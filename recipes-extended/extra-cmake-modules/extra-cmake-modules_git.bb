DESCRIPTION = "The Extra CMake Modules package, or ECM, adds to the modules provided by CMake."
HOMEPAGE = "https://github.com/KDE/extra-cmake-modules"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING-CMAKE-SCRIPTS;md5=54c7042be62e169199200bc6477f04d1"

inherit cmake

SRC_URI = " \
  git://github.com/KDE/extra-cmake-modules.git;protocol=https;branch=master \
"
SRCREV = "b6c8b20c1047006f148a9376046e45e8f036b3bd"
PV = "5.94.0"
S = "${WORKDIR}/git"

FILES:${PN} += "${datadir}"
