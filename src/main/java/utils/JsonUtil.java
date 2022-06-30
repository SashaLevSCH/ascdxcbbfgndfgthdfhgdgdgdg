package utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.DataProvider;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import org.json.simple.JSONArray;

public class JsonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);
    public static JSONObject jsonObject;

    public static JSONObject toJsonObject(String jsonFileName){
        URL resource = Res.getResource(jsonFileName);
        FileInputStream input = null;
        JSONObject jsonObject = null;
        try {
            File file = new File(resource.toURI());
            FileReader fileReader = new FileReader(resource.toURI().toString());
            JSONParser parser = new JSONParser();
            jsonObject = (JSONObject) parser.parse(fileReader);
            return jsonObject;
        } catch (URISyntaxException | ParseException | IOException e) {
            LOGGER.error("Could not parse json to JSONObject for "+jsonFileName,e);
            throw new RuntimeException("Could not parse json to JSONObject for "+jsonFileName,e);
        }
    }
    public static JSONArray toJsonArray(String jsonFileName){
        URL resource = Res.getResource(jsonFileName);
        FileInputStream input = null;
        JSONArray jsonArray = null;
        try {
            FileReader fileReader = new FileReader(resource.getPath());
            JSONParser parser = new JSONParser();
            jsonArray = (JSONArray) parser.parse(fileReader);
            return jsonArray;
        } catch (ParseException | IOException e) {
            LOGGER.error("Could not parse json to JSONArray for "+jsonFileName,e);
            throw new RuntimeException("Could not parse json to JSONArray for "+jsonFileName,e);
        }
    }
    public static List<Map> getFilteredRecordListFromJsonArray(JSONArray jsonArray, String key, String value) {
        List<Map> listOfFilteredRecords  = new ArrayList<>();
        Iterator itr = jsonArray.iterator();
        while (itr.hasNext()){
            Map<String,String> map = new HashMap<>();
            JSONObject jsonObject = ((JSONObject) itr.next());
            if(jsonObject.get(key).equals(value)){
                map = ((Map<String, String>) jsonObject);
                listOfFilteredRecords.add(map);
            }
        }
        return listOfFilteredRecords;
    }

    public static List<Map> getMapListFromJsonArray(JSONArray jsonArray) {
        List<Map> listOfFilteredRecords  = new ArrayList<>();
        Iterator itr = jsonArray.iterator();
        while (itr.hasNext()){
            Map<String,String> map = new HashMap<>();
            JSONObject jsonObject = ((JSONObject) itr.next());
            map = ((Map<String, String>) jsonObject);
            listOfFilteredRecords.add(map);
        }
        return listOfFilteredRecords;
    }


    /*    json object must be  import org.json.JSONObject; not simple jsonobject
        otherwise error while initiating this will happen*/

    public static JSONObject readTestData(String strScenarioName, String testDataFileName) throws Exception {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(testDataFileName);
        System.out.println("Scenario Data for - "+ strScenarioName);
        Object obj = jsonParser.parse(reader);
        JSONObject dataObject = (JSONObject) obj;
        JSONObject jsonChild = (JSONObject) dataObject.get(strScenarioName);
        return jsonChild;
    }


    public static Object[][] readTestDataFile(final String path){
        JsonObject jsonObject = null;
        try {
            jsonObject = new JsonParser()
                    .parse(new FileReader(path)).getAsJsonObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, String> maps = new Gson().fromJson(jsonObject,
                new TypeToken<HashMap<String, String>>() {}.getType());

        return new Object[][]{{maps}};
    }


    @DataProvider(name = "TestData_Path")
    public static Object[][] TestData_Path() {
        return readTestDataFile(Constants.ENROLL_TEST_DATA_PATH);
    }


    /**
     * Helper method for reading test data json files
     */
    public static Object[][] readTestDataFile1(final String path) {
        JsonObject jsonObject = null;
        try {
            jsonObject = new JsonParser()
                    .parse(new FileReader(path)).getAsJsonObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, String> maps = new Gson().fromJson(jsonObject,
                new TypeToken<HashMap<String, String>>() {
                }.getType());

        return new Object[][]{{maps}};
    }
    /*

      Two ways to use the file Pass it in testng xml file or Pass the file in Constants Java class
      Add the file name in the testng xml file   <parameter name="filename" value="src/test/resources/TestData/ridp_test_data.xlsx" />
    <parameter name="sheetname" value="Sheet1" />
     */


    @DataProvider(name = "TestData_Enroll")
    public static Object[][] TestData_Enroll() {
        JsonObject jsonObject = null;
        try {
            jsonObject = new JsonParser()
                    .parse(new FileReader(Constants.TEST_DATA_PATH)).getAsJsonObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, String> maps = new Gson().fromJson(jsonObject,
                new TypeToken<HashMap<String, String>>() {
                }.getType());

        return new Object[][]{{maps}};
    }



}
