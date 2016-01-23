package com.amusoft.ultipedia;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DbHelperSci extends SQLiteOpenHelper {
private static final int DATABASE_VERSION = 1;
// Database Name
private static final String DATABASE_NAME = "Science questions";
// tasks table name
private static final String TABLE_QUEST_SCI = "questSci";
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
public DbHelperSci(Context context) {
super(context, DATABASE_NAME, null, DATABASE_VERSION);
}
@Override
public void onCreate(SQLiteDatabase db) {
dbase=db;
String sqlsci = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST_SCI + " ( "
+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
+ KEY_QUES+ " TEXT, "
+ KEY_ANSWER + " TEXT, "
+ KEY_NOTE +" TEXT,"
+ KEY_OPTA +" TEXT, "
+ KEY_OPTB +" TEXT, "
+ KEY_OPTC +" TEXT, "
+ KEY_OPTD +" TEXT )";
db.execSQL(sqlsci);	
addQuestions();
//db.close();
}
private void addQuestions()
{
	Question q1=new Question("In a geothermal power station steam is led through pipes to generate aform of energy which enables people to see.The energy transformations involved are",
			"A:chemical-electrical-mechanical-heat-light",
			"B:heat-mechanical-electrical-heat-light",
			"C:heat-chemical-mechanical-light-electrical", 
			"D:chemical-electrical-light-heat",
			"B:heat-mechanical-electrical-heat-light",
			"The notes are currently unavailable for this question");
	this.addQuestion(q1);
	Question q2=new Question("Which of the following occurs when rays of light pass from air into water",
			"A:Reflection",
			"B:Dispersion",
			"C:Refraction",
			"D:Absorption:",
			"C:Refraction",
			"Refraction is the change in direction as a light or sound wave enters a new medium.");
	this.addQuestion(q2);
	Question q3=new Question("Which one of the following factors Does Not affect how high or low sound produced by a stringed instrument it?",
			"A:lenght of the String",
			"B:Thickness of the String",
			"C:Tightness  of the String",
			"D:Force used to pluck the string",
			"A:lenght of the String",
			"The notes are currently unavailable for this question");
	this.addQuestion(q3);
	Question q4=new Question("Which of the following is NOT a characteristic of seeds dispersed by wind",
		"A:light",
		"B:hooked",
		"C:winged",
		"D:feathery",
		"B:hooked",
		"Seeds dispersed by the wind must be light and small in order to be carried by the wind.");
	this.addQuestion(q4);
	Question q5=new Question("Which one of the following has ALL the conditions necessary for germaination of seeds",
			"A:Soil,air,water",
			"B:Air,Warmth,water",
			"C:Warmth light,soil",
			"D:Water,Warmth,Light",
			"D:Water,Warmth,Light",
			"In general we can say that all seeds need water and warmth to germinate.");
	this.addQuestion(q5);
Question q6=new Question("Which one of the following insects DOES NOT undergo the stages of egg ,larva ,pupa and adult in its lifecycle",
		"A:Housefly",
		"B:Mosquito",
		"C:Bee",
		"D:Locust",
		"D:Locust",
		"The dragonfly,Locust, termite, grasshopper and true bug undergo incomplete metamorphosis. In this process there are three stages called egg, nymph and adult");
this.addQuestion(q6);
Question q7=new Question("Which of the following animals is not a mammal",
		"A:Hipopotamus",
		"B:Bat",
		"C:Whale",
		"D:Shark",
		"D:Shark",
		"Sharks are a group of fish characterized by a cartilaginous skeleton, five to seven gill slits on the sides of the head, and pectoral fins that are not fused to the head. ");
this.addQuestion(q7);
Question q8=new Question("The following are functions of roots:\n(i)holding plants firmly in the soil\n(ii)storage of food\n(iii)absorbtion of water and mineral salts\n(iv)breathing\n Which of the following functions are performed by all Roots",
		"A:(i)(iii)",
		"B:(ii)(iv)",
		"C:(i)(ii)",
		"D:(iii)(iv)",
		"A:(i)(iii)",
		"The four major functions of roots are absorption of water and inorganic nutrients,anchoring of the plant body to the ground, and supporting it,storage of food and nutrients, and vegetative reproduction. ");
this.addQuestion(q8);
Question q9=new Question("Which of the folllowing is not a function of the placenta?",
		"A:allow passage of dissolved food materials to the embryo",
		"B:Allow exchange of gases between embryo  and mother",
		"C:prevent harmful materials from reaching the embryo",
		"D:protects embryo from from shock",
		"D:protects embryo from from shock",
		"The placenta is the Site for gas exchange,Nutrient exchange,Waste exchange,Synthesis of enzymes Detoxification of drugs and metabolisation and also provides IgG and immune system for foetus");
this.addQuestion(q9);
Question q10=new Question("The plant process investigated when the leaves of a potted plants are enclosed in a polytthene bag is?",
		"A:Condesation",
		"B:Transpiration",
		"C:Saturation",
		"D:evaporation",
		"B:Transpiration",
		"Transpiration is the loss of water vapour from the surface of plant leaves.Transpiration is most rapid in hot, dry, windy or bright conditions.");
this.addQuestion(q10);
Question q11=new Question("Which oneof the following statements is NOT True about all arteries?",
		"A:They carry blood away from the heart",
		"B:They have thick walls",
		"C:Blood pressure in them is high",
		"D:They carry blood rich in Oxygen",
		"D:They carry blood rich in Oxygen",
		"Blood is pumped through pulmonary artery to lungs to retrieve oxygen oxygenated blood returns to heart through the Pulmonary vein");
this.addQuestion(q11);
Question q12=new Question("Which one of the folllowing features would help a pupil tell that a plant structure is a fruit",
		"A:Being fleshy",
		"B:Presence of two scars",
		"C:Having one Cotyledon",
		"D:Having a line if weakness",
		"B:Presence of two scars",
		"Fruits have two scars while Seeds only have two");
this.addQuestion(q12);
Question q13=new Question("Digestion of food does not take place in the",
		"A:mouth",
		"B:large intestines",
		"C:stomach",
		"D:small intestines:",
		"B:large intestines",
		"The Large Intestine is the final portion of the alimentary canal, made up of the cecum, colon, rectum, and anal canal, involved with absorption of water and electrolytes");
this.addQuestion(q13);
Question q14=new Question("A small amount of water was put in a tin can and heated to boiling.The tin can was then closed tightly and left to cool.The experiment was to demonstrate thst air: ",
		"A:occupies space",
		"B:exerts pressure",
		"C:has weight",
		"D:contracts on cooling",
		"D:contracts on cooling",
		"Air contracts this reduces pressure in the tin.Air pressure then acts on the tin can and crushes it.");
this.addQuestion(q14);
Question q15=new Question("Which two components make about 78% of the volume of air?",
		"A:Oxygen and Carbon dioxide",
		"B:Nitrogen and Oxygen",
		"C:Carbon dioxide and Nitogen",
		"D:Rare gases aon Nitrogen",
		"C:Carbon dioxide and Nitogen",
		"Nitrogen makes up 78%,Oxygen	makes up 21%,Carbon dioxide	makes up 0.03% and Rare Gases make up 0.97%");
this.addQuestion(q15);
Question q16=new Question("A certain indicator obtained from a flower turned pink when mixed with a few drops of clover extract.Which one of the following materials would have similar results when mixed with the indicator",
		"A:Chalk powder",
		"B:lemon juice",
		"C:wood ash",
		"D:Baking powder",
		"B:lemon juice",
		"Lemon juice is acidic in nature,Hence will also turn the plant exctract to pink");
this.addQuestion(q16);
Question q17=new Question("Force is Measured in ",
		"A:grams",
		"B:grams per cubic centimeter",
		"C:cubic centimeters",
		"D:Newtons",
		"D:Newtons",
		"A force is a push or pull upon an object resulting from the object's interaction with another object,It is measured in Newtons");
this.addQuestion(q17);
Question q18=new Question("Which one of the following mixtures cannot be separated by dissolving filtering and evaporating?",
		"A:Sand and sugar",
		"B:Maize flour and sugar",
		"C:chalk powder and salt",
		"D:salt and sugar",
		"D:salt and sugar",
		"Salt and Sugar all dissolve in water");
this.addQuestion(q18);
Question q19=new Question("A staircase is an example of a simple machine called",
		"A:a wedge",
		"B:an inclined plane",
		"C:a screw",
		"D:a lever",
		"B:an inclined plane",
		"An inclined plane is a slanting surface connecting a lower level to a higher level. It makes it easier to lift something heavy");
this.addQuestion(q19);
Question q20=new Question("A pupil immersed a small container filled with soil into a basin of water bubbles were observed.Which one of the following explains the observation",
		"A:Soil reacts with water",
		"B:Water contains air",
		"C:Soil contains air",
		"D:Small animals in soil produces air",
		"C:Soil contains air",
		"Air is expelled from the soil by the water and comes out through bubbles.Proving soil has water");
this.addQuestion(q20);
Question q21=new Question("Which one of the following levers has the same position of load,effort and fulcrum as the wheelbarrow?",
		"A:Pair of scissors",
		"B:Nutcracker",
		"C:Fishrod",
		"D:Crowbar",
		"B:Nutcracker",
		"Nutcracker and wheelbartrow are second class levers since the load is in between the fulcrum and effort");
this.addQuestion(q21);
Question q22=new Question("Which one of the following will NOT cause a reduction in the number of animals in a game reserve?",
		"A:Burning the charcoal",
		"B:Constructing a railway line through the reserve",
		"C:Fencing using electric wire",
		"D:Operating a quarry",
		"C:Fencing using electric wire",
		"The electric Fence will serve to protect the wild animals from external human inteference i.e poaching");
this.addQuestion(q22);
Question q23=new Question("Which one of the folllowing would help to conserve the environment?",
		"A:Burning heaps of sawdust",
		"B:Burying plastics in the soil",
		"C:Using wood ash to kill pests",
		"D:Using commercial fertilizers to increase crop yield",
		"C:Using wood ash to kill pests",
		"Wood Ash doesnt pollute environment");
this.addQuestion(q23);
Question q24=new Question("Which one of the following would least pollute the environment?",
		"A:Gases from factories",
		"B:Exhaust gases from burning charcoal",
		"C:Smoke from burning charcoal",
		"D:rotting plant and animal matter",
		"D:rotting plant and animal matter",
		"Rotting plant and Animal matter decompose to enrich the soil");
this.addQuestion(q24);
Question q25=new Question("Which one of the following pairs of plannet consist of a planet that takes the longest time and a planet that a planet that takes the shortest time to go around the sun",
		"A:Jupiter and Mars",
		"B:Pluto and Mercury",
		"C:Earth and Saturn",
		"D:Venus and Neptune",
		"B:Pluto and Mercury",
		"The order of planets from the sun is Mercury,Venus,Earth,Mars,Jupiter,Sartun,Uranus,Neptune and lastly Pluto");
this.addQuestion(q25);
Question q26=new Question("Which one of the following DOES NOT affect the accuracy of a RainGauge?",
		"A:The Diameter of the funnel",
		"B:The diameter of the collecting jar",
		"C:The distance between the markings on the collecting jar",
		"D:The materials used to make the container",
		"B:The diameter of the collecting jar",
		"The collecting jar only collects rain droplets and is not used to measure the volume of water measured ");
this.addQuestion(q26);
Question q27=new Question("Which one of the following is NOT drug abuse?",
		"A:Taking prescribed drugs for a long time.",
		"B:Taking an overdose of a prescribed drug",
		"C:Using the drug for a wrong sickness",
		"D:Taking less of the prescribed drugs",
		"A:Taking prescribed drugs for a long time.",
		"Drug abuse is the non-medical use of a drug that interferes with a healthy life. Any drug can be abused. Some people develope drug dependence syndrome, can be physical or phychological or both.");
this.addQuestion(q27);
Question q28=new Question("Which one of the following is NOT an effect of abusing alcohol",
		"A:Loss of memory",
		"B:Social and family problems",
		"C:Hallucinations",
		"D:Poor Health",
		"C:Hallucinations",
		"The notes are currently unavailable for this question");
this.addQuestion(q28);
Question q29=new Question("Drugs taken to treat diseases are known as",
		"A:curative",
		"B:stimulants",
		"C:preventive",
		"D:pain relievers",
		"A:curative",
		"The notes are currently unavailable for this question");
this.addQuestion(q29);
Question q30=new Question("Which of the following heavenly bodies produces light ",
		"A:Mars ",
		"B:Venus",
		"C:Star",
		"D:Moon",
		"C:Star",
		"A star is a a self-luminous celestial body consisting of a mass of gas held together by its own gravity.");
this.addQuestion(q30);
Question q31=new Question("Which one of the following explains why flowing waters moves objects?Flowing water ",
		"A:has energy of movement",
		"B:is a liquid",
		"C:has potential energy",
		"Carries less dense objects only",
		"A:has energy of movement",
		"Kinetic Energy is the energy of that objects in motion posess");
this.addQuestion(q31);
Question q32=new Question("Which of the following insect undergoes the stages of egg,nymph,and adult in its life cycle?",
		"A:Tsetse fly",
		"B:Wasp",
		"C:Butterfly",
		"D:Cockroach",
		"C:Butterfly",
		"The dragonfly,Locust, termite, grasshopper and true bug undergo incomplete metamorphosis. In this process there are three stages called egg, nymph and adult");
this.addQuestion(q32);
Question q33=new Question("Engine oil mixes with kerosene but does not mix with water.Methylated spirit mixes with water but does not mix with kerosene.If the four liquids were put in the same container how many layers would be observed? ",
		"A:1",
		"B:2",
		"C:3",
		"D:4",
		"B:2",
		"Engine Oil will mix with Kerosene to form a single layer,Water and Methylated spirit  will mix to form another layer");
this.addQuestion(q33);
Question q34=new Question("A chameleon shoots out its tounge to",
		"A:taste food",
		"B:locate food",
		"C:catch food",
		"D:coll itself",
		"C:catch food",
		"Chameleon feed by firing their sticky tongues at a variety of prey including flies, grasshoppers and butterflies.");
this.addQuestion(q34);
Question q35=new Question("Which choice contains a flowering plant and a non-flowering plant respectively? ",
		"A:Fern,Moss",
		"B:Banana,Fern",
		"C:Moss,Mushroom",
		"D:Grass,Banana",
		"B:Banana,Fern",
		"Bananas form Flowers while Ferns posees  false  flowers");
this.addQuestion(q35);
Question q36=new Question("On a cold day most birds raise their fathers to",
		"A:allow air to escape from escape from their bodies",
		"B:allow even distribution of heat in the body",
		"C:avoid losing heat from their bodies",
		"D:generate heat",
		"C:avoid losing heat from their bodies",
		"Raising feathers trap air pockets hence insulating the birds skin from loss of heat ");
this.addQuestion(q36);
Question q37=new Question("Which one of the following drugs is a stimulant when used in small quantities but a depressant when used in large quantities?",
		"A:Tobacco",
		"B:Coffee",
		"C:Khat",
		"D:Alcohol",
		"D:Alcohol",
		"Interestingly enough, alcohol is in two categories. The main category, of course, is a depressant. It makes people slow down and lose motor skills. On the other hand, alcohol can also be said to be a stimulant because it causes people to lose inhibitions in smaller amounts.");
this.addQuestion(q37);
Question q38=new Question("Which one of the following ways of producing lighy involves energy changes from chemical to electrical and lastly to heat and light?Using a",
		"A:bicycle dynamo",
		"B:hydroelectric generator",
		"C:solar cells",
		"D:torch",
		"D:torch",
		"Chemical energy is in the torch battery cells  which is then trensferred through the cables,The Electricity heats the bulb filament of the torch which lights up ");
this.addQuestion(q38);
Question q39=new Question("Fruits that are dispersed by water ",
		"A:have pods wit lines of weakness",
		"B:are small and hairy",
		"C:are hollow and fibrous",
		"D:are small with hooks",
		"C:are hollow and fibrous","The notes are currently unavailable for this question");
this.addQuestion(q39);
Question q40=new Question("A certain animal lays egggs,has scales,and the body temperatures varies with the surrounding.The animal is likely to be a",
		"A:snake",
		"B:platypus",
		"C:toad",
		"D:duck",
		"A:snake",
		"The Animal Described is a Mamall");
this.addQuestion(q40);
Question q41=new Question("The type of modified roots found in mangrooves are called",
		"A:breathing",
		"B:prop",
		"C:butress",
		"D:clasping",
		"A:breathing",
		"Breathing roots of the mangrooves are adapted in order to enable gaseous exchange for the plant");
this.addQuestion(q41);
Question q42=new Question("Which of the following aspects of an object cannot be changed?",
		"A:Mass",
		"B:Density",
		"C:Weight",
		"D:Volume",
		"A:Mass",
		"Quantity of matter(mass) cannot be created nor destroyed:Law of conservation of matter");
this.addQuestion(q42);
Question q43=new Question("Which one of the following should NOT be the same when comparing rates of melting in substances?",
		"A:Quantity of substances ",
		"B:Amount of heat",
		"C:The substances",
		"D:Duration of heating",
		"C:The substances",
		"The test is on melting of different substances,The Substances should vary");
this.addQuestion(q43);
Question q44=new Question("The planet with a ring around it is",
		"A:Mercury",
		"B:Saturn",
		"C:Pluto",
		"D:Jupiter",
		"B:Saturn",
		"The planet Jupiter has a system of rings, known as the rings of Jupiter or the Jovian ring system");
this.addQuestion(q44);
Question q45=new Question("The soil that drains water fastest",
		"A:has small air spaces",
		"B:cracks when dry",
		"C:has poor capilarity",
		"D:has smooth texture",
		"C:has poor capilarity",
		"The soil that drains water fastest has the largest air particles hence making its capilarity poor");
this.addQuestion(q45);
Question q46=new Question("t",
		"a",
		"b",
		"c",
		"d",
		"ans",
		" Notes");
this.addQuestion(q46);


}
@Override
public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
// Drop older table if existed
db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST_SCI);
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
dbase.insert(TABLE_QUEST_SCI, null, values);	
}
public List<Question> getAllQuestions() {
List<Question> quesListSci = new ArrayList<Question>();
// Select All Query
String selectQuery = "SELECT * FROM " + TABLE_QUEST_SCI;
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
quesListSci.add(quest);
} while (cursor.moveToNext());
}
// return quest list
return quesListSci;
}
public int rowcount()
{
int row=0;
String selectQuery = "SELECT * FROM " + TABLE_QUEST_SCI;
SQLiteDatabase db = this.getWritableDatabase();
Cursor cursor = db.rawQuery(selectQuery, null);
row=cursor.getCount();
return row;
}
}