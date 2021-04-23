#!/bin/sh

(pidof thunar && swaymsg "[app_id=thunar] focus";) || \
(swaymsg "workspace 4:Thunar"; exec thunar;)
