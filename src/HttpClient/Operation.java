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
                    "1) Dólar (USD) =>> Peso argentino (ARS)\n" +
                    "2) Peso argentino (ARS) =>> Real brasileiro (BRL)\n" +
                    "3) Real brasileiro (BRL) =>> Peso colombiano (COP)\n" +
                    "4) Peso colombiano (COP) =>> Peso boliviano (BOB)\n" +
                    "5) Peso boliviano (BOB) =>> Peso chileno (CLP)\n" +
                    "6) Peso chileno (CLP) =>> Dólar (USD)\n" +
                    "7) Dólar (USD) =>> Real brasileiro (BRL)\n" +
                    "8) Peso colombiano (COP) =>> Dólar (USD)\n" +
                    "9) Sair\n" +
                    "Escolha uma opção válida:");


            choice = scanner.nextInt();

//          Visto que a função "scanner.nextInt" não consumirá a "\n" ao final do input do usuário, chamamos a função abaixo.
//          Assim estaremos a descartar a quebra de linha, afinal não atribuímos a lugar nenhum, permitindo que os "scanner.nextLine()" dentro do switch case
//          possam ser considerados
            scanner.nextLine();

            switch (choice) {
                case 1:
                    convertCurrency(USD, ARS); // Dólar => Peso argentino
                    scanner.nextLine();
                    break;
                case 2:
                    convertCurrency(ARS, BRL); // Peso argentino => Real brasileiro
                    scanner.nextLine();
                    break;
                case 3:
                    convertCurrency(BRL, COP); // Real brasileiro => Peso colombiano
                    scanner.nextLine();
                    break;
                case 4:
                    convertCurrency(COP, BOB); // Peso colombiano => Peso boliviano
                    scanner.nextLine();
                    break;
                case 5:
                    convertCurrency(BOB, CLP); // Peso boliviano => Peso chileno
                    scanner.nextLine();
                    break;
                case 6:
                    convertCurrency(CLP, USD); // Peso chileno => Dólar
                    scanner.nextLine();
                    break;
                case 7:
                    convertCurrency(USD, BRL); // Dólar => Real brasileiro
                    scanner.nextLine();
                    break;
                case 8:
                    convertCurrency(COP, USD); // Peso colombiano => Dólar
                    scanner.nextLine();
                    break;
                case 9:
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
