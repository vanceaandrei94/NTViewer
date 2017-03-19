package com.unbm.andrei.ntviewer.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.unbm.andrei.ntviewer.model.Network;
import com.unbm.andrei.ntviewer.model.NetworkLocation;
import com.unbm.andrei.ntviewer.model.NetworkNode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by andrei.vancea on 3/6/2017.
 */

public class DBOperations {

    private static final String TAG = "[DBOperations]";
    private SQLiteDatabase database;
    private NTViewerDBHelper ntViewerDBHelper;

    public DBOperations(Context context) {
        ntViewerDBHelper = new NTViewerDBHelper(context);
    }

    /**
     * Insert a NewtorkLocation into database
     *
     * @param networkLocation NetworkLocation object where are the properties are at
     */
    public void insertLocation(NetworkLocation networkLocation) {
        database = ntViewerDBHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(NTViewerContract.LocationsTable.COLUMN_NAME_LOCATION_NAME, networkLocation.getName());
        contentValues.put(NTViewerContract.LocationsTable.COLUMN_NAME_LAT, networkLocation.getLat());
        contentValues.put(NTViewerContract.LocationsTable.COLUMN_NAME_LON, networkLocation.getLon());
        long id = database.insert(NTViewerContract.LocationsTable.LOCATIONS_TABLE_NAME, null, contentValues);
        Log.d(TAG, "\"InsertLocation\" row Id:" + id);
    }

    /**
     * Insert a network into database
     *
     * @param network    Network object where all the properties are at
     * @param locationId The id of the NetworkLocation where the Network resides at
     */
    @SuppressLint("simpleDateFormat")
    public void insertNetwork(Network network, String locationId) {
        database = ntViewerDBHelper.getWritableDatabase();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY.MM.DD HH:mm:ss");

        ContentValues contentValues = new ContentValues();
        contentValues.put(NTViewerContract.NetworksTable.COLUMN_NAME_NETWORK_NAME, network.getName());
        contentValues.put(NTViewerContract.NetworksTable.COLUMN_NAME_ADDED_AT, simpleDateFormat.format(new Date()));
        contentValues.put(NTViewerContract.NetworksTable.COLUMN_NAME_ENDPOINT_ADDRESS, network.getEndpointAddress());
        contentValues.put(NTViewerContract.NetworksTable.COLUMN_NAME_LOCATION_ID, locationId);
        long id = database.insert(NTViewerContract.NetworksTable.NETWORKS_TABLE_NAME, null, contentValues);
        Log.d(TAG, "\"InsertNetwork\" row Id:" + id);
    }


    /**
     * Insert a note into database
     *
     * @param networkNode NetworkNode object where all the properties are at
     * @param networkId   The id of the Network where the Node belongs at
     */
    @SuppressLint("simpleDateFormat")
    public void insertNode(NetworkNode networkNode, String networkId) {
        database = ntViewerDBHelper.getWritableDatabase();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY.MM.DD HH:mm:ss");

        ContentValues contentValues = new ContentValues();
        contentValues.put(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_NAME, networkNode.getName());
        contentValues.put(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_IP, networkNode.getLocalIpAddress());
        contentValues.put(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_MAC, networkNode.getMacAddress());
        contentValues.put(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_TYPE, networkNode.getType());
        contentValues.put(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_ADDED_AT, simpleDateFormat.format(new Date()));
        contentValues.put(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_LAST_ACTIVE, networkNode.getLastOnline());
        contentValues.put(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_2DFILE, networkNode.getPath2DFile());
        contentValues.put(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_3DFILE, networkNode.getPath3DFile());
        contentValues.put(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NETWORK_ID, networkId);
        long id = database.insert(NTViewerContract.NetworkNodeTable.NETWORK_NODES_TABLE_NAME, null, contentValues);
        Log.d(TAG, "\"InsertNode\" row Id:" + id);
    }


