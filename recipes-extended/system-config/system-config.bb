LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit retro-user retro-overrides

SRC_URI = " \
	file://azotebg \
	file://bashrc \
	file://sway/config \
	file://sway/scripts/chromium.sh \
	file://sway/scripts/kodi.sh \
	file://sway/scripts/retroarch.sh \
	file://sway/scripts/thunar.sh \
	file://profile \
	file://foot/foot.ini \
	file://waybar/config \
	file://waybar/style.css \
	file://waybar/scripts/waybar.sh \
	file://waybar/scripts/pulse.sh \
	file://waybar/scripts/net.sh \
	file://waybar/scripts/processes.sh \
	file://waybar/scripts/resources.sh \
	file://waybar/scripts/blueman-manager.sh \
	file://glib-2.0/settings/keyfile \
"

RRECOMMENDS:${PN} = " \
	autotiling \
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
	install -d ${D}${ROOT_HOME}/.config/glib-2.0/settings
	install -m 0644 ${WORKDIR}/bashrc ${D}${RETRO_USER_HOMEDIR}/.bashrc
	install -m 0644 ${WORKDIR}/profile ${D}${RETRO_USER_HOMEDIR}/.profile
	install -m 0644 ${WORKDIR}/sway/config ${D}${RETRO_USER_HOMEDIR}/.config/sway
	install -m 0755 ${WORKDIR}/sway/scripts/chromium.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts	
	install -m 0755 ${WORKDIR}/sway/scripts/kodi.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts	
	install -m 0755 ${WORKDIR}/sway/scripts/retroarch.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts
	install -m 0755 ${WORKDIR}/sway/scripts/thunar.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts	
	install -m 0644 ${WORKDIR}/foot/foot.ini ${D}${RETRO_USER_HOMEDIR}/.config/foot/foot.ini
	install -m 0644 ${WORKDIR}/waybar/config ${D}${RETRO_USER_HOMEDIR}/.config/waybar/config
	install -m 0644 ${WORKDIR}/waybar/style.css ${D}${RETRO_USER_HOMEDIR}/.config/waybar/style.css
	install -m 0755 ${WORKDIR}/waybar/scripts/waybar.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts/waybar.sh
	install -m 0755 ${WORKDIR}/waybar/scripts/pulse.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts	
	install -m 0755 ${WORKDIR}/waybar/scripts/net.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts
	install -m 0755 ${WORKDIR}/waybar/scripts/blueman-manager.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts
	install -m 0755 ${WORKDIR}/waybar/scripts/processes.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts
	install -m 0755 ${WORKDIR}/waybar/scripts/resources.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts
	install -m 0755 ${WORKDIR}/azotebg ${D}${RETRO_USER_HOMEDIR}/.azotebg
	install -m 0644 ${WORKDIR}/glib-2.0/settings/keyfile ${D}${RETRO_USER_HOMEDIR}/.config/glib-2.0/settings
	install -m 0644 ${WORKDIR}/glib-2.0/settings/keyfile ${D}${ROOT_HOME}/.config/glib-2.0/settings
}

do_install:append:armarch() {
	echo -e "--gpu-context=wayland\n--hwdec=v4l2m2m\n" > ${D}${RETRO_USER_HOMEDIR}/.config/mpv/mpv.conf
}

do_install:append:x86arch() {
	echo -e "--gpu-context=wayland\n--hwdec=vaapi\n" > ${D}${RETRO_USER_HOMEDIR}/.config/mpv/mpv.conf
}

do_install:append() {
	chown ${RETRO_USER_NAME}:${RETRO_USER_NAME} -R ${D}${RETRO_USER_HOMEDIR}
}

FILES:${PN} = "${RETRO_USER_HOMEDIR} ${ROOT_HOME}"

INSANE_SKIP:${PN} = "host-user-contaminated"

