package br.rocha.felipe.model;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Jogo {

    Scanner scanner = new Scanner(System.in);

    public void iniciarJogo() {


        int [][]jogo = new int[5][5];

        System.out.println("=0=0= --| Campo Minado |-- =0=0=");


        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                jogo[l][c] = '-';
            }
        }

        int quant = 5, pL, pC, bomba = 0;

        while (bomba < quant) {
            pL = ((int) (Math.random() * 5) - 1);
            pC = ((int) (Math.random() * 5) - 1);
            if (jogo[pL][pC] == '-') {
                jogo[pL][pC] = 'O';
                bomba++;
            }
        }

        int total = 5, tentativa = 1, pontos = 0, lin, col;
        boolean bum = false;

        while (tentativa < total || pontos < total * 2) {
            // Mostrar tabuleiro com ?????
            System.out.println("=======================================");
            for (int l = 0; l < 5; l++) {
                for (int c = 0; c < 5; c++) {
                    if (jogo[l][c] == '-' || jogo[l][c] == 'O') {
                        System.out.println("? ");
                    } else {
                        System.out.println(jogo[l][c] + " ");
                    }
                }

            }
            System.out.println("=======================================");
            System.out.println("Faça a sua jogada! Tentativa: " + tentativa );
            do{
                System.out.println("Linha = ");
                lin = scanner.nextInt();
            } while (lin >= 5);
            do{
                System.out.println("Coluna = ");
                col = scanner.nextInt();
            } while (col >= 5);
            if (jogo[lin][col] == 'O'){
                System.out.println("--> TIRO ERRADO! Você acertou uma BOMBA!");
                bum = true;
                jogo[lin][col] = '*';
                break;
            } else if (jogo[lin][col] == '-'){
                System.out.println("--> TIRO CERTO! Parabéns!");
                jogo[lin][col] = 'X';
                tentativa++;
                pontos += 2;

            } else if (jogo[lin][col] == 'X'){
                System.out.println("--> Você já atirou nessa posição! Tente novamente!");
            }

            for(int l = 0; l < 5; l++){
                for(int c = 0; c < 5; c++){
                    System.out.println(jogo[l][c] + " ");
                }

            }
            System.out.println("=======================================");
            if (bum){
                System.out.println("VOCÊ NÃO GANHOU!");
                System.out.println("=======================================");
                System.out.println("GAME OVER!");
                System.out.println("=======================================");
            }else  {
                System.out.println("VITÓRIA! VOCÊ GANHOU!!");
            }
            System.out.println("=======================================");
            System.out.println("Você fez " + pontos + " pontos em " + (tentativa - 1) + " tentativas!");
            System.out.println("=======================================");
        }


        }

    }