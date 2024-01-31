
SCRIPT_START
{
    SCRIPT_NAME VPHONE
    //PRINT_FORMATTED_NOW "aaaa" 1000

    CONST_FLOAT SCREEN_WIDTH 92.0

    // VAR_INT switch_cur_char     // player_phone_theme[switch_cur_char]

    VAR_INT player_phone_theme[3] player_phone_wallpaper[2] call_id flag_player_on_activity
    VAR_TEXT_LABEL caller

    LVAR_INT phone_screen last_phone_screen hour min phone_obj phone_flags selec n n2 n3
    LVAR_INT theme_r theme_g theme_b startPoint
    LVAR_INT list_max_items return_screen number_of_list_items
    LVAR_FLOAT posX posY posz angleX angleY angleZ handX
    LVAR_TEXT_LABEL text

    
    //switch_cur_char = PLAYER_MICHAEL  // for debug purposes

    GOSUB define_theme_colors
    GOSUB define_wallpaper
    phone_screen = screen_main

    //phone_screen = screen_call

    CONST_INT bit_is_button_pressed 0

    CONST_INT sprite_phone 1
    CONST_INT sprite_frame 2
    CONST_INT sprite_theme 3
    CONST_INT sprite_ok 4
    //CONST_INT sprite_signal 5
    CONST_INT sprite_enter 6
    CONST_INT sprite_back 7
    CONST_INT sprite_headerbar 5
    CONST_INT sprite_wallpaper 18
    CONST_INT sprite_home 19
    CONST_INT sprite_email 10
    CONST_INT sprite_message 11
    CONST_INT sprite_check 12
    CONST_INT sprite_save 13
    CONST_INT sprite_cont 14
    CONST_INT sprite_setts 15
    CONST_INT sprite_cam 16
    CONST_INT sprite_web 17
      

    CONST_INT item_save 3
    CONST_INT item_camera 6 
    CONST_INT item_settings 5 
    CONST_INT item_email 0
    CONST_INT item_web 7
    CONST_INT item_contacts 4
    CONST_INT item_texts 1
    CONST_INT item_checklist 2

    CONST_INT screen_main 0
    CONST_INT screen_camera 1
    CONST_INT screen_settings 2
    CONST_INT screen_themes 3
    CONST_INT screen_wallpapers 4
    CONST_INT screen_contacts 5
    CONST_INT screen_checklist 6
    CONST_INT screen_email 7
    CONST_INT screen_texts 8

    CONST_INT sprite_trevor 80
    CONST_INT sprite_michael 81
    CONST_INT sprite_franklin 82
     CONST_INT sprite_dani 83

    CONST_INT call_hangout_michael 1
    CONST_INT call_hangout_trevor 2 
    CONST_INT call_hangout_franklin 0

    CONST_INT screen_call 9

    SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed

    REQUEST_MODEL CELLPHONE
    WHILE  NOT HAS_MODEL_LOADED CELLPHONE 
        WAIT 0
    ENDWHILE
    SET_CURRENT_CHAR_WEAPON hPlayerPed 0
    GOSUB generate_phone

    LOAD_TEXTURE_DICTIONARY CONTACT
    LOAD_SPRITE sprite_trevor trevor
    LOAD_SPRITE sprite_michael michael
    LOAD_SPRITE sprite_franklin frank
    //LOAD_SPRITE sprite_dani dani69

    SET_PLAYER_NEVER_GETS_TIRED 0 1
    //selec = 0
    last_phone_screen = -1
    
    SWITCH switch_cur_char
        CASE PLAYER_TREVOR
            LOAD_TEXTURE_DICTIONARY PHONE2   
            LOAD_SPRITE sprite_back back
            LOAD_SPRITE sprite_enter enter 
            LOAD_SPRITE sprite_frame frame
            //LOAD_SPRITE sprite_signal signal 
            LOAD_SPRITE sprite_wallpaper phone

            LOAD_SPRITE sprite_email email
            LOAD_SPRITE sprite_message message
            LOAD_SPRITE sprite_check check
            LOAD_SPRITE sprite_save save
            LOAD_SPRITE sprite_cont cont
            LOAD_SPRITE sprite_setts setts
            LOAD_SPRITE sprite_cam cam
            LOAD_SPRITE sprite_web web
            LOAD_SPRITE sprite_theme theme_icon
            LOAD_SPRITE sprite_ok ok_icon
            
            CONST_FLOAT height_settings 30f
            CONST_FLOAT heightOffset_settings 31f

            WHILE TIMERA > 0
                WAIT 0
                IF NOT last_phone_screen = phone_screen
                    last_phone_screen = phone_screen
                    selec = 0
                    startPoint = 0    
                ENDIF
                USE_TEXT_COMMANDS 0
                GOSUB check_phone_buttons
                SWITCH phone_screen

                    CASE screen_main
                        GOSUB draw_trevor_phone
                        REPEAT 8 n
                            SWITCH n
                                CASE 0
                                    posX = 530f 
                                    posY = 315f
                                    text = IMAIL
                                    BREAK
                                CASE 1
                                    posX = 560f 
                                    posY = 315f
                                    text = IMESS
                                    BREAK
                                CASE 2
                                    posX = 590f 
                                    posY = 315f
                                    text = ICHEC
                                    BREAK
                                CASE 3
                                    posX = 530f 
                                    posY = 347f
                                    text = ISAVE
                                    BREAK
                                CASE 4
                                    posX = 560f 
                                    posY = 347f
                                    text = ICONT
                                    BREAK
                                CASE 5
                                    posX = 590f 
                                    posY = 347f
                                    text = ICONF
                                    BREAK
                                CASE 6
                                    posX = 530f 
                                    posY = 379f
                                    text = ISNAP
                                    BREAK
                                CASE 7
                                    posX = 560f 
                                    posY = 379f
                                    text = IWEB
                                    BREAK
                            ENDSWITCH
                            SET_SPRITES_DRAW_BEFORE_FADE 0
                            n2 = n
                            n2 += 10
                            IF selec = n
                                GOSUB set_text_properties4
                                SET_TEXT_CENTRE 0
                                SET_TEXT_WRAPX 640f          
                                DISPLAY_TEXT 513.5f 272.5f $text
                                DRAW_RECT posX posY (25f 28f) 255 255 255 255
                                IF n = 6
                                    DRAW_SPRITE n2 posx posY (25f 28f) 255 255 255 255
                                ELSE
                                    DRAW_SPRITE n2 posx posY (25f 28f) theme_r theme_g theme_b 255
                                ENDIF
                            ELSE
                                DRAW_RECT posX posY (25f 28f) theme_r theme_g theme_b 255
                                DRAW_SPRITE n2 posx posY (25f 28f) 255 255 255 255
                            ENDIF
                        ENDREPEAT

                        GOSUB check_home_buttons

                    BREAK

                    CASE screen_camera
                        GOSUB snapmatic
                    BREAK

                    CASE screen_settings
                        text = ICONF
                        list_max_items = 1
                        return_screen = screen_main
                        GOSUB draw_trevor_list

                        IF NOT IS_LOCAL_VAR_BIT_SET_CONST phone_flags bit_is_button_pressed
                            IF IS_BUTTON_PRESSED 0 CROSS
                                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                                phone_screen = screen_themes
                            ENDIF              
                        ENDIF
                    BREAK
                    
                    CASE screen_themes
                        text = ITHEME
                        list_max_items = 10
                        return_screen = screen_settings
                        GOSUB draw_trevor_list
                        
                        IF NOT IS_LOCAL_VAR_BIT_SET_CONST phone_flags bit_is_button_pressed   
                            IF IS_BUTTON_PRESSED 0 CROSS
                                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                                player_phone_theme[switch_cur_char] = n2
                                GOSUB define_theme_colors
                            ENDIF
                        ENDIF
                    BREAK

                    CASE screen_contacts
                        text = ICONT
                        list_max_items = 2
                        return_screen = screen_main
                        GOSUB draw_trevor_list
                        IF NOT IS_LOCAL_VAR_BIT_SET_CONST phone_flags bit_is_button_pressed
                            IF IS_BUTTON_PRESSED 0 CROSS
                                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                                IF selec = 0
                                    call_id = call_hangout_michael
                                    GOSUB trevor_call
                                ENDIF
                                IF selec = 1
                                    call_id = call_hangout_franklin
                                    GOSUB trevor_call
                                ENDIF
                            ENDIF
                        ENDIF
                    BREAK
                    CASE screen_checklist
                        text = ICHEC
                        list_max_items = 0
                        return_screen = screen_main
                        GOSUB draw_trevor_list
                    BREAK
                    CASE screen_texts
                        text = IMESS
                        list_max_items = 0
                        return_screen = screen_main
                        GOSUB draw_trevor_list
                    BREAK
                    CASE screen_email
                        text = IMAIL
                        list_max_items = 0
                        return_screen = screen_main
                        GOSUB draw_trevor_list
                    BREAK

                ENDSWITCH

            ENDWHILE

            
        BREAK

        CASE PLAYER_FRANKLIN
            LOAD_TEXTURE_DICTIONARY PHONE0   

            LOAD_SPRITE sprite_frame frame
            LOAD_SPRITE sprite_email email
            LOAD_SPRITE sprite_message messages
            LOAD_SPRITE sprite_check checklist
            LOAD_SPRITE sprite_save quicksave
            LOAD_SPRITE sprite_cont contacts
            LOAD_SPRITE sprite_setts settings
            LOAD_SPRITE sprite_cam snapmatic
            LOAD_SPRITE sprite_web browser
            LOAD_SPRITE sprite_theme theme_icon
            LOAD_SPRITE sprite_ok ok_icon
            LOAD_SPRITE sprite_headerbar header_bar
            LOAD_SPRITE sprite_phone phone
            LOAD_SPRITE sprite_home home

            WHILE timera > 0
                WAIT 0
                USE_TEXT_COMMANDS 0
                IF NOT last_phone_screen = phone_screen
                    last_phone_screen = phone_screen
                    selec = 0
                    startPoint = 0    
                ENDIF
                GOSUB check_phone_buttons

                // CONST_FLOAT SCREEN_WIDTH 92.0

                SWITCH phone_screen
                    CASE screen_main
                        if player_phone_wallpaper[switch_cur_char] = 0
                            DRAW_SPRITE sprite_wallpaper 560.0 329.0 94f 156.0 theme_r theme_g theme_b 255
                        ELSE
                            DRAW_SPRITE sprite_wallpaper 560.0 329.0 94f 156.0 255 255 255 255
                        ENDIF
                        DRAW_SPRITE sprite_home 560.0 277.0 SCREEN_WIDTH 50.0 255 255 255 255
                        GOSUB draw_franklyn_phone
                        GET_TIME_OF_DAY hour min
                        SET_TEXT_EDGE 0 0 0 0 0
                        SET_TEXT_SCALE 0.35 1.9
                        IF min >= 10
                            DISPLAY_TEXT_WITH_2_NUMBERS 545.0 253.0 TIME hour min
                        ELSE
                            DISPLAY_TEXT_WITH_2_NUMBERS 545.0 253.0 TIME_0 hour min
                        ENDIF

                        REPEAT 8 n
                            SWITCH n
                                CASE 0
                                    posX = 533f 
                                    posY = 318.0
                                    text = IMAIL
                                    BREAK
                                CASE 1
                                    posX = 560f 
                                    posY = 318.0
                                    text = IMESS
                                    BREAK
                                CASE 2
                                    posX = 587.0 
                                    posY = 318.0
                                    text = ICHEC
                                    BREAK
                                CASE 3
                                    posX = 533.0 
                                    posY = 350.0
                                    text = ISAVE
                                    BREAK
                                CASE 4
                                    posX = 560f 
                                    posY = 350.0
                                    text = ICONT
                                    BREAK
                                CASE 5
                                    posX = 587.0 
                                    posY = 350.0
                                    text = ICONF
                                    BREAK
                                CASE 6
                                    posX = 533.0 
                                    posY = 382.0
                                    text = ISNAP
                                    BREAK
                                CASE 7
                                    posX = 560.0 
                                    posY = 382.0
                                    text = IWEB
                                    BREAK
                            ENDSWITCH
                            SET_SPRITES_DRAW_BEFORE_FADE 0
                            n2 = n + 10
                            // n2 += 10
                            IF selec = n
                                GOSUB set_text_properties4                    
                                DISPLAY_TEXT 560.0 283.0 $text
                                DRAW_RECT posX posY (25.0 32.2) theme_r theme_g theme_b 150
                            ENDIF
                            DRAW_SPRITE n2 posx posY (27.0 34.2) 255 255 255 255
                        ENDREPEAT

                        GOSUB check_home_buttons

                    BREAK
                    CASE screen_camera
                        GOSUB snapmatic
                    BREAK
                    CASE screen_contacts
                        text = ICONT
                        list_max_items = 2
                        return_screen = screen_main
                        GOSUB draw_frank_list
                        IF NOT IS_LOCAL_VAR_BIT_SET_CONST phone_flags bit_is_button_pressed
                            IF IS_BUTTON_PRESSED 0 CROSS
                                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                                IF selec = 0
                                    call_id = call_hangout_michael
                                    GOSUB frank_call
                                ENDIF
                                IF selec = 1
                                    call_id = call_hangout_trevor
                                    GOSUB frank_call
                                ENDIF
                            ENDIF
                        ENDIF
                    BREAK
                    CASE screen_checklist
                        text = ICHEC
                        list_max_items = 0
                        return_screen = screen_main
                        GOSUB draw_frank_list
                    BREAK
                    CASE screen_texts
                        text = IMESS
                        list_max_items = 0
                        return_screen = screen_main
                        GOSUB draw_frank_list
                    BREAK
                    CASE screen_email
                        text = IMAIL
                        list_max_items = 0
                        return_screen = screen_main
                        GOSUB draw_frank_list
                    BREAK
                    CASE screen_settings
                        text = ICONF
                        list_max_items = 2
                        return_screen = screen_main
                        GOSUB draw_frank_list

                        IF NOT IS_LOCAL_VAR_BIT_SET_CONST phone_flags bit_is_button_pressed

                            IF IS_BUTTON_PRESSED 0 CROSS
                                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                                IF selec = 0
                                    phone_screen = screen_themes
                                ELSE
                                    phone_screen = screen_wallpapers
                                ENDIF
                                //startPoint = 0
                                //selec = 0
                            ENDIF              
                        ENDIF

                        

                    BREAK
                    CASE screen_wallpapers
                        text =  WALLP
                        list_max_items = 5
                        return_screen =  screen_settings
                        GOSUB draw_frank_list
                        
                        IF NOT IS_LOCAL_VAR_BIT_SET_CONST phone_flags bit_is_button_pressed
                            
                            IF IS_BUTTON_PRESSED 0 CROSS
                                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed 
                                player_phone_wallpaper[switch_cur_char] = n2
                                GOSUB define_wallpaper
                                //player_phone_theme[switch_cur_char] = n2
                                //GOSUB define_theme_colors
                            ENDIF
                        ENDIF
                    BREAK

                    CASE screen_themes

                        text = ITHEME
                        list_max_items = 10
                        return_screen = screen_settings
                        GOSUB draw_frank_list
                        
                        IF NOT IS_LOCAL_VAR_BIT_SET_CONST phone_flags bit_is_button_pressed
                            
                            IF IS_BUTTON_PRESSED 0 CROSS
                                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                                
                                player_phone_theme[switch_cur_char] = n2
                                GOSUB define_theme_colors
                            ENDIF

                            

                        ENDIF

                    BREAK
                ENDSWITCH
                
            ENDWHILE
        BREAK

        CASE PLAYER_MICHAEL
            LOAD_TEXTURE_DICTIONARY PHONE1   

            LOAD_SPRITE sprite_frame frame

            LOAD_SPRITE sprite_email email
            LOAD_SPRITE sprite_message messages
            LOAD_SPRITE sprite_check checklist
            LOAD_SPRITE sprite_save quicksave
            LOAD_SPRITE sprite_cont contacts
            LOAD_SPRITE sprite_setts settings
            LOAD_SPRITE sprite_cam snapmatic
            LOAD_SPRITE sprite_web browser
            LOAD_SPRITE sprite_theme theme_icon
            LOAD_SPRITE sprite_ok ok_icon

            LOAD_SPRITE sprite_headerbar header_bar
            LOAD_SPRITE sprite_phone phone
            LOAD_SPRITE sprite_home home

            WHILE timera > 0
                WAIT 0
                IF NOT last_phone_screen = phone_screen
                    last_phone_screen = phone_screen
                    selec = 0
                    startPoint = 0    
                ENDIF
                USE_TEXT_COMMANDS 0
                GOSUB check_phone_buttons

                SWITCH phone_screen
                    CASE screen_main
                        DRAW_SPRITE sprite_phone 560.0 340.0 105.0 250.0 255 255 255 255 //
                        if player_phone_wallpaper[switch_cur_char] = 0
                            DRAW_SPRITE sprite_wallpaper 560.0 329.0 88f 154.0 theme_r theme_g theme_b 255
                        ELSE
                            DRAW_SPRITE sprite_wallpaper 560.0 329.0 88f 154.0 255 255 255 255
                        ENDIF
                        DRAW_RECT 560.0 257.0 88f 10.0 0 0 0 255
                        DRAW_SPRITE sprite_frame 560.0 340.0 105.0 250.0 theme_r theme_g theme_b 255
                        DRAW_SPRITE sprite_home 560.0 336.0 109.0 250.0 255 255 255 255
                        DRAW_SPRITE sprite_headerbar 560.0 271.4 88.0 18.0 theme_r theme_g theme_b 255
                        
                        GET_TIME_OF_DAY hour min
                        SET_TEXT_EDGE 0 0 0 0 0
                        SET_TEXT_CENTRE 1
                        SET_TEXT_SCALE 0.25 1.1
                        IF min >= 10
                            DISPLAY_TEXT_WITH_2_NUMBERS 560.0 252.0 TIME hour min
                        ELSE
                            DISPLAY_TEXT_WITH_2_NUMBERS 560.0 252.0 TIME_0 hour min
                        ENDIF

                        REPEAT 8 n
                            SWITCH n
                                CASE 0
                                    posX = 533f 
                                    posY = 306.0
                                    text = IMAIL
                                    BREAK
                                CASE 1
                                    posX = 560f 
                                    posY = 306.0
                                    text = IMESS
                                    BREAK
                                CASE 2
                                    posX = 587.0 
                                    posY = 306.0
                                    text = ICHEC
                                    BREAK
                                CASE 3
                                    posX = 533.0 
                                    posY = 340.0
                                    text = ISAVE
                                    BREAK
                                CASE 4
                                    posX = 560f 
                                    posY = 340.0
                                    text = ICONT
                                    BREAK
                                CASE 5
                                    posX = 587.0 
                                    posY = 340.0
                                    text = ICONF
                                    BREAK
                                CASE 6
                                    posX = 533.0 
                                    posY = 372.0
                                    text = ISNAP
                                    BREAK
                                CASE 7
                                    posX = 560.0 
                                    posY = 372.0
                                    text = IWEB
                                    BREAK
                            ENDSWITCH
                            SET_SPRITES_DRAW_BEFORE_FADE 0
                            n2 = n + 10
                            // n2 += 10
                            IF selec = n
                                GOSUB set_text_properties4                    
                                DISPLAY_TEXT 560.0 265.0 $text // 560.0 272.2
                                DRAW_RECT posX posY (25.0 32.2) theme_r theme_g theme_b 150
                            ENDIF
                            DRAW_SPRITE n2 posx posY (27.0 34.2) 255 255 255 255
                        ENDREPEAT

                        GOSUB check_home_buttons

                    BREAK
                    CASE screen_camera
                        GOSUB snapmatic
                    BREAK
                    CASE screen_contacts
                        text = ICONT
                        list_max_items = 2
                        return_screen = screen_main
                        GOSUB draw_michael_list
                        IF NOT IS_LOCAL_VAR_BIT_SET_CONST phone_flags bit_is_button_pressed
                            IF IS_BUTTON_PRESSED 0 CROSS
                                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                                IF selec = 0
                                    call_id = call_hangout_trevor
                                    GOSUB michael_call
                                ENDIF
                                IF selec = 1
                                    call_id = call_hangout_franklin
                                    GOSUB michael_call
                                ENDIF
                            ENDIF
                        ENDIF
                    BREAK
                    CASE screen_checklist
                        text = ICHEC
                        list_max_items = 0
                        return_screen = screen_main
                        GOSUB draw_michael_list
                    BREAK
                    CASE screen_texts
                        text = IMESS
                        list_max_items = 0
                        return_screen = screen_main
                        GOSUB draw_michael_list
                    BREAK
                    CASE screen_email
                        text = IMAIL
                        list_max_items = 0
                        return_screen = screen_main
                        GOSUB draw_michael_list
                    BREAK
                    CASE screen_settings
                        text = ICONF
                        list_max_items = 2
                        return_screen = screen_main
                        GOSUB draw_michael_list

                        IF NOT IS_LOCAL_VAR_BIT_SET_CONST phone_flags bit_is_button_pressed

                            IF IS_BUTTON_PRESSED 0 CROSS
                                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                                IF selec = 0
                                    phone_screen = screen_themes
                                ELSE
                                    phone_screen = screen_wallpapers
                                ENDIF
                            ENDIF              
                        ENDIF
                    BREAK
                    CASE screen_wallpapers
                        text =  WALLP
                        list_max_items = 5
                        return_screen =  screen_settings
                        GOSUB draw_michael_list
                        
                        IF NOT IS_LOCAL_VAR_BIT_SET_CONST phone_flags bit_is_button_pressed
                            
                            IF IS_BUTTON_PRESSED 0 CROSS
                                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed 
                                player_phone_wallpaper[switch_cur_char] = n2
                                GOSUB define_wallpaper
                                //player_phone_theme[switch_cur_char] = n2
                                //GOSUB define_theme_colors
                            ENDIF
                        ENDIF
                    BREAK

                    CASE screen_themes

                        text = ITHEME
                        list_max_items = 10
                        return_screen = screen_settings
                        GOSUB draw_michael_list
                        IF NOT IS_LOCAL_VAR_BIT_SET_CONST phone_flags bit_is_button_pressed
                            IF IS_BUTTON_PRESSED 0 CROSS
                                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                                player_phone_theme[switch_cur_char] = n2
                                GOSUB define_theme_colors
                            ENDIF
                        ENDIF
                    BREAK
                ENDSWITCH
            ENDWHILE
        BREAK
    ENDSWITCH

    
    SET_PLAYER_NEVER_GETS_TIRED 0 0
    MARK_MODEL_AS_NO_LONGER_NEEDED CELLPHONE
    WAIT 0
    REMOVE_TEXTURE_DICTIONARY
    IF DOES_OBJECT_EXIST phone_obj
        DELETE_OBJECT phone_obj
    ENDIF
    IF NOT IS_CHAR_IN_ANY_CAR hPlayerPed
        CLEAR_CHAR_TASKS_IMMEDIATELY hPlayerPed
    ENDIF
    is_drawing = 0
    WRITE_MEMORY (pAllowRadioWheelDrawing, 4, 1 TRUE)
    TERMINATE_THIS_SCRIPT

    draw_michael_list:
        DRAW_SPRITE sprite_phone 560.0 340.0 105.0 250.0 255 255 255 255 
        DRAW_RECT 560.0 330.0 88f 125f 255 255 255 255 // 560.0 329.0 SCREEN_WIDTH 154.0
        DRAW_RECT 560.0 257.0 88f 15.0 0 0 0 255
        DRAW_SPRITE sprite_frame 560.0 340.0 105.0 250.0 theme_r theme_g theme_b 255
        DRAW_SPRITE sprite_home 560.0 336.0 109.0 250.0 255 255 255 255
        DRAW_SPRITE sprite_headerbar 560.0 271.4 88.0 18.0 theme_r theme_g theme_b 255
        
        GET_TIME_OF_DAY hour min
        SET_TEXT_EDGE 0 0 0 0 0
        SET_TEXT_CENTRE 1
        SET_TEXT_SCALE 0.25 1.1
        IF min >= 10
            DISPLAY_TEXT_WITH_2_NUMBERS 560.0 252.0 TIME hour min
        ELSE
            DISPLAY_TEXT_WITH_2_NUMBERS 560.0 252.0 TIME_0 hour min
        ENDIF
        IF list_max_items > 5
            number_of_list_items = 5
        ELSE 
            number_of_list_items = list_max_items 
        ENDIF

        GOSUB set_text_properties4 
        //SET_TEXT_CENTRE 1
        //DISPLAY_TEXT 560.0 262.0 $text  
        GOSUB set_text_properties4                    
        DISPLAY_TEXT 560.0 265.0 $text


        posy = 291.2f  
        REPEAT 5 n
            IF list_max_items > n
                n2 = n 
                n2 += startPoint

                if phone_screen = screen_contacts
                    SWITCH n2
                        CASE 0
                            text = TREVOR
                            n3 = sprite_trevor
                        BREAK
                        CASE 1
                            text = FRANK
                            n3 = sprite_franklin
                        BREAK
                    ENDSWITCH   
                ENDIF

                IF phone_screen = screen_wallpapers
                    IF n2 = player_phone_wallpaper[switch_cur_char]//player_phone_theme[switch_cur_char]
                        n3 = sprite_ok
                    ELSE
                        n3 = sprite_theme
                    ENDIF
                    SWITCH n2
                        CASE 0
                        text = WAL0
                        BREAK
                        CASE 1
                        text = WAL1
                        BREAK
                        CASE 2
                        text = WAL2
                        BREAK
                        CASE 3
                        text = WAL3
                        BREAK
                        CASE 4
                        text = WAL4
                        BREAK
                    ENDSWITCH

                ENDIF
            
                IF phone_screen = screen_themes
                    IF n2 = player_phone_theme[switch_cur_char]
                        n3 = sprite_ok
                    ELSE
                        n3 = sprite_theme
                    ENDIF
                    SWITCH n2
                        CASE 0
                        text = ICOL0
                        BREAK
                        CASE 1
                        text = ICOL1
                        BREAK
                        CASE 2
                        text = ICOL2
                        BREAK
                        CASE 3
                        text = ICOL3
                        BREAK
                        CASE 4
                        text = ICOL4
                        BREAK
                        CASE 5
                        text = ICOL5
                        BREAK
                        CASE 6
                        text = ICOL6
                        BREAK
                        CASE 7
                        text = ICOL7
                        BREAK
                        CASE 8
                        text = ICOL8
                        BREAK
                        CASE 9
                        text = ICOL9
                        BREAK

                    ENDSWITCH
                ENDIF

                IF phone_screen = screen_settings
                    n3 = sprite_theme
                    SWITCH n2
                        CASE 0
                        text = ITHEME
                        BREAK
                        CASE 1
                        text = WALLP
                        BREAK
                    ENDSWITCH
                ENDIF

                GOSUB set_text_properties5 
                IF n = selec
                    DRAW_RECT 560.0 posy 88f settings_trevor_height theme_r theme_g theme_b 255
                    DRAW_SPRITE n3 525f posy 15f 15f 255 255 255 255   
                    SET_TEXT_COLOUR 255 255 255 255  
                ELSE
                    IF phone_screen = screen_contacts
                        DRAW_SPRITE n3 525f posy 15f 15f 255 255 255 255
                    ELSE
                        DRAW_SPRITE n3 525f posy 15f 15f 0 0 0 255 
                    ENDIF 
                ENDIF 
                posz = posy
                posZ -= 7.0f
                SET_TEXT_WRAPX 640f
                DISPLAY_TEXT_WITH_NUMBER 535f posZ $text n2 
                
                posy += settings_trevor_height
            ENDIF
        ENDREPEAT


        IF NOT IS_LOCAL_VAR_BIT_SET_CONST phone_flags bit_is_button_pressed
 
            IF IS_BUTTON_PRESSED PAD1 DPADDOWN 
                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                n3 = number_of_list_items - 1
                IF selec < n3 // 4
                    selec += 1
                ELSE 
                    n3 = list_max_items - 1

                    IF n2 < n3
                        startPoint += 1
                    ELSE 
                        selec = 0
                        startPoint = 0
                    ENDIF
                ENDIF
            ENDIF

            IF IS_BUTTON_PRESSED PAD1 DPADUP 
                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                IF selec > 0
                    selec -= 1
                ELSE 
                    IF startPoint > 0
                    startPoint -= 1
                    ELSE  
                        selec = number_of_list_items - 1 // 4
                        startPoint = list_max_items - number_of_list_items // 5 
                    ENDIF
                ENDIF
            ENDIF

            IF IS_BUTTON_PRESSED 0 CIRCLE
                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                phone_screen = return_screen
            ENDIF

        ENDIF

        n2 = selec 
        n2 += startPoint

    RETURN

    draw_frank_list:
        GOSUB draw_franklyn_phone
        DRAW_RECT 560.0 334.0 SCREEN_WIDTH 144.0 255 255 255 255
        DRAW_RECT 560.0 257.0 SCREEN_WIDTH 10.0 0 0 0 255
        DRAW_SPRITE sprite_headerbar 560.0 271.2 SCREEN_WIDTH 18.0 theme_r theme_g theme_b 255
        GET_TIME_OF_DAY hour min
        SET_TEXT_EDGE 0 0 0 0 0
        SET_TEXT_SCALE 0.25 1.1
        IF min >= 10
            DISPLAY_TEXT_WITH_2_NUMBERS 517.0 250.0 TIME hour min
        ELSE
            DISPLAY_TEXT_WITH_2_NUMBERS 517.0 250.0 TIME_0 hour min
        ENDIF

        IF list_max_items > 5
            number_of_list_items = 5
        ELSE 
            number_of_list_items = list_max_items 
        ENDIF

        GOSUB set_text_properties4 
        SET_TEXT_CENTRE 1
        DISPLAY_TEXT 560.0 262.0 $text  

        CONST_FLOAT settings_height 25.2f

        posy = 292.2f  // 23f
        REPEAT 5 n
            IF list_max_items > n
                n2 = n 
                n2 += startPoint

                if phone_screen = screen_contacts
                    SWITCH n2
                        CASE 0
                        text = MICHAEL
                        n3 = sprite_michael
                        BREAK
                        CASE 1
                        text = TREVOR
                        n3 = sprite_trevor
                        BREAK
                    ENDSWITCH   
                ENDIF

                IF phone_screen = screen_wallpapers
                    IF n2 = player_phone_wallpaper[switch_cur_char]//player_phone_theme[switch_cur_char]
                        n3 = sprite_ok
                    ELSE
                        n3 = sprite_theme
                    ENDIF
                    SWITCH n2
                        CASE 0
                        text = WAL0
                        BREAK
                        CASE 1
                        text = WAL1
                        BREAK
                        CASE 2
                        text = WAL2
                        BREAK
                        CASE 3
                        text = WAL3
                        BREAK
                        CASE 4
                        text = WAL4
                        BREAK
                    ENDSWITCH

                ENDIF
            
                IF phone_screen = screen_themes
                    IF n2 = player_phone_theme[switch_cur_char]
                        n3 = sprite_ok
                    ELSE
                        n3 = sprite_theme
                    ENDIF
                    SWITCH n2
                        CASE 0
                        text = ICOL0
                        BREAK
                        CASE 1
                        text = ICOL1
                        BREAK
                        CASE 2
                        text = ICOL2
                        BREAK
                        CASE 3
                        text = ICOL3
                        BREAK
                        CASE 4
                        text = ICOL4
                        BREAK
                        CASE 5
                        text = ICOL5
                        BREAK
                        CASE 6
                        text = ICOL6
                        BREAK
                        CASE 7
                        text = ICOL7
                        BREAK
                        CASE 8
                        text = ICOL8
                        BREAK
                        CASE 9
                        text = ICOL9
                        BREAK

                    ENDSWITCH
                ENDIF

                IF phone_screen = screen_settings
                    n3 = sprite_theme
                    SWITCH n2
                        CASE 0
                        text = ITHEME
                        BREAK
                        CASE 1
                        text = WALLP
                        BREAK
                    ENDSWITCH
                ENDIF

                GOSUB set_text_properties5 
                IF n = selec
                    DRAW_RECT 560.0 posy SCREEN_WIDTH settings_height theme_r theme_g theme_b 255
                    DRAW_SPRITE n3 525f posy 15f 15f 255 255 255 255   
                    SET_TEXT_COLOUR 255 255 255 255  
                ELSE
                    if phone_screen = screen_contacts
                        DRAW_SPRITE n3 525f posy 15f 15f 255 255 255 255  
                    ELSE
                        DRAW_SPRITE n3 525f posy 15f 15f theme_r theme_g theme_b 255  
                    ENDIF
                ENDIF 

                
                posz = posy
                posZ -= 7.0f
                SET_TEXT_WRAPX 640f
                DISPLAY_TEXT_WITH_NUMBER 535f posZ $text n2 
                
                posy += settings_height
            ENDIF
        ENDREPEAT


        IF NOT IS_LOCAL_VAR_BIT_SET_CONST phone_flags bit_is_button_pressed
 
            IF IS_BUTTON_PRESSED PAD1 DPADDOWN 
                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                n3 = number_of_list_items - 1
                IF selec < n3 // 4
                    selec += 1
                ELSE 
                    n3 = list_max_items - 1

                    IF n2 < n3
                        startPoint += 1
                    ELSE 
                        selec = 0
                        startPoint = 0
                    ENDIF
                ENDIF
            ENDIF

            IF IS_BUTTON_PRESSED PAD1 DPADUP 
                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                IF selec > 0
                    selec -= 1
                ELSE 
                    IF startPoint > 0
                    startPoint -= 1
                    ELSE  
                        selec = number_of_list_items - 1 // 4
                        startPoint = list_max_items - number_of_list_items // 5 
                    ENDIF
                ENDIF
            ENDIF

            IF IS_BUTTON_PRESSED 0 CIRCLE
                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                phone_screen = return_screen
            ENDIF

        ENDIF

        n2 = selec 
        n2 += startPoint

    RETURN

    michael_call:
        TIMERA = 1
        GOSUB set_call_sprites
        text = DIAL
        
        PLAY_MISSION_AUDIO 1
        TIMERA = 0
        WHILE TIMERA < 3000
            WAIT 0
            GOSUB draw_michael_call
        ENDWHILE
        CLEAR_MISSION_AUDIO 1 
        
        IF flag_player_on_activity = 0
            text = CONEC
            // temporario:
            WHILE TIMERA < 5000   
                WAIT 0
                GOSUB draw_michael_call 
            ENDWHILE
            //
        ELSE
            text = BUSY
            WHILE TIMERA < 5000
                WAIT 0
                GOSUB draw_michael_call 
            ENDWHILE
            RETURN
        ENDIF
        IF call_id = call_hangout_trevor
 
        ENDIF
        IF call_id = call_hangout_franklin

        ENDIF
        GOSUB hangout_start 
    RETURN

    draw_michael_call:
        USE_TEXT_COMMANDS 0
        SET_SPRITES_DRAW_BEFORE_FADE 1
        DRAW_SPRITE sprite_phone 560.0 340.0 105.0 250.0 255 255 255 255 
        SET_SPRITES_DRAW_BEFORE_FADE 1
        DRAW_RECT 560.0 330.0 88f 125f 0 0 0 255 // 560.0 329.0 SCREEN_WIDTH 154.0
        SET_SPRITES_DRAW_BEFORE_FADE 1
        DRAW_RECT 560.0 257.0 88f 15.0 0 0 0 255
        SET_SPRITES_DRAW_BEFORE_FADE 1
        DRAW_SPRITE sprite_frame 560.0 340.0 105.0 250.0 theme_r theme_g theme_b 255
        SET_SPRITES_DRAW_BEFORE_FADE 1
        DRAW_SPRITE sprite_home 560.0 336.0 109.0 250.0 255 255 255 255
        
        
        GET_TIME_OF_DAY hour min
        SET_TEXT_EDGE 0 0 0 0 0
        SET_TEXT_CENTRE 1
        SET_TEXT_SCALE 0.25 1.1
        IF min >= 10
            DISPLAY_TEXT_WITH_2_NUMBERS 560.0 252.0 TIME hour min
        ELSE
            DISPLAY_TEXT_WITH_2_NUMBERS 560.0 252.0 TIME_0 hour min
        ENDIF

        GOSUB set_text_properties6
        DISPLAY_TEXT 520.0 268.0 $caller  
        SET_SPRITES_DRAW_BEFORE_FADE 1
        DRAW_SPRITE n3 529f 299f 25f 25f 255 255 255 255

        GOSUB set_text_properties7
        SET_TEXT_FONT 2
        DISPLAY_TEXT 545.0 285.0 $text

    RETURN

    trevor_call:

        TIMERA = 1
        GOSUB set_call_sprites
        text = DIAL
        
        PLAY_MISSION_AUDIO 1
        TIMERA = 0
        WHILE TIMERA < 3000
            WAIT 0
            GOSUB draw_trevor_call
        ENDWHILE
        CLEAR_MISSION_AUDIO 1 
        
        IF flag_player_on_activity = 0
            text = CONEC
            // temporario:
            WHILE TIMERA < 5000   
                WAIT 0
                GOSUB draw_trevor_call 
            ENDWHILE
            //
        ELSE
            text = BUSY
            WHILE TIMERA < 5000
                WAIT 0
                GOSUB draw_trevor_call 
            ENDWHILE
            RETURN
        ENDIF
        IF call_id = call_hangout_michael
 
        ENDIF
        IF call_id = call_hangout_franklin

        ENDIF
        GOSUB hangout_start 

    RETURN,,

    draw_trevor_call:
        USE_TEXT_COMMANDS 0
        SET_SPRITES_DRAW_BEFORE_FADE 1
       DRAW_SPRITE sprite_wallpaper 560.0 340.0 105.0 250.0 255 255 255 255
       SET_SPRITES_DRAW_BEFORE_FADE 1
        DRAW_SPRITE sprite_frame 560.0 340.0 105.0 250.0 theme_r theme_g theme_b 255
        GET_TIME_OF_DAY hour min
        GOSUB set_text_properties
        IF 10 > min
            DISPLAY_TEXT_WITH_2_NUMBERS 560.5f 260f TIME_0 hour min
        ELSE
            DISPLAY_TEXT_WITH_2_NUMBERS 560.5f 260f TIME hour min
        ENDIF

        GOSUB set_text_properties6
        DISPLAY_TEXT 515.0 278.0 $caller  
        SET_SPRITES_DRAW_BEFORE_FADE 1
        DRAW_SPRITE n3 529f 309f 25f 25f 255 255 255 255

        GOSUB set_text_properties7
        SET_TEXT_FONT 2
        DISPLAY_TEXT 545.0 295.0 $text

    RETURN

    frank_call:

        TIMERA = 1
        GOSUB set_call_sprites
        text = DIAL
        
        PLAY_MISSION_AUDIO 1
        TIMERA = 0
        WHILE TIMERA < 3000
            WAIT 0
            GOSUB draw_frank_call
        ENDWHILE
        CLEAR_MISSION_AUDIO 1 
        
        IF flag_player_on_activity = 0
            text = CONEC
        ELSE
            text = BUSY
            WHILE TIMERA < 5000
                WAIT 0
                GOSUB draw_frank_call 
            ENDWHILE
            RETURN
        ENDIF
        IF call_id = call_hangout_michael
            WHILE TIMERA < 14000
                WAIT 0
                GOSUB draw_frank_call
                IF TIMERA > 4000
                    PRINT_NOW TXT1 2000 1
                ENDIF
                IF TIMERA > 6000
                    PRINT_NOW TXT2 2000 1
                ENDIF
                IF TIMERA > 10000
                    PRINT_NOW TXT3 2000 1
                ENDIF
                IF TIMERA > 12000
                    PRINT_NOW TXT4 2000 1
                ENDIF
            ENDWHILE 
        ENDIF
        IF call_id = call_hangout_trevor
            // temporario:
            WHILE TIMERA < 5000   
                WAIT 0
                GOSUB draw_michael_call 
            ENDWHILE
            //
        ENDIF
        GOSUB hangout_start 


    RETURN

    set_call_sprites:
        IF call_id = call_hangout_michael
            n3 = sprite_michael
            caller = MICHAEL
        ENDIF

        IF call_id = call_hangout_trevor
            n3 = sprite_trevor
            caller = TREVOR
        ENDIF

        IF call_id = call_hangout_franklin
            n3 = sprite_franklin
            caller = FRANK
        ENDIF
    RETURN

    draw_frank_call:
        USE_TEXT_COMMANDS 0
        SET_SPRITES_DRAW_BEFORE_FADE 1
        DRAW_SPRITE sprite_phone 560.0 340.0 105.0 250.0 255 255 255 255
        SET_SPRITES_DRAW_BEFORE_FADE 1
        DRAW_SPRITE sprite_frame 560.0 340.0 105.0 250.0 theme_r theme_g theme_b 255
        SET_SPRITES_DRAW_BEFORE_FADE 1
        DRAW_RECT 560.0 334.0 SCREEN_WIDTH 144.0 38 38 38 255
        SET_SPRITES_DRAW_BEFORE_FADE 1
        DRAW_RECT 560.0 301.2 SCREEN_WIDTH 35.0 0 0 0 255
        SET_SPRITES_DRAW_BEFORE_FADE 1
        DRAW_RECT 560.0 257.0 SCREEN_WIDTH 10.0 0 0 0 255
        GET_TIME_OF_DAY hour min
        SET_TEXT_EDGE 0 0 0 0 0
        SET_TEXT_SCALE 0.25 1.1
        IF min >= 10
            DISPLAY_TEXT_WITH_2_NUMBERS 517.0 250.0 TIME hour min
        ELSE
            DISPLAY_TEXT_WITH_2_NUMBERS 517.0 250.0 TIME_0 hour min
        ENDIF

        GOSUB set_text_properties6
        DISPLAY_TEXT 515.0 268.0 $caller  
        SET_SPRITES_DRAW_BEFORE_FADE 1
        DRAW_SPRITE n3 529f 299f 25f 25f 255 255 255 255

        GOSUB set_text_properties7
        SET_TEXT_FONT 2
        DISPLAY_TEXT 545.0 285.0 $text
    RETURN

    draw_trevor_list:

        GOSUB draw_trevor_phone

        IF list_max_items > 5
            number_of_list_items = 5
        ELSE 
            number_of_list_items = list_max_items 
        ENDIF

        GOSUB set_text_properties4
        SET_TEXT_CENTRE 0
        SET_TEXT_WRAPX 640f                    
        DISPLAY_TEXT 513.5f 272.5f $text  

        CONST_FLOAT settings_trevor_height 22.2f
        posy = 299.9f  // 23f
        
        REPEAT 5 n
            IF list_max_items > n
                n2 = n 
                n2 += startPoint

                if phone_screen = screen_contacts
                    SWITCH n2
                        CASE 0
                        text = MICHAEL
                        n3 = sprite_michael
                        BREAK
                        CASE 1
                        text = FRANK
                        n3 = sprite_franklin
                        BREAK
                        //CASE 2
                        //text = DANI
                        //n3 = sprite_dani
                        //BREAK
                    ENDSWITCH   
                ENDIF
            
                IF phone_screen = screen_themes
                    IF n2 = player_phone_theme[switch_cur_char]
                        n3 = sprite_ok
                    ELSE
                        n3 = sprite_theme
                    ENDIF
                    SWITCH n2
                        CASE 0
                        text = ICOL0
                        BREAK
                        CASE 1
                        text = ICOL1
                        BREAK
                        CASE 2
                        text = ICOL2
                        BREAK
                        CASE 3
                        text = ICOL3
                        BREAK
                        CASE 4
                        text = ICOL4
                        BREAK
                        CASE 5
                        text = ICOL5
                        BREAK
                        CASE 6
                        text = ICOL6
                        BREAK
                        CASE 7
                        text = ICOL7
                        BREAK
                        CASE 8
                        text = ICOL8
                        BREAK
                        CASE 9
                        text = ICOL9
                        BREAK

                    ENDSWITCH
                ENDIF

                IF phone_screen = screen_settings
                    n3 = sprite_theme
                    SWITCH n2
                        CASE 0
                        text = ITHEME
                        BREAK
                        CASE 1
                        text = WALLP
                        BREAK
                    ENDSWITCH
                ENDIF



                GOSUB set_text_properties5 // voltar
                SET_TEXT_COLOUR 255 255 255 255
                IF n = selec
                    DRAW_RECT 560.0 posy SCREEN_WIDTH settings_trevor_height theme_r theme_g theme_b 255
                    
                    IF phone_screen = screen_contacts
                        DRAW_SPRITE n3 523f posy 15f 15f 255 255 255 255
                    ELSE
                        DRAW_RECT 523f posy , 20f settings_trevor_height , 255 255 255 255
                        DRAW_SPRITE n3 523f posy 15f 15f theme_r theme_g theme_b  255 
                    ENDIF
                ELSE
                    IF NOT phone_screen = screen_contacts
                        DRAW_RECT 523f posy , 20f settings_trevor_height , theme_r theme_g theme_b  255
                    ENDIF
                    DRAW_SPRITE n3 523f posy 15f 15f 255 255 255 255  
                ENDIF 

                
                posz = posy
                posZ -= 7.0f
                SET_TEXT_WRAPX 640f
                DISPLAY_TEXT_WITH_NUMBER 535f posZ $text n2 
                
                posy += settings_trevor_height
            ENDIF
        ENDREPEAT


        IF NOT IS_LOCAL_VAR_BIT_SET_CONST phone_flags bit_is_button_pressed
 
            IF IS_BUTTON_PRESSED PAD1 DPADDOWN 
                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                n3 = number_of_list_items - 1
                IF selec < n3 // 4
                    selec += 1
                ELSE 
                    n3 = list_max_items - 1

                    IF n2 < n3
                        startPoint += 1
                    ELSE 
                        selec = 0
                        startPoint = 0
                    ENDIF
                ENDIF
            ENDIF

            IF IS_BUTTON_PRESSED PAD1 DPADUP 
                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                IF selec > 0
                    selec -= 1
                ELSE 
                    IF startPoint > 0
                    startPoint -= 1
                    ELSE  
                        selec = number_of_list_items - 1 // 4
                        startPoint = list_max_items - number_of_list_items // 5 
                    ENDIF
                ENDIF
            ENDIF

            IF IS_BUTTON_PRESSED 0 CIRCLE
                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                phone_screen = return_screen
            ENDIF

        ENDIF

        n2 = selec 
        n2 += startPoint

    RETURN

    check_home_buttons:

        IF NOT IS_LOCAL_VAR_BIT_SET_CONST phone_flags bit_is_button_pressed

            // move
                IF IS_BUTTON_PRESSED 0 DPADUP
                        SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                        IF selec > 2
                            selec -= 3
                        ELSE
                            IF selec = 2
                                selec = 5
                            ELSE
                                selec += 6
                            ENDIF
                        ENDIF
                ENDIF

                IF IS_BUTTON_PRESSED 0 DPADDOWN
                        SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                        IF 5 > selec
                            selec += 3
                        ELSE
                            IF selec = 5
                                selec = 2
                            ELSE
                                selec -= 6
                            ENDIF
                        ENDIF
                ENDIF

                IF IS_BUTTON_PRESSED 0 DPADLEFT
                    SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                    IF NOT selec = 0
                    AND NOT selec = 3
                    AND NOT selec = 6
                        selec -= 1
                    ELSE 
                        IF NOT selec = 6
                        selec += 2
                        ELSE
                            selec = 7
                        ENDIF
                    ENDIF
                ENDIF

                IF IS_BUTTON_PRESSED 0 DPADRIGHT
                    SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                    IF NOT selec = 2
                    AND NOT selec = 5
                    AND NOT selec = 7
                        selec += 1
                    ELSE 
                        IF NOT selec = 7
                        selec -= 2
                        ELSE
                            selec = 6
                        ENDIF
                    ENDIF
                ENDIF
            // endmove

            IF IS_BUTTON_PRESSED 0 CROSS
                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                
                SWITCH selec 
                    CASE item_contacts
                        phone_screen = screen_contacts
                        IF IS_PC_VERSION
                            LOAD_MISSION_AUDIO 1 3600
                        ELSE
                            LOAD_MISSION_AUDIO 1 31200
                        ENDIF
                        LOAD_ALL_MODELS_NOW
                    BREAK
                    CASE item_texts
                        phone_screen = screen_texts
                    BREAK
                    CASE item_email
                        phone_screen = screen_email
                    BREAK
                    CASE item_checklist
                        phone_screen = screen_checklist
                    BREAK
                    CASE item_camera
                        IF NOT IS_CHAR_IN_ANY_CAR hPlayerPed
                            //GOSUB vertical_para_horizontal
                            phone_screen = screen_camera
                        ELSE
                            PRINT_HELP VEHOUT
                        ENDIF
                    BREAK
                    CASE item_settings
                        phone_screen = screen_settings
                    BREAK
                    CASE item_save
                        IF flag_player_on_mission = 0
                        AND NOT IS_CHAR_IN_ANY_CAR hPlayerPed
                            is_drawing = 0 
                            DELETE_OBJECT phone_obj
                            ACTIVATE_SAVE_MENU
                            WHILE NOT HAS_SAVE_GAME_FINISHED
                                WAIT 0
                            ENDWHILE
                            TIMERA = -10
                        ELSE
                            PRINT_HELP SAUN
                        ENDIF
                    BREAK
                    
                ENDSWITCH    
            ENDIF

            IF IS_BUTTON_PRESSED 0 CIRCLE
            OR NOT IS_CHAR_HEALTH_GREATER hPlayerPed 1 
                TIMERA = -100
            ENDIF
        ENDIF

    RETURN

    define_theme_colors:

            
        SWITCH player_phone_theme[switch_cur_char]
            CASE 0
                theme_r = 255
                theme_g = 0
                theme_b = 0
            BREAK
            CASE 1 
                theme_r = 0
                theme_g = 128
                theme_b = 0
                BREAK
            CASE 2 
                theme_r = 0
                theme_g = 0
                theme_b = 255
            BREAK
            CASE 3 
                theme_r = 255
                theme_g = 140
                theme_b = 0
            BREAK
            CASE 4 
                theme_r = 192
                theme_g = 0
                theme_b = 255
            BREAK
            CASE 5 
                theme_r = 20
                theme_g = 20
                theme_b = 20
            BREAK
            CASE 6 
                theme_r = 140
                theme_g = 140
                theme_b = 140
            BREAK
            CASE 7 
                theme_r = 255
                theme_g = 120
                theme_b = 203
            BREAK
            CASE 8 
                theme_r = 0
                theme_g = 255
                theme_b = 0
            BREAK
            CASE 9 
                theme_r = 150
                theme_g = 75
                theme_b = 0
                /*GENERATE_RANDOM_INT_IN_RANGE 0 256 theme_r
                GENERATE_RANDOM_INT_IN_RANGE 0 256 theme_g
                GENERATE_RANDOM_INT_IN_RANGE 0 256 theme_b*/
            BREAK
        ENDSWITCH

    RETURN

    define_wallpaper:
        IF NOT switch_cur_char = PLAYER_TREVOR
            LOAD_TEXTURE_DICTIONARY WALLP
            IF player_phone_wallpaper[switch_cur_char] = 0
                LOAD_SPRITE sprite_wallpaper wallpaper1
            ENDIF
            IF player_phone_wallpaper[switch_cur_char] = 1
                LOAD_SPRITE sprite_wallpaper wallpaper2
            ENDIF
            IF player_phone_wallpaper[switch_cur_char] = 2
                LOAD_SPRITE sprite_wallpaper wallpaper3
            ENDIF
            IF player_phone_wallpaper[switch_cur_char] = 3
                LOAD_SPRITE sprite_wallpaper wallpaper4
            ENDIF
            IF player_phone_wallpaper[switch_cur_char] = 4
                LOAD_SPRITE sprite_wallpaper wallpaper5
            ENDIF
        ENDIF
    RETURN

    check_phone_buttons:
        IF NOT IS_BUTTON_PRESSED 0 DPADLEFT
        AND NOT IS_BUTTON_PRESSED 0 DPADRIGHT
        AND NOT IS_BUTTON_PRESSED 0 DPADUP
        AND NOT IS_BUTTON_PRESSED 0 DPADDOWN
        AND NOT IS_BUTTON_PRESSED 0 SELECT
        AND NOT IS_BUTTON_PRESSED 0 CROSS
        AND NOT IS_BUTTON_PRESSED 0 SQUARE
        AND NOT IS_BUTTON_PRESSED 0 CIRCLE
            CLEAR_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
        ENDIF
    RETURN

    snapmatic:
        DELETE_OBJECT phone_obj
        REQUEST_ANIMATION "ON_LOOKERS"
        LOAD_ALL_MODELS_NOW
        CLEAR_CHAR_TASKS_IMMEDIATELY hPlayerPed
        DISPLAY_HUD 0
        DISPLAY_RADAR 0
        SET_PLAYER_CONTROL 0 0
        TASK_PLAY_ANIM_NON_INTERRUPTABLE hPlayerPed "POINTUP_LOOP" "ON_LOOKERS" 4.0 1 0 0 0 -1
        selec = 0
        angleX = 0f
        angleY = 0f
        angleZ = 0f
        hour = 0
        TIMERA = 0
        WHILE DOES_CHAR_EXIST hPlayerPed
            WAIT 0
            USE_TEXT_COMMANDS 0
            IF hour = 1 // grade
                DRAW_RECT 213f 224f 1f 448f 140 140 140 150
                DRAW_RECT 426f 224f 1f 448f 140 140 140 150
                DRAW_RECT 320f 150f 640f 1f 140 140 140 150
                DRAW_RECT 320f 300f 640f 1f 140 140 140 150
            ENDIF
            
            IF IS_BUTTON_PRESSED 0 CIRCLE
                SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                BREAK
            ENDIF

            
            IF NOT IS_LOCAL_VAR_BIT_SET_CONST phone_flags bit_is_button_pressed
                IF IS_BUTTON_PRESSED 0 SQUARE
                    SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                    IF hour = 0
                        hour = 1
                    ELSE 
                        hour = 0
                    ENDIF
                ENDIF

                IF IS_BUTTON_PRESSED 0 SELECT
                    SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
                    IF selec = 0
                        selec = 1
                    ELSE 
                        selec = 0
                    ENDIF
                ENDIF

                IF IS_BUTTON_PRESSED 0 CROSS //x
                    CLEAR_PRINTS
                    SET_PHOTO_CAMERA_EFFECT 1
                    WAIT 500
                    // TAKE_PHOTO 1
                    REPORT_MISSION_AUDIO_EVENT_AT_CHAR hPlayerPed 1132
                    SET_PHOTO_CAMERA_EFFECT 0
                ENDIF
            ENDIF
            GOSUB check_phone_buttons

            GOSUB set_text_properties
            //SET_TEXT_CENTRE 0
            //SET_TEXT_BACKGROUND 1
            SET_TEXT_WRAPX 640f
            GET_POSITION_OF_ANALOGUE_STICKS 0 timerb timerb n n2

            TIMERA = 0 /////// debug

            IF n > 10
            OR n < -10
            OR n2 > 10
            OR n2 < -10
                TIMERA = 0
            ENDIF

            IF selec = 0
                IF TIMERA < 5000
                    DISPLAY_TEXT 450f 420f ICAM2
                ENDIF
                IF n < -10
                    angleX +=@ 0.015
                ENDIF
                IF n > 10
                    angleX -=@ 0.015
                ENDIF
                IF n2 < -10
                    angleY +=@ 0.015
                ENDIF
                IF n2 > 10
                    angleY -=@ 0.015
                ENDIF
                //limites
                IF angleX < -0.06
                    angleX = -0.06
                    GET_CHAR_HEADING hPlayerPed angleZ
                    angleZ -=@ 0.85
                    SET_CHAR_HEADING hPlayerPed angleZ
                ENDIF
                IF angleX > 0.7
                    angleX = 0.7
                    GET_CHAR_HEADING hPlayerPed angleZ
                    angleZ +=@ 0.85
                    SET_CHAR_HEADING hPlayerPed angleZ
                ENDIF
                IF angleY < -0.1
                    angleY = -0.1
                ENDIF
                IF angleY > 1.0
                    angleY = 1.0
                ENDIF
                IF angleX < 0.0
                    handX -= angleX
                ENDIF
                ATTACH_CAMERA_TO_CHAR hPlayerPed handX 0.8 0.9 angleX 0.0 angleY 0.0 2
                IF angleX < 0.0
                    handX += angleX
                ENDIF
            ELSE //selec = 1
                IF TIMERA < 3000
                    DISPLAY_TEXT 450f 420f ICAM1
                ENDIF
                GET_CHAR_HEADING hPlayerPed angleX
                IF n < -10
                    angleX +=@ 1.2
                ENDIF
                IF n > 10
                    angleX -=@ 1.2
                ENDIF
                IF n2 < -10
                    angleY +=@ 0.08
                ENDIF
                IF n2 > 10
                    angleY -=@ 0.08
                ENDIF
                GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hPlayerPed 0.0 0.5 0.6 posX posY posZ
                SET_FIXED_CAMERA_POSITION posX posY posZ 0.0 0.0 0.0
                SET_CHAR_HEADING hPlayerPed angleX
                GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS hPlayerPed 0.0 5.0 angleY posX posY posZ
                POINT_CAMERA_AT_POINT posX posY posZ 2
            ENDIF

        ENDWHILE
        REMOVE_ANIMATION "ON_LOOKERS" 
        DISPLAY_HUD 1
        DISPLAY_RADAR 1
        SET_PLAYER_CONTROL 0 1
        CLEAR_CHAR_TASKS_IMMEDIATELY hPlayerPed
        WAIT 0
        GOSUB generate_phone
        RESTORE_CAMERA_JUMPCUT
        SET_LOCAL_VAR_BIT_CONST phone_flags bit_is_button_pressed
        selec = 6
        phone_screen = screen_main
    RETURN

    vertical_para_horizontal:
        posz = 180f
        posx = 560f
        WHILE posz > 90f
            WAIT 0
            USE_TEXT_COMMANDS 0
            SET_SPRITES_DRAW_BEFORE_FADE 1
            DRAW_SPRITE_WITH_ROTATION 101 posx 315.0 128.0 240.0 posz 0 0 0 255
            //DRAW_SPRITE_WITH_ROTATION 101 posx 315.0 (90.0 170.0) posz 255 255 255 255
            DRAW_SPRITE_WITH_ROTATION sprite_frame posx 315.0 130.0 250.0, posz ,theme_r theme_g theme_b 255
            //DRAW_SPRITE_WITH_ROTATION sprite_phone posx 315.0 105.0 250.0 posz 255 255 255 255
            
            posz -= 10f
            posx -= 6f
        ENDWHILE
    RETURN

    draw_franklyn_phone:
        DRAW_SPRITE sprite_phone 560.0 340.0 105.0 250.0 255 255 255 255
        DRAW_SPRITE sprite_frame 560.0 340.0 105.0 250.0 theme_r theme_g theme_b 255
    RETURN

    draw_trevor_phone:
        DRAW_SPRITE sprite_wallpaper 560.0 340.0 105.0 250.0 255 255 255 255
        DRAW_SPRITE sprite_frame 560.0 340.0 105.0 250.0 theme_r theme_g theme_b 255
        GET_TIME_OF_DAY hour min
        GOSUB set_text_properties
        IF 10 > min
            DISPLAY_TEXT_WITH_2_NUMBERS 560.5f 260f TIME_0 hour min
        ELSE
            DISPLAY_TEXT_WITH_2_NUMBERS 560.5f 260f TIME hour min
        ENDIF
    RETURN

    set_text_properties:
        SET_TEXT_CENTRE 1
        SET_TEXT_COLOUR 255 255 255 255
        SET_TEXT_EDGE 1 0 0 0 200
        SET_TEXT_SCALE 0.4 1.1f
        SET_TEXT_DRAW_BEFORE_FADE 0
    RETURN

    set_text_properties2:
        SET_TEXT_COLOUR 255 255 255 255
        SET_TEXT_EDGE 1 0 0 0 200
        SET_TEXT_SCALE 0.5 1.5f
        SET_TEXT_WRAPX 640f
        SET_TEXT_DRAW_BEFORE_FADE 0
    RETURN

    set_text_properties3:
        SET_TEXT_COLOUR 255 255 255 255
        SET_TEXT_EDGE 0 0 0 0 0
        SET_TEXT_SCALE 0.40 0.96
        SET_TEXT_WRAPX 640f
        SET_TEXT_DRAW_BEFORE_FADE 0
    RETURN

    set_text_properties4:
        SET_TEXT_EDGE 0 0 0 0 0
        //SET_TEXT_JUSTIFY 2
        SET_TEXT_CENTRE 1
        SET_TEXT_COLOUR 255 255 255 255
        SET_TEXT_SCALE 0.32 1.6
    RETURN

    set_text_properties5:
        SET_TEXT_EDGE 0 0 0 0 0
        SET_TEXT_COLOUR 0 0 0 255
        SET_TEXT_SCALE 0.28 1.4
    RETURN

    set_text_properties6:
        SET_TEXT_EDGE 0 0 0 0 0
        SET_TEXT_WRAPX 640f
        SET_TEXT_COLOUR 255 255 255 255
        SET_TEXT_SCALE 0.28 1.4
    RETURN

    set_text_properties7:
        SET_TEXT_EDGE 0 0 0 0 0
        SET_TEXT_WRAPX 640f
        SET_TEXT_COLOUR 255 255 255 255
        SET_TEXT_SCALE 0.24 1.0f
    RETURN

    generate_phone:

        CREATE_OBJECT CELLPHONE 0.0 0.0 0.0 phone_obj  
        DONT_REMOVE_OBJECT phone_obj
        SET_OBJECT_PROOFS phone_obj 1 1 1 1 1 
        TASK_PICK_UP_OBJECT hPlayerPed phone_obj 0.0 0.0 0.0 6 16 PHONE_GRAB PED -1
        IF NOT IS_CHAR_IN_ANY_CAR hPlayerPed
            TASK_PLAY_ANIM_NON_INTERRUPTABLE hPlayerPed PHONE_GRAB PED 4f 0 0 0 1 -1
        ELSE
            TASK_PLAY_ANIM hPlayerPed PHONE_GRAB PED 4f 0 0 0 1 -1
        ENDIF
    RETURN

    hangout_start:
            STREAM_SCRIPT HANGOUT
            LOAD_ALL_MODELS_NOW
            START_NEW_STREAMED_SCRIPT HANGOUT          
    RETURN

}
SCRIPT_END