    /**
     * Method for getting all the locations stored in database
     *
     * @return a List of {@link NetworkLocation}
     */
    public List<NetworkLocation> getLocations() {
        database = ntViewerDBHelper.getReadableDatabase();
        List<NetworkLocation> networkLocations = new ArrayList<>();

        Cursor cursor = database.query(NTViewerContract.LocationsTable.LOCATIONS_TABLE_NAME, null, null, null, null, null, NTViewerContract.LocationsTable.COLUMN_NAME_LOCATION_NAME);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(NTViewerContract.LocationsTable._ID));
            String name = cursor.getString(cursor.getColumnIndex(NTViewerContract.LocationsTable.COLUMN_NAME_LOCATION_NAME));
            String lat = cursor.getString(cursor.getColumnIndex(NTViewerContract.LocationsTable.COLUMN_NAME_LAT));
            String lon = cursor.getString(cursor.getColumnIndex(NTViewerContract.LocationsTable.COLUMN_NAME_LON));
            int networkId = cursor.getInt(cursor.getColumnIndex(NTViewerContract.LocationsTable.COLUMN_NAME_NETWORK_ID));
            Network network = getNetworkById(networkId, database);
            networkLocations.add(new NetworkLocation(id, name, Double.valueOf(lat), Double.valueOf(lon), network));
        }

        cursor.close();
        return networkLocations;
    }


    /**
     * Method for getting all the Networks stored in database
     *
     * @return a List of {@link Network}s
     */
    public List<Network> getNetworks() {
        database = ntViewerDBHelper.getReadableDatabase();

        List<Network> networks = new ArrayList<>();

        Cursor cursor = database.query(NTViewerContract.NetworksTable.NETWORKS_TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Network network = new Network();
            network.setId(cursor.getInt(cursor.getColumnIndex(NTViewerContract.NetworksTable._ID)));
            network.setName(cursor.getString(cursor.getColumnIndex(NTViewerContract.NetworksTable.COLUMN_NAME_NETWORK_NAME)));
            network.setEndpointAddress(cursor.getString(cursor.getColumnIndex(NTViewerContract.NetworksTable.COLUMN_NAME_ENDPOINT_ADDRESS)));
            network.setNetworkNodeList(getNodesByNetworkId(network.getId(), database));

            networks.add(network);
        }

        cursor.close();
        return networks;
    }

    /**
     * Method for getting a network by ID
     *
     * @param networkId The id of the Network
     * @param database  SQLiteDatabase instance
     * @return {@link Network}
     */
    private Network getNetworkById(int networkId, SQLiteDatabase database) {
        Network network = new Network();
        String selection = "_ID = ?";
        String[] args = new String[]{String.valueOf(networkId)};
        Cursor cursor = database.query(NTViewerContract.NetworksTable.NETWORKS_TABLE_NAME, null, selection, args, null, null, null);
        cursor.moveToNext();
        network.setId(networkId);
        network.setEndpointAddress(cursor.getString(cursor.getColumnIndex(NTViewerContract.NetworksTable.COLUMN_NAME_ENDPOINT_ADDRESS)));
        network.setName(cursor.getString(cursor.getColumnIndex(NTViewerContract.NetworksTable.COLUMN_NAME_NETWORK_NAME)));
        network.setLocationId(cursor.getString(cursor.getColumnIndex(NTViewerContract.NetworksTable.COLUMN_NAME_LOCATION_ID)));
        List<NetworkNode> nodes = getNodesByNetworkId(networkId, database);
        network.setNetworkNodeList(nodes);
        cursor.close();
        return network;
    }

    /**
     * Method for getting all nodes of a specific network
     *
     * @param networkId The id of the network
     * @param database  SQLiteDatabase instance
     * @return a list of {@link NetworkNode}
     */
    private List<NetworkNode> getNodesByNetworkId(int networkId, SQLiteDatabase database) {
        List<NetworkNode> nodes = new ArrayList<>();
        String selection = "NETWORK_ID = ?";
        String[] args = new String[]{String.valueOf(networkId)};

        Cursor cursor = database.query(NTViewerContract.NetworkNodeTable.NETWORK_NODES_TABLE_NAME, null, selection, args, null, null, null);
        while (cursor.moveToNext()) {
            NetworkNode networkNode = new NetworkNode();
            networkNode.setName(cursor.getString(cursor.getColumnIndex(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_NAME)));
            networkNode.setAddedAt(cursor.getString(cursor.getColumnIndex(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_ADDED_AT)));
            networkNode.setLastOnline(cursor.getString(cursor.getColumnIndex(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_LAST_ACTIVE)));
            networkNode.setLocalIpAddress(cursor.getString(cursor.getColumnIndex(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_IP)));
            networkNode.setMacAddress(cursor.getString(cursor.getColumnIndex(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_MAC)));
            networkNode.setType(cursor.getString(cursor.getColumnIndex(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_TYPE)));

            nodes.add(networkNode);
        }

        cursor.close();
        return nodes;
    }

    /**
     * Method for updating a database Network record
     *
     * @param network {@link Network} object with updated fields
     */
    public void updateNetwork(Network network) {
        database = ntViewerDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NTViewerContract.NetworksTable.COLUMN_NAME_ENDPOINT_ADDRESS, network.getEndpointAddress());
        contentValues.put(NTViewerContract.NetworksTable.COLUMN_NAME_LOCATION_ID, network.getLocationId());

        String whereClause = "_ID = ?";
        String[] whereArgs = new String[]{String.valueOf(network.getId())};

        int rowsAffected = database.update(NTViewerContract.NetworksTable.NETWORKS_TABLE_NAME, contentValues, whereClause, whereArgs);
        Log.d(TAG, "\"UpdateNetwork\" rows affected: " + rowsAffected);
    }

    /**
     * Method for updating a database Node record
     *
     * @param node {@link NetworkNode} object with updated fields
     */
    public void updateNode(NetworkNode node) {
        database = ntViewerDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_NAME, node.getName());
        contentValues.put(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_IP, node.getLocalIpAddress());
        contentValues.put(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_MAC, node.getMacAddress());
        contentValues.put(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_TYPE, node.getType());
        contentValues.put(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_LAST_ACTIVE, node.getLastOnline());
        contentValues.put(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_2DFILE, node.getPath2DFile());
        contentValues.put(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NODE_3DFILE, node.getPath3DFile());
        contentValues.put(NTViewerContract.NetworkNodeTable.COLUMN_NAME_NETWORK_ID, node.getNetworkId());

        String whereClause = "_ID = ?";
        String[] whereArgs = new String[]{node.getId()};

        int rowsAffected = database.update(NTViewerContract.NetworkNodeTable.NETWORK_NODES_TABLE_NAME, contentValues, whereClause, whereArgs);
        Log.d(TAG, "\"UpdateNode\" rows affected: " + rowsAffected);
    }


    /**
     * Method for deleting a NetworkLocation from database
     * Note: this method will trigger a delete for the network and network nodes associated with this NetworkLocation
     *
     * @param networkLocation NetworkLocation object to be deleted
     */
    public void deleteLocationCascade(NetworkLocation networkLocation) {
        database = ntViewerDBHelper.getWritableDatabase();

        String whereClause = "_ID = ?";
        String[] whereArgs = new String[]{String.valueOf(networkLocation.getId())};

        //cascade delete
        deleteNetwork(networkLocation.getNetwork(), database);

        int rowsAffected = database.delete(NTViewerContract.LocationsTable.LOCATIONS_TABLE_NAME, whereClause, whereArgs);
        Log.d(TAG, "\"DeleteLocation\" rows affected: " + rowsAffected);
    }

    private void deleteNetwork(Network network, SQLiteDatabase database) {
        deleteNetworkNodes(network.getId(), database);
        String whereClause = "_ID = ?";
        String[] whereArgs = new String[]{String.valueOf(network.getId())};
        int rowsAffected = database.delete(NTViewerContract.NetworksTable.NETWORKS_TABLE_NAME, whereClause, whereArgs);
        Log.d(TAG, "\"DeleteNetwork\" rows affected: " + rowsAffected);
    }

    private void deleteNetworkNodes(int networkId, SQLiteDatabase database) {

        String whereClause = NTViewerContract.NetworkNodeTable.COLUMN_NAME_NETWORK_ID + " = ?";
        String[] whereArgs = new String[]{String.valueOf(networkId)};
        int rowsAffected = database.delete(NTViewerContract.NetworkNodeTable.NETWORK_NODES_TABLE_NAME, whereClause, whereArgs);
        Log.d(TAG, "\"DeleteNetworkNodes\" rows affected: " + rowsAffected);
    }


    /**
     * Method for closing the database connection
     */
    public void closeConnection() {
        if (database != null) {
            database.close();
        }
    }
}
