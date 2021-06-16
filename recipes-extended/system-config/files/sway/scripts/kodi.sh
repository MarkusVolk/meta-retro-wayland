#!/bin/sh

(ps -e | grep kodi && swaymsg "[app_id=Kodi] focus";) || \
(swaymsg "workspace 1:Kodi"; exec kodi ;)
