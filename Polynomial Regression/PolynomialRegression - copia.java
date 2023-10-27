package com.company;
import java.util.ArrayList;

public class PolynomialRegression {

    public static ArrayList<DataSet> Datos = new ArrayList<>();

    public static void main(String[] args) {


        Datos = DataSet.LeerDatos6();

        double matriz[][];
        matriz = polynomialRegression();


        System.out.println("La ecuación de la regresión cuadrática es: Y = " + matriz[0][0] + "*X^2 + " + matriz[1][0] + "*X + " + matriz[2][0] + "\n");

        //Predicciones
        System.out.println("Predicciones= ");

        System.out.println("\nSimulacion 1: ");
        double x = 110;
        System.out.println("Cuando X vale 110: " + (matriz[0][0] * x * x + matriz[1][0] * x + matriz[2][0]));

        System.out.println("\nSimulacion 2: ");
        x = 120;
        System.out.println("Cuando X vale 110: " + (matriz[0][0] * x * x + matriz[1][0] * x + matriz[2][0]));

        System.out.println("\nSimulacion 3: ");
        x = 130;
        System.out.println("Cuando X vale 110: " + (matriz[0][0] * x * x + matriz[1][0] * x + matriz[2][0]));

        System.out.println("\nSimulacion 4: ");
        x = 140;
        System.out.println("Cuando X vale 110: " + (matriz[0][0] * x * x + matriz[1][0] * x + matriz[2][0]));

        System.out.println("\nSimulacion 5: ");
        x = 150;
        System.out.println("Cuando X vale 110: " + (matriz[0][0] * x * x + matriz[1][0] * x + matriz[2][0]));


    }


