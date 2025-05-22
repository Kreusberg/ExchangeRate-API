package main;

import HttpClient.Client;
import model.Model;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Model model = new Client().sendRequest("USD");

        Double currency = model.getConversion_rates().get("BRL");

        System.out.println(model.getConversion_rates().get("BRL"));

    }

}
