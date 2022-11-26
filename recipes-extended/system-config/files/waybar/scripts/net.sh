#!/usr/bin/env sh
swaymsg "[app_id=iwgtk] focus"  > /dev/null 2>&1 && pkill -f iwgtk && exit 0
exec /usr/bin/iwgtk &
