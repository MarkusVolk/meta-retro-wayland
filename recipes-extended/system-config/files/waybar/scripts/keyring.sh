#!/usr/bin/env sh
swaymsg "[app_id=zenity] focus"  > /dev/null 2>&1 && pkill -f zenity && exit 0
exec /usr/bin/unlock-keyring &
