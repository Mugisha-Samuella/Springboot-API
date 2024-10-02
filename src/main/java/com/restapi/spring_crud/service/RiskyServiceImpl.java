package com.restapi.spring_crud.service;
import com.restapi.spring_crud.exception.CustomException;
import org.springframework.stereotype.Service;

@Service
public class RiskyServiceImpl implements RiskyService {

    @Override
    public void takeRisk(){
        throw new CustomException("Something went wrong");
    }
}
