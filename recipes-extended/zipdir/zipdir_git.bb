SUMMARY = "zipdir as needed by gzdoom"
HOMEPAGE = "https://zdoom.org/index"

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://zipdir.c;md5=d4385b322d32b0b67ece560b8b0d2570"

DEPENDS = "zlib bzip2"
RDEPENDS:${PN} = "zlib bzip2"

inherit cmake

SRC_URI = " \
    git://github.com/ZDoom/gzdoom.git;protocol=https;nobranch=1 \
    file://0001-zipdir-remove-deprecated-liblzma-support.patch \
"

PV = "4.8.2"
SRCREV = "c2373fed99998790dc63ee1f706183e89d0f7929"
S = "${WORKDIR}/git/tools/zipdir"

EXTRA_OECMAKE:class-native += " \
	-DZLIB_LIBRARIES=z \
	-DBZIP2_LIBRARIES=bz2 \
	-DZLIB_INCLUDE_DIR=${STAGING_INCDIR_NATIVE} \
	-DBZIP2_INCLUDE_DIR=${STAGING_INCDIR_NATIVE} \
"

EXTRA_OECMAKE:class-target += " \
	-DZLIB_LIBRARIES=z \
	-DBZIP2_LIBRARIES=bz2 \
	-DZLIB_INCLUDE_DIR=${STAGING_INCDIR} \
	-DBZIP2_INCLUDE_DIR=${STAGING_INCDIR} \
"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 zipdir ${D}${bindir}
}

FILES:${PN} = "${bindir}"

BBCLASSEXTEND = "native"
