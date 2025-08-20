package com.example.khana_khazana.service;

import com.example.khana_khazana.dto.users.UsersCreate;
import com.example.khana_khazana.dto.users.UsersEmail;
import com.example.khana_khazana.dto.users.UsersPhone;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    public ResponseEntity<?> updatePhone(Long id, UsersPhone request) {return null;
    }

    public ResponseEntity<?> updateEmail(Long id, UsersEmail request) {return null;
    }

    public ResponseEntity<?> signInEmail(UsersEmail request) {return null;
    }

    public ResponseEntity<?> signInPhone(UsersPhone request) {return null;
    }

    public ResponseEntity<?> createNewUser(UsersCreate request) {return null;
    }

    public String deleteUserByEmail(Long id, String email) {return null;
    }

    public String deleteUserByPhone(String phoneNumber) {return null;
    }
}
