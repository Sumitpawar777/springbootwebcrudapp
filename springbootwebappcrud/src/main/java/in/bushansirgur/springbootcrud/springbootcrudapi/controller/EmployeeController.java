package in.bushansirgur.springbootcrud.springbootcrudapi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import in.bushansirgur.springbootcrud.springbootcrudapi.service.EmployeeService;
import in.bushansirgur.springbootcrud.springbootcrudapi.model.Employee;

@Controller
public class EmployeeController {

	@Autowired 
	private EmployeeService employeeService;
	
	/*this function is used add new employee through form*/
	@RequestMapping("/save")
	public ModelAndView save(@ModelAttribute("employee") Employee employeeObj) {
		ModelAndView mav = new ModelAndView("employeesList");
		employeeService.save(employeeObj);
		mav.addObject("list", employeeService.get());
		return mav;
	}
	
	/*this function is used to neviagte to form*/
	@RequestMapping("/showEmployeeForm")
	public ModelAndView showEmployeeForm() {
		ModelAndView mv = new ModelAndView("employeesAdd");
		mv.addObject("employee",new Employee());
		return mv;
	}
	
	/*home page which showing no of employee are in database*/
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView get() {
		ModelAndView mv = new ModelAndView("employeesList");
		mv.addObject("list", employeeService.get());
		return mv;
	}

	/*this function is used to edit employees from the database based on the id here id is passed using Querystring*/
	@RequestMapping("/employee")
	public ModelAndView get(@RequestParam("id") int id) {
		   Employee empolyeeObj = employeeService.get(id);
		   ModelAndView mv = new ModelAndView("employeesAdd");
		   mv.addObject("employee", empolyeeObj);
		   if(empolyeeObj == null) {
			   throw new RuntimeException("Employee not found for this id"+id+"Not found");
		   }
		   return mv;
	}
	
	/*this function is used to delete employee from the database based on the id here id is passed using Path variable*/
	@RequestMapping("delete/{id}")
	public ModelAndView delete(@PathVariable int id) {
		ModelAndView mvn = new ModelAndView("employeesList"); 
		employeeService.delete(id);
		mvn.addObject("list", employeeService.get());
		return mvn;
	}
	

	/*this function used to update employee object*//
	@PutMapping("/employee")
	public Employee update(@RequestBody Employee employeeObj) {
		employeeService.save(employeeObj);
		return employeeObj;
	}
}
