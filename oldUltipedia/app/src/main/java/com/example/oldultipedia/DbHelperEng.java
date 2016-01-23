package com.example.oldultipedia;
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
+ KEY_ANSWER+ " TEXT, "
+KEY_OPTA +" TEXT, "
+KEY_OPTB +" TEXT, "
+KEY_OPTC+" TEXT, "
+KEY_OPTD +" TEXT )";
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
		"C:requires");
this.addQuestion(q1);
Question q2=new Question("Choose one that means the same as the word in Capital:He SELDOM Comes Here",
		"A:regurlarly",
		"B:rarely",
		"C:always",
		"D:sometimes",
		"B:rarely");
this.addQuestion(q2);
Question q3=new Question("Choose one that means the same as the word in Capital:The INITIAL plan was the best",
		"A:earlier",
		"B:former",
		"C:starting",
		"D:original",
		"D:original");
this.addQuestion(q3);
Question q4=new Question("Which of the following is correctly punctuated:",
		"A:Subira inquired Fred,\"how many cackes do you need?\"",
		"B:\"Subira,\" inquired Fred,\"how many cackes do you need?\"",
		"C:Subira,inquired Fred,\"how many cackes do you need?\"",
		"D:\"Subira inquired Fred,\"how many cackes do you need?",
		"A:Subira inquired Fred,\"how many cackes do you need?\"");
this.addQuestion(q4);
Question q5=new Question("Which of the following is correctly punctuated:",
		"A:How interesting the day was?",
		"B:How interesting the day was.",
		"C:How interesting the day was!",
		"D:How interesting the day was!?",
		"C:How interesting the day was!");
this.addQuestion(q5);
Question q6=new Question("Which alternative Best completes the sentences:I offered him a job but he___",
		"A:turned it away",
		"B:turned it down",
		"C:turned it back",
		"D:turned it off",
		"B:turned it down");
this.addQuestion(q6);
Question q7=new Question("Which alternative Best completes the sentences:After yesterday's perfomance they should be____",
		"A:ashamed for themselves",
		"B:ashamed with themselves",
		"C:ashamed at themselves",
		"D:ashamed of themselves",
		"D:ashamed of themselves");
this.addQuestion(q7);
Question q8=new Question("Which alternative Best completes the sentences:She has a_____bag",
		"A:small beautiful expensive",
		"B: beautiful small expensive",
		"C:small expensive  beautiful",
		"D: beautiful expensive small",
		"A:small beautiful expensive");
this.addQuestion(q8);
Question q9=new Question("Choose one that best completes the sentence:The Mutukus are so kind...",
		"A:because they always help people.",
		"B:as they always help people",
		"C:that they always help people",
		"D:since they always help people",
		"A:because they always help people.");
this.addQuestion(q9);
Question q10=new Question("Fights were PROHIBITED means they were",
		"A:stopped",
		"B:discouraged",
		"C:forbidden",
		"D:refused",
		"C:forbidden");
this.addQuestion(q10);
Question q11=new Question("Which of the following words is closest in meaning to 'crumpled'",
		"A:Folded",
		"B:Wrinkled",
		"C:Pleated",
		"D:Squeezed",
		"B:Wrinkled");
this.addQuestion(q11);
Question q12=new Question("The term \"common knowledge\" means the same as",
		"A:easy to get",
		"B:widely known",
		"C:for everybody",
		"D:found everywhere",
		"B:widely know");
this.addQuestion(q12);
Question q13=new Question("Choose the word that least fits the group",
		"A:cutlery",
		"B:crockery",
		"C:bedding",
		"D:shirts",
		"D:shirts");
this.addQuestion(q13);
Question q14=new Question("Choose the word that least fits the group",
		"A:glance",
		"B:gaze",
		"C:stare",
		"D:glare",
		"D:glare");
this.addQuestion(q14);
Question q15=new Question("Choose the word that least fits the group",
		"A:grab",
		"B:hold",
		"C:touch",
		"D:seize",
		"C:touch");
this.addQuestion(q15);
Question q16=new Question("Choose the best alternative which best to complete the statement:Only after everyone has paid the fare..",
		"A:the bus will leave",
		"B:then the bus will leave",
		"C:and the bus will leave",
		"D:will the bus leave",
		"D:will the bus leave");
