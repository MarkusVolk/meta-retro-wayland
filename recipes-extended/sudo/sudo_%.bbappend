do_install:append() {
	sed -i "s|# %sudo	ALL=(ALL) ALL|%sudo ALL=(ALL) NOPASSWD: ALL|" ${D}${sysconfdir}/sudoers
}

