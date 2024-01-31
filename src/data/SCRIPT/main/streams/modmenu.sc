SCRIPT_START
{
    modmenu:
    SCRIPT_NAME MODMENU

    VAR_INT menu_flags

    LVAR_INT page menu_slot_selected menu_current_slot menu_current_item  buttons_pressed dummy LR_pressed
    LVAR_INT start_offset number_of_slots number_of_items last_page confirmed buttons_timer
    LVAR_INT int1 int2 int3 int4 int5 column1_number column2_number 
    LVAR_FLOAT posY tempFloat coordx coordy coordz 
    LVAR_TEXT_LABEL text text_2 title  
   
    CONST_INT page_main_menu 0
    buttons_pressed = TRUE

    CONST_FLOAT const_width 220f
    CONST_FLOAT const_posx 130f
    CONST_FLOAT const_posx_2column 230f
    CONST_FLOAT const_posx_2column_rect 225f
    CONST_FLOAT const_posY_offset 18f

    /* debug_loop:
        WAIT 0
        IF IS_KEY_PRESSED VK_KEY_M
            GOSUB menu
        ENDIF
    GOTO debug_loop*/

    is_drawing = 1
    LOAD_TEXTURE_DICTIONARY MODMENU

    LOAD_SPRITE 61 "selector"
    LOAD_SPRITE 64 "ok"

    load_sprite 3 "MAPA"
    load_sprite 4 "MARKER"

    

    menu:
        //page = page_main_menu
        last_page = -1
        SET_PLAYER_CONTROL 0 FALSE

        //IF IS_CHAR_IN_ANY_CAR hPlayerPed
        //    STORE_CAR_CHAR_IS_IN_NO_SAVE hPlayerPed player_car 
        //ENDIF

        buttons_timer = 3

        menu_loop:
            WAIT 0
            GOSUB check_buttons
            USE_TEXT_COMMANDS 0
        
            menu_current_item = 1

            IF NOT page = last_page
                last_page = page 
                GOSUB reset_page
                number_of_items = 0
                WHILE DOES_CHAR_EXIST hPlayerPed
                    GOSUB read_pages
                    IF text = BJ_0
                        number_of_items = menu_current_item
                        number_of_items -= 1
                        BREAK
                    ENDIF   
                    IF NOT number_of_items = 0
                        BREAK
                    ENDIF
                    menu_current_item += 1
                ENDWHILE

                IF number_of_items <=12
                    number_of_slots = number_of_items
                ELSE 
                    number_of_slots = 12
                ENDIF

                IF page = page_cabco
                    LOAD_SPRITE 50 "cabco"
                ENDIF

            ENDIF

            GOSUB header_draw
            
            posY = 105f
            menu_current_slot = 1
            WHILE menu_current_slot <= number_of_slots
                
                menu_current_item = menu_current_slot
                menu_current_item += start_offset
                
                GOSUB read_pages
                
                IF menu_slot_selected = menu_current_slot
                    DRAW_RECT const_posx posY const_width const_posY_offset 255 255 255 255
                    SET_TEXT_COLOUR 0 0 0 255
                ELSE
                    DRAW_RECT const_posx posY const_width const_posY_offset 0 0 0 200
                    SET_TEXT_COLOUR 255 255 255 200
                ENDIF
                tempFloat = posY
                tempFloat -= 4.0f
                SET_TEXT_FONT 1
                SET_TEXT_WRAPX 640f
                SET_TEXT_EDGE 0 0 0 0 0
                //IF IS_GLOBAL_VAR_BIT_SET_CONST mods_activated flag_widescreen
                    SET_TEXT_SCALE 0.25 1.12f 
               // ELSE
                //    SET_TEXT_SCALE 0.40 1.1f
                //ENDIF 
                DISPLAY_TEXT_WITH_NUMBER 25f tempFloat $text column1_number
                
                IF NOT text_2 = _
                    SET_TEXT_RIGHT_JUSTIFY 1
                    SET_TEXT_FONT 1
                    SET_TEXT_EDGE 0 0 0 0 0
                    SET_TEXT_SCALE 0.35 1.12f 
                    IF menu_slot_selected = menu_current_slot
                        SET_TEXT_COLOUR 0 0 0 255
                    ELSE
                        SET_TEXT_COLOUR 255 255 255 200
                    ENDIF
                    DISPLAY_TEXT_WITH_NUMBER const_posx_2column tempFloat $text_2 column2_number

                    IF text_2 = OK
                        IF menu_slot_selected = menu_current_slot
                            DRAW_SPRITE 64 220f posY 20f 20f 0 0 0 255
                        ELSE
                            DRAW_SPRITE 64 220f posY 20f 20f 255 255 255 255
                        ENDIF
                    ENDIF
                    IF text_2 = ON
                        DRAW_RECT const_posx_2column_rect posY 10f 10f 0 0 0 255
                        DRAW_RECT const_posx_2column_rect posY 8f 8f 0 255 0 255
                    ENDIF
                    IF text_2 = OFF
                        DRAW_RECT const_posx_2column_rect posY 10f 10f 0 0 0 255
                        DRAW_RECT const_posx_2column_rect posY 8f 8f 255 0  0 255
                    ENDIF
                    
                ENDIF
                
                posY += const_posY_offset
                menu_current_slot += 1   
            ENDWHILE

            IF TIMERA > 600
                IF IS_BUTTON_PRESSED PAD1 DPADDOWN
                OR IS_BUTTON_PRESSED PAD1 DPADUP
                    buttons_timer += 1
                ELSE
                    buttons_timer = 0
                ENDIF
            ENDIF
        
            IF IS_BUTTON_PRESSED PAD1 DPADDOWN
                IF buttons_timer < 2
                OR buttons_timer > 15
                    IF menu_slot_selected < number_of_slots
                        menu_slot_selected += 1
                    ELSE 
                        IF menu_current_item < number_of_items
                            start_offset += 1
                        ELSE
                            start_offset = 0
                            menu_slot_selected = 1
                        ENDIF
                    ENDIF
                ENDIF
            ENDIF

            IF IS_BUTTON_PRESSED PAD1 DPADUP
                IF buttons_timer < 2
                OR buttons_timer > 15
                    IF menu_slot_selected > 1
                        menu_slot_selected -= 1
                    ELSE 
                        IF start_offset > 0
                            start_offset -= 1
                        ELSE
                            dummy = number_of_items
                            dummy -= number_of_slots
                            start_offset = dummy
                            menu_slot_selected = number_of_slots
                        ENDIF
                    ENDIF
                ENDIF
            ENDIF

            IF IS_BUTTON_PRESSED 0 TRIANGLE
            OR timera < 0
                IF NOT menu_flags = 0
                    WAIT 0
                    USE_TEXT_COMMANDS 0
                    SET_PLAYER_CONTROL 0 TRUE
                    FREEZE_CHAR_POSITION_AND_DONT_LOAD_COLLISION hPlayerPed 0
                    //requested_txds -= 1
                    //IF requested_txds = 0
                        REMOVE_TEXTURE_DICTIONARY
                    is_drawing = 0
                    //ENDIF
    
                    TERMINATE_THIS_SCRIPT
                ENDIF
            ENDIF

            DRAW_RECT const_posx posY const_width const_posY_offset 0 0 0 180
            DRAW_SPRITE 61 const_posx posY 15f 15f 255 255 255 255
            menu_current_item = menu_slot_selected
            menu_current_item += start_offset
            SET_TEXT_RIGHT_JUSTIFY 1
            //SET_TEXT_COLOUR 106 13 176 255
            SET_TEXT_COLOUR 255 255 255 200 // DEV
            SET_TEXT_SCALE 0.43 1.12
            DISPLAY_TEXT_WITH_2_NUMBERS const_posx_2column 82f BARR menu_current_item number_of_items

        GOTO menu_loop
    RETURN

    check_buttons:
        IF NOT IS_BUTTON_PRESSED PAD1 CROSS
        AND NOT IS_BUTTON_PRESSED PAD1 CIRCLE
        AND NOT IS_BUTTON_PRESSED PAD1 SQUARE
        AND NOT IS_BUTTON_PRESSED PAD1 DPADRIGHT
        AND NOT IS_BUTTON_PRESSED PAD1 DPADLEFT
            buttons_pressed = FALSE
        ENDIF
    RETURN
    
    header_draw:
        //DRAW_RECT const_posx 50.0 const_width 58.0 106 13 176 200 //azul:46 76 118      roxo: 106 13 176 // DEV
        DRAW_SPRITE 50 const_posx 50.0 const_width 58.0 255 255 255 255
        SET_TEXT_FONT 3
        SET_TEXT_SCALE 0.56 2.14
        SET_TEXT_COLOUR 255 255 255 255
        SET_TEXT_EDGE 0 0 0 0 255
        SET_TEXT_CENTRE 1
        DISPLAY_TEXT const_posx 40.0 PEDROP
        DRAW_RECT const_posx 87f const_width const_posY_offset 0 0 0 200
        SET_TEXT_FONT 2
        SET_TEXT_WRAPX 640f
        SET_TEXT_COLOUR 255 255 255 255
        //SET_TEXT_COLOUR 106 13 176 255
        //SET_TEXT_COLOUR 255 255 255 200 // DEV
        //SET_TEXT_COLOUR 46 76 118 255
        SET_TEXT_EDGE 0 0 0 0 255        
        SET_TEXT_SCALE 0.30 1.2
        DISPLAY_TEXT 25f 81f $title

        DRAW_RECT 545f 425f 180f 20f 0 0 0 150
        SET_TEXT_RIGHT_JUSTIFY 1
        SET_TEXT_SCALE 0.30 1.2
        DISPLAY_TEXT 620f 418f BTNS
    RETURN

    reset_page:
        buttons_pressed = TRUE
        menu_slot_selected = 1
        start_offset = 0
    RETURN

    // DEFINIÇÃO DE CONSTANTES

        CONST_INT page_cabco 1
    //

    read_pages:
        text = BJ_0
        text_2 = _
        dummy = menu_slot_selected
        dummy += start_offset

        IF IS_BUTTON_PRESSED PAD1 CROSS 
        AND buttons_pressed = FALSE
        AND menu_current_item = dummy
            confirmed = TRUE
        ELSE 
            confirmed = FALSE
        ENDIF

        IF buttons_pressed = FALSE
        AND menu_current_item = dummy
        AND lr_pressed = 0
            IF IS_BUTTON_PRESSED 0 DPADRIGHT
                lr_pressed = DPADRIGHT
            ENDIF
            IF IS_BUTTON_PRESSED 0 DPADLEFT
                lr_pressed = DPADLEFT
            ENDIF
        ENDIF

        SWITCH page
            /*
                CASE page_
                    title = 
                    SWITCH menu_current_item
                        CASE 1
                            text = 
                            IF confirmed = TRUE
                                
                            ENDIF
                        BREAK
                    ENDSWITCH

                    IF buttons_pressed = FALSE
                    AND IS_BUTTON_PRESSED PAD1 CIRCLE
                        buttons_pressed = TRUE
                        page = page_
                    ENDIF

                BREAK

             */

            CASE page_main_menu
                title = MENUP 
                SWITCH menu_current_item
                    
                    /*CASE 7
                        text = GDEBUG
                        IF confirmed = TRUE
                            page = page_debug   
                        ENDIF
                    BREAK*/                    
                ENDSWITCH
            BREAK

            CASE page_cabco
                title = CABCO
                text_2 = DOL
                SWITCH menu_current_item
                    CASE 1 
                        text = HOME
                        IF switch_cur_char = PLAYER_FRANKLIN
                            coordx = 1684.828
                            coordy = -2108.3677
                        ENDIF
                        IF switch_cur_char = PLAYER_MICHAEL
                            coordx = 250.0
                            coordy = -1227.0
                        ENDIF
                        IF switch_cur_char = PLAYER_TREVOR
                            coordx = -1041.3763 
                            coordy = 1562.1898
                        ENDIF
                        GOSUB calcular_distancia
                    BREAK
                    CASE 2
                        text = AIRP 
                        coordx = 1682.5110 
                        coordy = -2251.3920 
                        //coordz = 13.3947
                        GOSUB calcular_distancia
                    BREAK
                    CASE 3
                        text = WAYP // BJ_0 //WAYP 
                        //GET_CHAR_COORDINATES hPlayerPed coordx coordy coordz
                        //IF IS_PC_VERSION
                        coordx = -1f
                        coordy = -1f
                        coordz = -1f
                        GET_TARGET_BLIP_COORDS coordx coordy coordz
                        //PRINT_FORMATTED_NOW "%f %f %f" 1 coordx coordy coordz

                        //ENDIF
                        GOSUB calcular_distancia
                        IF coordz = -1f //column2_number = 0
                            text = BJ_0 //para nao ser listado
                        ENDIF
                    BREAK
                ENDSWITCH
                IF confirmed = TRUE
                    menu_flags = menu_current_item
                    TIMERA = -10
                ENDIF
            BREAK

            
        ENDSWITCH

        IF confirmed = TRUE 
        OR IS_BUTTON_PRESSED PAD1 CIRCLE
        OR NOT lr_pressed = 0
            buttons_pressed = TRUE
            lr_pressed = 0
        ENDIF

    RETURN

    calcular_distancia:
    GET_CHAR_COORDINATES hPlayerPed temp_float[0] temp_float[1] temp_float[2]
    GET_DISTANCE_BETWEEN_COORDS_2D coordx coordy temp_float[0] temp_float[1] temp_float[2] 
    temp_float[2] /= 100f
    column2_number =# temp_float[2]
    RETURN
}
SCRIPT_END