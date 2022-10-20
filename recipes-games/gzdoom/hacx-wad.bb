SUMMARY = "HACX v2.0 wad"
HOMEPAGE = "https://archive.org"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"


SRC_URI = "https://ia801900.us.archive.org/28/items/2020_03_22_DOOM/DOOM%20WADs/HACX%20%28v2.0-r61%29.zip"

SRC_URI[sha256sum] = "dd6edef84b3e7d138f29d9e007fb3156f228dc213b33c895a2dbe0bafa083b4b"

do_install() {
	install -d ${D}${datadir}/games/doom
	install -m 0644 ${WORKDIR}/HACX.WAD ${D}${datadir}/games/doom
}

FILES:${PN} = "${datadir}"

