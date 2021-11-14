SUMMARY = "Quake-2 'Ground Zero' pak"
HOMEPAGE = "https://archive.org" 

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"


SRC_URI = " \
    https://archive.org/download/rogue_202111/rogue.zip \
"

SRC_URI[sha256sum] = "cb3cba868cfd9d3648959bac9947a41e59706ee2d629b469343e6bfae3660837"

do_install() {
	install -d ${D}${datadir}/games/quake2
	cp -rf ${WORKDIR}/rogue ${D}${datadir}/games/quake2
}

FILES:${PN} = " \
	${datadir} \
"

