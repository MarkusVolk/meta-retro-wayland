DESCRIPTION = "LuaLanes"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
HOMEPAGE = "https://github.com/LuaLanes/lanes.git"
DEPENDS += "lua"
RDEPENDS:${PN} += "lua"

include ../lua.inc

SRC_URI = "git://github.com/LuaLanes/lanes.git;protocol=https;branch=master"

SRCREV = "${AUTOREV}"
PV = "${SRCPV}"
PR = "1"

S = "${WORKDIR}/git"

inherit cmake

do_install:append() {
	install -d ${D}/${LUA_VER}/lanes ${D}/usr/lib/lua ${D}/usr/share/lua/${LUA_VER}
	rm -r ${D}/usr/share/lanes
	mv ${D}/usr/share/lua/cmod/core.so ${D}/${LUA_VER}/lanes
	mv ${D}/${LUA_VER} ${D}/usr/lib/lua
	mv ${D}/usr/share/lua/lmod/lanes.lua ${D}/usr/share/lua/${LUA_VER}/ 
}

FILES:${PN} = "/usr"

BBCLASSEXTEND = "native nativesdk"
