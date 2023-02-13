import pycdlib, os, collections, configparser, hashlib, shutil, py7zr

config = configparser.ConfigParser()
config.read('config.ini')
iso_path = config['DEFAULT']['iso_name']
uiso_path = config['DEFAULT']['uiso_path'].replace("$cwd", os.getcwd())
output = config['DEFAULT']['output']
build_path = config['DEFAULT']['build_path']
project_path = config['DEFAULT']['project_path']
allow_modded = config['DEFAULT']['allow_modded'] != "False"
extract_once = config['DEFAULT']['extract_once'] != "False"
extracted_iso = config['SAVED_CONFIG']['extracted_iso']

BUF_SIZE = 65536

def checksum(src):
    md5 = hashlib.md5()
    sha1 = hashlib.sha1()

    with open(src, 'rb') as f:
        while True:
            data = f.read(BUF_SIZE)
            if not data:
                break
            md5.update(data)
            sha1.update(data)
    
    return {"md5":md5.hexdigest(), "sha1":sha1.hexdigest()}

def check_iso(src):
    print("Searching GTA San Andreas NTSC v1.03 ISO Dump...")

    iso_exists = os.path.exists(src)

    if iso_exists:
        print("OK")
    else:
        print("FAILED")
        src = input("Enter the name of the .iso file here (if not, leave it empty):")
        if(len(src) == 0 or not os.path.exists(src)):
            print("Error: ISO File not found. Exiting...")
            exit()

    if not allow_modded and not extracted_iso:
        print("Running hash calculation... ")

        digest = checksum(src)

        if(digest["md5"] != "c383c015065f8060343032480928d08d" or digest["sha1"] != "66cb01a8281cc132e023a1e52afc75d1fad3fbe1"):
            print("FAILED\nError: MD5/SHA1 Checksum failed. Exiting...")
            exit()
        else:
            print("OK")
    

def extract_iso(src, dst):
    if not os.path.exists(dst) and extract_once:
        print("Extracting ISO Dump file... ")
        os.makedirs(dst)

        iso = pycdlib.PyCdlib()

        iso.open(src)

        root_entry = iso.get_record(**{"iso_path": "/"})
        dirs = collections.deque([root_entry])
        while dirs:
            dir_record = dirs.popleft()
            ident_to_here = iso.full_path_from_dirrecord(dir_record, False)
            relname = ident_to_here[len("/"):]
            if relname and relname[0] == '/':
                relname = relname[1:]
            if dir_record.is_dir():
                if relname != '':
                    os.makedirs(os.path.join(dst, relname))
                child_lister = iso.list_children(**{"iso_path": ident_to_here})
                for child in child_lister:
                    if child is None or child.is_dot() or child.is_dotdot():
                        continue
                    dirs.append(child)
            else:
                iso.get_file_from_iso(os.path.join(dst, relname.replace(";1", "")), **{"iso_path": ident_to_here})

        iso.close()
        config['SAVED_CONFIG']['extracted_iso'] = "True"
        print("OK")

print("GTA V Legacy builder v0.1 - Created by Daniel Santos\n")

if os.path.exists(build_path):
    shutil.rmtree(build_path)

check_iso(iso_path)
extract_iso(iso_path, build_path)

print("Copying files...")

if os.path.exists(build_path + "/models/gta3_1.img"):
    os.remove(build_path + "/models/gta3_1.img")

if os.path.exists(build_path + "/movies"):
    shutil.rmtree(build_path + "/movies")

if not os.path.exists(build_path + "/intro"):
    os.makedirs(build_path + "/intro")

shutil.copytree(project_path + "/intro", build_path + "/intro", dirs_exist_ok=True)
shutil.copytree(project_path + "/text", build_path + "/text", dirs_exist_ok=True)
shutil.copytree(project_path + "/data", build_path + "/data", dirs_exist_ok=True)
shutil.copytree(project_path + "/models", build_path + "/models", dirs_exist_ok=True)

shutil.copytree(project_path + "/audio/CONFIG", build_path + "/audio/CONFIG", dirs_exist_ok=True)
shutil.copytree(project_path + "/audio/SFX", build_path + "/audio/SFX", dirs_exist_ok=True)

filenames = [project_path + f"/audio/STREAMS/STREAMS.7z.{part:03d}" for part in range(1, 86)]

with open(build_path + '/audio/STREAMS/result.7z', 'ab') as outfile:  # append in binary mode
    for fname in filenames:
        with open(fname, 'rb') as infile:        # open in binary mode also
            outfile.write(infile.read())

with py7zr.SevenZipFile(build_path + "/audio/STREAMS/result.7z", "r") as archive:
    archive.extractall(path=(build_path + "/audio/STREAMS"))
os.remove(build_path + "/audio/STREAMS/result.7z")

