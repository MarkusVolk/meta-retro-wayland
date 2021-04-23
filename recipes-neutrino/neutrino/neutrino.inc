
PROVIDES = "virtual/neutrino"
RPROVIDES_${PN} = "virtual/neutrino"

inherit autotools pkgconfig ccache retro-user

DEPENDS += " \
	curl \
	ffmpeg \
	flac \
	freetype \
	freetype-native \
	fribidi \
	gettext \
	giflib \
	glib-2.0 \
	libass \
	libdvbsi++ \
	libid3tag \
	libjpeg-turbo \
	libpng \
	libsigc++-2.0\
	virtual/lua \
	luaposix \
	openssl \
	openthreads \
	virtual/libstb-hal \
	virtual/libiconv \
	fontconfig \
	libpng \
	tremor \
	zlib \
	gdk-pixbuf \
	atk \
	cairo \
	pixman \
	cogl-1.0 \
	clutter-1.0 \
	harfbuzz \
	pango \
	json-glib \
	retro-user \
"

RRECOMMENDS_${PN} += "libao-plugin-libalsa libao-plugin-libpulse"

S = "${WORKDIR}/git"

YT_DEV_KEY ?= "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"

TMDB_DEV_KEY ?= "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"

SHOUTCAST_DEV_KEY ?= "XXXXXXXXXXXXXXXX"

OMDB_API_KEY ?= "XXXXXXXX"

N_PREFIX = "/usr"

N_EXEC_PREFIX = "${N_PREFIX}/bin"

EXTRA_OECONF = " \
	--enable-maintainer-mode \
	--enable-silent-rules \
	--enable-upnp \
	--enable-mdev \
	--enable-fribidi \
	--enable-giflib \
	--with-tremor \
	--enable-flac \
	--enable-ffmpegdec \
	--enable-lua \
	--enable-reschange \
	--with-target=native \
	--prefix=${N_PREFIX} \
	--exec_prefix=${N_EXEC_PREFIX} \
	--includedir=${N_PREFIX}/include \
	--with-configdir=${RETRO_USER_HOMEDIR}/.config/neutrino/config \
	--with-plugindir=${RETRO_USER_HOMEDIR}/.config/neutrino/plugins \
	--with-plugindir_var=${RETRO_USER_HOMEDIR}/.config/neutrino/plugins \
	--with-webtvdir_var=${RETRO_USER_HOMEDIR}/.config/neutrino/webtv \
	--with-luaplugindir=${RETRO_USER_HOMEDIR}/.config/neutrino/luaplugin \
	--with-tmdb-dev-key="${TMDB_DEV_KEY}" \
	--with-omdb-api-key="${OMDB_API_KEY}" \
	--with-youtube-dev-key="${YT_DEV_KEY}" \
	--with-shoutcast-dev-key="${SHOUTCAST_DEV_KEY}" \
	--with-weather-dev-key="${WEATHER_DEV_KEY}" \
	--disable-tmdb-key-manage \
	--disable-omdb-key-manage \
	--disable-youtube-key-manage \
	--disable-shoutcast-key-manage \
	--disable-weather-key-manage \
"

EXTRA_OEMAKE += "'ARFLAGS=rc'"

# VERSION_FILE = "${N_PREFIX}/.version"

N_CFLAGS = "-Wall -Wextra -Wshadow -Wno-psabi -g -O2 -fno-strict-aliasing -rdynamic -DENABLE_FREESATEPG -DNEW_LIBCURL \
-I${S}/lib/libcoolstream2 -I${STAGING_INCDIR}/freetype2 -I${STAGING_INCDIR}/sigc++-2.0 -I${STAGING_INCDIR}/glib-2.0 -I${STAGING_LIBDIR}/glib-2.0/include -I${STAGING_INCDIR}/luajit-2.1"

N_CXXFLAGS = "${N_CFLAGS}"

N_LDFLAGS += "-Wl,--hash-style=gnu -Wl,-rpath-link, ${STAGING_LIBDIR} -lcurl -ldl -lass"
N_CPPFLAGS = "-DDYNAMIC_LUAPOSIX -D__KERNEL_STRICT_NAMES -D__STDC_CONSTANT_MACROS"
CPPFLAGS = "${N_CPPFLAGS}"

do_configure_prepend() {
        ln -sf ${B}/src/gui/version.h ${S}/src/gui/
}


do_compile () {
	# unset CFLAGS CXXFLAGS LDFLAGS
	oe_runmake CFLAGS="${N_CFLAGS}" CXXFLAGS="${N_CXXFLAGS}" LDFLAGS="${N_LDFLAGS}"
}


do_install_append () {
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/neutrino/config
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/neutrino/luaplugins
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/neutrino/plugins
	install -d ${D}${RETRO_USER_HOMEDIR}/.config/neutrino/webtv
	# We install update.urls file, but with suffix '.disable'. 
	# That causes disabling the formal online flash update menu entry within Neutrino which is using update.urls.
	# Online flash updates will working only with the stb-flash.lua script.
	# Nevertheless, you can remove the suffix '.disable', but flashing will never works.
	if [ ! -z ${RELEASE_TEXT_LOCATION} ]; then
		echo "${RELEASE_TEXT_LOCATION}" > ${D}/etc/update.urls.disable
	fi
	chown ${RETRO_USER_NAME}:${RETRO_USER_NAME} -R ${D}${RETRO_USER_HOMEDIR}
}

FILES_${PN} += "\
	${datadir} \
	${libdir} \
	${RETRO_USER_HOMEDIR} \	
"

INSANE_SKIP_${PN} = "host-user-contaminated"

