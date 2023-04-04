#include <iostream>
#include "Personagem.h" 
//Getters e setters
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
void Personagem::Attack(Personagem *Oponente, std::string nomeDoPoder, double intensidade)
{
    //Caso o Personagem nao possua o poder Passado como parametro
    if(this->_map_poderes.find(nomeDoPoder) == this->_map_poderes.end()) {
        std::cout << getNome() << " nao possui o poder " << nomeDoPoder << std::endl;
        return;
    }
    int PowerIndex = this->_map_poderes[nomeDoPoder];
    //Caso o poder seja de categoria 1(ataque)
    if(this->_poderes[PowerIndex].getCategoria() == 1) {
        std::cout << getNome() << " ataca " << Oponente->getNome() << " com " << this->_poderes[PowerIndex].getNome() << std::endl;
        //Caso o personagem tente atacar um oponente que esteja protegido
        if(Oponente->getProtegido()) {
            std::cout << Oponente->getNome() << " esta protegido, o ataque nao funciona" << std::endl;
            Oponente->setProtegido(false);
            return;
        }
    //Caso o poder seja de categoria 2(defensivo)
    } else {
        std::cout << getNome() << " usa " << this->_poderes[PowerIndex].getNome() << std::endl;
    }
    //Teste de probabilidade para ver se o persongaem consegue utilizar o poder
    if((double)rand()/RAND_MAX < this->_poderes[PowerIndex].probabilidadeDeAcerto) {
        if(this->_poderes[PowerIndex].getCategoria() == 2) {
            this->protegido = true;
            std::cout << this->_poderes[PowerIndex].getNome() << " ativado, " << getNome() << " esta protegido"<< std::endl;
            return;
        }
        Oponente->setVida(Oponente->getVida() > this->_poderes[PowerIndex].getNivelDePoder()*intensidade? Oponente->getVida() - this->_poderes[PowerIndex].getNivelDePoder(): 0);
        std::cout << getNome() << " acerta" << std::endl;
        std::cout << Oponente->getNome() << " perde " << this->_poderes[PowerIndex].getNivelDePoder()*intensidade << " pontos de vida" << std::endl;
        return;
    } 
    printf("%s %s\n", getNome().c_str(), this->_poderes[PowerIndex].getCategoria() == 1? "erra": "falha");
}