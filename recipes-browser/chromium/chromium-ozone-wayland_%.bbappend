FILESEXTRAPATHS:prepend := "${THISDIR}/chromium-ozone-wayland:"

PACKAGECONFIG:append = " proprietary-codecs"
CHROMIUM_EXTRA_ARGS:append = " --password-store=gnome --enable-gpu-rasterization --enable-zero-copy --force-dark-mode --enable-features=WebUIDarkMode --no-default-browser-check"

inherit ccache mime-xdg

DEPENDS:append:x86 = " libva"
DEPENDS:append:x86_64 = " libva"

GN_ARGS += " \
  use_gtk=true \
  enable_widevine=true \
"

GN_ARGS:append:x86 = " use_vaapi=true"
GN_ARGS:append:x86_64 = " use_vaapi=true"
