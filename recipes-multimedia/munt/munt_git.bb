
SUMMARY = "A multi-platform software synthesiser"
HOMEPAGE = "https://github.com/munt/munt.git"

LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://mt32emu/COPYING.LESSER.txt;md5=243b725d71bb5df4a1e5920b344b86ad"

DEPENDS = "glib-2.0"

inherit cmake

SRC_URI = "git://github.com/munt/munt.git;protocol=https;branch=master"
SRCREV = "08aba2f0018f4e7c2af855c268a97b8b84f8dc06"
PV = "2.7.0"
S = "${WORKDIR}/git"

EXTRA_OECMAKE = " \
    -Dlibmt32emu_SHARED=ON \
    -Dmunt_WITH_MT32EMU_QT=OFF \
"

