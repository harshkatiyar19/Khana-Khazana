package com.example.khana_khazana.repository;

import com.example.khana_khazana.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
