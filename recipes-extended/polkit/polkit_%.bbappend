FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
	file://10-disable-suspend.rules \
	file://10-wifimanagement.rules \
	file://49-nopasswd_global.rules \
"

do_install:append() {	
	install -m 0644 ${WORKDIR}/10-disable-suspend.rules ${D}${sysconfdir}/polkit-1/rules.d
	install -m 0644 ${WORKDIR}/10-wifimanagement.rules ${D}${sysconfdir}/polkit-1/rules.d
	install -m 0644 ${WORKDIR}/49-nopasswd_global.rules ${D}${sysconfdir}/polkit-1/rules.d
}

