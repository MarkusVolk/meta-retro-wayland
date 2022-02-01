SUMMARY = "the rainbow ... i tastes it."
HOMEPAGE = "https://github.com/busyloop/lolcat"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0041f56ad1b9f50d1a73ce5e312909f0"

SRC_URI = "git://github.com/busyloop/lolcat.git;protocol=https"

RDEPENDS:${PN} = "paint optimist manpages"

inherit ruby

S = "${WORKDIR}/git"
PV = "100.0.1"
SRCREV = "f4cca5601ea57df2b5b3c98feea8ad05f4421039"

FILES:${PN} += "${libdir}"

BBCLASSEXTEND = ""

