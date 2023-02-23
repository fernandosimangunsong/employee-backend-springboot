package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.AttributedString;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list/{id}")
    public Employee getEmployeeById(@PathVariable long id) {
        return employeeService.getEmployeeById(id); }
    @GetMapping("/list")
    public List<Employee> list () { return employeeService.getAllEmployee();}
//
    @PostMapping ("/add")
    public Employee add (@RequestBody Employee employee){ return employeeService.save(employee);}

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") Long id) {
        System.out.println("deleteById = "+id);
        employeeService.deleteEmployeeById(id);
        return "Data Employee telah dihapus";
    }

    @PostMapping("/update")
    public String update(@RequestBody Employee employee) {
        Employee employeedb = employeeService.getEmployeeById(employee.getId());
        employeedb.setNik(employee.getNik());
        employeedb.setName(employee.getName());
        employeedb.setHired_date(employee.getHired_date());
        employeedb.setExpired_date(employee.getExpired_date());
        employeedb.setSalary(employee.getSalary());
        employeedb.setBirth_date(employee.getBirth_date());
        employeedb.setNpwp(employee.getNpwp());
        employeedb.setSex(employee.getSex());
        employeedb.setType(employee.getType());
        employeeService.save(employeedb);
        return "Data telah diupdate";
    }
        @PutMapping("/update/{id}")
        public String updateData(@PathVariable int id, @RequestBody Employee updatedData) {
            // logika untuk meng-update data
            return "redirect:/list";
        }

//    @PostMapping("/save")
//    public String saveEmployee(@ModelAttribute("employee") Employee employee){
//        employeeService.save(employee);
//        return "redirect:/";
//    }
//
//
//    @GetMapping("/delete/{id}")
//    public String deleteById(@PathVariable(value = "id") long id){
//        employeeService.deleteById(id);
//        return "redirect:/";
//    }
//

}
