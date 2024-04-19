package com.blog.Api.Blog.controller;

import com.blog.Api.Blog.model.AuthResponse;
import com.blog.Api.Blog.model.User;
import com.blog.Api.Blog.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody User request
            ) {
        return ResponseEntity.ok(authService.login(request));
    }
}
