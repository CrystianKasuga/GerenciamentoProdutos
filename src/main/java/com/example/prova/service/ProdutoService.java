package com.example.prova.service;

import com.example.prova.model.Produto;
import com.example.prova.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodosProdutos() {
        return produtoRepository.findAll();}

    public Optional<Produto> consultarProdutoPorId(Integer id) {
        return produtoRepository.findById(id);
    }

    public Produto atualizarProduto(Integer id, Produto detalhesProduto) {
        Produto produto = produtoRepository.getOne(id);
        produto.setNome(detalhesProduto.getNome());
        produto.setPreco(detalhesProduto.getPreco());
        return produtoRepository.save(produto);
    }

    public void excluirProduto(Integer id) {
        produtoRepository.deleteById(id);
    }
}
