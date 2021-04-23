DEPENDS_class-target += "zlib openssl rtmpdump"

EXTRA_OECONF_append_class-target = " \
	--with-librtmp \
	--with-ssl \
	--with-zlib \
"

