package com.sb.java.training.springboot.sampleClient.service;

import com.sb.java.training.springboot.sampleClient.model.Company;
import com.sb.java.training.springboot.sampleClient.model.Employee;
import com.sb.java.training.springboot.sampleClient.utils.SslConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    SslConfiguration sslConfiguration;

    public List<Company> getCompanyDetails() throws Exception{

        List<Object> employees = sslConfiguration.restTemplate().getForObject("https://localhost:8080/api/employees", List.class);

        List<Company> companies = new ArrayList<>();
        Company c1 = new Company();
        c1.setEmployees(new ArrayList<Employee>());
        companies.add(c1);

        return companies;
    }
}
