SUMMARY = "HEXEN - Beyond heretic v1.1 wad"
HOMEPAGE = "https://archive.org"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"


SRC_URI = "https://archive.org/download/2020_03_22_DOOM/DOOM%20WADs/Hexen%20-%20Beyond%20Heretic%20%28v1.1%29.zip"

SRC_URI[sha256sum] = "ab52debae11ba1a71043cf923ab1db4d64e5cefbce551efcf3353d93cca921ec"

do_install() {
	install -d ${D}${datadir}/games/doom
	install -m 0644 ${WORKDIR}/HEXEN.WAD ${D}${datadir}/games/doom
}

FILES:${PN} = "${datadir}"
