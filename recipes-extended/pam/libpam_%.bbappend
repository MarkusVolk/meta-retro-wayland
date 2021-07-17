inherit retro-overrides

do_install_append() {
	echo "LANG=en_US.UTF-8" >> ${D}${sysconfdir}/environment
	echo "LC_ALL=en_US.UTF-8" >> ${D}${sysconfdir}/environment
	echo "XKB_DEFAULT_LAYOUT=de" >> ${D}${sysconfdir}/environment
	echo "TERM=xterm" >> ${D}${sysconfdir}/environment
	echo "XDG_RUNTIME_DIR=/run/user/1000" >> ${D}${sysconfdir}/environment
	echo "QT_QPA_FONTDIR=/usr/share/fonts" >> ${D}${sysconfdir}/environment
	echo "QT_LOGGING_RULES=qt.qpa.*=true" >> ${D}${sysconfdir}/environment
	echo "SDL_VIDEODRIVER=wayland" >> ${D}${sysconfdir}/environment
	echo "LIBC_WIDEVINE_PATCHLEVEL=1" >> ${D}${sysconfdir}/environment
}

do_install_append_armarch() {
	echo "MALLOC_MMAP_THRESHOLD_=8192" >> ${D}${sysconfdir}/environment
}

do_install_append_x86arch() {
	echo "MALLOC_MMAP_THRESHOLD_=524288" >> ${D}${sysconfdir}/environment
}
