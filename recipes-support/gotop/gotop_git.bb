SUMMARY = "Another terminal based graphical activity monitor, inspired by gtop and vtop, this time written in Go!"
HOMEPAGE = "https://github.com/xxxserxxx/gotop"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/${GO_IMPORT}/LICENSE;md5=d485113f92a06664566115c7794a5071"

SRC_URI = "git://${GO_IMPORT};branch=master;protocol=https"

GO_IMPORT = "github.com/xxxserxxx/gotop.git"

PV = "4.1.2"
SRCREV = "a32a1c05eae8c6612857f1e2e883382d793640e8"

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

