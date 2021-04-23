FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append += "file://nanorc"

RDEPENDS_${PN}_append += "nano-syntax-highlighting"

do_install_append() {
	# provided by nano-syntax-highlighting
	rm -rf ${D}${datadir}/nano/*.nanorc
	# use custom nanorc
	install -d ${D}/${sysconfdir}
	install -m 644 ${WORKDIR}/nanorc ${D}${sysconfdir}
}

