SUMMARY = "This is a cursor theme inspired by macOS and based on KDE Breeze."
LICENSE = "LGPL-3.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=90cffc6a4f1bcbb66067c81f5512c14f"


SRC_URI = "git://github.com/keeferrourke/capitaine-cursors.git"

DEPENDS += "bc-native"

PV = "4"
SRCREV = "r${PV}"
S = "${WORKDIR}/git"

inherit gtk-icon-cache

do_compile() {
	for type in light dark; do
		./build.sh --max-dpi xxxhd --type "$type"
	done
}

do_install() {
	install -d ${D}${datadir}/icons
	for type in light dark; do
		cp -dr --no-preserve=ownership dist/"$type" ${D}${datadir}/icons/capitaine-cursors-"$type"
	done
}

FILES_${PN} = "${datadir}"

