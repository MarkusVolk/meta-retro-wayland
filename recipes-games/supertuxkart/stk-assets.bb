SUMMARY = "Assets for SuperTuxKart."
HOMEPAGE = "https://github.com/supertuxkart/stk-assets-mobile" 

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://licenses.txt;md5=84fb15f16a7e0abe70bded282e705c06" 

RDEPENDS:${PN} = "supertuxkart"

SRC_URI = "https://github.com/supertuxkart/stk-assets-mobile/releases/download/${PV}/stk-assets-full.zip"
SRC_URI[sha256sum] = "cf540c3f459cab32c6fb194808a342a294422fe63f17c3c2486e06dd7565c4e8"

PV = "1.3"
S = "${WORKDIR}"

do_install() {
	install -d ${D}${datadir}/supertuxkart/data
	for i in editor karts library models music sfx textures tracks; do
		cp -r "$i" ${D}${datadir}/supertuxkart/data
	done
}

FILES:${PN} += "${datadir}"

