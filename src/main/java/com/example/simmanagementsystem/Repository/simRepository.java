package com.example.simmanagementsystem.Repository;

import com.example.simmanagementsystem.Entity.Simdetails;
import com.example.simmanagementsystem.Entity.Store;
import com.example.simmanagementsystem.Request.SimdetailsRequest;
import com.example.simmanagementsystem.Utility.ApiResponse;
import com.example.simmanagementsystem.Utility.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@RequiredArgsConstructor
@Repository
public class simRepository{
    private final JdbcTemplate jdbcTemplate;

    public List<Simdetails> findAll() {
        return jdbcTemplate.query("Select * from sim_details",new BeanPropertyRowMapper<>(Simdetails.class));
    }

    public List<Simdetails> findByStore_Id(String storeId) {
        return jdbcTemplate.query("Select * from sim_details where store_id = '"+storeId+"'",new BeanPropertyRowMapper<>(Simdetails.class));
    }

    public ApiResponse<String> simdetailsSSave(SimdetailsRequest request) {
        String sql="Select id from store where store_id='"+request.getStoreId()+"'";
        Long id =jdbcTemplate.queryForObject(sql,Long.class);

        String query="Select id from users where staff_id='"+request.getStaffId()+"'";
        Long staffId=jdbcTemplate.queryForObject(query,Long.class);

        String update ="INSERT INTO sim_details(sim_no, account_number, mobile_number, store_id, created_by) VALUES('"+request.getSimNo()+"','"+request.getAccountNumber()+"','"+request.getMobileNumber()+"','"+id+"','"+staffId+"')";
        return jdbcTemplate.update(update)>0?ResponseBuilder.successResponse("Simdetails save success..!"):ResponseBuilder.error("Simdetails save fail.");
    }
}
