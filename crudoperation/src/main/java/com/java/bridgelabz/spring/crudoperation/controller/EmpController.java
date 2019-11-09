package com.java.bridgelabz.spring.crudoperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.bridgelabz.spring.crudoperation.dao.EmployeeDAO;
import com.java.bridgelabz.spring.crudoperation.model.Employee;

@Controller
public class EmpController {
	
	@Autowired
	EmployeeDAO empDao;
	
	@RequestMapping("/empform")
	public String showform(Model model) {
		model.addAttribute("command", new Employee());
		return "empform";
		
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("emp") Employee emp){    
        empDao.save(emp);    
        return "redirect:/viewemp";   
    }    
	
	@RequestMapping("/viewemp")    
    public String viewemp(Model m){    
        List<Employee> list=empDao.getEmployees();    
        m.addAttribute("list",list);  
        return "viewemp";    
    }   
	
	@RequestMapping(value="/editemp/{id}")    
    public String edit(@PathVariable int id, Model model){    
        Employee emp=empDao.getEmployeeById(id);    
        model.addAttribute("command",emp);  
        return "empeditform";    
    }   
	
	@RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("emp") Employee emp){    
        empDao.update(emp);    
        return "redirect:/viewemp";    
    }    
	
	
	@RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        empDao.delete(id);    
        return "redirect:/viewemp";    
    }     
	
}
