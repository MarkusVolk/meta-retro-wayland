FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://nanorc"

RDEPENDS:${PN}:append = " nano-syntax-highlighting"

do_install:append() {
	# provided by nano-syntax-highlighting
	rm -rf ${D}${datadir}/nano/*.nanorc
	# use custom nanorc
	install -d ${D}/${sysconfdir}
	install -m 644 ${WORKDIR}/nanorc ${D}${sysconfdir}
}

