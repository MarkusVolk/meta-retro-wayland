SUMMARY = "'The Reckoning' for Yamagi Quake II."
HOMEPAGE = "https://www.yamagi.org/quake2/" 

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fc18eae0b6e132ba97715116a31e0264" 

RDEPENDS:${PN} = "yquake2"
RRECOMMENDS:${PN} = "xatrix-pak"

inherit cmake

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release"

SRC_URI = " \
    git://github.com/yquake2/xatrix.git;protocol=https;branch=master \
"

PV = "2.09"
SRCREV = "dfd2224bbf0582b37d97a745aa2fe0d71f1766c8"
S = "${WORKDIR}/git"

do_install() {
	# install routine is missing ... do it manually
	install -d ${D}${datadir}/games/quake2/xatrix
	install -m 644 ${B}/Release/game.so ${D}${datadir}/games/quake2/xatrix
}

FILES:${PN} = "${datadir}"

