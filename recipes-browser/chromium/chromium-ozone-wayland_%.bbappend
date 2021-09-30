FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

PACKAGECONFIG:append = " proprietary-codecs use-vaapi"

inherit ccache

GN_ARGS += "use_custom_libcxx=true"

