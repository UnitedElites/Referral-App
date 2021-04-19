package com.example.referal_app_version2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "referral";
    public static final String DATABASE_TABLE = "User";
    public static final String DATABASE_TABLE_2 = "Appointment";
    public static final String DATABASE_TABLE_3 = "Information";
    public static final String DATABASE_TABLE_4 = "loginemail";

    public static final int DATABASE_VERSION = 1;

    public static final String KEY_ROWID = "_id";
    public static final String KEY_USERNAME = "user_name";
    public static final String KEY_USEREMAIL = "user_email";
    public static final String KEY_USERAGE = "user_age";
    public static final String KEY_USERGENDER = "user_gender";
    public static final String KEY_USERPASSWORD = "user_password";
    public static final String KEY_EMERGENCYEMAIL = "emergency_email";
    public static final String KEY_EMERGENCYPHONE = "emergency_phone";
    public static final String KEY_APPTIMAGE = "appt_image";


    public static final String KEY_DOD = "appoint_date";
    public static final String KEY_title = "title";
    public static final String KEY_appdetail = "appoint_detail";
    public static final String KEY_apptime = "day_time";
    public static final String KEY_cate = "category";
    public static final String KEY_infotitle = "title";
    public static final String KEY_infoaddress = "address";
    public static final String KEY_infophone = "phone";
    public static final String KEY_infoemail = "email";







    private static final String DATABASE_CREATE = "create table " + DATABASE_TABLE +
            "(_id integer primary key autoincrement," + "user_name text not null," +
            "user_email text not null," + "user_age text not null," + "user_gender text not null,"+ "user_password text not null," +
            "emergency_email text," + "emergency_phone text )";



    String DATABASE_CREATE_2 = "create table " + DATABASE_TABLE_2 +
            "(_id integer primary key autoincrement," + "user_email text not null," + "title text ," +
            "appoint_date text ," + "day_time text ," + "appt_image text," + "appoint_detail text )";

    String DATABASE_CREATE_3 = "create table " + DATABASE_TABLE_3 +
            "(_id integer primary key autoincrement," + "category text not null," + "title text ," +
            "address text ," + "email text ," + "phone text )";

    String DATABASE_CREATE_4 = "create table " + DATABASE_TABLE_4 +
            "(_id integer primary key autoincrement,"  + "user_email text not null )";



    public DatabaseHelper (Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    void add_cate_data(SQLiteDatabase db){


        //Doctor
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Jervis Medical Centre","1 Jervis St, North City, Dublin 1","http://www.jervismedical.ie/","35318735959"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Capel Street Medical Centre","138 Capel St, North City, Dublin, D01 C4E9","http://gpdoc.ie/","35315496267"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Custom House Square Medical Centre IFSC","2 Gandon House, Mayor Street Lower, Dublin, D01 CY50","http://www.custommedical.ie/","35318290902"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Summerhill Family Practice","46-65 Summerhill, Mountjoy, Dublin 1, D01 T6C2","/","35319211698"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Dame Street Medical Centre","16 Dame St, Dublin 2, D02 TD50","http://damestreetmedical.ie/","35316790754"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","The Pembroke Clinic Dublin 2","2 Pembroke Street Lower, Dublin 2","http://www.pembrokeclinic.com/","35316616610"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Weekend Doctor, Nassau Clinic","32 Nassau Street Suite 17 on 1st Floor, Dublin","https://www.nassau.ie/","35315242848"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","East Wall Health Clinic","51-53 Church Rd, East Wall, Dublin 3, D03 A584","http://hse.ie/","35317957090"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Fairview Medical Centre","37 - 39 Fairview Strand, Ballybough, Dublin 3","http://www.dublinfamilydoctor.com/","35318339856"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Marino Medical Centre","144 Philipsburgh Ave, Ballybough, Dublin 3, D03 R6X6","http://www.marinomedicalcentre.ie/","35318374730"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Henry Medical Centre","63 Clontarf Rd, Clontarf, Dublin 3, D03 R8P9","http://henrymedicalcentre.ie/","35315514058"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Irishtown & Ringsend Primary Care Centre","Irishtown Rd, Dublin","https://www.sandymountmedical.ie/","35312320600"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Morehampton Clinic","Gardeners Cottage, The Royal Hospital, Bloomfield Ave, Dublin 4, D04 P8N6","http://morehamptonclinic.ie/","35312693921"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Sandymount Road Medical Centre","29 Sandymount Rd, Dublin 4, D04 F9K8","http://www.sandymountmedical.ie/","35316680077"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Merrion Gates Medical Centre","240 Merrion Rd, Dublin 4, D04 CF74","http://www.merriongatesmc.com/","35312691876"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Ballsbridge Medical Centre","66 Merrion Rd, Ballsbridge, Dublin 4, D04 N1W5","http://ballsbridgemedical.ie/","35316600236"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Hazelwood Medical Practice","31 Hazelwood Ct, Kilmore, Artane, Co. Dublin, D05 DX88","https://www.hazelwoodmedical.ie/","35318479880"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Dr. Tarek Zourob","44 Bóthar Mhullach Íde, Clontarf West, Dublin 5","/","35318510040"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","The Avenue Family Practice","59 Collins Ave E, Clontarf West, Dublin 5, D05 VE03","http://www.dublingp.ie/","35318336568"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Hampson Surgery","40 Whitethorn Rise, Beaumont, Artane, Co. Dublin, D05 AK31","http://www.drhampsonsurgery.com/","35318312260"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Moe Family Practice","Holly Lodge, 13 Winton Rd, Ranelagh, Dublin 6, D06 X2R4","http://www.moefamilypractice.ie/","35312691155"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Ranelagh Medical, Centric Health","22-26 Sandford Rd, Ranelagh, Dublin 6, D06 A365","https://www.centricgp.ie/ranelagh-medical/","35314986900"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Rathmines Clinic","24 Upper Rathmines Rd Upper, Rathmines Road, Rathmines, Dublin, D06 W2R4","http://rathminesclinic.com/","35314966025"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Rathgar Village Medical Centre","99 Rathgar Rd, Rathfarnham, Dublin 6, D06 P6X6","http://www.rathgarvillagemed.ie/","353 830998646"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Doctors Clinic Rathmines Dublin","104 Rathmines Rd Lower, Rathmines, Dublin, D06 F9P0","http://www.drclinicdublin.com/","35314979938"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Family Clinic","Navan Road Navan Rd, Ashtown, Dublin 7, D07 RCK4","https://www.familyclinic.ie/","35318115873"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","The Milligan Family Practice","Maple Shopping Centre, Unit 3a, The, Navan Rd, Dublin 7, D07 H3NH","http://www.milligan.ie/","35319060888"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Sirona Medical","185 Cabra Rd, Cabra East, Dublin 7, D07 FR52","http://www.sironamedical.ie/","35318680242"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Inchicore Medical Centre","15 Grattan Cres, Inchicore, Dublin 8, D08 EWF2","http://www.inchicoremedical.ie/","35314734030"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","South Circular Road GP Clinic","106a S Circular Rd, Wood Quay, Dublin, D08 K2V6","http://www.scrsurgery.ie/","35314548026"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Collins Ave GP","138 Collins Ave, Beaumont, Dublin 9, D09 W7W3","http://www.collinsavegp.ie/","35318328692"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","SantryGP.ie Clinic","Unit 1 Northwood houseNorthwood business park, Santry, Dublin","http://www.santrygp.ie/","35318420007"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","College Gate Clinic","123 Ballymun Rd, Ballygall, Dublin, D09 W523","http://www.collegegateclinic.ie/","35318378194"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Ballymun Family Practice (Ground Floor)","Civic Centre, Main St, Ballymun, Dublin 9, D09 C8P5","https://www.ballymunfp.com/","35318467033"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Whitehall Clinic","394a Collins Ave, Whitehall, Dublin 9, D09 X7H5","http://www.whitehallclinic.ie/","35315382871"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Griffith Avenue Practice","411 Griffith Ave, Whitehall, Dublin 9, D09 YY19","http://www.griffithavenuepractice.com/","35318373611"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Beaumont Park Clinic","77 The Park, Beaumont Woods, Beaumont, Dublin 9, D09 T974","http://beaumontpark.com/","35318378158"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Claddagh Surgery","Ballyfermot Primary Care Centre, Ballyfermot, Dublin 10, D10 C973","https://claddaghsurgery.ie/","35317956010"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Ballyfermot Family Practice","Ballyfermot Family Practice, Ballyfermot Rd, Dublin 10","/","35316266238"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","The Surgery: Dr. Naseema Moorad","10 Ballyfermot Rd, Drumfinn, Dublin","http://www.docvadis.ie/naseema-moorad/index.html","353 16262629"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Finglas Medical, Centric Health","45-47 Main St, Finglas East, Dublin 11, D11 TCC9","https://www.centricgp.ie/finglas-medical/","35318341124"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Dr. James Kirrane","23 North Rd, Finglas North, Dublin 11","https://www.irelandstats.com/gp/dr-james-kirrane-23-north-road/","35318343932"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","The Cremore Clinic","66 Ballygall Rd E, Ballygall, Dublin 11, D11 RX50","http://www.cremoreclinic.ie/info/our-location","35318344611"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Willows Clinic","38 Oakwood Ave, Glasnevin, Dublin 11, D11 HY02","http://www.willowsclinic.com/","35314851100"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Iveagh Medical Clinic","235 Crumlin Rd, Crumlin, Dublin 12, D12 WR53","http://iveaghmedicalclinic.ie/","35314567878"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Park West Medical","The Plaza, Park W Ave, Park West Business Park, Dublin","http://parkwestmedical.ie/","35316204399"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Armagh Road (Crumlin) Primary Care Centre","12 Armagh Rd, Crumlin, Dublin, D12 W62N","/","35319213801"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Dr Catherine King","172 Sundrive Rd, Kimmage, Dublin, D12 V2CY","/","35314534671"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Clongriffin Medical Centre","17A Main St, Clongriffin, Dublin 13, D13 CT89","http://www.clongriffinmedical.ie/","35318285492"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Grange Clinic","Grange Rd, Donaghmede, Dublin 13","http://www.grangeclinic.ie/","35318480033"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Northern Cross Medical Centre","Burnell Court, Unit 4, Malahide Rd, Northern Cross, Dublin 17","http://www.northerncrossmedical.com/","35314445977"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Dodder Park Medical","4 Dodder Park Dr, Rathfarnham, Dublin 14, D14 VY57","http://www.dodderparkmedical.ie/","35314055300"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Orwell Medical Clinic","170 Orwell Rd, Newtown Little, Dublin 6, D14 EK57","http://www.orwellclinic.ie/","35314923544"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Dr Ciaran Bent","17 Main St, Dundrum, Dublin 14","http://www.drciaranbent.ie/","35312980226"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Churchtown Family Practice","111D Beaumont Ave, Churchtown Upper, Dublin, D14 X5R5","https://www.churchtownfamilypractice.ie/","35312051010"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Dr. Paul McCormick","218 Barton Rd E, Dundrum, Dublin 14, D14 AE92","218 Barton Rd E, Dundrum, Dublin 14, D14 AE92","35312984214"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Dr. Paul McCormick","218 Barton Rd E, Dundrum, Dublin 14, D14 AE92","218 Barton Rd E, Dundrum, Dublin 14, D14 AE92","35312984214"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","The Gables Medical Centre","Unit 13, Nutgrove Retail Park, Rathfarnham, Dublin 14","http://www.thegablesmedicalcentre.ie/","35312988488"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Oakwood Medical Clinic, Castleknock","Castlecourt Shopping Centre, 3, Dublin 15","http://www.oakwoodmedical.ie/","35318219530"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Oakwood Medical Clinic, Clonsilla","Kirkfield Cottages, Clonsilla Rd, Clonsilla, Dublin 15","http://www.oakwoodmedical.ie/","35318219530"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Castleknock Clinic","23 Castleknock Ave, Blanchardstown, Dublin 15, D15 NHR2","/","35318211347"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Tyrrelstown Medical Centre Centric GP (Primacare)","Unit 1 Block B, Tyrrelstown Way, Cruiserath, Dublin 15, D15 K667","http://www.primacare.ie/","35318856380"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Woodstown Medical","Unit 9, Woodstown Shopping Centre, Dublin 16","http://www.woodstownmedical.ie/","35314630962"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Grange Road Family Practice","3b Grange Rd, Rathfarnham, Dublin, D16 XD82","http://www.grangeroadfamilypractice.com/","35314957758"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Blackglen Medical","7, Blackglen Village Centre, Blackglen Rd, Ticknock Park, Dublin 18","http://www.blackglenmedical.ie/","35312998976"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Deansgrange Medical Centre","2 Clonkeen Rd, Kill of the Grange, Blackrock, Co. Dublin, A94 A4E4","https://www.deansgrangemedicalcentre.ie/","35312892116"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Stepaside Medical","3 The Village, Kilgobbin, Stepaside, Co. Dublin","http://www.stepasidemedical.ie/","35312948988"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Shankill Family Practice","1 Athgoe Dr, Shankill, Dublin, D18 C596","http://www.shankillfamilypractice.ie/","35312720475"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Palmerstown Medical Centre","Lucan Rd Old, Palmerstown Lower, Palmerstown, Co. Dublin","http://www.palmerstownmedicalcentre.com/contact1.aspx","35316038022"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Palmerstown GP","31 Manor Rd, Redcowfarm, Dublin 20, D20 AW73","http://www.manorroadsurgery.com/","35316265672"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Glenfield Family Practice","20 Glenfield Ave, Rowlagh, Dublin, D22 E309","http://glenfieldfamilypractice.com/","35316260562"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Chapelizod Medical Centre","Belgrove Park, Chapelizod, Dublin","/","35316264678"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Dr K.B Olinger","Village Centre, Unit 6, The, Watery Ln, Dublin 22","https://www.centricgp.ie/village-medical-centre/","35314592596"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Tallaght Medical Practice","1 Alderwood Park, Springfield, Dublin, D24 XR58","http://www.tallaghtmedicalpractice.com/","35314590962"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Ballycullen Medical Centre","Oldcourt Shopping Centre, 24 Parklands Rd, Dublin 24","http://www.ballycullenmedicalcentre.com/","35315441100"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Old Bawn Family Practice | Doctors in Tallaght","59a Old Bawn Way, Tallaght, Dublin, D24 RY77","https://oldbawndoctors.ie/","35314513386"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Killinarden Health Centre","Killinarden Heights, Tallaght, Dublin 24, D24 YX96","/","35314626260"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"GP/Doctor","Glenview Clinic","12 Glenview Park, Tallaght, Dublin 24, D24 WK33","/","35314515018"});



        //Library
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Central Library","Henry St, North City, Dublin 1","http://www.dublincity.ie/central-library","35312228300"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Charleville Mall Library","Charleville Mall, N Strand Rd, Dublin 1, D01 AX99","http://www.dublincity.ie/charleville-mall-library","35312228411"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Pearse Street Library","144 Pearse St, Dublin 2, D02 DE68","http://www.dublincity.ie/pearse-street-library","35316744888"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","National Library of Ireland","7-8 Kildare St, Dublin 2, D02 P638","https://www.nli.ie/","35316030200"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","The Rooney Library","American College, 1 Merrion Square N, Dublin, D02 NH98","http://iamu.edu/","35316768939"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Marino Library","Marino Mart, Ballybough, Dublin","http://www.dublincity.ie/marino-library","35312228399"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Ringsend Library","Fitzwilliam St, Dublin, D04 Y970","http://www.dublincity.ie/ringsend-library","35312228499"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Raheny Library","Howth Rd, Donaghmede, Dublin 5, D05 VY99","http://www.dublincity.ie/raheny-library","35312228322"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Rathmines Library","Lower Rathmines Road Rathmines Road Lower, Dublin 6, D06 K2K6","http://www.dublincity.ie/rathmines-library","35312228466"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Cabra Library","Navan Road, Dublin, D07 AYW1","http://www.dublincity.ie/cabra-library","35318691414"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Drumcondra Library","Millmount Ave, Drumcondra, Dublin 9, D09 PT78","http://www.dublincity.ie/drumcondra-library","35312228344"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Ballymun Library","9 Ballymun Rd, Ballymun, Dublin 9","http://www.dublincity.ie/ballymun-library","35312228355"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Ballyfermot Library","Ballyfermot Rd, Kylemore, Dublin","http://dublincity.ie/ballyfermot-library","35312228422"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Finglas Library","Finglas Village Centre, Jamestown Rd, Dublin 11, D11 F76T","http://www.dublincity.ie/finglas-library","35312228330"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Walkinstown Library","Percy French Rd, Crumlin, Dublin, D12 FK18","http://www.dublincity.ie/walkinstown-library","35312228890"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Donaghmede Library","Donaghmede Shopping Centre, Grange Road, Grange, Dublin 13, D13 XW28","http://www.dublincity.ie/donaghmede-library","35312228311"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Dundrum Library","Churchtown Rd Upper, Dundrum, Dublin, D14 VP97","http://libraries.dlrcoco.ie/using-your-library/find-your-library/dundrum","35312985000"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Ballyroan Library","54 Orchardstown Ave, Rathfarnham, Dublin 14, D14 XY75","http://www.southdublinlibraries.ie/find-library/ballyroan","35314941900"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Blanchardstown Library","The Civic Centre , Blanchardstown Centre, Dublin 15","http://www.fingal.ie/","35318905560"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Coolock Library","Barryscourt Rd, Kilmore, Dublin, D17 C950","http://www.dublincity.ie/coolock-library","35312228490"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Blackrock Library","Main St, Blackrock, Co. Dublin, A94 YF76","http://libraries.dlrcoco.ie/using-your-library/find-your-library/blackrock","35312888117"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Deansgrange Library","Clonkeen Dr, Deansgrange, Dublin, D18 NY58","http://libraries.dlrcoco.ie/using-your-library/find-your-library/deansgrange","35312850860"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Palmerstown Library Digital Hub","Unit 11, Palmerstown Shopping Centre, Woodfarm, Dublin 20","http://www.southdublinlibraries.ie/","35314678909"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","North Clondalkin Library","1 Liscarne Cl, Rowlagh, Dublin, D22 E2Y2","https://www.sdcc.ie/en/services/sport-and-recreation/libraries/","35314149269"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","County Library","Library Square, Tallaght, Dublin, D24 A3EX","http://www.southdublinlibraries.ie/find-library/county-library-tallaght","35314620073"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Library","Terenure Library","Templeogue Rd, Terenure, Dublin, D6W YC59","http://www.dublincity.ie/terenure-library","35312228700"});



        //Social Worker
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Store Street Garda Station","4-6 Store St, Mountjoy, Dublin 1, D01 W773","https://www.garda.ie/en/Contact-Us/Station-Directory/Store-Street.html","35316668000"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Fitzgibbon Street Garda Station","1 Fitzgibbon St, Mountjoy, Dublin 1, D01 R2K5","http://garda.ie/","35316668400"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Pearse Street Garda Station","1-6 Pearse St, Dublin 2, D02 W289","https://www.garda.ie/en/Contact-Us/Station-Directory/Pearse-Street.html","35316669000"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Clontarf Garda Station","4 Clontarf Rd, Clontarf, Dublin, D03 V4K8","http://www.garda.ie/","35316664800"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Donnybrook Garda Station","43 Donnybrook Rd, Ranelagh, Dublin 4, D04 XC78","https://www.garda.ie/en/Contact-Us/Station-Directory/Donnybrook.html","35316669200"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Raheny District Garda Station","All Saints Rd, Clontarf East, Dublin 5, D05 C960","https://www.garda.ie/en/Contact-Us/Station-Directory/Raheny.html","35316664300"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Rathmines Garda Station","196 Rathgar Rd, Rathmines, Dublin 6, D06 YW20","http://garda.ie/","35316666700"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Mountjoy Garda Station","399 N Circular Rd, Dublin 7, D07 CH02","http://www.garda.ie/stations/default.aspx","35316668600"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Cabra Garda Station","Nephin Rd, Cabra West, Dublin, D07 XN61","http://garda.ie/","35316667400"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Kevin Street District Garda Station","41 Kevin Street Upper, Dublin","https://www.garda.ie/en/Contact-Us/Station-Directory/Kevin-Street.html","35316669400"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Kilmainham Garda Station","High Road, Kilmainham Ln, Kilmainham, Dublin 8","https://www.garda.ie/en/Contact-Us/Station-Directory/Kilmainham.html","35316669700"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Santry Garda Station","Shanowen Rd, Whitehall, Dublin 9","http://www.garda.ie/","35316664000"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Ballyfermot Garda Station","Rossmore Ave, Drumfinn, Dublin","http://www.garda.ie/stations/default.aspx","35316667200"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Ballymun Garda Station","Ballymun Rd, Santry, Dublin","http://garda.ie/","35316664400"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Finglas Garda Station","Finglas North, Dublin","http://www.garda.ie/","35316667500"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Crumlin Garda Station","23 St Agnes Rd, Crumlin, Dublin, D12 C588","http://www.garda.ie/Controller.aspx?Page=1023&Lang=1","35316666200"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Coolock Garda Station","5 Oscar Traynor Rd, Kilmore, Coolock, Co. Dublin","http://www.garda.ie/","35316664200"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Dundrum Garda Station","Kilmacud Rd Upper, Dundrum, Dublin","http://www.garda.ie/","35316665600"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Blanchardstown Garda Station","Blanchardstown, Co. Dublin","https://www.garda.ie/en/Contact-Us/Station-Directory/Blanchardstown.html","35316667000"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Rathfarnham Garda Station","Butterfield Ave, Rathfarnham, Dublin","http://www.garda.ie/Stations/Default.aspx","35316666500"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Dun Laoghaire District Garda Station","34/35 Corrig Rd, Glasthule, Dún Laoghaire, Co. Dublin, A96 N299","http://www.garda.ie/Controller.aspx?Page=1027&Lang=1","35316665000"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Lucan Garda Station","Main St, Lucan, Co. Dublin","http://www.garda.ie/stations/Default.aspx","35316667300"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Garda Station","Clondalkin, Co. Dublin","http://garda.ie/","35316667600"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Ronanstown Garda Station","St Ronans Avenue, Clondalkin, Dublin","http://www.garda.ie/","35316667700"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Social Worker","Tallaght Garda Station","Tallaght, Dublin","http://www.garda.ie/","35316666000"});

        //Hair Cut
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Ultimate Hair & Beauty ","Unit 8, GPO Arcade, Henry St, North City, Dublin 1, D01 F6Y9","info@uhb.ie","353 1 873 2825"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Lunatic Fringe at Robert Chambers","25 Liffey St. Upper, North City, Dublin 1, D01 T2R7","lunaticfringe.ie"," (01) 872 3663"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","House Of Colour","64 Middle Abbey St, North City, Dublin 1, D01 X4C6","https://houseofcolour.ie/","(01) 878 3633"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","New York Hairdressing","20 Eden Quay, North City, Dublin 1, D01 E6N6","nyeden.ie"," (01) 872 7969"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Youmei hair & beauty","118 Capel street Dublin 1 Dublin 1, Dublin, D01 VW94","/","/"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Mont Ciara Hair and Beauty Salon"," 76 Parnell St, Rotunda, Dublin 1, D01 W710","https://voguehairdressing.com/","(01) 558 0558"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Vogue hairdressing","140 Parnell St, Rotunda, Dublin 1, D01 RF34","https://voguehairdressing.com/"," 083 360 5871"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Peter Mark Hairdressers Mary Street","23 Mary St, North City, Dublin 1, D01 AW27","https://petermark.ie/"," (01) 872 7771"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Carmeo Hair Salon","44 Dorset Street Lower, Dublin, D01 F3C6","/"," (01) 855 8843"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Saks Hair Salon","15 Sackville Pl, North City, Dublin 1, D01 X5K7","/"," (01) 878 6344"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","The nature cut","First floor 33/34 Wicklow street,Dublin2","/","01 679 7130"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Dylan Bradshaw Hair Salon"," 56 William St S, Dublin 2, D02 Y897, Ireland","/","353 1 671 9353  "});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Lunatic Fringe","69 Grafton Street, Dublin 2, D02 HC04, Ireland","grafton@lunaticfringe.ie","353 1 679 3766"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","THE BEST BARBER","Crampton Buildings, 6 Bedford Row, Temple Bar, Dublin, D02 WE88","/","353 16798451"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","5th Avenue Boutique Dublin"," 24A Wicklow St, Dublin, D02 YV18","5thavenue.ie"," (01) 679 8783"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Robert Chambers Hair Salon","69 Grafton Street, Dublin 2, D02 HC04","robertchambersacademy.ie","(01) 677 1323"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Kazumi Hair Salon","36 Molesworth St, Dublin 2, D02 HY45","https://kazumihair.ie/"," (01) 678 5004"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","TONI&GUY Dawson Street","51A Dawson St, Dublin 2, D02 YK66","http://toniandguy.ie/","(01) 671 4401"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Reds Hair Salon","1st Floor, 21 Dawson St, Dublin, D02 TK33","https://reds.ie/"," (01) 678 8211"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","City barber East Wall","57-63, Shelmalier Rd, North Dock, Dublin 3, D03 K380","/","353 894267445"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","The Royal Barber","1 Fairview Ave Lower, Ballybough, Dublin 3, D03 CP86","http://theroyalbarbers.ie/","353 872227878"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Sculpture Barber Shop","Malahide Rd, Grace Park, Dublin 3, D03 H265","/","353 877568081"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","The Barbershop @ 56","56 Clontarf Rd, Clontarf, Dublin 3, D03 YN93","https://thebarbershopat56.resurva.com/book","353 876119883"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","KnR Barbers","Sweetman House, 41B, Myrtle Dr, The Coast, Dublin","/","/"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Trim Hair Salon","Trim Hair Salon,45 Shellbourne Road,Ballsbridge, Dublin 4,Dublin","Daire@Trim4hair.Ie"," (01) 668 4108"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Central hair","89 Sandymount Rd, Dublin 4","/","(01) 668 3309"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","The Room D4","6 Seafort Ave, Dublin 4, D04 YA24","http://www.theroomd4.ie/"," (01) 215 3786"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","93 Hairdressing","93A Morehampton Rd, Ranelagh, Dublin 4","/"," (01) 667 7750"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Helga Schworer Hair and Beauty Salon"," 33 Baggot Street Upper, Ballsbridge, Dublin, D04 N1W9","https://helga.ie/"," (01) 660 3311"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","McAuley Scanlon Hair"," 9 Baggot Street Upper, Ballsbridge, Dublin, 4","mcauleyscanlonhair.com","(01) 668 3669"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Di Milo Hair Design Ltd","46 Donnybrook Rd, Dublin 4, D04 RK65","https://www.dimilo.ie/","(01) 218 0872"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Hair By Ashleigh","40-42 Tonlegee Rd, Donaghmede, Dublin 5, D05 H3A3","mylocalsalon.com"," (01) 430 9220"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Gorgeous Hair Salon","5 Maryfield Ave, Beaumont, Artane, Co. Dublin, D05 V2R2","/","(01) 867 4643"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Angelz Hair Salon","Raheny Shopping Centre, Howth Rd, Clontarf East, Dublin","http://angelzhairsalon.com/","(01) 831 6303"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Hair Rocks salon"," Edenmore Shopping Centre, Unit 8 Raheny Dublin 5 Dublin 5, Co. Dublin","/","(01) 558 1758"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","The Colour Room","6 Ardcollum Ave, Beaumont, Dublin 5, D05 A5R6","/","/"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Wink The Hair Studio"," Brookwood Rise, Harmonstown, Dublin","https://www.facebook.com/winkhairstudio/"," (01) 851 0405"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","GMALE Barbers","73 Ranelagh, Main St, Ranelagh, Dublin, D06 PW96","http://www.gmale.ie/","353 14969954"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","The Village Barber","16 Ranelagh Rd, Dublin Southside, Dublin","/","353 14974517"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Jim Hatton","40 Dunville Ave, Ranelagh, Dublin 6, D06 TP60","http://www.jimhatton.ie/"," (01) 497 6840"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Poise Hair Salon","Milltown Rd, Rathmines, Dublin 6"," phorest.com","(01) 207 1880"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Hair Cafe Salon","8a Thundercut Alley, Smithfield, Dublin 7","info@haircafesalon","353 1 878 8198    "});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Harvard Hair"," 5 Manor St, Stoneybatter, Dublin 7, D07 NC56","http://harvardhair.ie/"," (01) 868 9416"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Clanbrassil barber","4 Clanbrassil Street Upper, Dublin 8, D08 A362","/","353 852131898"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","J&R Barbershop","78-80 Reuben St, South-West Inner City, Dublin, D08 X267","/","353 852407286"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","D|M Hairdressing"," 79 Tyrconnell Rd, Inchicore, Dublin, D08 CXY5","ovatu.com","(01) 454 0748"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","V Studio"," 22 James St, The Liberties, Dublin 8, D08 XW8D","http://www.vstudio.ie/"," 087 174 0405"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","The Salon"," 73/74 Patrick St, Dublin 8, D08 XT28","/","(01) 416 4898"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Clanbrassil barber","4 Clanbrassil Street Upper, Dublin 8, D08 A362","/"," 085 213 1898"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","D9 Barber"," 112 Collins Avenue, D09 Y2X7 Collins Ave, Beaumont, Dublin 9, D09 Y2X7","/"," (01) 831 4741"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","HIM Barbershop","1A St Mobhi Rd, Ballygall, Dublin 9, D09 H7V0","http://himbarbershop.ie/","083 405 2623"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Trends Hair & Beauty Salon","Lorcan Ave, Whitehall, Dublin 9, D09 P623","/"," (01) 842 7647"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Pelo Hairdressing & Scalp Specialists","95 Swords Rd, Whitehall, Dublin, D09 V840"," mylocalsalon.com"," (01) 797 9358"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Salon D10  ","Unit 5, Phoenix Shopping Centre, Dublin 10, Ireland","/","353 85 237 2924 "});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Ritual Barbers","209 Decies Rd, Decies, Ballyfermot, Co. Dublin, D10 FH22","https://ritual-barbers.business.site/","353 851468738"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","King Barbers"," Unit 3, Phoenix Shopping Centre, Cherry Orchard, Dublin 10","/"," (01) 620 3651"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","The Barber Shop"," 341 Ballyfermot Rd, Cherry Orchard, Dublin 10, D10 DT80","/"," 086 843 6172"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Headmasters"," 353a Ballyfermot Rd, Cherry Orchard, Dublin","/"," (01) 626 0567"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Justins Barber Shop","92-188 Le Fanu Rd, Drumfinn, Dublin 10, D10 FW14","/","/"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Turkish barbers","Upstairs, 275 Glasnevin Ave, Ballygall, Dublin 11, D11 Y18W","/","/"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Boxx Barber Shop","Seamus Ennis Rd, Finglas Village, Dublin 11, D11 VHF6","boxx.ie"," (01) 864 3959"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Dream Hair Salon","5 Jamestown Rd, Ballygall, Dublin 11, D11 K330","/"," (01) 864 4837"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Glow Hair & Beauty Salon","250 Sarsfield Rd, Kilmainham, Dublin","/","353 1 620 6800      "});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Franks Barber Shop","1 Lisle Rd, Crumlin Village, Crumlin, Dublin","/","353 14551851"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Errigal Unisex Hair and Beauty Salon","12a Errigal Rd, Drimnagh, Dublin 12, D12 YTY7","./","(01) 455 8026"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Revive Hair & Beauty Clinic","167 Drimnagh Rd, Drimnagh, Dublin, D12 KF96","https://revivehbc.ie/"," (01) 465 2749"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","DNA Hair Salon","Limekiln Ln, Perrystown, Dublin 12, D12 HH99","/"," 085 832 1512"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Salon Nova"," 259 Crumlin Rd, Crumlin, Dublin, D12 DH94","https://www.facebook.com/salonnovadublin/"," (01) 455 9756"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Ginners Barber Shop","Sutton Cross Shopping Centre, Unit 6, Dublin 13, D13 V8P4","/","/"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Mane Envy","Badminton centre Baldoyle, Grange Ave, Baldoyle Industrial Estate, Dublin 13","http://maneenvysalon.com/","353 18394575"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Colourpop hair studio","1 Red Arches Park, The Coast, Dublin 13, D13 A362","https://www.colourpophairsalon.com/hair.html","353 15392491"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Angelz Hair Salon","Raheny Shopping Centre, Howth Rd, Clontarf East, Dublin","http://angelzhairsalon.com/","353 18316303"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Billies Hair Studio","Unit 21 Donaghmede Shopping Centre, Donaghmede, Dublin","http://www.billieshairstudio.ie/","353 18474849"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Radiance Hair & Beauty","42 Main St, Belmayne, Dublin, D13 AH10","http://www.dublinhairdressers.ie/","353 15371617"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","The Gym Barbers","1A Bird Ave, Farranboley, Dublin 14, D14 E124","/","353 12613990"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Gents Barber","1 Landscape Rd, Dublin Southside, Dublin 14, D14 E5C6","/","353 872999567"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","The Gentlemans Quarters","11, Meakstown Commercial Centre, Jamestown Little, Dublin","/","353 892066790"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","The Best Barber - Dundrum","15 Main St, Dundrum, Dublin 14","https://m.facebook.com/bestbarberDublin/","353 12951133"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Halo Hair Beauty","Arbourfield Terrace, 7 Dundrum Rd, Farranboley, Dublin 14","/","353 15378870"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Boshka Hair & Beauty Salon","Unit 42, Coolmine Industrial Estate, Blanchardstown, Dublin 15","http://www.boshka.ie/","353 18249548"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Paris Lover Hair and Beauty","22 Willow Rd, Dún Droma, Dublin 16, D16 A471","https://parislover.ie/","353 15552928"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Hermans Hairstylists","Level 1M Dundrum Town Centre, Dublin 16","http://www.hermans.ie/","353 12965514"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Imagez Hair Salon","Unit E, Oscar Traynor Rd, Kilmore, Dublin","/","353 18475716"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Romina Daniel Hair & Beauty  ","UNIT 3 SANDYFORD HALL SHOPPING CENTRE, KILGOBBIN ROAD, SANDYFORD","sandyford@rominadaniel.ie","353 1 564 9926"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","The Barber Shop","71 Main St, Blackrock, Co. Dublin, A94 RY19","/","353 868164655"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Ballance Hair","Leopardstown Shopping Centre, Ballyogan Rd, Ballyogan, Dublin 18, D18 P9X7","https://ballancehairandbeauty.com/","353 12948888"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Santana Hair Studio Foxrock","3A Brighton Rd, Foxrock Village, Dublin 18","/","353 12891111"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","New Image","81 Lower Kilmacud Rd, Stillorgan, Dublin, A94 E2A2","http://newimagestillorgan.com/","353 12780636"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","FOX SALON","94 Foxrock Ave, Deansgrange, Dublin 18, D18 P8N6","http://www.facebook.com/foxsalonhair","353 12898450"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Hairlough Barbers","Ninth Lock Road, Clondalkin, Dublin 22 . D22 C820","info@hairloughbarbers.ie ","353 1 457 6127 "});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Romina Daniel Hair","UNITS 7/16, KENNELSFORT RD UPPER, PALMERSTOWN, DUBLIN","palmerstown@rominadaniel.ie","353 1 623 1444"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Hairlough Barbers","Unit 5 Chaplains Place, Rowlagh Village Centre, Clondakin, Dublin 22. D22 DD27","info@hairloughbarbers.ie","353 1 5498703"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Hot House Hair and Beauty","Unit 7, Village Centre, Watery Ln, Clondalkin, Dublin 22","/","353 14577653"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","The Cutting Room","1a Castle Crescent shopping centre, Monastery Road, Dublin 22, D22 A2K5","http://www.thecuttingroom.ie/","353 14037366"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Shamooze","Bawnogue Shopping Centre, Bawnogue Rd, Clonburris Great, Dublin 22","/","353 14576115"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Hair By Leo","49d, 22 Tower Road, Clondalkin, Co. Dublin","https://www.treatwell.ie/place/hair-by-leo/","353 894493388"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Daves academy barbers","Old Blessington Rd, Tallaght, Dublin","/","/"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Star Hair & Beauty Studio","Supervalu shopping centre, Maplewood Rd, Springfield, Dublin 24, D24 A073","http://www.star-studio.ie/","353 14628840"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Ross Adams Hair & Beauty Salon","Unit 10, The Square Tuansgate Tallaght, DUBLIN 24, D24 DP86","http://rossadamshairandbeauty.com/","353 14621827"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Hair Cut","Genie Mack Hair Beauty Barbers","Oldcourt Shopping Centre, Parklands Rd, Dublin 24","http://www.genie-mack.ie/","353 15377156"});


        //Dental
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Novadent - Dental Clinic","71 Middle Abbey St, North City, Dublin 1, D01 E7K5","http://www.novadent.ie/","353870991111"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Frederick Dental Clinic","33 Frederick St N, Rotunda, Dublin 1, D01 NH98","http://www.thefrederickdentalclinic.com/","35318786999"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Shining Smile Dental Clinic","31-35 Gardiner Street Middle, Mountjoy, Dublin 1, D01 Y2E5","https://www.shiningsmile.ie/","35315615435"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Molesworth Dental Clinic","2 Molesworth Pl, Dublin 2, D02 K023","http://www.molesworthclinic.ie/","35316615544"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","D2 Dental","42 Baggot Street Lower, Dublin 2, D02 E780","http://d2dental.ie/","35316761536"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Dental Options Dublin","4 Chatham St, Dublin 2, D02 R223","http://www.chathamstdentalcare.ie/","35316729595"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Baggot Dental","140 Baggot Street Lower, Dublin 2, D02 HT73","http://baggotdental.com/","35316787322"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Merrion Square Dental","78 Merrion Square S, Dublin, D02 R251","http://merrionsqdental.ie/","35316618048"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Dental Artistry","63 N Strand Rd, Ballybough, Dublin 3, D03 EA38","http://dentalartistry.ie/","35315589332"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Fairview Dental Clinic","21 Fairview, Ballybough, Dublin","http://www.fairviewdentalclinic.ie/","35318338985"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Annesley Bridge Dental Surgery","18 Annesley Bridge Rd, Ballybough, Dublin 3, D03 X7W3","http://www.annesleydental.ie/","35318556636"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Clontarf Road Dental","58 Clontarf Rd, Clontarf, Dublin, D03 X9F5","http://www.clontarfroaddental.ie/","35318335641"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Howth Road Dental","183 Howth Rd, Clontarf, Dublin 3, D03 Y1K7","http://www.howthroaddental.ie/","35318533006"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Pembroke Dental Ballsbridge","166 Pembroke Rd, Dublin 4, D04 W996","https://pembrokedentist.ie/","35316683242"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","D4 Dentist","46 Baggot Street Upper, Ballsbridge, Dublin 4","http://www.d4dentist.ie/","35316600144"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Northumberland Dental Care","58 Northumberland Rd, Ballsbridge, Dublin 4, D04 R231","/","35316688441"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Donnybrook Dental Practice","114 Morehampton Rd, Dublin 4, D04 K3H7","http://www.donnybrookdental.ie/","35316676938"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Shelbourne Dental Clinic","Grand Canal Wharf, 7 S Dock Rd, Dublin 4, D04 R860","http://www.shelbourneclinic.ie/","35316655900"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","North City Dental","Donaghmede, Coolock, Co. Dublin","http://www.northcitydental.ie/","35318480468"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Raheny Dental Centre","436 Howth Rd, Clontarf East, Raheny, Co. Dublin, D05 K2Y9","/","35318314004"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Raheny Orthodontics","Raheny Shopping Centre, 4 Skillings House, Howth Rd, Dublin 5, D05 FX05","http://www.rahenyortho.ie/","35318313197"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Kilbarrack Dental Care","49 Kilbarrack Rd, Donaghmede, Dublin, D05 A8N6","https://kilbarrackdentalcare.business.site/","35318320558"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Rathmines Dental","183 Rathmines Rd Lower, Rathmines, Dublin 6, D06 E3E5","http://www.rathminesdental.ie/","35314976543"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Dentist Rathmines","42, Swan Shopping Centre Rathmines, Dublin 6","http://www.dentistrathmines.com/","35314977478"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","D6 Dental","188 Rathgar Rd, Rathmines, Dublin 6, D06 H6P4","http://www.d6dental.ie/","35314966246"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Ranelagh Village Dental","72 Ranelagh Village, Ranelagh, Dublin 6, D06 P8H2","http://www.ranelaghvillagedental.ie/","35314969681"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Rathgar Dental Clinic","156a Rathgar Rd, Rathmines, Rathgar, Co. Dublin, D06 V262","http://www.rathgardentist.ie/about-us","35314969596"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Navan Road Dental Practice","Aras Slainte, Primary Care Centre, Navan Rd, Dublin 7","http://navanroaddentalpractice.ie/","35315132888"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Cabra Dental Centre","82 New Cabra Rd, Cabra - Glasnevin, Cabra, Co. Dublin","http://www.cabradental.com/","35318389966"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","J. B. Dental Laboratories","64 Prussia St, Dublin 7","http://www.jbdentaldublin.com/","35318386033"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Kilmainham Dental","631 S Circular Rd, Kilmainham, Dublin 8, D08 C9TR","http://www.kilmainhamdental.com/","35314531859"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Dublin Dental Specialist","Heuston South Quarter, Unit 8A Dargan Building, Military Rd, Dublin","http://www.specialist.ie/","35317719100"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Diamond Smile Dental","Christchurch, 3 Meath St, The Liberties, Dublin 8, D08 KD2Y","http://www.diamondsmiledental.ie/","35314020200"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Patrick Street Dental","Ardilaun Court, Nicholas House, Patrick St, The Liberties, Dublin 8","http://patrickdental.ie/clinic/","353896028689"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Camden Dental Clinic","The Meath Primary Care Centre, Heytesbury St, Dublin 8","http://www.camdendentalclinic.ie/","35314547464"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Molloy Dental","222 Swords Rd, Whitehall, Dublin 9, D09 V2P8","http://molloydental.ie/","35318621877"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Drumcondra Village Dental","159 Drumcondra Rd Lower, Ballybough, Dublin 9, D09 ND86","http://www.drumcondravillagedental.ie/","35314411420"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Santry Dental","37 Swords Rd, Santry, Dublin, D09 K3H6","http://www.santrydental.ie/","35319695959"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Ballyfermot Dental Practice","276 Ballyfermot Rd, Drumfinn, Ballyfermot, Co. Dublin, D10 FA31","https://www.ballyfermotdentalpractice.ie/","35316265776"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","J.F.O Connor Dental Surgeon","353 Ballyfermot Rd, Cherry Orchard, Dublin 10, D10 WN70","/","35316264922"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","D11 Dental","173 Ballymun Rd, Ballymun, Dublin 11, D11 FX08","http://www.d11dental.ie/","35318422845"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Bryan Duggan and Associates","10 Main St, Ballygall, Dublin 11, D11 WRW3","http://duggandentist.com/","35318341140"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Finglas Dental Care","1-3, Drogheda Mall, Finglas, Dublin 11","https://www.facebook.com/finglasdentalcare","35318344369"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Crumlin Road Dental","325 Crumlin Rd, Crumlin, Dublin","http://www.crumlinroaddental.ie/","35314556432"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Clear Dental Care","6 St Agnes Rd, Crumlin, Dublin 12, D12 X897","http://www.cleardentalcare.ie/","35314557797"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Walkinstown Dental Studio","133 Walkinstown Rd, Walkinstown, Dublin, D12 PX7A","http://www.walkinstowndentalstudio.ie/","35314503228"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Smile Design Dental Clinic","16 Main St, Baldoyle, Co. Dublin, D13 DC98","http://www.smiledesign.ie/","35318396520"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Smart Dental Care","Grange Clinic, Grange Rd, Donaghmede, Dublin, D13 F7H9","http://www.smartdentalcare.ie/","35315136741"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Northern Cross Dental","Burnell Square, Unit 8/9, Malahide Rd, Northern Cross, Dublin, D17 DK71","http://www.ncdental.ie/","35318673100"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Grange Clinic","Grange Rd, Donaghmede, Dublin 13","http://www.grangeclinic.ie/","35318480033"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Clifford Dental Care","18 Pembroke Cottages, Main St, Dundrum, Dublin 14","http://www.clifforddentalcare.ie/","35312980843"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Louis Roche Dental Surgery","18, Pembroke Cottages, Dundrum, Dublin 14","/","35312980843"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Dodder Park Dental","3a Dodder Park Dr, Rathfarnham, Dublin, D14 A5F6","http://www.dodderparkdental.ie/","35314063917"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Glenville Dental, Dundrum","5 Pembroke Cottages, Main St, Dundrum, Dublin, D14 VK85","http://glenvilledental.ie/","35312981133"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Dental Implants Ireland","1b Woodlawn Terrace, Upper Churchtown Road, Dundrum, Dublin, D14 F5W6","http://www.dental-implants-ireland.com/","35315577740"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Ongar Dental Surgery","1 The Avenue, Ongar Village, Clonsilla, Dublin 15, D15 V326","http://www.ongardentalsurgery.com/","35316402733"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Blanchardstown Centre Dental","329 Blanchardstown Centre, Blanchardstown, Dublin, D15 P7K2","http://www.gums.ie/","35318220666"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Beechview- Medical Dental","Beechview, Main St, Blanchardstown, Dublin 15, D15 P6WA","https://beechview.ie/","35315989412"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Castleknock Dental Surgery","Exchange House, Main Street, Castleknock Road, Dublin 15","http://www.castleknockdentist.ie/","35318212499"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Phoenix Dental","The Village Centre, Rathborne, Dublin, D15 HT6D","http://www.phoenixdental.ie/","35318664080"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","The Fresh Breath Clinic","47 Ballinteer Ave, Ballinteer, Dublin 16, D16 E9A0","http://www.thefreshbreathclinic.ie/","35312981801"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Woodstown Dental Centre","Unit 11, Woodstown Shopping Centre, Ballycullen Rd, Ballycullen, Co. Dublin","http://woodstowndental.ie/","35314952523"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","KBM Dental Rathfarnham","Unit 2 Grange Road Office Park, Grange Rd, Rathfarnham, Dublin 16, D16 K160","http://www.kbmdental.ie/","35314957844"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Northern Cross Dental","Burnell Square, Unit 8/9, Malahide Rd, Northern Cross, Dublin, D17 DK71","http://www.ncdental.ie/","35318673100"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Glencairn Dental Centre","Leopardstown Valley, Ballyogan Road Dublin 18","http://www.glencairndental.ie/","35312944055"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","South Dublin Dental","2 Brighton Rd, Foxrock, Dublin, D18 W6T2","http://www.southdublindental.ie/","35312899772"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Cornelscourt Dental Practice","New Cornelscourt, 2 Bray Rd, Cabinteely, Dublin 18","http://www.cdpractice.com/","35312896182"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Chapelizod Dental","69 Lucan Rd, Chapelizod, Dublin 20, D20 EP23","/","35316264454"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Palmerstown Dental Surgery","14 Palmerstown Park, Woodfarm, Dublin, D20 YD43","/","35316230797"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Clondalkin Dental Ltd","4 Tower Road, Clondalkin, Dublin 22, D22 N5F9","https://www.clondalkindental.ie/","35314576371"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Tully House Dental Practice","Tully House, Monastery Road, Bushelloaf, Dublin 22, D22 E7Y2","http://www.tullydental.ie/","35314574733"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Newlands Dental","Unit 2 Aldi Retail Scheme, Newlands Cross, Clondalkin, Co. Dublin, D22 C1P3","https://newlandsdental.com/","35314111946"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Springfield Dental Surgery","23 Maplewood Rd, Springfield, Dublin, D24 H5NT","http://www.springfielddentalsurgery.ie/","35314513104"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Old Bawn Smile Clinic","1 Old Bawn Terrace, Tallaght, Dublin 24, D24 AFX9","http://www.smileclinic.ie/","35314513453"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Mountain Park, Dental Practice","51 Mountain Park, Tallaght, Co. Dublin, D24 RR28","http://tallaghtdentists.com/","35314513686"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","The Square Dental Practice","3rd Level, Medical Centre, The Square Shopping Centre, Tallaght, Dublin 24","https://www.squaredental.ie/about","35314598593"});
        db.execSQL("INSERT INTO Information (category,title, address,email,phone) VALUES(?,?,?,?,?)",new Object[]{"Dental","Aylesbury Dental","42 Heatherview Cl, Aylesbury, Dublin 24, D24 VH59","https://www.facebook.com/aylesbury.dental.3","35314512194"});




    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DATABASE_CREATE);
        db.execSQL(DATABASE_CREATE_2);
        db.execSQL(DATABASE_CREATE_3);
        db.execSQL(DATABASE_CREATE_4);
        add_cate_data(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table if EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }

}
