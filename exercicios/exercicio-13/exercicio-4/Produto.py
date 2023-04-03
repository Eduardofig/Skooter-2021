from abc import ABC, abstractmethod


class Produto(ABC):
    @abstractmethod
    def __init__(self, codigo, preco, descricao, quantidade):
        self._codigo = codigo
        self._preco = preco
        self._descricao = descricao
        self._quantidade = quantidade

    # Get e set para preço
    @property
    def preco(self):
        return self._preco

    @preco.setter
    def preco(self, preco_unit):
        if (preco_unit >= 0):
            self._preco = preco
        else:
            print("Preço não pode ser negativo")

    # Get e set para descricao
    @property
    def descricao(self):
        return self._descricao

    @descricao.setter
    def descricao(self, descricao):
        self._descricao = descricao

    #Deve oferecer métodos “get” para código e quantidade
    # Get para código
    @property
    def codigo(self):
        return self._codigo

    # Get e outros métodos para quantidade
    @property
    def quantidade(self):
        return self._quantidade

    @quantidade.setter
    def add_quant(self, quantidade):
        self._quantidade += quantidade

    def sub_quant(self, quantidade):
        self._quantidade -= quantidade
        return self._quantidade

    # método que imprime a descrição
    def exibe_descricao(self):
        print(f'Produto {self.codigo}, {self.descricao}, custo de R$ {self.preco}, quantidade {self.quantidade}')
