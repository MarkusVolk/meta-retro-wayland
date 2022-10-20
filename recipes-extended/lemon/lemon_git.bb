SUMMARY = "The LEMON Parser Generator"
HOMEPAGE = "https://github.com/coelckers/Raze"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://../../package/common/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit cmake

SRC_URI = " \
    git://github.com/coelckers/Raze.git;protocol=https;nobranch=1 \
"

SRCREV = "6b4561f3bd83e2ae62ea745c37aaca28275b2322"
S = "${WORKDIR}/git/tools/lemon"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 lemon ${D}${bindir}
    install -m 0644 ${S}/lempar.c ${D}${bindir}
}

BBCLASSEXTEND = "native"
