SUMMARY = "micro is a terminal-based text editor that aims to be easy to use and intuitive."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/${GO_IMPORT}/LICENSE;md5=5d3b6c44af6e9177296f05709aab74a4"

GO_IMPORT = "github.com/zyedidia/micro.git"

SRC_URI = "git://${GO_IMPORT};nobranch=1;protocol=https"

PV = "2.0.10"
SRCREV = "v${PV}"

inherit go go-mod mime-xdg

export CGO_ENABLED = "0"

do_compile() {
	go install -trimpath ./cmd/micro
}

do_install:append() {
	install -d ${D}${datadir}/applications
	install -m 644 ${S}/src/${GO_IMPORT}/assets/packaging/micro.desktop ${D}${datadir}/applications
	# make files removable by buildsystem
	chmod +w -R ${B}/pkg/mod
}

GO_INSTALL = "${GO_IMPORT}"

FILES:${PN}:append = " ${datadir}"

