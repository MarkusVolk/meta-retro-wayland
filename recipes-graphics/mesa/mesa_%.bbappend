VULKAN_DRIVERS:append:rpi = ",broadcom"
VULKAN_DRIVERS:append:rockchip = ",panfrost"
PACKAGECONFIG:append:x86:class-target = " va gallium-llvm"
PACKAGECONFIG:append:x86-64:class-target = " va gallium-llvm"
