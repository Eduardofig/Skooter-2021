from produto import Produto, ProdutoPerecivel, ProdutoPerecivelEspecial, ProdutoNaoPerecivel
from estoque import Estoque

estoque1 = Estoque()
arroz = {'tipo' : 1, 'codigo' : 1, 'preco' : 15.0, 'descricao' : 'Arroz', 'quantidade' : 20, 'validade' : '10/09/2021'}
feijao = {'tipo' : 2, 'codigo' : 2, 'preco' : 23.0, 'descricao' : 'Feijão', 'quantidade' : 31, 'validade' : '08/11/2021'}
notebook = {'tipo' : 3, 'codigo' : 3, 'preco' : 2099.0, 'descricao' : 'Notebook', 'quantidade' : 11, 'garantia' : 2}
estoque1.cadastrar(**arroz)
estoque1.cadastrar(**feijao)
estoque1.cadastrar(**notebook)
print("Descrição básica dos itens no estoque")
estoque1.descricao_basica()
print("\n\nPesquisa por codigo")
estoque1.consultar(1)
estoque1.consultar(2)
print(f'\n\nValor total do estoque: R$ {estoque1.valor_estoque()}')
