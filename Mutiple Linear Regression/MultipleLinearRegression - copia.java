package com.company;


import java.util.ArrayList;

public class MultipleLinearRegression {

    public static ArrayList<DataSet> Datos= new ArrayList<>();


    public static void main(String[] args) {

        //Elige cual de los dos data set deseas, solo comenta el otro
        Datos=DataSet.LeerDatos3();
        //Datos=DataSet.LeerDatos4();


        multipleLinearRegression();
    }

    public static void multipleLinearRegression() {

        int filas = Datos.size();


        DataSet.LeerDatos3();
        //DataSet.LeerDatos4();

        double determinante;
        double simulacion1, simulacion2, simulacion3, simulacion4, simulacion5;
        double b0, b1, b2, b3;

        // Matriz para las X
        double[][] matrizX = new double[filas][4];
        // Matriz para las Y
        double[][] matrizY = new double[filas][1];

        for (int i = 0; i < filas; i++) {
            DataSet dato = Datos.get(i);
            matrizX[i][0] = dato.X;
            matrizX[i][1] = dato.X2;
            matrizX[i][2] = dato.X3;

            //En caso de querer usar el .LeerDatos4() Se debe comentar la siguiente linea
            matrizX[i][3] = dato.X4;

            matrizY[i][0] = dato.Y;
        }

                                //imprimirMatriz(matrizX);
                                //imprimirMatriz(matrizY);

        //Sacar la transpuesta X
        double[][] transpuestaX = new double[matrizX[0].length][matrizX.length];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < matrizX[0].length; j++) {
                transpuestaX[j][i] = matrizX[i][j];
            }
        }
                                //imprimirMatriz(transpuestaX);

        // Multiplicar la matriz transpuestaX por la matriz matrizX
        double[][] transpuestaPorX = multiplicarMatrices(transpuestaX, matrizX);
                                //imprimirMatriz(transpuestaPorX);

                                //imprimirMatriz(transpuestaPorX);

        determinante= Determinante(transpuestaPorX);

        //double[][] matrizAdjunta ;
        //matrizAdjunta= MatrizAdjunta(transpuestaPorX);

        //double[][] matrizInversa ;
        //matrizInversa=dividirMatrices(matrizAdjunta, determinante);
                                //imprimirMatriz(matrizInversa);

         if(determinante!=0) {


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
                                        //imprimirMatriz(resultados);


             if (resultados.length == 4) {

                 b0 = resultados[0][0];
                 b1 = resultados[1][0];
                 b2 = resultados[2][0];
                 b3 = resultados[3][0];

                 //Ecuacion de regresion
                 System.out.println("Ecuación de la regresión lineal multiple: y = " + resultados[0][0] + " + " + resultados[1][0] + "X1 + " + resultados[2][0] + "X2 + " + resultados[3][0] + "X3 ");


                 simulacion1 = b0 + b1 * 165349.2 + b2 * 136897.8 + b3 * 471784.1;
                 System.out.println("Simulacion cuando \nX1= " + 165349.2 + "\nX2= " + 136897.8 + "\nX3= " + 471784.1 + "\nResultado de Y=" + simulacion1);


                 simulacion2 = b0 + b1 * 114523.61 + b2 * 122616.84 + b3 * 261776.23;
                 System.out.println("Simulacion cuando \nX1= " + 114523.61 + "\nX2= " + 122616.84 + "\nX3= " + 261776.23 + "\nResultado de Y=" + simulacion2);


                 simulacion3 = b0 + b1 * 44069.95 + b2 * 51283.14 + b3 * 197029.42;
                 System.out.println("Simulacion cuando \nX1= " + 44069.95 + "\nX2= " + 51283.14 + "\nX3= " + 197029.42 + "\nResultado de Y=" + simulacion3);

                 simulacion4 = b0 + b1 * 40069.95 + b2 * 50283.14 + b3 * 207029.42;
                 System.out.println("Simulacion cuando \nX1= " + 40069.95 + "\nX2= " + 50283.14 + "\nX3= " + 207029.42 + "\nResultado de Y=" + simulacion4);

                 simulacion5 = b0 + b1 * 64069.95 + b2 * 61283.14 + b3 * 180029.42;
                 System.out.println("Simulacion cuando \nX1= " + 64069.95 + "\nX2= " + 61283.14 + "\nX3= " + 180029.42 + "\nResultado de Y=" + simulacion5);
             } else {

                 b0 = resultados[0][0];
                 b1 = resultados[1][0];
                 b2 = resultados[2][0];

                 //Ecuacion de regresion
                 System.out.println("Ecuación de la regresión lineal multiple: y = " + resultados[0][0] + " + " + resultados[1][0] + "X1 + " + resultados[2][0] + "X2");


                 simulacion1 = b0 + b1 * 41.9 + b2 * 29.1;
                 System.out.println("Simulacion cuando \nX1= " + 41.9 + "\nX2= " + 29.1 + "\nResultado de Y=" + simulacion1);


                 simulacion2 = b0 + b1 * 50 + b2 * 30;
                 System.out.println("Simulacion cuando \nX1= " + 50 + "\nX2= " + 30 + "\nResultado de Y=" + simulacion2);


                 simulacion3 = b0 + b1 * 80 + b2 * 33;
                 System.out.println("Simulacion cuando \nX1= " + 80 + "\nX2= " + 33 + "\nResultado de Y=" + simulacion3);

                 simulacion4 = b0 + b1 * 70 + b2 * 25;
                 System.out.println("Simulacion cuando \nX1= " + 70 + "\nX2= " + 25 + "\nResultado de Y=" + simulacion4);

                 simulacion5 = b0 + b1 * 75 + b2 * 27;
                 System.out.println("Simulacion cuando \nX1= " + 75 + "\nX2= " + 27 + "\nResultado de Y=" + simulacion5);
             }
         }
         else{
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
        }
        else if(filasA == 2){
            return matrizA[0][0]*matrizA[1][1]-matrizA[0][1]*matrizA[1][0];
        }
        else{
            double operacion=0;


            for(int i=0; i<filasA; i++) {
                double[][] matrizcompuesta= new double[matrizA.length-1][matrizA.length-1];
                for(int j=0; j<filasA; j++){
                    if(j!=i){
                        for (int k=1; k<filasA; k++){
                            int columna=-1;
                            if(j!=i){
                                columna = (j < i) ? j : j - 1;
                            }

                            matrizcompuesta[columna][k-1]=matrizA[j][k];
                        }
                    }

                }
                if(i%2==0){
                    operacion+=matrizA[i][0] * Determinante(matrizcompuesta);
                }
                else {
                    operacion-=matrizA[i][0] * Determinante(matrizcompuesta);
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


    public static double[][] dividirMatrices(double[][] matriz, Double divisor) {

        double[][] resultado= new double[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                resultado[i][j]=matriz[i][j]/divisor;

            }

        }

        return resultado;
    }


    public static double[][] MatrizAdjunta(double[][] matrizA) {
        int filasA = matrizA.length;
        int columnasA = matrizA[0].length;

        if (filasA != columnasA) {
            throw new IllegalArgumentException("La matriz no es cuadrada, no se puede calcular la matriz adjunta.");
        }

        double[][] matrizAdjunta = new double[filasA][filasA];

        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < filasA; j++) {
                double[][] matrizMenor = new double[filasA - 1][filasA - 1];

                for (int k = 0; k < filasA; k++) {
                    for (int l = 0; l < filasA; l++) {
                        if (k != i && l != j) {
                            int filaMenor = (k < i) ? k : k - 1;
                            int columnaMenor = (l < j) ? l : l - 1;
                            matrizMenor[filaMenor][columnaMenor] = matrizA[k][l];
                        }
                    }
                }

                double cofactor = Determinante(matrizMenor);
                matrizAdjunta[i][j] = (i + j) % 2 == 0 ? cofactor : -cofactor;
            }
        }
        return matrizAdjunta;
    }

}


