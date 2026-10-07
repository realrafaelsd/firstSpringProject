package br.com.fiap.to;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class RemedioTO {
    private Long codigo; //Long é o tipo de atributo para inteiros grandes
    @NotBlank //validação para o nome nao vir em branco e nem nulo (validações sempre virao antes do que sera validado)
    private String nome;
    @NotNull
    @PositiveOrZero //garante que o preço é posivito ou zero
    private Double preco;
    @PastOrPresent //garante que a data será no passado ou data atual
    private LocalDate dataDeFabricacao;
    @FutureOrPresent //garante que a data será no futuro ou a data atual
    private LocalDate dataDeValidade;

    //construtores
    public RemedioTO (){}

    public RemedioTO(Long codigo, String nome, Double preco, LocalDate dataDeFabricacao, LocalDate dataDeValidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.dataDeFabricacao = dataDeFabricacao;
        this.dataDeValidade = dataDeValidade;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public LocalDate getDataDeFabricacao() {
        return dataDeFabricacao;
    }

    public void setDataDeFabricacao(LocalDate dataDeFabricacao) {
        this.dataDeFabricacao = dataDeFabricacao;
    }

    public LocalDate getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(LocalDate dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }
}
