package com.unbm.andrei.ntviewer.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by andrei.vancea on 3/6/2017.
 */

public class NTViewerDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MyNotes.db";

    private static final String SQL_CREATE_LOCATIONS_TABLE =
            "CREATE TABLE " + NTViewerContract.LocationsTable.TABLE_NAME + " (" +
                    NTViewerContract.LocationsTable._ID + " INTEGER PRIMARY KEY," +
                    NTViewerContract.LocationsTable.COLUMN_NAME_LOCATION_NAME + " TEXT," +
                    NTViewerContract.LocationsTable.COLUMN_NAME_IP_ADDR + " TEXT," +
                    NTViewerContract.LocationsTable.COLUMN_NAME_LAT + " TEXT," +
                    NTViewerContract.LocationsTable.COLUMN_NAME_LON + " TEXT)";

    private static final String SQL_DROP_LOCATIONS_TABLE =
            "DROP TABLE IF EXISTS " + NTViewerContract.LocationsTable.TABLE_NAME;

    public NTViewerDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_LOCATIONS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_LOCATIONS_TABLE);
        onCreate(db);
    }
}
