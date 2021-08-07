SUMMARY = "Nordic is a Gtk3.20+ theme created using the awesome Nord color pallete."
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"


SRC_URI = "https://github.com/EliverLara/Nordic/releases/download/${PV}/Nordic-darker.tar.xz"
SRC_URI[sha256sum] = "fb9057fbb419cb0e598ec984e93bb2289909fe57e35e40a9833da226dbd5a774"

PV = "2.0.0"
SRCREV = "${PV}"
S = "${WORKDIR}/Nordic-darker"


do_install() {
	install -d ${D}${datadir}/themes
	cp -r ${S} ${D}${datadir}/themes
}

FILES:${PN} = " ${datadir}"

