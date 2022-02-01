
SUMMARY = "A multi-platform software synthesiser"
HOMEPAGE = "https://github.com/munt/munt.git"

LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://mt32emu/COPYING.LESSER.txt;md5=243b725d71bb5df4a1e5920b344b86ad"

DEPENDS = "glib-2.0"

inherit cmake

SRC_URI = "git://github.com/munt/munt.git;protocol=https;branch=master"
SRCREV = "d94d064021993f83a80df45348defc2614312847"
PV = "2.5.3"
S = "${WORKDIR}/git"

EXTRA_OECMAKE = " \
    -Dlibmt32emu_SHARED=ON \
    -Dmunt_WITH_MT32EMU_QT=OFF \
"

