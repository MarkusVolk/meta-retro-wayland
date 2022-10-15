FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://retroarch-use-system-luajit.patch"

PACKAGECONFIG[openal] = "--enable-al,--disable-al,openal-soft"
PACKAGECONFIG[lua] = "--enable-lua,--disable-lua,luajit"

PACKAGECONFIG:append = " gles3_2 openal flac lua"
PACKAGECONFIG:remove = "wifi"

EXTRA_OEMAKE += " \
  HAVE_BLUETOOTH=${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', '1', '0', d)} \
"

RRECOMMENDS:${PN} = "retroarch-autoconfig"

