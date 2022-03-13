SUMMARY = "RTMP Dump"
DESCRIPTION = "rtmpdump is a toolkit for RTMP streams. All forms of RTMP are \
supported, including rtmp://, rtmpt://, rtmpe://, rtmpte://, and rtmps://."
HOMEPAGE = "http://rtmpdump.mplayerhq.hu/"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = "openssl zlib"

SRCREV = "530e342cb41b6d33de8fb3659a5f67645043f4c7"
PV = "${SRCPV}"

SRC_URI = " \
	git://github.com/neutrino-images/ni-rtmpdump.git;protocol=https;branch=master \
	file://0001-Add-my-modifications-to-some-files.patch \
"

S = "${WORKDIR}/git"

inherit autotools-brokensep

EXTRA_OEMAKE = " \
    CC='${CC} -Wl,--hash-style=gnu -Os -Wl,-rpath-link,${STAGING_DIR_HOST}/usr/lib' \
    SYS=posix INC=-I=/usr/include DESTDIR=${D} \
    prefix=${prefix} libdir=${libdir} incdir=${includedir}/librtmp bindir=${bindir} mandir=${mandir}"

do_install:prepend() {
	install -d ${D}/usr/lib
}


