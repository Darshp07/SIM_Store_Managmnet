package com.example.simmanagementsystem.ServiceImp;

import com.example.simmanagementsystem.Entity.Simdetails;
import com.example.simmanagementsystem.Entity.users;
import com.example.simmanagementsystem.Repository.UserRepository;
import com.example.simmanagementsystem.Repository.simRepository;
import com.example.simmanagementsystem.Request.LogInRequest;
import com.example.simmanagementsystem.Request.SimdetailsRequest;
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

        users userlist=repo.findByStaffIdAndStore_StoreId(request.getStaffId(),request.getStoreId());
        if( userlist.getRole()== Role.ADMIN ){
            List<Simdetails> details=  repository.findAll();
            if(details.isEmpty()){
                return ResponseBuilder.DataNotFound();
            }else{
                return ResponseBuilder.success(details);
            }
        }else {
            List<Simdetails> detaillist = repository.findByStore_Id(userlist.getStore().getId());

            if (detaillist.isEmpty()) {
                return ResponseBuilder.DataNotFound();
            } else {
                return ResponseBuilder.success(detaillist);
            }
        }
      //  users userlist=repo.findByStaffId(request.getStaffId());
     //   System.out.println(userlist.getPassword());
      /*  if(userlist==null){
            return ResponseBuilder.DataNotFound();
        }else{
            if(!request.getPassword().equals(userlist.getPassword())){
                return ResponseBuilder.error("password is Invalid..!!");
            }
            if( userlist.getRole()== Role.ADMIN ){
                List<Simdetails> details=  repository.findAll();
                if(details.isEmpty()){
                    return ResponseBuilder.DataNotFound();
                }else{
                    return ResponseBuilder.success(details);
                }
            }else{
                List<Simdetails> detaillist=repository.findByStore_Id(userlist.getStore().getStoreId());
                if(detaillist.isEmpty()){
                    return ResponseBuilder.DataNotFound();
                }else {
                    return ResponseBuilder.success(detaillist);
                }
            }
        }*/


    }

    @Override
    public ApiResponse<String> simdetailsSave(SimdetailsRequest request) {

        users user =repo.findByStaffId(request.getStaffId());
        Simdetails   simdetails= new Simdetails();
        simdetails.setSimNo(request.getSimNo());
        simdetails.setAccountNumber(request.getAccountNumber());
        simdetails.setMobileNumber(request.getMobileNumber());
        simdetails.setCreated_by(user);
        simdetails.setStore(user.getStore());
        Simdetails savedSim =repository.save(simdetails);
        if(savedSim.getId() != null){
            return ResponseBuilder.successResponse("SIM Saved Successfully");
        }else{
            return ResponseBuilder.error("SIM Not Saved");
        }
    }

//    @Override
//    public ApiResponse<String> simdetailsSave(SimdetailsRequest request) {
//
//        return repository.save(request);
//    }
}
