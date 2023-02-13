// main/mistery1.sc
// 
// This is a mission script. It has the following basic structure:
MISSION_START
GOSUB mission_start_mistery1
IF HAS_DEATHARREST_BEEN_EXECUTED 
    GOSUB mission_mistery1_failed
ENDIF
GOSUB mission_cleanup_mistery1
MISSION_END

//
// Here, in mission scripts, is where the the deatharrest state shines (remember SET_DEATHARREST_STATE?).
// The deatharrest state is the scripting engine constantly checking if the player is dead or arrested,
// if so, the engine will make the script return from all its GOSUBs immediately!
//
// Do you see the relationship in the basic mission structure? Nice, eh?
//
// Another interesting features of mission scripts are the mission cleanup list and the cleanup gosub.
// The cleanup gosub serves as a disposal method for all the resources used by the mission.
// The cleanup list is a script engine internal list that keeps track of some, but not all, of the entities created
// by the mission, in such a way that once the mission is ended, the control of those entities are given back to the
// game logic (just like by calling MARK_THING_AS_NO_LONGER_NEEDED). The most notable entities tracked by the cleanup
// list are chars and cars.
//
// It reminds a bit of RAII. Request your stuff on mission startup and cleanup them on the cleanup sub.
//

// Let's write a simple 'GO FROM POINT A TO POINT B' mission.

{

// Variables for mission
// For III/VC you'll probably declare globals, but SA has an abundant amount of local variables in a mission.
LVAR_INT mistery1_delivery_car mistery1_delivery_blip
LVAR_FLOAT x y z

mission_start_mistery1:

flag_player_on_mission = 1
REGISTER_MISSION_GIVEN
WAIT 0 // let other scripts know a mission has been started

SCRIPT_NAME mister1

LOAD_MISSION_TEXT (BCESAR4)
REQUEST_MODEL ZR350
LOAD_ALL_MODELS_NOW // Tip: This freezes the game, use only while faded out (which we are).
                    // Otherwise use HAS_MODEL_LOADED in a while loop.

GET_CHAR_COORDINATES scplayer (x y z)
CREATE_CAR ZR350 (x y z) mistery1_delivery_car
WARP_CHAR_INTO_CAR scplayer mistery1_delivery_car

ADD_BLIP_FOR_COORD (40.0 0.0 4.0) mistery1_delivery_blip 

DO_FADE 1000 FADE_IN
WHILE GET_FADING_STATUS
    WAIT 0
ENDWHILE

PRINT_NOW (BCE5W10) 5000 1
SET_PLAYER_CONTROL player ON

WHILE NOT LOCATE_CHAR_ANY_MEANS_3D scplayer (40.0 0.0 4.0) (5.0 5.0 3.0) TRUE
    WAIT 0
    IF IS_CAR_DEAD mistery1_delivery_car
        PRINT_NOW (BCE5@24) 5000 1
        GOTO mission_mistery1_failed
    ENDIF
ENDWHILE
GOTO mission_mistery1_passed

mission_mistery1_failed:
PRINT_BIG (M_FAIL) 5000 1
RETURN

mission_mistery1_passed:
PRINT_WITH_NUMBER_BIG (M_PASSS 25000) 5000 1 // MISSION PASSED!~n~~w~$~1~~n~~w~RESPECT +
ADD_SCORE player (25000)
                                            // Remember the counters at the top of main.sc?
REGISTER_MISSION_PASSED	(SMOKE_4)           // This builds up to the SET_TOTAL_NUMBER_OF_MISSIONS counter
PLAYER_MADE_PROGRESS 1                      // This builds up to the SET_PROGRESS_TOTAL counter. 
AWARD_PLAYER_MISSION_RESPECT 3              // This builds up to the SET_MISSION_RESPECT_TOTAL counter.
CLEAR_WANTED_LEVEL player
PLAY_MISSION_PASSED_TUNE 1
flag_mistery1_passed = 1
START_NEW_SCRIPT mistery2_loop
RETURN

mission_cleanup_mistery1:
MARK_MODEL_AS_NO_LONGER_NEEDED ZR350
//MARK_CAR_AS_NO_LONGER_NEEDED mistery1_delivery_car  // Not necessary, mission cleanup list does that for us!
REMOVE_BLIP mistery1_delivery_blip
flag_player_on_mission = 0
MISSION_HAS_FINISHED // runs the mission cleanup list
RETURN

}

// IMPORTANT NOTICE:
// Don't START_NEW_SCRIPT into a label inside a mission script.
// Remember, the mission scripts do not persist in memory!
