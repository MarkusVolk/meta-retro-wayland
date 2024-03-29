SUMMARY = "OpenAL is a cross-platform 3D audio API"
HOMEPAGE = "https://github.com/kcat/openal-soft" 

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://BSD-3Clause;md5=409803f24896cb07a1da563198a46f03" 

inherit cmake pkgconfig

SRC_URI = " \
    git://github.com/kcat/openal-soft.git;protocol=https;branch=master \
"

PACKAGECONFIG[alsa] = ",,alsa-lib"
PACKAGECONFIG[pulseaudio] = ",,pulseaudio"
PACKAGECONFIG[sdl2] = ",,libsdl2"
PACKAGECONFIG[ffmpeg] = ",,ffmpeg"

PACKAGECONFIG ?= "\
    ${@bb.utils.filter('DISTRO_FEATURES', 'alsa', d)} \
    ${@bb.utils.filter('DISTRO_FEATURES', 'pulseaudio', d)} \
    sdl2 \
    ffmpeg \
"

PV = "1.22.2"
SRCREV = "c835f07f7e8db54455bb1b8ecbc15380498c660b"
S = "${WORKDIR}/git"

FILES:${PN} += "${datadir}"

