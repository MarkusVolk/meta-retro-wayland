#!/bin/sh

(ps -e | grep retroarch && swaymsg "[app_id=retroarch] focus";) || \
(swaymsg "workspace 2:Retroarch   "; exec retroarch;)
