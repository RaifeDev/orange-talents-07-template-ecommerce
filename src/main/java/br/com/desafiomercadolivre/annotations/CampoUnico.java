package br.com.desafiomercadolivre.annotations;


import br.com.desafiomercadolivre.annotations.implementacoes.CampoUnicoImplementacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {CampoUnicoImplementacao.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface CampoUnico {


    String message() default "O valor informado já existe!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String fieldName();
    Class<?> domainClass();


}
