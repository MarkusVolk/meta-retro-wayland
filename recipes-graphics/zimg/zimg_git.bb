SUMMARY = "The "z" library implements the commonly required image processing basics of scaling, colorspace conversion, and depth conversion"
HOMEPAGE = "github.com/sekrit-twc/zimg" 

LICENSE = "WTFPL"
LIC_FILES_CHKSUM = "file://COPYING;md5=389a9e29629d1f05e115f8f05c283df5"

inherit autotools pkgconfig

SRC_URI = " \
    git://github.com/sekrit-twc/zimg.git;protocol=https \
"

PV = "3.0.1"
SRCREV = "release-${PV}"
S = "${WORKDIR}/git"

