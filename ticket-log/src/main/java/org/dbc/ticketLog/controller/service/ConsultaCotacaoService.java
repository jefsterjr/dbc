package org.dbc.ticketLog.controller.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@Service
public interface ConsultaCotacaoService {
    String url = "https://economia.awesomeapi.com.br/json/all/USD-BRL";

    static BigDecimal getCotacaoDolar() {
        RestTemplate template = new RestTemplate();
        Map<String, Map<String, String>> consulta = template.getForEntity(url, Map.class).getBody();
        Map<String, String> moeda = consulta.get("USD");
        return new BigDecimal(moeda.get("ask"));
    }
}
