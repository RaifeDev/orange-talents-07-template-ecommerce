package br.com.desafiomercadolivre.annotations.implementacoes;

import br.com.desafiomercadolivre.annotations.IdExiste;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class IdExisteImplementacao implements ConstraintValidator<IdExiste, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<?> classeEmUso;
    private String atributoDaClasse;
    private boolean allowNull;


    @Override
    public void initialize(IdExiste constraintAnnotation) {
        atributoDaClasse = constraintAnnotation.fieldName();
        classeEmUso = constraintAnnotation.domainClass();
        allowNull = constraintAnnotation.allowNull();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext) {
        if(allowNull && value == null) return true;
        Query query = entityManager.createQuery("select 1 from "+classeEmUso.getName()+" where " + atributoDaClasse + "=:value");
        query.setParameter("value", value);

        List<?> result = query.getResultList();
        return !result.isEmpty();
    }



}
