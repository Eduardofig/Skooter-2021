from Produto import Produto


class ProdutoNaoPerecivel(Produto):
    def __init__(self, codigo, preco, descricao, quantidade, garantia):
        super().__init__(codigo, preco, descricao, quantidade)
        self._garantia = garantia

    @property
    def garantia(self):
        return self._garantia

    def add_quant(self, quantidade):
        if(quantidade == 0):
            self._quantidade = quantidade
            return true
        else:
            return false
