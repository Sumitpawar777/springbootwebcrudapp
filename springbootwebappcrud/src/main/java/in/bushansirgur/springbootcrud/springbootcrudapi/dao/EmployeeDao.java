package in.bushansirgur.springbootcrud.springbootcrudapi.dao;

import in.bushansirgur.springbootcrud.springbootcrudapi.model.Employee;

import java.util.List;

public interface EmployeeDao {

	List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id);
	
}
