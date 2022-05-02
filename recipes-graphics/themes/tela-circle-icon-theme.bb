SUMMARY = "Tela circle Icon Theme."
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING.md;md5=0f7f40118b07053f43a50552fd48e11d"


SRC_URI = " \
	git://github.com/vinceliuice/Tela-circle-icon-theme.git;protocol=https;branch=master \
	file://0001-install.sh-dont-rename-themes-using-spaces.patch \
"

PV = "2022-04-26"
SRCREV = "58503e3e9963f8c9840740340b2065837aa7f34d"
S = "${WORKDIR}/git"

inherit gtk-icon-cache

# Create themes in all available colors. Increases creation time and disk usage!
TELA_COLORED_THEMES ?= "enabled"

# Install circular folder icons
TELA_CIRCULAR_FOLDERS ?= "enabled"

do_install() {
	install -d ${D}${datadir}/icons
	./install.sh -n Tela-circle \
	${@bb.utils.contains('TELA_COLORED_THEMES', 'enabled', '-a', '', d)} \
	${@bb.utils.contains('TELA_CIRCULAR_FOLDERS', 'enabled', '-c', '', d)} \
	-d ${D}${datadir}/icons
}

ALLOW_EMPTY:${PN} = "1"

PACKAGES += " \
	tela-circle \
	tela-circle-dark \
	tela-circle-nord \
	tela-circle-purple-dark \
	tela-circle-black \
	tela-circle-green \
	tela-circle-nord-dark \
	tela-circle-red \
	tela-circle-black-dark \
	tela-circle-green-dark \
	tela-circle-orange \
	tela-circle-red-dark \
	tela-circle-blue \
	tela-circle-grey \
	tela-circle-orange-dark \
	tela-circle-ubuntu \
	tela-circle-blue-dark \
	tela-circle-grey-dark \
	tela-circle-pink \
	tela-circle-ubuntu-dark \
	tela-circle-brown \
	tela-circle-manjaro \
	tela-circle-pink-dark \
	tela-circle-yellow \
	tela-circle-brown-dark \
	tela-circle-manjaro-dark \
	tela-circle-purple \
	tela-circle-yellow-dark \
"

FILES:tela-circle = "${datadir}/icons/Tela-circle"
FILES:tela-circle-dark = "${datadir}/icons/Tela-circle-dark"
FILES:tela-circle-nord = "${datadir}/icons/Tela-circle-nord"
FILES:tela-circle-purple-dark = "${datadir}/icons/Tela-circle-purple-dark"
FILES:tela-circle-black = "${datadir}/icons/Tela-circle-black"
FILES:tela-circle-green = "${datadir}/icons/Tela-circle-green"
FILES:tela-circle-nord-dark = "${datadir}/icons/Tela-circle-nord-dark"
FILES:tela-circle-red = "${datadir}/icons/Tela-circle-red"
FILES:tela-circle-black-dark = "${datadir}/icons/Tela-circle-black-dark"
FILES:tela-circle-green-dark = "${datadir}/icons/Tela-circle-green-dark"
FILES:tela-circle-orange = "${datadir}/icons/Tela-circle-orange"
FILES:tela-circle-red-dark = "${datadir}/icons/Tela-circle-red-dark"
FILES:tela-circle-blue = "${datadir}/icons/Tela-circle-blue"
FILES:tela-circle-grey = "${datadir}/icons/Tela-circle-grey"
FILES:tela-circle-orange-dark = "${datadir}/icons/Tela-circle-orange-dark"
FILES:tela-circle-ubuntu = "${datadir}/icons/Tela-circle-ubuntu"
FILES:tela-circle-blue-dark = "${datadir}/icons/Tela-circle-blue-dark"
FILES:tela-circle-grey-dark = "${datadir}/icons/Tela-circle-grey-dark"
FILES:tela-circle-pink = "${datadir}/icons/Tela-circle-pink"
FILES:tela-circle-ubuntu-dark = "${datadir}/icons/Tela-circle-ubuntu-dark"
FILES:tela-circle-brown = "${datadir}/icons/Tela-circle-brown"
FILES:tela-circle-manjaro = "${datadir}/icons/Tela-circle-manjaro"
FILES:tela-circle-pink-dark = "${datadir}/icons/Tela-circle-pink-dark"
FILES:tela-circle-yellow = "${datadir}/icons/Tela-circle-yellow"
FILES:tela-circle-brown-dark = "${datadir}/icons/Tela-circle-brown-dark"
FILES:tela-circle-manjaro-dark = "${datadir}/icons/Tela-circle-manjaro-dark"
FILES:tela-circle-purple = "${datadir}/icons/Tela-circle-purple"
FILES:tela-circle-yellow-dark = "${datadir}/icons/Tela-circle-yellow-dark"

RRECOMMENDS:${PN} = " \
	tela-circle \
	tela-circle-dark \
	tela-circle-nord \
	tela-circle-purple-dark \
	tela-circle-black \
	tela-circle-green \
	tela-circle-nord-dark \
	tela-circle-red \
	tela-circle-black-dark \
	tela-circle-green-dark \
	tela-circle-orange \
	tela-circle-red-dark \
	tela-circle-blue \
	tela-circle-grey \
	tela-circle-orange-dark \
	tela-circle-ubuntu \
	tela-circle-blue-dark \
	tela-circle-grey-dark \
	tela-circle-pink \
	tela-circle-ubuntu-dark \
	tela-circle-brown \
	tela-circle-manjaro \
	tela-circle-pink-dark \
	tela-circle-yellow \
	tela-circle-brown-dark \
	tela-circle-manjaro-dark \
	tela-circle-purple \
	tela-circle-yellow-dark \
"

