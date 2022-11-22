SUMMARY = "The core rendering algorithms and ideas of mpv rewritten as an independent library."
SECTION = "multimedia"
HOMEPAGE = "https://opensourcelibs.com/lib/libplacebo"

LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=435ed639f84d4585d93824e7da3d85da"

SRC_URI = " \
    git://github.com/haasn/libplacebo.git;protocol=https;nobranch=1 \
"

S = "${WORKDIR}/git"
SRCREV = "34314e37306e3d12fe5a0416c9b79eaf268b0cb2"
PV = "5.229.1"

inherit meson pkgconfig

PACKAGECONFIG ??= " \
	${@bb.utils.filter('DISTRO_FEATURES', 'vulkan opengl', d)} \
	lcms \
"

PACKAGECONFIG[vulkan] = "-Dvulkan=enabled,-Dvulkan=disabled,vulkan-loader vulkan-headers shaderc spirv-shader-generator python3-mako-native python3-jinja2-native glad-native"
PACKAGECONFIG[opengl] = "-Dopengl=enabled,-Dopengl=disabled,libepoxy"
PACKAGECONFIG[lcms] = "-Dlcms=enabled,-Dlcms=disabled,lcms"
PACKAGECONFIG[demos] = "-Ddemos=true,-Ddemos=false,ffmpeg libsdl2 libsdl2-image"

EXTRA_OEMESON = "-Dvulkan-registry=${STAGING_DATADIR}/vulkan/registry/vk.xml"

