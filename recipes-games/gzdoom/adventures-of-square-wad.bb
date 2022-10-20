SUMMARY = "Adventures of the square wad"
HOMEPAGE = "https://archive.org"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"


SRC_URI = "https://ia801900.us.archive.org/28/items/2020_03_22_DOOM/DOOM%20WADs/Adventures%20of%20Square%2C%20The%20-%20Episodes%201%20%26%202%20%28v2.0%29.zip"

SRC_URI[sha256sum] = "d6ad854570e3c4299a80791198266957a1b564f93e42fa6bfe538b74572dc7b1"

do_install() {
	install -d ${D}${datadir}/games/doom
	install -m 0644 ${WORKDIR}/SQUARE1.PK3 ${D}${datadir}/games/doom
}

FILES:${PN} = "${datadir}"

