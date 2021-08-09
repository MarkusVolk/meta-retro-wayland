FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append =  " \
	file://0001-WIP-DVDVideoCodecDRMPRIME-add-support-for-filters.patch \
	file://0002-WIP-DRMPRIME-deinterlace-filter.patch \
	file://0001-disable-wayland-scanner.patch \
	file://kodi-100.03-disable-online-check.patch \
	file://kodi-100.08-setup-timezone.patch \
	file://kodi-100.13-udevprovider-filter-out-OE-specific-mounts.patch \
	file://kodi-100.25-hack-fix-texture-packer-cmake-source-dir.patch \
	file://kodi-995.10-devinputmappings.patch \
"

DEPENDS:append += "kodi-tools-jsonschemabuilder-native kodi-tools-texturepacker-native wayland-native waylandpp-native"
DEPENDS:remove = "libsquish"

EXTRA_OECMAKE += "-DWAYLANDPP_SCANNER=${STAGING_BINDIR_NATIVE}/wayland-scanner++" 
EXTRA_OECMAKE += "-DCORE_PLATFORM_NAME=wayland"
EXTRA_OECMAKE += "-DAPP_RENDER_SYSTEM=gles"

EXTRA_OECMAKE_BUILD = ""

inherit retro-overrides

VAAPISUPPORT:armarch = "0"
VDPAUSUPPORT:armarch = "0"

PACKAGECONFIG:append += "bluetooth samba wayland"


RRECOMMENDS:${PN}:append = " \
	libcec \
	libcurl \
	libnfs \
	nss \
	os-release \
	python3 \
	python3-ctypes \
	python3-netclient \
	python3-html \
	python3-difflib \
	python3-json \
	python3-shell \
	python3-six \
	python3-sqlite3 \
	python3-compression \
	python3-xmlrpc \
	python3-pycryptodomex \
	python3-profile \
	tvheadend \
	tzdata-africa \
	tzdata-americas \
	tzdata-antarctica \
	tzdata-arctic \
	tzdata-asia \
	tzdata-atlantic \
	tzdata-australia \
	tzdata-europe \
	tzdata-pacific \
	v4l-utils \
	xkeyboard-config \
	kodi-addon-inputstream-adaptive \
	kodi-addon-inputstream-ffmpegdirect \
	kodi-addon-inputstream-rtmp \
	kodi-addon-peripheral-joystick \
	kodi-addon-pvr-hts \
	alsa-plugins \
"

RRECOMMENDS:${PN}:append:libc-glibc = " \
	glibc-charmap-ibm850 \
	glibc-gconv-ibm850 \
	glibc-charmap-ibm437 \
	glibc-gconv-ibm437 \
	glibc-gconv-unicode \
	glibc-gconv-utf-32 \
	glibc-charmap-utf-8 \
	glibc-localedata-en-us \
"

