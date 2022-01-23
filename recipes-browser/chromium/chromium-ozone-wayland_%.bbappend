FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

PACKAGECONFIG:append = " proprietary-codecs"
CHROMIUM_EXTRA_ARGS:append = " --enable-gpu-rasterization --enable-zero-copy --force-dark-mode --enable-features=WebUIDarkMode --no-default-browser-check"

inherit ccache

GN_ARGS += " \
  use_custom_libcxx=true \
  use_gtk=true \
  enable_widevine=true \
"
