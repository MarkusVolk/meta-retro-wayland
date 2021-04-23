SUMMARY = "A Wayland WM"
HOMEPAGE = "https://github.com/WayfireWM/wayfire"
BUGTRACKER = "https://github.com/WayfireWM/wayfire/issues"
SECTION = "graphics"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=14e4594093363e3c3a530e9b54cb5285"

REQUIRED_DISTRO_FEATURES = "wayland systemd"

DEPENDS += "wlroots\
            freetype \
            glm \
            cairo \
            libdrm \
            libevdev \
            mesa \
            libinput \
            jpeg \
            libpng \
            libxkbcommon \
            libxml2 \
            pixman \
            wf-config \
            wayland \
            wayland-protocols \
            wayland-native \
           "

RRECOMMENDS_${PN} += " \
	wcm \
	wf-config \
	wf-recorder \
	wf-shell \
"

SRC_URI = "https://github.com/WayfireWM/wayfire/releases/download/v${PV}/wayfire-${PV}.tar.xz"
SRC_URI[sha256sum] = "0d8ec311510bf10647d857c2db6e3dbbccfe3ac9064463661c8062c8cbb469a6"

S = "${WORKDIR}/${PN}-${PV}"

inherit meson pkgconfig features_check

EXTRA_OEMESON += "--buildtype release"

FILES_${PN}_append += "${datadir}"

BBCLASSEXTEND = ""

