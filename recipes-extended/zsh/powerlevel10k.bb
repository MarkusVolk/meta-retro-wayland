SUMMARY = "Powerlevel10k theme for Zsh"
DESCRIPTION = "Powerlevel10k is a theme for Zsh. It emphasizes speed, flexibility and out-of-the-box experience."
HOMEPAGE = "https://github.com/romkatv/powerlevel10k"
SECTION = "base/shell"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=239c25ece29e6df812e1e05750ff8271"

RDEPENDS:${PN} = "zsh"

SRC_URI = "git://github.com/romkatv/powerlevel10k;depth=1;protocol=https;branch=master \
"

SRCREV = "${AUTOREV}"
PV = "${SRCPV}"
PR = "1"

S = "${WORKDIR}/git"

inherit retro-user

do_install () {
	install -d ${D}${RETRO_USER_HOMEDIR} ${D}${sysconfdir}/zsh
	cp -rf ${S} ${D}${RETRO_USER_HOMEDIR}/.powerlevel10k
	rm -r ${D}${RETRO_USER_HOMEDIR}/.powerlevel10k/.git
	chown ${RETRO_USER}:${RETRO_USER} -R ${D}${RETRO_USER_HOMEDIR}
}

FILES:${PN} = "${RETRO_USER_HOMEDIR} \
	       ${sysconfdir} \
"
