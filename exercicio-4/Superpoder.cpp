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
Superpoder::Superpoder(int pCategoria, double pNivelDePoder, double probabilidadeDeAcerto, std::string pNome)
{
    setCategoria(pCategoria);
    setNome(pNome);
    setNivelDePoder(pNivelDePoder);
    this->probabilidadeDeAcerto = probabilidadeDeAcerto;
}
