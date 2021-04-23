SUMMARY = "A Wayland WM"
HOMEPAGE = "https://github.com/swaywm/sway"
BUGTRACKER = "https://github.com/swaywm/sway/issues"
SECTION = "graphics"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=dfc67e5b1fa10ebb4b70eb0c0ca67bea"

REQUIRED_DISTRO_FEATURES = "wayland systemd"

DEPENDS += "wlroots \
            pcre \
            json-c \
            pango \
            cairo \
            gdk-pixbuf \
            git \
            wayland \
            wayland-native \
            wayland-protocols \
           "

RRECOMMENDS_${PN} += " \
	grim \
	slurp \
	wf-recorder \
	dmenu-wayland \
	waybar \
	swaybg \
"

SRC_URI = " \
	https://github.com/swaywm/sway/releases/download/${PV}/sway-${PV}.tar.gz \
"

SRC_URI[sha256sum] = "9ecfd2f38239f7e90922a13cd348fc95fc059e8fa0e4b75b8ffcc7b61685a5fb"

S = "${WORKDIR}/${PN}-${PV}"

inherit meson pkgconfig features_check

EXTRA_OEMESON += "--buildtype release"

FILES_${PN}_append = " \
	${datadir} \
"

BBCLASSEXTEND = ""

