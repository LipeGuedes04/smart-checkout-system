# 🏢 Sistema de Caixa de Supermercado - Smart Checkout

## 🎯 O que o projeto faz?

O sistema simula o funcionamento automatizado de um caixa de supermercado (PDV). O operador pode abrir o sistema, cadastrar múltiplos produtos informando **nome**, **preço unitário** e **quantidade**. O programa realiza a validação dos valores de entrada em tempo real, calcula o subtotal acumulado, aplica **desconto de 5% para clientes com Cartão Fidelidade**, processa o pagamento (via dinheiro ou cartão) e gerencia de forma inteligente o **recebimento de valores insuficientes e cálculo de troco**.

### 🔄 Fluxo da Aplicação
```text
[ Entrada no Sistema ] ➔ [ Cadastro de Itens & Validação ] ➔ [ Aplicação de Desconto ] ➔ [ Fluxo de Pagamento ] ➔ [ Fechamento/Troco ]
```

---

## 🎨 Design do Código (Como as regras conversam)

Este projeto foi estruturado de forma dinâmica utilizando **Estruturas de Repetição Aninhadas (While)** e condicionais para criar loops de controle de estado do terminal e fluxos contínuos de compra. Veja o mapa limpo do design:

```text
       ┌────────────────────────┐
       │   Abertura do Sistema  │ (Loop de controle inicial)
       └───────────┬────────────┘
                   │
                   ▼
       ┌────────────────────────┐
       │  Cadastro de Produtos  │ ◄───┐ (Loop principal de compras)
       └───────────┬────────────┘     │
                   │                  │
                   ▼                  │ (Adicionar mais itens)
       ┌────────────────────────┐     │
       │ Validação de Entradas  │     │
       └───────────┬────────────┘     │
                   │                  │
                   ▼                  │
       ┌────────────────────────┐     │
       │   Fechamento & Cupom   │ ────┤
       └───────────┬────────────┘
                   │
                   ▼
       ┌────────────────────────┐
       │   Módulo de Pagamento  │ (Validação de saldo / cálculo de troco)
       └────────────────────────┘
```

### 📋 Mapeamento de Variáveis e Estruturas

| Estrutura / Variável | O que ela faz no código? |
| :--- | :--- |
| 🚀 `main.java` | Classe principal que gerencia o estado da aplicação através da variável `Sistema`. |
| 📦 `nomeProduto` | String que guarda temporariamente o nome do produto atual inserido no carrinho. |
| 💰 `PrecoUni` | Ponto flutuante (double) que armazena o preço por unidade, protegido por filtro de validação. |
| 🔢 `quantidade` | Inteiro que define o volume de itens levados pelo cliente para multiplicação do subtotal. |
| 💳 `TotalProduto` | Variável acumuladora global que guarda o valor bruto e líquido da compra inteira. |
| 💵 `ValorPago` | Armazena a quantia em dinheiro entregue pelo cliente para acionar o loop de saldo insuficiente. |

---

## 🧠 Conceitos de Programação Praticados

* **Loops de Estado de Menu:** Uso avançado de loops `while` atuando como máquinas de estado para navegar entre telas do terminal (Adicionar produto, Fechar compra, Pagamento).
* **Loops de Validação Consistente:** Implementação de estruturas de checagem compulsória para impedir que o sistema processe valores negativos ou quantidades zeradas.
* **Algoritmo de Amortização de Dívida:** Uso de laço iterativo no pagamento em dinheiro que acumula entradas adicionais até que o valor total da compra seja completamente liquidado.

---

## 💻 Exemplo Prático de Uso

Imagine a seguinte simulação de uma compra com múltiplos itens e desconto de fidelidade rodando direto no terminal:

```text
Deseja entrar no sistema?
Entrar - 1 
Sair - 2
1
Qual nome do Produto? 
Café Express
Qual preço do produto? 
12.50
Quantos unidades será levado? 
2

Adicionar produto - 1 
fechar compra - 2 
Sair - 3
2

Possui Cartão Fidelidade da Loja (S/N)
S
🎉 Você recebeu 5% de desconto na sua compra!!
Valor do desconto foi de 1.25 reais
Valor total 23.75 reais

Adicionar produto - 1 
Ir ao pagamento - 4
4
Qual será a forma de pagamento?

Dinheiro - 1 
Cartão - 2
1
Qual o valor que foi pago? 
20.00
❌ Valor insuficiente! Falta R\$ 3.75 reais
Digite novamente com o valor restante: 
5.00
🛒 Pagamento Concluído! O valor do troco será 1.25 reais
Obrigado
Deseja entrar no programa novamente?
Entrar - 1 
Sair - 2
2
```
