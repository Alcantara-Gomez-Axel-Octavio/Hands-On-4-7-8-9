package com.company;

import java.util.ArrayList;

public class SimpleLinearRegression {

    public static ArrayList<DataSet> Datos = new ArrayList<>();
    public static ArrayList<Double> DesviacionesSpend = new ArrayList<>();
    public static ArrayList<Double> DesviacionesProfit = new ArrayList<>();
    public static ArrayList<Double> ProductoDesviaciones= new ArrayList<>();


    public double pendiente;
    public double intercept;


    public static void main(String[] args) {

        double simulacion;

        ArrayList<DataSet> data = DataSet.LeerDatos();
        //ArrayList<DataSet> data = DataSet.LeerDatos2();



        SimpleLinearRegression regression = new SimpleLinearRegression(data);



        // Simulacion 1
        simulacion = 20;
        System.out.println("Para x = " + simulacion + ", y = " + regression.predict(simulacion));

        //Simulacion 2
        simulacion = 30;
        System.out.println("Para x = " + simulacion + ", y = " +regression.predict(simulacion));

        //Simulacion 3
        simulacion = 40;
        System.out.println("Para x = " + simulacion + ", y = " + regression.predict(simulacion));

        //Simulacion 4
        simulacion = 45;
        System.out.println("Para x = " + simulacion + ", y = " + regression.predict(simulacion));

        //Simulacion 5
        simulacion = 50;
        System.out.println("Para x = " + simulacion + ", y = " + regression.predict(simulacion));


         /*

        Datos=DataSet.LeerDatos();
        MetodoSimpleLinearRegression();

         */


    }


    public SimpleLinearRegression(ArrayList<DataSet> data) {

        // Calcula la pendiente y la intersección de la regresión lineal
        int n = data.size();
        double sumX = 0;
        double sumY = 0;
        double sumXY = 0;
        double sumX2 = 0;

        for (DataSet p : data) {
            //Sacar sumatoria de las X
            sumX += p.X;

            //Sacar sumatoria de las y
            sumY += p.Y;

            //Sacar sumatoria de X por Y
            sumXY += p.X * p.Y;

            //Sacar sumatoria de X cuadrada
            sumX2 += p.X * p.X;
        }

        //formula para la pendiente
        pendiente = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);

        //Formula para el intercepto
        intercept = (sumY - pendiente * sumX) / n;

        // Imprime la ecuación de la regresión lineal
        System.out.println("Ecuación de la regresión lineal: y = " + pendiente + "x + " + intercept);
    }


    public double predict(double x) {

        // Realiza una predicción utilizando la ecuación de la regresión lineal
        return pendiente * x + intercept;
    }


    public static void MetodoSimpleLinearRegression(){
        double proSpend;
        double sumaSpend=0;
        double proProfit;
        double sumaProfit=0;
        double sumaProdDesviaciones=0;
        double sumaDesCuadradaSpend=0;
        double coeficienteRegresion;
        double intercepto;
        double simulacion1,  simulacion2,  simulacion3;

        DesviacionesSpend.clear();
        DesviacionesProfit.clear();
        ProductoDesviaciones.clear();



        //Promedio X
        for(DataSet p: Datos){
            sumaSpend+=p.X;
        }

        System.out.println();
        System.out.printf("Suma de los valores de Spend: %.10f%n", (double) sumaSpend);

        proSpend=sumaSpend/Datos.size();
        System.out.printf("\nPromedio de spend: %.10f%n", (double) proSpend);
        System.out.println();

        //Desviaciones X
        for(DataSet p: Datos){
            DesviacionesSpend.add((double) p.X-proSpend);

        }
        for (Double valor : DesviacionesSpend) {
            System.out.println("Valor de las desviaciones Spend: " + valor);
        }



        //Promedio Y
        for(DataSet p: Datos){
            sumaProfit+=p.Y;
        }

        System.out.println();
        System.out.printf("Suma de los valores de Profit: %.10f%n", (double) sumaProfit);

        proProfit=sumaProfit/Datos.size();
        System.out.printf("\nPromedio de profit: %.10f%n", (double) proProfit);
        System.out.println();

        //Desviaciones Y
        for(DataSet p: Datos){
            DesviacionesProfit.add((double) p.Y-proProfit);

        }
        for (Double valor : DesviacionesProfit) {
            System.out.println("Valor de las desviaciones Profit: " + valor);
        }

        //Producto Desviaciones
        System.out.println();
        for(int i=0;i<=DesviacionesSpend.size()-1;i++) {

            ProductoDesviaciones.add((double) DesviacionesSpend.get(i) *DesviacionesProfit.get(i));
            System.out.println("Valor de Producto de desviaciones: " +ProductoDesviaciones.get(i));
        }

        //Suma de los productos de desviaciones
        System.out.println();
        for(Double valor: ProductoDesviaciones){
            sumaProdDesviaciones+=valor;
        }
        System.out.println("Valor de la suma de Producto de desviaciones: "+sumaProdDesviaciones);

        //Suma de Desviaciones Spend al cuadrado
        System.out.println();
        for(Double valor: DesviacionesSpend){
            double cuadrado =valor*valor;
            sumaDesCuadradaSpend+=cuadrado;
        }
        System.out.println("Valor de la suma de desviaciones al cuadrado de spend: "+sumaDesCuadradaSpend);

        //Calcular la pendiente (coeficiente de regresión)
        System.out.println();
        coeficienteRegresion= sumaProdDesviaciones / sumaDesCuadradaSpend;
        System.out.println("Coeficiente de regresión: "+coeficienteRegresion);

        //Calcular el intercepto
        System.out.println();
        intercepto= proProfit - coeficienteRegresion *  proSpend;
        System.out.println("Intercepto: "+intercepto);

        //Ecuacion de Regresion
        System.out.println();
        System.out.println("Ecuación de Regresión: Y="+intercepto+"+("+coeficienteRegresion+"X1)");


        //Simulacion 1
        simulacion1=intercepto+coeficienteRegresion*23;
        System.out.println("Suponiendo que X vale 23= "+simulacion1);

        //Simulacion 2
        simulacion2=intercepto+coeficienteRegresion*30;
        System.out.println("Suponiendo que X vale 30= "+simulacion2);

        //Simulacion 3
        simulacion3=intercepto+coeficienteRegresion*60;
        System.out.println("Suponiendo que X vale 60= "+simulacion3);
    }

}
