==Tuning Parts Installation==
======================================

**NOTE: DO NOT PUT THIS README IN MODLOADER. IT WON'T WORK.

--Requirements
	> ModLoader
	> CLEO 4
	> Fastman92 Limit Adjuster

1) Copy carmods.dat and shopping.dat from the game's Data Folder to any folder inside ModLoader (I recommend having a central dedicated Folder for modified Data Files like this)

2) Place the 'Tuning Parts' Folder inside The Folder where your vehicle model is located (i.e. Peyote (SA) Folder).
	a) To change the Tuning Part IDs, open loader.txt inside the folder and change it to your liking

3) Open the shopping.dat you copied, then paste the following lines in their respective sections (Ctrl + F to find these sections faster)

	a) section CarMods	
		rbmp_lr_pyt1	PYTRF1	   	respect 0 	sexy 0		2130
		rbmp_lr_pyt2	PYTRF2	   	respect 0 	sexy 0		2130
		rf_lr_pyt1	PYTR1	   	respect 0 	sexy 0		2130
		bnt_lr_pyt1	INDUC	   	respect 0 	sexy 0		2130	# END OF PEYOTE
		
	b) section carmod2 # Lowriders
		item rbmp_lr_pyt1
		item rbmp_lr_pyt2
		item rf_lr_pyt1
		item bnt_lr_pyt1		# END OF PEYOTE

4) Replace the "carmods.dat" line in the respective .txts with this line:
	
	, nto_b_l, nto_b_s, nto_b_tw, rbmp_lr_pyt1, rbmp_lr_pyt2, bnt_lr_pyt1