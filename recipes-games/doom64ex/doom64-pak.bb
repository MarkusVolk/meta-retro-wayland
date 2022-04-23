SUMMARY = "Doom64ex pak"
HOMEPAGE = "https://archive.org" 

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"


SRC_URI = " \
	https://archive.org/download/doom64ex_202204/doom64ex.zip \
	file://doom.png \
	file://doom64.desktop \	
"

SRC_URI[sha256sum] = "2a43f7777f85f5de8ca27a6ff90a6ce025be134ceb45548441ebc3b68d77e8ad"

inherit gtk-icon-cache

do_install() {
	install -d ${D}${datadir}/games ${D}${datadir}/icons/hicolor/128x128/apps ${D}${datadir}/applications
	cp -rf ${WORKDIR}/doom64ex ${D}${datadir}/games
	install -m 644 ${WORKDIR}/doom64.desktop ${D}${datadir}/applications
	install -m 644 ${WORKDIR}/doom.png ${D}${datadir}/icons/hicolor/128x128/apps
}

FILES:${PN} = " \
	${datadir} \
"

