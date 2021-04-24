#include <iostream>
#include <vector>

class Superpoder 
{
    private:
        int _categoria;
        double _nivelDePoder;
        std::string _nome;
    public:
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
        Superpoder(int pCategoria, double pNivelDePoder, std::string pNome)
        {
            setCategoria(pCategoria);
            setNome(pNome);
            setNivelDePoder(pNivelDePoder);
        }
};

class Personagem 
{
    private:
        std::string _nome;
        std::string _nomeVidaReal;
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
};

class SuperHeroi: public Personagem 
{
    public:
        SuperHeroi(std::string pNome, std::string pNomeVidaReal, std::vector<Superpoder> pPoderes)
        {
            setNome(pNome);
            setNomeVidaReal(pNomeVidaReal);
            for(Superpoder pPoder: pPoderes) {
                addPoder(pPoder);
            }
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
        Vilao(std::string pNome, std::string pNomeVidaReal, std::vector<Superpoder> pPoderes, int pAnosDePrisao)
        {
            setNome(pNome);
            setNomeVidaReal(pNomeVidaReal);
            setAnosDePrisao(pAnosDePrisao);
            for(Superpoder pPoder: pPoderes) {
                addPoder(pPoder);
            }
        }
};

int main()
{
    Superpoder visaoLaser(1, 10.0, "visaoLaser");
    Superpoder supersoco(1, 10.0, "supersoco");
    SuperHeroi superman("superman", "clark kent", {visaoLaser});
    superman.addPoder(supersoco);
    Superpoder socokryptonita(1, 20.0, "socokryptonita");
    Superpoder granadagasK(1, 5.0, "granadagask");
    Vilao lexluthor("Lex Luthor", "Alexander Luthor",{socokryptonita}, 150);
    lexluthor.addPoder(granadagasK);
    std::cout << superman.getNomeVidaReal() << std::endl;
    std::cout << superman.getNome() << std::endl;
    std::cout << superman.getTotalPoder() << std::endl;
    std::cout << " Versus " << std::endl;
    std::cout << lexluthor.getNomeVidaReal() << std::endl;
    std::cout << lexluthor.getNome() << std::endl;
    std::cout << lexluthor.getTotalPoder() << std::endl;
    std::cout << lexluthor.getAnosDePrisao() << std::endl;
}
