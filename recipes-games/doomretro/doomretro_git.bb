SUMMARY = "The classic, refined DOOM source port"
HOMEPAGE = "https://www.doomretro.com" 

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b79a3a253030f1021bea5fd6c54d5241" 

DEPENDS = "libsdl2 libsdl2-image libsdl2-mixer"

RRECOMMENDS:${PN} = "doomretro-doom-wad"

inherit cmake pkgconfig

SRC_URI = " \
    git://github.com/bradharding/doomretro.git;protocol=https;branch=master \
    file://doomretro.desktop \
    file://doomretro.png \
"

PV = "4.6.2"
SRCREV = "5a7dcfa075d0cfb726ebdf756d57d02201805d36"
S = "${WORKDIR}/git"

do_install:append() {
	install -d ${D}${datadir}/applications ${D}${datadir}/icons/hicolor/128x128/apps
	install -m 644 ${WORKDIR}/doomretro.desktop ${D}${datadir}/applications
	install -m 644 ${WORKDIR}/doomretro.png ${D}${datadir}/icons/hicolor/128x128/apps
}

FILES:${PN} += "${datadir}"
