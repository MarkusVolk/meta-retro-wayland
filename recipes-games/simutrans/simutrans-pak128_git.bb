SUMMARY = "Pak128 is a graphics set (pakset) for Simutrans."
HOMEPAGE = "https://www.simutrans.com" 

LICENSE = "Artistic-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=88f7c4912aebe9740e31585406f2bf7b" 

DEPENDS = "zip-native simutrans-makeobj-native"

SRC_URI = "git://github.com/simutrans/pak128.git;protocol=https;branch=master"

inherit autotools-brokensep

SRCREV = "0adb1d2a6cd9cb1254bede2f52081916cbb93921"
S = "${WORKDIR}/git"
PV = "2.8.2"

EXTRA_OEMAKE = "MAKEOBJ=${STAGING_BINDIR_NATIVE}/makeobj"

do_install() {
	install -d ${D}${datadir}
	cp -rf ${S}/simutrans ${D}${datadir}
}

FILES:${PN} = "${datadir}"

