SUMMARY = "A Wayland WM"
HOMEPAGE = "https://github.com/WayfireWM/wf-config"
BUGTRACKER = "https://github.com/WayfireWM/wf-config/issues"
SECTION = "graphics"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=e165ae90e5190201fda9741b611f9378"

DEPENDS = " \
	glm \
	libevdev \
	libxml2 \
"

REQUIRED_DISTRO_FEATURES = "wayland"

SRC_URI = "https://github.com/WayfireWM/wf-config/releases/download/v${PV}/wf-config-${PV}.tar.xz"
SRC_URI[sha256sum] = "c7fb0b388afdd46add4b209ff7262bd3a30f9948a9a4d6e7ec1239bbf42b5aad"

S = "${WORKDIR}/${PN}-${PV}"

inherit meson pkgconfig

EXTRA_OEMESON += "--buildtype release"


BBCLASSEXTEND = ""

