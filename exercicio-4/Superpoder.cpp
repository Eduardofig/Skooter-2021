#include<iostream>
#include "Superpoder.h"

int Superpoder::getCategoria()
{
    return this->_categoria;
}
std::string Superpoder::getNome()
{
    return this->_nome;
}
double Superpoder::getNivelDePoder()
{
    return this->_nivelDePoder;
}
bool Superpoder::getProtege()
{
    return this->protege;
}
void Superpoder::setCategoria(int pCategoria)
{
    this->_categoria = pCategoria;
}
void Superpoder::setNome(std::string pNome)
{
    this->_nome = pNome;
}
void Superpoder::setNivelDePoder(double pNivelDePoder)
{
    this->_nivelDePoder = pNivelDePoder;
}
void Superpoder::setProtege(bool pProtege) 
{
    this->protege = pProtege;
}
Superpoder::Superpoder(int pCategoria, double pNivelDePoder, double probabilidadeDeAcerto, std::string pNome, bool pProtege)
{
    setCategoria(pCategoria);
    setNome(pNome);
    setNivelDePoder(pNivelDePoder);
    setProtege(pProtege);
    this->probabilidadeDeAcerto = probabilidadeDeAcerto;
}
