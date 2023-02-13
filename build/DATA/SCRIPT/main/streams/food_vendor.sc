// main/stream/food_vendor.sc
//----------------------------------
// For the good of the nation the food vendor script from the original multifile has been decompiled
// and improved a bit, there's nothing very special to learn here except for the fact the triggerer
// is passed to the first local variable of the streamed script.
//----------------------------------
SCRIPT_START
{

LVAR_INT prop_cart      // The object which triggered this script is passed to the first variable.
LVAR_INT script_state
LVAR_INT vendor
LVAR_INT next_state_time

LVAR_INT game_timer temp_health
LVAR_FLOAT temp_x temp_y temp_z temp_heading
LVAR_FLOAT area_lower_x area_lower_y area_lower_z
LVAR_FLOAT area_upper_x area_upper_y area_upper_z

SCRIPT_NAME fodvend

script_state = 0
IF script_state = 1
    CREATE_OBJECT_NO_OFFSET ICESCART_PROP 0.0 0.0 0.0 prop_cart
ENDIF

food_vendor_loop:
WAIT 0
GET_GAME_TIMER game_timer
IF DOES_OBJECT_EXIST prop_cart
    IF IS_OBJECT_WITHIN_BRAIN_ACTIVATION_RANGE prop_cart
        IF IS_PLAYER_PLAYING player
            IF NOT HAS_OBJECT_BEEN_UPROOTED prop_cart

                IF script_state = 0 // still needs to create vendor
                    GET_OFFSET_FROM_OBJECT_IN_WORLD_COORDS prop_cart -1.0 0.0 -1.0 temp_x temp_y temp_z
                    area_lower_x = temp_x - 0.5
                    area_lower_y = temp_y - 0.5
                    area_lower_z = temp_z
                    area_upper_x = temp_x + 0.5
                    area_upper_y = temp_y + 0.5
                    area_upper_z = temp_z + 2.0
                    IF NOT IS_AREA_OCCUPIED (area_lower_x area_lower_y area_lower_z) (area_upper_x area_upper_y area_upper_z) FALSE FALSE TRUE FALSE FALSE
                        IF NOT IS_POINT_ON_SCREEN temp_x temp_y temp_z 1.0
                            REQUEST_MODEL BMOCHIL
                            IF HAS_MODEL_LOADED BMOCHIL
                                CREATE_CHAR (PEDTYPE_CIVMALE BMOCHIL) (temp_x temp_y temp_z) vendor
                                GET_OFFSET_FROM_OBJECT_IN_WORLD_COORDS prop_cart (1.0 0.0 0.0) (area_lower_x area_lower_y area_lower_z)
                                area_lower_x = area_lower_x - temp_x
                                area_lower_y = area_lower_y - temp_y
                                GET_HEADING_FROM_VECTOR_2D (area_lower_x area_lower_y) temp_heading
                                SET_CHAR_HEADING vendor temp_heading
                                ++script_state
                            ENDIF
                        ENDIF
                    ELSE
                        GOTO terminate_vendor_script
                    ENDIF
                ENDIF

                IF script_state = 1 // may buy food
                    IF LOCATE_CHAR_ON_FOOT_OBJECT_2D scplayer prop_cart 8.0 8.0 FALSE
                        REQUEST_ANIMATION VENDING
                        IF HAS_ANIMATION_LOADED VENDING
                            IF IS_SCORE_GREATER player 0
                                GET_OFFSET_FROM_OBJECT_IN_WORLD_COORDS prop_cart (1.0 0.0 0.0) (temp_x temp_y temp_z)
                                IF LOCATE_CHAR_ON_FOOT_3D scplayer (temp_x temp_y temp_z) (0.6 0.6 1.0) TRUE
                                    GET_CHAR_HEALTH scplayer temp_health
                                    temp_health += 50
                                    SET_CHAR_HEALTH scplayer temp_health
                                    TASK_PLAY_ANIM_SECONDARY scplayer VEND_EAT1_P VENDING 4.0 FALSE FALSE FALSE FALSE -1
                                    INCREMENT_INT_STAT 245 10
                                    next_state_time = game_timer + 3000
                                    ADD_SCORE player -1
                                    ++script_state
                                ENDIF
                            ENDIF
                        ENDIF
                    ENDIF
                ENDIF

                IF script_state = 2 // waiting for animation to end
                    IF game_timer > next_state_time
                        next_state_time = game_timer + 27000
                        ++script_state
                    ENDIF
                ENDIF

                IF script_state = 3 // waiting for next buy time and player get out of cart activation sphere
                    IF game_timer > next_state_time
                        GET_OFFSET_FROM_OBJECT_IN_WORLD_COORDS prop_cart 1.0 0.0 0.0 temp_x temp_y temp_z
                        IF NOT LOCATE_CHAR_ON_FOOT_3D scplayer temp_x temp_y temp_z 0.6 0.6 1.0 FALSE
                            script_state = 1
                        ENDIF
                    ENDIF
                ENDIF

            ELSE // HAS_OBJECT_BEEN_UPROOTED
                IF script_state > 0
                    IF IS_PLAYER_PLAYING player
                        IF NOT IS_CHAR_DEAD vendor
                            TASK_KILL_CHAR_ON_FOOT_TIMED vendor scplayer 10000
                        ENDIF
                    ENDIF
                ENDIF
                GOTO terminate_vendor_script
            ENDIF
        ELSE
            GOSUB mark_vendor_as_no_longer_needed
            MARK_MODEL_AS_NO_LONGER_NEEDED BMOCHIL
        ENDIF
    ELSE
        GOTO terminate_vendor_script
    ENDIF
ELSE
    GOTO terminate_vendor_script
ENDIF
GOTO food_vendor_loop

terminate_vendor_script:
    GOSUB mark_vendor_as_no_longer_needed
    MARK_MODEL_AS_NO_LONGER_NEEDED BMOCHIL
TERMINATE_THIS_SCRIPT

mark_vendor_as_no_longer_needed:
    IF script_state > 0
        MARK_CHAR_AS_NO_LONGER_NEEDED vendor
        REMOVE_ANIMATION VENDING
        script_state = 0
    ENDIF
RETURN

}
SCRIPT_END