package com.multi.carteira.application.usecases.carteira.transferencia;

import java.math.BigDecimal;

public record TransferenciaInput(Long contaOrigem, Long contaDestino, BigDecimal valor) {
}
