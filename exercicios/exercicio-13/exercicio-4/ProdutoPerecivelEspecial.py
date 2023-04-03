from ProdutoPerecivel import ProdutoPerecivel


class ProdutoPerecivelEspecial(ProdutoPerecivel):
    def __init__(self, codigo, preco, descricao, quantidade, validade): # validade mmaa
        super().__init__(codigo, preco, descricao, quantidade, validade)

    def imprime_nota(self): #definir depois
        print(f'Codigo: {self.codigo}\nPreço: R$ {self.preco}\nDescrição: {self.descricao}\nQuantidade: {self.quantidade}\nValidade: {self.validade}')
