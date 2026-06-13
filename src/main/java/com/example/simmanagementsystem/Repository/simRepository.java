package com.example.simmanagementsystem.Repository;

import com.example.simmanagementsystem.Entity.Simdetails;
import com.example.simmanagementsystem.Entity.Store;
import com.example.simmanagementsystem.Utility.ApiResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface simRepository extends JpaRepository<Simdetails,Long> {



    List<Simdetails> findByStore_Id(Store store);
}
