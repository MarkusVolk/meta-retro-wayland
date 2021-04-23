#!/bin/sh

(pidof chromium-bin && swaymsg "[app_id=Chromium-browser] focus";) || \
(swaymsg "workspace 3:Chromium"; exec chromium ;)
