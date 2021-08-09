FILESEXTRAPATHS:prepend := "${THISDIR}/ffmpeg:"

inherit retro-overrides

SRC_URI = " \
	git://github.com/xbmc/FFmpeg.git;protocol=https;branch=release/4.3-kodi \
	file://mips64_cpu_detection.patch \
	file://0001-libavutil-include-assembly-with-full-path-from-sourc.patch \
	file://4_02_fix_mpegts.patch \
	file://4_03_allow_to_choose_rtmp_impl_at_runtime.patch \
	file://4_04_hls_replace_key_uri.patch \
	file://4_06_optimize_aac.patch \
	file://4_07_increase_buffer_size.patch \
	file://4_08_recheck_discard_flags.patch \
	file://4_09_ffmpeg_fix_edit_list_parsing.patch \
	file://4_10_rtsp_patch \
	file://4_11_dxva2_patch \
	file://4_A02-corrupt-h264-frames.patch \
	file://4_A11-FFmpeg-devel-amfenc-Add-support-for-pict_type-field.patch \
	file://ffmpeg-001-libreelec.patch \
	file://ffmpeg-0002-WIP-deint-filter.patch \
	file://ffmpeg-0003-libavfilter-v4l2deinterlace-dequeue-both-destination.patch \
"

SRC_URI:append:rpi = "	\
	file://rpi/ffmpeg-001-rpi.patch \
"
	
SRC_URI:append:rockchip = " \
	file://ffmpeg-001-v4l2-request.patch \
	file://ffmpeg-001-v4l2-drmprime.patch \
"

S = "${WORKDIR}/git"
PV = "4.3.2"
SRCREV = "${PV}-Matrix-19.2"

PACKAGECONFIG[dav1d] = "--enable-libdav1d,--disable-libdav1d,dav1d"
PACKAGECONFIG[libass] = "--enable-libass,--disable-libass,libass"
PACKAGECONFIG[libfontconfig] = "--enable-libfontconfig,--disable-libfontconfig,fontconfig"
PACKAGECONFIG[libfreetype] = "--enable-libfreetype,--disable-libfreetype,freetype"
PACKAGECONFIG[libopus] = "--enable-libopus,--disable-libopus,libopus"
PACKAGECONFIG[librtmp] = "--enable-librtmp,--disable-librtmp,rtmpdump"
PACKAGECONFIG[libv4l2] = "--enable-libv4l2,--disable-libv4l2,v4l-utils"
PACKAGECONFIG[pulseaudio] = "--enable-libpulse,--disable-libpulse,pulseaudio"
PACKAGECONFIG[v4l2-m2m] = "--enable-v4l2_m2m --enable-libdrm,--disable-v4l2_m2m,libdrm"
PACKAGECONFIG[v4l2-request] = "--enable-v4l2-request --enable-libudev,--disable-v4l2-request"
PACKAGECONFIG[wavpack] = "--enable-libwavpack,--disable-libwavpack,wavpack"
PACKAGECONFIG[webp] = "--enable-libwebp,--disable-libwebp,libwebp"
PACKAGECONFIG[zimg] = "--enable-libzimg,--disable-libzimg,zimg"
PACKAGECONFIG[libxml2] = "--enable-libxml2,--disable-libxml2,libxml2"

PACKAGECONFIG:append = " \
	dav1d \
	fdk-aac \
	gpl \
	librtmp \
	libass \
	libfontconfig \
	libfreetype \
	libopus \
	libv4l2 \
	libvorbis \
	libxml2 \
	mp3lame \
	openssl \
	pulseaudio \
	sdl2 \
	vpx \
	wavpack \
	webp \
	x264 \
	x265 \
	zimg \
"

PACKAGECONFIG:append:armarch = " \
	v4l2-m2m \
	v4l2-request \
"

VAAPISUPPORT:armarch = "0"
VDPAUSUPPORT:armarch = "0"

EXTRA_FFCONF = " \
	--prefix=${prefix} \
	--disable-static \
	--disable-runtime-cpudetect \
	--disable-doc \
	--disable-fast-unaligned \	
	--disable-htmlpages \
	--disable-manpages \
	--disable-podpages \
	--disable-txtpages \
	--disable-debug \
	--disable-altivec \
	--enable-inline-asm \
	--enable-asm \
	--enable-muxers \
	--enable-encoders \
	--enable-decoders \
	--enable-demuxers \
	--enable-ffprobe \
	--enable-nonfree \
	--enable-parsers \
	--enable-bsfs \
	--enable-protocols \
	--enable-indevs \
	--enable-outdevs \
	--enable-filters \
	--enable-hwaccels \
	--enable-optimizations \
	--enable-pthreads \
	--enable-postproc \
	--enable-network \
	--enable-swscale \
	--disable-gray \
	--enable-swscale-alpha \
	--disable-small \
	--enable-dct \
	--enable-fft \
	--enable-mdct \
	--enable-rdft \
	--disable-crystalhd \
	--extra-ldflags="${TARGET_LDFLAGS},--gc-sections -Wl,--print-gc-sections,-lrt" \
	--extra-cflags="${TARGET_CFLAGS} ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS} -ffunction-sections -fdata-sections -fno-aggressive-loop-optimizations" \
"

EXTRA_FFCONF:append:armarch = " \
	--disable-amd3dnow \
	--disable-amd3dnowext \
	--disable-mmx \
	--disable-mmxext \
	--disable-sse \
	--disable-sse2 \
	--disable-sse3 \
	--disable-ssse3 \
	--disable-sse4 \
	--disable-sse42 \
	--disable-x86asm \
	--disable-avx \
	--disable-xop \
	--disable-fma3 \
	--disable-fma4 \
	--disable-avx2 \
	${@bb.utils.contains("TARGET_ARCH", "arm", "--enable-armv6 --enable-armv6t2 --enable-vfp --enable-neon", "", d)} \
	${@bb.utils.contains("TUNE_FEATURES", "aarch64", "--enable-armv8 --enable-vfp --enable-neon", "", d)} \
"

EXTRA_FFCONF:append:rpi = " \
	--disable-rpi \
	--enable-sand \
	--disable-mmal \
	--disable-hwaccel=h264_v4l2request \
	--disable-hwaccel=mpeg2_v4l2request \
	--disable-hwaccel=vp8_v4l2request \
	--disable-hwaccel=vp9_v4l2request \
"

LICENSE_FLAGS_WHITELIST = "commercial"

