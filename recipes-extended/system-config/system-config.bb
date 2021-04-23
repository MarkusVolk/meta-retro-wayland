LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit retro-user

DEPENDS += "retro-user"

SRC_URI = " \
	file://bashrc \
	file://sway/config \
	file://sway/scripts/chromium.sh \
	file://sway/scripts/kodi.sh \
	file://sway/scripts/retroarch.sh \
	file://sway/scripts/thunar.sh \
	file://profile \
	file://10-disable-suspend.rules \
	file://10-wifimanagement.rules \
	file://49-nopasswd_global.rules \
	file://automountd \
	file://automount.service \
	file://99-udisks2.rules \
	file://media.conf \
	file://retro.jpg \
	file://waybar/config \
	file://waybar/waybar.sh \
	file://waybar/pulse.sh \
	file://waybar/net.sh \
	file://waybar/gparted.sh \
	file://waybar/monitor.sh \
"
	
	
do_install() {
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/sway/wallpaper
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/systemd/user
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/samba
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/connman
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/waybar
	install -d ${D}${sysconfdir}/polkit-1/rules.d
	install -d ${D}${sysconfdir}/udev/scripts
	install -d ${D}${sysconfdir}/udev/rules.d
	install -d ${D}${sysconfdir}/tmpfiles.d
	install -d ${D}${sysconfdir}/xdg/waybar	
	install -d ${D}${systemd_system_unitdir}/sysinit.target.wants
	install -m 0644 ${WORKDIR}/bashrc ${D}${RETRO_USER_HOMEDIR}/.bashrc
	install -m 0644 ${WORKDIR}/profile ${D}${RETRO_USER_HOMEDIR}/.profile
	install -m 0644 ${WORKDIR}/sway/config ${D}${RETRO_USER_HOMEDIR}/.config/sway
	install -m 0755 ${WORKDIR}/sway/scripts/chromium.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts	
	install -m 0755 ${WORKDIR}/sway/scripts/kodi.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts	
	install -m 0755 ${WORKDIR}/sway/scripts/retroarch.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts
	install -m 0755 ${WORKDIR}/sway/scripts/thunar.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts	
	install -m 0644 ${WORKDIR}/retro.jpg ${D}${RETRO_USER_HOMEDIR}/.config/sway/wallpaper
	install -m 0644 ${WORKDIR}/10-disable-suspend.rules ${D}${sysconfdir}/polkit-1/rules.d
	install -m 0644 ${WORKDIR}/10-wifimanagement.rules ${D}${sysconfdir}/polkit-1/rules.d
	install -m 0644 ${WORKDIR}/49-nopasswd_global.rules ${D}${sysconfdir}/polkit-1/rules.d
	install -m 0755 ${WORKDIR}/automountd ${D}${sysconfdir}/udev/scripts
	install -m 0644 ${WORKDIR}/waybar/config ${D}${sysconfdir}/xdg/waybar/config
	install -m 0755 ${WORKDIR}/waybar/waybar.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar/waybar.sh
	install -m 0755 ${WORKDIR}/waybar/pulse.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar	
	install -m 0755 ${WORKDIR}/waybar/net.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar
	install -m 0755 ${WORKDIR}/waybar/gparted.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar
	install -m 0755 ${WORKDIR}/waybar/monitor.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar
	install -m 0644 ${WORKDIR}/automount.service ${D}${systemd_system_unitdir}
	ln -sf ${systemd_system_unitdir}/automount.service ${D}${systemd_system_unitdir}/sysinit.target.wants
	install -m 0644 ${WORKDIR}/99-udisks2.rules ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/media.conf ${D}${sysconfdir}/tmpfiles.d
	chown ${RETRO_USER_NAME}:${RETRO_USER_NAME} -R ${D}${RETRO_USER_HOMEDIR}
}


FILES_${PN} = "${sysconfdir} ${RETRO_USER_HOMEDIR} ${systemd_system_unitdir}"

INSANE_SKIP_${PN} = "host-user-contaminated"
