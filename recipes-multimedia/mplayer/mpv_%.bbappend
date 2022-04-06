PV:rpi = "0.32.0"

PACKAGECONFIG:append = " openal sdl2 shared zimg"

PACKAGECONFIG:append:x86 = " vaapi"
PACKAGECONFIG:append:x86-64 = " vaapi"

RRECOMMENDS:${PN} += "mpv-mpris"
