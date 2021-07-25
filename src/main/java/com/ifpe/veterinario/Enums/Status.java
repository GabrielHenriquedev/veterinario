package com.ifpe.veterinario.Enums;

public enum Status {

    CONCLUIDO("Concluído"),
    PROCESSO("Em andamento"),
    PAGAMENTOPENDENTE("Aguardando Pagamento"),
    PAGAMENTOEFETUADO("Pagamento efetuado"),
    CANCELADO("Atendimento cancelado"),
    ENTREGUE("Entrege ao dono");

    private String status;

    private Status (String status){
        this.status = status;
    }
}
