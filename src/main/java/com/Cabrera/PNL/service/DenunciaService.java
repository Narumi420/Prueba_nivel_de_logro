package com.Cabrera.PNL.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.Cabrera.PNL.entity.Denuncia;

public interface DenunciaService {
public List<Denuncia> findAll(Pageable page);
    public List<Denuncia> findAll();
    public List<Denuncia> findByTitulo(String titulo, Pageable page);
    public Denuncia findById(int id);
    public Denuncia save(Denuncia denuncia);
    public void delete(int id);
}