this.addQuestion(q16);
Question q17=new Question("Choose the best alternative which best to complete the statement:Musa asked her..",
		"A:where are you going",
		"B:where was she going",
		"C:where she was going",
		"D:where she is going",
		"C:where she was going");
this.addQuestion(q17);
Question q18=new Question("Which sentence is punctuated correctly:",
		"A:You don't believe that.Do you?",
		"B:I don't like it's colour.",
		"C:Jane Said,\"The young man is my brother.\" ",
		"D:She is asking whether you are hungry?",
		"B:I don't like it's colour.");
this.addQuestion(q18);
Question q19=new Question("Which sentence is punctuated correctly:",
		"A:Your's was accepted",
		"B:\"Do you like travelling ?\"She asked.",
		"C:Ipu bought the following items:sugar,flour,bread and honey.",
		"D:what a surprise?",
		"B:\"Do you like travelling ?\"She asked.");
this.addQuestion(q19);
Question q20=new Question("The expression\"in quick succesion means\"",
		"A:Many events were quickly witnessed",
		"B:The rhythm of life changed suddenly",
		"C:an event taking place before another ends",
		"D:things happening rapidly one after another",
		"D:things happening rapidly one after another");
this.addQuestion(q20);
Question q21=new Question("Choose an alteranative that best fill the blanks:Kemboi chose to walk to the mmarket_____it was very hot",
		"A:because",
		"B:but",
		"C:while",
		"D:though",
		"D:though");
this.addQuestion(q21);
Question q22=new Question("Choose an alteranative that best fill the blanks:\"Come first December this year my sister_______two years old\"",
		"A:shall be",
		"B:will be",
		"C:could be",
		"D:should be",
		"B:will be");
this.addQuestion(q22);
Question q23=new Question("Choose an alteranative that best fill the blanks:The teacher was very_____with the pupils who had not done their homework.",
		"A:sad",
		"B:annoyed",
		"C:disturbed",
		"D:sorry",
		"B:annoyed");
this.addQuestion(q23);
Question q24=new Question("Choose one that means the same as the words in Capital:Neri works very hard IN SPITE OF THE FACT she is very old.",
		"A:although",
		"B:but",
		"C:moreover",
		"D:despite",
		"A:although");
this.addQuestion(q24);
Question q25=new Question("Choose one that means the same as the words in Capital:Wanyama wanted to MAKE UP FOR the time he had lost.",
		"A:create",
		"B:restore",
		"C:replace",
		"D:recover",
		"D:recover");
this.addQuestion(q25);
Question q26=new Question("Choose one that means the same as the words in Capital:Abdi was in a hurry to  WIND UP the meeting",
		"A:postpone",
		"B:end",
		"C:leave",
		"D:stop",
		"B:end");
this.addQuestion(q26);
Question q27=new Question("Which means the same as the sentence:Had it not been for the quick response of the ambulance team,the patient would not have survived.",
		"A:The ambulance team responded quickly and the patient survived",
		"B:If the ambulance team had responded quickly the patients would have survived ",
		"C:Because the ambulance team responded quickly the patient survived",
		"D:if the ambulance team responded quickly the patient would not have survived", 
		"C:Because the ambulance team responded quickly the patient survived");
this.addQuestion(q27);
Question q28=new Question("Which means the same as the sentence:In a court of law people who have broken the law without knowing it still get punished for the offence.",
		"A:people get punished in acourt of law only for breaking the law deliberately",
		"B:Whether people break the law or not they are punished in a court of law.",
		"C:People get punished in a court of law whether or not,they were aware of the law they broke",
		"D:people who get punished in a court of law neither have broken a law nor they aware of it",
		"C:People get punished in a court of law whether or not,they were aware of the law they broke");
this.addQuestion(q28);
Question q29=new Question("The word\"feeble \" means the same as",
		"A:dying",
		"B:soft",
		"C:weak",
		"D:slow",
		"C:weak");
this.addQuestion(q29);
Question q30=new Question("The meaning of the word\"Derived\" as used in \"Spices can be classed from the plat which their are derived \"  is? ",
		"A:found",
		"B:removed",
		"C:btained",
		"D:Produced",
		"B:removed");
