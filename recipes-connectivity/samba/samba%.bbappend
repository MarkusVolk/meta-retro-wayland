FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

RDEPENDS:${PN}:append += "glibc-gconv-ibm850"

SRC_URI:append = " \
	file://samba \
	file://smb.conf \
"

do_install:append() {
	install -d ${D}${sysconfdir}/pam.d
	install -m 0644 ${WORKDIR}/samba ${D}${sysconfdir}/pam.d
	sed -i "s|\/var\/run|\/run|" ${D}/etc/tmpfiles.d/samba.conf
	sed -i "s|guest account = user|guest account = ${RETRO_USER_NAME}|" ${WORKDIR}/smb.conf
	sed -i "s|path = path|path = \/home\/${RETRO_USER_NAME}|" ${WORKDIR}/smb.conf
	sed -i "s|force user = user|force user = ${RETRO_USER_NAME}|" ${WORKDIR}/smb.conf
	install -m 644 ${WORKDIR}/smb.conf ${D}${sysconfdir}/samba/
}

inherit retro-user

pkg_postinst_ontarget:${PN}() {
#!/bin/sh

pdbedit -L | grep ${RETRO_USER_NAME} >> /dev/null || smbpasswd -n -a ${RETRO_USER_NAME}
}

