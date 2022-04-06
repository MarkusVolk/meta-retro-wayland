SUMMARY = "The classic, refined DOOM source port"
HOMEPAGE = "https://www.doomretro.com" 

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b79a3a253030f1021bea5fd6c54d5241" 

DEPENDS = "libsdl2 libsdl2-image libsdl2-mixer"

RRECOMMENDS:${PN} = "doom-wad"

inherit cmake pkgconfig

SRC_URI = " \
    git://github.com/bradharding/doomretro.git;protocol=https;branch=master \
    file://doomretro.desktop \
    file://doomretro.png \
"

PV = "4.4.10"
SRCREV = "5ac71af47d062d9ec9fd6b485d2a062aac015841"
S = "${WORKDIR}/git"

do_install:append() {
	install -d ${D}${datadir}/applications ${D}${datadir}/icons/hicolor/128x128/apps
	install -m 644 ${WORKDIR}/doomretro.desktop ${D}${datadir}/applications
	install -m 644 ${WORKDIR}/doomretro.png ${D}${datadir}/icons/hicolor/128x128/apps
}

FILES:${PN} += "${datadir}"
