SUMMARY = "DOOM v1.9 wad"
HOMEPAGE = "https://archive.org"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

SRC_URI = " \
    https://archive.org/download/2020_03_22_DOOM/DOOM%20WADs/Doom%20%28v1.9%29.zip \
"

SRC_URI[sha256sum] = "da93816b56634624ee70afc1629352bc6ca64ef61bb0558b3a8f717bc7a24ecc"

do_install() {
	install -d ${D}${datadir}/games/doom
	install -m 0644 ${WORKDIR}/DOOM.WAD ${D}${datadir}/games/doom
}

FILES:${PN} = "${datadir}"

