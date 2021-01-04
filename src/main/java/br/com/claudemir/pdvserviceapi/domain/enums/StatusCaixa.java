package br.com.claudemir.pdvserviceapi.domain.enums;

public enum StatusCaixa {

    ABERTO("1", "Aberto"),
    FECHADO("2", "Fechado"),
    CANCELADO("3", "Cancelado");

    private String cod;
    private String descricao;

    private StatusCaixa(String cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public String getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusCaixa toEnum(String cod) {
        if (cod == null)
            return null;

        for (StatusCaixa x : StatusCaixa.values())
            if (cod.equals(x.getCod()))
                return x;

        throw new IllegalArgumentException("Id inválido " + cod);
    }
}
