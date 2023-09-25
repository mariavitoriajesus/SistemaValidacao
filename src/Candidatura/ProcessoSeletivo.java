package Candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos ={"ANA", "FELIPE", "AMANDA", "MARCIA", "AGATHA"};
        for (String candidato: candidatos){
            entrarContato(candidato);
        }

        imprimir();
    }
    static void entrarContato(String candidado){
        int tentivasRalizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando =!continuarTentando;
            if (continuarTentando){
                tentivasRalizadas++;
            } else {
                System.out.println("CONTATO REALIZADO COM SUCESSO!");
            }
        } while (continuarTentando && tentivasRalizadas < 3);

        if (atendeu){
            System.out.println("CONSEGUIMOS CONTATO COM " + candidado+ " APÓS "+ tentivasRalizadas);
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM O " + candidado);
        }
    }
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimir(){
        String [] candidatos ={"ANA", "FELIPE", "AMANDA", "MARCIA", "AGATHA"};
        System.out.println("Lista de candidatos selecionados: ");
        for (String candidato: candidatos){
            System.out.println("O candidato selesionado foi " + candidato);
        }
    }

    static void selecaoCandidatos(){
        String [] candidatos ={"ANA", "FELIPE", "AMANDA", "MARCIA", "AGATHA", "TADEU", "JUDAS", "CRISTIANE", "JESUITA"};

        int candidatosSelecioados =0;
        int candidatoAtual =0;
        double salarioBase= 2000.0;
        while (candidatosSelecioados < 5 && candidatoAtual < candidatos.length ){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou esta valor de salário: " + salarioPretendido);
            if (salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecioados++;
            }
            candidatoAtual++;
        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double base = 2000.0;
        if(base > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO!");
        } else if (base == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
