DESCRIPTION = "pigpio is a C library for the Raspberry which allows control of the General Purpose Input Outputs (GPIO)."
HOMEPAGE = "https://github.com/joan2937/pigpio"
LICENSE = "Unlicense"
LIC_FILES_CHKSUM = "file://UNLICENCE;md5=61287f92700ec1bdf13bc86d8228cd13"

inherit setuptools3

SRC_URI = " \
  git://github.com/joan2937/pigpio.git;protocol=https;branch=master \
"
SRCREV = "c33738a320a3e28824af7807edafda440952c05d"
PV = "79"
S = "${WORKDIR}/git"


