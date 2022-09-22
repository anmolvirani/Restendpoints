package com.restapi.mycontroller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping("/hello")
	public ResponseEntity<Object> sayHello()
	{
		Map<String,String> mp = new HashMap<>();
		mp.put("aa","bb");
		return new ResponseEntity<>("Hello",HttpStatus.OK);
	}

}
