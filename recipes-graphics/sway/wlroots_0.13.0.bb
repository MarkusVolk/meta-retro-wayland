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
            systemd \
            udev \
            virtual/egl \
            wayland \
            wayland-native \
            wayland-protocols \
           "

SRC_URI = "https://github.com/swaywm/wlroots/releases/download/${PV}/wlroots-${PV}.tar.gz"
SRC_URI[sha256sum] = "f6bea37fd4a6f5e5f552b83d61adae8c73e64b0bcb9ae0ab464ebcd9309d3cf3"

S = "${WORKDIR}/wlroots-${PV}"

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

