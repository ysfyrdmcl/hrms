package com.bilgeadam.services;

import com.bilgeadam.dto.request.DoLoginRequest;
import com.bilgeadam.repository.IAuthRepository;
import com.bilgeadam.repository.entity.Auth;
import com.bilgeadam.repository.enums.Roles;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth,Long> {
    private final IAuthRepository authRepository;

    public AuthService(IAuthRepository authRepository) {
        super(authRepository);
        this.authRepository = authRepository;

    }
    public Optional<Auth> dologin(DoLoginRequest dto){
        return authRepository.findOptionalByUsernameIgnoreCaseAndPassword(dto.getUsername(),
                dto.getPassword());
    }

    public Optional<Roles> getRoles(Optional<Long> authid) {

        Optional<Auth> optionalAuth = authRepository.findOptionalById(authid.get());
        if (optionalAuth.isEmpty()) return Optional.empty();
        try {
           return Optional.ofNullable(optionalAuth.get().getRole());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}