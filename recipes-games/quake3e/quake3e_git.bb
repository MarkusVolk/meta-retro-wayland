SUMMARY = "This is a modern Quake III Arena engine aimed to be fast, secure and compatible with all existing Q3A mods."
HOMEPAGE = "https://github.com/ec-/Quake3e" 
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=87113aa2b484c59a17085b5c3f900ebf" 

DEPENDS = " \
	curl \
	libsdl2 \
	libjpeg-turbo \
	virtual/libgl \
"

RDEPENDS:${PN} = "q3-pak"

inherit autotools-brokensep pkgconfig gtk-icon-cache

SRC_URI = " \
    git://github.com/ec-/Quake3e.git;protocol=https;branch=master \
    file://quake3.desktop \
"

PV = "2021-10-14"
SRCREV = "5924248d79c3a2c9949c85e9fdcc1ca0e60da807"
S = "${WORKDIR}/git"

EXTRA_OEMAKE += "CROSS_COMPILING=1 ARCH=${TARGET_ARCH} USE_SYSTEM_JPEG=1"

do_configure:prepend() {
	sed -i "s|-I/usr/include -I/usr/local/include|-I${STAGING_INCDIR}|" ${S}/Makefile
}

do_install() {
	install -d ${D}${bindir} ${D}${datadir}/games/quake3 ${D}${datadir}/icons/hicolor/scalable/apps ${D}${datadir}/applications
	install -m 0644 ${S}/build/release-linux-${TARGET_ARCH}/quake3e_opengl_${TARGET_ARCH}.so ${D}${datadir}/games/quake3
	install -m 0644 ${S}/build/release-linux-${TARGET_ARCH}/quake3e_vulkan_${TARGET_ARCH}.so ${D}${datadir}/games/quake3
	install -m 0755 ${S}/build/release-linux-${TARGET_ARCH}/quake3e.${TARGET_ARCH} ${D}${datadir}/games/quake3
	install -m 0755 ${S}/build/release-linux-${TARGET_ARCH}/quake3e.ded.${TARGET_ARCH} ${D}${datadir}/games/quake3
	install -m 0644 ${S}/code/unix/quake3.svg ${D}${datadir}/icons/hicolor/scalable/apps
	install -m 0644 ${WORKDIR}/quake3.desktop ${D}${datadir}/applications
	ln -sf ${datadir}/games/quake3/quake3e.${TARGET_ARCH} ${D}${bindir}/quake3
}

FILES:${PN} = "${bindir} ${datadir}"

INSANE_SKIP:${PN} = "already-stripped"

