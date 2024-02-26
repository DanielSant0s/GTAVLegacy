// GTA V Legacy Main Script - Created by Daniel Santos
GOTO start

DUMP 
00 // Alignment
ENDDUMP

lpTextBuffer:
DUMP // Size: 512, reserved for text buffering
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
ENDDUMP

lpPeopleSquareGenObjects:
DUMP // Size: 64, 16 handlers with 4 byte size
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
ENDDUMP

lpPeopleSquareGenPeds:
DUMP // Size: 64, 16 handlers with 4 byte size
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
ENDDUMP

lpPeopleSquareGenTimers:
DUMP // Size: 64, 16 handlers with 4 byte size
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
ENDDUMP

lpPeopleSquareGenMaxTimes:
DUMP // Size: 64, 16 handlers with 4 byte size
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
ENDDUMP

start:
// Basic Init
SCRIPT_NAME main

VAR_INT iPlayer hPlayerPed player_group pPlayerPed
VAR_INT flag_player_on_mission hook_ptr
VAR_INT is_drawing

VAR_INT switch_cur_char switch_new_char 
VAR_INT switch_money[3] switch_wanted[3] 
VAR_INT switch_last_used_car[3] switch_in_car[3] 
VAR_INT char_r[3] char_g[3] char_b[3]
VAR_INT char_add_color[3] char_replace_color[3] 
VAR_FLOAT switch_x[3] switch_y[3] switch_z[3] 
VAR_FLOAT switch_new_x[3] switch_new_y[3] switch_new_z[3]
VAR_FLOAT switch_ability[3]

VAR_INT life_pickup gas_pickup

VAR_INT pTextBuffer

DO_FADE 0 FADE_OUT
DISPLAY_RADAR FALSE
DISPLAY_HUD FALSE
DISPLAY_ZONE_NAMES FALSE
DISPLAY_CAR_NAMES FALSE
CLEAR_HELP

GET_LABEL_POINTER (lpTextBuffer) (pTextBuffer)

VAR_INT pPeopleSquareGenObjects pPeopleSquareGenPeds pPeopleSquareGenTimers pPeopleSquareGenMaxTimes
GET_LABEL_POINTER (lpPeopleSquareGenObjects) (pPeopleSquareGenObjects)
GET_LABEL_POINTER (lpPeopleSquareGenPeds) (pPeopleSquareGenPeds)
GET_LABEL_POINTER (lpPeopleSquareGenTimers) (pPeopleSquareGenTimers)
GET_LABEL_POINTER (lpPeopleSquareGenMaxTimes) (pPeopleSquareGenMaxTimes)

VAR_INT beggar_ids[8]
beggar_ids[0] = 79
beggar_ids[1] = 134
beggar_ids[2] = 135
beggar_ids[3] = 136
beggar_ids[4] = 137
beggar_ids[5] = 212
beggar_ids[6] = 230
beggar_ids[7] = 239

char_r[0] = 0
char_g[0] = 220
char_b[0] = 50

char_r[1] = 0
char_g[1] = 80
char_b[1] = 200

char_r[2] = 150
char_g[2] = 70
char_b[2] = 70

char_add_color[0] = 0xFF233626
char_add_color[1] = 0xFF362c23
char_add_color[2] = 0xFF232336

char_replace_color[0] = 0x80808080
char_replace_color[1] = 0x80808080
char_replace_color[2] = 0x80808080

switch_ability[0] = 100f
switch_ability[1] = 100f
switch_ability[2] = 100f

CONST_INT toggleBlur 0x110498

CONST_INT CPostEffects_m_bGrainEnable 0x66C70C
CONST_INT MaxHealth 0x70974B
CONST_INT UpdateCompareFlag 0x3077F0

CONST_INT printf 0x54F7D0 
CONST_INT strlen 0x5517B8 
CONST_INT ENDLINE 0x0A 

CONST_INT PLAYER_FRANKLIN 0
CONST_INT PLAYER_MICHAEL 1
CONST_INT PLAYER_TREVOR 2

SET_DEATHARREST_STATE (OFF)

SET_TOTAL_NUMBER_OF_MISSIONS (0)
SET_PROGRESS_TOTAL (0)
SET_MISSION_RESPECT_TOTAL (0)

SET_INT_STAT (181, 4)
SET_INT_STAT (23, 40)
SHOW_UPDATE_STATS (0)

player_phone_theme[0] = 8
player_phone_theme[1] = 6
player_phone_theme[2] = 0

CREATE_PLAYER (0, 223.3513, -1753.368, 4.6704) (iPlayer)

GET_PLAYER_CHAR (iPlayer) (hPlayerPed)
GET_PED_POINTER (hPlayerPed) (pPlayerPed)
GET_PLAYER_GROUP (iPlayer) (player_group)
SET_GROUP_LEADER (player_group, hPlayerPed)

REQUEST_COLLISION (223.3513, -1753.368)
LOAD_SCENE (223.3513, -1753.368, 4.6704)

CREATE_PICKUP (1240, PICKUP_ON_STREET, 223.3513, -1753.368, 4.6704) (life_pickup)
CREATE_PICKUP (322, PICKUP_ON_STREET, 223.783936 -1760.698364 4.737206) (gas_pickup)

SET_CAMERA_BEHIND_PLAYER ()
SET_CHAR_HEADING (hPlayerPed, 9.83518)

flag_player_on_mission = FALSE
DECLARE_MISSION_FLAG (flag_player_on_mission)

GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP (iPlayer, SHIRTABLUE, SHIRTA, 0)
GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP (iPlayer, PLAYER_FACE, HEAD, 1)
GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP (iPlayer, JEANSDENIM, JEANS, 2)
GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP (iPlayer, SHOEDRESSBLK, SHOE, 3)
BUILD_PLAYER_MODEL (iPlayer)

ADD_HOSPITAL_RESTART (0.0, 0.0, 5.0, 0.0, 0)
ADD_POLICE_RESTART (0.0, 0.0, 5.0, 0.0, 0)

SET_TIME_OF_DAY (10, 0)

is_drawing = 0

WAIT 5000

VAR_INT story_mode
story_mode = FALSE

LOAD_AND_LAUNCH_MISSION initial.sc
WAIT (0)

IF story_mode = TRUE
    LOAD_AND_LAUNCH_MISSION intro.sc
ELSE
    DO_FADE (1000, FADE_IN)
    DISPLAY_RADAR TRUE
    DISPLAY_HUD TRUE
    DISPLAY_ZONE_NAMES TRUE
    DISPLAY_CAR_NAMES TRUE
    CLEAR_HELP
ENDIF

WAIT (0)

SET_PLAYER_CONTROL (iPlayer, ON)

//START_NEW_SCRIPT psave

START_NEW_SCRIPT (debug_menu)
START_NEW_SCRIPT (char_switcher)
START_NEW_SCRIPT (weapon_selector)
START_NEW_SCRIPT (improvedMove)
START_NEW_SCRIPT (life_recovery)
START_NEW_SCRIPT (manual_reload)
START_NEW_SCRIPT (car_wash)
START_NEW_SCRIPT (als)
START_NEW_SCRIPT (chop_companion)
START_NEW_SCRIPT (beggar_camps_activator)
START_NEW_SCRIPT (taxi)
START_NEW_SCRIPT (robbery)
START_NEW_SCRIPT (plane_camera)
START_NEW_SCRIPT (manual_driveby)
START_NEW_SCRIPT (first_person_vehicle_camera)
START_NEW_SCRIPT (pacific_arrest)
START_NEW_SCRIPT (car_crash_inertia)
START_NEW_SCRIPT (speed_shake)
START_NEW_SCRIPT (street_racing)
START_NEW_SCRIPT (break_locked_car_glass)
START_NEW_SCRIPT (shoreline_waves, 0)
START_NEW_SCRIPT (shoreline_waves, 1)
START_NEW_SCRIPT (shoreline_waves, 2)
START_NEW_SCRIPT (people_gen_squares) 
START_NEW_SCRIPT (ability_system)
START_NEW_SCRIPT (rpg_backview)
START_NEW_SCRIPT (fire_oil_system)
START_NEW_SCRIPT (submarine)
START_NEW_SCRIPT (legalize_it_michael)
START_NEW_SCRIPT (random_events)
//START_NEW_SCRIPT (SNOW_11)

WAIT (0) // Start our scripts

CONST_INT LoadCodeOverlay 0x3C6990
CONST_INT UnloadCodeOverlay 0x3C6AA0
CONST_INT OverlaySpace 0x88D880

CONST_INT erl_flush_symbols 0x890338
CONST_INT find_erl 0x8902B0

// VAR_INT pCurPlugin

// CALL_FUNCTION LoadCodeOverlay (2, 0) ("relocator.nm", OverlaySpace)

// CALL_FUNCTION_RETURN find_erl (1, 0) ("cleo_ps2") (pCurPlugin)

// IF pCurPlugin > 0
//     CPRINTLN( "CLEO Library found at 0x%X, flushing symbols...", pCurPlugin )
//     CALL_FUNCTION erl_flush_symbols (1, 0) (pCurPlugin)
// ENDIF

// CALL_FUNCTION UnloadCodeOverlay (0, 0) ()

VAR_INT pLibraryObjectAddress iLibraryObject pAllowRadioWheelDrawing pRadioWheelVisible

IF GET_DYNAMIC_LIBRARY_PROCEDURE ("allow_radiowheel_drawing", 0) (pAllowRadioWheelDrawing)
    CPRINTLN( "GTA V Legacy: [Plugin <> Script Interface] allow_radiowheel_drawing collected" )
ENDIF

IF GET_DYNAMIC_LIBRARY_PROCEDURE ("radiowheel_visible", 0) (pRadioWheelVisible)
    CPRINTLN( "GTA V Legacy: [Plugin <> Script Interface] radiowheel_visible collected" )
ENDIF

//LAUNCH_MISSION (import.sc)
//LAUNCH_MISSION (other_scripts.sc)

REGISTER_STREAMED_SCRIPT (CARMOD1, carmod1.sc)
REGISTER_STREAMED_SCRIPT (VPHONE, vphone.sc)
REGISTER_STREAMED_SCRIPT (HANGOUT, hangout.sc)
REGISTER_STREAMED_SCRIPT (MODMENU, modmenu.sc) 
//REGISTER_STREAMED_SCRIPT (FOOD_VENDOR, food_vendor.sc)

CONST_INT GARAGE_OPEN_FOR_LOW_RIDERS 36
CONST_INT GARAGE_OPEN_FOR_STREET_RACERS 37
CONST_INT GARAGE_OPEN_FOR_NORMAL_CARS 38

// LA Normal Cars
CHANGE_GARAGE_TYPE (bodLAwN, GARAGE_OPEN_FOR_NORMAL_CARS)

// LA LowRiders (Neils Lowrider garage)
CHANGE_GARAGE_TYPE (modlast, GARAGE_OPEN_FOR_LOW_RIDERS)

// San Fran Normal Cars
CHANGE_GARAGE_TYPE (mdsSFSe, GARAGE_OPEN_FOR_NORMAL_CARS)

// San Fran Street Racer Garage
CHANGE_GARAGE_TYPE (mds1SFS, GARAGE_OPEN_FOR_STREET_RACERS)

// Vegas Normal Cars
CHANGE_GARAGE_TYPE (vEcmod, GARAGE_OPEN_FOR_NORMAL_CARS)

// GARAGE LOCATES FOR PLAYER TO STOP IN
// LA normal garage
CONST_FLOAT LS_NR_GARAGEX 1042.013 // 1042.263
CONST_FLOAT LS_NR_GARAGEY -1019.927 // -1013.566
CONST_FLOAT LS_NR_GARAGEZ 31.127

// LA lowrider garage Old one under bridge (Neils Mission one)  
CONST_FLOAT LS_LR_GARAGEX 2645.112
CONST_FLOAT LS_LR_GARAGEY -2045.745
CONST_FLOAT LS_LR_GARAGEZ 12.607

// San Fran normal garage
CONST_FLOAT SF_NR_GARAGEX -1935.528
CONST_FLOAT SF_NR_GARAGEY 247.029
CONST_FLOAT SF_NR_GARAGEZ 33.561

// San Fran Street Racer Garage
CONST_FLOAT SF_SR_GARAGEX -2723.845 
CONST_FLOAT	SF_SR_GARAGEY 217.804
CONST_FLOAT SF_SR_GARAGEZ 3.585

// Vegas normal garage
CONST_FLOAT LV_NR_GARAGEX 2387.075
CONST_FLOAT LV_NR_GARAGEY 1050.511
CONST_FLOAT LV_NR_GARAGEZ 9.812

// used for help messages for nitros
VAR_INT flag_1st_time_nitro_shop 
flag_1st_time_nitro_shop = 0   

//VAR_INT addr 

//ALLOCATE_MEMORY 16384 (addr)
//PRINT_FORMATTED_NOW "16KB Malloc ptr: 0x%x" 99999999

VAR_INT carro player2 phone_obj2

VAR_INT lscustoms_enabled
lscustoms_enabled = FALSE

main_loop:
WAIT (250)

// This is basically how you'd stream a streamed script manually:
IF IS_GARAGE_OPEN (BODLAWN)
OR IS_GARAGE_OPEN (MODLAST)
OR IS_GARAGE_OPEN (MDSSFSE)
OR IS_GARAGE_OPEN (MDS1SFS)
OR IS_GARAGE_OPEN (VECMOD)
OR lscustoms_enabled = TRUE
    GET_NUMBER_OF_INSTANCES_OF_STREAMED_SCRIPT (CARMOD1, num_carmod_instances)
    IF num_carmod_instances = 0
        STREAM_SCRIPT (CARMOD1)
        IF HAS_STREAMED_SCRIPT_LOADED (CARMOD1)
            START_NEW_STREAMED_SCRIPT (CARMOD1)   // Tip: You can send values just like START_NEW_SCRIPT
        ENDIF
    ENDIF
ELSE
    MARK_STREAMED_SCRIPT_AS_NO_LONGER_NEEDED (CARMOD1)
ENDIF

IF IS_BUTTON_PRESSED (PAD1, DPADUP)
AND NOT READ_MEMORY_BOOL (pRadioWheelVisible, 1)

    WRITE_MEMORY (pAllowRadioWheelDrawing, 1, 0 TRUE)
    GET_NUMBER_OF_INSTANCES_OF_STREAMED_SCRIPT (VPHONE, num_carmod_instances)
    IF num_carmod_instances = 0
    AND is_drawing = 0
        is_drawing = 1
        STREAM_SCRIPT (VPHONE)
        LOAD_ALL_MODELS_NOW ()
        START_NEW_STREAMED_SCRIPT (VPHONE)
        WAIT (0)
        MARK_STREAMED_SCRIPT_AS_NO_LONGER_NEEDED (VPHONE)
    ENDIF  
ENDIF

GOTO main_loop

// Let's declare a few more variables.
// Usually this should be  the very top of the script, but avoid poluting the 'minimal multifile' sample,
// we'll declare them here.
VAR_INT mistery_blip flag_mistery1_passed flag_mistery2_passed 
VAR_FLOAT mistery_xpos mistery_ypos mistery_zpos
VAR_INT num_carmod_instances dogcart1

// This is a simple save game script.
// After spawning, turn around and look for a save pickup and play with it.
// Again, no comments needed.
{
    psave:
    SCRIPT_NAME psave

    LVAR_INT save_pickup pickup_created
    pickup_created = 0

    // Remeber the entities tutorial? Try compiling without those lines:
    IF pickup_created = 1
        CREATE_PICKUP (0, PICKUP_NONE, 0.0, 0.0, 0.0) (save_pickup)
    ENDIF

    psave_loop:
    WAIT 0
    IF flag_player_on_mission = 0
        GOSUB psave_create_pickup
        IF IS_PLAYER_PLAYING (iPlayer)
        AND HAS_PICKUP_BEEN_COLLECTED (save_pickup)
            GOSUB psave_do_save
            GOSUB psave_destroy_pickup
            GOSUB psave_create_pickup
            GOSUB psave_respawn_player
        ENDIF
    ELSE
        GOSUB psave_destroy_pickup
        WAIT (1000)
    ENDIF
    GOTO psave_loop

    psave_do_save:
        SET_PLAYER_CONTROL (iPlayer, OFF)
        ACTIVATE_SAVE_MENU ()
        WHILE NOT HAS_SAVE_GAME_FINISHED ()
            WAIT (0)
        ENDWHILE
        SET_FADING_COLOUR (0, 0, 0)
        DO_FADE (1000, FADE_OUT)
        SET_PLAYER_CONTROL (iPlayer, OFF)
    RETURN

    psave_respawn_player:
        IF IS_PLAYER_PLAYING (iPlayer)
            CLEAR_AREA (15.0, 0.0, 4.0, 1.0, TRUE)
            SET_CHAR_COORDINATES (hPlayerPed, 15.0, 0.0, 4.0)
        ENDIF
        WAIT (0)
        DO_FADE (1000, FADE_IN)
        RESTORE_CAMERA_JUMPCUT ()
        SET_CAMERA_BEHIND_PLAYER ()
        WAIT (500)
        IF IS_PLAYER_PLAYING (iPlayer)
            SET_PLAYER_CONTROL (iPlayer, ON)
        ENDIF
    RETURN

    psave_create_pickup:
        IF pickup_created = 0
            pickup_created = 1
            CREATE_PICKUP (PICKUPSAVE, PICKUP_ONCE, 10.0, 0.0, 3.0) (save_pickup)
        ENDIF
    RETURN

    psave_destroy_pickup:
        IF pickup_created = 1
            pickup_created = 0
            REMOVE_PICKUP (save_pickup)
        ENDIF
    RETURN
}


{
    random_events:
    LVAR_INT iRand

    random_events_loop:
        WAIT 100 

        GENERATE_RANDOM_INT_IN_RANGE (0, 100) (iRand)

        IF iRand = 15
        OR iRand = 50
        OR iRand = 85
            IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 718.973694 -1101.235107 19.471481 100.0 100.0 3.0 FALSE
                CLEO_CALL securicar_assault 0 718.973694 -1101.235107 19.471481 328.988770
                WHILE LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 718.973694 -1101.235107 19.471481 110.0 110.0 3.0 FALSE
                    WAIT 0
                ENDWHILE
            ENDIF

            IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 621.967651 -829.408081 23.572269 100.0 100.0 3.0 FALSE
                CLEO_CALL securicar_assault 0 621.967651 -829.408081 23.572269 2.720037
                WHILE LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 621.967651 -829.408081 23.572269 110.0 110.0 3.0 FALSE
                    WAIT 0
                ENDWHILE
            ENDIF

            IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1649.060791 -1968.489014 23.287500 100.0 100.0 3.0 FALSE
                CLEO_CALL securicar_assault 0 1649.060791 -1968.489014 23.287500 191.564285
                WHILE LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1649.060791 -1968.489014 23.287500 110.0 110.0 3.0 FALSE
                    WAIT 0
                ENDWHILE
            ENDIF

            IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 440.155334 -1515.068481 30.371260 100.0 100.0 3.0 FALSE
                CLEO_CALL securicar_assault 0 440.155334 -1515.068481 30.371260 185.553589
                WHILE LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 440.155334 -1515.068481 30.371260 110.0 110.0 3.0 FALSE
                    WAIT 0
                ENDWHILE
            ENDIF

            IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1227.666016 -1523.618286 13.546875 100.0 100.0 3.0 FALSE
                CLEO_CALL wallet_robbery 0 1227.666016 -1523.618286 13.546875 90.432434 1251.456543 -1523.751587 13.554897
                WHILE LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1227.666016 -1523.618286 13.546875 110.0 110.0 3.0 FALSE
                    WAIT 0
                ENDWHILE
            ENDIF

            IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1631.847534 -1689.786255 13.367046 100.0 100.0 3.0 FALSE
                CLEO_CALL wallet_robbery 0 1631.847534 -1689.786255 13.367046 358.14 1631.834473 -1695.477295 13.364292
                WHILE LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1631.847534 -1689.786255 13.367046 110.0 110.0 3.0 FALSE
                    WAIT 0
                ENDWHILE
            ENDIF

            IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1137.094849, -1630.775391, 13.876565 100.0 100.0 3.0 FALSE
                CLEO_CALL atm_robbery 0 1137.094849, -1630.775391, 13.876565, 174.737030 1142.308838, -1644.272095, 13.945395
                WHILE LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1137.094849, -1630.775391, 13.876565 110.0 110.0 3.0 FALSE
                    WAIT 0
                ENDWHILE
            ENDIF

            IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1009.123047 -948.001465 42.260448 100.0 100.0 3.0 FALSE
                CLEO_CALL atm_robbery 0 1009.583862  -929.517822,  42.328125, 8.075090,  1009.123047, -948.001465, 42.260448
                WHILE LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1009.123047 -948.001465 42.260448 110.0 110.0 3.0 FALSE
                    WAIT 0
                ENDWHILE
            ENDIF


            IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 2396.475098 -1403.695068 24.000000 100.0 100.0 3.0 FALSE
                CLEO_CALL bike_hijacking_1 0
                WHILE LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 2396.475098 -1403.695068 24.000000 110.0 110.0 3.0 FALSE
                    WAIT 0
                ENDWHILE
            ENDIF

            IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1861.382690 -1370.008789 13.137326 100.0 100.0 3.0 FALSE
                CLEO_CALL bike_hijacking_2 0
                WHILE LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1861.382690 -1370.008789 13.137326 110.0 110.0 3.0 FALSE
                    WAIT 0
                ENDWHILE
            ENDIF

            IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 125.620537 -1483.763428 17.401913 100.0 100.0 15.0 FALSE
                CLEO_CALL sport_bike_hijacking_1 0
                WHILE LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 125.620537 -1483.763428 17.401913 110.0 110.0 15.0 FALSE
                    WAIT 0
                ENDWHILE
            ENDIF

            IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed -86.535606 -1151.513916 1.755659 100.0 100.0 15.0 FALSE
                CLEO_CALL car_hijacking_1 0
                WHILE LOCATE_CHAR_ANY_MEANS_3D hPlayerPed -86.535606 -1151.513916 1.755659 110.0 110.0 15.0 FALSE
                    WAIT 0
                ENDWHILE
            ENDIF

            IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1648.484619 -1136.189697 23.643808 100.0 100.0 15.0 FALSE
                CLEO_CALL car_hijacking_2 0
                WHILE LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1648.484619 -1136.189697 23.643808 110.0 110.0 15.0 FALSE
                    WAIT 0
                ENDWHILE
            ENDIF

        ENDIF
    GOTO random_events_loop
}

{
    LVAR_FLOAT x y z h
    securicar_assault:

    LVAR_INT hSecurityCar hDriverPed hGuardPed hDriverSeq hMoneyPickup iMoneyAmount hcarBlip
    LVAR_FLOAT v3dCarCoords[3] v3dDetMin[3] v3dDetMax[3] v3dMoneyCoords[3]

    REQUEST_MODEL SECURICA
    REQUEST_MODEL WMYSGRD
    REQUEST_MODEL 1550 // CJ_MONEY_BAG
    REQUEST_MODEL M4
    
    WHILE NOT HAS_MODEL_LOADED SECURICA 
    OR NOT HAS_MODEL_LOADED WMYSGRD
    OR NOT HAS_MODEL_LOADED M4
    OR NOT HAS_MODEL_LOADED 1550
        WAIT 0
    ENDWHILE

    WHILE IS_POINT_ON_SCREEN x y z 5.0
        WAIT 0
    ENDWHILE

    CREATE_CAR SECURICA x y z hSecurityCar
    SET_CAR_PROOFS hSecurityCar TRUE TRUE TRUE FALSE FALSE
    SET_CAR_HEADING hSecurityCar h
    CHANGE_CAR_COLOUR hSecurityCar 1, 86

    CREATE_CHAR PEDTYPE_CIVMALE WMYSGRD 0.0 0.0 0.0 hDriverPed
    WARP_CHAR_INTO_CAR hDriverPed hSecurityCar
    CREATE_CHAR PEDTYPE_CIVMALE WMYSGRD 0.0 0.0 0.0 hGuardPed
    WARP_CHAR_INTO_CAR_AS_PASSENGER hGuardPed hSecurityCar 3

    TASK_CAR_DRIVE_WANDER hDriverPed hSecurityCar 12.0 2

    ADD_BLIP_FOR_CAR (hSecurityCar) (hcarBlip)
    CHANGE_BLIP_DISPLAY (hcarBlip, BLIP_ONLY)
    CHANGE_BLIP_COLOUR (hcarBlip, 0x63C5DAFF)

    WHILE LOCATE_CHAR_ANY_MEANS_CAR_3D hPlayerPed hSecurityCar 100.0 100.0 15.0 FALSE
        GET_OFFSET_FROM_CAR_IN_WORLD_COORDS hSecurityCar 0.0 0.0 0.0 v3dCarCoords[0] v3dCarCoords[1] v3dCarCoords[2]
		v3dDetMin[0] = v3dCarCoords[0] - 10.0
        v3dDetMin[1] = v3dCarCoords[1] - 10.0
        v3dDetMin[2] = v3dCarCoords[2] - 10.0

		v3dDetMax[0] = v3dCarCoords[0] + 10.0
		v3dDetMax[1] = v3dCarCoords[1] + 10.0
		v3dDetMax[2] = v3dCarCoords[2] + 10.0

        IF IS_EXPLOSION_IN_AREA EXPLOSION_GRENADE v3dDetMin[0] v3dDetMin[1] v3dDetMin[2] v3dDetMax[0] v3dDetMax[1] v3dDetMax[2]
        OR IS_EXPLOSION_IN_AREA EXPLOSION_ROCKET v3dDetMin[0] v3dDetMin[1] v3dDetMin[2] v3dDetMax[0] v3dDetMax[1] v3dDetMax[2]
        OR IS_EXPLOSION_IN_AREA EXPLOSION_MINE v3dDetMin[0] v3dDetMin[1] v3dDetMin[2] v3dDetMax[0] v3dDetMax[1] v3dDetMax[2]
        OR IS_EXPLOSION_IN_AREA EXPLOSION_ROCKET_WEAK v3dDetMin[0] v3dDetMin[1] v3dDetMin[2] v3dDetMax[0] v3dDetMax[1] v3dDetMax[2]
        OR IS_EXPLOSION_IN_AREA EXPLOSION_SMALL v3dDetMin[0] v3dDetMin[1] v3dDetMin[2] v3dDetMax[0] v3dDetMax[1] v3dDetMax[2]
        OR IS_EXPLOSION_IN_AREA EXPLOSION_TINY v3dDetMin[0] v3dDetMin[1] v3dDetMin[2] v3dDetMax[0] v3dDetMax[1] v3dDetMax[2]

            SET_CAR_CRUISE_SPEED hSecurityCar 0.0

            OPEN_CAR_DOOR hSecurityCar 4
            OPEN_CAR_DOOR hSecurityCar 5

            TASK_EVERYONE_LEAVE_CAR hSecurityCar

            GIVE_WEAPON_TO_CHAR hDriverPed WEAPONTYPE_M4 99999
            GIVE_WEAPON_TO_CHAR hGuardPed WEAPONTYPE_M4 99999

            SET_CHAR_SHOOT_RATE hDriverPed 70
            SET_CHAR_SHOOT_RATE hGuardPed 70

            TASK_KILL_CHAR_ON_FOOT hDriverPed hPlayerPed
            TASK_KILL_CHAR_ON_FOOT hGuardPed hPlayerPed

            GET_OFFSET_FROM_CAR_IN_WORLD_COORDS hSecurityCar 0.0 -4.0 0.0 v3dMoneyCoords[0] v3dMoneyCoords[1] v3dMoneyCoords[2]

            CREATE_PICKUP 1550 PICKUP_ONCE v3dMoneyCoords[0] v3dMoneyCoords[1] v3dMoneyCoords[2] (hMoneyPickup)

            WHILE NOT HAS_PICKUP_BEEN_COLLECTED hMoneyPickup
                IF NOT LOCATE_CHAR_ANY_MEANS_CAR_3D hPlayerPed hSecurityCar 50.0 50.0 15.0 FALSE
                    GOTO securicar_assault_free_assets
                ENDIF
                WAIT 0
            ENDWHILE

            GENERATE_RANDOM_INT_IN_RANGE 3000 8000 (iMoneyAmount)
            ADD_SCORE 0 iMoneyAmount

            WHILE NOT IS_CHAR_DEAD hDriverPed
            OR NOT IS_CHAR_DEAD hGuardPed
                IF NOT LOCATE_CHAR_ANY_MEANS_CAR_3D hPlayerPed hSecurityCar 50.0 50.0 15.0 FALSE
                    GOTO securicar_assault_free_assets
                ENDIF
                WAIT 0
            ENDWHILE

            GOTO securicar_assault_free_assets
        ENDIF

        WAIT 0
    ENDWHILE

securicar_assault_free_assets:
    IF DOES_BLIP_EXIST hcarBlip
        REMOVE_BLIP hcarBlip
    ENDIF

    MARK_CHAR_AS_NO_LONGER_NEEDED hDriverPed
    MARK_CHAR_AS_NO_LONGER_NEEDED hGuardPed
    MARK_CAR_AS_NO_LONGER_NEEDED hSecurityCar

    MARK_MODEL_AS_NO_LONGER_NEEDED 1550
    MARK_MODEL_AS_NO_LONGER_NEEDED WMYSGRD
    MARK_MODEL_AS_NO_LONGER_NEEDED M4
    MARK_MODEL_AS_NO_LONGER_NEEDED SECURICA

    CLEO_RETURN 0
}

{
    LVAR_FLoAT x1 y1 z1 h1 x2 y2 z2
    wallet_robbery:

    LVAR_INT hPed hThief hThiefBlip hMoneyPickup hPedBlip
    LVAR_FLOAT v3dThiefCoords[3]

    WHILE IS_POINT_ON_SCREEN x1 y1 z1 5.0
        WAIT 0
    ENDWHILE

    CREATE_RANDOM_CHAR (x1 y1 z1) (hPed)
    SET_CHAR_HEADING (hPed, h1)
    TASK_WANDER_STANDARD hPed

    CREATE_RANDOM_CHAR (x2 y2 z2) (hThief)
    TASK_GOTO_CHAR hThief hPed -1 1.5

    WHILE NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D hThief hPed 1.5 1.5 1.5 FALSE,
        WAIT 0
    ENDWHILE

    TASK_KILL_CHAR_ON_FOOT_TIMED hThief hPed 2500

    TASK_TURN_CHAR_TO_FACE_CHAR hPed hThief

    WAIT 500

    TASK_PLAY_ANIM hPed "gas_cwr" "PED" 4.0 FALSE FALSE FALSE FALSE -1 

    WAIT 2500

    TASK_SMART_FLEE_CHAR hThief hPed 100.0 -1

    ADD_BLIP_FOR_CHAR (hThief) (hThiefBlip)
    CHANGE_BLIP_DISPLAY (hThiefBlip, BLIP_ONLY)
    CHANGE_BLIP_COLOUR (hThiefBlip, 0xFF0000FF)

    WHILE LOCATE_CHAR_ANY_MEANS_CHAR_3D hThief hPed 100.0 100.0 3.0 FALSE
        IF IS_CHAR_DEAD hThief
        AND HAS_CHAR_BEEN_DAMAGED_BY_CHAR hThief hPlayerPed
            REMOVE_BLIP hThiefBlip

            GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS (hThief, 0.0, -1.0, 0.0) (v3dThiefCoords[0], v3dThiefCoords[1], v3dThiefCoords[2])
            CREATE_MONEY_PICKUP (v3dThiefCoords[0], v3dThiefCoords[1], v3dThiefCoords[2], 5000, FALSE) (hMoneyPickup)

            WHILE LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed hPed 100.0 100.0 3.0 FALSE
                WAIT 0
                IF HAS_PICKUP_BEEN_COLLECTED hMoneyPickup
                    PRINT_HELP_STRING "If you retrieve a stolen item, you can choose to keep it or return it for a reward."

                    ADD_BLIP_FOR_CHAR (hPed) (hPedBlip)
                    CHANGE_BLIP_DISPLAY (hPedBlip, BLIP_ONLY)
                    CHANGE_BLIP_COLOUR (hPedBlip, 0x63C5DAFF)

                    WHILE NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed hPed 1.5 1.5 3.0 FALSE
                        IF NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed hPed 100.0 100.0 3.0 FALSE
                            GOTO robbery_1_free_assets
                        ENDIF
                        WAIT 0
                    ENDWHILE
                    ADD_SCORE 0 -4500
                    GOTO robbery_1_free_assets
                ENDIF
            ENDWHILE

            GOTO robbery_1_free_assets
        ENDIF
        WAIT 0
    ENDWHILE


robbery_1_free_assets:
    MARK_CHAR_AS_NO_LONGER_NEEDED hPed
    MARK_CHAR_AS_NO_LONGER_NEEDED hThief

    IF DOES_BLIP_EXIST hPedBlip
        REMOVE_BLIP hPedBlip
    ENDIF

    IF DOES_BLIP_EXIST hThiefBlip
        REMOVE_BLIP hThiefBlip
    ENDIF

    IF DOES_PICKUP_EXIST hMoneyPickup
        REMOVE_PICKUP hMoneyPickup
    ENDIF

    CLEO_RETURN 0

}

{
    LVAR_FLOAT x1 y1 z1 h1 x2 y2 z2
    atm_robbery:
    
    LVAR_INT hPed hThief hThiefBlip hMoneyPickup hPedBlip
    LVAR_FLOAT v3dThiefCoords[3]

    WHILE IS_POINT_ON_SCREEN x1 y1 z1 5.0
        WAIT 0
    ENDWHILE

    CREATE_RANDOM_CHAR (x1 y1 z1) (hPed)
    SET_CHAR_HEADING (hPed, h1)
    TASK_PLAY_ANIM hPed "ATM" "PED" 4.0 FALSE FALSE FALSE FALSE -1 

    CREATE_RANDOM_CHAR (x2 y2 z2) (hThief)
    TASK_GOTO_CHAR hThief hPed -1 1.5

    WHILE NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D hThief hPed 1.5 1.5 1.5 FALSE,
        WAIT 0
    ENDWHILE

    TASK_KILL_CHAR_ON_FOOT_TIMED hThief hPed 2500

    TASK_TURN_CHAR_TO_FACE_CHAR hPed hThief

    WAIT 500

    TASK_PLAY_ANIM hPed "gas_cwr" "PED" 4.0 FALSE FALSE FALSE FALSE -1 

    WAIT 2500

    TASK_SMART_FLEE_CHAR hThief hPed 100.0 -1

    ADD_BLIP_FOR_CHAR (hThief) (hThiefBlip)
    CHANGE_BLIP_DISPLAY (hThiefBlip, BLIP_ONLY)
    CHANGE_BLIP_COLOUR (hThiefBlip, 0xFF0000FF)

    WHILE LOCATE_CHAR_ANY_MEANS_CHAR_3D hThief hPed 100.0 100.0 3.0 FALSE
        IF IS_CHAR_DEAD hThief
        AND HAS_CHAR_BEEN_DAMAGED_BY_CHAR hThief hPlayerPed
            REMOVE_BLIP hThiefBlip

            GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS (hThief, 0.0, -1.0, 0.0) (v3dThiefCoords[0], v3dThiefCoords[1], v3dThiefCoords[2])
            CREATE_MONEY_PICKUP (v3dThiefCoords[0], v3dThiefCoords[1], v3dThiefCoords[2], 5000, FALSE) (hMoneyPickup)

            WHILE LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed hPed 100.0 100.0 3.0 FALSE
                WAIT 0
                IF HAS_PICKUP_BEEN_COLLECTED hMoneyPickup
                    PRINT_HELP_STRING "If you retrieve a stolen item, you can choose to keep it or return it for a reward."

                    ADD_BLIP_FOR_CHAR (hPed) (hPedBlip)
                    CHANGE_BLIP_DISPLAY (hPedBlip, BLIP_ONLY)
                    CHANGE_BLIP_COLOUR (hPedBlip, 0x63C5DAFF)

                    WHILE NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed hPed 1.5 1.5 3.0 FALSE
                        IF NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed hPed 100.0 100.0 3.0 FALSE
                            GOTO atm_robbery_1_free_assets
                        ENDIF
                        WAIT 0
                    ENDWHILE
                    ADD_SCORE 0 -4500
                    GOTO atm_robbery_1_free_assets
                ENDIF
            ENDWHILE

            GOTO atm_robbery_1_free_assets
        ENDIF
        WAIT 0
    ENDWHILE


atm_robbery_1_free_assets:
    MARK_CHAR_AS_NO_LONGER_NEEDED hPed
    MARK_CHAR_AS_NO_LONGER_NEEDED hThief

    IF DOES_BLIP_EXIST hPedBlip
        REMOVE_BLIP hPedBlip
    ENDIF

    IF DOES_BLIP_EXIST hThiefBlip
        REMOVE_BLIP hThiefBlip
    ENDIF

    IF DOES_PICKUP_EXIST hMoneyPickup
        REMOVE_PICKUP hMoneyPickup
    ENDIF

    CLEO_RETURN 0

}

