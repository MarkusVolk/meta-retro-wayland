FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

RDEPENDS:${PN} = "zsh-syntax-highlighting powerlevel10k powerline-fonts"

SRC_URI:append = " \
	file://zshrc \
	file://vconsole.conf \
	file://p10k.zsh \
"

inherit retro-user

do_install:append() {
	install -d ${D}${sysconfdir} -d ${D}${RETRO_USER_HOMEDIR}
	install -m0644 ${WORKDIR}/vconsole.conf ${D}${sysconfdir}
	install -m0644 ${WORKDIR}/p10k.zsh ${D}${RETRO_USER_HOMEDIR}/.p10k.zsh
	install -m0644 ${WORKDIR}/zshrc ${D}${RETRO_USER_HOMEDIR}/.zshrc
	chown ${RETRO_USER}:${RETRO_USER} -R ${D}${RETRO_USER_HOMEDIR}
}

FILES_${PN} += "${RETRO_USER_HOMEDIR}"

