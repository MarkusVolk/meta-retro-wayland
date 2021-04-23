DESCRIPTION = "i3 - improved tiling manager"
HOMEPAGE = "https://i3wm.org/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5d94c0207d5b4cf9a9dfb589ac9dbeb2"

DEPENDS = "libconfuse libnl alsa-lib pulseaudio yajl asciidoc-native"

SRC_URI = "git://github.com/i3/i3status.git;protocol=https;branch=master \
"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit pkgconfig gettext autotools-brokensep

do_configure_prepend () {
    sed -i "s|i3status manpage|i3status|" ${S}/Makefile    
    sed -i "s|install -m 644 man/i3status.1|#install -m 644 man/i3status.1|" ${S}/Makefile
}

