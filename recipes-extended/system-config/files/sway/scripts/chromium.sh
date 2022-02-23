#!/bin/sh

(ps -e | grep chromium-bin && swaymsg "[app_id=chromium-browser] focus";) || \
(swaymsg "workspace $ws3"; exec chromium ;)
