package com.deveficiente.seeddesafiocdc.dto;

public class ErroDTO {

    private String campo;
    private String erro;

    public ErroDTO() {
    }

    public ErroDTO(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
