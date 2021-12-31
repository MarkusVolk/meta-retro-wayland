FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://0001-kodi-adjust-default-settings.patch"

PACKAGECONFIG:append = " \
	bluetooth \
	samba \
	wayland \
"

KODIGRAPHICALBACKEND = "wayland"
KODISYSTEMDAUTOSTART = "disable"

