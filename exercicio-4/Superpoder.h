#include<string>
#include<vector>
#ifndef SUPERPODER_H
#define SUPERPODER_H value

class Superpoder
{
    private:
        int _categoria;
        double _nivelDePoder;
        std::string _nome;
    public:
        double probabilidadeDeAcerto;
        int getCategoria();
        std::string getNome();
        double getNivelDePoder();
        void setCategoria(int pCategoria);
        void setNome(std::string pNome);
        void setNivelDePoder(double pNivelDePoder);
        Superpoder(int pCategoria, double pNivelDePoder, double probabilidadeDeAcerto, std::string pNome);
};

#endif /* ifndef Superpoder */
