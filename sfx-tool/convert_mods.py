import os, io
import subprocess

root = os.getcwd()
conv_root = os.getcwd()

with os.scandir(root) as root_entries:
    for root_entry in root_entries:
        if root_entry.name.endswith("_mod"):
            convdir_name = root_entry.name.replace("_mod", "_converted")
            extdir_name = root_entry.name.replace("_mod", "_extracted")
            conv_bank = root + "\\" + convdir_name + "\\"
            ext_bank = root + "\\" + extdir_name + "\\"
            bank = root + "\\" + root_entry.name + "\\"
    
            if not os.path.exists(convdir_name):
                os.mkdir(convdir_name, 777)

            with os.scandir(bank) as banks_entries:
               for bank_entry in banks_entries:
                    
                    if not os.path.exists(conv_bank + "\\" + bank_entry.name):
                        os.mkdir(conv_bank + "\\" + bank_entry.name, 777)

                    sound_path = bank + "\\" + bank_entry.name + "\\"
                    sound_conv_path = conv_bank + "\\" + bank_entry.name + "\\"
                    sound_ext_path = ext_bank + "\\" + bank_entry.name + "\\"

                    with io.open(sound_ext_path + "sfx_meta.dat") as meta:
                        with os.scandir(bank + "\\" + bank_entry.name) as sounds_entries:
                            for sound_entry in sounds_entries:
                                metadata = [int(i) for i in meta.readline().split()]
                                if metadata[0] == -1:
                                    subprocess.run(["wav2vag.exe", sound_path+sound_entry.name, sound_conv_path+sound_entry.name.replace(".wav", ".vag")])
                                else:
                                    subprocess.run(["wav2vag.exe", sound_path+sound_entry.name, sound_conv_path+sound_entry.name.replace(".wav", ".vag"), f"-l:{metadata[0]}"])

                            print(sound_entry.name)
