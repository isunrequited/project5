package com.project.scheduler.employee.controller;

import com.project.scheduler.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    
    // 로그인
    @GetMapping("/login")
    public String login(int empNo, String password) {
        if(employeeService.checkEmpNo(empNo)) {
            if(employeeService.getPassword(empNo).equals(password)) {
                // 로그인 성공
            }
            // 패스워드 불일치
        }
        // 없는 사번
        return "";
    }
}
