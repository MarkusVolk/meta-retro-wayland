SUMMARY = "Free Libre Action Roleplaying Engine."
HOMEPAGE = "https://github.com/flareteam" 
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504" 

DEPENDS = "libsdl2 libsdl2-mixer libsdl2-image libsdl2-ttf"

inherit cmake

SRC_URI = " \
    git://github.com/flareteam/flare-engine.git;protocol=https;branch=master \
"

PV = "1.13.04"
SRCREV = "39f02c8e00b8c25afc3a5e112cf1ceafd439b383"
S = "${WORKDIR}/git"

FILES:${PN} = "${datadir} ${prefix}/games"

