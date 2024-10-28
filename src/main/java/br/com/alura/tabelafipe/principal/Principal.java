package br.com.alura.tabelafipe.principal;

import br.com.alura.tabelafipe.model.Veiculo;
import br.com.alura.tabelafipe.service.ConsumoApi;
import br.com.alura.tabelafipe.service.ConverteDadosJson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDadosJson conversorJson = new ConverteDadosJson();
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
    private String tipoVeiculo;
    private List<Veiculo> veiculos = new ArrayList<>();

    public void exibeMenu() {
        System.out.println("""
                **** OPÇÕES ****
                Carro
                Moto
                Caminhão""");

        String opcao = scanner.nextLine();
        switch (opcao.toLowerCase()) {
            case "carro":
                buscarCarros();
                break;
            case "moto":
                buscarMotos();
                break;
            case "caminhão":
                buscarCaminhoes();
                break;
            default:
                System.out.println("Opção inválida");
        }

    }

    private void buscarCarros() {
        System.out.println("carro");
    }

    private void buscarMotos() {
        System.out.println("moto");
    }

    private void buscarCaminhoes() {
        System.out.println("caminhão");
    }

}
