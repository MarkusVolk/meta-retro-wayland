#!/usr/bin/env sh

swaymsg "[app_id=gnome-system-monitor] focus"  > /dev/null 2>&1 && pkill -f gnome-system-monitor && exit 0
exec /usr/bin/gnome-system-monitor -r &
