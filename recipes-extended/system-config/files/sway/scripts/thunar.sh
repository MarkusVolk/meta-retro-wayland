#!/bin/sh

(ps -e | grep thunar && swaymsg "[app_id=thunar] focus";) || \
(swaymsg "workspace $ws4"; exec thunar;)