    public static double[][] polynomialRegression() {


        int columnas = 3;
        double determinante;
        int n = Datos.size();

        double resultados1[][] = new double[columnas][columnas + 1];
        double matrizsumax[] = new double[2 * columnas];
        double matrizsumay[] = new double[columnas];

        for (int i = 0; i < Datos.size(); i++) {
            double x = Datos.get(i).getX();
            double y = Datos.get(i).getY();

            for (int j = 0; j < 2 * columnas; j++) {
                matrizsumax[j] += Math.pow(x, j);
            }

            for (int j = 0; j < columnas; j++) {
                matrizsumay[j] += Math.pow(x, j) * y;

            }
        }

        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultados1[i][j] = matrizsumax[i + j];
            }
            resultados1[i][columnas] = matrizsumay[i];
        }


        //Separar el resultado de la matriz Resultado
        double matrizY[][] = new double[resultados1.length][1];
        for (int i = 0; i < resultados1.length; i++) {
            for (int j = 0; j < 1; j++) {
                matrizY[i][0] = resultados1[i][j + resultados1[0].length - 1];

            }
        }

        double matrizX[][] = new double[resultados1.length][resultados1[0].length - 1];
        for (int i = 0; i < resultados1.length; i++) {
            for (int j = 0; j < resultados1.length; j++) {
                matrizX[i][j] = resultados1[i][j];

            }
        }


        double[][] transpuestaX = new double[matrizX[0].length][matrizX.length];

        for (int i = 0; i < matrizX.length; i++) {
            for (int j = 0; j < matrizX[0].length; j++) {
                transpuestaX[j][i] = matrizX[i][j];
            }
        }

        double[][] transpuestaPorX = multiplicarMatrices(transpuestaX, matrizX);

        determinante = Determinante(transpuestaPorX);

        if (determinante != 0) {


            //Crear una matriz 1 y 0 y juntara con la matriz a la que quiero sacarle transpuesta
            double matriz10[][] = new double[transpuestaPorX.length][transpuestaPorX.length];


            for (int i = 0; i < transpuestaPorX.length; i++) {
                for (int j = 0; j < transpuestaPorX.length; j++) {
                    if (i == j) {
                        matriz10[i][j] = 1.0;
                    } else {
                        matriz10[i][j] = 0;
                    }
                }
            }
            //imprimirMatriz(matriz10);

            double matrizAumentada[][] = new double[transpuestaPorX.length][transpuestaPorX.length * 2];
            for (int i = 0; i < transpuestaPorX.length; i++) {
                for (int j = 0; j < transpuestaPorX.length * 2; j++) {
                    if (j <= transpuestaPorX.length - 1) {
                        matrizAumentada[i][j] = transpuestaPorX[i][j];
                    } else {
                        for (int k = 0; k < matriz10.length; k++) {

                            matrizAumentada[i][j] = matriz10[i][k];
                            j++;
                        }

                    }
                }
            }
            //imprimirMatriz(matrizAumentada);

            //Crear el resultado con la matriz Aumentada
            for (int i = 0; i < matrizAumentada.length; i++) {
                double pivote = matrizAumentada[i][i];
                for (int j = 0; j < matrizAumentada.length * 2; j++) {
                    matrizAumentada[i][j] /= pivote;
                }

                for (int k = 0; k < matrizAumentada.length; k++) {
                    if (k != i) {
                        double cofactor = matrizAumentada[k][i];
                        for (int j = 0; j < matrizAumentada.length * 2; j++) {
                            matrizAumentada[k][j] -= cofactor * matrizAumentada[i][j];
                        }
                    }
                }
            }

            //Separar el resultado con la matriz Aumentada
            double matrizInversa[][] = new double[transpuestaPorX.length][transpuestaPorX.length];
            for (int i = 0; i < transpuestaPorX.length; i++) {
                for (int j = 0; j < transpuestaPorX.length; j++) {
                    matrizInversa[i][j] = matrizAumentada[i][j + transpuestaPorX.length];
                }
            }
            //imprimirMatriz(matrizInversa);

            double[][] XTxY;
            XTxY = multiplicarMatrices(transpuestaX, matrizY);
            //imprimirMatriz(XTxY);

            double[][] resultados;
            resultados = multiplicarMatrices(matrizInversa, XTxY);


            return resultados;
        } else {
            throw new IllegalArgumentException("la determinante de la matriz es 0.");
        }


    }

    public static double[][] multiplicarMatrices(double[][] matrizA, double[][] matrizB) {
        int filasA = matrizA.length;
        int columnasA = matrizA[0].length;
        int filasB = matrizB.length;
        int columnasB = matrizB[0].length;

        if (columnasA != filasB) {
            throw new IllegalArgumentException("Las dimensiones de las matrices no son compatibles para la multiplicación.");
        }

        double[][] resultado = new double[filasA][columnasB];

        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                double suma = 0;
                for (int k = 0; k < columnasA; k++) {
                    suma += matrizA[i][k] * matrizB[k][j];
                }
                resultado[i][j] = suma;
            }
        }

        return resultado;
    }

    public static double Determinante(double[][] matrizA) {
        int filasA = matrizA.length;
        int columnasA = matrizA[0].length;

        if (filasA != columnasA) {
            throw new IllegalArgumentException("Las dimensiones de las matriz no son compatibles para sacar la transpuesta.");
        } else if (filasA == 2) {
            return matrizA[0][0] * matrizA[1][1] - matrizA[0][1] * matrizA[1][0];
        } else {
            double operacion = 0;


            for (int i = 0; i < filasA; i++) {
                double[][] matrizcompuesta = new double[matrizA.length - 1][matrizA.length - 1];
                for (int j = 0; j < filasA; j++) {
                    if (j != i) {
                        for (int k = 1; k < filasA; k++) {
                            int columna = -1;
                            if (j != i) {
                                columna = (j < i) ? j : j - 1;
                            }
                            matrizcompuesta[columna][k - 1] = matrizA[j][k];
                        }
                    }

                }
                if (i % 2 == 0) {
                    operacion += matrizA[i][0] * Determinante(matrizcompuesta);
                } else {
                    operacion -= matrizA[i][0] * Determinante(matrizcompuesta);
                }
            }
            return operacion;
        }
    }


    public static void imprimirMatriz(double[][] matriz) {
        for (double[] doubles : matriz) {
            for (int j = 0; j < doubles.length; j++) {
                System.out.printf("%.12f\t", doubles[j]);
            }
            System.out.println();
        }
    }


}