SUMMARY = "GNU Chess is a chess-playing program."
HOMEPAGE = "http://www.gnu.org/software/chess/"
LICENSE = "GPL-3.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = " \
	git://git.savannah.gnu.org/git/chess.git;protocol=https;branch=master \
"

inherit autotools

do_configure:prepend() {
	touch ${S}/ABOUT-NLS
	touch ${S}/man/gnuchess.1
}

EXTRA_OECONF = "--disable-nls"

S = "${WORKDIR}/git"
PV = "6.2.9"
SRCREV = "v${PV}"

FILES:${PN} += "${datadir}"

BBCLASSEXTEND = ""
