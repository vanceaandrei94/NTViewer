package com.unbm.andrei.ntviewer.test;

/**
 * Created by Andrei on 5/1/2017.
 */

public class Helper {

    // TODO: 6/14/2017 Change the response, for successfull login the user should get a token.
    public static final String LOGIN_SUCCEEDED_JSON =
            "{" +
            "\"User\": {" +
            "   \"username\":\"test\"," +
                    "\"isWorking\":\"true\"" +
            "   }" +
            "}";
    public static final String INVALID_CREDENTIALS = "{\"message\":\"Invalid Credentials\"}";
    public static final String GET_PROVIDERS_COVERAGE_JSON = "[\n" +
            "  {\n" +
            "\t\"name\": \"DIGI\",\n" +
            "\t\"color\": \"RED\",\n" +
            "\t\"subscribers\": [{\n" +
            "\t\t\t\"lat\": 47.661506,\n" +
            "\t\t\t\"lon\": 23.574064\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"lat\": 47.661362,\n" +
            "\t\t\t\"lon\": 23.547885\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"lat\": 47.660148,\n" +
            "\t\t\t\"lon\": 23.546641\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"lat\": 47.660784,\n" +
            "\t\t\t\"lon\": 23.551576\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"lat\": 47.661795,\n" +
            "\t\t\t\"lon\": 23.574064\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"lat\": 47.656274,\n" +
            "\t\t\t\"lon\": 23.572476\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"lat\": 47.654808,\n" +
            "\t\t\t\"lon\": 23.567004\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"lat\": 47.653413,\n" +
            "\t\t\t\"lon\": 23.551662\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"lat\": 47.653384,\n" +
            "\t\t\t\"lon\": 23.561490\n" +
            "\t\t}\n" +
            "\t]\n" +
            "},\n" +
            "{\n" +
            "\t\"name\": \"TELEKOM\",\n" +
            "\t\"color\": \"BLUE\",\n" +
            "\t\"subscribers\": [{\n" +
            "\t\t\t\"lat\": 46.661506,\n" +
            "\t\t\t\"lon\": 23.574064\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"lat\": 46.661362,\n" +
            "\t\t\t\"lon\": 23.547885\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"lat\": 46.660148,\n" +
            "\t\t\t\"lon\": 23.546641\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"lat\": 46.660784,\n" +
            "\t\t\t\"lon\": 23.551576\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"lat\": 46.661795,\n" +
            "\t\t\t\"lon\": 23.574064\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"lat\": 46.656274,\n" +
            "\t\t\t\"lon\": 23.572476\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"lat\": 46.654808,\n" +
            "\t\t\t\"lon\": 23.567004\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"lat\": 46.653413,\n" +
            "\t\t\t\"lon\": 23.551662\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"lat\": 46.653384,\n" +
            "\t\t\t\"lon\": 23.561490\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}\n" +
            "]";
    public static final String GET_COMPLAINTS_JSON = "[\n" +
            "  {\n" +
            "\t\"priority\": 90,\n" +
            "\t\"lat\": 47.660306,\n" +
            "\t\"lon\": 23.546142\n" +
            "  },\n" +
            "  {\n" +
            "\t\"priority\": 70,\n" +
            "\t\"lat\": 47.659554,\n" +
            "\t\"lon\": 23.546174\n" +
            "  },\n" +
            "  {\n" +
            "\t\"priority\": 30,\n" +
            "\t\"lat\": 47.659713,\n" +
            "\t\"lon\": 23.550026\n" +
            "  },\n" +
            "  {\n" +
            "\t\"priority\": 20,\n" +
            "\t\"lat\": 47.661180,\n" +
            "\t\"lon\": 23.549328\n" +
            "  },\n" +
            "  {\n" +
            "\t\"priority\": 90,\n" +
            "\t\"lat\": 47.661100,\n" +
            "\t\"lon\": 23.547494\n" +
            "  },\n" +
            "  {\n" +
            "\t\"priority\": 10,\n" +
            "\t\"lat\": 47.660127,\n" +
            "\t\"lon\": 23.544806\n" +
            "  }\n" +
            "]";
    public static final String GET_NETWORK_ROUTE_JSON = "";
}
