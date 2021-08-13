SUMMARY = "LGI is gobject-introspection based dynamic Lua binding to GObject based libraries."
HOMEPAGE = "https://https://github.com/pavouk/lgi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a77b7838f84aa753d37f88fd9c9ccf7d"

SRC_URI = "git://github.com/pavouk/lgi.git;protocol=https"

DEPENDS = " \
	virtual/lua \
	virtual/lua-native \
	cairo \
	gobject-introspection \
	gobject-introspection-native \
"

S = "${WORKDIR}/git"
PV = "0.9.2"
SRCREV = "a3d46f4f3cb1a3c19c61f46b856ee6683a2d57db"

inherit meson pkgconfig

EXTRA_OEMESON += "--buildtype release -Dtests=false"

FILES:${PN} = "${libdir} ${datadir}"

