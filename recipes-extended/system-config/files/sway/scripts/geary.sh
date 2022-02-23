#!/bin/sh

(ps -e | grep geary && swaymsg "[app_id=geary] focus";) || \
(swaymsg "workspace $ws5"; exec geary;)
