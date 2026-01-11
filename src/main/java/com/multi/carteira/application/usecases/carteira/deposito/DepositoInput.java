package com.multi.carteira.application.usecases.carteira.deposito;

import java.math.BigDecimal;

public record DepositoInput(Long id, BigDecimal valor) {
}
