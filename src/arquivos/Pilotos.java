package arquivos;
public class Pilotos {
    private String _NomePiloto;
    private String _CpfPiloto;
    public Pilotos(String nome,String cpf ){
        _NomePiloto = nome;
        _CpfPiloto = cpf;
    }
    public String getnome(){
        return _NomePiloto;
    }
    public String getcpf(){
        return _CpfPiloto;
    }
    @Override
    public String toString(){
        return "[Nome: "+ _NomePiloto + ", CPF: "+ _CpfPiloto +"]";
    }
}
