package com.example.ApiClassRoom.aids;

public enum MessageAPI {

    DOCENTE_NO_ENCONTRADO("El docente que buscas no se encuentra en la base de datos");

    private String text;

    MessageAPI(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
