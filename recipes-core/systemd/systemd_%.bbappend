FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
	file://00-create-volatile.conf \
	file://getty@.service \	
"

do_install:append() {
	install -m 0644 ${WORKDIR}/getty@.service ${D}${systemd_unitdir}/system
}
