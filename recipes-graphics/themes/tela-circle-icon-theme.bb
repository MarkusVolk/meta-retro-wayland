SUMMARY = "Tela circle Icon Theme."
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"


SRC_URI = "git://github.com/vinceliuice/Tela-circle-icon-theme.git"

PV = "2020-11-29"
SRCREV = "${PV}"
S = "${WORKDIR}/git"

inherit gtk-icon-cache

do_install() {
	install -d ${D}${datadir}/icons
	./install.sh -n Tela-circle -d ${D}${datadir}/icons
}

FILES_${PN} = "${datadir}"

