SUMMARY = "Cowsay is a configurable talking cow, written in Perl."
HOMEPAGE = "https://github.com/piuccio/cowsay"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = " \
	git://github.com/cowsay-org/cowsay.git;protocol=https;branch=master \
	file://0001-Makefile-adjust-PATH.patch \	
"

DEPENDS = "perl-native perl"

S = "${WORKDIR}/git"
PV = "3.7.0"
SRCREV = "v${PV}"

inherit autotools-brokensep

FILES:${PN} += "${datadir}"

