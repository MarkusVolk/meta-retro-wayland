SUMMARY = "Another terminal based graphical activity monitor, inspired by gtop and vtop, this time written in Go!"
HOMEPAGE = "https://github.com/xxxserxxx/gotop"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/${GO_IMPORT}/LICENSE;md5=d485113f92a06664566115c7794a5071"

SRC_URI = "git://${GO_IMPORT};branch=master;protocol=https"

GO_IMPORT = "github.com/xxxserxxx/gotop.git"

PV = "4.1.4"
SRCREV = "cd0cf0f6ed85f3d9e9cbc7dfd2eb6e0a03f18dc2"

inherit go go-mod

do_compile() {
	go build -trimpath ./cmd/gotop
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/src/${GO_IMPORT}/gotop ${D}${bindir}
	# make files removable by buildsystem
	chmod +w -R ${B}/pkg/mod
}

GO_INSTALL = "${GO_IMPORT}/gotop"

do_compile[network] = "1"

INSANE_SKIP:${PN}-dev = "file-rdeps"

