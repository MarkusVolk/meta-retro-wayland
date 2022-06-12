#!/bin/sh

NUM_WORKSPACE=$(swaymsg -t get_outputs | jq -r '.[] | select(.focused)' | jq -r '.current_workspace' | cut -d: -f1)

[ $1 = "prev" ] && TO_WORKSPACE_NUM=$(expr $NUM_WORKSPACE - 1)
[ $1 = "next" ] && TO_WORKSPACE_NUM=$(expr $NUM_WORKSPACE + 1)

[ $TO_WORKSPACE_NUM = 11 ] && TO_WORKSPACE_NUM=1
[ $TO_WORKSPACE_NUM = 0 ] && TO_WORKSPACE_NUM=10

[ $TO_WORKSPACE_NUM = 1 ] && exec ~/.config/sway/scripts/kodi.sh;
[ $TO_WORKSPACE_NUM = 2 ] && exec ~/.config/sway/scripts/retroarch.sh;
[ $TO_WORKSPACE_NUM = 3 ] && exec ~/.config/sway/scripts/chromium.sh;
[ $TO_WORKSPACE_NUM = 4 ] && exec ~/.config/sway/scripts/thunar.sh;
[ $TO_WORKSPACE_NUM = 5 ] && exec ~/.config/sway/scripts/geary.sh;
[ $TO_WORKSPACE_NUM = 6 ]  && exec swaymsg workspace $ws$TO_WORKSPACE_NUM:;
[ $TO_WORKSPACE_NUM = 7 ] && exec swaymsg workspace $ws$TO_WORKSPACE_NUM:;
[ $TO_WORKSPACE_NUM = 8 ] && exec swaymsg workspace $ws$TO_WORKSPACE_NUM:;
[ $TO_WORKSPACE_NUM = 9 ] && exec swaymsg workspace $ws$TO_WORKSPACE_NUM:;
[ $TO_WORKSPACE_NUM = 10 ] && exec swaymsg workspace $ws$TO_WORKSPACE_NUM:Mpv  ;
