package Nunc.Core.Libraries;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CommonUtil {
	
	public static JSONArray readJsonArray(String file, String object) {
		JSONArray list =null;
		JSONParser parser =new JSONParser();
		try {
			FileReader reader=new FileReader("testdata/"+file+".json");
			Object obj= parser.parse(reader);
			JSONObject jsonObject = (JSONObject)obj;
			list = (JSONArray) jsonObject.get(object);
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return list;
	}
	public static JSONObject readJsonObject(String file, String object) {
		JSONObject list =null;
		JSONParser parser =new JSONParser();
		try {
			FileReader reader=new FileReader("testdata/"+file+".json");
			Object obj= parser.parse(reader);
			JSONObject jsonObject = (JSONObject)obj;
			list = (JSONObject) jsonObject.get(object);
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return list;
	}
}

