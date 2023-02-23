package com.employee.controller;

import com.employee.model.Employee;
import com.employee.model.Leave;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private EmployeeService leaveService;

    @GetMapping("/list")
    public List<Leave> list () {return leaveService.getAllLeave();}
    //
    @PostMapping ("/add")
    public Leave add (@RequestBody Leave tblleave){return leaveService.save(tblleave);}

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") Long id) {
        System.out.println("deleteById = "+id);
        leaveService.deleteLeaveById(id);
        return "Data Leave telah dihapus";
    }

    @PostMapping("/update")
    public String update(@RequestBody Leave tblleave) {
        Leave leavedb = leaveService.getLeaveById(tblleave.getId());
        leavedb.setId(tblleave.getId());
        leavedb.setEmployee_id(tblleave.getEmployee_id());
        leavedb.setFrom_date(tblleave.getFrom_date());
        leavedb.setType(tblleave.getType());
        leavedb.setReason(tblleave.getReason());
        leavedb.setCreated_date(tblleave.getCreated_date());
        leavedb.setCreated_by(tblleave.getCreated_by());
        leavedb.setModified_date(tblleave.getModified_date());
        leavedb.setModified_by(tblleave.getModified_by());
        leaveService.save(leavedb);
        return "Data telah diupdate";
    }
//
//    @PostMapping("/save")
//    public String saveEmployee(@ModelAttribute("employee") Employee employee){
//        employeeService.save(employee);
//        return "redirect:/";
//    }
//
//    @GetMapping("updateform/{id}")
//    public String updateForm(@PathVariable(value = "id") long id, Model model){
//        Employee employee = employeeService.getById(id);
//        model.addAttribute("employee", employee);
//        return "update";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteById(@PathVariable(value = "id") long id){
//        employeeService.deleteById(id);
//        return "redirect:/";
//    }
//

}
