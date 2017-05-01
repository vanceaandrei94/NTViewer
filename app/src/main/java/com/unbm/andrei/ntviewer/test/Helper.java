package com.unbm.andrei.ntviewer.test;

/**
 * Created by Andrei on 5/1/2017.
 */

public class Helper {

    public static final String FAKE_SITES_JSON = "[{\n" +
            "\t\"NetworkSite\": {\n" +
            "\t\t\"site_name\": \"siteName\",\n" +
            "\t\t\"site_quality\": \"average\",\n" +
            "\t\t\"site_location\": {\n" +
            "\t\t\t\"coordinates\": [{\n" +
            "\t\t\t\t\t\"lat\": \"12.23232\",\n" +
            "\t\t\t\t\t\"lon\": \"12.34543\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"lat\": \"34.32323\",\n" +
            "\t\t\t\t\t\"lon\": \"32.23232\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"lat\": \"15.23232\",\n" +
            "\t\t\t\t\t\"lon\": \"22.34543\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"lat\": \"66.32323\",\n" +
            "\t\t\t\t\t\"lon\": \"66.23232\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"subscribers\": [{\n" +
            "\t\t\t\"subscriber\": {\n" +
            "\t\t\t\t\"name\": \"plm\",\n" +
            "\t\t\t\t\"home_addr\": \"Avenue Street, 54\",\n" +
            "\t\t\t\t\"phone\": \"2250402342\",\n" +
            "\t\t\t\t\"location\": {\n" +
            "\t\t\t\t\t\"lat\": \"23.3232\",\n" +
            "\t\t\t\t\t\"lon\": \"54.3232\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"ipAddress\": \"192.54.32.11\",\n" +
            "\t\t\t\t\"subnetwork\": {\n" +
            "\t\t\t\t\t\"nodes\": [{\n" +
            "\t\t\t\t\t\t\t\"node\": {\n" +
            "\t\t\t\t\t\t\t\t\"name\": \"ABC Xabs\",\n" +
            "\t\t\t\t\t\t\t\t\"type\": \"Modem\",\n" +
            "\t\t\t\t\t\t\t\t\"local_ip\": \"192.168.3.190\",\n" +
            "\t\t\t\t\t\t\t\t\"mac\": \"38-D5-47-3A-C8-FF\",\n" +
            "\t\t\t\t\t\t\t\t\"state\": \"Active\",\n" +
            "\t\t\t\t\t\t\t\t\"lastActive\": \"\",\n" +
            "\t\t\t\t\t\t\t\t\"lastMaxTimeActive\": \"10:04:22\"\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"node\": {\n" +
            "\t\t\t\t\t\t\t\t\"name\": \"Me-PC\",\n" +
            "\t\t\t\t\t\t\t\t\"type\": \"pc\",\n" +
            "\t\t\t\t\t\t\t\t\"local_ip\": \"192.168.3.166\",\n" +
            "\t\t\t\t\t\t\t\t\"mac\": \"B0-C0-90-BC-CE-33\",\n" +
            "\t\t\t\t\t\t\t\t\"state\": \"Inactive\",\n" +
            "\t\t\t\t\t\t\t\t\"last_active\": \"24.03.2017 00:30:23\",\n" +
            "\t\t\t\t\t\t\t\t\"last_max_time_active\": \"12:04:22\"\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t]\n" +
            "\t\t\t\t}\n" +
            "\t\t\t}\n" +
            "\t\t}]\n" +
            "\t}\n" +
            "}]";

