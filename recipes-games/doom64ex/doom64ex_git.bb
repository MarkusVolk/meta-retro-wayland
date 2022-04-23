SUMMARY = "Doom64EX is a reverse-engineering project aimed to recreate Doom64 as close as possible with additional modding features."
HOMEPAGE = "https://doom64ex.wordpress.com/" 
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=a23a74b3f4caf9616230789d94217acb" 

DEPENDS = "libsdl2 libsdl2-net libpng zlib fluidsynth"
RDEPENDS:${PN} = "doom64-pak"

inherit cmake pkgconfig

SRC_URI = "git://github.com/svkaiser/Doom64EX.git;protocol=https;branch=master"

PV = "2022"
SRCREV = "03a5e6a5a3a14d66886f62b72431b37ef7336706"
S = "${WORKDIR}/git"

EXTRA_OECMAKE = "-DENABLE_SYSTEM_FLUIDSYNTH=ON"

FILES:${PN} += "${datadir}"

