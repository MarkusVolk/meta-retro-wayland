SUMMARY = "A game inspired by Snake, in pure C with SDL2."
HOMEPAGE = "https://github.com/rapiz1/DungeonRush"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

DEPENDS = " \
	libsdl2 \
	libsdl2-net \
	libsdl2-ttf \
	libsdl2-mixer \
	libsdl2-image \
"

SRC_URI = " \
    git://github.com/rapiz1/DungeonRush.git;protocol=https;branch=master \
    file://dungeon_rush \
"

PV = "1.1"
SRCREV = "ff44828b2bd89e0edb831673aca64ef4377c0c32"
S = "${WORKDIR}/git"

inherit cmake pkgconfig gtk-icon-cache


do_install() {
	install -d ${D}${bindir} ${D}${datadir}/icons/hicolor/256x256/apps ${D}${datadir}/applications ${D}${datadir}/games/dungeonrush
	cp -rf ${B}/bin/* ${D}${datadir}/games/dungeonrush
	install -m 755 ${WORKDIR}/dungeon_rush ${D}${bindir}
	install -m 644 ${S}/dungeonrush.desktop ${D}${datadir}/applications
	install -m 644 ${S}/dungeonrush.png ${D}${datadir}/icons/hicolor/256x256/apps
}

FILES:${PN} = "${bindir} ${datadir}"
