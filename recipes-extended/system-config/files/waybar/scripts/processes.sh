#!/usr/bin/env sh

ps -e | grep gnome-system-mo && killall -q gnome-system-monitor && exit 0
exec /usr/bin/gnome-system-monitor -p