{
    bike_hijacking_1:
    LVAR_INT hBike hThiefPed hPed hThiefBlip hPedBlip

    REQUEST_MODEL BIKE

    WHILE NOT HAS_MODEL_LOADED BIKE
        WAIT 0
    ENDWHILE

    WHILE IS_POINT_ON_SCREEN 2400.548340 -1398.222534 24.000000 5.0
        WAIT 0
    ENDWHILE

    CREATE_CAR BIKE 2400.548340 -1398.222534 24.000000 (hBike)

    CREATE_RANDOM_CHAR 2402.947998 -1402.807007 24.034048 (hPed)
    SET_CHAR_HEADING hPed 32.439930

    CREATE_RANDOM_CHAR 2398.609131 -1400.452271 24.000000 hThiefPed
    SET_CHAR_HEADING hThiefPed 322.855896

    TASK_PLAY_ANIM hPed "fucku" "PED" 4.0 FALSE FALSE FALSE FALSE -1 

    TASK_ENTER_CAR_AS_DRIVER hThiefPed hBike -1

    WHILE NOT IS_CHAR_SITTING_IN_CAR hThiefPed hBike
        WAIT 0
    ENDWHILE

    ADD_BLIP_FOR_CHAR (hThiefPed) (hThiefBlip)
    CHANGE_BLIP_DISPLAY (hThiefBlip, BLIP_ONLY)
    CHANGE_BLIP_COLOUR (hThiefBlip, 0xFF0000FF)

    TASK_GOTO_CHAR hPed hThiefPed -1 1.5

    TASK_CAR_DRIVE_WANDER hThiefPed hBike 10.0 2

    WHILE LOCATE_CHAR_ANY_MEANS_CHAR_3D hThiefPed hPed 100.0 100.0 3.0 FALSE
        IF NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed hPed 100.0 100.0 3.0 FALSE
            GOTO bike_hijacking_1_free_assets
        ENDIF

        IF IS_CHAR_DEAD hThiefPed
        AND NOT IS_CHAR_SITTING_IN_CAR hThiefPed hBike
            PRINT_HELP_STRING "If you retrieve a stolen item, you can choose to keep it or return it for a reward."
            REMOVE_BLIP hThiefBlip

            ADD_BLIP_FOR_CHAR (hPed) (hPedBlip)
            CHANGE_BLIP_DISPLAY (hPedBlip, BLIP_ONLY)
            CHANGE_BLIP_COLOUR (hPedBlip, 0x63C5DAFF)

            CLEAR_CHAR_TASKS hPed 

            TASK_GOTO_CAR hPed hBike -1 2.0

            WHILE NOT LOCATE_CHAR_ANY_MEANS_CAR_3D hPed hBike 2.0 2.0 2.0 FALSE
                IF NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed hPed 100.0 100.0 3.0 FALSE
                    GOTO bike_hijacking_1_free_assets
                ENDIF
                WAIT 0
            ENDWHILE

            TASK_ENTER_CAR_AS_DRIVER hPed hBike -1

            WHILE NOT IS_CHAR_SITTING_IN_CAR hPed hBike
                IF NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed hPed 100.0 100.0 3.0 FALSE
                    GOTO bike_hijacking_1_free_assets
                ENDIF
                WAIT 0
            ENDWHILE

            TASK_CAR_DRIVE_WANDER hPed hBike 10.0 2

            ADD_SCORE 0 60000

            GOTO bike_hijacking_1_free_assets
        ENDIF
        WAIT 0
    ENDWHILE

bike_hijacking_1_free_assets:
    MARK_CHAR_AS_NO_LONGER_NEEDED hPed
    MARK_CHAR_AS_NO_LONGER_NEEDED hThiefPed
    MARK_CAR_AS_NO_LONGER_NEEDED hBike

    IF DOES_BLIP_EXIST hPedBlip
        REMOVE_BLIP hPedBlip
    ENDIF

    IF DOES_BLIP_EXIST hThiefBlip
        REMOVE_BLIP hThiefBlip
    ENDIF

    MARK_MODEL_AS_NO_LONGER_NEEDED BIKE
    
    CLEO_RETURN 0
}

{
    bike_hijacking_2:
    LVAR_INT hBike hThiefPed hPed hThiefBlip hPedBlip

    REQUEST_MODEL BIKE

    WHILE NOT HAS_MODEL_LOADED BIKE
        WAIT 0
    ENDWHILE

    WHILE IS_POINT_ON_SCREEN 1861.382690 -1370.008789 13.137326 5.0
        WAIT 0
    ENDWHILE

    CREATE_CAR BIKE 1861.382690 -1370.008789 13.137326 (hBike)

    CREATE_RANDOM_CHAR 1863.230713 -1375.315186 13.481759 (hPed)
    SET_CHAR_HEADING hPed 16.871861

    CREATE_RANDOM_CHAR 1858.280762 -1371.886963 13.562500 hThiefPed
    SET_CHAR_HEADING hThiefPed 322.855896

    TASK_PLAY_ANIM hPed "fucku" "PED" 4.0 FALSE FALSE FALSE FALSE -1 

    TASK_ENTER_CAR_AS_DRIVER hThiefPed hBike -1

    WHILE NOT IS_CHAR_SITTING_IN_CAR hThiefPed hBike
        WAIT 0
    ENDWHILE

    ADD_BLIP_FOR_CHAR (hThiefPed) (hThiefBlip)
    CHANGE_BLIP_DISPLAY (hThiefBlip, BLIP_ONLY)
    CHANGE_BLIP_COLOUR (hThiefBlip, 0xFF0000FF)

    TASK_GOTO_CHAR hPed hThiefPed -1 1.5

    TASK_CAR_DRIVE_WANDER hThiefPed hBike 10.0 2

    WHILE LOCATE_CHAR_ANY_MEANS_CHAR_3D hThiefPed hPed 100.0 100.0 3.0 FALSE
        IF NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed hPed 100.0 100.0 3.0 FALSE
            GOTO bike_hijacking_2_free_assets
        ENDIF

        IF IS_CHAR_DEAD hThiefPed
        AND NOT IS_CHAR_SITTING_IN_CAR hThiefPed hBike
            PRINT_HELP_STRING "If you retrieve a stolen item, you can choose to keep it or return it for a reward."
            REMOVE_BLIP hThiefBlip

            ADD_BLIP_FOR_CHAR (hPed) (hPedBlip)
            CHANGE_BLIP_DISPLAY (hPedBlip, BLIP_ONLY)
            CHANGE_BLIP_COLOUR (hPedBlip, 0x63C5DAFF)

            CLEAR_CHAR_TASKS hPed 

            TASK_GOTO_CAR hPed hBike -1 2.0

            WHILE NOT LOCATE_CHAR_ANY_MEANS_CAR_3D hPed hBike 2.0 2.0 2.0 FALSE
                IF NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed hPed 100.0 100.0 3.0 FALSE
                    GOTO bike_hijacking_2_free_assets
                ENDIF
                WAIT 0
            ENDWHILE

            TASK_ENTER_CAR_AS_DRIVER hPed hBike -1

            WHILE NOT IS_CHAR_SITTING_IN_CAR hPed hBike
                IF NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed hPed 100.0 100.0 3.0 FALSE
                    GOTO bike_hijacking_2_free_assets
                ENDIF
                WAIT 0
            ENDWHILE

            TASK_CAR_DRIVE_WANDER hPed hBike 10.0 2

            GOTO bike_hijacking_2_free_assets
        ENDIF
        WAIT 0
    ENDWHILE

bike_hijacking_2_free_assets:
    MARK_CHAR_AS_NO_LONGER_NEEDED hPed
    MARK_CHAR_AS_NO_LONGER_NEEDED hThiefPed
    MARK_CAR_AS_NO_LONGER_NEEDED hBike

    IF DOES_BLIP_EXIST hPedBlip
        REMOVE_BLIP hPedBlip
    ENDIF

    IF DOES_BLIP_EXIST hThiefBlip
        REMOVE_BLIP hThiefBlip
    ENDIF

    MARK_MODEL_AS_NO_LONGER_NEEDED BIKE
    
    CLEO_RETURN 0
}

{
    sport_bike_hijacking_1:
    LVAR_INT hBike hThiefPed hPed hThiefBlip hPedBlip

    REQUEST_MODEL PCJ600

    WHILE NOT HAS_MODEL_LOADED PCJ600
        WAIT 0
    ENDWHILE

    WHILE IS_POINT_ON_SCREEN 125.620537 -1483.763428 17.401913 5.0
        WAIT 0
    ENDWHILE

    CREATE_CAR PCJ600 125.620537 -1483.763428 17.401913 (hBike)
    SET_CAR_HEADING hBike 70.685844

    CREATE_RANDOM_CHAR 131.119781 -1490.121948 18.731892 (hPed)
    SET_CHAR_HEADING hPed 16.871861

    CREATE_RANDOM_CHAR 126.638214 -1474.845703 20.021196 hThiefPed
    SET_CHAR_HEADING hThiefPed 148.106201

    TASK_PLAY_ANIM hPed "fucku" "PED" 4.0 FALSE FALSE FALSE FALSE -1 

    TASK_ENTER_CAR_AS_DRIVER hThiefPed hBike -1

    WHILE NOT IS_CHAR_SITTING_IN_CAR hThiefPed hBike
        WAIT 0
    ENDWHILE

    ADD_BLIP_FOR_CHAR (hThiefPed) (hThiefBlip)
    CHANGE_BLIP_DISPLAY (hThiefBlip, BLIP_ONLY)
    CHANGE_BLIP_COLOUR (hThiefBlip, 0xFF0000FF)

    TASK_GOTO_CHAR hPed hThiefPed -1 1.5

    TASK_CAR_DRIVE_WANDER hThiefPed hBike 20.0 2

    WHILE LOCATE_CHAR_ANY_MEANS_CHAR_3D hThiefPed hPed 100.0 100.0 15.0 FALSE
        IF NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed hPed 100.0 100.0 15.0 FALSE
            GOTO sport_bike_hijacking_1_free_assets
        ENDIF

        IF IS_CHAR_DEAD hThiefPed
        AND NOT IS_CHAR_SITTING_IN_CAR hThiefPed hBike
            PRINT_HELP_STRING "If you retrieve a stolen item, you can choose to keep it or return it for a reward."
            REMOVE_BLIP hThiefBlip

            ADD_BLIP_FOR_CHAR (hPed) (hPedBlip)
            CHANGE_BLIP_DISPLAY (hPedBlip, BLIP_ONLY)
            CHANGE_BLIP_COLOUR (hPedBlip, 0x63C5DAFF)

            CLEAR_CHAR_TASKS hPed 

            TASK_GOTO_CAR hPed hBike -1 2.0

            WHILE NOT LOCATE_CHAR_ANY_MEANS_CAR_3D hPed hBike 2.0 2.0 2.0 FALSE
                IF NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed hPed 100.0 100.0 15.0 FALSE
                    GOTO sport_bike_hijacking_1_free_assets
                ENDIF
                WAIT 0
            ENDWHILE

            TASK_ENTER_CAR_AS_DRIVER hPed hBike -1

            WHILE NOT IS_CHAR_SITTING_IN_CAR hPed hBike
                IF NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed hPed 100.0 100.0 15.0 FALSE
                    GOTO sport_bike_hijacking_1_free_assets
                ENDIF
                WAIT 0
            ENDWHILE

            TASK_CAR_DRIVE_WANDER hPed hBike 20.0 2

            GOTO sport_bike_hijacking_1_free_assets
        ENDIF
        WAIT 0
    ENDWHILE

sport_bike_hijacking_1_free_assets:
    MARK_CHAR_AS_NO_LONGER_NEEDED hPed
    MARK_CHAR_AS_NO_LONGER_NEEDED hThiefPed
    MARK_CAR_AS_NO_LONGER_NEEDED hBike

    IF DOES_BLIP_EXIST hPedBlip
        REMOVE_BLIP hPedBlip
    ENDIF

    IF DOES_BLIP_EXIST hThiefBlip
        REMOVE_BLIP hThiefBlip
    ENDIF

    MARK_MODEL_AS_NO_LONGER_NEEDED PCJ600
    
    CLEO_RETURN 0
}

{
    car_hijacking_1:
    LVAR_INT hBike hThiefPed hPed hThiefBlip hPedBlip

    REQUEST_MODEL BLADE

    WHILE NOT HAS_MODEL_LOADED BLADE
        WAIT 0
    ENDWHILE

    WHILE IS_POINT_ON_SCREEN -86.535606 -1151.513916 1.755659 5.0
        WAIT 0
    ENDWHILE

    CREATE_CAR BLADE -92.713806 -1150.437500 1.732354 (hBike)
    CHANGE_CAR_COLOUR hBike 126, 0
    SET_CAR_HEADING hBike 70.685844

    CREATE_RANDOM_CHAR -80.266090 -1169.084961 2.185834 (hPed)
    SET_CHAR_HEADING hPed 28.503769

    CREATE_RANDOM_CHAR -93.822495 -1160.265869 2.140777 hThiefPed
    SET_CHAR_HEADING hThiefPed 314.266602

    

    TASK_ENTER_CAR_AS_DRIVER hThiefPed hBike -1

    TASK_PLAY_ANIM hPed "fucku" "PED" 4.0 FALSE FALSE FALSE FALSE -1 

    WHILE NOT IS_CHAR_SITTING_IN_CAR hThiefPed hBike
        WAIT 0
    ENDWHILE
    

    ADD_BLIP_FOR_CHAR (hThiefPed) (hThiefBlip)
    CHANGE_BLIP_DISPLAY (hThiefBlip, BLIP_ONLY)
    CHANGE_BLIP_COLOUR (hThiefBlip, 0xFF0000FF)

    TASK_GOTO_CHAR hPed hThiefPed -1 1.5

    TASK_CAR_DRIVE_WANDER hThiefPed hBike 20.0 2

    WHILE LOCATE_CHAR_ANY_MEANS_CHAR_3D hThiefPed hPed 100.0 100.0 15.0 FALSE
        IF NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed hPed 100.0 100.0 15.0 FALSE
            GOTO car_hijacking_1_free_assets
        ENDIF

        IF IS_CHAR_DEAD hThiefPed
        AND NOT IS_CHAR_SITTING_IN_CAR hThiefPed hBike
            PRINT_HELP_STRING "If you retrieve a stolen item, you can choose to keep it or return it for a reward."
            REMOVE_BLIP hThiefBlip

            ADD_BLIP_FOR_CHAR (hPed) (hPedBlip)
            CHANGE_BLIP_DISPLAY (hPedBlip, BLIP_ONLY)
            CHANGE_BLIP_COLOUR (hPedBlip, 0x63C5DAFF)

            CLEAR_CHAR_TASKS hPed 

            TASK_GOTO_CAR hPed hBike -1 2.0

            WHILE NOT LOCATE_CHAR_ANY_MEANS_CAR_3D hPed hBike 2.0 2.0 2.0 FALSE
                IF NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed hPed 100.0 100.0 15.0 FALSE
                    GOTO car_hijacking_1_free_assets
                ENDIF
                WAIT 0
            ENDWHILE

            TASK_ENTER_CAR_AS_DRIVER hPed hBike -1

            WHILE NOT IS_CHAR_SITTING_IN_CAR hPed hBike
                IF NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed hPed 100.0 100.0 15.0 FALSE
                    GOTO car_hijacking_1_free_assets
                ENDIF
                WAIT 0
            ENDWHILE

            TASK_CAR_DRIVE_WANDER hPed hBike 20.0 2

            GOTO car_hijacking_1_free_assets
        ENDIF
        WAIT 0
    ENDWHILE

car_hijacking_1_free_assets:
    MARK_CHAR_AS_NO_LONGER_NEEDED hPed
    MARK_CHAR_AS_NO_LONGER_NEEDED hThiefPed
    MARK_CAR_AS_NO_LONGER_NEEDED hBike

    IF DOES_BLIP_EXIST hPedBlip
        REMOVE_BLIP hPedBlip
    ENDIF

    IF DOES_BLIP_EXIST hThiefBlip
        REMOVE_BLIP hThiefBlip
    ENDIF

    MARK_MODEL_AS_NO_LONGER_NEEDED BLADE
    
    CLEO_RETURN 0
}


{
    car_hijacking_2:
    LVAR_INT hBike hThiefPed hPed hThiefBlip hPedBlip
    REQUEST_MODEL HUNTLEY

    WHILE NOT HAS_MODEL_LOADED HUNTLEY
        WAIT 0
    ENDWHILE

    WHILE IS_POINT_ON_SCREEN 1648.484619 -1136.189697 23.643808 10.0
        WAIT 0
    ENDWHILE

    CREATE_CAR HUNTLEY 1648.484619 -1136.189697 23.643808 (hBike)
    CHANGE_CAR_COLOUR hBike 80, 0
    SET_CAR_HEADING hBike 180.0

    CREATE_RANDOM_CHAR 1630.815186 -1140.996826 23.906250 (hPed)
    SET_CHAR_HEADING hPed 285.244415

    CREATE_RANDOM_CHAR 1654.015869 -1143.408569 24.072096 hThiefPed
    SET_CHAR_HEADING hThiefPed 84.082474

    

    TASK_ENTER_CAR_AS_DRIVER hThiefPed hBike -1

    TASK_PLAY_ANIM hPed "fucku" "PED" 4.0 FALSE FALSE FALSE FALSE -1 

    WHILE NOT IS_CHAR_SITTING_IN_CAR hThiefPed hBike
        WAIT 0
    ENDWHILE
    

    ADD_BLIP_FOR_CHAR (hThiefPed) (hThiefBlip)
    CHANGE_BLIP_DISPLAY (hThiefBlip, BLIP_ONLY)
    CHANGE_BLIP_COLOUR (hThiefBlip, 0xFF0000FF)

    TASK_GOTO_CHAR hPed hThiefPed -1 1.5

    TASK_CAR_DRIVE_WANDER hThiefPed hBike 20.0 2

    WHILE LOCATE_CHAR_ANY_MEANS_CHAR_3D hThiefPed hPed 100.0 100.0 15.0 FALSE
        IF NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed hPed 100.0 100.0 15.0 FALSE
            GOTO car_hijacking_2_free_assets
        ENDIF

        IF IS_CHAR_DEAD hThiefPed
        AND NOT IS_CHAR_SITTING_IN_CAR hThiefPed hBike
            PRINT_HELP_STRING "If you retrieve a stolen item, you can choose to keep it or return it for a reward."
            REMOVE_BLIP hThiefBlip

            ADD_BLIP_FOR_CHAR (hPed) (hPedBlip)
            CHANGE_BLIP_DISPLAY (hPedBlip, BLIP_ONLY)
            CHANGE_BLIP_COLOUR (hPedBlip, 0x63C5DAFF)

            CLEAR_CHAR_TASKS hPed 

            TASK_GOTO_CAR hPed hBike -1 2.0

            WHILE NOT LOCATE_CHAR_ANY_MEANS_CAR_3D hPed hBike 2.0 2.0 2.0 FALSE
                IF NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed hPed 100.0 100.0 15.0 FALSE
                    GOTO car_hijacking_2_free_assets
                ENDIF
                WAIT 0
            ENDWHILE

            TASK_ENTER_CAR_AS_DRIVER hPed hBike -1

            WHILE NOT IS_CHAR_SITTING_IN_CAR hPed hBike
                IF NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed hPed 100.0 100.0 15.0 FALSE
                    GOTO car_hijacking_2_free_assets
                ENDIF
                WAIT 0
            ENDWHILE

            ADD_SCORE 0 60000

            TASK_CAR_DRIVE_WANDER hPed hBike 20.0 2

            GOTO car_hijacking_2_free_assets
        ENDIF
        WAIT 0
    ENDWHILE

car_hijacking_2_free_assets:
    MARK_CHAR_AS_NO_LONGER_NEEDED hPed
    MARK_CHAR_AS_NO_LONGER_NEEDED hThiefPed
    MARK_CAR_AS_NO_LONGER_NEEDED hBike

    IF DOES_BLIP_EXIST hPedBlip
        REMOVE_BLIP hPedBlip
    ENDIF

    IF DOES_BLIP_EXIST hThiefBlip
        REMOVE_BLIP hThiefBlip
    ENDIF

    MARK_MODEL_AS_NO_LONGER_NEEDED HUNTLEY 
    
    CLEO_RETURN 0
}




{
    // Checking that the ped has a weapon
    LVAR_INT pPed i weaponSlot
    HasPedAnyWeapon: // i - ped pointer
    pPed += 0x5A0

    i = 0
    WHILE i < 12
        READ_MEMORY pPed 4 FALSE (weaponSlot)
        IF NOT weaponSlot = 0
            CLEO_RETURN 0 1
        ENDIF
        pPed += 0x1C
        i++
    ENDWHILE

    CLEO_RETURN 0 0

}

{
    //    Return TRUE IF char is holding any fire or explosion weapon - By Junior_Djjr
    //    Use: 0AB1: call_scm_func @IsCharHoldingDangerousWeapon 1 hPlayerPed

    CONST_INT WEAPON_FIRE_MELEE         0
    CONST_INT WEAPON_FIRE_INSTANT_HIT   1
    CONST_INT WEAPON_FIRE_PROJECTILE    2
    CONST_INT WEAPON_FIRE_AREA_EFFECT   3
    CONST_INT WEAPON_FIRE_CAMERA        4
    CONST_INT WEAPON_FIRE_USE           5

    LVAR_INT i j

    IsCharHoldingDangerousWeapon:
        GET_CURRENT_CHAR_WEAPON i (j)
        CALL_FUNCTION_RETURN 0x1410B0 2 2 j 1 (j) // GetWeaponInfo (we can ignore skill (1) here)
        READ_MEMORY j 4 FALSE (j)
        IF j = WEAPON_FIRE_INSTANT_HIT
        OR j = WEAPON_FIRE_PROJECTILE
            IS_INT_LVAR_GREATER_THAN_CONSTANT TIMERA -1 // RETURN_TRUE
        ENDIF
    CLEO_RETURN 0
}

{
    submarine:
    SCRIPT_NAME SUBMARN

    LVAR_INT hKraken iLeftStickX iLeftStickY i
    LVAR_FLOAT f g fSavedZ v3dSubCoords[3] v3dSubRotation[3] fSpeed fSin fCos fAngle
    g = 1.5

    submarine_main_loop:
        WAIT 0
        IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 808.745544 -2019.298096 0.0 20.0 20.0 20.0 FALSE

            REQUEST_MODEL JETMAX

            WHILE NOT HAS_MODEL_LOADED JETMAX
                WAIT 0
            ENDWHILE

            CREATE_CAR JETMAX 808.745544 -2019.298096 0.0 hKraken

            MARK_CAR_AS_NO_LONGER_NEEDED hKraken

            WHILE LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 808.745544 -2019.298096 0.0 20.0 20.0 20.0 FALSE
                WAIT 0
                IF IS_CHAR_SITTING_IN_CAR hPlayerPed hKraken
                    WHILE IS_CHAR_SITTING_IN_CAR hPlayerPed hKraken
                        WAIT 0
                        GET_POSITION_OF_ANALOGUE_STICKS PAD1 i iLeftStickY i i
                        

                        IF NOT iLeftStickY = 0
                        AND TIMERA > 150
                            GET_CAR_HEADING hKraken fAngle
                            IF iLeftStickY < -64
                                g -= 0.35
                                COS fAngle fCos
                                SIN fAngle fSin
                                fCos *= 60.0
                                fSin *= 60.0
                                APPLY_FORCE_TO_CAR hKraken 0.0 0.0 -0.22 fCos fSin 0.0
                            ELSE
                                IF iLeftStickY > 64
                                    IF v3dSubCoords[2] <= 1.0f 
                                        g += 0.35
                                        COS fAngle fCos
                                        SIN fAngle fSin
                                        fCos *= -60.0
                                        fSin *= -60.0
                                        APPLY_FORCE_TO_CAR hKraken 0.0 0.0 0.22 fCos fSin 0.0
                                    ENDIF
                                ENDIF
                            ENDIF
                            TIMERA = 0
                        ENDIF

                        GET_CAR_COORDINATES hKraken v3dSubCoords[0] v3dSubCoords[1] v3dSubCoords[2]

                        IF v3dSubCoords[2] > g
                            APPLY_FORCE_TO_CAR hKraken 0.0 0.0 -0.22 0.0 0.0 0.0
                        ENDIF

                        GET_CAR_SPEED hKraken fSpeed

                        IF g < -3.0
                        AND IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER2
                            IF fSpeed < 35.0
                                fSpeed += 15.0
                            ENDIF

                            SET_CAR_FORWARD_SPEED hKraken fSpeed
                        ENDIF

                    ENDWHILE
                ENDIF
            ENDWHILE
        ENDIF
    GOTO submarine_main_loop
}

{
    legalize_it_michael:

    LVAR_INT hTableObject hChairObject hBarryPed iSequenceTask iInitialObjectsLoaded hCigarObject i bOnMission

    legalize_it_michael_main_loop:
        WAIT 0
        IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1468.043457 -1652.227905 13.046875 50.0 50.0 50.0 FALSE
        AND switch_cur_char = PLAYER_MICHAEL

            REQUEST_MODEL 2115 // Table
            REQUEST_MODEL 1810 // Chair
            REQUEST_MODEL 3044 // Cigar
            REQUEST_ANIMATION "GANGS" // Smoke anim
            LOAD_SPECIAL_CHARACTER 1 TRUTH

            WHILE NOT HAS_MODEL_LOADED 2115
            OR NOT HAS_MODEL_LOADED 1810
            OR NOT HAS_MODEL_LOADED 3044
            OR NOT HAS_SPECIAL_CHARACTER_LOADED 1
            OR NOT HAS_ANIMATION_LOADED "GANGS"
                WAIT 0
            ENDWHILE

            CREATE_CHAR PEDTYPE_CIVMALE SPECIAL01 1468.079829 -1650.901636 14.046875 hBarryPed
            SET_CHAR_HEADING hBarryPed 152.380005

            TASK_PLAY_ANIM_NON_INTERRUPTABLE hBarryPed "SEAT_idle" "PED" 4.0 TRUE FALSE FALSE FALSE 99999

            CREATE_OBJECT 1810 1468.424805 -1650.651001 13.046875 hChairObject
            SET_OBJECT_HEADING hChairObject 320.639938

            CREATE_OBJECT 2115 1468.043457 -1652.227905 13.046875 hTableObject
            SET_OBJECT_HEADING hTableObject 159.437317

            CREATE_OBJECT 3044 1467.343457 -1651.527905 13.846875 hCigarObject

            WHILE LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1468.043457 -1652.227905 13.046875 50.0 50.0 50.0 FALSE
                WAIT 0
                IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1468.043457 -1652.227905 13.046875 2.0 2.0 2.0 FALSE
                AND NOT flag_player_on_mission = TRUE
                    flag_player_on_mission = TRUE

                    DO_FADE 1000 FADE_OUT
                    WAIT 1000

                    DELETE_CHAR hBarryPed
                    DELETE_OBJECT hChairObject
                    DELETE_OBJECT hTableObject
                    DELETE_OBJECT hCigarObject
                    LOAD_AND_LAUNCH_MISSION grass_roots_michael.sc

                    WHILE LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1468.043457 -1652.227905 13.046875 4.0 4.0 2.0 FALSE
                        WAIT 0
                    ENDWHILE
                ENDIF
            ENDWHILE

            IF DOES_CHAR_EXIST hBarryPed
                DELETE_CHAR hBarryPed
            ENDIF

            IF DOES_OBJECT_EXIST hChairObject
                DELETE_OBJECT hChairObject
            ENDIF

            IF DOES_OBJECT_EXIST hTableObject
                DELETE_OBJECT hTableObject
            ENDIF

            IF DOES_OBJECT_EXIST hCigarObject
                DELETE_OBJECT hCigarObject
            ENDIF

        ENDIF
    GOTO legalize_it_michael_main_loop
}

{
    pacific_arrest:
    SCRIPT_NAME ARREST

    LVAR_INT hCopPed iPedType
    LVAR_FLOAT v3dPlayerCoords[3]

    pacific_arrest_main_loop:
        WAIT 0

        IF IS_PLAYER_PLAYING iPlayer
            IF IS_WANTED_LEVEL_GREATER iPlayer 0
            AND NOT IS_WANTED_LEVEL_GREATER iPlayer 1
                TIMERA = 0
                WHILE IS_WANTED_LEVEL_GREATER iPlayer 0
                AND NOT IS_WANTED_LEVEL_GREATER iPlayer 1
                    WAIT 0
                    IF IS_BUTTON_PRESSED PAD1 CIRCLE
                    OR  IS_BUTTON_PRESSED PAD1 SQUARE
                    OR  IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER2
                    OR  IS_BUTTON_PRESSED PAD1 LEFTSHOULDER2
                        TIMERA = 0
                    ENDIF

                    IF TIMERA > 10000
                        GET_CHAR_COORDINATES hPlayerPed v3dPlayerCoords[0] v3dPlayerCoords[1] v3dPlayerCoords[2] 
                        WHILE GET_RANDOM_CHAR_IN_SPHERE_NO_SAVE_RECURSIVE v3dPlayerCoords[0] v3dPlayerCoords[1] v3dPlayerCoords[2] 5.0 1 1 (hCopPed) 
                            WAIT 0
                            IF NOT hCopPed = 0
                            AND DOES_CHAR_EXIST hCopPed 
                            GET_PED_TYPE (hCopPed) (iPedType)
                                IF iPedType = 6
                                    REQUEST_MODEL 346 
                                    WHILE NOT HAS_MODEL_LOADED 346
                                        WAIT 0
                                    ENDWHILE 
                                    GIVE_WEAPON_TO_CHAR hCopPed 22 600 
                                    SET_CURRENT_CHAR_WEAPON hCopPed 22 
                                    CLEAR_CHAR_TASKS hCopPed 
                                    TASK_AIM_GUN_AT_CHAR hCopPed hPlayerPed 3000
                                    TASK_HANDS_UP hPlayerPed -1
                                    WAIT 1000
                                    SET_CHAR_ARRESTED hPlayerPed
                                    WAIT 3000
                                    CLEAR_CHAR_TASKS hPlayerPed
                                    BREAK
                                ENDIF
                            ENDIF
                        ENDWHILE
                    ENDIF
                ENDWHILE
            ENDIF
        ENDIF
    GOTO pacific_arrest_main_loop
}

{
    fire_oil_system:
    LVAR_FLOAT v3dPlayerPos[3]
    LVAR_INT pPlayerPos AddOilPuddle DrawAmmoSetOverride DrawAmmoClearOverride pTemp
    
	LVAR_INT gas_quantity pGasQuantity hObject bLoaded

    WAIT 0 

	GET_VAR_POINTER v3dPlayerPos[0] pPlayerPos
    GET_VAR_POINTER gas_quantity pGasQuantity

    IF GET_DYNAMIC_LIBRARY_PROCEDURE ("AddOilPuddle", 0) (AddOilPuddle)
        READ_MEMORY 0x66B220 4 TRUE (pTemp)
    ENDIF

    IF GET_DYNAMIC_LIBRARY_PROCEDURE ("DrawAmmoSetOverride", 0) (DrawAmmoSetOverride)
        CPRINTLN ("GTA V Legacy: [Plugin <> Script Interface] DrawAmmoSetOverride collected!")
    ENDIF

    IF GET_DYNAMIC_LIBRARY_PROCEDURE ("DrawAmmoClearOverride", 0) (DrawAmmoClearOverride)
        CPRINTLN ("GTA V Legacy: [Plugin <> Script Interface] DrawAmmoClearOverride collected!")
    ENDIF

	gas_quantity = 100 

	pour_gasoline_main_loop:
		WAIT 0
			IF IS_CURRENT_CHAR_WEAPON hPlayerPed WEAPONTYPE_DILDO2
                // void DrawAmmoSetOverride(int ammo_qt, int clip_qt, bool has_clip)
                CALL_FUNCTION DrawAmmoSetOverride 2 0 pGasQuantity 0
                WHILE IS_CURRENT_CHAR_WEAPON hPlayerPed WEAPONTYPE_DILDO2
                    WAIT 0
                    IF IS_PLAYER_PLAYING iPlayer 
				        IF gas_quantity >= 1 
				        AND IS_BUTTON_PRESSED 0 RIGHTSHOULDER2
				        AND NOT IS_CHAR_IN_ANY_CAR hPlayerPed 
				        	IF bLoaded = FALSE
				        		REQUEST_MODEL 1650 
				        		WHILE NOT HAS_MODEL_LOADED 1650
				        			WAIT 0
				        		ENDWHILE
				        		bLoaded = TRUE
				        	ENDIF
				        	CREATE_OBJECT 1650 0.0 0.0 0.0 hObject 
				        	TASK_PICK_UP_OBJECT hPlayerPed hObject -0.05 0.2 0.0 6 16 "GAS_IDLE" "PED" -1 
				        	SET_OBJECT_ROTATION hObject 0.0 0.0 0.0 

				        	WHILE gas_quantity >= 1 
				        	AND IS_BUTTON_PRESSED 0 RIGHTSHOULDER2 
				        	AND NOT IS_CHAR_IN_ANY_CAR hPlayerPed 
				        		WAIT 400
				        		gas_quantity -= 1 
				        		GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hPlayerPed 0.4 2.0 -0.97 v3dPlayerPos[0] v3dPlayerPos[1] v3dPlayerPos[2] 
                                // AddOilPuddle(RwTexture* texture, CVector* pos, int r, int g, int b, int a, float size)
				        		CALL_FUNCTION AddOilPuddle 7 0 pTemp pPlayerPos 0x39 0x23 0x20 255 1.0 
				        	ENDWHILE

				        	TASK_PLAY_ANIM_SECONDARY hPlayerPed "GAS_IDLE" "PED" 4.0 0 0 0 0 10 
				        	DELETE_OBJECT hObject 

				        ENDIF
                    ENDIF
                ENDWHILE
                // void DrawAmmoClearOverride()
                CALL_FUNCTION DrawAmmoClearOverride 0 0
			ENDIF
	GOTO pour_gasoline_main_loop
}

{
    ability_system:
    LVAR_INT bEnabled bPressed bForceDisable bDoFade bFadeAltered
    CONST_INT bGripCheat 0x88D71C

    VAR_INT pAbilityPercent
    VAR_FLOAT fAbilityPercent
    LVAR_INT ToggleRageFilter

    IF GET_DYNAMIC_LIBRARY_PROCEDURE ("CHud_AbilityPercent", 0) (pAbilityPercent)
        READ_MEMORY (pAbilityPercent, 4, TRUE) (fAbilityPercent)
    ENDIF

    WRITE_MEMORY 0x14B518 4 0 TRUE // Disable boost jump

    TIMERA = 0
    ability_system_loop:
        WAIT 0
        IF bEnabled = TRUE
            IF bPressed = TRUE
            OR fAbilityPercent <= 0f
            OR bForceDisable = TRUE
                SWITCH switch_cur_char
                    CASE PLAYER_FRANKLIN
                        // reset fade
                        IF bFadeAltered = 1
                            SET_FADING_COLOUR 0 0 0
                            DO_FADE 0 1  
                        ENDIF  
                        
                        SET_DARKNESS_EFFECT 0 0
                        IF IS_CHAR_SITTING_IN_ANY_CAR hPlayerPed
                            SET_TIME_SCALE 1.0
                            WRITE_MEMORY bGripCheat 1 0 TRUE
                        ENDIF
                        BREAK
                    CASE PLAYER_MICHAEL
                        // reset fade
                        IF bFadeAltered = 1
                            SET_FADING_COLOUR 0 0 0
                            DO_FADE 0 1  
                        ENDIF  

                        SET_DARKNESS_EFFECT 0 0
                        SET_TIME_SCALE 1.0
                        BREAK
                    CASE PLAYER_TREVOR
                        SET_CHAR_PROOFS hPlayerPed FALSE FALSE FALSE FALSE FALSE
                        SET_CHAR_FIRE_DAMAGE_MULTIPLIER hPlayerPed 1f
                        SET_TIME_SCALE 1.0
                        IF GET_DYNAMIC_LIBRARY_PROCEDURE ("ToggleRageFilter", 0) (ToggleRageFilter)
                            CALL_FUNCTION ToggleRageFilter 0 0
                        ENDIF
                        BREAK
                ENDSWITCH
                bEnabled = FALSE
                bForceDisable = FALSE
            ENDIF

            IF switch_cur_char = PLAYER_FRANKLIN
                IF NOT IS_CHAR_SITTING_IN_ANY_CAR hPlayerPed
                OR IS_CHAR_IN_WATER hPlayerPed
                OR IS_CHAR_DEAD hPlayerPed
                    bForceDisable = TRUE
                ENDIF
            ELSE
                IF switch_cur_char = PLAYER_MICHAEL
                    IF IS_CHAR_SITTING_IN_ANY_CAR hPlayerPed
                    OR IS_CHAR_IN_WATER hPlayerPed
                    OR IS_CHAR_DEAD hPlayerPed
                        bForceDisable = TRUE
                    ENDIF
                ELSE
                    IF switch_cur_char = PLAYER_TREVOR
                        IF IS_CHAR_SITTING_IN_ANY_CAR hPlayerPed
                        OR IS_CHAR_IN_WATER hPlayerPed
                        OR IS_CHAR_DEAD hPlayerPed
                            bForceDisable = TRUE
                        ENDIF
                    ENDIF
                ENDIF
            ENDIF

            IF bDoFade = 1
                IF TIMERB > 50
                    DO_FADE 9999999 0
                    bDoFade = 0
                ENDIF
            ENDIF

            IF TIMERA > 100
                IF fAbilityPercent > 0f
                    IF switch_cur_char = PLAYER_TREVOR
                        fAbilityPercent -= 0.5f
                    ELSE
                        fAbilityPercent -= 2f
                    ENDIF
                    WRITE_MEMORY pAbilityPercent 4 fAbilityPercent TRUE
                    TIMERA = 0
                ENDIF
            ENDIF
        ELSE
            IF bPressed = TRUE
                SWITCH switch_cur_char
                    CASE PLAYER_FRANKLIN
                        IF IS_CHAR_SITTING_IN_ANY_CAR hPlayerPed
                            SET_TIME_SCALE 0.2
                            WRITE_MEMORY bGripCheat 1 1 TRUE
                            // do postfx IF valid
                            SET_DARKNESS_EFFECT 1 50
                            IF NOT GET_FADING_STATUS
                                GOSUB Switch_SetFadeColorByCur
                                DO_FADE 700 0
                                TIMERB = 0
                                bDoFade = 1
                                bFadeAltered = 1
                            ELSE   
                                bDoFade = 0
                                bFadeAltered = 0
                            ENDIF
                            bEnabled = TRUE
                        ENDIF
                        BREAK
                    CASE PLAYER_MICHAEL
                        SET_TIME_SCALE 0.2
                        // do postfx IF valid
                        SET_DARKNESS_EFFECT 1 50
                        IF NOT GET_FADING_STATUS
                            GOSUB Switch_SetFadeColorByCur
                            DO_FADE 700 0
                            TIMERB = 0
                            bDoFade = 1
                            bFadeAltered = 1
                        ELSE   
                            bDoFade = 0
                            bFadeAltered = 0
                        ENDIF
                        bEnabled = TRUE
                        BREAK
                    CASE PLAYER_TREVOR
                        SET_CHAR_PROOFS hPlayerPed TRUE TRUE TRUE TRUE TRUE
                        SET_CHAR_FIRE_DAMAGE_MULTIPLIER hPlayerPed 2f
                        SET_TIME_SCALE 0.8
                        bEnabled = TRUE
                        IF GET_DYNAMIC_LIBRARY_PROCEDURE ("ToggleRageFilter", 0) (ToggleRageFilter)
                            CALL_FUNCTION ToggleRageFilter 0 0
                        ENDIF
                        BREAK
                ENDSWITCH
            ENDIF

            IF TIMERA > 100
            AND fAbilityPercent < 100f
                fAbilityPercent += 1f
                WRITE_MEMORY pAbilityPercent 4 fAbilityPercent TRUE
                TIMERA = 0
            ENDIF
        ENDIF

        IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
        AND IS_BUTTON_PRESSED PAD1 LEFTSHOCK
            bPressed = TRUE
            WHILE IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
            AND IS_BUTTON_PRESSED PAD1 LEFTSHOCK
                WAIT 0
            ENDWHILE
        ELSE
            bPressed = FALSE
        ENDIF

    GOTO ability_system_loop
}

