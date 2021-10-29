DESCRIPTION = "luaposix is a POSIX binding for Lua."
LICENSE = "MIT"
HOMEPAGE = "https://github.com/luaposix/luaposix"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f81069e00c0cad249f20efe958276db1"

DEPENDS += "virtual/lua-native virtual/lua virtual/crypt"

SRC_URI = "git://github.com/luaposix/luaposix.git;branch=release-v${PV} \
"
SRCREV = "14043c5086ae738823a5dfbc9170d9e14193fbef"
S = "${WORKDIR}/git"
B = "${S}"
PV = "35.1"

inherit pkgconfig

do_compile() {
    ${S}/build-aux/luke CFLAGS="-I${STAGING_INCDIR}/luajit-2.1"
}

do_install() {
    ${S}/build-aux/luke PREFIX=${D}${prefix} install
}

FILES:${PN} = "${datadir} ${libdir}"

