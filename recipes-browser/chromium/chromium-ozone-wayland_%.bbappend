FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

PACKAGECONFIG:append = " proprietary-codecs"
CHROMIUM_EXTRA_ARGS:append = " --enable-gpu-rasterization --enable-zero-copy --force-dark-mode --enable-features=WebUIDarkMode --no-default-browser-check"

inherit ccache

DEPENDS:append:x86 = " libva"
DEPENDS:append:x86_64 = " libva"

GN_ARGS += " \
  use_custom_libcxx=true \
  use_gtk=true \
  enable_widevine=true \
"

GN_ARGS:append:x86 = " use_vaapi=true"
GN_ARGS:append:x86_64 = " use_vaapi=true"
