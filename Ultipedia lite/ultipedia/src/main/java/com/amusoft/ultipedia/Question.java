package com.amusoft.ultipedia;

public class Question {
    private int ID;
    private String QUESTION;
    private String OPTA;
    private String OPTB;
    private String OPTC;
    private String OPTD;
    private String ANSWER;
    private String NOTE;

    public Question() {

        ID = 0;
        QUESTION = "";
        OPTA = "";
        OPTB = "";
        OPTC = "";
        OPTD = "";
        ANSWER = "";
        NOTE = "";
    }

    public Question(String qUESTION, String oPTA, String oPTB, String oPTC, String oPTD,
                    String aNSWER, String nOTE) {

        QUESTION = qUESTION;
        OPTA = oPTA;
        OPTB = oPTB;
        OPTC = oPTC;
        OPTD = oPTD;
        ANSWER = aNSWER;
        NOTE = nOTE;

    }

    public int getID() {
        return ID;
    }

    public void setID(int id) {
        ID = id;
    }

    public String getQUESTION() {
        return QUESTION;
    }

    public void setQUESTION(String qUESTION) {
        QUESTION = qUESTION;
    }

    public String getOPTA() {
        return OPTA;
    }

    public void setOPTA(String oPTA) {
        OPTA = oPTA;
    }

    public String getOPTB() {
        return OPTB;
    }

    public void setOPTB(String oPTB) {
        OPTB = oPTB;
    }

    public String getOPTC() {
        return OPTC;
    }

    public void setOPTC(String oPTC) {
        OPTC = oPTC;
    }

    public String getOPTD() {
        return OPTD;
    }

    public void setOPTD(String oPTD) {
        OPTD = oPTD;
    }

    public String getANSWER() {
        return ANSWER;
    }

    public void setANSWER(String aNSWER) {
        ANSWER = aNSWER;
    }

    public String getNOTE() {
        return NOTE;
    }

    public void setNOTE(String nOTE) {
        NOTE = nOTE;
    }

}