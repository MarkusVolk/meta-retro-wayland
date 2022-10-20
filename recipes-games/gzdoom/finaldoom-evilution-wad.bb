SUMMARY = "Final Doom - Evilution Wad"
HOMEPAGE = "https://archive.org"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"


SRC_URI = "https://ia801900.us.archive.org/28/items/2020_03_22_DOOM/DOOM%20WADs/Final%20Doom%20-%20Evilution%20%28id%20Anthology%29.zip"

SRC_URI[sha256sum] = "35e7105d1629ed6f8a6d2366c870569e1e63dde06b7065aa657d9399c0d52054"

do_install() {
	install -d ${D}${datadir}/games/doom
	install -m 0644 ${WORKDIR}/TNT.WAD ${D}${datadir}/games/doom
}

FILES:${PN} = "${datadir}"
