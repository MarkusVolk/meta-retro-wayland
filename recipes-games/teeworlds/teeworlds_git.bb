SUMMARY = "A retro multiplayer shooter."
HOMEPAGE = "https://teeworlds.com/"
LICENSE = "CC-BY-SA-3.0"
LIC_FILES_CHKSUM = "file://license.txt;md5=141d0726e11e19730f9caef382025353"

DEPENDS = " \
	googletest \
	libsdl2 \
	freetype \
	wavpack \
	zlib \
	openssl \
"

SRC_URI = " \
	gitsm://github.com/teeworlds/teeworlds.git;protocol=https;nobranch=1 \
	file://teeworlds.png \
	file://teeworlds.desktop \
"

PV = "0.7.5"
SRCREV = "4fc25a17fef3e6c2bf4d52b0421e0d69ecaa1e79"
S = "${WORKDIR}/git"

inherit cmake pkgconfig python3native gtk-icon-cache

EXTRA_OECMAKE = " \
	-DFREETYPE_INCLUDEDIR=${STAGING_INCDIR}/freetype2 \
	-DWAVPACK_INCLUDEDIR=${STAGING_INCDIR}/wavpack \
"

do_install:append() {
	install -d ${D}${datadir}/icons/hicolor/128x128/apps ${D}${datadir}/applications
	install -m 644 ${WORKDIR}/teeworlds.desktop ${D}${datadir}/applications
	install -m 644 ${WORKDIR}/teeworlds.png ${D}${datadir}/icons/hicolor/128x128/apps
}

