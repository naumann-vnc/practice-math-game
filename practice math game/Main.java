import java.util.concurrent.ThreadLocalRandom;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    static void clearConsole() throws IOException, InterruptedException {
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            Runtime.getRuntime().exec("clear");
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Quantas vezes deseja jogar?");
        Scanner scanVezes = new Scanner(System.in);
        int vezesJogadas = scanVezes.nextInt();

        clearConsole();

        String[] operacao = new String[] { "+", "-", "*", "/" };

        int acertos = 0;
        int erros = 0;

        for (int i = 0; i < vezesJogadas; i++) {

            System.out.println("Digite o resultado do calculo:");

            List<String> strList = Arrays.asList(operacao);
            Collections.shuffle(strList);
            operacao = strList.toArray(new String[strList.size()]);

            int randomNum1 = 1 + (int) (Math.random() * 10);
            int randomNum2 = ThreadLocalRandom.current().nextInt(1, randomNum1 + 1);

            while (randomNum1 % randomNum2 != 0 && Arrays.asList(operacao[0]).contains("/")) {
                randomNum2 = ThreadLocalRandom.current().nextInt(1, randomNum1 + 1);
                // System.out.println("catchau");
                clearConsole();
            }

            System.out.print(randomNum1 + " " + operacao[0] + " " + randomNum2 + "=");

            Scanner scanner = new Scanner(System.in);
            int playerInput = scanner.nextInt();

            if (Arrays.asList(operacao[0]).contains("+")) {
                if (playerInput == randomNum1 + randomNum2) {
                    // System.out.println("acerto");
                    acertos += 1;
                } else {
                    // System.out.println("erro");
                    erros += 1;
                }
            }
            if (Arrays.asList(operacao[0]).contains("-")) {
                if (playerInput == randomNum1 - randomNum2) {
                    // System.out.println("acerto");
                    acertos += 1;
                } else {
                    // System.out.println("erro");
                    erros += 1;
                }
            }
            if (Arrays.asList(operacao[0]).contains("*")) {
                if (playerInput == randomNum1 * randomNum2) {
                    // System.out.println("acerto");
                    acertos += 1;
                } else {
                    // System.out.println("erro");
                    erros += 1;
                }
            }
            if (Arrays.asList(operacao[0]).contains("/")) {
                if (playerInput == randomNum1 / randomNum2) {
                    // System.out.println("acerto");
                    acertos += 1;
                } else {
                    // System.out.println("erro");
                    erros += 1;
                }
            }
            clearConsole();
        }
        clearConsole();
        System.out.println(
                "Relatorio:\nAcertos: " + acertos + "\nErros: " + erros + "\n" + vezesJogadas + " total de tentativas");
    }
}