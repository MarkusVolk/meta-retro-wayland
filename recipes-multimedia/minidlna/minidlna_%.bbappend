FILESEXTRAPATHS_prepend := "${THISDIR}/minidlna:"

do_configure_prepend() {
	sed -i 's|media_dir=\/opt|media_dir=\/media|' ${S}/minidlna.conf
}
