SUMMARY = "DSP IIR Realtime C++ filter library"
HOMEPAGE = "https://github.com/berndporr/iir1"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=3e4bda4204237f84ed771428f1b0a656"

SRC_URI = "git://github.com/berndporr/iir1.git;nobranch=1;protocol=https"
PV = "1.9.3"
SRCREV = "f5eaccc87c437d7ca3d050bdfe0783523dbb9d0e"
S = "${WORKDIR}/git"

inherit pkgconfig cmake
