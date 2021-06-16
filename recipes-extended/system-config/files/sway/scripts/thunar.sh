#!/bin/sh

(ps -e | grep thunar && swaymsg "[app_id=thunar] focus";) || \
(swaymsg "workspace 4:Thunar"; exec thunar;)
