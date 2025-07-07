package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.algaworks.junit.utilidade.SaudacaoUtil.saudar;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes no utilitário de saudação")
class SaudacaoUtilTest {

    @Test
    @DisplayName("Saudação com bom dia")
    public void saudarComBomDia() {
        int horaValida = 9;
        String saudacao = saudar(horaValida);
        assertEquals("Bom dia", saudacao, "Saudação Incorreta!");
    }

    @Test
    @DisplayName("Deve saudar com bom dia ás 5h")
    public void saudarComBomDiaAPartir5h (){
        int horaValida = 5;
        String saudacao = saudar(horaValida);
        assertEquals("Bom dia", saudacao, "Saudação Incorreta!");
    }

    @Test
    public void saudarComBoaTarde() {
        int horaValida = 15;
        String saudacao = saudar(horaValida);
        assertEquals("Boa tarde", saudacao, "Saudação Incorreta!");
    }

    @Test
    public void saudarComBoaNoite() {
        int horaValida = 20;
        String saudacao = saudar(horaValida);
        assertEquals("Boa noite", saudacao, "Saudação Incorreta!");
    }

    @Test
    public void saudarComBoaNoiteAs4h() {
        int horaValida = 4;
        String saudacao = saudar(horaValida);
        assertEquals("Boa noite", saudacao, "Saudação Incorreta!");
    }

    @Test
    public void deveLancarException() {
        int horaInvalida = -10;
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> saudar(horaInvalida));
        assertEquals("Hora inválida", e.getMessage());
    }

    @Test
    public void naoDeveLancarException() {
        assertDoesNotThrow(() -> saudar(0));
    }
}