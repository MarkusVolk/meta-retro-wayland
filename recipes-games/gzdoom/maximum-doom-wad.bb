SUMMARY = "Maximum Doom wad"
HOMEPAGE = "https://archive.org"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"


SRC_URI = "https://ia801900.us.archive.org/28/items/2020_03_22_DOOM/DOOM%20WADs/Maximum%20Doom.zip"

SRC_URI[sha256sum] = "9eaf931c5acfe795eb7b3b62db307dfcd36743e3bad4e6c4d7b2368ab49ec9b9"

do_install() {
	install -d ${D}${datadir}/games/doom
	for file in *.WAD; do
		install "$file" ${D}${datadir}/games/doom
	done
}

FILES:${PN} = "${datadir}"

