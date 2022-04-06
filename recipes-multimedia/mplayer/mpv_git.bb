SUMMARY = "Open Source multimedia player"
DESCRIPTION = "mpv is a fork of mplayer2 and MPlayer. It shares some features with the former projects while introducing many more."
SECTION = "multimedia"
HOMEPAGE = "http://www.mpv.io/"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.GPL;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "zlib ffmpeg jpeg libv4l libass"

PV = "0.34.1"
SRCREV_mpv = "712ef65e2a830e9db082d5d36563ff0d1df0097c"
SRC_URI = " \
    git://github.com/mpv-player/mpv;name=mpv;nobranch=1;protocol=https \
    https://waf.io/waf-2.0.22;name=waf;subdir=git \
"

SRC_URI[waf.sha256sum] = "0a09ad26a2cfc69fa26ab871cb558165b60374b5a653ff556a0c6aca63a00df1"
S = "${WORKDIR}/git"

inherit waf pkgconfig mime-xdg

LDFLAGS:append:riscv64 = " -latomic"

# Note: lua is required to get on-screen-display (controls)
PACKAGECONFIG ??= " \
	lua \
	${@bb.utils.filter('DISTRO_FEATURES', 'alsa pulseaudio vulkan wayland x11 vaapi vdpau', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'opengl egl gbm', '', d)} \
"

PACKAGECONFIG[alsa] = ",--disable-alsa,alsa-lib"
PACKAGECONFIG[drm] = "--enable-drm,--disable-drm,libdrm"
PACKAGECONFIG[egl] = "--enable-egl,--disable-egl,virtual/egl virtual/libgles2"
PACKAGECONFIG[gbm] = "--enable-gbm,--disable-gbm,virtual/libgbm"
PACKAGECONFIG[jack] = "--enable-jack, --disable-jack, jack"
PACKAGECONFIG[lcms] = "--enable-lcms2,--disable-lcms2,lcms"
PACKAGECONFIG[libarchive] = "--enable-libarchive,--disable-libarchive,libarchive"
PACKAGECONFIG[lua] = "--enable-lua,--disable-lua,luajit"
PACKAGECONFIG[openal] = "--enable-openal,--disable-openal,openal-soft"
PACKAGECONFIG[opengl] = "--enable-gl,--disable-gl,virtual/libgl"
PACKAGECONFIG[pulseaudio] = ",--disable-pulse,pulseaudio"
PACKAGECONFIG[sdl2] = "--enable-sdl2,--disable-sdl2,libsdl2"
PACKAGECONFIG[shared] = "--enable-libmpv-shared,--enable-libmpv-static"
PACKAGECONFIG[vaapi] = "--enable-vaapi,--disable-vaapi,libva"
PACKAGECONFIG[vdpau] = "--enable-vdpau,--disable-vdpau,libvdpau"
PACKAGECONFIG[vulkan] = ",,vulkan-loader vulkan-headers libplacebo"
PACKAGECONFIG[wayland] = "--enable-wayland,--disable-wayland,wayland wayland-native wayland-protocols libxkbcommon"
PACKAGECONFIG[x11] = "--enable-x11,--disable-x11,virtual/libx11 xsp libxv libxscrnsaver libxinerama"
PACKAGECONFIG[zimg] = ",,zimg"

python __anonymous() {
    packageconfig = (d.getVar("PACKAGECONFIG") or "").split()
    extras = []
    if "x11" in packageconfig and "opengl" in packageconfig:
        extras.append(" --enable-gl-x11")
    if "x11" in packageconfig and "egl" in packageconfig:
        extras.append(" --enable-egl-x11")
    if "egl" in packageconfig and "drm" in packageconfig:
        extras.append(" --enable-egl-drm")
    if "vaapi" in packageconfig and "x11" in packageconfig:
        extras.append(" --enable-vaapi-x11")
    if "vaapi" in packageconfig and "drm" in packageconfig:
        extras.append(" --enable-vaapi-drm")
    if "vaapi" in packageconfig and "x11" in packageconfig and "egl" in packageconfig:
        extras.append(" --enable-vaapi-x-egl")
    if "vdpau" in packageconfig and "opengl" in packageconfig and "x11" in packageconfig:
        extras.append(" --enable-vdpau-gl-x11")
    if "wayland" in packageconfig and "opengl" in packageconfig:
        extras.append(" --enable-gl-wayland")
    if "wayland" in packageconfig and "vaapi" in packageconfig:
        extras.append(" --enable-vaapi-wayland")
    if extras:
        d.appendVar("EXTRA_OECONF", "".join(extras))
}

SIMPLE_TARGET_SYS = "${@'${TARGET_SYS}'.replace('${TARGET_VENDOR}', '')}"

EXTRA_OECONF = " \
    --prefix=${prefix} \
    --target=${SIMPLE_TARGET_SYS} \
    --confdir=${sysconfdir} \
    --datadir=${datadir} \
    --disable-manpage-build \
    --disable-libbluray \
    --disable-dvdnav \
    --disable-cdda \
    --disable-uchardet \
    --disable-rubberband \
    --disable-vapoursynth \
    ${PACKAGECONFIG_CONFARGS} \
"

link_waf() {
    ln -s waf-2.0.22 ${S}/waf
}

do_unpack[postfuncs] += "link_waf"

FILES:${PN} += " \
    ${datadir}/icons \
    ${datadir}/zsh \
    ${datadir}/bash-completion \
    "
EXCLUDE_FROM_WORLD = "${@bb.utils.contains("LICENSE_FLAGS_ACCEPTED", "commercial", "0", "1", d)}"

