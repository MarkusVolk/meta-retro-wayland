SUMMARY = "Seahorse is a graphical interface for managing and using encryption keys."
LICENSE="GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

GNOMEBASEBUILDCLASS = "meson"

DEPENDS = " \
    avahi \
    gcr \
    glib-2.0 \
    gnupg \
    gpgme \
    gtk+3 \
    libhandy \
    libpwquality \
    libsecret \
    libsoup-2.4 \
    openldap \
"

inherit gnomebase itstool vala

SRC_URI[archive.sha256sum] = "e6eec09e810448295f547f18c1d5772b65c3edc1d9e5a2595f10b5dde68929f5"

do_configure:prepend() {
    sed -i "s|ssh_keygen = find_program('ssh-keygen')|#ssh_keygen = find_program('ssh-keygen')|" ${S}/meson.build
    sed -i "s|ssh_keygen.path()|'${bindir}/ssh-keygen'|" ${S}/meson.build
} 

FILES:${PN} += "${datadir}"

