SUMMARY = "Library to abstract STB hardware. Supports Tripledragon, AZbox ME, Fulan Spark boxes as well as generic PC hardware and the Raspberry Pi right now."
DESCRIPTION = "Library to abstract STB hardware."
HOMEPAGE = "https://github.com/neutrino-mp"
SECTION = "libs"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${THISDIR}/libstb-hal/COPYING.GPL;md5=751419260aa954499f7abaabaa882bbe"

#
# this stuff really is machine specific, not CPU specific
PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "\
	openthreads \
	ffmpeg \
	libao \
	libass \
	libaio \
	fontconfig \
	atk \
	libpng \
	freetype \
	glew \
	freeglut \
	gdk-pixbuf \
	cairo \
	pixman \
	cogl-1.0 \
	clutter-1.0 \
	harfbuzz \
	freetype \
	pango \
	json-glib \
"

include tuxbox.inc

# on coolstream, the same is provided by cs-drivers pkg (libcoolstream)
PROVIDES = "virtual/libstb-hal"
RPROVIDES_${PN} = "virtual/libstb-hal"
RDEPENDS_${PN} = "ffmpeg"

SRCREV = "${AUTOREV}"
#PV = "0.1+git${SRCPV}"

# libstb-hal-bin package for testing binaries etc.
PACKAGES += "${PN}-bin"

SRC_URI_append = " \
	file://blank_480.mpg \
	file://blank_576.mpg \
	file://timer-wakeup.init \
"

S = "${WORKDIR}/git"

# the build system is not really broken wrt separate builddir,
# but I want it to build inside the source for various reasons :-)
inherit autotools pkgconfig

LDFLAGS += " -Wl,-rpath-link,${STAGING_LIBDIR} -L${STAGING_LIBDIR} -lrt -lavformat -lavcodec -lavutil -lswscale -lswresample"


EXTRA_OECONF += "\
	--enable-maintainer-mode \
	--disable-silent-rules \
	--enable-shared \
	--enable-clutter \
	--with-boxtype=generic \
"

EXTRA_OEMAKE += "'ARFLAGS=rc'"

do_configure_prepend() {
	export AUTOMAKE="automake --foreign --add-missing"
}

do_install_append() {
	install -d ${D}/${datadir}
	install -d ${D}/${includedir}/libstb-hal
	install -d ${D}/${includedir}/common
	install -d ${D}/${includedir}/libarmbox
	install -d ${D}/${includedir}/libgeneric-pc
	install -m 0644 ${S}/libgeneric-pc/*.h ${D}/${includedir}/libgeneric-pc	
	install -m 0644 ${S}/libarmbox/*.h ${D}/${includedir}/libarmbox
	install -m 0644 ${S}/common/*.h ${D}/${includedir}/common	
	install -m 0644 ${S}/include/*.h ${D}/${includedir}/libstb-hal
}

# pic2m2v is included in lib package, because it is always needed,
# libstb-hal-bin contains all other binaries, which are rather for testing only
FILES_${PN} = "\
	${libdir}/* \
	${bindir}/pic2m2v \
	${datadir} \
"

FILES_${PN}-dev += "${includedir}"