{
    SNOW_11:

    LVAR_INT int_1 int_27 int_30 int_19 int_23
    LVAR_FLOAT float_2 float_4 float_5 float_6 float_11 float_12 float_13 float_14 float_15 float_16 float_18 float_20 float_21 float_22 

    WAIT 0 
    REQUEST_MODEL 3003 
    REQUEST_MODEL 3065 
    int_27 = 0 
    TIMERB = 0 
    REQUEST_ANIMATION "GRENADE" 
    REQUEST_ANIMATION "BOMBER" 
    LOAD_ALL_MODELS_NOW 

    WHILE NOT HAS_MODEL_LOADED 3003 
    OR NOT HAS_MODEL_LOADED 3065 
    OR NOT HAS_ANIMATION_LOADED "GRENADE" 
    OR NOT HAS_ANIMATION_LOADED "BOMBER" 
        WAIT 0
    ENDWHILE


    SNOW_100:
    WAIT 0 
    GET_AREA_VISIBLE int_30 
    IF int_30 = 0 
    AND NOT IS_CHAR_IN_ANY_CAR hPlayerPed 
    AND IS_PLAYER_PLAYING iPlayer 
    AND IS_BUTTON_PRESSED PAD1 CIRCLE  
        GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hPlayerPed  2.5 -0.5 0.5 float_11 float_12 float_13 
        CREATE_OBJECT 3065 float_11 float_12 100.8 int_1 
        CREATE_OBJECT 3003 float_11 float_12 float_13 int_19 
        SET_OBJECT_VISIBLE int_19 0 
        SET_OBJECT_RECORDS_COLLISIONS int_1 1 
        SET_OBJECT_COLLISION int_1 1 
        DONT_REMOVE_OBJECT int_1 
        SET_CURRENT_CHAR_WEAPON hPlayerPed 0 
        SET_PLAYER_CYCLE_WEAPON_BUTTON iPlayer 0 
        SET_OBJECT_VISIBLE int_1 0 
    ELSE
        GOTO SNOW_100
    ENDIF

    SNOW_253:
    WAIT 0 
    GET_AREA_VISIBLE int_30 
    IF int_30 = 0 
    AND NOT IS_CHAR_IN_ANY_CAR hPlayerPed 
    AND IS_BUTTON_PRESSED PAD1 CIRCLE 
    AND NOT IS_CHAR_IN_AIR hPlayerPed 
    AND NOT IS_CHAR_IN_WATER hPlayerPed 
        TASK_PLAY_ANIM_NON_INTERRUPTABLE hPlayerPed "BOM_PLANT_IN" "BOMBER" 4.0 0 0 0 0 -1 
        WAIT 1000 
        SET_OBJECT_VISIBLE int_19 1 
        DROP_OBJECT hPlayerPed 1 
        TASK_PICK_UP_OBJECT hPlayerPed int_19 0.08 0.03 0.0 6 16 "NULL" "NULL" 1 
    ELSE
        GOTO SNOW_253
    ENDIF

    SNOW_401:
    WAIT 0 
    IF IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER2
        GOTO SNOW_985 
    ELSE
        GOTO SNOW_427
    ENDIF


    SNOW_427:
    WAIT 0 
    IF NOT IS_CHAR_IN_ANY_CAR hPlayerPed 
    AND IS_BUTTON_PRESSED PAD1 CIRCLE 
        TASK_PLAY_ANIM_NON_INTERRUPTABLE hPlayerPed  "WEAPON_THROW"  "GRENADE"  4.0  0  0  0  0  600 
        WAIT 300 
        HIDE_CHAR_WEAPON_FOR_SCRIPTED_CUTSCENE hPlayerPed  1 
        GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hPlayerPed  0.35 0.6 0.9 float_11 float_12 float_13 
        GET_CHAR_HEADING hPlayerPed float_2 
        SET_OBJECT_COORDINATES int_1 float_11 float_12 float_13 
        float_2 += 270.0 
        SET_OBJECT_HEADING int_1 float_2 
        SET_OBJECT_VISIBLE int_19 1 
        DROP_OBJECT hPlayerPed 0 
        ATTACH_OBJECT_TO_OBJECT int_19  int_1  0.0 0.0 0.0  90.0 270.0 0.0 
        WAIT 0 
        GET_CHAR_HEADING hPlayerPed float_2 
        GET_CHAR_HEIGHT_ABOVE_GROUND hPlayerPed float_18 
        float_4 = 50.0 
        SIN float_2 float_5 
        COS float_2 float_6 
        float_5 *= float_4 
        float_6 *= float_4 
        float_5 *= -1.0 
        float_18 += 1.0 
        SET_OBJECT_DYNAMIC int_1 1 
        SET_OBJECT_VELOCITY int_1 float_5 float_6 float_18 
        int_27 = 1 
        WAIT 300 
    ELSE
        GOTO SNOW_401
    ENDIF

    SNOW_743:
    WAIT 0 
    IF HAS_OBJECT_COLLIDED_WITH_ANYTHING int_1 
    GET_OFFSET_FROM_OBJECT_IN_WORLD_COORDS int_1  0.0 0.0 0.0 float_20 float_21 float_22 
    CREATE_FX_SYSTEM "SNOWBALL" float_20 float_21 float_22 1 int_23 
    PLAY_FX_SYSTEM int_23 
    WAIT 300 
    KILL_FX_SYSTEM int_23 
    GOTO SNOW_911 
    IF int_27 = 1 
    AND TIMERB > 250 
        IF int_27 = 1 
            DETACH_OBJECT int_19 0.0 0.0 0.0 0 
            WAIT 500
        ELSE
            GOTO SNOW_911 
        ENDIF
    ELSE
        GOTO SNOW_253
    ENDIF
    ELSE 
    GOTO SNOW_743
    ENDIF

    SNOW_911:
    DELETE_OBJECT int_1 
    DELETE_OBJECT int_19 
    MARK_OBJECT_AS_NO_LONGER_NEEDED int_19 
    int_27 = 0 
    TIMERB = 0 
    MARK_MODEL_AS_NO_LONGER_NEEDED 3003 
    MARK_MODEL_AS_NO_LONGER_NEEDED 3065 
    REMOVE_ANIMATION "GRENADE" 
    REMOVE_ANIMATION "BOMBER" 
    SET_PLAYER_CYCLE_WEAPON_BUTTON iPlayer 1 
    GOTO SNOW_11 

    SNOW_985:
    WAIT 0 
    TASK_PLAY_ANIM_NON_INTERRUPTABLE hPlayerPed  "ENDCHAT_03"  "PED"  4.0  0  0  0  0  200 
    WAIT 200 
    DROP_OBJECT hPlayerPed 0 
    SET_OBJECT_VELOCITY int_19 0.0 0.0 -2.0 
    WAIT 100 
    DELETE_OBJECT int_1 
    DELETE_OBJECT int_19 
    MARK_OBJECT_AS_NO_LONGER_NEEDED int_19 
    int_27 = 0 
    TIMERB = 0 
    MARK_MODEL_AS_NO_LONGER_NEEDED 3003 
    MARK_MODEL_AS_NO_LONGER_NEEDED 3065 
    REMOVE_ANIMATION "GRENADE" 
    REMOVE_ANIMATION "BOMBER" 
    SET_PLAYER_CYCLE_WEAPON_BUTTON iPlayer 1 
    GOTO SNOW_11 
}

{
    chop_companion:

    LVAR_INT chop_ped weapon_slot hBlip iObject iBlip

    LVAR_FLOAT tmp_x tmp_y tmp_z tmp_h
    LVAR_FLOAT float_4 float_5 float_6 float_14 float_15 float_16 float_18 float_20 float_21 float_22 

    LVAR_INT phys_ball_obj ball_obj int_27 int_30

    ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD 1673.5386 -2082.1696 0.0 35 hBlip

    chop_spawn_loop:
    WAIT 0
    IF switch_cur_char = PLAYER_FRANKLIN 
        IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1673.5386 -2082.1696 13.5468 30f 30f 30f 0
            REQUEST_ANIMATION SKATE
            LOAD_SPECIAL_CHARACTER 1 WUZIMU
            WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
            OR NOT HAS_ANIMATION_LOADED SKATE
                WAIT 0
            ENDWHILE
            CREATE_CHAR PEDTYPE_MISSION1 SPECIAL01 1673.5386 -2082.1696 13.5468 chop_ped
            SET_CHAR_HEADING chop_ped 180.0
            SET_CHAR_SHOOT_RATE chop_ped 100
            SET_ANIM_GROUP_FOR_CHAR chop_ped CHOP
            GIVE_MELEE_ATTACK_TO_CHAR chop_ped 6 6
            TASK_GOTO_CHAR chop_ped hPlayerPed 500 20f
            GOTO chop_loop
        ENDIF
    ENDIF
    GOTO chop_spawn_loop

    chop_loop:
    WAIT 0
    IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1673.5386 -2082.1696 13.5468 10f 10f 10f 0
    AND IS_CHAR_ON_SCREEN chop_ped
        WHILE LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1673.5386 -2082.1696 13.5468 10f 10f 10f 0
        AND IS_CHAR_ON_SCREEN chop_ped
            WAIT 0
            IF IS_CURRENT_CHAR_WEAPON hPlayerPed WEAPONTYPE_UNARMED   
            AND IS_BUTTON_PRESSED PAD1 LEFTSHOULDER2
                PRINT_HELP_STRING "Press ~j~ to take Chop for a walk."
                WHILE IS_CURRENT_CHAR_WEAPON hPlayerPed WEAPONTYPE_UNARMED   
                AND IS_BUTTON_PRESSED PAD1 LEFTSHOULDER2
                    WAIT 0
                    GET_AREA_VISIBLE int_30 
                    IF IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER1
                    AND int_30 = 0 
                    AND NOT IS_CHAR_IN_ANY_CAR hPlayerPed 
                    AND IS_PLAYER_PLAYING iPlayer 
                        WHILE IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER1
                            WAIT 0
                        ENDWHILE
                        
                        SET_GROUP_MEMBER player_group chop_ped
                        REQUEST_MODEL 3003 
                        REQUEST_MODEL 3065 
                        REQUEST_ANIMATION "GRENADE" 
                        REQUEST_ANIMATION "BOMBER" 
                        LOAD_ALL_MODELS_NOW 

                        WHILE NOT HAS_MODEL_LOADED 3003 
                        OR NOT HAS_MODEL_LOADED 3065 
                        OR NOT HAS_ANIMATION_LOADED "GRENADE" 
                        OR NOT HAS_ANIMATION_LOADED "BOMBER" 
                            WAIT 0
                        ENDWHILE

                        GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hPlayerPed  2.5 -0.5 0.5 tmp_x tmp_y tmp_z
                        CREATE_OBJECT 3065 tmp_x tmp_y 100.8 phys_ball_obj 
                        CREATE_OBJECT 3003 tmp_x tmp_y tmp_z ball_obj 
                        SET_OBJECT_VISIBLE ball_obj 0 
                        SET_OBJECT_RECORDS_COLLISIONS phys_ball_obj 1 
                        SET_OBJECT_COLLISION phys_ball_obj 1 
                        DONT_REMOVE_OBJECT phys_ball_obj 
                        SET_CURRENT_CHAR_WEAPON hPlayerPed 0 
                        SET_PLAYER_CYCLE_WEAPON_BUTTON iPlayer 0 
                        SET_OBJECT_VISIBLE phys_ball_obj 0 

                        SET_OBJECT_VISIBLE ball_obj 1 
                        DROP_OBJECT hPlayerPed 1 
                        TASK_PICK_UP_OBJECT hPlayerPed ball_obj 0.08 0.03 0.0 6 16 "NULL" "NULL" 1 
                        
                        GOTO chop_idle
                    ENDIF
                ENDWHILE
            ENDIF
        ENDWHILE
    ENDIF

    IF NOT LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1673.5386 -2082.1696 13.5468 30f 30f 30f 0
        GOTO chop_reset
    ENDIF

    GOTO chop_loop

    chop_idle:
        WAIT 0
        IF IS_CHAR_DEAD chop_ped
        OR NOT switch_cur_char = PLAYER_FRANKLIN
            REMOVE_CHAR_FROM_GROUP chop_ped
            GOTO chop_reset
        ENDIF

        IF LOCATE_CHAR_ANY_MEANS_CHAR_3D hPlayerPed chop_ped 10f 10f 10f 0
        AND IS_CHAR_ON_SCREEN chop_ped
        AND IS_CURRENT_CHAR_WEAPON hPlayerPed WEAPONTYPE_UNARMED   
        AND IS_BUTTON_PRESSED PAD1 LEFTSHOULDER2
            PRINT_HELP_STRING "Press ~j~ to dismiss Chop."
            WHILE IS_CURRENT_CHAR_WEAPON hPlayerPed WEAPONTYPE_UNARMED   
            AND IS_BUTTON_PRESSED PAD1 LEFTSHOULDER2
                WAIT 0
                IF IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER1
                    REMOVE_CHAR_FROM_GROUP chop_ped
                    TASK_CHAR_SLIDE_TO_COORD chop_ped 1673.5386 -2082.1696 13.5468 0.0 15.0
                    WAIT 30000
                    GOTO chop_reset
                ENDIF
            ENDWHILE
        ENDIF

        IF IS_BUTTON_PRESSED PAD1 CIRCLE
        AND NOT IS_CHAR_IN_ANY_CAR hPlayerPed 
            WHILE IS_BUTTON_PRESSED PAD1 CIRCLE
                WAIT 0
            ENDWHILE

            GOSUB throw_ball 

            TASK_LOOK_AT_OBJECT chop_ped ball_obj 10000
            TASK_GO_TO_OBJECT chop_ped ball_obj -1 2.0
            WHILE NOT LOCATE_CHAR_ANY_MEANS_OBJECT_3D chop_ped ball_obj 2.0 2.0 2.0 0
                WAIT 0
            ENDWHILE

            TASK_PICK_UP_OBJECT chop_ped ball_obj 0.30f 0f 0f 18 16 NULL NULL -1
            WAIT 3000
            TASK_GOTO_CHAR chop_ped hPlayerPed -1 10.0

            WHILE NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D chop_ped hPlayerPed 10.0 10.0 10.0 0
                WAIT 0
            ENDWHILE

            SET_OBJECT_DYNAMIC phys_ball_obj 0
            SET_OBJECT_RECORDS_COLLISIONS phys_ball_obj 0
            SET_OBJECT_COLLISION phys_ball_obj 0
            GET_OBJECT_COORDINATES ball_obj (tmp_x tmp_y tmp_z) 
            GET_GROUND_Z_FOR_3D_COORD tmp_x tmp_y tmp_z tmp_z
            SET_OBJECT_COORDINATES phys_ball_obj tmp_x tmp_y tmp_z
            SET_OBJECT_COORDINATES ball_obj tmp_x tmp_y tmp_z
            DROP_OBJECT chop_ped 1

            WHILE NOT LOCATE_CHAR_ANY_MEANS_OBJECT_3D hPlayerPed ball_obj 1.0f 1.0f 1.0f 0
                WAIT 0
            ENDWHILE

            TASK_PLAY_ANIM_NON_INTERRUPTABLE hPlayerPed "BOM_PLANT_IN" "BOMBER" 4.0 0 0 0 0 -1 
            WAIT 1000 

            SET_OBJECT_RECORDS_COLLISIONS phys_ball_obj 1
            SET_OBJECT_COLLISION phys_ball_obj 1
            SET_OBJECT_VISIBLE ball_obj 1 
            DROP_OBJECT hPlayerPed 1 
            TASK_PICK_UP_OBJECT hPlayerPed ball_obj 0.08 0.03 0.0 6 16 "NULL" "NULL" 1 
        ENDIF
    GOTO chop_idle

    chop_reset:
    REMOVE_ANIMATION SKATE
    DELETE_CHAR chop_ped
    UNLOAD_SPECIAL_CHARACTER 1

    DELETE_OBJECT phys_ball_obj 
    DELETE_OBJECT ball_obj 
    MARK_OBJECT_AS_NO_LONGER_NEEDED ball_obj 
    MARK_MODEL_AS_NO_LONGER_NEEDED 3003 
    MARK_MODEL_AS_NO_LONGER_NEEDED 3065 
    REMOVE_ANIMATION "GRENADE" 
    REMOVE_ANIMATION "BOMBER" 
    GOTO chop_spawn_loop

    throw_ball:
    TASK_PLAY_ANIM_NON_INTERRUPTABLE hPlayerPed  "WEAPON_THROW"  "GRENADE"  4.0  0  0  0  0  600 
    WAIT 300 
    HIDE_CHAR_WEAPON_FOR_SCRIPTED_CUTSCENE hPlayerPed  1 
    GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hPlayerPed  0.35 0.6 0.9 tmp_x tmp_y tmp_z 
    GET_CHAR_HEADING hPlayerPed tmp_h 
    SET_OBJECT_COORDINATES phys_ball_obj tmp_x tmp_y tmp_z 
    tmp_h += 270.0 
    SET_OBJECT_HEADING phys_ball_obj tmp_h 
    SET_OBJECT_VISIBLE ball_obj 1 
    DROP_OBJECT hPlayerPed 0 
    ATTACH_OBJECT_TO_OBJECT ball_obj phys_ball_obj 0.0 0.0 0.0 90.0 270.0 0.0 
    WAIT 0 
    GET_CHAR_HEADING hPlayerPed tmp_h 
    GET_CHAR_HEIGHT_ABOVE_GROUND hPlayerPed float_18 
    float_4 = 50.0 
    SIN tmp_h float_5 
    COS tmp_h float_6 
    float_5 *= float_4 
    float_6 *= float_4 
    float_5 *= -1.0 
    float_18 += 1.0 
    SET_OBJECT_DYNAMIC phys_ball_obj 1 
    SET_OBJECT_VELOCITY phys_ball_obj float_5 float_6 float_18 
    WAIT 300
    RETURN
}

VAR_INT beggar_camp_status[6]

{
    beggar_camps_activator:

    beggar_camps_loop:
        WAIT 0

        IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1629.0180 -1542.4736 12.75 50f 50f 50f  0
        AND beggar_camp_status[0] = 0

            beggar_camp_status[0] = 1
            START_NEW_SCRIPT beggar_camps 1629.0180 -1542.4736 12.75 0
            WAIT 0
        ENDIF

        IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1567.1705 -1492.1428 12.75 50f 50f 50f  0
        AND beggar_camp_status[1] = 0
        
            beggar_camp_status[1] = 1
            START_NEW_SCRIPT beggar_camps 1567.1705 -1492.1428 12.75 1
            WAIT 0
        ENDIF

        IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1530.6510 -1011.4103 23.1 50f 50f 50f  0
        AND beggar_camp_status[2] = 0
        
            beggar_camp_status[2] = 1
            START_NEW_SCRIPT beggar_camps 1530.6510 -1011.4103 23.1 2
            WAIT 0
        ENDIF

        IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1806.9829 -1023.4615 23.1 50f 50f 50f  0
        AND beggar_camp_status[3] = 0
        
            beggar_camp_status[3] = 1
            START_NEW_SCRIPT beggar_camps 1806.9829 -1023.4615 23.1 3
            WAIT 0
        ENDIF


        IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1623.7724 -996.3151 23.1 50f 50f 50f  0
        AND beggar_camp_status[4] = 0
        
            beggar_camp_status[4] = 1
            START_NEW_SCRIPT beggar_camps 1623.7724 -996.3151 23.1 4
            WAIT 0
        ENDIF

        IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed 1686.1671 -997.1469 23.1 50f 50f 50f  0
        AND beggar_camp_status[5] = 0
        
            beggar_camp_status[5] = 1
            START_NEW_SCRIPT beggar_camps 1686.1671 -997.1469 23.1 5
            WAIT 0
        ENDIF
        
    GOTO beggar_camps_loop
}

{
    beggar_camps:
    SCRIPT_NAME BEGGARC 

    LVAR_FLOAT camp_x camp_y camp_z

    LVAR_INT camp_index

    LVAR_INT box_objects[5] objchairs[4] ped[4]

    LVAR_INT urb_object[3] fire iObject fireBin

    LVAR_INT peds_qt chair_qt tmp_rand i

    LVAR_FLOAT entity_x entity_y entity_z entity_h

    i = 0
    WHILE i < 8
        REQUEST_MODEL beggar_ids[i]
        i++
    ENDWHILE

    REQUEST_MODEL DYN_FIREBIN0
    REQUEST_MODEL smash_box_stay
    REQUEST_MODEL CJ_FOLDCHAIR
    REQUEST_ANIMATION GANGS
    REQUEST_MODEL 3044 // cigarro
    REQUEST_MODEL CJ_EASYCHAIR1
    REQUEST_MODEL CJ_SHTROLLY
    REQUEST_ANIMATION INT_HOUSE

    WHILE NOT HAS_MODEL_LOADED beggar_ids[0]
    OR    NOT HAS_MODEL_LOADED beggar_ids[1]
    OR    NOT HAS_MODEL_LOADED beggar_ids[2]
    OR    NOT HAS_MODEL_LOADED beggar_ids[3]
    OR    NOT HAS_MODEL_LOADED beggar_ids[4]
    OR    NOT HAS_MODEL_LOADED beggar_ids[5]
    OR    NOT HAS_MODEL_LOADED beggar_ids[6]
    OR    NOT HAS_MODEL_LOADED beggar_ids[7]
        WAIT 0
    ENDWHILE

    WHILE NOT HAS_ANIMATION_LOADED GANGS
    OR NOT HAS_ANIMATION_LOADED INT_HOUSE
    OR NOT HAS_MODEL_LOADED DYN_FIREBIN0
    OR NOT HAS_MODEL_LOADED smash_box_stay
    OR NOT HAS_MODEL_LOADED CJ_FOLDCHAIR
    OR NOT HAS_MODEL_LOADED 3044
    OR NOT HAS_MODEL_LOADED CJ_EASYCHAIR1
        WAIT 0
    ENDWHILE
    WHILE NOT HAS_MODEL_LOADED CJ_SHTROLLY
        WAIT 0
    ENDWHILE

    GENERATE_RANDOM_INT_IN_RANGE 0 4 peds_qt

    i = 0
    WHILE i < peds_qt
        GOSUB generate_coords

        GENERATE_RANDOM_INT_IN_RANGE 0 7 tmp_rand

        CREATE_CHAR PEDTYPE_CIVMALE beggar_ids[tmp_rand] entity_x entity_y camp_z ped[i]
        SET_CHAR_HEADING ped[i] entity_h

        GENERATE_RANDOM_INT_IN_RANGE 1 10 tmp_rand

        IF tmp_rand > 5
        AND tmp_rand < 8
            TASK_LOOK_ABOUT ped[i] 15000
        ELSE
            IF tmp_rand < 5

                entity_z = camp_z - 0.85
                SET_CHAR_COORDINATES ped[i] entity_x entity_y entity_z
                TASK_PLAY_ANIM ped[i] "BED_Loop_R" "INT_HOUSE" 4.0 1 0 0 0 -1
            ELSE
                CREATE_OBJECT 3044 0f 0f 0f iObject
                TASK_PICK_UP_OBJECT ped[i] iObject 0.04 0.1 0.05 6 16 "SMKCIG_PRTL" "GANGS" -1
            ENDIF
        ENDIF

        i++
    ENDWHILE

    GOSUB generate_coords
    CREATE_OBJECT DYN_FIREBIN0 entity_x entity_y camp_z fireBin
    entity_z = camp_z
    entity_z += 0.8

    IF peds_qt > 0
        START_SCRIPT_FIRE entity_x entity_y entity_z 0 0 fire 
    ENDIF

    i = 0
    WHILE i < 5
        GOSUB generate_coords
        CREATE_OBJECT smash_box_stay entity_x entity_y camp_z box_objects[i]
        i++
    ENDWHILE

    GENERATE_RANDOM_INT_IN_RANGE peds_qt 4 chair_qt
    i = 0
    WHILE i < chair_qt
        GOSUB generate_coords
        CREATE_OBJECT CJ_FOLDCHAIR entity_x entity_y camp_z objchairs[i]
        SET_OBJECT_HEADING objchairs[i] entity_h
        i++
    ENDWHILE

    GOSUB generate_coords
    CREATE_OBJECT CJ_EASYCHAIR1 entity_x entity_y camp_z urb_object[0]
    SET_OBJECT_HEADING urb_object[0] entity_h

    GOSUB generate_coords
    CREATE_OBJECT CJ_SHTROLLY entity_x entity_y camp_z urb_object[1]
    SET_OBJECT_HEADING urb_object[1] entity_h

    GOSUB generate_coords
    CREATE_OBJECT CJ_SHTROLLY entity_x entity_y camp_z urb_object[2]
    SET_OBJECT_HEADING urb_object[2] entity_h

    i = 0
    WHILE i < 8
        MARK_MODEL_AS_NO_LONGER_NEEDED beggar_ids[i]
        i++
    ENDWHILE

    MARK_MODEL_AS_NO_LONGER_NEEDED DYN_FIREBIN0
    MARK_MODEL_AS_NO_LONGER_NEEDED smash_box_stay
    MARK_MODEL_AS_NO_LONGER_NEEDED CJ_FOLDCHAIR
    MARK_MODEL_AS_NO_LONGER_NEEDED 3044
    MARK_MODEL_AS_NO_LONGER_NEEDED CJ_EASYCHAIR1
    MARK_MODEL_AS_NO_LONGER_NEEDED CJ_SHTROLLY
    REMOVE_ANIMATION GANGS

    WHILE LOCATE_CHAR_ANY_MEANS_3D hPlayerPed camp_x camp_y camp_z 60f 60f 60f 0
        WAIT 0
        IF peds_qt > 0
            IF IS_SCRIPT_FIRE_EXTINGUISHED fire
                i = 0
                WHILE i < peds_qt
                    CLEAR_CHAR_TASKS_IMMEDIATELY ped[i]
                    TASK_KILL_CHAR_ON_FOOT ped[i] hPlayerPed
                    i++
                ENDWHILE
            ENDIF
        ENDIF
    ENDWHILE

    i = 0
    WHILE i < peds_qt
        DELETE_CHAR ped[i]
        i++
    ENDWHILE

    i = 0
    WHILE i < 5
        DELETE_OBJECT box_objects[i]
        i++
    ENDWHILE

    i = 0
    WHILE i < chair_qt
        DELETE_OBJECT objchairs[i]
        i++
    ENDWHILE

    DELETE_OBJECT urb_object[0]
    DELETE_OBJECT urb_object[1]
    DELETE_OBJECT urb_object[2]
    DELETE_OBJECT iObject

    DELETE_OBJECT fireBin

    IF peds_qt > 0
        REMOVE_SCRIPT_FIRE fire
    ENDIF

    beggar_camp_status[camp_index] = 0
    
    TERMINATE_THIS_SCRIPT

    generate_coords:
    GENERATE_RANDOM_FLOAT_IN_RANGE -6.0 6.0 entity_x
    GENERATE_RANDOM_FLOAT_IN_RANGE -6.0 6.0 entity_y
    GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 360.0 entity_h
    entity_x += camp_x
    entity_y += camp_y

    RETURN
}

{
    car_wash:
    LVAR_INT hVeh pVeh p hFx hBlip iBlipSpriteID i
    LVAR_FLOAT fDirt

    LVAR_INT pEntity // In
    LVAR_FLOAT x y z // In
    LVAR_INT pMatrix pCoord

    LVAR_FLOAT CAMERA1X CAMERA1Y CAMERA1Z
    LVAR_FLOAT CAMERA2X CAMERA2Y CAMERA2Z

    LVAR_FLOAT CARX CARY CARZ CARA

    LVAR_FLOAT PARTICLEX PARTICLEY PARTICLEZ

    LVAR_FLOAT CARDX CARDY

    iBlipSpriteID = 55

    ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD 2139.2253 2714.3403 0.0 iBlipSpriteID hBlip
    ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD 2162.7361 2464.7861 0.0 iBlipSpriteID hBlip
    ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD 2464.9353 -1461.2537 0.0 iBlipSpriteID hBlip
    ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD 1910.7087 -1768.9048 0.0 iBlipSpriteID hBlip
    ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD 1018.8 -926.1744 0.0 iBlipSpriteID hBlip

    WHILE NOT IS_GERMAN_GAME
        WAIT 150
        IF IS_CHAR_SITTING_IN_ANY_CAR hPlayerPed
            IF IS_PLAYER_CONTROL_ON 0
            AND NOT IS_WANTED_LEVEL_GREATER 0 0
                STORE_CAR_CHAR_IS_IN_NO_SAVE hPlayerPed hVeh
                GET_DRIVER_OF_CAR hVeh p
                IF p = hPlayerPed
                    GOSUB CheckList
                ENDIF
            ENDIF
        ENDIF
    ENDWHILE


    CheckList:
    GOSUB east_ls
    GOSUB idlewood
    GOSUB vinewood
    GOSUB pickle
    GOSUB esmerald
    RETURN


    Pressed:
    IF IS_BUTTON_PRESSED PAD1 DPADRIGHT
        IS_INT_LVAR_GREATER_THAN_CONSTANT TIMERA -1 // RETURN_TRUE
        RETURN
    ELSE
        IF timerb > 5000
            PRINT_HELP_STRING "Press ~>~ to wash your car."
            timerb = 0
        ENDIF
    ENDIF
    IS_INT_LVAR_EQUAL_TO_CONSTANT TIMERA -1 // RETURN_FALSE
    RETURN


    east_ls:
    CARX = 2464.9353
    CARY = -1461.2537
    CARZ = 23.6362
    IF LOCATE_CAR_3D hVeh CARX CARY CARZ 4.0 4.0 2.0 FALSE
        IF GOSUB Pressed
            CARA = 90.0

            CAMERA1X = 2433.4844
            CAMERA1Y = -1466.8766
            CAMERA1Z = 26.0

            CAMERA2X = 2450.9875
            CAMERA2Y = -1460.3097
            CAMERA2Z = 24.0

            PARTICLEX = 2452.3738
            PARTICLEY = -1461.2537
            PARTICLEZ = 23.0

            CARDX = 2442.8247
            CARDY = -1461.042
            GOSUB wash_activate
        ENDIF
    ENDIF
    RETURN


    idlewood:
    CARX = 1910.7087
    CARY = -1768.9048
    CARZ = 12.8471
    IF LOCATE_CAR_3D hVeh CARX CARY CARZ 4.0 4.0 2.0 FALSE
        IF GOSUB Pressed
            CARA = 180.0

            CAMERA1X = 1906.5447
            CAMERA1Y = -1789.3156
            CAMERA1Z = 15.0

            CAMERA2X = 1912.2312
            CAMERA2Y = -1779.7174
            CAMERA2Z = 13.3828


            PARTICLEX = 1911.6976 
            PARTICLEY = -1777.4185
            PARTICLEZ = 12.3

            CARDX = 1911.6588
            CARDY = -1784.8184
            GOSUB wash_activate
        ENDIF
    ENDIF
    RETURN


    vinewood:
    CARX = 1018.8
    CARY = -926.1744
    CARZ = 41.6421
    IF LOCATE_CAR_3D hVeh CARX CARY CARZ 4.0 4.0 2.0 FALSE
        IF GOSUB Pressed
            CARA = 8.0

            CAMERA1X = 1020.0527
            CAMERA1Y = -906.0007
            CAMERA1Z = 44.0

            CAMERA2X = 1016.6766
            CAMERA2Y = -913.4736
            CAMERA2Z = 42.1797

            PARTICLEX = 1017.2542
            PARTICLEY = -916.9676
            PARTICLEZ = 41.808

            CARDX = 1016.2774
            CARDY = -908.9207
            GOSUB wash_activate
        ENDIF
    ENDIF
    RETURN


    pickle:
    CARX = 2139.2253
    CARY = 2714.3403
    CARZ = 10.2835
    IF LOCATE_CAR_3D hVeh CARX CARY CARZ 4.0 4.0 2.0 FALSE
        IF GOSUB Pressed
            CARA = 270.0

            CAMERA1X = 2168.9836
            CAMERA1Y = 2708.6091
            CAMERA1Z = 12.0

            CAMERA2X = 2156.1731
            CAMERA2Y = 2715.6377
            CAMERA2Z = 10.0

            PARTICLEX = 2147.9233
            PARTICLEY = 2714.2554
            PARTICLEZ = 10.2825

            CARDX = 2158.041
            CARDY = 2714.2927
            GOSUB wash_activate
        ENDIF
    ENDIF
    RETURN


    esmerald:
    CARX = 2162.7361
    CARY = 2464.7861
    CARZ = 10.2878
    IF LOCATE_CAR_3D hVeh CARX CARY CARZ 4.0 4.0 2.0 FALSE
        IF GOSUB Pressed
            CARA = 0.0

            CAMERA1X = 2168.8884
            CAMERA1Y = 2490.2102
            CAMERA1Z = 12.0

            CAMERA2X = 2162.6309
            CAMERA2Y = 2479.6628
            CAMERA2Z = 10.0

            PARTICLEX = 2162.8997
            PARTICLEY = 2474.468
            PARTICLEZ = 10.2825

            CARDX = 2162.7354
            CARDY = 2481.2876
            GOSUB wash_activate
        ENDIF
    ENDIF
    RETURN



    wash_activate:
    ADD_SCORE 0 -50

    SET_PLAYER_CONTROL 0 OFF
    SET_FIXED_CAMERA_POSITION CAMERA1X CAMERA1Y CAMERA1Z 0.0 0.0 0.0 
    POINT_CAMERA_AT_POINT CAMERA2X CAMERA2Y CAMERA2Z 2

    // GET_VEHICLE_DIRT_LEVEL
    GET_VEHICLE_POINTER hVeh pVeh
    p = pVeh + 0x4B8 // mDirtLevel
    READ_MEMORY p 4 FALSE (fDirt)

    SET_CAR_COORDINATES_NO_OFFSET hVeh CARX CARY CARZ

    p = pVeh + 0x5D0 // mSubClass
    READ_MEMORY p 4 FALSE (i)
    IF i = VEHICLE_SUBCLASS_BIKE // BIKE
    OR i = VEHICLE_SUBCLASS_BMX //BMX
        CLEO_CALL SetEntityPosSimple 0 (pVeh CARX CARY CARZ)
    ENDIF

    SET_CAR_HEADING hVeh CARA
    SET_CAR_FORWARD_SPEED hVeh 0.0

    CREATE_FX_SYSTEM "carwashspray" PARTICLEX PARTICLEY PARTICLEZ 1 (hFx)
    PLAY_FX_SYSTEM hFx

    CAR_GOTO_COORDINATES_ACCURATE hVeh CARDX CARDY CARZ
    SET_CAR_CRUISE_SPEED hVeh 4.5
    SET_CAR_MISSION hVeh MISSION_GOTOCOORDS_STRAIGHT

    timera = 0
    WHILE NOT LOCATE_CAR_2D hVeh CARDX CARDY 3.0 3.0 FALSE
    AND timera < 10000
        WAIT 0
        IF NOT DOES_VEHICLE_EXIST hVeh
            SET_PLAYER_CONTROL 0 ON
            RESTORE_CAMERA
            RETURN
        ENDIF
        IF fDirt > 0.0
            fDirt -=@ 0.1
            IF fDirt < 0.0
                fDirt = 0.0
            ENDIF
            SET_VEHICLE_DIRT_LEVEL hVeh fDirt
        ENDIF
    ENDWHILE
    KILL_FX_SYSTEM hFx


    RESTORE_CAMERA

    WAIT 1000

    SET_CAR_MISSION hVeh MISSION_NONE
    WARP_CHAR_INTO_CAR hPlayerPed hVeh
    SET_PLAYER_CONTROL 0 ON

    RETURN
}

{
    LVAR_INT pEntity // In
    LVAR_FLOAT x y z // In
    LVAR_INT pMatrix pCoord

    SetEntityPosSimple:
    pMatrix = pEntity + 0x14
    READ_MEMORY pMatrix 4 FALSE (pMatrix)
    pCoord = pMatrix + 0x30
    WRITE_MEMORY pCoord 4 (x) FALSE
    pCoord += 0x4 // y
    WRITE_MEMORY pCoord 4 (y) FALSE
    pCoord += 0x4 // y
    WRITE_MEMORY pCoord 4 (z) FALSE
    CLEO_RETURN 0 ()
}

