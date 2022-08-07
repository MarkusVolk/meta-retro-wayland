SUMMARY = "Seahorse is a graphical interface for managing and using encryption keys."
LICENSE="GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

GNOMEBASEBUILDCLASS = "meson"

DEPENDS = " \
    appstream-glib-native \
    desktop-file-utils-native \
    gcr \
    glib-2.0 \
    gnupg \
    gpgme \
    gtk+3 \
    libhandy \
    libpwquality \
    libsecret \
    libsoup-2.4 \
    openssh \
"

inherit gnomebase itstool vala

SRC_URI[archive.sha256sum] = "c50cacebf8de7a7e2e5f1dae0b98232114741296abe8d543e3923d62a153d630"

PACKAGECONFIG[key-sharing] = "-Dkey-sharing=true,-Dkey-sharing=false,avahi"
PACKAGECONFIG[ldap-support] = "-Dldap-support=true,-Dldap-support=false,openldap"
PACKAGECONFIG[pkcs11-support] = "-Dpkcs11-support=true,-Dpkcs11-support=false,p11-kit"

PACKAGECONFIG ??= "pkcs11-support"

do_configure:prepend() {
    sed -i "s|ssh_keygen = find_program('ssh-keygen')|#ssh_keygen = find_program('ssh-keygen')|" ${S}/meson.build
    sed -i "s|ssh_keygen.path()|'${bindir}/ssh-keygen'|" ${S}/meson.build
} 

FILES:${PN} += "${datadir}"
