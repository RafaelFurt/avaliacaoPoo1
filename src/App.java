
import java.util.Scanner;
import arquivos.Pilotos;

public class App {
    private static int TAMANHO_INICIAL = 2;
    private static Scanner scanner = new Scanner(System.in);
    private static Pilotos[] _Pilotos = new Pilotos[TAMANHO_INICIAL];
    private static int _NumeroPiloto = 0;

    public static void main(String[] args) throws Exception {
        boolean continuarExecutando = true;

        do {
            try {
                visualizarMenu();
                int opcao = lerOpcao();
                continuarExecutando = executarOpcao(opcao);
            } catch (Exception e) {
                System.out.println("Ocorreu um erro durante o Processo: " + e.getMessage());
                continuarExecutando = true;
            }
        } while (continuarExecutando);
    }
    private static boolean executarOpcao(int opcao) throws Exception {
        switch (opcao) {
            case 1: {
                cadastrarPiloto();
                break;
            }
            case 2:{
                listarPilotos();
                break;
            }
            /*case 3:{
                consultarcpf();
                break;
            }*/
            case 4:{
                aumentarArmazenamento();
                break;
            }
            case 5: {
                System.out.println("GoodBye...");
                return false;
            }
            default: {
                System.out.println("Não disponível");
                break;
            }
        }

        return true;
    }

    private static void cadastrarPiloto() {
    if (_NumeroPiloto == _Pilotos.length){
        System.out.println("Sem Espaço de armazenamento");
        }
    else{
        System.out.println("Insira o nome do piloto: ");
        String nome = scanner.nextLine();
        System.out.println("Insira o CPF do piloto: ");
        String cpf = scanner.nextLine();
        
    Pilotos piloto = new Pilotos(nome, cpf);
    NovaListaDePiloto(piloto);}
    }
    private static void NovaListaDePiloto(Pilotos piloto){
        if(_NumeroPiloto == _Pilotos.length){
            Pilotos[] novaLista = new Pilotos[_Pilotos.length * 2];
            
            for (int i = 0; i < _Pilotos.length; i++) {
                novaLista[i] = _Pilotos[i];
            }
            _Pilotos = novaLista;
        }
        _Pilotos[_NumeroPiloto] = piloto;
        _NumeroPiloto++;
        }   

    private static void listarPilotos() {   
        if (_NumeroPiloto == 0){
            System.out.println("Não há pilotos cadastrados para exibir.");
        }else{
            System.out.println("Lista de motoristas cadastrados:");
            for (int i = 0; i < _NumeroPiloto; i++) {
            System.out.println(_Pilotos[i]);
            }}
    }
    private static void aumentarArmazenamento(){
            System.out.println("Informe a nova capacidade de armazenamento.");
            TAMANHO_INICIAL= scanner.nextInt(); 
            System.out.println("Capacidade aumentada com sucesso.");
    }

    private static void visualizarMenu(){
            System.out.println(" ---------------------------");
            System.out.println("         ### MENU  ###");
            System.out.println(" ---------------------------");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("5 - Sair");
    }    
    private static boolean validarMenu(int opcao) {
        return (opcao >= 1  && opcao <= 5);
    }
    private static int lerOpcao() {
        int opcao = 0;
        do {
            System.out.println("Selecione a opção desejada: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                if (!validarMenu(opcao)) {
                    System.out.println("Opção inválida!");
                }
            }catch ( Exception e ) {
                System.out.println("Opção inválida!");
                scanner.nextLine();
            }
        } while (!validarMenu(opcao));

        return opcao;
    }      
}