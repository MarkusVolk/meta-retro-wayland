FILESEXTRAPATHS:prepend := "${THISDIR}/raspberrypi:"

SRC_URI:append = " \
    file://0001-nintendo-switch-driver.patch \
    file://fs.cfg \
    file://gpio-sysfs.cfg \
    file://gamepad.cfg \
    file://nfsd.cfg \
    file://wlan.cfg \
    file://i2c.cfg \
"

