DESCRIPTION = "libconfuse -  a configuration file parser library written in c"
HOMEPAGE = "https://github.com/libconfuse/libconfuse"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=42fa47330d4051cd219f7d99d023de3a"

DEPENDS = "virtual/gettext"

SRC_URI = "git://github.com/libconfuse/libconfuse.git;protocol=https;branch=master \
"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit pkgconfig autotools gettext

