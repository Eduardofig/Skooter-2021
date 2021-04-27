#include <iostream>
#include "Personagem.h" 

std::string Personagem::getNome()
{
    return this->_nome;
}
std::string Personagem::getNomeVidaReal()
{
    return this->_nomeVidaReal;
}
double Personagem::getTotalPoder()
{
    double totalPoder = 0;
    for(Superpoder poder: this->_poderes) {
        totalPoder += poder.getNivelDePoder();
    }
    return totalPoder;
}
double Personagem::getVida()
{
    return this->vida;
}
bool Personagem::getProtegido()
{
    return this->protegido;
}
void Personagem::setNome(std::string pNome)
{
    this->_nome = pNome;
}
void Personagem::setNomeVidaReal(std::string pNomeVidaReal)
{
    this->_nomeVidaReal = pNomeVidaReal;
}
void Personagem::addPoder(Superpoder pPoder)
{
    this->_poderes.push_back(pPoder);
    this->_map_poderes[pPoder.getNome()] = this->_poderes.size() - 1;
}
void Personagem::setVida(double pVida)
{
    this->vida = pVida;
}
void Personagem::setProtegido(bool pProtegido)
{
    this->protegido = pProtegido;
}
void Personagem::Attack(Personagem *Oponente, std::string nomeDoPoder)
{
    if(this->_map_poderes.find(nomeDoPoder) == this->_map_poderes.end()) {
        std::cout << getNome() << " nao possui o poder " << nomeDoPoder << std::endl;
        return;
    }
    int PowerIndex = this->_map_poderes[nomeDoPoder];
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
