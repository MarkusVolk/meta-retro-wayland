SUMMARY = "Final Doom - Plutonia Experiment Wad"
HOMEPAGE = "https://archive.org"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"


SRC_URI = "https://ia801900.us.archive.org/28/items/2020_03_22_DOOM/DOOM%20WADs/Final%20Doom%20-%20The%20Plutonia%20Experiment%20%28id%20Anthology%29.zip"

SRC_URI[sha256sum] = "efdb5a9280bab3b6de5d9b051b1fe7ebbb75e8333d1869235f24131b0c654893"

do_install() {
	install -d ${D}${datadir}/games/doom
	install -m 0644 ${WORKDIR}/PLUTONIA.WAD ${D}${datadir}/games/doom
}

FILES:${PN} = "${datadir}"
