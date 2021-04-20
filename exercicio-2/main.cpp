#include <bits/stdc++.h>

//Classe para driver generico
class Driver {
    private:
        bool estaLigado;
        bool estaFuncionando;
        std::string status;
    public:
        Driver()
        {
            this->estaFuncionando = true;
            this->estaLigado = false;
            this->status = "Aguadando Teste";
        }
        bool checarLigado()
        {
            return this->estaLigado;
        }
        void ligaDispositivo()
        {
            this->estaLigado = true;
            std::cout << "Ligando" << std::endl;
        }
        void executaTeste()
        {
            std::cout << "Testando" << std::endl;
        }
        void verificaStatus()
        {
            if(estaFuncionando) {
                this->status = "Funcionando";
                std::cout << this->status << std::endl;
                return;
            }
            this->status = "Nao esta funcionando";
            std::cout << this->status << std::endl;
        }
};

//Classe para driver de Rede que implementa o metodo enviaPacoteDeDados
class DriverDeRede: public Driver {
    private:
        std::vector<std::pair<std::string, int>> dados;
    public:
        DriverDeRede(std::vector<std::pair<std::string, int>> dados)
        {
            this->dados = dados;
        }
        void enviaPacoteDeDados()
        {
            if(!checarLigado()) {
                std::cout << "driver desligado" << std::endl;
                return;
            }
            for(std::pair<std::string, int> p: this->dados) {
                std::cout << "Enviando Pacote: " << p.first << std::endl;
            }
        }
};

//Classe para DriverDePagina que implementa metodo imprimePaginas
class DriverDePagina: public Driver {
    private:
        std::vector<std::string> paginas;
    public:
        DriverDePagina(std::vector<std::string> paginas) 
        {
            this->paginas = paginas;
        }
        void imprimePaginas()
        {
            if(!checarLigado()) {
                std::cout << "driver desligado" << std::endl;
                return;
            }
            for(std::string pagina: this->paginas) {
                std::cout << pagina << std::endl;
            }
        }
};

//Classe para DriverDeExibicao que implementa metodo alteraBrilhoDeExibicao
class DriverDeExibicao: public Driver {
    private:
        int brilho;
    public:
        DriverDeExibicao()
        {
            this->brilho = 0;
        }
        void alteraBrilhoDeExibicao(int brilho)
        {
            if(!checarLigado()) {
                std::cout << "driver desligado" << std::endl;
                return;
            }
            this->brilho = brilho;
            std::cout << "Brilho alterado para : " << brilho << std::endl;
        }
};

//main para demonstracao dos metodos
int main()
{
    std::vector<std::pair<std::string, int>> v(10);
    std::string nome;
    for (int i = 0; i < 10; ++i) {
        nome = "dado_" + std::to_string(i);
        v[i] = std::make_pair(nome, i);
    }
    DriverDeExibicao driver1;
    DriverDePagina driver3({"Pagina 1: \n       O Comeco", "Pagina 2: \n        O Meio", "Pagina 3: \n       O Fim"});
    DriverDeRede driver2(v);
    driver1.alteraBrilhoDeExibicao(10);
    driver1.ligaDispositivo();
    driver1.alteraBrilhoDeExibicao(10);
    driver1.executaTeste();
    driver1.verificaStatus();
    driver2.ligaDispositivo();
    driver2.executaTeste();
    driver2.enviaPacoteDeDados();
    driver3.ligaDispositivo();
    driver3.imprimePaginas();
}
