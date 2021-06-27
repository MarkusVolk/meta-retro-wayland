#!/usr/bin/env sh

ps -e | grep blueman-manager && killall -q blueman-manager && exit 0
exec /usr/bin/blueman-manager
