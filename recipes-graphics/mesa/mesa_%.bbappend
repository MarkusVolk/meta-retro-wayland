VULKAN_DRIVERS:append:rpi = ",broadcom"
VULKAN_DRIVERS:append:rockchip = ",panfrost"
PACKAGECONFIG:append:x86:class-target = " va gallium-llvm r600 dri3"
PACKAGECONFIG:append:x86-64:class-target = " va gallium-llvm r600 dri3"

EXTRA_OEMESON += "-Dvideo-codecs=vc1dec,h264dec,h264enc,h265dec,h265enc"
