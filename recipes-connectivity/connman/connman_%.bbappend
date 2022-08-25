WIRELESS_DAEMON = "iwd"

PACKAGECONFIG:append = " openvpn vpnc l2tp pptp"

RRECOMMENDS:${PN} += " \
	connman-vpn \
	connman-plugin-vpn-openvpn \
	connman-plugin-vpn-vpnc \
	connman-plugin-vpn-l2tp \
	connman-plugin-vpn-pppt \
	connman-tools \
	connman-wait-online \
"

