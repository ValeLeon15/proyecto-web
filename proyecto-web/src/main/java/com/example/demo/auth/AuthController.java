package com.example.demo.auth;


import com.example.demo.entity.Arrendador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
//mejorar
@RestController
@RequestMapping(value="/progrupo14/auth")
@CrossOrigin(origins = "http://localhost")
public class AuthController {
  @Autowired
  private AuthService authService;
    
    @PostMapping( "/login")
    // http://localhost:8080/progrupo14/auth/login
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
      System.out.println("loginRequest: " + loginRequest);
          return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping( "/register")
    // http://localhost:8080/progrupo14/auth/register
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest) {
      System.out.println("loginRequest: " + registerRequest);
        if(registerRequest.tipo.equalsIgnoreCase("arrendatario")){
          return ResponseEntity.ok(authService.registerArrendatario(registerRequest));
        }
        else if (registerRequest.tipo.equalsIgnoreCase("arrendador")){
            return ResponseEntity.ok(authService.registerArrendador(registerRequest));
        }
        else{
            throw new IllegalArgumentException("Invalid type.");
        }
    }


    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("Logout");
    }

}
