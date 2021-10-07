inherit retro-user

ROOT_USER_PASSWORD ?= "root"
ROOTFS_POSTPROCESS_COMMAND += "set_root_passwd;"
ROOTFS_POSTPROCESS_COMMAND += "set_retro_passwd;"

set_root_passwd() {
   ROOTPW_ENCRYPTED="$(openssl passwd -6 -salt xyz ${ROOT_USER_PASSWORD})"
   sed -i "s%^root:[^:]*:%root:${ROOTPW_ENCRYPTED}:%" ${IMAGE_ROOTFS}/etc/shadow
}

set_retro_passwd() {
   RETROPW_ENCRYPTED="$(openssl passwd -6 -salt xyz ${RETRO_USER_PASSWORD})"
   sed -i "s%^retro:[^:]*:%retro:${RETROPW_ENCRYPTED}:%" ${IMAGE_ROOTFS}/etc/shadow
}

RETRO_WAYLAND_COMPOSITOR ?= "sway"

WGTK_APPS ?= " \
	azote \
	blueman \
	connman-gtk \
	eovpn \
	file-roller \
	gdk-pixbuf \
	librsvg-gtk \
	gnome-disk-utility \
	gnome-system-monitor \
	gparted \
	gsettings-desktop-schemas \
	gvfs \
	gvfsd-trash \
	l3afpad \
	pavucontrol \
	thunar \
	xfce-polkit \
"

WCONSOLE_TOOLS ?= " \
	bash \
	bzip2 \
	coreutils-stdbuf \
	curl \
	dosfstools \
	dosbox-staging \
	e2fsprogs \
	findutils \
	fzf \
	git \
	gotop \
	grep \
	gzip \
	htop \
	imagemagick \
	imv \
	less \
	libswscale \
	libusb1 \
	micro \
	mpv \
	procps \
	pv \
	rsync \
	sed \
	shadow \
	sudo \
	tar \
	usbutils \
	util-linux \
	util-linux-agetty \
	util-linux-fstrim \
	wf-recorder \
	wlsunset \
"

WSYSTEM_CONF ?= " \
	automountd \
	ca-certificates \
	glibc-binary-localedata-cs-cz \
	glibc-binary-localedata-de-de \
	glibc-binary-localedata-en-us \
	glibc-binary-localedata-es-es \
	glibc-binary-localedata-fr-fr \
	glibc-binary-localedata-pl-pl \
	glibc-binary-localedata-ru-ru \
	glibc-charmap-utf-8 \
	localedef \
	packagegroup-fonts-truetype \
	shared-mime-info \
	shared-mime-info-data \
	system-config \
	tzdata \
	tzdata-europe \
	wireless-regdb-static \
"
	
WNET_SERVICES ?= " \
	autofs \
	cifs-utils \
	minidlna \
	nfs-utils \
	nfs-utils-client \
	ntpdate \
	oscam \
	proftpd \
	pulseaudio \
	rpcbind \
	samba \
"

WLUA ?= " \
	luajit \
	lua-expat \
	lua-feedparser \
	lua-json \
	luaposix \
	lgi \
"

IMAGE_INSTALL:append = " \
	${WGTK_APPS} \
	${WCONSOLE_TOOLS} \
	${WSYSTEM_CONF} \
	${WNET_SERVICES} \
	${WLUA} \
"

IMAGE_INSTALL:append:rockchip = " \
	rockchip-firmware \
	ap6256-firmware \
"

IMAGE_INSTALL:remove = "retroarch-service"


