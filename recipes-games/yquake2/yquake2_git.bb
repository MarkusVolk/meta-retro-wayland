SUMMARY = "Yamagi Quake 2 Client"
HOMEPAGE = "https://www.yamagi.org/quake2/" 

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cdfb10fe3916436d25f4410fcd6a97b8" 

DEPENDS = "libsdl2 virtual/libgl curl openal-soft"
RDEPENDS:${PN} = "openal-soft"
RRECOMMENDS:${PN} = "quake2-pak rogue xatrix"

inherit cmake pkgconfig gtk-icon-cache

EXTRA_OECMAKE += "-DSYSTEMWIDE_SUPPORT=1"

SRC_URI = " \
    git://github.com/yquake2/yquake2.git;protocol=https \
    file://quake2.desktop \
"

PV = "8.00"
SRCREV = "QUAKE2_8_00"
S = "${WORKDIR}/git"

# thumb is unsupported
ARM_INSTRUCTION_SET = "arm"

do_install() {
	# install routine is missing ... do it manually
	install -d ${D}${libexecdir} ${D}${bindir} ${D}${datadir}/applications ${D}${datadir}/icons/hicolor/scalable/apps
	install -m 644 ${WORKDIR}/quake2.desktop ${D}${datadir}/applications
	install -m 644 ${S}/stuff/icon/Quake2.svg ${D}${datadir}/icons/hicolor/scalable/apps
	cp -rf ${B}/release ${D}${libexecdir}/quake2
	echo "exec ${libexecdir}/quake2/quake2 +set r_mode -1 +set r_customwidth 1920 +set r_customheight 1080 -datadir ${datadir}/games/quake2" > ${D}${bindir}/quake2
	chmod 755 ${D}${bindir}/quake2
}

FILES:${PN} = " \
	${bindir} \
	${libexecdir} \
	${datadir} \
"

