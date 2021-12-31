SUMMARY = "Modernized DOSBox codebase by using current development practices and tools."
HOMEPAGE = "https://github.com/dosbox-staging/dosbox-staging" 
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=a75e9ff85f9de2c690521c2b6ddd26cf" 

DEPENDS = " \
	libsdl2 \
	libxkbfile \
	alsa-lib \
	opusfile \
"

inherit meson gtk-icon-cache pkgconfig

SRC_URI = " \
	git://github.com/dosbox-staging/dosbox-staging.git;protocol=https;branch=release/0.78.x \
"

SRCREV = "fbe8d2412161462b6a92a374bd151a6ae77f2ca6"
PV = "0.78.1"
S = "${WORKDIR}/git"

PACKAGECONFIG[alsa] = "-Duse_alsa=true,-Duse_alsa=false,alsa-lib"
PACKAGECONFIG[fluidsynth] = "-Duse_fluidsynth=true,-Duse_fluidsynth=false,fluidsynth"
PACKAGECONFIG[mt32emu] = "-Duse_mt32emu=true,-Duse_mt32emu=false,munt"
PACKAGECONFIG[opengl] = "-Duse_opengl=true,-Duse_opengl=false"
PACKAGECONFIG[png] = "-Duse_png=true,-Duse_png=false,libpng"
PACKAGECONFIG[sdl2_net] = "-Duse_sdl2_net=true,-Duse_sdl2_net=false,libsdl2-net"
PACKAGECONFIG[slirp] = "-Duse_slirp=true,-Duse_slirp=false,libslirp"

PACKAGECONFIG ?= " \
	alsa \
	sdl2_net \
	opengl \
	fluidsynth \
	mt32emu \
	png \
"

FILES:${PN} += "${datadir}"

