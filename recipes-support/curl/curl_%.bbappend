DEPENDS:class-target += "zlib openssl rtmpdump"

EXTRA_OECONF:append:class-target = " \
	--with-librtmp \
	--with-ssl \
	--with-zlib \
"

