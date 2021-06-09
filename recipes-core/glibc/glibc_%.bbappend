FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
	file://tls-change-the-max_align-to-64U.patch \
"

