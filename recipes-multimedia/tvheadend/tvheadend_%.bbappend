FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit python3native

SRC_URI:append = "file://tvheadend.service"

do_install:append() {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/tvheadend.service ${D}${systemd_unitdir}/system
}

FILES:${PN} += "${systemd_unitdir}"

