SUMMARY = "This plugin will add man pages support to ruby gems."
HOMEPAGE = "https://github.com/bitboxer/manpages"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=95c5eae9cdb44bf7c0e5e8d9ed735295"

SRC_URI = "git://github.com/bitboxer/manpages.git;protocol=https;branch=master"

RDEPENDS:${PN} = "bash"

inherit ruby

S = "${WORKDIR}/git"
PV = "0.6.1"
SRCREV = "${PV}"

FILES:${PN} += "${libdir}"

BBCLASSEXTEND = ""

