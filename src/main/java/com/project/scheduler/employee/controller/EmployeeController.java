package com.project.scheduler.employee.controller;

import com.project.scheduler.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Log4j2
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("")
    public String main() {
        return "/login";
    }
    
    // 로그인
    @PostMapping("/login")
    public String login(int empNo, String password) {
        if(employeeService.checkEmpNo(empNo)) {
            if(employeeService.getPassword(empNo).equals(password)) {
                // 로그인 성공
                log.info(empNo + "님 로그인성공!!");
                return "redirect:/schedule/calendar/" + empNo;
            }
            // 패스워드 불일치
        }
        log.info(empNo + "님 로그인실패!!");
        // 없는 사번
        return "redirect:";
    }
    
    // 사원 정보 들고오기
}