    public static final String SECOND_JSON = "[{\n" +
            "\t\"NetworkSite\": {\n" +
            "\t\t\"site_name\": \"First Site\",\n" +
            "\t\t\"site_quality\": \"average\",\n" +
            "\t\t\"site_location\": {\n" +
            "\t\t\t\"Coordinates\": [{\n" +
            "\t\t\t\t\t\"lat\": \"12.23232\",\n" +
            "\t\t\t\t\t\"lon\": \"12.34543\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"lat\": \"34.32323\",\n" +
            "\t\t\t\t\t\"lon\": \"32.23232\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"lat\": \"15.23232\",\n" +
            "\t\t\t\t\t\"lon\": \"22.34543\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"lat\": \"66.32323\",\n" +
            "\t\t\t\t\t\"lon\": \"66.23232\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"Subscribers\": [{\n" +
            "\t\t\t\t\"name\": \"plm\",\n" +
            "\t\t\t\t\"home_addr\": \"Avenue Street, 54\",\n" +
            "\t\t\t\t\"phone\": \"2250402342\",\n" +
            "\t\t\t\t\"Coordinate\": {\n" +
            "\t\t\t\t\t\"lat\": \"23.3232\",\n" +
            "\t\t\t\t\t\"lon\": \"54.3232\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"ipAddress\": \"192.54.32.11\",\n" +
            "\t\t\t\t\"subnetwork\": {\n" +
            "\t\t\t\t\t\"NetworkNodes\": [{\n" +
            "\t\t\t\t\t\t\t\t\"name\": \"ABC Xabs\",\n" +
            "\t\t\t\t\t\t\t\t\"type\": \"Modem\",\n" +
            "\t\t\t\t\t\t\t\t\"local_ip\": \"192.168.3.190\",\n" +
            "\t\t\t\t\t\t\t\t\"mac\": \"38-D5-47-3A-C8-FF\",\n" +
            "\t\t\t\t\t\t\t\t\"state\": \"Active\",\n" +
            "\t\t\t\t\t\t\t\t\"lastActive\": \"\",\n" +
            "\t\t\t\t\t\t\t\t\"lastMaxTimeActive\": \"10:04:22\"\n" +
            "\t\t\t\t\t\t},\n" +
            "                              {\n" +
            "\t\t\t\t\t\t\t\t\"name\": \"ABC Xabs\",\n" +
            "\t\t\t\t\t\t\t\t\"type\": \"Modem\",\n" +
            "\t\t\t\t\t\t\t\t\"local_ip\": \"192.168.3.190\",\n" +
            "\t\t\t\t\t\t\t\t\"mac\": \"38-D5-47-3A-C8-FF\",\n" +
            "\t\t\t\t\t\t\t\t\"state\": \"Active\",\n" +
            "\t\t\t\t\t\t\t\t\"lastActive\": \"\",\n" +
            "\t\t\t\t\t\t\t\t\"lastMaxTimeActive\": \"10:04:22\"\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t]\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "                {\"name\": \"plm\",\n" +
            "\t\t\t\t\"home_addr\": \"Avenue Street, 54\",\n" +
            "\t\t\t\t\"phone\": \"2250402342\",\n" +
            "\t\t\t\t\"Coordinate\": {\n" +
            "\t\t\t\t\t\"lat\": \"23.3232\",\n" +
            "\t\t\t\t\t\"lon\": \"54.3232\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"ipAddress\": \"192.54.32.11\",\n" +
            "\t\t\t\t\"subnetwork\": {\n" +
            "\t\t\t\t\t\"NetworkNodes\": [{\n" +
            "\t\t\t\t\t\t\t\t\"name\": \"ABC Xabs\",\n" +
            "\t\t\t\t\t\t\t\t\"type\": \"Modem\",\n" +
            "\t\t\t\t\t\t\t\t\"local_ip\": \"192.168.3.190\",\n" +
            "\t\t\t\t\t\t\t\t\"mac\": \"38-D5-47-3A-C8-FF\",\n" +
            "\t\t\t\t\t\t\t\t\"state\": \"Active\",\n" +
            "\t\t\t\t\t\t\t\t\"lastActive\": \"\",\n" +
            "\t\t\t\t\t\t\t\t\"lastMaxTimeActive\": \"10:04:22\"\n" +
            "\t\t\t\t\t\t},\n" +
            "                              {\n" +
            "\t\t\t\t\t\t\t\t\"name\": \"ABC Xabs\",\n" +
            "\t\t\t\t\t\t\t\t\"type\": \"Modem\",\n" +
            "\t\t\t\t\t\t\t\t\"local_ip\": \"192.168.3.190\",\n" +
            "\t\t\t\t\t\t\t\t\"mac\": \"38-D5-47-3A-C8-FF\",\n" +
            "\t\t\t\t\t\t\t\t\"state\": \"Active\",\n" +
            "\t\t\t\t\t\t\t\t\"lastActive\": \"\",\n" +
            "\t\t\t\t\t\t\t\t\"lastMaxTimeActive\": \"10:04:22\"\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t]\n" +
            "\t\t\t\t}\n" +
            "\t\t\t}\n" +
            "\t\t]\n" +
            "\t}\n" +
            "},\n" +
            "{\n" +
            "\t\"NetworkSite\": {\n" +
            "\t\t\"site_name\": \"Second Site \",\n" +
            "\t\t\"site_quality\": \"good\",\n" +
            "\t\t\"site_location\": {\n" +
            "\t\t\t\"Coordinates\": [{\n" +
            "\t\t\t\t\t\"lat\": \"12.23232\",\n" +
            "\t\t\t\t\t\"lon\": \"12.34543\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"lat\": \"34.32323\",\n" +
            "\t\t\t\t\t\"lon\": \"32.23232\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"lat\": \"15.23232\",\n" +
            "\t\t\t\t\t\"lon\": \"22.34543\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"lat\": \"66.32323\",\n" +
            "\t\t\t\t\t\"lon\": \"66.23232\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"Subscribers\": [{\n" +
            "\t\t\t\t\"name\": \"plm\",\n" +
            "\t\t\t\t\"home_addr\": \"Avenue Street, 54\",\n" +
            "\t\t\t\t\"phone\": \"2250402342\",\n" +
            "\t\t\t\t\"Coordinate\": {\n" +
            "\t\t\t\t\t\"lat\": \"23.3232\",\n" +
            "\t\t\t\t\t\"lon\": \"54.3232\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"ipAddress\": \"192.54.32.11\",\n" +
            "\t\t\t\t\"subnetwork\": {\n" +
            "\t\t\t\t\t\"NetworkNodes\": [{\n" +
            "\t\t\t\t\t\t\t\t\"name\": \"ABC Xabs\",\n" +
            "\t\t\t\t\t\t\t\t\"type\": \"Modem\",\n" +
            "\t\t\t\t\t\t\t\t\"local_ip\": \"192.168.3.190\",\n" +
            "\t\t\t\t\t\t\t\t\"mac\": \"38-D5-47-3A-C8-FF\",\n" +
            "\t\t\t\t\t\t\t\t\"state\": \"Active\",\n" +
            "\t\t\t\t\t\t\t\t\"lastActive\": \"\",\n" +
            "\t\t\t\t\t\t\t\t\"lastMaxTimeActive\": \"10:04:22\"\n" +
            "\t\t\t\t\t\t},\n" +
            "                              {\n" +
            "\t\t\t\t\t\t\t\t\"name\": \"ABC Xabs\",\n" +
            "\t\t\t\t\t\t\t\t\"type\": \"Modem\",\n" +
            "\t\t\t\t\t\t\t\t\"local_ip\": \"192.168.3.190\",\n" +
            "\t\t\t\t\t\t\t\t\"mac\": \"38-D5-47-3A-C8-FF\",\n" +
            "\t\t\t\t\t\t\t\t\"state\": \"Active\",\n" +
            "\t\t\t\t\t\t\t\t\"lastActive\": \"\",\n" +
            "\t\t\t\t\t\t\t\t\"lastMaxTimeActive\": \"10:04:22\"\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t]\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "                {\"name\": \"plm\",\n" +
            "\t\t\t\t\"home_addr\": \"Avenue Street, 54\",\n" +
            "\t\t\t\t\"phone\": \"2250402342\",\n" +
            "\t\t\t\t\"Coordinate\": {\n" +
            "\t\t\t\t\t\"lat\": \"23.3232\",\n" +
            "\t\t\t\t\t\"lon\": \"54.3232\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"ipAddress\": \"192.54.32.11\",\n" +
            "\t\t\t\t\"subnetwork\": {\n" +
            "\t\t\t\t\t\"NetworkNodes\": [{\n" +
            "\t\t\t\t\t\t\t\t\"name\": \"ABC Xabs\",\n" +
            "\t\t\t\t\t\t\t\t\"type\": \"Modem\",\n" +
            "\t\t\t\t\t\t\t\t\"local_ip\": \"192.168.3.190\",\n" +
            "\t\t\t\t\t\t\t\t\"mac\": \"38-D5-47-3A-C8-FF\",\n" +
            "\t\t\t\t\t\t\t\t\"state\": \"Active\",\n" +
            "\t\t\t\t\t\t\t\t\"lastActive\": \"\",\n" +
            "\t\t\t\t\t\t\t\t\"lastMaxTimeActive\": \"10:04:22\"\n" +
            "\t\t\t\t\t\t},\n" +
            "                              {\n" +
            "\t\t\t\t\t\t\t\t\"name\": \"ABC Xabs\",\n" +
            "\t\t\t\t\t\t\t\t\"type\": \"Modem\",\n" +
            "\t\t\t\t\t\t\t\t\"local_ip\": \"192.168.3.190\",\n" +
            "\t\t\t\t\t\t\t\t\"mac\": \"38-D5-47-3A-C8-FF\",\n" +
            "\t\t\t\t\t\t\t\t\"state\": \"Active\",\n" +
            "\t\t\t\t\t\t\t\t\"lastActive\": \"\",\n" +
            "\t\t\t\t\t\t\t\t\"lastMaxTimeActive\": \"10:04:22\"\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t]\n" +
            "\t\t\t\t}\n" +
            "\t\t\t}\n" +
            "\t\t]\n" +
            "\t}\n" +
            "}\n" +
            "]";
}
