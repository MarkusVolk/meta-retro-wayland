SUMMARY = "Wayland bar for Wlroots based compositors"
DESCRIPTION = "Highly customizable Wayland bar for Sway and Wlroots based compositors."
AUTHOR = ""
HOMEPAGE = "https://github.com/Alexays/Waybar"
BUGTRACKER = "https://github.com/Alexays/Waybar/issues"
SECTION = "graphics"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=98f7e9dc79966298d76caf1b0a6d35c1"

REQUIRED_DISTRO_FEATURES = "wayland"

DEPENDS += " \
	glib-2.0-native \
	gtkmm3 \
	gtk-layer-shell \
	jsoncpp \
	libsigc++-3 \
	fmt \
	spdlog \
	gtk+3 \
	gobject-introspection \
	pulseaudio \
	bluez5 \
	libnl \
	wayland \
	wayland-native \
	wayland-protocols \
"

RRECOMMENDS_${PN} += " \
	font-awesome-otf \
"

SRC_URI = "git://github.com/Alexays/Waybar.git;protocol=https"
SRCREV = "c21dc681c95361bcdbc1b4b998d2b2b9370f337c"

S = "${WORKDIR}/git"

inherit meson pkgconfig features_check

do_install_append() {
	rm -rf ${D}${sysconfdir}/xdg/waybar/config
}

PACKAGES += "${PN}-systemd"

FILES_${PN}-systemd += "${libdir}/systemd"

BBCLASSEXTEND = ""
