// GTA V Legacy Main Script - Created by Daniel Santos
GOTO start

DUMP 
00 //Alignment
ENDDUMP

ColourFilter:
DUMP 
//                              gtavl_colourfilter:
//
//                              var_28          = -0x28
//                              var_18          = -0x18
//                              var_10          = -0x10
//                              var_s0          =  0
//
D0 FF BD 27 //                                  addiu   $sp, -0x30
28 00 BF FF //                                  sd      $ra, 0x28+var_s0($sp)
25 10 80 00 //                                  move    $v0, $a0
00 10 02 00 //                                  sll     $v0, 0
10 00 A2 AF //                                  sw      $v0, 0x28+var_18($sp)
25 10 A0 00 //                                  move    $v0, $a1
00 10 02 00 //                                  sll     $v0, 0
18 00 A2 AF //                                  sw      $v0, 0x28+var_10($sp)
40 00 02 24 //                                  li      $v0, 0x40  # R
00 00 A2 A3 //                                  sb      $v0, 0x28+var_28($sp)
40 00 02 24 //                                  li      $v0, 0x40  # G
01 00 A2 A3 //                                  sb      $v0, 0x28+var_28+1($sp)
60 00 02 24 //                                  li      $v0, 0x60  # B
02 00 A2 A3 //                                  sb      $v0, 0x28+var_28+2($sp)
70 00 02 24 //                                  li      $v0, 0x70  # A
03 00 A2 A3 //                                  sb      $v0, 0x28+var_28+3($sp)
10 00 A5 DF //                                  ld      $a1, 0x28+var_18($sp)
00 00 A4 DF //                                  ld      $a0, 0x28+var_28($sp)
DC 67 14 0C //                                  jal     colour_filter
00 00 00 00 //                                  nop
00 00 00 00 //                                  nop
28 00 BF DF //                                  ld      $ra, 0x28+var_s0($sp)
30 00 BD 27 //                                  addiu   $sp, 0x30
08 00 E0 03 //                                  jr      $ra
00 00 00 00 //                                  nop
//                               # End of function set_saturation
ENDDUMP

pause_menu_hook2:
DUMP
//                               pause_menu_hook:
//
//                               var_18          = -0x18
//                               var_14          = -0x14
//                               var_10          = -0x10
//                               var_s0          =  0
//
E0 FF BD 27                   //                addiu   $sp, -0x20
18 00 BF FF                   //                sd      $ra, 0x18+var_s0($sp)
24 00 02 3C 60 6F 42 34       //                li      $v0, 0x246F60
00 00 A2 AF                   //                sw      $v0, 0x18+var_18($sp)
6F 00 02 3C A8 F9 42 34       //                li      $v0, 0x6FF9A8
04 00 A2 AF                   //                sw      $v0, 0x18+var_14($sp)
BB AA 02 3C DD CC 42 34       //                li      $v0, 0xAABBCCDD
08 00 A2 AF                   //                sw      $v0, 0x18+var_10($sp)
04 00 A2 8F                   //                lw      $v0, 0x18+var_14($sp)
00 00 42 80                   //                lb      $v0, 0($v0)
07 00 40 10                   //                beqz    $v0, loc_100054
00 00 00 00                   //                nop
08 00 A2 8F                   //                lw      $v0, 0x18+var_10($sp)
14 0C 03 3C AC 58 63 34       //                li      $v1, 0xC1458AC
00 00 43 AC                   //                sw      $v1, 0($v0)
08 00 00 10                   //                b       loc_100070
00 00 00 00                   //                nop
//                              loc_100054:
00 00 A2 8F                   //                lw      $v0, 0x18+var_18($sp)
09 F8 40 00                   //                jalr    $v0
00 00 00 00                   //                nop
08 00 A2 8F                   //                lw      $v0, 0x18+var_10($sp)
14 0C 03 3C DC 67 63 34       //                li      $v1, 0xC1467DC
00 00 43 AC                   //                sw      $v1, 0($v0)
//                              loc_100070:
00 00 00 00                   //                nop
18 00 BF DF                   //                ld      $ra, 0x18+var_s0($sp)
20 00 BD 27                   //                addiu   $sp, 0x20
08 00 E0 03                   //                jr      $ra
00 00 00 00                   //                nop
//                               # End of function pause_menu_hook
ENDDUMP

weapon_to_model:
DUMP
EC FF BD 27 //                                  addiu   $sp, -0x20       # Add Immediate Unsigned
10 00 BF FF //                                  sd      $ra, 0x40+var_10($sp)  # Store Doubleword
00 00 B0 7F //                                  sq      $s0, 0x40+var_40($sp)  # Store Quadword
7B 00 02 3C //                                  lui     $v0, 0x7B  # '{'  # Load Upper Immediate
80 18 04 00 //                                  sll     $v1, $a0, 2      # Shift Left Logical
80 87 42 24 //                                  li      $v0, CModelInfo::ms_modelInfoPtrs  # Load Immediate
21 10 43 00 //                                  addu    $v0, $v1         # Add Unsigned
00 00 50 8C //                                  lw      $s0, 0($v0)      # Load Word
00 00 19 8E //                                  lw      $t9, 0($s0)      # Load Word
18 00 39 8F //                                  lw      $t9, 0x18($t9)   # Load Word
09 F8 20 03 //                                  jalr    $t9              # Jump And Link Register
2D 20 00 02 //                                  move    $a0, $s0
10 00 BF DF //                                  ld      $ra, 0x40+var_10($sp)  # Load Doubleword
00 00 B0 7B //                                  lq      $s0, 0x40+var_40($sp)  # Load Quadword
08 00 E0 03 //                                  jr      $ra              # Jump Register
40 00 BD 27 //                                  addiu   $sp, 0x40        # Add Immediate Unsigned
ENDDUMP

gtavl_cam:
DUMP
                         //     GTAVLegacy_cam:

                        // //     var_38          = -0x38
                         //     var_28          = -0x28
                         //     var_24          = -0x24
                         //     var_20          = -0x20
                         //     var_1C          = -0x1C
                         //     var_18          = -0x18
                         //     var_14          = -0x14
                         //     var_10          = -0x10
                         //     var_s0          =  0

C0 FF BD 27             // //                     addiu   $sp, -0x40
38 00 BF FF              //                     sd      $ra, 0x38+var_s0($sp)
10 00 A4 AF              //                     sw      $a0, 0x38+var_28($sp)
14 00 A5 AF              //                     sw      $a1, 0x38+var_24($sp)
18 00 AC E7              //                     swc1    $f12, 0x38+var_20($sp)
1C 00 AD E7              //                     swc1    $f13, 0x38+var_1C($sp)
20 00 AE E7              //                     swc1    $f14, 0x38+var_18($sp)
25 10 20 01              //                     move    $v0, $a5
24 00 A2 A3              //                     sb      $v0, 0x38+var_14($sp)
99 3E 02 3C 9A 99 42 34  //                     li      $v0, 0x3E99999A
00 00 A2 AF              //                     sw      $v0, 0x38+var_38($sp)
14 00 A2 8F              //                     lw      $v0, 0x38+var_24($sp)
00 00 41 C4              //                     lwc1    $f1, 0($v0)
28 00 BD AF              //                     sw      $sp, 0x38+var_10($sp)
28 00 A2 8F              //                     lw      $v0, 0x38+var_10($sp)
00 00 40 C4              //                     lwc1    $f0, 0($v0)
00 08 00 46              //                     add.s   $f0, $f1, $f0
14 00 A2 8F              //                     lw      $v0, 0x38+var_24($sp)
00 00 40 E4              //                     swc1    $f0, 0($v0)
24 00 A2 93              //                     lbu     $v0, 0x38+var_14($sp)
25 48 40 00              //                     move    $a5, $v0
20 00 AE C7              //                     lwc1    $f14, 0x38+var_18($sp)
1C 00 AD C7              //                     lwc1    $f13, 0x38+var_1C($sp)
18 00 AC C7              //                     lwc1    $f12, 0x38+var_20($sp)
14 00 A5 8F              //                     lw      $a1, 0x38+var_24($sp)
10 00 A4 8F              //                     lw      $a0, 0x38+var_28($sp)
B4 1F 08 0C              //                     jal     Process_FollowPed_SA
00 00 00 00              //                     nop
00 00 00 00              //                     nop
38 00 BF DF              //                     ld      $ra, 0x38+var_s0($sp)
40 00 BD 27              //                     addiu   $sp, 0x40
08 00 E0 03              //                     jr      $ra
00 00 00 00              //                     nop
ENDDUMP

indievehhandlings_label:
DUMP // Size: 4096, increase handling size from 224 bytes to 341 bytes per vehicle
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
ENDDUMP

start:
// Basic Init
SCRIPT_NAME main

VAR_INT player scplayer player_group
VAR_INT flag_player_on_mission hook_ptr
VAR_INT is_drawing colour_filter filter_call

VAR_INT switch_cur_char switch_new_char switch_money[3] switch_wanted[3] switch_last_used_car[3] switch_in_car[3] char_r[3] char_g[3] char_b[3]
VAR_FLOAT switch_x[3] switch_y[3] switch_z[3] switch_new_x[3] switch_new_y[3] switch_new_z[3]
VAR_INT rgba rgba_pointer getrgba_ptr color[4] life_pickup filter_r_ptr filter_g_ptr filter_b_ptr filter_a_ptr

VAR_INT fps_onscreen stream_onscreen
fps_onscreen = 0
stream_onscreen = 0

// Disable heat haze
WRITE_MEMORY 0x516D80 4 0x03E00008 1 // jr $ra
WRITE_MEMORY 0x516D84 4 0x00000000 1 // nop

// Disable enex
WRITE_MEMORY 0x4BB188 4 0x1000015B 1   // branch
WRITE_MEMORY 0x4BB18C 4 0x00000000 1   // nop

// Disable Door Camera
WRITE_MEMORY 0x4BC998 4 0x1000003F 1   // branch
WRITE_MEMORY 0x4BC99C 4 0x00000000 1   // nop

// Hook colour filter
GET_LABEL_POINTER ColourFilter (colour_filter)
filter_call = colour_filter + 72
filter_r_ptr = colour_filter + 32
filter_g_ptr = colour_filter + 40
filter_b_ptr = colour_filter + 48
filter_a_ptr = colour_filter + 56

colour_filter /= 4
colour_filter += 0x0C000000
WRITE_MEMORY 0x515568 4 colour_filter 0

// Hook player on foot camera
GET_LABEL_POINTER gtavl_cam (hook_ptr)
hook_ptr /= 4
hook_ptr += 0x0C000000
WRITE_MEMORY 0x202A10 4 hook_ptr 0

char_r[0] = 0
char_g[0] = 220
char_b[0] = 50

char_r[1] = 0
char_g[1] = 80
char_b[1] = 200

char_r[2] = 150
char_g[2] = 70
char_b[2] = 70

CONST_INT CPostEffects_m_bGrainEnable 0x66C70C
CONST_INT MaxHealth 0x70974B
CONST_INT UpdateCompareFlag 0x3077F0

CONST_INT PLAYER_FRANKLIN 0
CONST_INT PLAYER_MICHAEL 1
CONST_INT PLAYER_TREVOR 2

// -------------------------------------------------- Independent Vehicle Handlings global vars -------------------------------------------------- //

VAR_INT indieVehicles[12] indieHandlings[12] usedHandlingSlots handlingReplFlag
CONST_INT HANDLING_HOOK_WAIT 0 
CONST_INT HANDLING_HOOK_SIGNAL 1

handlingReplFlag = HANDLING_HOOK_WAIT
usedHandlingSlots = 0

// ----------------------------------------------------------------------------------------------------------------------------------------------- //

SET_DEATHARREST_STATE OFF

SET_TOTAL_NUMBER_OF_MISSIONS 0
SET_PROGRESS_TOTAL 0
SET_MISSION_RESPECT_TOTAL 0

CREATE_PLAYER 0 223.3513, -1753.368, 4.6704 player

GET_PLAYER_CHAR player scplayer
GET_PLAYER_GROUP player player_group

REQUEST_COLLISION 223.3513, -1753.368
LOAD_SCENE 223.3513, -1753.368, 4.6704

CREATE_PICKUP 1240, 2, 223.3513, -1753.368, 4.6704 (life_pickup)

