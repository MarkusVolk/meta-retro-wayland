SUMMARY = "A command-line fuzzy finder."
HOMEPAGE = "https://github.com/junegunn/fzf.git"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/${GO_IMPORT}/LICENSE;md5=bba7e28399b614707a33394aba4249d1"


GO_IMPORT = "github.com/junegunn/fzf"

SRC_URI = "git://${GO_IMPORT};branch=master;protocol=https"

PV = "0.29.0"
SRCREV = "9cb7a364a31bdb882d873807774bdcf6fad0c9e4"

inherit go go-mod

GO_INSTALL = "${GO_IMPORT}"

do_compile[network] = "1"

