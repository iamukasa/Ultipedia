package com.amusoft.ultipedialite;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DbHelperKis extends SQLiteOpenHelper {
private static final int DATABASE_VERSION = 1;
// Database Name
private static final String DATABASE_NAME = "Kiswahili questions";
// tasks table name
private static final String TABLE_QUEST_KIS = "quest";
// tasks Table Columns names
private static final String KEY_ID = "id";
private static final String KEY_QUES = "question";
private static final String KEY_ANSWER = "answer"; //correct option
private static final String KEY_OPTA= "opta"; //option a
private static final String KEY_OPTB= "optb"; //option b
private static final String KEY_OPTC= "optc"; //option c
private static final String KEY_OPTD="optd";
private static final String KEY_NOTE="note";
private SQLiteDatabase dbase;
public DbHelperKis(Context context) {
super(context, DATABASE_NAME, null, DATABASE_VERSION);
}
@Override
public void onCreate(SQLiteDatabase db) {
dbase=db;
String sql3 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST_KIS + " ( "
+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
+ KEY_QUES+ " TEXT, "
+ KEY_ANSWER + " TEXT, "
+ KEY_NOTE +" TEXT,"
+KEY_OPTA +" TEXT, "
+KEY_OPTB +" TEXT, "
+KEY_OPTC +" TEXT, "
+KEY_OPTD +" TEXT)";
db.execSQL(sql3);		
addQuestions();
//db.close();
}
private void addQuestions()
{
	Question q1=new Question("Chagua neno lifaalo:_____aliposikia kukibishwa hodi alisimama na kuekelea mlangoni",
			"A:Pindi",
			"B:Kwani",
			"C:Baada",
			"D:Kuwa",
			"A:Pindi","The notes are currently unavailable in kiswahili");
	this.addQuestion(q1);
	Question q2=new Question("Jaza pengo kwa neno mwafaka.Babu____njia hadi nyumbani kwake.",
			"A:alisindikizwa",
			"B:aliongozwa",
			"C:alishikwa",
			"D:aliongoza",
			"A:alisindikizwa",
			"The notes are currently unavailable in kiswahili");
	this.addQuestion(q2);
	Question q3=new Question("Chagua Wingi Wa:'Kitabu changu kizuri kimeraruliwa",
			"A:Vitabu zangu nzuri kimeraruliwa",
			"B:Vitabu vyangu vizuri vimeraruliwa ",
			"C:Vitabu vyetu vizuri vimeraruliwa",
			"D:Vitabu vyetu zuri zimeraruliwa",
			"C:Vitabu vyetu vizuri vimeraruliwa","The notes are currently unavailable in kiswahili");
	this.addQuestion(q3);
	Question q4=new Question("____kwa wale wezi hakungeweza kuwafanya wasamehewe.",
			"A:Kutetea",
			"B:Kujitetea",
			"C:Kuittea",
			"D:Kuzitetea",
			"B:Kujitetea","The notes are currently unavailable in kiswahili");
	this.addQuestion(q4);
	Question q5=new Question("Viazi Vyake ____gari.",
		"A:vilichukuliwa kwa",
		"B:vilichukuliwa na",
		"C:vilibebwa kwa",
		"D:vilibebe kwa",
		"A:vilichukuliwa kwa","The notes are currently unavailable in kiswahili");
	this.addQuestion(q5);
Question q6=new Question("Ni maneno yapi ambayo yote ni vielezi?",
		"A:Rasmi,Kitunguu,Kiziwi,Safi",
		"B:Mzuri,Mweupe,yeyote,pale",
		"C:Upesi,Kitajiri,Sana,Kivivu",
		"D:Muungwana,Mwerevu,Kimaskini,Gunia",
		"C:Upesi,Kitajiri,Sana,Kivivu","The notes are currently unavailable in kiswahili");
this.addQuestion(q6);
Question q7=new Question("Ukubwa wa sentensi 'Kitoto kilivaa kijikanzucheupe' ni",
		"A:Mtoto alivaa kanzu jeupe",
		"B:Mtoto alivaa kanzu nyeupe",
		"C:Toto lilivaa jikanzu nyeupe",
		"D:Toto lilivaa jikanzu jeupe",
		"D:Toto lilivaa jikanzu jeupe","The notes are currently unavailable in kiswahili");
this.addQuestion(q7);
Question q8=new Question("Chagua sentensi iliyo sahihi kisarufi",
		"A:Michuzi yote mingine zilikuwa na chumvi isipokuwa hii",
		"B:Michuzi yote mingine ilikuwa na chumvi isipokuwa huu",
		"C:Michuzi yote mingine ilikuwa na chumvi isipokuwa hizi",
		"D:Michuzi yote mingine mlikuwa na chumvi isipokuwa hizi",
		"B:Michuzi yote mingine ilikuwa na chumvi isipokuwa huu","The notes are currently unavailable in kiswahili");
this.addQuestion(q8);
Question q9=new Question("Maana ya methali'Sikio la kufa haliskii dawa' ni:",
		"A:Asiyesikia hasikii",
		"B:Asiyetii ni vigumu kumkanya",
		"C:Sikio la kufa halitibiwi",
		"D:Asiyesikia haambiwi",
		"B:Asiyetii ni vigumu kumkanya","The notes are currently unavailable in kiswahili");
this.addQuestion(q9);
Question q10=new Question("Maana ya usingizi wa pono ni:",
		"A:usingizi mewpesi",
		"B:usingizi mzito",
		"C:usingizi wa shida",
		"D:usingizi wa mang'amung'amu",
		"B:usingizi mzito","The notes are currently unavailable in kiswahili");
this.addQuestion(q10);
Question q11=new Question("Maana ya 'Kughairi' katika sentensi ni:Hakupata mhisani hata mmoja,lakini hiki hakikumfanya KUGAHIRI.",
		"A:Kubadili nia",
		"B:kufa moyo",
		"C:kuogopa sana",
		"D:kupunguza mwendo",
		"B:kufa moyo","The notes are currently unavailable in kiswahili");
this.addQuestion(q11);
Question q12=new Question("Maana ya 'Ungetumbukia nyongo'",
		"A:ungeangukia nyongo",
		"B:ungetengenezeka",
		"C:ungeharibika",
		"D:ungekuja kuchelewa",
		"C:ungeharibika","The notes are currently unavailable in kiswahili");
this.addQuestion(q12);
Question q13=new Question("\"Ki\" imetumiwa aje katika sentensi:Mweni alipokuja alinipata nikifyeka.",
		"A:Kuonyesha hali ya masharti",
		"B:Kuonyesha hali ya kukanusha",
		"C:Kuonyesha hali ya kuendelea",
		"D:Kuonyesha hali ya udogo",
		"C:Kuonyesha hali ya kuendelea","The notes are currently unavailable in kiswahili");
this.addQuestion(q13);
Question q14=new Question("Ni sentensi ipi sahihi?",
		"A:Ndizi lililoletwa ni wangu",
		"B:Miti zilizopandwa zimeota.",
		"C:Zulia iliyonunuliwa ni zuri",
		"D:Wema unaozungumziwa ni huu",
		"D:Wema unaozungumziwa ni huu","The notes are currently unavailable in kiswahili");
this.addQuestion(q14);
Question q15=new Question("Miongoni mwa sehemu hizi za mwili,ni sehemu ipi iliyo toofauti na zengine?",
		"A:Paja",
		"B:Kiganja",
		"C:Pafu",
		"D:Goti",
		"C:Pafu","The notes are currently unavailable in kiswahili");
this.addQuestion(q15);
Question q16=new Question("PolePole,Vibaya,Alasiri,Njiani,ni ",
		"A:Vielezi",
		"B:Vivumishi",
		"C:Nomino",
		"D:Viwakilishi",
		"A:Vielezi","The notes are currently unavailable in kiswahili");
this.addQuestion(q16);
Question q17=new Question("Methali inayotoa funzo kuwa:Jambo linaloonekana zito kwa mwengine laweza kuwa rahisi kwako ni:",
		"A:Bahati ya mwenzio usilalie mlango wazi",
		"B:Mzigo wa mwenzio ni kanda la usufi",
		"C:Kila mwamba ngoma ngozi huvuutia kwake",
		"D:Ganda la muwa la jana chungu kaona kivuno",
		"B:Mzigo wa mwenzio ni kanda la usufi","The notes are currently unavailable in kiswahili");
this.addQuestion(q17);
Question q18=new Question("Sentensi \"Asingalikkwenda kwake asubuhi asingalimkuta \" ina maana kuwa:",
		"A:Hakuenda kwake asubuhi lakini alimkuta",
		"B:Alienda kwake asubuhi lakini hakumkuta",
		"C:Alienda kwake asubuhi na akamkuta",
		"D:Hakuenda kwake asubuhi wala hakumkuta",
		"C:Alienda kwake asubuhi na akamkuta","The notes are currently unavailable in kiswahili");
this.addQuestion(q18);
Question q19=new Question("Ni maneno yapi yote nui viunganishi?",
		"A:ila,ingawa,lakini,maadamu",
		"B:huyu,hao,ovyo,na",
		"C:ila,lakini,vizuri,wima",
		"D:ingawa,isipokuwa,zuri,safi",
		"A:ila,ingawa,lakini,maadamu","The notes are currently unavailable in kiswahili");
this.addQuestion(q19);
Question q20=new Question("Kivumishi cha sifa kutokana na kitenzi angaa ni:",
		"A:Angaza",
		"B:Angazia",
		"C:Angamia",
		"D:Angazifu",
		"D:Angazifu","The notes are currently unavailable in kiswahili");
this.addQuestion(q20);
Question q21=new Question("7/8 Kwa maneno ni:",
		"A:subui nane",
		"B:Thumni saba",
		"C:Subui",
		"D:Thumuni",
		"B:Thumni saba","The notes are currently unavailable in kiswahili");
this.addQuestion(q21);
Question q22=new Question("Kisawe cha neno BAROBARO ni",
		"A:Banati",
		"B:Kijana",
		"C:Mvulana",
		"D:Shaibu",
		"C:Mvulana","The notes are currently unavailable in kiswahili");
this.addQuestion(q22);
Question q23=new Question("Nomino habari iko katika ngeli ya:",
		"A:U-ZI",
		"B:I-I",
		"C:U-I",
		"D:I-ZI",
		"D:I-ZI","The notes are currently unavailable in kiswahili");
this.addQuestion(q23);
Question q24=new Question("Tano kwa Chokaa.Kitita ni kwa?",
		"A:Pesa",
		"B:Funguo",
		"C:Ndizi",
		"D:Ngozi",
		"A:Pesa","The notes are currently unavailable in kiswahili");
this.addQuestion(q24);
Question q25=new Question("Chagua Usemi halisi ufaao wa:Bahati alisema kuwa angeenda nyumbani kupumzika.",
		"A:\"Nimeenda nyumbani kupumzika\",Bahati alisema.",
		"B:\"Niende nyumbani kupumzika\",Bahati alisema.",
		"C:\"Nitaenda nyumbani kupumzika\",Bahati alisema.",
		"D:\"Nilienda nyumbani kupumzika\",Bahati alisema.",
		"C:\"Nitaenda nyumbani kupumzika\",Bahati alisema.","The notes are currently unavailable in kiswahili");
this.addQuestion(q25);
Question q26=new Question("Yapange maneno yafuatayo jinsi yanavyoyokea katika kamusi:(i)Bandika(ii)Birika(iii)Beua(iv)Barika",
		"A:(i)(iv)(ii)(iii)",
		"B:(iv)(ii)(iii)(i)",
		"C:(ii)(i)(iii)(iv)",
		"D:(iv)(i)(ii)(iii)",
		"A:(i)(iv)(ii)(iii)","The notes are currently unavailable in kiswahili");
this.addQuestion(q26);
Question q27=new Question("Methali:Abebwaye hujikaza ina maana gani",
		"A:Unaposaidiwa lazima nwe pia ujitahidi",
		"B:Ukibebwa mgongoni usilegee kamwe",
		"C:tusitarajie kusaidiwa bika kusaidia",
		"D:tukiwasaidia wengine lazima tujitahidi",
		"A:Unaposaidiwa lazima nwe pia ujitahidi","The notes are currently unavailable in kiswahili");
this.addQuestion(q27);
Question q28=new Question("\"Kutojihadhari kabla ya hatari \" ni sawa na?",
		"A:Kutojitayarisha kukabiliana na tatizo",
		"B:kutoshughulika na hatari",
		"C:kutoshughulikia matatizo yajapo",
		"D:kutoogopa madhara ya tatizo",
		"A:Kutojitayarisha kukabiliana na tatizo","The notes are currently unavailable in kiswahili");
this.addQuestion(q28);
Question q29=new Question("Chagua Usemi wa taarifa ufaao wa:\"Kilele cha Mlima Kenya kina theluji nyingi\",Fatuma akasema.",
		"A:Fatuma alisema kwamba kilele cha Mlima Kenya kilikuwa na theluji nyingi.",
		"B:Fatuma anasema kwamba kilele cha Mlima Kenya huwa na theluji nyingi. ",
		"C:Fatuma akasema kwamba kilele cha Mlima Kenya kimekuwa na theluji nyingi. ",
		"D:Fatuma alisema kwamba kilele cha Mlima Kenya kingekuwa na theluji nyingi ",
		"B:Fatuma anasema kwamba kilele cha Mlima Kenya huwa na theluji nyingi.","The notes are currently unavailable in kiswahili");
this.addQuestion(q29);
Question q30=new Question("Ni sentensi ipi inayoonyesha matumizi sahihi ya Lau?",
		"A:Lau mwanafunzi anapopita mtihani hutuzwa.",
		"B:Lau ungekuja ningekusaidia",
		"C:Nipe lau kitabu kitabu moja nisome",
		"D:Nitakujuza lau hutaki kujua",
		"D:Nitakujuza lau hutaki kujua","The notes are currently unavailable in kiswahili");
this.addQuestion(q30);
Question q31=new Question("Chagua jibu linaloonyesha aina za mashairi.",
		"A:Tarbia.Takhmisa",
		"B:Tarbia,Mizani",
		"C:Vina,Takhmisa",
		"D:Takhmisa,Mishororo",
		"A:Tarbia.Takhmisa","The notes are currently unavailable in kiswahili");
this.addQuestion(q31);
Question q32=new Question("Methali yenye maana sawa na\"Usiache mbachao kwa msala upitao\" ni",
		"A:usione kwenda mbele kurudi nyuma si kazi",
		"B:bahati ya mwenzio usilalie mlango wazi",
		"C:usipoziba ufa utajenga ukuta",
		"D:bura yangu siibadili na rehani",
		"D:bura yangu siibadili na rehani","The notes are currently unavailable in kiswahili");
this.addQuestion(q32);
Question q33=new Question("Jogoo ni kwa koo,fahali ni kwa",
		"A:ndama",
		"B:kipora",
		"C:tembe",
		"D:mtamba",
		"A:ndama","The notes are currently unavailable in kiswahili");
this.addQuestion(q33);
Question q34=new Question("Chagua aina ya pambo ambalo huvaliwa miguuni",
		"A:Kipete",
		"B:Kidani",
		"C:Kikuku",
		"D:Kikuba",
		"D:Kikuba","The notes are currently unavailable in kiswahili");
this.addQuestion(q34);
Question q35=new Question("Umoja wa sentensi \"Waungwana wowote hawawezi kutufanyia fujo \" ni",
		"A:Muungwana yeyote hawezi kutufanyia fujo.",
		"B:Muungwana yeyote hawezi kunifanyia fujo.",
		"C:Muungwana yoyote hawezi kunifanyia fujo.",
		"D:Muungwana yoyote hawezi kutufanyia fujo.",
		"B:Muungwana yeyote hawezi kunifanyia fujo.","The notes are currently unavailable in kiswahili");
this.addQuestion(q35);
Question q36=new Question("Chagua sentensi ambayo ni muungano sahihi wa hizi:\nMburukenge aliingia uwanzani.\nMburukenge aliwafadhaisha wanafunzi.",
		"A:Mburukenge aliingia uwanjani na kuwafadhaisha wanafunzi",
		"B:Mburukenge aliingia uwanjani kwa kuwafadhaisha wanafunzi",
		"C:Mburukenge aliingia uwanjani lakini  aliwafadhaisha wanafunzi",
		"D:Mburukenge aliingia uwanjani kwani aliwafadhaisha wanafunzi",
		"A:Mburukenge aliingia uwanjani na kuwafadhaisha wanafunzi","The notes are currently unavailable in kiswahili");
this.addQuestion(q36);
Question q37=new Question("Kumpiga vitu vijembe ni:",
		"A:Kumpa sifa asizostahili",
		"B:Kumsema kwa mafumbo",
		"C:Kumchafulia mtu jina",
		"D:Kumfanyia ishara ya dharau",
		"B:Kumsema kwa mafumbo","The notes are currently unavailable in kiswahili");
this.addQuestion(q37);
Question q38=new Question("Ugonjwa wa ukambi pia huitwa",
		"A:surua",
		"B:safura",
		"C:ndui",
		"D:tetewega",
		"C:ndui","The notes are currently unavailable in kiswahili");
this.addQuestion(q38);
Question q39=new Question("Sahihisha:Kule mlikolima hamna rutuba",
		"A:Kule mlipolima hamna rutuba",
		"B:Pale mlipolima hamna rutuba",
		"C:Kule mlikolima hakuna rutuba",
		"D:Mle mlimolima hakuna rutuba",
		"C:Kule mlikolima hakuna rutuba","The notes are currently unavailable in kiswahili");
this.addQuestion(q39);
Question q40=new Question("Chagua nomino kutokana na kitenzi Kumbuka",
		"A:Kumbukika",
		"B:Kumbukwa",
		"C:Kumbusha",
		"D:Kumbusho",
		"D:Kumbusho","The notes are currently unavailable in kiswahili");
this.addQuestion(q40);
Question q41=new Question("Umbu,Mkoi,Halati wote ni",
		"A:jamii",
		"B:wakwe",
		"C:jamaa",
		"D:marafiki",
		"A:jamii","The notes are currently unavailable in kiswahili");
this.addQuestion(q41);
Question q42=new Question("Kitendawil\"Nikitembea yuko,nikikimbia yuko,nikiingia ndani hayuko,\"jibu lake ni",
		"A:Mwanga",
		"B:Kivuli",
		"C:Mwangwi",
		"D:Upepo",
		"B:Kivuli","The notes are currently unavailable in kiswahili");;
this.addQuestion(q42);
Question q43=new Question("Maana ya neno:Kusajiliwa ni:",
		"A:Kurekebisha",
		"B:Kunufaishwa",
		"C:Kuandikishwa",
		"D:Kufundishwa",
		"C:Kuandikishwa","The notes are currently unavailable in kiswahili");
this.addQuestion(q43);
Question q44=new Question("Nomino Kibogoyo iko Katika Ngeli gani",
		"A:KI-VI",
		"B:U-ZI",
		"C:A-WA",
		"D:I-ZI",
		"C:A-WA","The notes are currently unavailable in kiswahili");
this.addQuestion(q44);
Question q45=new Question("Siku baada ya kesho kutwa ni?",
		"A:juzi",
		"B:mtondogoo",
		"C:mtondo",
		"D:ALasiri",
		"C:mtondo","The notes are currently unavailable in kiswahili");
this.addQuestion(q45);
Question q46=new Question("t",
		"a",
		"b",
		"c",
		"d",
		"ans",
		"notes");
this.addQuestion(q46);



}
@Override
public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
// Drop older table if existed
db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST_KIS);
// Create tables again
onCreate(db);
}
// Adding new question
public void addQuestion(Question quest) {
//SQLiteDatabase db = this.getWritableDatabase();
ContentValues values = new ContentValues();
values.put(KEY_QUES, quest.getQUESTION());
values.put(KEY_ANSWER, quest.getANSWER());
values.put(KEY_NOTE,quest.getNOTE() );
values.put(KEY_OPTA, quest.getOPTA());
values.put(KEY_OPTB, quest.getOPTB());
values.put(KEY_OPTC, quest.getOPTC());
values.put(KEY_OPTD,quest.getOPTD());
// Inserting Row
dbase.insert(TABLE_QUEST_KIS, null, values);	
}
public List<Question> getAllQuestions() {
List<Question> quesListKis = new ArrayList<Question>();
// Select All Query
String selectQuery = "SELECT * FROM " + TABLE_QUEST_KIS;
dbase=this.getReadableDatabase();
Cursor cursor = dbase.rawQuery(selectQuery, null);
// looping through all rows and adding to list
if (cursor.moveToFirst()) {
do {
Question quest = new Question();
quest.setID(cursor.getInt(0));
quest.setQUESTION(cursor.getString(1));
quest.setANSWER(cursor.getString(2));
quest.setNOTE(cursor.getString(3));
quest.setOPTA(cursor.getString(4));
quest.setOPTB(cursor.getString(5));
quest.setOPTC(cursor.getString(6));
quest.setOPTD(cursor.getString(7));
quesListKis.add(quest);
} while (cursor.moveToNext());
}
// return quest list
return quesListKis;
}
public int rowcount()
{
int row=0;
String selectQuery = "SELECT * FROM " + TABLE_QUEST_KIS;
SQLiteDatabase db = this.getWritableDatabase();
Cursor cursor = db.rawQuery(selectQuery, null);
row=cursor.getCount();
return row;
}
}