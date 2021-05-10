from timefutebol import TimeFutebol
from operator import itemgetter, attrgetter
import random

def compare(time1, time2):
    if(time1.pontos != time2.pontos):
        if(time1.pontos > time2.pontos):
            return 1
        else:
            return -1
    elif(time1.vitorias != time2.vitorias):
        if(time1.vitorias > time2.vitorias):
            return 1
        else:
            return -1
    elif(time1.saldo != time2.saldo):
        if(time1.saldo > time1.saldo):
            return 1
        else:
            return -1
    elif(time1.gols_marcados != time2.gols_marcados):
        if(time1.gols_marcados > time2.gols_marcados):
            return 1
        else:
            return -1
    elif(time1.vermelhos != time2.vermelhos):
        if(time1.vermelhos > time2.vermelhos):
            return -1
        else:
            return 1
    elif(time1.amarelos != time2.amarelos):
        if(time1.amarelos > time2.amarelos):
            return -1
        else:
            return 1
    else:
        return random.randint(-1,1)

if __name__ == '__main__':


    timeA = TimeFutebol(13,5,6,38,12,1,8, 'timea')
    timeB = TimeFutebol(13,5,6,38,12,0,8, 'timeb')
    timeC = TimeFutebol(13,5,6,38,12,0,7, 'timec')
    timeD = TimeFutebol(13,5,6,38,13,0,7, 'timed')
    timeE = TimeFutebol(13,5,6,35,13,0,7, 'timee')
    timeF = TimeFutebol(13,5,6,35,13,0,7, 'timef')
    timeG = TimeFutebol(13,5,6,38,12,1,8, 'timeg')
    timeH = TimeFutebol(8,10,6,38,12,1,8, 'timeh')
    timeI = TimeFutebol(8,11,5,38,12,1,8, 'timei')
    timeJ = TimeFutebol(7,11,6,38,12,1,8, 'timej')
    timeK = TimeFutebol(7,11,6,28,12,1,8, 'timek')
    timeL = TimeFutebol(7,11,6,22,12,1,8, 'timel')
    timeM = TimeFutebol(7,11,6,28,12,1,8, 'timem')
    timeN = TimeFutebol(5,13,6,28,12,1,8, 'timen')
    timeO = TimeFutebol(5,13,6,19,12,1,8, 'timeo')
    timeP = TimeFutebol(5,13,6,11,18,1,8, 'timep')
    timeQ = TimeFutebol(3,13,8,11,22,1,8, 'timeq')
    timeR = TimeFutebol(3,13,8,11,22,1,8, 'timer')
    timeS = TimeFutebol(3,13,8,11,22,5,8, 'times')
    timeT = TimeFutebol(3,13,8,11,22,5,16, 'timet')
    timeU = TimeFutebol(3,13,8,11,22,5,16, 'timeu')
    timeV = TimeFutebol(2,14,8,11,22,5,16, 'timev')
    timeX = TimeFutebol(14,9,1,43,22,5,12, 'timex')
    timeW = TimeFutebol(14,8,2,43,22,5,12, 'timew')
    timeY = TimeFutebol(14,9,1,43,22,5,12, 'timey')
    timeZ = TimeFutebol(18,0,6,39,22,5,12, 'timez')

    campeonato = [timeA, timeB, timeC, timeD, timeE, timeF, timeG, timeH, timeI, timeJ, timeK, timeL, timeM, timeN, timeO, timeP, timeQ, timeR, timeS, timeT, timeU, timeV, timeX, timeW, timeY, timeZ]

    campeonato.sort(key = lambda x: (-x.pontos, -x.vitorias, -x.saldo, -x.gols_marcados, x.vermelhos, x.amarelos))


    for time in campeonato:
        print(time.nome, end=' ')
        print(time.pontos)