SET_CAMERA_BEHIND_PLAYER
SET_CHAR_HEADING scplayer 9.83518

flag_player_on_mission = 0
DECLARE_MISSION_FLAG flag_player_on_mission

GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP player SHIRTABLUE SHIRTA 0
GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP player PLAYER_FACE HEAD 1 
GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP player JEANSDENIM JEANS 2 
GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP player SHOEDRESSBLK SHOE 3 
BUILD_PLAYER_MODEL player

ADD_HOSPITAL_RESTART (0.0 0.0 5.0) (0.0) 0 
ADD_POLICE_RESTART (0.0 0.0 5.0) (0.0) 0

SET_TIME_OF_DAY (10 0)

is_drawing = 0

SET_PLAYER_CONTROL player ON
DO_FADE 0 FADE_IN

//LOAD_AND_LAUNCH_MISSION initial.sc
WAIT 0

//START_NEW_SCRIPT psave

// START_NEW_SCRIPT streaming_usage
// START_NEW_SCRIPT fps_counter
START_NEW_SCRIPT debug_menu
START_NEW_SCRIPT char_switcher
START_NEW_SCRIPT weapon_selector
START_NEW_SCRIPT wanted_blip
START_NEW_SCRIPT improvedMove
START_NEW_SCRIPT cops_on_radar
START_NEW_SCRIPT life_recovery
START_NEW_SCRIPT manual_reload
START_NEW_SCRIPT pickups_on_ground
START_NEW_SCRIPT car_wash
START_NEW_SCRIPT phone
START_NEW_SCRIPT als
//START_NEW_SCRIPT transparent_menu


//LAUNCH_MISSION import.sc
//LAUNCH_MISSION other_scripts.sc

REGISTER_STREAMED_SCRIPT CARMOD1 carmod1.sc
//REGISTER_STREAMED_SCRIPT FOOD_VENDOR food_vendor.sc

// Streamed scripts can be streamed in manually or by a script trigger.
// We'll see how stream it manually  the main_loop, but for now let's focus on triggers.
//
// The triggers may be registered using:
//   + REGISTER_SCRIPT_BRAIN_FOR_CODE_USE
//   + REGISTER_ATTRACTOR_SCRIPT_BRAIN_FOR_CODE_USE
//   + ALLOCATE_STREAMED_SCRIPT_TO_RANDOM_PED
//   + ALLOCATE_STREAMED_SCRIPT_TO_OBJECT
//
// Each of those triggers are very delicate and requires a tutorial by themselves, which I'm
// NOT up write, and gets out of the scope of this tutorial, which is quick learning.
//
// Instead, let's pick ALLOCATE_STREAMED_SCRIPT_TO_OBJECT and play with it.
//
//ALLOCATE_STREAMED_SCRIPT_TO_OBJECT FOOD_VENDOR CHILLIDOGCART 100 70.0 -1
//ALLOCATE_STREAMED_SCRIPT_TO_OBJECT FOOD_VENDOR NOODLECART_PROP 100 70.0 -1
// So, we just told the script engine we want run FOOD_VENDOR once we're  a 70.0 radius
// of the the CHILLIDOGCART or NOODLECART_PROP objects.

// Unfortunately, objects spawned by script (CREATE_OBJECT) do NOT trigger streamed scripts, so we'll
// make a teleporter that have a cart spawned by level files.
// Tip: Look away from the carts IF the vendor character is NOT spawned.
//START_NEW_SCRIPT cart_teleport

// **************************************** CAR MODING GARAGES ************************************
// ************************************************************************************************

CONST_INT GARAGE_OPEN_FOR_LOW_RIDERS 36
CONST_INT GARAGE_OPEN_FOR_STREET_RACERS 37
CONST_INT GARAGE_OPEN_FOR_NORMAL_CARS 38

// LA Normal Cars
CHANGE_GARAGE_TYPE bodLAwN GARAGE_OPEN_FOR_NORMAL_CARS

// LA LowRiders (Neils Lowrider garage)
CHANGE_GARAGE_TYPE modlast GARAGE_OPEN_FOR_LOW_RIDERS

// San Fran Normal Cars
CHANGE_GARAGE_TYPE mdsSFSe GARAGE_OPEN_FOR_NORMAL_CARS

// San Fran Street Racer Garage
CHANGE_GARAGE_TYPE mds1SFS GARAGE_OPEN_FOR_STREET_RACERS

// Vegas Normal Cars
CHANGE_GARAGE_TYPE vEcmod GARAGE_OPEN_FOR_NORMAL_CARS

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

main_loop:
WAIT 250

// This is basically how you'd stream a streamed script manually:
IF IS_GARAGE_OPEN (BODLAWN)
OR IS_GARAGE_OPEN (MODLAST)
OR IS_GARAGE_OPEN (MDSSFSE)
OR IS_GARAGE_OPEN (MDS1SFS)
OR IS_GARAGE_OPEN (VECMOD)
OR IS_BUTTON_PRESSED PAD1 DPADRIGHT
    GET_NUMBER_OF_INSTANCES_OF_STREAMED_SCRIPT CARMOD1 num_carmod_instances
    IF num_carmod_instances = 0
        STREAM_SCRIPT CARMOD1
        IF HAS_STREAMED_SCRIPT_LOADED CARMOD1
            START_NEW_STREAMED_SCRIPT CARMOD1   // Tip: You can send values just like START_NEW_SCRIPT
        ENDIF
    ENDIF
ELSE
    MARK_STREAMED_SCRIPT_AS_NO_LONGER_NEEDED CARMOD1
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
        CREATE_PICKUP 0 0 .0 .0 .0 save_pickup
    ENDIF

    psave_loop:
    WAIT 0
    IF flag_player_on_mission = 0
        GOSUB psave_create_pickup
        IF IS_PLAYER_PLAYING player
        AND HAS_PICKUP_BEEN_COLLECTED save_pickup
            GOSUB psave_do_save
            GOSUB psave_destroy_pickup
            GOSUB psave_create_pickup
            GOSUB psave_respawn_player
        ENDIF
    ELSE
        GOSUB psave_destroy_pickup
        WAIT 1000
    ENDIF
    GOTO psave_loop

    psave_do_save:
        SET_PLAYER_CONTROL player OFF
        ACTIVATE_SAVE_MENU
        WHILE NOT HAS_SAVE_GAME_FINISHED
            WAIT 0
        ENDWHILE
        SET_FADING_COLOUR 0 0 0
        DO_FADE 1000 FADE_OUT
        SET_PLAYER_CONTROL player OFF
    RETURN

    psave_respawn_player:
        IF IS_PLAYER_PLAYING player
            CLEAR_AREA (15.0 0.0 4.0) (1.0) 1
            SET_CHAR_COORDINATES scplayer (15.0 0.0 4.0)
        ENDIF
        WAIT 0
        DO_FADE 1000 FADE_IN
        RESTORE_CAMERA_JUMPCUT
        SET_CAMERA_BEHIND_PLAYER
        WAIT 500
        IF IS_PLAYER_PLAYING player
            SET_PLAYER_CONTROL player ON
        ENDIF
    RETURN

    psave_create_pickup:
        IF pickup_created = 0
            pickup_created = 1
            CREATE_PICKUP PICKUPSAVE PICKUP_ONCE 10.0 0.0 3.0 save_pickup
        ENDIF
    RETURN

    psave_destroy_pickup:
        IF pickup_created = 1
            pickup_created = 0
            REMOVE_PICKUP save_pickup
        ENDIF
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

    ADD_SPRITE_BLIP_FOR_COORD 2139.2253 2714.3403 0.0 iBlipSpriteID hBlip
    ADD_SPRITE_BLIP_FOR_COORD 2162.7361 2464.7861 0.0 iBlipSpriteID hBlip
    ADD_SPRITE_BLIP_FOR_COORD 2464.9353 -1461.2537 0.0 iBlipSpriteID hBlip
    ADD_SPRITE_BLIP_FOR_COORD 1910.7087 -1768.9048 0.0 iBlipSpriteID hBlip
    ADD_SPRITE_BLIP_FOR_COORD 1018.8 -926.1744 0.0 iBlipSpriteID hBlip

    WHILE NOT IS_GERMAN_GAME
        WAIT 150
        IF IS_CHAR_SITTING_IN_ANY_CAR scplayer
            IF IS_PLAYER_CONTROL_ON 0
            AND NOT IS_WANTED_LEVEL_GREATER 0 0
                STORE_CAR_CHAR_IS_IN_NO_SAVE scplayer hVeh
                GET_DRIVER_OF_CAR hVeh p
                IF p = scplayer
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
    IF IS_BUTTON_PRESSED 0 11
        IS_INT_LVAR_GREATER_THAN_CONSTANT TIMERA -1 // RETURN_TRUE
        RETURN
    ELSE
        IF timerb > 10000
            PRINT_HELP CARWSHA
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
    IF i = 9 // BIKE
    OR i = 10 //BMX
        pEntity = pVeh
        x = CARX
        y = CARY
        z = CARZ
        GOSUB SetEntityPosSimple
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
    WARP_CHAR_INTO_CAR scplayer hVeh
    SET_PLAYER_CONTROL 0 ON

    RETURN

    SetEntityPosSimple:
    pMatrix = pEntity + 0x14
    READ_MEMORY pMatrix 4 FALSE (pMatrix)
    pCoord = pMatrix + 0x30
    WRITE_MEMORY pCoord 4 (x) FALSE
    pCoord += 0x4 // y
    WRITE_MEMORY pCoord 4 (y) FALSE
    pCoord += 0x4 // y
    WRITE_MEMORY pCoord 4 (z) FALSE
    RETURN

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
    pickups_on_ground:

    LVAR_INT pObject wModelId pickupObject pickups ptr_tmp iX iY iZ pickup_type
    LVAR_FLOAT x y z ground_z

    //WRITE_MEMORY 0x00536541 5 0x90 1  //CPickups::DoPickUpEffects(CEntity *)
    WRITE_MEMORY 0x2D9E10 4 0x0 1 //object->__parent.physical.entity.placeable.m_pCoords->pos.z = outVec.z;
    WRITE_MEMORY 0x22FD90 4 0x2403FFFF 1   // movzx edx,word ptr [008CD59C]
    
    WRITE_MEMORY 0x2DD3B0 4 0x100000B7 1
    WRITE_MEMORY 0x2DD3B4 4 0x0 1 
    
    WRITE_MEMORY 0x2DCA10 4 0x0 1 //coronas
    
    WHILE NOT IS_GERMAN_GAME
        WAIT 0

        pickups = 0x803170         
        WHILE pickups <= 0x807ED0 
            ptr_tmp = pickups + 0x1C //pickup type
            READ_MEMORY ptr_tmp 1 0 (pickup_type)  //x
            IF pickup_type = 2
            OR pickup_type = 3
            OR pickup_type = 4
            OR pickup_type = 5
            OR pickup_type = 8
            OR pickup_type = 15
            OR pickup_type = 19
                ptr_tmp = pickups + 0x10 // int
                READ_MEMORY ptr_tmp 2 0 (iX)  //x
                ptr_tmp = pickups + 0x4 // int 
                READ_MEMORY ptr_tmp 4 0 (pObject) //[POINTER] - CObjectVC* pObject
                ptr_tmp = pickups + 0x18 // int
                READ_MEMORY ptr_tmp 2 0 (wModelId) //[WORD] - wModelId
                IF NOT iX = 0
                AND NOT pObject = 0
                    GET_OBJECT_REF pObject (pickupObject)
                    GET_OBJECT_COORDINATES pickupObject (x y z)
                    IF LOCATE_CHAR_ANY_MEANS_2D scplayer x y 80.0 80.0 0
                        IF LOCATE_CHAR_ANY_MEANS_2D scplayer x y 45.0 45.0 0
                        OR IS_OBJECT_ON_SCREEN pickupObject
                            GET_GROUND_Z_FOR_3D_COORD x y z (ground_z)
                            ground_z += 0.05
                            SET_OBJECT_COORDINATES pickupObject x y ground_z
                            IF NOT wModelId = 1212 //#MONEY
                                SET_OBJECT_ROTATION pickupObject 90.0 0.0 134.0
                            ELSE
                                SET_OBJECT_ROTATION pickupObject 0.0 0.0 5.0 
                            ENDIF
                       ENDIF
                    ENDIF
                ENDIF
            ENDIF
            pickups += 0x20
        ENDWHILE
    ENDWHILE
}

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
            GET_PED_POINTER scplayer (pPed)
            i = pPed + 0x758 //m_nActiveWeaponSlot
            READ_MEMORY i 1 0 (i)

            IF NOT i = 0
            AND NOT IS_CHAR_DEAD scplayer

                i *= 0x1C //sizeof CWeapon
                i += pPed

                pWeapon = i + 0x5E0 //CWeapon

                GET_CURRENT_CHAR_WEAPON scplayer (iCurWeapon)

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
        IF NOT IS_CHAR_SITTING_IN_ANY_CAR scplayer
            CONTINUE
        ENDIF
        STORE_CAR_CHAR_IS_IN_NO_SAVE scplayer (CurrentVehicle)
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

                WHILE IS_CHAR_SITTING_IN_ANY_CAR scplayer
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
    WHILE IS_CHAR_SITTING_IN_ANY_CAR scplayer
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
        IF IS_PLAYER_CONTROL_ON player
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
    transparent_menu:
    LVAR_INT menu_hook_ptr colour_filter_hook_ptr hook_hi hook_lo

    //Remove menu backgrounds
    WRITE_MEMORY 0x2340B4 0x4 0x0 0
    WRITE_MEMORY 0x234348 0x4 0x0 0
    WRITE_MEMORY 0x23B124 0x4 0x240A0000 0
    WRITE_MEMORY 0x23B14C 0x4 0x240A0000 0
    WRITE_MEMORY 0x234350 0x4 0x1000000D 0
    WRITE_MEMORY 0x234370 0x4 0x27A50098 0

    //Enable Render World
    WRITE_MEMORY 0x246764 0x4 0x14400006 0

    WRITE_MEMORY 0x238C30 0x4 0x00 0

    WRITE_MEMORY 0x238C14 0x4 0x00 0
    WRITE_MEMORY 0x238C18 0x4 0x00 0
    WRITE_MEMORY 0x238C1C 0x4 0x00 0
    WRITE_MEMORY 0x238C20 0x4 0x00 0
    WRITE_MEMORY 0x238C24 0x4 0x00 0
    WRITE_MEMORY 0x238C28 0x4 0x00 0
    WRITE_MEMORY 0x238C2C 0x4 0x00 0
    WRITE_MEMORY 0x238C30 0x4 0x00 0
    WRITE_MEMORY 0x238C34 0x4 0x00 0

    GET_LABEL_POINTER pause_menu_hook2 (menu_hook_ptr)
    menu_hook_ptr += 32

    GET_LABEL_POINTER ColourFilter (colour_filter_hook_ptr)
    colour_filter_hook_ptr += 72

    hook_hi = colour_filter_hook_ptr / 0x10000
    hook_hi += 0x3C020000
    WRITE_MEMORY menu_hook_ptr 4 hook_hi 0
    menu_hook_ptr += 4

    hook_lo = colour_filter_hook_ptr * 0x10000
    hook_lo /= 0x10000
    hook_lo += 0x34420000

    WRITE_MEMORY menu_hook_ptr 4 hook_lo 0

    GET_LABEL_POINTER pause_menu_hook2 (menu_hook_ptr)
    menu_hook_ptr /= 4
    menu_hook_ptr += 0x0C000000
    WRITE_MEMORY 0x2469E4 4 menu_hook_ptr 0

    TERMINATE_THIS_SCRIPT
}


