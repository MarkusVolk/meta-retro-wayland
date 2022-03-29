inherit retro-user

do_configure:prepend() {
	sed -i 's|media_dir=\/opt|media_dir=\/media|' ${S}/minidlna.conf
	sed -i 's|#user=jmaggard|user=${RETRO_USER_NAME}|' ${S}/minidlna.conf
	sed -i 's|#db_dir=\/var\/cache\/minidlna|db_dir=\/home\/${RETRO_USER_NAME}\/.minidlna|' ${S}/minidlna.conf
	sed -i 's|#log_dir=\/var\/log|log_dir=\/home\/${RETRO_USER_NAME}\/.minidlna|' ${S}/minidlna.conf
}

do_install:append() {
	# fix service start
	sed -i 's|Type=notify|Type=forking|' ${D}${systemd_system_unitdir}/minidlna.service
	sed -i 's|ExecStart=.*|ExecStart=\/usr\/sbin\/minidlnad -f \/etc\/minidlna.conf -P \/var\/run\/minidlna.pid|' \
		${D}${systemd_system_unitdir}/minidlna.service
	# .bb installs files with wrong permissions
	chmod 0644 ${D}${sysconfdir}/minidlna.conf
	chmod 0644 ${D}${systemd_system_unitdir}/minidlna.service
	# run as user
	install -d ${D}${systemd_system_unitdir}/minidlna.service.d
	echo "[Service]" > ${D}${systemd_system_unitdir}/minidlna.service.d/run-as-user.conf
	echo "User=${RETRO_USER_NAME}" >> ${D}${systemd_system_unitdir}/minidlna.service.d/run-as-user.conf
	echo "Group=${RETRO_USER_NAME}" >> ${D}${systemd_system_unitdir}/minidlna.service.d/run-as-user.conf
	echo "PIDFile=/var/run/minidlna.pid" >> ${D}${systemd_system_unitdir}/minidlna.service.d/run-as-user.conf
	echo "ProtectHome=off" >> ${D}${systemd_system_unitdir}/minidlna.service.d/run-as-user.conf
}

FILES:${PN} += "${systemd_system_unitdir}"

