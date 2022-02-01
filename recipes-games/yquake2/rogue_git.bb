SUMMARY = "'Ground Zero' for Yamagi Quake II."
HOMEPAGE = "https://www.yamagi.org/quake2/" 

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8ae2f31ea8b86131f13bfc9fab7095c7" 

RDEPENDS:${PN} = "yquake2"
RRECOMMENDS:${PN} = "rogue-pak"

inherit cmake

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release"

SRC_URI = " \
    git://github.com/yquake2/rogue.git;protocol=https;branch=master \
"

PV = "2.08"
SRCREV = "ee6164cbce244e9b9d45aefe3a23bd127dc93ca3"
S = "${WORKDIR}/git"

do_install() {
	# install routine is missing ... do it manually
	install -d ${D}${datadir}/games/quake2/rogue
	install -m 644 ${B}/Release/game.so ${D}${datadir}/games/quake2/rogue
}

FILES:${PN} = "${datadir}"

