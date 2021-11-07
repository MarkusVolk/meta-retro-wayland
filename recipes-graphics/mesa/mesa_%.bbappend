SRC_URI = " \
	git://github.com/mesa3d/mesa.git;protocol=https;branch=21.3 \
	file://0001-meson.build-check-for-all-linux-host_os-combinations.patch \
	file://0002-meson.build-make-TLS-ELF-optional.patch \
	file://0001-meson-misdetects-64bit-atomics-on-mips-clang.patch \
	file://0001-futex.h-Define-__NR_futex-if-it-does-not-exist.patch \
"

PV = "21.3.0-rc4"
SRCREV = "mesa-${PV}"
S = "${WORKDIR}/git"

inherit retro-overrides

PACKAGECONFIG:remove:armarch = "vdpau"
PACKAGECONFIG:remove:rockchip = "va"
PACKAGECONFIG:append = " kmsro"
PACKAGECONFIG:append = " dri3"

VULKAN_DRIVERS:append:rpi = ",broadcom"
VULKAN_DRIVERS:append:rockchip = ",panfrost"
