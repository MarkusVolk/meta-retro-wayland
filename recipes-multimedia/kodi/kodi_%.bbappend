FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://0001-kodi-adjust-default-settings.patch"
SRC_URI:append:arm = " file://enable-drmprime.patch"
SRC_URI:append:aarch64 = " file://enable-drmprime.patch"

PACKAGECONFIG:append = " \
	dvdcss \
	bluetooth \
	optical \
	samba \
"

KODIGRAPHICALBACKEND = "wayland"
KODISYSTEMDAUTOSTART = "disable"

