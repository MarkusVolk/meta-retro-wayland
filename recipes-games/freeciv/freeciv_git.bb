SUMMARY = "Turn-based strategy game inspired by the history of human civilization."
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
SECTION = "games"

DEPENDS = " \
	bzip2 \
	curl \
	icu \
	libsdl2 \
	libsdl2-mixer \
	readline \
	sqlite3 \
	xz \
"

SRC_URI = " \
	git://github.com/freeciv/freeciv.git;protocol=https;branch=master \
	file://0001-meson.build-remove-get_cross_property.patch \
	file://0002-meson.build-hack-tolua-dependency.patch \
	file://0003-meson.build-install-missing-files.patch \
	file://0001-tilespec-fix-dependent-filenames.patch \
	file://freeciv.desktop \
"

S = "${WORKDIR}/git"
PV = "3.0.0-beta3"
SRCREV = "053a5e3b7752709ee83c1d9199f1f5687af1e74e"

inherit meson pkgconfig gettext gtk-icon-cache

# choose one of: sdl2, gtk3.22, qt
FREECIV_CLIENT ??= "gtk3.22"

PACKAGECONFIG[freeciv-web] = "-Dfreeciv-web=true,-Dfreeciv-web=false"
PACKAGECONFIG[gtk3.22] = "-Dclients=gtk3.22 -Dfcmp=gtk3,,gtk+3 atk pango gdk-pixbuf glib-2.0"
PACKAGECONFIG[json] = "-Djson-protocol=true,-Djson-protocol=false,jansson"
PACKAGECONFIG[qt] = "-Dclients=qt -Druledit=true -Dfcmp=qt,-Druledit=false,qtbase qttools-native"
PACKAGECONFIG[sdl2] = "-Dclients=sdl2 -Dfcmp=cli,,libsdl2-image libsdl2-ttf libsdl2-gfx freetype"
PACKAGECONFIG[syslua] = "-Dsyslua=true,-Dsyslua=false,lua"

PACKAGECONFIG ?= " \
	${FREECIV_CLIENT} \
"

do_install:append() {
	install -d ${D}${datadir}/applications
	install -m 644 ${WORKDIR}/freeciv.desktop ${D}${datadir}/applications
	ln -sf ${bindir}/freeciv-${FREECIV_CLIENT} ${D}${bindir}/freeciv
}

FILES:${PN} = " \
	${sysconfdir} \
	${bindir} \
	${libdir} \
	${datadir}/freeciv \
	${datadir}/icons \
	${datadir}/applications \
"

FILES:${PN}-dev = ""

EXTRA_OEMESON = "-Dack_experimental=true"

