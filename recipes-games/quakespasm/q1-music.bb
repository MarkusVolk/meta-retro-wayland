SUMMARY = "Quake ogg audio files"
HOMEPAGE = "https://archive.org" 
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"


SRC_URI = "https://archive.org/download/music_20211125/music.zip"

SRC_URI[sha256sum] = "1b9a3ef082949786135c1a8426d5dea03dc844e3d5d629edc3d220da6647651a"

do_install() {
	install -d ${D}${datadir}/games/quake/id1
	cp -rf ${WORKDIR}/music ${D}${datadir}/games/quake/id1
}

FILES:${PN} = "${datadir}"

