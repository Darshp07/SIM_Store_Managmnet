package com.example.simmanagementsystem.Repository;

import com.example.simmanagementsystem.Entity.users;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository  {
    private final JdbcTemplate jdbcTemplate;


    public users findByStaffId(String staffId) {
        String sql="select * from users where staff_id='"+staffId+"'";
       return jdbcTemplate.query(sql,new  BeanPropertyRowMapper<>(users.class)).getFirst();
    }
}
