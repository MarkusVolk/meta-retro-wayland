SUMMARY = "Source for a library of binary -> decimal and decimal -> binary conversion routines"
HOMEPAGE = "https://github.com/jwiegley/gdtoa"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://../../package/common/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit cmake

DEPENDS = "gdtoa-native"

SRC_URI = " \
    git://github.com/coelckers/Raze.git;protocol=https;nobranch=1 \
"

SRCREV = "6b4561f3bd83e2ae62ea745c37aaca28275b2322"
S = "${WORKDIR}/git/libraries/gdtoa"

do_install:class-native() {
	install -d ${D}${bindir}
	install -m 0755 ${B}/arithchk ${D}${bindir}
	install -m 0755 ${B}/qnan ${D}${bindir}
}

do_install:class-target() {
	install -d ${D}${libdir} ${D}${includedir}
	for file in ${B}/*.h; do
		install -m 0644 "$file" ${D}${includedir}
	done
	install -m 0644 ${B}/libgdtoa.a ${D}${libdir}
}

FILES:${PN} = "${libdir}"
FILES:${PN}-dev = "${includedir}"

BBCLASSEXTEND = "native"
