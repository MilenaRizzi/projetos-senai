package com.senai.imobiliaria.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Tipo {
  APARTAMENTO, 
  CASA,
  PREDIO,
  TERRENO;

   @JsonCreator
    public static Tipo fromString(String value) {
        for (Tipo especialidade : Tipo.values()) {
            if (especialidade.name().equalsIgnoreCase(value)) {
                return especialidade;
            }
        }
        throw new IllegalArgumentException("Especialidade inválida: " + value);
    }
}
