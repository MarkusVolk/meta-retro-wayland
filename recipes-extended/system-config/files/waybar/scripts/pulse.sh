#!/usr/bin/env sh

pidof pavucontrol && killall -q pavucontrol && exit 0
exec /usr/bin/pavucontrol

