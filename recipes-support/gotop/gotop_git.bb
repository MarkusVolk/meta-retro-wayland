SUMMARY = "Another terminal based graphical activity monitor, inspired by gtop and vtop, this time written in Go!"
HOMEPAGE = "https://github.com/xxxserxxx/gotop"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/${GO_IMPORT}/LICENSE;md5=d485113f92a06664566115c7794a5071"


GO_IMPORT = "github.com/xxxserxxx/gotop.git"

SRC_URI = "git://${GO_IMPORT};branch=master;protocol=https"

PV = "4.1.2"
SRCREV = "v${PV}"

export CGO_ENABLED = "0"

inherit go go-mod

do_compile() {
	go install -trimpath ./cmd/gotop
}

do_install:append() {
	# make files removable by buildsystem
	chmod +w -R ${B}/pkg/mod
}

GO_INSTALL = "${GO_IMPORT}"

do_compile[network] = "1"

INSANE_SKIP:${PN}-dev = "file-rdeps"

