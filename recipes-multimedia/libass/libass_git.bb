DESCRIPTION = "libass is a portable subtitle renderer for the ASS/SSA (Advanced Substation Alpha/Substation Alpha) subtitle format. It is mostly compatible with VSFilter."
HOMEPAGE = "https://github.com/libass/libass"
SECTION = "libs/multimedia"

LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://COPYING;md5=a42532a0684420bdb15556c3cdd49a75"

DEPENDS = "enca freetype libpng fribidi"

SRC_URI = "git://github.com/libass/libass.git;protocol=https;branch=master"
PV = "0.15.1"
SRCREV = "${PV}"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

PACKAGECONFIG[compare] = "--enable-compare,--disable-compare"
PACKAGECONFIG[fontconfig] = "--enable-fontconfig,--disable-fontconfig,fontconfig"
PACKAGECONFIG[harfbuzz] = ",,harfbuzz"
PACKAGECONFIG[largetiles] = "--enable-large-tiles,--disable-large-tiles"
PACKAGECONFIG[profile] = "--enable-profile,--disable-profile"
PACKAGECONFIG[test] = "--enable-test,--disable-test"

PACKAGECONFIG ??= "fontconfig harfbuzz"

# Disable compiling with ASM for x86 to avoid textrel
EXTRA_OECONF:append:x86 = " --disable-asm"

PACKAGES =+ "${PN}-tests"

FILES:${PN}-tests = " \
    ${libdir}/test \
"

