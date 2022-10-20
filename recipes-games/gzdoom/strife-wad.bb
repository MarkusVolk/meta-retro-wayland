SUMMARY = "STRIFE v1.2 wad"
HOMEPAGE = "https://archive.org"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"


SRC_URI = "https://archive.org/download/2020_03_22_DOOM/DOOM%20WADs/Strife%20%28v1.2%29.zip"

SRC_URI[sha256sum] = "9eaf931c5acfe795eb7b3b62db307dfcd36743e3bad4e6c4d7b2368ab49ec9b9"

do_install() {
	install -d ${D}${datadir}/games/doom
	install -m 0644 ${WORKDIR}/STRIFE1.WAD ${D}${datadir}/games/doom
	install -m 0644 ${WORKDIR}/VOICES.WAD ${D}${datadir}/games/doom
}

FILES:${PN} = "${datadir}"

