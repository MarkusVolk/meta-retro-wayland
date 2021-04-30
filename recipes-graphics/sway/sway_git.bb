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
	git://github.com/swaywm/sway.git;protocol=https \
"

SRCREV = "7c74f01f0ae9d5b3f92d3e6fc64cb9abe95b4c52"
PV = "1.6+${SRCREV}"

S = "${WORKDIR}/git"

inherit meson pkgconfig features_check

EXTRA_OEMESON += "--buildtype release"

FILES_${PN}_append = " \
	${datadir} \
"

BBCLASSEXTEND = ""

