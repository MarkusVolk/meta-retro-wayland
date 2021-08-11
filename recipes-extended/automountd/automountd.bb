LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-2-Clause;md5=cb641bc04cda31daea161b1bc15da69f"

SRC_URI = " \
	file://automountd \
	file://automount.service \
	file://99-udisks2.rules \
	file://media.conf \
"

RDEPENDS:${PN} = " \
	udev \
	udisks2 \
	polkit \
"	

do_install() {
	install -d ${D}${sysconfdir}/udev/scripts
	install -d ${D}${sysconfdir}/udev/rules.d
	install -d ${D}${sysconfdir}/tmpfiles.d
	install -d ${D}${systemd_system_unitdir}/sysinit.target.wants
	install -m 0755 ${WORKDIR}/automountd ${D}${sysconfdir}/udev/scripts
	install -m 0644 ${WORKDIR}/automount.service ${D}${systemd_system_unitdir}
	ln -sf ${systemd_system_unitdir}/automount.service ${D}${systemd_system_unitdir}/sysinit.target.wants
	install -m 0644 ${WORKDIR}/99-udisks2.rules ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/media.conf ${D}${sysconfdir}/tmpfiles.d
}

FILES:${PN} = "${sysconfdir} ${systemd_system_unitdir}"

