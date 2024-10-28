package br.com.alura.tabelafipe.principal;

import br.com.alura.tabelafipe.model.Dados;
import br.com.alura.tabelafipe.model.Modelos;
import br.com.alura.tabelafipe.model.Veiculo;
import br.com.alura.tabelafipe.service.ConsumoApi;
import br.com.alura.tabelafipe.service.ConverteDadosJson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDadosJson conversorJson = new ConverteDadosJson();
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
    private List<Veiculo> veiculos = new ArrayList<>();

    public void exibeMenu() {
        System.out.println("""
                **** OPÇÕES ****
                Carro
                Moto
                Caminhão
                
                Digite uma das opções para consultar valores:
                """);

        String opcao = scanner.nextLine();
        String endereco = "";

        if (opcao.toLowerCase().contains("carr")) {
            endereco = ENDERECO + "carros/marcas/";
        } else if (opcao.toLowerCase().contains("mot")) {
            endereco = ENDERECO + "motos/marcas/";
        } else if (opcao.toLowerCase().contains("cami")) {
            endereco = ENDERECO + "caminhoes/marcas/";
        } else {
            System.out.println("Opção inválida!");
        }

        String json = consumo.obterDados(endereco);

        List<Dados> marcas = conversorJson.converterLista(json, Dados.class);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("\nInforme o código dar marca para consulta");
        int codigoMarca = scanner.nextInt();
        scanner.nextLine();

        endereco = endereco + codigoMarca + "/modelos/";
        json = consumo.obterDados(endereco);
        Modelos modeloLista = conversorJson.converterDados(json, Modelos.class);

        System.out.println("\nModelos dessa marca: ");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("\nDigite um trecho do nome do veículo para consulta");
        String trecho = scanner.nextLine();
        List<Dados> modelosFiltrados = modeloLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(trecho.toLowerCase()))
                        .collect(Collectors.toList());

        System.out.println("\nModelos filtrados");
        modelosFiltrados.forEach(System.out::println);

        System.out.println("\nDigite o código do modelo para consultar valores:");
        int codModelo = scanner.nextInt();

        endereco = endereco + codModelo + "/anos/";
        json = consumo.obterDados(endereco);
        List<Dados> anos = conversorJson.converterLista(json, Dados.class);

        for (int i = 0; i < anos.size(); i++) {
            String enderecoAno = endereco + anos.get(i).codigo();
            json = consumo.obterDados(enderecoAno);
            Veiculo veiculo = conversorJson.converterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }
        System.out.println("\nTodos os veículos com os valores por ano:");
        veiculos.forEach(System.out::println);
    }
}
