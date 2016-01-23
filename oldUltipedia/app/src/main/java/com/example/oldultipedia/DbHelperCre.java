package com.example.oldultipedia;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DbHelperCre extends SQLiteOpenHelper {
private static final int DATABASE_VERSION = 1;
// Database Name
private static final String DATABASE_NAME = "CRE questions";
// tasks table name
private static final String TABLE_QUEST_CRE = "quest";
// tasks Table Columns names
private static final String KEY_ID = "id";
private static final String KEY_QUES = "question";
private static final String KEY_ANSWER = "answer"; //correct option
private static final String KEY_OPTA= "opta"; //option a
private static final String KEY_OPTB= "optb"; //option b
private static final String KEY_OPTC= "optc"; //option c
private static final String KEY_OPTD="optd";
private SQLiteDatabase dbase;
public DbHelperCre(Context context) {
super(context, DATABASE_NAME, null, DATABASE_VERSION);
}
@Override
public void onCreate(SQLiteDatabase db) {
dbase=db;
String sql3 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST_CRE + " ( "
+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
+ KEY_QUES+ " TEXT, "
+ KEY_ANSWER+ " TEXT, "
+KEY_OPTA +" TEXT, "
+KEY_OPTB +" TEXT, "
+KEY_OPTC+" TEXT, "
+KEY_OPTD +" TEXT )";
db.execSQL(sql3);	
addQuestions();
//db.close();
}
private void addQuestions()
{
	Question q1=new Question("Which one of the following duties was given to Adam and Eve when God created them?",
			"A:To obey the ten commandments",
			"B:To offer sacrifice to God",
			"C:To take care of other living things",
			"D:To obey the prophets of God",
			"C:To take care of other living things");
	this.addQuestion(q1);
	Question q2=new Question("God changed the name of Abram to Abraham mainly because he wanted to.",
			"A:make him a father of nations",
			"B:give him a new land",
			"C:make him rich",
			"D:give him protection",
			"A:make him a father of nations ");
	this.addQuestion(q2);
	Question q3=new Question("Joseph the son of Jacob was sold by his brothers because they:",
			"A:hoped to become rich",
			"B:were jealous",
			"C:needed food",
			"D:wanted to visit Egypt",
			"B:were jealous");
	this.addQuestion(q3);
	Question q4=new Question("Which one of the following qualities of God is shown on the night the Jews left Egypt?",
			"A:He is the creator",
			"B:He is forgiving",
			"C:He is a saviour",
			"D:He is Holy",
			"C:He is a saviour");
	this.addQuestion(q4);
	Question q5=new Question("Who among the following people asked God to forgive Israelites at Mount Sinai?",
			"A:Moses",
			"B:Josua",
			"C:Miriam",
			"D:Aaron",
			"A:Moses");
	this.addQuestion(q5);
Question q6=new Question("David annoyed God when he",
		"A:killed Goliath",
		"B:killed Uriah",
		"C:cried over the death of Saul",
		"D:married many women",
		"B:killed Uriah");
this.addQuestion(q6);
Question q7=new Question("'Give me the wisdom i need to rule your people with justice'(1 Kings 3:9).These words were spoken by King",
		"A:Ahaz",
		"B:Solomon",
		"C:Jeroboam",
		"D:Ahab",
		"B:Solomon");
this.addQuestion(q7);
Question q8=new Question("Who among the following prophets annointed Saul to be King of Israel?",
		"A:ELisha.",
		"B:Isaiah",
		"C:Nathan",
		"D:Samuel",
		"D:Samuel");
this.addQuestion(q8);
Question q9=new Question("The prophets of Baal were put to test by Elijah on Mount Carmel to show that?",
		"A:God answers prayers",
		"B:God is three in one",
		"C:Baal was asleep",
		"D:Baal was a coward",
		"A:God answers prayers");
this.addQuestion(q9);
Question q10=new Question("When Jesus was born the angel appeared to the shapherds to",
		"A:help them guard animals",
		"B:tell them the good news",
		"C:warn them about Herod",
		"D:guide them to Bethlehem",
		"B:tell them the good news");
this.addQuestion(q10);
Question q11=new Question("Didnt you know that i had to be in my fathers house?(Luke 2:49)'Wen did Jesus say these words",
		"A:When he was found by his parents in the temple",
		"B:When he chased the traders from the temple",
		"C:During his baptism by John",
		"D:During his trial before the high Preist",
		"A:When he was found by his parents in the temple");
this.addQuestion(q11);
Question q12=new Question("The temptation of Jesus in the desert teaches Christians that they should",
		"A:seek earthly riches",
		"B:run away from trials",
		"C:do the will of God",
		"D:look for food when hungry",
		"C:do the will of God");
this.addQuestion(q12);
Question q13=new Question("A miracle of Jesus which shows His power over nature is the",
		"A:healing of the paralysed man",
		"B:walking on water",
		"C:healing the blind man",
		"D:raising of Jarius's Daughter",
		"B:walking on water");
this.addQuestion(q13);
Question q14=new Question("Which of the following is the main reason Jesus mixed with sinners?",
		"A:He came from a poor family",
		"B:Sinners were hated by other people",
		"C:He came to save all people",
		"D:Sinners were friendly to him",
		"C:He came to save all people");
this.addQuestion(q14);
Question q15=new Question("Which one of the following actions of Mary and Martha best shows their love for their brother Lazarus",
		"A:Staying with tje mourners",
		"B:Showing Jesus Lazaru's grave",
		"C:Welcoming Jesus to their home",
		"D:Informing Jesus about Lazaru's sickness",
		"D:Informing Jesus about Lazaru's sickness");
this.addQuestion(q15);
Question q16=new Question("'This is my body ,Which is given for you'(Luke 22:19).These words were said by Jesus during the",
		"A:Last supper",
		"B:trial before pilate",
		"C:Crucifixion on the cross",
		"D:ascension into heaven",
		"A:Last supper");
this.addQuestion(q16);
Question q17=new Question("Who among the following helped Jesus to carry the cross?",
		"A:Joseph of Arimathea",
		"B:Simon of Cyrene",
		"C:Peter",
		"D:Nicodemus",
		"B:Simon of Cyrene");
this.addQuestion(q17);
Question q18=new Question("On the day of Pentecost the Holy Spirit came down in the form of:",
		"A:A cloud",
		"B:a dove",
		"C:Fire",
		"D:water",
		"C:Fire");
this.addQuestion(q18);
Question q19=new Question("Who among the folllowing people was the first Christian to be killed because of his faith?",
		"A:Philip",
		"B:Paul",
		"C:James",
		"D:Stephen",
		"D:Stephen");
this.addQuestion(q19);
Question q20=new Question("Which of the following beliefs about God is found in  both Christianity and traditional African Communities.",
		"A:God became man",
		"B:God raises the dead",
		"C:God is everywhere",
		"D:God is three in one",
		"C:God is everywhere");
this.addQuestion(q20);
Question q21=new Question("Which one of the following acts were performed by elders in traditional African communities during worship",
		"A:Sacrificing animals",
		"B:Reciting the creed",
		"C:Baptising members",
		"D:Serving the Holy Communion",
		"A:Sacrificing animals");
this.addQuestion(q21);
Question q22=new Question("Which one of the following is the best reason why people in traditional African communities were expected to marry.",
		"A:To be resopected",
		"B:To have a partner",
		"C:To have childern",
		"D:To be accepted",
		"C:To have childern");
this.addQuestion(q22);
Question q23=new Question("In  traditional African communities ancestors were respected mainly because they",
		"A:appeaed to the living in a dream",
		"B:united the living and the dead",
		"C:reminded people of the past",
		"D:were the dead relatives",
		"B:united the living and the dead");
this.addQuestion(q23);
Question q24=new Question("Who among the fololowing people is found in Christianity and Traditional African Communities?",
		"A:Herbalist",
		"B:Rainmaker",
		"C:Diviner",
		"D:Prophet",
		"D:Prophet");
this.addQuestion(q24);
Question q25=new Question("According to Christian teaching the greates fruit of the Holy Spirit is",
		"A:joy",
		"B:love",
		"C:Hope",
		"D:Faith",
		"B:love");
this.addQuestion(q25);
Question q26=new Question("Sarah is sent to buy a kilogram of sugar.The shopkeeper gives her more change.As a Christian,Sarah should?",
		"A:return it to the shop keeper",
		"B:Keep quiet about it",
		"C:use it to buy sweets",
		"D:take it home",
		"A:return it to the shop keeper");
this.addQuestion(q26);
Question q27=new Question("Your deskmate Dimon has told you that he is suffering from AIDS.As a Christian which one of the following is the best action to take?",
		"A:Repot the matter to the class teacher",
		"B:Change your sitting position",
		"C:Advise him to seek medical help",
		"D:Inform your classmates",
		"C:Advise him to seek medical help");
this.addQuestion(q27);
Question q28=new Question("Peter who is a rich man is thinking of how to use his extra money.As a Christian,what advice would you give him?",
		"A:Go for trips abroad",
		"B:Pay school fees  for orphans",
		"C:Build a bigger house for his family",
		"D:Buy a farm for his family",
		"B:Pay school fees  for orphans");
this.addQuestion(q28);
Question q29=new Question("Jane,a standard eight pupil has been asked by her class teacher to go to school on the day of worship.As a Christian the best advice you would give Jane is",
		"A:Obey the class teacher",
		"B:talk to the church leader",
		"C:transfer to another school",
		"D:go to church",
		"D:go to church");
this.addQuestion(q29);
Question q30=new Question("Which one of the following was the work of the early Christian missionaries in Kenya?",
		"A:Building schools",
		"B:Appointing Local rulers",
		"C:Setting boundaries for colonies",
		"D:Building Railways",
		"A:Building schools");
this.addQuestion(q30);
Question q31=new Question("Which one of the following is the main reason why God Created Eve?He wanted her to?",
		"A:look after the animals",
		"B:take care of the garden of Eden",
		"C:be a companion to Adam",
		"D:eat the fruits of the garden of Eden",
		"C:be a companion to Adam");
this.addQuestion(q31);
Question q32=new Question("Which one of the following is a lesson that Christians learn from the story of joseph in prison?",
		"A:God protects the innocent",
		"B:God forgives his people",
		"C:People should have dreams",
		"D:People should look after their parents",
		"A:God protects the innocent");
this.addQuestion(q32);
Question q33=new Question("God led the people of Israel  through the wildernes to the promised land by use of.",
		"A:fire and smoke",
		"B:fire and cloud",
		"C:wind and rainfall",
		"D:thunder and lightening",
		"B:fire and cloud");
this.addQuestion(q33);
Question q34=new Question("David is remembered as a great King of Israel because he..",
		"A:Killed Goliath",
		"B:married many wives",
		"C:Built palace for himself",
		"D:Killed wild animals",
		"A:Killed Goliath");
this.addQuestion(q34);
Question q35=new Question("Who among the following people was a priest when Samuel was called by God?",
		"A:Elikana",
		"B:Elijah",
		"C:Aaron",
		"D:Eli",
		"A:Elikana");
this.addQuestion(q35);
Question q36=new Question("Who among the following people visited baby Jesus?",
		"A:The Samaritans",
		"B:King Herod",
		"C:The Pharises",
		"D:The Shephereds",
		"D:The Shephereds");
this.addQuestion(q36);
Question q37=new Question("Who among the following people were in the temple when Jesus was dedicated to God?",
		"A:Zachariah and Elizabeth",
		"B:Simeone and Anna",
		"C:Ananias and Saphira",
		"D:Lazarus and Martha",
		"B:Simeone and Anna");
this.addQuestion(q37);
Question q38=new Question("Which one of the following parables of Jesus teaches about forgiveness?The parable of the:",
		"A:Sower",
		"B:Good samaritan",
		"C:Prodigal son",
		"D:Rich man and Lazarus",
		"C:Prodigal son");
this.addQuestion(q38);
Question q39=new Question("\"I promise you today you will be in paradise with me.\"(Luke 23:43)Jesus said these words when he was",
		"A:in the garden of Gesthsemane",
		"B:at the sea of Tiberias",
		"C:on the way to Emmaus",
		"D:on the cross",
		"D:on the cross");
this.addQuestion(q39);
Question q40=new Question("After the ressurection of Jesus for the Holy Spirit who would help them to.",
		"A:become wealthy",
		"B:conqueer the Roman Empire",
		"C:serve in the Jewish council",
		"D:preach good news",
		"D:preach good news");
this.addQuestion(q40);
Question q41=new Question("The resurrection of Jesus teaches Christians to be :",
		"A:tolerant",
		"B:obedient",
		"C:hopeful",
		"D:honest",
		"C:hopeful");
this.addQuestion(q41);
Question q42=new Question("Which one of the following is a reason why Stephen was stoned to death?He",
		"A:wanted to lead a rebelion",
		"B:refused to deny Jesus",
		"C:refused to pay taxes",
		"D:worked on the Sabath day",
		"B:refused to deny Jesus");
this.addQuestion(q42);
Question q43=new Question("Which one of the following New Testnent books is a gospel?",
		"A:Hebrews",
		"B:Galatians",
		"C:John",
		"D:James",
		"C:John");
this.addQuestion(q43);
Question q44=new Question("Three of the folowing ativities in the early Church demonstrated unity among the belivers.Which one does not?",
		"A:Meeting in the temple for worship ",
		"B:Helping the needy",
		"C:Breaaking of the bread",
		"D:Speaking in tongues",
		"D:Speaking in tongues");
this.addQuestion(q44);
Question q45=new Question("During worship offerings are given in both Christianity and Traditional African communities s a way of showing",
		"A:thanksgiving",
		"B:Mercy",
		"C:Patience",
		"D:Justice",
		"A:thanksgiving");
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
db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST_CRE);
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
dbase.insert(TABLE_QUEST_CRE, null, values);	
}
public List<Question> getAllQuestions() {
List<Question> quesList = new ArrayList<Question>();
// Select All Query
String selectQuery = "SELECT * FROM " + TABLE_QUEST_CRE;
dbase=this.getReadableDatabase();
Cursor cursor = dbase.rawQuery(selectQuery, null);
// looping through all rows and adding to list
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
quesList.add(quest);
} while (cursor.moveToNext());
}
// return quest list
return quesList;
}
public int rowcount()
{
int row=0;
String selectQuery = "SELECT * FROM " + TABLE_QUEST_CRE;
SQLiteDatabase db = this.getWritableDatabase();
Cursor cursor = db.rawQuery(selectQuery, null);
row=cursor.getCount();
return row;
}
}