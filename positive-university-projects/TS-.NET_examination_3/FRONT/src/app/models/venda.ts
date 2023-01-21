import { ItemVenda } from "./item-venda";
import { Produto } from "./produto";

export interface Venda {
    VendaId?: number;
    Cliente?: string;
    IdMetodoPagamento?: number;
    itens: ItemVenda[];
    criadoEm: Date;
}
