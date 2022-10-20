SUMMARY = "Heretic wad"
HOMEPAGE = "https://archive.org"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"


SRC_URI = "https://ia801900.us.archive.org/28/items/2020_03_22_DOOM/DOOM%20WADs/Heretic%20-%20Shadow%20of%20the%20Serpent%20Riders%20%28v1.3%29.zip"

SRC_URI[sha256sum] = "7d44964876be044597ddc1fc33e3a4c5f4afc1d85061d74f26f66539178736f5"

do_install() {
	install -d ${D}${datadir}/games/doom
	install -m 0644 ${WORKDIR}/HERETIC.WAD ${D}${datadir}/games/doom
}

FILES:${PN} = "${datadir}"

