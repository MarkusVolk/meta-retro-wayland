FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = "file://tvheadend.service"

EXTRA_OECONF = "--arch=${TARGET_ARCH} \
		--enable-nvenc \
		--enable-cardclient \
		--enable-mmal \
		--enable-ffmpeg \
		--disable-ffmpeg_static \
		--enable-inotify \
		--enable-pcre2 \
		--enable-uriparser \
		--enable-tvhcsa \
		--enable-bundle \
		--enable-dvbcsa \
		--enable-kqueue \
		--enable-libvpx \
		--enable-libopus \
		--enable-ddci \
		--python=python3 \
                 "


do_install:append() {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/tvheadend.service ${D}${systemd_unitdir}/system
}

FILES_${PN} += "${systemd_unitdir}"

