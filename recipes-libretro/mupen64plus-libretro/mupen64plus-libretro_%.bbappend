FILESEXTRAPATHS:prepend := "${THISDIR}/mupen64plus-libretro:"

SRC_URI:append = " \
	file://0001-remove-mvectorize-with-neon-quad.patch \
	file://0001-remove-SOURCE-ASM.patch \
	file://0001-neon-disable-s16-convert.patch \
"

LIBRETRO_EXTRA_MAKEFLAGS:append = " HAVE_PARALLEL_RDP=1 HAVE_PARALLEL_RSP=1 HAVE_THR_AL=1 LLE=1 HAVE_NEON=1"

