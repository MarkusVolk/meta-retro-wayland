FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

inherit retro-overrides

SRC_URI_append_armarch = " \
	file://glibc-add-support-for-SHT_RELR-sections.patch \
	file://tls-change-the-max_align-to-64U.patch \
"

