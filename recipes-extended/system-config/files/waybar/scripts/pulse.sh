#!/usr/bin/env sh

swaymsg "[app_id=pavucontrol] focus"  > /dev/null 2>&1 && pkill -f pavucontrol && exit 0
exec /usr/bin/pavucontrol &

