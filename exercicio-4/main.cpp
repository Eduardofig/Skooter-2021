#include <iostream>
#include <vector>

class Superpoder 
{
    private:
        int _categoria;
        double _nivelDePoder;
        std::string _nome;
    public:
        double probabilidadeDeAcerto;
        int getCategoria()
        {
            return this->_categoria;
        }
        std::string getNome()
        {
            return this->_nome;
        }
        double getNivelDePoder()
        {
            return this->_nivelDePoder;
        }
        void setCategoria(int pCategoria)
        {
            this->_categoria = pCategoria;
        }
        void setNome(std::string pNome)
        {
            this->_nome = pNome;
        }
        void setNivelDePoder(double pNivelDePoder)
        {
            this->_nivelDePoder = pNivelDePoder;
        }
        Superpoder(int pCategoria, double pNivelDePoder, double probabilidadeDeAcerto, std::string pNome)
        {
            setCategoria(pCategoria);
            setNome(pNome);
            setNivelDePoder(pNivelDePoder);
            this->probabilidadeDeAcerto = probabilidadeDeAcerto;
        }
};

class Personagem 
{
    private:
        std::string _nome;
        std::string _nomeVidaReal;
        double vida;
        bool protegido;
    public:
        std::vector<Superpoder> _poderes;
        std::string getNome()
        {
            return this->_nome;
        }
        std::string getNomeVidaReal()
        {
            return this->_nomeVidaReal;
        }
        double getTotalPoder()
        {
            double totalPoder = 0;
            for(Superpoder poder: this->_poderes) {
                totalPoder += poder.getNivelDePoder();
            }
            return totalPoder;
        }
        double getVida()
        {
            return this->vida;
        }
        bool getProtegido()
        {
            return this->protegido;
        }
        void setNome(std::string pNome)
        {
            this->_nome = pNome;
        }
        void setNomeVidaReal(std::string pNomeVidaReal)
        {
            this->_nomeVidaReal = pNomeVidaReal;
        }
        void addPoder(Superpoder pPoder)
        {
            this->_poderes.push_back(pPoder);
        }
        void setVida(double pVida)
        {
            this->vida = pVida;
        }
        void setProtegido(bool pProtegido)
        {
            this->protegido = pProtegido;
        }
        void Attack(Personagem *Oponente, int PowerIndex)
        {
            std::cout << getNome() << " ataca " << Oponente->getNome() << " com " << this->_poderes[PowerIndex].getNome() << std::endl;
            if(Oponente->getProtegido()) {
                std::cout << Oponente->getNome() << " esta protegido" << std::endl;
                Oponente->setProtegido(false);
                return;
            }
            if((double)rand()/RAND_MAX > this->_poderes[PowerIndex].probabilidadeDeAcerto) {
                Oponente->setVida(Oponente->getVida() > this->_poderes[PowerIndex].getNivelDePoder()? Oponente->getVida() - this->_poderes[PowerIndex].getNivelDePoder(): 0);
                std::cout << getNome() << " acerta" << std::endl;
                std::cout << Oponente->getNome() << " perde " << this->_poderes[PowerIndex].getNivelDePoder() << " pontos de vida" << std::endl;
                return;
            } 
            std::cout << getNome() << " erra" << std::endl;
        }
};

class SuperHeroi: public Personagem 
{
    public:
        SuperHeroi(std::string pNome, std::string pNomeVidaReal, std::vector<Superpoder> pPoderes, double vida)
        {
            setNome(pNome);
            setNomeVidaReal(pNomeVidaReal);
            for(Superpoder pPoder: pPoderes) {
                addPoder(pPoder);
            }
            setVida(vida);
            setProtegido(true);
        }
};

class Vilao: public Personagem 
{
    private:
        int _anosDePrisao;
    public:
        void setAnosDePrisao(int pAnosDePrisao)
        {
            this->_anosDePrisao = pAnosDePrisao;
        }
        int getAnosDePrisao()
        {
            return this->_anosDePrisao;
        }
        Vilao(std::string pNome, std::string pNomeVidaReal, std::vector<Superpoder> pPoderes, int pAnosDePrisao, double vida)
        {
            setNome(pNome);
            setNomeVidaReal(pNomeVidaReal);
            setAnosDePrisao(pAnosDePrisao);
            for(Superpoder pPoder: pPoderes) {
                addPoder(pPoder);
            }
            setVida(vida);
            setProtegido(false);
        }
};

int main()
{
    Superpoder VisaoLaser(1, 10.0, 0.5, "Visao Laser");
    Superpoder SuperSoco(1, 10.0, 0.7, "Super Soco");
    SuperHeroi Superman("Superman", "Clark Kent", {VisaoLaser, SuperSoco}, 150.00);
    Superpoder SocoKryptonita(1, 20.0, 0.8, "Soco Kryptonita");
    Superpoder GranadaGasKryptonita(1, 5.0, 0.4, "Granada de Gas de Kryptonita");
    Vilao LexLuthor("Lex Luthor", "Lex Luthor",{SocoKryptonita, GranadaGasKryptonita}, 150, 200.00);
    std::cout << Superman.getNomeVidaReal() << std::endl;
    std::cout << Superman.getNome() << std::endl;
    std::cout << Superman.getTotalPoder() << std::endl;
    std::cout << " Versus " << std::endl;
    std::cout << LexLuthor.getNomeVidaReal() << std::endl;
    std::cout << LexLuthor.getNome() << std::endl;
    std::cout << LexLuthor.getTotalPoder() << std::endl;
    std::cout << LexLuthor.getAnosDePrisao() << std::endl;
    while(LexLuthor.getVida() != 0 || Superman.getVida() != 0) {
        Superman.Attack(&LexLuthor, rand() % 2);
        if(LexLuthor.getVida() == 0) {
            break;
        }
        LexLuthor.Attack(&Superman, rand() % 2);
    }
    if(LexLuthor.getVida() == 0) {
        std::cout << Superman.getNome() << " WINS" << std::endl;
    } else {
        std::cout << LexLuthor.getNome() << " WINS" << std::endl;
    }
}
