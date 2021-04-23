HOMEPAGE = "http://www.tuxbox.org"
MAINTAINER = "Tuxbox-Developers"

SRC_URI += "git://github.com/tuxbox-neutrino/library-stb-hal.git;branch=mpx;protocol=https \
	    file://0001-generic-pc-increase-standard-resolution.patch \
"

PV = "1.4.0+${SRCPV}"

EXTRA_OECONF_append += " \
        --with-boxtype=generic \
"

