MISSION_START

SCRIPT_NAME GRAROTM

GOSUB grass_roots_michael_mission

IF HAS_DEATHARREST_BEEN_EXECUTED
    GOSUB grass_roots_michael_failed
ENDIF

GOSUB grass_roots_michael_cleanup

MISSION_END

{
    VAR_INT BindMissionAudio
    LVAR_INT hBarryPed hTableObject hChairObject hCigarObject hAlienPed[24] i j 
    LVAR_FLOAT coords[3]


    grass_roots_michael_mission:

    CREATE_CHAR PEDTYPE_CIVMALE SPECIAL01 1468.079829 -1650.901636 14.046875 hBarryPed
    SET_CHAR_HEADING hBarryPed 152.380005

    TASK_PLAY_ANIM_NON_INTERRUPTABLE hBarryPed "SEAT_idle" "PED" 4.0 TRUE FALSE FALSE FALSE 99999

    CREATE_OBJECT 1810 1468.424805 -1650.651001 13.046875 hChairObject
    SET_OBJECT_HEADING hChairObject 320.639938

    CREATE_OBJECT 2115 1468.043457 -1652.227905 13.046875 hTableObject
    SET_OBJECT_HEADING hTableObject 159.437317

    CREATE_OBJECT 3044 1467.343457 -1651.527905 13.846875 hCigarObject

    REQUEST_MODEL MINIGUN
    REQUEST_MODEL MP5LNG

    WHILE NOT HAS_MODEL_LOADED MINIGUN
    OR NOT HAS_MODEL_LOADED MP5LNG
        WAIT 0
    ENDWHILE

    SET_POLICE_IGNORE_PLAYER 0 TRUE
    SET_MAX_WANTED_LEVEL 0

    SET_PED_DENSITY_MULTIPLIER 0.0
    SET_CAR_DENSITY_MULTIPLIER 0.0

    SWITCH_WIDESCREEN ON
    DISPLAY_RADAR OFF
    DISPLAY_HUD OFF
    CLEAR_HELP

    CLEAR_AREA 1468.043457 -1652.227905 13.046875 500.0 TRUE

    DO_FADE 1000 FADE_IN
    WAIT 1000

    LOAD_SPECIAL_CHARACTER 2 MACCER

    WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 2
        WAIT 0
    ENDWHILE

    CLEO_CALL create_new_alien 0 (1442.362427, -1608.780029, 13.796875, 205.020370 ) (hAlienPed[0])
    CLEO_CALL create_new_alien 0 (1440.965332, -1610.717285, 13.546875, 204.707031 ) (hAlienPed[1])
    CLEO_CALL create_new_alien 0 (1447.362427, -1610.191650, 14.046875, 197.500336 ) (hAlienPed[2])
    CLEO_CALL create_new_alien 0 (1471.537231, -1622.125122, 14.039297, 155.513321 ) (hAlienPed[3])
    CLEO_CALL create_new_alien 0 (1464.696289, -1626.009521, 14.046875, 180.266846 ) (hAlienPed[4])
    CLEO_CALL create_new_alien 0 (1459.561646, -1633.283569, 14.039297, 192.173584 ) (hAlienPed[5])

    SET_CHAR_VISIBLE hAlienPed[0] FALSE
    SET_CHAR_VISIBLE hAlienPed[1] FALSE
    SET_CHAR_VISIBLE hAlienPed[2] FALSE
    SET_CHAR_VISIBLE hAlienPed[3] FALSE
    SET_CHAR_VISIBLE hAlienPed[4] FALSE
    SET_CHAR_VISIBLE hAlienPed[5] FALSE

    SKIP_CUTSCENE_START

    SET_PLAYER_CONTROL 0 OFF

    TASK_LOOK_AT_CHAR hBarryPed hPlayerPed -1
    TASK_TURN_CHAR_TO_FACE_CHAR hPlayerPed hBarryPed
    TASK_PLAY_ANIM_SECONDARY hBarryPed "endchat_01" "PED" 4.0 FALSE FALSE FALSE FALSE -1

    CLEO_CALL play_grass_roots_michael_sound 0 (0, hBarryPed)

    PRINT_STRING_NOW "Barry: Excuse me, sir, can I talk to you for a second?" 5000
    WAIT 5000

    ATTACH_CAMERA_TO_CHAR_LOOK_AT_CHAR hPlayerPed 2.0 -2.0 0.0 hBarryPed 0.0 2 // Camera on they talking

    CLEO_CALL play_grass_roots_michael_sound 0 (3, hPlayerPed)

    PRINT_STRING_NOW "Michael: The fuck are you talking about?" 5000
    WAIT 5000

    ATTACH_CAMERA_TO_CHAR_LOOK_AT_CHAR hPlayerPed 0.0 0.0 0.0 hBarryPed 0.0 2 // Camera on Barry

    CLEO_CALL play_grass_roots_michael_sound 0 (4, hBarryPed)

    TASK_PLAY_ANIM_SECONDARY hBarryPed "factalk" "PED" 4.0 TRUE FALSE FALSE FALSE -1
    PRINT_STRING_NOW "Barry: I am talking about a hotline straight to heaven." 5000
    WAIT 5000

    CLEO_CALL play_grass_roots_michael_sound 0 (5, hBarryPed)
    
    PRINT_STRING_NOW "Barry: That this state makes illegal." 5000
    WAIT 5000

    CLEO_CALL play_grass_roots_michael_sound 0 (6, hBarryPed)

    TASK_PICK_UP_OBJECT hBarryPed hCigarObject 0.04 0.1 0.05 6 16 "IDLE_chat" "PED" 1500 
    PRINT_STRING_NOW "Barry: Yeah, this is what I'm talking about." 5000
    WAIT 5000

    CLEO_CALL play_grass_roots_michael_sound 0 (7, hPlayerPed)
    
    ATTACH_CAMERA_TO_CHAR_LOOK_AT_CHAR hBarryPed 3.0 2.0 0.0 hPlayerPed 0.0 2 // Camera on player
    TASK_PLAY_ANIM_NON_INTERRUPTABLE hPlayerPed "endchat_02" "PED" 4.0 FALSE FALSE FALSE FALSE -1
    PRINT_STRING_NOW "Michael: I don't give a fuck about reefer!" 2500
    WAIT 2500

    CLEO_CALL play_grass_roots_michael_sound 0 (8, hBarryPed)

    ATTACH_CAMERA_TO_CHAR_LOOK_AT_CHAR hPlayerPed 2.0 -2.0 0.0 hBarryPed 0.0 2 // Camera on they talking
    PRINT_STRING_NOW "Barry: They rigged the vote, I saw the ballots, it's a lie." 5000
    WAIT 5000

    CLEO_CALL play_grass_roots_michael_sound 0 (9, hPlayerPed)

    ATTACH_CAMERA_TO_CHAR_LOOK_AT_CHAR hBarryPed 3.0 2.0 0.0 hPlayerPed 0.0 2 // Camera on player
    PRINT_STRING_NOW "Michael: It's democracy at work, amigo." 5000
    WAIT 5000

    CLEO_CALL play_grass_roots_michael_sound 0 (10, hBarryPed)

    ATTACH_CAMERA_TO_CHAR_LOOK_AT_CHAR hPlayerPed 0.0 0.0 0.0 hBarryPed 0.0 2 // Camera on Barry
    DELETE_OBJECT hCigarObject
    CREATE_OBJECT 3044 1467.343457 -1651.527905 13.846875 hCigarObject
    TASK_PLAY_ANIM_NON_INTERRUPTABLE hBarryPed "fucku" "PED" 4.0 FALSE FALSE FALSE FALSE -1
    PRINT_STRING_NOW "Barry: Democracy can suck my fatty." 5000
    WAIT 5000

    CLEO_CALL play_grass_roots_michael_sound 0 (11, hBarryPed)

    ATTACH_CAMERA_TO_CHAR_LOOK_AT_CHAR hPlayerPed 0.0 0.0 0.0 hBarryPed 0.0 2 // Camera on Barry
    PRINT_STRING_NOW "Barry: Democracy only works when it lets intelligent people do what they want." 5000
    WAIT 5000

    CLEO_CALL play_grass_roots_michael_sound 0 (12, hBarryPed)

    PRINT_STRING_NOW "Barry: This? This is tyranny by morons!" 5000
    WAIT 5000

    CLEO_CALL play_grass_roots_michael_sound 0 (13, hPlayerPed)

    ATTACH_CAMERA_TO_CHAR_LOOK_AT_CHAR hBarryPed 2.0 2.0 0.0 hPlayerPed 0.0 2 // Camera on player
    PRINT_STRING_NOW "Michael: Yeah... well," 2000
    WAIT 2000

    CLEO_CALL play_grass_roots_michael_sound 0 (14, hPlayerPed)

    PRINT_STRING_NOW "Michael: I got things to take care of in a little place called reality." 5000
    WAIT 5000

    CLEO_CALL play_grass_roots_michael_sound 0 (15, hBarryPed)

    ATTACH_CAMERA_TO_CHAR_LOOK_AT_CHAR hPlayerPed 0.0 0.0 0.0 hBarryPed 0.0 2 // Camera on Barry
    TASK_PICK_UP_OBJECT hBarryPed hCigarObject 0.04 0.1 0.05 6 16 "pass_Smoke_in_car" "PED" -1 
    PRINT_STRING_NOW "Barry: You wanna drag?" 5000
    WAIT 5000

    CLEO_CALL play_grass_roots_michael_sound 0 (16, hPlayerPed)

    ATTACH_CAMERA_TO_CHAR_LOOK_AT_CHAR hBarryPed 2.0 2.0 0.0 hPlayerPed 0.0 2 // Camera on player
    TASK_PLAY_ANIM_NON_INTERRUPTABLE hPlayerPed "endchat_02" "PED" 4.0 FALSE FALSE FALSE FALSE -1
    PRINT_STRING_NOW "Michael: Nah, I'm not a drug guy." 5000
    WAIT 5000

    CLEO_CALL play_grass_roots_michael_sound 0 (17, hBarryPed)

    ATTACH_CAMERA_TO_CHAR_LOOK_AT_CHAR hPlayerPed 0.0 0.0 0.0 hBarryPed 0.0 2 // Camera on Barry
    TASK_PICK_UP_OBJECT hBarryPed hCigarObject 0.04 0.1 0.05 6 16 "pass_Smoke_in_car" "PED" -1 
    PRINT_STRING_NOW "Barry: This isn't bush weed." 2500
    WAIT 2500

    CLEO_CALL play_grass_roots_michael_sound 0 (18, hBarryPed)

    PRINT_STRING_NOW "Barry: This is mana!" 2500
    WAIT 2500

    CLEO_CALL play_grass_roots_michael_sound 0 (19, hBarryPed)

    PRINT_STRING_NOW "Barry: I grow it myself," 2500
    WAIT 2500

    CLEO_CALL play_grass_roots_michael_sound 0 (20, hBarryPed)

    PRINT_STRING_NOW "Barry: no paranoia, no weirdness." 2500
    WAIT 2500

    CLEO_CALL play_grass_roots_michael_sound 0 (21, hBarryPed)

    PRINT_STRING_NOW "Barry: A passport to nirvana." 2500
    WAIT 2500

    ATTACH_CAMERA_TO_CHAR_LOOK_AT_CHAR hBarryPed 3.0 2.0 0.0 hPlayerPed 0.0 2 // Camera on player
    TASK_PLAY_ANIM_NON_INTERRUPTABLE hPlayerPed "roadcross" "PED" 4.0 FALSE FALSE FALSE FALSE -1

    WAIT 1500

    CLEO_CALL play_grass_roots_michael_sound 0 (22, hPlayerPed)

    PRINT_STRING_NOW "Michael: Fuck it, give me that thing." 2000
    WAIT 2000

    //ATTACH_CAMERA_TO_CHAR_LOOK_AT_CHAR hBarryPed 0.0 0.0 2.0 hPlayerPed 0.0 2 // Camera on player
    DELETE_OBJECT hCigarObject
    CREATE_OBJECT 3044 0f 0f 0f hCigarObject

    TASK_PICK_UP_OBJECT hPlayerPed hCigarObject 0.04 0.1 0.05 6 16 "Walk_DoorPartial" "PED" -1
    WAIT 1000

    DELETE_OBJECT hCigarObject
    CREATE_OBJECT 3044 0f 0f 0f hCigarObject

    CLEO_CALL play_grass_roots_michael_sound 0 (23, hBarryPed)

    ATTACH_CAMERA_TO_CHAR_LOOK_AT_CHAR hPlayerPed 0.0 0.0 0.0 hBarryPed 0.0 2 // Camera on Barry
    PRINT_STRING_NOW "Barry: Yeah here, you'll hardly feel it." 2500
    WAIT 2500

    CLEO_CALL play_grass_roots_michael_sound 0 (24, hBarryPed)

    PRINT_STRING_NOW "Barry: Yeah I smoke all day and I'm fine." 2500
    WAIT 2500

    CLEO_CALL play_grass_roots_michael_sound 0 (25, hBarryPed)

    PRINT_STRING_NOW "Barry: It's a pure mellow high." 2500
    WAIT 2500

    CLEO_CALL play_grass_roots_michael_sound 0 (26, hBarryPed)

    PRINT_STRING_NOW "Barry: But I do get concerned about the monsters." 2500
    WAIT 2500

    SET_CHAR_VISIBLE hBarryPed FALSE
    GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hPlayerPed 0.0 3.0 0.7 coords[0] coords[1] coords[2]
    SET_FIXED_CAMERA_POSITION coords[0] coords[1] coords[2] 0.0 0.0 0.0
    GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hPlayerPed 0.0 0.0 0.7 coords[0] coords[1] coords[2]
    POINT_CAMERA_AT_POINT coords[0] coords[1] coords[2] JUMP_CUT
    TASK_PICK_UP_OBJECT hPlayerPed hCigarObject 0.04 0.1 0.05 6 16 "SMKCIG_PRTL" "GANGS" -1

    PRELOAD_BEAT_TRACK 4

    PLAY_BEAT_TRACK

    CLEO_CALL play_grass_roots_michael_sound 0 (27, hBarryPed)

    PRINT_STRING_NOW "Barry: Yeah..." 1000
    WAIT 1000

    PRINT_STRING_NOW "Barry: I mean" 1000
    WAIT 1000

    CAMERA_SET_LERP_FOV 70.0 15.0 5000 TRUE
    CAMERA_PERSIST_FOV TRUE

    CLEO_CALL play_grass_roots_michael_sound 0 (28, hBarryPed)

    PRINT_STRING_NOW "Barry: I'm sure they're nothing serious, but ah..." 2000
    WAIT 2000

    CLEO_CALL play_grass_roots_michael_sound 0 (29, hBarryPed)

    PRINT_STRING_NOW "Barry: I never let them get to near." 2000
    WAIT 2000

    TASK_PLAY_ANIM_NON_INTERRUPTABLE hPlayerPed "facsurp" "PED" 4.0 TRUE FALSE FALSE FALSE 99999

    CLEO_CALL play_grass_roots_michael_sound 0 (30, hPlayerPed)

    PRINT_STRING_NOW "Michael: Oh!" 1000
    WAIT 1000

    PRINT_STRING_NOW "Michael: The fuck..." 1000
    WAIT 1000

    CLEO_CALL play_grass_roots_michael_sound 0 (31, hPlayerPed)

    PRINT_STRING_NOW "Michael: Is that?" 1000
    WAIT 1000

    WAIT 2000

    CLEAR_MISSION_AUDIO 1

    DELETE_OBJECT hChairObject
    DELETE_OBJECT hTableObject
    UNLOAD_SPECIAL_CHARACTER 1
    DELETE_CHAR hBarryPed
    
    DELETE_OBJECT hCigarObject

    CAMERA_SET_LERP_FOV 15.0 70.0 5000 TRUE
    CAMERA_PERSIST_FOV FALSE

    SKIP_CUTSCENE_END

    SET_CHAR_VISIBLE hAlienPed[0] TRUE
    SET_CHAR_VISIBLE hAlienPed[1] TRUE
    SET_CHAR_VISIBLE hAlienPed[2] TRUE
    SET_CHAR_VISIBLE hAlienPed[3] TRUE
    SET_CHAR_VISIBLE hAlienPed[4] TRUE
    SET_CHAR_VISIBLE hAlienPed[5] TRUE

    WAIT 5000

    RESTORE_CAMERA
    
    GIVE_WEAPON_TO_CHAR hPlayerPed WEAPONTYPE_MINIGUN 99999

    CLEAR_CHAR_TASKS hPlayerPed
    SET_PLAYER_CONTROL 0 ON

    SWITCH_WIDESCREEN OFF
    DISPLAY_RADAR ON
    DISPLAY_HUD ON
    CLEAR_HELP

    i = 0
    j = 6
    GOSUB do_aliens_attack

    WHILE NOT IS_CHAR_DEAD hAlienPed[0]
    OR NOT IS_CHAR_DEAD hAlienPed[1]
    OR NOT IS_CHAR_DEAD hAlienPed[2]
    OR NOT IS_CHAR_DEAD hAlienPed[3]
    OR NOT IS_CHAR_DEAD hAlienPed[4]
    OR NOT IS_CHAR_DEAD hAlienPed[5]
        WAIT 0
    ENDWHILE

    CLEO_CALL create_new_alien 0 (1496.748535, -1653.437500, 14.046875, 111.669876) (hAlienPed[6])
    CLEO_CALL create_new_alien 0 (1494.130859, -1648.454834, 14.046875, 109.789856) (hAlienPed[7])
    CLEO_CALL create_new_alien 0 (1491.428711, -1651.171509, 14.046875, 109.789856) (hAlienPed[8])
    CLEO_CALL create_new_alien 0 (1493.328369, -1660.002930, 14.046875, 78.769524 ) (hAlienPed[9])
    CLEO_CALL create_new_alien 0 (1493.704346, -1665.144287, 14.046875, 60.909451 ) (hAlienPed[10])
    CLEO_CALL create_new_alien 0 (1489.885376, -1630.078735, 14.046875, 136.423477) (hAlienPed[11])

    i = 6
    j = 12
    GOSUB do_aliens_attack

    WHILE NOT IS_CHAR_DEAD hAlienPed[6]
    OR NOT IS_CHAR_DEAD hAlienPed[7]
    OR NOT IS_CHAR_DEAD hAlienPed[8]
    OR NOT IS_CHAR_DEAD hAlienPed[9]
    OR NOT IS_CHAR_DEAD hAlienPed[10]
    OR NOT IS_CHAR_DEAD hAlienPed[11]
        WAIT 0
    ENDWHILE

    CLEO_CALL create_new_alien 0 (1442.362427, -1608.780029, 13.796875, 205.020370 ) (hAlienPed[12])
    CLEO_CALL create_new_alien 0 (1440.965332, -1610.717285, 13.546875, 204.707031 ) (hAlienPed[13])
    CLEO_CALL create_new_alien 0 (1447.362427, -1610.191650, 14.046875, 197.500336 ) (hAlienPed[14])
    CLEO_CALL create_new_alien 0 (1471.537231, -1622.125122, 14.039297, 155.513321 ) (hAlienPed[15])
    CLEO_CALL create_new_alien 0 (1464.696289, -1626.009521, 14.046875, 180.266846 ) (hAlienPed[16])
    CLEO_CALL create_new_alien 0 (1459.561646, -1633.283569, 14.039297, 192.173584 ) (hAlienPed[17])

    i = 12
    j = 18
    GOSUB do_aliens_attack

    WHILE NOT IS_CHAR_DEAD hAlienPed[12]
    OR NOT IS_CHAR_DEAD hAlienPed[13]
    OR NOT IS_CHAR_DEAD hAlienPed[14]
    OR NOT IS_CHAR_DEAD hAlienPed[15]
    OR NOT IS_CHAR_DEAD hAlienPed[16]
    OR NOT IS_CHAR_DEAD hAlienPed[17]
        WAIT 0
    ENDWHILE

    CLEO_CALL create_new_alien 0 (1496.748535, -1653.437500, 14.046875, 111.669876) (hAlienPed[18])
    CLEO_CALL create_new_alien 0 (1494.130859, -1648.454834, 14.046875, 109.789856) (hAlienPed[19])
    CLEO_CALL create_new_alien 0 (1491.428711, -1651.171509, 14.046875, 109.789856) (hAlienPed[20])
    CLEO_CALL create_new_alien 0 (1493.328369, -1660.002930, 14.046875, 78.769524 ) (hAlienPed[21])
    CLEO_CALL create_new_alien 0 (1493.704346, -1665.144287, 14.046875, 60.909451 ) (hAlienPed[22])
    CLEO_CALL create_new_alien 0 (1489.885376, -1630.078735, 14.046875, 136.423477) (hAlienPed[23])

    i = 18
    j = 24
    GOSUB do_aliens_attack

    WHILE NOT IS_CHAR_DEAD hAlienPed[18]
    OR NOT IS_CHAR_DEAD hAlienPed[19]
    OR NOT IS_CHAR_DEAD hAlienPed[20]
    OR NOT IS_CHAR_DEAD hAlienPed[21]
    OR NOT IS_CHAR_DEAD hAlienPed[22]
    OR NOT IS_CHAR_DEAD hAlienPed[23]
        WAIT 0
    ENDWHILE

    PRINT_WITH_NUMBER_BIG M_PASS 5000 5000 1
    ADD_SCORE iPlayer 5000

    RETURN

    grass_roots_michael_failed:
    	PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
    RETURN

    do_aliens_attack:
        WHILE i < j
            SET_CHAR_SHOOT_RATE hAlienPed[i] 70
            TASK_KILL_CHAR_ON_FOOT hAlienPed[i] hPlayerPed
            i++
        ENDWHILE
    RETURN

    grass_roots_michael_cleanup:
        DELETE_CHAR hAlienPed[0]
        DELETE_CHAR hAlienPed[1]
        DELETE_CHAR hAlienPed[2]
        DELETE_CHAR hAlienPed[3]
        DELETE_CHAR hAlienPed[4]
        DELETE_CHAR hAlienPed[5]
        DELETE_CHAR hAlienPed[6]
        DELETE_CHAR hAlienPed[7]
        DELETE_CHAR hAlienPed[8]
        DELETE_CHAR hAlienPed[9]
        DELETE_CHAR hAlienPed[10]
        DELETE_CHAR hAlienPed[11]
        DELETE_CHAR hAlienPed[12]
        DELETE_CHAR hAlienPed[13]
        DELETE_CHAR hAlienPed[14]
        DELETE_CHAR hAlienPed[15]
        DELETE_CHAR hAlienPed[16]
        DELETE_CHAR hAlienPed[17]
        DELETE_CHAR hAlienPed[18]
        DELETE_CHAR hAlienPed[19]
        DELETE_CHAR hAlienPed[20]
        DELETE_CHAR hAlienPed[21]
        DELETE_CHAR hAlienPed[22]
        DELETE_CHAR hAlienPed[23]
        UNLOAD_SPECIAL_CHARACTER 2

        STOP_BEAT_TRACK 

        SET_POLICE_IGNORE_PLAYER 0 FALSE
        SET_MAX_WANTED_LEVEL 5 

        SET_PED_DENSITY_MULTIPLIER 1.0
        SET_CAR_DENSITY_MULTIPLIER 1.0

        MISSION_HAS_FINISHED

        flag_player_on_mission = FALSE
    RETURN

}

{
    LVAR_FLOAT v3dCoords[3] fHeading 
    LVAR_INT hAlienPed

    create_new_alien: // CPedHandle create_new_alien(float x, float y, float z, float angle)

    CREATE_CHAR PEDTYPE_CIVMALE SPECIAL02 v3dCoords[0] v3dCoords[1] v3dCoords[2] hAlienPed
    SET_CHAR_HEADING hAlienPed fHeading
    GIVE_WEAPON_TO_CHAR hAlienPed WEAPONTYPE_MP5 99999

    CLEO_RETURN 0 hAlienPed
}

{
    LVAR_INT iSoundId hPed iBankId

    play_grass_roots_michael_sound: // void play_grass_roots_michael_sound(int sound_id, CPedHandle ped)

    iSoundId += 5200
    CLEAR_MISSION_AUDIO 1

    LOAD_MISSION_AUDIO 1 iSoundId
    WHILE NOT HAS_MISSION_AUDIO_LOADED 1 
        WAIT 0
    ENDWHILE
    ATTACH_MISSION_AUDIO_TO_CHAR 1 hPed
    PLAY_MISSION_AUDIO 1

    CLEO_RETURN 0
}
