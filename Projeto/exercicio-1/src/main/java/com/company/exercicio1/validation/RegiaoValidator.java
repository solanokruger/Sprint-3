package com.company.exercicio1.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RegiaoValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RegiaoValidator {
    String message() default "Erro ao inserir o parametro";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload()  default {};
}
