SUMMARY = "Miller is like awk, sed, cut, join, and sort for data formats such as CSV, TSV, JSON, JSON Lines, and positionally-indexed"
HOMEPAGE = "https://github.com/johnkerl/miller"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/${GO_IMPORT}/LICENSE.txt;md5=1bd8766c3c92d76801888ca1fa45e4b2"


GO_IMPORT = "github.com/johnkerl/miller.git"

SRC_URI = "git://${GO_IMPORT};nobranch=1;protocol=https"
PV = "6.4.0"
SRCREV = "3c5cc37bdfeacb2c031be5daf4a37cd423d9b144"

inherit go go-mod

do_compile() {
	go build -trimpath ./cmd/mlr
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/src/${GO_IMPORT}/mlr ${D}${bindir}
	# make files removable by buildsystem
	chmod +w -R ${B}/pkg/mod
}

GO_INSTALL = "${GO_IMPORT}/mlr"

do_compile[network] = "1"


