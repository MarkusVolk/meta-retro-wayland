SUMMARY = "The classic, refined DOOM source port"
HOMEPAGE = "https://www.doomretro.com" 

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=435fa6b85536eff97b3594b76fd0048f" 

DEPENDS = "libsdl2 libsdl2-image libsdl2-mixer"

RRECOMMENDS_${PN} = "doom-wad"

inherit cmake

SRC_URI = " \
    git://github.com/bradharding/doomretro.git;protocol=https \
"

PV = "4.0.9"
SRCREV = "v${PV}"
S = "${WORKDIR}/git"
