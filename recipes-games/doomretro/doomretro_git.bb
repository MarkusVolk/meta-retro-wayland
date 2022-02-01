SUMMARY = "The classic, refined DOOM source port"
HOMEPAGE = "https://www.doomretro.com" 

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b79a3a253030f1021bea5fd6c54d5241" 

DEPENDS = "libsdl2 libsdl2-image libsdl2-mixer"

RRECOMMENDS:${PN} = "doom-wad"

inherit cmake pkgconfig

SRC_URI = " \
    git://github.com/bradharding/doomretro.git;protocol=https;branch=master \
"

PV = "4.4.3"
SRCREV = "fde8043061f41b62ef92a69a04dc4a7a9e26f227"
S = "${WORKDIR}/git"

