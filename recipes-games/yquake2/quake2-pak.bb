SUMMARY = "Quake-2 v3.20 pak"
HOMEPAGE = "https://archive.org" 

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"


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

