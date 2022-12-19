RRECOMMENDS:${PN} += "e2fsprogs"

# Crude hack to get gparted running under wayland.
# Until security people made up their mind about the future direction, this is broken by design and needs a dirty hack anyway
# Like this it is at least also running under plain wayland without x11

do_install:append() {
	echo "#!/bin/sh" > ${D}${bindir}/gparted-wayland
	echo "exec sudo -E gparted" >> ${D}${bindir}/gparted-wayland
	chmod +x ${D}${bindir}/gparted-wayland
	sed -i "s:\/usr\/bin\/gparted:\/usr\/bin\/gparted-wayland:" ${D}${datadir}/applications/gparted.desktop
}

