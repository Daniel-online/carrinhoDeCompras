package br.com.improving.carrinho;

import java.math.BigDecimal;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class Item {

    private Produto produto;
    private BigDecimal valorUnitario;
    private int quantidade;

    /**
     * Construtor da classe Item.
     * 
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
    public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
    	this.produto = produto;
    	this.valorUnitario = valorUnitario;
    	this.quantidade = quantidade;
    	
    }

    /**
     * Retorna o produto.
     *
     * @return Produto
     */
    public Produto getProduto() {
    	return this.produto;
    }
    public void somaQuantidade(int quantidade) {
    	this.quantidade += quantidade;
    }
    public void reduzQuantidade(int quantidade) {
    	this.quantidade -= quantidade;
    }
    /**
     * Retorna o valor unitário do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorUnitario() {
    	return this.valorUnitario;
    }

    /**
     * Retorna a quantidade dos item.
     *
     * @return int
     */
    public int getQuantidade() {
    	return this.quantidade;
    }

    /**
     * Retorna o valor total do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {
    	BigDecimal quantidadeTransformadaBigDecimal = BigDecimal.valueOf(this.quantidade);
    	BigDecimal valorTotal = this.valorUnitario.multiply(quantidadeTransformadaBigDecimal) ;
    	return valorTotal;
    }
}
