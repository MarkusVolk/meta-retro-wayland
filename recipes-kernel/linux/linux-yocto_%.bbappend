FILESEXTRAPATHS:prepend := "${THISDIR}/linux-yocto:"

SRC_URI:append = " \
    file://fs.cfg \
    file://gpio-sysfs.cfg \
    file://gamepad.cfg \
    file://nfsd.cfg \
    file://wlan.cfg \
    file://i2c.cfg \
    file://touchpad.cfg \
    file://linux-020-eld-constraints-for-compressed-formats.patch \
    file://linux-051-ouya_controller_support.patch \
    file://linux-058.05-hid_sony-add_autorepeat_for_PS3_remotes.patch \
    file://linux-062-imon_pad_ignore_diagonal.patch \
    file://linux-999.02-0001-pm-disable-async-suspend-resume-by-default.patch \
    file://linux-999-no-lzma-in-x86-perf-build.patch \
"

