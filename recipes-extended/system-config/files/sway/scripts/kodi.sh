#!/bin/sh

(ps -e | grep kodi && swaymsg "[app_id=Kodi] focus";) || \
(swaymsg "workspace $ws1"; exec kodi ;)
