SUMMARY = "GNOME Chess is a 2D chess game, where games can be played between a combination of human and computer players."
HOMEPAGE = "https://wiki.gnome.org/Apps/Chess"
LICENSE = "GPL-3.0-only"

LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

REQUIRED_DISTRO_FEATURES = "gobject-introspection-data"

DEPENDS = " \
	gtk+3 \
	glib-2.0 \
	librsvg \
"

RRECOMMENDS:${PN}  = "gnuchess"

SRC_URI = " \
	git://github.com/GNOME/gnome-chess.git;protocol=https;nobranch=1 \
"

inherit meson pkgconfig gobject-introspection gtk-icon-cache vala features_check mime-xdg gsettings

GIR_MESON_OPTION = ""

S = "${WORKDIR}/git"
PV = "3.38.1"
SRCREV = "433ffc18de77c6db9236d0e6d815e67ced98489a"

FILES:${PN} += "${datadir}"

BBCLASSEXTEND = ""
