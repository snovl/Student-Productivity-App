package com.example.cpscproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    // Database Version
    public static final int DATABASE_VERSION = 1;
    // Database Name
    public static final String DATABASE_NAME = "maxApp.db";
    // Table Names
    public static final String TABLE_CLASS = "CLASS";
    public static final String TABLE_EVENT = "EVENT";
    public static final String TABLE_EXAM = "EXAM";
    public static final String TABLE_EXERCISE = "EXERCISE";
    public static final String TABLE_FOOD_TYPE = "FOOD_TYPE";
    public static final String TABLE_GOAL = "GOAL";
    public static final String TABLE_GRADEBOOK = "GRADEBOOK";
    public static final String TABLE_MEETING = "MEETING";
    public static final String TABLE_NUTRITION = "NUTRITION";
    public static final String TABLE_OTHER_EVENT = "OTHER_EVENT";
    public static final String TABLE_OTHER_USER = "OTHER_USER";
    public static final String TABLE_PERFORMS_EXERCISE = "PERFORMS_EXERCISE";
    public static final String TABLE_PROJECT = "PROJECT";
    public static final String TABLE_RECORDED_IN = "RECORDED_IN";
    public static final String TABLE_SELFCARE = "SELFCARE";
    public static final String TABLE_SLEEP = "SLEEP";
    public static final String TABLE_STREAK = "STREAK";
    public static final String TABLE_STUDENT = "STUDENT";
    public static final String TABLE_STUDENT_WORKS_ON_PROJECT = "STUDENT_WORKS_ON_PROJECT";
    public static final String TABLE_USER = "USER";
    public static final String TABLE_USERS_SLEEP = "USERS_SLEEP";
    public static final String TABLE_WORKER = "WORKER";
    public static final String TABLE_WORKER_WORKS_ON_PROJECT = "WORKER_WORKS_ON_PROJECT";

    //Common column names
    public static final String USSN = "USSN";
    public static final String SSN = "SSN";
    public static final String DURATION = "Duration";
    public static final String NAME = "Name";
    public static final String EVENTID = "EventID";
    public static final String DATE = "Date";
    public static final String TYPE = "Type";
    public static final String CLASSNAME = "ClassName";
    public static final String NUMGRADE = "NumGrade";
    public static final String LETTERGRADE = "LetterGrade";
    public static final String FOODID = "NumGrade";
    public static final String STUDENTID = "StudentID";
    public static final String PROJECTID = "ProjectID";

    //CLASS Table - column names
    public static final String CLASS_NUM = "ClassNum";

    //EVENT Table - column names
    public static final String EVENT_TRAVELTIME = "TravelTime";

    //GOAL Table - column names
    public static final String GOALID = "GoalID";
    public static final String GOAL_EDC = "EDC";

    //NUTRITION table - column names
    public static final String CALORIES = "Calories";
    public static final String PROTEIN = "Protein";
    public static final String CARBS = "Carbs";
    public static final String FAT = "Fat";

    //PROJECT table - column names
    public static final String PROJECTNAME = "ProjectName";
    public static final String PROJECT_DUEDATE = "DueDate";

    //SLEEP table - column names
    public static final String SLEEP_QUALITY = "ProjectID";

    //STREAK table - column names
    public static final String STREAK_CURRCONDAYS = "CurrConDays";
    public static final String STREAK_RECORDDAYS= "RecordDays";

    //USER table - column names
    public static final String USER_FNAME = "FName";
    public static final String USER_MINIT = "Minit";
    public static final String USER_LNAME = "LName";
    public static final String USER_UFLAG = "UFlag";
    public static final String USER_WFlag = "WFlag";
    public static final String USER_SFlag = "SFlag";




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       // Create statements
        db.execSQL("create table " + TABLE_CLASS +" (ClassName TEXT PRIMARY KEY,ClassNum INTEGER,USSN INTEGER)");
        db.execSQL("create table " + TABLE_EVENT +" (EventID INTEGER PRIMARY KEY,TravelTime INTEGER,Duration INTEGER, Name TEXT, USSN INTEGER)");
        db.execSQL("create table " + TABLE_EXAM +" (EventID INTEGER PRIMARY KEY,NumGrade INTEGER,LetterGrade TEXT)");
        db.execSQL("create table " + TABLE_EXERCISE +" (Date INTEGER PRIMARY KEY,Duration INTEGER,Type TEXT)");
        db.execSQL("create table " + TABLE_FOOD_TYPE +" (FoodID INTEGER PRIMARY KEY,Type TEXT)");
        db.execSQL("create table " + TABLE_GOAL+" (GoalID INTEGER PRIMARY KEY,EDC INTEGER,Name TEXT,USSN INTEGER)");
        db.execSQL("create table " + TABLE_GRADEBOOK +" (ClassName INTEGER PRIMARY KEY,NumGrade INTEGER,LetterGrade TEXT)");
        db.execSQL("create table " + TABLE_MEETING +" (EventID INTEGER PRIMARY KEY,Type TEXT)");
        db.execSQL("create table " + TABLE_NUTRITION +" (Date INTEGER PRIMARY KEY,Calories INTEGER,FoodID INTEGER, Protein INTEGER, Carbs INTEGER, Fat INTEGER)");
        db.execSQL("create table " + TABLE_OTHER_EVENT +" (EventID INTEGER PRIMARY KEY)");
        db.execSQL("create table " + TABLE_OTHER_USER +" (SSN INTEGER PRIMARY KEY)");
        db.execSQL("create table " + TABLE_PERFORMS_EXERCISE +" (USSN INTEGER PRIMARY KEY,Date INTEGER PRIMARY KEY)");
        db.execSQL("create table " + TABLE_PROJECT +" (ProjectID INTEGER PRIMARY KEY,ProjectName TEXT,DueDate INTEGER,ClassName TEXT)");
        db.execSQL("create table " + TABLE_RECORDED_IN +" (EventID INTEGER PRIMARY KEY,ClassName TEXT PRIMARY KEY)");
        db.execSQL("create table " + TABLE_SELFCARE +" (USSN INTEGER PRIMARY KEY,Duration INTEGER,Type TEXT)");
        db.execSQL("create table " + TABLE_SLEEP +" (DateINTEGER PRIMARY KEY,Duration INTEGER,Quality TEXT)");
        db.execSQL("create table " + TABLE_STREAK+" (USSN INTEGER PRIMARY KEY,CurrConDays INTEGER,RecordDays INTEGER)");
        db.execSQL("create table " + TABLE_STUDENT +" (SSN INTEGER PRIMARY KEY,StudentID INTEGER)");
        db.execSQL("create table " + TABLE_STUDENT_WORKS_ON_PROJECT+" (USSN INTEGER PRIMARY KEY,Date INTEGER PRIMARY KEY)");
        db.execSQL("create table " + TABLE_USER+" (SSN INTEGER PRIMARY KEY,FName TEXT,Minit TEXT, LName TEXT, UFlag BLOB, WFLag BLOB, SFlag BLOB)");
        db.execSQL("create table " + TABLE_USERS_SLEEP +" (USSN INTEGER PRIMARY KEY,Date INTEGER PRIMARY KEY)");
        db.execSQL("create table " + TABLE_WORKER +" (SSN INTEGER PRIMARY KEY,StudentID INTEGER)");
        db.execSQL("create table " + TABLE_WORKER_WORKS_ON_PROJECT +" (USSN INTEGER PRIMARY KEY,ProjectID INTEGER PRIMARY KEY)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables on upgrade
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CLASS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_EVENT);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_EXAM);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_EXERCISE);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_FOOD_TYPE);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_GOAL);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_GRADEBOOK);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_MEETING);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NUTRITION);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_OTHER_EVENT);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_OTHER_USER);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PERFORMS_EXERCISE);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PROJECT);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_RECORDED_IN);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SELFCARE);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SLEEP);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_STREAK);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_STUDENT);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_STUDENT_WORKS_ON_PROJECT);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_USERS_SLEEP);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_WORKER);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_WORKER_WORKS_ON_PROJECT);

        // Create new tables
        onCreate(db);
    }

    //Insert data into CLASS Table
    public boolean insertDataClass(String ClassName,String ClassNum,Integer C_USSN) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CLASSNAME,ClassName);
        contentValues.put(CLASS_NUM,ClassNum);
        contentValues.put(USSN,C_USSN);
        //Insert row
        long result = db.insert(TABLE_CLASS,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //Insert data into EVENT Table
    public boolean insertDataEvent(Integer EventID,String Event_TravelTime,Integer Duration, String Name, Integer E_USSN) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EVENTID,EventID);
        contentValues.put(EVENT_TRAVELTIME,Event_TravelTime);
        contentValues.put(DURATION,Duration);
        contentValues.put(NAME,Name);
        contentValues.put(USSN,E_USSN);
        //Insert row
        long result = db.insert(TABLE_EVENT,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //Insert data into EXAM Table
    public boolean insertDataExam(Integer EventID,Integer NumGrade,String LetterGrade) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EVENTID,EventID);
        contentValues.put(NUMGRADE,NumGrade);
        contentValues.put(LETTERGRADE,LetterGrade);
        //Insert row
        long result = db.insert(TABLE_EXAM,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //Insert data into EXERCISE Table
    public boolean insertDataExercise(Integer Date,Integer Duration, String Type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DATE,Date);
        contentValues.put(DURATION,Duration);
        contentValues.put(TYPE,Type);
        //Insert row
        long result = db.insert(TABLE_EXERCISE,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //Insert data into FOOD_TYPE Table
    public boolean insertDataFood_Type(Integer FoodID, String Type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FOODID,FoodID);
        contentValues.put(TYPE,Type);
        //Insert row
        long result = db.insert(TABLE_FOOD_TYPE,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //Insert data into GOAL Table
    public boolean insertDataGoal(Integer GoalID,Integer EDC, String Name, Integer G_USSN) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(GOALID,GoalID);
        contentValues.put(GOAL_EDC,EDC);
        contentValues.put(NAME,Name);
        contentValues.put(USSN, G_USSN);
        //Insert row
        long result = db.insert(TABLE_GOAL,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //Insert data into GRADEBOOK Table
    public boolean insertDataGradeBook(Integer ClassName,Integer NumGrade, String LetterGrade) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CLASSNAME,ClassName);
        contentValues.put(NUMGRADE,NumGrade);
        contentValues.put(LETTERGRADE,LetterGrade);
        //Insert row
        long result = db.insert(TABLE_GRADEBOOK,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //Insert data into MEETING Table
    public boolean insertDataMeeting(Integer EventID, String Type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EVENTID,EventID);
        contentValues.put(TYPE,Type);
        //Insert row
        long result = db.insert(TABLE_MEETING,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //Insert data into NUTRITION Table
    public boolean insertDataNutrition(Integer Date,Integer Calories, Integer FoodID, Integer Protein, Integer Carbs, Integer Fat) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DATE,Date);
        contentValues.put(CALORIES,Calories);
        contentValues.put(FOODID,FoodID);
        contentValues.put(PROTEIN,Protein);
        contentValues.put(CARBS,Carbs);
        contentValues.put(FAT,Fat);
        //Insert row
        long result = db.insert(TABLE_NUTRITION,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //Insert data into OTHER_EVENT Table
    public boolean insertDataOther_Event(Integer EventID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EVENTID,EventID);
        //Insert row
        long result = db.insert(TABLE_OTHER_EVENT,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //Insert data into OTHER USERTable
    public boolean insertDataOther_User(Integer O_SSN) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SSN,O_SSN);
        //Insert row
        long result = db.insert(TABLE_OTHER_USER,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //Insert data into PERFORMS_EXERCISE Table
    public boolean insertDataPerforms_Exercise(Integer PE_USSN,Integer Date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USSN,PE_USSN);
        contentValues.put(DATE, Date);
        //Insert row
        long result = db.insert(TABLE_PERFORMS_EXERCISE,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //Insert data into PROJECT Table
    public boolean insertDataProject(Integer ProjectID,String ProjectName, Integer DueDate, String ClassName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROJECTID,ProjectID);
        contentValues.put(PROJECTNAME,ProjectName);
        contentValues.put(PROJECT_DUEDATE, DueDate);
        contentValues.put(CLASSNAME,ClassName);
        //Insert row
        long result = db.insert(TABLE_PROJECT,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //Insert data into RECORDED_IN Table
    public boolean insertDataRecorded_In(String Classname,Integer EventID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CLASSNAME,Classname);
        contentValues.put(EVENTID,EventID);
        //Insert row
        long result = db.insert(TABLE_RECORDED_IN,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //Insert data into SELFCARE Table
    public boolean insertDataSelfCare(Integer S_USSN, String Type, Integer Duration) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USSN,S_USSN);
        contentValues.put(TYPE,Type);
        contentValues.put(DURATION,Duration);
        //Insert row
        long result = db.insert(TABLE_SELFCARE,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }


    //Insert data into SLEEP Table
    public boolean insertDataSleep(Integer Date,Integer Duration, String Quality) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DATE, Date);
        contentValues.put(DURATION, Duration);
        contentValues.put(SLEEP_QUALITY, Quality);
        //Insert row
        long result = db.insert(TABLE_SLEEP,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //Insert data into STREAK Table
    public boolean insertDataStreak(Integer ST_USSN,Integer CurrConDays, Integer RecordDays) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USSN,ST_USSN);
        contentValues.put(STREAK_CURRCONDAYS, CurrConDays);
        contentValues.put(STREAK_RECORDDAYS, RecordDays);
        //Insert row
        long result = db.insert(TABLE_STREAK,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //Insert data into STUDENT Table
    public boolean insertDataStudent(Integer STUD_USSN,Integer StudentID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USSN,STUD_USSN);
        contentValues.put(STUDENTID, StudentID);
        //Insert row
        long result = db.insert(TABLE_STUDENT,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //Insert data into STUDENT_WORKS_ON_PROJECT Table
    public boolean insertDataStudent_works_on_Project(Integer SWOP_USSN,Integer Date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USSN,SWOP_USSN);
        contentValues.put(DATE, Date);
        //Insert row
        long result = db.insert(TABLE_STUDENT_WORKS_ON_PROJECT,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //Insert data into USER Table
    public boolean insertDataUser(Integer U_USSN,String FName, String Minit, String LName, Boolean UFlag, Boolean WFlag, Boolean SFlag) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USSN,U_USSN);
        contentValues.put(USER_FNAME, FName);
        contentValues.put(USER_MINIT,Minit);
        contentValues.put(USER_LNAME,LName);
        contentValues.put(USER_UFLAG,UFlag);
        contentValues.put(USER_WFlag,WFlag);
        contentValues.put(USER_SFlag,SFlag);
        //Insert row
        long result = db.insert(TABLE_USER,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }


    //Insert data into USER_SLEEP Table
    public boolean insertDataUserSleep(Integer US_USSN,Integer Date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USSN,US_USSN);
        contentValues.put(DATE, Date);
        //Insert row
        long result = db.insert(TABLE_USERS_SLEEP,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //Insert data into WORKER Table
    public boolean insertDataWorker(Integer W_USSN,Integer StudentID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USSN,W_USSN);
        contentValues.put(STUDENTID, StudentID);
        //Insert row
        long result = db.insert(TABLE_WORKER,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }


    //Insert data into WORKER_WORKS_ON_PROJECT Table
    public boolean insertDataWorker_works_on_Project(Integer WWOP_USSN,Integer ProjectID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USSN,WWOP_USSN);
        contentValues.put(PROJECTID, ProjectID);
        //Insert row
        long result = db.insert(TABLE_WORKER_WORKS_ON_PROJECT,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //Getting data
    public Cursor getAllDataCLASS() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_CLASS,null);
        return res;
    }
    public Cursor getAllDataEVENT() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_EVENT,null);
        return res;
    }
    public Cursor getAllDataEXAM() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_EXAM,null);
        return res;
    }
    public Cursor getAllDataEXERCISE() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_EXERCISE,null);
        return res;
    }
    public Cursor getAllDataFOOD_TYPE() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_FOOD_TYPE,null);
        return res;
    }
    public Cursor getAllDataGOAL() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_GOAL,null);
        return res;
    }
    public Cursor getAllDataGRADEBOOK() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_GRADEBOOK,null);
        return res;
    }
    public Cursor getAllDataMEETING() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_MEETING,null);
        return res;
    }
    public Cursor getAllDataNUTRITION() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NUTRITION,null);
        return res;
    }
    public Cursor getAllDataOTHER_EVENT() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_OTHER_EVENT,null);
        return res;
    }
    public Cursor getAllDataOTHER_USER() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_OTHER_USER,null);
        return res;
    }
    public Cursor getAllDataPERFORMS_EXERCISE() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_PERFORMS_EXERCISE,null);
        return res;
    }
    public Cursor getAllDataPROJECT() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_PROJECT,null);
        return res;
    }
    public Cursor getAllDataRECORDED_IN() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_RECORDED_IN,null);
        return res;
    }
    public Cursor getAllDataSELFCARE() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_SELFCARE,null);
        return res;
    }
    public Cursor getAllDataSLEEP() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_SLEEP,null);
        return res;
    }
    public Cursor getAllDataSTREAK() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_STREAK,null);
        return res;
    }
    public Cursor getAllDataSTUDENT() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_STUDENT,null);
        return res;
    }
    public Cursor getAllDataSTUDENT_WORKS_ON_PROJECT() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_STUDENT_WORKS_ON_PROJECT,null);
        return res;
    }
    public Cursor getAllDataUSER() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_USER,null);
        return res;
    }
    public Cursor getAllDataUSERS_SLEEP() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_USERS_SLEEP,null);
        return res;
    }
    public Cursor getAllDataWORKER() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_WORKER,null);
        return res;
    }
    public Cursor getAllDataWROKER_WORKS_ON_PROJECT() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_WORKER_WORKS_ON_PROJECT,null);
        return res;
    }

    //Updating the tables
    public boolean updateDataClass(String ClassName,String ClassNum,Integer C_USSN) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CLASSNAME,ClassName);
        contentValues.put(CLASS_NUM,ClassNum);
        contentValues.put(USSN,C_USSN);
        db.update(TABLE_CLASS, contentValues, "USSN = ?",new String[] { USSN });
        return true;
    }
    public boolean updateDataEvent(Integer EventID,String Event_TravelTime,Integer Duration, String Name, Integer E_USSN) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EVENTID,EventID);
        contentValues.put(EVENT_TRAVELTIME,Event_TravelTime);
        contentValues.put(DURATION,Duration);
        contentValues.put(NAME,Name);
        contentValues.put(USSN,E_USSN);
        db.update(TABLE_EVENT, contentValues, "EVENTID = ?",new String[] { EVENTID });
        return true;
    }
    public boolean updateDataExam(Integer EventID,Integer NumGrade,String LetterGrade) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EVENTID,EventID);
        contentValues.put(NUMGRADE,NumGrade);
        contentValues.put(LETTERGRADE,LetterGrade);
        db.update(TABLE_EXAM, contentValues, "EVENTID = ?",new String[] { EVENTID });
        return true;
    }
    public boolean updateDataExercise(Integer Date,Integer Duration, String Type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DATE,Date);
        contentValues.put(DURATION,Duration);
        contentValues.put(TYPE,Type);
        db.update(TABLE_EXERCISE, contentValues, "DATE = ?",new String[] { DATE });
        return true;
    }

    public boolean updateDataFood_Type(Integer FoodID,String Type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FOODID,FoodID);
        contentValues.put(TYPE,Type);
        db.update(TABLE_FOOD_TYPE, contentValues, "FOODID = ?",new String[] { FOODID });
        return true;
    }

    public boolean updateDataGoal(Integer GoalID, Integer EDC, String Name,Integer G_USSN) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(GOALID,GoalID);
        contentValues.put(GOAL_EDC,EDC);
        contentValues.put(NAME,Name);
        contentValues.put(USSN,G_USSN);
        db.update(TABLE_GOAL, contentValues, "GOALID = ?",new String[] { GOALID });
        return true;
    }
    public boolean updateDataGradebook(Integer ClassName, Integer NumGrade, String LetterGrade) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CLASSNAME,ClassName);
        contentValues.put(NUMGRADE,NumGrade);
        contentValues.put(LETTERGRADE,LetterGrade);
        db.update(TABLE_GRADEBOOK, contentValues, "CLASSNAME = ?",new String[] { CLASSNAME });
        return true;
    }

    public boolean updateDataMeeting(Integer EventID, String Type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EVENTID,EventID);
        contentValues.put(TYPE, Type);
        db.update(TABLE_MEETING, contentValues, "EVENTID = ?",new String[] { EVENTID });
        return true;
    }

    public boolean updateDataNutrition(Integer Date, Integer Calories, Integer FoodID, Integer Protein, Integer Carbs, Integer Fat) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DATE,Date);
        contentValues.put(CALORIES,Calories);
        contentValues.put(FOODID,FoodID);
        contentValues.put(PROTEIN,Protein);
        contentValues.put(CARBS,Carbs);
        contentValues.put(FAT,Fat);
        db.update(TABLE_NUTRITION, contentValues, "DATE = ?",new String[] { DATE });
        return true;
    }
    public boolean updateDataOther_Event(Integer EventID, String Type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EVENTID, EventID);
        contentValues.put(TYPE, Type);
        db.update(TABLE_OTHER_EVENT, contentValues, "EVENTID = ?", new String[]{EVENTID});
        return true;
    }

    public boolean updateDataOtherUser(Integer ssn, String Type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SSN, ssn);
        contentValues.put(TYPE, Type);
        db.update(TABLE_OTHER_USER, contentValues, "SSN = ?", new String[]{SSN});
        return true;
    }

    public boolean updateDataPerforms_Exercise(Integer ussn, Integer Date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USSN, ussn);
        contentValues.put(DATE, Date);
        db.update(TABLE_PERFORMS_EXERCISE, contentValues, "DATE = ?", new String[]{DATE});
        return true;
    }
    public boolean updateDataProject(Integer ProjectID, String ProjectName, Integer DueDate, String ClassName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROJECTID,ProjectID);
        contentValues.put(PROJECTNAME, ProjectName);
        contentValues.put(PROJECT_DUEDATE, DueDate);
        contentValues.put(CLASSNAME,ClassName);
        db.update(TABLE_PROJECT, contentValues, "PROJECTID = ?",new String[] { PROJECTID });
        return true;
    }
    public boolean updateDataRecorded_In(Integer EventID, String ClassName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EVENTID,EventID);
        contentValues.put(CLASSNAME, ClassName);
        db.update(TABLE_RECORDED_IN, contentValues, "EVENTID = ?",new String[] { EVENTID });
        return true;
    }
    public boolean updateDataSelfCare(Integer ussn, String Type, Integer Duration) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USSN,ussn);
        contentValues.put(TYPE, Type);
        contentValues.put(DURATION, Duration);
        db.update(TABLE_SELFCARE, contentValues, "USSN = ?",new String[] { USSN });
        return true;
    }
    public boolean updateDataSleep (Integer Date, String Quality, Integer Duration) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DATE,Date);
        contentValues.put(SLEEP_QUALITY, Quality);
        contentValues.put(DURATION, Duration);
        db.update(TABLE_SLEEP, contentValues, "DATE = ?",new String[] { DATE });
        return true;
    }
    public boolean updateDataStreak(Integer ussn, Integer CurrConDays, Integer RecordDays) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USSN,ussn);
        contentValues.put(STREAK_CURRCONDAYS, CurrConDays);
        contentValues.put(STREAK_RECORDDAYS, RecordDays);
        db.update(TABLE_STREAK, contentValues, "USSN = ?",new String[] { USSN });
        return true;
    }
    public boolean updateDataStudent(Integer ssn,  Integer StudentID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SSN,ssn);
        contentValues.put(STUDENTID, StudentID);
        db.update(TABLE_STUDENT, contentValues, "SSN = ?",new String[] { SSN });
        return true;
    }
    public boolean updateDataStudent_Works_On(Integer ussn, Integer Date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USSN,ussn);
        contentValues.put(DATE, Date);
        db.update(TABLE_STUDENT_WORKS_ON_PROJECT, contentValues, "USSN = ?",new String[] { USSN });
        return true;
    }
    public boolean updateDataUser(Integer ssn, String FName, String Minit, String LName, Boolean UFlag, Boolean WFlag, Boolean SFlag) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SSN,ssn);
        contentValues.put(USER_FNAME, FName);
        contentValues.put(USER_MINIT, Minit);
        contentValues.put(USER_LNAME, LName);
        contentValues.put(USER_UFLAG, UFlag);
        contentValues.put(USER_WFlag, WFlag);
        contentValues.put(USER_SFlag, SFlag);
        db.update(TABLE_USER, contentValues, "SSN = ?",new String[] { SSN });
        return true;
    }
    public boolean updateDataUser_Sleep(Integer ussn, Integer Date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USSN,ussn);
        contentValues.put(DATE, Date);
        db.update(TABLE_USERS_SLEEP, contentValues, "USSN = ?",new String[] { USSN });
        return true;
    }
    public boolean updateDataWorker(Integer ssn, Integer StudentID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SSN,ssn);
        contentValues.put(STUDENTID, StudentID);
        db.update(TABLE_WORKER, contentValues, "SSN = ?",new String[] { SSN });
        return true;
    }
    public boolean updateDataWorker_Works_On_Project(Integer ussn, Integer ProjectID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USSN,ussn);
        contentValues.put(PROJECTID, ProjectID);
        db.update(TABLE_WORKER_WORKS_ON_PROJECT, contentValues, "USSN = ?",new String[] { USSN });
        return true;
    }


    public Integer deleteDataClass (String ClassName) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_CLASS, "CLASSNAME = ?",new String[] {ClassName});
    }
  /*  public Integer deleteDataEvent (Integer EventId) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_EVENT, "EVENTID = ?",new String[] {EventId});
    }
    public Integer deleteDataExam(Integer EventId) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_EXAM, "EVENTID = ?",new String[] {EventId});
    }
    public Integer deleteDataExercise (Integer Date) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_EXERCISE, "DATE = ?",new String[] {Date});
    }*/
}