FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://0001-kodi-adjust-default-settings.patch"
SRC_URI:append:arm = " file://enable-drmprime.patch"
SRC_URI:append:aarch64 = " file://enable-drmprime.patch"

PACKAGECONFIG:append = " \
	dvdcss \
	optical \
	samba \
	vorbis \
	mariadb \
"

KODIGRAPHICALBACKEND = "wayland"
KODISYSTEMDAUTOSTART = "disable"

KODI_PLUGINS_INSTALL:append = " \
	kodi-addon-netflix \
	kodi-addon-ardundzdf \
	kodi-addon-radio \
	kodi-addon-fluxfm \
	kodi-addon-pvr-plutotv \
"
