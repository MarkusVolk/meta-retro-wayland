LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit retro-user

SRC_URI = " \
	file://azotebg \
	file://bashrc \
	file://sway/config \
	file://sway/scripts/chromium.sh \
	file://sway/scripts/kodi.sh \
	file://sway/scripts/retroarch.sh \
	file://sway/scripts/thunar.sh \
	file://profile \
	file://automountd \
	file://automount.service \
	file://99-udisks2.rules \
	file://media.conf \
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
	install -d ${D}/home/root/.config/glib-2.0/settings
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/connman
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/mpv/
	install -d ${D}${sysconfdir}/udev/scripts
	install -d ${D}${sysconfdir}/udev/rules.d
	install -d ${D}${sysconfdir}/tmpfiles.d
	install -d ${D}${systemd_system_unitdir}/sysinit.target.wants
	install -m 0644 ${WORKDIR}/bashrc ${D}${RETRO_USER_HOMEDIR}/.bashrc
	install -m 0644 ${WORKDIR}/profile ${D}${RETRO_USER_HOMEDIR}/.profile
	install -m 0644 ${WORKDIR}/sway/config ${D}${RETRO_USER_HOMEDIR}/.config/sway
	install -m 0755 ${WORKDIR}/sway/scripts/chromium.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts	
	install -m 0755 ${WORKDIR}/sway/scripts/kodi.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts	
	install -m 0755 ${WORKDIR}/sway/scripts/retroarch.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts
	install -m 0755 ${WORKDIR}/sway/scripts/thunar.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts	
	install -m 0755 ${WORKDIR}/automountd ${D}${sysconfdir}/udev/scripts
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
	install -m 0644 ${WORKDIR}/automount.service ${D}${systemd_system_unitdir}
	ln -sf ${systemd_system_unitdir}/automount.service ${D}${systemd_system_unitdir}/sysinit.target.wants
	install -m 0644 ${WORKDIR}/99-udisks2.rules ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/media.conf ${D}${sysconfdir}/tmpfiles.d
	install -m 0644 ${WORKDIR}/glib-2.0/settings/keyfile ${D}${RETRO_USER_HOMEDIR}/.config/glib-2.0/settings
	install -m 0644 ${WORKDIR}/glib-2.0/settings/keyfile ${D}/home/root/.config/glib-2.0/settings
	echo -e "--gpu-context=wayland\n--hwdec=v4l2m2m\n" > ${D}${RETRO_USER_HOMEDIR}/.config/mpv/mpv.conf
	chown ${RETRO_USER_NAME}:${RETRO_USER_NAME} -R ${D}${RETRO_USER_HOMEDIR}
}

FILES:${PN} = "${sysconfdir} ${RETRO_USER_HOMEDIR} /home/root ${systemd_system_unitdir}"

INSANE_SKIP:${PN} = "host-user-contaminated"

