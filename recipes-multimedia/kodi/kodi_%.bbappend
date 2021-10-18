FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append =   " \
	file://0001-WIP-DVDVideoCodecDRMPRIME-add-support-for-filters.patch \
	file://0002-WIP-DRMPRIME-deinterlace-filter.patch \
	file://0001-disable-wayland-scanner.patch \
	file://kodi-100.03-disable-online-check.patch \
	file://kodi-100.05-make-binary-addons-executable.patch \
	file://kodi-100.06-dont-set-_NET_WM_STATE_FULLSCREEN.patch \
	file://kodi-100.08-setup-timezone.patch \
	file://kodi-100.12-prevent-kodi-switching-to-windowed-mode.patch \
	file://kodi-100.13-udevprovider-filter-out-OE-specific-mounts.patch \
	file://kodi-100.25-hack-fix-texture-packer-cmake-source-dir.patch \
	file://kodi-995.10-devinputmappings.patch \
	file://kodi-999.15-disable-using-tv-menu-language-by-default.patch \
	file://cec-framework/kodi-100.17-tinker-s-cec-disable-polling.patch \
"
	
SRC_URI:append:rockchip = " \
	file://0001-kodi-rockchip-adjust-default-settings.patch \
"

DEPENDS:append += "kodi-tools-jsonschemabuilder-native kodi-tools-texturepacker-native wayland-native waylandpp-native"

RRECOMMENDS:${PN} = "kodi-addon-inputstream-adaptive kodi-addon-peripheral-joystick"

EXTRA_OECMAKE += "-DWAYLANDPP_SCANNER=${STAGING_BINDIR_NATIVE}/wayland-scanner++" 
EXTRA_OECMAKE += "-DCORE_PLATFORM_NAME=wayland"
EXTRA_OECMAKE += "-DAPP_RENDER_SYSTEM=gles"

EXTRA_OECMAKE_BUILD = ""

inherit retro-overrides

VDPAUSUPPORT:armarch = "0"
VAAPISUPPORT:armarch = "0"

PACKAGECONFIG:append += " \
	bluetooth \
	samba \
	wayland \
"

