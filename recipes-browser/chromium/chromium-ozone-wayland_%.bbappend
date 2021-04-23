FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PACKAGECONFIG_append = " impl-side-painting proprietary-codecs"

SRC_URI_append = " \
	file://chromium-glibc-2-33.patch \
"

inherit ccache

