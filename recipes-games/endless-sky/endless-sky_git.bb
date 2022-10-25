SUMMARY = "Explore other star systems. Earn money by trading, carrying passengers, or completing missions."
HOMEPAGE = "https://endless-sky.github.io/"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://license.txt;md5=7702f203b58979ebbc31bfaeb44f219c"

DEPENDS = " \
	libsdl2 \
	glew \
	libglu \
	openal-soft \
	libmad \
	libjpeg-turbo \
	libpng \
"

SRC_URI = " \
    git://github.com/endless-sky/endless-sky.git;protocol=https;branch=master \
"

PV = "0.9.16.1"
SRCREV = "d930b95c14119a74c6ffaadbe14bfd67a679af81"
S = "${WORKDIR}/git"

inherit scons pkgconfig gtk-icon-cache

EXTRA_OESCONS = "DESTDIR=${D} mode=release opengl=gles"

do_install:append() {
	mv ${D}${prefix}/games ${D}${bindir}
	install -d ${D}${sysconfdir}/security/limits.d
	echo "*       soft    rtprio  2" > ${D}${sysconfdir}/security/limits.d/endless-sky.conf
	echo "*       hard    rtprio  2" >> ${D}${sysconfdir}/security/limits.d/endless-sky.conf
}

FILES:${PN} = "${datadir} ${bindir} ${sysconfdir}"
