PACKAGECONFIG_append += "lua egl drm gbm openal sdl2 shared zimg"

inherit retro-user

do_install_append() {
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/mpv
	echo -e "--gpu-context=wayland\n--hwdec=v4l2m2m\n" > ${D}${RETRO_USER_HOMEDIR}/.config/mpv/mpv.conf
	chown ${RETRO_USER_NAME} -R ${D}${RETRO_USER_HOMEDIR}
}

FILES_${PN} += "${RETRO_USER_HOMEDIR}"
	
INSANE_SKIP_${PN} = "host-user-contaminated"

