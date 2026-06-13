package com.example.simmanagementsystem.Repository;

import com.example.simmanagementsystem.Entity.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<users, Long> {
    users findByStaffIdAndStore_StoreCode(String staffId, String storeId);
}
