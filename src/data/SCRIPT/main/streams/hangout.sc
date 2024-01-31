
SCRIPT_START
{
hangout:
    SCRIPT_NAME HANGOUT

    WAIT 1000
    MARK_STREAMED_SCRIPT_AS_NO_LONGER_NEEDED HANGOUT

    VAR_INT hangout_blip
    LVAR_INT partner stored_cur_char
    LVAR_FLOAT hangout_x hangout_y hangout_z 

    flag_player_on_activity = 1
    stored_cur_char = switch_cur_char

    STORE_CLOTHES_STATE

    IF caller = MICHAEL
        PRINT_HELP HGOM 
        hangout_x = 250.0
        hangout_y = -1227.0
        hangout_z = -100f
    ENDIF

    IF caller = FRANK
        PRINT_HELP HGOF 
        hangout_x =  1684.828 
        hangout_y = -2108.3677
        hangout_z = -100f
    ENDIF

    IF caller = TREVOR
        PRINT_HELP HGOT 
        hangout_x = -1041.3763 
        hangout_y = 1562.1898
        hangout_z = -100f
    ENDIF

    ADD_SPRITE_BLIP_FOR_COORD  hangout_x hangout_y hangout_z RADAR_SPRITE_GANG_G hangout_blip

    WHILE NOT LOCATE_CHAR_ANY_MEANS_2D hPlayerPed hangout_x hangout_y 5f 5f 1 
        WAIT 0
        IF flag_player_on_mission = 1
        OR NOT stored_cur_char = switch_cur_char
            GOTO hangout_exit
        ENDIF
    ENDWHILE

    DO_FADE 1000 0
    SET_PLAYER_CONTROL 0 0
    WAIT 1000

    GOSUB setup_player

    CREATE_CHAR PEDTYPE_GANG1 0 hangout_x hangout_y hangout_z partner
    SET_CHAR_HEALTH partner 100
    GET_PLAYER_GROUP 0 player_group
    SET_GROUP_MEMBER player_group partner
    REQUEST_MODEL MICRO_UZI
    LOAD_ALL_MODELS_NOW
    GIVE_WEAPON_TO_CHAR partner WEAPONTYPE_MICRO_UZI 999
    SET_CHAR_NEVER_TARGETTED partner 1
    
    REMOVE_BLIP hangout_blip

    flag_player_on_mission = 1

    RESTORE_CLOTHES_STATE
    BUILD_PLAYER_MODEL iPlayer

    DO_FADE 1000 1
    SET_PLAYER_CONTROL 0 1

    WHILE IS_CHAR_HEALTH_GREATER hPlayerPed 1
    AND IS_CHAR_HEALTH_GREATER partner 1
        WAIT 0
        IF IS_BUTTON_PRESSED 1 START //TEST_CHEAT start
            DO_FADE 0 0
            GET_CHAR_COORDINATES partner hangout_x hangout_y hangout_z
            DELETE_CHAR partner
            GOSUB setup_player
            CREATE_PLAYER 1 hangout_x hangout_y hangout_z player2
            RESTORE_CLOTHES_STATE
            BUILD_PLAYER_MODEL 0
            GET_PLAYER_CHAR 1 partner
            GIVE_WEAPON_TO_CHAR partner WEAPONTYPE_MICRO_UZI 999
            SET_TWO_PLAYER_CAMERA_MODE 1
            DO_FADE 0 1
        ENDIF
    ENDWHILE

    hangout_exit:

    IF DOES_CHAR_EXIST partner
        DELETE_CHAR partner
    ENDIF

    IF DOES_CHAR_EXIST player2
        DELETE_PLAYER 1
    ENDIF

    REMOVE_BLIP hangout_blip

    flag_player_on_activity = 0
    flag_player_on_mission = 0
    MARK_MODEL_AS_NO_LONGER_NEEDED MICRO_UZI
    SET_TWO_PLAYER_CAMERA_MODE 0

    TERMINATE_THIS_SCRIPT

    setup_player:
        IF caller = MICHAEL
            GIVE_PLAYER_CLOTHES iPlayer 0 0 13 
            GIVE_PLAYER_CLOTHES iPlayer 0 0 14 
            GIVE_PLAYER_CLOTHES iPlayer 0 0 15 
            GIVE_PLAYER_CLOTHES iPlayer 0 0 16 
            GIVE_PLAYER_CLOTHES iPlayer 0 0 17 
            GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP iPlayer SUIT1YELLOW SUIT1 0 
            GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP iPlayer SUIT1TRYELLOW SUIT1TR 2 
            GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP iPlayer SHOEDRESSBLK SHOE 3 
            GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP iPlayer JHERICURL JHERI 1 
            GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP iPlayer 4RIP 4RIP 4  
            BUILD_PLAYER_MODEL iPlayer
        ENDIF

        IF caller = FRANK 
            GIVE_PLAYER_CLOTHES iPlayer 0 0 13 
            GIVE_PLAYER_CLOTHES iPlayer 0 0 14 
            GIVE_PLAYER_CLOTHES iPlayer 0 0 15 
            GIVE_PLAYER_CLOTHES iPlayer 0 0 16 
            GIVE_PLAYER_CLOTHES iPlayer 0 0 17 
            GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP iPlayer SHIRTABLUE SHIRTA 0 
            GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP iPlayer LEATHERTR LEATHERTR 2 
            GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP iPlayer SHOEDRESSBLK SHOE 3 
            GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP iPlayer PLAYER_FACE HEAD 1   
            BUILD_PLAYER_MODEL iPlayer 
        ENDIF 

        IF caller = TREVOR
            GIVE_PLAYER_CLOTHES iPlayer 0 0 13 
            GIVE_PLAYER_CLOTHES iPlayer 0 0 14 
            GIVE_PLAYER_CLOTHES iPlayer 0 0 15 
            GIVE_PLAYER_CLOTHES iPlayer 0 0 16 
            GIVE_PLAYER_CLOTHES iPlayer 0 0 17 
            GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP iPlayer TSHIRT TSHIRT 0 
            GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP iPlayer LEATHERTR LEATHERTR 2 
            GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP iPlayer SHOEDRESSBLK SHOE 3 
            GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP iPlayer WEDGE WEDGE 1 
            GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP iPlayer 4RIP 4RIP 4     
            BUILD_PLAYER_MODEL iPlayer  
        ENDIF 
    RETURN


}
SCRIPT_END