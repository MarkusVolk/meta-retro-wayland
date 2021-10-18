PV = "21.2.4"
SRC_URI[sha256sum] = "fe6ede82d1ac02339da3c2ec1820a379641902fd351a52cc01153f76eff85b44"
SRC_URI:remove = "           file://without-neon.patch \"


inherit retro-overrides

PACKAGECONFIG:remove:armarch = "vdpau"
PACKAGECONFIG:remove:rockchip = "va"
PACKAGECONFIG:append = " kmsro"
PACKAGECONFIG:append = " dri3 vulkan"

VULKAN_DRIVERS:append:rpi = ",broadcom"
VULKAN_DRIVERS:append:rockchip = ",panfrost"
