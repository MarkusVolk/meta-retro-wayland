SUMMARY = "GNOME Chess is a 2D chess game, where games can be played between a combination of human and computer players."
HOMEPAGE = "https://wiki.gnome.org/Apps/Chess"
LICENSE = "GPL-3.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

REQUIRED_DISTRO_FEATURES = "gobject-introspection-data"

DEPENDS = " \
	gtk+3 \
	glib-2.0 \
	librsvg \
"

RRECOMMENDS:${PN}  = "gnuchess"

SRC_URI = " \
	git://github.com/GNOME/gnome-chess.git;protocol=https;branch=gnome-3-38 \
"

inherit meson pkgconfig gobject-introspection gtk-icon-cache vala features_check mime-xdg gsettings

UNKNOWN_CONFIGURE_WHITELIST:append = " introspection"

S = "${WORKDIR}/git"
PV = "3.38.1"
SRCREV = "${PV}"

FILES:${PN} += "${datadir}"

BBCLASSEXTEND = ""