{
    fps_counter:
    SCRIPT_NAME showfps
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
        DISPLAY_TEXT_WITH_NUMBER 12.0 42.0 _FPSCN1 b
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
    phone:
    SCRIPT_NAME phone
    NOP

    LVAR_INT hour min phone_model pos_x pos_y selec b_active num_items theme_r theme_g theme_b dummy
    LVAR_FLOAT selec_mult

    CONST_FLOAT SCREEN_WIDTH 92.0

    theme_r = 109
    theme_g = 235
    theme_b = 95
    dummy = 0

    REQUEST_ANIMATION phone

    init:
    WAIT 0
    IF IS_BUTTON_PRESSED 0 DPADUP
    AND is_drawing = 0
        is_drawing = 1
        SET_PLAYER_CONTROL 0 0
        IF switch_cur_char = PLAYER_FRANKLIN
            LOAD_TEXTURE_DICTIONARY VPHONE
        ELSE 
            IF switch_cur_char = PLAYER_MICHAEL
                LOAD_TEXTURE_DICTIONARY VPHONE2
            ELSE
                IF switch_cur_char = PLAYER_TREVOR
                    LOAD_TEXTURE_DICTIONARY VPHONE3
                ENDIF
            ENDIF
        ENDIF
        GOSUB load_cellphone
        GOTO init_phone
    ENDIF
    GOTO init

    load_cellphone:
    REQUEST_MODEL CELLPHONE
    WHILE NOT HAS_MODEL_LOADED CELLPHONE
        WAIT 0
    ENDWHILE
    MARK_MODEL_AS_NO_LONGER_NEEDED CELLPHONE
    CREATE_OBJECT_NO_OFFSET CELLPHONE 0.0 0.0 0.0 phone_model
    TASK_PICK_UP_OBJECT scplayer phone_model 0.03 0.0 0.0 6 16 phone_grab PHONE -1
    IF IS_CHAR_IN_ANY_CAR scplayer
        TASK_PLAY_ANIM scplayer phone_grab PHONE 4.0 1 0 0 0 -1
    ENDIF
    RETURN

    init_phone:
    WHILE IS_BUTTON_PRESSED 0 CIRCLE
    OR IS_BUTTON_PRESSED 0 CROSS
        GOSUB draw_home
    ENDWHILE
    GOSUB draw_home
    IF b_active = 0
        IF IS_BUTTON_PRESSED 0 DPADLEFT
           selec -= 1
           b_active = 1
        ENDIF
        IF IS_BUTTON_PRESSED 0 DPADRIGHT
            selec += 1
            b_active = 1
        ENDIF
        IF IS_BUTTON_PRESSED 0 DPADUP
           selec -= 3
           b_active = 1
        ENDIF
        IF IS_BUTTON_PRESSED 0 DPADDOWN
            selec += 3
            b_active = 1
        ENDIF
    ELSE
        IF NOT IS_BUTTON_PRESSED 0 DPADLEFT
        AND NOT IS_BUTTON_PRESSED 0 DPADRIGHT
        AND NOT IS_BUTTON_PRESSED 0 DPADUP
        AND NOT IS_BUTTON_PRESSED 0 DPADDOWN
            b_active = 0
        ENDIF
    ENDIF
    IF selec < 0
        selec = 7
    ENDIF
    IF selec > 7
        selec = 0
    ENDIF

    IF IS_BUTTON_PRESSED 0 CROSS
        SWITCH selec
            CASE 0
                BREAK
            CASE 1
                BREAK
            CASE 2
                BREAK
            CASE 3
                BREAK
            CASE 4
                BREAK
            CASE 5
                selec = 0
                GOTO create_settings
                BREAK
            CASE 6
                BREAK
            CASE 7
                BREAK
        ENDSWITCH
    ENDIF

    IF IS_BUTTON_PRESSED 0 CIRCLE
        DELETE_OBJECT phone_model
        CLEAR_CHAR_TASKS scplayer
        SET_PLAYER_CONTROL 0 1
        WAIT 100
        REMOVE_TEXTURE_DICTIONARY
        is_drawing = 0
        GOTO init
    ENDIF
    GOTO init_phone

    draw_home:
    USE_TEXT_COMMANDS 1
    GOSUB rainbow_theme
    LOAD_SPRITE 4 wallpaper
    DRAW_SPRITE 4 560.0 329.0 SCREEN_WIDTH 154.0 theme_r theme_g theme_b 255
    LOAD_SPRITE 3 home
    DRAW_SPRITE 3 560.0 277.0 SCREEN_WIDTH 50.0 255 255 255 255
    GOSUB draw_phone_frame
    SET_TEXT_EDGE 0 0 0 0 0
    SET_TEXT_SCALE 0.25 1.3
    DISPLAY_TEXT 546.0 271.5 PZERO
    SET_TEXT_EDGE 0 0 0 0 0
    SET_TEXT_SCALE 0.25 1.3
    DISPLAY_TEXT 565.0 271.5 PZERO
    GET_TIME_OF_DAY hour min
    SET_TEXT_EDGE 0 0 0 0 0
    SET_TEXT_SCALE 0.35 1.9
    DISPLAY_TEXT_WITH_2_NUMBERS 549.0 253.0 PTIME hour min 
    LOAD_SPRITE 5 selected
    SWITCH selec
        CASE 0
            GOSUB set_app_title
            DISPLAY_TEXT 545.0 283.0 PEMAIL
            DRAW_SPRITE 5 533.0 318.0 27.0 34.2 theme_r theme_g theme_b 255
            BREAK
        CASE 1
            GOSUB set_app_title
            DISPLAY_TEXT 535.0 283.0 PMESSAG
            DRAW_SPRITE 5 560.0 318.0 27.0 34.2 theme_r theme_g theme_b 255
            BREAK
        CASE 2
            GOSUB set_app_title
            DISPLAY_TEXT 540.0 283.0 PCHECKL
            DRAW_SPRITE 5 587.0 318.0 27.0 34.2 theme_r theme_g theme_b 255
            BREAK
        CASE 3
            GOSUB set_app_title
            DISPLAY_TEXT 534.0 283.0 PQKSAVE
            DRAW_SPRITE 5 533.0 350.0 27.0 34.2 theme_r theme_g theme_b 255
            BREAK
        CASE 4
            GOSUB set_app_title
            DISPLAY_TEXT 539.0 283.0 PCONTAC
            DRAW_SPRITE 5 560.0 350.0 27.0 34.2 theme_r theme_g theme_b 255
            BREAK
        CASE 5
            GOSUB set_app_title
            DISPLAY_TEXT 539.0 283.0 PSETTIN
            DRAW_SPRITE 5 587.0 350.0 27.0 34.2 theme_r theme_g theme_b 255
            BREAK
        CASE 6
            GOSUB set_app_title
            DISPLAY_TEXT 536.0 283.0 PSNPMTC
            DRAW_SPRITE 5 533.0 382.0 27.0 34.2 theme_r theme_g theme_b 255
            BREAK
        CASE 7
            GOSUB set_app_title
            DISPLAY_TEXT 540.0 283.0 PBROWSE
            DRAW_SPRITE 5 560.0 382.0 27.0 34.2 theme_r theme_g theme_b 255
            BREAK
    ENDSWITCH
    LOAD_SPRITE 6 email
    DRAW_SPRITE 6 533.0 318.0 27.0 34.2 255 255 255 255
    LOAD_SPRITE 7 messages
    DRAW_SPRITE 7 560.0 318.0 27.0 34.2 255 255 255 255
    LOAD_SPRITE 8 checklist
    DRAW_SPRITE 8 587.0 318.0 27.0 34.2 255 255 255 255
    LOAD_SPRITE 9 quicksave
    DRAW_SPRITE 9 533.0 350.0 27.0 34.2 255 255 255 255
    LOAD_SPRITE 10 contacts
    DRAW_SPRITE 10 560.0 350.0 27.0 34.2 255 255 255 255
    LOAD_SPRITE 11 settings
    DRAW_SPRITE 11 587.0 350.0 27.0 34.2 255 255 255 255
    LOAD_SPRITE 12 snapmatic
    DRAW_SPRITE 12 533.0 382.0 27.0 34.2 255 255 255 255
    LOAD_SPRITE 13 browser
    DRAW_SPRITE 13 560.0 382.0 27.0 34.2 255 255 255 255
    USE_TEXT_COMMANDS 0
    WAIT 0
    RETURN

    create_settings:
    WHILE IS_BUTTON_PRESSED 0 CIRCLE
    OR IS_BUTTON_PRESSED 0 CROSS
        GOSUB draw_settings
    ENDWHILE
    GOSUB draw_settings

    IF IS_BUTTON_PRESSED 0 CROSS
        SWITCH selec
            CASE 0
                BREAK
            CASE 1
                BREAK
            CASE 2
                BREAK
            CASE 3
                selec = 0
                GOTO create_theme_sets
                BREAK
            CASE 4
                BREAK
        ENDSWITCH
    ENDIF

    IF IS_BUTTON_PRESSED 0 CIRCLE
        GOTO init_phone
    ENDIF
    GOTO create_settings

    draw_settings:
    USE_TEXT_COMMANDS 1
    GOSUB rainbow_theme
    GOSUB create_menu_base
    GOSUB set_app_title
    DISPLAY_TEXT 540.0 262.0 PSETTIN
    num_items = 4
    GOSUB create_menu_selection
    GOSUB set_settings_item
    LOAD_SPRITE 4 theme_icon
    IF selec = 0
        SET_TEXT_COLOUR 255 255 255 255
        DRAW_SPRITE 4 522.0 291.2 15.0 19.0 255 255 255 255
    ELSE
        DRAW_SPRITE 4 522.0 291.2 15.0 19.0 theme_r theme_g theme_b 255
    ENDIF
    DISPLAY_TEXT 532.0 283.0 PWALLPA
    GOSUB set_settings_item
    LOAD_SPRITE 5 profile_icon
    IF selec = 1
        SET_TEXT_COLOUR 255 255 255 255
        DRAW_SPRITE 5 522.0 313.2 15.0 19.0 255 255 255 255
    ELSE
        DRAW_SPRITE 5 522.0 313.2 15.0 19.0 theme_r theme_g theme_b 255
    ENDIF
    DISPLAY_TEXT 532.0 305.0 PPROFIL
    GOSUB set_settings_item
    LOAD_SPRITE 6 ringtone_icon
    IF selec = 2
        SET_TEXT_COLOUR 255 255 255 255
        DRAW_SPRITE 6 522.0 335.2 15.0 19.0 255 255 255 255
    ELSE
        DRAW_SPRITE 6 522.0 335.2 15.0 19.0 theme_r theme_g theme_b 255
    ENDIF
    DISPLAY_TEXT 532.0 327.0 PRINGTO
    GOSUB set_settings_item
    LOAD_SPRITE 4 theme_icon
    IF selec = 3
        SET_TEXT_COLOUR 255 255 255 255
        DRAW_SPRITE 4 522.0 357.2 15.0 19.0 255 255 255 255
    ELSE
        DRAW_SPRITE 4 522.0 357.2 15.0 19.0 theme_r theme_g theme_b 255
    ENDIF
    DISPLAY_TEXT 532.0 349.0 PTHEME
    GOSUB set_settings_item
    LOAD_SPRITE 7 vibrate_icon
    IF selec = 4
        SET_TEXT_COLOUR 255 255 255 255
        DRAW_SPRITE 7 522.0 379.2 15.0 19.0 255 255 255 255
    ELSE
        DRAW_SPRITE 7 522.0 379.2 15.0 19.0 theme_r theme_g theme_b 255
    ENDIF
    DISPLAY_TEXT 532.0 371.0 PVIBRAT
    GOSUB draw_phone_frame
    USE_TEXT_COMMANDS 0
    WAIT 0
    RETURN

    create_theme_sets:
    WHILE IS_BUTTON_PRESSED 0 CIRCLE
    OR IS_BUTTON_PRESSED 0 CROSS
        GOSUB draw_theme_sets
    ENDWHILE
    GOSUB draw_theme_sets

    IF IS_BUTTON_PRESSED 0 CROSS
        SWITCH selec
            CASE 0
                theme_r = 80
                theme_g = 173
                theme_b = 239
                BREAK
            CASE 1
                theme_r = 109
                theme_g = 235
                theme_b = 95
                BREAK
            CASE 2
                theme_r = 89
                theme_g = 89
                theme_b = 88
                BREAK
            CASE 3
                theme_r = 206
                theme_g = 111
                theme_b = 29
                BREAK
            CASE 4
                theme_r = 255
                theme_g = 108
                theme_b = 200
                BREAK
            CASE 5
                BREAK
        ENDSWITCH
    ENDIF
    IF IS_BUTTON_PRESSED 0 DPADDOWN
    AND selec = 5
        selec = 1
        GOTO create_theme_sets2
    ENDIF
    IF IS_BUTTON_PRESSED 0 CIRCLE
        GOTO create_settings
    ENDIF
    GOTO create_theme_sets

    draw_theme_sets:
    USE_TEXT_COMMANDS 1
    GOSUB rainbow_theme
    LOAD_SPRITE 4 theme_icon
    LOAD_SPRITE 5 ok_icon
    GOSUB create_menu_base
    GOSUB set_app_title
    DISPLAY_TEXT 540.0 262.0 PSETTIN
    num_items = 5
    GOSUB create_menu_selection
    GOSUB set_settings_item
    IF selec = 0
        SET_TEXT_COLOUR 255 255 255 255
        DRAW_SPRITE 4 522.0 291.2 15.0 19.0 255 255 255 255
    ELSE
        DRAW_SPRITE 4 522.0 291.2 15.0 19.0 theme_r theme_g theme_b 255
    ENDIF
    DISPLAY_TEXT 532.0 283.0 PBLUE
    GOSUB set_settings_item
    IF selec = 1
        SET_TEXT_COLOUR 255 255 255 255
        DRAW_SPRITE 4 522.0 313.2 15.0 19.0 255 255 255 255
    ELSE
        DRAW_SPRITE 4 522.0 313.2 15.0 19.0 theme_r theme_g theme_b 255
    ENDIF
    DISPLAY_TEXT 532.0 305.0 PGREEN
    GOSUB set_settings_item
    IF selec = 2
        SET_TEXT_COLOUR 255 255 255 255
        DRAW_SPRITE 4 522.0 335.2 15.0 19.0 255 255 255 255
    ELSE
        DRAW_SPRITE 4 522.0 335.2 15.0 19.0 theme_r theme_g theme_b 255
    ENDIF
    DISPLAY_TEXT 532.0 327.0 PGRAY
    GOSUB set_settings_item
    IF selec = 3
        SET_TEXT_COLOUR 255 255 255 255
        DRAW_SPRITE 4 522.0 357.2 15.0 19.0 255 255 255 255
    ELSE
        DRAW_SPRITE 4 522.0 357.2 15.0 19.0 theme_r theme_g theme_b 255
    ENDIF
    DISPLAY_TEXT 532.0 349.0 PORANGE
    GOSUB set_settings_item
    IF selec = 4
        SET_TEXT_COLOUR 255 255 255 255
        DRAW_SPRITE 4 522.0 379.2 15.0 19.0 255 255 255 255
    ELSE
        DRAW_SPRITE 4 522.0 379.2 15.0 19.0 theme_r theme_g theme_b 255
    ENDIF
    DISPLAY_TEXT 532.0 371.0 PPINK
    GOSUB draw_phone_frame
    USE_TEXT_COMMANDS 0
    WAIT 0
    RETURN

    create_theme_sets2:
    WHILE IS_BUTTON_PRESSED 0 CIRCLE
    OR IS_BUTTON_PRESSED 0 CROSS
        GOSUB draw_theme_sets2
    ENDWHILE
    GOSUB draw_theme_sets2

    IF IS_BUTTON_PRESSED 0 CROSS
        SWITCH selec
            CASE 0
                BREAK
            CASE 1
                dummy = 0
                theme_r = 122
                theme_g = 65
                theme_b = 148
                BREAK
            CASE 2
                dummy = 0
                theme_r = 216
                theme_g = 33
                theme_b = 32
                BREAK
            CASE 3
                dummy = 0
                theme_r = 255
                theme_g = 234
                theme_b = 0
                BREAK
            CASE 4
                dummy = 1
                BREAK
        ENDSWITCH
    ENDIF
    IF IS_BUTTON_PRESSED 0 DPADUP
    AND selec = 0
        selec = 4
        GOTO create_theme_sets
    ENDIF
    IF IS_BUTTON_PRESSED 0 CIRCLE
        GOTO create_settings
    ENDIF
    GOTO create_theme_sets2

    draw_theme_sets2:
    USE_TEXT_COMMANDS 1
    GOSUB rainbow_theme
    LOAD_SPRITE 4 theme_icon
    LOAD_SPRITE 5 ok_icon
    GOSUB create_menu_base
    GOSUB set_app_title
    DISPLAY_TEXT 540.0 262.0 PSETTIN
    num_items = 4
    GOSUB create_menu_selection
    GOSUB set_settings_item
    IF selec = 1
        SET_TEXT_COLOUR 255 255 255 255
        DRAW_SPRITE 4 522.0 313.2 15.0 19.0 255 255 255 255
    ELSE
        DRAW_SPRITE 4 522.0 313.2 15.0 19.0 theme_r theme_g theme_b 255
    ENDIF
    DISPLAY_TEXT 532.0 305.0 PPURPLE
    GOSUB set_settings_item
    IF selec = 2
        SET_TEXT_COLOUR 255 255 255 255
        DRAW_SPRITE 4 522.0 335.2 15.0 19.0 255 255 255 255
    ELSE
        DRAW_SPRITE 4 522.0 335.2 15.0 19.0 theme_r theme_g theme_b 255
    ENDIF
    DISPLAY_TEXT 532.0 327.0 PRED
    GOSUB set_settings_item
    IF selec = 3
        SET_TEXT_COLOUR 255 255 255 255
        DRAW_SPRITE 4 522.0 357.2 15.0 19.0 255 255 255 255
    ELSE
        DRAW_SPRITE 4 522.0 357.2 15.0 19.0 theme_r theme_g theme_b 255
    ENDIF
    DISPLAY_TEXT 532.0 349.0 PYELLOW
    GOSUB set_settings_item
    IF selec = 4
        SET_TEXT_COLOUR 255 255 255 255
        DRAW_SPRITE 4 522.0 379.2 15.0 19.0 255 255 255 255
    ELSE
        DRAW_SPRITE 4 522.0 379.2 15.0 19.0 theme_r theme_g theme_b 255
    ENDIF
    DISPLAY_TEXT 532.0 371.0 PRAINBO
    GOSUB draw_phone_frame
    USE_TEXT_COMMANDS 0
    WAIT 0
    RETURN

    create_menu_base:
    LOAD_SPRITE 3 header_bar
    DRAW_RECT 560.0 334.0 SCREEN_WIDTH 144.0 255 255 255 255
    DRAW_RECT 560.0 257.0 SCREEN_WIDTH 10.0 0 0 0 255
    DRAW_SPRITE 3 560.0 271.2 SCREEN_WIDTH 18.0 theme_r theme_g theme_b 255
    RETURN

    create_menu_selection:
    IF b_active = 0
        IF IS_BUTTON_PRESSED 0 DPADUP
           selec -= 1
           b_active = 1
        ENDIF
        IF IS_BUTTON_PRESSED 0 DPADDOWN
            selec += 1
            b_active = 1
        ENDIF
    ELSE
        IF NOT IS_BUTTON_PRESSED 0 DPADUP
        AND NOT IS_BUTTON_PRESSED 0 DPADDOWN
            b_active = 0
        ENDIF
    ENDIF
    IF selec < 0
        selec = num_items
    ENDIF
    IF selec > num_items
        selec = 0
    ENDIF
    selec_mult =# selec
    selec_mult *= 22.0
    selec_mult += 291.2
    DRAW_RECT 560.0 selec_mult SCREEN_WIDTH 22.0 theme_r theme_g theme_b 255
    RETURN


    set_app_title:
    SET_TEXT_EDGE 0 0 0 0 0
    SET_TEXT_JUSTIFY 2
    SET_TEXT_COLOUR 255 255 255 255
    SET_TEXT_SCALE 0.32 1.6
    RETURN

    set_settings_item:
    SET_TEXT_EDGE 0 0 0 0 0
    SET_TEXT_COLOUR 0 0 0 255
    SET_TEXT_SCALE 0.28 1.4
    RETURN

    draw_phone_frame:
    LOAD_SPRITE 1 phone
    LOAD_SPRITE 2 frame
    DRAW_SPRITE 1 560.0 340.0 105.0 250.0 255 255 255 255
    DRAW_SPRITE 2 560.0 340.0 105.0 250.0 theme_r theme_g theme_b 255
    RETURN

    rainbow_theme:
    IF dummy = 1
        theme_r--
        IF theme_r < 120
            theme_r = 120
            dummy = 2
        ENDIF
    ENDIF
    IF dummy = 2
        theme_g++
        IF theme_g > 255
            theme_g = 255
            dummy = 3
        ENDIF
    ENDIF
    IF dummy = 3
        theme_g--
        IF theme_g < 70
            theme_g = 70
            dummy = 4
        ENDIF
    ENDIF
    IF dummy = 4
        theme_b++
        IF theme_b > 255
            theme_b = 255
            dummy = 5
        ENDIF
    ENDIF
    IF dummy = 5
        theme_r++
        IF theme_r > 255
            theme_r = 255
            dummy = 6
        ENDIF
    ENDIF
    IF dummy = 6
        theme_b--
        IF theme_b < 180
            theme_b = 180
            dummy = 7
        ENDIF
    ENDIF
    IF dummy = 7
        theme_r--
        IF theme_r < 40
            theme_r = 40
            dummy = 8
        ENDIF
    ENDIF
    IF dummy = 8
        theme_g++
        IF theme_g > 255
            theme_g = 255
            dummy = 9
        ENDIF
    ENDIF
    IF dummy = 9
        theme_b--
        IF theme_b < 40
            theme_b = 40
            dummy = 10
        ENDIF
    ENDIF
    IF dummy = 10
        theme_r++
        IF theme_r > 255
            theme_r = 255
            dummy = 11
        ENDIF
    ENDIF
    IF dummy = 11
        theme_g--
        IF theme_g < 30
            theme_g = 30
            dummy = 1
        ENDIF
    ENDIF
    RETURN

}

