FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

RDEPENDS_${PN}_append += "glibc-gconv-ibm850"

SRC_URI_append = " \
	file://samba \
	file://smb.conf \
"

do_install_append() {
	install -d ${D}${sysconfdir}/pam.d
	install -m 0644 ${WORKDIR}/samba ${D}${sysconfdir}/pam.d
	sed -i "s|\/var\/run|\/run|" ${D}/etc/tmpfiles.d/samba.conf
	install -m 644 ${WORKDIR}/smb.conf ${D}${sysconfdir}/samba/
}

pkg_postinst_ontarget_${PN}() {
#!/bin/sh

pdbedit -L | grep root >> /dev/null || smbpasswd -n -a root
}

