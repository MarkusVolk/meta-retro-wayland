SUMMARY = "Assets for SuperTuxKart."
HOMEPAGE = "https://github.com/supertuxkart/stk-assets-mobile" 

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891" 

RDEPENDS:${PN} = "supertuxkart"

SRC_URI = "https://github.com/supertuxkart/stk-assets-mobile/releases/download/${PV}/stk-assets.zip"
SRC_URI[sha256sum] = "34e098e501e524dd21641f9cb96fc91a7524e5bfe5bbdc755398d72e2fde22c6"

PV = "1.4"
S = "${WORKDIR}"

do_install() {
	install -d ${D}${datadir}/games/supertuxkart/data
	for i in karts library models music sfx textures tracks; do
		cp -r "$i" ${D}${datadir}/games/supertuxkart/data
	done
}

FILES:${PN} += "${datadir}"

