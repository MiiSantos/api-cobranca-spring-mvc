package com.algaworks.crudcobranca.model;

public enum StatusTitle {

    PENDING("Pendente"),
    RECEIVED("Recebido");

    private String description;

    StatusTitle(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
