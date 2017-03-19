package com.unbm.andrei.ntviewer.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by andrei.vancea on 3/6/2017.
 */

public class NTViewerDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "NTViewer.db";

    private static final String SQL_CREATE_LOCATIONS_TABLE =
            "CREATE TABLE " + NTViewerContract.LocationsTable.LOCATIONS_TABLE_NAME + " (" +
                    NTViewerContract.LocationsTable._ID + " INTEGER PRIMARY KEY," +
                    NTViewerContract.LocationsTable.COLUMN_NAME_LOCATION_NAME + " TEXT," +
                    NTViewerContract.LocationsTable.COLUMN_NAME_NETWORK_ID + " INTEGER," +
                    NTViewerContract.LocationsTable.COLUMN_NAME_LAT + " TEXT," +
                    NTViewerContract.LocationsTable.COLUMN_NAME_LON + " TEXT)";

    private static final String SQL_DROP_LOCATIONS_TABLE =
            "DROP TABLE IF EXISTS " + NTViewerContract.LocationsTable.LOCATIONS_TABLE_NAME;

    private static final String SQL_CREATE_NETWORKS_TABLE =
            "CREATE TABLE " + NTViewerContract.NetworksTable.NETWORKS_TABLE_NAME + " (" +
                    NTViewerContract.NetworksTable._ID + " INTEGER PRIMARY KEY," +
                    NTViewerContract.NetworksTable.COLUMN_NAME_NETWORK_NAME + " TEXT," +
                    NTViewerContract.NetworksTable.COLUMN_NAME_ENDPOINT_ADDRESS + " TEXT," +
                    NTViewerContract.NetworksTable.COLUMN_NAME_ADDED_AT + " TEXT," +
                    NTViewerContract.NetworksTable.COLUMN_NAME_LOCATION_ID + " INTEGER)";

    private static final String SQL_DROP_NETWORKS_TABLE =
            "DROP TABLE IF EXISTS " + NTViewerContract.NetworksTable.NETWORKS_TABLE_NAME;

    private static final String SQL_CREATE_NODES_TABLE =
            "CREATE TABLE " + NTViewerContract.NetworkNodeTable.NETWORK_NODES_TABLE_NAME + " (" +
                    NTViewerContract.NetworkNodeTable._ID + " INTEGER PRIMARY KEY," +
                    NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_NAME + " TEXT," +
                    NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_TYPE + " TEXT," +
                    NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_IP + " TEXT," +
                    NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_MAC + " TEXT," +
                    NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_LAST_ACTIVE + " TEXT," +
                    NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_ADDED_AT + " TEXT," +
                    NTViewerContract.NetworkNodeTable.COLUMN_NAME_NETWORK_ID + " INTEGER," +
                    NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_2DFILE + " TEXT," +
                    NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_3DFILE + " TEXT)";

    private static final String SQL_DROP_NODES_TABLE =
            "DROP TABLE IF EXISTS " + NTViewerContract.NetworkNodeTable.NETWORK_NODES_TABLE_NAME;

    public NTViewerDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_LOCATIONS_TABLE);
        db.execSQL(SQL_CREATE_NETWORKS_TABLE);
        db.execSQL(SQL_CREATE_NODES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_LOCATIONS_TABLE);
        db.execSQL(SQL_DROP_NETWORKS_TABLE);
        db.execSQL(SQL_DROP_NODES_TABLE);
        onCreate(db);
    }
}
