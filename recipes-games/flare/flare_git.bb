SUMMARY = "Free Libre Action Roleplaying Engine."
HOMEPAGE = "https://github.com/flareteam" 
LICENSE = "CC-BY-3.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=13a870bd7f606a919042749a5f098ac2" 

SRC_URI = " \
    git://github.com/flareteam/flare-game.git;protocol=https;branch=master \
"

RDEPENDS:${PN} = "flare-engine"

PV = "1.13.04"
SRCREV = "97b74b9c4096e784323604746d7f211bc173e884"
S = "${WORKDIR}/git"

inherit cmake

FILES:${PN} = "${datadir}"

