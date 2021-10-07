#!/usr/bin/env sh
swaymsg "[app_id=blueman-manager] focus"  > /dev/null 2>&1 && pkill -f blueman-manager && exit 0
exec /usr/bin/blueman-manager &
