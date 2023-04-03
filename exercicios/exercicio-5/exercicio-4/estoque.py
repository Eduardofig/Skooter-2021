from produto import Produto, ProdutoPerecivel, ProdutoPerecivelEspecial, ProdutoNaoPerecivel


class Estoque:

    _valor_estoque = 0

    def __init__(self):
        self._estoque = []

    def cadastrar(self, **produto):
        if(produto['tipo'] == 1): #ProdutoPerecivel
            produto = ProdutoPerecivel(produto['codigo'], produto['preco'], produto['descricao'], produto['quantidade'], produto['validade'])
            self._estoque.append(produto)
        elif(produto['tipo'] == 2): #ProdutoPerecivelEspecial
            produto = ProdutoPerecivelEspecial(produto['codigo'], produto['preco'], produto['descricao'], produto['quantidade'], produto['validade'])
            self._estoque.append(produto)
        else: #ProdutoNaoPerecivel
            produto = ProdutoNaoPerecivel(produto['codigo'], produto['preco'], produto['descricao'], produto['quantidade'], produto['garantia'])
            self._estoque.append(produto)
        del produto

    #@property
    def consultar(self, codigo):
        status = 0
        for item in self._estoque:
            if(codigo == item.codigo):
                item.exibe_descricao()
        if(status == 0):
            return 0


    def retirar_estoque(self, codigo, quantidade):
        for item in self._estoque:
            if(codigo == item.codigo):
                item.sub_quant(quantidade)

    def descricao_basica(self):
        for item in (self._estoque):
            item.exibe_descricao()

    def valor_estoque(self):
        for item in (self._estoque):
            Estoque._valor_estoque += (item.preco * item.quantidade)
        return Estoque._valor_estoque
