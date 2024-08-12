package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController2 {
	@GetMapping("list2")
	@ResponseBody
	// public Map<String, String> getJsons() { => <String, String>작성 시 데이터 1개의 값만 넘어간다.
	public Map<String, Object> getJsons() {
		List<Map<String, String>> dataList = new ArrayList<Map<String,String>>();
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", "여빙");
		data.put("age", "24");
		dataList.add(data);
		
		data = new HashMap<String, String>();
		data.put("name", "냐옹");
		data.put("age", "3");
		dataList.add(data);
		
		data = new HashMap<String, String>();
		data.put("name", "멍멍");
		data.put("age", "2");
		dataList.add(data);
		// return data;
		System.out.println("data : " + data);
		
		Map<String, Object> data2 = new HashMap<String, Object>();
		data2.put("datas", dataList);
		System.out.println("dataList : " + dataList);
		// dataList : [{name=여빙, age=24}, {name=냐옹, age=3}, {name=멍멍, age=2}]
		// @ResponseBody에 의해 {"datas":[{name=여빙, age=24}, {name=냐옹, age=3}, {name=멍멍, age=2}]}
		
		return data2;
	}	
}
