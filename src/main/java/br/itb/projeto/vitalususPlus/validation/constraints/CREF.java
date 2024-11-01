package br.itb.projeto.vitalususPlus.validation.constraints;

import br.itb.projeto.vitalususPlus.validation.CrefValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CrefValidation.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CREF {

    String message() default "CREF inválido";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};

}
