SUMMARY = "Yamagi Quake 2 Client"
HOMEPAGE = "https://www.yamagi.org/quake2/" 

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cdfb10fe3916436d25f4410fcd6a97b8" 

DEPENDS = "libsdl2 virtual/libgles2 curl openal-soft"
RDEPENDS_${PN} = "openal-soft"
RRECOMMENDS_${PN} = "quake2-pak"

inherit cmake pkgconfig

EXTRA_OECMAKE += "-DSYSTEMWIDE_SUPPORT=1"

SRC_URI = " \
    git://github.com/yquake2/yquake2.git;protocol=https \
"

PV = "8.00"
SRCREV = "QUAKE2_8_00"
S = "${WORKDIR}/git"

# thumb is unsupported
ARM_INSTRUCTION_SET = "arm"

do_install() {
	# install routine is missing ... do it manually
	install -d ${D}${prefix}/libexec ${D}${bindir}
	cp -rf ${B}/release ${D}${prefix}/libexec/quake2
	echo -e "exec /usr/libexec/quake2/quake2 -datadir ${datadir}/quake2" > ${D}${bindir}/quake2
	chmod 755 ${D}${bindir}/quake2
}

FILES_${PN} = " \
	${bindir} \
	${prefix}/libexec \
"

