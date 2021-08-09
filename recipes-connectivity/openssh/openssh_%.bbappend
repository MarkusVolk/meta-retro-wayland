
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://sshd_config \
	    file://sshd_banner \
	    file://sshd.socket \
	    file://sshd_check_keys \
"

DEPENDS:append += "libpam"

# no compile problems with uclibc here. therefore overriding default bb settings
EXTRA_OECONF:append = " --with-pam"

do_install:append () {
	sed -i "s|yocto|${MACHINE}|" ${WORKDIR}/sshd_banner
	install -m 0600 ${WORKDIR}/sshd_banner ${D}${sysconfdir}/ssh/sshd_banner
}

FILES:${PN}-sshd += "${sysconfdir}/ssh/sshd_banner"

pkg_postinst_ontarget:${PN} () {
	chmod 700 /etc/ssh
}
