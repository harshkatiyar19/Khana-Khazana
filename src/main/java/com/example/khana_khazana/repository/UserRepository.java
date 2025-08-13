package com.example.khana_khazana.repository;

import com.example.khana_khazana.entity.Tables;
import com.example.khana_khazana.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