{
    debug_menu:
    SCRIPT_NAME debug_m
    NOP
    LVAR_INT selected b_active vehicle max_item veh_model old_selected r g b dummy
    LVAR_FLOAT items_size items_pos sc_float sc_pos item_qt px py pz pa

    LVAR_INT filter_col[4] col_idx old_col_idx

    CONST_INT MAX_ITEMS 3
    CONST_FLOAT ITEM_QUANTITY 4.0

    CONST_INT MAX_STYLE 2
    CONST_FLOAT STYLE_QUANTITY 3.0

    CONST_FLOAT RECT_X 112.0
    CONST_FLOAT RECT_W 170.0

    selected = 0
    dummy = 1
    r = 120
    g = 60
    b = 220

    menu_init:
    WAIT 0
    IF IS_BUTTON_PRESSED 0 RIGHTSHOCK
    AND IS_BUTTON_PRESSED 0 LEFTSHOCK
    AND is_drawing = 0
        is_drawing = 1
        SET_PLAYER_CONTROL 0 0
        GOTO main_menu_loop
    ENDIF
    GOTO menu_init

    main_menu_loop:
    WHILE IS_BUTTON_PRESSED 0 CROSS
    OR IS_BUTTON_PRESSED 0 TRIANGLE
        GOSUB draw_main_menu
    ENDWHILE
    GOSUB draw_main_menu
    IF IS_BUTTON_PRESSED 0 CROSS
        SWITCH selected
            CASE 0
                GOTO style_loop
                BREAK
            CASE 1
                selected = 0
                old_selected = -1
                GOTO cars_loop
                BREAK
            CASE 2
                selected = 0
                old_selected = -1
                GOTO debug_loop
                BREAK
            CASE 3
                BREAK
        ENDSWITCH
    ENDIF
    IF IS_BUTTON_PRESSED 0 TRIANGLE
    AND b_active = 0
        b_active = 1
        SET_PLAYER_CONTROL 0 1
        is_drawing = 0
        GOTO menu_init
    ENDIF
    GOTO main_menu_loop

    draw_main_menu:
    WAIT 0
    USE_TEXT_COMMANDS 1
    GOSUB draw_title
    SET_TEXT_FONT 2
    SET_TEXT_SCALE 0.35 1.68
    SET_TEXT_COLOUR 140 120 235 255
    SET_TEXT_EDGE 0 0 0 0 0
    DISPLAY_TEXT 30.0 82.0 RMOPTS
    DRAW_RECT RECT_X 90.0 RECT_W 20.0 0 0 0 255
    item_qt = ITEM_QUANTITY
    max_item = MAX_ITEMS
    GOSUB create_selection
    GOSUB set_textitem_params
    IF selected = 0
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 100.0 RMITEM1
    GOSUB set_textitem_params
    IF selected = 1
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 120.0 RMITEM2
    GOSUB set_textitem_params
    IF selected = 2
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 140.0 RMITEM3
    GOSUB set_textitem_params
    IF selected = 3
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 160.0 CARMOD1
    USE_TEXT_COMMANDS 0
    RETURN


    debug_loop:
    WHILE IS_BUTTON_PRESSED 0 CROSS
    OR IS_BUTTON_PRESSED 0 TRIANGLE
        GOSUB draw_debug_items
    ENDWHILE
    GOSUB draw_debug_items
    IF IS_BUTTON_PRESSED 0 CROSS
        SWITCH selected
            CASE 0
                IF NOT fps_onscreen = 1
                    START_NEW_SCRIPT fps_counter
                    fps_onscreen = 1
                ELSE
                    TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME showfps
                    fps_onscreen = 0
                ENDIF
                BREAK
            CASE 1
                IF NOT stream_onscreen = 1
                    START_NEW_SCRIPT streaming_usage
                    stream_onscreen = 1
                ELSE
                    TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME STRUSE
                    stream_onscreen = 0
                ENDIF
                BREAK
            CASE 2
                WAIT 500
                DISPLAY_HUD 0
                DISPLAY_RADAR 0

                READ_MEMORY filter_r_ptr 1 0 filter_col[0]
                READ_MEMORY filter_g_ptr 1 0 filter_col[1]
                READ_MEMORY filter_b_ptr 1 0 filter_col[2]
                READ_MEMORY filter_a_ptr 1 0 filter_col[3]
                GOTO colour_filter_selector
                BREAK
        ENDSWITCH
    ENDIF
    IF IS_BUTTON_PRESSED 0 TRIANGLE
        GOTO main_menu_loop
    ENDIF
    GOTO debug_loop


    draw_debug_items:
    WAIT 0
    USE_TEXT_COMMANDS 1
    GOSUB draw_vehicle_panel
    item_qt = STYLE_QUANTITY
    max_item = MAX_STYLE
    GOSUB create_selection
    GOSUB set_textitem_params
    IF selected = 0
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 100.0 VLFPSC
    GOSUB set_textitem_params
    IF selected = 1
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 120.0 VLSTRC
    GOSUB set_textitem_params
    IF selected = 2
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 140.0 CFILTER
    USE_TEXT_COMMANDS 0
    RETURN

    colour_filter_selector:
    WAIT 0

    IF IS_BUTTON_PRESSED PAD1 DPADLEFT
    AND filter_col[col_idx] > 0
        filter_col[col_idx]--
    ENDIF

    IF IS_BUTTON_PRESSED PAD1 DPADRIGHT
    AND filter_col[col_idx] < 255
        filter_col[col_idx]++
    ENDIF

    IF b_active = 0
        IF IS_BUTTON_PRESSED 0 DPADUP
        AND col_idx > 0
           col_idx--
           b_active = 1
        ENDIF
        IF IS_BUTTON_PRESSED 0 DPADDOWN
        AND col_idx < 3
            col_idx++
            b_active = 1
        ENDIF
    ELSE
        IF NOT IS_BUTTON_PRESSED 0 DPADUP
        AND NOT IS_BUTTON_PRESSED 0 DPADDOWN
            b_active = 0
        ENDIF
    ENDIF

    USE_TEXT_COMMANDS 1
    DRAW_RECT 50.0 50.0 100.0 100.0 filter_col[0] filter_col[1] filter_col[2] filter_col[3]
    USE_TEXT_COMMANDS 0
    PRINT_FORMATTED_NOW "%d %d %d %d" 1 filter_col[0] filter_col[1] filter_col[2] filter_col[3]

    IF IS_BUTTON_PRESSED PAD1 SQUARE
        filter_col[0] += 0x24020000
        filter_col[1] += 0x24020000
        filter_col[2] += 0x24020000
        filter_col[3] += 0x24020000
        WRITE_MEMORY filter_r_ptr 4 filter_col[0] 0 
        WRITE_MEMORY filter_g_ptr 4 filter_col[1] 0 
        WRITE_MEMORY filter_b_ptr 4 filter_col[2] 0 
        WRITE_MEMORY filter_a_ptr 4 filter_col[3] 0 
        filter_col[0] -= 0x24020000
        filter_col[1] -= 0x24020000
        filter_col[2] -= 0x24020000
        filter_col[3] -= 0x24020000
        WAIT 500
    ENDIF

    IF IS_BUTTON_PRESSED PAD1 CROSS
        filter_col[0] += 0x24020000
        filter_col[1] += 0x24020000
        filter_col[2] += 0x24020000
        filter_col[3] += 0x24020000
        WRITE_MEMORY filter_r_ptr 4 filter_col[0] 0 
        WRITE_MEMORY filter_g_ptr 4 filter_col[1] 0 
        WRITE_MEMORY filter_b_ptr 4 filter_col[2] 0 
        WRITE_MEMORY filter_a_ptr 4 filter_col[3] 0 
        filter_col[0] -= 0x24020000
        filter_col[1] -= 0x24020000
        filter_col[2] -= 0x24020000
        filter_col[3] -= 0x24020000
        DISPLAY_HUD 1
        DISPLAY_RADAR 1
        GOTO debug_loop
    ENDIF

    IF IS_BUTTON_PRESSED PAD1 TRIANGLE
        DISPLAY_HUD 1
        DISPLAY_RADAR 1
        GOTO debug_loop
    ENDIF

    GOTO colour_filter_selector

    style_loop:
    WHILE IS_BUTTON_PRESSED 0 CROSS
    OR IS_BUTTON_PRESSED 0 TRIANGLE
        GOSUB draw_style_items
    ENDWHILE
    GOSUB draw_style_items
    IF IS_BUTTON_PRESSED 0 CROSS
        SWITCH selected
            CASE 0
                BREAK
            CASE 1
                BREAK
            CASE 2
                BREAK
        ENDSWITCH
    ENDIF
    IF IS_BUTTON_PRESSED 0 TRIANGLE
        GOTO main_menu_loop
    ENDIF
    GOTO style_loop

    draw_style_items:
    WAIT 0
    USE_TEXT_COMMANDS 1
    GOSUB draw_vehicle_panel
    item_qt = STYLE_QUANTITY
    max_item = MAX_STYLE
    GOSUB create_selection
    GOSUB set_textitem_params
    IF selected = 0
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 100.0 STSKIN
    GOSUB set_textitem_params
    IF selected = 1
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 120.0 STCLOTH
    GOSUB set_textitem_params
    IF selected = 2
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 140.0 STRESET
    USE_TEXT_COMMANDS 0
    RETURN

    cars_loop:
    WHILE IS_BUTTON_PRESSED 0 CROSS
    OR IS_BUTTON_PRESSED 0 TRIANGLE
    OR IS_BUTTON_PRESSED 0 DPADDOWN
    OR IS_BUTTON_PRESSED 0 DPADUP
    OR IS_BUTTON_PRESSED 0 LEFTSHOULDER2
    OR IS_BUTTON_PRESSED 0 RIGHTSHOULDER2
        GOSUB draw_cars_items
    ENDWHILE
    GOSUB draw_cars_items

    GET_CHAR_COORDINATES scplayer px py pz
    GET_CHAR_HEADING scplayer pa
    pa += 90.0
    GET_OFFSET_FROM_CHAR_IN_WORLD_COORDS scplayer 0.0 5.0 0.0 px py pz

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
                veh_model = TOPFUN
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
            GOSUB draw_cars_items
        ENDWHILE
        CREATE_CAR veh_model px py pz vehicle
        SET_CAR_HEADING vehicle pa
        MARK_MODEL_AS_NO_LONGER_NEEDED veh_model
        MARK_CAR_AS_NO_LONGER_NEEDED vehicle
    ENDIF
    IF IS_BUTTON_PRESSED 0 SQUARE
        WARP_CHAR_INTO_CAR scplayer vehicle
        SET_PLAYER_CONTROL 0 1
        is_drawing = 0
        GOTO menu_init
    ENDIF
    IF IS_BUTTON_PRESSED 0 TRIANGLE
            selected = 0
            old_selected = -1
        GOTO main_menu_loop
    ENDIF
    IF IS_BUTTON_PRESSED 0 RIGHTSHOULDER2
            selected = 0
            old_selected = -1
        GOTO cars2_loop
    ENDIF
    old_selected = selected
    GOTO cars_loop

    draw_cars_items:
    WAIT 0
    USE_TEXT_COMMANDS 1
    GOSUB draw_vehicle_panel
    item_qt = 10.0
    max_item = 9
    GOSUB create_selection

    GOSUB set_textitem_params
    IF selected = 0
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 100.0 MANANA

    GOSUB set_textitem_params
    IF selected = 1
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 120.0 WASHING

    GOSUB set_textitem_params
    IF selected = 2
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 140.0 BANSHEE

    GOSUB set_textitem_params
    IF selected = 3
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 160.0 BUFFALO

    GOSUB set_textitem_params
    IF selected = 4
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 180.0 LANDSTK
    GOSUB set_textitem_params
    IF selected = 5
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 200.0 FELTZER

    GOSUB set_textitem_params
    IF selected = 6
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 220.0 TOPFUN

    GOSUB set_textitem_params
    IF selected = 7
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 240.0 BANDITO

    GOSUB set_textitem_params
    IF selected = 8
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 260.0 RANCHER

    GOSUB set_textitem_params
    IF selected = 9
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 280.0 RANCHER

    USE_TEXT_COMMANDS 0
    RETURN

    cars2_loop:
    WHILE IS_BUTTON_PRESSED 0 CROSS
    OR IS_BUTTON_PRESSED 0 TRIANGLE
    OR IS_BUTTON_PRESSED 0 DPADDOWN
    OR IS_BUTTON_PRESSED 0 DPADUP
    OR IS_BUTTON_PRESSED 0 LEFTSHOULDER2
    OR IS_BUTTON_PRESSED 0 RIGHTSHOULDER2
        GOSUB draw_cars2_items
    ENDWHILE
    GOSUB draw_cars2_items
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
            GOSUB draw_cars2_items
        ENDWHILE
        CREATE_CAR veh_model px py pz vehicle
        SET_CAR_HEADING vehicle pa
        MARK_MODEL_AS_NO_LONGER_NEEDED veh_model
        MARK_CAR_AS_NO_LONGER_NEEDED vehicle
    ENDIF
    IF IS_BUTTON_PRESSED 0 SQUARE
        WARP_CHAR_INTO_CAR scplayer vehicle
        SET_PLAYER_CONTROL 0 1
        is_drawing = 0
        GOTO menu_init
    ENDIF
    IF IS_BUTTON_PRESSED 0 TRIANGLE
        selected = 0
        old_selected = -1
        GOTO main_menu_loop
    ENDIF
    IF IS_BUTTON_PRESSED 0 LEFTSHOULDER2
        selected = 0
        old_selected = -1
        GOTO cars_loop
    ENDIF
    IF IS_BUTTON_PRESSED 0 RIGHTSHOULDER2
        selected = 0
        old_selected = -1
        GOTO cars3_loop
    ENDIF
    old_selected = selected
    GOTO cars2_loop

    draw_cars2_items:
    WAIT 0
    USE_TEXT_COMMANDS 1
    GOSUB draw_vehicle_panel
    item_qt = 10.0
    max_item = 9
    GOSUB create_selection

    GOSUB set_textitem_params
    IF selected = 0
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 100.0 SABRE

    GOSUB set_textitem_params
    IF selected = 1
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 120.0 BLISTAC

    GOSUB set_textitem_params
    IF selected = 2
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 140.0 VIRGO

    GOSUB set_textitem_params
    IF selected = 3
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 160.0 STALION

    GOSUB set_textitem_params
    IF selected = 4
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 180.0 GLENSHI
    GOSUB set_textitem_params
    IF selected = 5
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 200.0 INFERNU

    GOSUB set_textitem_params
    IF selected = 6
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 220.0 HOTRING

    GOSUB set_textitem_params
    IF selected = 7
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 240.0 COMET

    GOSUB set_textitem_params
    IF selected = 8
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 260.0 SUPERGT

    GOSUB set_textitem_params
    IF selected = 9
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 280.0 SADLER

    USE_TEXT_COMMANDS 0
    RETURN

    cars3_loop:
    WHILE IS_BUTTON_PRESSED 0 CROSS
    OR IS_BUTTON_PRESSED 0 TRIANGLE
    OR IS_BUTTON_PRESSED 0 DPADDOWN
    OR IS_BUTTON_PRESSED 0 DPADUP
    OR IS_BUTTON_PRESSED 0 LEFTSHOULDER2
    OR IS_BUTTON_PRESSED 0 RIGHTSHOULDER2
        GOSUB draw_cars3_items
    ENDWHILE
    GOSUB draw_cars3_items
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
            GOSUB draw_cars3_items
        ENDWHILE
        CREATE_CAR veh_model px py pz vehicle
        SET_CAR_HEADING vehicle pa
        MARK_MODEL_AS_NO_LONGER_NEEDED veh_model
        MARK_CAR_AS_NO_LONGER_NEEDED vehicle
    ENDIF
    IF IS_BUTTON_PRESSED 0 SQUARE
        WARP_CHAR_INTO_CAR scplayer vehicle
        SET_PLAYER_CONTROL 0 1
        is_drawing = 0
        GOTO menu_init
    ENDIF
    IF IS_BUTTON_PRESSED 0 TRIANGLE
        selected = 0
        old_selected = -1
        GOTO main_menu_loop
    ENDIF
    IF IS_BUTTON_PRESSED 0 LEFTSHOULDER2
        selected = 0
        old_selected = -1
        GOTO cars2_loop
    ENDIF
    IF IS_BUTTON_PRESSED 0 RIGHTSHOULDER2
        selected = 0
        old_selected = -1
        GOTO cars4_loop
    ENDIF
    old_selected = selected
    GOTO cars3_loop

    draw_cars3_items:
    WAIT 0
    USE_TEXT_COMMANDS 1
    GOSUB draw_vehicle_panel
    item_qt = 10.0
    max_item = 9
    GOSUB create_selection

    GOSUB set_textitem_params
    IF selected = 0
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 100.0 ALPHA

    GOSUB set_textitem_params
    IF selected = 1
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 120.0 BFINJEC

    GOSUB set_textitem_params
    IF selected = 2
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 140.0 BF400

    GOSUB set_textitem_params
    IF selected = 3
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 160.0 EMPEROR

    GOSUB set_textitem_params
    IF selected = 4
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 180.0 FORKLIF
    GOSUB set_textitem_params
    IF selected = 5
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 200.0 HOTRINB

    GOSUB set_textitem_params
    IF selected = 6
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 220.0 HUNTLEY

    GOSUB set_textitem_params
    IF selected = 7
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 240.0 JESTER

    GOSUB set_textitem_params
    IF selected = 8
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 260.0 JOURNEY

    GOSUB set_textitem_params
    IF selected = 9
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 280.0 NRG500

    USE_TEXT_COMMANDS 0
    RETURN

    cars4_loop:
    WHILE IS_BUTTON_PRESSED 0 CROSS
    OR IS_BUTTON_PRESSED 0 TRIANGLE
    OR IS_BUTTON_PRESSED 0 DPADDOWN
    OR IS_BUTTON_PRESSED 0 DPADUP
    OR IS_BUTTON_PRESSED 0 LEFTSHOULDER2
    OR IS_BUTTON_PRESSED 0 RIGHTSHOULDER2
        GOSUB draw_cars4_items
    ENDWHILE
    GOSUB draw_cars4_items
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
            GOSUB draw_cars4_items
        ENDWHILE
        CREATE_CAR veh_model px py pz vehicle
        SET_CAR_HEADING vehicle pa
        MARK_MODEL_AS_NO_LONGER_NEEDED veh_model
        MARK_CAR_AS_NO_LONGER_NEEDED vehicle
    ENDIF
    IF IS_BUTTON_PRESSED 0 SQUARE
        WARP_CHAR_INTO_CAR scplayer vehicle
        SET_PLAYER_CONTROL 0 1
        is_drawing = 0
        GOTO menu_init
    ENDIF
    IF IS_BUTTON_PRESSED 0 TRIANGLE
        selected = 0
        old_selected = -1
        GOTO main_menu_loop
    ENDIF
    IF IS_BUTTON_PRESSED 0 LEFTSHOULDER2
        selected = 0
        old_selected = -1
        GOTO cars3_loop
    ENDIF
    IF IS_BUTTON_PRESSED 0 RIGHTSHOULDER2
        selected = 0
        old_selected = -1
        GOTO cars5_loop
    ENDIF
    old_selected = selected
    GOTO cars4_loop

    draw_cars4_items:
    WAIT 0
    USE_TEXT_COMMANDS 1
    GOSUB draw_vehicle_panel
    item_qt = 10.0
    max_item = 9
    GOSUB create_selection

    GOSUB set_textitem_params
    IF selected = 0
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 100.0 MAVERIC

    GOSUB set_textitem_params
    IF selected = 1
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 120.0 PATRIOT

    GOSUB set_textitem_params
    IF selected = 2
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 140.0 RAINDAN

    GOSUB set_textitem_params
    IF selected = 3
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 160.0 RHINO

    GOSUB set_textitem_params
    IF selected = 4
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 180.0 SECURIC
    GOSUB set_textitem_params
    IF selected = 5
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 200.0 SWATVAN

    GOSUB set_textitem_params
    IF selected = 6
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 220.0 TAXI

    GOSUB set_textitem_params
    IF selected = 7
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 240.0 COPCARL

    GOSUB set_textitem_params
    IF selected = 8
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 260.0 TRACTOR

    GOSUB set_textitem_params
    IF selected = 9
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 280.0 YOSEMIT

    USE_TEXT_COMMANDS 0
    RETURN


    cars5_loop:
    WHILE IS_BUTTON_PRESSED 0 CROSS
    OR IS_BUTTON_PRESSED 0 TRIANGLE
    OR IS_BUTTON_PRESSED 0 DPADDOWN
    OR IS_BUTTON_PRESSED 0 DPADUP
    OR IS_BUTTON_PRESSED 0 LEFTSHOULDER2
    OR IS_BUTTON_PRESSED 0 RIGHTSHOULDER2
        GOSUB draw_cars5_items
    ENDWHILE
    GOSUB draw_cars5_items
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
            GOSUB draw_cars5_items
        ENDWHILE
        CREATE_CAR veh_model px py pz vehicle
        SET_CAR_HEADING vehicle pa
        MARK_MODEL_AS_NO_LONGER_NEEDED veh_model
        MARK_CAR_AS_NO_LONGER_NEEDED vehicle
    ENDIF
    IF IS_BUTTON_PRESSED 0 SQUARE
        WARP_CHAR_INTO_CAR scplayer vehicle
        SET_PLAYER_CONTROL 0 1
        is_drawing = 0
        GOTO menu_init
    ENDIF
    IF IS_BUTTON_PRESSED 0 TRIANGLE
        selected = 0
        old_selected = -1
        GOTO main_menu_loop
    ENDIF
    IF IS_BUTTON_PRESSED 0 LEFTSHOULDER2
        selected = 0
        old_selected = -1
        GOTO cars4_loop
    ENDIF
    old_selected = selected
    GOTO cars5_loop

    draw_cars5_items:
    WAIT 0
    USE_TEXT_COMMANDS 1
    GOSUB draw_vehicle_panel
    item_qt = 10.0
    max_item = 9
    GOSUB create_selection

    GOSUB set_textitem_params
    IF selected = 0
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 100.0 WALTON

    GOSUB set_textitem_params
    IF selected = 1
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 120.0 HOTRINA

    GOSUB set_textitem_params
    IF selected = 2
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 140.0 MAJESTI

    GOSUB set_textitem_params
    IF selected = 3
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 160.0 SANDKIN

    GOSUB set_textitem_params
    IF selected = 4
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 180.0 CHEETAH
    GOSUB set_textitem_params
    IF selected = 5
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 200.0 ZR350

    GOSUB set_textitem_params
    IF selected = 6
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 220.0 ELEGY

    GOSUB set_textitem_params
    IF selected = 7
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 240.0 COPCARL

    GOSUB set_textitem_params
    IF selected = 8
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 260.0 TRACTOR

    GOSUB set_textitem_params
    IF selected = 9
        SET_TEXT_COLOUR 0 0 0 255
    ENDIF
    DISPLAY_TEXT 31.0 280.0 YOSEMIT

    USE_TEXT_COMMANDS 0
    RETURN

    draw_vehicle_panel:
    GOSUB draw_title
    SET_TEXT_FONT 2
    SET_TEXT_SCALE 0.35 1.68
    SET_TEXT_COLOUR 140 120 235 255
    SET_TEXT_EDGE 0 0 0 0 0
    DISPLAY_TEXT 38.0 82.0 RMITEM2
    DRAW_RECT RECT_X 90.0 RECT_W 20.0 0 0 0 255
    RETURN

    draw_title:
    SET_TEXT_FONT 0
    SET_TEXT_EDGE 1 0 0 0 255
    SET_TEXT_COLOUR 255 255 255 255
    SET_TEXT_SCALE 1.0 4.0
    DISPLAY_TEXT 72.0 32.0 RMMENU
    GOSUB pulse_color
    DRAW_RECT RECT_X 45.0 RECT_W 70.0 r g b 235
    DRAW_RECT 558.0 414.0 100.0 23.0 0 0 0 235
    GOSUB set_textitem_params
    DISPLAY_TEXT 558.0 405.0 RMSELEC
    GOSUB set_textitem_params
    DISPLAY_TEXT 515.0 405.0 RMBACK
    RETURN

    set_textitem_params:
    SET_TEXT_FONT 1
    SET_TEXT_SCALE 0.35 1.68
    SET_TEXT_WRAPX 640.0
    SET_TEXT_COLOUR 255 255 255 255
    SET_TEXT_EDGE 0 0 0 0 0
    RETURN

    create_selection:
    items_pos = item_qt * 20.0
    items_pos /= 2.0 
    items_pos += 100.0
    items_size = item_qt * 20.0 
    DRAW_RECT RECT_X items_pos RECT_W items_size 0 0 0 235
    IF b_active = 0
        IF IS_BUTTON_PRESSED 0 DPADUP
           selected--
           b_active = 1
        ENDIF
        IF IS_BUTTON_PRESSED 0 DPADDOWN
            selected++
            b_active = 1
        ENDIF
    ELSE
        IF NOT IS_BUTTON_PRESSED 0 DPADUP
        AND NOT IS_BUTTON_PRESSED 0 DPADDOWN
            b_active = 0
        ENDIF
    ENDIF
    IF selected < 0
        selected = max_item
    ENDIF
    IF selected > max_item
        selected = 0
    ENDIF
    sc_float =# selected
    sc_float *= 20.0
    sc_pos = sc_float + 110.0
    DRAW_RECT RECT_X sc_pos RECT_W 20.0 255 255 255 220
    RETURN

    pulse_color:
    IF dummy = 1
        r--
        g--
        b--
        IF g < 60
            IF r < 120
                r = 120
            ENDIF
            IF b < 220
                b = 220
            ENDIF
            g = 60
            dummy = 2
        ENDIF
    ELSE
        r++
        g++
        b++
        IF r > 255
            r = 255
            dummy = 1
        ENDIF
        IF g > 255
            g = 255
            dummy = 1
        ENDIF
        IF b > 255
            b = 255
            dummy = 1
        ENDIF
    ENDIF

    RETURN
}

