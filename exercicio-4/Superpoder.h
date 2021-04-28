#include <string>
#include <vector>
#ifndef SUPERPODER_H
#define SUPERPODER_H

class Superpoder
{
    private:
        int _categoria;
        double _nivelDePoder;
        std::string _nome;
        bool protege;
    public:
        double probabilidadeDeAcerto;
        int getCategoria();
        std::string getNome();
        double getNivelDePoder();
        bool getProtege();
        void setCategoria(int pCategoria);
        void setNome(std::string pNome);
        void setNivelDePoder(double pNivelDePoder);
        void setProtege(bool pProtege);
        Superpoder(int pCategoria, double pNivelDePoder, double probabilidadeDeAcerto, std::string pNome, bool pProtege);
};

#endif /* ifndef Superpoder */
