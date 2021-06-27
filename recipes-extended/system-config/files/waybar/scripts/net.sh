#!/usr/bin/env sh

ps -e | grep connman-gtk && killall -q connman-gtk && exit 0
exec /usr/bin/connman-gtk

