SUMMARY = "Quake3 Arena pak"
HOMEPAGE = "https://archive.org" 
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"


SRC_URI = " \
    https://archive.org/download/baseq3/baseq3.zip \
"

SRC_URI[sha256sum] = "56a9c77bd1f8b9687bbcda1154c5455d216a12f80ea8ac30474f4dc2f44e5288"

do_install() {
	install -d ${D}${datadir}/games/quake3
	cp -rf ${WORKDIR}/baseq3 ${D}${datadir}/games/quake3
}

FILES:${PN} = "${datadir}"

