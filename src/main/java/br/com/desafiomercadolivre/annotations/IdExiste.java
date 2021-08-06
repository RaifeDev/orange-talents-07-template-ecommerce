package br.com.desafiomercadolivre.annotations;


import br.com.desafiomercadolivre.annotations.implementacoes.IdExisteImplementacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {IdExisteImplementacao.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface IdExiste {


    String message() default "O valor informado não existe";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    boolean allowNull() default false;
    String fieldName();
    Class<?> domainClass();


}
