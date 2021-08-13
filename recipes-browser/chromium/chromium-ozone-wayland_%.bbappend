FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

PACKAGECONFIG:append = " proprietary-codecs"
PV = "92.0.4515.107"

inherit ccache

SRC_URI:append = " \
	file://0012-extend-enable-accelerated-video-decode-flag.patch \
	file://0013-linux-sandbox-syscall-broker-use-struct-kernel_stat.patch \
	file://0014-linux-sandbox-fix-fstatat-crash.patch \
	file://0015-make-GetUsableSize-handle-nullptr-gracefully.patch \
"

SRC_URI:remove = "    file://0012-Fix-font-rendering-with-glibc-2.33.patch \"

