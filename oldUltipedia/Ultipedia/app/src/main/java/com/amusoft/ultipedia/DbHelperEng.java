package com.amusoft.ultipedia;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DbHelperEng extends SQLiteOpenHelper {
private static final int DATABASE_VERSION = 1;
// Database Name
private static final String DATABASE_NAME = "English questions";
// tasks table name
private static final String TABLE_QUEST_ENG = "quest";
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
public DbHelperEng(Context context) {
super(context, DATABASE_NAME, null, DATABASE_VERSION);
}
@Override
public void onCreate(SQLiteDatabase db) {
dbase=db;
String sqlr = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST_ENG + " ( "
+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
+ KEY_QUES+ " TEXT, "
+ KEY_ANSWER + " TEXT, "
+ KEY_NOTE +" TEXT,"
+KEY_OPTA +" TEXT, "
+KEY_OPTB +" TEXT, "
+KEY_OPTC +" TEXT, "
+KEY_OPTD +" TEXT)";
db.execSQL(sqlr);		
addQuestions();
//db.close();
}
private void addQuestions()
{
Question q1=new Question("Choose one that means the same as the word in Capital:The law OBLIGES parents to send their children to school",
		"A:forces",
		"B:ask",
		"C:requires", 
		"D:persuades",
		"C:requires",
		"Oblige:to require or constrain, as by law, command, conscience, or force of necessity,to bind morally or legally, as by a promise or contract.to place under a debt of gratitude for some benefit, favor, or service:");
this.addQuestion(q1);
Question q2=new Question("Choose one that means the same as the word in Capital:He SELDOM Comes Here",
		"A:regurlarly",
		"B:rarely",
		"C:always",
		"D:sometimes",
		"B:rarely",
		"Seldom:not often; rarely");
this.addQuestion(q2);
Question q3=new Question("Choose one that means the same as the word in Capital:The INITIAL plan was the best",
		"A:earlier",
		"B:former",
		"C:starting",
		"D:original",
		"D:original",
		"Initial:of, pertaining to, or occurring at the beginning; first:");
this.addQuestion(q3);
Question q4=new Question("Which of the following is correctly punctuated:",
		"A:Subira inquired Fred,\"how many cackes do you need?\"",
		"B:\"Subira,\" inquired Fred,\"how many cackes do you need?\"",
		"C:Subira,inquired Fred,\"how many cackes do you need?\"",
		"D:\"Subira inquired Fred,\"how many cackes do you need?",
		"A:Subira inquired Fred,\"how many cackes do you need?\"",
		"Use quotation marks to set off material that represents quoted or spoken language. Quotation marks also set off the titles of things that do not normally stand by themselves: short stories, poems, and articles. Usually, a quotation is set off from the rest of the sentence by a comma;");
this.addQuestion(q4);
Question q5=new Question("Which of the following is correctly punctuated:",
		"A:How interesting the day was?",
		"B:How interesting the day was.",
		"C:How interesting the day was!",
		"D:How interesting the day was!?",
		"C:How interesting the day was!",
		"The exclamation point  is a terminal punctuation mark in English and is usually used at the end of a sentence with no extra period. It can turn a simple indicative or declarative sentence into a strong command or reflect an emotional outburst. It can also indicate rhetorical questions.");
this.addQuestion(q5);
Question q6=new Question("Which alternative Best completes the sentences:I offered him a job but he___",
		"A:turned it away",
		"B:turned it down",
		"C:turned it back",
		"D:turned it off",
		"B:turned it down",
		"turn down somebody/something also turn somebody/something down is to refuse to accept or agree to something, or to someone's idea");
this.addQuestion(q6);
Question q7=new Question("Which alternative Best completes the sentences:After yesterday's perfomance they should be____",
		"A:ashamed for themselves",
		"B:ashamed with themselves",
		"C:ashamed at themselves",
		"D:ashamed of themselves",
		"D:ashamed of themselves",
		"Generally, the adjective order in English is:Quantity or number,Quality or opinion,Size,Age,Shape,Color,Proper adjective (often nationality, other place of origin, or material),Purpose or qualifier");
this.addQuestion(q7);
Question q8=new Question("Which alternative Best completes the sentences:She has a_____bag",
		"A:small beautiful expensive",
		"B: beautiful small expensive",
		"C:small expensive  beautiful",
		"D: beautiful expensive small",
		"A:small beautiful expensive",
		"Generally, the adjective order in English is:Quantity or number,Quality or opinion,Size,Age,Shape,Color,Proper adjective (often nationality, other place of origin, or material),Purpose or qualifier");
this.addQuestion(q8);
Question q9=new Question("Choose one that best completes the sentence:The Mutukus are so kind...",
		"A:because they always help people.",
		"B:as they always help people",
		"C:that they always help people",
		"D:since they always help people",
		"A:because they always help people.",
		"The notes are currently unavailable for this question");
this.addQuestion(q9);
Question q10=new Question("Fights were PROHIBITED means they were",
		"A:stopped",
		"B:discouraged",
		"C:forbidden",
		"D:refused",
		"C:forbidden",
		"Prohibited:To forbid by authority,To prevent; preclude");
this.addQuestion(q10);
Question q11=new Question("Which of the following words is closest in meaning to 'crumpled'",
		"A:Folded",
		"B:Wrinkled",
		"C:Pleated",
		"D:Squeezed",
		"B:Wrinkled",
		"Crumple:To become wrinkled. To collapse");
this.addQuestion(q11);
Question q12=new Question("The term \"common knowledge\" means the same as",
		"A:easy to get",
		"B:widely known",
		"C:for everybody",
		"D:found everywhere",
		"B:widely known",
		"Common knowledge:something widely or generally known");
this.addQuestion(q12);
Question q13=new Question("Choose the word that least fits the group",
		"A:cutlery",
		"B:crockery",
		"C:bedding",
		"D:shirts",
		"D:shirts","The notes are currently unavailable for this question");
this.addQuestion(q13);
Question q14=new Question("Choose the word that least fits the group",
		"A:glance",
		"B:gaze",
		"C:stare",
		"D:glare",
		"D:glare","The notes are currently unavailable for this question");
this.addQuestion(q14);
Question q15=new Question("Choose the word that least fits the group",
		"A:grab",
		"B:hold",
		"C:touch",
		"D:seize",
		"C:touch",
		"The notes are currently unavailable for this question");
this.addQuestion(q15);
Question q16=new Question("Choose the best alternative which best to complete the statement:Only after everyone has paid the fare..",
		"A:the bus will leave",
		"B:then the bus will leave",
		"C:and the bus will leave",
		"D:will the bus leave",
		"D:will the bus leave","The notes are currently unavailable for this question");
this.addQuestion(q16);
Question q17=new Question("Choose the best alternative which best to complete the statement:Musa asked her..",
		"A:where are you going",
		"B:where was she going",
		"C:where she was going",
		"D:where she is going",
		"C:where she was going","The notes are currently unavailable for this question");
this.addQuestion(q17);
Question q18=new Question("Which sentence is punctuated correctly:",
		"A:You don't believe that.Do you?",
		"B:I don't like it's colour.",
		"C:Jane Said,\"The young man is my brother.\"The notes are currently unavailable for this question",
		"D:She is asking whether you are hungry?",
		"B:I don't like it's colour.","The notes are currently unavailable for this question");
this.addQuestion(q18);
Question q19=new Question("Which sentence is punctuated correctly:",
		"A:Your's was accepted",
		"B:\"Do you like travelling ?\"She asked.",
		"C:Ipu bought the following items:sugar,flour,bread and honey.",
		"D:what a surprise?",
		"B:\"Do you like travelling ?\"She asked.","The notes are currently unavailable for this question");
this.addQuestion(q19);
Question q20=new Question("The expression\"in quick succesion means\"",
		"A:Many events were quickly witnessed",
		"B:The rhythm of life changed suddenly",
		"C:an event taking place before another ends",
		"D:things happening rapidly one after another",
		"D:things happening rapidly one after another","The notes are currently unavailable for this question");
this.addQuestion(q20);
Question q21=new Question("Choose an alteranative that best fill the blanks:Kemboi chose to walk to the mmarket_____it was very hot",
		"A:because",
		"B:but",
		"C:while",
		"D:though",
		"D:though","The notes are currently unavailable for this question");
this.addQuestion(q21);
Question q22=new Question("Choose an alteranative that best fill the blanks:\"Come first December this year my sister_______two years old\"",
		"A:shall be",
		"B:will be",
		"C:could be",
		"D:should be",
		"B:will be","The notes are currently unavailable for this question");
this.addQuestion(q22);
Question q23=new Question("Choose an alteranative that best fill the blanks:The teacher was very_____with the pupils who had not done their homework.",
		"A:sad",
		"B:annoyed",
		"C:disturbed",
		"D:sorry",
		"B:annoyed","The notes are currently unavailable for this question");
this.addQuestion(q23);
Question q24=new Question("Choose one that means the same as the words in Capital:Neri works very hard IN SPITE OF THE FACT she is very old.",
		"A:although",
		"B:but",
		"C:moreover",
		"D:despite",
		"A:although","The notes are currently unavailable for this question");
this.addQuestion(q24);
Question q25=new Question("Choose one that means the same as the words in Capital:Wanyama wanted to MAKE UP FOR the time he had lost.",
		"A:create",
		"B:restore",
		"C:replace",
		"D:recover",
		"D:recover","The notes are currently unavailable for this question");
this.addQuestion(q25);
Question q26=new Question("Choose one that means the same as the words in Capital:Abdi was in a hurry to  WIND UP the meeting",
		"A:postpone",
		"B:end",
		"C:leave",
		"D:stop",
		"B:end","The notes are currently unavailable for this question");
this.addQuestion(q26);
Question q27=new Question("Which means the same as the sentence:Had it not been for the quick response of the ambulance team,the patient would not have survived.",
		"A:The ambulance team responded quickly and the patient survived",
		"B:If the ambulance team had responded quickly the patients would have survived ",
		"C:Because the ambulance team responded quickly the patient survived",
		"D:if the ambulance team responded quickly the patient would not have survived", 
		"C:Because the ambulance team responded quickly the patient survived","The notes are currently unavailable for this question");
this.addQuestion(q27);
Question q28=new Question("Which means the same as the sentence:In a court of law people who have broken the law without knowing it still get punished for the offence.",
		"A:people get punished in acourt of law only for breaking the law deliberately",
		"B:Whether people break the law or not they are punished in a court of law.",
		"C:People get punished in a court of law whether or not,they were aware of the law they broke",
		"D:people who get punished in a court of law neither have broken a law nor they aware of it",
		"C:People get punished in a court of law whether or not,they were aware of the law they broke","The notes are currently unavailable for this question");
this.addQuestion(q28);
Question q29=new Question("The word\"feeble \" means the same as",
		"A:dying",
		"B:soft",
		"C:weak",
		"D:slow",
		"C:weak",
		"Feeble:Lacking strength; weak.Indicating weakness.Lacking vigor, force, or effectiveness; inadequate");
this.addQuestion(q29);
Question q30=new Question("The meaning of the word\"Derived\" as used in \"Spices can be classed from the plat which their are derived \"  is? ",
		"A:found",
		"B:removed",
		"C:btained",
		"D:Produced",
		"B:removed",
		"Derived:To obtain or receive from a source. To arrive at by reasoning; deduce or infer: derive a conclusion from facts.To trace the origin or development of (a word).");
this.addQuestion(q30);
Question q31=new Question("Choose one that best completes the sentence:They have been forbidden.....",
		"A:to go to town?",
		"B:from going to town?",
		"C::not to go to town?",
		"D:no going to town?",
		"B:from going to town?","The notes are currently unavailable for this question");
this.addQuestion(q31);
Question q32=new Question("Choose one that best completes the sentence:Would you have done that job if you",
		"A:had been paid well?",
		"B:were paid well?",
		"C:could have been paid well?",
		"D:would be paid well",
		"A:had been paid well?",
		"The notes are currently unavailable for this question");
this.addQuestion(q32);
Question q33=new Question("Choose one that means the same as the word in capital:Most fresh flowers have a delightful FRAGRANCE. ",
		"A:aroma",
		"B:scent",
		"C:smell",
		"d:odour",
		"B:scent",
		"Fragrance: The state or quality of having a pleasant odor.A sweet or pleasant odor; a scent.A substance, such as a perfume or cologne, designed to emit a pleasant odor.");
this.addQuestion(q33);
Question q34=new Question("Choose one that means the same as the word in capital:Children should not WANDER in the streets.",
		"A:walk",
		"B:stroll",
		"C:loiter",
		"D:roam",
		"C:loiter",
		"Wander:To move about without a definite destination or purpose.To go by an indirect route or at no set pace; amble: wander toward town.To proceed in an irregular course; meander.To go astray: wander from the path of righteousness.To lose clarity or coherence of thought or expression.");
this.addQuestion(q34);
Question q35=new Question("Choose one that means the same as the word in capital:She DESERVED that reward.",
		"A:got",
		"B:won",
		"C:carned",
		"D:gained",
		"B:won",
		"Deserved:Merited or earned");
this.addQuestion(q35);
Question q36=new Question("Choose an alteranative that best fill the blanks:Since Rehema could not get a matatu she travelled home______a bus",
		"A:by",
		"B:on",
		"C:in",
		"D:with",
		"A:by","The notes are currently unavailable for this question");
this.addQuestion(q36);
Question q37=new Question("Choose an alteranative that best fill the blanks:When do you expect to___in Mombasa?",
		"A:get",
		"B:go",
		"C:reach",
		"D:arrive",
		"D:arrive","The notes are currently unavailable for this question");
this.addQuestion(q37);
Question q38=new Question("Choose sentence that is correctly punctuated:",
		"A:\"That is a very hard working pupil,\"the teacher said.",
		"B:\"That is a very hard working pupil\",the teacher said.",
		"C:\"That is a very hard working pupil.\",\"the teacher said.",
		"D:\"That is a very hard working pupil.The teacher said.\"",
		"B:\"That is a very hard working pupil\",the teacher said.","The notes are currently unavailable for this question");
this.addQuestion(q38);
Question q39=new Question("Choose sentence that is correctly punctuated:",
		"A:What long hair you have!",
		"B:He went home early,Didn't he?",
		"C:Our science teachers sent us to look for grasshoppers flowers frogs and green leaves",
		"D:Its good to always drink clean water.",
		"A:What long hair you have!","The notes are currently unavailable for this question");
this.addQuestion(q39);
Question q40=new Question("The word \"fascinated\" is similar in meaning to?",
		"A:surprised",
		"B:excited",
		"C:amazed",
		"D:amused",
		"C:amazed",
		"Fascinate:To hold an intense interest or attraction for.To hold motionless; spellbind.");
this.addQuestion(q40);
Question q41=new Question("Which of the following can best replace the word \"furious\"?",
		"A:upset",
		"B:enraged",
		"C:annoyed",
		"D:irritated",
		"B:enraged",
		" Furious:Full of or characterized by extreme anger; raging.Suggestive of extreme anger in action or appearance; fierce.Full of activity; energetic or rapid:");
this.addQuestion(q41);
Question q42=new Question("Which of the following can best replace the word \"agressive\" in the text \"The aggresive campaign through advertisements\"",
		"A:tough",
		"B:strict",
		"C:offensive",
		"D:serious",
		"D:serious",
		"Agressive:assertive; vigorous,forceful, enterprising, assertive");
this.addQuestion(q42);
Question q43=new Question("Which of the following can best replace the word \"fatal\"?",
		"A:dangerous",
		"B:bad",
		"C:painful",
		"D:deadly",
		"D:deadly",
		"Fatal:causing or capable of causing death; mortal; deadly");
this.addQuestion(q43);
Question q44=new Question("Choose one that means the same as the word in capital:Nafula QUIT her job to go to America.",
		"Aabandoned:",
		"B:deserted",
		"C:ignored",
		"D:left",
		"D:left",
		"Quit:to stop, cease, or discontinue,to depart from; leave,to give up or resign; let go; relinquish");
this.addQuestion(q44);
Question q45=new Question("Choose one that means the same as the word in capital:He has been ACQUITTED for all the charges",
		"A:freed",
		"B:forgiven",
		"C:discharged",
		"D:released",
		"D:released",
		"Acqit:to relieve from a charge of fault or crime; declare not guilty:");
this.addQuestion(q45);
Question q46=new Question("t",
		"a",
		"b",
		"c",
		"d",
		"ans","The notes are currently unavailable for this question");
this.addQuestion(q46);





}
@Override
public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
// Drop older table if existed
db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST_ENG);
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
dbase.insert(TABLE_QUEST_ENG, null, values);	
}
public List<Question> getAllQuestions() {
List<Question> quesListEng= new ArrayList<Question>();
// Select All Query
String selectQuery = "SELECT * FROM " + TABLE_QUEST_ENG;
dbase=this.getReadableDatabase();
Cursor cursor = dbase.rawQuery(selectQuery, null);
// looping through all rows and adding to  list
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
quesListEng.add(quest);
} while (cursor.moveToNext());
}
// return quest list
return quesListEng;
}
public int rowcount()
{
int row=0;
String selectQuery = "SELECT * FROM " + TABLE_QUEST_ENG;
SQLiteDatabase db = this.getWritableDatabase();
Cursor cursor = db.rawQuery(selectQuery, null);
row=cursor.getCount();
return row;
}
}