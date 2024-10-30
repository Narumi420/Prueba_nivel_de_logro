package com.Cabrera.PNL.validator;

import com.Cabrera.PNL.entity.Denuncia;
import com.Cabrera.PNL.exception.ValidateException;

public class DenunciaValidator {
    public static void save(Denuncia registro) {

        if (registro.getTitulo() == null || registro.getTitulo().trim().isEmpty()) {
            throw new ValidateException("El titulo es requerido");
        }
        if (registro.getTitulo().length() > 100) {
            throw new ValidateException("El titulo no debe exceder los 100 caracteres");
        }
        
        if (registro.getDescripcion() == null || registro.getDescripcion().trim().isEmpty()) {
            throw new ValidateException("La descripción no puede ser nula o vacía");
        }
        if (registro.getDescripcion().length() > 255) {
            throw new ValidateException("La descripcion no debe exceder los 255 caracteres");
        }
        if (registro.getUbicacion() == null || registro.getUbicacion().trim().isEmpty()) {
            throw new ValidateException("La ubicacion no puede ser nula o vacía");
        }
        if (registro.getUbicacion().length() > 150) {
            throw new ValidateException("La ubicacion no debe exceder los 150 caracteres");
        }
        if (registro.getEstado() == null || registro.getEstado().trim().isEmpty()) {
            throw new ValidateException("El estado no puede ser nula o vacía");
        }
        if (registro.getEstado().length() > 20) {
            throw new ValidateException("El estado no debe exceder los 20 caracteres");
        }
        if (registro.getCiudadano() == null || registro.getCiudadano().trim().isEmpty()) {
            throw new ValidateException("El ciudadano no puede ser nula o vacía");
        }
        if (registro.getCiudadano().length() > 100) {
            throw new ValidateException("El ciudadano no debe exceder los 100 caracteres");
        }
        if (registro.getFechaRegistro() == null) {
            throw new ValidateException("La fecha no puede ser nula o vacía");
        }
        if (registro.getTelefonoCiudadano() == null || registro.getTelefonoCiudadano().trim().isEmpty()) {
            throw new ValidateException("El Telefono no puede ser nulo o vacía");
        }
        if (registro.getTelefonoCiudadano().length() > 15) {
            throw new ValidateException("El telefono no debe exceder los 15 caracteres");
        }

       
    }
}
