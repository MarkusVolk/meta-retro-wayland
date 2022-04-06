SUMMARY = "The road unbroken. This vehicle a bastille of C and OpenGL. Weatherd and beaten by Carmack, Fitzgibbons, and journeymen. Gelled with SDL."
HOMEPAGE = "https://github.com/Shpoike/Quakespasm" 
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://../LICENSE.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263" 

DEPENDS = " \
	zlib \
	libvorbis \
	opusfile \
	libmad \
	libsdl2 \
	virtual/libgl \
"

RDEPENDS:${PN} = "libmad q1-pak"
RRECOMMENDS:${PN} = "q1-music"

inherit autotools-brokensep pkgconfig gtk-icon-cache

SRC_URI = " \
    git://github.com/sezero/quakespasm.git;protocol=https;branch=master \
    file://0001-Makefile-replace-sdl-config-with-pkg-config.patch \
    file://quake.desktop \
    file://quake.svg \
"

PV = "0.94.3"
SRCREV = "09396fd9ca86997b9af717e6399f63be22ab6dae"
S = "${WORKDIR}/git/Quake"

EXTRA_OEMAKE += "DO_USERDIRS=1 USE_SDL2=1"

do_configure:prepend() {
	sed -i "s|LDFLAGS =|LDFLAGS = ${LDFLAGS}|" ${S}/Makefile
}

do_install() {
	install -d ${D}${bindir} ${D}${datadir}/games/quake ${D}${datadir}/icons/hicolor/scalable/apps ${D}${datadir}/applications
	install -m 0755 ${S}/quakespasm ${D}${datadir}/games/quake
	install -m 0644 ${WORKDIR}/quake.svg ${D}${datadir}/icons/hicolor/scalable/apps
	install -m 0644 ${WORKDIR}/quake.desktop ${D}${datadir}/applications
	echo "exec ${datadir}/games/quake/quakespasm -basedir ${datadir}/games/quake" > ${D}${bindir}/quake
	chmod 755 ${D}${bindir}/quake
}

FILES:${PN} = "${bindir} ${datadir}"

INSANE_SKIP:${PN} = "already-stripped"

