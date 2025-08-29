package com.example.khana_khazana.repository;

import com.example.khana_khazana.entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Transactional
public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query("SELECT u.password FROM Users u WHERE u.userId = :id")
    String findPasswordByUserId(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Users u SET u.email = :email WHERE u.userId = :id AND u.password = :password ")
    int updateUserEmail(@Param("id") Long id, @Param("email") String email, @Param("password") String password);

    @Modifying
    @Query("UPDATE Users u SET u.phoneNumber = :phoneNumber WHERE u.userId = :id AND u.password = :password ")
    int updateUserPhone(Long id, String phoneNumber, String password);

    Users findByEmailAndPassword(String email ,String Password);

    Users findByPhoneNumberAndPassword(String phoneNumber ,String Password);
}
