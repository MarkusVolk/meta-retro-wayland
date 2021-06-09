FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PACKAGECONFIG_append = " impl-side-painting proprietary-codecs"

inherit ccache

