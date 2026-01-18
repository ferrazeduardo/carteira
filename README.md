# 💳 Wallet Concurrency Lab

Projeto educacional para estudar **concorrência real em sistemas transacionais** usando:

- Java 21  
- Spring Boot 3  
- JPA / Hibernate  
- Lock Otimista (`@Version`)  
- Lock Pessimista (`PESSIMISTIC_WRITE`)  
- Virtual Threads  

O objetivo é entender, na prática:

- Quando o **lock otimista** funciona e quando ele falha  
- Por que algumas operações exigem **lock pessimista**  
- Como **race conditions** acontecem de verdade  
- Como o banco de dados se comporta sob alta concorrência  
- O impacto das **Virtual Threads** em operações bloqueantes  

---

## 🧠 Domínio

O sistema modela uma **Carteira Digital (Wallet)**:

- Cada carteira possui um saldo  
- Operações disponíveis:
  - Consulta de saldo  
  - Depósito  
  - Saque  
  - Transferência entre carteiras  

Esse domínio é ideal porque envolve:

- Estado compartilhado  
- Escritas concorrentes  
- Operações críticas (transferência)  
- Risco real de inconsistência  

🧪 Experimentos Sugeridos
Saque concorrente (lock otimista)

1000 saques simultâneos

Observe OptimisticLockException

Retry automático

Capture a exceção

Reexecute a transação

Transferência concorrente

Use lock pessimista

Compare com versão sem lock

Deadlock

Inverta a ordem dos locks

Execute cargas paralelas

Observe erro no banco

Virtual Threads vs Thread Pool tradicional

Troque o executor

Compare throughput e latência

🎯 Objetivo Final
Ao final deste projeto você terá entendido, na prática:

Tema	Aprendizado
Lock otimista	Quando usar e quando ele falha
Lock pessimista	Quando é obrigatório
@Version	Controle de concorrência real
Deadlock	Como acontece de verdade
Virtual Threads	Onde ajudam e onde não
Banco de dados	Verdadeiro ponto crítico

Este repositório não é sobre “funcionar”,
é sobre entender profundamente concorrência em sistemas reais.



