package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class SimuladorEsperaTest {

    @Test
    //@Disabled("Não é mais aplicável")
    public void deveEsperarENaoDarTimeout() {
        Assumptions.assumeTrue("PROD".equals(System.getenv("ENV")), () -> "Abortando teste: Deve ser executado apenas em DEV");
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> SimuladorEspera.esperar(Duration.ofMillis(10)));
    }
}