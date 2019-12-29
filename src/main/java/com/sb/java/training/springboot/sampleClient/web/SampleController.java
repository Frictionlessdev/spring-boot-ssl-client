package com.sb.java.training.springboot.sampleClient.web;

import com.sb.java.training.springboot.sampleClient.model.Company;
import com.sb.java.training.springboot.sampleClient.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SampleController {

    @Autowired
    CompanyService companyService;

    @RequestMapping("/company")
    public List<Company> getCompanyDetails() throws Exception{
        return companyService.getCompanyDetails();
    }
}
