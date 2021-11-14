SUMMARY = "Quake-2 v3.20 pak"
HOMEPAGE = "https://archive.org" 

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"


SRC_URI = " \
    https://archive.org/download/quake2_202105/quake2.zip \
"

SRC_URI[sha256sum] = "ed17776afe5d9076baf2c718e54fc0cb0866bafbcdce3f2658e67e2e5c17c217"

do_install() {
	install -d ${D}${datadir}/games
	cp -rf ${WORKDIR}/quake2 ${D}${datadir}/games
}

FILES:${PN} = " \
	${datadir} \
"

