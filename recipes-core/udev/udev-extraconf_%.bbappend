do_install() {
    install -d ${D}${sysconfdir}/udev/rules.d

    install -m 0644 ${WORKDIR}/autonet.rules       ${D}${sysconfdir}/udev/rules.d/autonet.rules
    install -m 0644 ${WORKDIR}/localextra.rules    ${D}${sysconfdir}/udev/rules.d/localextra.rules

    install -d ${D}${sysconfdir}/udev/mount.blacklist.d
    install -m 0644 ${WORKDIR}/mount.blacklist     ${D}${sysconfdir}/udev/

    install -d ${D}${sysconfdir}/udev/scripts/

    install -m 0755 ${WORKDIR}/network.sh ${D}${sysconfdir}/udev/scripts
}
