SUMMARY = "The Battle for Wesnoth is an Open Source, turn-based tactical strategy game."
HOMEPAGE = "https://www.wesnoth.org/" 

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=eb723b61539feef013de476e68b5c50a" 

DEPENDS = " \
	libsdl2 \
	libsdl2-image \
	libsdl2-mixer \
	fontconfig \
	pango \
	cairo \
	openssl \
	zlib \
	bzip2 \
	libvorbis \
	boost \
"

RDEPENDS:${PN} = "bash"

inherit cmake pkgconfig

SRC_URI = " \
    git://github.com/wesnoth/wesnoth.git;protocol=https;branch=1.16 \
    file://0001-CMakeLIST.txt-dont-use-sdl-config-dont-install-run-e.patch \
"

PV = "1.15.16"
SRCREV = "${PV}"
S = "${WORKDIR}/git"

FILES:${PN} += " \
	${sysconfdir} \
	${datadir} \
"

