FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

PACKAGECONFIG:append = " proprietary-codecs use-vaapi"

inherit ccache

SRC_URI:append = " \
	file://0013-linux-sandbox-syscall-broker-use-struct-kernel_stat.patch \
	file://0014-linux-sandbox-fix-fstatat-crash.patch \
"

SRC_URI:remove = "    file://0012-Fix-font-rendering-with-glibc-2.33.patch \"

GN_ARGS += "use_custom_libcxx=true"

