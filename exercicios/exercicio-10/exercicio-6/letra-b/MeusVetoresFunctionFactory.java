public class MeusVetoresFunctionFactory {
    public MeusVetoresFunction fabricarFuncao(String funcao) {
        if(funcao.equals("interseccao")) {
            return new MeusVetoresInterseccao();
        } 
        
        if(funcao.equals("uniao")) {
            return new MeusVetoresUniao();
        }

        //funcao == "diferenca"
        return new MeusVetoresDiferenca();
    }
}
