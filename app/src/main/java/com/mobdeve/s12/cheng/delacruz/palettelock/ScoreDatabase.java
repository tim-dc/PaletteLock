package com.mobdeve.s12.cheng.delacruz.palettelock;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ScoreDatabase extends SQLiteOpenHelper {

    public Context context;

    private static final String TAG = "ScoreDatabase";

    // DB information
    public static final String DATABASE_NAME = "paletteLOCK.db";
    public static final int DATABASE_VERSION = 1;

    // Column names
    public static final String TABLE_SCORE = "my_score";
    public static final String SCORE_ID = "_id";
    public static final String SCORE_LEVEL = "score_level";
    public static final String GAME_SCORE = "game_score";
    public static final String POST_LOCATION = "post_location";
    public static final String POST_TIMESTAMP = "post_timestamp";
    public static final String POST_CAPTION = "post_caption";
    public static final String POST_LIKED = "post_liked";

    // Table information
    private static final String CREATE_SCORE_TABLE = "CREATE TABLE " + TABLE_SCORE
            + " (" + SCORE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SCORE_LEVEL + " INTEGER, " + GAME_SCORE
            + " INTEGER);";



    public ScoreDatabase(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_SCORE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORE);
        onCreate(db);
    }

    public boolean addData(int score, int level){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(GAME_SCORE, score);
        cv.put(SCORE_LEVEL, level);

        Log.d(TAG, "addData: Adding " + score + " and " + level + " to " + TABLE_SCORE);

        long result = db.insert(TABLE_SCORE, null, cv);

        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public Cursor getData(int level)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select *" + " from my_score" + " where score_level = " + level + " order by game_score desc";
        //String query = "SELECT * FROM " + TABLE_SCORE;
        Cursor data = db.rawQuery(query, null);

        return data;
    }

    public boolean deleteTitle(int level)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.delete(TABLE_SCORE, SCORE_LEVEL + "=" + level, null) > 0;
    }
}