this.addQuestion(q30);
Question q31=new Question("Choose one that best completes the sentence:They have been forbidden.....",
		"A:to go to town?",
		"B:from going to town?",
		"C::not to go to town?",
		"D:no going to town?",
		"B:from going to town?");
this.addQuestion(q31);
Question q32=new Question("Choose one that best completes the sentence:Would you have done that job if you",
		"A:had been paid well?",
		"B:were paid well?",
		"C:could have been paid well?",
		"D:would be paid well",
		"A:had been paid well?");
this.addQuestion(q32);
Question q33=new Question("Choose one that means the same as the word in capital:Most fresh flowers have a delightful FRAGRANCE. ",
		"A:aroma",
		"B:scent",
		"C:smell",
		"d:odour",
		"B:scent");
this.addQuestion(q33);
Question q34=new Question("Choose one that means the same as the word in capital:Children should not WANDER in the streets.",
		"A:walk",
		"B:stroll",
		"C:loiter",
		"D:roam",
		"C:loiter");
this.addQuestion(q34);
Question q35=new Question("Choose one that means the same as the word in capital:She DESERVED that reward.",
		"A:got",
		"B:won",
		"C:carned",
		"D:gained",
		"B:won");
this.addQuestion(q35);
Question q36=new Question("Choose an alteranative that best fill the blanks:Since Rehema could not get a matatu she travelled home______a bus",
		"A:by",
		"B:on",
		"C:in",
		"D:with",
		"A:by");
this.addQuestion(q36);
Question q37=new Question("Choose an alteranative that best fill the blanks:When do you expect to___in Mombasa?",
		"A:get",
		"B:go",
		"C:reach",
		"D:arrive",
		"D:arrive");
this.addQuestion(q37);
Question q38=new Question("Choose sentence that is correctly punctuated:",
		"A:\"That is a very hard working pupil,\"the teacher said.",
		"B:\"That is a very hard working pupil\",the teacher said.",
		"C:\"That is a very hard working pupil.\",\"the teacher said.",
		"D:\"That is a very hard working pupil.The teacher said.\"",
		"B:\"That is a very hard working pupil\",the teacher said.");
this.addQuestion(q38);
Question q39=new Question("Choose sentence that is correctly punctuated:",
		"A:What long hair you have!",
		"B:He went home early,Didn't he?",
		"C:Our science teachers sent us to look for grasshoppers flowers frogs and green leaves",
		"D:Its good to always drink clean water.",
		"A:What long hair you have!");
this.addQuestion(q39);
Question q40=new Question("The word \"fascinated\" is similar in meaning to?",
		"A:surprised",
		"B:excited",
		"C:amazed",
		"D:amused",
		"C:amazed");
this.addQuestion(q40);
Question q41=new Question("Which of the following can best replace the word \"furious\"?",
		"A:upset",
		"B:enraged",
		"C:annoyed",
		"D:irritated",
		"B:enraged");
this.addQuestion(q41);
Question q42=new Question("Which of the following can best replace the word \"agressive\" in the text \"The aggresive campaign through advertisements\"",
		"A:tough",
		"B:strict",
		"C:offensive",
		"D:serious",
		"D:serious");
this.addQuestion(q42);
Question q43=new Question("Which of the following can best replace the word \"fatal\"?",
		"A:dangerous",
		"B:bad",
		"C:painful",
		"D:deadly",
		"D:deadly");
this.addQuestion(q43);
Question q44=new Question("Choose one that means the same as the word in capital:Nafula QUIT her job to go to America.",
		"Aabandoned:",
		"B:deserted",
		"C:ignored",
		"D:left",
		"D:left");
this.addQuestion(q44);
Question q45=new Question("Choose one that means the same as the word in capital:He has been ACQUITTED for all the charges",
		"A:freed",
		"B:forgiven",
		"C:discharged",
		"D:released",
		"D:released");
this.addQuestion(q45);
Question q46=new Question("t",
		"a",
		"b",
		"c",
		"d",
		"ans");
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
quest.setOPTA(cursor.getString(3));
quest.setOPTB(cursor.getString(4));
quest.setOPTC(cursor.getString(5));
quest.setOPTD(cursor.getString(6));
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