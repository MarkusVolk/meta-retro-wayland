SUMMARY = "micro is a terminal-based text editor that aims to be easy to use and intuitive."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/${GO_IMPORT}/LICENSE;md5=5d3b6c44af6e9177296f05709aab74a4"

GO_IMPORT = "github.com/zyedidia/micro.git"

SRC_URI = "git://${GO_IMPORT};nobranch=1;protocol=https"

PV = "2.0.10"
SRCREV = "03ae049c0fe5862ca6010474dd775656bd6e5b86"

inherit go go-mod

do_compile() {
	go install -trimpath ./cmd/micro
}

GO_INSTALL = "${GO_IMPORT}"

do_compile[network] = "1"

