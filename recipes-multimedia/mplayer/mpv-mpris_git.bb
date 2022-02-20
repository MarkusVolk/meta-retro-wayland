SUMMARY = "mpv-mpris is a plugin for mpv which allows control of the player using standard media keys."
SECTION = "multimedia"
HOMEPAGE = "http://github.com/hoyon/mpv-mpris"

DEPENDS = "glib-2.0 mpv"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6d9f933220f595813218a175adc13001"

PV = "0.6"
SRCREV = "22f9ba0f7c52437e2b3c2157b74e338e466b09e9"
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

