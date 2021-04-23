SUMMARY = "A powerful yet lightweight web browser built with the Qt framework."
HOMEPAGE = "https://github.com/LeFroid/Viper-Browser"
SECTION = "multimedia"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=ee0634018831ceeacfabe102c4e90f24 \
"

DEPENDS += "qtwebengine qtquickcontrols qtquickcontrols2 qtgraphicaleffects qtdeclarative qtbase qtbase-native qtsvg"

SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/LeFroid/Viper-Browser.git;protocol=https \
"

S = "${WORKDIR}/git"

inherit cmake_qt5 pkgconfig mime-xdg


FILES_${PN} += "${datadir}/icons"

