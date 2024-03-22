package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Classe responsável pela criação e recuperação dos carrinhos de compras.
 * 
 * As instâncias de CarrinhoComprasFactory são independentes entre si, ou seja, quando um carrinho
 * para um cliente é criado em uma instância, a outra pode criar um novo carrinho para o mesmo
 * cliente. Isso é verdade para todos os métodos.
 */
public class CarrinhoComprasFactory {
	private Collection<CarrinhoCompras> listaCarrinhoCompras;

	public CarrinhoComprasFactory() {
		this.listaCarrinhoCompras = new ArrayList<CarrinhoCompras>();
	}

	/**
	 * Cria e retorna um novo carrinho de compras para o cliente passado como parâmetro.
	 *
	 * Caso já exista um carrinho de compras para o cliente passado como parâmetro, este carrinho
	 * deverá ser retornado.
	 *
	 * @param identificacaoCliente
	 * @return CarrinhoCompras
	 */
	public CarrinhoCompras criar(String identificacaoCliente) {
		CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
		carrinhoCompras.setIdentificadorCliente(identificacaoCliente);
		listaCarrinhoCompras.add(carrinhoCompras);
		return carrinhoCompras;
	}

	/**
	 * Retorna o valor do ticket médio no momento da chamada ao método. O valor do ticket médio é a
	 * soma do valor total de todos os carrinhos de compra dividido pela quantidade de carrinhos de
	 * compra. O valor retornado deverá ser arredondado com duas casas decimais, seguindo a regra:
	 * 0-4 deve ser arredondado para baixo e 5-9 deve ser arredondado para cima.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal getValorTicketMedio() {
		if (listaCarrinhoCompras.isEmpty()) {
            throw new IllegalStateException("Não há carrinhos de compras para calcular o ticket médio.");
        }
		try {
			float soma = 0;
			for (CarrinhoCompras carrinho : this.listaCarrinhoCompras) {
				soma = soma + carrinho.getValorTotal().floatValue();
			}
			float media = soma / (listaCarrinhoCompras.size());
			return new BigDecimal(media);

		} catch (ArithmeticException | NullPointerException ex) {
			// TODO: handle exception
			ex.printStackTrace(); // Example of logging the exception
			return BigDecimal.ZERO;
		}
	}

	/**
	 * Invalida um carrinho de compras quando o cliente faz um checkout ou sua sessão expirar. Deve
	 * ser efetuada a remoção do carrinho do cliente passado como parâmetro da listagem de carrinhos
	 * de compras.
	 *
	 * @param identificacaoCliente
	 * @return Retorna um boolean, tendo o valor true caso o cliente passado como parämetro tenha um
	 *         carrinho de compras e e false caso o cliente não possua um carrinho.
	 */
	public boolean invalidar(String identificacaoCliente) {
		boolean clienteRemovido = false;
		Iterator<CarrinhoCompras> iterator = listaCarrinhoCompras.iterator();

		while (iterator.hasNext()) {

			CarrinhoCompras carrinhoCompras = iterator.next();

			if (carrinhoCompras.getIdentificadorCliente() == identificacaoCliente) {
				clienteRemovido = true;
				iterator.remove();
				break; // Se você quer remover apenas o primeiro item que corresponde ao índice,
						// então você pode quebrar o loop
			}

		}
		return clienteRemovido;
	}
}
