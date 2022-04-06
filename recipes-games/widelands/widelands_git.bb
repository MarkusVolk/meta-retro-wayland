SUMMARY = "Widelands is a free, open source real-time strategy game with singleplayer campaigns and a multiplayer mode."
HOMEPAGE = "https://www.widelands.org" 
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263" 

DEPENDS = " \
	asio \
	glew \
	libglu \
	libpng \
	libsdl2 \
	libsdl2-image \
	libsdl2-mixer \
	libsdl2-ttf \
	zlib \
"

SRC_URI = " \
    git://github.com/widelands/widelands.git;protocol=https;branch=master \
"

PV = "1.0"
SRCREV = "e4b59faf6937414b1b2af9aeeb0e26fce0c7b548"
S = "${WORKDIR}/git"

inherit cmake gettext python3native gtk-icon-cache

EXTRA_OECMAKE = " \
	-DOPTION_BUILD_TESTS=OFF \
	-DOPTION_ASAN=OFF \
	-DOPTION_TSAN=OFF \
	-DWL_INSTALL_BASEDIR=${datadir}/games/widelands \
	-DWL_INSTALL_DATADIR=${datadir}/games/widelands \
	-DCMAKE_BUILD_TYPE=Release \
	-DOPTION_BUILD_TRANSLATIONS=ON \
	-DOPTION_BUILD_WEBSITE_TOOLS=OFF \
"

do_install:append() {
	mv -f ${D}/share/* ${D}${datadir}
	rm -rf ${D}/share
	install -d ${D}${bindir}
	mv ${D}${prefix}/widelands ${D}${bindir}
}

FILES:${PN} = "${prefix}"
