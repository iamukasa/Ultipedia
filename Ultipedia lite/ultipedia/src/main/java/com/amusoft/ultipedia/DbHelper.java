package com.amusoft.ultipedia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "Brundle questions";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
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

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sqlNew = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_QUES + " TEXT, "
                + KEY_ANSWER + " TEXT, "
                + KEY_NOTE + " TEXT,"
                + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, "
                + KEY_OPTC + " TEXT, "
                + KEY_OPTD + " TEXT)";
        db.execSQL(sqlNew);
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
        Question q2 = new Question("Choose one that means the same as the word in Capital:The law OBLIGES parents to send their children to school",
                "A:forces",
                "B:ask",
                "C:requires",
                "D:persuades",
                "C:requires",
                "Oblige:to require or constrain, as by law, command, conscience, or force of necessity,to bind morally or legally, as by a promise or contract.to place under a debt of gratitude for some benefit, favor, or service:");
        this.addQuestion(q2);
        Question q3 = new Question("Chagua neno lifaalo:_____aliposikia kukibishwa hodi alisimama na kuekelea mlangoni",
                "A:Pindi",
                "B:Kwani",
                "C:Baada",
                "D:Kuwa",
                "A:Pindi",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q3);
        Question q4 = new Question("In a geothermal power station steam is led through pipes to generate aform of energy which enables people to see.The energy transformations involved are",
                "A:chemical-electrical-mechanical-heat-light",
                "B:heat-mechanical-electrical-heat-light",
                "C:heat-chemical-mechanical-light-electrical",
                "D:chemical-electrical-light-heat",
                "B:heat-mechanical-electrical-heat-light",
                "The notes are currently unavailable for this question");
        this.addQuestion(q4);
        Question q5 = new Question("Which one of the following groups of Kenyan communities share a common origin?",
                "A:Samburu,Aembu,Pokomo",
                "B:Samburu,Abaluyia,Borana",
                "C:Samburu,Turukana,Maasai",
                "D:Samburu,Abakuria,Iteso",
                "C:Samburu,Turukana,Maasai",
                "They all are Nilotic ");
        this.addQuestion(q5);
        Question q6 = new Question("Which one of the following duties was given to Adam and Eve when God created them?",
                "A:To obey the ten commandments",
                "B:To offer sacrifice to God",
                "C:To take care of other living things",
                "D:To obey the prophets of God",
                "C:To take care of other living things",
                "Genesis 1:19 And out of the ground the Lord God formed every beast of the field, and every fowl of the air; and brought them unto Adam to see what he would call them: and whatsoever Adam called every living creature, that was the name thereof.");
        this.addQuestion(q6);
        Question q7 = new Question("Which one of the following numbers has the smallest value?",
                "A:111010",
                "B:101101",
                "C:110110",
                "D:101011",
                "A:111010",
                "The notes are currently unavailable for Math");
        this.addQuestion(q7);
        Question q8 = new Question("Choose one that means the same as the word in Capital:He SELDOM Comes Here",
                "A:regurlarly",
                "B:rarely",
                "C:always",
                "D:sometimes",
                "B:rarely",
                "Seldom:not often; rarely");
        this.addQuestion(q8);
        Question q9 = new Question("Jaza pengo kwa neno mwafaka.Babu____njia hadi nyumabni kwake.",
                "A:alisindikizwa",
                "B:aliongozwa",
                "C:alishikwa",
                "D:aliongoza",
                "A:alisindikizwa",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q9);
        Question q10 = new Question("Which of the following occurs when rays of light pass from air into water",
                "A:Reflection",
                "B:Dispersion",
                "C:Refraction",
                "D:Absorption:",
                "C:Refraction",
                "Refraction is the change in direction as a light or sound wave enters a new medium.");
        this.addQuestion(q10);
        Question q11 = new Question("The empire of Mwenemutapa was ruled by?",
                "A:a King",
                "B:a council of elders",
                "C:a queen mother",
                "D:a chief",
                "A:a King",
                "The state emerged around 1500 under Nyatsimba Mutota, the first mwene (king) who gained control of the surrounding gold producing region and much of the Zambezi River Valley.  Mutota established a new capital at Zvongombe, near the Zambezi River.");
        this.addQuestion(q11);
        Question q12 = new Question("God changed the name of Abram to Abraham mainly because he wanted to.",
                "A:make him a father of nations",
                "B:give him a new land",
                "C:make him rich",
                "D:give him protection",
                "A:make him a father of nations ",
                "Genesis 17:4-6 As for me, behold, my covenant is with thee, and thou shalt be a father of many nations.Neither shall thy name any more be called Abram, but thy name shall be Abraham; for a father of many nations have I made thee.And I will make thee exceeding fruitful, and I will make nations of thee, and kings shall come out of thee.");
        this.addQuestion(q12);
        Question q13 = new Question("A rectangular water tank is 6 meters long, 4meters wide and three meters high.How many litres of water does the tank hold when full",
                "A:72l",
                "B:7200l",
                "C:72000l",
                "D:72000000l",
                "D:72000000l",
                "The notes are currently unavailable for Math");
        this.addQuestion(q13);
        Question q14 = new Question("Choose one that means the same as the word in Capital:The INITIAL plan was the best",
                "A:earlier",
                "B:former",
                "C:starting",
                "D:original",
                "D:original",
                "Initial:of, pertaining to, or occurring at the beginning; first:");
        this.addQuestion(q14);
        Question q15 = new Question("Chagua Wingi Wa:'Kitabu changu kizuri kimeraruliwa",
                "A:Vitabu zangu nzuri kimeraruliwa",
                "B:Vitabu vyangu vizuri vimeraruliwa ",
                "C:Vitabu vyetu vizuri vimeraruliwa",
                "D:Vitabu vyetu zuri zimeraruliwa",
                "C:Vitabu vyetu vizuri vimeraruliwa",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q15);
        Question q16 = new Question("Which one of the following factors Does Not affect how high or low sound produced by a stringed instrument it?",
                "A:lenght of the String",
                "B:Thickness of the String",
                "C:Tightness  of the String",
                "D:Force used to pluck the string",
                "A:lenght of the String",
                "The notes are currently unavailable for this question");
        this.addQuestion(q16);
        Question q17 = new Question("Which one of the following is the main function of Thika town?It is",
                "A:an administrative centre",
                "B:an agricultural centre",
                "C:a market centre",
                "D:an industrial centre",
                "D:an industrial centre",
                "Thika  is an industrial town in Kiambu County, Kenya, lying on the A2 road 40 kilometres (25 mi) north east of Nairobi, near the confluence of the Thika and Chania Rivers.");
        this.addQuestion(q17);
        Question q18 = new Question("Joseph the son of Jacob was sold by his brothers because they:",
                "A:hoped to become rich",
                "B:were jealous",
                "C:needed food",
                "D:wanted to visit Egypt",
                "B:were jealous",
                "Genesis 37:4-5 Now Israel loved Joseph more than all his children, because he was the son of his old age: and he made him a coat of many colours. And when his brethren saw that their father loved him more than all his brethren, they hated him, and could not speak peaceably unto him.");
        this.addQuestion(q18);
        Question q19 = new Question("What is the number 29853 when rounded to the nearest thousand?",
                "A:29000",
                "B:29850",
                "C:29900",
                "D:30000",
                "D:30000",
                "The notes are currently unavailable for Math");
        this.addQuestion(q19);
        Question q20 = new Question("Which of the following is correctly punctuated:",
                "A:Subira inquired Fred,\"how many cackes do you need?\"",
                "B:\"Subira,\" inquired Fred,\"how many cackes do you need?\"",
                "C:Subira,inquired Fred,\"how many cackes do you need?\"",
                "D:\"Subira inquired Fred,\"how many cackes do you need?",
                "A:Subira inquired Fred,\"how many cackes do you need?\"",
                "Use quotation marks to set off material that represents quoted or spoken language. Quotation marks also set off the titles of things that do not normally stand by themselves: short stories, poems, and articles. Usually, a quotation is set off from the rest of the sentence by a comma;");
        this.addQuestion(q20);
        Question q21 = new Question("____kwa wale wezi hakungeweza kuwafanya wasamehewe.",
                "A:Kutetea",
                "B:Kujitetea",
                "C:Kuittea",
                "D:Kuzitetea",
                "B:Kujitetea",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q21);
        Question q22 = new Question("Which of the following is NOT a characteristic of seeds dispersed by wind",
                "A:light",
                "B:hooked",
                "C:winged",
                "D:feathery",
                "B:hooked",
                "Seeds dispersed by the wind must be light and small in order to be carried by the wind.");
        this.addQuestion(q22);
        Question q23 = new Question("In traditional Kenyan society polygamy was accepted because",
                "A:it was a way of controlling population growth",
                "B:it was a way of reducing immorality",
                "C:it was a way of controlling infectious diseases",
                "D:it was a sign of prestige",
                "D:it was a sign of prestige",
                "Polygamy was a symbol of status. When one had many wives, it showed that he is capable of supporting a large number of people. This meant that he was wealthy. This raised his status in the society.");
        this.addQuestion(q23);
        Question q24 = new Question("Which one of the following qualities of God is shown on the night the Jews left Egypt?",
                "A:He is the creator",
                "B:He is forgiving",
                "C:He is a saviour",
                "D:He is Holy",
                "C:He is a saviour",
                "Exodus 12:74 For the Lord will pass through to smite the Egyptians; and when he seeth the blood upon the lintel, and on the two side posts, the Lord will pass over the door, and will not suffer the destroyer to come in unto your houses to smite you. Exodus 12:50-51 Thus did all the children of Israel; as the Lord commanded Moses and Aaron, so did they.And it came to pass the selfsame day, that the Lord did bring the children of Israel out of the land of Egypt by their armies.");
        this.addQuestion(q24);
        Question q25 = new Question("What is the place value of digit 5 in the number 1050067?",
                "A:Thousands",
                "B:Ten thousands",
                "C:Fifty thousands",
                "D:hundred thousands",
                "B:Ten thousands",
                "The notes are currently unavailable for Math");
        this.addQuestion(q25);
        Question q26 = new Question("Which of the following is correctly punctuated:",
                "A:How interesting the day was?",
                "B:How interesting the day was.",
                "C:How interesting the day was!",
                "D:How interesting the day was!?",
                "C:How interesting the day was!",
                "The exclamation point  is a terminal punctuation mark in English and is usually used at the end of a sentence with no extra period. It can turn a simple indicative or declarative sentence into a strong command or reflect an emotional outburst. It can also indicate rhetorical questions.");
        this.addQuestion(q26);
        Question q27 = new Question("Viazi Vyake ____gari.",
                "A:vilichukuliwa kwa",
                "B:vilichukuliwa na",
                "C:vilibebwa kwa",
                "D:vilibebe kwa",
                "A:vilichukuliwa kwa",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q27);
        Question q28 = new Question("Which one of the following has ALL the conditions necessary for germination of seeds",
                "A:Soil,air,water",
                "B:Air,Warmth,water",
                "C:Warmth light,soil",
                "D:Water,Warmth,Light",
                "D:Water,Warmth,Light",
                "In general we can say that all seeds need water and warmth to germinate.");
        this.addQuestion(q28);
        Question q29 = new Question("Which one of the following groups of countries are found in Eastern Africa",
                "A:Kenya,Uganda,Angola",
                "B:Kenya,Rwanda,Egypt",
                "C:Kenya,Somalia,Namibia",
                "D:Kenya,Tanzania,Sudan",
                "D:Kenya,Tanzania,Sudan",
                "East Africa comprises ten countries: Tanzania, Burundi, Rwanda, Uganda, Sudan, Ethiopia, Eritrea, Djibouti, Somalia, and Kenya.");
        this.addQuestion(q29);
        Question q30 = new Question("Who among the following people asked God to forgive Israelites at Mount Sinai?",
                "A:Moses",
                "B:Josua",
                "C:Miriam",
                "D:Aaron",
                "A:Moses",
                "Exodus 32:31-32 And Moses returned unto the Lord, and said, Oh, this people have sinned a great sin, and have made them gods of gold.Yet now, if thou wilt forgive their sin�; and if not, blot me, I pray thee, out of thy book which thou hast written.");
        this.addQuestion(q30);
        Question q31 = new Question("What is the value of:(24(72-69)+6�4)/12",
                "A:8",
                "B:26",
                "C:30",
                "D:74",
                "A:8",
                "The notes are currently unavailable for Math");
        this.addQuestion(q31);
        Question q32 = new Question("Which alternative Best completes the sentences:I offered him a job but he___",
                "A:turned it away",
                "B:turned it down",
                "C:turned it back",
                "D:turned it off",
                "B:turned it down",
                "turn down somebody/something also turn somebody/something down is to refuse to accept or agree to something, or to someone's idea");
        this.addQuestion(q32);
        Question q33 = new Question("Ni maneno yapi ambayo yote ni vielezi?",
                "A:Rasmi,Kitunguu,Kiziwi,Safi",
                "B:Mzuri,Mweupe,yeyote,pale",
                "C:Upesi,Kitajiri,Sana,Kivivu",
                "D:Muungwana,Mwerevu,Kimaskini,Gunia",
                "C:Upesi,Kitajiri,Sana,Kivivu",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q33);
        Question q34 = new Question("Which one of the following insects DOES NOT undergo the stages of egg ,larva ,pupa and adult in its lifecycle",
                "A:Housefly",
                "B:Mosquito",
                "C:Bee",
                "D:Locust",
                "D:Locust",
                "The dragonfly,Locust, termite, grasshopper and true bug undergo incomplete metamorphosis. In this process there are three stages called egg, nymph and adult");
        this.addQuestion(q34);
        Question q35 = new Question("The following are statements about a community in Eastern Africa During the precolonial period(i)The community was ruled by hereditary kings(ii)The community traded with the coast traders(iii)The community practiced crop growing",
                "A:The Dinka",
                "B:The Baganda",
                "C:the Chagga",
                "D:The Somali",
                "B:The Baganda",
                "The leader of the Kingdom is called The Kabaka. Sovereignty of leadership has always belonged to the male child from the royal family.");
        this.addQuestion(q35);
        Question q36 = new Question("David annoyed God when he",
                "A:killed Goliath",
                "B:killed Uriah",
                "C:cried over the death of Saul",
                "D:married many women",
                "B:killed Uriah",
                "2 Samuel 12:9 Wherefore hast thou despised the commandment of the Lord, to do evil in his sight? thou hast killed Uriah the Hittite with the sword, and hast taken his wife to be thy wife, and hast slain him with the sword of the children of Ammon.");
        this.addQuestion(q36);
        Question q37 = new Question("What is the value of 8^2(9^2-3^2)/4^2�6^2?",
                "A:4",
                "B:8",
                "C:2",
                "D:2/3",
                "B:8",
                "The notes are currently unavailable for Math");
        this.addQuestion(q37);
        Question q38 = new Question("Which alternative Best completes the sentences:After yesterday's perfomance they should be____",
                "A:ashamed for themselves",
                "B:ashamed with themselves",
                "C:ashamed at themselves",
                "D:ashamed of themselves",
                "D:ashamed of themselves",
                "The notes are currently unavailable for this question");
        this.addQuestion(q38);
        Question q39 = new Question("Ukubwa wa sentensi 'Kitoto kilivaa kijikanzucheupe' ni",
                "A:Mtoto alivaa kanzu jeupe",
                "B:Mtoto alivaa kanzu nyeupe",
                "C:Toto lilivaa jikanzu nyeupe",
                "D:Toto lilivaa jikanzu jeupe",
                "D:Toto lilivaa jikanzu jeupe",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q39);
        Question q40 = new Question("Which of the following animals is not a mammal",
                "A:Hipopotamus",
                "B:Bat",
                "C:Whale",
                "D:Shark",
                "D:Shark",
                "Sharks are a group of fish characterized by a cartilaginous skeleton, five to seven gill slits on the sides of the head, and pectoral fins that are not fused to the head. ");
        this.addQuestion(q40);

        Question q41 = new Question("Which one of the following is the main function of agricultural co-operative societies in Kenya",
                "A:Marketing of produce for the members.",
                "B:Buying farm implements for the members",
                "C:Assisting the members to learn good farming methods",
                "D:Building schools for the members' children",
                "A:Marketing of produce for the members.",
                "The notes are currently unavailable for this question");
        this.addQuestion(q41);
        Question q42 = new Question("'Give me the wisdom i need to rule your people with justice'(1 Kings 3:9).These words were spoken by King",
                "A:Ahaz",
                "B:Solomon",
                "C:Jeroboam",
                "D:Ahab",
                "B:Solomon",
                "1 Kings 3:10 And the speech pleased the Lord, that Solomon had asked this thing.");
        this.addQuestion(q42);
        Question q43 = new Question("What is 23.1408 correct to three decimal places",
                "A:23.0",
                "B:23.1",
                "C:23.140",
                "D:23.141",
                "D:23.141",
                "The notes are currently unavailable for Math");
        this.addQuestion(q43);
        Question q44 = new Question("Which alternative Best completes the sentences:She has a_____bag",
                "A:small beautiful expensive",
                "B: beautiful small expensive",
                "C:small expensive  beautiful",
                "D: beautiful expensive small",
                "A:small beautiful expensive",
                "Generally, the adjective order in English is:Quantity or number,Quality or opinion,Size,Age,Shape,Color,Proper adjective (often nationality, other place of origin, or material),Purpose or qualifier");
        this.addQuestion(q44);
        Question q45 = new Question("Chagua sentensi iliyo sahihi kisarufi",
                "A:Michuzi yote mingine zilikuwa na chumvi isipokuwa hii",
                "B:Michuzi yote mingine ilikuwa na chumvi isipokuwa huu",
                "C:Michuzi yote mingine ilikuwa na chumvi isipokuwa hizi",
                "D:Michuzi yote mingine mlikuwa na chumvi isipokuwa hizi",
                "B:Michuzi yote mingine ilikuwa na chumvi isipokuwa huu",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q45);
        Question q46 = new Question("The following are functions of roots:\n(i)holding plants firmly in the soil\n(ii)storage of food\n(iii)absorbtion of water and mineral salts\n(iv)breathing\n Which of the following functions are performed by all Roots",
                "A:(i)(iii)",
                "B:(ii)(iv)",
                "C:(i)(ii)",
                "D:(iii)(iv)",
                "A:(i)(iii)",
                "The four major functions of roots are absorption of water and inorganic nutrients,anchoring of the plant body to the ground, and supporting it,storage of food and nutrients, and vegetative reproduction. ");
        this.addQuestion(q46);
        Question q47 = new Question("The Main problem facing beef farming in Kenya is?",
                "A:inadequate market",
                "B:scarcity of water",
                "C:pests and diseases",
                "D:attacks by wild animals",
                "B:scarcity of water",
                "All the above are other problems facing beef farming");
        this.addQuestion(q47);
        Question q48 = new Question("Who among the following prophets annointed Saul to be King of Israel?",
                "A:ELisha.",
                "B:Isaiah",
                "C:Nathan",
                "D:Samuel",
                "D:Samuel",
                "1 Samuel 10:1 Then Samuel took a vial of oil, and poured it upon his head, and kissed him, and said, Is it not because the Lord hath anointed thee to be captain over his inheritance?");
        this.addQuestion(q48);
        Question q49 = new Question("The marked price of a pair of shoewas sh.250.During a sale the price was reduced to sh.200.what was the percentage decreade in price",
                "A:80%",
                "B:50%",
                "C:25%",
                "D:20%",
                "D:20%",
                "The notes are currently unavailable for Math");
        this.addQuestion(q49);
        Question q50 = new Question("Choose one that best completes the sentence:The Mutukus are so kind...",
                "A:because they always help people.",
                "B:as they always help people",
                "C:that they always help people",
                "D:since they always help people",
                "A:because they always help people.",
                "The notes are currently unavailable for this question");
        this.addQuestion(q50);

        Question q51 = new Question("Neno jingine lenye maana MWONGO ni",
                "A:mia",
                "B:kumi",
                "C:elfu",
                "D:hamsini",
                "A:mia",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q51);
        Question q52 = new Question("Which of the folllowing is not a function of the placenta?",
                "A:allow passage of dissolved food materials to the embryo",
                "B:Allow exchange of gases between embryo  and mother",
                "C:prevent harmful materials from reaching the embryo",
                "D:protects embryo from from shock",
                "D:protects embryo from from shock",
                "The placenta is the Site for gas exchange,Nutrient exchange,Waste exchange,Synthesis of enzymes Detoxification of drugs and metabolisation and also provides IgG and immune system for foetus");
        this.addQuestion(q52);
        Question q53 = new Question("Which of the following is the main problem facing sugarcane farmers in Western Kenya",
                "A:Lack of land to expand their farms",
                "B:Lack of labour during harvesting",
                "C:Delayed payment of sugarcane delivered to factories",
                "D:Lack of storage facilities for sugarcane in the factories",
                "C:Delayed payment of sugarcane delivered to factories",
                "All the above are other problems facing sugar cane farming");
        this.addQuestion(q53);
        Question q54 = new Question("The prophets of Baal were put to test by Elijah on Mount Carmel to show that?",
                "A:God answers prayers",
                "B:God is three in one",
                "C:Baal was asleep",
                "D:Baal was a coward",
                "A:God answers prayers",
                "1 Kings 18:37-38 Hear me, O Lord, hear me, that this people may know that thou art the Lord God, and that thou hast turned their heart back again.Then the fire of the Lord fell, and consumed the burnt sacrifice, and the wood, and the stones, and the dust, and licked up the water that was in the trench.");
        this.addQuestion(q54);
        Question q55 = new Question("What is the L.C.M of 15,20 and 30?",
                "A:120",
                "B:60",
                "C:15",
                "D:5",
                "A:120",
                "The notes are currently unavailable for Math");
        this.addQuestion(q55);
        Question q56 = new Question("Fights were PROHIBITED means they were",
                "A:stopped",
                "B:discouraged",
                "C:forbidden",
                "D:refused",
                "C:forbidden",
                "Prohibited:To forbid by authority,To prevent; preclude");
        this.addQuestion(q56);
        Question q57 = new Question("Maana ya methali'Sikio la kufa haliskii dawa' ni:",
                "A:Asiyesikia hasikii",
                "B:Asiyetii ni vigumu kumkanya",
                "C:Sikio la kufa halitibiwi",
                "D:Asiyesikia haambiwi",
                "B:Asiyetii ni vigumu kumkanya",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q57);
        Question q58 = new Question("The plant process investigated when the leaves of a potted plants are enclosed in a polytthene bag is?",
                "A:Condesation",
                "B:Transpiration",
                "C:Saturation",
                "D:evaporation",
                "B:Transpiration",
                "Transpiration is the loss of water vapour from the surface of plant leaves.Transpiration is most rapid in hot, dry, windy or bright conditions.");
        this.addQuestion(q58);
        Question q59 = new Question("Which of the following Kenyan Communities is correctly matched with its main economic activity during the coloial period?",
                "A:Rendile-trading",
                "B:Ameru-Livestock Keeping",
                "C:Nandi-hunting",
                "D:Abagusii-crop qrowing",
                "D:Abagusii-crop qrowing",
                "Precolonial staple crop was finger millet, which was grown together with sorghum, beans, and sweet potatoes. By the 1920s, maize had overtaken finger millet as both a staple-food crop and a cash crop.");
        this.addQuestion(q59);
        Question q60 = new Question("When Jesus was born the angel appeared to the shapherds to",
                "A:help them guard animals",
                "B:tell them the good news",
                "C:warn them about Herod",
                "D:guide them to Bethlehem",
                "B:tell them the good news",
                "Luke 2:8-10 And there were in the same country shepherds abiding in the field, keeping watch over their flock by night.And, lo, the angel of the Lord came upon them, and the glory of the Lord shone round about them: and they were sore afraid.And the angel said unto them, Fear not: for, behold, I bring you good tidings of great joy, which shall be to all people.");
        this.addQuestion(q60);

        Question q61 = new Question("What is the ratio 3:5 expresed as a decimal?",
                "A:1.6",
                "B:0.625",
                "C:0.6",
                "D:0.375",
                "C:0.6",
                "The notes are currently unavailable for Math");
        this.addQuestion(q61);
        Question q62 = new Question("Which of the following words is closest in meaning to 'crumpled'",
                "A:Folded",
                "B:Wrinkled",
                "C:Pleated",
                "D:Squeezed",
                "B:Wrinkled",
                "Crumple:To become wrinkled. To collapse");
        this.addQuestion(q62);
        Question q63 = new Question("Maana ya usingizi wa pono ni:",
                "A:usingizi mewpesi",
                "B:usingizi mzito",
                "C:usingizi wa shida",
                "D:usingizi wa mang'amung'amu",
                "B:usingizi mzito",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q63);
        Question q64 = new Question("Which oneof the following statements is NOT True about all arteries?",
                "A:They carry blood away from the heart",
                "B:They have thick walls",
                "C:Blood pressure in them is high",
                "D:They carry blood rich in Oxygen",
                "D:They carry blood rich in Oxygen",
                "Blood is pumped through pulmonary artery to lungs to retrieve oxygen oxygenated blood returns to heart through the Pulmonary vein");

        this.addQuestion(q64);
        Question q65 = new Question("Which one of the following groups of people share a common ancestor in Traditional Agikuyu community?",
                "A:Njau,his brothers,his sisters",
                "B:Njau,his mother,his father",
                "C:Njau,his wife,his brothers",
                "D:Njau,his uncle,his mother",
                "A:Njau,his brothers,his sisters",
                " The Kikuyu family is considered to be circular, rather than linear as in Western cultures. Each new generation replaces their grandparents, who are then free to become ancestors. The need to replace four grandparents is an important reason for having a minimum of four children, and more children gives honor to the parents' siblings.");
        this.addQuestion(q65);
        Question q66 = new Question("Didnt you know that i had to be in my fathers house?(Luke 2:49)'When did Jesus say these words",
                "A:When he was found by his parents in the temple",
                "B:When he chased the traders from the temple",
                "C:During his baptism by John",
                "D:During his trial before the high Preist",
                "A:When he was found by his parents in the temple",
                "Luke 2:46-47 And it came to pass, that after three days they found him in the temple, sitting in the midst of the doctors, both hearing them, and asking them questions.And all that heard him were astonished at his understanding and answers.");
        this.addQuestion(q66);
        Question q67 = new Question("In the year 2000, Febuary 9th was a Saturday.What was March 6th the same year?",
                "A:Sunday",
                "B:Monday",
                "C:Tuesday",
                "D:Wednesday",
                "B:Monday",
                "The notes are currently unavailable for Math");
        this.addQuestion(q67);
        Question q68 = new Question("The term \"common knowledge\" means the same as",
                "A:easy to get",
                "B:widely known",
                "C:for everybody",
                "D:found everywhere",
                "B:widely known",
                "Common knowledge:something widely or generally known");
        this.addQuestion(q68);
        Question q69 = new Question("Maana ya 'Kughairi' katika sentensi ni:Hakupata mhisani hata mmoja,lakini hiki hakikumfanya KUGAHIRI.",
                "A:Kubadili nia",
                "B:kufa moyo",
                "C:kuogopa sana",
                "D:kupunguza mwendo",
                "B:kufa moyo",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q69);
        Question q70 = new Question("Which one of the folllowing features would help a pupil tell that a plant structure is a fruit",
                "A:Being fleshy",
                "B:Presence of two scars",
                "C:Having one Cotyledon",
                "D:Having a line if weakness",
                "B:Presence of two scars",
                "Fruits have two scars while Seeds only have two");
        this.addQuestion(q70);
        Question q71 = new Question("Which one of the following statements is true about education in traditional African societies?",
                "A:Learners read books about great peoople in the society",
                "B:Learners were given written tests regurlarly",
                "C:Learning took place throughout a persons life",
                "D:Learning took place in classrooms.",
                "C:Learning took place throughout a persons life",
                "Traditional education is based on informal apprenticeship with kin and early participation in the work force.");
        this.addQuestion(q71);
        Question q72 = new Question("The temptation of Jesus in the desert teaches Christians that they should",
                "A:seek earthly riches",
                "B:run away from trials",
                "C:do the will of God",
                "D:look for food when hungry",
                "C:do the will of God",
                "Luke 4:4 And Jesus answered him, saying, It is written, That man shall not live by bread alone, but by every word of God.");
        this.addQuestion(q72);
        Question q73 = new Question("What is the value of 0.3�0.94+(0.304+0.123�0.4)?",
                "A:1.3495",
                "B:1.7725",
                "C:0.8935",
                "D:0.6225",
                "C:0.8935",
                "The notes are currently unavailable for Math");
        this.addQuestion(q73);
        Question q74 = new Question("Choose the word that least fits the group",
                "A:cutlery",
                "B:crockery",
                "C:bedding",
                "D:shirts",
                "D:shirts", "The notes are currently unavailable for this question");
        this.addQuestion(q74);
        Question q75 = new Question("Maana ya 'Ungetumbukia nyongo'",
                "A:ungeangukia nyongo",
                "B:ungetengenezeka",
                "C:ungeharibika",
                "D:ungekuja kuchelewa",
                "C:ungeharibika",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q75);
        Question q76 = new Question("Digestion of food does not take place in the",
                "A:mouth",
                "B:large intestines",
                "C:stomach",
                "D:small intestines:",
                "B:large intestines",
                "The Large Intestine is the final portion of the alimentary canal, made up of the cecum, colon, rectum, and anal canal, involved with absorption of water and electrolytes");
        this.addQuestion(q76);
        Question q77 = new Question("The main cause of rural-rural migration in Kenya is?",
                "A:lack of water",
                "B:search for land for settlement",
                "C:search for employment",
                "D:outbreak of diseases",
                "A:lack of water",
                "All the above are reasons for rural-rural migration");
        this.addQuestion(q77);
        Question q78 = new Question("A miracle of Jesus which shows His power over nature is the",
                "A:healing of the paralysed man",
                "B:walking on water",
                "C:healing the blind man",
                "D:raising of Jarius's Daughter",
                "B:walking on water",
                "Mathew 14:25-28  And in the fourth watch of the night Jesus went unto them, walking on the sea.And when the disciples saw him walking on the sea, they were troubled, saying, It is a spirit; and they cried out for fear.But straightway Jesus spake unto them, saying, Be of good cheer; it is I; be not afraid. And Peter answered him and said, Lord, if it be thou, bid me come unto thee on the water.");
        this.addQuestion(q78);

        Question q79 = new Question("A box measuring 10cm by 6cm by 4cm were to be packed in a carton measuring 1.5 m by 0.4 m.How many boxes were needed to fill the carton",
                "A:25000",
                "B:2500",
                "C:250",
                "D:25",
                "B:2500",
                "The notes are currently unavailable for Math");
        this.addQuestion(q79);
        Question q80 = new Question("Choose the word that least fits the group",
                "A:glance",
                "B:gaze",
                "C:stare",
                "D:glare",
                "D:glare", "The notes are currently unavailable for this question");
        this.addQuestion(q80);
        Question q81 = new Question("Ni sentensi ipi sahihi?",
                "A:Ndizi lililoletwa ni wangu",
                "B:Miti zilizopandwa zimeota.",
                "C:Zulia iliyonunuliwa ni zuri",
                "D:Wema unaozungumziwa ni huu",
                "D:Wema unaozungumziwa ni huu",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q81);
        Question q82 = new Question("A small amount of water was put in a tin can and heated to boiling.The tin can was then closed tightly and left to cool.The experiment was to demonstrate thst air: ",
                "A:occupies space",
                "B:exerts pressure",
                "C:has weight",
                "D:contracts on cooling",
                "D:contracts on cooling",
                "Air contracts this reduces pressure in the tin.Air pressure then acts on the tin can and crushes it.");
        this.addQuestion(q82);
        Question q83 = new Question("Drug abuse is discouraged mainly because it",
                "A:leads to ill health",
                "B:promotes illegal trade",
                "C:pollutes the environment",
                "D:encourages corruption",
                "A:leads to ill health",
                "More deaths, illnesses and disabilities stem from substance abuse than from any other preventable health condition.");
        this.addQuestion(q83);
        Question q84 = new Question("Which of the following is the main reason Jesus mixed with sinners?",
                "A:He came from a poor family",
                "B:Sinners were hated by other people",
                "C:He came to save all people",
                "D:Sinners were friendly to him",
                "C:He came to save all people",
                "Matthew 18:11-12 For the Son of man is come to save that which was lost.How think ye? if a man have an hundred sheep, and one of them be gone astray, doth he not leave the ninety and nine, and goeth into the mountains, and seeketh that which is gone astray?");
        this.addQuestion(q84);
        Question q85 = new Question("A cylinder which is open at one end has a radius of 6.3cm and a height of 25cm.What is the surface area of the cylinder in square centimeters(Take PII=22/7 )",
                "A:1114.74",
                "B:1239.48",
                "C:3118.50",
                "D:619.74",
                "A:1114.74",
                "The notes are currently unavailable for Math");
        this.addQuestion(q85);
        Question q86 = new Question("Choose the word that least fits the group",
                "A:grab",
                "B:hold",
                "C:touch",
                "D:seize",
                "C:touch",
                "The notes are currently unavailable for this question");

        this.addQuestion(q86);
        Question q87 = new Question("Miongoni mwa sehemu hizi za mwili,ni sehemu ipi iliyo toofauti na zengine?",
                "A:Paja",
                "B:Kiganja",
                "C:Pafu",
                "D:Goti",
                "C:Pafu",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q87);
        Question q88 = new Question("Which two components make about 78% of the volume of air?",
                "A:Oxygen and Carbon dioxide",
                "B:Nitrogen and Oxygen",
                "C:Carbon dioxide and Nitogen",
                "D:Rare gases aon Nitrogen",
                "C:Carbon dioxide and Nitogen",
                "Nitrogen makes up 78%,Oxygen	makes up 21%,Carbon dioxide	makes up 0.03% and Rare Gases make up 0.97%");
        this.addQuestion(q88);
        Question q89 = new Question("Arabs came to the Kenyan coast before 1500 AD mainly to:",
                "A:spread islam",
                "B:escape religious persecution",
                "C:trade with the local people",
                "D:explore the area",
                "C:trade with the local people",
                "Arab traders began frequenting the Kenya coast around the 1st century AD. Kenya's proximity to the Arabian Peninsula invited trade and later settlement.");
        this.addQuestion(q89);
        Question q90 = new Question("Which one of the following actions of Mary and Martha best shows their love for their brother Lazarus",
                "A:Staying with the mourners",
                "B:Showing Jesus Lazaru's grave",
                "C:Welcoming Jesus to their home",
                "D:Informing Jesus about Lazaru's sickness",
                "D:Informing Jesus about Lazaru's sickness",
                "John 11:1-3 Now a certain man was sick, named Lazarus, of Bethany, the town of Mary and her sister Martha.(It was that Mary which anointed the Lord with ointment, and wiped his feet with her hair, whose brother Lazarus was sick.)Therefore his sisters sent unto him, saying, Lord, behold, he whom thou lovest is sick.");
        this.addQuestion(q90);
        Question q91 = new Question("A cuboid measures 6 cm long,5 cm wide and 4 cm high.What is the total length of the edges in cm",
                "A:30",
                "B:60",
                "C:90",
                "D:120",
                "B:60",
                "The notes are currently unavailable for Math");
        this.addQuestion(q91);
        Question q92 = new Question("Choose the best alternative which best to complete the statement:Only after everyone has paid the fare..",
                "A:the bus will leave",
                "B:then the bus will leave",
                "C:and the bus will leave",
                "D:will the bus leave",
                "D:will the bus leave", "The notes are currently unavailable for this question");
        this.addQuestion(q92);
        Question q93 = new Question("PolePole,Vibaya,Alasiri,Njiani,ni ",
                "A:Vielezi",
                "B:Vivumishi",
                "C:Nomino",
                "D:Viwakilishi",
                "A:Vielezi", "The notes are currently unavailable in kiswahili");
        this.addQuestion(q93);
        Question q94 = new Question("A certain indicator obtained from a flower turned pink when mixed with a few drops of clover extract.Which one of the following materials would have similar results when mixed with the indicator",
                "A:Chalk powder",
                "B:lemon juice",
                "C:wood ash",
                "D:Baking powder",
                "B:lemon juice",
                "Lemon juice is acidic in nature,Hence will also turn the plant exctract to pink");
        this.addQuestion(q94);
        Question q95 = new Question("Perkerra irigation scheme was planned for growing",
                "A:fruits",
                "B:onions",
                "C:rice",
                "D:cotton",
                "B:onions",
                "Perkerra Irrigation Scheme was started in 1954 and was incorporated into NIB upon its formation in 1966 through an Act of Parliament.");
        this.addQuestion(q95);
        Question q96 = new Question("'This is my body ,Which is given for you'(Luke 22:19).These words were said by Jesus during the",
                "A:Last supper",
                "B:trial before pilate",
                "C:Crucifixion on the cross",
                "D:ascension into heaven",
                "A:Last supper",
                "Luke 22:7-8 Then came the day of unleavened bread, when the passover must be killed. And he sent Peter and John, saying, Go and prepare us the passover, that we may eat.");
        this.addQuestion(q96);
        Question q97 = new Question("The price of a radio was reduced by sh.630.This represents a 30% discount.What wa the price of the radio after the discount",
                "A:sh. 441",
                "B:sh.1470",
                "C:sh.2100",
                "D:sh.2730",
                "B:sh.1470",
                "The notes are currently unavailable for Math");
        this.addQuestion(q97);
        Question q98 = new Question("Choose the best alternative which best to complete the statement:Musa asked her..",
                "A:where are you going",
                "B:where was she going",
                "C:where she was going",
                "D:where she is going",
                "C:where she was going", "The notes are currently unavailable for this question");
        this.addQuestion(q98);
        Question q99 = new Question("Methali inayotoa funzo kuwa:Jambo linaloonekana zito kwa mwengine laweza kuwa rahisi kwako ni:",
                "A:Bahati ya mwenzio usilalie mlango wazi",
                "B:Mzigo wa mwenzio ni kanda la usufi",
                "C:Kila mwamba ngoma ngozi huvuutia kwake",
                "D:Ganda la muwa la jana chungu kaona kivuno",
                "B:Mzigo wa mwenzio ni kanda la usufi",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q99);
        Question q100 = new Question("Force is Measured in ",
                "A:grams",
                "B:grams per cubic centimeter",
                "C:cubic centimeters",
                "D:Newtons",
                "D:Newtons",
                "A force is a push or pull upon an object resulting from the object's interaction with another object,It is measured in Newtons");
        this.addQuestion(q100);
        Question q101 = new Question("Which one of the following groups of commodities did the Akamba traders obtain from the coastal traders during the nineteenth century?",
                "A:Ivory and skins",
                "B:Slaves and grain",
                "C:Beads and cloth",
                "D:Glassware and Gold",
                "C:Beads and cloth",
                "The first crop of Onions was planted in 1956. The area developed to use furrow method of Irrigation was 1400 acres (567 Ha). The total surveyed area for Irrigation is 5800 Acres (2348 Ha)");
        this.addQuestion(q101);
        Question q102 = new Question("Who among the following helped Jesus to carry the cross?",
                "A:Joseph of Arimathea",
                "B:Simon of Cyrene",
                "C:Peter",
                "D:Nicodemus",
                "B:Simon of Cyrene",
                " Matthew 27:32 And as they came out, they found a man of Cyrene, Simon by name: him they compelled to bear his cross.");
        this.addQuestion(q102);
        Question q103 = new Question("What is the next number in the sequence 7,16,32,57",
                "A:93",
                "B:89",
                "C:82",
                "D:63",
                "A:93",
                "The notes are currently unavailable for Math");
        this.addQuestion(q103);
        Question q104 = new Question("Which sentence is punctuated correctly:",
                "A:You don't believe that.Do you?",
                "B:I don't like it's colour.",
                "C:Jane Said,\"The young man is my brother.\"The notes are currently unavailable for this question",
                "D:She is asking whether you are hungry?",
                "B:I don't like it's colour.", "The notes are currently unavailable for this question");
        this.addQuestion(q104);
        Question q105 = new Question("Sentensi \"Asingalikkwenda kwake asubuhi asingalimkuta \" ina maana kuwa:",
                "A:Hakuenda kwake asubuhi lakini alimkuta",
                "B:Alienda kwake asubuhi lakini hakumkuta",
                "C:Alienda kwake asubuhi na akamkuta",
                "D:Hakuenda kwake asubuhi wala hakumkuta",
                "C:Alienda kwake asubuhi na akamkuta",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q105);
        Question q106 = new Question("Which one of the following mixtures cannot be separated by dissolving filtering and evaporating?",
                "A:Sand and sugar",
                "B:Maize flour and sugar",
                "C:chalk powder and salt",
                "D:salt and sugar",
                "D:salt and sugar",
                "Salt and Sugar all dissolve in water");
        this.addQuestion(q106);
        Question q107 = new Question("European nations established colonies colonies in Africa during the nineteenth century in order to:",
                "A:promote good relations with African leaders",
                "B:Secure markets for manufactured goods from Europe",
                "C:encourage Africans to grow cash crops",
                "D:obtain land to settle European refugees",
                "B:Secure markets for manufactured goods from Europe",
                "The imperatives of capitalist industrialization�including the demand for assured sources of raw materials, the search for guaranteed markets and profitable investment outlets�spurred the European scramble and the partition and eventual conquest of Africa. Thus the primary motivation for European intrusion was economic.");
        this.addQuestion(q107);
        Question q108 = new Question("On the day of Pentecost the Holy Spirit came down in the form of:",
                "A:A cloud",
                "B:a dove",
                "C:Fire",
                "D:water",
                "C:Fire",
                "Acts 2:3-4 And there appeared unto them cloven tongues like as of fire, and it sat upon each of them.And they were all filled with the Holy Ghost, and began to speak with other tongues, as the Spirit gave them utterance.");
        this.addQuestion(q108);
        Question q109 = new Question("What is the value of x in the equation 2(x-6)/3=2/3",
                "A:7 2/3",
                "B:7",
                "C:2 2/3",
                "D:4",
                "B:7",
                "The notes are currently unavailable for Math");
        this.addQuestion(q109);
        Question q110 = new Question("Which sentence is punctuated correctly:",
                "A:Your's was accepted",
                "B:\"Do you like travelling ?\"She asked.",
                "C:Ipu bought the following items:sugar,flour,bread and honey.",
                "D:what a surprise?",
                "B:\"Do you like travelling ?\"She asked.", "The notes are currently unavailable for this question");
        this.addQuestion(q110);
        Question q111 = new Question("Ni maneno yapi yote nui viunganishi?",
                "A:ila,ingawa,lakini,maadamu",
                "B:huyu,hao,ovyo,na",
                "C:ila,lakini,vizuri,wima",
                "D:ingawa,isipokuwa,zuri,safi",
                "A:ila,ingawa,lakini,maadamu",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q111);
        Question q112 = new Question("Which sentence is punctuated correctly:",
                "A:Your's was accepted",
                "B:\"Do you like travelling ?\"She asked.",
                "C:Ipu bought the following items:sugar,flour,bread and honey.",
                "D:what a surprise?",
                "B:\"Do you like travelling ?\"She asked.", "The notes are currently unavailable for this question");
        this.addQuestion(q112);
        Question q113 = new Question("African resistance ganist European colonisation failed mainly because the Africans",
                "A:lacked modern weapons",
                "B:were disunited",
                "C:had small armies",
                "D:had poor means of communication",
                "A:lacked modern weapons",
                "The resistors were unable to come together for common goal of fighting shared  enemies, the Germans fought separated resistant movements in Tanganyika, also, in west African, the defeat of samora Toure was contributed by the density among the African,");
        this.addQuestion(q113);
        Question q114 = new Question("Who among the following people was the first Christian to be killed because of his faith?",
                "A:Philip",
                "B:Paul",
                "C:James",
                "D:Stephen",
                "D:Stephen",
                "Acts 7:59-60 And they stoned Stephen, calling upon God, and saying, Lord Jesus, receive my spirit.And he knelt down, and cried with a loud voice, Lord, lay not this sin to their charge. And when he had said this, he fell asleep.");
        this.addQuestion(q114);
        Question q115 = new Question("In 1998,Wanja harvested 4676 bags of maize.This was 168 bags more than those harvested in 1997,How many bags did she harvest in 1997?",
                "A:177",
                "B:513",
                "C:4508",
                "D:5021",
                "C:4508",
                "The notes are currently unavailable for Math");
        this.addQuestion(q115);
        Question q116 = new Question("The expression\"in quick succession means\"",
                "A:Many events were quickly witnessed",
                "B:The rhythm of life changed suddenly",
                "C:an event taking place before another ends",
                "D:things happening rapidly one after another",
                "D:things happening rapidly one after another", "The notes are currently unavailable for this question");
        this.addQuestion(q116);
        Question q117 = new Question("Kivumishi cha sifa kutokana na kitenzi angaa ni:",
                "A:Angaza",
                "B:Angazia",
                "C:Angamia",
                "D:Angazifu",
                "D:Angazifu",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q117);
        Question q118 = new Question("A pupil immersed a small container filled with soil into a basin of water bubbles were observed.Which one of the following explains the observation",
                "A:Soil reacts with water",
                "B:Water contains air",
                "C:Soil contains air",
                "D:Small animals in soil produces air",
                "C:Soil contains air",
                "Air is expelled from the soil by the water and comes out through bubbles.Proving soil has water");
        this.addQuestion(q118);
        Question q119 = new Question("Which one of the following European countries used the policy of assimilation to administer its colonies in Africa",
                "A:Britain",
                "B:Germany",
                "C:France",
                "D:Portugal",
                "C:France",
                "Assimilation was one ideological basis of French colonial policy in the 19th and 20th centuries. In contrast with British imperial policy, the French taught their subjects that, by adopting French language and culture, they could eventually become French. The famous 'Four Communes' in Senegal were seen as proof of this. Here Africans were, in theory, afforded all the rights of French citizens.");
        this.addQuestion(q119);
        Question q120 = new Question("Which of the following beliefs about God is found in  both Christianity and traditional African Communities.",
                "A:God became man",
                "B:God raises the dead",
                "C:God is everywhere",
                "D:God is three in one",
                "C:God is everywhere",
                "The notes are currently unavailable for this question");
        this.addQuestion(q120);
        Question q121 = new Question("A motorist left home at 10.00 am and travelled to Nairobi, a distance of 225 km.He travelled at an average speed of 90 km/hr.At What time did he reach Nairobi)",
                "A:12.30 p.m",
                "B:12.50 p.m",
                "C:2.30 p.m",
                "D:12.30 a.m",
                "A:12.30 p.m",
                "The notes are currently unavailable for Math");
        this.addQuestion(q121);
        Question q122 = new Question("Choose an alternative that best fill the blanks:Kemboi chose to walk to the mmarket_____it was very hot",
                "A:because",
                "B:but",
                "C:while",
                "D:though",
                "D:though", "The notes are currently unavailable for this question");
        this.addQuestion(q122);
        Question q123 = new Question("7/8 Kwa maneno ni:",
                "A:subui nane",
                "B:Thumni saba",
                "C:Subui",
                "D:Thumuni",
                "B:Thumni saba",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q123);
        Question q124 = new Question("Which one of the following levers has the same position of load,effort and fulcrum as the wheelbarrow?",
                "A:Pair of scissors",
                "B:Nutcracker",
                "C:Fishrod",
                "D:Crowbar",
                "B:Nutcracker",
                "Nutcracker and wheelbarrow are second class levers since the load is in between the fulcrum and effort");
        this.addQuestion(q124);
        Question q125 = new Question("Three of the following are results of European colonial rule in Eastern Africa.Which one is not?",
                "A:Creation of reserves for Africans",
                "B:Promotion of African Culture",
                "C:Introduction of modern health facilities",
                "D:Introduction of modern methods of farming",
                "B:Promotion of African Culture",
                "The impacts of colonization are immense and pervasive.Various effects, both immediate and protracted, include the spread of virulent diseases, unequal social relations, exploitation, enslavement, medical advances, the creation of new institutions, abolitionism,improved infrastructure,and technological progress.Colonial practices also spur the spread of colonist languages, literature and cultural institutions, while endangering or obliterating those of native peoples.");
        this.addQuestion(q125);
        Question q126 = new Question("Which one of the following acts were performed by elders in traditional African communities during worship",
                "A:Sacrificing animals",
                "B:Reciting the creed",
                "C:Baptising members",
                "D:Serving the Holy Communion",
                "A:Sacrificing animals",
                "There is no single African traditional religion that can be seen as a generalized representation of the religious and cultural beliefs of the people of Africa. Africans recognize eternity, omniscience, omnipresence, holiness, justice, mercy, faithfulness and transcendence of God although perceptions of God�s attributes vary from one place to anothe");
        this.addQuestion(q126);
        Question q127 = new Question("Onacha spent 1/9 of his salary on food,3/4 of the remainder on school fees and therest for leisure.if is salary was sh 5400.How much did he spend on leisure",
                "A:sh.4200",
                "B:sh.1800",
                "C:sh.1200",
                "D:sh.750",
                "C:sh.1200",
                "The notes are currently unavailable for Math");
        this.addQuestion(q127);
        Question q128 = new Question("Choose an alternative that best fill the blanks:\"Come first December this year my sister_______two years old\"",
                "A:shall be",
                "B:will be",
                "C:could be",
                "D:should be",
                "B:will be", "The notes are currently unavailable for this question");
        this.addQuestion(q128);
        Question q129 = new Question("Kisawe cha neno BAROBARO ni",
                "A:Banati",
                "B:Kijana",
                "C:Mvulana",
                "D:Shaibu",
                "C:Mvulana",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q129);
        Question q130 = new Question("Which one of the following will NOT cause a reduction in the number of animals in a game reserve?",
                "A:Burning the charcoal",
                "B:Constructing a railway line through the reserve",
                "C:Fencing using electric wire",
                "D:Operating a quarry",
                "C:Fencing using electric wire",
                "The electric Fence will serve to protect the wild animals from external human interference i.e poaching");
        this.addQuestion(q130);
        Question q131 = new Question("The headquaters of the African Union is located in",
                "A:Accra",
                "B:Nairobi",
                "C:Harare",
                "D:Addis Ababa",
                "D:Addis Ababa",
                "The African Union (AU) is a union consisting of 54 African states.The AU was established on 26 May 2001 in Addis Ababa and launched on 9 July 2002 in South AfricaThe African Union's new headquarters complex in Addis Ababa. The main administrative capital of the African Union is in Addis Ababa, Ethiopia, where the African Union Commission is headquartered.");

        this.addQuestion(q131);
        Question q132 = new Question("Which one of the following is the best reason why people in traditional African communities were expected to marry.",
                "A:To be resopected",
                "B:To have a partner",
                "C:To have childern",
                "D:To be accepted",
                "C:To have childern",
                "An African proverb says that children are the adornment of the home. This, therefore, is one of the reasons why Africans marry. It is an aesthetic reason. Another reason is that children are an investment, especially in old age; so there is an economic reason for marriage. ");
        this.addQuestion(q132);
        Question q133 = new Question("Kirwa used a ladder to paint the top of a wall.He placed the bottom of the ladder 4 1/2 meters way from the wall.The ladder touched the wall at a height of 6 meters.What was the length of the ladder",
                "A:7 1/2m",
                "B:10 1/2m",
                "C:15 m",
                "D:56 1/4m",
                "A:7 1/2m",
                "The notes are currently unavailable for Math");
        this.addQuestion(q133);
        Question q134 = new Question("Choose an alteranative that best fill the blanks:The teacher was very_____with the pupils who had not done their homework.",
                "A:sad",
                "B:annoyed",
                "C:disturbed",
                "D:sorry",
                "B:annoyed", "The notes are currently unavailable for this question");
        this.addQuestion(q134);
        Question q135 = new Question("Nomino habari iko katika ngeli ya:",
                "A:U-ZI",
                "B:I-I",
                "C:U-I",
                "D:I-ZI",
                "D:I-ZI",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q135);
        Question q136 = new Question("Which one of the folllowing would help to conserve the environment?",
                "A:Burning heaps of sawdust",
                "B:Burying plastics in the soil",
                "C:Using wood ash to kill pests",
                "D:Using commercial fertilizers to increase crop yield",
                "C:Using wood ash to kill pests",
                "Wood Ash doesnt pollute environment");
        this.addQuestion(q136);
        Question q137 = new Question("Below are ststements about a river in Africa.(i)it passes through a dessert.(ii)its source is a freshwater lake.(iii)it has a delta(iv)it provides water for irrigation",
                "A:River Volta",
                "B:River Tana",
                "C:River Nile",
                "D:River Limpopo",
                "C:River Nile",
                "The River Nile is about 6,670 km (4,160 miles) in length and is the longest river in Africa and in the world. Although it is generally associated with Egypt, only 22% of the Nile�s course runs through Egypt.");

        this.addQuestion(q137);
        Question q138 = new Question("In  traditional African communities ancestors were respected mainly because they",
                "A:appeaed to the living in a dream",
                "B:united the living and the dead",
                "C:reminded people of the past",
                "D:were the dead relatives",
                "B:united the living and the dead",
                "ancestors are revered consequent upon their affairs of their lineage and are believed to have a great deal of influence over their lineage and siblings. They also play a great intermediary role in between the physical and spiritual world");

        this.addQuestion(q138);
        Question q139 = new Question("The cash price of a bed is sh.11 700 .The hire purchase price is 20% more than the cash price.Mbugua bought a bed on hire purchase terms.He paid a deposit of sh.2808 and 12 equal monthly installments.How much was each monthly installment",
                "A:sh.1404",
                "B:sh.1170",
                "C:sh.936",
                "D:sh.546",
                "C:sh.936",
                "The notes are currently unavailable for Math");
        this.addQuestion(q139);
        Question q140 = new Question("Choose one that means the same as the words in Capital:Njeri works very hard IN SPITE OF THE FACT she is very old.",
                "A:although",
                "B:but",
                "C:moreover",
                "D:despite",
                "A:although", "The notes are currently unavailable for this question");
        this.addQuestion(q140);
        Question q141 = new Question("Tano kwa Chokaa.Kitita ni kwa?",
                "A:Pesa",
                "B:Funguo",
                "C:Ndizi",
                "D:Ngozi",
                "A:Pesa",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q141);
        Question q142 = new Question("Which one of the following would least pollute the environment?",
                "A:Gases from factories",
                "B:Exhaust gases from burning charcoal",
                "C:Smoke from burning charcoal",
                "D:rotting plant and animal matter",
                "D:rotting plant and animal matter",
                "Rotting plant and Animal matter decompose to enrich the soil");

        this.addQuestion(q142);
        Question q143 = new Question("Which one of the following factors explains why the Turukana practice nomadic pastoralism?",
                "A:They own large numbers of animals.",
                "B:They live in an area that receives little rainfall",
                "C:They have a liking for adventure",
                "D:They lack land for growing crops",
                "B:They live in an area that receives little rainfall",
                "The Turkana are a Nilotic people native to the Turkana District in northwest Kenya, a semi-arid climate region bordering Lake Turkana in the east, Pokot, Rendille and Samburu to the south, Uganda to the west, and South Sudan and Ethiopia to the north");

        this.addQuestion(q143);
        Question q144 = new Question("Who among the fololowing people is found in Christianity and Traditional African Communities?",
                "A:Herbalist",
                "B:Rainmaker",
                "C:Diviner",
                "D:Prophet",
                "D:Prophet",
                " In arguably its most influential manifestation, the system of prophecy practiced by the Babalawos and Iyanifas of the historically Yoruba regions of West Africa have bequeathed to the world a corpus of fortune-telling poetic methodologies ");

        this.addQuestion(q144);
        Question q145 = new Question("A plane left nairobi at 23 50 hr on Monday and took 1hr 45 minutes to reach Mombasa where it stopped for 50 minutes.It then left Mombasa and took 40 minutes to reach Zanzibar.As what time in am/pm sytem did the plane reach Zanzibar?",
                "A:2.25 a.m.",
                "B:3.05 a.m.",
                "C:2.15 p.m.",
                "D:3.05 p.m",
                "B:3.05 a.m",
                "The notes are currently unavailable for Math");
        this.addQuestion(q145);
        Question q146 = new Question("Choose one that means the same as the words in Capital:Wanyama wanted to MAKE UP FOR the time he had lost.",
                "A:create",
                "B:restore",
                "C:replace",
                "D:recover",
                "D:recover", "The notes are currently unavailable for this question");
        this.addQuestion(q146);
        Question q147 = new Question("Chagua Usemi halisi ufaao wa:Bahati alisema kuwa angeenda nyumbani kupumzika.",
                "A:\"Nimeenda nyumbani kupumzika\",Bahati alisema.",
                "B:\"Niende nyumbani kupumzika\",Bahati alisema.",
                "C:\"Nitaenda nyumbani kupumzika\",Bahati alisema.",
                "D:\"Nilienda nyumbani kupumzika\",Bahati alisema.",
                "C:\"Nitaenda nyumbani kupumzika\",Bahati alisema.",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q147);
        Question q148 = new Question("Which one of the following pairs of plannet consist of a planet that takes the longest time and a planet that a planet that takes the shortest time to go around the sun",
                "A:Jupiter and Mars",
                "B:Pluto and Mercury",
                "C:Earth and Saturn",
                "D:Venus and Neptune",
                "B:Pluto and Mercury",
                "The order of planets from the sun is Mercury,Venus,Earth,Mars,Jupiter,Sartun,Uranus,Neptune and lastly Pluto");
        this.addQuestion(q148);
        Question q149 = new Question("Which of the following minerals is correctly matched with the country in Africaa where it is mined for export?",
                "A:Gold-South Africa",
                "B:Oil-Tanzania",
                "C:Copper-Nigeria",
                "D:Diamonds-Uganda",
                "A:Gold-South Africa",
                "South Africa dominated global gold production in the Twentieth Century and in  1970 accounted for 79% of the entire world�s production. It is estimated that South Africa has produced some 40,000 tonnes of gold since the start of recorded history,about one third of the total worldwide.");
        this.addQuestion(q149);
        Question q150 = new Question("According to Christian teaching the greates fruit of the Holy Spirit is",
                "A:joy",
                "B:love",
                "C:Hope",
                "D:Faith",
                "B:love",
                "1 Corinthians 13:13 So now faith, hope, and love abide, these three; but the greatest of these is love.");

        this.addQuestion(q150);
        Question q151 = new Question("what is the value of  m+r^2/p+r  given m=2p,p=n+5,n=3r,r=5",
                "A: 2 1/5",
                "B:2 3/5",
                "C:3 1/4",
                "D:2",
                "C:3 1/4",
                "The notes are currently unavailable for Math");
        this.addQuestion(q151);
        Question q152 = new Question("Choose one that means the same as the words in Capital:Abdi was in a hurry to  WIND UP the meeting",
                "A:postpone",
                "B:end",
                "C:leave",
                "D:stop",
                "B:end", "The notes are currently unavailable for this question");
        this.addQuestion(q152);
        Question q153 = new Question("Yapange maneno yafuatayo jinsi yanavyoyokea katika kamusi:(i)Bandika(ii)Birika(iii)Beua(iv)Barika",
                "A:(i)(iv)(ii)(iii)",
                "B:(iv)(ii)(iii)(i)",
                "C:(ii)(i)(iii)(iv)",
                "D:(iv)(i)(ii)(iii)",
                "A:(i)(iv)(ii)(iii)",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q153);
        Question q154 = new Question("Which one of the following DOES NOT affect the accuracy of a RainGauge?",
                "A:The Diameter of the funnel",
                "B:The diameter of the collecting jar",
                "C:The distance between the markings on the collecting jar",
                "D:The materials used to make the container",
                "B:The diameter of the collecting jar",
                "The collecting jar only collects rain droplets and is not used to measure the volume of water measured ");
        this.addQuestion(q154);
        Question q155 = new Question("The Drakensberg Mountains was formed as a result of?",
                "A:deposition",
                "B:folding",
                "C:erosion",
                "D:faulting",
                "D:faulting",
                "The Drakensberg  is the name given to the eastern portion of the Great Escarpment, which encloses the central Southern African plateau. The Great Escarpment reaches its greatest altitude in this region (2000 � 3000 m).");

        this.addQuestion(q155);
        Question q156 = new Question("Sarah is sent to buy a kilogram of sugar.The shopkeeper gives her more change.As a Christian,Sarah should?",
                "A:return it to the shop keeper",
                "B:Keep quiet about it",
                "C:use it to buy sweets",
                "D:take it home",
                "A:return it to the shop keeper",
                "Leviticus 19:11 You shall not steal; you shall not deal falsely; you shall not lie to one another.");

        this.addQuestion(q156);
        Question q157 = new Question("A rectangular field measuring 560m by 800m is to be represented on a scale drawing using the scale 1:20000.what is the area of the scale drawing in centimeters?",
                "A:1120",
                "B:22.4",
                "C:11.2",
                "D:2240",
                "C:11.2",
                "The notes are currently unavailable for Math");
        this.addQuestion(q157);
        Question q158 = new Question("Which means the same as the sentence:Had it not been for the quick response of the ambulance team,the patient would not have survived.",
                "A:The ambulance team responded quickly and the patient survived",
                "B:If the ambulance team had responded quickly the patients would have survived ",
                "C:Because the ambulance team responded quickly the patient survived",
                "D:if the ambulance team responded quickly the patient would not have survived",
                "C:Because the ambulance team responded quickly the patient survived",
                "The notes are currently unavailable for this question");
        this.addQuestion(q158);
        Question q159 = new Question("Methali:Abebwaye hujikaza ina maana gani",
                "A:Unaposaidiwa lazima nwe pia ujitahidi",
                "B:Ukibebwa mgongoni usilegee kamwe",
                "C:tusitarajie kusaidiwa bika kusaidia",
                "D:tukiwasaidia wengine lazima tujitahidi",
                "A:Unaposaidiwa lazima nwe pia ujitahidi",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q159);
        Question q160 = new Question("Which one of the following is NOT drug abuse?",
                "A:Taking prescribed drugs for a long time.",
                "B:Taking an overdose of a prescribed drug",
                "C:Using the drug for a wrong sickness",
                "D:Taking less of the prescribed drugs",
                "A:Taking prescribed drugs for a long time.",
                "Drug abuse is the non-medical use of a drug that interferes with a healthy life. Any drug can be abused. Some people develope drug dependence syndrome, can be physical or phychological or both.");
        this.addQuestion(q160);
        Question q161 = new Question("Which one of the following is true about the struggle for independence in Tanganyika?",
                "A:The nationalists established bases in neighbouring countries",
                "B:The nationalists organised querilla warfare",
                "C:The nationalists formed political parties",
                "D:The nationalists were helped by the OAU.",
                "C:The nationalists formed political parties",
                "The Tanganyika African National Union (TANU) was the principal political party in the struggle for sovereignty in the East African state of Tanganyika (now Tanzania). The party was formed from the Tanganyika African Association by Julius Nyerere in July 1954 when he was teaching at St. Francis' College");
        this.addQuestion(q161);
        Question q162 = new Question("Your deskmate Dimon has told you that he is suffering from AIDS.As a Christian which one of the following is the best action to take?",
                "A:Repot the matter to the class teacher",
                "B:Change your sitting position",
                "C:Advise him to seek medical help",
                "D:Inform your classmates",
                "C:Advise him to seek medical help",
                "For friends and family of someone with HIV, it can be difficult to accept the diagnosis. Counselling can help work through issues that have arisen, and offer advice on how best to support the individual.");
        this.addQuestion(q162);
        Question q163 = new Question("A teacher measured the heights of his nine pupils in his class.The heights of the pupils were 167cm,170cm,167cm,175cm,170cm,172cm,167cm,168cm.The total height of the eight pupills was 1356 cm.If the mean height of the nine pupils was 169 cm,what was the median height",
                "A:170cm",
                "B:168cm",
                "C:167 cm",
                "D:165 cm",
                "B:168cm",
                "The notes are currently unavailable for Math");
        this.addQuestion(q163);
        Question q164 = new Question("Which means the same as the sentence:In a court of law people who have broken the law without knowing it still get punished for the offence.",
                "A:people get punished in acourt of law only for breaking the law deliberately",
                "B:Whether people break the law or not they are punished in a court of law.",
                "C:People get punished in a court of law whether or not,they were aware of the law they broke",
                "D:people who get punished in a court of law neither have broken a law nor they aware of it",
                "C:People get punished in a court of law whether or not,they were aware of the law they broke", "The notes are currently unavailable for this question");
        this.addQuestion(q164);
        Question q165 = new Question("\"Kutojihadhari kabla ya hatari \" ni sawa na?",
                "A:Kutojitayarisha kukabiliana na tatizo",
                "B:kutoshughulika na hatari",
                "C:kutoshughulikia matatizo yajapo",
                "D:kutoogopa madhara ya tatizo",
                "A:Kutojitayarisha kukabiliana na tatizo",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q165);
        Question q166 = new Question("Which one of the following is NOT an effect of abusing alcohol",
                "A:Loss of memory",
                "B:Social and family problems",
                "C:Hallucinations",
                "D:Poor Health",
                "C:Hallucinations",
                "The notes are currently unavailable for this question");

        this.addQuestion(q166);
        Question q167 = new Question("The following events took place during the struggle for independence in Kenya.Which one came first?",
                "A:Nomination of the first African to the Legislative Council.",
                "B:The release of Jomo Kenyatta from detention",
                "C:The first Lancaster House Conference",
                "D:Declaration of the State of Emergency",
                "D:Declaration of the State of Emergency",
                "In October 1952, the British declared a state of emergency, which continued until 1960. The State of Emergency was in response to an increase in attacks on the property and persons of white settlers, as well as African chiefs who were seen as collaborators.");

        this.addQuestion(q167);
        Question q168 = new Question("Peter who is a rich man is thinking of how to use his extra money.As a Christian,what advice would you give him?",
                "A:Go for trips abroad",
                "B:Pay school fees  for orphans",
                "C:Build a bigger house for his family",
                "D:Buy a farm for his family",
                "B:Pay school fees  for orphans",
                "Mathew 25:36-40 For I was an hungred, and ye gave me meat: I was thirsty, and ye gave me drink: I was a stranger, and ye took me in:Naked, and ye clothed me: I was sick, and ye visited me: I was in prison, and ye came unto me.Then shall the righteous answer him, saying, Lord, when saw we thee an hungred, and fed thee? or thirsty, and gave thee drink?When saw we thee a stranger, and took thee in? or naked, and clothed thee?Or when saw we thee sick, or in prison, and came unto thee?And the King shall answer and say unto them, Verily I say unto you, Inasmuch as ye have done it unto one of the least of these my brethren, ye have done it unto me.");

        this.addQuestion(q168);
        Question q169 = new Question("A fundraising meeting for Jako,Kabula ,Masindu and Buko rasied sh.108,000 .Jako got three times as much as Buko.Masindu got two-thirds of Jako's share while Kabula got half as much as Jako.How much did Kabula receive?",
                "A:sh.43 200",
                "B:sh.28 800",
                "C:sh.21 600",
                "D:sh.14 400",
                "D:sh.14 400",
                "The notes are currently unavailable for Math");
        this.addQuestion(q169);
        Question q170 = new Question("The word\"feeble \" means the same as",
                "A:dying",
                "B:soft",
                "C:weak",
                "D:slow",
                "C:weak",
                "Feeble:Lacking strength; weak.Indicating weakness.Lacking vigor, force, or effectiveness; inadequate");
        this.addQuestion(q170);
        Question q171 = new Question("Chagua Usemi wa taarifa ufaao wa:\"Kilele cha Mlima Kenya kina theluji nyingi\",Fatuma akasema.",
                "A:Fatuma alisema kwamba kilele cha Mlima Kenya kilikuwa na theluji nyingi.",
                "B:Fatuma anasema kwamba kilele cha Mlima Kenya huwa na theluji nyingi. ",
                "C:Fatuma akasema kwamba kilele cha Mlima Kenya kimekuwa na theluji nyingi. ",
                "D:Fatuma alisema kwamba kilele cha Mlima Kenya kingekuwa na theluji nyingi ",
                "B:Fatuma anasema kwamba kilele cha Mlima Kenya huwa na theluji nyingi.",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q171);
        Question q172 = new Question("Drugs taken to treat diseases are known as",
                "A:curative",
                "B:stimulants",
                "C:preventive",
                "D:pain relievers",
                "A:curative",
                "The notes are currently unavailable for this question");
        this.addQuestion(q172);
        Question q173 = new Question("Three of the following are reasons why fish farms are started.Which one is not?",
                "A:To make harvesting of fish easy",
                "B:To enable farmers to keep the type of fish they require",
                "C:To provide people with jobs",
                "D:To provide clean water for drinking",
                "D:To provide clean water for drinking",
                "There is an increasing demand for fish and fish protein, which has resulted in widespread overfishing in wild fisheries. Fish farming offers fish marketers another source.");

        this.addQuestion(q173);
        Question q174 = new Question("Jane,a standard eight pupil has been asked by her class teacher to go to school on the day of worship.As a Christian the best advice you would give Jane is",
                "A:Obey the class teacher",
                "B:talk to the church leader",
                "C:transfer to another school",
                "D:go to church",
                "D:go to church", "The notes are currently unavailable for this question");
        this.addQuestion(q174);
        Question q175 = new Question("A sales person earns a salary of sh.2000 plus a 5% commission on sales above sh 10,1000.In one month the sales person sold goods worth sh.25000.How much money did the sales person receive that month?",
                "A:sh.3250",
                "B:sh.2750",
                "C:sh.2500",
                "D:sh.750",
                "B:sh.2750",
                "The notes are currently unavailable for Math");
        this.addQuestion(q175);
        Question q176 = new Question("The meaning of the word\"Derived\" as used in \"Spices can be classed from the plat which their are derived \"  is? ",
                "A:found",
                "B:removed",
                "C:btained",
                "D:Produced",
                "B:removed",
                "Derived:To obtain or receive from a source. To arrive at by reasoning; deduce or infer: derive a conclusion from facts.To trace the origin or development of (a word).");

        this.addQuestion(q176);
        Question q177 = new Question("Ni sentensi ipi inayoonyesha matumizi sahihi ya Lau?",
                "A:Lau mwanafunzi anapopita mtihani hutuzwa.",
                "B:Lau ungekuja ningekusaidia",
                "C:Nipe lau kitabu kitabu moja nisome",
                "D:Nitakujuza lau hutaki kujua",
                "D:Nitakujuza lau hutaki kujua",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q177);
        Question q178 = new Question("Which of the following heavenly bodies produces light ",
                "A:Mars ",
                "B:Venus",
                "C:Star",
                "D:Moon",
                "C:Star",
                "A star is a a self-luminous celestial body consisting of a mass of gas held together by its own gravity.");

        this.addQuestion(q178);
        Question q179 = new Question("One of the achivements of Kwame Nkurmah of Ghana is that",
                "A:He led the trade union movement in Ghana during the colonoal periods",
                "B:He abolished taxation in his country",
                "C:He led the country to independence",
                "D:he introduced large scale cocoa farming in Ghana",
                "C:He led the country to independence",
                "Kwame Nkrumah,was the leader of Ghana and its predecessor state, the Gold Coast, from 1951 to 1966. Overseeing the nation's independence from British colonisation in 1957, Nkrumah was the first President of Ghana and the first Prime Minister of Ghana. An influential 20th-century advocate of Pan-Africanism, he was a founding member of the Organisation of African Unity and was the winner of the Lenin Peace Prize in 1963");

        this.addQuestion(q179);
        Question q180 = new Question("Which one of the following was the work of the early Christian missionaries in Kenya?",
                "A:Building schools",
                "B:Appointing Local rulers",
                "C:Setting boundaries for colonies",
                "D:Building Railways",
                "A:Building schools",
                "The education sector in Kenya has gone through significant development processes. The foundation that nurtured its growth was laid down by the early Christian Missionaries who combined the introduction of Christianity among the Africans with education");

        this.addQuestion(q180);
        Question q181 = new Question("What is the expression 7(x+4y+2)+5(2x-y+3)",
                "A:17x+23y+29",
                "B:3x+3y+29",
                "C:17x+3y+5",
                "D:9x+27y+17",
                "A:17x+23y+29",
                "The notes are currently unavailable for Math");
        this.addQuestion(q181);
        Question q182 = new Question("Choose one that best completes the sentence:They have been forbidden.....",
                "A:to go to town?",
                "B:from going to town?",
                "C::not to go to town?",
                "D:no going to town?",
                "B:from going to town?", "The notes are currently unavailable for this question");
        this.addQuestion(q182);
        Question q183 = new Question("Chagua jibu linaloonyesha aina za mashairi.",
                "A:Tarbia.Takhmisa",
                "B:Tarbia,Mizani",
                "C:Vina,Takhmisa",
                "D:Takhmisa,Mishororo",
                "A:Tarbia.Takhmisa",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q183);
        Question q184 = new Question("Which one of the following explains why flowing waters moves objects?Flowing water ",
                "A:has energy of movement",
                "B:is a liquid",
                "C:has potential energy",
                "Carries less dense objects only",
                "A:has energy of movement",
                "Kinetic Energy is the energy of that objects in motion posess");
        this.addQuestion(q184);
        Question q185 = new Question("The main factor that determines the establishment of a textile manufacturing industry is:",
                "A:availability of land",
                "B:availability of workers",
                "C:adequate market",
                "D:adequate transport",
                "C:adequate market",
                "All the above also factor in establishing a textile manufacturing industry");
        this.addQuestion(q185);
        Question q186 = new Question("Which one of the following is the main reason why God Created Eve?He wanted her to?",
                "A:look after the animals",
                "B:take care of the garden of Eden",
                "C:be a companion to Adam",
                "D:eat the fruits of the garden of Eden",
                "C:be a companion to Adam",
                "Genesis 2:20 And Adam gave names to all cattle, and to the fowl of the air, and to every beast of the field; but for Adam there was not found an help meet for him.");
        this.addQuestion(q186);
        Question q187 = new Question("Oduour invested a certain amount of money in a business that paid simple interest at the rate of 15% per annum.At the end of nine months he withdrew sh 1125 which was the interest the money had earned.How much money had he invested",
                "A:5p-60",
                "B:3p-27",
                "C:5p+60",
                "D:5p-30",
                "A:5p-60",
                "The notes are currently unavailable for Math");
        this.addQuestion(q187);
        Question q188 = new Question("Choose one that best completes the sentence:Would you have done that job if you",
                "A:had been paid well?",
                "B:were paid well?",
                "C:could have been paid well?",
                "D:would be paid well",
                "A:had been paid well?",
                "The notes are currently unavailable for this question");
        this.addQuestion(q188);
        Question q189 = new Question("Methali yenye maana sawa na\"Usiache mbachao kwa msala upitao\" ni",
                "A:usione kwenda mbele kurudi nyuma si kazi",
                "B:bahati ya mwenzio usilalie mlango wazi",
                "C:usipoziba ufa utajenga ukuta",
                "D:bura yangu siibadili na rehani",
                "D:bura yangu siibadili na rehani",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q189);
        Question q190 = new Question("Which of the following insect undergoes the stages of egg,nymph,and adult in its life cycle?",
                "A:Tsetse fly",
                "B:Wasp",
                "C:Butterfly",
                "D:Cockroach",
                "C:Butterfly",
                "The dragonfly,Locust, termite, grasshopper and true bug undergo incomplete metamorphosis. In this process there are three stages called egg, nymph and adult");
        this.addQuestion(q190);
        Question q191 = new Question("Which one of the following ativities threatens the existence of natural forests in Kenya?",
                "A:Settling of people around the forests.",
                "B:Destruction of trees by wild animals.",
                "C:Collecting of herbs for making medicine",
                "D:Cutting trees for telephone poles",
                "D:Cutting trees for telephone poles",
                "Kenya has a relatively low forest cover. Closed canopy forest covers about 1.24 million ha. Plantations cover 0.16 million ha. The total forest area is less than 3 per cent of the total land area of Kenya. Most of the indigenous forests occur in high potential areas where they are under severe pressure and competition from other forms of land use");
        this.addQuestion(q191);
        Question q192 = new Question("Which one of the following is a lesson that Christians learn from the story of Joseph in prison?",
                "A:God protects the innocent",
                "B:God forgives his people",
                "C:People should have dreams",
                "D:People should look after their parents",
                "A:God protects the innocent", "The notes are currently unavailable for this question");
        this.addQuestion(q192);
        Question q193 = new Question("Which of the following is 5505055 in words?",
                "A:Five million ,fifty five thousand nad fifty five",
                "B:Five million,five hundred thousand,five hundred and fifty five",
                "C:Five million five,hundred and five thousand and fifty five.",
                "D:Five million,five hhundred and fifty thousand,and fifty five",
                "C:Five million five,hundred and five thousand and fifty five.",
                "The notes are currently unavailable for Math");
        this.addQuestion(q193);
        Question q194 = new Question("Choose one that means the same as the word in capital:Most fresh flowers have a delightful FRAGRANCE. ",
                "A:aroma",
                "B:scent",
                "C:smell",
                "d:odour",
                "B:scent",
                "Fragrance: The state or quality of having a pleasant odor.A sweet or pleasant odor; a scent.A substance, such as a perfume or cologne, designed to emit a pleasant odor.");
        this.addQuestion(q194);
        Question q195 = new Question("Jogoo ni kwa koo,fahali ni kwa",
                "A:ndama",
                "B:kipora",
                "C:tembe",
                "D:mtamba",
                "A:ndama",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q195);
        Question q196 = new Question("Engine oil mixes with kerosene but does not mix with water.Methylated spirit mixes with water but does not mix with kerosene.If the four liquids were put in the same container how many layers would be observed? ",
                "A:1",
                "B:2",
                "C:3",
                "D:4",
                "B:2",
                "Engine Oil will mix with Kerosene to form a single layer,Water and Methylated spirit  will mix to form another layer");
        this.addQuestion(q196);
        Question q197 = new Question("In which one of the following months is the sun overhead at the Tropic of Capricorn?",
                "A:March",
                "B:December",
                "C:June",
                "D:September",
                "C:June",
                "The Tropic of Cancer, also referred to as the northern tropic, is the most northerly circle of latitude on the Earth at which the Sun may appear directly overhead at its culmination. This event occurs once per year, at the time of the June solstice, when the Northern Hemisphere is tilted toward the Sun to its maximum extent");
        this.addQuestion(q197);
        Question q198 = new Question("God led the people of Israel  through the wildernes to the promised land by use of.",
                "A:fire and smoke",
                "B:fire and cloud",
                "C:wind and rainfall",
                "D:thunder and lightening",
                "B:fire and cloud",
                "Exodus 13:21 And the Lord went before them by day in a pillar of a cloud, to lead them the way; and by night in a pillar of fire, to give them light; to go by day and night:");
        this.addQuestion(q198);
        Question q199 = new Question("A rectangular plot measuring 46m by 38 m is to be fenced all round .If three strands of wire are to be used,what would be the total length of the wire required in meters?",
                "A:168",
                "B:252",
                "C:504",
                "D:5244",
                "C:504",
                "The notes are currently unavailable for Math");
        this.addQuestion(q199);
        Question q200 = new Question("Choose one that means the same as the word in capital:Children should not WANDER in the streets.",
                "A:walk",
                "B:stroll",
                "C:loiter",
                "D:roam",
                "C:loiter",
                "Wander:To move about without a definite destination or purpose.To go by an indirect route or at no set pace; amble: wander toward town.To proceed in an irregular course; meander.To go astray: wander from the path of righteousness.To lose clarity or coherence of thought or expression.");
        this.addQuestion(q200);
        Question q201 = new Question("Chagua aina ya pambo ambalo huvaliwa miguuni",
                "A:Kipete",
                "B:Kidani",
                "C:Kikuku",
                "D:Kikuba",
                "D:Kikuba",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q201);
        Question q202 = new Question("A chameleon shoots out its tounge to",
                "A:taste food",
                "B:locate food",
                "C:catch food",
                "D:coll itself",
                "C:catch food",
                "Chameleon feed by firing their sticky tongues at a variety of prey including flies, grasshoppers and butterflies.");
        this.addQuestion(q202);
        Question q203 = new Question("Kenya citizens are allowed to register as voters for parliamentary election when they ",
                "A:become members of political parties",
                "B:have completed primary level of education",
                "C:participate in development projects",
                "D:have attained the age of 18 years",
                "D:have attained the age of 18 years",
                "To be eligible to register to vote, a person must be aged 18 years or over and a Kenyan citizen");
        this.addQuestion(q203);
        Question q204 = new Question("David is remembered as a great King of Israel because he..",
                "A:Killed Goliath",
                "B:married many wives",
                "C:Built palace for himself",
                "D:Killed wild animals",
                "A:Killed Goliath",
                "1 Samuel 17:50-51 So David triumphed over the Philistine with a sling and a stone; without a sword in his hand he struck down the Philistine and killed him.David ran and stood over him. He took hold of the Philistine�s sword and drew it from the sheath. After he killed him, he cut off his head with the sword.");
        this.addQuestion(q204);
        Question q205 = new Question("An empty box weighed 2.5 kg.Kombe packed books in the box until the total weight was 9.5 kg.If each book weighed 250 g,how many books were packed?",
                "A:10",
                "B:28",
                "C:38",
                "D:280",
                "B:28",
                "The notes are currently unavailable for Math");
        this.addQuestion(q205);
        Question q206 = new Question("Choose one that means the same as the word in capital:She DESERVED that reward.",
                "A:got",
                "B:won",
                "C:carned",
                "D:gained",
                "B:won",
                "Deserved:Merited or earned");
        this.addQuestion(q206);
        Question q207 = new Question("Umoja wa sentensi \"Waungwana wowote hawawezi kutufanyia fujo \" ni",
                "A:Muungwana yeyote hawezi kutufanyia fujo.",
                "B:Muungwana yeyote hawezi kunifanyia fujo.",
                "C:Muungwana yoyote hawezi kunifanyia fujo.",
                "D:Muungwana yoyote hawezi kutufanyia fujo.",
                "B:Muungwana yeyote hawezi kunifanyia fujo.",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q207);
        Question q208 = new Question("Which choice contains a flowering plant and a non-flowering plant respectively? ",
                "A:Fern,Moss",
                "B:Banana,Fern",
                "C:Moss,Mushroom",
                "D:Grass,Banana",
                "B:Banana,Fern",
                "Bananas form Flowers while Ferns posees  false  flowers");
        this.addQuestion(q208);
        Question q209 = new Question("Suspected criminals are kept in cells before being taken to court in order to.",
                "A:punish them for the offences they have commited",
                "B:allow time for carrying out investigations",
                "C:give them  time to contact their relatives",
                "D:make them clean up the cells",
                "B:allow time for carrying out investigations",
                "The notes are currently unavailable for this question");
        this.addQuestion(q209);
        Question q210 = new Question("Who among the following people was a priest when Samuel was called by God?",
                "A:Elikana",
                "B:Elijah",
                "C:Aaron",
                "D:Eli",
                "D:Eli",
                "1 Samuel 1:9 So Hannah rose up after they had eaten in Shiloh, and after they had drunk. Now Eli the priest sat upon a seat by a post of the temple of the Lord.");
        this.addQuestion(q210);
        Question q211 = new Question("Maria agreed to loan Luvisha sh 10,000 at a opmound intrest of 15% per annum.How Much money altogether did Luvuisia had to pay",
                "A:sh 13225",
                "B:sh 13000",
                "C:sh 11500",
                "D:sh 3225",
                "A:sh 13225",
                "The notes are currently unavailable for Math");
        this.addQuestion(q211);
        Question q212 = new Question("Choose an alteranative that best fill the blanks:Since Rehema could not get a matatu she travelled home______a bus",
                "A:by",
                "B:on",
                "C:in",
                "D:with",
                "A:by", "The notes are currently unavailable for this question");
        this.addQuestion(q212);
        Question q213 = new Question("Chagua sentensi ambayo ni muungano sahihi wa hizi:\nMburukenge aliingia uwanzani.\nMburukenge aliwafadhaisha wanafunzi.",
                "A:Mburukenge aliingia uwanjani na kuwafadhaisha wanafunzi",
                "B:Mburukenge aliingia uwanjani kwa kuwafadhaisha wanafunzi",
                "C:Mburukenge aliingia uwanjani lakini  aliwafadhaisha wanafunzi",
                "D:Mburukenge aliingia uwanjani kwani aliwafadhaisha wanafunzi",
                "A:Mburukenge aliingia uwanjani na kuwafadhaisha wanafunzi",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q213);
        Question q214 = new Question("On a cold day most birds raise their fathers to",
                "A:allow air to escape from escape from their bodies",
                "B:allow even distribution of heat in the body",
                "C:avoid losing heat from their bodies",
                "D:generate heat",
                "C:avoid losing heat from their bodies",
                "Raising feathers trap air pockets hence insulating the birds skin from loss of heat ");
        this.addQuestion(q214);
        Question q215 = new Question("Which one of the following statements explains why farmers in the Kenya highlands grow most of the tea in small scale farms?",
                "A:There is scarcity of land to establish large farms",
                "B:It is expensive to establish large farms",
                "C:There are too few labourers to work on large farms",
                "D:There are too few factories to process tea from large farms",
                "A:There is scarcity of land to establish large farms",
                "The main tea growing areas in Kenya are situated in and around the highland areas on both sides of the Great Rift Valley; and astride the Equator within altitudes of between 1500 metres and 2700 metres above the sea level.");
        this.addQuestion(q215);
        Question q216 = new Question("Who among the following people visited baby Jesus?",
                "A:The Samaritans",
                "B:King Herod",
                "C:The Pharises",
                "D:The Shephereds",
                "D:The Shephereds",
                "Luke 2:15-17 When the angels had left them and gone into heaven, the shepherds said to one another, �Let�s go to Bethlehem and see this thing that has happened, which the Lord has told us about.�So they hurried off and found Mary and Joseph, and the baby, who was lying in the manger. 17 When they had seen him, they spread the word concerning what had been told them about this child,");
        this.addQuestion(q216);
        Question q217 = new Question("A motorist covers 3 km in every 1 3/4 minutes.How many kilometers will he have covered from 8.19 am to 9.08 am?",
                "A:2.8",
                "B:8.4",
                "C:1.47",
                "D:1.4",
                "D:1.4",
                "The notes are currently unavailable for Math");
        this.addQuestion(q217);
        Question q218 = new Question("Choose an alteranative that best fill the blanks:When do you expect to___in Mombasa?",
                "A:get",
                "B:go",
                "C:reach",
                "D:arrive",
                "D:arrive",
                "The notes are currently unavailable for this question");
        this.addQuestion(q218);
        Question q219 = new Question("Kumpiga vitu vijembe ni:",
                "A:Kumpa sifa asizostahili",
                "B:Kumsema kwa mafumbo",
                "C:Kumchafulia mtu jina",
                "D:Kumfanyia ishara ya dharau",
                "B:Kumsema kwa mafumbo",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q219);
        Question q220 = new Question("Which one of the following drugs is a stimulant when used in small quantities but a depressant when used in large quantities?",
                "A:Tobacco",
                "B:Coffee",
                "C:Khat",
                "D:Alcohol",
                "D:Alcohol",
                "Interestingly enough, alcohol is in two categories. The main category, of course, is a depressant. It makes people slow down and lose motor skills. On the other hand, alcohol can also be said to be a stimulant because it causes people to lose inhibitions in smaller amounts.");
        this.addQuestion(q220);
        Question q221 = new Question("Which of the following is the safest point for a pedestrian to cross a busy road?",
                "A:At a junction",
                "B:At a bend",
                "C:At a footbridge",
                "D:At a roundabout",
                "C:At a footbridge",
                "A footbridge or a pedestrian bridge is a bridge designed for pedestrians and in some cases cyclists, animal traffic and horse riders, rather than vehicular traffic");
        this.addQuestion(q221);
        Question q222 = new Question("Who among the following people were in the temple when Jesus was dedicated to God?",
                "A:Zachariah and Elizabeth",
                "B:Simeone and Anna",
                "C:Ananias and Saphira",
                "D:Lazarus and Martha",
                "B:Simeone and Anna",
                "The notes are currently unavailable for this question");
        this.addQuestion(q222);
        Question q223 = new Question("What is the value of 5.0-2.65�0.001?",
                "A:4.999735",
                "B:4.99735",
                "C:4.9735",
                "D:0.00235",
                "B:4.99735",
                "The notes are currently unavailable for Math");
        this.addQuestion(q223);
        Question q224 = new Question("Choose sentence that is correctly punctuated:",
                "A:\"That is a very hard working pupil,\"the teacher said.",
                "B:\"That is a very hard working pupil\",the teacher said.",
                "C:\"That is a very hard working pupil.\",\"the teacher said.",
                "D:\"That is a very hard working pupil.The teacher said.\"",
                "B:\"That is a very hard working pupil\",the teacher said.",
                "The notes are currently unavailable for this question");
        this.addQuestion(q224);
        Question q225 = new Question("Ugonjwa wa ukambi pia huitwa",
                "A:surua",
                "B:safura",
                "C:ndui",
                "D:tetewega",
                "C:ndui",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q225);
        Question q226 = new Question("Which one of the following ways of producing light involves energy changes from chemical to electrical and lastly to heat and light?Using a",
                "A:bicycle dynamo",
                "B:hydroelectric generator",
                "C:solar cells",
                "D:torch",
                "D:torch",
                "Chemical energy is in the torch battery cells  which is then transferred through the cables,The Electricity heats the bulb filament of the torch which lights up ");
        this.addQuestion(q226);
        Question q227 = new Question("A good citizen of Kenya is one who",
                "A:attends prayer  meetings regularly",
                "B:Obeys the laws of the land",
                "C:Attends political rallies regularly",
                "D:Owns a lot of property",
                "B:Obeys the laws of the land",
                "Regardless of the presence of elected representatives:Every citizen has an obligation to respect, uphold and defend Kenya�s sovereignty and also to live out the national values and principles of: patriotism, national unity, sharing and devolution of power, the rule of law, democracy and participation of the people.");
        this.addQuestion(q227);
        Question q228 = new Question("Which one of the following parables of Jesus teaches about forgiveness?The parable of the:",
                "A:Sower",
                "B:Good samaritan",
                "C:Prodigal son",
                "D:Rich man and Lazarus",
                "C:Prodigal son",
                "Luke 2:25 Now there was a man in Jerusalem called Simeon, who was righteous and devout. He was waiting for the consolation of Israel, and the Holy Spirit was on him Luke 2:36 There was also a prophet, Anna, the daughter of Penuel, of the tribe of Asher. She was very old; she had lived with her husband seven years after her marriage, ");
        this.addQuestion(q228);
        Question q229 = new Question("The cylinder has a volume of 550 cm3.if the geight of the cylinder is 7cm,what is its diameter?(Take pi=22/7) ",
                "A:50 cm",
                "B:25 cm",
                "C:10 cm",
                "D:5 cm",
                "C:10 cm",
                "The notes are currently unavailable for Math");
        this.addQuestion(q229);
        Question q230 = new Question("Choose sentence that is correctly punctuated:",
                "A:What long hair you have!",
                "B:He went home early,Didn't he?",
                "C:Our science teachers sent us to look for grasshoppers flowers frogs and green leaves",
                "D:Its good to always drink clean water.",
                "A:What long hair you have!", "The notes are currently unavailable for this question");
        this.addQuestion(q230);
        Question q231 = new Question("Sahihisha:Kule mlikolima hamna rutuba",
                "A:Kule mlipolima hamna rutuba",
                "B:Pale mlipolima hamna rutuba",
                "C:Kule mlikolima hakuna rutuba",
                "D:Mle mlimolima hakuna rutuba",
                "C:Kule mlikolima hakuna rutuba",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q231);
        Question q232 = new Question("Fruits that are dispersed by water ",
                "A:have pods wit lines of weakness",
                "B:are small and hairy",
                "C:are hollow and fibrous",
                "D:are small with hooks",
                "C:are hollow and fibrous", "The notes are currently unavailable for this question");
        this.addQuestion(q232);
        Question q233 = new Question("Which one of the following officers is appointed by the Public Service Commission(PSC) of Kenya?",
                "A:Chiefs to head locations",
                "B:Speaker of the national Assembly",
                "C:Headteachers of primary schools",
                "D:Judges of the high court",
                "A:Chiefs to head locations",
                "The Public Service Commission  of Kenya is an Independent government Commission established under the Constitution of Kenya to manage human resources in the Kenya Civil Service and the Local Authorities.");
        this.addQuestion(q233);
        Question q234 = new Question("\"I promise you today you will be in paradise with me.\"(Luke 23:43)Jesus said these words when he was",
                "A:in the garden of Gesthsemane",
                "B:at the sea of Tiberias",
                "C:on the way to Emmaus",
                "D:on the cross",
                "D:on the cross",
                "Luke 23:39-40 One of the criminals who hung there hurled insults at him: �Aren�t you the Messiah? Save yourself and us!�But the other criminal rebuked him. �Don�t you fear God,� he said, �since you are under the same sentence? 41 We are punished justly, for we are getting what our deeds deserve. But this man has done nothing wrong.�");
        this.addQuestion(q234);
        Question q235 = new Question("Twenty-four-5 deciliter packets of milk were emptied into a 50-litre container.How many more such packets of milk were needed to fill the cointainer?",
                "A:100",
                "B:76",
                "C:52",
                "D:38",
                "B:76",
                "The notes are currently unavailable for Math");
        this.addQuestion(q235);
        Question q236 = new Question("The word \"fascinated\" is similar in meaning to?",
                "A:surprised",
                "B:excited",
                "C:amazed",
                "D:amused",
                "C:amazed",
                "Fascinate:To hold an intense interest or attraction for.To hold motionless; spellbind.");
        this.addQuestion(q236);
        Question q237 = new Question("Chagua nomino kutokana na kitenzi Kumbuka",
                "A:Kumbukika",
                "B:Kumbukwa",
                "C:Kumbusha",
                "D:Kumbusho",
                "D:Kumbusho",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q237);
        Question q238 = new Question("A certain animal lays eggs,has scales,and the body temperatures varies with the surrounding.The animal is likely to be a",
                "A:snake",
                "B:platypus",
                "C:toad",
                "D:duck",
                "A:snake",
                "The Animal Described is a Mamall");
        this.addQuestion(q238);
        Question q239 = new Question("Three of the following statements are true about Mount Kilimanjaro.Which one is NOT?",
                "A:It is the highest Mountain in Africa",
                "B:It is covered with snow at the top",
                "C:It is a source of river Tana",
                "D:It is located in Tanzania",
                "C:It is a source of river Tana",
                "There are three volcanoes on Kilimanjaro - Mawenzi, Shira and Kibo. Mawenzi and Shira are extinct, but Kibo is dormant. The last major eruption was 360 000 years ago.");
        this.addQuestion(q239);
        Question q240 = new Question("After the resurrection of Jesus he promised to send for the Holy Spirit who would help them to.",
                "A:become wealthy",
                "B:conqueer the Roman Empire",
                "C:serve in the Jewish council",
                "D:preach good news",
                "D:preach good news",
                "Acts 1:8 But you will receive power when the Holy Spirit comes on you; and you will be my witnesses in Jerusalem, and in all Judea and Samaria, and to the ends of the earth.�");
        this.addQuestion(q240);
        Question q241 = new Question("The top of a 25m ladder leans on a vertical wall with its lowered touching the ground.Which one of the following sets of measurements represents te height of the wall and the horizontal distance of the ladder from the wall?",
                "A:12 m and 13 m",
                "B:3 m and 4 m",
                "C:5 m and 12 m",
                "D:7m and 24 m",
                "D:7m and 24 m",
                "The notes are currently unavailable for Math");
        this.addQuestion(q241);
        Question q242 = new Question("Which of the following can best replace the word \"furious\"?",
                "A:upset",
                "B:enraged",
                "C:annoyed",
                "D:irritated",
                "B:enraged",
                " Furious:Full of or characterized by extreme anger; raging.Suggestive of extreme anger in action or appearance; fierce.Full of activity; energetic or rapid:");
        this.addQuestion(q242);
        Question q243 = new Question("Umbu,Mkoi,Halati wote ni",
                "A:jamii",
                "B:wakwe",
                "C:jamaa",
                "D:marafiki",
                "A:jamii",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q243);
        Question q244 = new Question("The type of modified roots found in mangroves are called",
                "A:breathing",
                "B:prop",
                "C:butress",
                "D:clasping",
                "A:breathing",
                "Breathing roots of the mangrooves are adapted in order to enable gaseous exchange for the plant");
        this.addQuestion(q244);
        Question q245 = new Question("The climate of the Congo Basin is generally?",
                "A:cold and wet throughout the year",
                "B:Cold and dry for most of the year",
                "C:Hot and dry for most of the year",
                "D:hot and wet throughout the year",
                "D:hot and wet throughout the year",
                "The Congo Basin climate is warm and humid; with two main seasons: one long rainy season and a dry season with slightly less rains. It rains about 117 days per year with a total of approximately 1,766mm of rainfall.");
        this.addQuestion(q245);
        Question q246 = new Question("The resurrection of Jesus teaches Christians to be :",
                "A:tolerant",
                "B:obedient",
                "C:hopeful",
                "D:honest",
                "C:hopeful",
                " Hebrews 6:19 We have this hope as an anchor for the soul, firm and secure. It enters the inner sanctuary behind the curtain,");
        this.addQuestion(q246);
        Question q247 = new Question("Kazungu bought a radio on hire purchase terms.He paid a deposit a deposit of sh 900 and 9 equal monthly instalments of sh 300.The hire purchase price was 20% more than the marked price.What was the marked price of the radio?",
                "A:sh 720",
                "B:sh 2880",
                "C:sh 3000",
                "D:sh 3600",
                "C:sh 3000",
                "The notes are currently unavailable for Math");
        this.addQuestion(q247);
        Question q248 = new Question("Which of the following can best replace the word \"agressive\" in the text \"The aggresive campaign through advertisements\"",
                "A:tough",
                "B:strict",
                "C:offensive",
                "D:serious",
                "D:serious",
                "Agressive:assertive; vigorous,forceful, enterprising, assertive");
        this.addQuestion(q248);
        Question q249 = new Question("Kitendawil\"Nikitembea yuko,nikikimbia yuko,nikiingia ndani hayuko,\"jibu lake ni",
                "A:Mwanga",
                "B:Kivuli",
                "C:Mwangwi",
                "D:Upepo",
                "B:Kivuli",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q249);
        Question q250 = new Question("Which of the following aspects of an object cannot be changed?",
                "A:Mass",
                "B:Density",
                "C:Weight",
                "D:Volume",
                "A:Mass",
                "Quantity of matter(mass) cannot be created nor destroyed:Law of conservation of matter");
        this.addQuestion(q250);
        Question q251 = new Question("Water pollution in Lake Victoria is caused mainly by",
                "A:plants qrowing in the water",
                "B:waste from factories in the Area",
                "C:People bathing in the area",
                "D:Waste from nearby homes",
                "B:waste from factories in the Area",
                "Pollution of Lake Victoria is mainly due to discharge of raw sewage into the lake, dumping of domestic and industrial waste, and fertiliser and chemicals from farms.");

        this.addQuestion(q251);
        Question q252 = new Question("Which one of the following is a reason why Stephen was stoned to death?He",
                "A:wanted to lead a rebelion",
                "B:refused to deny Jesus",
                "C:refused to pay taxes",
                "D:worked on the Sabath day",
                "B:refused to deny Jesus",
                "Acts 6:13 They produced false witnesses, who testified, �This fellow never stops speaking against this holy place and against the law. 14 For we have heard him say that this Jesus of Nazareth will destroy this place and change the customs Moses handed down to us.�");
        this.addQuestion(q252);
        Question q253 = new Question("The length of a rectangle is represented by the expression (2x+8)cm and its width by the expression(x-6)cm . if the perimeter is 58 cm,what is the actual length of the rectangle? ",
                "A:3 cm",
                "B:9 cm",
                "C:26 cm",
                "D:45 1/3 cm",
                "C:26 cm",
                "The notes are currently unavailable for Math");
        this.addQuestion(q253);
        Question q254 = new Question("Which of the following can best replace the word \"fatal\"?",
                "A:dangerous",
                "B:bad",
                "C:painful",
                "D:deadly",
                "D:deadly",
                "Fatal:causing or capable of causing death; mortal; deadly");
        this.addQuestion(q254);
        Question q255 = new Question("Maana ya neno:Kusajiliwa ni:",
                "A:Kurekebisha",
                "B:Kunufaishwa",
                "C:Kuandikishwa",
                "D:Kufundishwa",
                "C:Kuandikishwa",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q255);
        Question q256 = new Question("Which one of the following should NOT be the same when comparing rates of melting in substances?",
                "A:Quantity of substances ",
                "B:Amount of heat",
                "C:The substances",
                "D:Duration of heating",
                "C:The substances",
                "The test is on melting of different substances,The Substances should vary");
        this.addQuestion(q256);
        Question q257 = new Question("Three of the following statements are true about the functions of the President of Kenya.Which one is not?",
                "A:chairs Cabinet Meetings",
                "B:is The Chancellor of Public Universities",
                "C:clears candidates for general elections",
                "D:is the head of the Central Government",
                "D:is the head of the Central Government",
                "The President is the Head of Government and wields executive authority,he co-ordinates and supervises all major sections of the executive branch.");
        this.addQuestion(q257);
        Question q258 = new Question("Which one of the following New Testament books is a gospel?",
                "A:Hebrews",
                "B:Galatians",
                "C:John",
                "D:James",
                "C:John", "The Gospel Books are Matthew,Mark,Luke and John");
        this.addQuestion(q258);
        Question q259 = new Question("Cheptoo was hired for 8 hours a day from Monday to Friday and 5 hours on Saturday.She was paid sh 5850 per week.Cheptoo now works 10 hours a day from Monday and is free on Saturday.What is her weekly pay if she is paid at the same rate per hour as before? ",
                "A:sh 4500",
                "B:sh 5265",
                "C:sh 5300",
                "D:sh 6500",
                "D:sh 6500",
                "The notes are currently unavailable for Math");
        this.addQuestion(q259);
        Question q260 = new Question("Choose one that means the same as the word in capital:Nafula QUIT her job to go to America.",
                "Aabandoned:",
                "B:deserted",
                "C:ignored",
                "D:left",
                "D:left",
                "Quit:to stop, cease, or discontinue,to depart from; leave,to give up or resign; let go; relinquish");
        this.addQuestion(q260);
        Question q261 = new Question("Nomino Kibogoyo iko Katika Ngeli gani",
                "A:KI-VI",
                "B:U-ZI",
                "C:A-WA",
                "D:I-ZI",
                "C:A-WA",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q261);
        Question q262 = new Question("The planet with a ring around it is",
                "A:Mercury",
                "B:Saturn",
                "C:Pluto",
                "D:Jupiter",
                "B:Saturn",
                "The planet Jupiter has a system of rings, known as the rings of Jupiter or the Jovian ring system");
        this.addQuestion(q262);
        Question q263 = new Question("The colour of the National flag of Kenya which represents peace is?",
                "A:white",
                "B:green",
                "C:black",
                "D:red",
                "A:white",
                " The colour black represents the people of the Republic of Kenya, red for the blood shed during the fight for independence, green for the country's landscape and the white fimbriation was added later to symbolize peace and honesty. The black, red, and white traditional Maasai shield and two spears symbolize the defense of all the things mentioned peace and honesty");
        this.addQuestion(q263);
        Question q264 = new Question("Three of the folowing ativities in the early Church demonstrated unity among the believers.Which one does not?",
                "A:Meeting in the temple for worship ",
                "B:Helping the needy",
                "C:Breaaking of the bread",
                "D:Speaking in tongues",
                "D:Speaking in tongues",
                "Speaking in tongues was is a gift of the holy spirit");
        this.addQuestion(q264);
        Question q265 = new Question("What is the value of 21�8 correct to two decimal places?",
                "A:2.6",
                "B:2.62",
                "C:2.625",
                "D:2.63",
                "D:2.63", "TEST");
        this.addQuestion(q265);
        Question q266 = new Question("Choose one that means the same as the word in capital:He has been ACQUITTED for all the charges",
                "A:freed",
                "B:forgiven",
                "C:discharged",
                "D:released",
                "D:released",
                "Acqit:to relieve from a charge of fault or crime; declare not guilty:");
        this.addQuestion(q266);
        Question q267 = new Question("Siku baada ya kesho kutwa ni?",
                "A:juzi",
                "B:mtondogoo",
                "C:mtondo",
                "D:ALasiri",
                "C:mtondo",
                "The notes are currently unavailable in kiswahili");
        this.addQuestion(q267);
        Question q268 = new Question("The soil that drains water fastest",
                "A:has small air spaces",
                "B:cracks when dry",
                "C:has poor capillarity",
                "D:has smooth texture",
                "C:has poor capilarity",
                "The soil that drains water fastest has the largest air particles hence making its capillarity poor");
        this.addQuestion(q268);
        Question q269 = new Question("Which one of the following groups of security departments is responsible for protecting Kenya aganist external attack?",
                "A:Army,Prison wardens",
                "B:Police forces,prison Wardens",
                "C:Air Force,Police force",
                "D:Army,Air force",
                "D:Army,Air force",
                "The Kenya Defence Forces are the armed forces of the Republic of Kenya. The Kenya Army, Kenya Navy, and Kenya Air Force comprise the national Defence Forces.The Kenya defence force protects Kenya from external attacks");
        this.addQuestion(q269);
        Question q270 = new Question("During worship offerings are given in both Christianity and Traditional African communities s a way of showing",
                "A:thanksgiving",
                "B:Mercy",
                "C:Patience",
                "D:Justice",
                "A:thanksgiving",
                "Traditional African religion is a way of life in which ancestors are part of every major event such as wedding, births and deaths as well as less important ones such as getting a job and finishing university. During these events usually an offering is made to honour, please and thank the ancestors");
        this.addQuestion(q270);
        Question q271 = new Question("t",
                "a",
                "b",
                "c",
                "d",
                "ans",
                " note");
        this.addQuestion(q271);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
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
        dbase.insert(TABLE_QUEST, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_QUEST;
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
        String selectQuery = "SELECT * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row = cursor.getCount();
        return row;
    }

}