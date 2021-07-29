FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append += "file://user-dirs.defaults"

do_install_append() {
	install -m 644 ${WORKDIR}/user-dirs.defaults ${D}${sysconfdir}/xdg
}

