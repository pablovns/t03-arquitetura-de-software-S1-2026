package com.fag.lucasmartins.arquitetura_software.model.repository;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.model.repository.entity.ProdutoEntity;
import com.fag.lucasmartins.arquitetura_software.model.repository.jpa.ProdutoJpaRepository;
import com.fag.lucasmartins.arquitetura_software.model.repository.mapper.ProdutoEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class ProdutoRepository {

    private final ProdutoJpaRepository jpaRepository;

    public ProdutoRepository(ProdutoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public ProdutoBO salvar(ProdutoBO bo) {
        ProdutoEntity entity = ProdutoEntityMapper.toEntity(bo);

        ProdutoEntity produtoCriado = jpaRepository.save(entity);

        return ProdutoEntityMapper.toBo(produtoCriado);
    }
}
