package br.com.FelipeTomazoti.desafioItau.loadTest;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;
import java.time.OffsetDateTime;


public class TransacaoSavesSimulation extends Simulation {

    HttpProtocolBuilder httpProtocol =
            http.baseUrl("https://computer-database.gatling.io")
                    .baseUrl("http://localhost:8080")
                    .acceptHeader("application/json")
                    .contentTypeHeader("application/json");

    ScenarioBuilder postTransacaoScenario = scenario("POST Transacao")
            .exec(session -> {
                String dataHoraAtual = OffsetDateTime.now().toString();
                return session.set("dataHoraAtual", dataHoraAtual);
            })
            .exec(http("Criar Transacao")
                    .post("/transacao")
                    .header("Content-Type", "application/json")
                    .body(StringBody(session -> {
                        return "{ \"valor\": 100.50, \"dataHora\": \"" + session.get("dataHoraAtual") + "\" }";
                    }))
                    .check(status().is(201)));

    ScenarioBuilder getTransacaoScenario = scenario("GET Transacoes")
            .exec(http("Listar Transacoes")
                    .get("/transacao")
                    .check(status().is(200)));

    ScenarioBuilder getEstatisticasScenario = scenario("GET Estatisticas")
            .exec(http(("Listar Estatisticas"))
                    .get("/estatistica")
                    .check(status().is(200)));

    {
        setUp(
                postTransacaoScenario.injectOpen(constantUsersPerSec(2).during(60)),
                getTransacaoScenario.injectOpen(constantUsersPerSec(2).during(60)),
                getEstatisticasScenario.injectOpen(constantUsersPerSec(2).during(60))
        ).protocols(httpProtocol);
    }
}