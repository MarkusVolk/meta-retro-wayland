FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

KODIVER ?= "20.0"
SRCREV = "08b7599d63e063545e34a24bb17fc3738cd4dde7"
PV = "20.0"

SRC_URI:append =   " \
	file://0001-kodi-adjust-default-settings.patch \
	file://libreelec/kodi-100.03-disable-online-check.patch \
	file://libreelec/kodi-995.10-devinputmappings.patch \
	file://libreelec/kodi-999.15-disable-using-tv-menu-language-by-default.patch \
	file://libreelec/kodi-995.01-fix-missing-wayland-scanner-pkg-config.patch \
"
	
SRC_URI:append:rockchip = " \
	file://rockchip/0001-WIP-DVDVideoCodecDRMPRIME-add-support-for-filters.patch \
	file://rockchip/0002-WIP-DRMPRIME-deinterlace-filter.patch \
"

DEPENDS:append = " kodi-tools-jsonschemabuilder-native kodi-tools-texturepacker-native wayland-native waylandpp-native"

RRECOMMENDS:${PN} = "kodi-addon-inputstream-adaptive kodi-addon-peripheral-joystick"

EXTRA_OECMAKE += "-DWAYLANDPP_SCANNER=${STAGING_BINDIR_NATIVE}/wayland-scanner++" 
EXTRA_OECMAKE += "-DCORE_PLATFORM_NAME=wayland"
EXTRA_OECMAKE += "-DAPP_RENDER_SYSTEM=gles"

EXTRA_OECMAKE_BUILD = ""

inherit retro-overrides

VDPAUSUPPORT:armarch = "0"
VAAPISUPPORT:armarch = "0"

PACKAGECONFIG:append = " \
	bluetooth \
	samba \
	wayland \
"

FILES:${PN} += "${datadir}/metainfo"

