SUMMARY = "OpenSpades is a compatible client of Ace of Spades 0.75."
HOMEPAGE = "https://github.com/yvt/openspades" 
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a1ef5c23fc6adb7c64151b1b0f322cfa" 

DEPENDS = "libopus opusfile freetype glew libglu libsdl2 libsdl2-image curl libogg zip-native zlib"

inherit cmake pkgconfig gtk-icon-cache mime-xdg

SRC_URI = " \
    git://github.com/yvt/openspades.git;protocol=https;branch=master \
"

PV = "0.1.5"
SRCREV = "e6d1856b3d8c937392883d2fb43c43175df4610b"
S = "${WORKDIR}/git"

do_install:append() {
	mv ${D}${prefix}/games ${D}${bindir}
}

FILES:${PN} = "${datadir} ${bindir}"

do_compile[network] = "1"

