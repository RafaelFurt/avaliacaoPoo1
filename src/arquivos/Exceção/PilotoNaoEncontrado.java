package arquivos.Exceção;

public class PilotoNaoEncontrado extends Exception {
    public PilotoNaoEncontrado(String cpf){
        super("Piloto Não econtrado com o cpf: "+ cpf);
    }
}