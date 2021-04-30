SUMMARY = "A modular Wayland compositor library"
DESCRIPTION = "Pluggable, composable, unopinionated modules for building a \
               Wayland compositor; or about 50,000 lines of code you were \
               going to write anyway"
AUTHOR = ""
HOMEPAGE = "https://github.com/swaywm/wlroots"
BUGTRACKER = "https://github.com/swaywm/wlroots/issues"
SECTION = "graphics"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=7578fad101710ea2d289ff5411f1b818"

REQUIRED_DISTRO_FEATURES = "wayland systemd"

DEPENDS += "cmake-native \
            libdrm \
            libinput \
            libxkbcommon \
            pixman \
            seatd \
            systemd \
            udev \
            virtual/egl \
            wayland \
            wayland-native \
            wayland-protocols \
           "

SRC_URI = "git://github.com/swaywm/wlroots.git;protocol=https"
SRCREV = "c85789a3a9f6f851e6fbc900495057ba91b3e255"
PV = "0.13+${SRCREV}"

S = "${WORKDIR}/git"

inherit meson pkgconfig features_check

EXTRA_OEMESON += "--buildtype release"

do_configure_prepend() {
    export WLR_BACKENDS="drm,libinput,wayland"
}

FILES_${PN} = "${bindir} \
               ${libdir} \
              "

FILES_${PN}-dev = "${includedir} \
                   /usr/src/ \
                   ${libdir}/libwlroots.so \
"

BBCLASSEXTEND = ""

