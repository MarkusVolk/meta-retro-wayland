#!/usr/bin/env sh

pidof connman-gtk && killall -q connman-gtk && exit 0
/usr/bin/connman-gtk

