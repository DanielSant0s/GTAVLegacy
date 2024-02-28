==Tuning Parts Installation==
=============================

**NOTE: DO NOT PUT THIS README IN MODLOADER. IT WON'T WORK.

--Requirements
	> ModLoader
	> CLEO 4
	> Fastman92 Limit Adjuster

1) Copy carmods.dat and shopping.dat from the game's Data Folder to any folder inside ModLoader (I recommend having a central dedicated Folder for modified Data Files like this)

2) Place the 'Extended Tuning Parts' Folder inside The Folder where your vehicle model is located.
	a) To change the Tuning Part IDs, open loader.txt inside the folder and change it to your liking

3) Open the shopping.dat you copied, then paste the following lines in their respective sections (Ctrl + F to find these sections faster)

	a) section CarMods	
		exh_b_hrc		HRCEXH		respect 0 	sexy 0		1100	
		bnt_lr_hrc		HRCBNT		respect 0 	sexy 0		800	
		bnt_lr_hrc2		HRCBNB		respect 0 	sexy 0		650	
		misc_c_b_hrc		HRCGRL		respect 0 	sexy 0		1450	
		rf_b_sc_hrc		HRCRFA		respect 0 	sexy 0		950	
		rf_b_sc_hrc2		HRCRFB		respect 0 	sexy 0		1050	#END OF HERCULES
		
	b) section carmod1 # Normal Cars
		item exh_b_hrc			
		item bnt_lr_hrc			
		item bnt_lr_hrc2			
		item misc_c_b_hrc			
		item rf_b_sc_hrc			
		item rf_b_sc_hrc2			#END OF HERCULES

4) Add the following line to  hercules_add.txt :
	
	hercules, bnt_b_sc_l, bnt_b_sc_m, exh_b_l, exh_b_t, exh_b_ts, lgt_b_rspt, lgt_b_sspt, rf_b_sc_r, exh_b_hrc, bnt_lr_hrc, bnt_lr_hrc2, misc_c_b_hrc, rf_b_sc_hrc, rf_b_sc_hrc2