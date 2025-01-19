package br.com.FelipeTomazoti.desafioItau.domain.validator;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValorValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTransacao {
    String message() default "Transação inválida!";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
