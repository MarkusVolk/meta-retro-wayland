#!/bin/sh

swaymsg "[app_id=eovpn] focus"  > /dev/null 2>&1 && pkill -f eovpn && exit 0
exec /usr/bin/eovpn &