/*
{
    LVAR_FLOAT ExplosionBlur
    CONST_INT pCamera 0x6FE530 // OK
    
    LVAR_INT pShakeStartTime
    LVAR_FLOAT pShakeIntensity                    
    LVAR_INT ShakeStartTime
    LVAR_FLOAT ShakeIntensity
    LVAR_INT TimeInMilliseconds
    LVAR_FLOAT x
        
    LVAR_INT i
    LVAR_INT k
    LVAR_INT n

    GOSUB PATCH
    ExplosionBlur = 0.0
    pShakeIntensity = pCamera + 0x12C
    pShakeStartTime = pCamera + 0x5C


    WHILE NOT IS_GERMAN_GAME
        WAIT 0

        READ_MEMORY pShakeIntensity 4 FALSE (ShakeIntensity)
        READ_MEMORY pShakeStartTime 4 FALSE (ShakeStartTime) 
        READ_MEMORY 0xB7CB84 4 FALSE (TimeInMilliseconds)

        TimeInMilliseconds -= ShakeStartTime    
        x =# TimeInMilliseconds
        x *= 0.00028
        ShakeIntensity -= x    

        IF ShakeIntensity > 0.0
        THEN
            ExplosionBlur +=@ 1.0
            IF ExplosionBlur > 1.0
            THEN
                ExplosionBlur = 1.0
            END
        ELSE
            IF ExplosionBlur > 0.0
            THEN
                ExplosionBlur -=@ 0.05        
            END        
            IF ExplosionBlur < 0.0
            THEN
                ExplosionBlur = 0.0
            END
        END
    END


    PATCH:
    GET_LABEL_POINTER _ASM (k)
    GET_VAR_POINTER n (ExplosionBlur)
    // Setup the pointer at [@_ASM+2] to local variable 0
    k += 3
    WRITE_MEMORY k 4 n FALSE 
    k -= 3


    // Patch
    k -= 0x704DB1
    WRITE_MEMORY 0x704DAB 1 0x90 TRUE
    WRITE_MEMORY 0x704DAC 1 0xE8 TRUE
    WRITE_MEMORY 0x704DAD 4 k TRUE

    // NOP a check that avoids the blur in certain camera modes (may not be a good idea?)
    WRITE_MEMORY 0x704D9C 2 0x9090 TRUE
    WRITE_MEMORY 0x704D9E 4 0x90909090 TRUE

    RETURN


    _ASM:
    DUMP
        50              // push eax
        52              // push edx
        BA 00000000     // mov edx, 0x0 (address of explosion blur)
        D9 05 C802C400  // fld dword ptr [BlurLevel]
        D8 1A           // fcomp dword ptr [edx]
        DFE0            // fnstsw ax
        F6 C4 05        // test ah, 0x05
        7A 08           // jp _OUT              -- BlurLevel < ExplosionBlur
        8B 02           // mov eax, dword ptr [edx]
        89 05 C802C400  // mov dword ptr [BlurLevel], eax
                        //
                        // _OUT:
        5A              // pop edx
        58              // pop eax
        D9 05 C802C400  // fld dword ptr [BlurLevel]
        C3              // retn          
    ENDDUMP

}
*/

{
    manual_reload:
    LVAR_INT playerId pPed i j iCurWeapon iSkill iMaxAmmo iCurAmmo pWeapon pWeaponInfo iTimeInMilliseconds iReloadTime iLastCurAmmo iTotalAmmo

    /////////////////////////////////////////////
 
    WHILE NOT IS_GERMAN_GAME
        WAIT 0
        playerId = 0
        GOSUB Activate
    ENDWHILE

    Activate:
    IF IS_PLAYER_CONTROL_ON playerId
        IF IS_BUTTON_PRESSED PAD1 CIRCLE
            GET_PED_POINTER hPlayerPed (pPed)
            i = pPed + 0x758 //m_nActiveWeaponSlot
            READ_MEMORY i 1 0 (i)

            IF NOT i = 0
            AND NOT IS_CHAR_DEAD hPlayerPed

                i *= 0x1C //sizeof CWeapon
                i += pPed

                pWeapon = i + 0x5E0 //CWeapon

                GET_CURRENT_CHAR_WEAPON hPlayerPed (iCurWeapon)

                //char __thiscall CPed::GetWeaponSkill(CPed *this, eWeaponType weaponType)
                CALL_METHOD_RETURN 0x19A1C0 pPed 1 0 (iCurWeapon)(iSkill) 

                //CWeaponInfo *__cdecl CWeaponInfo::GetWeaponInfo(eWeaponType weaponID, char skill)
                CALL_FUNCTION_RETURN 0x1410B0 2 2 (iCurWeapon iSkill)(pWeaponInfo) 

                iMaxAmmo = pWeaponInfo + 0x20 //ammoClip
                READ_MEMORY iMaxAmmo 2 0 (iMaxAmmo)
                IF iMaxAmmo > 1 // only activate on weapons with clips
                    iCurAmmo = pWeapon + 0x8 //m_nAmmoInClip
                    READ_MEMORY iCurAmmo 4 0 (iCurAmmo)

                    IF iCurAmmo = iMaxAmmo
                        RETURN
                    ENDIF

                    iCurAmmo = pWeapon + 0xC //m_nTotalAmmo
                    READ_MEMORY iCurAmmo 4 0 (iTotalAmmo)
                    IF iTotalAmmo <= 0
                        RETURN
                    ENDIF

                    //signed int __thiscall CWeaponInfo::GetWeaponReloadTime(CWeaponInfo *this)
                    CALL_METHOD_RETURN 0x141270 pWeaponInfo 0 0 ()(iReloadTime)

                    // Fast reload tweak
                    j = playerId * 0x190 //sizeof CPlayerInfo
                    j += 0x66BA14
                    READ_MEMORY j 1 0 (j) //CWorld::Players[playerId].fastReload
                    IF j = 1
                        iReloadTime /= 4
                    ENDIF

                    // Set shot timer limit
                    READ_MEMORY 0x66BA14 4 0 (iTimeInMilliseconds)
                    j = iReloadTime + iTimeInMilliseconds
                    i = pWeapon + 0x10 //m_nShotTimer
                    WRITE_MEMORY i 4 (j) 0

                    // Set reload state
                    i = pWeapon + 0x4 //m_nState
                    WRITE_MEMORY i 4 (2) 0

                    // Wait reload END
                    timera = 0
                    i = pWeapon + 0x8 //m_nAmmoInClip
                    READ_MEMORY i 4 0 (iLastCurAmmo)
                    WHILE iLastCurAmmo = iCurAmmo
                    AND timera < 3000 // anti-bug
                        WAIT 0
                        READ_MEMORY i 4 0 (iLastCurAmmo)
                    ENDWHILE

                ENDIF
            ENDIF
        ENDIF
    ENDIF
    RETURN
}

{
    als:
    LVAR_INT VehMinValue SoundID CurrentVehicle VehiclePtr VehSubClass CurrentVehModel SomethingChangingWithGearChanging VehFlags AccPedal RPM pHandling Particle int_22 int_23 int_24 int_25 int_26 i rand_1 rand_2
    LVAR_FLOAT float_10 float_11 float_12 float_13 float_14 float_15 float_16 VehSpeed 
    LVAR_INT VehicleID DummyID

    VehMinValue = 60000
    SoundID = 1131

    WHILE NOT IS_GERMAN_GAME
        WAIT 0
        IF NOT IS_CHAR_SITTING_IN_ANY_CAR hPlayerPed
            CONTINUE
        ENDIF
        STORE_CAR_CHAR_IS_IN_NO_SAVE hPlayerPed (CurrentVehicle)
        GET_VEHICLE_POINTER CurrentVehicle (VehiclePtr)
        VehSubClass = VehiclePtr + 0x5D0 //mSubClass - OK
        READ_MEMORY VehSubClass 4 0 (VehSubClass)
        IF VehSubClass = 0 //VEHICLE_AUTOMOBILE  
        OR VehSubClass = 9 //VEHICLE_BIKE         
            GET_CAR_MODEL CurrentVehicle (CurrentVehModel)
            GET_CAR_MODEL_VALUE CurrentVehModel (SomethingChangingWithGearChanging)
            IF SomethingChangingWithGearChanging > VehMinValue
                SomethingChangingWithGearChanging = VehiclePtr + 0x27C //SomethingChangingWithGearChanging...  
                AccPedal = VehiclePtr + 0x9C2 //AccPedal - OK                             
                RPM = VehiclePtr + 0x278 //RPM                                   
                VehSubClass = VehiclePtr + 0x37C //bNitroActivated                       
                VehFlags = VehiclePtr + 0x430 //Flags - OK

                VehicleID = CurrentVehModel
                DummyID = 0x6

                GOSUB GetVehicleDummyPosOffset

                pHandling = VehiclePtr + 0x38C //pHandling - OK  
                READ_MEMORY pHandling 4 0 (pHandling)

                pHandling += 0xCC //ModelFlags    
                READ_MEMORY pHandling 4 0 (pHandling)
                IF IS_LOCAL_VAR_BIT_SET_CONST pHandling 13 //VEHICLE_HANDLING_MODEL_DOUBLE_EXHAUST
                    float_10 = float_11
                    float_10 *= -1.0
                ELSE 
                    float_10 = 0.0
                ENDIF

                WHILE IS_CHAR_SITTING_IN_ANY_CAR hPlayerPed
                    WAIT 0
                    IF NOT DOES_VEHICLE_EXIST CurrentVehicle
                        BREAK
                    ENDIF
    
                    READ_MEMORY VehSubClass 1 0 (int_24) // bNitroActivated 
                    IF NOT int_24 = 0
                        CONTINUE
                    ENDIF

                    READ_MEMORY SomethingChangingWithGearChanging 1 0 (int_26) //SomethingChangingWithGearChanging...  

                    READ_MEMORY RPM 2 0 (int_22) //RPM   

                    GET_CAR_SPEED CurrentVehicle (VehSpeed)

                    IF int_26 = 0     //is back to gear
                    AND NOT int_22 = 65535 //not in last gear
                    AND int_22 > 100    //not starting to accelerate
                    AND VehSpeed > 5.0    //not stopped
                        GOSUB BackFire
                    ENDIF        

                    READ_MEMORY AccPedal 1 0 (int_25) //AccPedal  

                    READ_MEMORY VehFlags 1 0 (int_24) //flags
                    IF IS_LOCAL_VAR_BIT_SET_CONST int_24 5
                    AND int_25 = 128 //full throttle
                        GOSUB BackFire_Multi
                    ENDIF 

                    IF int_23 = false
                        IF int_25 = 128
                            int_23 = true
                        ENDIF
                    ELSE  
                        IF int_25 < 100
                            GOSUB BackFire_Multi
                            int_23 = false  
                        ENDIF
                    ENDIF
                ENDWHILE
            ELSE 
                GOSUB WhileInCar
            ENDIF 
        ELSE 
            GOSUB WhileInCar
        ENDIF
    ENDWHILE



    WhileInCar:
    WHILE IS_CHAR_SITTING_IN_ANY_CAR hPlayerPed
        WAIT 0
    ENDWHILE
    RETURN


    BackFire:
    IF NOT float_10 = 0.0 //double exhausts

        CREATE_FX_SYSTEM_ON_CAR_WITH_DIRECTION "GUNFLASH" CurrentVehicle float_11 float_12 float_13 0.0 -25.0 0.0 1 (Particle)
        PLAY_AND_KILL_FX_SYSTEM Particle 

        CREATE_FX_SYSTEM_ON_CAR_WITH_DIRECTION "GUNFLASH" CurrentVehicle float_10 float_12 float_13 0.0 -25.0 0.0 1 (Particle)
        PLAY_AND_KILL_FX_SYSTEM Particle 

        GET_OFFSET_FROM_CAR_IN_WORLD_COORDS CurrentVehicle 0.0 float_12 float_13 (float_14 float_15 float_16)
        GOSUB PlaySound
    ELSE
        CREATE_FX_SYSTEM_ON_CAR_WITH_DIRECTION "GUNFLASH" CurrentVehicle float_11 float_12 float_13 0.0 -25.0 0.0 1 (Particle)
        PLAY_AND_KILL_FX_SYSTEM Particle 
        GET_OFFSET_FROM_CAR_IN_WORLD_COORDS CurrentVehicle float_11 float_12 float_13 (float_14 float_15 float_16)
        GOSUB PlaySound
    ENDIF
    RETURN
    
    BackFire_Multi:
    GENERATE_RANDOM_INT_IN_RANGE 0 4 (rand_2)

    i = 0
    WHILE i <= rand_2 
        GENERATE_RANDOM_INT_IN_RANGE 20 300 (rand_1)
        WAIT rand_1  
        DOES_VEHICLE_EXIST CurrentVehicle
        RETURN_IF_FALSE

        IF NOT float_10 = 0.0 //double exhausts

            CREATE_FX_SYSTEM_ON_CAR_WITH_DIRECTION "GUNFLASH" CurrentVehicle float_11 float_12 float_13 0.0 -25.0 0.0 1 (Particle)
            PLAY_AND_KILL_FX_SYSTEM Particle 

            CREATE_FX_SYSTEM_ON_CAR_WITH_DIRECTION "GUNFLASH" CurrentVehicle float_10 float_12 float_13 0.0 -25.0 0.0 1 (Particle)
            PLAY_AND_KILL_FX_SYSTEM Particle 

            GET_OFFSET_FROM_CAR_IN_WORLD_COORDS CurrentVehicle 0.0 float_12 float_13 (float_14 float_15 float_16)
            GOSUB PlaySound
        ELSE
            CREATE_FX_SYSTEM_ON_CAR_WITH_DIRECTION "GUNFLASH" CurrentVehicle float_11 float_12 float_13 0.0 -25.0 0.0 1 (Particle)
            PLAY_AND_KILL_FX_SYSTEM Particle 

            GET_OFFSET_FROM_CAR_IN_WORLD_COORDS CurrentVehicle float_11 float_12 float_13 (float_14 float_15 float_16)
            GOSUB PlaySound
        ENDIF
        i++
    ENDWHILE
    RETURN

    PlaySound:
    ADD_ONE_OFF_SOUND float_14 float_15 float_16 SoundID
    RETURN

    GetVehicleDummyPosOffset:
    VehicleID *= 4
    VehicleID += 0x7A8780
    
    READ_MEMORY VehicleID 4 0 (VehicleID)

    VehicleID += 0x5C  // vehstruct
    READ_MEMORY VehicleID 4 0 (VehicleID)
    DummyID *= 0xC   // sizeof Rwv3d
    VehicleID += DummyID
    READ_MEMORY VehicleID 4 0 (float_11)
    VehicleID += 0x4
    READ_MEMORY VehicleID 4 0 (float_12)
    VehicleID += 0x4
    READ_MEMORY VehicleID 4 0 (float_13)
    RETURN
}

{
    improvedMove:
    SCRIPT_NAME IMPMOVE
    LVAR_INT iStickX iStickY j

    WRITE_MEMORY 0x467184 4 0x3C034370 0 // Analog Sensitivity

    WRITE_MEMORY 0x1A2E04 4 0x3C024000 0 //g_AnimBlendSpeed
    WRITE_MEMORY 0x1A2868 4 0x3C024000 0 //g_AnimBlendSpeed
    WRITE_MEMORY 0x1A2780 4 0x3C024000 0 //g_AnimBlendSpeed
    WRITE_MEMORY 0x1A2998 4 0x3C03C000 0 //-g_AnimBlendSpeed

    WRITE_MEMORY 0x1A2E3C 4 0x3C023f80 0 //g_AnimBlendSpeed / 2
    WRITE_MEMORY 0x1A2E70 4 0x3C043f80 0 //g_AnimBlendSpeed / 2
    WRITE_MEMORY 0x1A2E74 4 0x3C03bf80 0 // - (g_AnimBlendSpeed / 2)

    walk_loop:
        IF IS_PLAYER_CONTROL_ON iPlayer
            GET_POSITION_OF_ANALOGUE_STICKS PAD1 iStickX iStickY j j
            IF IS_BUTTON_PRESSED PAD1 CROSS
                IF NOT iStickX = 0
                OR NOT iStickY = 0
                    TIMERA = 0
                    WRITE_MEMORY 0x467184 4 0x3C034270 0
                    WHILE NOT iStickX = 0
                    OR NOT iStickY = 0
                        GET_POSITION_OF_ANALOGUE_STICKS PAD1 iStickX iStickY j j
                        WAIT 0
                    ENDWHILE
                    WRITE_MEMORY 0x467184 4 0x3C034370 0
                ENDIF
            ENDIF
        ENDIF
        WAIT 0
    GOTO walk_loop
}

{
    ConsoleLog:
        CALL_FUNCTION_RETURN (strlen 1 0)(pTextBuffer) (iStrLen)
        iEndLinePtr = pTextBuffer + iStrLen
        WRITE_MEMORY iEndLinePtr 1 0x0A TRUE

        CALL_FUNCTION (printf 1 0)(pTextBuffer)
    RETURN
}

{
    coordinate_logger:
    SCRIPT_NAME PCORLOG
    LVAR_FLOAT v3dPlayerCoords[3] fPlayerHeading 
    VAR_INT iStrLen iEndLinePtr

    coordinate_logger_loop:
        WAIT 0
        IF IS_BUTTON_PRESSED PAD1 LEFTSHOULDER2
            WHILE IS_BUTTON_PRESSED PAD1 LEFTSHOULDER2
                WAIT 0
            ENDWHILE

            GET_CHAR_COORDINATES (hPlayerPed) (v3dPlayerCoords[0] v3dPlayerCoords[1] v3dPlayerCoords[2])
            GET_CHAR_HEADING (hPlayerPed) (fPlayerHeading)

            STRING_FORMAT pTextBuffer "%f %f %f %f" v3dPlayerCoords[0] v3dPlayerCoords[1] v3dPlayerCoords[2] fPlayerHeading
            PRINT_STRING_NOW $pTextBuffer 3000

            GOSUB ConsoleLog
        ENDIF
    GOTO coordinate_logger_loop
}


{
    fps_counter:
    SCRIPT_NAME SHOWFPS
    VAR_INT fps_counter_active
    LVAR_INT a b

    WHILE NOT IS_GERMAN_GAME
        a = 0
        TIMERA = 0
        WHILE TIMERA < 1000 
            GOSUB show
            WAIT 0
            a++
        ENDWHILE
        a--
        b = a    
        GOSUB show   
        WAIT 0
    ENDWHILE

    show:   
        USE_TEXT_COMMANDS 1
        GOSUB SetupFPSDraw
        DISPLAY_TEXT_WITH_NUMBER 12.0 72.0 _FPSCN1 b
        USE_TEXT_COMMANDS 0
    RETURN 


    SetupFPSDraw:
        SET_TEXT_FONT 2
        SET_TEXT_SCALE 0.3 1.2
        SET_TEXT_COLOUR 255 255 255 255
        SET_TEXT_BACKGROUND 0
        SET_TEXT_PROPORTIONAL 0
        SET_TEXT_DRAW_BEFORE_FADE 1
        SET_TEXT_DROPSHADOW 0 0 0 0 0
        SET_TEXT_EDGE 1 0 0 0 255
        SET_TEXT_JUSTIFY 0
        SET_TEXT_WRAPX 130.0
    RETURN
}


{
    streaming_usage:
    LVAR_INT total_mem used_mem
    VAR_INT stream_counter_active

    SCRIPT_NAME STRUSE

    WHILE NOT IS_GERMAN_GAME
        WAIT 0
        READ_MEMORY 0x66BE0C 4 0 (used_mem)
        used_mem /= 1024
        READ_MEMORY 0x666E08 4 0 (total_mem)  
        total_mem /= 1024 

        USE_TEXT_COMMANDS 1
        GOSUB SetupStreamDraw
        DISPLAY_TEXT_WITH_2_NUMBERS 12.0 12.0 _STRMUG used_mem total_mem
        USE_TEXT_COMMANDS 0
    ENDWHILE

    SetupStreamDraw:
        SET_TEXT_FONT 2
        SET_TEXT_SCALE 0.3 1.2
        SET_TEXT_COLOUR 255 255 255 255
        SET_TEXT_BACKGROUND 0
        SET_TEXT_PROPORTIONAL 0
        SET_TEXT_DRAW_BEFORE_FADE 1
        SET_TEXT_DROPSHADOW 0 0 0 0 0
        SET_TEXT_EDGE 1 0 0 0 255
        SET_TEXT_JUSTIFY 0
        SET_TEXT_WRAPX 130.0
    RETURN
}

{
    memory_usage:
    LVAR_INT total_mem used_mem
    VAR_INT memory_counter_active

    SCRIPT_NAME MEMUSE

    WHILE NOT IS_GERMAN_GAME
        WAIT 0
        READ_MEMORY 0x66B180 4 0 (used_mem)
        used_mem += 8016120
        used_mem /= 1024
        CALL_FUNCTION_RETURN 0x53BC00 0 0 (total_mem)  
        total_mem /= 1024 

        USE_TEXT_COMMANDS 1
        GOSUB SetupMemDraw
        DISPLAY_TEXT_WITH_2_NUMBERS 12.0 42.0 _MEMUG used_mem total_mem
        USE_TEXT_COMMANDS 0
    ENDWHILE

    SetupMemDraw:
        SET_TEXT_FONT 2
        SET_TEXT_SCALE 0.3 1.2
        SET_TEXT_COLOUR 255 255 255 255
        SET_TEXT_BACKGROUND 0
        SET_TEXT_PROPORTIONAL 0
        SET_TEXT_DRAW_BEFORE_FADE 1
        SET_TEXT_DROPSHADOW 0 0 0 0 0
        SET_TEXT_EDGE 1 0 0 0 255
        SET_TEXT_JUSTIFY 0
        SET_TEXT_WRAPX 130.0
    RETURN
}


{
    advanced_settings:
    SCRIPT_NAME ADVSETS
    LVAR_INT hAdvancedSettingsMenu iSelected iTemp iTotalStreamMemory iDesiredVehicles
    LVAR_FLOAT fDrawDistance fLODDistance

    CREATE_MENU VLSETS 50f 50f 300f 1 TRUE TRUE 0 (hAdvancedSettingsMenu)
    SET_MENU_COLUMN hAdvancedSettingsMenu 0 DUMMY VLMEMC VLFRLM VLFPSC VLDRDS VLLDDS VLSTRC VLSTMEM VLVEHC DUMMY DUMMY DUMMY DUMMY
    SET_MENU_COLUMN_ORIENTATION hAdvancedSettingsMenu 0 1

    READ_MEMORY 0x66659C 4 TRUE (fDrawDistance)
    READ_MEMORY 0x666E08 4 TRUE (iTotalStreamMemory)
    READ_MEMORY 0x666E0C 4 TRUE (iDesiredVehicles)
    READ_MEMORY 0x6665A0 4 TRUE (fLODDistance)

    advanced_settings_loop:
        WAIT 0
        GET_MENU_ITEM_SELECTED (hAdvancedSettingsMenu) (iSelected)

        IF iSelected = 3
            PRINT_FORMATTED_NOW "Draw distance %g" 1 fDrawDistance
        ELSE
            IF iSelected = 4
                PRINT_FORMATTED_NOW "LOD distance %g" 1 fLODDistance
            ELSE
                IF iSelected = 6
                    PRINT_FORMATTED_NOW "Available stream %d" 1 iTotalStreamMemory
                ELSE
                    IF iSelected = 7
                        PRINT_FORMATTED_NOW "Vehicles %d" 1 iDesiredVehicles
                    ENDIF
                ENDIF
            ENDIF
        ENDIF

        IF IS_BUTTON_PRESSED PAD1 DPADLEFT
            WHILE IS_BUTTON_PRESSED PAD1 DPADLEFT
                WAIT 0
            ENDWHILE
            IF iSelected = 3
                fDrawDistance -= 0.05f
            ENDIF
            IF iSelected = 4
                fLODDistance -= 0.05f
            ENDIF
            IF iSelected = 6
                iTotalStreamMemory -= 1024
            ENDIF
            IF iSelected = 7
                iDesiredVehicles -= 1
            ENDIF
        ENDIF

        IF IS_BUTTON_PRESSED PAD1 DPADRIGHT
            WHILE IS_BUTTON_PRESSED PAD1 DPADRIGHT
                WAIT 0
            ENDWHILE
            IF iSelected = 3
                fDrawDistance += 0.05f
            ENDIF
            IF iSelected = 4
                fLODDistance += 0.05f
            ENDIF
            IF iSelected = 6
                iTotalStreamMemory += 1024
            ENDIF
            IF iSelected = 7
                iDesiredVehicles += 1
            ENDIF
        ENDIF

        IF IS_BUTTON_PRESSED PAD1 CROSS
            WHILE IS_BUTTON_PRESSED PAD1 CROSS
                WAIT 0
            ENDWHILE

            SWITCH iSelected
                CASE 0 // Whole memory counter
                    IF memory_counter_active = 0
                        memory_counter_active = 1
                        START_NEW_SCRIPT memory_usage
                    ELSE
                        memory_counter_active = 0
                        TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME MEMUSE
                    ENDIF
                    BREAK
                CASE 1 // Toggle frame limiter
                    READ_MEMORY 0x6678CC 1 TRUE (iTemp) 
                    IF iTemp = 2
                        WRITE_MEMORY 0x6678CC 1 1 TRUE 
                    ELSE
                        WRITE_MEMORY 0x6678CC 1 2 TRUE 
                    ENDIF
                    
                    CALL_FUNCTION 0x359C20 0 0 // RpSkyResume
                    BREAK
                CASE 2 // Toggle framerate counter
                    IF fps_counter_active = 0
                        fps_counter_active = 1
                        START_NEW_SCRIPT fps_counter
                    ELSE
                        fps_counter_active = 0
                        TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME SHOWFPS
                    ENDIF

                    BREAK
                CASE 3 // Set draw distance
                    WRITE_MEMORY 0x66659C 4 fDrawDistance TRUE 
                    BREAK
                CASE 4 // Set LOD draw distance
                    WRITE_MEMORY 0x70685C 4 fLODDistance TRUE // 0x6665A0
                    BREAK
                CASE 5 // Toggle stream usage counter
                    IF stream_counter_active = 0
                        stream_counter_active = 1
                        START_NEW_SCRIPT streaming_usage
                    ELSE
                        stream_counter_active = 0
                        TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME STRUSE
                    ENDIF
                    BREAK
                CASE 6 // Set stream memory
                    WRITE_MEMORY 0x666E08 4 iTotalStreamMemory TRUE 
                    BREAK
                CASE 7 // Set desired vehicles
                    WRITE_MEMORY 0x666E0C 4 iDesiredVehicles TRUE 
                    BREAK
            ENDSWITCH
        ENDIF

        IF IS_BUTTON_PRESSED PAD1 TRIANGLE
            WRITE_MEMORY (pAllowRadioWheelDrawing, 1, 1 TRUE)
            is_drawing = 0

            DELETE_MENU hAdvancedSettingsMenu

            WAIT 150
            SET_PLAYER_CONTROL 0 1
            TERMINATE_THIS_SCRIPT
        ENDIF

        
    GOTO advanced_settings_loop
}

{
    debug_menu:
    SCRIPT_NAME DEBUG_M
    NOP
    LVAR_INT selected b_active vehicle max_item veh_model old_selected r g b color_flag_thing
    LVAR_FLOAT items_size items_pos sc_float sc_pos item_qt px py pz pa

    LVAR_INT filter_col[4] col_idx old_col_idx

    VAR_INT hCurrMenu

    LVAR_INT logging_coordinates

    CONST_INT MAX_ITEMS 3
    CONST_FLOAT ITEM_QUANTITY 4.0

    CONST_INT MAX_STYLE 2
    CONST_FLOAT STYLE_QUANTITY 3.0

    CONST_FLOAT RECT_X 112.0
    CONST_FLOAT RECT_W 170.0

    selected = 0
    color_flag_thing = 1
    r = 120
    g = 60
    b = 220

    menu_init:
    WAIT 0
    IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
    AND IS_BUTTON_PRESSED PAD1 DPADLEFT
    AND NOT READ_MEMORY_BOOL (pRadioWheelVisible, 1)
    AND is_drawing = 0
        is_drawing = 1
        WRITE_MEMORY (pAllowRadioWheelDrawing, 1, 0 TRUE)
        SET_PLAYER_CONTROL 0 0
        CREATE_MENU RMMENU 50f 50f 300f 1 TRUE TRUE 0 (hCurrMenu)
        SET_MENU_COLUMN hCurrMenu 0 RMOPTS RMITEM1 RMITEM2 RMITEM3 RMITEM4 VLSETS DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY
        SET_MENU_COLUMN_ORIENTATION hCurrMenu 0 1
        GOTO main_menu_loop
    ENDIF
    GOTO menu_init

    main_menu_loop:
    WAIT 0
    GET_MENU_ITEM_SELECTED hCurrMenu (selected)
    IF IS_BUTTON_PRESSED PAD1 CROSS
        SWITCH selected
            CASE 0
                SET_MENU_COLUMN hCurrMenu 0 RMOPTS STSKIN STCLOTH STRESET DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY
                SET_MENU_COLUMN_ORIENTATION hCurrMenu 0 1
                GOTO style_loop
                BREAK
            CASE 1
                selected = 0
                old_selected = -1
                SET_MENU_COLUMN hCurrMenu 0 RMOPTS MANANA WASHING BANSHEE BUFFALO LANDSTK FELTZER ELEGANT BANDITO RANCHER RANCHER DUMMY DUMMY
                SET_MENU_COLUMN_ORIENTATION hCurrMenu 0 1
                GOTO cars_loop
                BREAK
            CASE 2
                SET_PLAYER_CONTROL 0 1
                is_drawing = 0
                IF IS_CHAR_IN_ANY_CAR hPlayerPed
                AND NOT IS_CHAR_IN_ANY_BOAT hPlayerPed
                AND NOT IS_CHAR_IN_FLYING_VEHICLE hPlayerPed
                    lscustoms_enabled = TRUE
                    DELETE_MENU hCurrMenu
                ENDIF
                GOTO menu_init
                BREAK
            CASE 3
                IF logging_coordinates = FALSE
                    PRINT_HELP CORDLOG
                    logging_coordinates = TRUE
                    START_NEW_SCRIPT coordinate_logger
                ELSE
                    logging_coordinates = FALSE
                    TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME PCORLOG
                ENDIF

                WRITE_MEMORY (pAllowRadioWheelDrawing, 1, 1 TRUE)
                SET_PLAYER_CONTROL 0 1
                is_drawing = 0
                DELETE_MENU hCurrMenu
                GOTO menu_init
                BREAK
            CASE 4
                START_NEW_SCRIPT advanced_settings

                DELETE_MENU hCurrMenu
                GOTO menu_init
                BREAK
        ENDSWITCH
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 TRIANGLE
        WRITE_MEMORY (pAllowRadioWheelDrawing, 1, 1 TRUE)
        SET_PLAYER_CONTROL 0 1
        is_drawing = 0
        DELETE_MENU hCurrMenu
        GOTO menu_init
    ENDIF
    GOTO main_menu_loop

    style_loop:
    WAIT 0
    GET_MENU_ITEM_SELECTED hCurrMenu (selected)

    IF IS_BUTTON_PRESSED PAD1 CROSS
        SWITCH selected
            CASE 0
                BREAK
            CASE 1
                BREAK
            CASE 2
                BREAK
        ENDSWITCH
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 TRIANGLE
        GOTO main_menu_loop
    ENDIF
    GOTO style_loop

    cars_loop:
    WAIT 0
    GET_MENU_ITEM_SELECTED hCurrMenu (selected)

    GET_CHAR_COORDINATES hPlayerPed px py pz
    GET_CHAR_HEADING hPlayerPed pa
    pa += 90.0
    GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hPlayerPed 0.0 5.0 0.0 px py pz

    IF NOT old_selected = selected
        SWITCH selected
            CASE 0
                veh_model = MANANA
                BREAK
            CASE 1
                veh_model = WASHING
                BREAK
            CASE 2
                veh_model = BANSHEE
                BREAK
            CASE 3
                veh_model = BUFFALO
                BREAK
            CASE 4
                veh_model = LANDSTAL
                BREAK
            CASE 5
                veh_model = FELTZER
                BREAK
            CASE 6
                veh_model = ELEGANT
                BREAK
            CASE 7
                veh_model = BANDITO
                BREAK
            CASE 8
                veh_model = RANCHER
                BREAK
            CASE 9
                veh_model = RNCHLURE
                BREAK
        ENDSWITCH
        REQUEST_MODEL veh_model
        WHILE NOT HAS_MODEL_LOADED veh_model
            WAIT 0
        ENDWHILE
        CREATE_CAR veh_model px py pz vehicle
        SET_CAR_HEADING vehicle pa
        MARK_MODEL_AS_NO_LONGER_NEEDED veh_model
        MARK_CAR_AS_NO_LONGER_NEEDED vehicle
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 SQUARE
        WRITE_MEMORY (pAllowRadioWheelDrawing, 1, 1 TRUE)
        WARP_CHAR_INTO_CAR hPlayerPed vehicle
        SET_PLAYER_CONTROL 0 1
        is_drawing = 0
        DELETE_MENU hCurrMenu
        GOTO menu_init
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 TRIANGLE
            selected = 0
            old_selected = -1
        GOTO main_menu_loop
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER2
            selected = 0
            old_selected = -1
        SET_MENU_COLUMN hCurrMenu 0 RMOPTS SABRE BLISTAC VIRGO STALLIO GLENSHI INFERNU HOTRING COMET SUPERGT SADLER DUMMY DUMMY
        SET_MENU_COLUMN_ORIENTATION hCurrMenu 0 1
        GOTO cars2_loop
    ENDIF
    old_selected = selected
    GOTO cars_loop

    cars2_loop:
    WAIT 0
    GET_MENU_ITEM_SELECTED hCurrMenu (selected)

    IF NOT old_selected = selected
        SWITCH selected
            CASE 0
                veh_model = SABRE
                BREAK
            CASE 1
                veh_model = BLISTAC
                BREAK
            CASE 2
                veh_model = VIRGO
                BREAK
            CASE 3
                veh_model = STALLION
                BREAK
            CASE 4
                veh_model = GLENSHIT
                BREAK
            CASE 5
                veh_model = INFERNUS
                BREAK
            CASE 6
                veh_model = HOTRING
                BREAK
            CASE 7
                veh_model = COMET
                BREAK
            CASE 8
                veh_model = SUPERGT
                BREAK
            CASE 9
                veh_model = SADLER
                BREAK
        ENDSWITCH
        REQUEST_MODEL veh_model
        WHILE NOT HAS_MODEL_LOADED veh_model
            WAIT 0
        ENDWHILE
        CREATE_CAR veh_model px py pz vehicle
        SET_CAR_HEADING vehicle pa
        MARK_MODEL_AS_NO_LONGER_NEEDED veh_model
        MARK_CAR_AS_NO_LONGER_NEEDED vehicle
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 SQUARE
        WRITE_MEMORY (pAllowRadioWheelDrawing, 1, 1 TRUE)
        WARP_CHAR_INTO_CAR hPlayerPed vehicle
        SET_PLAYER_CONTROL 0 1
        is_drawing = 0
        DELETE_MENU hCurrMenu
        GOTO menu_init
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 TRIANGLE
        selected = 0
        old_selected = -1
        GOTO main_menu_loop
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 LEFTSHOULDER2
        selected = 0
        old_selected = -1
        SET_MENU_COLUMN hCurrMenu 0 RMOPTS MANANA WASHING BANSHEE BUFFALO LANDSTK FELTZER TOPFUN BANDITO RANCHER RANCHER DUMMY DUMMY
        SET_MENU_COLUMN_ORIENTATION hCurrMenu 0 1
        GOTO cars_loop
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER2
        selected = 0
        old_selected = -1
        SET_MENU_COLUMN hCurrMenu 0 RMOPTS ALPHA BFINJEC BF400 EMPEROR FORKLIF HOTRINB HUNTLEY JESTER JOURNEY NRG500 DUMMY DUMMY
        SET_MENU_COLUMN_ORIENTATION hCurrMenu 0 1
        GOTO cars3_loop
    ENDIF
    old_selected = selected
    GOTO cars2_loop

    cars3_loop:
    WAIT 0
    GET_MENU_ITEM_SELECTED hCurrMenu (selected)

    IF NOT old_selected = selected
        SWITCH selected
            CASE 0
                veh_model = ALPHA
                BREAK
            CASE 1
                veh_model = BFINJECT
                BREAK
            CASE 2
                veh_model = BF400
                BREAK
            CASE 3
                veh_model = EMPEROR
                BREAK
            CASE 4
                veh_model = FORKLIFT
                BREAK
            CASE 5
                veh_model = HOTRINB
                BREAK
            CASE 6
                veh_model = HUNTLEY
                BREAK
            CASE 7
                veh_model = JESTER
                BREAK
            CASE 8
                veh_model = JOURNEY
                BREAK
            CASE 9
                veh_model = NRG500
                BREAK
        ENDSWITCH
        REQUEST_MODEL veh_model
        WHILE NOT HAS_MODEL_LOADED veh_model
            WAIT 0
        ENDWHILE
        CREATE_CAR veh_model px py pz vehicle
        SET_CAR_HEADING vehicle pa
        MARK_MODEL_AS_NO_LONGER_NEEDED veh_model
        MARK_CAR_AS_NO_LONGER_NEEDED vehicle
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 SQUARE
        WRITE_MEMORY (pAllowRadioWheelDrawing, 1, 1 TRUE)
        WARP_CHAR_INTO_CAR hPlayerPed vehicle
        SET_PLAYER_CONTROL 0 1
        is_drawing = 0
        DELETE_MENU hCurrMenu
        GOTO menu_init
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 TRIANGLE
        selected = 0
        old_selected = -1
        GOTO main_menu_loop
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 LEFTSHOULDER2
        selected = 0
        old_selected = -1
        SET_MENU_COLUMN hCurrMenu 0 RMOPTS SABRE BLISTAC VIRGO STALLIO GLENSHI INFERNU HOTRING COMET SUPERGT SADLER DUMMY DUMMY
        SET_MENU_COLUMN_ORIENTATION hCurrMenu 0 1
        GOTO cars2_loop
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER2
        selected = 0
        old_selected = -1
        SET_MENU_COLUMN hCurrMenu 0 RMOPTS MAVERIC PATRIOT RAINDAN RHINO SECURIC SWATVAN TAXI COPCARL TRACTOR YOSEMIT DUMMY DUMMY
        SET_MENU_COLUMN_ORIENTATION hCurrMenu 0 1
        GOTO cars4_loop
    ENDIF
    old_selected = selected
    GOTO cars3_loop

    cars4_loop:
    WAIT 0
    GET_MENU_ITEM_SELECTED hCurrMenu (selected)

    IF NOT old_selected = selected
        SWITCH selected
            CASE 0
                veh_model = MAVERICK
                BREAK
            CASE 1
                veh_model = PATRIOT
                BREAK
            CASE 2
                veh_model = RAINDANC
                BREAK
            CASE 3
                veh_model = RHINO
                BREAK
            CASE 4
                veh_model = SECURICA
                BREAK
            CASE 5
                veh_model = SWATVAN
                BREAK
            CASE 6
                veh_model = TAXI
                BREAK
            CASE 7
                veh_model = COPCARLA
                BREAK
            CASE 8
                veh_model = TRACTOR
                BREAK
            CASE 9
                veh_model = YOSEMITE
                BREAK
        ENDSWITCH
        REQUEST_MODEL veh_model
        WHILE NOT HAS_MODEL_LOADED veh_model
            WAIT 0
        ENDWHILE
        CREATE_CAR veh_model px py pz vehicle
        SET_CAR_HEADING vehicle pa
        MARK_MODEL_AS_NO_LONGER_NEEDED veh_model
        MARK_CAR_AS_NO_LONGER_NEEDED vehicle
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 SQUARE
        WRITE_MEMORY (pAllowRadioWheelDrawing, 1, 1 TRUE)
        WARP_CHAR_INTO_CAR hPlayerPed vehicle
        SET_PLAYER_CONTROL 0 1
        is_drawing = 0
        DELETE_MENU hCurrMenu
        GOTO menu_init
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 TRIANGLE
        selected = 0
        old_selected = -1
        GOTO main_menu_loop
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 LEFTSHOULDER2
        selected = 0
        old_selected = -1
        SET_MENU_COLUMN hCurrMenu 0 RMOPTS ALPHA BFINJEC BF400 EMPEROR FORKLIF HOTRINB HUNTLEY JESTER JOURNEY NRG500 DUMMY DUMMY
        SET_MENU_COLUMN_ORIENTATION hCurrMenu 0 1
        GOTO cars3_loop
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER2
        selected = 0
        old_selected = -1
        SET_MENU_COLUMN hCurrMenu 0 RMOPTS WALTON HOTRINA MAJESTI SANDKIN CHEETAH ZR350 ELEGY BRAVURA SWEEPER URANUS DUMMY DUMMY
        SET_MENU_COLUMN_ORIENTATION hCurrMenu 0 1
        GOTO cars5_loop
    ENDIF
    old_selected = selected
    GOTO cars4_loop

    cars5_loop:
    WAIT 0
    GET_MENU_ITEM_SELECTED hCurrMenu (selected)
    
    IF NOT old_selected = selected
        SWITCH selected
            CASE 0
                veh_model = WALTON
                BREAK
            CASE 1
                veh_model = HOTRINA
                BREAK
            CASE 2
                veh_model = MAJESTIC
                BREAK
            CASE 3
                veh_model = SANDKING
                BREAK
            CASE 4
                veh_model = CHEETAH
                BREAK
            CASE 5
                veh_model = ZR350
                BREAK
            CASE 6
                veh_model = ELEGY
                BREAK
            CASE 7
                veh_model = BRAVURA
                BREAK
            CASE 8
                veh_model = SWEEPER
                BREAK
            CASE 9
                veh_model = URANUS
                BREAK
        ENDSWITCH
        REQUEST_MODEL veh_model
        WHILE NOT HAS_MODEL_LOADED veh_model
            WAIT 0
        ENDWHILE
        CREATE_CAR veh_model px py pz vehicle
        SET_CAR_HEADING vehicle pa
        MARK_MODEL_AS_NO_LONGER_NEEDED veh_model
        MARK_CAR_AS_NO_LONGER_NEEDED vehicle
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 SQUARE
        WRITE_MEMORY (pAllowRadioWheelDrawing, 1, 1 TRUE)
        WARP_CHAR_INTO_CAR hPlayerPed vehicle
        SET_PLAYER_CONTROL 0 1
        is_drawing = 0
        DELETE_MENU hCurrMenu
        GOTO menu_init
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 TRIANGLE
        selected = 0
        old_selected = -1
        GOTO main_menu_loop
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 LEFTSHOULDER2
        selected = 0
        old_selected = -1
        SET_MENU_COLUMN hCurrMenu 0 RMOPTS MAVERIC PATRIOT RAINDAN RHINO SECURIC SWATVAN TAXI COPCARL TRACTOR YOSEMIT DUMMY DUMMY
        SET_MENU_COLUMN_ORIENTATION hCurrMenu 0 1
        GOTO cars4_loop
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER2
        selected = 0
        old_selected = -1
        SET_MENU_COLUMN hCurrMenu 0 RMOPTS TOWTRUC PREVION FCR900 FORTUNE SULTAN NEBULA SUNRISE CADRONA SWEEPER URANUS DUMMY DUMMY
        SET_MENU_COLUMN_ORIENTATION hCurrMenu 0 1
        GOTO cars6_loop
    ENDIF
    old_selected = selected
    GOTO cars5_loop

    cars6_loop:
    WAIT 0
    GET_MENU_ITEM_SELECTED hCurrMenu (selected)
    
    IF NOT old_selected = selected
        SWITCH selected
            CASE 0
                veh_model = TOWTRUCK
                BREAK
            CASE 1
                veh_model = PREVION
                BREAK
            CASE 2
                veh_model = FCR900
                BREAK
            CASE 3
                veh_model = FORTUNE
                BREAK
            CASE 4
                veh_model = SULTAN
                BREAK
            CASE 5
                veh_model = NEBULA
                BREAK
            CASE 6
                veh_model = SUNRISE
                BREAK
            CASE 7
                veh_model = CADRONA
                BREAK
            CASE 8
                veh_model = SWEEPER
                BREAK
            CASE 9
                veh_model = URANUS
                BREAK
        ENDSWITCH
        REQUEST_MODEL veh_model
        WHILE NOT HAS_MODEL_LOADED veh_model
            WAIT 0
        ENDWHILE
        CREATE_CAR veh_model px py pz vehicle
        SET_CAR_HEADING vehicle pa
        MARK_MODEL_AS_NO_LONGER_NEEDED veh_model
        MARK_CAR_AS_NO_LONGER_NEEDED vehicle
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 SQUARE
        WRITE_MEMORY (pAllowRadioWheelDrawing, 1, 1 TRUE)
        WARP_CHAR_INTO_CAR hPlayerPed vehicle
        SET_PLAYER_CONTROL 0 1
        is_drawing = 0
        DELETE_MENU hCurrMenu
        GOTO menu_init
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 TRIANGLE
        selected = 0
        old_selected = -1
        GOTO main_menu_loop
    ENDIF
    IF IS_BUTTON_PRESSED PAD1 LEFTSHOULDER2
        selected = 0
        old_selected = -1
        SET_MENU_COLUMN hCurrMenu 0 RMOPTS WALTON HOTRINA MAJESTI SANDKIN CHEETAH ZR350 ELEGY BRAVURA SWEEPER URANUS DUMMY DUMMY
        SET_MENU_COLUMN_ORIENTATION hCurrMenu 0 1
        GOTO cars5_loop
    ENDIF
    old_selected = selected
    GOTO cars6_loop
}

