FILESEXTRAPATHS_prepend := "${THISDIR}/qtwebengine:"

inherit ccache

SRC_URI_append = " \
	file://0001-qtwebengine-set-user-agent.patch \
	file://chromium/0004-enable-openmax.patch;patchdir=src/3rdparty \
	file://chromium/0005-mediahost.patch;patchdir=src/3rdparty;apply=no \
"

#SRCREV_qtwebengine = "a059e7404a6db799f4da0ad696e65ae9c854b4b0"
#SRCREV_chromium = "79f989b810053095020e3a9d937c3d9cb6091dac"

PACKAGECONFIG_append += "libwebp opus ffmpeg proprietary-codecs pepper-plugins webrtc glib zlib libevent"

DEPENDS_append = "libnss-mdns libwebp-native lcms libopus"


