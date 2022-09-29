SUMMARY = "A command-line fuzzy finder."
HOMEPAGE = "https://github.com/junegunn/fzf.git"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/${GO_IMPORT}/LICENSE;md5=db2771304bde7cd078662b2f1af760e4"


GO_IMPORT = "github.com/junegunn/fzf"

SRC_URI = "git://${GO_IMPORT};branch=master;protocol=https"

PV = "0.33.0"
SRCREV = "e03ac3136e17a525bc67d62728ccb3eb8179f183"

inherit go go-mod

GO_INSTALL = "${GO_IMPORT}"

do_compile[network] = "1"

