SUMMARY = "The Battle for Wesnoth is an Open Source, turn-based tactical strategy game."
HOMEPAGE = "https://www.wesnoth.org/" 

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=eb723b61539feef013de476e68b5c50a" 

DEPENDS = " \
	boost \
	bzip2 \
	cairo \
	fontconfig \
	libpng \
	libsdl2 \
	libsdl2-image \
	libsdl2-mixer \
	libsdl2-net \
	libsdl2-ttf \
	libvorbis \
	openssl \
	pango \
	zlib \
"

EXTRA_OECMAKE += "-DENABLE_SERVER=0 -DENABLE_DISPLAY_REVISION=0"

RDEPENDS:${PN} = "bash"

inherit cmake pkgconfig gettext

SRC_URI = " \
    gitsm://github.com/wesnoth/wesnoth.git;protocol=https;branch=master \
    file://0002-Do-not-adjust-compiler-flags.patch \
"

PV = "1.17.11"
SRCREV = "ba8227e99491859082170a52ffb67baa7a736f01"
S = "${WORKDIR}/git"

# Workaround sdl2 wayland issue if starting in fullscreen mode 
do_install:append() {
	sed -i "s|Exec=sh -c \"wesnoth|Exec=sh -c \"wesnoth -w|" ${D}${datadir}/applications/org.wesnoth.Wesnoth.desktop
}

FILES:${PN} += " \
	${sysconfdir} \
	${datadir} \
"

