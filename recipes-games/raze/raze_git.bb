SUMMARY = "Raze is a fork of Build engine games backed by GZDoom tech"
HOMEPAGE = "https://github.com/coelckers/Raze"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://package/common/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

HAVE_GTK = "${@bb.utils.contains('DISTRO_FEATURES', 'gtk3', 'gtk+3', '', d)}"

DEPENDS = " \
	${HAVE_GTK} \
	bzip2-native \
	gdtoa-native \
	fluidsynth \
	glew \
	jpeg \
	lemon-native \
	libglu \
	libsdl2 \
	libsndfile1 \
	libvpx \
	mpg123 \
	openal-soft \
	re2c-native \
	virtual/libgl \
	virtual/libgles2 \
	zipdir-native \
	zlib-native \
	zmusic \
"

DEPENDS:x86_64 += "nasm"

RDEPENDS:${PN} = "openal-soft"
RRECOMMENDS:${PN} = "universal-raze-package"

inherit cmake pkgconfig gtk-icon-cache

SRC_URI = " \
    git://github.com/coelckers/Raze.git;protocol=https;nobranch=1 \
    file://0001-CMakeLists.txt-compile-fix.patch \
    file://raze.svg \
    file://raze.desktop \
"

PV = "1.5.0"
SRCREV = "bfafe4e21c47350c5bc52d8170fdecee1a5bfcdf"
S = "${WORKDIR}/git"

EXTRA_OECMAKE = "-DCLANG_FORMAT_CMD=OFF"

do_install:append() {
	install -d ${D}${datadir}/applications ${D}${datadir}/icons/hicolor/scalable/apps
	install -m 644 ${WORKDIR}/raze.desktop ${D}${datadir}/applications
	install -m 644 ${WORKDIR}/raze.svg ${D}${datadir}/icons/hicolor/scalable/apps
}

FILES:${PN} += "${datadir}"
