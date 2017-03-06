package com.unbm.andrei.ntviewer.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.unbm.andrei.ntviewer.model.NetworkLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrei.vancea on 3/6/2017.
 */

public class DBOperations {

    private static final String TAG = "DBOperations";
    private SQLiteDatabase database;
    private NTViewerDBHelper ntViewerDBHelper;

    public DBOperations(Context context) {
        ntViewerDBHelper = new NTViewerDBHelper(context);
    }

    public void insert(NetworkLocation networkLocation) {
        database = ntViewerDBHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(NTViewerContract.LocationsTable.COLUMN_NAME_LOCATION_NAME, networkLocation.getName());
        contentValues.put(NTViewerContract.LocationsTable.COLUMN_NAME_IP_ADDR, networkLocation.getIpAddress());
        contentValues.put(NTViewerContract.LocationsTable.COLUMN_NAME_LAT, networkLocation.getLat());
        contentValues.put(NTViewerContract.LocationsTable.COLUMN_NAME_LON, networkLocation.getLon());
        long id = database.insert(NTViewerContract.LocationsTable.TABLE_NAME, null, contentValues);
        Log.d(TAG, "\"Insert\" row Id:" + id);
    }

    public List<NetworkLocation> getLocations() {
        database = ntViewerDBHelper.getReadableDatabase();
        List<NetworkLocation> networkLocations = new ArrayList<>();

        Cursor cursor = database.query(NTViewerContract.LocationsTable.TABLE_NAME, null, null, null, null, null, NTViewerContract.LocationsTable.COLUMN_NAME_LOCATION_NAME);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(NTViewerContract.LocationsTable._ID));
            String name = cursor.getString(cursor.getColumnIndex(NTViewerContract.LocationsTable.COLUMN_NAME_LOCATION_NAME));
            String ip = cursor.getString(cursor.getColumnIndex(NTViewerContract.LocationsTable.COLUMN_NAME_IP_ADDR));
            String lat = cursor.getString(cursor.getColumnIndex(NTViewerContract.LocationsTable.COLUMN_NAME_LAT));
            String lon = cursor.getString(cursor.getColumnIndex(NTViewerContract.LocationsTable.COLUMN_NAME_LON));

            networkLocations.add(new NetworkLocation(id, name, ip, Double.valueOf(lat), Double.valueOf(lon)));
        }

        cursor.close();
        return networkLocations;
    }

    public void update(NetworkLocation networkLocation) {
        database = ntViewerDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NTViewerContract.LocationsTable.COLUMN_NAME_LOCATION_NAME, networkLocation.getName());
        contentValues.put(NTViewerContract.LocationsTable.COLUMN_NAME_IP_ADDR, networkLocation.getIpAddress());
        contentValues.put(NTViewerContract.LocationsTable.COLUMN_NAME_LAT, networkLocation.getLat());
        contentValues.put(NTViewerContract.LocationsTable.COLUMN_NAME_LON, networkLocation.getLon());

        String whereClause = "_ID = ?";
        String[] whereArgs = new String[]{String.valueOf(networkLocation.getId())};

        int rowsAffected = database.update(NTViewerContract.LocationsTable.TABLE_NAME, contentValues, whereClause, whereArgs);
        Log.d(TAG, "\"Update\" rows affected: " + rowsAffected);
    }

    public void delete(NetworkLocation networkLocation) {
        database = ntViewerDBHelper.getWritableDatabase();

        String whereClause = "_ID = ?";
        String[] whereArgs = new String[]{String.valueOf(networkLocation.getId())};

        int rowsAffected = database.delete(NTViewerContract.LocationsTable.TABLE_NAME, whereClause, whereArgs);
        Log.d(TAG, "\"Update\" rows affected: " + rowsAffected);
    }

    public void closeConnection() {
        if (database != null) {
            database.close();
        }
    }
}
