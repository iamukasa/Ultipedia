package com.amusoft.ultipedialite;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DbHelperSSt extends SQLiteOpenHelper {
private static final int DATABASE_VERSION = 1;
// Database Name
private static final String DATABASE_NAME = "Social Studies questions";
// tasks table name
private static final String TABLE_QUEST_SST = "quest";
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
public DbHelperSSt(Context context) {
super(context, DATABASE_NAME, null, DATABASE_VERSION);
}
@Override
public void onCreate(SQLiteDatabase db) {
dbase=db;
String sql3 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST_SST + " ( "
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
	Question q1=new Question("Which one of the following groups of Kenyan communities share a common origin?",
			"A:Samburu,Aembu,Pokomo",
			"B:Samburu,Abaluyia,Borana",
			"C:Samburu,Turukana,Maasai",
			"D:Samburu,Abakuria,Iteso",
			"C:Samburu,Turukana,Maasai",
			"They all are Nilotic ");
	this.addQuestion(q1);
	Question q2=new Question("The empire of Mwenemutapa was ruled by?",
			"A:a King",
			"B:a council of elders",
			"C:a queen mother",
			"D:a chief",
			"A:a King",
			"The state emerged around 1500 under Nyatsimba Mutota, the first mwene (king) who gained control of the surrounding gold producing region and much of the Zambezi River Valley.  Mutota established a new capital at Zvongombe, near the Zambezi River.");
	this.addQuestion(q2);
	Question q3=new Question("Which one of the following is the main function of Thika town?It is",
			"A:an administrative centre",
			"B:an agricultural centre",
			"C:a market centre",
			"D:an industrial centre",
			"D:an industrial centre",
			"Thika  is an industrial town in Kiambu County, Kenya, lying on the A2 road 40 kilometres (25 mi) north east of Nairobi, near the confluence of the Thika and Chania Rivers.");
	this.addQuestion(q3);
	Question q4=new Question("In traditional Kenyan society polygamy was accepted because",
			"A:it was a way of controlling population growth",
			"B:it was a way of reducing immorality",
			"C:it was a way of controlling infectious diseases",
			"D:it was a sign of prestige",
			"D:it was a sign of prestige",
			"Polygamy was a symbol of status. When one had many wives, it showed that he is capable of supporting a large number of people. This meant that he was wealthy. This raised his status in the society.");
	this.addQuestion(q4);
	Question q5=new Question("Which one of the following groups of countries are found in Eastern Africa",
			"A:Kenya,Uganda,Angola",
			"B:Kenya,Rwanda,Egypt",
			"C:Kenya,Somalia,Namibia",
			"D:Kenya,Tanzania,Sudan",
			"D:Kenya,Tanzania,Sudan",
			"East Africa comprises ten countries: Tanzania, Burundi, Rwanda, Uganda, Sudan, Ethiopia, Eritrea, Djibouti, Somalia, and Kenya.");
	this.addQuestion(q5);
	Question q6=new Question("The following are statements about a community in Eastern Africa During the precolonial period(i)The community was ruled by hereditary kings(ii)The community traded with the coast traders(iii)The community practise crop growing",
			"A:The Dinka",
			"B:The Baganda",
			"C:the Chagga",
			"D:The Somali",
			"B:The Baganda",
			"The leader of the Kingdom is called The Kabaka. Sovereignty of leadership has always belonged to the male child from the royal family.");
	this.addQuestion(q6);
Question q7=new Question("Which one of the following is the main function of agricultural co-operative societies in Kenya",
		"A:Marketing of produce for the members.",
		"B:Buying farm implements for the members",
		"C:Assisting the members to learn good farming methods",
		"D:Building schools for the members' children",
		"A:Marketing of produce for the members.",
		"The notes are currently unavailable for this question");
this.addQuestion(q7);
Question q8=new Question("The Main problem facing beef farming in Kenya is?",
		"A:inadequate market",
		"B:scarcity of water",
		"C:pests and diseases",
		"D:attacks by wild animals",
		"B:scarcity of water",
		"All the above are other problems facing beef farming");
this.addQuestion(q8);
Question q9=new Question("Which of the following is the main problem facing sugarcane farmers in Western Kenya",
		"A:Lack of land to expand their farms",
		"B:Lack of labour during harvesting",
		"C:Delayed payment of sugarcane delivered to factories",
		"D:Lack of storage facilities for sugarcane in the factories",
		"C:Delayed payment of sugarcane delivered to factories",
		"All the above are other problems facing sugar cane farming");
this.addQuestion(q9);
Question q10=new Question("Which of the following Kenyan Communities is correctly matched with its main economic activity during the coloial period?",
		"A:Rendile-trading",
		"B:Ameru-Livestock Keeping",
		"C:Nandi-hunting",
		"D:Abagusii-crop qrowing",
		"D:Abagusii-crop qrowing",
		"Precolonial staple crop was finger millet, which was grown together with sorghum, beans, and sweet potatoes. By the 1920s, maize had overtaken finger millet as both a staple-food crop and a cash crop.");
this.addQuestion(q10);
Question q11=new Question("Which one of the following groups of people share a common ancestor in Traditional Agikuyu community?",
		"A:Njau,his brothers,his sisters",
		"B:Njau,his mother,his father",
		"C:Njau,his wife,his brothers",
		"D:Njau,his uncle,his mother",
		"A:Njau,his brothers,his sisters",
		" The Kikuyu family is considered to be circular, rather than linear as in Western cultures. Each new generation replaces their grandparents, who are then free to become ancestors. The need to replace four grandparents is an important reason for having a minimum of four children, and more children gives honor to the parents' siblings.");
this.addQuestion(q11);
Question q12=new Question("Which one of the following statements is true about education in traditional African societies?",
		"A:Learners read books about great peoople in the society",
		"B:Learners were given written tests regurlarly",
		"C:Learning took place throughout a persons life",
		"D:Learning took place in classrooms.",
		"C:Learning took place throughout a persons life",
		"Traditional education is based on informal apprenticeship with kin and early participation in the work force.");
this.addQuestion(q12);
Question q13=new Question("The main cause of rural-rural migration in Kenya is?",
		"A:lack of water",
		"B:search for land for settlement",
		"C:search for employment",
		"D:outbreak of diseases",
		"A:lack of water",
		"All the above are reasons for rural-rural migration");
this.addQuestion(q13);
Question q14=new Question("Drug abuse is discouraged mainly because it",
		"A:leads to ill health",
		"B:promotes illegal trade",
		"C:pollutes the environment",
		"D:encourages corruption",
		"A:leads to ill health",
		"More deaths, illnesses and disabilities stem from substance abuse than from any other preventable health condition.");
this.addQuestion(q14);
Question q15=new Question("Arabs came to the Kenyan coast before 1500 AD mainly to:",
		"A:spread islam",
		"B:escape religious persecution",
		"C:trade with the local people",
		"D:explore the area",
		"C:trade with the local people",
		"Arab traders began frequenting the Kenya coast around the 1st century AD. Kenya's proximity to the Arabian Peninsula invited trade and later settlement.");
this.addQuestion(q15);
Question q16=new Question("Perkerra irigation scheme was planned for growing",
		"A:fruits",
		"B:onions",
		"C:rice",
		"D:cotton",
		"B:onions",
		"Perkerra Irrigation Scheme was started in 1954 and was incorporated into NIB upon its formation in 1966 through an Act of Parliament.");
this.addQuestion(q16);
Question q17=new Question("Which one of the following groups of commodities did the Akamba traders obtain from the coastal traders during the nineteenth century?",
		"A:Ivory and skins",
		"B:Slaves and grain",
		"C:Beads and cloth",
		"D:Glassware and Gold",
		"C:Beads and cloth",
		"The first crop of Onions was planted in 1956. The area developed to use furrow method of Irrigation was 1400 acres (567 Ha). The total surveyed area for Irrigation is 5800 Acres (2348 Ha)");
this.addQuestion(q17);
Question q18=new Question("European nations established colonies colonies in Africa during the nineteenth century in order to:",
		"A:promote good relations with African leaders",
		"B:Secure markets for manufactured goods from Europe",
		"C:encourage Africans to grow cash crops",
		"D:obtain land to settle European refugees",
		"B:Secure markets for manufactured goods from Europe",
		"The imperatives of capitalist industrialization—including the demand for assured sources of raw materials, the search for guaranteed markets and profitable investment outlets—spurred the European scramble and the partition and eventual conquest of Africa. Thus the primary motivation for European intrusion was economic.");
this.addQuestion(q18);
Question q19=new Question("African resistance ganist European colonisation failed mainly because the Africans",
		"A:lacked modern weapons",
		"B:were disunited",
		"C:had small armies",
		"D:had poor means of communication",
		"A:lacked modern weapons",
		"The resistors were unable to come together for common goal of fighting share anemies, the Germans fough separated resistant movements in Tanganyika, also, in west African, the defeat of samora Toure was contributed by the density among the African,");
this.addQuestion(q19);
Question q20=new Question("Which one of the following European countries used the policy of assimilation to administer its colonies in Africa",
		"A:Britain",
		"B:Gemany",
		"C:France",
		"D:Portugal",
		"C:France",
		"Assimilation was one ideological basis of French colonial policy in the 19th and 20th centuries. In contrast with British imperial policy, the French taught their subjects that, by adopting French language and culture, they could eventually become French. The famous 'Four Communes' in Senegal were seen as proof of this. Here Africans were, in theory, afforded all the rights of French citizens.");
this.addQuestion(q20);
Question q21=new Question("Three of the following are results of European colonial rule in Eastern Africa.Which one is not?",
		"A:Creation of reserves for Africans",
		"B:Promotion of African Culture",
		"C:Introduction of modern health facilities",
		"D:Introduction of modern methods of farming",
		"B:Promotion of African Culture",
		"The impacts of colonization are immense and pervasive.Various effects, both immediate and protracted, include the spread of virulent diseases, unequal social relations, exploitation, enslavement, medical advances, the creation of new institutions, abolitionism,improved infrastructure,and technological progress.Colonial practices also spur the spread of colonist languages, literature and cultural institutions, while endangering or obliterating those of native peoples.");
this.addQuestion(q21);
Question q22=new Question("The headquaters of the African Union is located in",
		"A:Accra",
		"B:Nairobi",
		"C:Harare",
		"D:Addis Ababa",
		"D:Addis Ababa",
		"The African Union (AU) is a union consisting of 54 African states.The AU was established on 26 May 2001 in Addis Ababa and launched on 9 July 2002 in South AfricaThe African Union's new headquarters complex in Addis Ababa. The main administrative capital of the African Union is in Addis Ababa, Ethiopia, where the African Union Commission is headquartered.");
this.addQuestion(q22);
Question q23=new Question("Below are ststements about a river in Africa.(i)it passes through a dessert.(ii)its source is a freshwater lake.(iii)it has a delta(iv)it provides water for irrigation",
		"A:River Volta",
		"B:River Tana",
		"C:River Nile",
		"D:River Limpopo",
		"C:River Nile",
		"The River Nile is about 6,670 km (4,160 miles) in length and is the longest river in Africa and in the world. Although it is generally associated with Egypt, only 22% of the Nile’s course runs through Egypt.");
this.addQuestion(q23);
Question q24=new Question("Which one of the following factors explains why the Turukana practise nomadic pastoralism?",
		"A:They own large numbers of animals.",
		"B:They live in an area that receives little rainfall",
		"C:They have a liking for adventure",
		"D:They lack land for growing crops",
		"B:They live in an area that receives little rainfall",
		"The Turkana are a Nilotic people native to the Turkana District in northwest Kenya, a semi-arid climate region bordering Lake Turkana in the east, Pokot, Rendille and Samburu to the south, Uganda to the west, and South Sudan and Ethiopia to the north");
this.addQuestion(q24);
Question q25=new Question("Which of the following minerals is correctly matched with the country in Africaa where it is mined for export?",
		"A:Gold-South Africa",
		"B:Oil-Tanzania",
		"C:Copper-Nigeria",
		"D:Diamonds-Uganda",
		"A:Gold-South Africa",
		"South Africa dominated global gold production in the Twentieth Century and in  1970 accounted for 79% of the entire world’s production. It is estimated that South Africa has produced some 40,000 tonnes of gold since the start of recorded history,about one third of the total worldwide.");
this.addQuestion(q25);
Question q26=new Question("The Drakensberg Mountains was formed as a result of?",
		"A:deposition",
		"B:folding",
		"C:erosion",
		"D:faulting",
		"D:faulting",
		"The Drakensberg  is the name given to the eastern portion of the Great Escarpment, which encloses the central Southern African plateau. The Great Escarpment reaches its greatest altitude in this region (2000 – 3000 m).");
this.addQuestion(q26);
Question q27=new Question("Which one of the following is true about the struggle for independence in Tanganyika?",
		"A:The nationalists established bases in neighbouring countries",
		"B:The nationalists organised querilla warfare",
		"C:The nationalists formed political parties",
		"D:The nationalists were helped by the OAU.",
		"C:The nationalists formed political parties",
		"The Tanganyika African National Union (TANU) was the principal political party in the struggle for sovereignty in the East African state of Tanganyika (now Tanzania). The party was formed from the Tanganyika African Association by Julius Nyerere in July 1954 when he was teaching at St. Francis' College");
this.addQuestion(q27);
Question q28=new Question("The following events took place during the struggle for independence in Kenya.Which one came first?",
		"A:Nomination of the first African to the Legislative Council.",
		"B:The release of Jomo Kenyatta from detention",
		"C:The first Lancaster House Conference",
		"D:Declaration of the State of Emergency",
		"D:Declaration of the State of Emergency",
		"In October 1952, the British declared a state of emergency, which continued until 1960. The State of Emergency was in response to an increase in attacks on the property and persons of white settlers, as well as African chiefs who were seen as collaborators.");
this.addQuestion(q28);
Question q29=new Question("Three of the following are reasons why fish farms are started.Which one is not?",
		"A:To make harvesting of fish easy",
		"B:To enable farmers to keep the type of fish they require",
		"C:To provide people with jobs",
		"D:To provide clean water for drinking",
		"D:To provide clean water for drinking",
		"There is an increasing demand for fish and fish protein, which has resulted in widespread overfishing in wild fisheries. Fish farming offers fish marketers another source.");
this.addQuestion(q29);
Question q30=new Question("One of the achivements of Kwame Nkurmah of Ghana is that",
		"A:He led the trade union movement in Ghana during the colonoal periods",
		"B:He abolished taxation in his country",
		"C:He led the country to independence",
		"D:he introduced large scale cocoa farming in Ghana",
		"C:He led the country to independence",
		"Kwame Nkrumah,was the leader of Ghana and its predecessor state, the Gold Coast, from 1951 to 1966. Overseeing the nation's independence from British colonisation in 1957, Nkrumah was the first President of Ghana and the first Prime Minister of Ghana. An influential 20th-century advocate of Pan-Africanism, he was a founding member of the Organisation of African Unity and was the winner of the Lenin Peace Prize in 1963");
this.addQuestion(q30);
Question q31=new Question("The main factor that determines the establishment of a textile manufacturing industry is:",
		"A:availability of land",
		"B:availability of workers",
		"C:adequate market",
		"D:adequate transport",
		"C:adequate market",
		"All the above also factor in establishing a textile manufacturing industry");
this.addQuestion(q31);
Question q32=new Question("Which one of the following ativities threatens the existence of natural forests in Kenya?",
		"A:Settling of people around the forests.",
		"B:Destruction of trees by wild animals.",
		"C:Collecting of herbs for making medicine",
		"D:Cutting trees for telephone poles",
		"D:Cutting trees for telephone poles",
		"Kenya has a relatively low forest cover. Closed canopy forest covers about 1.24 million ha. Plantations cover 0.16 million ha. The total forest area is less than 3 per cent of the total land area of Kenya. Most of the indigenous forests occur in high potential areas where they are under severe pressure and competition from other forms of land use");
this.addQuestion(q32);
Question q33=new Question("In which one of the following months is the sun overhead at the Tropic of Capricorn?",
		"A:March",
		"B:December",
		"C:June",
		"D:September",
		"C:June",
		"The Tropic of Cancer, also referred to as the northern tropic, is the most northerly circle of latitude on the Earth at which the Sun may appear directly overhead at its culmination. This event occurs once per year, at the time of the June solstice, when the Northern Hemisphere is tilted toward the Sun to its maximum extent");
this.addQuestion(q33);
Question q34=new Question("Kenya citizens are allowed to register as voters for parliamentary election when they ",
		"A:become members of political parties",
		"B:have completed primary level of education",
		"C:participate in development projects",
		"D:have attained the age of 18 years",
		"D:have attained the age of 18 years",
		"To be eligible to register to vote, a person must be aged 18 years or over and a Kenyan citizen");
this.addQuestion(q34);
Question q35=new Question("Suspected criminals are kept in cells before being taken to court in order to.",
		"A:punish them for the offences they have commited",
		"B:allow time for carrying out investigations",
		"C:give them  time to contact their relatives",
		"D:make them clean up the cells",
		"B:allow time for carrying out investigations",
		"The notes are currently unavailable for this question");
this.addQuestion(q35);
Question q36=new Question("Which one of the following statements explains why farmers in the Kenya highlands grow most of the tea in small scale farms?",
		"A:There is scarcity of land to establish large farms",
		"B:It is expensive to establish large farms",
		"C:There are too few labourers to work on large farms",
		"D:There are too few factories to process tea from large farms",
		"A:There is scarcity of land to establish large farms",
		"The main tea growing areas in Kenya are situated in and around the highland areas on both sides of the Great Rift Valley; and astride the Equator within altitudes of between 1500 metres and 2700 metres above the sea level.");
this.addQuestion(q36);
Question q37=new Question("Which of the following is the safest point for a pedestrian to cross a busy road?",
		"A:At a junction",
		"B:At a bend",
		"C:At a footbridge",
		"D:At a roundabout",
		"C:At a footbridge",
		"A footbridge or a pedestrian bridge is a bridge designed for pedestrians and in some cases cyclists, animal traffic and horse riders, rather than vehicular traffic");
this.addQuestion(q37);
Question q38=new Question("A good citizen of Kenya is one who",
		"A:attends prayer  meetings regurlarly",
		"B:Obeys the laws of the land",
		"C:Attends political rallies regurlarly",
		"D:Owns alot of property",
		"B:Obeys the laws of the land",
		"Regardless of the presence of elected representatives:Every citizen has an obligation to respect, uphold and defend Kenya’s sovereignty and also to live out the national values and principles of: patriotism, national unity, sharing and devolution of power, the rule of law, democracy and participation of the people.");
this.addQuestion(q38);
Question q39=new Question("Which one of the following officers is appointed by the Public Service Commission(PSC) of Kenya?",
		"A:Chiefs to head locations",
		"B:Speaker of the national Assembly",
		"C:Headteachers of primary schools",
		"D:Judges of the high court",
		"A:Chiefs to head locations",
		"The Public Service Commission  of Kenya is an Independent government Commission established under the Constitution of Kenya to manage human resources in the Kenya Civil Service and the Local Authorities.");
this.addQuestion(q39);
Question q40=new Question("Three of the following statements are true about Mount Kilimanjaro.Which one is NOT?",
		"A:It is the highest Mountain in Africa",
		"B:It is covered with snow at the top",
		"C:It is a source of river Tana",
		"D:It is located in Tanzania",
		"C:It is a source of river Tana",
		"There are three volcanoes on Kilimanjaro - Mawenzi, Shira and Kibo. Mawenzi and Shira are extinct, but Kibo is dormant. The last major eruption was 360 000 years ago.");
this.addQuestion(q40);
Question q41=new Question("The climate of the Congo Basin is generally?",
		"A:cold and wet throughout the year",
		"B:Cold and dry for most of the year",
		"C:Hot and dry for most of the year",
		"D:hot and wet throughout the year",
		"D:hot and wet throughout the year",
		"The Congo Basin climate is warm and humid; with two main seasons: one long rainy season and a dry season with slightly less rains. It rains about 117 days per year with a total of approximately 1,766mm of rainfall.");
this.addQuestion(q41);
Question q42=new Question("Water pollution in Lake Victoria is caussed mainly by",
		"A:plants qrowing in the water",
		"B:waste from factories in the Area",
		"C:People bathing in the area",
		"D:Waste from nearby homes",
		"B:waste from factories in the Area",
		"Pollution of Lake Victoria is mainly due to discharge of raw sewage into the lake, dumping of domestic and industrial waste, and fertiliser and chemicals from farms.");
this.addQuestion(q42);
Question q43=new Question("Three of the following statements are true about the functions of the President of Kenya.Which one is not?",
		"A:chairs Cabinet Meetings",
		"B:is The Chancellor of Public Universities",
		"C:clears candidates for general elections",
		"D:is the head of the Central Government",
		"D:is the head of the Central Government",
		"The President is the Head of Government and wields executive authority,he co-ordinates and supervises all major sections of the executive branch.");
this.addQuestion(q43);
Question q44=new Question("The colour of the National flag of Kenya which represents peace is?",
		"A:white",
		"B:green",
		"C:black",
		"D:red",
		"A:white",
		" The colour black represents the people of the Republic of Kenya, red for the blood shed during the fight for independence, green for the country's landscape and the white fimbriation was added later to symbolize peace and honesty. The black, red, and white traditional Maasai shield and two spears symbolize the defense of all the things mentioned peace and honesty");
this.addQuestion(q44);
Question q45=new Question("Which one of the following groups of security departments is responsible for protecting Kenya aganist external attack?",
		"A:Army,Prison wardens",
		"B:Police forces,prison Wardens",
		"C:Air Force,Police force",
		"D:Army,Air force",
		"D:Army,Air force",
		"The Kenya Defence Forces are the armed forces of the Republic of Kenya. The Kenya Army, Kenya Navy, and Kenya Air Force comprise the national Defence Forces.The Kenya defence force protects Kenya from external attacks");
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
db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST_SST);
// Create tables again
onCreate(db);
}
// Adding new question
public void addQuestion(Question quest) {
//SQLiteDatabase db = this.getWritableDatabase();
ContentValues values = new ContentValues();
values.put(KEY_QUES, quest.getQUESTION());
values.put(KEY_ANSWER, quest.getANSWER());
values.put(KEY_NOTE,quest.getNOTE());
values.put(KEY_OPTA, quest.getOPTA());
values.put(KEY_OPTB, quest.getOPTB());
values.put(KEY_OPTC, quest.getOPTC());
values.put(KEY_OPTD,quest.getOPTD());
// Inserting Row
dbase.insert(TABLE_QUEST_SST, null, values);	
}
public List<Question> getAllQuestions() {
List<Question> quesListSst = new ArrayList<Question>();
// Select All Query
String selectQuery = "SELECT * FROM " + TABLE_QUEST_SST;
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
quesListSst.add(quest);
} while (cursor.moveToNext());
}
// return quest list
return quesListSst;
}
public int rowcount()
{
int row=0;
String selectQuery = "SELECT * FROM " + TABLE_QUEST_SST;
SQLiteDatabase db = this.getWritableDatabase();
Cursor cursor = db.rawQuery(selectQuery, null);
row=cursor.getCount();
return row;
}
}