{
    wanted_blip:

        SCRIPT_NAME wantedb

        wanted_blip_loop:
        WAIT 0
        IF IS_WANTED_LEVEL_GREATER player 0
            WHILE IS_WANTED_LEVEL_GREATER player 0
                WRITE_MEMORY 0x0026E29C 4 0x240500FF 0
                WRITE_MEMORY 0x0026E2A4 4 0x240600A5 0
                WRITE_MEMORY 0x0026E2A8 4 0x240700A5 0
                WRITE_MEMORY 0x0026E2B0 4 0x240800FF 0
                WAIT 1000
                WRITE_MEMORY 0x0026E29C 4 0x240500A5 0
                WRITE_MEMORY 0x0026E2A4 4 0x240600A5 0
                WRITE_MEMORY 0x0026E2A8 4 0x240700FF 0
                WRITE_MEMORY 0x0026E2B0 4 0x240800FF 0
                WAIT 1000
            ENDWHILE

            WRITE_MEMORY 0x0026E29C 4 0x240500FF 0
            WRITE_MEMORY 0x0026E2A4 4 0x240600FF 0
            WRITE_MEMORY 0x0026E2A8 4 0x240700FF 0
            WRITE_MEMORY 0x0026E2B0 4 0x240800FF 0
            
        ENDIF
        GOTO wanted_blip_loop
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

    // Initilize player once (optional)
    GOSUB Switch_SetPlayer


    /////////////////////////////////////////////////
    
    
    WHILE NOT IS_GERMAN_GAME
        WAIT 0  

        IF IS_PLAYER_CONTROL_ON player // more?
            IF IS_BUTTON_PRESSED PAD1 DPADDOWN
            AND is_drawing = 0
                is_drawing = 1
                SHAKE_PAD PAD1 100 999999
                LOAD_TEXTURE_DICTIONARY VHUD
                SET_TIME_SCALE 0.2
                WRITE_MEMORY filter_call 4 0x0C1458AC 0

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

                    IF NOT IS_PLAYER_PLAYING player
                    OR IS_CHAR_DEAD scplayer
                    OR HAS_CHAR_BEEN_ARRESTED scplayer
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
                AND NOT IS_WANTED_LEVEL_GREATER player 0
                    switch_new_char = iCurSide
                    DISPLAY_HUD 0
                    DISPLAY_RADAR 0
                    GOSUB Switch_Run
                ENDIF

                // pad          
                WRITE_MEMORY 0x665204 4 backupSensValue 0
                WRITE_MEMORY filter_call 4 0x0C1467DC 0

                SET_TIME_SCALE 1.0
                WAIT 100  
                REMOVE_TEXTURE_DICTIONARY 
                is_drawing = 0
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
            GET_CHAR_COORDINATES scplayer switch_x[0] switch_y[0] switch_z[0]
        ENDIF
        IF NOT switch_cur_char = PLAYER_MICHAEL
            tmp_player = PLAYER_MICHAEL
            GOSUB Switch_ProcessFakeMove_ProcessThisPlayer   
          //  0165: set_marker y8 color_to 1
        ELSE
            GET_CHAR_COORDINATES scplayer switch_x[1] switch_y[1] switch_z[1]
        ENDIF
        IF NOT switch_cur_char = PLAYER_TREVOR
            tmp_player = PLAYER_TREVOR
            GOSUB Switch_ProcessFakeMove_ProcessThisPlayer    
        //    0165: set_marker y8 color_to 5
        ELSE
            GET_CHAR_COORDINATES scplayer switch_x[2] switch_y[2] switch_z[2]
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
    // tmp_player = switch player id
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

    SET_PLAYER_CONTROL player 0
    GET_CHAR_COORDINATES scplayer playerCoords[0] playerCoords[1] playerCoords[2]

    GOSUB Switch_ProcessFadeDelayStart

    GOSUB Switch_ProcessFadeDelay

    SET_FIXED_CAMERA_POSITION playerCoords[0] playerCoords[1] 160.0 0.0 0.0 0.0 
    POINT_CAMERA_AT_POINT playerCoords[0] playerCoords[1] playerCoords[2] 1 

    GOSUB Switch_ProcessFadeDelay

    WRITE_MEMORY filter_call 4 0x0C1467DC 0

    SET_FIXED_CAMERA_POSITION playerCoords[0] playerCoords[1] 200.0 0.0 0.0 0.0 
    POINT_CAMERA_AT_POINT playerCoords[0] playerCoords[1] playerCoords[2] 1 

    GOSUB Switch_ProcessFadeDelay

    SET_FIXED_CAMERA_POSITION playerCoords[0] playerCoords[1] 300.0 0.0 0.0 0.0 
    POINT_CAMERA_AT_POINT playerCoords[0] playerCoords[1] playerCoords[2] 1 

    GOSUB Switch_ProcessFadeDelay 

    GOSUB Switch_GetSimpleCoords

    SET_FIXED_CAMERA_POSITION fTmp[1] fTmp[2] 300.0 0.0 0.0 0.0 
    POINT_CAMERA_AT_POINT fTmp[1] fTmp[2] fTmp[3] 1 

    SET_CHAR_COORDINATES scplayer fTmp[1] fTmp[2] fTmp[3]
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
    SET_PLAYER_CONTROL player 1
    SET_CURRENT_CHAR_WEAPON scplayer 0

    DISPLAY_RADAR 1
    DISPLAY_HUD 1

    RETURN



    Swtich_PrepareAndSetNewPlayerCoord:
    IF IS_CHAR_IN_ANY_CAR scplayer
        STORE_CAR_CHAR_IS_IN_NO_SAVE scplayer (iTmp[0])
        WARP_CHAR_FROM_CAR_TO_COORD scplayer fTmp[1] fTmp[2] -100.0
        SET_CAR_COORDINATES iTmp[0] 0.0 0.0 -20.0 // dummy pos
        switch_in_car[switch_cur_char] = 1
        switch_last_used_car[switch_cur_char] = iTmp[0]
    ELSE                                
        switch_in_car[switch_cur_char] = 0 
        switch_last_used_car[switch_cur_char] = -1
    ENDIF

    CLEAR_CHAR_TASKS_IMMEDIATELY scplayer
    SET_CHAR_COORDINATES scplayer fTmp[1] fTmp[2] -100.0
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
            TASK_WARP_CHAR_INTO_CAR_AS_DRIVER scplayer iTmp[0]
        ENDIF
    ENDIF
    RETURN


    Switch_GetSetStats:
    // Money
    STORE_SCORE player (switch_money[switch_cur_char])
    iTmp[0] = switch_money[switch_cur_char]

    // reset money zero, maybe better use another way
    iTmp[0] *= -1
    IF iTmp[0] > 0 // fix negative money
        iTmp[0] = 0
    ENDIF
    ADD_SCORE player iTmp[0]

    ADD_SCORE player switch_money[switch_new_char]

    // Wanted
    STORE_WANTED_LEVEL player (switch_wanted[switch_cur_char])
    ALTER_WANTED_LEVEL player switch_wanted[switch_new_char] 
    RETURN


    Switch_SetPlayer:
    GOSUB Switch_GetSetStats
    IF switch_new_char = PLAYER_MICHAEL
        GIVE_MELEE_ATTACK_TO_CHAR scplayer 5 6 
        GIVE_PLAYER_CLOTHES player 0 0 13 
        GIVE_PLAYER_CLOTHES player 0 0 14 
        GIVE_PLAYER_CLOTHES player 0 0 15 
        GIVE_PLAYER_CLOTHES player 0 0 16 
        GIVE_PLAYER_CLOTHES player 0 0 17 
        GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP player SUIT1YELLOW SUIT1 0 
        GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP player SUIT1TRYELLOW SUIT1TR 2 
        GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP player SHOEDRESSBLK SHOE 3 
        GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP player JHERICURL JHERI 1 
        GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP player 4RIP 4RIP 4  
        BUILD_PLAYER_MODEL player  
    ENDIF  
    IF switch_new_char = PLAYER_FRANKLIN
        GIVE_MELEE_ATTACK_TO_CHAR scplayer 5 6 
        GIVE_PLAYER_CLOTHES player 0 0 13 
        GIVE_PLAYER_CLOTHES player 0 0 14 
        GIVE_PLAYER_CLOTHES player 0 0 15 
        GIVE_PLAYER_CLOTHES player 0 0 16 
        GIVE_PLAYER_CLOTHES player 0 0 17 
        GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP player SHIRTABLUE SHIRTA 0 
        GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP player LEATHERTR LEATHERTR 2 
        GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP player SHOEDRESSBLK SHOE 3 
        GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP player PLAYER_FACE HEAD 1   
        BUILD_PLAYER_MODEL player 
    ENDIF 
    IF switch_new_char = PLAYER_TREVOR
        GIVE_MELEE_ATTACK_TO_CHAR scplayer 5 6 
        GIVE_PLAYER_CLOTHES player 0 0 13 
        GIVE_PLAYER_CLOTHES player 0 0 14 
        GIVE_PLAYER_CLOTHES player 0 0 15 
        GIVE_PLAYER_CLOTHES player 0 0 16 
        GIVE_PLAYER_CLOTHES player 0 0 17 
        GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP player TSHIRT TSHIRT 0 
        GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP player LEATHERTR LEATHERTR 2 
        GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP player SHOEDRESSBLK SHOE 3 
        GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP player WEDGE WEDGE 1 
        GIVE_PLAYER_CLOTHES_OUTSIDE_SHOP player 4RIP 4RIP 4     
        BUILD_PLAYER_MODEL player  
    ENDIF 
    switch_cur_char = switch_new_char
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

    CONST_FLOAT WHEEL_SIZEX 313.6
    CONST_FLOAT WHEEL_SIZEY 125.0

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

    CONST_FLOAT BARS_BG_POS_X 86.91
    CONST_FLOAT BARS_BG_POS_Y 422.8 
    CONST_FLOAT BARS_BG_SIZ_X 95.2
    CONST_FLOAT BARS_BG_SIZ_Y 5.8 

    CONST_FLOAT BARS_GL_POS_Y 422.3  
    CONST_FLOAT BARS_GL_SIZ_Y 3.0

    CONST_FLOAT BARS_HE_POS_X 40.7
    CONST_FLOAT BARS_HE_SIZ_X 33.0

    CONST_FLOAT BARS_AR_POS_X 89.0
    CONST_FLOAT BARS_AR_SIZ_X 14.0

    CONST_FLOAT BARS_AB_POS_X 113.8
    CONST_FLOAT BARS_AB_SIZ_X 19.3


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

            IF IS_PLAYER_CONTROL_ON player
            AND NOT IS_CHAR_IN_ANY_CAR scplayer
                IF IS_BUTTON_PRESSED PAD1 4
                AND is_drawing = 0
                    is_drawing = 1
                    SHAKE_PAD PAD1 100 999999
                    LOAD_TEXTURE_DICTIONARY VHUD

                    SET_TIME_SCALE 0.2
                    SET_DARKNESS_EFFECT 1 50    

                    WRITE_MEMORY filter_call 4 0x0C1458AC 0

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
                    GET_CURRENT_CHAR_WEAPON scplayer (iCurWeapon)
                    GOSUB GetPreferedMeleeSlot

                    WHILE IS_BUTTON_PRESSED PAD1 4
                        WAIT 0  

                        IF NOT IS_PLAYER_PLAYING player
                        OR IS_CHAR_DEAD scplayer
                        OR HAS_CHAR_BEEN_ARRESTED scplayer
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
                            DRAW_SPRITE_WITH_ROTATION wheel_part 320.0 224.0 WHEEL_SIZEX WHEEL_SIZEY fAngle 255 255 255 255
                            IF iCurSide = iSide
                                DRAW_SPRITE_WITH_ROTATION wheel_selected 320.0 224.0 WHEEL_SIZEX WHEEL_SIZEY fAngle char_r[switch_cur_char] char_g[switch_cur_char] char_b[switch_cur_char] 255
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
                        SET_CURRENT_CHAR_WEAPON scplayer iCheckWeapon
                    ENDIF

                    // disable camera

                    // pad          
                    WRITE_MEMORY 0x665204 4 backupSensValue 0

                    WRITE_MEMORY filter_call 4 0x0C1467DC 0
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

        GET_CHAR_WEAPON_IN_SLOT scplayer iPreferMeleeSlot i j j

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
        GET_CHAR_WEAPON_IN_SLOT scplayer iSlot weapon iCheckWeapon ammo i model i
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
    GET_CHAR_WEAPON_IN_SLOT scplayer 9 k j j
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
        y = 104.0
    ENDIF   
    IF iSide = SIDE_SMG
        iSlot = 5  
        x = 405.0
        y = 140.0 
    ENDIF  
    IF iSide = SIDE_ASSALT
        iSlot = 6  
        x = 440.0
        y = 220.0 
    ENDIF  
    IF iSide = SIDE_RIFLE
        iSlot = 7 
        x = 405.0
        y = 300.0 
    ENDIF     
    IF iSide = SIDE_MELEE
        iSlot = 1
        x = 320.0
        y = 340.0 
    ENDIF     
    IF iSide = SIDE_SHOTGUN   
        iSlot = 4
        x = 235.0
        y = 300.0 
    ENDIF      
    IF iSide = SIDE_HEAVY
        iSlot = 8
        x = 210.0
        y = 220.0 
    ENDIF       
    IF iSide = SIDE_PROJECTILES
        iSlot = 9
        x = 235.0
        y = 140.0 
    ENDIF
    RETURN

    GetWeapon:
    GET_CHAR_WEAPON_IN_SLOT scplayer iSlot iCheckWeapon iCheckAmmo i

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
            GET_CHAR_WEAPON_IN_SLOT scplayer iPreferMeleeSlot iCheckWeapon iCheckAmmo i  
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
    GET_CHAR_WEAPON_IN_SLOT scplayer iSlot iCheckWeapon iCheckAmmo i 
    IF iCheckWeapon = iCurWeapon
        iPreferMeleeSlot = iSlot
        RETURN
    ENDIF
    iSlot = 2  
    GET_CHAR_WEAPON_IN_SLOT scplayer iSlot iCheckWeapon iCheckAmmo i 
    IF iCheckWeapon = iCurWeapon
        iPreferMeleeSlot = iSlot 
        RETURN
    ENDIF  
    iSlot = 11             
    GET_CHAR_WEAPON_IN_SLOT scplayer iSlot iCheckWeapon iCheckAmmo i 
    IF iCheckWeapon = iCurWeapon
        iPreferMeleeSlot = iSlot     
        RETURN
    ENDIF
    iSlot = 13            
    GET_CHAR_WEAPON_IN_SLOT scplayer iSlot iCheckWeapon iCheckAmmo i 
    IF iCheckWeapon = iCurWeapon
        iPreferMeleeSlot = iSlot    
        RETURN
    ENDIF    
    iSlot = 12        
    GET_CHAR_WEAPON_IN_SLOT scplayer iSlot iCheckWeapon iCheckAmmo i 
    IF iCheckWeapon = iCurWeapon
        iPreferMeleeSlot = iSlot   
        RETURN
    ENDIF
    RETURN

    CheckDrawCurSide:
    IF iCurWeapon = iCheckWeapon
        LOAD_SPRITE wheel_current "wheel_current"
        DRAW_SPRITE_WITH_ROTATION wheel_current 320.0 224.0 WHEEL_SIZEX WHEEL_SIZEY fAngle char_r[switch_cur_char] char_g[switch_cur_char] char_b[switch_cur_char] 255
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
    cops_on_radar:
    SCRIPT_NAME COPMARK 

    LVAR_INT ped handler i pedtype blip char_ptr blip_added
    LVAR_FLOAT x y z
    
    cops_ident_loop:
    WAIT 250
    IF IS_PLAYER_PLAYING player
    AND IS_WANTED_LEVEL_GREATER player 0
        TIMERA = 0

        READ_MEMORY 0x66B918 4 0 (handler)
        handler += 0x4

        READ_MEMORY handler 4 0 (handler)

        i = 0
        WHILE i <= 35584
            READ_MEMORY handler 1 0 (ped)
            handler += 0x1
            IF ped >= 0x00 
            AND 0x80 > ped
                ped += i

                GET_PED_TYPE ped (pedtype)
                IF pedtype = 6
                    GET_PED_POINTER ped (char_ptr)
                    char_ptr += 0x7D6 //Padding, we'll use it to store our flag
                    READ_MEMORY char_ptr 1 0 (blip_added)
                    IF blip_added = 0x0
                        ADD_BLIP_FOR_CHAR ped (blip)
                        CHANGE_BLIP_DISPLAY blip 2
                        WRITE_MEMORY char_ptr 1 0xFF 0
                    ENDIF
                ENDIF
            ENDIF

            i += 0x100
        ENDWHILE

    ENDIF
    GOTO cops_ident_loop
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
        GET_CHAR_HEALTH scplayer (iCurHealth)
        IF NOT iLastCurHealth = iCurHealth
            RETURN
        ENDIF
    ENDWHILE

    fRegeHealthPercent = fCurHealthPercent
    WHILE NOT IS_GERMAN_GAME
        IF GOSUB ProcessCancel
            RETURN
        ENDIF
        GET_CHAR_HEALTH scplayer (iCurHealth)
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
    SET_CHAR_HEALTH scplayer iFinalHealth
    RETURN

    StoreValues:
    GET_CHAR_HEALTH scplayer (iCurHealth)

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
    GET_CHAR_SPEED scplayer (char_speed)
    IF char_speed > 0.0
    AND NOT IS_CHAR_IN_ANY_CAR scplayer
        IS_INT_LVAR_GREATER_THAN_CONSTANT TIMERA -1
        RETURN
    ENDIF
    IS_INT_LVAR_EQUAL_TO_CONSTANT TIMERA -1
    RETURN
}


