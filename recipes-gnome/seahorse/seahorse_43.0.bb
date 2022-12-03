SUMMARY = "Seahorse is a graphical interface for managing and using encryption keys."
LICENSE="GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

GNOMEBASEBUILDCLASS = "meson"

DEPENDS = " \
    avahi \
    appstream-glib-native \
    desktop-file-utils-native \
    gcr3 \
    glib-2.0 \
    gnupg \
    gpgme \
    gtk+3 \
    libhandy \
    libpwquality \
    libsecret \
    libsoup-3.0 \
    openssh \
"

inherit gnomebase itstool vala mime-xdg

SRC_URI[archive.sha256sum] = "5b1d1bfba74f3658227f3c82e296f330dd0fcd1ef4636b6a218228fee5ea832d"

PACKAGECONFIG[key-sharing] = "-Dkey-sharing=true,-Dkey-sharing=false,avahi"
PACKAGECONFIG[ldap-support] = "-Dldap-support=true,-Dldap-support=false,openldap"
PACKAGECONFIG[pkcs11-support] = "-Dpkcs11-support=true,-Dpkcs11-support=false,p11-kit"

PACKAGECONFIG ??= "pkcs11-support"

EXTRA_OEMESON += "--cross-file=${WORKDIR}/meson-${PN}.cross"

do_write_config:append() {
    cat >${WORKDIR}/meson-${PN}.cross <<EOF
[binaries]
ssh-keygen = '${bindir}/ssh-keygen'
EOF
}

FILES:${PN} += "${datadir}"
