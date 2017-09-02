package com.unbm.andrei.ntviewer.test;

import com.unbm.andrei.ntviewer.application.NTViewerApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei on 5/1/2017.
 */

public class Helper {

    public static String getJsonResource(int resId) throws IOException {
        InputStream raw = NTViewerApplication.getInstance().getResources().openRawResource(resId);
        BufferedReader is = new BufferedReader(new InputStreamReader(raw, "UTF8"));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = is.readLine()) != null) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    // TODO: 6/14/2017 Change the response, for successfull login the user should get a token.
    public static final String LOGIN_SUCCEEDED_JSON =
            "{" +
                    "\"username\":\"test\"" +
                    "}";
    public static final String INVALID_CREDENTIALS = "{\"message\":\"Invalid Credentials\"}";
    public static final String GET_PROVIDERS_COVERAGE_JSON = "[\n" +
            "  {\n" +
            "\t\"name\": \"DIGI\",\n" +
            "\t\"color\": \"RED\",\n" +
            "\t\"geoLocations\": [{\n" +
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
            "\t\"geoLocations\": [{\n" +
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
    public static final String GET_DERANGEMENTS_JSON = "[\n" +
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
    public static final String GET_NETWORK_ROUTE_JSON = "[\n" +
            "  {\n" +
            "    \"routes\": [\n" +
            "      {\n" +
            "        \"routeId\": \"244001\",\n" +
            "        \"routeOk\": false,\n" +
            "        \"linePoints\": [\n" +
            "          {\n" +
            "            \"lat\": 47.660428,\n" +
            "            \"lon\": 23.542505\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.660421,\n" +
            "            \"lon\": 23.544801\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"routeId\": \"244001\",\n" +
            "        \"routeOk\": true,\n" +
            "        \"linePoints\": [\n" +
            "          {\n" +
            "            \"lat\": 47.660421,\n" +
            "            \"lon\": 23.544801\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.660277,\n" +
            "            \"lon\": 23.545616\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.661780,\n" +
            "            \"lon\": 23.545273\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.662235,\n" +
            "            \"lon\": 23.546078\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.662192,\n" +
            "            \"lon\": 23.554779\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.662676,\n" +
            "            \"lon\": 23.557246\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.664453,\n" +
            "            \"lon\": 23.562407\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.659785,\n" +
            "            \"lon\": 23.566999\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.659446,\n" +
            "            \"lon\": 23.565529\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.660147,\n" +
            "            \"lon\": 23.565164\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"routeId\": \"244002\",\n" +
            "        \"routeOk\": false,\n" +
            "        \"linePoints\": [\n" +
            "          {\n" +
            "            \"lat\": 47.660147,\n" +
            "            \"lon\": 23.565164\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.659923,\n" +
            "            \"lon\": 23.563909\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"routeId\": \"244003\",\n" +
            "        \"routeOk\": true,\n" +
            "        \"linePoints\": [\n" +
            "          {\n" +
            "            \"lat\": 47.660147,\n" +
            "            \"lon\": 23.565164\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.659879,\n" +
            "            \"lon\": 23.563319\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"routeId\": \"244004\",\n" +
            "        \"routeOk\": true,\n" +
            "        \"linePoints\": [\n" +
            "          {\n" +
            "            \"lat\": 47.659814,\n" +
            "            \"lon\": 23.566913\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.659395,\n" +
            "            \"lon\": 23.566495\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.658607,\n" +
            "            \"lon\": 23.566774\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.658535,\n" +
            "            \"lon\": 23.565744\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.657574,\n" +
            "            \"lon\": 23.565808\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.656924,\n" +
            "            \"lon\": 23.570915\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.657885,\n" +
            "            \"lon\": 23.576612\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.659670,\n" +
            "            \"lon\": 23.580485\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.659357,\n" +
            "            \"lon\": 23.581452\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.657091,\n" +
            "            \"lon\": 23.582955\n" +
            "          },\n" +
            "          {\n" +
            "            \"lat\": 47.657010,\n" +
            "            \"lon\": 23.582878\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    ],\n" +
            "    \"nodes\": [\n" +
            "      {\n" +
            "        \"id\": \"254201\",\n" +
            "        \"type\": \"big_building\",\n" +
            "        \"lat\": 47.660428,\n" +
            "        \"lon\": 23.542505\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"254202\",\n" +
            "        \"type\": \"big_building\",\n" +
            "        \"lat\": 47.660421,\n" +
            "        \"lon\": 23.544801\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"254203\",\n" +
            "        \"type\": \"big_building\",\n" +
            "        \"lat\": 47.660147,\n" +
            "        \"lon\": 23.565164\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"254204\",\n" +
            "        \"type\": \"big_building\",\n" +
            "        \"lat\": 47.659923,\n" +
            "        \"lon\": 23.563909\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"254205\",\n" +
            "        \"type\": \"big_building\",\n" +
            "        \"lat\": 47.659879,\n" +
            "        \"lon\": 23.563319\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"254206\",\n" +
            "        \"type\": \"big_building\",\n" +
            "        \"lat\": 47.657010,\n" +
            "        \"lon\": 23.582878\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"254207\",\n" +
            "        \"type\": \"switch\",\n" +
            "        \"lat\": 47.660421,\n" +
            "        \"lon\": 23.544801\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"254208\",\n" +
            "        \"type\": \"switch\",\n" +
            "        \"lat\": 47.660428,\n" +
            "        \"lon\": 23.542505\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"254209\",\n" +
            "        \"type\": \"switch\",\n" +
            "        \"lat\": 47.660147,\n" +
            "        \"lon\": 23.565164\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"254210\",\n" +
            "        \"type\": \"switch_epon\",\n" +
            "        \"lat\": 47.659385,\n" +
            "        \"lon\": 23.565564\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"254211\",\n" +
            "        \"type\": \"switch_epon\",\n" +
            "        \"lat\": 47.659779,\n" +
            "        \"lon\": 23.566959\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"254212\",\n" +
            "        \"type\": \"switch\",\n" +
            "        \"lat\": 47.657010,\n" +
            "        \"lon\": 23.582878\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]";

    private static final List<String> NODE_INFO_LIST = new ArrayList<>();

    private static final String NODE_INFO_BIG_BUILDING1 = "{\n" +
            "\t\"nodeId\": 254201,\n" +
            "\t\"name\": \"Caminul 2\",\n" +
            "\t\"ip\": \"192.168.3.180\",\n" +
            "\t\"last_updated\": \"24/06/2017\",\n" +
            "\t\"status\": \"Active\"\n" +
            "}";
    private static final String NODE_INFO_BIG_BUILDING2 = "{\n" +
            "\t\"nodeId\": 254202,\n" +
            "\t\"type\": \"big_building\",\n" +
            "\t\"name\": \"Facultatea de Inginerie\",\n" +
            "\t\"ip\": \"192.168.3.180\",\n" +
            "\t\"last_updated\": \"24/06/2017\",\n" +
            "\t\"status\": \"Active\"\n" +
            "}";
    private static final String NODE_INFO_BIG_BUILDING3 = "{\n" +
            "\t\"nodeId\": 254203,\n" +
            "\t\"type\": \"big_building\",\n" +
            "\t\"name\": \"Facultatea de stiinte\",\n" +
            "\t\"ip\": \"192.168.66.10\",\n" +
            "\t\"last_updated\": \"24/06/2017\",\n" +
            "\t\"status\": \"Active\"\n" +
            "}";
    private static final String NODE_INFO_BIG_BUILDING4 = "{\n" +
            "\t\"nodeId\": 254204,\n" +
            "\t\"type\": \"big_building\",\n" +
            "\t\"name\": \"Caminul 3\",\n" +
            "\t\"ip\": \"192.138.55.10\",\n" +
            "\t\"last_updated\": \"24/06/2017\",\n" +
            "\t\"status\": \"Active\"\n" +
            "}";
    private static final String NODE_INFO_BIG_BUILDING5 = "{\n" +
            "\t\"nodeId\": 254205,\n" +
            "\t\"type\": \"big_building\",\n" +
            "\t\"name\": \"Caminul 1\",\n" +
            "\t\"ip\": \"192.168.56.11\",\n" +
            "\t\"last_updated\": \"24/06/2017\",\n" +
            "\t\"status\": \"Active\"\n" +
            "}";
    private static final String NODE_INFO_BIG_BUILDING6 = "{\n" +
            "\t\"nodeId\": 254206,\n" +
            "\t\"type\": \"big_building\",\n" +
            "\t\"name\": \"Facultate Centru Vechi\",\n" +
            "\t\"ip\": \"192.156.54.250\",\n" +
            "\t\"last_updated\": \"24/06/2017\",\n" +
            "\t\"status\": \"Active\"\n" +
            "}";

    private static final String NODE_SWITCH1 = "{\n" +
            "\t\"nodeId\": 254207,\n" +
            "\t\"type\": \"switch\",\n" +
            "\t\"name\": \"Caminul 2\",\n" +
            "\t\"ip\": \"192.168.5.110\",\n" +
            "\t\"last_updated\": \"24/06/2017\",\n" +
            "\t\"status\": \"Active\"\n" +
            "}";
    private static final String NODE_SWITCH2 = "{\n" +
            "\t\"nodeId\": 254208,\n" +
            "\t\"type\": \"switch\",\n" +
            "\t\"name\": \"Facultate de inginerie\",\n" +
            "\t\"ip\": \"192.168.3.180\",\n" +
            "\t\"last_updated\": \"24/06/2017\",\n" +
            "\t\"status\": \"Active\"\n" +
            "}";
    private static final String NODE_SWITCH3 = "{\n" +
            "\t\"nodeId\": 254209,\n" +
            "\t\"type\": \"switch\",\n" +
            "\t\"name\": \"Facultatea de stiinte\",\n" +
            "\t\"ip\": \"192.168.66.10\",\n" +
            "\t\"last_updated\": \"24/06/2017\",\n" +
            "\t\"status\": \"Active\"\n" +
            "}";
    private static final String NODE_SWITCH4 = "{\n" +
            "\t\"nodeId\": 254210,\n" +
            "\t\"type\": \"switch\",\n" +
            "\t\"name\": \"Facultate Centru Vechi\",\n" +
            "\t\"ip\": \"192.156.54.250\",\n" +
            "\t\"last_updated\": \"24/06/2017\",\n" +
            "\t\"status\": \"Active\"\n" +
            "}";

    private static final String NODE_SWITCH_EPON1 = "{\n" +
            "\t\"nodeId\": 254211,\n" +
            "\t\"type\": \"switch_epon\",\n" +
            "\t\"name\": \"Petrom bucla\",\n" +
            "\t\"ip\": \"167.45.54.111\",\n" +
            "\t\"last_updated\": \"24/06/2017\",\n" +
            "\t\"status\": \"Active\"\n" +
            "}";
    private static final String NODE_SWITCH_EPON2 = "{\n" +
            "\t\"nodeId\": 254212,\n" +
            "\t\"type\": \"switch_epon\",\n" +
            "\t\"name\": \"Bucla\",\n" +
            "\t\"ip\": \"164.112.112.112\",\n" +
            "\t\"last_updated\": \"24/06/2017\",\n" +
            "\t\"status\": \"Active\"\n" +
            "}";

    static {
        NODE_INFO_LIST.add(NODE_INFO_BIG_BUILDING1);
        NODE_INFO_LIST.add(NODE_INFO_BIG_BUILDING2);
        NODE_INFO_LIST.add(NODE_INFO_BIG_BUILDING3);
        NODE_INFO_LIST.add(NODE_INFO_BIG_BUILDING4);
        NODE_INFO_LIST.add(NODE_INFO_BIG_BUILDING5);
        NODE_INFO_LIST.add(NODE_INFO_BIG_BUILDING6);
        NODE_INFO_LIST.add(NODE_SWITCH1);
        NODE_INFO_LIST.add(NODE_SWITCH2);
        NODE_INFO_LIST.add(NODE_SWITCH3);
        NODE_INFO_LIST.add(NODE_SWITCH4);
        NODE_INFO_LIST.add(NODE_SWITCH_EPON1);
        NODE_INFO_LIST.add(NODE_SWITCH_EPON2);
    }

    public static String getNodeById(String nodeId) {
        for (String json : NODE_INFO_LIST) {
            if (json.contains(nodeId)) {
                return json;
            }
        }
        return null;
    }

}
