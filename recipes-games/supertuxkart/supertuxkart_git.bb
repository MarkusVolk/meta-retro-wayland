SUMMARY = "SuperTuxKart is a free kart racing game."
HOMEPAGE = "https://github.com/supertuxkart/stk-code" 

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=bcfdeb69518cfe348a07845ebba5c295" 

DEPENDS = " \
	bluez5 \
	curl \
	freetype \
	harfbuzz \
	jpeg \
	libogg \
	libpng \
	libsdl2 \
	libvorbis \
	openal-soft \
	openssl \
	sqlite3 \
	virtual/egl \
	virtual/libgles2 \
	zlib \
"

RDEPENDS:${PN} = "openal-soft stk-assets"

inherit cmake pkgconfig

EXTRA_OECMAKE += "-DBUILD_RECORDER=0 -DCHECK_ASSETS=off -DSTK_INSTALL_DATA_DIR=${datadir}/games/supertuxkart"

SRC_URI = " \
    git://github.com/supertuxkart/stk-code.git;protocol=https;nobranch=1 \
"

PV = "1.4"
SRCREV = "bea5b530a56296e6110e7755a56d79742bd94176"
S = "${WORKDIR}/git"

FILES:${PN} += "${datadir}"