{
    char_switcher:
    SCRIPT_NAME VSWITCH

    CONST_INT CHANGE_MOVE_AFTER 5000
    CONST_FLOAT WHEEL_SENSITIVITY 0.7

    CONST_FLOAT MIN_DISTANCE_FROM_OTHER_CHAR 500.0
    CONST_INT TRIES_LIMIT_TO_SET_NEW_FAKE_MOVE 20
    CONST_INT SWITCH_RANDOM_TOGGLE_IN_CAR 5000 // less = changes with more frequency

    CONST_FLOAT NEW_MOVE_DISTANCE_NEG -500.0      
    CONST_FLOAT NEW_MOVE_DISTANCE_POS 500.0

    CONST_FLOAT SWITCH_WHEEL_SIZEX 85.0
    CONST_FLOAT SWITCH_WHEEL_SIZEY 107.6 
    CONST_FLOAT SWITCH_WHEEL_POSX 575.0 
    CONST_FLOAT SWITCH_WHEEL_POSY 380.5
    
    LVAR_FLOAT backupSensValue
    LVAR_FLOAT fAngle
    LVAR_INT iSprite

    LVAR_INT iStickX
    LVAR_INT iStickY 

    LVAR_FLOAT fStickX
    LVAR_FLOAT fStickY  

    LVAR_FLOAT fStoredStickX
    LVAR_FLOAT fStoredStickY

    LVAR_INT iCurSide

    LVAR_INT bDoFade

    LVAR_INT bFadeAltered

    LVAR_INT i
    LVAR_INT j
    LVAR_INT k

    LVAR_INT tmp_player

    LVAR_INT iTmp[3]
    LVAR_FLOAT fTmp[4] fTempDistance[4] playerCoords[3]

    switch_cur_char = PLAYER_FRANKLIN
    switch_new_char = PLAYER_FRANKLIN

    switch_money[0] = 0   
    switch_money[1] = 0 
    switch_money[2] = 0   

    switch_wanted[0] = 0   
    switch_wanted[1] = 0 
    switch_wanted[2] = 0   

    switch_x[1] = 2000.00
    switch_y[1] = -1500.0
    switch_z[1] = 13.0  

    switch_new_x[1] = 0.0
    switch_new_y[1] = 0.0
    switch_new_z[1] = 0.0

    switch_x[0] = 2500.08
    switch_y[0] = -1679.118
    switch_z[0] = 13.3632  

    switch_new_x[0] = 0.0
    switch_new_y[0] = 0.0
    switch_new_z[0] = 0.0

    switch_x[2] = -800.0
    switch_y[2] = 1500.0
    switch_z[2] = 13.0 

    switch_new_x[2] = 0.0
    switch_new_y[2] = 0.0
    switch_new_z[2] = 0.0

    switch_last_used_car[0] = -1 
    switch_last_used_car[1] = -1
    switch_last_used_car[2] = -1 

    switch_in_car[0] = 0
    switch_in_car[1] = 0
    switch_in_car[2] = 1


    TIMERA = CHANGE_MOVE_AFTER

    // Initilize iPlayer once (optional)
    GOSUB Switch_SetPlayer


    /////////////////////////////////////////////////
    
    
    WHILE NOT IS_GERMAN_GAME
        WAIT 0  

        IF IS_PLAYER_CONTROL_ON iPlayer // more?

            IF IS_BUTTON_PRESSED PAD1 DPADDOWN
                TIMERA = 0
                WHILE IS_BUTTON_PRESSED PAD1 DPADDOWN
                    WAIT 0
                    IF TIMERA > 500
                        BREAK
                    ENDIF
                ENDWHILE
            ENDIF
            
            IF IS_BUTTON_PRESSED PAD1 DPADDOWN
            AND NOT READ_MEMORY_BOOL (pRadioWheelVisible, 1)
            AND is_drawing = 0
                is_drawing = 1
                WRITE_MEMORY (pAllowRadioWheelDrawing, 1, 0 TRUE)
                SHAKE_PAD PAD1 100 999999
                LOAD_TEXTURE_DICTIONARY VHUD
                SET_TIME_SCALE 0.2

                IF GET_DYNAMIC_LIBRARY_PROCEDURE ("enable_blur", 0) (pLibraryObjectAddress)
                    WRITE_MEMORY (pLibraryObjectAddress, 4, 1, TRUE)
                ENDIF

                // do postfx IF valid
                SET_DARKNESS_EFFECT 1 50
                IF NOT GET_FADING_STATUS
                    GOSUB Switch_SetFadeColorByCur
                    DO_FADE 700 0
                    TIMERA = 0
                    bDoFade = 1
                    bFadeAltered = 1
                ELSE   
                    bDoFade = 0
                    bFadeAltered = 0
                ENDIF

                // pad  
                READ_MEMORY 0x665204 4 0 (backupSensValue)
                WRITE_MEMORY 0x665204 4 0.0 0

                // selection loop
                fStoredStickX = 0.0
                fStoredStickY = 0.0    

                WHILE IS_BUTTON_PRESSED PAD1 DPADDOWN
                    WAIT 0

                    IF NOT IS_PLAYER_PLAYING iPlayer
                    OR IS_CHAR_DEAD hPlayerPed
                    OR HAS_CHAR_BEEN_ARRESTED hPlayerPed
                        iCurSide = -1
                        BREAK
                    ENDIF    

                    USE_TEXT_COMMANDS 1

                    IF bDoFade = 1
                        IF TIMERA > 50
                            DO_FADE 9999999 0
                            bDoFade = 0
                        ENDIF
                    ENDIF

                    GOSUB GetSelectedSide_2     

                    LOAD_SPRITE 100 "none"
                    LOAD_SPRITE 101 "franklin" // const PLAYER_* + 101
                    LOAD_SPRITE 102 "michael"
                    LOAD_SPRITE 103 "trevor"

                    iSprite = iCurSide
                    iSprite += 101
                    DRAW_SPRITE iSprite SWITCH_WHEEL_POSX SWITCH_WHEEL_POSY SWITCH_WHEEL_SIZEX SWITCH_WHEEL_SIZEY 255 255 255 255

                    USE_TEXT_COMMANDS 0 
                ENDWHILE

                // reset fade
                IF bFadeAltered = 1
                    SET_FADING_COLOUR 0 0 0
                    DO_FADE 0 1  
                ENDIF  
                
                SET_DARKNESS_EFFECT 0 0

                // set selected new char
                IF iCurSide > -1
                AND NOT iCurSide = switch_cur_char
                AND NOT IS_WANTED_LEVEL_GREATER iPlayer 0
                    switch_new_char = iCurSide
                    DISPLAY_HUD 0
                    DISPLAY_RADAR 0
                    GOSUB Switch_Run
                ENDIF

                // pad          
                WRITE_MEMORY 0x665204 4 backupSensValue 0
                IF GET_DYNAMIC_LIBRARY_PROCEDURE ("enable_blur", 0) (pLibraryObjectAddress)
                    WRITE_MEMORY (pLibraryObjectAddress, 4, 0, TRUE)
                ENDIF

                SET_TIME_SCALE 1.0
                WAIT 100  
                REMOVE_TEXTURE_DICTIONARY 
                is_drawing = 0
                WRITE_MEMORY (pAllowRadioWheelDrawing, 1, 1 TRUE)
            ENDIF
        ENDIF

        GOSUB Switch_ProcessFakeMove
    ENDWHILE
    
    /////////////////////////////////////////////////

    GetSelectedSide_2:
    GET_POSITION_OF_ANALOGUE_STICKS PAD1 j j iStickX iStickY

    fStickX =# iStickX 
    fStickY =# iStickY

    IF NOT fStickX = 0.0  
    OR NOT fStickY = 0.0
        fStoredStickX = fStickX 
        fStoredStickY = fStickY
    ELSE
        fStickY *= -1.0

        fStickX *= WHEEL_SENSITIVITY     
        fStickY *= WHEEL_SENSITIVITY

        fStoredStickX +=@ fStickX   
        fStoredStickY +=@ fStickY

        IF fStoredStickX > 10.0
            fStoredStickX = 10.0
        ENDIF  
        IF fStoredStickX < -10.0
            fStoredStickX = -10.0
        ENDIF   
        IF fStoredStickY > 10.0
            fStoredStickY = 10.0
        ENDIF  
        IF fStoredStickY < -10.0
            fStoredStickY = -10.0
        ENDIF
    ENDIF

    iCurSide = -1

    IF fStoredStickX > 5.0
        iCurSide = PLAYER_TREVOR
    ENDIF 

    IF fStoredStickX < -5.0
        iCurSide = PLAYER_MICHAEL
    ENDIF

    IF fStoredStickY < -5.0
        iCurSide = PLAYER_FRANKLIN
    ENDIF

    //x = fStoredStickX  
    //y = fStoredStickY
    //x += 320.0               
    //y += 224.0                                                  
    //draw_box_position 320.0 224.0 20.0 20.0 RGBA 0 0 0 255
    //draw_box_position x y 5.0 5.0 RGBA 255 255 0 255
    RETURN



    Switch_ProcessFakeMove:
    IF TIMERA > CHANGE_MOVE_AFTER
        // 0164: disable_marker z0
        // 0164: disable_marker y9
        // 0164: disable_marker y8
        IF NOT switch_cur_char = PLAYER_MICHAEL
            tmp_player = PLAYER_MICHAEL
            GOSUB Switch_ProcessFakeMove_UpdateThisPlayer
        ENDIF     
        IF NOT switch_cur_char = PLAYER_FRANKLIN
            tmp_player = PLAYER_FRANKLIN
            GOSUB Switch_ProcessFakeMove_UpdateThisPlayer
        ENDIF      
        IF NOT switch_cur_char = PLAYER_TREVOR
            tmp_player = PLAYER_TREVOR
            GOSUB Switch_ProcessFakeMove_UpdateThisPlayer
        ENDIF
        TIMERA = 0
    ELSE     
        // 0164: disable_marker z0
        // 0164: disable_marker y9
        // 0164: disable_marker y8 
        IF NOT switch_cur_char = PLAYER_FRANKLIN
            tmp_player = PLAYER_FRANKLIN
            GOSUB Switch_ProcessFakeMove_ProcessThisPlayer   
          //  0165: set_marker y8 color_to 3
        ELSE
            GET_CHAR_COORDINATES hPlayerPed switch_x[0] switch_y[0] switch_z[0]
        ENDIF
        IF NOT switch_cur_char = PLAYER_MICHAEL
            tmp_player = PLAYER_MICHAEL
            GOSUB Switch_ProcessFakeMove_ProcessThisPlayer   
          //  0165: set_marker y8 color_to 1
        ELSE
            GET_CHAR_COORDINATES hPlayerPed switch_x[1] switch_y[1] switch_z[1]
        ENDIF
        IF NOT switch_cur_char = PLAYER_TREVOR
            tmp_player = PLAYER_TREVOR
            GOSUB Switch_ProcessFakeMove_ProcessThisPlayer    
        //    0165: set_marker y8 color_to 5
        ELSE
            GET_CHAR_COORDINATES hPlayerPed switch_x[2] switch_y[2] switch_z[2]
        ENDIF
    ENDIF
    RETURN

    Switch_ProcessFakeMove_UpdateThisPlayer:
    i = 0
    WHILE i < TRIES_LIMIT_TO_SET_NEW_FAKE_MOVE
        GENERATE_RANDOM_FLOAT_IN_RANGE NEW_MOVE_DISTANCE_NEG NEW_MOVE_DISTANCE_POS (fTmp[0])
        fTmp[1] = switch_x[tmp_player]
        GOSUB Switch_ProcessFakeMove_NormalizeNewX
        GENERATE_RANDOM_FLOAT_IN_RANGE NEW_MOVE_DISTANCE_NEG NEW_MOVE_DISTANCE_POS (fTmp[0])
        fTmp[2] = switch_y[tmp_player]
        GOSUB Switch_ProcessFakeMove_NormalizeNewY
        IF tmp_player = PLAYER_FRANKLIN
            GET_DISTANCE_BETWEEN_COORDS_2D fTmp[1] fTmp[2] switch_x[1] switch_y[1] (fTempDistance[0])
            GET_DISTANCE_BETWEEN_COORDS_2D fTmp[1] fTmp[2] switch_x[2] switch_y[2] (fTempDistance[1])
            GET_DISTANCE_BETWEEN_COORDS_2D fTmp[1] fTmp[2] switch_new_x[1] switch_new_y[1] (fTempDistance[2])
            GET_DISTANCE_BETWEEN_COORDS_2D fTmp[1] fTmp[2] switch_new_x[2] switch_new_y[2] (fTempDistance[3])
        ENDIF         
        IF tmp_player = PLAYER_MICHAEL
            GET_DISTANCE_BETWEEN_COORDS_2D fTmp[1] fTmp[2] switch_x[2] switch_y[2] (fTempDistance[0])
            GET_DISTANCE_BETWEEN_COORDS_2D fTmp[1] fTmp[2] switch_x[0] switch_y[0] (fTempDistance[1])
            GET_DISTANCE_BETWEEN_COORDS_2D fTmp[1] fTmp[2] switch_new_x[2] switch_new_y[2] (fTempDistance[2])
            GET_DISTANCE_BETWEEN_COORDS_2D fTmp[1] fTmp[2] switch_new_x[0] switch_new_y[0] (fTempDistance[3])
        ENDIF
        IF tmp_player = PLAYER_TREVOR
            GET_DISTANCE_BETWEEN_COORDS_2D fTmp[1] fTmp[2] switch_x[1] switch_y[1] (fTempDistance[0])
            GET_DISTANCE_BETWEEN_COORDS_2D fTmp[1] fTmp[2] switch_x[0] switch_y[0] (fTempDistance[1])
            GET_DISTANCE_BETWEEN_COORDS_2D fTmp[1] fTmp[2] switch_new_x[1] switch_new_y[1] (fTempDistance[2])
            GET_DISTANCE_BETWEEN_COORDS_2D fTmp[1] fTmp[2] switch_new_x[0] switch_new_y[0] (fTempDistance[3])
        ENDIF
        IF  fTempDistance[0] > MIN_DISTANCE_FROM_OTHER_CHAR 
        AND fTempDistance[1] > MIN_DISTANCE_FROM_OTHER_CHAR
        AND fTempDistance[2] > MIN_DISTANCE_FROM_OTHER_CHAR 
        AND fTempDistance[3] > MIN_DISTANCE_FROM_OTHER_CHAR
            BREAK //ok
        ENDIF   
        i++
    ENDWHILE
    
    switch_new_x[tmp_player] = fTmp[1] 
    switch_new_y[tmp_player] = fTmp[2]  

    GENERATE_RANDOM_INT_IN_RANGE 0 SWITCH_RANDOM_TOGGLE_IN_CAR (iTmp[0])

    IF iTmp[0] = 0
        switch_last_used_car[tmp_player] = -1
        IF switch_in_car[tmp_player] = 1
            switch_in_car[tmp_player] = 0
        ELSE 
            switch_in_car[tmp_player] = 1
        ENDIF
    ENDIF
    RETURN

    Switch_ProcessFakeMove_ProcessThisPlayer:
    // tmp_player = switch iPlayer id
    iTmp[0] = switch_in_car[tmp_player]

    fTmp[1] = switch_x[tmp_player]
    fTmp[1] -= switch_new_x[tmp_player]
    GOSUB Switch_ProcessFakeMove_NormalizeSpeedX  
    switch_x[tmp_player] -=@ fTmp[1]

    fTmp[2] = switch_x[tmp_player]
    fTmp[2] -= switch_new_x[tmp_player] 
    GOSUB Switch_ProcessFakeMove_NormalizeSpeedY
    switch_y[tmp_player] -=@ fTmp[2]

    // 0AD1: show_formatted_text_highpriority "%.3f %.3f" time 2000 fTmp[1] fTmp[2]
    // 02A8: y8 = create_marker 0  switch_x[tmp_player] switch_y[tmp_player] 0.0
    RETURN 

    Switch_ProcessFakeMove_NormalizeSpeedX:
    IF iTmp[0] = 1 // this char is in car
    
        fTmp[1] /= 1000.0
    ELSE
        fTmp[1] /= 4000.0
    ENDIF
    IF fTmp[1] > 0.0

        IF iTmp[0] = 1

            IF fTmp[1] > 1.0
                fTmp[1] = 1.0
            ENDIF
        ELSE  
            IF fTmp[1] > 0.2
                fTmp[1] = 0.2
            ENDIF
        ENDIF
    ELSE
        IF iTmp[0] = 1

            IF fTmp[1] < -1.0
                fTmp[1] = -1.0
            ENDIF
        ELSE  
            IF fTmp[1] < -0.2
                fTmp[1] = -0.2
            ENDIF
        ENDIF
    ENDIF  
    RETURN

    Switch_ProcessFakeMove_NormalizeSpeedY:
    IF iTmp[0] = 1 // this char is in car
    
        fTmp[2] /= 1000.0
    ELSE
        fTmp[2] /= 4000.0
    ENDIF
    IF fTmp[2] > 0.0

        IF iTmp[0] = 1

            IF fTmp[2] > 1.0
                fTmp[2] = 1.0
            ENDIF
        ELSE  
            IF fTmp[2] > 0.2
                fTmp[2] = 0.2
            ENDIF
        ENDIF
    ELSE
        IF iTmp[0] = 1

            IF fTmp[2] < -1.0
                fTmp[2] = -1.0
            ENDIF
        ELSE  
            IF fTmp[2] < -0.2
                fTmp[2] = -0.2
            ENDIF
        ENDIF
    ENDIF  
    RETURN

    Switch_ProcessFakeMove_NormalizeNewX:
    fTmp[1] += fTmp[0]
    IF fTmp[1] < -2700.0 
    OR fTmp[1] > 2700.0 
        IF fTmp[1] > 0.0
            fTmp[1] -= NEW_MOVE_DISTANCE_POS
        ELSE 
            fTmp[1] += NEW_MOVE_DISTANCE_POS
        ENDIF
    ENDIF
    RETURN

    Switch_ProcessFakeMove_NormalizeNewY:
    fTmp[2] += fTmp[0]
    IF fTmp[2] < -2700.0 
    OR fTmp[2] > 2700.0 
        IF fTmp[2] > 0.0
            fTmp[2] -= NEW_MOVE_DISTANCE_POS
        ELSE 
            fTmp[2] += NEW_MOVE_DISTANCE_POS
        ENDIF
    ENDIF
    RETURN

    /////////////////////////////////////////////////


    Switch_Run:
    SET_TIME_SCALE 1.0 // the camera movement is too slow IF we decrease it

    SET_PLAYER_CONTROL iPlayer 0
    GET_CHAR_COORDINATES hPlayerPed playerCoords[0] playerCoords[1] playerCoords[2]

    switch_ability[switch_cur_char] = fAbilityPercent

    GOSUB Switch_ProcessFadeDelayStart

    GOSUB Switch_ProcessFadeDelay

    SET_FIXED_CAMERA_POSITION playerCoords[0] playerCoords[1] 160.0 0.0 0.0 0.0 
    POINT_CAMERA_AT_POINT playerCoords[0] playerCoords[1] playerCoords[2] 1 

    GOSUB Switch_ProcessFadeDelay

    SET_FIXED_CAMERA_POSITION playerCoords[0] playerCoords[1] 200.0 0.0 0.0 0.0 
    POINT_CAMERA_AT_POINT playerCoords[0] playerCoords[1] playerCoords[2] 1 

    GOSUB Switch_ProcessFadeDelay

    SET_FIXED_CAMERA_POSITION playerCoords[0] playerCoords[1] 300.0 0.0 0.0 0.0 
    POINT_CAMERA_AT_POINT playerCoords[0] playerCoords[1] playerCoords[2] 1 

    GOSUB Switch_ProcessFadeDelay 

    GOSUB Switch_GetSimpleCoords

    SET_FIXED_CAMERA_POSITION fTmp[1] fTmp[2] 300.0 0.0 0.0 0.0 
    POINT_CAMERA_AT_POINT fTmp[1] fTmp[2] fTmp[3] 1 

    SET_CHAR_COORDINATES hPlayerPed fTmp[1] fTmp[2] fTmp[3]
    LOAD_SCENE fTmp[1] fTmp[2] fTmp[3] 
    REQUEST_COLLISION fTmp[1] fTmp[2]

    WRITE_MEMORY CPostEffects_m_bGrainEnable 1 1 0
    WRITE_MEMORY 0x6684E4 4 0x10 0

    GOSUB Switch_ProcessFadeDelay   

    GOSUB Switch_GetFinalCoords

    GOSUB Switch_ProcessFadeDelay 

    GOSUB Switch_ProcessFadeDelay

    GOSUB Swtich_PrepareAndSetNewPlayerCoord

    GOSUB Switch_SetPlayer

    GOSUB Switch_SetCarIfNecessary

    SET_FIXED_CAMERA_POSITION fTmp[1] fTmp[2] 200.0 0.0 0.0 0.0 
    POINT_CAMERA_AT_POINT fTmp[1] fTmp[2] fTmp[3] 1 

    GOSUB Switch_ProcessFadeDelay

    SET_FIXED_CAMERA_POSITION fTmp[1] fTmp[2] 160.0 0.0 0.0 0.0 
    POINT_CAMERA_AT_POINT fTmp[1] fTmp[2] fTmp[3] 1 

    GOSUB Switch_ProcessFadeDelay

    WRITE_MEMORY CPostEffects_m_bGrainEnable 1 0 0
    WRITE_MEMORY 0x6684E4 4 0x40 0

    GOSUB Switch_ProcessFadeEnd

    RESTORE_CAMERA
    SET_PLAYER_CONTROL iPlayer 1
    SET_CURRENT_CHAR_WEAPON hPlayerPed 0

    DISPLAY_RADAR 1
    DISPLAY_HUD 1

    RETURN



    Swtich_PrepareAndSetNewPlayerCoord:
    IF IS_CHAR_IN_ANY_CAR hPlayerPed
        STORE_CAR_CHAR_IS_IN_NO_SAVE hPlayerPed (iTmp[0])
        WARP_CHAR_FROM_CAR_TO_COORD hPlayerPed fTmp[1] fTmp[2] -100.0
        SET_CAR_COORDINATES iTmp[0] 0.0 0.0 -20.0 // dummy pos
        switch_in_car[switch_cur_char] = 1
        switch_last_used_car[switch_cur_char] = iTmp[0]
    ELSE                                
        switch_in_car[switch_cur_char] = 0 
        switch_last_used_car[switch_cur_char] = -1
    ENDIF

    CLEAR_CHAR_TASKS_IMMEDIATELY hPlayerPed
    SET_CHAR_COORDINATES hPlayerPed fTmp[1] fTmp[2] -100.0
    LOAD_SCENE fTmp[1] fTmp[2] fTmp[3]
    REQUEST_COLLISION fTmp[1] fTmp[2]

    RETURN


    Switch_SetCarIfNecessary:
    iTmp[0] = -1     
    IF switch_in_car[switch_new_char] = 1
        IF DOES_VEHICLE_EXIST switch_last_used_car[switch_new_char]
            iTmp[0] = switch_last_used_car[switch_new_char]
            SET_CAR_COORDINATES iTmp[0] switch_x[switch_new_char] switch_y[switch_new_char] -100.0
        ELSE      
            IF switch_new_char = PLAYER_FRANKLIN
                iTmp[1] = BUFFALO
            ENDIF  
            IF switch_new_char = PLAYER_MICHAEL
                iTmp[1] = WASHING
            ENDIF   
            IF switch_new_char = PLAYER_TREVOR
                iTmp[1] = RNCHLURE
            ENDIF
            REQUEST_MODEL iTmp[1]
            WHILE NOT HAS_MODEL_LOADED iTmp[1]
                WAIT 0
            ENDWHILE
            CREATE_CAR iTmp[1] switch_x[switch_new_char] switch_y[switch_new_char] -100.0 (iTmp[0])
            MARK_MODEL_AS_NO_LONGER_NEEDED iTmp[1] 
            MARK_CAR_AS_NO_LONGER_NEEDED iTmp[0]
            TASK_WARP_CHAR_INTO_CAR_AS_DRIVER hPlayerPed iTmp[0]
        ENDIF
    ENDIF
    RETURN


    Switch_GetSetStats:
    // Money
    STORE_SCORE iPlayer (switch_money[switch_cur_char])
    iTmp[0] = switch_money[switch_cur_char]

    // reset money zero, maybe better use another way
    iTmp[0] *= -1
    IF iTmp[0] > 0 // fix negative money
        iTmp[0] = 0
    ENDIF
    ADD_SCORE iPlayer iTmp[0]

    ADD_SCORE iPlayer switch_money[switch_new_char]

    // Wanted
    STORE_WANTED_LEVEL iPlayer (switch_wanted[switch_cur_char])
    ALTER_WANTED_LEVEL iPlayer switch_wanted[switch_new_char] 
    RETURN


    Switch_SetPlayer:
    GOSUB Switch_GetSetStats
    IF switch_new_char = PLAYER_MICHAEL
        GIVE_MELEE_ATTACK_TO_CHAR hPlayerPed 5 6 
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
    IF switch_new_char = PLAYER_FRANKLIN
        GIVE_MELEE_ATTACK_TO_CHAR hPlayerPed 5 6 
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
    IF switch_new_char = PLAYER_TREVOR
        GIVE_MELEE_ATTACK_TO_CHAR hPlayerPed 5 6 
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
    switch_cur_char = switch_new_char

    fAbilityPercent = switch_ability[switch_cur_char]
    WRITE_MEMORY pAbilityPercent 4 fAbilityPercent TRUE

    IF GET_DYNAMIC_LIBRARY_PROCEDURE "radio_wheel_bgcolor" 0 (pLibraryObjectAddress)
        WRITE_STRUCT_OFFSET_MULTI pLibraryObjectAddress 0 4 1 char_r[switch_cur_char] char_g[switch_cur_char] char_b[switch_cur_char] 255
    ENDIF

    IF GET_DYNAMIC_LIBRARY_PROCEDURE "MenuBGAddColor" 0 (pLibraryObjectAddress)
        WRITE_MEMORY pLibraryObjectAddress 4 char_add_color[switch_cur_char] TRUE
    ENDIF

    IF GET_DYNAMIC_LIBRARY_PROCEDURE "MenuBGReplaceColor" 0 (pLibraryObjectAddress)
        WRITE_MEMORY pLibraryObjectAddress 4 char_replace_color[switch_cur_char] TRUE
    ENDIF

    TIMERA = CHANGE_MOVE_AFTER // force recalculate fake move
    RETURN


    Switch_GetSimpleCoords:
    fTmp[1] = switch_x[switch_new_char]
    fTmp[2] = switch_y[switch_new_char]
    fTmp[3] = switch_z[switch_new_char]
    RETURN

    Switch_GetFinalCoords:
    IF switch_in_car[switch_new_char] = 1
    
       GET_CLOSEST_CAR_NODE switch_x[switch_new_char] switch_y[switch_new_char] switch_z[switch_new_char] switch_x[switch_new_char] switch_y[switch_new_char] switch_z[switch_new_char]
    ELSE 
        GET_CLOSEST_CHAR_NODE switch_x[switch_new_char] switch_y[switch_new_char] switch_z[switch_new_char] switch_x[switch_new_char] switch_y[switch_new_char] switch_z[switch_new_char]
    ENDIF
    fTmp[1] = switch_x[switch_new_char]
    fTmp[2] = switch_y[switch_new_char]
    fTmp[3] = switch_z[switch_new_char]
    RETURN

    Switch_SetFadeColorByCur:
    SET_FADING_COLOUR char_r[switch_cur_char] char_g[switch_cur_char] char_b[switch_cur_char] 
    RETURN

    Switch_SetFadeColorByNew:
    SET_FADING_COLOUR char_r[switch_new_char] char_g[switch_new_char] char_b[switch_new_char]
    RETURN
    
    Switch_ProcessFadeDelayStart:
    GOSUB Switch_SetFadeColorByNew 
    DO_FADE 500 0
    WAIT 100
    DO_FADE 999999 0
    RETURN

    Switch_ProcessFadeDelay:
    WAIT 1000
    RETURN

    Switch_ProcessFadeEnd:
    DO_FADE 500 1
    WAIT 600
    SET_FADING_COLOUR 0 0 0
    RETURN
}

