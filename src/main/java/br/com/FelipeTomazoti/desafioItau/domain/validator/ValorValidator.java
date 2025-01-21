package br.com.FelipeTomazoti.desafioItau.domain.validator;

import br.com.FelipeTomazoti.desafioItau.domain.Transacao;
import br.com.FelipeTomazoti.desafioItau.domain.dto.TransacaoDTO;
import br.com.FelipeTomazoti.desafioItau.domain.validator.exception.ValidationExceptionAPI;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class ValorValidator implements ConstraintValidator<ValidTransacao, TransacaoDTO> {

    @Override
    public boolean isValid(TransacaoDTO transacaoDTO, ConstraintValidatorContext constraintValidatorContext) {
        if (transacaoDTO.getValor() < 0) {
            throw new ValidationExceptionAPI("Valor nao pode ser negativo!");
        }
        if (transacaoDTO.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new ValidationExceptionAPI("Transação não pode ocorrer no futuro!");
        }
        return true;
    }
}
