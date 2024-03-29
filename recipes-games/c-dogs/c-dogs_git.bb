SUMMARY = "C-Dogs SDL is a classic overhead run-and-gun game, supporting up to 4 players in co-op and deathmatch modes."
HOMEPAGE = "https://github.com/cxong/cdogs-sdl"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=a23a74b3f4caf9616230789d94217acb"

DEPENDS = " \
	gtk+3 \
	libsdl2 \
	libsdl2-mixer \
	libsdl2-image \
	protobuf-native \
	python3-protobuf \
"

SRC_URI = " \
    git://github.com/cxong/cdogs-sdl.git;protocol=https;branch=master \
    file://fix-datadir.patch \
"

PV = "1.3.1"
SRCREV = "af83c8f6fcb599b175ded12f95776b7956e6b969"
S = "${WORKDIR}/git"

inherit cmake pkgconfig gtk-icon-cache

EXTRA_OECMAKE = "-DCDOGS_DATA_DIR=${datadir}/games/c-dogs/"

FILES:${PN} += "${datadir}"
CFLAGS:append = " -Wno-stringop-overflow"
