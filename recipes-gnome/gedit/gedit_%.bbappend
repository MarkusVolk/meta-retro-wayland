do_install:append() {
    sed -i "s|DBusActivatable|#DBusActivatable|" ${D}${datadir}/applications/org.gnome.gedit.desktop
}

