SUMMARY = "Universal Raze Package"
HOMEPAGE = "https://archive.org"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

DEPENDS = "unzip-native"

SRC_URI = "https://archive.org/download/raze-package/Raze%20Package.zip;unpack=0"
SRC_URI[sha256sum] = "e6aa6b6e532692b2da480d009769445f90c0ba7a61a4d64ed5d2f1bacf9b8b13"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${datadir}/games
	unzip Raze\ Package.zip -d ${D}${datadir}/games
	[ -d ${D}${datadir}/games/Raze\ Package ] && mv ${D}${datadir}/games/Raze\ Package ${D}${datadir}/games/raze
}

FILES:${PN} = "${datadir}"
