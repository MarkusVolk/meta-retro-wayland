SUMMARY = "mpv-mpris is a plugin for mpv which allows control of the player using standard media keys."
SECTION = "multimedia"
HOMEPAGE = "http://github.com/hoyon/mpv-mpris"

DEPENDS = "glib-2.0 mpv"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6d9f933220f595813218a175adc13001"

PV = "0.8.1"
SRCREV = "6f07b20acd6d4fa317f97004dfcfd53037eca0f2"
SRC_URI = " \
    git://github.com/hoyon/mpv-mpris.git;nobranch=1;protocol=https \
"

S = "${WORKDIR}/git"

inherit autotools-brokensep pkgconfig

do_install() {
	install -d ${D}${libdir}/mpv/scripts
	install -m 0644 ${S}/mpris.so ${D}${libdir}/mpv/scripts/mpris.so
}

FILES:${PN} = "${libdir}"

