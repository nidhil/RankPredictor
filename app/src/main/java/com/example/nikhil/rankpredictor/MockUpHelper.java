package com.example.nikhil.rankpredictor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikhil on 28-10-2016.
 */

public class MockUpHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "quiz.db";
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_TABLE = "Quiz";
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_OPTA = "optA";
    private static final String KEY_OPTB = "optB";
    private static final String KEY_OPTC = "optC";
    private static final String KEY_OPTD = "optD";
    private static final String KEY_COUNTA = "countA";
    private static final String KEY_COUNTB = "countB";
    private static final String KEY_COUNTC = "countC";
    private static final String KEY_COUNTD = "countD";
    private  SQLiteDatabase dbase;

    public MockUpHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        dbase = this.getReadableDatabase();
        String sql = "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_QUES + " TEXT, "
                +KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "
                +KEY_OPTC+" TEXT,"
                +KEY_OPTD+ " TEXT, "
                +KEY_COUNTA+ " INTEGER, "
                +KEY_COUNTB+ " INTEGER, "
                +KEY_COUNTC+ " INTEGER, "
                +KEY_COUNTD+ " INTEGER)";
        dbase.execSQL(sql);
        if(dbase.)
        addQuestions();



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void addQuestions(){
        Question q1 = new Question("An arc lamp requires a direct current of 10 A at 80 V to function.  If it is connected to a 220 V (rms), 50 Hz AC supply, the series inductor needed for it to work is close to :",
                " 80 H" ,
                " 0.08 H",
                " 0.044 H" ,
                " 0.065 H");
        this.addQuestion(q1);
        Question q2 = new Question("An observer looks at a distant tree of height 10 m with a telescope of magnifying power of 20.  To the observer the tree appears :",
                " 10 times taller.",
                " 10 times nearer." ,
                " 20 times taller." ,
                " 20 times nearer" );
        this.addQuestion(q2);
        Question q3 = new Question("Galvanization is applying a coating of :" ,
                " Pb" ,
                " Cr" ,
                " Cu" ,
                " Zn");
        this.addQuestion(q3);
        Question q4 = new Question("If one of the diameters of the circle, given by the equation, x2+y2−4x+6y−12=0, is a chord of a circle S, whose centre is at (−3, 2), then the radius of S is :",
                " 5",
                " 3",
                " 5",
                " 10" );
        this.addQuestion(q4);
        Question q5 = new Question("A galvanometer having a coil resistance of 100 Ω gives a full scale deflection, when a current of 1 mA is passed through it. The value of the resistance, which can convert this galvanometer into ammeter giving a full scale deflection for a current of 10 A, is :",
                "  0.01 Ω",
                "  2 Ω",
                "  0.1 Ω",
                "  3 Ω");
        this.addQuestion(q5);
        Question q6 = new Question("The species in which the N atom is in a state of sp hybridization is :",
                " 2NO +",
                " 2NO −",
                " 3NO−",
                " NO2");
        this.addQuestion(q6);
    }

    public void addQuestion(Question ques){
        dbase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, ques.getQuestion());
        values.put(KEY_OPTA, ques.getOptA());
        values.put(KEY_OPTB, ques.getOptB());
        values.put(KEY_OPTC, ques.getOptC());
        values.put(KEY_OPTD, ques.getOptD());
        dbase.insert(DATABASE_TABLE, null, values);
    }

    public List<Question> getAllQuestions(){
        List<Question> quesList = new ArrayList<Question>();
        String query = "SELECT * FROM "+ DATABASE_TABLE;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(query, null);
        if(cursor.moveToFirst() && cursor.getColumnCount() < 5) {
            do {
                Question ques = new Question();
                ques.setId(cursor.getInt(0));
                ques.setQuestion(cursor.getString(1));
                ques.setOptA(cursor.getString(2));
                ques.setOptB(cursor.getString(3));
                ques.setOptC(cursor.getString(4));
                ques.setOptD(cursor.getString(5));
                ques.setCountA(0);
                ques.setCountB(0);
                ques.setCountC(0);
                ques.setCountD(0);
                quesList.add(ques);
            } while (cursor.moveToNext());
        }
        return quesList;
    }

    public void deleteDb(SQLiteDatabase dbase) {
        dbase = this.getReadableDatabase();

        dbase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
    }
}
