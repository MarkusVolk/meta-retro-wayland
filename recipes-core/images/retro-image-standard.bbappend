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

IMAGE_INSTALL_append = " \
	autofs \
	bash \
	blueman \
	bzip2 \
	ca-certificates \
	cifs-utils \
	connman-gtk \
	coreutils-stdbuf \
	curl \
	dosfstools \
	dvb-femon \
	dvb-usb-drivers-meta \
	e2fsprogs \
	file-roller \
	findutils \
	gdk-pixbuf \
	git \
	glibc-binary-localedata-cs-cz \
	glibc-binary-localedata-de-de \
	glibc-binary-localedata-en-us \
	glibc-binary-localedata-es-es \
	glibc-binary-localedata-fr-fr \
	glibc-binary-localedata-pl-pl \
	glibc-binary-localedata-ru-ru \
	glibc-charmap-utf-8 \
	gnome-system-monitor \
	gparted \
	gsettings-desktop-schemas \
	gvfs \
	gvfsd-trash \
	gzip \
	htop \
	imagemagick \
	l3afpad \
	less \
	libswscale \
	libusb1 \
	localedef \
	lua-expat \
	lua-feedparser \
	lua-json \
	luaposix \
	minidlna \
	mpv \
	nano \
	nfs-utils \
	nfs-utils-client \
	ntpdate \
	oscam \
	packagegroup-fonts-truetype \
	pavucontrol \
	proftpd \
	pulseaudio \
	pv \
	rpcbind \
	rsync \
	samba \
	sed \
	shadow \
	shared-mime-info \
	sudo \
	system-config \
	tar \
	thunar \
	tzdata \
	tzdata-europe \
	usbutils \
	util-linux \
	util-linux-agetty \
	util-linux-fstrim \
	virtual/lua \
	wireless-regdb-static \
	xfce4-terminal \
	xfce-polkit \
	${RETRO_WAYLAND_COMPOSITOR} \
"


