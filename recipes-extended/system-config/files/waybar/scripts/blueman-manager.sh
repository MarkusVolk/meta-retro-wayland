#!/usr/bin/env sh

pidof blueman-manager && killall -q blueman-manager && exit 0
exec /usr/bin/blueman-manager
