#!/bin/sh

(pidof retroarch && swaymsg "[app_id=retroarch] focus";) || \
(swaymsg "workspace 2:Retroarch"; exec retroarch;)
