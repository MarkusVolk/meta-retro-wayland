SUMMARY = "The core rendering algorithms and ideas of mpv rewritten as an independent library."
SECTION = "multimedia"
HOMEPAGE = "https://opensourcelibs.com/lib/libplacebo"

LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=435ed639f84d4585d93824e7da3d85da"

SRC_URI = " \
    git://github.com/haasn/libplacebo.git;protocol=https;branch=master \
"

S = "${WORKDIR}/git"
PV = "4.192.0"
SRCREV = "f95f7aa2a23c818a1aea32754b7ff06cd5503fb7"

inherit meson pkgconfig

PACKAGECONFIG ??= " \
	${@bb.utils.filter('DISTRO_FEATURES', 'vulkan', d)} \
	${@bb.utils.filter('DISTRO_FEATURES', 'opengl', d)} \
"

PACKAGECONFIG[vulkan] = ",,vulkan-loader vulkan-headers shaderc python3-mako-native"
PACKAGECONFIG[opengl] = ",,virtual/libgl libepoxy"
PACKAGECONFIG[lcms] = ",,lcms"
PACKAGECONFIG[sdl2] = ",,libsdl2 libsdl2-image"
PACKAGECONFIG[ffmpeg] = ",,ffmpeg"

EXTRA_OEMESON = "-Dvulkan-registry=${STAGING_DATADIR}/vulkan/registry/vk.xml"

