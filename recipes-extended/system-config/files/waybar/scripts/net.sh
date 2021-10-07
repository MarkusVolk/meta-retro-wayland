#!/usr/bin/env sh
swaymsg "[app_id=connman-gtk] focus"  > /dev/null 2>&1 && pkill -f connman-gtk && exit 0
exec /usr/bin/connman-gtk &
