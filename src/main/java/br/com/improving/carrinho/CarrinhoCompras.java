package br.com.improving.carrinho;

import br.com.improving.carrinho.Produto;
import br.com.improving.carrinho.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Classe que representa o carrinho de compras de um cliente.
 */
public class CarrinhoCompras {

	/**
	 * Permite a adição de um novo item no carrinho de compras.
	 *
	 * Caso o item já exista no carrinho para este mesmo produto, as seguintes regras deverão ser
	 * seguidas: - A quantidade do item deverá ser a soma da quantidade atual com a quantidade
	 * passada como parâmetro. - Se o valor unitário informado for diferente do valor unitário atual
	 * do item, o novo valor unitário do item deverá ser o passado como parâmetro.
	 *
	 * Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao
	 * carrinho de compras.
	 *
	 * @param produto
	 * @param valorUnitario
	 * @param quantidade
	 */
	private String identificadorCliente;
	private Collection<Item> carrinhoDeCompras = new ArrayList<Item>();

	public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) {
		try{ 
			boolean produtoRepetido = false;

			for (Item itemCarrinho : carrinhoDeCompras) {
			// percorre o array/colection inteiro condicionando um objeto
			// itemCarrinho a cada item no Collection

			if (itemCarrinho.getProduto().getCodigo().equals(produto.getCodigo())) {
				// se, ao pegar um produto, pegar o codigo deste produto e igualar ao codigo dos
				// produtos
				// der um valor True, entao somará a quantidade de unidades e declara o produto como
				// existente
				itemCarrinho.somaQuantidade(quantidade);
				produtoRepetido = true;

			}

		}
			if (!produtoRepetido) {
			Item item = new Item(produto, valorUnitario, quantidade);
			carrinhoDeCompras.add(item);
			// identifica se existe um produto
			// se a resposta for true ele cria um produto
			}
		
			//else {}
		}
		catch (ArithmeticException ex) {
	        ex.printStackTrace(); // Example of logging the exception
	        // Handle NullPointerException here
	    } catch (RuntimeException ex) {
	        ex.printStackTrace(); // Example of logging the exception
	        // Handle other potential runtime exceptions here
	    }
		

	}

	/**
	 * Permite a remoção do item que representa este produto do carrinho de compras.
	 *
	 * @param produto
	 * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e
	 *         false caso o produto não exista no carrinho.
	 */
	public boolean removerItem(Produto produto) {
		boolean produtoEncontrado = false;
		Iterator<Item> iterator = carrinhoDeCompras.iterator();

		while (iterator.hasNext()) {
			// percorre o array/colection inteiro condicionando um objeto
			// itemCarrinho a cada item no Collection
			Item item = iterator.next();
			if (item.getProduto().getCodigo().equals(produto.getCodigo())) {
				// se, ao pegar um produto, pegar o codigo deste produto e igualar ao codigo dos
				// produtos
				// der um valor True, entao somará a quantidade de unidades e declara o produto como
				// existente
				
				iterator.remove();
				produtoEncontrado = true;

			}

		}
		return produtoEncontrado;
	}

	/**
	 * Permite a remoção do item de acordo com a posição. Essa posição deve ser determinada pela
	 * ordem de inclusão do produto na coleção, em que zero representa o primeiro item.
	 *
	 * @param posicaoItem
	 * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e
	 *         false caso o produto não exista no carrinho.
	 */
	
	public boolean removerItem(int posicaoItem) {
		if (posicaoItem < 0 || posicaoItem >= carrinhoDeCompras.size()) {
            throw new IllegalArgumentException("Posição do item a ser removido é inválida.");
        }
		boolean produtoEncontrado = false;
		Iterator<Item> iterator = carrinhoDeCompras.iterator();
		int index = 0;
	    while (iterator.hasNext()) {
	        iterator.next();
	        if (index == posicaoItem) {
	        	produtoEncontrado = true;
	            iterator.remove();
	            break; // Se você quer remover apenas o primeiro item que corresponde ao índice, então você pode quebrar o loop
	        }
	        index++;
	    }
	    return produtoEncontrado;
	}

	/**
	 * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores totais de todos
	 * os itens que compõem o carrinho.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal getValorTotal() {
		if (carrinhoDeCompras.isEmpty()) {
            return BigDecimal.ZERO;
        }
		float somaTotal = 0 ;
		
		for (Item itemCarrinho : carrinhoDeCompras) {
			// percorre o array/colection inteiro condicionando um objeto
			// itemCarrinho a cada item no Collection
			somaTotal = somaTotal + itemCarrinho.getValorTotal().floatValue();
	
		}
	
		
		return new BigDecimal(somaTotal);
	}
	
	public String getIdentificadorCliente() {
		return this.identificadorCliente;
	}
	
	public void setIdentificadorCliente(String identificadorCliente) {
		this.identificadorCliente = identificadorCliente;
	}

	/**
	 * Retorna a lista de itens do carrinho de compras.
	 *
	 * @return itens
	 */
	public Collection<Item> getItens() {
		return this.carrinhoDeCompras;
	}
}