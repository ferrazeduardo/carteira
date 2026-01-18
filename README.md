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

## 🧪 Experimentos Sugeridos

### 1. Saque concorrente (lock otimista)
- Execute **1000 saques simultâneos** na mesma carteira  
- Observe a ocorrência de `OptimisticLockException`  
- Analise quantas operações realmente foram persistidas  

### 2. Retry automático
- Capture a exceção de lock otimista  
- Reexecute a transação automaticamente  
- Compare o resultado com a versão sem retry  

### 3. Transferência concorrente
- Implemente transferência entre duas carteiras  
- Use **lock pessimista**  
- Compare com uma versão **sem lock**  
- Observe inconsistências e falhas  

### 4. Deadlock
- Inverta a ordem dos locks nas transferências  
- Execute cargas paralelas  
- Observe erros de deadlock no banco de dados  

### 5. Virtual Threads vs Thread Pool tradicional
- Troque o executor (Virtual Threads × Fixed Thread Pool)  
- Compare **throughput**  
- Compare **latência**  
- Observe onde o gargalo realmente ocorre  

## 🎯 Objetivo Final

| Tema            | Aprendizado                          |
|-----------------|--------------------------------------|
| Lock otimista   | Quando usar e quando ele falha       |
| Lock pessimista | Quando é obrigatório                 |
| @Version        | Controle de concorrência real        |
| Deadlock        | Como acontece de verdade             |
| Virtual Threads | Onde ajudam e onde não               |
| Banco de dados  | Verdadeiro ponto crítico             |

---

Este repositório não é sobre “funcionar”.

Ele é sobre **entender profundamente concorrência em sistemas reais**.




