SUMMARY = "eOVPN is an application to connect, manage and update(from remote .zip) OpenVPN configurations."
HOMEPAGE = "github.com/jkotra/eOVPN"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ee9b9fa5b9a99776492e169f131967dd"

REQUIRED_DISTRO_FEATURES = "gobject-introspection-data"

DEPENDS = " \
	glib-2.0 \
	gtk+3 \
	python3 \
"

RDEPENDS:${PN} = " \
	mako \
	openvpn \
	python3 \
	python3-psutil \
	python3-pygobject \
	python3-requests \
"

GIR_MESON_OPTION = ""

inherit meson gtk-icon-cache mime-xdg pkgconfig features_check gobject-introspection

SRC_URI = " \
    git://github.com/jkotra/eOVPN.git;protocol=https;branch=master \
    file://0001-meson.build-fix.patch \
"

S = "${WORKDIR}/git"
PV = "0.41"
SRCREV = "88b59488d009ec98756779263ceb6202c5d42ac3"

EXTRA_OEMESON += " \
    --buildtype release \
"

PACKAGECONFIG[nm] = "-Dnm=true,-Dnm=false,networkmanager"

PACKAGECONFIG ?= ""

FILES:${PN} += "${datadir} ${libdir}"

