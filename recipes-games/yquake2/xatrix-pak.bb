SUMMARY = "Quake-2 'The Reckoning' pak"
HOMEPAGE = "https://archive.org" 

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"


SRC_URI = " \
    https://archive.org/download/xatrix/xatrix.zip \
"

SRC_URI[sha256sum] = "c4fcde2a674568b3404760ded631c5354a72d4dea16fa3d04f5951f5e0679e62"

do_install() {
	install -d ${D}${datadir}/games/quake2
	cp -rf ${WORKDIR}/xatrix ${D}${datadir}/games/quake2
}

FILES:${PN} = " \
	${datadir} \
"

