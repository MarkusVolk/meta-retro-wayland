#!/usr/bin/env sh

pidof gparted && sudo killall -q gparted && exit 0
sudo env XDG_RUNTIME_DIR=$XDG_RUNTIME_DIR /usr/sbin/gparted

