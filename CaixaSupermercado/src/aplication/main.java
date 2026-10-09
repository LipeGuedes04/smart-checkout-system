package aplication;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		String nomeProduto;
		double PrecoUni; 
		int quantidade;
		double TotalProduto = 0.0;

		Scanner caixa = new Scanner(System.in);

		System.out.println("Deseja entrar no sistema?");
		System.out.println("Entrar - 1 \nSair - 2");
		int Sistema = caixa.nextInt();
		caixa.nextLine();

		while (Sistema == 2) {
			System.out.println("Obrigado");
			System.out.println("Deseja entrar no programa?");
			System.out.println("Entrar - 1 \nSair - 2");
			Sistema = caixa.nextInt();
			caixa.nextLine();
		}

		while (Sistema == 1) {

			System.out.println("Qual nome do Produto? ");
			nomeProduto = caixa.nextLine();
			System.out.println("Qual preço do produto? ");
			PrecoUni = caixa.nextDouble(); 
			caixa.nextLine();
			System.out.println("Quantos unidades será levado? ");
			quantidade = caixa.nextInt();
			caixa.nextLine();

			while (PrecoUni <= 0 || quantidade < 1) {
				System.out.println("❌ Valor Inválido, digite novamente");
				System.out.println("Qual preço do produto? ");
				PrecoUni = caixa.nextDouble(); 
				caixa.nextLine();
				System.out.println("Quantos unidades será levado? ");
				quantidade = caixa.nextInt();
				caixa.nextLine();
			}

			double subtotal = PrecoUni * quantidade;
			TotalProduto += subtotal;

			System.out.println("\nAdicionar produto - 1 \nfechar compra - 2 \nSair - 3");
			Sistema = caixa.nextInt();
			caixa.nextLine();

			while (Sistema == 2) {
				System.out.println("\nPossui Cartão Fidelidade da Loja (S/N)");
				String desconto = caixa.next();
				caixa.nextLine(); 

				if (desconto.equalsIgnoreCase("S")) {
					double des = TotalProduto * 0.05;
					TotalProduto = TotalProduto - des;
					System.out.println("🎉 Você recebeu 5% de desconto na sua compra!!");
					System.out.printf("Valor do desconto foi de %.2f reais", des);
					System.out.printf("\nValor total %.2f reais", TotalProduto);

					System.out.println("\n\nAdicionar produto - 1 \nIr ao pagamento - 4");
					Sistema = caixa.nextInt();
					caixa.nextLine();
				} else {
					System.out.printf("Valor total %.2f reais", TotalProduto);
					System.out.println("\n\nAdicionar produto - 1 \nIr ao pagamento - 4");
					Sistema = caixa.nextInt();
					caixa.nextLine();
				}
			} 

			while (Sistema == 4) {
				System.out.println("Qual será a forma de pagamento?");
				System.out.println("\nDinheiro - 1 \nCartão - 2");
				int opcao = caixa.nextInt();
				caixa.nextLine();

				if (opcao == 1) {
					System.out.println("Qual o valor que foi pago? ");
					double ValorPago = caixa.nextDouble();
					caixa.nextLine();

					while (ValorPago < TotalProduto) {
						double ValorInsuficiente = TotalProduto - ValorPago;
						System.out.printf("❌ Valor insuficiente! Falta R$ %.2f reais\n", ValorInsuficiente);
						System.out.println("Digite novamente com o valor restante: ");
						double valorRestante = caixa.nextDouble();
						caixa.nextLine();

						ValorPago += valorRestante;
					}

					
					if (ValorPago > TotalProduto) {
						double troco = ValorPago - TotalProduto;
						System.out.printf("🛒 Pagamento Concluído! O valor do troco será %.2f reais\n", troco);
					} else {
						System.out.println("🛒 Pagamento Concluído com valor exato!");
					}

				} else {
					System.out.println("🛒 Pagamento Concluído via Cartão!");
				}

				
				Sistema = 3;
			}

			while (Sistema == 3) {
				System.out.println("Obrigado");
				System.out.println("Deseja entrar no programa novamente?");
				System.out.println("Entrar - 1 \nSair - 2");
				Sistema = caixa.nextInt();
				caixa.nextLine();
			}

		} 

		caixa.close();
	}
}
