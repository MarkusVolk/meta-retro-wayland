PV = "21.2.3"
SRC_URI[sha256sum] = "7245284a159d2484770e1835a673e79e4322a9ddf43b17859668244946db7174"
SRC_URI:remove = "           file://without-neon.patch \"


inherit retro-overrides

PACKAGECONFIG:remove:armarch = "vdpau"
PACKAGECONFIG:remove:rockchip = "va"
PACKAGECONFIG:append = " kmsro"
PACKAGECONFIG:append = " dri3 vulkan"

VULKAN_DRIVERS:append:rpi = ",broadcom"

