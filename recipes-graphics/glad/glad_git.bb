SUMMARY = "Vulkan/GL/GLES/EGL/GLX/WGL Loader-Generator based on the official specifications for multiple languages."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae570f26774ac096cff8f992091a223c"

SRC_URI = "git://github.com/Dav1dde/glad.git;protocol=https;branch=glad2"

RDEPENDS:${PN} = "python3"

inherit setuptools3

S = "${WORKDIR}/git"
PV = "2.0.2"
SRCREV = "f237a2bfcec0d9b82b90ec9af4af265c40de7183"

BBCLASSEXTEND = "native nativesdk"
