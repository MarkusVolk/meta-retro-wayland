#!/usr/bin/env sh

ps -e | grep pavucontrol && killall -q pavucontrol && exit 0
exec /usr/bin/pavucontrol

