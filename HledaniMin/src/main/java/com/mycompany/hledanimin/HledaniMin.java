package com.mycompany.hledanimin;

import java.util.Random;
import java.util.Scanner;

public class HledaniMin {

    public static void main(String[] args) {
        final int NEODKRYTE_POLE = 0;
        final int MINA = 1;
        final int ODKRYTE_POLE = 2;

        final int RADKY = 2;
        final int SLOUPCE = 2;

        // TODO: Uzivatel muze urcit rozmery hraciho pole
        int[][] hraciPole = new int[RADKY][SLOUPCE];

        Scanner scanner = new Scanner(System.in);
        
        // TODO: Nahodne miny kazde zapnuti hry
        Random random = new Random(1);

        System.out.println("Hledani min - Java verze");
        // TODO: Osetreni na validni vstup (zaporny pocet min, vice min nez je mozno, jiny datovy typ)
        System.out.print("Zadejte pocet min: ");
        int pocetMin = scanner.nextInt();

        for (int i = 0; i < pocetMin;) {
            int yMina = random.nextInt(0, RADKY);
            int xMina = random.nextInt(0, SLOUPCE);

            if (hraciPole[yMina][xMina] != MINA) {
                hraciPole[yMina][xMina] = MINA;
                ++i;
            }
        }

        int body = 0;
        final int POCET_BEZ_MIN = (RADKY * SLOUPCE) - pocetMin;

        while (true) { // Nekonecna herni smycka
            
            // TODO: Vylepsit vypis aby neukazoval miny
            // TODO: X - miny, O - okryta pole, N - neodkryta pole
            for (int[] radky : hraciPole) {
                for (int bunka : radky) {
                    System.out.print(bunka + " ");
                }
                System.out.println();
            }
            System.out.println("Pocet bodu: " + body);

            // TODO: Osetreni na validni vstup (zaporny souradnice, mimo hraci plochu, jiny datovy typ)
            System.out.print("Zadej X souradnici: ");
            int x = scanner.nextInt();

            System.out.print("Zadej Y souradnici: ");
            int y = scanner.nextInt();

            int bunka = hraciPole[y][x];

            switch (bunka) {
                case NEODKRYTE_POLE -> {
                    body++;
                    hraciPole[y][x] = ODKRYTE_POLE;
                    
                    if (body == POCET_BEZ_MIN) {
                        System.out.println("Super, vyhral si!");
                        
                        System.exit(0);
                    }
                }

                case MINA -> {
                    System.out.println("Slapl si na minu, prohral si!");

                    System.exit(0);
                }

                case ODKRYTE_POLE -> System.out.println("Tohle pole uz si vybral.");
            }
        }
    }
}