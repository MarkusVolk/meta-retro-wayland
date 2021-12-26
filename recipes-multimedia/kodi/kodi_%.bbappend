FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append =   " \
	file://0001-kodi-adjust-default-settings.patch \
	file://libreelec/kodi-100.03-disable-online-check.patch \
	file://libreelec/kodi-995.10-devinputmappings.patch \
	file://libreelec/kodi-999.15-disable-using-tv-menu-language-by-default.patch \
"
	
SRC_URI:append:rockchip = " \
	file://rockchip/0001-WIP-DVDVideoCodecDRMPRIME-add-support-for-filters.patch \
	file://rockchip/0002-WIP-DRMPRIME-deinterlace-filter.patch \
"

SRC_URI:append:rpi = " \
	file://rpi/kodi-001-deinterlace.patch \
	file://rpi/kodi-002-set-max-bpc-for-high-bit-depth-videos.patch \
	file://rpi/kodi-003-add-colourspace-connector-property.patch \
"

RRECOMMENDS:${PN} = "kodi-addon-inputstream-adaptive kodi-addon-peripheral-joystick"

PACKAGECONFIG:append = " \
	bluetooth \
	samba \
	wayland \
"

FILES:${PN} += "${datadir}/metainfo"
