SUMMARY = "Paint creates terminal colors and effects for you."
HOMEPAGE = "https://github.com/janlelis/paint"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://MIT-LICENSE.txt;md5=a7e3cd6e2aac3862724a5b90cd2f6235"

SRC_URI = "git://github.com/janlelis/paint.git;protocol=https;branch=main"

inherit ruby

S = "${WORKDIR}/git"
PV = "2.2.1"
SRCREV = "v${PV}"

FILES:${PN} += "${libdir}"

BBCLASSEXTEND = ""

