package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pack.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/alldatas")
	public String allDatas() {
		customerService.printAlldata();
		return "전체 자료 출력";
	}
	
	// http://localhost:8080/updatedata?name=소희군 <= 수정 uri
	@GetMapping("/updatedata")
	public String upData(@RequestParam(name="name")String name) {
		customerService.updateData(name);
		return "자료 수정";
	}
	
	// http://localhost:8080/deletedata?name=소희군 <= 삭제 uri
	@GetMapping("/deletedata")
	public String delData(@RequestParam(name="name")String name) {
		customerService.deleteData(name);
		return "자료 삭제";
	}
}