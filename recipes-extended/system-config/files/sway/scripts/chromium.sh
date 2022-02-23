#!/bin/sh

(ps -e | grep chromium-bin && swaymsg "[app_id=chromium-browser] focus";) || \
(swaymsg "workspace 3:Chromium  "; exec chromium ;)
