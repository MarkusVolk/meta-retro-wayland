SUMMARY = "Optimist is a commandline option parser for Ruby."
HOMEPAGE = "https://github.com/ManageIQ/optimist"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=ebbd710405696f86bf1f3d171c0a33ac"

SRC_URI = "git://github.com/ManageIQ/optimist.git;protocol=https;branch=master"

inherit ruby

S = "${WORKDIR}/git"
PV = "3.0.1"
SRCREV = "v${PV}"

FILES:${PN} += "${libdir}"

BBCLASSEXTEND = ""