{
    weapon_selector:
    NOP 
    SCRIPT_NAME WEAPSEL

    CONST_INT wheel_part 99 
    CONST_INT wheel_current 98
    CONST_INT wheel_selected 97

    CONST_INT weapon_icon_0 96
    CONST_INT weapon_icon_1 95
    CONST_INT weapon_icon_2 94 
    CONST_INT weapon_icon_3 93
    CONST_INT weapon_icon_4 92  
    CONST_INT weapon_icon_5 91
    CONST_INT weapon_icon_6 90 
    CONST_INT weapon_icon_7 89   

    CONST_FLOAT WHEEL_SIZEX 260.0
    CONST_FLOAT WHEEL_SIZEY 100.0

    CONST_FLOAT ICON_SIZEX 110.0
    CONST_FLOAT ICON_SIZEY 70.0    

    CONST_FLOAT ICON_AMMO_X_OFFSET 0.0 
    CONST_FLOAT ICON_AMMO_Y_OFFSET 15.0

    CONST_FLOAT WEAP_WHEEL_SENSITIVITY 1.5

    CONST_INT SIDE_PISTOL 0
    CONST_INT SIDE_SMG 1
    CONST_INT SIDE_ASSALT 2
    CONST_INT SIDE_RIFLE 3
    CONST_INT SIDE_MELEE 4
    CONST_INT SIDE_SHOTGUN 5
    CONST_INT SIDE_HEAVY 6
    CONST_INT SIDE_PROJECTILES 7

    LVAR_FLOAT backupSensValue
    LVAR_FLOAT fAngle
    LVAR_INT iSide
    LVAR_INT iSlot
    LVAR_INT iCurWeapon
    LVAR_INT iCurSpriteId
    LVAR_INT iCheckWeapon 
    LVAR_INT iCheckAmmo
    LVAR_FLOAT x
    LVAR_FLOAT y

    LVAR_INT iStickX
    LVAR_INT iStickY

    LVAR_FLOAT fStickX
    LVAR_FLOAT fStickY
    LVAR_FLOAT fStoredStickX
    LVAR_FLOAT fStoredStickY

    LVAR_INT iCurSide

    LVAR_FLOAT fCurSideAngle

    LVAR_INT iLastSide

    LVAR_INT iPreferMeleeSlot

    LVAR_INT iDisablePrev  
    LVAR_INT iDisableNext
    LVAR_INT iLastPreferMeleeSlot

    LVAR_INT bDoFade
    LVAR_INT bFadeAltered
    LVAR_INT bReturn

    LVAR_INT i
    LVAR_INT j
    LVAR_INT k

    WHILE NOT IS_GERMAN_GAME
        WAIT 0
        READ_MEMORY 0x66BCA8 1 0 (iSide)
        READ_MEMORY 0x6FE56D 1 0 (iSlot)
        READ_MEMORY 0x66C518 4 0 (iCurWeapon)
        READ_MEMORY 0x6FF968 4 0 (iCurSpriteId)

        IF iSide = 0
        AND iSlot = 0
        AND NOT iCurWeapon = 1   
        AND NOT iCurSpriteId = 2
            IF IS_PLAYER_CONTROL_ON iPlayer
            AND NOT IS_CHAR_IN_ANY_CAR hPlayerPed
                IF IS_BUTTON_PRESSED PAD1 LEFTSHOULDER1
                AND is_drawing = 0
                    is_drawing = 1
                    SHAKE_PAD PAD1 100 999999
                    LOAD_TEXTURE_DICTIONARY VHUD

                    SET_TIME_SCALE 0.2
                    SET_DARKNESS_EFFECT 1 50    

                    CALL_FUNCTION toggleBlur 0 0 

                    IF NOT GET_FADING_STATUS
                        SET_FADING_COLOUR char_r[switch_cur_char] char_g[switch_cur_char] char_b[switch_cur_char]
                        DO_FADE 700 0 
                        TIMERA = 0
                        bDoFade = 1
                        bFadeAltered = 1
                    ELSE   
                        bDoFade = 0
                        bFadeAltered = 0
                    ENDIF

                    // disable camera            
                    READ_MEMORY 0x665204 4 0 (backupSensValue)

                    WRITE_MEMORY 0x665204 4 0.0 0

                    fStoredStickX = 0.0
                    fStoredStickY = 0.0
                    iDisablePrev = 0  
                    iDisableNext = 0          
                    GET_CURRENT_CHAR_WEAPON hPlayerPed (iCurWeapon)
                    GOSUB GetPreferedMeleeSlot

                    WHILE IS_BUTTON_PRESSED PAD1 LEFTSHOULDER1
                        WAIT 0  

                        IF NOT IS_PLAYER_PLAYING iPlayer
                        OR IS_CHAR_DEAD hPlayerPed
                        OR HAS_CHAR_BEEN_ARRESTED hPlayerPed
                            BREAK
                        ENDIF    

                        IF bDoFade = 1
                            IF TIMERA > 50
                                DO_FADE 9999999 0 
                                bDoFade = 0
                            ENDIF
                        ENDIF

                        GOSUB GetSelectedSide 
                        GOSUB CycleMelee
                        LOAD_SPRITE wheel_selected "wheel_selected"
                        LOAD_SPRITE wheel_part "wheel_part"

                        USE_TEXT_COMMANDS 1

                        iSide = 0
                        fAngle = -90.0
                        WHILE fAngle <= 225.0
                            DRAW_SPRITE_WITH_ROTATION wheel_part 320.0 200.0 WHEEL_SIZEX WHEEL_SIZEY fAngle 255 255 255 255
                            IF iCurSide = iSide
                                DRAW_SPRITE_WITH_ROTATION wheel_selected 320.0 200.0 WHEEL_SIZEX WHEEL_SIZEY fAngle char_r[switch_cur_char] char_g[switch_cur_char] char_b[switch_cur_char] 255
                            ENDIF
                            GOSUB DrawWeaponThisSide
                            iSide++
                            fAngle += 45.0
                        ENDWHILE

                        USE_TEXT_COMMANDS 0

                    ENDWHILE

                    IF bFadeAltered = 1
                        SET_FADING_COLOUR 0 0 0
                        DO_FADE 0 1 
                    ENDIF

                    IF iCurSide >= 0
                        iSide = iCurSide              
                        GOSUB GetSlotAndPosition
                        GOSUB GetWeapon
                        SET_CURRENT_CHAR_WEAPON hPlayerPed iCheckWeapon
                    ENDIF

                    // disable camera

                    // pad          
                    WRITE_MEMORY 0x665204 4 backupSensValue 0

                    CALL_FUNCTION toggleBlur 0 0 
                    SET_TIME_SCALE 1.0  
                    SET_DARKNESS_EFFECT 0 0
                    WAIT 100
                    REMOVE_TEXTURE_DICTIONARY
                    is_drawing = 0   
                ENDIF
            ENDIF                  
        ENDIF
    ENDWHILE


    CycleMelee:
    IF iCurSide = SIDE_MELEE
        IF IS_BUTTON_PRESSED PAD1 5 //prev
            IF iDisablePrev = 0
                GOSUB CycleMelee_Check  
                iDisablePrev = 1
            ENDIF
        ELSE
            iDisablePrev = 0
        ENDIF   

        IF IS_BUTTON_PRESSED PAD1 7 //next
            IF iDisableNext = 0
                GOSUB CycleMelee_Check 
                iDisableNext = 1
            ENDIF
        ELSE
            iDisableNext = 0
        ENDIF

        GOSUB FormatCycle

        IF iPreferMeleeSlot = 1
            DISPLAY_TEXT 320.0 270.0 LRARRW1
        ENDIF 

        IF iPreferMeleeSlot = 2
            DISPLAY_TEXT 320.0 270.0 LRARRW2
        ENDIF 

        IF iPreferMeleeSlot = 11
            DISPLAY_TEXT 320.0 270.0 LRARRW3
        ENDIF

        IF iPreferMeleeSlot = 12
            DISPLAY_TEXT 320.0 270.0 LRARRW4
        ENDIF

        IF iPreferMeleeSlot = 13
            DISPLAY_TEXT 320.0 270.0 LRARRW5
        ENDIF     
    ENDIF

    RETURN

    CycleMelee_Check:
    iLastPreferMeleeSlot = iPreferMeleeSlot

    WHILE NOT IS_GERMAN_GAME
        IF IS_BUTTON_PRESSED PAD1 5 //prev      
            GOSUB CycleMelee_Prev
        ELSE 
            GOSUB CycleMelee_Next
        ENDIF 
        
        IF iLastPreferMeleeSlot = iPreferMeleeSlot
            BREAK
        ENDIF        

        IF iPreferMeleeSlot = 13
            GOSUB ShowDetonator
            IF bReturn = 0
                CONTINUE
            ENDIF
        ENDIF

        GET_CHAR_WEAPON_IN_SLOT hPlayerPed iPreferMeleeSlot i j j

        IF iPreferMeleeSlot = 1
        AND i = 0
            BREAK
        ENDIF
        
        IF NOT i = 0
           BREAK
        ENDIF

    ENDWHILE 

    RETURN

    CycleMelee_Prev:
    IF iPreferMeleeSlot = 13
        iPreferMeleeSlot = 12
        RETURN
    ENDIF     
    IF iPreferMeleeSlot = 12
        iPreferMeleeSlot = 11
        RETURN
    ENDIF    
    IF iPreferMeleeSlot = 11
        iPreferMeleeSlot = 2
        RETURN
    ENDIF    
    IF iPreferMeleeSlot = 2
        iPreferMeleeSlot = 1
        RETURN
    ENDIF 
    IF iPreferMeleeSlot = 1
        iPreferMeleeSlot = 13
        RETURN
    ENDIF     
    RETURN  

    // 1 2 11 13 12

    CycleMelee_Next:
    IF iPreferMeleeSlot = 1
        iPreferMeleeSlot = 2
        RETURN
    ENDIF     
    IF iPreferMeleeSlot = 2
        iPreferMeleeSlot = 11
        RETURN
    ENDIF    
    IF iPreferMeleeSlot = 11
        iPreferMeleeSlot = 12
        RETURN
    ENDIF 
    IF iPreferMeleeSlot = 12
        iPreferMeleeSlot = 13
        RETURN
    ENDIF    
    IF iPreferMeleeSlot = 13
        iPreferMeleeSlot = 1
        RETURN
    ENDIF   
    RETURN

    GetSelectedSide:
    GET_POSITION_OF_ANALOGUE_STICKS PAD1 j j iStickX iStickY

    fStickX =# iStickX 
    fStickY =# iStickY

    IF NOT fStickX = 0.0  
    OR NOT fStickY = 0.0
        fStoredStickX = fStickX 
        fStoredStickY = fStickY
    ELSE
        fStickY *= -1.0

        fStickX *= WEAP_WHEEL_SENSITIVITY     
        fStickY *= WEAP_WHEEL_SENSITIVITY

        fStoredStickX +=@ fStickX   
        fStoredStickY +=@ fStickY

        IF fStoredStickX > 10.0
            fStoredStickX = 10.0
        ENDIF  
        IF fStoredStickX < -10.0
            fStoredStickX = -10.0
        ENDIF   
        IF fStoredStickY > 10.0
            fStoredStickY = 10.0
        ENDIF  
        IF fStoredStickY < -10.0
            fStoredStickY = -10.0
        ENDIF
    ENDIF

    iLastSide = iCurSide
    iCurSide = -1

    IF fStoredStickX > -5.0 
    AND fStoredStickX < 5.0
    AND fStoredStickY < -5.0
        iCurSide = SIDE_PISTOL
    ENDIF

    IF fStoredStickX > 5.0
    AND fStoredStickY < -5.0
        iCurSide = SIDE_SMG
    ENDIF  

    IF fStoredStickX > 5.0
    AND fStoredStickY > -5.0  
    AND fStoredStickY < 5.0
        iCurSide = SIDE_ASSALT
    ENDIF     

    IF fStoredStickX > 5.0
    AND fStoredStickY > 5.0
        iCurSide = SIDE_RIFLE
    ENDIF      

    IF fStoredStickX > -5.0 
    AND fStoredStickX < 5.0
    AND fStoredStickY > 5.0
        iCurSide = SIDE_MELEE
    ENDIF      

    IF fStoredStickX < -5.0
    AND fStoredStickY > 5.0
        iCurSide = SIDE_SHOTGUN
    ENDIF   

    IF fStoredStickX < -5.0
    AND fStoredStickY > -5.0  
    AND fStoredStickY < 5.0
        iCurSide = SIDE_HEAVY
    ENDIF  

    IF fStoredStickX < -5.0
    AND fStoredStickY < -5.0
        iCurSide = SIDE_PROJECTILES
    ENDIF

    /*IF iCurSide >= 0
    
           iSide = iCurSide
        GOSUB GetSlotAndPosition
        GET_CHAR_WEAPON_IN_SLOT hPlayerPed iSlot iCheckWeapon ammo i model i
        IF iCheckWeapon <= 0
        
            IF iSlot <> 1
            
                   iCurSide = iLastSide
            ENDIF
        ENDIF
    ENDIF
    
    x = fStoredStickX  
    y = fStoredStickY
    x += 320.0               
    y += 224.0                                                  
    draw_box_position 320.0 224.0 20.0 20.0 RGBA 0 0 0 255
    draw_box_position x y 5.0 5.0 RGBA 255 255 0 255*/

    RETURN

    ShowDetonator:
    GET_CHAR_WEAPON_IN_SLOT hPlayerPed 9 k j j
    IF k = 39
        GOTO TrueReturn
    ELSE
        GOTO FalseReturn
    ENDIF

    DrawWeaponThisSide:
    iSlot = -1          
    bReturn = 0

    GOSUB GetSlotAndPosition
    GOSUB GetWeapon
    
    IF bReturn = 1
        GOSUB CheckDrawCurSide   
        DRAW_SPRITE iCurSpriteId x y ICON_SIZEX ICON_SIZEY 255 255 255 255
        x -= ICON_AMMO_X_OFFSET                                                                         
        y += ICON_AMMO_Y_OFFSET
        GOSUB CheckDrawAmmo
        IF bReturn = 1
            GOSUB FormatAmmo
            DISPLAY_TEXT_WITH_NUMBER x y NUMBER iCheckAmmo
        ENDIF
    ENDIF
    RETURN

    FormatAmmo:
    SET_TEXT_FONT 2
    SET_TEXT_EDGE 2 0 0 0 255
    SET_TEXT_SCALE 0.32 1.07
    SET_TEXT_CENTRE 1
    SET_TEXT_CENTRE_SIZE 640.0
    RETURN

    FormatCycle:
    SET_TEXT_FONT 2
    SET_TEXT_EDGE 2 0 0 0 255
    SET_TEXT_SCALE 0.32 1.07 
    SET_TEXT_CENTRE 1
    SET_TEXT_CENTRE_SIZE 640.0
    RETURN

    CheckDrawAmmo:
    IF iCheckWeapon <= 15
        GOTO FalseReturn
    ENDIF

    IF iCheckWeapon = 40  
    OR iCheckWeapon = 44
    OR iCheckWeapon = 45
    OR iCheckWeapon = 46
        GOTO FalseReturn
    ENDIF
    GOTO TrueReturn

    GetSlotAndPosition:
    IF iSide = SIDE_PISTOL
        iSlot = 3  
        x = 320.0
        y = 96.0
    ENDIF   
    IF iSide = SIDE_SMG
        iSlot = 5  
        x = 380.0
        y = 130.0 
    ENDIF  
    IF iSide = SIDE_ASSALT
        iSlot = 6  
        x = 400.0
        y = 200.0 
    ENDIF  
    IF iSide = SIDE_RIFLE
        iSlot = 7 
        x = 380.0
        y = 270.0 
    ENDIF     
    IF iSide = SIDE_MELEE
        iSlot = 1
        x = 320.0
        y = 300.0 
    ENDIF     
    IF iSide = SIDE_SHOTGUN   
        iSlot = 4
        x = 260.0
        y = 270.0 
    ENDIF      
    IF iSide = SIDE_HEAVY
        iSlot = 8
        x = 235.0
        y = 200.0 
    ENDIF       
    IF iSide = SIDE_PROJECTILES
        iSlot = 9
        x = 260.0
        y = 130.0 
    ENDIF
    RETURN

    GetWeapon:
    GET_CHAR_WEAPON_IN_SLOT hPlayerPed iSlot iCheckWeapon iCheckAmmo i

    IF iCheckWeapon = 0
        IF NOT iSlot = 1
            iCheckWeapon = -1
            RETURN
        ENDIF
    ENDIF

    IF iSlot = 3
        iCurSpriteId = weapon_icon_0
        IF iCheckWeapon = 22
            LOAD_SPRITE iCurSpriteId "pistol"
            GOTO TrueReturn
        ENDIF 
        IF iCheckWeapon = 23
            LOAD_SPRITE iCurSpriteId "silenced_pistol"
            GOSUB TrueReturn
        ENDIF      
        IF iCheckWeapon = 24
            LOAD_SPRITE iCurSpriteId "desert_eagle"
            GOSUB TrueReturn
        ENDIF
    ENDIF  

    IF iSlot = 5   
        iCurSpriteId = weapon_icon_1
        IF iCheckWeapon = 28
            LOAD_SPRITE iCurSpriteId "micro_uzi"
            GOSUB TrueReturn
        ENDIF      
        IF iCheckWeapon = 29
            LOAD_SPRITE iCurSpriteId "mp5"
            GOSUB TrueReturn
        ENDIF    
        IF iCheckWeapon = 32
            LOAD_SPRITE iCurSpriteId "tec_9"
            GOTO TrueReturn
        ENDIF 
    ENDIF      

    IF iSlot = 6     
        iCurSpriteId = weapon_icon_2
        IF iCheckWeapon = 30
            LOAD_SPRITE iCurSpriteId "ak47"
            GOSUB TrueReturn
        ENDIF      
        IF iCheckWeapon = 31
            LOAD_SPRITE iCurSpriteId "m4"
            GOSUB TrueReturn
        ENDIF    
    ENDIF      

    IF iSlot = 7 
        iCurSpriteId = weapon_icon_3
        IF iCheckWeapon = 33
            LOAD_SPRITE iCurSpriteId "rifle"
            GOSUB TrueReturn
        ENDIF      
        IF iCheckWeapon = 34
            LOAD_SPRITE iCurSpriteId "sniper_rifle"
            GOSUB TrueReturn
        ENDIF    
    ENDIF     

    IF iSlot = 1
        IF iPreferMeleeSlot > 1
            GET_CHAR_WEAPON_IN_SLOT hPlayerPed iPreferMeleeSlot iCheckWeapon iCheckAmmo i  
        ENDIF

        iCurSpriteId = weapon_icon_4
        IF iCheckWeapon = 0
            LOAD_SPRITE iCurSpriteId "unarmed" 
            GOTO TrueReturn
        ENDIF    
        IF iCheckWeapon = 1
            LOAD_SPRITE iCurSpriteId "brass_knuckles" 
            GOTO TrueReturn
        ENDIF
        IF iCheckWeapon = 2
            LOAD_SPRITE iCurSpriteId "golf_club"  
            GOTO TrueReturn
        ENDIF      
        IF iCheckWeapon = 3
            LOAD_SPRITE iCurSpriteId "night_stick" 
            GOTO TrueReturn
        ENDIF      
        IF iCheckWeapon = 4
            LOAD_SPRITE iCurSpriteId "knife"  
            GOTO TrueReturn
        ENDIF      
        IF iCheckWeapon = 5
            LOAD_SPRITE iCurSpriteId "baseball_bat"   
            GOTO TrueReturn
        ENDIF      
        IF iCheckWeapon = 6
            LOAD_SPRITE iCurSpriteId "shovel"
            GOTO TrueReturn
        ENDIF         
        IF iCheckWeapon = 7
            LOAD_SPRITE iCurSpriteId "pool_cue" 
            GOTO TrueReturn 
        ENDIF          
        IF iCheckWeapon = 8
            LOAD_SPRITE iCurSpriteId "katana"  
            GOTO TrueReturn
        ENDIF           
        IF iCheckWeapon = 9
            LOAD_SPRITE iCurSpriteId "chainsaw" 
            GOTO TrueReturn
        ENDIF                        
        IF iCheckWeapon = 10
            LOAD_SPRITE iCurSpriteId "dildo_1"  
            GOTO TrueReturn
        ENDIF         
        IF iCheckWeapon = 11 
            LOAD_SPRITE iCurSpriteId "dildo_2" 
            GOTO TrueReturn
        ENDIF          
        IF iCheckWeapon = 12 
            LOAD_SPRITE iCurSpriteId "vibe_1" 
            GOTO TrueReturn 
        ENDIF        
        IF iCheckWeapon = 13 
            LOAD_SPRITE iCurSpriteId "vibe_2" 
            GOTO TrueReturn
        ENDIF       
        IF iCheckWeapon = 14
            LOAD_SPRITE iCurSpriteId "flowers" 
            GOTO TrueReturn
        ENDIF       
        IF iCheckWeapon = 15
            LOAD_SPRITE iCurSpriteId "cane"
            GOTO TrueReturn
        ENDIF                
        IF iCheckWeapon = 40
            LOAD_SPRITE iCurSpriteId "detonator"
            GOTO TrueReturn
        ENDIF                     
        IF iCheckWeapon = 41
            LOAD_SPRITE iCurSpriteId "spray_paint"
            GOTO TrueReturn
        ENDIF   
        IF iCheckWeapon = 42
            LOAD_SPRITE iCurSpriteId "fire_extinguisher"
            GOTO TrueReturn
        ENDIF     
        IF iCheckWeapon = 43
            LOAD_SPRITE iCurSpriteId "camera"
            GOTO TrueReturn
        ENDIF 
        IF iCheckWeapon = 44
            LOAD_SPRITE iCurSpriteId "n_goggles"
            GOTO TrueReturn
        ENDIF     
        IF iCheckWeapon = 45
            LOAD_SPRITE iCurSpriteId "t_goggles"
            GOTO TrueReturn
        ENDIF      
        IF iCheckWeapon = 46
            LOAD_SPRITE iCurSpriteId "parachute"
            GOTO TrueReturn
        ENDIF
        GOTO TrueReturn
    ENDIF  

    IF iSlot = 4             
        iCurSpriteId = weapon_icon_5
        IF iCheckWeapon = 25
            LOAD_SPRITE iCurSpriteId "shotgun"
            GOSUB TrueReturn
        ENDIF      
        IF iCheckWeapon = 26
            LOAD_SPRITE iCurSpriteId "sawn_off"
            GOSUB TrueReturn
        ENDIF        
        IF iCheckWeapon = 27
            LOAD_SPRITE iCurSpriteId "spas_12"
            GOSUB TrueReturn
        ENDIF    
    ENDIF   

    IF iSlot = 8
        iCurSpriteId = weapon_icon_6
        IF iCheckWeapon = 35
            LOAD_SPRITE iCurSpriteId "rpg" 
            GOSUB TrueReturn
        ENDIF      
        IF iCheckWeapon = 36
            LOAD_SPRITE iCurSpriteId "missilel"
            GOSUB TrueReturn
        ENDIF        
        IF iCheckWeapon = 37
            LOAD_SPRITE iCurSpriteId "flame_thrower"
            GOSUB TrueReturn
        ENDIF             
        IF iCheckWeapon = 38
            LOAD_SPRITE iCurSpriteId "minigun"
            GOSUB TrueReturn
        ENDIF   
    ENDIF       

    IF iSlot = 9   
        iCurSpriteId = weapon_icon_7
        IF iCheckWeapon = 16
            LOAD_SPRITE iCurSpriteId "grenade"
            GOSUB TrueReturn
        ENDIF      
        IF iCheckWeapon = 17
            LOAD_SPRITE iCurSpriteId "tear_gas"
            GOSUB TrueReturn
        ENDIF        
        IF iCheckWeapon = 18
            LOAD_SPRITE iCurSpriteId "molotov"
            GOSUB TrueReturn
        ENDIF          
        IF iCheckWeapon = 39
            LOAD_SPRITE iCurSpriteId "satchel_charge"
            GOSUB TrueReturn
        ENDIF  
    ENDIF    
    RETURN

    GetPreferedMeleeSlot:  
    iPreferMeleeSlot = 1
    iSlot = 1
    GET_CHAR_WEAPON_IN_SLOT hPlayerPed iSlot iCheckWeapon iCheckAmmo i 
    IF iCheckWeapon = iCurWeapon
        iPreferMeleeSlot = iSlot
        RETURN
    ENDIF
    iSlot = 2  
    GET_CHAR_WEAPON_IN_SLOT hPlayerPed iSlot iCheckWeapon iCheckAmmo i 
    IF iCheckWeapon = iCurWeapon
        iPreferMeleeSlot = iSlot 
        RETURN
    ENDIF  
    iSlot = 11             
    GET_CHAR_WEAPON_IN_SLOT hPlayerPed iSlot iCheckWeapon iCheckAmmo i 
    IF iCheckWeapon = iCurWeapon
        iPreferMeleeSlot = iSlot     
        RETURN
    ENDIF
    iSlot = 13            
    GET_CHAR_WEAPON_IN_SLOT hPlayerPed iSlot iCheckWeapon iCheckAmmo i 
    IF iCheckWeapon = iCurWeapon
        iPreferMeleeSlot = iSlot    
        RETURN
    ENDIF    
    iSlot = 12        
    GET_CHAR_WEAPON_IN_SLOT hPlayerPed iSlot iCheckWeapon iCheckAmmo i 
    IF iCheckWeapon = iCurWeapon
        iPreferMeleeSlot = iSlot   
        RETURN
    ENDIF
    RETURN

    CheckDrawCurSide:
    IF iCurWeapon = iCheckWeapon
        LOAD_SPRITE wheel_current "wheel_current"
        DRAW_SPRITE_WITH_ROTATION wheel_current 320.0 200.0 WHEEL_SIZEX WHEEL_SIZEY fAngle char_r[switch_cur_char] char_g[switch_cur_char] char_b[switch_cur_char] 255
    ENDIF
    RETURN

    TrueReturn:
    bReturn = 1
    RETURN   
    
    FalseReturn:
    bReturn = 0
    RETURN
}     

{
    life_recovery:
    SCRIPT_NAME LIFEREC

    LVAR_INT i iCurHealth iLastCurHealth iMaxHealth p iWithDelay iFinalHealth this_script cur_color
    LVAR_FLOAT f fMaxHealth fCurHealth fCurHealthPercent fFinalHealth fIfLessThan fIncreaseTo fUsingSpeed fRegeHealthPercent fFlashHudHealth char_speed

    WAIT 1100

    fIfLessThan = 50.0
    fIncreaseTo = 50.0
    fUsingSpeed = 0.05
    iWithDelay  = 2000

    fIfLessThan /= 100.0
    fIncreaseTo /= 100.0
    fUsingSpeed /= 50.0

    GET_THIS_SCRIPT_STRUCT (this_script)

    TIMERB = 99999

    life_loop:  
        WAIT 0

        IF GOSUB StoreValues
            IF fCurHealthPercent < fIfLessThan
                GOSUB RunRegeneration
            ENDIF
        ENDIF
    GOTO life_loop
    
    RunRegeneration:
    iLastCurHealth = iCurHealth
    TIMERA = 0
    WHILE TIMERA < iWithDelay
        IF GOSUB ProcessCancel
            RETURN
        ENDIF
        GET_CHAR_HEALTH hPlayerPed (iCurHealth)
        IF NOT iLastCurHealth = iCurHealth
            RETURN
        ENDIF
    ENDWHILE

    fRegeHealthPercent = fCurHealthPercent
    WHILE NOT IS_GERMAN_GAME
        IF GOSUB ProcessCancel
            RETURN
        ENDIF
        GET_CHAR_HEALTH hPlayerPed (iCurHealth)
        IF iCurHealth < iLastCurHealth // was damaged
            RETURN
        ENDIF
        IF GOSUB StoreValues
        ELSE
            RETURN
        ENDIF
        IF fCurHealthPercent > fRegeHealthPercent
            fRegeHealthPercent = fCurHealthPercent + 1.0
        ENDIF
        fRegeHealthPercent +=@ fUsingSpeed
        IF fRegeHealthPercent > fIncreaseTo
            GOSUB SetHealthByPercent
            BREAK
        ENDIF
        GOSUB SetHealthByPercent
        iLastCurHealth = iFinalHealth
    ENDWHILE

    RETURN

    SetHealthByPercent:
    fFinalHealth = fMaxHealth * fRegeHealthPercent
    iFinalHealth =# fFinalHealth
    SET_CHAR_HEALTH hPlayerPed iFinalHealth
    RETURN

    StoreValues:
    GET_CHAR_HEALTH hPlayerPed (iCurHealth)

    READ_MEMORY 0x2A9D14 4 0 (cur_color)
    IF fCurHealthPercent < 0.3
        IF NOT cur_color = 0xFF0000FF
            WRITE_MEMORY 0x2A9D14 4 0xFF0000FF 0
        ENDIF
    ELSE
        IF cur_color = 0xFF0000FF
            WRITE_MEMORY 0x2A9D14 4 0xff019b3e 0
        ENDIF
    ENDIF

    IF iCurHealth > 0
        READ_MEMORY 0x70974B 1 0 (iMaxHealth)
        fMaxHealth =# iMaxHealth
        fCurHealth =# iCurHealth
        fCurHealthPercent = fCurHealth / fMaxHealth
        IS_INT_LVAR_GREATER_THAN_CONSTANT TIMERA -1
        RETURN
    ENDIF
    IS_INT_LVAR_EQUAL_TO_CONSTANT TIMERA -1
    RETURN

    ProcessCancel:
    WAIT 0
    GET_CHAR_SPEED hPlayerPed (char_speed)
    IF char_speed > 0.0
    AND NOT IS_CHAR_IN_ANY_CAR hPlayerPed
        IS_INT_LVAR_GREATER_THAN_CONSTANT TIMERA -1
        RETURN
    ENDIF
    IS_INT_LVAR_EQUAL_TO_CONSTANT TIMERA -1
    RETURN
}


{
    taxi:
    SCRIPT_NAME TAXI
    VAR_FLOAT temp_float[4]
    LVAR_INT temp_driver temp_car car_model taxis[5] n i hTaxiMenu
    LVAR_FLOAT x1 y1 x2 y2 z1 z2 scplayer_x scplayer_y

    CONST_INT CRadar_ms_RadarTrace 0x701F00
    CONST_INT FrontEndMenuManager_m_nTargetBlipIndex 0x6FF970
    LVAR_INT targetBlip tmp

    // for debug purposes
    /*    REQUEST_MODEL TAXI
        LOAD_ALL_MODELS_NOW
        GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hPlayerPed -0f 10f 0f x1 y1 z1  
        CREATE_CAR TAXI x1 y1 z1 n 
        taxis[0] = n
        CREATE_RANDOM_CHAR_AS_DRIVER n n */
    //

    taxi_loop:
        WAIT 0
        IF NOT IS_CHAR_IN_ANY_CAR hPlayerPed
            GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hPlayerPed -10f -10f 0f x1 y1 z1  
            GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hPlayerPed 10f 10f 0f x2 y2 z1  
            GET_RANDOM_CAR_OF_TYPE_IN_AREA x1 y1 x2 y2 TAXI temp_car 
            IF DOES_VEHICLE_EXIST temp_car
                REPEAT 5 n 
                    IF taxis[n] = 0
                        taxis[n] = temp_car
                        BREAK
                    ELSE
                        IF DOES_VEHICLE_EXIST taxis[n]
                            IF NOT LOCATE_CHAR_ANY_MEANS_CAR_3D hPlayerPed taxis[n] 10f 10f 10f 0
                                taxis[n] = temp_car
                                BREAK
                            ENDIF
                        ELSE    
                            taxis[n] = temp_car
                            BREAK
                        ENDIF
                    ENDIF
                ENDREPEAT   
            ENDIF

            
            REPEAT 5 n 
                IF taxis[n] > 0
                    IF DOES_VEHICLE_EXIST taxis[n]
                        IF IS_CAR_HEALTH_GREATER taxis[n] 100
                            GET_DRIVER_OF_CAR taxis[n] temp_driver
                            //PRINT_FORMATTED_NOW "%i" 1 temp_driver
                            IF LOCATE_CHAR_ANY_MEANS_CAR_3D hPlayerPed taxis[n] 8f 8f 8f 0 
                            AND NOT temp_driver = -1  
                                //PRINT_HELP TAX1
                                PRINT_HELP_STRING "Press ~t~ to get into the taxi."
                                SET_PLAYER_ENTER_CAR_BUTTON 0 0
                                WHILE LOCATE_CHAR_ANY_MEANS_CAR_3D hPlayerPed taxis[n] 8f 8f 8f 0
                                    WAIT 0
                                    IF NOT IS_CAR_HEALTH_GREATER taxis[n] 0
                                    OR IS_CHAR_IN_ANY_CAR hPlayerPed
                                        BREAK
                                    ENDIF
                                    //PRINT_FORMATTED_NOW "esta perto" 1 
                                    IF IS_BUTTON_PRESSED PAD1 TRIANGLE
                                    AND is_drawing = FALSE
                                        is_drawing = TRUE
                                        TIMERA = 0
                                        TASK_CAR_MISSION temp_driver taxis[n] -1 1 0f 0
                                        WHILE IS_BUTTON_PRESSED PAD1 TRIANGLE
                                            WAIT 0
                                            IF TIMERA > 1500
                                                is_drawing = FALSE
                                                BREAK
                                            ENDIF
                                        ENDWHILE
                                        IF TIMERA < 1500
                                            SET_PLAYER_CONTROL 0 FALSE
                                            GET_OFFSET_FROM_CAR_IN_WORLD_COORDS taxis[n] -1f 0f 0f x1 y1 z1  
                                            GET_OFFSET_FROM_CAR_IN_WORLD_COORDS taxis[n] 1f 0f 0f x2 y2 z2
                                            GET_CHAR_COORDINATES hPlayerPed scplayer_x scplayer_y z1
                                            GET_DISTANCE_BETWEEN_COORDS_2D x1 y1 scplayer_x scplayer_y x1
                                            GET_DISTANCE_BETWEEN_COORDS_2D x2 y2 scplayer_x scplayer_y x2
                                            IF x2 > x1 
                                                TASK_ENTER_CAR_AS_PASSENGER hPlayerPed taxis[n] 10000 1
                                            ELSE
                                                TASK_ENTER_CAR_AS_PASSENGER hPlayerPed taxis[n] 10000 2
                                            ENDIF
                                            WHILE NOT IS_CHAR_IN_ANY_CAR hPlayerPed
                                                IF IS_BUTTON_PRESSED PAD1 TRIANGLE
                                                    WHILE IS_BUTTON_PRESSED PAD1 TRIANGLE
                                                        WAIT 0
                                                    ENDWHILE
                                                    TASK_CAR_MISSION temp_driver taxis[n] -1 0 25f 0
                                                    TASK_CAR_DRIVE_WANDER temp_driver taxis[n] 25f 0

                                                    MARK_CAR_AS_NO_LONGER_NEEDED taxis[n]
                                                    MARK_CHAR_AS_NO_LONGER_NEEDED temp_driver

                                                    CLEAR_CHAR_TASKS_IMMEDIATELY hPlayerPed
                                                    SET_PLAYER_CONTROL 0 TRUE
                                                    is_drawing = FALSE

                                                    WAIT 250

                                                    GOTO taxi_loop
                                                ENDIF
                                                WAIT 0
                                            ENDWHILE
                                            // 067C: attach_camera_to_char hPlayerPed offset 0.0 -0.17 0.7 rotation 0.0 1.5 0.4 tilt 0.0 switchstyle 2
                                            ATTACH_CAMERA_TO_CHAR hPlayerPed 0.0 -0.17 0.7 , -0.5 1.5 0.4 0.0 2
                                            TASK_LOOK_AT_CHAR temp_driver hPlayerPed -1

                                            CREATE_MENU TAXI 50f 50f 300f 1 TRUE TRUE 0 (hTaxiMenu)
                                            SET_MENU_COLUMN hTaxiMenu 0 DUMMY HOME AIRP WAYP DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY
                                            SET_MENU_COLUMN_ORIENTATION hTaxiMenu 0 1

                                            WHILE IS_THING_GREATER_THAN_THING TIMERA -1
                                                IF IS_BUTTON_PRESSED PAD1 CROSS
                                                    WHILE IS_BUTTON_PRESSED PAD1 CROSS
                                                        WAIT 0
                                                    ENDWHILE
                                                    GET_MENU_ITEM_SELECTED (hTaxiMenu) (menu_flags)
                                                    is_drawing = FALSE
                                                    BREAK
                                                ENDIF
                                                IF IS_BUTTON_PRESSED PAD1 TRIANGLE
                                                    WHILE IS_BUTTON_PRESSED PAD1 TRIANGLE
                                                        WAIT 0
                                                    ENDWHILE
                                                    is_drawing = FALSE
                                                    TASK_LEAVE_ANY_CAR hPlayerPed
                                                    
                                                    DELETE_MENU hTaxiMenu

                                                    WAIT 1000

                                                    SET_PLAYER_CONTROL 0 TRUE
                                                    
                                                    TASK_CAR_MISSION temp_driver taxis[n] -1 0 25f 0
                                                    TASK_CAR_DRIVE_WANDER temp_driver taxis[n] 25f 0

                                                    MARK_CAR_AS_NO_LONGER_NEEDED taxis[n]
                                                    MARK_CHAR_AS_NO_LONGER_NEEDED temp_driver

                                                    GOTO taxi_loop
                                                ENDIF
                                                WAIT 0
                                            ENDWHILE

                                            DELETE_MENU hTaxiMenu

                                            SWITCH menu_flags
                                                CASE 0 // HOME
                                                    IF switch_cur_char = PLAYER_FRANKLIN
                                                        x1 = 1684.828
                                                        y1 = -2108.3677
                                                        z1 = 13f
                                                    ENDIF
                                                    IF switch_cur_char = PLAYER_MICHAEL
                                                        x1 = 273.0
                                                        y1 = -1236.0
                                                        z1 = 73.6825
                                                    ENDIF
                                                    IF switch_cur_char = PLAYER_TREVOR
                                                        x1 = -1041.3763 
                                                        y1 = 1562.1898
                                                        z1 = 32f
                                                    ENDIF
                                                BREAK
                                                CASE 1 // AIRP
                                                    x1 = 1682.5110 
                                                    y1 = -2251.3920 
                                                    z1 = 13f
                                                BREAK
                                                CASE 2 // WAYPOINT
                                                    GET_TARGET_BLIP_COORDS x1 y1 z1
                                                BREAK
                                            ENDSWITCH
                                            GET_CHAR_COORDINATES hPlayerPed scplayer_x scplayer_y z2
                                            GET_DISTANCE_BETWEEN_COORDS_2D x1 y1 scplayer_x scplayer_y z2
                                            z2 /= 100f
                                            i =# z2
                                            RESTORE_CAMERA_JUMPCUT
                                            SET_CAR_DRIVING_STYLE taxis[n] DRIVINGMODE_AVOIDCARS
                                            TASK_CAR_DRIVE_TO_COORD temp_driver taxis[n] x1 y1 z1 30f 0 0 0
                                            PRINT_HELP_STRING "Press ~x~ to skip the trip."
                                            //TASK_CAR_MISSION temp_driver taxis[n] -1 1 15.0 0 
                                            WHILE NOT IS_GERMAN_GAME
                                                WAIT 0
                                                IF IS_BUTTON_PRESSED PAD1 CROSS
                                                    DO_FADE 3000 0 
                                                    WAIT 3000
                                                    CLEAR_CHAR_TASKS temp_driver
                                                    LOAD_SCENE x1 y1 z1
                                                    REQUEST_COLLISION x1 y1
                                                    LOAD_ALL_MODELS_NOW
                                                    GET_CLOSEST_CAR_NODE_WITH_HEADING x1 y1 z1 x1 y1 z1 x2
                                                    SET_CAR_COORDINATES taxis[n] x1 y1 z1
                                                    SET_CAR_HEADING taxis[n] x2
                                                    DO_FADE 2000 1
                                                    WAIT 2000
                                                    BREAK
                                                ENDIF
                                                IF LOCATE_STOPPED_CAR_2D taxis[n] x1 y1 20f 20f 0
                                                    BREAK
                                                ENDIF
                                            ENDWHILE
                                            TASK_LEAVE_CAR_IMMEDIATELY hPlayerPed taxis[n]
                                            WHILE IS_CHAR_IN_ANY_CAR hPlayerPed
                                                WAIT 0
                                            ENDWHILE
                                            WAIT 200
                                            MARK_CAR_AS_NO_LONGER_NEEDED taxis[n]
                                            MARK_CHAR_AS_NO_LONGER_NEEDED temp_driver
                                            TASK_CAR_MISSION temp_driver taxis[n] -1 1 15.0 0 
                                            SET_PLAYER_CONTROL 0 1                                        
                                            SET_PLAYER_ENTER_CAR_BUTTON 0 1
                                            IF IS_SCORE_GREATER 0 i 
                                                i *= -1
                                                ADD_SCORE 0 i
                                            ELSE 
                                                STORE_WANTED_LEVEL 0 i 
                                                i++
                                                ALTER_WANTED_LEVEL 0 i
                                            ENDIF
                                        ELSE
                                            TASK_ENTER_CAR_AS_DRIVER hPlayerPed taxis[n] -1
                                            WHILE NOT IS_CHAR_IN_ANY_CAR hPlayerPed
                                                WAIT 0
                                            ENDWHILE
                                            BREAK
                                        ENDIF
                                    ENDIF
                                ENDWHILE
                                SET_PLAYER_ENTER_CAR_BUTTON 0 1
                                CLEAR_HELP
                            ENDIF
                        ENDIF
                    ELSE
                        taxis[n] = 0
                    ENDIF
                ENDIF
            ENDREPEAT
        ENDIF
    GOTO taxi_loop
}

