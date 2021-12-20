FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

PACKAGECONFIG:append = " proprietary-codecs"
CHROMIUM_EXTRA_ARGS:append = " --enable-gpu-rasterization --enable-zero-copy --force-dark-mode --enable-features=WebUIDarkMode --no-default-browser-check"

inherit ccache

SRC_URI:append = " file://wayland-Fixed-terminate-caused-by-binding-to-wrong-version.patch"

GN_ARGS += " \
  use_custom_libcxx=true \
  use_gtk=true \
"


