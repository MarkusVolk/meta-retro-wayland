RETRO_WAYLAND_COMPOSITOR ?= "sway"

WGTK_APPS ?= " \
	azote \
	blueman \
	file-roller \
	geary \
	gdk-pixbuf \
	gnome-chess \
	gnome-disk-utility \
	gnome-system-monitor \
	gnome-software \
	gparted \
	gsettings-desktop-schemas \
	gthumb \
	gvfs \
	gvfsd-trash \
	gedit \
	iwgtk \
	librsvg-gtk \
	nwg-displays \
	nwg-launchers \
	nwg-look \
	pavucontrol \
	sirula \
	swappy \
	thunar \
	waybar \
	xfce-polkit \
"

WCONSOLE_TOOLS ?= " \
	asciinema \
	bash \
	bzip2 \
	coreutils \
	coreutils-stdbuf \
	cowsay-perl \
	curl \
	dosfstools \
	dosbox-staging \
	e2fsprogs \
	ffmpeg \
	findutils \
	flatpak \
	fortunes \
	fzf \
	gawk \
	git \
	gotop \
	grep \
	gzip \
	htop \
	imagemagick \
	less \
	libswscale \
	libusb1 \
	light \
	micro \
	mpv \
	pamixer \
	playerctl \
	procps \
	psmisc \
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
	which \
	wlsunset \
	wob \
	xz \
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
	linux-firmware \
	localedef \
	packagegroup-fonts-truetype \
	shared-mime-info \
	shared-mime-info-data \
	system-config \
	tzdata \
	tzdata-europe \
	udev-rules-udisks-hide-bootpart \
	wireless-regdb-static \
	pulseaudio-user-service \
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
	pipewire \
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


