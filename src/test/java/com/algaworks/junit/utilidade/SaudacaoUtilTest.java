package com.algaworks.junit.utilidade;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;
import static com.algaworks.junit.utilidade.SaudacaoUtil.saudar;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes no utilitário de saudação")
class SaudacaoUtilTest {

    @Test
    public void Dado_uma_horario_matuino_Quando_saudar_Entao_deve_retornar_bom_dia() {
        int horaValida = 9;
        String saudacao = saudar(horaValida);

        assertThat(saudacao).is(SaudacaoUtilConditions.igualBomDia());
    }

    @Test
    public void Dado_uma_horario_vespertino_Quando_saudar_Entao_deve_retornar_boa_tarde() {
        int horaValida = 15;
        String saudacao = saudar(horaValida);
        assertEquals("Boa tarde", saudacao);
    }

    @Test
    public void Dado_uma_horario_noturno_Quando_saudar_Entao_deve_retornar_boa_noite() {
        int horaValida = 4;
        String saudacao = saudar(horaValida);
        assertEquals("Boa noite", saudacao);
    }

    @Test
    public void Dado_uma_hora_invalida_Quando_saudar_Entao_deve_lancar_exception() {
        int horaInvalida = -10;
        IllegalArgumentException e = catchThrowableOfType(() -> saudar(horaInvalida), IllegalArgumentException.class);
        // assertThatThrownBy(() -> saudar(horaInvalida)).isInstanceOf(IllegalArgumentException.class).hasMessage("Hora inválida");   -- PODE FAZER ESSA FORMA
        assertThat(e).hasMessage("Hora inválida");
    }

    @Test
    public void Dado_uma_hora_valida_Quando_saudar_Entao_nao_deve_lancar_exception() {
        int horaValida = 0;
        Executable chamadaValidaDeMetodo = () -> saudar(horaValida);
        assertDoesNotThrow(chamadaValidaDeMetodo);
    }



    @ParameterizedTest
    @ValueSource(ints = {5,6,7,8,9,10,11})
    public void Dado_horario_matinal_Quando_saudar_Entao_deve_retornar_bom_dia(int hora) {
        String saudacao = saudar(hora);
        assertEquals("Bom dia", saudacao);
    }

    @ParameterizedTest
    @ValueSource(ints = {12,13,14,15,16,17})
    public void Dado_horario_tarde_Quando_saudar_Entao_deve_retornar_boa_tarde(int hora) {
        String saudacao = saudar(hora);
        assertEquals("Boa tarde", saudacao);
    }
}