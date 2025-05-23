package HttpClient;

import java.io.IOException;
import java.util.Scanner;

public class Operation {

    public static final String USD = "USD";
    public static final String ARS = "ARS";
    public static final String BOB = "BOB";
    public static final String BRL = "BRL";
    public static final String CLP = "CLP";
    public static final String COP = "COP";

    Scanner scanner = new Scanner(System.in);

    public void showOptions() throws IOException, InterruptedException {
        boolean done = true;

        int choice;
        double quantity;

        while (done) {
            System.out.println(
                    "1) Dólar =>> Peso argentino\n" +
                    "2) Peso argentino =>> Dólar\n" +
                    "3) Dólar =>> Real brasileiro\n" +
                    "4) Real brasileiro =>> Dólar\n" +
                    "5) Dólar =>> Peso colombiano\n" +
                    "6) Peso colombiano =>> Dólar\n" +
                    "7) Sair\n" +
                    "Escolha uma opção válida:");


            choice = scanner.nextInt();

//          Visto que a função "scanner.nextInt" não consumirá a "\n" ao final do input do usuário, chamamos a função abaixo.
//          Assim estaremos a descartar a quebra de linha, afinal não atribuímos a lugar nenhum, permitindo que os "scanner.nextLine()" dentro do switch case
//          possam ser considerados
            scanner.nextLine();

            switch (choice) {
                case 1:
                    convertCurrency(USD, ARS);
                    scanner.nextLine();
                    break;
                case 2:
                    convertCurrency(ARS, USD);
                    scanner.nextLine();
                    break;
                case 3:
                    convertCurrency(USD, BRL);
                    scanner.nextLine();
                    break;
                case 4:
                    convertCurrency(BRL, USD);
                    scanner.nextLine();
                    break;
                case 5:
                    convertCurrency(USD, COP);
                    scanner.nextLine();
                    break;
                case 6:
                    convertCurrency(COP, USD);
                    scanner.nextLine();
                    break;
                case 7:
                    System.out.println("Saindo");
                    done = false;
                    break;
                default:
                    System.out.println("Número inválido");
                    scanner.nextLine();
                    break;
            }
        }

    }

    public void convertCurrency(String currency, String currencyToConvert) throws IOException, InterruptedException {

        double quantity;

        System.out.println("Informe a quantia monetária a converter: ");
        quantity = scanner.nextDouble();

        double conversion = new Client().getCurrency(currency, currencyToConvert);

        System.out.println("Convertendo " + quantity + " [" + currency + "] para [" + currencyToConvert + "], o novo valor é de: " + quantity * conversion + "\n");


    }

}
