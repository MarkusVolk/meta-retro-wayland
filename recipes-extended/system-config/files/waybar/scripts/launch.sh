#!/usr/bin/env sh
swaymsg "[app_id=sirula]"  > /dev/null 2>&1 && pkill -f sirula && exit 0
exec /usr/bin/sirula &
