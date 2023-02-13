// main/other_scripts.sc
MISSION_START
SET_DEATHARREST_STATE OFF
MISSION_END

// Another use for subscripts is including labels in another file,
// like labels for GOSUBs or for START_NEW_SCRIPTs.

{
some_random_script:
TERMINATE_THIS_SCRIPT
// you can use START_NEW_SCRIPT some_random_script from anywhere now.
}

some_random_gosub:
RETURN
// you can use GOSUB some_random_gosub from anywhere now.

{
    cart_teleport:
    WAIT 0
    IF IS_PLAYER_PLAYING player
        IF IS_CHAR_IN_AREA_ON_FOOT_3D scplayer (-15.0, 5.0 4.0) (-14.0 2.0 0.0) TRUE
            REQUEST_COLLISION -2157.6257 -425.5779
            LOAD_ALL_MODELS_NOW
            SET_CHAR_COORDINATES scplayer -2157.6257 -425.5779 -100.0
            ADD_SCORE player 100 // some money to buy food
        ENDIF
    ENDIF
    GOTO cart_teleport
}