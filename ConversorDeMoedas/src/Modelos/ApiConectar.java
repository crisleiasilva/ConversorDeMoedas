package Modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConectar {
    private String minhaApi = "299652dd44a972ce128dba26";
    private String url = "https://v6.exchangerate-api.com/v6/";
    private String moedaInicio;
    private String moedaFinal;


    public String conversor(int opcaoDeEntrada, double valorDeEntrada) throws IOException, InterruptedException {
        try {
            switch (opcaoDeEntrada) {
                case 1:
                    this.moedaInicio = "BRL";
                    this.moedaFinal = "USD";
                    break;
                case 2:
                    this.moedaInicio = "USD";
                    this.moedaFinal = "BRL";
                    break;
                case 3:
                    this.moedaInicio = "BRL";
                    this.moedaFinal = "BOB";
                    break;
                case 4:
                    this.moedaInicio = "BOB";
                    this.moedaFinal = "BRL";
                    break;
                case 5:
                    this.moedaInicio = "BRL";
                    this.moedaFinal = "ARS";
                    break;
                case 6:
                    this.moedaInicio = "ARS";
                    this.moedaFinal = "BRL";
                    break;
                default:
                    System.out.println("Saindo do programa...");
                    break;
            }

            Gson gson = new GsonBuilder().create();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(this.url + this.minhaApi + "/pair/" + this.moedaInicio + "/" + this.moedaFinal + "/" + valorDeEntrada))
                    .build();


            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());


            String json = response.body();
            LeituraApi minhaApi = gson.fromJson(json, LeituraApi.class);
            MinhaMoeda minhaMoeda = new MinhaMoeda(minhaApi);

            return minhaMoeda.toString();


        } catch (Exception e) {
            System.out.println("Não foi possível fazer a leitura da sua entrada : \n " + e);

        }

        return "\n Erro";
    }
}

