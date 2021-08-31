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

inherit meson gtk-icon-cache

SRC_URI = " \
	git://github.com/dosbox-staging/dosbox-staging.git;protocol=https;branch=kc/release-0.77.1 \
	file://0001-ne2000.cpp-add-missing-header-file.patch \
"

SRCREV = "v${PV}"
PV = "0.77.1"
S = "${WORKDIR}/git"

PACKAGECONFIG[fluidsynth] = "-Duse_fluidsynth=true,-Duse_fluidsynth=false,fluidsynth"
PACKAGECONFIG[mt32emu] = "-Duse_mt32emu=true,-Duse_mt32emu=false,munt"
PACKAGECONFIG[opengl] = "-Duse_opengl=true,-Duse_opengl=false"
PACKAGECONFIG[pcap] = "-Duse_pcap=true,-Duse_pcap=false,libpcap"
PACKAGECONFIG[png] = "-Duse_png=true,-Duse_png=false,libpng"
PACKAGECONFIG[sdl2_net] = "-Duse_sdl2_net=true,-Duse_sdl2_net=false,libsdl2-net"
PACKAGECONFIG[slirp] = "-Duse_slirp=true,-Duse_slirp=false,libslirp"

PACKAGECONFIG ?= " \
	sdl2_net \
	opengl \
	fluidsynth \
	mt32emu \
	png \
	pcap \
"

FILES:${PN} += "${datadir}"

