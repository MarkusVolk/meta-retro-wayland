SUMMARY = "makeobj to compile Simutrans paks."
HOMEPAGE = "https://www.simutrans.com" 

LICENSE = "Artistic-2.0"
LIC_FILES_CHKSUM = "file://../../LICENSE.txt;md5=10a3c09093deda8cbe4095ab2b158072" 

DEPENDS = "zlib bzip2 libpng"

inherit cmake

SRC_URI = " \
    git://github.com/simutrans/simutrans.git;protocol=https;nobranch=1 \
    file://0001-CMakeList.txt-fix-build.patch \
"

SRCREV = "6f26cce03f49ec3329a1bd4e578def35afc2e8f0"
S = "${WORKDIR}/git/src/makeobj"

EXTRA_OECMAKE = "-DSIMUTRANS_MSG_LEVEL=1"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${B}/makeobj ${D}${bindir}
}

FILES:${PN} = "${bindir}"
BBCLASSEXTEND = "native nativesdk"

