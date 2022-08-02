SUMMARY = "The core rendering algorithms and ideas of mpv rewritten as an independent library."
SECTION = "multimedia"
HOMEPAGE = "https://opensourcelibs.com/lib/libplacebo"

LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=435ed639f84d4585d93824e7da3d85da"

SRC_URI = " \
    git://github.com/haasn/libplacebo.git;protocol=https;nobranch=1 \
"

S = "${WORKDIR}/git"
SRCREV = "12d55df496aa473296b180318b3132fdceb068fe"
PV = "4.208.0"

inherit meson pkgconfig

PACKAGECONFIG ??= " \
	${@bb.utils.filter('DISTRO_FEATURES', 'vulkan opengl', d)} \
"

PACKAGECONFIG[vulkan] = ",,vulkan-loader vulkan-headers shaderc python3-mako-native"
PACKAGECONFIG[opengl] = ",,libepoxy"
PACKAGECONFIG[lcms] = ",,lcms"
PACKAGECONFIG[sdl2] = ",,libsdl2 libsdl2-image"
PACKAGECONFIG[ffmpeg] = ",,ffmpeg"

EXTRA_OEMESON = "-Dvulkan-registry=${STAGING_DATADIR}/vulkan/registry/vk.xml"

