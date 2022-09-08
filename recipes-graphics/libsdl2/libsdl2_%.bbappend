inherit retro-overrides

PACKAGECONFIG:append = " libusb libdecor pipewire"
PACKAGECONFIG:append:armarch = " arm-neon"

