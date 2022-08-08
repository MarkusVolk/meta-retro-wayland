SUMMARY = "micro is a terminal-based text editor that aims to be easy to use and intuitive."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/${GO_IMPORT}/LICENSE;md5=5d3b6c44af6e9177296f05709aab74a4"

GO_IMPORT = "github.com/zyedidia/micro.git"

SRC_URI = "git://${GO_IMPORT};nobranch=1;protocol=https"

PV = "2.0.11"
SRCREV = "225927b9a25f0d50ea63ea18bc7bb68e404c0cfd"

inherit go go-mod

do_compile() {
	go install -trimpath ./cmd/micro
}

GO_INSTALL = "${GO_IMPORT}"

do_install:append() {
	# make files removable by buildsystem
	chmod +w -R ${B}/pkg/mod
}

do_compile[network] = "1"

