# Build vala-bindings for librsvg. Gnome-chess has a hard dependency on it.

inherit vala

PACKAGECONFIG[vala] = "--enable-vala,--disable-vala"

# Vala-bindings need gobject-introspection. We dont have this available for native builds
PACKAGECONFIG:append:class-target = " vala"

