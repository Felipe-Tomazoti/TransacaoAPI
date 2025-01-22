package br.com.FelipeTomazoti.desafioItau;

import br.com.FelipeTomazoti.desafioItau.controller.exception.StandardError;
import br.com.FelipeTomazoti.desafioItau.domain.Transacao;
import br.com.FelipeTomazoti.desafioItau.domain.dto.EstatisticaDTO;
import br.com.FelipeTomazoti.desafioItau.domain.dto.TransacaoDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.OffsetDateTime;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DesafioItauApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private WebClient webClient;

    @BeforeEach
    void setUp() {
        this.webClient =
                WebClient
                        .builder()
                        .baseUrl("http://localhost:" + this.port)
                        .build();
    }

    @BeforeEach
    void excluirTodasTransacoes() {
        webClient
                .delete()
                .uri("/transacao")
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Test
    void criarTransacao() {
        TransacaoDTO transacaoDTO = new TransacaoDTO(123.45, OffsetDateTime.now());

        var response = webClient.post()
                .uri("/transacao")
                .bodyValue(transacaoDTO)
                .exchangeToMono(ClientResponse::toBodilessEntity)
                .block();

        Assertions.assertThat(response.getStatusCode().value()).isEqualTo(201);
    }

    @Test
    void falharTransacaoValorNegativo() {
        TransacaoDTO transacaoDTO = new TransacaoDTO(-1.00, OffsetDateTime.now());

        var response = webClient.post()
                .uri("/transacao")
                .bodyValue(transacaoDTO)
                .exchangeToMono(clienteResponse -> clienteResponse.bodyToMono(StandardError.class))
                .block();

        Assertions.assertThat(response.getStatus()).isEqualTo(422);
        Assertions.assertThat(response.getError()).isEqualTo("Valor nao pode ser negativo!");
        Assertions.assertThat(response.getMessage()).isEqualTo("Entidade não processável");
        Assertions.assertThat(response.getPath()).isEqualTo("/transacao");
    }

    @Test
    void falharTransacaoDataFutura() {
        TransacaoDTO transacaoDTO = new TransacaoDTO(1.00, OffsetDateTime.parse("2026-08-07T12:34:56.789-03:00"));

        var response = webClient.post()
                .uri("/transacao")
                .bodyValue(transacaoDTO)
                .exchangeToMono(clienteResponse -> clienteResponse.bodyToMono(StandardError.class))
                .block();

        Assertions.assertThat(response.getStatus()).isEqualTo(422);
        Assertions.assertThat(response.getError()).isEqualTo("Transação não pode ocorrer no futuro!");
        Assertions.assertThat(response.getMessage()).isEqualTo("Entidade não processável");
        Assertions.assertThat(response.getPath()).isEqualTo("/transacao");
    }

    @Test
    void falharTransacaoJsonInvalido() {
        TransacaoDTO transacaoDTO = new TransacaoDTO(null, OffsetDateTime.parse("2024-08-07T12:34:56.789-03:00"));

        var response = webClient.post()
                .uri("/transacao")
                .bodyValue(transacaoDTO)
                .exchangeToMono(clienteResponse -> clienteResponse.bodyToMono(StandardError.class))
                .block();

        Assertions.assertThat(response.getStatus()).isEqualTo(400);
        Assertions.assertThat(response.getError()).isEqualTo("O Campo \"valor\" não pode ser nulo!");
        Assertions.assertThat(response.getMessage()).isEqualTo("JSON inválido");
        Assertions.assertThat(response.getPath()).isEqualTo("/transacao");
    }

    @Test
    void listarEstatisticas() {
        TransacaoDTO transacaoDTO1 = new TransacaoDTO(4.00, OffsetDateTime.now());
        TransacaoDTO transacaoDTO2 = new TransacaoDTO(6.00, OffsetDateTime.now());

        webClient.post()
                .uri("/transacao")
                .bodyValue(transacaoDTO1)
                .exchangeToMono(ClientResponse::toBodilessEntity)
                .block();

        webClient.post()
                .uri("/transacao")
                .bodyValue(transacaoDTO2)
                .exchangeToMono(ClientResponse::toBodilessEntity)
                .block();

        var response = webClient.get()
                .uri("/estatistica")
                .retrieve()
                .bodyToMono(EstatisticaDTO.class)
                .block();

        Assertions.assertThat(response.getCount()).isEqualTo(2);
        Assertions.assertThat(response.getMin()).isEqualTo(4.00);
        Assertions.assertThat(response.getMax()).isEqualTo(6.00);
        Assertions.assertThat(response.getAvg()).isEqualTo(5.00);
        Assertions.assertThat(response.getSum()).isEqualTo(10.0);
    }

}
