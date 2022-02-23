#!/bin/sh

(ps -e | grep geary && swaymsg "[app_id=geary] focus";) || \
(swaymsg "workspace 5:Geary  "; exec geary;)
