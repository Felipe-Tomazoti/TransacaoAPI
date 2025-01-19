package br.com.FelipeTomazoti.desafioItau.domain.validator;

import br.com.FelipeTomazoti.desafioItau.domain.Transacao;
import br.com.FelipeTomazoti.desafioItau.domain.validator.exception.ValidationExceptionAPI;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.OffsetDateTime;

public class ValorValidator implements ConstraintValidator<ValidTransacao, Transacao> {

    @Override
    public boolean isValid(Transacao transacao, ConstraintValidatorContext constraintValidatorContext) {
        if (transacao.getValor() < 0) {
            throw new ValidationExceptionAPI("Valor nao pode ser negativo!");
        }
        if (transacao.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new ValidationExceptionAPI("Transação não pode ocorrer no futuro!");
        }
        return true;
    }
}
