package com.bilgeadam.controller;

import com.bilgeadam.config.security.JwtTokenManager;
import com.bilgeadam.dto.request.DoLoginRequest;
import com.bilgeadam.repository.entity.Auth;
import com.bilgeadam.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

import static com.bilgeadam.constans.ApiUrls.*;





@RestController
@RequestMapping(BASE_URL+AUTH)
@RequiredArgsConstructor

public class AuthController {
    private final AuthService authService;
    private final JwtTokenManager jwtTokenManager;
    //authorize için.
    //@PreAuthorize("hasAuthory('USER')")
    @PostMapping(LOGIN)
    public ResponseEntity<String> doLogin(@RequestBody @Valid DoLoginRequest dto){
        Optional<Auth> auth = authService.dologin(dto);
        if(auth.isPresent()){
            String token = jwtTokenManager.createToken(auth.get().getId()).get();
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().body("Giriş Başarısız");
    }
}