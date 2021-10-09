SUMMARY = "Fortunes for the fortune program."
LICENSE = "CC-BY-4.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=ae7d52aec34a76e4d0f2680fb208db5f"

SRC_URI = " \
	git://github.com/bmc/fortunes.git;protocol=https \
"

RDEPENDS:${PN} = " \
	fortune \
"

S = "${WORKDIR}/git"
PV = "1.0"
SRCREV = "2545ebb6f08be7bab5d204d8326e382f6181608b"


do_install() {
	install -d ${D}${datadir}/fortunes
	install -m644 ${S}/fortunes ${D}${datadir}/fortunes
}	
