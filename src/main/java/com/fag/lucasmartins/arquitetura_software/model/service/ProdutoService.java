package com.fag.lucasmartins.arquitetura_software.model.service;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.model.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    public final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public ProdutoBO cadastrarProduto(ProdutoBO produtoBO) {
        String nome = produtoBO.getNome();
        Integer estoque = produtoBO.getEstoque();
        double preco = produtoBO.getPreco();

        if (nome != null && nome.toLowerCase().contains("premium") && preco < 100.0) {
            throw new RuntimeException("Erro: Produtos Premium não podem custar menos de R$ 100,00.");
        }

        double precoFinal;
        if (estoque != null && estoque >= 50) {
            precoFinal = preco - (preco * 0.10); // 10%
            produtoBO.setPreco(precoFinal);
        }

        return salvar(produtoBO);
    }

    public ProdutoBO salvar(ProdutoBO produtoBO) {
        return repository.salvar(produtoBO);
    }

}
