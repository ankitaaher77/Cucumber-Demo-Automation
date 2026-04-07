package utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader {

public static JSONObject getuser(int index){
    try {
        String content = new String(Files.readAllBytes(Paths.get("src/test/resources/testdata/login.json")));
        JSONObject jsonObject = new JSONObject(content);
        JSONArray users = jsonObject.getJSONArray("users");
        return users.getJSONObject(index);
    }
    catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

}




