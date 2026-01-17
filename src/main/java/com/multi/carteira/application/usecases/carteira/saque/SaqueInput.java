package com.multi.carteira.application.usecases.carteira.saque;

import java.math.BigDecimal;

public record SaqueInput(Long id, BigDecimal valor) {
}
