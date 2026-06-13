package com.example.simmanagementsystem.Service;

import com.example.simmanagementsystem.Entity.Simdetails;
import com.example.simmanagementsystem.Request.LogInRequest;
import com.example.simmanagementsystem.Utility.ApiResponse;

import java.util.List;

public interface UserService {


    ApiResponse<List<Simdetails>> logInUser(LogInRequest request);
}
