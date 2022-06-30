package utils;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonPathUtil {

    public static String getKeyValueByJsonPath(File jsonFile , String Node, String Key) throws IOException {
        Map<String, String> objectMap = JsonPath.read(jsonFile, "$");
        Map<String, String> objectMap1 = JsonPath.read(jsonFile, "$['"+Node+"']");
        String KeyVal = objectMap1.get(Key);
        return KeyVal;
    }



    public  static String getArrayValuesByJsonPath(File jsonFile , String ArrayNode, String ArrayVals) throws IOException {
        JSONArray jsonArray = JsonPath.read(jsonFile, "$['"+ArrayNode+"']['"+ArrayVals+"'][*]");
        String Vals = jsonArray.toJSONString();
        System.out.println(Vals);;
        return Vals;
    }



  private static File jsonFile = new File("src/test/resources/TestData/QAData.json");

    @Test
    public void getJsonPathKeyValues() throws IOException {
        // JSONArray objectMap = JsonPath.read(jsonFile, "$['signup']['MedicalPro'][*]");
        //   System.out.println(objectMap.toJSONString());
        getArrayValuesByJsonPath(jsonFile,"signup","MedicalPro");
    }


}
