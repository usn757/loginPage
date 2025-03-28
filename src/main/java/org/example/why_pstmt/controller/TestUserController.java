package org.example.why_pstmt.controller;


import org.example.why_pstmt.model.dao.TestUserRepository;
import org.example.why_pstmt.model.dto.TestUserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/")
public class TestUserController {
    private final TestUserRepository testUserRepository;


    public TestUserController(TestUserRepository testUserRepository) {
        this.testUserRepository = testUserRepository;
    }


    @GetMapping("/")
    public String index() {
        return "newIndex";
    }

    @PostMapping("/")
    public String login(@ModelAttribute TestUserDTO dto, Model model) throws SQLException {
        boolean result = testUserRepository.login(dto.username(), dto.password());
        model.addAttribute(
                "message",
                result ? "로그인 성공 : %s 환영함".formatted(dto.username()) : "로그인 실패");
        return "newIndex";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PostMapping("/join")
    public String signUp(@ModelAttribute TestUserDTO dto) throws SQLException {
        testUserRepository.createTestUser(dto.username(), dto.password());
        return "redirect:/";
    }
}