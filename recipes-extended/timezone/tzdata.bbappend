do_install_append() {
	ln -sf ${datadir}/zoneinfo/Europe/Berlin ${D}${sysconfdir}/localtime
}
