SUMMARY = "Powerline fonts"
DESCRIPTION = "Powerline Consolefonts needed for agnoster zsh theme"

HOMEPAGE = "https://github.com/powerline/fonts.git"
SECTION = "base/fonts"

LICENSE = "OFL-1.1"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/OFL-1.1;md5=fac3a519e5e9eb96316656e0ca4f2b90"

SRCREV_terminus = "${AUTOREV}"
SRCREV_meslo = "${AUTOREV}"
SRCREV_FORMAT = "terminus"

SRC_URI = " \
	git://github.com/powerline/fonts.git;protocol=https;name=terminus \
	git://github.com/romkatv/powerlevel10k-media.git;protocol=https;name=meslo;destsuffix=git/meslo \
"

S = "${WORKDIR}/git"
PV = "${SRCPV}"
SRCREV = "${AUTOREV}"


do_install () {
	install -d ${D}${datadir}/consolefonts ${D}${datadir}/fonts/ttf
	for powerline_font in ${S}/Terminus/PSF/*; do
		install -m0644 ${powerline_font} ${D}${datadir}/consolefonts
	done
	for ttf_font in ${S}/meslo/"Meslo*.ttf"; do
		install -m 0644 ${ttf_font} ${D}${datadir}/fonts/ttf
	done
}

FILES:${PN} = " \
	${datadir}/consolefonts \
	${datadir}/fonts \
"

