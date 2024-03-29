LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit retro-user retro-overrides

SRC_URI = " \
	file://azotebg \
	file://bashrc \
	file://kodi/kodi-addon-pvr-iptvsimple/settings.xml \
	file://swappy/config \
	file://sway/config \
	file://sway/outputs \
	file://sway/scripts/chromium.sh \
	file://sway/scripts/flathub.sh \
	file://sway/scripts/kodi.sh \
	file://sway/scripts/retroarch.sh \
	file://sway/scripts/thunar.sh \
	file://sway/scripts/geary.sh \
	file://sway/scripts/rotate_workspaces.sh \
	file://foot/foot.ini \
	file://nwg-launchers/nwgbar/bar.json \
	file://nwg-launchers/nwggrid/terminal \
	file://nwg-launchers/nwggrid/grid.conf \
	file://waybar/config \
	file://waybar/style.css \
	file://waybar/scripts/launch.sh \
	file://waybar/scripts/waybar.sh \
	file://waybar/scripts/pulse.sh \
	file://waybar/scripts/net.sh \
	file://waybar/scripts/processes.sh \
	file://waybar/scripts/resources.sh \
	file://waybar/scripts/blueman-manager.sh \
	file://bash_profile \
	file://mimeapps.list \
	file://nwg-look/gsettings \
"

RRECOMMENDS:${PN} = " \
	autotiling-rs \
	capitaine-cursors \
	netcat \
	nwg-launchers \
	nwg-shell-wallpapers \
	waybar \
	nordic-darker-theme \
	tela-circle-icon-theme \
	xdg-user-dirs \
	xdg-desktop-portal \
"	
	
do_install() {
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/foot
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/mpv/
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/nwg-launchers/nwgbar
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/nwg-launchers/nwggrid
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/samba
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/swappy
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/systemd/user
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts
	install -d ${D}${RETRO_USER_HOMEDIR}/Downloads
	install -d ${D}${RETRO_USER_HOMEDIR}/.kodi/userdata/addon_data/pvr.iptvsimple
	install -d ${D}${RETRO_USER_HOMEDIR}/.local/share/applications
	install -d ${D}${RETRO_USER_HOMEDIR}/.local/share/nwg-look
	install -m 0644 ${WORKDIR}/bash_profile ${D}${RETRO_USER_HOMEDIR}/.bash_profile
	install -m 0644 ${WORKDIR}/bashrc ${D}${RETRO_USER_HOMEDIR}/.bashrc
	install -m 0644 ${WORKDIR}/foot/foot.ini ${D}${RETRO_USER_HOMEDIR}/.config/foot/foot.ini
	install -m 0644 ${WORKDIR}/kodi/kodi-addon-pvr-iptvsimple/settings.xml ${D}${RETRO_USER_HOMEDIR}/.kodi/userdata/addon_data/pvr.iptvsimple
	install -m 0644 ${WORKDIR}/mimeapps.list ${D}${RETRO_USER_HOMEDIR}/.config
	install -m 0644 ${WORKDIR}/nwg-launchers/nwgbar/bar.json ${D}${RETRO_USER_HOMEDIR}/.config/nwg-launchers/nwgbar
	install -m 0644 ${WORKDIR}/nwg-launchers/nwggrid/grid.conf ${D}${RETRO_USER_HOMEDIR}/.config/nwg-launchers/nwggrid
	install -m 0644 ${WORKDIR}/nwg-launchers/nwggrid/terminal ${D}${RETRO_USER_HOMEDIR}/.config/nwg-launchers/nwggrid
	install -m 0644 ${WORKDIR}/nwg-look/gsettings ${D}${RETRO_USER_HOMEDIR}/.local/share/nwg-look
	install -m 0644 ${WORKDIR}/swappy/config ${D}${RETRO_USER_HOMEDIR}/.config/swappy
	install -m 0644 ${WORKDIR}/sway/config ${D}${RETRO_USER_HOMEDIR}/.config/sway
	install -m 0644 ${WORKDIR}/sway/outputs ${D}${RETRO_USER_HOMEDIR}/.config/sway
	install -m 0644 ${WORKDIR}/waybar/config ${D}${RETRO_USER_HOMEDIR}/.config/waybar/config
	install -m 0644 ${WORKDIR}/waybar/style.css ${D}${RETRO_USER_HOMEDIR}/.config/waybar/style.css
	install -m 0755 ${WORKDIR}/azotebg ${D}${RETRO_USER_HOMEDIR}/.azotebg
	install -m 0755 ${WORKDIR}/sway/scripts/chromium.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts	
	install -m 0755 ${WORKDIR}/sway/scripts/geary.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts
	install -m 0755 ${WORKDIR}/sway/scripts/flathub.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts
	install -m 0755 ${WORKDIR}/sway/scripts/kodi.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts	
	install -m 0755 ${WORKDIR}/sway/scripts/retroarch.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts
	install -m 0755 ${WORKDIR}/sway/scripts/rotate_workspaces.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts
	install -m 0755 ${WORKDIR}/sway/scripts/thunar.sh ${D}${RETRO_USER_HOMEDIR}/.config/sway/scripts
	install -m 0755 ${WORKDIR}/waybar/scripts/blueman-manager.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts
	install -m 0755 ${WORKDIR}/waybar/scripts/launch.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts
	install -m 0755 ${WORKDIR}/waybar/scripts/net.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts
	install -m 0755 ${WORKDIR}/waybar/scripts/processes.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts
	install -m 0755 ${WORKDIR}/waybar/scripts/pulse.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts
	install -m 0755 ${WORKDIR}/waybar/scripts/resources.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts
	install -m 0755 ${WORKDIR}/waybar/scripts/waybar.sh ${D}${RETRO_USER_HOMEDIR}/.config/waybar/scripts/waybar.sh
	ln -sf ${RETRO_USER_HOMEDIR}/.config/mimeapps.list ${D}${RETRO_USER_HOMEDIR}/.local/share/applications/mimeapps.list
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
	echo "--scripts=${libdir}/mpv/scripts/mpris.so" >> ${D}${RETRO_USER_HOMEDIR}/.config/mpv/mpv.conf
	chown ${RETRO_USER_NAME}:${RETRO_USER_NAME} -R ${D}${RETRO_USER_HOMEDIR}
}

FILES:${PN} = "${RETRO_USER_HOMEDIR}"

INSANE_SKIP:${PN} = "host-user-contaminated"

