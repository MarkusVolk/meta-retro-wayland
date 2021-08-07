
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://proftpd.conf"

do_install:append () {
	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/proftpd.conf ${D}${sysconfdir}
}

FILES_${PN} += "${sysconfdir}/proftpd.conf"

