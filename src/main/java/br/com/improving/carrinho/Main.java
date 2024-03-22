package br.com.improving.carrinho;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarrinhoComprasFactory carrinhoFactory = new CarrinhoComprasFactory();
		CarrinhoCompras carrinhoComprasDaniel = carrinhoFactory.criar("Daniel");
		CarrinhoCompras carrinhoComprasLucas = carrinhoFactory.criar("Lucas");
		
		Produto arrozProduto = new Produto(Long.valueOf(12345), "Arroz 1kg");
		Produto macaProduto = new Produto(Long.valueOf(12388), "Maça 1kg");
		Produto alfaceProduto = new Produto(Long.valueOf(12245), "Alface 1kg");
		Produto cafeProduto = new Produto(Long.valueOf(12305), "Cafe 1kg");
		Produto acucarProduto = new Produto(Long.valueOf(12945), "Açucar 1kg");
		
		carrinhoComprasDaniel.adicionarItem(arrozProduto, BigDecimal.valueOf(4.99), 2);
		carrinhoComprasDaniel.adicionarItem(macaProduto, BigDecimal.valueOf(6.99), 3);
		carrinhoComprasDaniel.adicionarItem(alfaceProduto, BigDecimal.valueOf(3.99), 5);
		carrinhoComprasDaniel.adicionarItem(cafeProduto, BigDecimal.valueOf(11.99), 2);
		carrinhoComprasLucas.adicionarItem(acucarProduto, BigDecimal.valueOf(3.99), 3);
		System.out.println(carrinhoComprasDaniel.getItens().toString());
		System.out.println(carrinhoComprasDaniel.removerItem(1));
		System.out.println(carrinhoComprasDaniel.getIdentificadorCliente());
		
		
		System.out.println(carrinhoFactory.getValorTicketMedio());
		System.out.println(carrinhoComprasDaniel.getValorTotal());
		
		
	}

}
