SUMMARY = "Simutrans is a freeware and open-source transportation simulator."
HOMEPAGE = "https://www.simutrans.com" 

LICENSE = "Artistic-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=10a3c09093deda8cbe4095ab2b158072" 

DEPENDS = "libsdl2 libsdl2-mixer zlib bzip2 libpng freetype fluidsynth"
RDEPENDS:${PN} = "bash simutrans-pak128"

inherit cmake pkgconfig gtk-icon-cache

SRC_URI = " \
    git://github.com/simutrans/simutrans.git;protocol=https;nobranch=1 \
"

SRCREV = "a84b878870a4fe9bcdb649aaaf9b5eeefa9c96e6"
S = "${WORKDIR}/git"

EXTRA_OECMAKE = "-DSIMUTRANS_USE_REVISION=1"

