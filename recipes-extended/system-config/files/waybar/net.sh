#!/usr/bin/env sh

pidof connman-gtk && killall -q connman-gtk && exit 0
exec /usr/bin/connman-gtk

