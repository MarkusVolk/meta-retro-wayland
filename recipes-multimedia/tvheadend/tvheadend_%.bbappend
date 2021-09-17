FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = "file://tvheadend.service"

SRCREV = "8fc2dfa7e1b1b3b1e8ba6f78cd4a81f77fa6a736"

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

FILES:${PN} += "${systemd_unitdir}"

