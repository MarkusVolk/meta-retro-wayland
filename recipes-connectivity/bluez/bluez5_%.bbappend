do_install:append() {
    sed -i "s|ReadWritePaths=\/|ReadWritePaths=:\/|" ${D}${systemd_system_unitdir}/bluetooth.service
}

