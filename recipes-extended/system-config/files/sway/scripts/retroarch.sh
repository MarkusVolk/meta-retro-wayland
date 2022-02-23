#!/bin/sh

(ps -e | grep retroarch && swaymsg "[app_id=retroarch] focus";) || \
(swaymsg "workspace $ws2"; exec retroarch;)