fade_for_mission:
    IF IS_PLAYER_PLAYING player
        SET_PLAYER_CONTROL player OFF // Tip: turning player control off makes the player safe
                                      // (i.e. cannot die or get arrested)
        SET_FADING_COLOUR 0 0 0
        DO_FADE 500 FADE_OUT
        WHILE GET_FADING_STATUS
            WAIT 0
        ENDWHILE
        CLEAR_PRINTS
        CLEAR_HELP
        CLEAR_CHAR_TASKS scplayer
    ENDIF
RETURN


{
    separateVehicleHandling:
    SCRIPT_NAME INDVEHH

    LVAR_INT debug_car debug_car_ptr tmp_car_ptr debug_state pHandling pMass pIndieHandling pTmpHandling i handlingOffset
    LVAR_FLOAT debug_car_mass new_mass

    CONST_INT memcpy 0x54E3B0
    CONST_INT memset 0x54E568

    GET_LABEL_POINTER indievehhandlings_label (pIndieHandling)

    IF IS_PLAYER_PLAYING player
    AND IS_CHAR_SITTING_IN_ANY_CAR scplayer

        handlingReplFlag = HANDLING_HOOK_SIGNAL
        STORE_CAR_CHAR_IS_IN_NO_SAVE scplayer (debug_car)
        GET_VEHICLE_POINTER debug_car (debug_car_ptr)
        pHandling = debug_car_ptr + 0x38C // handlingData
        READ_MEMORY pHandling 4 0 (pHandling)

        IF pHandling < 0x6B1FF0
        OR pHandling > 0x6F3AB8
            IF usedHandlingSlots < 12
                handlingOffset = usedHandlingSlots * 0x154 // New handling size
                pIndieHandling += handlingOffset

                CALL_FUNCTION memcpy 3 0 (pIndieHandling, pHandling, 0xE0)  // Copy handling

                pHandling = debug_car_ptr + 0x38C // handlingData

                WRITE_MEMORY pHandling 4 pIndieHandling 0 // Replace handling pointer

                indieVehicles[usedHandlingSlots] = debug_car_ptr
                indieHandlings[usedHandlingSlots] = pIndieHandling

                usedHandlingSlots++
            ELSE
                i = 0
                WHILE i < 12
                    pTmpHandling = indieVehicles[i] + 0x38C // handlingData
                    READ_MEMORY pTmpHandling 4 0 (pTmpHandling)

                    IF NOT pTmpHandling = indieHandlings[i]
                        handlingOffset = i * 0x154 // New handling size
                        pIndieHandling += handlingOffset

                        CALL_FUNCTION memset 3 0 (pIndieHandling, 0, 0x154)  // Fill old handling
                        CALL_FUNCTION memcpy 3 0 (pIndieHandling, pHandling, 0xE0)  // Copy handling

                        pHandling = debug_car_ptr + 0x38C // handlingData

                        WRITE_MEMORY pHandling 4 pIndieHandling 0 // Replace handling pointer

                        indieVehicles[i] = debug_car_ptr
                        indieHandlings[i] = pIndieHandling

                        BREAK
                    ENDIF

                    i++
                ENDWHILE
            ENDIF
        ENDIF
        
        handlingReplFlag = HANDLING_HOOK_WAIT

    ENDIF

    TERMINATE_THIS_SCRIPT
}