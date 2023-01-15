package common;

import org.json.JSONObject;

public class GraphqlQueryBuilder {

    public static String getQueryBody(String query, int limitVariable) {

        JSONObject variablesObject = new JSONObject();
        variablesObject.put("limit", limitVariable);
        JSONObject queryObject = new JSONObject();
        queryObject.put("query", query);
        queryObject.put("variables", variablesObject);

        String queryBody = queryObject.toString();

        return queryBody;
    }
}
