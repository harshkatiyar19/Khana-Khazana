package com.example.khana_khazana.service;

import com.example.khana_khazana.dto.users.request.UsersCreate;
import com.example.khana_khazana.dto.users.request.UsersEmail;
import com.example.khana_khazana.dto.users.request.UsersPhone;
import com.example.khana_khazana.entity.Users;
import com.example.khana_khazana.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    Hashing hashing;

    public ResponseEntity<?> updatePhone(Long id, UsersPhone request) {
        int status = usersRepository.updateUserPhone(id, request.phone(), hashing.hash(request.password()));

        String successMsg="Phone number updated successfully.";
        String failureMsg="Wrong password.";
        return updateMsg(status,successMsg,failureMsg);
    }

    public ResponseEntity<?> updateEmail(Long id, UsersEmail request) {
        int status = usersRepository.updateUserEmail(id, request.email(), hashing.hash(request.password()));

        String successMsg="Email updated successfully.";
        String failureMsg="Wrong password.";
        return updateMsg(status,successMsg,failureMsg);
    }

    public ResponseEntity<?> signInEmail(UsersEmail request) {
        Users user = usersRepository.findByEmailAndPassword(request.email(), request.password());
        if(user!=null){
            return ResponseEntity.ok(user);
        }
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong credentials.");
        }
    }

    public ResponseEntity<?> signInPhone(UsersPhone request) {
        Users user = usersRepository.findByPhoneNumberAndPassword(request.phone(), request.password());
        if(user!=null){
            return ResponseEntity.ok(user);
        }
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong credentials.");
        }
    }

    public ResponseEntity<?> createNewUser(UsersCreate request) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        boolean isValidEmail = emailPattern.matcher(request.email()).matches();


        String phoneRegex = "^[0-9]{10}$";
        Pattern phoneNumberPattern = Pattern.compile(phoneRegex);
        boolean isValidPhoneNumber = phoneNumberPattern.matcher(request.phoneNumber()).matches();

        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
        Pattern passwordPattern = Pattern.compile(passwordRegex);
        boolean isValidPasswordPattern = passwordPattern.matcher(request.password()).matches();

        boolean isValidPassword = isValidPasswordPattern && Objects.equals(request.password(), request.confirmPassword());
        String hashedPassword=isValidPassword?hashing.hash(request.password()):null;


        if(isValidEmail&&isValidPhoneNumber&&isValidPassword){
            Users newUser = Users.builder()
                    .name(request.name())
                    .email(request.email())
                    .password(hashedPassword)
                    .phoneNumber(request.phoneNumber())
                    .build();

            usersRepository.save(newUser);
            return ResponseEntity.ok("User created successfully.");
        }
        else{
            List<String> errorList = new ArrayList<>();

            if(!isValidEmail) errorList.add("Invalid email .");
            if(!isValidPhoneNumber) errorList.add("Invalid phone number .");
            if(!isValidPasswordPattern) errorList.add("Invalid password pattern.");
            if(!isValidPassword) errorList.add("Passwords don't match .");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorList);
        }
    }

    public String deleteUser(Long id, String password) {
        if(Objects.equals(password, usersRepository.findPasswordByUserId(id))) {
            usersRepository.deleteById(id);
            return "User Deleted Successfully.";
        }
        else{
            return "Wrong Password.";
        }
    }

    private ResponseEntity<?> updateMsg(int status ,String successMsg,String failureMsg){
        if(status>0){
            return ResponseEntity.ok(successMsg);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failureMsg);
        }
    }
}
