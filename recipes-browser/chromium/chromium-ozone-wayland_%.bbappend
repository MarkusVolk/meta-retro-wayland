FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PACKAGECONFIG_append = " proprietary-codecs"

inherit ccache

