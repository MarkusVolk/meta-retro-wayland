SUMMARY = "A powerful yet lightweight web browser built with the Qt framework."
HOMEPAGE = "https://github.com/OtterBrowser/otter-browser"
SECTION = "multimedia"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=4fe869ee987a340198fb0d54c55c47f1 \
"

DEPENDS += "qtwebengine qtmultimedia qtsvg"

SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/OtterBrowser/otter-browser.git;protocol=https \
"

S = "${WORKDIR}/git"

inherit cmake_qt5 pkgconfig mime-xdg


FILES:${PN} += "${datadir}/icons"

