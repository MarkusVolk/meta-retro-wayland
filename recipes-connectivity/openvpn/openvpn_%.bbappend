do_install:append() {
	mv ${D}${sbindir} ${D}${bindir}
}

