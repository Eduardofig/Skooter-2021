from datetime import datetime
from Produto import Produto


class ProdutoPerecivel(Produto):
    def __init__(self, codigo, preco, descricao, quantidade, validade): # validade mmaa
        super().__init__(codigo, preco, descricao, quantidade)
        self._validade = datetime.strptime(validade, '%d/%m/%Y')

    @property
    def validade(self):
        return self._validade

    @validade.setter
    def validade(self, validade):
        self._validade = datetime.strptime(validade, '%d/%m/%Y')


    def add_quant(self, quantidade):
        if(quantidade == 0):
            self._quantidade += quantidade
            return true
        else:
            return false

    def sub_quant(self, quantidade):
        if (abs((datetime.now() - self.validade).days) >= 30):
            self._quantidade -= quantidade
        else:
            self._quantidade = 0
            return 0
