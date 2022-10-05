FILESEXTRAPATHS:prepend := "${THISDIR}/5.19:"

SRC_URI:append = " \
	file://drm-i915-Set-correct-domains-values-at-_i915_vma_move_to_active.patch \
	file://linux-100-kernel-5-19-io-series-664369.patch \
"

