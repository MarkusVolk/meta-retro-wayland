DESCRIPTION = "Syntax Highlighting für GNU nano"
HOMEPAGE = "http://www.nano-editor.org/"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0-or-later;md5=1c76c4cc354acaac30ed4d5eefea7245"
SECTION = "console/utils"
RDEPENDS:${PN} = "nano"

SRC_URI = "git://github.com/scopatz/nanorc.git;protocol=https;branch=master"

SRCREV = "${AUTOREV}"
PV = "${SRCPV}"

S = "${WORKDIR}/git"

do_install(){
	install -d ${D}/${datadir}/nano
	install -m 644 ${S}/*.nanorc ${D}${datadir}/nano
}

FILES:${PN} += "/usr/share/nano"

