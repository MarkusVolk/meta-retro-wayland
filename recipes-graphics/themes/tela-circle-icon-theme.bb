SUMMARY = "Tela circle Icon Theme."
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING.md;md5=0f7f40118b07053f43a50552fd48e11d"


SRC_URI = "git://github.com/vinceliuice/Tela-circle-icon-theme.git;protocol=https;branch=master"

PV = "2022-03-07"
SRCREV = "f4eeda13c5a5033d2b5bd4bbb5157b5a2b8235e5"
S = "${WORKDIR}/git"

inherit gtk-icon-cache

do_install() {
	install -d ${D}${datadir}/icons
	./install.sh -n Tela-circle -d ${D}${datadir}/icons
}

FILES:${PN} = "${datadir}"

