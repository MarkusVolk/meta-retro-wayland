SUMMARY = "Quake pak"
HOMEPAGE = "https://archive.org" 
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"


SRC_URI = " \
    https://archive.org/download/quake_dos/Quake.zip \
"

SRC_URI[sha256sum] = "722c0d747cedce05bf965b1c8a62686cc3f5a6a9ab11ce4d47e47725a4a1bb6e"

do_install() {
	install -d ${D}${datadir}/games/quake
	cp -rf ${WORKDIR}/id1 ${D}${datadir}/games/quake
}

FILES:${PN} = "${datadir}"

