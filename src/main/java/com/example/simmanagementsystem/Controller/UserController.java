package com.example.simmanagementsystem.Controller;

import com.example.simmanagementsystem.Entity.Simdetails;
import com.example.simmanagementsystem.Request.LogInRequest;
import com.example.simmanagementsystem.Request.SimdetailsRequest;
import com.example.simmanagementsystem.Service.UserService;
import com.example.simmanagementsystem.Utility.ApIConstant;
import com.example.simmanagementsystem.Utility.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(ApIConstant.USER_LINK)
@RequiredArgsConstructor
@Tag(name = "User API")
public class UserController {

    private final UserService service;

    @PostMapping("/LogInUser")
    public ApiResponse<List<Simdetails>>  logInUser(@RequestBody LogInRequest request) {
        return service.logInUser(request);
    }

    @PostMapping("/addSim")
    public ApiResponse<String> simdetailsSave(@RequestBody SimdetailsRequest request) {
        return  service.simdetailsSave(request);
    }
}