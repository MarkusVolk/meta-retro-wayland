inherit retro-overrides

PACKAGECONFIG:append = " libusb kmsdrm libdecor pipewire"
PACKAGECONFIG:append:armarch = " arm-neon"

