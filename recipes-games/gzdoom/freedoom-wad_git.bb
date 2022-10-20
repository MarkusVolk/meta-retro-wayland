SUMMARY = "Freedoom Wad"
HOMEPAGE = "https://github.com/freedoom/freedoom"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING.adoc;md5=990462e5b1ba9598e23dff2b9608db60"

DEPENDS = "deutex-native python3-pillow-native"

inherit autotools-brokensep python3native

SRC_URI = " \
    git://github.com/freedoom/freedoom.git;protocol=https;branch=master \
"

PV = "0.12.1"
SRCREV = "72174a75c10f49ce88b482a988f00eaf91b4ba92"
S = "${WORKDIR}/git"

EXTRA_OEMAKE = "prefix='' waddir=${datadir}/games/doom"


do_install:append() {
	mv ${D}/share ${D}${prefix}/share
}

FILES:${PN} += "${datadir}"
