package com.Cabrera.PNL.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Cabrera.PNL.entity.Denuncia;
import com.Cabrera.PNL.exception.GeneralException;
import com.Cabrera.PNL.exception.NoDataFoundException;
import com.Cabrera.PNL.exception.ValidateException;
import com.Cabrera.PNL.repository.DenunciaRepository;
import com.Cabrera.PNL.service.DenunciaService;
import com.Cabrera.PNL.validator.DenunciaValidator;

@Service
public class DenunciaServiceImpl implements DenunciaService {
    @Autowired
    private DenunciaRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Denuncia> findAll(Pageable page) {
        try {
            return repository.findAll(page).toList();
        } catch (Exception e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<Denuncia> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<Denuncia> findByTitulo(String titulo, Pageable page) {
        try {
            return repository.findByTituloContaining(titulo, page);
        } catch (Exception e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Denuncia findById(int id) {
        try {
            return repository.findById(id)
                    .orElseThrow(() -> new NoDataFoundException("No existe un registro con ese id"));
        } catch (NoDataFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Transactional
    @Override
    public Denuncia save(Denuncia denuncia) {
        try {
            DenunciaValidator.save(denuncia);

            if (denuncia.getId() == 0) {
                return repository.save(denuncia);
            }

            Denuncia registroExistente = repository.findById(denuncia.getId())
                    .orElseThrow(() -> new NoDataFoundException("No existe un registro con ese id"));

            registroExistente.setTitulo(denuncia.getTitulo());
            registroExistente.setDescripcion(denuncia.getDescripcion());
            registroExistente.setUbicacion(denuncia.getUbicacion());
            registroExistente.setEstado(denuncia.getEstado());
            registroExistente.setCiudadano(denuncia.getCiudadano());
            registroExistente.setTelefonoCiudadano(denuncia.getTelefonoCiudadano());
            registroExistente.setFechaRegistro(denuncia.getFechaRegistro());

            return repository.save(registroExistente);
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Transactional
    @Override
    public void delete(int id) {
        try {
            Denuncia registro = repository.findById(id)
                    .orElseThrow(() -> new NoDataFoundException("No existe un registro con ese id"));
            repository.delete(registro);
        } catch (NoDataFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new GeneralException("Error del servidor");
        }
    }
}
