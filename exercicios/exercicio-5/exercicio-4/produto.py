from datetime import datetime

class Produto:

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

class ProdutoPerecivelEspecial(ProdutoPerecivel):
    def __init__(self, codigo, preco, descricao, quantidade, validade): # validade mmaa
        super().__init__(codigo, preco, descricao, quantidade, validade)

    def imprime_nota(self): #definir depois
        print(f'Codigo: {self.codigo}\nPreço: R$ {self.preco}\nDescrição: {self.descricao}\nQuantidade: {self.quantidade}\nValidade: {self.validade}')

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
