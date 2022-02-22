SUMMARY = "The Battle for Wesnoth is an Open Source, turn-based tactical strategy game."
HOMEPAGE = "https://www.wesnoth.org/" 

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=eb723b61539feef013de476e68b5c50a" 

DEPENDS = " \
	libsdl2 \
	libsdl2-image \
	libsdl2-mixer \
	fontconfig \
	pango \
	cairo \
	openssl \
	zlib \
	bzip2 \
	libvorbis \
	boost \
"

RDEPENDS:${PN} = "bash"

inherit cmake pkgconfig

SRC_URI = " \
    git://github.com/wesnoth/wesnoth.git;protocol=https;nobranch=1 \
    file://0001-CMakeLIST.txt-dont-install-run-e.patch \
"

PV = "1.17.1"
SRCREV = "437bf5a9eccc7b58596a4dde1e6c84815c79c453"
S = "${WORKDIR}/git"

# Workaround sdl2 wayland issue if starting in fullscreen mode 
do_install:append() {
	sed -i "s|Exec=sh -c \"wesnoth|Exec=sh -c \"wesnoth -w|" ${D}${datadir}/applications/org.wesnoth.Wesnoth.desktop
}

FILES:${PN} += " \
	${sysconfdir} \
	${datadir} \
"

