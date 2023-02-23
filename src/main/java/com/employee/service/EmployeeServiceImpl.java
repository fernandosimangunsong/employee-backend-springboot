package com.employee.service;

import com.employee.model.Employee;
import com.employee.model.Leave;
import com.employee.model.Lookup;
import com.employee.repository.EmployeeRepository;
import com.employee.repository.LookupRepository;
import com.employee.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LookupRepository lookupRepository;


    @Autowired
    private LeaveRepository leaveRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Lookup> getAllLookup() {
        return lookupRepository.findAll();
    }

    @Override
    public List<Leave> getAllLeave() {
        return leaveRepository.findAll();
    }

    @Override
    public Leave save(Leave leave) {
        if (Objects.nonNull(leave)) {
            return leaveRepository.save(leave);
        }
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        if (Objects.nonNull(employee)) {
            return employeeRepository.save(employee);
        }
        return null;
    }
    public Lookup save(Lookup lookup) {
        if (Objects.nonNull(lookup)) {
            return lookupRepository.save(lookup);
        }
        return null;
    }


    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = null;
        if (Objects.nonNull(id)) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(id);
            if(optionalEmployee.isPresent()){
                employee = optionalEmployee.get();
            }else{
                throw new RuntimeException("Employee not found with the id:"+ id);
            }
        }
        return employee;
    }

    @Override
    public Lookup getLookupById(Long id) {
        Lookup lookup = null;
        if (Objects.nonNull(id)) {
            Optional<Lookup> optionalLookup = lookupRepository.findById(id);
            if(optionalLookup.isPresent()){
                lookup = optionalLookup.get();
            }else{
                throw new RuntimeException("Lookup not found with the id:"+ id);
            }
        }
        return lookup;
    }

    @Override
    public List<Lookup> getLookupByGroupName(String groupName) {
        List<Lookup> listLookup = null;
        System.out.println(Objects.nonNull(groupName));
        if (Objects.nonNull(groupName)) {
            System.out.println("Triggered deleteLeaveById " + groupName);
           listLookup =  lookupRepository.findByGroup(groupName);
        }
        return listLookup;
    }

    @Override
    public Leave getLeaveById(Long id) {
        Leave leave = null;
        if (Objects.nonNull(id)) {
            Optional<Leave> optionalLeave = leaveRepository.findById(id);
            if(optionalLeave.isPresent()){
                leave = optionalLeave.get();
            }else{
                throw new RuntimeException("Leave not found with the id:"+ id);
            }
        }
        return leave;
    }
    @Override
    public void deleteEmployeeById(Long id) {
        System.out.println(Objects.nonNull(id));
        if(Objects.nonNull(id)){
            System.out.println("Triggered deletaEmployeeById "+id);
            employeeRepository.deleteById(id);
        }
    }

    @Override
    public void deleteLookupById(Long id) {
        System.out.println(Objects.nonNull(id));
        if(Objects.nonNull(id)){
            System.out.println("Triggered deletaLookupById "+id);
            lookupRepository.deleteById(id);
        }
    }

    @Override
    public void deleteById(Long id) {
        System.out.println(Objects.nonNull(id));
        if(Objects.nonNull(id)){
            System.out.println("Triggered deleteLeaveById "+id);
            leaveRepository.deleteById(id);
        }
    }

    @Override
    public Employee deleteEmployeeById(long employee) {
        return null;
    }

    @Override
    public void deleteLeaveById(Long leave) {
        System.out.println(Objects.nonNull(leave));
        if (Objects.nonNull(leave)) {
            System.out.println("Triggered deleteLeaveById " + leave);
            leaveRepository.deleteById(leave);
        }
    }

    @Override
    public String deleteById() {
        return null;
    }

    @Override
    public Leave deleteById(long employee) {
        return null;
    }


}


