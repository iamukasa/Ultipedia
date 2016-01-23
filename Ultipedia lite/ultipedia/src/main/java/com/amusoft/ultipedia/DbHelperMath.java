package com.amusoft.ultipedia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelperMath extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "Math questions";
    // tasks table name
    private static final String TABLE_QUEST_MATH = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA = "opta"; //option a
    private static final String KEY_OPTB = "optb"; //option b
    private static final String KEY_OPTC = "optc"; //option c
    private static final String KEY_OPTD = "optd";
    private static final String KEY_NOTE = "note";
    private SQLiteDatabase dbase;

    public DbHelperMath(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql3 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST_MATH + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_QUES + " TEXT, "
                + KEY_ANSWER + " TEXT, "
                + KEY_NOTE + " TEXT,"
                + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, "
                + KEY_OPTC + " TEXT, "
                + KEY_OPTD + " TEXT)";

        db.execSQL(sql3);
        addQuestions();
//db.close();
    }

    private void addQuestions() {
        Question q1 = new Question("Which one of the following is 3200104 in words",
                "A:Thirty two thousand one hundred and four",
                "B:Three milion two thousand one hundred and four",
                "C:Three hundred and twenty thousand one hundred and four",
                "D:Three million two hundred thousand one hundred and four",
                "D:Three million two hundred thousand one hundred and four",
                "The notes are currently unavailable for Math");
        this.addQuestion(q1);
        Question q2 = new Question("Which one of the following numbers has the smallest value?",
                "A:111010",
                "B:101101",
                "C:110110",
                "D:101011",
                "A:111010",
                "The notes are currently unavailable for Math");
        this.addQuestion(q2);
        Question q3 = new Question("A rectangular water tank is 6 meters long, 4meters wide and three meters high.How many litres of water does the tank hold when full",
                "A:72l",
                "B:7200l",
                "C:72000l",
                "D:72000000l",
                "D:72000000l",
                "The notes are currently unavailable for Math");
        this.addQuestion(q3);
        Question q4 = new Question("What is the number 29853 when rounded to the nearest thousand?",
                "A:29000",
                "B:29850",
                "C:29900",
                "D:30000",
                "D:30000",
                "The notes are currently unavailable for Math");
        this.addQuestion(q4);
        Question q5 = new Question("What is the place value of digit 5 in the number 1050067?",
                "A:Thousands",
                "B:Ten thousands",
                "C:Fifty thousands",
                "D:hundred thousands",
                "B:Ten thousands",
                "The notes are currently unavailable for Math");
        this.addQuestion(q5);
        Question q6 = new Question("What is the value of:(24(72-69)+6×4)/12",
                "A:8",
                "B:26",
                "C:30",
                "D:74",
                "A:8",
                "The notes are currently unavailable for Math");
        this.addQuestion(q6);
        Question q7 = new Question("What is the value of 8^2(9^2-3^2)/4^2×6^2?",
                "A:4",
                "B:8",
                "C:2",
                "D:2/3",
                "B:8",
                "The notes are currently unavailable for Math");
        this.addQuestion(q7);
        Question q8 = new Question("What is 23.1408 correct to three decimal places",
                "A:23.0",
                "B:23.1",
                "C:23.140",
                "D:23.141",
                "D:23.141",
                "The notes are currently unavailable for Math");
        this.addQuestion(q8);
        Question q9 = new Question("The marked price of a pair of shoewas sh.250.During a sale the price was reduced to sh.200.what was the percentage decreade in price",
                "A:80%",
                "B:50%",
                "C:25%",
                "D:20%",
                "D:20%",
                "The notes are currently unavailable for Math");
        this.addQuestion(q9);
        Question q10 = new Question("What is the L.C.M of 15,20 and 30?",
                "A:120",
                "B:60",
                "C:15",
                "D:5",
                "A:120",
                "The notes are currently unavailable for Math");
        this.addQuestion(q10);
        Question q11 = new Question("What is the ratio 3:5 expresed as a decimal?",
                "A:1.6",
                "B:0.625",
                "C:0.6",
                "D:0.375",
                "C:0.6",
                "The notes are currently unavailable for Math");
        this.addQuestion(q11);
        Question q12 = new Question("In the year 2000, Febuary 9th was a Saturday.What was March 6th the same year?",
                "A:Sunday",
                "B:Monday",
                "C:Tuesday",
                "D:Wednesday",
                "B:Monday", "The notes are currently unavailable for Math");
        this.addQuestion(q12);
        Question q13 = new Question("What is the value of 0.3×0.94+(0.304+0.123÷0.4)?",
                "A:1.3495",
                "B:1.7725",
                "C:0.8935",
                "D:0.6225",
                "C:0.8935", "The notes are currently unavailable for Math");
        this.addQuestion(q13);
        Question q14 = new Question("A box measuring 10cm by 6cm by 4cm were to be packed in a carton measuring 1.5 m by 0.4 m.How many boxes were needed to fill the carton",
                "A:25000",
                "B:2500",
                "C:250",
                "D:25",
                "B:2500", "The notes are currently unavailable for Math");
        this.addQuestion(q14);
        Question q15 = new Question("A cylinder which is open at one end has a radius of 6.3cm and a height of 25cm.What is the surface area of the cylinder in square centimeters(Take PII=22/7 )",
                "A:1114.74",
                "B:1239.48",
                "C:3118.50",
                "D:619.74",
                "A:1114.74", "The notes are currently unavailable for Math");
        this.addQuestion(q15);
        Question q16 = new Question("A cuboid measures 6 cm long,5 cm wide and 4 cm high.What is the total length of the edges in cm",
                "A:30",
                "B:60",
                "C:90",
                "D:120",
                "B:60", "The notes are currently unavailable for Math");
        this.addQuestion(q16);
        Question q17 = new Question("The price of a radio was reduced by sh.630.This represents a 30% discount.What wa the price of the radio after the discount",
                "A:sh. 441",
                "B:sh.1470",
                "C:sh.2100",
                "D:sh.2730",
                "B:sh.1470", "The notes are currently unavailable for Math");
        this.addQuestion(q17);
        Question q18 = new Question("What is the next number in the sequence 7,16,32,57",
                "A:93",
                "B:89",
                "C:82",
                "D:63",
                "A:93", "The notes are currently unavailable for Math");
        this.addQuestion(q18);
        Question q19 = new Question("What is the value of x in the equation 2(x-6)/3=2/3",
                "A:7 2/3",
                "B:7",
                "C:2 2/3",
                "D:4",
                "B:7", "The notes are currently unavailable for Math");
        this.addQuestion(q19);
        Question q20 = new Question("In 1998,Wanja harvested 4676 bags of maize.This was 168 bags more than those harvested in 1997,How many bags did she harvest in 1997?",
                "A:177",
                "B:513",
                "C:4508",
                "D:5021",
                "C:4508", "The notes are currently unavailable for Math");
        this.addQuestion(q20);
        Question q21 = new Question("A motorist left home at 10.00 am and travelled to Nairobi, a distance of 225 km.He travelled at an average speed of 90 km/hr.At What time did he reach Nairobi)",
                "A:12.30 p.m",
                "B:12.50 p.m",
                "C:2.30 p.m",
                "D:12.30 a.m",
                "A:12.30 p.m", "The notes are currently unavailable for Math");
        this.addQuestion(q21);
        Question q22 = new Question("Onacha spent 1/9 of his salary on food,3/4 of the remainder on school fees and therest for leisure.if is salary was sh 5400.How much did he spend on leisure",
                "A:sh.4200",
                "B:sh.1800",
                "C:sh.1200",
                "D:sh.750",
                "C:sh.1200", "The notes are currently unavailable for Math");
        this.addQuestion(q22);
        Question q23 = new Question("Kirwa used a ladder to paint the top of a wall.He placed the bottom of the ladder 4 1/2 meters way from the wall.The ladder touched the wall at a height of 6 meters.What was the length of the ladder",
                "A:7 1/2m",
                "B:10 1/2m",
                "C:15 m",
                "D:56 1/4m",
                "A:7 1/2m", "The notes are currently unavailable for Math");
        this.addQuestion(q23);
        Question q24 = new Question("The cash price of a bed is sh.11 700 .The hire purchase price is 20% more than the cash price.Mbugua bought a bed on hire purchase terms.He paid a deposit of sh.2808 and 12 equal monthly installments.How much was each monthly installment",
                "A:sh.1404",
                "B:sh.1170",
                "C:sh.936",
                "D:sh.546",
                "C:sh.936", "The notes are currently unavailable for Math");
        this.addQuestion(q24);
        Question q25 = new Question("A plane left nairobi at 23 50 hr on Monday and took 1hr 45 minutes to reach Mombasa where it stopped for 50 minutes.It then left Mombasa and took 40 minutes to reach Zanzibar.As what time in am/pm sytem did the plane reach Zanzibar?",
                "A:2.25 a.m.",
                "B:3.05 a.m.",
                "C:2.15 p.m.",
                "D:3.05 p.m",
                "B:3.05 a.m", "The notes are currently unavailable for Math");
        ;
        this.addQuestion(q25);
        Question q26 = new Question("what is the value of  m+r^2/p+r  given m=2p,p=n+5,n=3r,r=5",
                "A: 2 1/5",
                "B:2 3/5",
                "C:3 1/4",
                "D:2",
                "C:3 1/4", "The notes are currently unavailable for Math");
        this.addQuestion(q26);
        Question q27 = new Question("A rectangular field measuring 560m by 800m is to be represented on a scale drawing using the scale 1:20000.what is the area of the scale drawing in centimeters?",
                "A:1120",
                "B:22.4",
                "C:11.2",
                "D:2240",
                "C:11.2", "The notes are currently unavailable for Math");
        this.addQuestion(q27);
        Question q28 = new Question("A teacher measured the heights of his nine pupils in his class.The heights of the pupils were 167cm,170cm,167cm,175cm,170cm,172cm,167cm,168cm.The total height of the eight pupills was 1356 cm.If the mean height of the nine pupils was 169 cm,what was the median height",
                "A:170cm",
                "B:168cm",
                "C:167 cm",
                "D:165 cm",
                "B:168cm", "The notes are currently unavailable for Math");
        this.addQuestion(q28);
        Question q29 = new Question("A fundraising meeting for Jako,Kabula ,Masindu and Buko rasied sh.108,000 .Jako got three times as much as Buko.Masindu got two-thirds of Jako's share while Kabula got half as much as Jako.How much did Kabula receive?",
                "A:sh.43 200",
                "B:sh.28 800",
                "C:sh.21 600",
                "D:sh.14 400",
                "D:sh.14 400", "The notes are currently unavailable for Math");
        this.addQuestion(q29);
        Question q30 = new Question("A sales person earns a salary of sh.2000 plus a 5% commission on sales above sh 10,1000.In one month the sales person sold goods worth sh.25000.How much money did the sales person receive that month?",
                "A:sh.3250",
                "B:sh.2750",
                "C:sh.2500",
                "D:sh.750",
                "B:sh.2750", "The notes are currently unavailable for Math");
        this.addQuestion(q30);
        Question q31 = new Question("What is the expression 7(x+4y+2)+5(2x-y+3)",
                "A:17x+23y+29",
                "B:3x+3y+29",
                "C:17x+3y+5",
                "D:9x+27y+17",
                "A:17x+23y+29", "The notes are currently unavailable for Math");
        this.addQuestion(q31);
        Question q32 = new Question("Oduour invested a certain amount of money in a business that paid simple interest at the rate of 15% per annum.At the end of nine months he withdrew sh 1125 which was the interest the money had earned.How much money had he invested",
                "A:5p-60",
                "B:3p-27",
                "C:5p+60",
                "D:5p-30",
                "A:5p-60", "The notes are currently unavailable for Math");
        this.addQuestion(q32);
        Question q33 = new Question("Which of the following is 5505055 in words?",
                "A:Five million ,fifty five thousand nad fifty five",
                "B:Five million,five hundred thousand,five hundred and fifty five",
                "C:Five million five,hundred and five thousand and fifty five.",
                "D:Five million,five hhundred and fifty thousand,and fifty five",
                "C:Five million five,hundred and five thousand and fifty five.", "The notes are currently unavailable for Math");
        this.addQuestion(q33);
        Question q34 = new Question("A rectangular plot measuring 46m by 38 m is to be fenced all round .If three strands of wire are to be used,what would be the total length of the wire required in meters?",
                "A:168",
                "B:252",
                "C:504",
                "D:5244",
                "C:504", "The notes are currently unavailable for Math");
        this.addQuestion(q34);
        Question q35 = new Question("An empty box weighed 2.5 kg.Kombe packed books in the box until the total weight was 9.5 kg.If each book weighed 250 g,how many books were packed?",
                "A:10",
                "B:28",
                "C:38",
                "D:280",
                "B:28", "The notes are currently unavailable for Math");
        this.addQuestion(q35);
        Question q36 = new Question("Maria agreed to loan Luvisha sh 10,000 at a opmound intrest of 15% per annum.How Much money altogether did Luvuisia had to pay",
                "A:sh 13225",
                "B:sh 13000",
                "C:sh 11500",
                "D:sh 3225",
                "A:sh 13225", "The notes are currently unavailable for Math");
        this.addQuestion(q36);
        Question q37 = new Question("A motorist covers 3 km in every 1 3/4 minutes.How many kilometers will he have covered from 8.19 am to 9.08 am?",
                "A:2.8",
                "B:8.4",
                "C:1.47",
                "D:1.4",
                "D:1.4", "The notes are currently unavailable for Math");
        this.addQuestion(q37);
        Question q38 = new Question("What is the value of 5.0-2.65×0.001?",
                "A:4.999735",
                "B:4.99735",
                "C:4.9735",
                "D:0.00235",
                "B:4.99735", "The notes are currently unavailable for Math");
        this.addQuestion(q38);
        Question q39 = new Question("The cylinder has a volume of 550 cm3.if the geight of the cylinder is 7cm,what is its diameter?(Take pi=22/7) ",
                "A:50 cm",
                "B:25 cm",
                "C:10 cm",
                "D:5 cm",
                "C:10 cm", "The notes are currently unavailable for Math");
        this.addQuestion(q39);
        Question q40 = new Question("Twenty-four-5 deciliter packets of milk were emptied into a 50-litre container.How many more such packets of milk were needed to fill the cointainer?",
                "A:100",
                "B:76",
                "C:52",
                "D:38",
                "B:76", "The notes are currently unavailable for Math");
        this.addQuestion(q40);
        Question q41 = new Question("The top of a 25m ladder leans on a vertical wall with its lowerend touching the ground.Which one of the following sets of measurements represents te height of the wall and the horizontal distance of the ladder from the wall?",
                "A:12 m and 13 m",
                "B:3 m and 4 m",
                "C:5 m and 12 m",
                "D:7m and 24 m",
                "D:7m and 24 m", "The notes are currently unavailable for Math");
        this.addQuestion(q41);
        Question q42 = new Question("Kazungu bought a radio on hire purchase terms.He paid a deposit a deposit of sh 900 and 9 equal monthly instalments of sh 300.The hire purchase price was 20% more than the marked price.What was the marked price of the radio?",
                "A:sh 720",
                "B:sh 2880",
                "C:sh 3000",
                "D:sh 3600",
                "C:sh 3000", "The notes are currently unavailable for Math");
        this.addQuestion(q42);
        Question q43 = new Question("The length of a rectangle is represented by the expression (2x+8)cm and its width by the expression(x-6)cm . if the perimeter is 58 cm,what is the actual length of the rectangle? ",
                "A:3 cm",
                "B:9 cm",
                "C:26 cm",
                "D:45 1/3 cm",
                "C:26 cm", "The notes are currently unavailable for Math");
        this.addQuestion(q43);
        Question q44 = new Question("Cheptoo was hired for 8 hours a day from Monday to Friday and 5 hours on Saturrday.She was paid sh 5850 per week.Cheptoo now works 10 hours a day from Monday and is free on Saturday.What is her weekly pay if she is paid at the same rate per hour as before? ",
                "A:sh 4500",
                "B:sh 5265",
                "C:sh 5300",
                "D:sh 6500",
                "D:sh 6500", "The notes are currently unavailable for Math");
        this.addQuestion(q44);
        Question q45 = new Question("What is the value of 21÷8 correct to two decimal places?",
                "A:2.6",
                "B:2.62",
                "C:2.625",
                "D:2.63",
                "D:2.63", "The notes are currently unavailable for Math");
        this.addQuestion(q45);
        Question q46 = new Question("t",
                "a",
                "b",
                "c",
                "d",
                "ans", "The notes are currently unavailable for Math");
        this.addQuestion(q46);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST_MATH);
// Create tables again
        onCreate(db);
    }

    // Adding new question
    public void addQuestion(Question quest) {
//SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_NOTE, quest.getNOTE());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_OPTD, quest.getOPTD());

// Inserting Row
        dbase.insert(TABLE_QUEST_MATH, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> quesListMath = new ArrayList<Question>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_QUEST_MATH;
        dbase = this.getReadableDatabase();
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
                quesListMath.add(quest);
            } while (cursor.moveToNext());
        }
// return quest list
        return quesListMath;
    }

    public int rowcount() {
        int row = 0;
        String selectQuery = "SELECT * FROM " + TABLE_QUEST_MATH;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row = cursor.getCount();
        return row;
    }
}