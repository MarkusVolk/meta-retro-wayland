FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " file://retroarch-use-system-luajit.patch"

PACKAGECONFIG[openal] = "--enable-al,--disable-al,openal-soft"
PACKAGECONFIG[lua] = "--enable-lua,--disable-lua,luajit"

PACKAGECONFIG_append = " lakka gles3_2 openal flac lua"



