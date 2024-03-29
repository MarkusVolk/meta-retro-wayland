SUMMARY = "GZDoom's music system as a standalone library"
HOMEPAGE = "https://github.com/coelckers/ZMusic"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://licenses/lgplv21.txt;md5=1803fa9c2c3ce8cb06b4861d75310742"

inherit cmake pkgconfig

DEPENDS = "zlib fluidsynth"

RDEPENDS:${PN} = "zlib"

SRC_URI = "git://github.com/coelckers/ZMusic.git;protocol=https;nobranch=1"

PV = "1.1.11"
SRCREV = "7a7ee92ff801d9874383476ef7843dfb89f3c934"
S = "${WORKDIR}/git"

EXTRA_OECMAKE = "-DBUILD_SHARED_LIBS=ON"
