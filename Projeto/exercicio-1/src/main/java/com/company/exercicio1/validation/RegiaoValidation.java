package com.company.exercicio1.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class RegiaoValidation implements ConstraintValidator<RegiaoValidator, String> {

    @Override
    public void initialize(RegiaoValidator constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<String> regioes = new ArrayList<>();
        regioes.add("Norte");
        regioes.add("Nordeste");
        regioes.add("Sul");
        regioes.add("Sudeste");
        regioes.add("Centro-Oeste");

        if (regioes.contains(value)){
            return true;
        }else{
            return false;
        }
    }
}
