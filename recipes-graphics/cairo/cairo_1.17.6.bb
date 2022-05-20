SUMMARY = "The Cairo 2D vector graphics library"
DESCRIPTION = "Cairo is a multi-platform library providing anti-aliased \
vector-based rendering for multiple target backends. Paths consist \
of line segments and cubic splines and can be rendered at any width \
with various join and cap styles. All colors may be specified with \
optional translucence (opacity/alpha) and combined using the \
extended Porter/Duff compositing algebra as found in the X Render \
Extension."
HOMEPAGE = "http://cairographics.org"
BUGTRACKER = "http://bugs.freedesktop.org"
SECTION = "libs"

LICENSE = "(MPL-1.1 | LGPL-2.1-only) & GPL-3.0-or-later"
LICENSE:${PN} = "MPL-1.1 | LGPL-2.1-only"
LICENSE:${PN}-dev = "MPL-1.1 | LGPL-2.1-only"
LICENSE:${PN}-doc = "MPL-1.1 | LGPL-2.1-only"
LICENSE:${PN}-gobject = "MPL-1.1 | LGPL-2.1-only"
LICENSE:${PN}-script-interpreter = "MPL-1.1 | LGPL-2.1-only"
LICENSE:${PN}-perf-utils = "GPL-3.0-or-later"

LIC_FILES_CHKSUM = "file://COPYING;md5=e73e999e0c72b5ac9012424fa157ad77"

DEPENDS = "glib-2.0 pixman"

SRC_URI = " \
	https://gitlab.freedesktop.org/cairo/cairo/-/archive/${PV}/cairo-${PV}.tar.bz2 \
	file://cairo-get_bitmap_surface-bsc1036789-CVE-2017-7475.diff \
	file://CVE-2019-6462.patch \
"

SRC_URI:append:class-nativesdk = " file://0001-disable-meson.get_external_property.patch"

SRC_URI[sha256sum] = "90496d135c9ef7612c98f8ee358390cdec0825534573778a896ea021155599d2"

inherit meson pkgconfig upstream-version-is-even multilib_script

PACKAGECONFIG ??= " \
	fontconfig \
	freetype \
	png \
	zlib \
	lzo \
	${@bb.utils.filter('DISTRO_FEATURES', 'x11', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'glesv3', '', d)} \
"

PACKAGECONFIG[x11] = "-Dgl-backend=gl -Dxcb=enabled -Dxlib=enabled,-Dxcb=disabled -Dxlib=disabled,virtual/libx11 virtual/libgl libsm libxrender libxext libxcb"
PACKAGECONFIG[fontconfig] = ",,fontconfig"
PACKAGECONFIG[freetype] = ",,freetype"
PACKAGECONFIG[glesv2] = "-Dgl-backend=glesv2 -Dglesv2=enabled"
PACKAGECONFIG[glesv3] = "-Dgl-backend=glesv3 -Dglesv3=enabled"
PACKAGECONFIG[png] = ",,libpng"
PACKAGECONFIG[xml] = ",,libxml2"
PACKAGECONFIG[zlib] = ",,zlib"
PACKAGECONFIG[lzo] = ",,lzo"
PACKAGECONFIG[tee] = "-Dtee=enabled,-Dtee=disabled"

EXTRA_OEMESON = "-Dtests=disabled -Dsymbol-lookup=disabled"

export prop="false"

do_install:append () {
	rm -rf ${D}${bindir}/cairo-sphinx
	rm -rf ${D}${libdir}/cairo/libcairo-fdr*
	rm -rf ${D}${libdir}/cairo/libcairo-sphinx*
	rm -rf ${D}${libdir}/cairo/.debug/libcairo-fdr*
	rm -rf ${D}${libdir}/cairo/.debug/libcairo-sphinx*
}

PACKAGES =+ "cairo-gobject cairo-script-interpreter cairo-perf-utils"

SUMMARY:cairo-gobject = "The Cairo library GObject wrapper library"
DESCRIPTION:cairo-gobject = "A GObject wrapper library for the Cairo API."

SUMMARY:cairo-script-interpreter = "The Cairo library script interpreter"
DESCRIPTION:cairo-script-interpreter = "The Cairo script interpreter implements \
CairoScript.  CairoScript is used by tracing utilities to enable the ability \
to replay rendering."

DESCRIPTION:cairo-perf-utils = "The Cairo library performance utilities"

FILES:${PN} = "${libdir}/libcairo.so.*"
FILES:${PN}-gobject = "${libdir}/libcairo-gobject.so.*"
FILES:${PN}-script-interpreter = "${libdir}/libcairo-script-interpreter.so.*"
FILES:${PN}-perf-utils = "${bindir}/cairo-trace* ${libdir}/cairo/*.la ${libdir}/cairo/libcairo-trace.so"

BBCLASSEXTEND = "native nativesdk"

UPSTREAM_CHECK_REGEX = "cairo-(?P<pver>\d+(\.\d+)+).tar.xz"
