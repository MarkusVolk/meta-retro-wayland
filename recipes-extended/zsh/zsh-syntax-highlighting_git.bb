SUMMARY = "Syntax highlighting for zsh"
DESCRIPTION = "Add syntax highlighting support into zsh"
HOMEPAGE = "https://github.com/zsh-users/zsh-syntax-highlighting.git"
SECTION = "base/shell"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING.md;md5=3bf38c5f1bf4c65eeb1029f986724465"

RDEPENDS:${PN} = "zsh"

SRC_URI = "git://github.com/zsh-users/zsh-syntax-highlighting.git;protocol=https;branch=master"

SRCREV = "55f846c673661bde03ef97333be7889f54079c7b"
PV = "${SRCPV}"
PR = "1"

S = "${WORKDIR}/git"

inherit retro-user

do_install () {
	install -d ${D}${RETRO_USER_HOMEDIR}
	cp -rf ${S} ${D}${RETRO_USER_HOMEDIR}/.zsh-syntax-highlighting
	rm -r ${D}${RETRO_USER_HOMEDIR}/.zsh-syntax-highlighting/.git
	chown ${RETRO_USER}:${RETRO_USER} -R ${D}${RETRO_USER_HOMEDIR}
}

FILES:${PN} = "${RETRO_USER_HOMEDIR}"
