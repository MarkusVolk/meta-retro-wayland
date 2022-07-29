DESCRIPTION = "AntiMicroX is a graphical program used to map gamepad keys to keyboard, mouse, scripts and macros."
HOMEPAGE = "https://github.com/AntiMicroX/antimicrox"

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit cmake_qt5 gettext pkgconfig mime mime-xdg

SRC_URI = " \
	git://github.com/AntiMicroX/antimicrox.git;protocol=https;branch=master \
	file://0001-buttoneditdialog.cpp-fix-redefinition-if-building-wi.patch \
"
SRCREV = "2f7504457a4c098cc3906a952f194195e4c4fd78"
PV = "3.2.5"
S = "${WORKDIR}/git"

DEPENDS = " \
	extra-cmake-modules \
	itstool \
	libsdl2 \
	libxi \
	libxtst \
	qtbase \
	qttools-native \
"

RDEPENDS:${PN} = "desktop-file-utils shared-mime-info-data"

EXTRA_OECMAKE = "-DAPPDATA=OFF ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '-DWITH_X11=OFF', '', d)}"

FILES:${PN} += "${datadir}"
