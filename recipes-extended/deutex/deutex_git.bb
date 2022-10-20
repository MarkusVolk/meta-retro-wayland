SUMMARY = "DeuTex - WAD composer for Doom, Heretic, Hexen, and Strife"
HOMEPAGE = "https://github.com/Doom-Utils/deutex"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "asciidoc-native libpng"

inherit autotools pkgconfig

SRC_URI = " \
    git://github.com/Doom-Utils/deutex.git;protocol=https;branch=master \
"

PV = "5.2.2"
SRCREV = "ef1c06a62cc0eff82ecea984f58fbbe41d8a593d"
S = "${WORKDIR}/git"

BBCLASSEXTEND = "native"
