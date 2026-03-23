package com.fag.lucasmartins.arquitetura_software.controller.mapper;

import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoDTO;
import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;

public class ProdutoDTOMapper {

    private ProdutoDTOMapper() {
    }

    public static ProdutoDTO toDto(ProdutoBO bo) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(bo.getId());
        dto.setNome(bo.getNome());
        dto.setEstoque(bo.getEstoque());
        dto.setPreco(bo.getPreco());
        return dto;
    }

    public static ProdutoBO toBo(ProdutoDTO dto) {
        ProdutoBO bo = new ProdutoBO();
        bo.setId(dto.getId());
        bo.setNome(dto.getNome());
        bo.setEstoque(dto.getEstoque());
        bo.setPreco(dto.getPreco());
        return bo;
    }

}
