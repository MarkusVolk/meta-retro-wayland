LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit retro-user retro-overrides

SRC_URI = " \
	https://repo.kodinerds.net/addons/repository.kodinerds/repository.kodinerds-7.0.1.1.zip;unpack=0 \
	file://azotebg \
	file://bashrc \
	file://sway/config \
	file://sway/scripts/chromium.sh \
	file://sway/scripts/kodi.sh \
	file://sway/scripts/retroarch.sh \
	file://sway/scripts/thunar.sh \
	file://foot/foot.ini \
	file://waybar/config \
	file://waybar/style.css \
	file://waybar/scripts/eovpn.sh \
	file://waybar/scripts/waybar.sh \
	file://waybar/scripts/pulse.sh \
	file://waybar/scripts/net.sh \
	file://waybar/scripts/processes.sh \
	file://waybar/scripts/resources.sh \
	file://waybar/scripts/blueman-manager.sh \
	file://glib-2.0/settings/keyfile \
	file://unlock-keyring \
	file://bash_profile \
"

SRC_URI[sha256sum] = "379e87793087017f16463ff5bacc5422dc7a3868332647e1899df7431573c7a0"

RRECOMMENDS:${PN} = " \
	autotiling-rs \
	capitaine-cursors \
	nwg-launchers \
	waybar \
	nordic-darker-theme \
	tela-circle-icon-theme \
	xdg-user-dirs \
"	
	
do_install() {
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/systemd/user
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/foot
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/samba
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/glib-2.0/settings
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/connman
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/mpv/
	install -d ${D}${RETRO_USER_HOMEDIR}/Downloads
	install -d ${D}${bindir}
	install -d ${D}${ROOT_HOME}/.config/glib-2.0/settings
	install -m 0644 ${WORKDIR}/bashrc ${D}${RETRO_USER_HOMEDIR}/.bashrc
	install -m 0644 ${WORKDIR}/bash_profile ${D}${RETRO_USER_HOMEDIR}/.bash_profile
	install -m 0644 ${WORKDIR}/sway/config ${D}${RETRO_USER_HOMEDIR}/.config/sway
	install -m 0755 ${WORKDIR}/sway/scripts/chromium.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts	
	install -m 0755 ${WORKDIR}/sway/scripts/kodi.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts	
	install -m 0755 ${WORKDIR}/sway/scripts/retroarch.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts
	install -m 0755 ${WORKDIR}/sway/scripts/thunar.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts	
	install -m 0644 ${WORKDIR}/foot/foot.ini ${D}${RETRO_USER_HOMEDIR}/.config/foot/foot.ini
	install -m 0644 ${WORKDIR}/waybar/config ${D}${RETRO_USER_HOMEDIR}/.config/waybar/config
	install -m 0644 ${WORKDIR}/waybar/style.css ${D}${RETRO_USER_HOMEDIR}/.config/waybar/style.css
	install -m 0755 ${WORKDIR}/waybar/scripts/eovpn.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts/eovpn.sh
	install -m 0755 ${WORKDIR}/waybar/scripts/waybar.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts/waybar.sh
	install -m 0755 ${WORKDIR}/waybar/scripts/pulse.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts	
	install -m 0755 ${WORKDIR}/waybar/scripts/net.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts
	install -m 0755 ${WORKDIR}/waybar/scripts/blueman-manager.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts
	install -m 0755 ${WORKDIR}/waybar/scripts/processes.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts
	install -m 0755 ${WORKDIR}/waybar/scripts/resources.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts
	install -m 0755 ${WORKDIR}/azotebg ${D}${RETRO_USER_HOMEDIR}/.azotebg
	install -m 0644 ${WORKDIR}/glib-2.0/settings/keyfile ${D}${RETRO_USER_HOMEDIR}/.config/glib-2.0/settings
	install -m 0644 ${WORKDIR}/glib-2.0/settings/keyfile ${D}${ROOT_HOME}/.config/glib-2.0/settings
	install -m 0644 ${WORKDIR}/repository.kodinerds-7.0.1.1.zip ${D}${RETRO_USER_HOMEDIR}/Downloads
	install -m 0755 ${WORKDIR}/unlock-keyring ${D}${bindir}
}

do_install:append:rpi() {
	echo "--gpu-context=wayland\n--hwdec=v4l2m2m" > ${D}${RETRO_USER_HOMEDIR}/.config/mpv/mpv.conf
}

do_install:append:x86arch() {
	echo "--gpu-context=wayland\n--hwdec=vaapi" > ${D}${RETRO_USER_HOMEDIR}/.config/mpv/mpv.conf
}

do_install:append:rockchip() {
	echo "--gpu-context=wayland\n--hwdec=drm-copy" > ${D}${RETRO_USER_HOMEDIR}/.config/mpv/mpv.conf
}

do_install:append() {
	chown ${RETRO_USER_NAME}:${RETRO_USER_NAME} -R ${D}${RETRO_USER_HOMEDIR}
}

FILES:${PN} = " \
	${RETRO_USER_HOMEDIR} \
	${ROOT_HOME} \
	${bindir} \
"

INSANE_SKIP:${PN} = "host-user-contaminated"

