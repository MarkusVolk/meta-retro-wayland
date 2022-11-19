SUMMARY = "A command-line fuzzy finder."
HOMEPAGE = "https://github.com/junegunn/fzf.git"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/${GO_IMPORT}/LICENSE;md5=db2771304bde7cd078662b2f1af760e4"


GO_IMPORT = "github.com/junegunn/fzf"

SRC_URI = "git://${GO_IMPORT};branch=master;protocol=https"

PV = "0.35.1"
SRCREV = "b55f5554871e548c9c00a49df7a92f980c0191c2"

inherit go go-mod

GO_INSTALL = "${GO_IMPORT}"

do_compile[network] = "1"

