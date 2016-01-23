package com.amusoft.ultipedia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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
    private static final String KEY_OPTA = "opta"; //option a
    private static final String KEY_OPTB = "optb"; //option b
    private static final String KEY_OPTC = "optc"; //option c
    private static final String KEY_OPTD = "optd";
    private static final String KEY_NOTE = "note";
    private SQLiteDatabase dbase;

    public DbHelperCre(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql3 = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST_CRE + " ( "
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
        Question q1 = new Question("Which one of the following duties was given to Adam and Eve when God created them?",
                "A:To obey the ten commandments",
                "B:To offer sacrifice to God",
                "C:To take care of other living things",
                "D:To obey the prophets of God",
                "C:To take care of other living things",
                "Genesis 1:19 And out of the ground the Lord God formed every beast of the field, and every fowl of the air; and brought them unto Adam to see what he would call them: and whatsoever Adam called every living creature, that was the name thereof.");
        this.addQuestion(q1);
        Question q2 = new Question("God changed the name of Abram to Abraham mainly because he wanted to.",
                "A:make him a father of nations",
                "B:give him a new land",
                "C:make him rich",
                "D:give him protection",
                "A:make him a father of nations ",
                "Genesis 17:4-6 As for me, behold, my covenant is with thee, and thou shalt be a father of many nations.Neither shall thy name any more be called Abram, but thy name shall be Abraham; for a father of many nations have I made thee.And I will make thee exceeding fruitful, and I will make nations of thee, and kings shall come out of thee.");
        this.addQuestion(q2);
        Question q3 = new Question("Joseph the son of Jacob was sold by his brothers because they:",
                "A:hoped to become rich",
                "B:were jealous",
                "C:needed food",
                "D:wanted to visit Egypt",
                "B:were jealous",
                "Genesis 37:4-5 Now Israel loved Joseph more than all his children, because he was the son of his old age: and he made him a coat of many colours. And when his brethren saw that their father loved him more than all his brethren, they hated him, and could not speak peaceably unto him.");
        this.addQuestion(q3);
        Question q4 = new Question("Which one of the following qualities of God is shown on the night the Jews left Egypt?",
                "A:He is the creator",
                "B:He is forgiving",
                "C:He is a saviour",
                "D:He is Holy",
                "C:He is a saviour",
                "Exodus 12:74 For the Lord will pass through to smite the Egyptians; and when he seeth the blood upon the lintel, and on the two side posts, the Lord will pass over the door, and will not suffer the destroyer to come in unto your houses to smite you. Exodus 12:50-51 Thus did all the children of Israel; as the Lord commanded Moses and Aaron, so did they.And it came to pass the selfsame day, that the Lord did bring the children of Israel out of the land of Egypt by their armies.");
        this.addQuestion(q4);
        Question q5 = new Question("Who among the following people asked God to forgive Israelites at Mount Sinai?",
                "A:Moses",
                "B:Josua",
                "C:Miriam",
                "D:Aaron",
                "A:Moses",
                "Exodus 32:31-32 And Moses returned unto the Lord, and said, Oh, this people have sinned a great sin, and have made them gods of gold.Yet now, if thou wilt forgive their sin�; and if not, blot me, I pray thee, out of thy book which thou hast written.");
        this.addQuestion(q5);
        Question q6 = new Question("David annoyed God when he",
                "A:killed Goliath",
                "B:killed Uriah",
                "C:cried over the death of Saul",
                "D:married many women",
                "B:killed Uriah",
                "2 Samuel 12:9 Wherefore hast thou despised the commandment of the Lord, to do evil in his sight? thou hast killed Uriah the Hittite with the sword, and hast taken his wife to be thy wife, and hast slain him with the sword of the children of Ammon.");
        this.addQuestion(q6);
        Question q7 = new Question("'Give me the wisdom i need to rule your people with justice'(1 Kings 3:9).These words were spoken by King",
                "A:Ahaz",
                "B:Solomon",
                "C:Jeroboam",
                "D:Ahab",
                "B:Solomon",
                "1 Kings 3:10 And the speech pleased the Lord, that Solomon had asked this thing.");
        this.addQuestion(q7);
        Question q8 = new Question("Who among the following prophets annointed Saul to be King of Israel?",
                "A:ELisha.",
                "B:Isaiah",
                "C:Nathan",
                "D:Samuel",
                "D:Samuel",
                "1 Samuel 10:1 Then Samuel took a vial of oil, and poured it upon his head, and kissed him, and said, Is it not because the Lord hath anointed thee to be captain over his inheritance?");
        this.addQuestion(q8);
        Question q9 = new Question("The prophets of Baal were put to test by Elijah on Mount Carmel to show that?",
                "A:God answers prayers",
                "B:God is three in one",
                "C:Baal was asleep",
                "D:Baal was a coward",
                "A:God answers prayers",
                "1 Kings 18:37-38 Hear me, O Lord, hear me, that this people may know that thou art the Lord God, and that thou hast turned their heart back again.Then the fire of the Lord fell, and consumed the burnt sacrifice, and the wood, and the stones, and the dust, and licked up the water that was in the trench.");
        this.addQuestion(q9);
        Question q10 = new Question("When Jesus was born the angel appeared to the shapherds to",
                "A:help them guard animals",
                "B:tell them the good news",
                "C:warn them about Herod",
                "D:guide them to Bethlehem",
                "B:tell them the good news",
                "Luke 2:8-10 And there were in the same country shepherds abiding in the field, keeping watch over their flock by night.And, lo, the angel of the Lord came upon them, and the glory of the Lord shone round about them: and they were sore afraid.And the angel said unto them, Fear not: for, behold, I bring you good tidings of great joy, which shall be to all people.");
        this.addQuestion(q10);
        Question q11 = new Question("Didnt you know that i had to be in my fathers house?(Luke 2:49)'When did Jesus say these words",
                "A:When he was found by his parents in the temple",
                "B:When he chased the traders from the temple",
                "C:During his baptism by John",
                "D:During his trial before the high Preist",
                "A:When he was found by his parents in the temple",
                "Luke 2:46-47 And it came to pass, that after three days they found him in the temple, sitting in the midst of the doctors, both hearing them, and asking them questions.And all that heard him were astonished at his understanding and answers.");
        this.addQuestion(q11);
        Question q12 = new Question("The temptation of Jesus in the desert teaches Christians that they should",
                "A:seek earthly riches",
                "B:run away from trials",
                "C:do the will of God",
                "D:look for food when hungry",
                "C:do the will of God",
                "Luke 4:4 And Jesus answered him, saying, It is written, That man shall not live by bread alone, but by every word of God.");
        this.addQuestion(q12);
        Question q13 = new Question("A miracle of Jesus which shows His power over nature is the",
                "A:healing of the paralysed man",
                "B:walking on water",
                "C:healing the blind man",
                "D:raising of Jarius's Daughter",
                "B:walking on water",
                "Mathew 14:25-28  And in the fourth watch of the night Jesus went unto them, walking on the sea.And when the disciples saw him walking on the sea, they were troubled, saying, It is a spirit; and they cried out for fear.But straightway Jesus spake unto them, saying, Be of good cheer; it is I; be not afraid. And Peter answered him and said, Lord, if it be thou, bid me come unto thee on the water.");
        this.addQuestion(q13);
        Question q14 = new Question("Which of the following is the main reason Jesus mixed with sinners?",
                "A:He came from a poor family",
                "B:Sinners were hated by other people",
                "C:He came to save all people",
                "D:Sinners were friendly to him",
                "C:He came to save all people",
                "Matthew 18:11-12 For the Son of man is come to save that which was lost.How think ye? if a man have an hundred sheep, and one of them be gone astray, doth he not leave the ninety and nine, and goeth into the mountains, and seeketh that which is gone astray?");
        this.addQuestion(q14);
        Question q15 = new Question("Which one of the following actions of Mary and Martha best shows their love for their brother Lazarus",
                "A:Staying with the mourners",
                "B:Showing Jesus Lazaru's grave",
                "C:Welcoming Jesus to their home",
                "D:Informing Jesus about Lazaru's sickness",
                "D:Informing Jesus about Lazaru's sickness",
                "John 11:1-3 Now a certain man was sick, named Lazarus, of Bethany, the town of Mary and her sister Martha.(It was that Mary which anointed the Lord with ointment, and wiped his feet with her hair, whose brother Lazarus was sick.)Therefore his sisters sent unto him, saying, Lord, behold, he whom thou lovest is sick.");
        this.addQuestion(q15);
        Question q16 = new Question("'This is my body ,Which is given for you'(Luke 22:19).These words were said by Jesus during the",
                "A:Last supper",
                "B:trial before pilate",
                "C:Crucifixion on the cross",
                "D:ascension into heaven",
                "A:Last supper",
                "Luke 22:7-8 Then came the day of unleavened bread, when the passover must be killed. And he sent Peter and John, saying, Go and prepare us the passover, that we may eat.");
        this.addQuestion(q16);
        Question q17 = new Question("Who among the following helped Jesus to carry the cross?",
                "A:Joseph of Arimathea",
                "B:Simon of Cyrene",
                "C:Peter",
                "D:Nicodemus",
                "B:Simon of Cyrene",
                " Matthew 27:32 And as they came out, they found a man of Cyrene, Simon by name: him they compelled to bear his cross.");
        this.addQuestion(q17);
        Question q18 = new Question("On the day of Pentecost the Holy Spirit came down in the form of:",
                "A:A cloud",
                "B:a dove",
                "C:Fire",
                "D:water",
                "C:Fire",
                "Acts 2:3-4 And there appeared unto them cloven tongues like as of fire, and it sat upon each of them.And they were all filled with the Holy Ghost, and began to speak with other tongues, as the Spirit gave them utterance.");
        this.addQuestion(q18);
        Question q19 = new Question("Who among the folllowing people was the first Christian to be killed because of his faith?",
                "A:Philip",
                "B:Paul",
                "C:James",
                "D:Stephen",
                "D:Stephen",
                "Acts 7:59-60 And they stoned Stephen, calling upon God, and saying, Lord Jesus, receive my spirit.And he kneeled down, and cried with a loud voice, Lord, lay not this sin to their charge. And when he had said this, he fell asleep.");
        this.addQuestion(q19);
        Question q20 = new Question("Which of the following beliefs about God is found in  both Christianity and traditional African Communities.",
                "A:God became man",
                "B:God raises the dead",
                "C:God is everywhere",
                "D:God is three in one",
                "C:God is everywhere",
                "The notes are currently unavailable for this question");
        this.addQuestion(q20);
        Question q21 = new Question("Which one of the following acts were performed by elders in traditional African communities during worship",
                "A:Sacrificing animals",
                "B:Reciting the creed",
                "C:Baptising members",
                "D:Serving the Holy Communion",
                "A:Sacrificing animals",
                "There is no single African traditional religion that can be seen as a generalized representation of the religious and cultural beliefs of the people of Africa. Africans recognize eternity, omniscience, omnipresence, holiness, justice, mercy, faithfulness and transcendence of God although perceptions of God�s attributes vary from one place to anothe");
        this.addQuestion(q21);
        Question q22 = new Question("Which one of the following is the best reason why people in traditional African communities were expected to marry.",
                "A:To be resopected",
                "B:To have a partner",
                "C:To have childern",
                "D:To be accepted",
                "C:To have childern",
                "An African proverb says that children are the adornment of the home. This, therefore, is one of the reasons why Africans marry. It is an aesthetic reason. Another reason is that children are an investment, especially in old age; so there is an economic reason for marriage. ");
        this.addQuestion(q22);
        Question q23 = new Question("In  traditional African communities ancestors were respected mainly because they",
                "A:appeaed to the living in a dream",
                "B:united the living and the dead",
                "C:reminded people of the past",
                "D:were the dead relatives",
                "B:united the living and the dead",
                "ancestors are revered consequent upon their affairs of their lineage and are believed to have a great deal of influence over their lineage and siblings. They also play a great intermediary role in between the physical and spiritual world");
        this.addQuestion(q23);
        Question q24 = new Question("Who among the fololowing people is found in Christianity and Traditional African Communities?",
                "A:Herbalist",
                "B:Rainmaker",
                "C:Diviner",
                "D:Prophet",
                "D:Prophet",
                " In arguably its most influential manifestation, the system of prophecy practiced by the Babalawos and Iyanifas of the historically Yoruba regions of West Africa have bequeathed to the world a corpus of fortune-telling poetic methodologies ");
        this.addQuestion(q24);
        Question q25 = new Question("According to Christian teaching the greates fruit of the Holy Spirit is",
                "A:joy",
                "B:love",
                "C:Hope",
                "D:Faith",
                "B:love",
                "1 Corinthians 13:13 So now faith, hope, and love abide, these three; but the greatest of these is love.");
        this.addQuestion(q25);
        Question q26 = new Question("Sarah is sent to buy a kilogram of sugar.The shopkeeper gives her more change.As a Christian,Sarah should?",
                "A:return it to the shop keeper",
                "B:Keep quiet about it",
                "C:use it to buy sweets",
                "D:take it home",
                "A:return it to the shop keeper",
                "Leviticus 19:11 You shall not steal; you shall not deal falsely; you shall not lie to one another.");
        this.addQuestion(q26);
        Question q27 = new Question("Your deskmate Dimon has told you that he is suffering from AIDS.As a Christian which one of the following is the best action to take?",
                "A:Repot the matter to the class teacher",
                "B:Change your sitting position",
                "C:Advise him to seek medical help",
                "D:Inform your classmates",
                "C:Advise him to seek medical help",
                "For friends and family of someone with HIV, it can be difficult to accept the diagnosis. Counselling can help work through issues that have arisen, and offer advice on how best to support the individual.");
        this.addQuestion(q27);
        Question q28 = new Question("Peter who is a rich man is thinking of how to use his extra money.As a Christian,what advice would you give him?",
                "A:Go for trips abroad",
                "B:Pay school fees  for orphans",
                "C:Build a bigger house for his family",
                "D:Buy a farm for his family",
                "B:Pay school fees  for orphans",
                "Mathew 25:36-40 For I was an hungred, and ye gave me meat: I was thirsty, and ye gave me drink: I was a stranger, and ye took me in:Naked, and ye clothed me: I was sick, and ye visited me: I was in prison, and ye came unto me.Then shall the righteous answer him, saying, Lord, when saw we thee an hungred, and fed thee? or thirsty, and gave thee drink?When saw we thee a stranger, and took thee in? or naked, and clothed thee?Or when saw we thee sick, or in prison, and came unto thee?And the King shall answer and say unto them, Verily I say unto you, Inasmuch as ye have done it unto one of the least of these my brethren, ye have done it unto me.");
        this.addQuestion(q28);
        Question q29 = new Question("Jane,a standard eight pupil has been asked by her class teacher to go to school on the day of worship.As a Christian the best advice you would give Jane is",
                "A:Obey the class teacher",
                "B:talk to the church leader",
                "C:transfer to another school",
                "D:go to church",
                "D:go to church", "The notes are currently unavailable for this question");
        this.addQuestion(q29);
        Question q30 = new Question("Which one of the following was the work of the early Christian missionaries in Kenya?",
                "A:Building schools",
                "B:Appointing Local rulers",
                "C:Setting boundaries for colonies",
                "D:Building Railways",
                "A:Building schools",
                "The education sector in Kenya has gone through significant development processes. The foundation that nurtured its growth was laid down by the early Christian Missionaries who combined the introduction of Christianity among the Africans with education");
        this.addQuestion(q30);
        Question q31 = new Question("Which one of the following is the main reason why God Created Eve?He wanted her to?",
                "A:look after the animals",
                "B:take care of the garden of Eden",
                "C:be a companion to Adam",
                "D:eat the fruits of the garden of Eden",
                "C:be a companion to Adam",
                "Genesis 2:20 And Adam gave names to all cattle, and to the fowl of the air, and to every beast of the field; but for Adam there was not found an help meet for him.");
        this.addQuestion(q31);
        Question q32 = new Question("Which one of the following is a lesson that Christians learn from the story of Joseph in prison?",
                "A:God protects the innocent",
                "B:God forgives his people",
                "C:People should have dreams",
                "D:People should look after their parents",
                "A:God protects the innocent", "The notes are currently unavailable for this question");
        this.addQuestion(q32);
        Question q33 = new Question("God led the people of Israel  through the wildernes to the promised land by use of.",
                "A:fire and smoke",
                "B:fire and cloud",
                "C:wind and rainfall",
                "D:thunder and lightening",
                "B:fire and cloud",
                "Exodus 13:21 And the Lord went before them by day in a pillar of a cloud, to lead them the way; and by night in a pillar of fire, to give them light; to go by day and night:");
        this.addQuestion(q33);
        Question q34 = new Question("David is remembered as a great King of Israel because he..",
                "A:Killed Goliath",
                "B:married many wives",
                "C:Built palace for himself",
                "D:Killed wild animals",
                "A:Killed Goliath",
                "1 Samuel 17:50-51 So David triumphed over the Philistine with a sling and a stone; without a sword in his hand he struck down the Philistine and killed him.David ran and stood over him. He took hold of the Philistine�s sword and drew it from the sheath. After he killed him, he cut off his head with the sword.");
        this.addQuestion(q34);
        Question q35 = new Question("Who among the following people was a priest when Samuel was called by God?",
                "A:Elikana",
                "B:Elijah",
                "C:Aaron",
                "D:Eli",
                "D:Eli",
                "1 Samuel 1:9 So Hannah rose up after they had eaten in Shiloh, and after they had drunk. Now Eli the priest sat upon a seat by a post of the temple of the Lord.");
        this.addQuestion(q35);
        Question q36 = new Question("Who among the following people visited baby Jesus?",
                "A:The Samaritans",
                "B:King Herod",
                "C:The Pharises",
                "D:The Shephereds",
                "D:The Shephereds",
                "Luke 2:15-17 When the angels had left them and gone into heaven, the shepherds said to one another, �Let�s go to Bethlehem and see this thing that has happened, which the Lord has told us about.�So they hurried off and found Mary and Joseph, and the baby, who was lying in the manger. 17 When they had seen him, they spread the word concerning what had been told them about this child,");
        this.addQuestion(q36);
        Question q37 = new Question("Who among the following people were in the temple when Jesus was dedicated to God?",
                "A:Zachariah and Elizabeth",
                "B:Simeone and Anna",
                "C:Ananias and Saphira",
                "D:Lazarus and Martha",
                "B:Simeone and Anna", "The notes are currently unavailable for this question");
        this.addQuestion(q37);
        Question q38 = new Question("Which one of the following parables of Jesus teaches about forgiveness?The parable of the:",
                "A:Sower",
                "B:Good samaritan",
                "C:Prodigal son",
                "D:Rich man and Lazarus",
                "C:Prodigal son",
                "Luke 2:25 Now there was a man in Jerusalem called Simeon, who was righteous and devout. He was waiting for the consolation of Israel, and the Holy Spirit was on him Luke 2:36 There was also a prophet, Anna, the daughter of Penuel, of the tribe of Asher. She was very old; she had lived with her husband seven years after her marriage, ");
        this.addQuestion(q38);
        Question q39 = new Question("\"I promise you today you will be in paradise with me.\"(Luke 23:43)Jesus said these words when he was",
                "A:in the garden of Gesthsemane",
                "B:at the sea of Tiberias",
                "C:on the way to Emmaus",
                "D:on the cross",
                "D:on the cross",
                "Luke 23:39-40 One of the criminals who hung there hurled insults at him: �Aren�t you the Messiah? Save yourself and us!�But the other criminal rebuked him. �Don�t you fear God,� he said, �since you are under the same sentence? 41 We are punished justly, for we are getting what our deeds deserve. But this man has done nothing wrong.�");
        this.addQuestion(q39);
        Question q40 = new Question("After the ressurection of Jesus he promised to send for the Holy Spirit who would help them to.",
                "A:become wealthy",
                "B:conqueer the Roman Empire",
                "C:serve in the Jewish council",
                "D:preach good news",
                "D:preach good news",
                "Acts 1:8 But you will receive power when the Holy Spirit comes on you; and you will be my witnesses in Jerusalem, and in all Judea and Samaria, and to the ends of the earth.�");
        this.addQuestion(q40);
        Question q41 = new Question("The resurrection of Jesus teaches Christians to be :",
                "A:tolerant",
                "B:obedient",
                "C:hopeful",
                "D:honest",
                "C:hopeful",
                " Hebrews 6:19 We have this hope as an anchor for the soul, firm and secure. It enters the inner sanctuary behind the curtain,");
        this.addQuestion(q41);
        Question q42 = new Question("Which one of the following is a reason why Stephen was stoned to death?He",
                "A:wanted to lead a rebelion",
                "B:refused to deny Jesus",
                "C:refused to pay taxes",
                "D:worked on the Sabath day",
                "B:refused to deny Jesus",
                "Acts 6:13 They produced false witnesses, who testified, �This fellow never stops speaking against this holy place and against the law. 14 For we have heard him say that this Jesus of Nazareth will destroy this place and change the customs Moses handed down to us.�");
        this.addQuestion(q42);
        Question q43 = new Question("Which one of the following New Testnent books is a gospel?",
                "A:Hebrews",
                "B:Galatians",
                "C:John",
                "D:James",
                "C:John", "The Gospel Books are Matthew,Mark,Luke and John");
        this.addQuestion(q43);
        Question q44 = new Question("Three of the folowing ativities in the early Church demonstrated unity among the belivers.Which one does not?",
                "A:Meeting in the temple for worship ",
                "B:Helping the needy",
                "C:Breaaking of the bread",
                "D:Speaking in tongues",
                "D:Speaking in tongues",
                "Speaking in tongues was is a gift of the holy spirit");
        this.addQuestion(q44);
        Question q45 = new Question("During worship offerings are given in both Christianity and Traditional African communities s a way of showing",
                "A:thanksgiving",
                "B:Mercy",
                "C:Patience",
                "D:Justice",
                "A:thanksgiving",
                "Traditional African religion is a way of life in which ancestors are part of every major event such as wedding, births and deaths as well as less important ones such as getting a job and finishing university. During these events usually an offering is made to honour, please and thank the ancestors");
        this.addQuestion(q45);
        Question q46 = new Question("t",
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
        values.put(KEY_NOTE, quest.getNOTE());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_OPTD, quest.getOPTD());

// Inserting Row
        dbase.insert(TABLE_QUEST_CRE, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_QUEST_CRE;
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
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
// return quest list
        return quesList;
    }

    public int rowcount() {
        int row = 0;
        String selectQuery = "SELECT * FROM " + TABLE_QUEST_CRE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row = cursor.getCount();
        return row;
    }
}