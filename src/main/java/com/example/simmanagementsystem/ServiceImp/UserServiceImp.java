package com.example.simmanagementsystem.ServiceImp;

import com.example.simmanagementsystem.Entity.Simdetails;
import com.example.simmanagementsystem.Entity.users;
import com.example.simmanagementsystem.Repository.UserRepository;
import com.example.simmanagementsystem.Repository.simRepository;
import com.example.simmanagementsystem.Request.LogInRequest;
import com.example.simmanagementsystem.Service.UserService;
import com.example.simmanagementsystem.Utility.ApiResponse;
import com.example.simmanagementsystem.Utility.ResponseBuilder;
import com.example.simmanagementsystem.Utility.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository repo;
    private final simRepository repository;
    @Override
    public ApiResponse<List<Simdetails>> logInUser(LogInRequest request) {
        users userlist=repo.findByStaffIdAndStore_StoreCode(request.getStaffId(),request.getStoreId());


        if( userlist.getRole()== Role.ADMIN ){
           List<Simdetails> details=  repository.findAll();
           if(details.isEmpty()){
                return ResponseBuilder.DataNotFound();
           }else{
               return ResponseBuilder.success(details);
           }
        }else{
             List<Simdetails> detaillist=repository.findByStore_Id(userlist.getStore());
            if(detaillist.isEmpty()){
                return ResponseBuilder.DataNotFound();
            }else {
                return ResponseBuilder.success(detaillist);
            }
        }
    }
}