{
    shoreline_waves:
    SCRIPT_NAME SHRLNWV

    LVAR_INT instance // In
    LVAR_FLOAT radius radiusNeg // In
    LVAR_INT fx creators i
    LVAR_FLOAT x y z rand waterHeight dist

    radius = 50.0
    radiusNeg = radius * -1.0

    instance *= 10
    WAIT instance // add start delay for each script

    WHILE NOT IS_GERMAN_GAME
        WAIT 0
        
        GET_AREA_VISIBLE i
        IF i = 0

            GET_ACTIVE_CAMERA_COORDINATES x y z
            IF z < 100.0
                GOSUB RandomizeCamCoord
                GET_WATER_HEIGHT_AT_COORDS x y FALSE (waterHeight)
                IF waterHeight > -1000.0
                    IF GOSUB IsValid
                        waterHeight += 0.01 // avoid z-fighting
                        CREATE_FX_SYSTEM "shore_wave" x y waterHeight 1 (fx)
                        PLAY_FX_SYSTEM fx
                        WAIT 500 // play time
                        KILL_FX_SYSTEM fx
                        CONTINUE // don't run next WAIT
                    ENDIF
                ENDIF
            ENDIF

        ENDIF

        WAIT 150

    ENDWHILE

    RandomizeCamCoord:
    GENERATE_RANDOM_FLOAT_IN_RANGE radiusNeg radius (rand)
    x += rand
    GENERATE_RANDOM_FLOAT_IN_RANGE radiusNeg radius (rand)
    y += rand
    GENERATE_RANDOM_FLOAT_IN_RANGE radiusNeg radius (rand)
    z += rand
    RETURN

    IsValid:
    // BoB
    GET_DISTANCE_BETWEEN_COORDS_2D x y -655.4575 -1889.0964 (dist)
    IF dist < 400.0
        IS_INT_LVAR_EQUAL_TO_CONSTANT TIMERA -1
        RETURN
    ENDIF

    // Riacho Sombrio
    GET_DISTANCE_BETWEEN_COORDS_2D x y -1517.027 -2197.4331 (dist)
    IF dist < 300.0
        IS_INT_LVAR_EQUAL_TO_CONSTANT TIMERA -1
        RETURN
    ENDIF

    // Tierra Robada
    GET_DISTANCE_BETWEEN_COORDS_2D x y -1260.0477 2132.3345 (dist)
    IF dist < 400.0
        IS_INT_LVAR_EQUAL_TO_CONSTANT TIMERA -1
        RETURN
    ENDIF

    // Las Venturas
    GET_DISTANCE_BETWEEN_COORDS_2D x y 2053.2419 1617.0974 (dist)
    IF dist < 1000.0
        IS_INT_LVAR_EQUAL_TO_CONSTANT TIMERA -1
        RETURN
    ENDIF

    // Near LS west
    GET_DISTANCE_BETWEEN_COORDS_2D x y 46.8252 -1040.2834 (dist)
    IF dist < 210.0
        IS_INT_LVAR_EQUAL_TO_CONSTANT TIMERA -1
        RETURN
    ENDIF
    
    IS_INT_LVAR_GREATER_THAN_CONSTANT TIMERA -1
    RETURN

}

{
    robbery:
    SCRIPT_NAME ROBBERY

    LVAR_INT seller_char visible_area int_2 int_3 int_4 int_5 int_23 int_24 int_25 int_26 int_27 int_30 test
    LVAR_FLOAT player_offset[3] vector_0[3] vector_1[3] vector_2[3]

    robbery_init:
    WAIT 0 
    int_5 = 0 

    robbery_loop:
    WAIT 0 
    IF IS_PLAYER_PLAYING iPlayer
        IF flag_player_on_mission = 0 
            GET_AREA_VISIBLE visible_area 
            IF visible_area = 3 
            OR visible_area = 4 
            OR visible_area = 6 
            OR visible_area = 16 
            OR visible_area = 18 
                REQUEST_MODEL 349 
                REQUEST_ANIMATION "SHOP" 
                IF HAS_MODEL_LOADED 349 
                AND HAS_ANIMATION_LOADED "SHOP" 
                    GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hPlayerPed 0.0 0.0 0.0 (player_offset[0] player_offset[1] player_offset[2]) 
                    IF GET_RANDOM_CHAR_IN_SPHERE_NO_SAVE_RECURSIVE player_offset[0] player_offset[1] player_offset[2] 5.0 1 1 (seller_char) 
                        IF DOES_CHAR_EXIST seller_char 
                            IF IS_CHAR_MODEL seller_char 178 
                            OR IS_CHAR_MODEL seller_char 147 
                            OR IS_CHAR_MODEL seller_char 17 
                            OR IS_CHAR_MODEL seller_char 217 
                            OR IS_CHAR_MODEL seller_char 141 
                                IF LOCATE_CHAR_ANY_MEANS_CHAR_2D seller_char hPlayerPed 10.0 10.0 0 
                                    IF int_5 = 0 
                                        IF NOT IS_WANTED_LEVEL_GREATER iPlayer 0 
                                            IF NOT IS_CURRENT_CHAR_WEAPON hPlayerPed 0 
                                            AND NOT IS_CURRENT_CHAR_WEAPON hPlayerPed 1 
                                            AND NOT IS_CURRENT_CHAR_WEAPON hPlayerPed 2 
                                            AND NOT IS_CURRENT_CHAR_WEAPON hPlayerPed 3 
                                            AND NOT IS_CURRENT_CHAR_WEAPON hPlayerPed 4 
                                            AND NOT IS_CURRENT_CHAR_WEAPON hPlayerPed 5 
                                            AND NOT IS_CURRENT_CHAR_WEAPON hPlayerPed 6 
                                            AND NOT IS_CURRENT_CHAR_WEAPON hPlayerPed 7 
                                                IF NOT IS_CURRENT_CHAR_WEAPON hPlayerPed 8 
                                                AND NOT IS_CURRENT_CHAR_WEAPON hPlayerPed 10 
                                                AND NOT IS_CURRENT_CHAR_WEAPON hPlayerPed 11 
                                                AND NOT IS_CURRENT_CHAR_WEAPON hPlayerPed 12 
                                                AND NOT IS_CURRENT_CHAR_WEAPON hPlayerPed 13 
                                                AND NOT IS_CURRENT_CHAR_WEAPON hPlayerPed 14 
                                                AND NOT IS_CURRENT_CHAR_WEAPON hPlayerPed 15 
                                                AND NOT IS_CURRENT_CHAR_WEAPON hPlayerPed 46 
                                                    IF IS_PLAYER_TARGETTING_CHAR iPlayer seller_char 
                                                        TASK_SAY hPlayerPed 182 
                                                        TASK_PLAY_ANIM_NON_INTERRUPTABLE seller_char "SHP_ROB_REACT" "SHOP" 4.0 0 0 0 0 2320 
                                                        GENERATE_RANDOM_INT_IN_RANGE 1 3 int_2 
                                                        WAIT 1300 
                                                        TASK_SAY seller_char 118 
                                                        WAIT 1000 
                                                        
                                                        WAIT 0 
                                                        IF int_2 = 1 
                                                            IF IS_CHAR_HEALTH_GREATER seller_char 99 
                                                            AND NOT IS_CHAR_DEAD seller_char 
                                                                TASK_PLAY_ANIM_NON_INTERRUPTABLE seller_char "SHP_ROB_GIVECASH" "SHOP" 4.0 0 0 0 0 3600 
                                                                GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS seller_char 0.0  1.6 -0.6 (vector_0[0] vector_0[1] vector_0[2]) 
                                                                GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS seller_char 0.2  1.7 -0.6 (vector_1[0] vector_1[1] vector_1[2]) 
                                                                GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS seller_char -0.2 1.8 -0.6 (vector_2[0] vector_2[1] vector_2[2]) 
                                                                GENERATE_RANDOM_INT_IN_RANGE 167 1001 int_3 
                                                                GENERATE_RANDOM_INT_IN_RANGE 167 1001 int_26 
                                                                GENERATE_RANDOM_INT_IN_RANGE 166 1001 int_27 
                                                                CREATE_MONEY_PICKUP vector_0[0] vector_0[1] vector_0[2] int_3 0 int_23 
                                                                CREATE_MONEY_PICKUP vector_1[0] vector_1[1] vector_1[2] int_26 0 int_24 
                                                                CREATE_MONEY_PICKUP vector_2[0] vector_2[1] vector_2[2] int_27 0 int_25 
                                                                ADD_ONE_OFF_SOUND 0.0 0.0 0.0 1058 
                                                                TASK_SAY hPlayerPed 172 
                                                                WAIT 2000 
                                                            ENDIF
                                                        ELSE
                                                            IF int_2 = 2 
                                                        robbery_shoot:
                                                                IF NOT IS_CHAR_DEAD seller_char 
                                                                    TASK_SAY seller_char 118 
                                                                    GIVE_WEAPON_TO_CHAR seller_char 25 100 
                                                                    LOAD_CHAR_DECISION_MAKER 0 int_30 
                                                                    SET_CHAR_DECISION_MAKER seller_char int_30 
                                                                    TASK_KILL_CHAR_ON_FOOT seller_char hPlayerPed 
                                                                    MARK_MODEL_AS_NO_LONGER_NEEDED 349 
                                                                ENDIF 
                                                            ENDIF
                                                        ENDIF

                                                        int_5 = 1 
                                                        IF NOT IS_WANTED_LEVEL_GREATER iPlayer 1 
                                                            ALTER_WANTED_LEVEL iPlayer 2 
                                                        ENDIF

                                                        GOTO robbery_extarea_loop 
                                                    ENDIF
                                                ENDIF
                                            ENDIF
                                        ELSE
                                            GOTO robbery_shoot 
                                        ENDIF
                                    ELSE
                                        GOTO robbery_shoot 
                                    ENDIF
                                ELSE
                                    GOTO robbery_extarea_loop 
                                ENDIF
                            ENDIF
                        ENDIF
                    ENDIF
                ENDIF
            ENDIF
        ENDIF
    ENDIF
    GOTO robbery_loop

    robbery_extarea_loop:
    WAIT 0 
    GET_AREA_VISIBLE visible_area 
    IF visible_area = 0 
        REMOVE_ANIMATION "SHOP" 
        GENERATE_RANDOM_INT_IN_RANGE 1 3 int_4 
    ELSE
        GOTO robbery_extarea_loop
    ENDIF

    WAIT 0 
    IF int_4 = 2 
        GOTO robbery_loop
    ELSE
        IF int_4 = 1 
            GOTO robbery_init
        ENDIF
    ENDIF
}

{
    plane_camera:
    SCRIPT_NAME PLN_CAM

    LVAR_INT veh_handle model_id plane_health
    LVAR_FLOAT plane_rotation plane_lbb[3] plane_rtf[3]

    plane_camera_loop:
    WAIT 0 
    IF IS_PLAYER_PLAYING iPlayer 
        IF IS_CHAR_IN_ANY_PLANE hPlayerPed 
            STORE_CAR_CHAR_IS_IN_NO_SAVE hPlayerPed veh_handle 
            GOSUB get_plane_dimensions

            WHILE IS_CHAR_IN_ANY_PLANE hPlayerPed 
                WAIT 0 
                IF IS_PLAYER_PLAYING iPlayer 
                AND DOES_VEHICLE_EXIST veh_handle
                    GOSUB get_plane_angle 
                    ATTACH_CAMERA_TO_VEHICLE veh_handle 0.0 plane_lbb[1] plane_rtf[2] 0.0 0.0 0.0 plane_rotation 2 
                ENDIF
            ENDWHILE
            RESTORE_CAMERA 

        ENDIF
    ENDIF
    GOTO plane_camera_loop

    get_plane_dimensions:
    GET_CAR_MODEL veh_handle model_id 
    GET_MODEL_DIMENSIONS model_id (plane_lbb[0] plane_lbb[1] plane_lbb[2] plane_rtf[0] plane_rtf[1] plane_rtf[2])
    plane_lbb[1] *= 3.0 
    plane_rtf[2] *= 2.0 
    RETURN

    get_plane_angle:
    GET_CAR_ROLL veh_handle plane_rotation 
    plane_rotation *= -1.0 
    RETURN
}

{
    break_locked_car_glass:
    SCRIPT_NAME GLS_CAR

    CONST_FLOAT fVolume 1f

    LVAR_INT int_15 int_16 int_17 hTargetVehicle pTargetVehicle i int_29 int_30 int_31 fxSystem hPossibleCopPed iAlarmPlaying iDoorLock
    LVAR_FLOAT player_offset[3] v3dTempCoords[3] v3dPedArmCoords[3] fLeftDoorAngle fRightDoorAngle float_0 float_1 float_4

    LVAR_TEXT_LABEL16 sBreakWindowAnim

    gls_car_main_loop:
        WAIT 0
        IF IS_PLAYER_PLAYING iPlayer
            IF flag_player_on_mission = 0
            AND NOT HAS_CHAR_BEEN_ARRESTED hPlayerPed
            AND NOT IS_CHAR_DEAD hPlayerPed
            AND NOT IS_CHAR_SITTING_IN_ANY_CAR hPlayerPed
                int_15 = 0
                int_16 = 0
                int_17 = 0

                GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hPlayerPed 0.0 0.0 0.0 (player_offset[0] player_offset[1] player_offset[2])
                IF GET_RANDOM_CAR_IN_SPHERE_NO_SAVE_RECURSIVE player_offset[0] player_offset[1] player_offset[2] 6f 1 1 (hTargetVehicle)
                    GET_VEHICLE_POINTER hTargetVehicle (pTargetVehicle)
                    GET_CAR_DOOR_LOCK_STATUS hTargetVehicle (iDoorLock)
                    IF iDoorLock = CARLOCK_LOCKED
                        GET_DOOR_ANGLE_RATIO hTargetVehicle 2 (fLeftDoorAngle)
                        GET_DOOR_ANGLE_RATIO hTargetVehicle 3 (fRightDoorAngle)

                        IF fLeftDoorAngle = 0f
                        AND fRightDoorAngle = 0f
                        AND NOT IS_CAR_DEAD hTargetVehicle
                        AND NOT IS_CAR_UPSIDEDOWN hTargetVehicle
                        AND NOT IS_CAR_IN_WATER hTargetVehicle
                        AND NOT IS_CAR_ON_FIRE hTargetVehicle
                            GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hPlayerPed 0.0 0.0 -1.0 (player_offset[0] player_offset[1] player_offset[2])
                            GET_CAR_DUMMY_COORD hTargetVehicle VEHICLE_DUMMY_PED_FRONTSEAT TRUE TRUE (v3dTempCoords[0] v3dTempCoords[1] v3dTempCoords[2])
                            v3dTempCoords[2] -= player_offset[2]

                            IF v3dTempCoords[2] < 1.5
                                IF IS_CHAR_PLAYING_ANIM hPlayerPed "CAR_doorlocked_LHS"
                                    int_31 = 10 // door L for windows 0D33 
                                    int_30 = 2 // door L for angle door
                                    int_29 = 0 // for 10 dummy "ped_arm" left

                                    GOTO gls_car_start
                                ENDIF
                                IF IS_CHAR_PLAYING_ANIM hPlayerPed "CAR_doorlocked_RHS"
                                    int_31 = 8 // door L for windows 0D33 
                                    int_30 = 3 // door L for angle door
                                    int_29 = 1 // for 10 dummy "ped_arm" left

                                    GOTO gls_car_start
                                ENDIF
                            ENDIF
                        ENDIF
                    ENDIF
                ENDIF
            ELSE
                IF IS_CHAR_SITTING_IN_ANY_CAR hPlayerPed
                AND iAlarmPlaying = TRUE
                AND TIMERB > 15000
                    GET_CAR_CHAR_IS_USING hPlayerPed (hTargetVehicle)
                    SET_CAR_ALARM hTargetVehicle CAR_ALARM_OFF
                    iAlarmPlaying = FALSE
                ENDIF
            ENDIF
        ENDIF
    GOTO gls_car_main_loop

    gls_car_start:
    GET_CHAR_ANIM_CURRENT_TIME hPlayerPed "CAR_doorlocked_LHS" (float_0)
    GET_CHAR_ANIM_CURRENT_TIME hPlayerPed "CAR_doorlocked_RHS" (float_1)

    IF float_0 >= 0.8
    OR float_1 >= 0.8
        IF NOT IS_BUTTON_PRESSED PAD1 LEFTSTICKX
        AND NOT IS_BUTTON_PRESSED PAD1 LEFTSTICKY
            REQUEST_ANIMATION "WINDOWS"
            WHILE NOT HAS_ANIMATION_LOADED "WINDOWS"
                WAIT 0
                REQUEST_ANIMATION "WINDOWS"
            ENDWHILE

            HIDE_CHAR_WEAPON_FOR_SCRIPTED_CUTSCENE hPlayerPed TRUE
            SET_PLAYER_CONTROL iPlayer FALSE
            GET_CAR_DUMMY_COORD hTargetVehicle VEHICLE_DUMMY_PED_ARM TRUE int_29 (v3dPedArmCoords[0] v3dPedArmCoords[1] v3dPedArmCoords[2])
            GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hPlayerPed 0.0 0.0 -1.0 (player_offset[0] player_offset[1] player_offset[2])
            GET_CAR_DUMMY_COORD hTargetVehicle VEHICLE_DUMMY_PED_FRONTSEAT TRUE TRUE (v3dTempCoords[0] v3dTempCoords[1] v3dTempCoords[2])
            v3dTempCoords[2] -= player_offset[2]

            IF IS_CHAR_PLAYING_ANIM hPlayerPed "CAR_doorlocked_LHS"
            AND v3dTempCoords[2] > 0.9
            AND v3dTempCoords[2] < 1.5
                sBreakWindowAnim = "WindowLeft_H"
            ENDIF
            IF IS_CHAR_PLAYING_ANIM hPlayerPed "CAR_doorlocked_RHS"
            AND v3dTempCoords[2] > 0.9
            AND v3dTempCoords[2] < 1.5
                sBreakWindowAnim = "WindowRight_H"
            ENDIF
            IF IS_CHAR_PLAYING_ANIM hPlayerPed "CAR_doorlocked_LHS"
            AND v3dTempCoords[2] < 0.4
                sBreakWindowAnim = "WindowLeft_L"
            ENDIF
            IF IS_CHAR_PLAYING_ANIM hPlayerPed "CAR_doorlocked_RHS"
            AND v3dTempCoords[2] < 0.4
                sBreakWindowAnim = "WindowRight_L"
            ENDIF
            IF IS_CHAR_PLAYING_ANIM hPlayerPed "CAR_doorlocked_LHS"
            AND v3dTempCoords[2] < 0.9
            AND v3dTempCoords[2] > 0.4
                sBreakWindowAnim = "WindowLeft"
            ENDIF
            IF IS_CHAR_PLAYING_ANIM hPlayerPed "CAR_doorlocked_RHS"
            AND v3dTempCoords[2] < 0.9
            AND v3dTempCoords[2] > 0.4
                sBreakWindowAnim = "WindowRight"
            ENDIF

            TASK_PLAY_ANIM_NON_INTERRUPTABLE hPlayerPed $sBreakWindowAnim "WINDOWS" 4.0 FALSE FALSE FALSE FALSE -1
            TIMERA = 0

            int_15 = 0
            
            CREATE_FX_SYSTEM "prt_glass" player_offset[0] player_offset[1] player_offset[2] 1 (fxSystem)
            //PLAY_FX_SYSTEM fxSystem

            gls_car_unlock_loop:
                WAIT 0
                GET_CHAR_ANIM_CURRENT_TIME hPlayerPed $sBreakWindowAnim (float_4) 

                IF int_15 = 0
                AND float_4 > 0.4
                    int_15 = 1
                    SET_CAR_DOOR_WINDOW_STATE hTargetVehicle int_31 TRUE
                    GENERATE_RANDOM_INT_IN_RANGE 1 4 (i)

                    CALL_FUNCTION 0x321700 1 0 (pTargetVehicle) // Glass effect

                    IF i = 1
                        SET_CAR_ALARM hTargetVehicle CAR_ALARM_PLAYING
                        TIMERB = 0
                        iAlarmPlaying = TRUE
                    ENDIF
                ENDIF

                IF int_15 = 1
                float_4 > 0.7
                    int_15 = 2
                    OPEN_CAR_DOOR_A_BIT hTargetVehicle int_30 0.1
                    LOCK_CAR_DOORS hTargetVehicle CARLOCK_UNLOCKED
                    TASK_ENTER_CAR_AS_DRIVER hPlayerPed hTargetVehicle -2
                    GOTO gls_car_terminate_lock
                ENDIF

                IF TIMERA > 1000
                    IF IS_CHAR_DEAD hPlayerPed
                    OR NOT IS_CHAR_PLAYING_ANIM hPlayerPed $sBreakWindowAnim
                    OR HAS_CHAR_BEEN_ARRESTED hPlayerPed
                        GOTO gls_car_terminate_lock
                    ENDIF
                ENDIF

                GET_CHAR_COORDINATES hPlayerPed (player_offset[0] player_offset[1] player_offset[2])

                IF int_15 = 1
                AND GET_RANDOM_CHAR_IN_SPHERE_NO_SAVE_RECURSIVE player_offset[0] player_offset[1] player_offset[2] 25.0 TRUE TRUE (hPossibleCopPed)
                    GET_PED_TYPE hPossibleCopPed (i)

                    IF i = 6
                        ALTER_WANTED_LEVEL_NO_DROP hPlayerPed 1
                    ENDIF
                ENDIF
            GOTO gls_car_unlock_loop

        ENDIF
    ENDIF

    gls_car_terminate_lock:
    REMOVE_ANIMATION "WINDOWS"
    HIDE_CHAR_WEAPON_FOR_SCRIPTED_CUTSCENE hPlayerPed FALSE
    KILL_FX_SYSTEM fxSystem
    SET_PLAYER_CONTROL iPlayer TRUE
    WAIT 500
    GOTO gls_car_main_loop

}

{
    manual_driveby:
    SCRIPT_NAME MNDRVBY

    LVAR_INT driveby_control_type restore_camera_after player_veh passenger_handle[3] player_ped weapon_type weapon_ammo weapon_model max_passengers
    LVAR_INT aim_button_state fire_button_state switch_button_state
    LVAR_INT i j k

    CONST_INT PADMEM_LEFTSTICKX 0x700B40       //<L3>
    CONST_INT PADMEM_LEFTSTICKY 0x700B42       //L3^
    CONST_INT PADMEM_RIGHTSTICKX 0x700B44      //<R3>
    CONST_INT PADMEM_RIGHTSTICKY 0x700B46      //R3^
    CONST_INT PADMEM_LEFTSHOULDER1 0x700B48    //L1
    CONST_INT PADMEM_LEFTSHOULDER2 0x700B4A    //L2
    CONST_INT PADMEM_RIGHTSHOULDER1 0x700B4C   //R1
    CONST_INT PADMEM_RIGHTSHOULDER2 0x700B4E   //R2
    CONST_INT PADMEM_DPADUP 0x700B50           //UP
    CONST_INT PADMEM_DPADDOWN 0x700B52         //DOWN
    CONST_INT PADMEM_DPADLEFT 0x700B54        //LEFT
    CONST_INT PADMEM_DPADRIGHT 0x700B56       //RIGHT
    CONST_INT PADMEM_START 0x700B58           //START
    CONST_INT PADMEM_SELECT 0x700B5A          //SELECT
    CONST_INT PADMEM_SQUARE 0x700B5C          //X
    CONST_INT PADMEM_TRIANGLE 0x700B5E        //Y
    CONST_INT PADMEM_CROSS 0x700B60           //A
    CONST_INT PADMEM_CIRCLE 0x700B62          //B
    CONST_INT PADMEM_LEFTSHOCK 0x700B64       //LS
    CONST_INT PADMEM_RIGHTSHOCK 0x700B66      //RS
    CONST_INT PADMEM_GUIDE 0x700B68           //Guide

    // driveby camera movement
    WRITE_MEMORY 0x438E78 4 0x00000000 TRUE
    WRITE_MEMORY 0x438E7C 4 0x00000000 TRUE

    /* auto switch to smg
    WRITE_MEMORY 0x64DB49 4 0x90909090 TRUE
    WRITE_MEMORY 0x64DB4D 4 0x90909090 TRUE
    WRITE_MEMORY 0x64DB51 1 0x90 TRUE */ 

    WRITE_MEMORY 0x205DCC 4 0x00000000 TRUE  //camera zoom   

    driveby_control_type = 0
    restore_camera_after = 1

    WHILE NOT IS_PC_VERSION
        WAIT 0
        IF IS_CHAR_IN_ANY_CAR hPlayerPed
        AND NOT IS_CHAR_IN_FLYING_VEHICLE hPlayerPed
        AND NOT IS_CHAR_IN_ANY_BOAT hPlayerPed 
        AND NOT IS_CHAR_IN_MODEL hPlayerPed RHINO
        AND NOT IS_CHAR_IN_MODEL hPlayerPed FIRETRUK
        AND NOT IS_CHAR_IN_MODEL hPlayerPed SWATVAN 
        AND NOT IS_PLAYER_IN_REMOTE_MODE iPlayer
            GET_CAR_CHAR_IS_USING hPlayerPed player_veh 

            GET_MAXIMUM_NUMBER_OF_PASSENGERS player_veh max_passengers

            k = 0
            WHILE k < max_passengers
			    IF NOT IS_CAR_PASSENGER_SEAT_FREE player_veh k
			     	GET_CHAR_IN_CAR_PASSENGER_SEAT player_veh k (passenger_handle[k])  
			    ENDIF
                 
                k++
            ENDWHILE

            GET_PED_POINTER hPlayerPed (player_ped)
            i = player_ped + 0x758 //m_nActiveWeaponSlot
            READ_MEMORY i 1 TRUE (i)

            i += 1
    	    GET_CHAR_WEAPON_IN_SLOT hPlayerPed i weapon_type weapon_ammo weapon_model

            IF i = 1
    		    WRITE_MEMORY 0x20266C 4 0x10400011 TRUE   //disable CPad::GetLookLeft(void)
                WRITE_MEMORY 0x2026C4 4 0x10400012 TRUE   //disable CPad::GetLookRight(void)
            ELSE
    		    WRITE_MEMORY 0x20266C 4 0x00000000 TRUE   //disable CPad::GetLookLeft(void)
                WRITE_MEMORY 0x2026C4 4 0x00000000 TRUE   //disable CPad::GetLookRight(void)
            ENDIF

            IF NOT hPlayerPed = passenger_handle[0]
            AND NOT hPlayerPed = passenger_handle[1]
            AND NOT hPlayerPed = passenger_handle[2]
                READ_MEMORY PADMEM_LEFTSHOULDER1 2 TRUE (aim_button_state)
    	        IF NOT aim_button_state = 0
                    GET_PED_POINTER hPlayerPed (player_ped)
                    i = player_ped + 0x758 //m_nActiveWeaponSlot
                    READ_MEMORY i 1 TRUE (i)

                    i += 1
    	            GET_CHAR_WEAPON_IN_SLOT hPlayerPed i weapon_type weapon_ammo weapon_model

    	            READ_MEMORY PADMEM_RIGHTSHOULDER1 2 TRUE (fire_button_state)

    				IF weapon_ammo > 0
    				AND fire_button_state = 0
    				AND i > 2
    				AND i < 7
    				    WRITE_MEMORY 0x204E40 4 0x1000002A TRUE
    				    TASK_DRIVE_BY hPlayerPed -1 -1 0f 0f 0f 900.0 4 0 100

                        WRITE_MEMORY 0x249C6C 4 0x8642000C TRUE
                        WRITE_MEMORY 0x249C70 4 0x8643000C TRUE

    					WHILE NOT IS_PC_VERSION
    					    WAIT 0
    					    READ_MEMORY PADMEM_LEFTSHOULDER1 2 TRUE (aim_button_state)

    						IF aim_button_state = 0
                                WRITE_MEMORY 0x249C6C 4 0x8642000E TRUE
                                WRITE_MEMORY 0x249C70 4 0x8643000E TRUE
    							BREAK
    						ENDIF
    
    						GOSUB weaponswitch
    
                            GET_PED_POINTER hPlayerPed (player_ped)
                            i = player_ped + 0x758 //m_nActiveWeaponSlot
                            READ_MEMORY i 1 TRUE (i)

      			            i += 1
    				        GET_CHAR_WEAPON_IN_SLOT hPlayerPed i weapon_type weapon_ammo weapon_model

                            IF weapon_ammo <= 0
                                BREAK
                            ENDIF
    
    						//IF NOT aim_button_state = 0
    						//	IF driveby_control_type = 0
    						//	    //WRITE_MEMORY PADMEM_CIRCLE 2 0xFF TRUE 
                            //        // patch=0,EE,20249C6C,extended,8642000E //Set fire to R2
                            //        // patch=0,EE,20249C70,extended,8643000E //Set fire to R2
    						//	ELSE
    						//	    READ_MEMORY PADMEM_RIGHTSHOULDER1 2 TRUE (fire_button_state)
    						//		IF fire_button_state = 0
    						//		    //WRITE_MEMORY PADMEM_CIRCLE 2 0xFF TRUE
    						//		ENDIF
    						//	ENDIF
    						//ENDIF
    					ENDWHILE

    					CLEAR_CHAR_TASKS hPlayerPed
    				    WRITE_MEMORY 0x204E40 4 0x82440758 TRUE

    				    IF NOT restore_camera_after = 0
                            RESTORE_CAMERA_JUMPCUT
    					ENDIF
                    ENDIF
    		    ENDIF			    
                GOSUB weaponswitch
            ENDIF 
        ENDIF
    ENDWHILE


    weaponswitch:
    READ_MEMORY PADMEM_SQUARE 2 TRUE (switch_button_state)
    IF NOT switch_button_state = 0
        GET_PED_POINTER hPlayerPed (player_ped)
        j = player_ped + 0x758 //m_nActiveWeaponSlot
        READ_MEMORY j 1 TRUE (j)
        j += 1

        k = 1
        WHILE k < 7
            j += 1
            IF j >= 7
                j = 1
            ENDIF
            IF j = 2
                j = 3
            ENDIF
            GET_CHAR_WEAPON_IN_SLOT hPlayerPed j weapon_type weapon_ammo weapon_model
            IF j = 1
            OR weapon_ammo > 0
                READ_MEMORY PADMEM_LEFTSHOULDER1 2 TRUE (aim_button_state)
                IF j = 1
                AND NOT aim_button_state = 0
                    CONTINUE
                ENDIF
                GET_PED_POINTER hPlayerPed (player_ped)
                CALL_METHOD 0x1993B0 player_ped 1 0 weapon_type // CPed::SetCurrentWeapon(eWeaponType)
                BREAK
            ENDIF

            k++    
        ENDWHILE

        WHILE NOT IS_PC_VERSION
            WAIT 0
            READ_MEMORY PADMEM_SQUARE 2 TRUE (switch_button_state)
            IF switch_button_state = 0
                BREAK
            ENDIF
        ENDWHILE
    ENDIF
    RETURN
}

{
    rpg_backview:
    SCRIPT_NAME RPGBCKV

    VAR_INT tmp_int1

    LVAR_INT int_0 int_2 int_3
    LVAR_FLOAT float_4 float_5 float_6 float_7 float_8 float_9 float_10 float_11 float_12 float_13 float_14 
    LVAR_FLOAT float_15 float_16 float_19 float_21 float_22 float_23 float_27 float_28 float_29 float_30 float_31

    LVAR_INT vecUnknownPtr vecOutputPtr vecInputPtr

    LVAR_FLOAT distance player_cam_x player_cam_y player_cam_z

    rpg_backview_init:
    TIMERA = 0 

    rpg_backview_loop:
    WAIT 0 
    IF IS_PLAYER_PLAYING iPlayer 
    	IF IS_CURRENT_CHAR_WEAPON hPlayerPed WEAPONTYPE_ROCKETLAUNCHER 
            IVSTYLE_126:
    		WAIT 0 
    		IF IS_PLAYER_PLAYING iPlayer 
    			IF IS_CURRENT_CHAR_WEAPON hPlayerPed WEAPONTYPE_ROCKETLAUNCHER
    				IF IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER2
    				AND TIMERA > 1000 
    					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 1131 
    					TIMERA = 0 

    					REQUEST_MODEL 345 
                        REQUEST_MODEL 1598 
                        int_0 = 22 
                        int_0 *= 0x70 
                        int_0 += 0x6882B0 
                        int_0 += 8 
                        READ_MEMORY int_0 4 0 (distance) 
                        GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hPlayerPed -0.2 0.0 0.4 (player_cam_x player_cam_y player_cam_z) 

                        GET_VAR_POINTER player_cam_x (vecInputPtr)
                        GET_VAR_POINTER float_4 (vecUnknownPtr)
                        GET_VAR_POINTER float_7 (vecOutputPtr)

                        CALL_METHOD 0x21AA90 0x6FE530 4 0 vecInputPtr vecUnknownPtr vecOutputPtr 55.0 
                        // CCamera::Find3rdPersonCamTargetVector(CCamera *this, float dist, float posX, float posY, float posZ, RwV3d *unkVec, RwV3d *output)

                        WAIT 0 
                        float_31 = float_9 
                        float_30 = 350.0 
                        float_30 += float_31 
                        float_31 /= 5.0 

                        WHILE NOT HAS_MODEL_LOADED 345 
                        AND NOT HAS_MODEL_LOADED 1598 
                        	WAIT 0
                        ENDWHILE 

                        GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hPlayerPed 0.2 5.0 0.4 float_11 float_12 float_13 
                        float_27 = float_13 
                        float_28 = float_11 
                        float_29 = float_12 
                        float_11 -= float_7 
                        float_12 -= float_8 
                        GET_HEADING_FROM_VECTOR_2D float_11 float_12 float_19 
                        float_9 -= float_13 
                        float_14 = float_9 
                        float_30 = float_14 
                        float_30 *= 10.0 
                        IF 0.0 > float_14 
                        	float_14 /= -2.0 
                        	float_14 -= 0.7 
                        	float_30 = 350.0 
                        	float_31 *= 10.0 
                        	float_30 += float_31 
                        	float_31 /= 10.0 
                        ELSE
                        	float_14 /= 10.0 
                        	float_14 += 1.1 
                        ENDIF

                        float_31 *= 2.0 
                        CREATE_OBJECT 1598 float_28 float_29 float_27 int_2 
                        SET_OBJECT_VISIBLE int_2 0 
                        SET_OBJECT_RECORDS_COLLISIONS int_2 1 
                        SET_OBJECT_COLLISION int_2 1 
                        SET_OBJECT_MASS int_2 100.0 
                        SET_OBJECT_TURN_MASS int_2 100.0 
                        CREATE_OBJECT 345 float_28 float_29 500.0 tmp_int1 
                        ATTACH_OBJECT_TO_OBJECT tmp_int1 int_2 0.0 1.0 0.0 float_30 0.0 180.0 
                        SET_OBJECT_COLLISION tmp_int1 0 
                        SET_OBJECT_HEADING int_2 float_19 
                        float_9 *= float_14 
                        float_10 = 80.1 
                        SIN float_19 float_15 
                        COS float_19 float_16 
                        float_15 *= float_10 
                        float_16 *= float_10 
                        float_15 *= -1.0 
                        SET_OBJECT_DYNAMIC int_2 1 
                        SET_OBJECT_VELOCITY int_2 float_15 float_16 float_9 
                        TIMERB = 0 
                        float_15 *= -1.0 
                        float_16 *= -1.0 

                        CNROCKM_672:
                        WAIT 0 
                        IF IS_PLAYER_PLAYING iPlayer 
                        	GET_OFFSET_FROM_OBJECT_IN_WORLD_COORDS int_2 0.0 0.0 0.0 float_21 float_22 float_23 
                        	ADD_SMOKE_PARTICLE float_21 float_22 float_23 0.0 0.0 0.0 1.0 1.0 1.0 1.0 0.2 0.1 
                        	SET_OBJECT_VELOCITY int_2 float_15 float_16 float_9 
                        	GET_OBJECT_COORDINATES int_2 float_11 float_12 float_13 
                        	IF HAS_OBJECT_COLLIDED_WITH_ANYTHING int_2 
                        	OR NOT LOCATE_CHAR_ANY_MEANS_OBJECT_3D hPlayerPed int_2 200.0 200.0 100.0 0 
                        	OR TIMERB > 7000 
                        		ADD_EXPLOSION float_11 float_12 float_13 12 
                        		ADD_EXPLOSION_NO_SOUND float_11 float_12 float_13 12 
                        		WAIT 0 
                        		ADD_EXPLOSION float_11 float_12 float_13 3 
                        		ADD_EXPLOSION_NO_SOUND float_11 float_12 float_13 3 
                        		WAIT 50 
                        		ADD_EXPLOSION float_11 float_12 float_13 3 
                        		ADD_EXPLOSION_NO_SOUND float_11 float_12 float_13 3 
                        	ELSE
                        		GOTO CNROCKM_672
                        	ENDIF
                        ENDIF

                        DELETE_OBJECT int_2 
                        DELETE_OBJECT tmp_int1 
                        MARK_MODEL_AS_NO_LONGER_NEEDED 345 
                        MARK_MODEL_AS_NO_LONGER_NEEDED 1598
                        
    				ENDIF
    				GOTO IVSTYLE_126
    			ENDIF
    		ENDIF
            
    	ENDIF
    ENDIF
    GOTO rpg_backview_loop 
}

