SUMMARY = "DOOM v1.9 wad"
HOMEPAGE = "https://archive.org" 

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"


SRC_URI = " \
    https://archive.org/download/2020_03_22_DOOM/DOOM%20WADs/Doom%20%28v1.9%29.zip \
"

SRC_URI[sha256sum] = "da93816b56634624ee70afc1629352bc6ca64ef61bb0558b3a8f717bc7a24ecc"

do_install() {
	install -d ${D}${datadir}/doomretro ${D}${bindir}
	install -m 0644 ${WORKDIR}/DOOM.WAD ${D}${datadir}/doomretro
	echo -e "exec doomretro ${datadir}/doomretro/DOOM.WAD\n" > ${D}${bindir}/doom
	chmod 755 ${D}${bindir}/doom
}

FILES:${PN} = " \
	${bindir} \
	${datadir} \
"

