SUMMARY = "GZDoom is a modder-friendly OpenGL and Vulkan source port based on the DOOM engine"
HOMEPAGE = "https://zdoom.org/index"

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

HAVE_GTK = "${@bb.utils.contains('DISTRO_FEATURES', 'gtk3', 'gtk+3', '', d)}"

DEPENDS = " \
	${HAVE_GTK} \
	bzip2-native \
	gdtoa-native \
	jpeg \
	lemon-native \
	libsdl2 \
	libvpx \
	virtual/libgl \
	virtual/libgles2 \
	zipdir-native \
	zlib-native \
	zmusic \
"

RRECOMMENDS:${PN} = " \
	doom1-wad doom2-wad finaldoom-evilution-wad finaldoom-plutonia-wad freedoom-wad \
	hacx-wad hexen-wad heretic-wad strife-wad adventures-of-square-wad \
"

inherit cmake pkgconfig gtk-icon-cache

SRC_URI = " \
    git://github.com/ZDoom/gzdoom.git;protocol=https;nobranch=1 \
    file://0001-CMakeLists.txt-compile-fix.patch \
    file://gzdoom.svg \
    file://gzdoom.desktop \
"

PV = "4.8.2"
SRCREV = "c2373fed99998790dc63ee1f706183e89d0f7929"
S = "${WORKDIR}/git"

EXTRA_OECMAKE = "-DCLANG_FORMAT_CMD=OFF"

do_install:append() {
	install -d ${D}${datadir}/applications ${D}${datadir}/icons/hicolor/scalable/apps
	install -m 644 ${WORKDIR}/gzdoom.desktop ${D}${datadir}/applications
	install -m 644 ${WORKDIR}/gzdoom.svg ${D}${datadir}/icons/hicolor/scalable/apps
}

FILES:${PN} += "${datadir}"
