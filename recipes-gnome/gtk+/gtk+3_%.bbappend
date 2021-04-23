inherit gobject-introspection

DEPENDS_append_class_target = " \
	wayland-protocols \
	wayland \
	libxkbcommon \
"

EXTRA_OECONF_append_class-target += " \
	--enable-wayland-backend \	
	--enable-introspection \
"

