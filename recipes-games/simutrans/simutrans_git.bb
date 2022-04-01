SUMMARY = "Simutrans is a freeware and open-source transportation simulator."
HOMEPAGE = "https://www.simutrans.com" 

LICENSE = "Artistic-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=10a3c09093deda8cbe4095ab2b158072" 

DEPENDS = "libsdl2 libsdl2-mixer zlib bzip2 libpng freetype fluidsynth"
RDEPENDS:${PN} = "bash simutrans-pak128"

inherit cmake pkgconfig gtk-icon-cache

SRC_URI = " \
    git://github.com/aburch/simutrans.git;protocol=https;branch=master \
"

PV = "r10594"
SRCREV = "121276359065f4a2939b4524dfec150e5bdac5a4"
S = "${WORKDIR}/git"

EXTRA_OECMAKE = "-DSIMUTRANS_USE_REVISION=1"

