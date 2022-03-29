FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://nfsd.cfg \
    file://gpio-sysfs.cfg \
"

