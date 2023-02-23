package com.employee.service;

import com.employee.model.Employee;
import com.employee.model.Leave;
import com.employee.model.Lookup;
import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();

    Employee save(Employee employee);

    Employee getEmployeeById(Long id);

    Leave getLeaveById(Long id);

    void deleteEmployeeById(Long ids);

    List<Lookup> getAllLookup();

    Lookup save(Lookup lookup);

    Lookup getLookupById(Long id);

    void deleteLookupById(Long ids);

    List<Leave> getAllLeave();

    Leave save(Leave leave);

    void deleteLeaveById(Long ids);

    void deleteById(Long id);

    Employee deleteEmployeeById(long employee);

    String deleteById();

    Leave deleteById(long employee);

    List<Lookup> getLookupByGroupName(String groupName);
}

