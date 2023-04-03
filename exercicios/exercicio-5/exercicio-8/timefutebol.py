class TimeFutebol:

    def __init__(self, vitorias, derrotas, empates, gols_marcados, gols_sofridos, vermelhos, amarelos, nome):
        self._vitorias = vitorias
        self._derrotas = derrotas
        self._empates = empates
        self._gols_marcados = gols_marcados
        self._gols_sofridos = gols_sofridos
        self._amarelos = amarelos
        self._vermelhos = vermelhos
        self._nome = nome

    @property
    def nome(self):
        return self._nome

    @property
    def vitorias(self):
        return self._vitorias

    @property
    def derrotas(self):
        return self._derrotas

    @property
    def empates(self):
        return self._empates

    @property
    def gols_marcados(self):
        return self._gols_marcados

    @property
    def gols_sofridos(self):
        return self._gols_sofridos

    @property
    def amarelos(self):
        return self._amarelos

    @property
    def vermelhos(self):
        return self._vermelhos

    @property
    def pontos(self):
        return (self.vitorias * 3) + self.empates

    @property
    def saldo(self):
        saldo_gols = self.gols_marcados - self.gols_sofridos
        return saldo_gols

    def __repr__(self):
        return '{' + str(self.vitorias) + '}'
