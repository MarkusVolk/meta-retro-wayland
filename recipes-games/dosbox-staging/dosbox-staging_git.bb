SUMMARY = "Modernized DOSBox codebase by using current development practices and tools."
HOMEPAGE = "https://github.com/dosbox-staging/dosbox-staging" 
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=ca8be14ecd86a8ae1155f8023c73bca6" 

DEPENDS = " \
	iir1 \
	libsdl2 \
	libxkbfile \
	opusfile \
	speexdsp \
	zlib \
"

inherit meson gtk-icon-cache pkgconfig

SRC_URI = "git://github.com/dosbox-staging/dosbox-staging.git;protocol=https;branch=release/0.79.x"

SRCREV = "dd7f21809870cc998005b3b09a33f1c36bd764a6"
PV = "0.79.1"
S = "${WORKDIR}/git"

PACKAGECONFIG ?= " \
	${@bb.utils.filter('DISTRO_FEATURES', 'opengl', d)} \
	alsa \
	sdl2_net \
	fluidsynth \
	mt32emu \
	png \
"

PACKAGECONFIG[alsa] = "-Duse_alsa=true,-Duse_alsa=false,alsa-lib"
PACKAGECONFIG[fluidsynth] = "-Duse_fluidsynth=true,-Duse_fluidsynth=false,fluidsynth"
PACKAGECONFIG[mt32emu] = "-Duse_mt32emu=true,-Duse_mt32emu=false,munt"
PACKAGECONFIG[opengl] = "-Duse_opengl=true,-Duse_opengl=false"
PACKAGECONFIG[png] = "-Duse_png=true,-Duse_png=false,libpng"
PACKAGECONFIG[sdl2_net] = "-Duse_sdl2_net=true,-Duse_sdl2_net=false,libsdl2-net"
PACKAGECONFIG[slirp] = "-Duse_slirp=true,-Duse_slirp=false,libslirp"

EXTRA_OEMESON += "-Dsystem_libraries=fluidsynth,glib,iir,mt32emu,opusfile,png,sdl2,sdl2_net,slirp,speexdsp,zlib"
EXTRA_OEMESON += "-Ddefault_library=shared"

FILES:${PN} += "${datadir}"
