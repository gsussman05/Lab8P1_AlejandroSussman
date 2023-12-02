/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab8p1_alejandrosussman;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Gabriel
 */
public class Lab8P1_AlejandroSussman {

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("1. Game of Life");
        System.out.println("2. Salirse");
        int opcion = sc.nextInt();
        int[][] matrix;
        int[][] matrixg;
        while (opcion != 2) {
            switch (opcion) {
                case 1:
                    
                    System.out.print("Ingrese el numero de rondas que desea: ");
                    int rondas = sc.nextInt();
                    matrix = createRand();
                    System.out.println("Coordenadas del tablero inicial: ");
                    ArrayList<String> Coordenadas = placement(matrix);
                    
                    for (String coordenada : Coordenadas) {
                        System.out.print(coordenada);
                    }
                    System.out.println("");
                    print(matrix);

                    for (int i = 0; i < rondas; i++) {
                        System.out.println("Esta en la ronda: "+(i+1));
                    

                    matrixg = nextGen(matrix);
                    ArrayList<String> Coordenadas2 = placement(matrixg);
                    for (String coordenada : Coordenadas2) {
                        System.out.print(coordenada);
                    }
                    System.out.println("");
                    print(matrixg);
                    
                    matrix=matrixg;
                    }
                    break;

                default:
                    System.out.println("Ingrese una opcion valida");
            }
            System.out.println("1 Game of life ");
            System.out.println("2. Salirse");
            opcion = sc.nextInt();
        }
        System.out.println("Saliendo ");

    }

    public static int[][] nextGen(int[][] matrix_x) {
        int[][] temp = matrix_x;
        for (int i = 0; i < matrix_x.length; i++) {
            for (int j = 0; j < matrix_x.length; j++) {
                int cont = 0;
                int cont2 = 0;
                if (i - 1 > 0) {
                    if (j - 1 > 0) {
                        if (j + 1 <= 9) {
                            if (i + 1 <= 9) {

                                if (matrix_x[i][j] == 1) {
                                    if (matrix_x[i - 1][j - 1] == 1) {
                                        cont++;
                                    } else if ((matrix_x[i + 1][j + 1] == 1)) {
                                        cont++;
                                    } else if ((matrix_x[i + 1][j] == 1)) {
                                        cont++;
                                    } else if ((matrix_x[i][j - 1] == 1)) {
                                        cont++;
                                    } else if ((matrix_x[i - 1][j] == 1)) {
                                        cont++;
                                    } else if ((matrix_x[i - 1][j + 1] == 1)) {
                                        cont++;
                                    } else if ((matrix_x[i + 1][j - 1] == 1)) {
                                        cont++;
                                    } else if ((matrix_x[i][j + 1] == 1)) {
                                        cont++;
                                    }

                                    if (cont > 2) {
                                        matrix_x[i][j] = 0;
                                    } else if (cont == 2) {
                                        matrix_x[i][j] = 1;
                                    } else if (cont < 2) {
                                        matrix_x[i][j] = 0;
                                    } else {
                                        continue;
                                    }

                                } else if (matrix_x[i][j] == 0) {
                                    if (matrix_x[i - 1][j - 1] == 1) {
                                        cont2++;
                                    } else if ((matrix_x[i + 1][j + 1] == 1)) {
                                        cont2++;
                                    } else if ((matrix_x[i + 1][j] == 1)) {
                                        cont2++;
                                    } else if ((matrix_x[i][j - 1] == 1)) {
                                        cont2++;
                                    } else if ((matrix_x[i - 1][j] == 1)) {
                                        cont2++;
                                    } else if ((matrix_x[i - 1][j + 1] == 1)) {
                                        cont2++;
                                    } else if ((matrix_x[i + 1][j - 1] == 1)) {
                                        cont2++;
                                    } else if ((matrix_x[i][j + 1] == 1)) {
                                        cont2++;
                                    }
                                    if (cont2 == 3) {
                                        matrix_x[i][j] = 1;
                                    } else {
                                        continue;
                                    }
                                }

                            }// 
                        }
                    }
                }

            }// 
        }
        return temp;
    }

    public static ArrayList<String> placement(int[][] matrix) {
        ArrayList<String> Coordenadas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (matrix[i][j] == 1) {
                    String coord = "(" + i + ":" + j + ") ";
                    Coordenadas.add(coord);
                }
            }
        }

        return Coordenadas;
    }

    public static int[][] llenando() {
        int[][] temp = new int[0][0];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                temp[i][j] = rand.nextInt(2);
                if (i == 0 || j == 0 || i == 9 || j == 9) {
                    temp[i][j] = 0;
                }
            }
        }
        return temp;
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }

    }

    public static int[][] createRand() {
        int[][] temp = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0 || i == 9 || j == 0 || j == 9) {
                    temp[i][j] = 0;
                } else {
                    temp[i][j] = rand.nextInt(2);
                }
            }
        }
        return temp;
    }

    public static int[][] MatrixX() {
        int[][] temp = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                temp[i][j] = 0;

            }
        }
        return temp;
    }

}
    
