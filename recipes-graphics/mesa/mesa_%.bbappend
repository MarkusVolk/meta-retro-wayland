SRC_URI = " \
	git://github.com/mesa3d/mesa.git;protocol=https;branch=main \
	file://0001-meson.build-check-for-all-linux-host_os-combinations.patch \
	file://0002-meson.build-make-TLS-ELF-optional.patch \
	file://0001-meson-misdetects-64bit-atomics-on-mips-clang.patch \
	file://0001-futex.h-Define-__NR_futex-if-it-does-not-exist.patch \
"

PV = "dev+${SRCREV}"
SRCREV = "c2d522b07f9a7c719eef1b4ebea3cc5975bbe15a"
S = "${WORKDIR}/git"

inherit retro-overrides

PACKAGECONFIG:remove:armarch = "vdpau"
PACKAGECONFIG:remove:rockchip = "va"
PACKAGECONFIG:append = " kmsro"
PACKAGECONFIG:append = " dri3 vulkan"

VULKAN_DRIVERS:append:rpi = ",broadcom"
VULKAN_DRIVERS:append:rockchip = ",panfrost"
