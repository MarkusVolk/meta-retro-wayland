SUMMARY = "The "z" library implements the commonly required image processing basics of scaling, colorspace conversion, and depth conversion"
HOMEPAGE = "github.com/sekrit-twc/zimg" 

LICENSE = "WTFPL"
LIC_FILES_CHKSUM = "file://COPYING;md5=389a9e29629d1f05e115f8f05c283df5"

inherit autotools pkgconfig

SRC_URI = " \
    git://github.com/sekrit-twc/zimg.git;protocol=https;branch=v3.0 \
"

PV = "3.0.4"
SRCREV = "dd4c4dff3ce6a2877bd6ba57c1be99759b9cb2da"
S = "${WORKDIR}/git"

