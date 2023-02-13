// main/initial.sc
//---------------------
// Initialization mission, as explained already in main.sc!
MISSION_START
SCRIPT_NAME initial

flag_mistery1_passed = 0
flag_mistery2_passed = 0
mistery_xpos = 0.0
mistery_ypos = 4.0
mistery_zpos = 4.0

START_NEW_SCRIPT mistery1_loop
ADD_SPRITE_BLIP_FOR_CONTACT_POINT (mistery_xpos mistery_ypos mistery_zpos) RADAR_SPRITE_MYSTERY mistery_blip

MISSION_END