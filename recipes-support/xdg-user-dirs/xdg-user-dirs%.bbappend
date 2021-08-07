FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append += "file://user-dirs.defaults"

do_install:append() {
	install -m 644 ${WORKDIR}/user-dirs.defaults ${D}${sysconfdir}/xdg
}

