package com.meta.tienda.excepciones;

import org.springframework.validation.BindingResult;

public class DatosNoValidosException extends RuntimeException{
    private BindingResult result;

    public DatosNoValidosException(String mensaje, BindingResult result){
        super(mensaje);
        this.result = result;
    }

    public BindingResult getResult() {
        return result;
    }

    public void setResult(BindingResult result) {
        this.result = result;
    }

}
