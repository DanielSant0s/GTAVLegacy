SCRIPT_START
{
    LVAR_INT lsc_state lsc_control_state i b_active iMaxItems lsc_selected car_ptr handling pSusp
    LVAR_FLOAT fTemp label_x label_y items_pos items_size item_qt og_suspension suspension
    item_qt = 12.0

    CONST_INT LSCUSTOMS_DISABLED 0
    CONST_INT LSCUSTOMS_REPAIR 1
    CONST_INT LSCUSTOMS_MAIN_MENU 2
    CONST_INT LSCUSTOMS_SUB_MENU 3

    CONST_INT LSCUSTOMS_INIT 0
    CONST_INT LSCUSTOMS_PROCESS 1
    CONST_INT LSCUSTOMS_BACK 2
    CONST_INT LSCUSTOMS_ACCEPT 3

    lsc_control_state = LSCUSTOMS_INIT
    lsc_state = LSCUSTOMS_DISABLED

    VAR_INT cost_menu_shops cost_menu_drawn_shops main_menu_shops main_menu_drawn_shops 
    VAR_INT bought_menu_shops bought_menu_drawn_shops sub_menu_shops sub_menu_drawn_shops

    VAR_INT price_counter

    VAR_INT item_price[20]
    VAR_INT item_model_index[20]
    VAR_TEXT_LABEL item_text_label[20]
    VAR_INT item_modelid[20]
    VAR_INT item_component[20]

    VAR_INT item_hilight_shops[20]

    VAR_INT modelid_shops component_shops special_camera // used to display clothes on the iPlayer

    VAR_INT area_looked_for_shops item_no_shops temp_var_shops

    VAR_INT shop_main_item_picked_shops shop_sub_item_picked_shops

    VAR_TEXT_LABEL $ITEM1 $ITEM2 $ITEM3 $ITEM4 $ITEM5 $ITEM6 $ITEM7 $ITEM8 $ITEM9 $ITEM10 $ITEM11 $ITEM12 // used for 1st menu

    VAR_INT player_item_texture_shops player_item_model_shops // used to check what stuff iPlayer has

    VAR_INT flag_no_money_shops // used to print message to tell iPlayer they have no cash

    VAR_INT flag_bought_item_already_shops

    VAR_INT flag_player_owned_item_shops

    VAR_INT area_to_look_at_shops
    area_to_look_at_shops = 0

    flag_bought_item_already_shops = 0
    flag_no_money_shops = 0
    flag_player_owned_item_shops = 0

    price_counter = 0
    cost_menu_drawn_shops = 0
    main_menu_drawn_shops = 0
    bought_menu_drawn_shops = 0
    sub_menu_drawn_shops = 0
    shop_main_item_picked_shops = 0
    shop_sub_item_picked_shops = 0

    area_looked_for_shops = 0 
    item_no_shops = 0 
    temp_var_shops = 0

    VAR_INT mod_flag control_flag_mod // these are used to say what point the script is at.

    // Car colour and paintjobs
    CONST_INT MOD_GARAGE_PAINTJOB 100
    CONST_INT MOD_GARAGE_CAR_COLOUR 101

    CONST_INT MOD_GARAGE_SUSPENSION 102
    CONST_INT MOD_GARAGE_ENGINE 103
    CONST_INT MOD_GARAGE_BRAKES 104
    CONST_INT MOD_GARAGE_TURBO 105

    VAR_INT number_of_colours
    number_of_colours = 0

    VAR_INT stored_paintjob_number paintjob_number paintjob_number_menu
    stored_paintjob_number = 0
    paintjob_number = 0
    paintjob_number_menu = 0

    VAR_INT no_of_mods_for_vehicle
    no_of_mods_for_vehicle = 0
    

    VAR_INT new_mod_index_wil
    VAR_INT upgradetype_mod
    VAR_INT wing_mod_counter roof_mod_counter exhaust_mod_counter nitro_mod_counter spolier_mod_counter bonnet_mod_counter bonnetLR_mod_counter wheel_mod_counter

    VAR_INT suspension_mod_counter
    suspension_mod_counter = 4

    wheel_mod_counter = 0
    wing_mod_counter = 0 
    roof_mod_counter = 0 
    exhaust_mod_counter = 0 
    nitro_mod_counter = 0 
    spolier_mod_counter = 0 
    bonnet_mod_counter = 0
    bonnetLR_mod_counter = 0

    VAR_INT front_bumper_mod_counter rear_bumper_mod_counter lights_mod_counter front_bullbar_mod_counter rear_bullbar_mod_counter misc_mod_counter
    front_bumper_mod_counter = 0 
    rear_bumper_mod_counter = 0 
    lights_mod_counter = 0 
    front_bullbar_mod_counter = 0 
    rear_bullbar_mod_counter = 0
    misc_mod_counter = 0

    VAR_INT paintjob_mod_counter stereo_mod_counter hydraulics_mod_counter
    paintjob_mod_counter = 0
    stereo_mod_counter = 0
    hydraulics_mod_counter = 0

    VAR_INT wing_mod_model_index[20]
    VAR_INT roof_mod_model_index[20]
    VAR_INT exhaust_mod_model_index[20]
    VAR_INT nitro_mod_model_index[20]
    VAR_INT spolier_mod_model_index[20]
    VAR_INT bonnet_mod_model_index[20]
    VAR_INT bonnetLR_mod_model_index[20]
    VAR_INT front_bumper_mod_model_index[20]
    VAR_INT rear_bumper_mod_model_index[20]
    VAR_INT lights_mod_model_index[20]
    VAR_INT front_bullbar_mod_model_index[20]
    VAR_INT rear_bullbar_mod_model_index[20]
    VAR_INT misc_mod_model_index[20]
    VAR_INT wheel_mod_model_index[20]
    VAR_INT stereo_mod_model_index[20]
    VAR_INT hydraulics_mod_model_index[20]

    CONST_INT VEHICLE_UPGRADE_BONNET 0
    CONST_INT VEHICLE_UPGRADE_BONNET_LEFT_RIGHT 1
    CONST_INT VEHICLE_UPGRADE_SPOILER 2
    CONST_INT VEHICLE_UPGRADE_WING 3
    CONST_INT VEHICLE_UPGRADE_FRONT_BULLBAR 4
    CONST_INT VEHICLE_UPGRADE_REAR_BULLBAR 5
    CONST_INT VEHICLE_UPGRADE_FRONT_LIGHTS 6
    CONST_INT VEHICLE_UPGRADE_ROOF 7
    CONST_INT VEHICLE_UPGRADE_NITRO 8
    CONST_INT VEHICLE_UPGRADE_HYDRAULICS 9
    CONST_INT VEHICLE_UPGRADE_STEREO 10
    CONST_INT VEHICLE_UPGRADE_P11 11
    CONST_INT VEHICLE_REPLACEMENT_WHEEL 12
    CONST_INT VEHICLE_REPLACEMENT_EXHAUST 13
    CONST_INT VEHICLE_REPLACEMENT_FRONT_BUMPER 14
    CONST_INT VEHICLE_REPLACEMENT_REAR_BUMPER 15
    CONST_INT VEHICLE_REPLACEMENT_MISC 16

    VAR_INT upgradetype[20]

    // menu stuff
    VAR_INT upgrade_menu1_selected upgrade_menu2_selected
    VAR_INT mod_counter
    VAR_INT number_of_mods_in_section // used for the price and hilight stuff
    upgrade_menu1_selected = 0
    upgrade_menu2_selected = 0
    mod_counter = 0

    VAR_INT mod_model_index

    // flags to say can you buy, can you mod, is it already on car
    VAR_INT flag_cant_mod flag_car_same_colour
    flag_car_same_colour = 0
    flag_cant_mod = 0
    flag_bought_item_already_shops = 0
    flag_no_money_shops = 0

    VAR_INT unk10416 unk10417
    unk10416 = 0
    unk10417 = 0

    // stored car stuff to return car to normal
    VAR_INT just_replaced_car_mod original_car_mod 

    VAR_INT stored_car_colour1 stored_car_colour2

    VAR_INT third_menu_shops third_menu_drawn_shops
    third_menu_drawn_shops = 0

    VAR_INT colour_menu_shops colour_menu_drawn_shops
    colour_menu_drawn_shops = 0
    main_menu_drawn_shops = 0
    sub_menu_drawn_shops = 0

    CONST_INT RESPRAY_COST_MOD_SHOP 150 // sets the cost of a respray in the mod shop to $500
    CONST_INT PAINTJOB_COST_MODSHOP 500

    VAR_FLOAT car_locate_modX car_locate_modY car_locate_modZ
    car_locate_modX = 0.0
    car_locate_modY = 0.0
    car_locate_modZ = 0.0

    VAR_INT stored_mod_garage_car

    // forth menu stuff
    VAR_TEXT_LABEL $forth_menu_item1 $forth_menu_item2

    VAR_INT forth_menu_shops

    VAR_INT forth_menu_drawn_shops upgrade_menu4_selected
    forth_menu_drawn_shops = 0
    upgrade_menu4_selected = 0

    VAR_INT selected_car_colour_mods upgrade_colour_selected
    selected_car_colour_mods = 0
    upgrade_colour_selected = 0

    VAR_INT car_colour1_change_mods car_colour2_change_mods
    car_colour1_change_mods = 0
    car_colour2_change_mods = 0

    // new menu stuff for car colours
    VAR_INT flag_no_of_car_colours
    flag_no_of_car_colours = 0

    VAR_INT car_name_mod
    car_name_mod = 0

    VAR_INT shop_counter number_of_paintjobs
    shop_counter = 0 
    number_of_paintjobs = 0

    LVAR_INT car_health car_model car_value repair_value rand_multiplier
    LVAR_TEXT_LABEL $shop_name
    repair_value = 0

    lsc_loop:
        IF IS_PLAYER_PLAYING iPlayer
        AND IS_CHAR_SITTING_IN_ANY_CAR hPlayerPed

            IF lsc_state = LSCUSTOMS_DISABLED
                SET_PLAYER_CONTROL iPlayer OFF
	    		TIMERA = 0
	    		DISPLAY_RADAR FALSE
                //DISPLAY_HUD FALSE
	    		SHOW_UPDATE_STATS FALSE

                SET_CAR_DENSITY_MULTIPLIER 0.0

                is_drawing = 1

                STORE_CAR_CHAR_IS_IN_NO_SAVE hPlayerPed (stored_mod_garage_car)
                GET_CAR_HEALTH stored_mod_garage_car (car_health)
                GET_CAR_MODEL stored_mod_garage_car (car_model)
                GET_CAR_MODEL_VALUE car_model (car_value)

                IF IS_CAR_STREET_RACER stored_mod_garage_car
                	LOAD_SHOP carmod3
                ELSE
                    IF IS_CAR_LOW_RIDER stored_mod_garage_car
                        LOAD_SHOP carmod2
                    ELSE
                        LOAD_SHOP carmod1
                    ENDIF
                ENDIF

	    		LOAD_PRICES CarMods

                GET_LOADED_SHOP $shop_name

                GET_NUMBER_OF_ITEMS_IN_SHOP item_no_shops 
                GET_CAR_COLOURS stored_mod_garage_car stored_car_colour1 stored_car_colour2
	    		GET_CURRENT_VEHICLE_PAINTJOB stored_mod_garage_car stored_paintjob_number
                RESET_VEHICLE_HYDRAULICS stored_mod_garage_car
	    		STORE_CAR_MOD_STATE

                IF car_health < 1000
                    repair_value = car_value / car_health
                    car_value = car_model
                    car_value /= 7
                    repair_value += car_value
                    repair_value *= 2

                    IF repair_value < 0
                        repair_value *= -1
                    ENDIF

                    lsc_state = LSCUSTOMS_REPAIR
                    CREATE_MENU UPGRADE 29.0 155.0 186.0 2 TRUE TRUE 0 main_menu_shops
                    SET_MENU_COLUMN main_menu_shops 0 DUMMY FIXVEHI DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY
                    SET_MENU_COLUMN main_menu_shops 1 DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY
                    SET_MENU_COLUMN_WIDTH main_menu_shops 0 140
                    SET_MENU_COLUMN_WIDTH main_menu_shops 1 46

					SET_MENU_COLUMN_ORIENTATION main_menu_shops 0 1
					SET_MENU_COLUMN_ORIENTATION main_menu_shops 1 2

                    SET_MENU_ITEM_WITH_NUMBER main_menu_shops 1 0 DOLLAR repair_value
                ELSE
                    lsc_state = LSCUSTOMS_MAIN_MENU
                ENDIF

                
            ENDIF

            IF lsc_state = LSCUSTOMS_REPAIR
                IF IS_BUTTON_PRESSED PAD1 CROSS
                    FIX_CAR stored_mod_garage_car
                    repair_value *= -1
                    ADD_SCORE iPlayer repair_value
                    repair_value = 0

                    lsc_state = LSCUSTOMS_MAIN_MENU
                    DELETE_MENU main_menu_shops
                ELSE
                    IF IS_BUTTON_PRESSED PAD1 TRIANGLE
                        DELETE_MENU main_menu_shops
                        GOTO lsc_global_cleanup
                    ENDIF
                ENDIF
            ENDIF

            IF lsc_state = LSCUSTOMS_MAIN_MENU
                IF lsc_control_state = LSCUSTOMS_INIT
                    GOSUB fill_in_text_menu1_mod
                    CREATE_MENU UPGRADE 29.0 155.0 186.0 1 TRUE TRUE 0 main_menu_shops
                    SET_MENU_COLUMN main_menu_shops 0 DUMMY $item_text_label[0] $item_text_label[1] $item_text_label[2] $item_text_label[3] $item_text_label[4] $item_text_label[5] $item_text_label[6] $item_text_label[7] $item_text_label[8] $item_text_label[9] $item_text_label[10] $item_text_label[11] 
                    SET_MENU_COLUMN_ORIENTATION main_menu_shops 0 1

                    //START_NEW_SCRIPT separateVehicleHandling
                    //WAIT 0
//
                    //pSusp = backupHandlings[curHandlingIndex] + 0xAC
                    //READ_MEMORY pSusp 4 0 (og_suspension)

                    lsc_control_state = LSCUSTOMS_PROCESS
                ENDIF

                IF lsc_control_state = LSCUSTOMS_PROCESS
                    GET_MENU_ITEM_SELECTED main_menu_shops (upgrade_menu1_selected)

                    IF IS_BUTTON_PRESSED PAD1 CROSS
			    		car_colour1_change_mods = 0
			    		car_colour2_change_mods = 0

			    		IF NOT upgradetype[upgrade_menu1_selected] = MOD_GARAGE_CAR_COLOUR							

			    			IF NOT upgradetype[upgrade_menu1_selected] = MOD_GARAGE_PAINTJOB 
			    				GET_CURRENT_CAR_MOD stored_mod_garage_car upgradetype[upgrade_menu1_selected] original_car_mod
			    			ELSE
			    				GET_CURRENT_VEHICLE_PAINTJOB stored_mod_garage_car stored_paintjob_number 
			    			ENDIF

			    			GOSUB fill_in_text_menu2_mods

			    		ELSE
    
			    			item_price[mod_counter] = RESPRAY_COST_MOD_SHOP

			    			GET_CAR_MODEL stored_mod_garage_car car_name_mod

			    			//GOSUB find_how_many_car_colours_mod

			    		ENDIF

                        lsc_control_state = LSCUSTOMS_ACCEPT
                    ENDIF

                    IF IS_BUTTON_PRESSED PAD1 TRIANGLE
                        lsc_control_state = LSCUSTOMS_BACK
                    ENDIF
                ENDIF

                IF lsc_control_state = LSCUSTOMS_BACK
                    IF NOT IS_BUTTON_PRESSED PAD1 TRIANGLE
                        DELETE_MENU main_menu_shops
                        CLEAR_HELP
                        GOTO lsc_global_cleanup
                    ENDIF
                ENDIF

                IF lsc_control_state = LSCUSTOMS_ACCEPT
                    IF NOT IS_BUTTON_PRESSED PAD1 CROSS
                        lsc_state = LSCUSTOMS_SUB_MENU
                        lsc_control_state = LSCUSTOMS_INIT
                        DELETE_MENU main_menu_shops
                    ENDIF
                ENDIF

            ENDIF

				// iPlayer is in menu two to select items
			IF lsc_state = LSCUSTOMS_SUB_MENU
                IF lsc_control_state = LSCUSTOMS_INIT
				    IF IS_CAR_DEAD stored_mod_garage_car
				    	GOTO lsc_global_cleanup 
				    ENDIF

			  	    IF upgradetype[upgrade_menu1_selected] = MOD_GARAGE_CAR_COLOUR

				    	IF forth_menu_drawn_shops = 0
                            NOP
				    		//GOSUB draw_menu4_mod_shop
				    	ENDIF

			  	    ELSE
    
				    	IF sub_menu_drawn_shops = 0
                            NOP
				    		// GOSUB draw_sub_menu_mod 
				    	ENDIF

			 	    ENDIF

                    SWITCH upgradetype[upgrade_menu1_selected]
                        CASE MOD_GARAGE_SUSPENSION
                            iMaxItems = suspension_mod_counter
                            BREAK
                        CASE VEHICLE_UPGRADE_BONNET
                            iMaxItems = bonnet_mod_counter
                            BREAK
                        CASE VEHICLE_UPGRADE_BONNET_LEFT_RIGHT
                            iMaxItems = bonnetLR_mod_counter
                            BREAK
                        CASE VEHICLE_UPGRADE_SPOILER
                            iMaxItems = spolier_mod_counter
                            BREAK
                        CASE VEHICLE_UPGRADE_WING
                            iMaxItems = wing_mod_counter
                            BREAK
                        CASE VEHICLE_UPGRADE_FRONT_BULLBAR
                            iMaxItems = front_bullbar_mod_counter
                            BREAK
                        CASE VEHICLE_UPGRADE_REAR_BULLBAR
                            iMaxItems = rear_bullbar_mod_counter
                            BREAK
                        CASE VEHICLE_UPGRADE_FRONT_LIGHTS
                            iMaxItems = lights_mod_counter
                            BREAK
                        CASE VEHICLE_UPGRADE_ROOF
                            iMaxItems = roof_mod_counter
                            BREAK
                        CASE VEHICLE_UPGRADE_NITRO
                            iMaxItems = nitro_mod_counter
                            BREAK
                        CASE VEHICLE_UPGRADE_HYDRAULICS
                            iMaxItems = hydraulics_mod_counter
                            BREAK
                        CASE VEHICLE_UPGRADE_STEREO
                            iMaxItems = stereo_mod_counter
                            BREAK
                        CASE VEHICLE_UPGRADE_P11
                            BREAK
                        CASE VEHICLE_REPLACEMENT_WHEEL
                            iMaxItems = wheel_mod_counter
                            BREAK
                        CASE VEHICLE_REPLACEMENT_EXHAUST
                            iMaxItems = exhaust_mod_counter
                            BREAK
                        CASE VEHICLE_REPLACEMENT_FRONT_BUMPER
                            iMaxItems = front_bumper_mod_counter
                            BREAK
                        CASE VEHICLE_REPLACEMENT_REAR_BUMPER
                            iMaxItems = rear_bumper_mod_counter
                            BREAK
                        CASE VEHICLE_REPLACEMENT_MISC
                            iMaxItems = misc_mod_counter
                            BREAK
                    ENDSWITCH

                    CREATE_MENU UPGRADE 29.0 155.0 186.0 2 TRUE TRUE 0 sub_menu_shops

                    SET_MENU_COLUMN sub_menu_shops 0 DUMMY $item_text_label[0] $item_text_label[1] $item_text_label[2] $item_text_label[3] $item_text_label[4] $item_text_label[5] $item_text_label[6] $item_text_label[7] $item_text_label[8] $item_text_label[9] $item_text_label[10] $item_text_label[11] 

                    SET_MENU_COLUMN sub_menu_shops 1 DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY DUMMY
                    //SET_MENU_COLUMN_ORIENTATION sub_menu_shops 1 2
                    SET_MENU_COLUMN_WIDTH sub_menu_shops 0 135
                    SET_MENU_COLUMN_WIDTH sub_menu_shops 1 41
					SET_MENU_COLUMN_ORIENTATION sub_menu_shops 0 1
					SET_MENU_COLUMN_ORIENTATION sub_menu_shops 1 2

                    i = 0
                    WHILE i < iMaxItems
                        SET_MENU_ITEM_WITH_NUMBER sub_menu_shops 1 i DOLLAR item_price[i]
                        i++
                    ENDWHILE

					GOSUB lsc_update_installed_items

                    lsc_control_state = LSCUSTOMS_PROCESS
                ENDIF

			    IF lsc_control_state = LSCUSTOMS_PROCESS
                    GET_MENU_ITEM_SELECTED sub_menu_shops (upgrade_menu2_selected)

                    	IF NOT upgradetype[upgrade_menu1_selected] = MOD_GARAGE_CAR_COLOUR
                            IF NOT upgradetype[upgrade_menu1_selected] = MOD_GARAGE_PAINTJOB
			    			AND NOT upgradetype[upgrade_menu1_selected] = MOD_GARAGE_CAR_COLOUR 
			    	   			mod_model_index = item_model_index[upgrade_menu2_selected]
			    	   			REQUEST_VEHICLE_MOD mod_model_index

                                WHILE NOT HAS_VEHICLE_MOD_LOADED mod_model_index								 
			    					WAIT 0
			    				ENDWHILE

			    				ADD_VEHICLE_MOD stored_mod_garage_car mod_model_index just_replaced_car_mod
			    			   	MARK_VEHICLE_MOD_AS_NO_LONGER_NEEDED mod_model_index

			    	   	   	ENDIF
			    	   	ENDIF 

			    	IF IS_BUTTON_PRESSED PAD1 TRIANGLE
                        lsc_control_state = LSCUSTOMS_BACK
                        RESTORE_CAR_MOD_STATE
			    	ENDIF

			    	IF IS_BUTTON_PRESSED PAD1 CROSS
                        lsc_control_state = LSCUSTOMS_ACCEPT
			    	ENDIF 
    
			    ENDIF

                IF lsc_control_state = LSCUSTOMS_BACK
                    IF NOT IS_BUTTON_PRESSED PAD1 TRIANGLE
                        sub_menu_drawn_shops = 0
			    		DELETE_MENU sub_menu_shops
                        CLEAR_HELP
                        lsc_state = LSCUSTOMS_MAIN_MENU
                        lsc_control_state = LSCUSTOMS_INIT
                    ENDIF
                ENDIF

                IF lsc_control_state = LSCUSTOMS_ACCEPT
                    IF NOT IS_BUTTON_PRESSED PAD1 CROSS
                    	IF NOT upgradetype[upgrade_menu1_selected] = MOD_GARAGE_CAR_COLOUR

			    			GET_MENU_ITEM_SELECTED forth_menu_shops upgrade_menu4_selected

			    			IF upgrade_menu4_selected < 0
			    				upgrade_menu4_selected = 0
			    			ENDIF

			    			IF upgrade_menu4_selected = 0
			    				car_colour1_change_mods = 1	
			    			ELSE
			    				car_colour2_change_mods = 1
			    			ENDIF 
			    	   	ENDIF 

			    		flag_no_money_shops = 0
			    		flag_bought_item_already_shops = 0
			    		flag_car_same_colour = 0

						IF NOT mod_model_index = original_car_mod
							BUY_ITEM mod_model_index
						ENDIF

                        STORE_CAR_MOD_STATE
                        original_car_mod = mod_model_index

						GOSUB lsc_update_installed_items

                        lsc_state = LSCUSTOMS_SUB_MENU
                        lsc_control_State = LSCUSTOMS_PROCESS
                    ENDIF
                ENDIF
														
			ENDIF

        ENDIF
        WAIT 0
    GOTO lsc_loop

    lsc_global_cleanup:
    SET_CAR_DENSITY_MULTIPLIER 1.0
    SET_PLAYER_CONTROL iPlayer ON
    lsc_state = LSCUSTOMS_DISABLED
    DISPLAY_RADAR TRUE
    //DISPLAY_HUD TRUE
    SHOW_UPDATE_STATS TRUE
    is_drawing = 0
    lscustoms_enabled = FALSE

    TERMINATE_THIS_SCRIPT

    // tells the first menu what to have it it
    fill_in_text_menu1_mod:

    no_of_mods_for_vehicle = 0
    wing_mod_counter = 0 
    roof_mod_counter = 0 
    exhaust_mod_counter = 0 
    nitro_mod_counter = 0 
    spolier_mod_counter = 0 
    bonnet_mod_counter = 0
    bonnetLR_mod_counter = 0
    front_bumper_mod_counter = 0 
    rear_bumper_mod_counter = 0 
    lights_mod_counter = 0 
    front_bullbar_mod_counter = 0 
    rear_bullbar_mod_counter = 0
    misc_mod_counter = 0
    wheel_mod_counter = 0
    number_of_paintjobs = 0
    number_of_colours = 0
    hydraulics_mod_counter = 0
    stereo_mod_counter = 0
    shop_counter = 0

    item_text_label[no_of_mods_for_vehicle] = LSCSUSP
    upgradetype[no_of_mods_for_vehicle] = MOD_GARAGE_SUSPENSION
    ++ no_of_mods_for_vehicle

    // gets the number of paintjobs
    GET_NUM_AVAILABLE_PAINTJOBS stored_mod_garage_car number_of_paintjobs

    IF NOT number_of_paintjobs = 0
    	item_text_label[no_of_mods_for_vehicle] = CARM11
    	upgradetype[no_of_mods_for_vehicle] = MOD_GARAGE_PAINTJOB // Means paintjobs
    	++ no_of_mods_for_vehicle 
    ENDIF

    GET_NUM_CAR_COLOURS stored_mod_garage_car number_of_colours

    IF NOT number_of_colours = 0
    	item_text_label[no_of_mods_for_vehicle] = CARM1
    	upgradetype[no_of_mods_for_vehicle] = MOD_GARAGE_CAR_COLOUR // Means paintjobs
    	++ no_of_mods_for_vehicle 
    ENDIF

    // checks the rest of the mods
    WHILE shop_counter < item_no_shops

    	GET_ITEM_IN_SHOP shop_counter new_mod_index_wil
    
       	GET_VEHICLE_MOD_TYPE new_mod_index_wil upgradetype_mod

    	IF upgradetype_mod = VEHICLE_REPLACEMENT_WHEEL

    		IF wheel_mod_counter = 0 
    			item_text_label[no_of_mods_for_vehicle] = CARM12
    			upgradetype[no_of_mods_for_vehicle] = VEHICLE_REPLACEMENT_WHEEL
    			++ no_of_mods_for_vehicle
    		ENDIF
    
    		wheel_mod_model_index[wheel_mod_counter] = new_mod_index_wil 

    		++ wheel_mod_counter
    
    	ENDIF
    
    	IF upgradetype_mod = VEHICLE_UPGRADE_WING

    		IF wing_mod_counter = 0 
    			item_text_label[no_of_mods_for_vehicle] = CARM4
    			upgradetype[no_of_mods_for_vehicle] = VEHICLE_UPGRADE_WING
    			++ no_of_mods_for_vehicle
    		ENDIF
    
    		wing_mod_model_index[wing_mod_counter] = new_mod_index_wil 

    		++ wing_mod_counter
    
    	ENDIF

    	IF upgradetype_mod = VEHICLE_UPGRADE_ROOF

    		IF roof_mod_counter = 0
    			item_text_label[no_of_mods_for_vehicle] = CARM10
    			upgradetype[no_of_mods_for_vehicle] = VEHICLE_UPGRADE_ROOF
    			++ no_of_mods_for_vehicle
    		ENDIF

    		roof_mod_model_index[roof_mod_counter] = new_mod_index_wil 
    
    		++ roof_mod_counter 
    
    	ENDIF

    	IF upgradetype_mod = VEHICLE_REPLACEMENT_EXHAUST
    
    		IF exhaust_mod_counter = 0 
    			item_text_label[no_of_mods_for_vehicle] = CARM5
    			upgradetype[no_of_mods_for_vehicle] = VEHICLE_REPLACEMENT_EXHAUST
    			++ no_of_mods_for_vehicle  
    		ENDIF

    		exhaust_mod_model_index[exhaust_mod_counter] = new_mod_index_wil

    		++ exhaust_mod_counter

    	ENDIF

    	IF upgradetype_mod = VEHICLE_UPGRADE_NITRO
    
    		IF nitro_mod_counter = 0
    			item_text_label[no_of_mods_for_vehicle] = CARM6
    			upgradetype[no_of_mods_for_vehicle] = VEHICLE_UPGRADE_NITRO
    			++ no_of_mods_for_vehicle  
    		ENDIF

    		nitro_mod_model_index[nitro_mod_counter] = new_mod_index_wil 

    		++ nitro_mod_counter

    	ENDIF

    	IF upgradetype_mod = VEHICLE_UPGRADE_SPOILER
    
    		IF spolier_mod_counter = 0
    			item_text_label[no_of_mods_for_vehicle] = CARM2
    			upgradetype[no_of_mods_for_vehicle] = VEHICLE_UPGRADE_SPOILER
    			++ no_of_mods_for_vehicle
    		ENDIF

    		spolier_mod_model_index[spolier_mod_counter] = new_mod_index_wil 
    
    		++ spolier_mod_counter 
    
    	ENDIF
    
    	IF upgradetype_mod = VEHICLE_UPGRADE_BONNET
    
    		IF bonnet_mod_counter = 0			 	 
    			item_text_label[no_of_mods_for_vehicle] = CARM3
    			upgradetype[no_of_mods_for_vehicle] = VEHICLE_UPGRADE_BONNET  
    			++ no_of_mods_for_vehicle
    		ENDIF

    		bonnet_mod_model_index[bonnet_mod_counter] = new_mod_index_wil 

    		++ bonnet_mod_counter 

    	ENDIF

    	IF upgradetype_mod = VEHICLE_UPGRADE_BONNET_LEFT_RIGHT
    
    		IF bonnetLR_mod_counter = 0			 	 
    			item_text_label[no_of_mods_for_vehicle] = CARM17
    			upgradetype[no_of_mods_for_vehicle] = VEHICLE_UPGRADE_BONNET_LEFT_RIGHT  
    			++ no_of_mods_for_vehicle
    		ENDIF

    		bonnetLR_mod_model_index[bonnetLR_mod_counter] = new_mod_index_wil 

    		++ bonnetLR_mod_counter 

    	ENDIF

    	IF upgradetype_mod = VEHICLE_REPLACEMENT_FRONT_BUMPER
    
    		IF front_bumper_mod_counter = 0
    	   		item_text_label[no_of_mods_for_vehicle] = CARM7
    			upgradetype[no_of_mods_for_vehicle] = VEHICLE_REPLACEMENT_FRONT_BUMPER
    			++ no_of_mods_for_vehicle
    		ENDIF

    		front_bumper_mod_model_index[front_bumper_mod_counter] = new_mod_index_wil

    		++ front_bumper_mod_counter
    
    	ENDIF
    
    	IF upgradetype_mod = VEHICLE_REPLACEMENT_REAR_BUMPER
    
    		IF rear_bumper_mod_counter = 0
    			item_text_label[no_of_mods_for_vehicle] = CARM8
    			upgradetype[no_of_mods_for_vehicle] = VEHICLE_REPLACEMENT_REAR_BUMPER
    			++ no_of_mods_for_vehicle
    		ENDIF

    		rear_bumper_mod_model_index[rear_bumper_mod_counter] = new_mod_index_wil 
    
    		++ rear_bumper_mod_counter
    
    	ENDIF

    	IF upgradetype_mod = VEHICLE_UPGRADE_FRONT_LIGHTS
    
    		IF lights_mod_counter = 0
    	 		item_text_label[no_of_mods_for_vehicle] = CARM9
    	 		upgradetype[no_of_mods_for_vehicle] = VEHICLE_UPGRADE_FRONT_LIGHTS  
    			++ no_of_mods_for_vehicle
    		ENDIF

    		lights_mod_model_index[lights_mod_counter] = new_mod_index_wil 

    		++ lights_mod_counter

    	ENDIF

    	IF upgradetype_mod = VEHICLE_UPGRADE_FRONT_BULLBAR
    
    		IF front_bullbar_mod_counter = 0
    	 		item_text_label[no_of_mods_for_vehicle] = CARM13
    	 		upgradetype[no_of_mods_for_vehicle] = VEHICLE_UPGRADE_FRONT_BULLBAR  
    			++ no_of_mods_for_vehicle
    		ENDIF

    		front_bullbar_mod_model_index[front_bullbar_mod_counter] = new_mod_index_wil 

    		++ front_bullbar_mod_counter 

    	ENDIF

    	IF upgradetype_mod = VEHICLE_UPGRADE_REAR_BULLBAR
    
    		IF rear_bullbar_mod_counter = 0 
    			item_text_label[no_of_mods_for_vehicle] = CARM14
    			upgradetype[no_of_mods_for_vehicle] = VEHICLE_UPGRADE_REAR_BULLBAR
    			++ no_of_mods_for_vehicle
    		ENDIF

    		rear_bullbar_mod_model_index[rear_bullbar_mod_counter] = new_mod_index_wil 
    
    		++ rear_bullbar_mod_counter
    
    	ENDIF

    	IF upgradetype_mod = VEHICLE_REPLACEMENT_MISC
    
    		IF misc_mod_counter = 0 
    			item_text_label[no_of_mods_for_vehicle] = CARM15
    			upgradetype[no_of_mods_for_vehicle] = VEHICLE_REPLACEMENT_MISC  
    			++ no_of_mods_for_vehicle
    		ENDIF

    		misc_mod_model_index[misc_mod_counter] = new_mod_index_wil 

    		++ misc_mod_counter

    	ENDIF

    	IF upgradetype_mod = VEHICLE_UPGRADE_HYDRAULICS
    
    		IF hydraulics_mod_counter = 0 
    			item_text_label[no_of_mods_for_vehicle] = CARM18
    			upgradetype[no_of_mods_for_vehicle] = VEHICLE_UPGRADE_HYDRAULICS  
    			++ no_of_mods_for_vehicle
    		ENDIF

    		hydraulics_mod_model_index[hydraulics_mod_counter] = new_mod_index_wil 

    		++ hydraulics_mod_counter

    	ENDIF

    	IF upgradetype_mod = VEHICLE_UPGRADE_STEREO
    
    		IF stereo_mod_counter = 0 
    			item_text_label[no_of_mods_for_vehicle] = CARM16
    			upgradetype[no_of_mods_for_vehicle] = VEHICLE_UPGRADE_STEREO  
    			++ no_of_mods_for_vehicle
    		ENDIF

    		stereo_mod_model_index[stereo_mod_counter] = new_mod_index_wil 

    		++ stereo_mod_counter

    	ENDIF

    	++ shop_counter

    ENDWHILE

    // fills in any blanks that are left
    temp_var_shops = no_of_mods_for_vehicle 

    GOSUB fill_in_menu_blanks

    RETURN

    // gets the names and prices of the items
    fill_in_text_menu2_mods:

        item_text_label[no_of_mods_for_vehicle] = LSCSUSP
    upgradetype[no_of_mods_for_vehicle] = MOD_GARAGE_SUSPENSION
    ++ no_of_mods_for_vehicle

    IF upgradetype[upgrade_menu1_selected] = MOD_GARAGE_SUSPENSION

    	number_of_mods_in_section = 4
    
    	item_text_label[0] = LSCSUSP
    	item_price[0] = 500

        item_text_label[1] = LSCSUSP
    	item_price[1] = 1000

        item_text_label[2] = LSCSUSP
    	item_price[2] = 1500

        item_text_label[3] = LSCSUSP
    	item_price[3] = 2000

    	// fills in any blanks that are left
    	temp_var_shops = 4
    
    	GOSUB fill_in_menu_blanks

    
    ENDIF

    IF upgradetype[upgrade_menu1_selected] = MOD_GARAGE_PAINTJOB

    	mod_counter = 0

    	number_of_mods_in_section = number_of_paintjobs

    	WHILE mod_counter < number_of_paintjobs
    
    		item_text_label[mod_counter] = paintjb 
    	   	item_price[mod_counter] = PAINTJOB_COST_MODSHOP 

    	   	IF stored_paintjob_number = mod_counter
    			item_hilight_shops[mod_counter] = FALSE
    		ELSE
    			item_hilight_shops[mod_counter] = TRUE
    		ENDIF 
    
    		++ mod_counter

    	ENDWHILE

    	// fills in any blanks that are left
    	temp_var_shops = number_of_paintjobs

    	GOSUB fill_in_menu_blanks

    ENDIF

    IF upgradetype[upgrade_menu1_selected]  = VEHICLE_REPLACEMENT_WHEEL

    	mod_counter = 0

    	number_of_mods_in_section = wheel_mod_counter

    	WHILE mod_counter < wheel_mod_counter
    
    		GET_NAME_OF_ITEM wheel_mod_model_index[mod_counter] item_text_label[mod_counter] 
    	   	GET_PRICE_OF_ITEM wheel_mod_model_index[mod_counter] item_price[mod_counter]
    		item_model_index[mod_counter] = wheel_mod_model_index[mod_counter]
    
    		IF original_car_mod = wheel_mod_model_index[mod_counter]
    			item_hilight_shops[mod_counter] = FALSE
    		ELSE
    			item_hilight_shops[mod_counter] = TRUE
    		ENDIF 
    
    		++ mod_counter

    	ENDWHILE

    	// fills in any blanks that are left
    	temp_var_shops = wheel_mod_counter
    
    	GOSUB fill_in_menu_blanks

    
    ENDIF

    IF upgradetype[upgrade_menu1_selected]  = VEHICLE_UPGRADE_WING

    	mod_counter = 0

    	number_of_mods_in_section = wing_mod_counter

    	WHILE mod_counter < wing_mod_counter
    
    		GET_NAME_OF_ITEM wing_mod_model_index[mod_counter] item_text_label[mod_counter] 
    	   	GET_PRICE_OF_ITEM wing_mod_model_index[mod_counter] item_price[mod_counter]
    		item_model_index[mod_counter] = wing_mod_model_index[mod_counter]
    
    		IF original_car_mod = wing_mod_model_index[mod_counter]
    			item_hilight_shops[mod_counter] = FALSE
    		ELSE
    			item_hilight_shops[mod_counter] = TRUE
    		ENDIF   
    
    		++ mod_counter

    	ENDWHILE

    	// fills in any blanks that are left
    	temp_var_shops = wing_mod_counter 

    	GOSUB fill_in_menu_blanks
    
    ENDIF

    IF upgradetype[upgrade_menu1_selected] = VEHICLE_UPGRADE_ROOF 

    	mod_counter = 0

    	number_of_mods_in_section = roof_mod_counter

    	WHILE mod_counter < roof_mod_counter

    		GET_NAME_OF_ITEM roof_mod_model_index[mod_counter] item_text_label[mod_counter] 
    	   	GET_PRICE_OF_ITEM roof_mod_model_index[mod_counter] item_price[mod_counter]
    	   	item_model_index[mod_counter] = roof_mod_model_index[mod_counter]
    
    	   	IF original_car_mod = roof_mod_model_index[mod_counter]
    			item_hilight_shops[mod_counter] = FALSE
    		ELSE
    			item_hilight_shops[mod_counter] = TRUE
    		ENDIF 
    
    		++ mod_counter

    	ENDWHILE

    	// fills in any blanks that are left
    	temp_var_shops = roof_mod_counter 

       GOSUB fill_in_menu_blanks
    
    ENDIF

    IF upgradetype[upgrade_menu1_selected] = VEHICLE_REPLACEMENT_EXHAUST 

    	mod_counter = 0

    	number_of_mods_in_section = exhaust_mod_counter

    	WHILE mod_counter < exhaust_mod_counter

    		GET_NAME_OF_ITEM exhaust_mod_model_index[mod_counter] item_text_label[mod_counter] 
    		GET_PRICE_OF_ITEM exhaust_mod_model_index[mod_counter] item_price[mod_counter]
    		item_model_index[mod_counter] = exhaust_mod_model_index[mod_counter]
    
    		IF original_car_mod = exhaust_mod_model_index[mod_counter]
    			item_hilight_shops[mod_counter] = FALSE
    		ELSE
    			item_hilight_shops[mod_counter] = TRUE
    		ENDIF 
    
    		++ mod_counter

    	ENDWHILE

    	// fills in any blanks that are left
    	temp_var_shops = exhaust_mod_counter 

    	GOSUB fill_in_menu_blanks
    
    ENDIF

    IF upgradetype[upgrade_menu1_selected] = VEHICLE_UPGRADE_NITRO

    	mod_counter = 0

    	number_of_mods_in_section = nitro_mod_counter

    	WHILE mod_counter < nitro_mod_counter

    		GET_NAME_OF_ITEM nitro_mod_model_index[mod_counter] item_text_label[mod_counter] 
    		GET_PRICE_OF_ITEM nitro_mod_model_index[mod_counter] item_price[mod_counter]
    		item_model_index[mod_counter] = nitro_mod_model_index[mod_counter]

    		IF original_car_mod = nitro_mod_model_index[mod_counter]
    			item_hilight_shops[mod_counter] = FALSE
    		ELSE
    			item_hilight_shops[mod_counter] = TRUE
    		ENDIF
    
    		++ mod_counter

    	ENDWHILE

    	// fills in any blanks that are left
    	temp_var_shops = nitro_mod_counter 

    	GOSUB fill_in_menu_blanks
    
    ENDIF

    IF upgradetype[upgrade_menu1_selected] = VEHICLE_UPGRADE_SPOILER 

    	mod_counter = 0

    	number_of_mods_in_section = spolier_mod_counter

    	WHILE mod_counter < spolier_mod_counter

    		GET_NAME_OF_ITEM spolier_mod_model_index[mod_counter] item_text_label[mod_counter] 
    		GET_PRICE_OF_ITEM spolier_mod_model_index[mod_counter] item_price[mod_counter]
    		item_model_index[mod_counter] = spolier_mod_model_index[mod_counter]
    
    		IF original_car_mod = spolier_mod_model_index[mod_counter]
    			item_hilight_shops[mod_counter] = FALSE
    		ELSE
    			item_hilight_shops[mod_counter] = TRUE
    		ENDIF 
    
    		++ mod_counter

    	ENDWHILE

    	// fills in any blanks that are left
    	temp_var_shops = spolier_mod_counter 

    	GOSUB fill_in_menu_blanks
    
    ENDIF

    IF upgradetype[upgrade_menu1_selected] = VEHICLE_UPGRADE_BONNET 

    	mod_counter = 0

    	number_of_mods_in_section = bonnet_mod_counter

    	WHILE mod_counter < bonnet_mod_counter

    		GET_NAME_OF_ITEM bonnet_mod_model_index[mod_counter] item_text_label[mod_counter] 
    		GET_PRICE_OF_ITEM bonnet_mod_model_index[mod_counter] item_price[mod_counter]
    		item_model_index[mod_counter] = bonnet_mod_model_index[mod_counter]
    
    		IF original_car_mod = bonnet_mod_model_index[mod_counter]
    			item_hilight_shops[mod_counter] = FALSE
    		ELSE
    			item_hilight_shops[mod_counter] = TRUE
    		ENDIF 
    
    		++ mod_counter

    	ENDWHILE

    	// fills in any blanks that are left
    	temp_var_shops = bonnet_mod_counter 

    	GOSUB fill_in_menu_blanks
    
    ENDIF

    IF upgradetype[upgrade_menu1_selected] = VEHICLE_UPGRADE_BONNET_LEFT_RIGHT 

    	mod_counter = 0

    	number_of_mods_in_section = bonnetLR_mod_counter

    	WHILE mod_counter < bonnetLR_mod_counter

    		GET_NAME_OF_ITEM bonnetLR_mod_model_index[mod_counter] item_text_label[mod_counter] 
    		GET_PRICE_OF_ITEM bonnetLR_mod_model_index[mod_counter] item_price[mod_counter]
    		item_model_index[mod_counter] = bonnetLR_mod_model_index[mod_counter]
    
    		IF original_car_mod = bonnetLR_mod_model_index[mod_counter]
    			item_hilight_shops[mod_counter] = FALSE
    		ELSE
    			item_hilight_shops[mod_counter] = TRUE
    		ENDIF 
    
    		++ mod_counter

    	ENDWHILE

    	// fills in any blanks that are left
    	temp_var_shops = bonnetLR_mod_counter 

    	GOSUB fill_in_menu_blanks
    
    ENDIF

    IF upgradetype[upgrade_menu1_selected] = VEHICLE_REPLACEMENT_FRONT_BUMPER 

    	mod_counter = 0

    	number_of_mods_in_section = front_bumper_mod_counter

    	WHILE mod_counter < front_bumper_mod_counter

    		GET_NAME_OF_ITEM front_bumper_mod_model_index[mod_counter] item_text_label[mod_counter] 
    		GET_PRICE_OF_ITEM front_bumper_mod_model_index[mod_counter] item_price[mod_counter]
    		item_model_index[mod_counter] = front_bumper_mod_model_index[mod_counter]
    
    		IF original_car_mod = front_bumper_mod_model_index[mod_counter]
    			item_hilight_shops[mod_counter] = FALSE
    		ELSE
    			item_hilight_shops[mod_counter] = TRUE
    		ENDIF 
    
    		++ mod_counter

    	ENDWHILE

    	// fills in any blanks that are left
    	temp_var_shops = front_bumper_mod_counter 

    	GOSUB fill_in_menu_blanks
    
    ENDIF

    IF upgradetype[upgrade_menu1_selected] = VEHICLE_REPLACEMENT_REAR_BUMPER 

    	mod_counter = 0

    	number_of_mods_in_section = rear_bumper_mod_counter

    	WHILE mod_counter < rear_bumper_mod_counter

    		GET_NAME_OF_ITEM rear_bumper_mod_model_index[mod_counter] item_text_label[mod_counter] 
    		GET_PRICE_OF_ITEM rear_bumper_mod_model_index[mod_counter] item_price[mod_counter]
    		item_model_index[mod_counter] = rear_bumper_mod_model_index[mod_counter]
    
    		IF original_car_mod = rear_bumper_mod_model_index[mod_counter]
    			item_hilight_shops[mod_counter] = FALSE
    		ELSE
    			item_hilight_shops[mod_counter] = TRUE
    		ENDIF 
    
    		++ mod_counter

    	ENDWHILE

    	// fills in any blanks that are left
    	temp_var_shops = rear_bumper_mod_counter 

    	GOSUB fill_in_menu_blanks
    
    ENDIF

    IF upgradetype[upgrade_menu1_selected] = VEHICLE_UPGRADE_FRONT_LIGHTS 

    	mod_counter = 0

    	number_of_mods_in_section = lights_mod_counter

    	WHILE mod_counter < lights_mod_counter

    		GET_NAME_OF_ITEM lights_mod_model_index[mod_counter] item_text_label[mod_counter] 
    		GET_PRICE_OF_ITEM lights_mod_model_index[mod_counter] item_price[mod_counter]
    		item_model_index[mod_counter] = lights_mod_model_index[mod_counter]
    
    		IF original_car_mod = lights_mod_model_index[mod_counter]
    			item_hilight_shops[mod_counter] = FALSE
    		ELSE
    			item_hilight_shops[mod_counter] = TRUE
    		ENDIF 
    
    		++ mod_counter

    	ENDWHILE

    	// fills in any blanks that are left
    	temp_var_shops = lights_mod_counter 

    	GOSUB fill_in_menu_blanks
    
    ENDIF

    IF upgradetype[upgrade_menu1_selected] = VEHICLE_UPGRADE_FRONT_BULLBAR 

    	mod_counter = 0

    	number_of_mods_in_section = front_bullbar_mod_counter

    	WHILE mod_counter < front_bullbar_mod_counter

    		GET_NAME_OF_ITEM front_bullbar_mod_model_index[mod_counter] item_text_label[mod_counter] 
    		GET_PRICE_OF_ITEM front_bullbar_mod_model_index[mod_counter] item_price[mod_counter]
    		item_model_index[mod_counter] = front_bullbar_mod_model_index[mod_counter]
    
    		IF original_car_mod = front_bullbar_mod_model_index[mod_counter]
    			item_hilight_shops[mod_counter] = FALSE
    		ELSE
    			item_hilight_shops[mod_counter] = TRUE
    		ENDIF 
    
    		++ mod_counter

    	ENDWHILE

    	// fills in any blanks that are left
    	temp_var_shops = front_bullbar_mod_counter 

    	GOSUB fill_in_menu_blanks
    
    ENDIF

    IF upgradetype[upgrade_menu1_selected] = VEHICLE_UPGRADE_REAR_BULLBAR 

    	mod_counter = 0

    	number_of_mods_in_section = rear_bullbar_mod_counter

    	WHILE mod_counter < rear_bullbar_mod_counter

    		GET_NAME_OF_ITEM rear_bullbar_mod_model_index[mod_counter] item_text_label[mod_counter] 
    		GET_PRICE_OF_ITEM rear_bullbar_mod_model_index[mod_counter] item_price[mod_counter]
    		item_model_index[mod_counter] = rear_bullbar_mod_model_index[mod_counter]
    
    		IF original_car_mod = rear_bullbar_mod_model_index[mod_counter]
    			item_hilight_shops[mod_counter] = FALSE
    		ELSE
    			item_hilight_shops[mod_counter] = TRUE
    		ENDIF 
    
    		++ mod_counter

    	ENDWHILE

    	// fills in any blanks that are left
    	temp_var_shops = rear_bullbar_mod_counter 

    	GOSUB fill_in_menu_blanks	
    
    ENDIF 

    IF upgradetype[upgrade_menu1_selected] = VEHICLE_REPLACEMENT_MISC 

    	mod_counter = 0

    	number_of_mods_in_section = misc_mod_counter

    	WHILE mod_counter < misc_mod_counter

    		GET_NAME_OF_ITEM misc_mod_model_index[mod_counter] item_text_label[mod_counter] 
    		GET_PRICE_OF_ITEM misc_mod_model_index[mod_counter] item_price[mod_counter]
    		item_model_index[mod_counter] = misc_mod_model_index[mod_counter]
    
    		IF original_car_mod = misc_mod_model_index[mod_counter]
    			item_hilight_shops[mod_counter] = FALSE
    		ELSE
    			item_hilight_shops[mod_counter] = TRUE
    		ENDIF 
    
    		++ mod_counter

    	ENDWHILE

    	// fills in any blanks that are left
    	temp_var_shops = misc_mod_counter // no_of_mods_for_vehicle 

    	GOSUB fill_in_menu_blanks	
    
    ENDIF

    IF upgradetype[upgrade_menu1_selected] = VEHICLE_UPGRADE_HYDRAULICS 

    	mod_counter = 0

    	number_of_mods_in_section = hydraulics_mod_counter

    	WHILE mod_counter < hydraulics_mod_counter

    		GET_NAME_OF_ITEM hydraulics_mod_model_index[mod_counter] item_text_label[mod_counter] 
    		GET_PRICE_OF_ITEM hydraulics_mod_model_index[mod_counter] item_price[mod_counter]
    		item_model_index[mod_counter] = hydraulics_mod_model_index[mod_counter]
    
    		IF original_car_mod = hydraulics_mod_model_index[mod_counter]
    			item_hilight_shops[mod_counter] = FALSE
    		ELSE
    			item_hilight_shops[mod_counter] = TRUE
    		ENDIF 
    
    		++ mod_counter

    	ENDWHILE

    	// fills in any blanks that are left
    	temp_var_shops = hydraulics_mod_counter // no_of_mods_for_vehicle 

    	GOSUB fill_in_menu_blanks	
    
    ENDIF

    IF upgradetype[upgrade_menu1_selected] = VEHICLE_UPGRADE_STEREO 

    	mod_counter = 0

    	number_of_mods_in_section = stereo_mod_counter

    	WHILE mod_counter < stereo_mod_counter

    		GET_NAME_OF_ITEM stereo_mod_model_index[mod_counter] item_text_label[mod_counter] 
    		GET_PRICE_OF_ITEM stereo_mod_model_index[mod_counter] item_price[mod_counter]
    		item_model_index[mod_counter] = stereo_mod_model_index[mod_counter]
    
    		IF original_car_mod = stereo_mod_model_index[mod_counter]
    			item_hilight_shops[mod_counter] = FALSE
    		ELSE
    			item_hilight_shops[mod_counter] = TRUE
    		ENDIF 
    
    		++ mod_counter

    	ENDWHILE

    	// fills in any blanks that are left
    	temp_var_shops = stereo_mod_counter // no_of_mods_for_vehicle 

    	GOSUB fill_in_menu_blanks	
    
    ENDIF

    RETURN

    fill_in_menu_blanks:
    	WHILE temp_var_shops < 12
    		item_model_index[temp_var_shops] = -1
    		item_price[temp_var_shops] = 0
    		item_text_label[temp_var_shops] = DUMMY
    		++temp_var_shops 
    	ENDWHILE	
    RETURN

    draw_sub_menu_mod:

    	IF sub_menu_drawn_shops = 0
    
    		PRINT_HELP_FOREVER MODH3 

            // Create and populate the secondary menu.

    		CREATE_MENU UPGRADE 29.0 145.0 186.0 1 TRUE TRUE 1 sub_menu_shops
    
    		SET_MENU_COLUMN sub_menu_shops 0 DUMMY $item_text_label[0] $item_text_label[1] $item_text_label[2] $item_text_label[3] $item_text_label[4] $item_text_label[5] $item_text_label[6] $item_text_label[7] $item_text_label[8] $item_text_label[9] $item_text_label[10] $item_text_label[11] 
			SET_MENU_COLUMN_ORIENTATION sub_menu_shops 0 1

    		IF upgradetype[upgrade_menu1_selected] = MOD_GARAGE_PAINTJOB
    		    temp_var_shops = 0

    			WHILE temp_var_shops < number_of_paintjobs
    				paintjob_number_menu = temp_var_shops + 1
    				SET_MENU_ITEM_WITH_NUMBER sub_menu_shops 0 temp_var_shops PJOB paintjob_number_menu
    				++temp_var_shops
    			ENDWHILE

    		    temp_var_shops = 0

    			WHILE temp_var_shops < number_of_paintjobs
    				ACTIVATE_MENU_ITEM sub_menu_shops temp_var_shops item_hilight_shops[temp_var_shops]
    				++temp_var_shops
    			ENDWHILE
    		ELSE		   
    		    temp_var_shops = 0

    			WHILE temp_var_shops < number_of_mods_in_section
    				ACTIVATE_MENU_ITEM sub_menu_shops temp_var_shops item_hilight_shops[temp_var_shops]
    				++temp_var_shops
    			ENDWHILE
    		ENDIF
    
    		sub_menu_drawn_shops = 1
    	ENDIF
    
    RETURN

	lsc_update_installed_items:
		IF upgradetype[upgrade_menu1_selected] = MOD_GARAGE_PAINTJOB
		    temp_var_shops = 0

			WHILE temp_var_shops < number_of_paintjobs
				paintjob_number_menu = temp_var_shops + 1
				SET_MENU_ITEM_WITH_NUMBER sub_menu_shops 0 temp_var_shops PJOB paintjob_number_menu
				++temp_var_shops
			ENDWHILE

		    temp_var_shops = 0

			WHILE temp_var_shops < number_of_paintjobs
				// ACTIVATE_MENU_ITEM sub_menu_shops temp_var_shops item_hilight_shops[temp_var_shops]
				IF item_hilight_shops[temp_var_shops] = FALSE
					SET_MENU_ITEM_WITH_NUMBER sub_menu_shops 1 temp_var_shops LSCINST temp_var_shops
				ENDIF
				++temp_var_shops
			ENDWHILE
		ELSE		   
		    temp_var_shops = 0

			WHILE temp_var_shops < number_of_mods_in_section
				//ACTIVATE_MENU_ITEM sub_menu_shops temp_var_shops item_hilight_shops[temp_var_shops]
				IF item_hilight_shops[temp_var_shops] = FALSE
					SET_MENU_ITEM_WITH_NUMBER sub_menu_shops 1 temp_var_shops LSCINST temp_var_shops
				ENDIF
				++temp_var_shops
			ENDWHILE
		ENDIF
	RETURN


}
SCRIPT_END

