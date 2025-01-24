package br.com.FelipeTomazoti.desafioItau.controller;

import br.com.FelipeTomazoti.desafioItau.domain.dto.TransacaoDTO;
import br.com.FelipeTomazoti.desafioItau.service.TransacaoService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "TransacaoAPI", description = "Desafio-ITAU")
@Slf4j
@RestController
@RequestMapping(value = "/transacao")
public record TransacaoController(TransacaoService transacaoService) {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = TransacaoDTO.class),
                    examples = @ExampleObject(
                            value = "{\n" +
                                    "  \"valor\": \"123.00\",\n" +
                                    "  \"dataHora\": \"2025-01-21T01:40:50.2472448Z\"\n" +
                                    "}"
                    )
            )
    )
    public ResponseEntity<List<TransacaoDTO>> listarTransacoes() {
        List<TransacaoDTO> list = transacaoService.listarTransacoes();
        log.info("Transacoes listadas com sucesso!");
        return ResponseEntity.ok(list);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @io.swagger.v3.oas.annotations.responses.ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "422",
                    description = "valor não pode ser negativo e dataHora não pode ser futura",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\n" +
                                            "  \"timestamp\": \"1736905543731\",\n" +
                                            "  \"status\": \"422\",\n" +
                                            "  \"error\": \"Valor nao pode ser negativo!\",\n" +
                                            "  \"message\": \"Entidade não processável\",\n" +
                                            "  \"path\": \"/transacao\"\n" +
                                            "}"
                            )
                    )
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "400",
                    description = "valor e dataHora não pode ser nulos",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\n" +
                                            "  \"timestamp\": \"1736905543731\",\n" +
                                            "  \"status\": \"400\",\n" +
                                            "  \"error\": \"O Campo \\\"valor\\\" não pode ser nulo!\",\n" +
                                            "  \"message\": \"JSON inválido\",\n" +
                                            "  \"path\": \"/transacao\"\n" +
                                            "}"
                            )
                    )
            ),

    })
    public ResponseEntity<Void> criarTransacao(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "criar transacao", required = true,
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = TransacaoDTO.class),
                    examples = @ExampleObject(value = "{\n" +
                            "  \"valor\": 10.00,\n" +
                            "  \"dataHora\": \"2025-01-21T01:40:50.2472448Z\"\n" +
                            "}"))) @RequestBody @Valid TransacaoDTO transacaoDTO) {
        transacaoService.criarTransacao(transacaoDTO);
        log.info("Transacao criada com sucesso!");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> excluirTodasTransacoes() {
        transacaoService.excluirTodasTransacoes();
        log.info("Transacoes excluidas com sucesso!");
        return ResponseEntity.ok().build();
    }
}
