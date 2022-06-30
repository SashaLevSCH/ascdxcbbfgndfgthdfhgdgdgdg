package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class JsonUtils {
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



    public static List<Map> getFilteredRecordListFromJsonArray(JSONArray jsonArray, String key, String value, String key2, String value2) {
        List<Map> listOfFilteredRecords  = new ArrayList<>();
        Iterator itr = jsonArray.iterator();
        while (itr.hasNext()){
            Map<String,String> map = new HashMap<>();
            JSONObject jsonObject = ((JSONObject) itr.next());
            if(jsonObject.get(key).equals(value) && jsonObject.get(key2).equals(value2)){
                map = ((Map<String, String>) jsonObject);
                listOfFilteredRecords.add(map);
            }
        }
        return listOfFilteredRecords;
    }

}
