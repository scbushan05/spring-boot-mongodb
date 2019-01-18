package in.bushansirgur.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.bushansirgur.restapi.dao.EmployeeDAO;
import in.bushansirgur.restapi.model.EmployeeModel;
import in.bushansirgur.restapi.service.SequenceGeneratorService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Autowired
	SequenceGeneratorService seqGeneratorService;
	
	@PostMapping("/create")
	public EmployeeModel create(@RequestBody EmployeeModel newEmployeeObject) {
		newEmployeeObject.setId(seqGeneratorService.generateSequence(EmployeeModel.SEQUENCE_NAME));
		return employeeDAO.save(newEmployeeObject);
	}
	
	@GetMapping("/read")
	public List<EmployeeModel> read(){
		return employeeDAO.findAll();
	}
	
	@GetMapping("/read/{id}")
	public EmployeeModel read(@PathVariable Long id) {
		Optional<EmployeeModel> employeeObj = employeeDAO.findById(id);
		if(employeeObj.isPresent()) {
			return employeeObj.get();
		}else {
			throw new RuntimeException("Employee not found with id "+id);
		}
	}
	
	@PutMapping("/update")
	public EmployeeModel update(@RequestBody EmployeeModel modifiedEmployeeObject) {
		return employeeDAO.save(modifiedEmployeeObject);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		Optional<EmployeeModel> employeeObj = employeeDAO.findById(id);
		if(employeeObj.isPresent()) {
			employeeDAO.delete(employeeObj.get());
			return "Employee deleted with id "+id;
		}else {
			throw new RuntimeException("Employee not found for id "+id);
		}
	}
	
}
