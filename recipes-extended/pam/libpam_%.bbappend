do_install:append() {
	echo "COLORTERM=truecolor" >> ${D}${sysconfdir}/environment
	echo "FORTUNE_FILE=/usr/share/fortunes/fortunes" >> ${D}${sysconfdir}/environment
	echo "LANG=en_US.UTF-8" >> ${D}${sysconfdir}/environment
	echo "LC_ALL=en_US.UTF-8" >> ${D}${sysconfdir}/environment
	echo "SDL_VIDEODRIVER=wayland" >> ${D}${sysconfdir}/environment
	echo "SHELL=/bin/bash" >> ${D}${sysconfdir}/environment
	echo "TERM=foot" >> ${D}${sysconfdir}/environment
	echo "XDG_CONFIG_DIRS=/etc/xdg/" >> ${D}${sysconfdir}/environment
	echo "XDG_DATA_DIRS=/usr/share" >> ${D}${sysconfdir}/environment
	echo "XDG_RUNTIME_DIR=/run/user/1000" >> ${D}${sysconfdir}/environment
	echo "XDG_SESSION_CLASS=user" >> ${D}${sysconfdir}/environment
	echo "XDG_SESSION_TYPE=wayland" >> ${D}${sysconfdir}/environment
	echo "XKB_DEFAULT_LAYOUT=de" >> ${D}${sysconfdir}/environment
}

do_install:append:arm() {
	echo "MALLOC_MMAP_THRESHOLD_=8192" >> ${D}${sysconfdir}/environment
}
do_install:append:aarch64() {
	echo "MALLOC_MMAP_THRESHOLD_=8192" >> ${D}${sysconfdir}/environment
}

do_install:append:x86() {
	echo "MALLOC_MMAP_THRESHOLD_=524288" >> ${D}${sysconfdir}/environment
}

do_install:append:x86-64() {
	echo "MALLOC_MMAP_THRESHOLD_=524288" >> ${D}${sysconfdir}/environment
}

