FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRCREV = "cf6ca2a47f44126f4caf9242cfa7917b94abbc52"
PV = "1.9.1"

DEPENDS += "fontconfig"

EXTRA_OEMAKE += "HAVE_LAKKA=1"

do_configure_prepend() {
	sed -i 's|audio_driver = "alsa"|audio_driver = "pulse"|' ${S}/retroarch.cfg
}

PACKAGECONFIG_append = " \
	gles3_2 \
"
