package com.bilgeadam.service;

import com.bilgeadam.repository.IProfessionRepository;
import com.bilgeadam.repository.entity.Profession;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ProfessionService extends ServiceManager<Profession, Long> {
    private final IProfessionRepository professionRepository;

    public ProfessionService(IProfessionRepository professionRepository) {
        super(professionRepository);
        this.professionRepository = professionRepository;
    }
}
