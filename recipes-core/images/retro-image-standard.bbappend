inherit retro-user

DEPENDS:append = "wic-tools"

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
	geary \
	gdk-pixbuf \
	gnome-chess \
	gnome-disk-utility \
	gnome-system-monitor \
	gparted \
	gsettings-desktop-schemas \
	gvfs \
	gvfsd-trash \
	gedit \
	librsvg-gtk \
	nwg-launchers \
	pavucontrol \
	thunar \
	waybar \
	xfce-polkit \
	zenity \
"

WCONSOLE_TOOLS ?= " \
	asciinema \
	bash \
	bzip2 \
	coreutils-stdbuf \
	curl \
	dosfstools \
	dosbox-staging \
	e2fsprogs \
	ffmpeg \
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
	light \
	micro \
	mpv \
	playerctl \
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
	udev-rules-udisks-hide-bootpart \
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
	luaposix \
	lgi \
"

WRETROARCH = " \
	retroarch \
	retroarch-assets \
	retroarch-overlays \
	retroarch-autoconfig \
	retroarch-database-cheats \
	retroarch-database-titles \
	retroarch-database-cursors \
	retroarch-libretro-info \
	retroarch-cg-shaders \
	retroarch-glsl-shaders \
	retroarch-slang-shaders \
"

IMAGE_INSTALL:append = " \
	${WGTK_APPS} \
	${WCONSOLE_TOOLS} \
	${WSYSTEM_CONF} \
	${WNET_SERVICES} \
	${WLUA} \
	${WRETROARCH} \
"

IMAGE_INSTALL:append:rockchip = " \
	rockchip-firmware \
	ap6256-firmware \
"

IMAGE_INSTALL:remove = "retroarch-service"


