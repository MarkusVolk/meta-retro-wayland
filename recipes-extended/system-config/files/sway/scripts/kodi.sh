#!/bin/sh

(pidof kodi && swaymsg "[app_id=Kodi] focus";) || \
(swaymsg "workspace 1:Kodi"; exec kodi ;)
