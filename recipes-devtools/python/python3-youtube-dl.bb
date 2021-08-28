SUMMARY = "Download videos from YouTube (and more sites)"
HOMEPAGE = "http://rg3.github.io/youtube-dl/"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7246f848faa4e9c9fc0ea91122d6e680"

DEPENDS = "libxml2 bash-completion"

inherit setuptools3

SRCREV = "${PV}"
PV = "2021.06.06"

SRC_URI = "git://github.com/ytdl-org/youtube-dl.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

do_compile:prepend() {
    cd ${S}
    oe_runmake lazy-extractors youtube-dl.bash-completion
}

do_install:append() {
    mv ${D}${datadir}/etc ${D}${sysconfdir}
    install -d ${D}${sysconfdir}/bash_completion.d
    install -m 0644 youtube-dl.bash-completion ${D}${sysconfdir}/bash_completion.d
}

RDEPENDS:${PN} = " \
    python3-email \
    python3-unixadmin \
    python3-ctypes \
    python3-html \
    "

RDEPENDS:{PN}-src = "${PN}"
FILES:${PN}-src = " \
    ${datadir}/etc \
"

FILES:${PN} += "${sysconfdir}"
