#!/bin/sh

(ps -e | grep retroarch && swaymsg "[app_id=org.libretro.RetroArch] focus";) || \
(swaymsg "workspace $ws2"; exec retroarch;)
