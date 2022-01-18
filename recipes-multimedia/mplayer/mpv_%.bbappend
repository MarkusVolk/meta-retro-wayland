PV:rpi = "0.32.0"

PACKAGECONFIG:append = " lua egl drm gbm openal sdl2 shared zimg"

PACKAGECONFIG:append:x86 = " vaapi"
PACKAGECONFIG:append:x86-64 = " vaapi"

