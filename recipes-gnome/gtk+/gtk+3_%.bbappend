inherit gobject-introspection

DEPENDS:append:class-target = " \
	wayland-protocols \
	wayland \
	libxkbcommon \
"

EXTRA_OECONF:append:class-target += " \
	--enable-wayland-backend \	
	--enable-introspection \
"

