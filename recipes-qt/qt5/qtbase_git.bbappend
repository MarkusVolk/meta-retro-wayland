RDEPENDS:${PN}  += "virtual/libgles2"

FILESEXTRAPATHS:prepend := "${THISDIR}/qtbase:"

DEPENDS += "mesa drm wayland wayland-protocols wayland-native"

PACKAGECONFIG_DEFAULT:append = " \
	freetype \
	fontconfig \
	eglfs \
	release \
	optimize-size \
	gles2 \
	openssl \
	journald \
	libinput \
	xkbcommon \
	kms \
	gbm \
	dbus \
	evdev \
	gtk \
	harfbuzz \
"

QT_CONFIG_FLAGS += " \
	-no-xcb \
	-no-bundled-xcb-xinput \
"

INSANE_SKIP:${PN} +="file-rdeps"
INSANE_SKIP:${PN}-plugins +="file-rdeps"

SET_QT_QPA_DEFAULT_PLATFORM = "wayland"

do_configure:prepend() {
cat >> ${S}/mkspecs/oe-device-extra.pri <<EOF
QT_QPA_DEFAULT_PLATFORM = ${SET_QT_QPA_DEFAULT_PLATFORM}
EOF
}

