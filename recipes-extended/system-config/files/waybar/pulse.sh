#!/usr/bin/env sh

pidof pavucontrol && killall -q pavucontrol && exit 0
/usr/bin/pavucontrol