shutil.copytree(project_path + "/anim", build_path + "/anim", dirs_exist_ok=True)
shutil.copytree(project_path + "/plugins", build_path + "/plugins", dirs_exist_ok=True)

shutil.copytree(project_path + "/overlays", build_path, dirs_exist_ok=True)

shutil.copy2(build_path + "/models/gta3.img", "./IMGconsole_32-bit")
shutil.copy2(build_path + "/models/gta_int.img", "./IMGconsole_32-bit")

print("OK\nBuilding IMG Streaming files...")

shutil.copy2(project_path + "/assets/build.txt", "./IMGconsole_32-bit")

if os.path.exists("./IMGconsole_32-bit" + "/gta3"):
    os.remove("./IMGconsole_32-bit" + "/gta3")

if os.path.exists("./IMGconsole_32-bit" + "/gta_int"):
    os.remove("./IMGconsole_32-bit" + "/gta_int")

os.mkdir("./IMGconsole_32-bit" + "/gta3")
os.mkdir("./IMGconsole_32-bit" + "/gta_int")

shutil.copytree(project_path + "/assets/Anims", "./IMGconsole_32-bit" + "/gta3", dirs_exist_ok=True)
shutil.copytree(project_path + "/assets/Radar", "./IMGconsole_32-bit" + "/gta3", dirs_exist_ok=True)

for map in os.listdir(project_path + "/assets/Map"):
    if not os.path.isfile(project_path + "/assets/Map/" + map):
        shutil.copytree(project_path + "/assets/Map/" + map, "./IMGconsole_32-bit" + "/gta3", ignore=shutil.ignore_patterns('*.txt', '*.cfg','*.ide', '*.dat'), dirs_exist_ok=True)

for ped in os.listdir(project_path + "/assets/Peds"):
    if not os.path.isfile(project_path + "/assets/Peds/" + ped):
        shutil.copytree(project_path + "/assets/Peds/" + ped, "./IMGconsole_32-bit" + "/gta3", ignore=shutil.ignore_patterns('*.txt', '*.cfg','*.ide', '*.dat'), dirs_exist_ok=True)

for tree in os.listdir(project_path + "/assets/Vegetation"):
    if not os.path.isfile(project_path + "/assets/Vegetation/" + tree):
        shutil.copytree(project_path + "/assets/Vegetation/" + tree, "./IMGconsole_32-bit" + "/gta3", ignore=shutil.ignore_patterns('*.txt', '*.cfg','*.ide', '*.dat'), dirs_exist_ok=True)

for vehicle in os.listdir(project_path + "/assets/Vehicles"):
    if not os.path.isfile(project_path + "/assets/Vehicles/" + vehicle):
        shutil.copytree(project_path + "/assets/Vehicles/" + vehicle, "./IMGconsole_32-bit" + "/gta3", ignore=shutil.ignore_patterns('*.txt', '*.cfg','*.ide', '*.dat'), dirs_exist_ok=True)

for weapon in os.listdir(project_path + "/assets/Weapons"):
    if not os.path.isfile(project_path + "/assets/Weapons/" + weapon):
        shutil.copytree(project_path + "/assets/Weapons/" + weapon, "./IMGconsole_32-bit" + "/gta3", ignore=shutil.ignore_patterns('*.txt', '*.cfg','*.ide', '*.dat'), dirs_exist_ok=True)

shutil.copytree(project_path + "/assets/Interiors", "./IMGconsole_32-bit" + "/gta_int", dirs_exist_ok=True)

os.system(f'cmd /c "{os.getcwd()}\\IMGconsole_32-bit\\fastman92ImgConsole32.exe -script "{os.getcwd()}\\IMGconsole_32-bit\\build.txt""')

shutil.rmtree("./IMGconsole_32-bit" + "/gta3")
shutil.rmtree("./IMGconsole_32-bit" + "/gta_int")

shutil.copy2("./IMGconsole_32-bit" + "/gta3.img", build_path + "/models")
shutil.copy2("./IMGconsole_32-bit" + "/gta_int.img", build_path + "/models")

os.remove("./IMGconsole_32-bit" + "/gta3.img")
os.remove("./IMGconsole_32-bit" + "/gta_int.img")

print("OK\nBuilding ISO File...")

if os.path.exists(output):
    os.remove(output)

uiso_cmds = [f'-input "{os.getcwd()}\\{iso_path}"', 
             f'-rmdir "/MODELS/GTA3_1.IMG"',
             f'-rmdir "/MOVIES"',
             f'-directory "{os.getcwd()}\\build\\"',
             f'-output "{os.getcwd()}\\{output}"']

os.system(f'cmd /c "{uiso_path}\\UltraISO.exe {" ".join(uiso_cmds)}"')

print("OK")

with open('config.ini', 'w') as configfile:    # save
    config.write(configfile)
