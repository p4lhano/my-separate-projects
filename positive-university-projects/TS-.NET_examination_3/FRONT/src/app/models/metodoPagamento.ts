export interface MetodoPagamento {
    id?: number;
    nome: string;
    usuarioId?: number;
    numeroCartao: string;
    meioPagamentoEscolhido?: MeioPagamento;
}

enum MeioPagamento{  CREDITO, DEBITO, VALE_CARD  }