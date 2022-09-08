FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://fs.cfg \
    file://gpio-sysfs.cfg \
    file://gamepad.cfg \
    file://nfsd.cfg \
    file://wlan.cfg \
    file://i2c.cfg \
"