{
    first_person_vehicle_camera:
    SCRIPT_NAME FPV_CAM

    LVAR_INT car objeto i2 cammode ativador modelo ivelocidade bancos teste cheat marca bMotion
    LVAR_FLOAT giro_y fvelocidade altura[2] esq_dir[2] frente_tras[2] x y z a b c 

    //write_memory 0x0052A50A 1 0 1

    loop1:
    WAIT 0

    READ_MEMORY 0x6FE6B0 2 0 cammode
    IF IS_CHAR_SITTING_IN_ANY_CAR hPlayerPed
        STORE_CAR_CHAR_IS_IN_NO_SAVE hPlayerPed car
    	GET_CAR_MODEL car modelo

        IF modelo = 532
        OR modelo = 592
        OR modelo = 601
            WHILE IS_CHAR_IN_MODEL hPlayerPed modelo
                WAIT 0
            ENDWHILE
            GOTO loop1
        ENDIF

        altura[0] = 0.622

        GET_MAXIMUM_NUMBER_OF_PASSENGERS car bancos
        IF bancos = 0
        OR IS_CHAR_IN_ANY_PLANE hPlayerPed
        OR IS_CHAR_IN_ANY_HELI hPlayerPed
        OR IS_CHAR_ON_ANY_BIKE hPlayerPed
            esq_dir[0] = 0.0
        ELSE
            esq_dir[0] = 0.075
        ENDIF

        frente_tras[0] = -0.35

        //destino
        GET_MODEL_DIMENSIONS modelo x y z a b c
        c *= 1.8

        altura[1] = 0.448

        GET_MAXIMUM_NUMBER_OF_PASSENGERS car bancos
        IF bancos = 0
        OR IS_CHAR_IN_ANY_PLANE hPlayerPed
        OR IS_CHAR_IN_ANY_HELI hPlayerPed
        OR IS_CHAR_ON_ANY_BIKE hPlayerPed
            esq_dir[1] = 0.0
        ELSE
            esq_dir[1] = -0.266
        ENDIF

        frente_tras[1] = c

        //altura[0] -= 100.0

        GET_MAXIMUM_NUMBER_OF_PASSENGERS car bancos
        IF bancos = 0
        OR IS_CHAR_IN_ANY_PLANE hPlayerPed
        OR IS_CHAR_IN_ANY_HELI hPlayerPed
            esq_dir[0] = 0.0
        ENDIF

        WHILE IS_CHAR_SITTING_IN_CAR hPlayerPed car
            IF cammode = 16
            OR cammode = 47
                IF NOT DOES_CHAR_EXIST i2
                    GOSUB criar_char
                ENDIF
                GOSUB grudar_char
                GET_CAR_SPEED car fvelocidade
                fvelocidade *= 3.6
                fvelocidade /= 15.0
                ivelocidade =# fvelocidade
                SET_PLAYER_DRUNKENNESS iPlayer ivelocidade
                //IF IS_BUTTON_PRESSED PAD1 LEFTSHOULDER2
                //OR IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER2
                //    IF NOT IS_CHAR_IN_ANY_PLANE hPlayerPed
                //    AND NOT IS_CHAR_IN_ANY_HELI hPlayerPed
                //        WRITE_MEMORY 0x6FE6B0 2 18 0
                //        RESTORE_CAMERA_JUMPCUT
                //        RESTORE_CAMERA
                //        DETACH_CHAR_FROM_CAR i2
                //        SET_PLAYER_DRUNKENNESS 0 0
                //        WHILE IS_BUTTON_PRESSED PAD1 LEFTSHOULDER2
                //        OR IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER2
                //            WAIT 0
                //        ENDWHILE
                //    ENDIF
                //ENDIF

                IF IS_BUTTON_PRESSED PAD1 SELECT
                    WHILE IS_BUTTON_PRESSED PAD1 SELECT
                        WAIT 0
                    ENDWHILE
                    WRITE_MEMORY 0x6FE6B0 2 18 0
                    RESTORE_CAMERA_JUMPCUT
                    RESTORE_CAMERA
                ENDIF
            ELSE            
                READ_MEMORY 0x66CB0C 4 TRUE (bMotion)
                IF bMotion = 1
                    WRITE_MEMORY 0x66CB0C 4 0 TRUE
                ENDIF
                //SET_PLAYER_DRUNKENNESS 0 0
                IF DOES_CHAR_EXIST i2
                    DELETE_CHAR i2
                ENDIF
            ENDIF
            READ_MEMORY 0x6FE6B0 2 0 cammode
            WAIT 0
        ENDWHILE
        SET_PLAYER_DRUNKENNESS 0 0
        WRITE_MEMORY 0x6FE6B0 2 18 0
        WHILE IS_CHAR_IN_ANY_CAR hPlayerPed//timera < 500
            WAIT 0
            RESTORE_CAMERA
            SET_CAMERA_BEHIND_PLAYER
            RESTORE_CAMERA_JUMPCUT
        ENDWHILE
        IF DOES_CHAR_EXIST i2
            DETACH_CHAR_FROM_CAR i2
            DELETE_CHAR i2
        ENDIF
    ENDIF

    GOTO loop1

    grudar_char:
        GET_CAR_ROLL car giro_y
        giro_y *= -1.0
        ATTACH_CHAR_TO_CAR i2 car esq_dir[1] frente_tras[1] altura[1] 0 0.0 0
        ATTACH_CAMERA_TO_CHAR_LOOK_AT_CHAR hPlayerPed esq_dir[0] frente_tras[0] altura[0] i2 giro_y 2
    RETURN

    criar_char:
        CREATE_RANDOM_CHAR 0.0 0.0 0.0 i2
        SET_CHAR_PROOFS i2 1 1 1 1 1
        SET_CHAR_ONLY_DAMAGED_BY_PLAYER i2 TRUE
        SET_CHAR_VISIBLE i2 FALSE
        DISABLE_CHAR_SPEECH i2 TRUE
        SET_CHAR_NEVER_TARGETTED i2 TRUE
        SET_CHAR_COLLISION i2 FALSE
        //ADD_BLIP_FOR_CHAR i2 marca
    RETURN
}

{
    car_crash_inertia:
    SCRIPT_NAME CCINERT
    LVAR_INT hVeh pVeh p iSubClass pFrame iModel vPos hEffect bWindowPresent iDamage hPassenger
    LVAR_FLOAT fSpeed x y z f dir_x dir_y dir_z fIntensity

    LVAR_INT iPanel // In
    LVAR_INT pDamageManager iPanelStatus

    LVAR_INT i

    LVAR_FLOAT g back front side car_x car_y car_z

    CONST_INT m_vLastDamageDirection    0xE0
    CONST_INT m_vLastDamagePoint        0xEC
    CONST_INT m_nLastDamagePart         0xF8
    CONST_INT m_fLastDamageIntensity    0xD8

    CONST_INT DamageManager     0x5E0
    CONST_INT GetPanelStatus    0x162560

    CONST_INT GetFrameFromId    0x28B2D0
    CONST_INT RpClump           0x18
    CONST_INT SubClass          0x5D0

    CONST_INT SUBCLASS_AUTOMOBILE 0 
    CONST_INT SUBCLASS_MTRUCK     1 
    CONST_INT SUBCLASS_QUAD       2 
    CONST_INT SUBCLASS_HELI       3 
    CONST_INT SUBCLASS_PLANE      4 
    CONST_INT SUBCLASS_BOAT       5 
    CONST_INT SUBCLASS_TRAIN      6 
    CONST_INT SUBCLASS_FHELI      7 
    CONST_INT SUBCLASS_FPLANE     8 
    CONST_INT SUBCLASS_BIKE       9 
    CONST_INT SUBCLASS_BMX        10
    CONST_INT SUBCLASS_TRAILER    11 

/////////////////////////////////////////////

    CONST_FLOAT fImpactDamageHealth 0.5
    CONST_FLOAT fThrowDamageHealth 1.0
    CONST_FLOAT fGlassDamageBonus 1.5

    CONST_FLOAT fMinIntensity        800.0
    CONST_FLOAT fMaxMass             3700.0
    CONST_FLOAT fDivStartInertia     3.0
    CONST_FLOAT fInertiaEaseOut      0.2

/////////////////////////////////////////////

    WHILE NOT IS_PC_VERSION
        WAIT 0

        IF IS_CHAR_SITTING_IN_ANY_CAR hPlayerPed

            STORE_CAR_CHAR_IS_IN_NO_SAVE hPlayerPed (hVeh)

            GOSUB GetCarCollisionIntensity

            IF fIntensity > 0.0

                GET_CAR_MODEL hVeh (iModel)
                IF NOT iModel = RHINO
                    
                    GET_NUMBER_OF_PASSENGERS hVeh (p)
                    IF p > 0
                        GET_CHAR_IN_CAR_PASSENGER_SEAT hVeh 0 (hPassenger)
                        IF NOT hPassenger > 0
                            hPassenger = -1
                        ENDIF
                    ELSE
                        hPassenger = -1
                    ENDIF

                    GET_VEHICLE_POINTER hVeh (pVeh)
                    iSubClass = pVeh + SubClass
                    READ_MEMORY iSubClass 4 FALSE (iSubClass)

                    f = fIntensity / 100.0
                    f *= fImpactDamageHealth

                    IF NOT iSubClass = SUBCLASS_AUTOMOBILE
                        f /= 2.0
                        IF iSubClass = SUBCLASS_HELI
                        OR iSubClass = SUBCLASS_PLANE
                            f /= 2.0
                        ENDIF
                    ENDIF

                    iDamage =# f
                    IF iDamage > 0
                        DAMAGE_CHAR hPlayerPed iDamage FALSE
                        IF hPassenger > 0
                            DAMAGE_CHAR hPassenger iDamage FALSE
                        ENDIF
                    ENDIF

                    IF fIntensity > fMinIntensity

                        IF iSubClass = SUBCLASS_AUTOMOBILE
                        OR iSubClass = SUBCLASS_MTRUCK
                            GET_CAR_MASS hVeh (f)

                            IF f <= fMaxMass

                                IF GOSUB IsCarCollisionFrontDirection
                                    
                                    p = pVeh + RpClump
                                    READ_MEMORY p 4 FALSE (p)

                                    //int __cdecl CClumpModelInfo::GetFrameFromId(RpClump *clump, int id)
                                    CALL_FUNCTION_RETURN GetFrameFromId 2 0 (p 18)(pFrame)
                                    IF pFrame > 0 // Has windows

                                        /*
                                        vPos = pFrame + 0x40 //modelling.pos
                                        READ_MEMORY vPos 4 FALSE (x)
                                        vPos += 0x4
                                        READ_MEMORY vPos 4 FALSE (y)
                                        vPos += 0x4
                                        READ_MEMORY vPos 4 FALSE (z)
                                        */
                                        iPanel = 4
                                        IF GOSUB IsPanelPresent
                                            CALL_FUNCTION 0x321700 1 1 (pVeh) // Glass effect
                                            POP_CAR_PANEL hVeh 4 OFF

                                            bWindowPresent = TRUE
                                        ELSE
                                            bWindowPresent = FALSE
                                        ENDIF
                                    ENDIF

                                    f = fIntensity / 100.0
                                    f *= fThrowDamageHealth
                                    IF bWindowPresent = TRUE
                                        f *= fGlassDamageBonus
                                    ENDIF
                                    iDamage =# f
                                    IF iDamage > 0
                                        DAMAGE_CHAR hPlayerPed iDamage FALSE
                                        IF hPassenger > 0
                                            DAMAGE_CHAR hPassenger iDamage FALSE
                                        ENDIF
                                    ENDIF

                                    //GET_MODEL_DIMENSIONS iModel (f fBack f, f fFront f)
                                    //IF fBack > fFront
                                    //    fFront = fBack
                                    //ENDIF
                                
                                    GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hPlayerPed (0.0 1.0 1.0) (x y z)
                                    WARP_CHAR_FROM_CAR_TO_COORD hPlayerPed (x y z)
                                    IF hPassenger > 0
                                        GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hPassenger (0.0 1.0 1.0) (x y z)
                                        WARP_CHAR_FROM_CAR_TO_COORD hPassenger (x y z)
                                    ENDIF
                                    
                                    // Simple inertia
                                    TASK_PLAY_ANIM_NON_INTERRUPTABLE hPlayerPed FALL_FRONT PED 4.0 FALSE FALSE FALSE FALSE 1000
                                    TASK_FALL_AND_GET_UP hPlayerPed 2 1000
                                    TASK_SAY hPlayerPed 344

                                    IF hPassenger > 0
                                        TASK_PLAY_ANIM_NON_INTERRUPTABLE hPassenger FALL_FRONT PED 4.0 FALSE FALSE FALSE FALSE 1000
                                        TASK_FALL_AND_GET_UP hPassenger 2 1000
                                        TASK_SAY hPassenger 344
                                    ENDIF

                                    dir_x /= fDivStartInertia
                                    dir_y /= fDivStartInertia
                                    dir_y /= fDivStartInertia
                                    f = fInertiaEaseOut

                                    WHILE TRUE
                                        SET_CHAR_VELOCITY hPlayerPed (dir_x dir_y dir_z)
                                        IF hPassenger > 0
                                            SET_CHAR_VELOCITY hPassenger (dir_x dir_y dir_z)
                                        ENDIF

                                        f +=@ f

                                        dir_x -=@ f
                                        dir_y -=@ f
                                        dir_z -=@ f

                                        IF dir_x < 0.05
                                        OR dir_x < 0.05
                                        OR dir_x < 0.05
                                            BREAK
                                        ENDIF

                                        WAIT 0

                                    ENDWHILE

                                ENDIF

                            ENDIF
                        
                        ENDIF

                    ENDIF
                    
                ELSE

                    // Store last speed (before big impact)
                    GET_CAR_SPEED_VECTOR hVeh (dir_x dir_y dir_z)

                ENDIF
            
            ENDIF

        ENDIF

    ENDWHILE

    /////////////////////////////////////////////////

    IsPanelPresent:
        GET_VEHICLE_POINTER hVeh (pDamageManager)
        pDamageManager += DamageManager
        CALL_METHOD_RETURN GetPanelStatus pDamageManager 1 0 (4)(iPanelStatus)
        IF NOT iPanelStatus = 3
            IS_INT_LVAR_GREATER_THAN_CONSTANT TIMERA -1 // RETURN_TRUE
        ELSE
            IS_INT_LVAR_EQUAL_TO_CONSTANT TIMERA -1 // RETURN_FALSE
        ENDIF
    RETURN

    GetCarCollisionIntensity:
        GET_VEHICLE_POINTER hVeh (i)
        i += m_fLastDamageIntensity
        READ_MEMORY i 4 FALSE (fIntensity)
    RETURN // fIntensity

    IsCarCollisionFrontDirection:
        GET_VEHICLE_POINTER hVeh (i)
        i += m_vLastDamagePoint
        READ_MEMORY i 4 FALSE (x)
        i += 0x4
        READ_MEMORY i 4 FALSE (y)
        //i += 0x4
        //READ_MEMORY i 4 FALSE (z)

        // TODO: Maybe convert to euler angles, but need to preserve a condition like this 'side' one

        GET_CAR_MODEL hVeh (i)
        GET_MODEL_DIMENSIONS i (side back g, g front g)
        IF back > front
            front = back
        ENDIF

        GET_OFFSET_FROM_CAR_IN_WORLD_COORDS hVeh 0.0 front 0.0 (car_x car_y car_z)
        GET_DISTANCE_BETWEEN_COORDS_2D (x y, car_x car_y) (g)
        
        ABS_LVAR_FLOAT side
        side *= 1.3

        IS_THING_GREATER_THAN_THING side g 
    RETURN // side > g

}

{
    speed_shake:
    SCRIPT_NAME SDK_SHK 

    LVAR_FLOAT fCarSpeed fShakeLevel
    LVAR_INT hPlayerCar iShakeLevel

    CONST_FLOAT fShakeIntensityMult 1f
    CONST_FLOAT fMinSpeed 35f

    speed_shake_loop:
    WAIT 0 
    IF IS_CHAR_SITTING_IN_ANY_CAR hPlayerPed 
    AND NOT IS_CHAR_IN_ANY_PLANE hPlayerPed 
    AND NOT IS_CHAR_IN_ANY_HELI hPlayerPed
        STORE_CAR_CHAR_IS_IN_NO_SAVE hPlayerPed hPlayerCar 
        GET_CAR_SPEED hPlayerCar fCarSpeed 
        fCarSpeed -= fMinSpeed 
        IF fCarSpeed > 0.0 
            fShakeLevel = fCarSpeed * fShakeIntensityMult
            iShakeLevel =# fShakeLevel 
            SHAKE_CAM iShakeLevel 
        ENDIF
    ENDIF

    GOTO speed_shake_loop
}

{
	street_racing:
	SCRIPT_NAME STRRACE

	LVAR_INT rival_model rival_class pRivalCar pRivalPed rival_blip rival_handle rival_ped iRivalCarModel proximity target_blip player_car iMoneyAmount i 
	LVAR_FLOAT player_coords[3] rival_coords[3] target_coords[3] fMoneyAmount fCruiseSpeed fRewardCoefficient fRivalProbability player_dist rival_dist

	CONST_FLOAT fRewardMaxMultiplier 2.86
	CONST_INT CVehicle_m_nCreatedBy 0x4AC
	CONST_INT CPed_m_nCreatedBy 0x4BC

    CONST_INT RANDOM_VEHICLE 1
    CONST_INT MISSION_VEHICLE 2
    CONST_INT PARKED_VEHICLE 3
    CONST_INT PERMANENT_VEHICLE 4

	player_car = 0
	rival_handle = 0

	street_races_main_loop:
		WAIT 0
		IF IS_CHAR_SITTING_IN_ANY_CAR hPlayerPed
			IF IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER2
			AND IS_BUTTON_PRESSED PAD1 LEFTSHOULDER2
				TIMERA = 0

				WHILE IS_BUTTON_PRESSED PAD1 RIGHTSHOULDER2
				AND IS_BUTTON_PRESSED PAD1 LEFTSHOULDER2
					WAIT 0
					IF TIMERA > 5000
						WHILE player_car = rival_handle
                            WAIT 0
							GET_CHAR_COORDINATES hPlayerPed (player_coords[0] player_coords[1] player_coords[2])
							GET_RANDOM_CAR_IN_SPHERE_NO_SAVE_RECURSIVE player_coords[0] player_coords[1] player_coords[2] 10f TRUE TRUE (rival_handle)
							GET_CAR_CHAR_IS_USING hPlayerPed player_car

							IF rival_handle = -1
								GOTO reset_script_status
							ENDIF

							GET_DRIVER_OF_CAR rival_handle (rival_ped)

							IF NOT IS_CHAR_SITTING_IN_CAR rival_ped rival_handle
								GOTO reset_script_status
							ENDIF
						ENDWHILE

						IF IS_CAR_MODEL rival_handle COPCARLA
						OR IS_CAR_MODEL rival_handle COPCARSF
						OR IS_CAR_MODEL rival_handle COPCARVG
						OR IS_CAR_MODEL rival_handle COPCARRU
						OR IS_CAR_MODEL rival_handle COPBIKE
							ALTER_WANTED_LEVEL 0 1
							GOTO reset_script_status
						ENDIF

						IF IS_CAR_MODEL rival_handle AMBULAN
							GOTO reset_script_status
						ENDIF

						GENERATE_RANDOM_FLOAT_IN_RANGE 0f 1f (fRivalProbability)

						IF fRivalProbability > 0.5f
							GET_PED_POINTER rival_ped (pRivalPed)
							GET_VEHICLE_POINTER rival_handle (pRivalCar)

							IF IS_PC_VERSION
								i = pRivalCar + 0x4A4
							ELSE
								i = pRivalCar + CVehicle_m_nCreatedBy
							ENDIF

							WRITE_MEMORY i 1 2 TRUE // MARK_CAR_AS_NEEDED

							IF IS_PC_VERSION
								i = pRivalPed + 0x484
							ELSE
								i = pRivalPed + CPed_m_nCreatedBy
							ENDIF

							WRITE_MEMORY i 1 2 TRUE // MARK_CHAR_AS_NEEDED

							GET_CAR_COORDINATES rival_handle (player_coords[0] player_coords[1] player_coords[2])
							GENERATE_RANDOM_FLOAT_IN_RANGE 1f fRewardMaxMultiplier fRewardCoefficient
							fCruiseSpeed = fRewardCoefficient * 35f
							fMoneyAmount = fRewardCoefficient * 1000f
							iMoneyAmount =# fMoneyAmount
							GET_NTH_CLOSEST_CAR_NODE player_coords[0] player_coords[1] player_coords[2] 1000 (target_coords[0] target_coords[1] target_coords[2])
							ADD_BLIP_FOR_COORD target_coords[0] target_coords[1] target_coords[2] target_blip 
							SET_CAR_DRIVING_STYLE rival_handle DRIVINGMODE_AVOIDCARS
							SET_CAR_CRUISE_SPEED rival_handle fCruiseSpeed

							CAR_GOTO_COORDINATES_RACING rival_handle target_coords[0] target_coords[1] target_coords[2]
							ADD_BLIP_FOR_CAR rival_handle rival_blip
                            flag_player_on_mission = TRUE
							TIMERA = 0

							WHILE DOES_VEHICLE_EXIST rival_handle
							AND DOES_CHAR_EXIST rival_ped
							AND IS_PLAYER_PLAYING 0
							AND DOES_VEHICLE_EXIST player_car
								WAIT 0
								GET_CAR_COORDINATES player_car (player_coords[0] player_coords[1] player_coords[2])
								GET_CAR_COORDINATES rival_handle (rival_coords[0] rival_coords[1] rival_coords[2])
								GET_DISTANCE_BETWEEN_COORDS_3D target_coords[0] target_coords[1] target_coords[2] player_coords[0] player_coords[1] player_coords[2] (player_dist)
								GET_DISTANCE_BETWEEN_COORDS_3D target_coords[0] target_coords[1] target_coords[2] rival_coords[0] rival_coords[1] rival_coords[2] (rival_dist)

								IF TIMERA > 5000
									IF player_dist < rival_dist
										PRINT_FORMATTED_NOW "1/2" 1
									ELSE
										PRINT_FORMATTED_NOW "2/2" 1
									ENDIF
								ELSE
									IF TIMERA > 2000
										PRINT_FORMATTED_NOW "Reach the ~y~marker~w~ first to win the race" 1
									ELSE
										PRINT_FORMATTED_NOW "Come on, I'll finish you! I bet $%d" 1 iMoneyAmount
									ENDIF
								ENDIF

								IF LOCATE_CHAR_ANY_MEANS_3D rival_ped target_coords[0] target_coords[1] target_coords[2] 5f 5f 5f TRUE
									iMoneyAmount *= -1
									ADD_SCORE 0 iMoneyAmount
									MARK_CAR_AS_NO_LONGER_NEEDED rival_handle
									MARK_CHAR_AS_NO_LONGER_NEEDED rival_ped
									REMOVE_BLIP rival_blip
									REMOVE_BLIP target_blip
									PRINT_BIG_STRING "You lost!" 1 1
                                    flag_player_on_mission = FALSE
									GOTO reset_script_status
								ELSE
									IF LOCATE_CHAR_ANY_MEANS_3D hPlayerPed target_coords[0] target_coords[1] target_coords[2] 5f 5f 5f TRUE
										ADD_SCORE 0 iMoneyAmount
										MARK_CAR_AS_NO_LONGER_NEEDED rival_handle
										MARK_CHAR_AS_NO_LONGER_NEEDED rival_ped
										REMOVE_BLIP rival_blip
										REMOVE_BLIP target_blip
										PRINT_BIG_STRING "You won!" 1 1
                                        flag_player_on_mission = FALSE
										GOTO reset_script_status
									ENDIF
								ENDIF
							ENDWHILE
						ELSE
							PRINT_FORMATTED_NOW "Get out of here you idiot asshole, I'll not race against you!" 5000
							GOTO reset_script_status
						ENDIF
					ENDIF
				ENDWHILE
			ENDIF
		ENDIF
	GOTO street_races_main_loop

	reset_script_status:
	player_car = 0
	rival_handle = 0
	GOTO street_races_main_loop
}

CONST_INT PEOPLEGEN_ROW 0
CONST_INT PEOPLEGEN_WALL 1 
CONST_INT PEOPLEGEN_CIRCLE 2

// CLEO_CALL people_generator 0 (iGenType, x, y, z, a, pad, count, model[0], model[1] ...)
{
    LVAR_INT iGeneratorType
    LVAR_FLOAT v3dInitialCoords[3] fAngle fPadding
    LVAR_INT iGeneratedPedsCount ped_ids[10] i iStep tmpInt
    VAR_INT hGeneratedPeds[10] 
    LVAR_FLOAT v2dAngledCoords[2] f fRowAngle fStep

    people_generator:

    i = 0
    WHILE i < iGeneratedPedsCount
        IF NOT ped_ids[0] = -1
            REQUEST_MODEL (ped_ids[i])
            WHILE NOT HAS_MODEL_LOADED (ped_ids[i])
                WAIT 0
            ENDWHILE
        ENDIF 

        i++
    ENDWHILE

    IF NOT iGeneratorType = PEOPLEGEN_CIRCLE
        IF iGeneratorType = PEOPLEGEN_ROW
            fRowAngle = fAngle + 90.0f
        ELSE 
            IF iGeneratorType = PEOPLEGEN_WALL
                fRowAngle = fAngle
            ENDIF
        ENDIF

        i = 0
        WHILE i < iGeneratedPedsCount
            f =# i
            COS (fRowAngle) (v2dAngledCoords[0])
            SIN (fRowAngle) (v2dAngledCoords[1])
            v2dAngledCoords[0] *= fPadding
            v2dAngledCoords[1] *= fPadding
            v2dAngledCoords[0] *= f
            v2dAngledCoords[1] *= f
            v2dAngledCoords[0] *= -1.0
            v2dAngledCoords[1] *= -1.0
            v2dAngledCoords[0] += v3dInitialCoords[0]
            v2dAngledCoords[1] += v3dInitialCoords[1]
            IF ped_ids[0] = -1
                CREATE_RANDOM_CHAR (v2dAngledCoords[0] v2dAngledCoords[1] v3dInitialCoords[2]) (hGeneratedPeds[i])
            ELSE
                CREATE_CHAR PEDTYPE_CIVMALE (ped_ids[i] v2dAngledCoords[0] v2dAngledCoords[1] v3dInitialCoords[2]) (hGeneratedPeds[i])
            ENDIF
            SET_CHAR_HEADING (hGeneratedPeds[i] fAngle) 

            i++
        ENDWHILE 
    ELSE
        i = 0
        iStep = 360 / iGeneratedPedsCount
        fStep =# iStep
        WHILE i < iGeneratedPedsCount
            f =# i
            fRowAngle = fStep * f
            fAngle = fRowAngle + 90.0f

            COS (fRowAngle) (v2dAngledCoords[0])
            SIN (fRowAngle) (v2dAngledCoords[1])
            v2dAngledCoords[0] *= fPadding
            v2dAngledCoords[1] *= fPadding
            v2dAngledCoords[0] += v3dInitialCoords[0]
            v2dAngledCoords[1] += v3dInitialCoords[1]

            IF ped_ids[0] = -1
                CREATE_RANDOM_CHAR (v2dAngledCoords[0] v2dAngledCoords[1] v3dInitialCoords[2]) (hGeneratedPeds[i])
            ELSE
                CREATE_CHAR PEDTYPE_CIVMALE (ped_ids[i] v2dAngledCoords[0] v2dAngledCoords[1] v3dInitialCoords[2]) (hGeneratedPeds[i])
            ENDIF
            SET_CHAR_HEADING (hGeneratedPeds[i] fAngle) 

            i++
        ENDWHILE 
    ENDIF

    WAIT 0

    CLEO_RETURN 0

}

{
    people_gen_squares:
    SCRIPT_NAME PPLSQGN
    LVAR_INT hSquarePed iPedsQuantity iPedsToGenerate iPedPackToGenerate i j k iPedModels[4] iObject pTmp iRandomTime iCurTime iMaxTime iRandomNum
    LVAR_FLOAT v3dRandomCoords[3] fRandom v3dPlayerCoords[3]

    people_gen_squares_loop:
        WAIT 0
        IF IS_CHAR_IN_ZONE hPlayerPed PER1
        AND NOT flag_player_on_mission = TRUE
            v3dRandomCoords[2] = 13.796877
            GENERATE_RANDOM_INT_IN_RANGE (8, 16) (iPedsToGenerate)
            iPedsQuantity = 0
            WHILE iPedsQuantity < iPedsToGenerate 
                GENERATE_RANDOM_INT_IN_RANGE (1, 4) (iPedPackToGenerate)

                i = iPedPackToGenerate + iPedsQuantity
                WHILE i > iPedsToGenerate
                    iPedPackToGenerate--
                    i = iPedPackToGenerate + iPedsQuantity
                ENDWHILE

                GENERATE_RANDOM_FLOAT_IN_RANGE (1441.818481, 1516.532593) (v3dRandomCoords[0])
                GENERATE_RANDOM_FLOAT_IN_RANGE (-1719.910767, -1604.777222) (v3dRandomCoords[1])
                
                CLEO_CALL people_generator 0 (2, v3dRandomCoords[0], v3dRandomCoords[1], v3dRandomCoords[2], 74.359f, 0.85f, iPedPackToGenerate, -1)
                
                i = 0
                WHILE i < iPedPackToGenerate
                    j = i + iPedsQuantity
                    hSquarePed = hGeneratedPeds[i]

                    GENERATE_RANDOM_INT_IN_RANGE (1, 10) (k)

                    IF k > 5
                    AND k < 8
                        TASK_LOOK_ABOUT (hSquarePed, -1)

                        pTmp = j * 4
                        pTmp += pPeopleSquareGenMaxTimes
                        WRITE_MEMORY (pTmp, 4, 40000, TRUE)
                    ELSE
                        IF k < 5
                            IF NOT iPedPackToGenerate = 1
                                GENERATE_RANDOM_INT_IN_RANGE (0, 1) (iRandomNum)
                                IF iRandomNum = TRUE
                                    REQUEST_ANIMATION "MISC"
                                    WHILE NOT HAS_ANIMATION_LOADED "MISC"
                                        WAIT 0
                                    ENDWHILE

                                    TASK_PLAY_ANIM hSquarePed "IDLE_CHAT_02" "MISC" 4.0 TRUE 0 0 0 -1 
                                    GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 1.0 fRandom
                                    WAIT 0
                                    SET_CHAR_ANIM_CURRENT_TIME hSquarePed "IDLE_CHAT_02" fRandom
                                ELSE
                                    TASK_PLAY_ANIM hSquarePed "IDLE_CHAT" "PED" 4.0 TRUE 0 0 0 -1 
                                    GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 1.0 fRandom
                                    WAIT 0
                                    SET_CHAR_ANIM_CURRENT_TIME hSquarePed "IDLE_CHAT" fRandom
                                ENDIF

                            ELSE
                                TASK_USE_MOBILE_PHONE hSquarePed TRUE
                            ENDIF

                            pTmp = j * 4
                            pTmp += pPeopleSquareGenMaxTimes
                            WRITE_MEMORY (pTmp, 4, 60000, TRUE)
                            
                        ELSE
                            REQUEST_MODEL 3044
                            REQUEST_ANIMATION "GANGS"
                            WHILE NOT HAS_MODEL_LOADED 3044
                            OR NOT HAS_ANIMATION_LOADED "GANGS"
                                WAIT 0
                            ENDWHILE

                            MARK_MODEL_AS_NO_LONGER_NEEDED 3044

                            CREATE_OBJECT 3044 0f 0f 0f iObject
                            TASK_PICK_UP_OBJECT hSquarePed iObject 0.04 0.1 0.05 6 16 NULL NULL -1
                            TASK_PLAY_ANIM hSquarePed "SMKCIG_PRTL" "GANGS" 4.0 TRUE 0 0 0 -1 
                            GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 1.0 fRandom
                            WAIT 0
                            SET_CHAR_ANIM_CURRENT_TIME hSquarePed "SMKCIG_PRTL" fRandom

                            pTmp = j * 4
                            pTmp += pPeopleSquareGenObjects
                            WRITE_MEMORY pTmp 4 iObject TRUE

                            pTmp = j * 4
                            pTmp += pPeopleSquareGenMaxTimes
                            WRITE_MEMORY (pTmp, 4, 60000, TRUE)

                        ENDIF
                    ENDIF

                    pTmp = j * 4
                    pTmp += pPeopleSquareGenPeds
                    WRITE_MEMORY pTmp 4 hSquarePed TRUE

                    GENERATE_RANDOM_INT_IN_RANGE (0, 30000) (iRandomTime)
                    pTmp = j * 4
                    pTmp += pPeopleSquareGenTimers
                    WRITE_MEMORY pTmp 4 iRandomTime TRUE
                    
                    i++
                ENDWHILE

                iPedsQuantity += iPedPackToGenerate 
            ENDWHILE

            WHILE IS_CHAR_IN_ZONE hPlayerPed PER1
            AND NOT flag_player_on_mission = TRUE
                TIMERA = 0
                WAIT 0

                i = 0
                WHILE i < iPedsQuantity
                    pTmp = i * 4
                    pTmp += pPeopleSquareGenMaxTimes
                    READ_MEMORY (pTmp, 4, TRUE) (iMaxTime)

                    pTmp = i * 4
                    pTmp += pPeopleSquareGenTimers
                    READ_MEMORY (pTmp, 4, TRUE) (iCurTime)
                    iCurTime += TIMERA

                    IF iCurTime >= iMaxTime
                        WRITE_MEMORY (pTmp, 4, 0, TRUE) 
                        GENERATE_RANDOM_INT_IN_RANGE (1, 10) (k)

                        pTmp = i * 4
                        pTmp += pPeopleSquareGenPeds
                        READ_MEMORY (pTmp, 4, TRUE) (hSquarePed)

                        CLEAR_CHAR_TASKS hSquarePed
                        WAIT 0

                        IF k > 5
                        AND k < 8
                            TASK_LOOK_ABOUT (hSquarePed, -1)

                            pTmp = i * 4
                            pTmp += pPeopleSquareGenMaxTimes
                            WRITE_MEMORY (pTmp, 4, 40000, TRUE)
                        ELSE
                            IF k < 5
                                IF NOT iPedPackToGenerate = 1
                                    GENERATE_RANDOM_INT_IN_RANGE (0, 1) (iRandomNum)
                                    IF iRandomNum = TRUE
                                        REQUEST_ANIMATION "MISC"
                                        WHILE NOT HAS_ANIMATION_LOADED "MISC"
                                            WAIT 0
                                        ENDWHILE

                                        TASK_PLAY_ANIM hSquarePed "IDLE_CHAT_02" "MISC" 4.0 TRUE 0 0 0 -1 
                                    ELSE
                                        TASK_PLAY_ANIM hSquarePed "IDLE_CHAT" "PED" 4.0 TRUE 0 0 0 -1 
                                    ENDIF

                                ELSE
                                    TASK_USE_MOBILE_PHONE hSquarePed TRUE
                                ENDIF

                                pTmp = i * 4
                                pTmp += pPeopleSquareGenMaxTimes
                                WRITE_MEMORY (pTmp, 4, 60000, TRUE)

                            ELSE
                                REQUEST_MODEL 3044
                                REQUEST_ANIMATION "GANGS"
                                WHILE NOT HAS_MODEL_LOADED 3044
                                OR NOT HAS_ANIMATION_LOADED "GANGS"
                                    WAIT 0
                                ENDWHILE

                                MARK_MODEL_AS_NO_LONGER_NEEDED 3044

                                CREATE_OBJECT 3044 0f 0f 0f iObject
                                TASK_PICK_UP_OBJECT hSquarePed iObject 0.04 0.1 0.05 6 16 NULL NULL -1
                                TASK_PLAY_ANIM hSquarePed "SMKCIG_PRTL" "GANGS" 4.0 TRUE 0 0 0 -1 

                                pTmp = i * 4
                                pTmp += pPeopleSquareGenObjects
                                WRITE_MEMORY pTmp 4 iObject TRUE

                                pTmp = i * 4
                                pTmp += pPeopleSquareGenMaxTimes
                                WRITE_MEMORY (pTmp, 4, 60000, TRUE)

                            ENDIF
                        ENDIF
                    ELSE
                        WRITE_MEMORY (pTmp, 4, iCurTime, TRUE) 
                    ENDIF

                    i++
                ENDWHILE
            ENDWHILE

            i = 0
            WHILE i < iPedsQuantity
                pTmp = i * 4
                pTmp += pPeopleSquareGenPeds
                READ_MEMORY pTmp 4 TRUE (hSquarePed)
                WRITE_MEMORY pTmp 4 0x00000000 TRUE

                IF DOES_CHAR_EXIST hSquarePed
                    DELETE_CHAR hSquarePed
                ENDIF 

                pTmp = i * 4
                pTmp += pPeopleSquareGenObjects

                READ_MEMORY pTmp 4 TRUE (iObject)
                WRITE_MEMORY pTmp 4 0x00000000 TRUE

                IF DOES_OBJECT_EXIST iObject
                    DELETE_OBJECT iObject
                ENDIF 

                i++
            ENDWHILE

            IF HAS_ANIMATION_LOADED "MISC"
                REMOVE_ANIMATION "MISC"
            ENDIF

            IF HAS_ANIMATION_LOADED "GANGS"
                REMOVE_ANIMATION "GANGS"
            ENDIF

        ELSE
            IF LOCATE_CHAR_ANY_MEANS_2D hPlayerPed 1022.404236 -1123.798218 50f 50f 0
                CLEO_CALL people_generator 0 (0, 1022.404236f, -1123.798218f, 23.870037f, 4.029474f, 0.70f, 6, -1)

                i = 0
                WHILE i < 6
                    hSquarePed = hGeneratedPeds[i]

                    pTmp = i * 4
                    pTmp += pPeopleSquareGenPeds
                    WRITE_MEMORY pTmp 4 hSquarePed TRUE
                    i++
                ENDWHILE

                CLEO_CALL people_generator 0 (2, 1033.302368 -1123.322876 23.891327 272.584106, 1.2f, 3, -1)

                i = 6
                WHILE i < 9
                    j = i - 6
                    hSquarePed = hGeneratedPeds[j]

                    pTmp = i * 4
                    pTmp += pPeopleSquareGenPeds
                    WRITE_MEMORY pTmp 4 hSquarePed TRUE
                    i++
                ENDWHILE

                CLEO_CALL people_generator 0 (2, 1010.137024 -1123.191406 23.899345 86.927002, 1.2f, 3, -1)

                i = 9
                WHILE i < 12
                    j = i - 9
                    hSquarePed = hGeneratedPeds[j]

                    pTmp = i * 4
                    pTmp += pPeopleSquareGenPeds
                    WRITE_MEMORY pTmp 4 hSquarePed TRUE
                    i++
                ENDWHILE

                WHILE LOCATE_CHAR_ANY_MEANS_2D hPlayerPed 1022.404236 -1123.798218 50f 50f 0
                    WAIT 0
                ENDWHILE

                i = 0
                WHILE i < 12
                    READ_MEMORY pTmp 4 TRUE (hSquarePed)
                    WRITE_MEMORY pTmp 4 0x00000000 TRUE

                    IF DOES_CHAR_EXIST hSquarePed
                        DELETE_CHAR hSquarePed
                    ENDIF 

                    pTmp = i * 4
                    pTmp += pPeopleSquareGenObjects

                    i++
                ENDWHILE
            ENDIF
        ENDIF
    GOTO people_gen_squares_loop
}

fade_for_mission:
    IF IS_PLAYER_PLAYING iPlayer
        SET_PLAYER_CONTROL iPlayer OFF // Tip: turning iPlayer control off makes the iPlayer safe
                                      // (i.e. cannot die or get arrested)
        SET_FADING_COLOUR 0 0 0
        DO_FADE 500 FADE_OUT
        WHILE GET_FADING_STATUS
            WAIT 0
        ENDWHILE
        CLEAR_PRINTS
        CLEAR_HELP
        CLEAR_CHAR_TASKS hPlayerPed
    ENDIF
RETURN
