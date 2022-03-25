SUMMARY = "yet another implementation of the Unix-style fortune program."
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=457477bba1a7ea611aa1002543d71889"

SRC_URI = " \
	git://github.com/bmc/fortune.git;protocol=https;branch=master \
"

RDEPENDS:${PN} = " \
	python3 \
	fortunes \
"

inherit setuptools3

S = "${WORKDIR}/git"
PV = "1.0"
SRCREV = "aed007c3d39d994d12cf74c89c68ab439d8405a1"

