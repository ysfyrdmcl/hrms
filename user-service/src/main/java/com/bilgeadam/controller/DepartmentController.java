package com.bilgeadam.controller;

import com.bilgeadam.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.bilgeadam.constants.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL + DEPARTMENT)
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
}
