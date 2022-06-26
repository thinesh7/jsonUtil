package com.learn.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonParseUtil {

	public String createJson(Map<String, Object> paramMap) {
		log.info("Received paramMap :: {} ", paramMap);
		JSONObject result = new JSONObject();
		for (Entry<String, Object> entry : paramMap.entrySet()) {
			prepareJsonObj(result, entry.getKey(), entry.getValue());
		}
		return result.toString();
	}

	private JSONObject prepareJsonObj(JSONObject josnObject, String path, Object value) {
		List<String> pathList = Arrays.asList(path.split("\\."));
		JSONObject innerNode = josnObject;
		JSONObject jsonElement;

		for (int i = 0; i < pathList.size() - 1; i++) {
			if (!innerNode.has(pathList.get(i))) {
				jsonElement = new JSONObject();
				innerNode.put(pathList.get(i), jsonElement);
				innerNode = jsonElement;
			} else {
				innerNode = innerNode.getJSONObject(pathList.get(i));
			}
		}
		innerNode.put(pathList.get(pathList.size() - 1), value);
		log.info("Prepared JSON Obj {} ", josnObject.toString());
		return josnObject;
	}
}
