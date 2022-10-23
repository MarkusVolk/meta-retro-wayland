SUMMARY = "vkQuake is a port of id Software's Quake using Vulkan instead of OpenGL for rendering."
HOMEPAGE = "https://github.com/Novum/vkQuake"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = " \
	zlib \
	libvorbis \
	opusfile \
	libmad \
	libsdl2 \
	spirv-tools-native \
	glslang-native \
	vulkan-loader \
	vulkan-headers \
"

RDEPENDS:${PN} = "libmad q1-pak"
RRECOMMENDS:${PN} = "q1-music"

inherit meson pkgconfig gtk-icon-cache

SRC_URI = " \
    git://github.com/Novum/vkQuake.git;protocol=https;branch=master \
    file://0001-meson-build-use-native-for-bintoc.patch \
    file://vkquake.desktop \
    file://vkquake.svg \
"

PV = "1.20.3"
SRCREV = "41ecf07dc40c4b1fde2a60ee592fa7ba264bbbff"
S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${bindir} ${D}${datadir}/games/quake ${D}${datadir}/icons/hicolor/scalable/apps ${D}${datadir}/applications
	install -m 0755 ${B}/vkquake ${D}${datadir}/games/quake
	install -m 0644 ${WORKDIR}/vkquake.svg ${D}${datadir}/icons/hicolor/scalable/apps
	install -m 0644 ${WORKDIR}/vkquake.desktop ${D}${datadir}/applications
	echo "exec ${datadir}/games/quake/vkquake -basedir ${datadir}/games/quake" > ${D}${bindir}/vkquake
	chmod 755 ${D}${bindir}/vkquake
}

FILES:${PN} = "${bindir} ${datadir}"
