SUMMARY = "DOOM2 v1.9 wad"
HOMEPAGE = "https://archive.org"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"


SRC_URI = "https://ia801900.us.archive.org/28/items/2020_03_22_DOOM/DOOM%20WADs/Doom%20II%20-%20Hell%20on%20Earth%20%28v1.9%29.zip"

SRC_URI[sha256sum] = "995a8b4b0e546ac706069b0854989665976810a78c15116d5d52a92ef01395b2"

do_install() {
	install -d ${D}${datadir}/games/doom
	install -m 0644 ${WORKDIR}/DOOM2.WAD ${D}${datadir}/games/doom
}

FILES:${PN} = "${datadir}"
