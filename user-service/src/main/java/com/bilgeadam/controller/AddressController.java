package com.bilgeadam.controller;

import com.bilgeadam.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bilgeadam.constants.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL + ADDRESS)
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

}
