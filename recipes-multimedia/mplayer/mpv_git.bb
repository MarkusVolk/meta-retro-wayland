SUMMARY = "Open Source multimedia player"
DESCRIPTION = "mpv is a fork of mplayer2 and MPlayer. It shares some features with the former projects while introducing many more."
SECTION = "multimedia"
HOMEPAGE = "http://www.mpv.io/"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.GPL;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "zlib ffmpeg jpeg libv4l libass uchardet"

PV = "0.35.0"
SRCREV_mpv = "75d938912ddd50f5658d874c59e1b50e13b28bf1"
SRC_URI = " \
    git://github.com/mpv-player/mpv;name=mpv;nobranch=1;protocol=https \
    https://waf.io/waf-2.0.23;name=waf;subdir=git \
"
SRC_URI[waf.sha256sum] = "28a2e4583314a162cfcbffefb8a9202c1d7869040d30b5852da479b76d9c0491"

S = "${WORKDIR}/git"

inherit waf pkgconfig mime-xdg

LDFLAGS:append:riscv64 = " -latomic"

EXTRA_OECONF = " \
    --prefix=${prefix} \
    --target=${SIMPLE_TARGET_SYS} \
    --confdir=${sysconfdir}/mpv \
    --datadir=${datadir} \
    --disable-manpage-build \
    --disable-libbluray \
    --disable-dvdnav \
    --disable-cdda \
    --disable-rubberband \
    --disable-vapoursynth \
    ${PACKAGECONFIG_CONFARGS} \
"

# Note: lua is required to get on-screen-display (controls)
PACKAGECONFIG ??= " \
	lua \
	libarchive \
	drm \
	openal \
	shared \
	zimg \
	${@bb.utils.filter('DISTRO_FEATURES', 'alsa pulseaudio vaapi vulkan wayland x11 pipewire', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'opengl egl gbm', '', d)} \
"

PACKAGECONFIG[alsa] = ",--disable-alsa,alsa-lib"
PACKAGECONFIG[drm] = "--enable-drm,--disable-drm,libdrm"
PACKAGECONFIG[egl] = "--enable-egl,--disable-egl,virtual/egl virtual/libgles2"
PACKAGECONFIG[gbm] = "--enable-gbm,--disable-gbm,virtual/libgbm"
PACKAGECONFIG[jack] = "--enable-jack, --disable-jack,jack"
PACKAGECONFIG[lcms] = "--enable-lcms2,--disable-lcms2,lcms"
PACKAGECONFIG[libarchive] = "--enable-libarchive,--disable-libarchive,libarchive"
PACKAGECONFIG[lua] = "--enable-lua,--disable-lua,luajit"
PACKAGECONFIG[openal] = "--enable-openal,--disable-openal,openal-soft"
PACKAGECONFIG[opengl] = "--enable-gl,--disable-gl,virtual/libgl"
PACKAGECONFIG[pipewire] = "--enable-pipewire,--disable-pipewire,pipewire"
PACKAGECONFIG[pulseaudio] = "--enable-pulse,--disable-pulse,pulseaudio"
PACKAGECONFIG[sdl2] = "--enable-sdl2,--disable-sdl2,libsdl2"
PACKAGECONFIG[shared] = "--enable-libmpv-shared,--enable-libmpv-static"
PACKAGECONFIG[vaapi] = "--enable-vaapi,--disable-vaapi,libva"
PACKAGECONFIG[vdpau] = "--enable-vdpau,--disable-vdpau,libvdpau"
PACKAGECONFIG[vulkan] = ",,vulkan-loader vulkan-headers spirv-shader-generator libplacebo"
PACKAGECONFIG[wayland] = "--enable-wayland,--disable-wayland,wayland wayland-native wayland-protocols libxkbcommon"
PACKAGECONFIG[x11] = "--enable-x11,--disable-x11,virtual/libx11 xext libxpresent libxscrnsaver libxinerama xrandr"
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

FILES:${PN} += "${datadir}"

RRECOMMENDS:${PN} += "mpv-mpris"

link_waf() {
    ln -s waf-2.0.23 ${S}/waf
}

do_unpack[postfuncs] += "link_waf"

FILES:${PN} += " \
    ${datadir}/icons \
    ${datadir}/zsh \
    ${datadir}/bash-completion \
    "
EXCLUDE_FROM_WORLD = "${@bb.utils.contains("LICENSE_FLAGS_ACCEPTED", "commercial", "0", "1", d)}"

