# add default password for root
ROOTFS_POSTPROCESS_COMMAND += "set_root_passwd;"
set_root_passwd() {
   ROOTPW_ENCRYPTED=""
   if [ -n "${ROOTPW}" ]; then
   ROOTPW_ENCRYPTED=`openssl passwd -crypt -quiet ${ROOTPW}`
   else
   ROOTPW_ENCRYPTED="wYNffsf6sozwE"
   fi
   sed "s%^root:[^:]*:%root:${ROOTPW_ENCRYPTED}:%" \
       < ${IMAGE_ROOTFS}/etc/shadow \
       > ${IMAGE_ROOTFS}/etc/shadow.new;
   mv ${IMAGE_ROOTFS}/etc/shadow.new ${IMAGE_ROOTFS}/etc/shadow ;
   rm -rf ${IMAGE_ROOTFS}/tmp/*
}

RETRO_WAYLAND_COMPOSITOR ?= "sway"

WGTK_APPS ?= " \
	blueman \
	connman-gtk \
	file-roller \
	gdk-pixbuf \
	librsvg-gtk \
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
	wl-sunset \
"

WSYSTEM_CONF ?= " \
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
"

IMAGE_INSTALL_append = " \
	${WGTK_APPS} \
	${WCONSOLE_TOOLS} \
	${WSYSTEM_CONF} \
	${WNET_SERVICES} \
	${WLUA} \
"

IMAGE_INSTALL_append_rockchip = " \
	rockchip-firmware \
	ap6256-firmware \
"

IMAGE_INSTALL_remove = "retroarch-service"


