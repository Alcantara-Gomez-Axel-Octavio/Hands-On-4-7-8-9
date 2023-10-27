package com.company;

import java.util.ArrayList;


public class DataSet {

    public static ArrayList<DataSet> Datos = new ArrayList<>();

    double X;
    double X2;
    double X3;
    double X4 ;
    double Y;

    public DataSet(double X, double X2, double X3, double X4, double Y) {
        this.X = X;
        this.X2 = X2;
        this.X3 = X3;
        this.X4 = X4;
        this.Y = Y;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public DataSet(double X, double Y) {
        this.X = X;
        this.Y = Y;
    }

    public DataSet(double X, double X2, double X3,double Y) {
        this.X = X;
        this.X2 = X2;
        this.X3 = X3;
        this.Y = Y;
    }



    public static ArrayList<DataSet> LeerDatos() {
        Datos.clear();
        Datos.add(new DataSet(23, 651));
        Datos.add(new DataSet(26, 762));
        Datos.add(new DataSet(30, 856));
        Datos.add(new DataSet(34, 1063));
        Datos.add(new DataSet(43, 1190));
        Datos.add(new DataSet(48, 1298));
        Datos.add(new DataSet(52, 1421));
        Datos.add(new DataSet(57, 1440));
        Datos.add(new DataSet(58, 1518));

        return Datos;
    }

    public static ArrayList<DataSet> LeerDatos2() {
        Datos.clear();
        Datos.add(new DataSet(165349.2,0,0,0, 192261.83));
        Datos.add(new DataSet(162597.7,0,0,0, 191792.06));
        Datos.add(new DataSet(153441.51,0,0,0, 191050.39));
        Datos.add(new DataSet(144372.41,0,0,0, 182901.99));
        Datos.add(new DataSet(142107.34,0,0,0, 166187.94));
        Datos.add(new DataSet(131876.9,0,0,0, 156991.12));
        Datos.add(new DataSet(134615.46,0,0,0, 156122.51));
        Datos.add(new DataSet(130298.13,0,0,0, 155752.6));
        Datos.add(new DataSet(120542.52,0,0,0, 152211.77));
        Datos.add(new DataSet(123334.88,0,0,0, 149759.96));
        Datos.add(new DataSet(101913.08,0,0,0, 146121.95));
        Datos.add(new DataSet(100671.96,0,0,0, 144259.4));
        Datos.add(new DataSet(93863.75,0,0,0, 141585.52));
        Datos.add(new DataSet(91992.39,0,0,0, 134307.35));
        Datos.add(new DataSet(119943.24,0,0,0, 132602.65));
        Datos.add(new DataSet(114523.61,0,0,0, 129917.04));
        Datos.add(new DataSet(78013.11,0,0,0, 126992.93));
        Datos.add(new DataSet(94657.16,0,0,0, 125370.37));
        Datos.add(new DataSet(91749.16,0,0,0, 124266.9));
        Datos.add(new DataSet(86419.7,0,0,0, 122776.86));
        Datos.add(new DataSet(76253.86,0,0,0, 118474.03));
        Datos.add(new DataSet(78389.47,0,0,0, 111313.02));
        Datos.add(new DataSet(73994.56,0,0,0, 110352.25));
        Datos.add(new DataSet(67532.53,0,0,0, 108733.99));
        Datos.add(new DataSet(77044.01,0,0,0, 108552.04));
        Datos.add(new DataSet(64664.71,0,0,0, 107404.34));
        Datos.add(new DataSet(75328.87,0,0,0, 105733.54));
        Datos.add(new DataSet(72107.6,0,0,0, 105008.31));
        Datos.add(new DataSet(66051.52,0,0,0, 103282.38));
        Datos.add(new DataSet(65605.48,0,0,0, 101004.64));
        Datos.add(new DataSet(61994.48,0,0,0, 99937.59));
        Datos.add(new DataSet(61136.38,0,0,0, 97483.56));
        Datos.add(new DataSet(63408.86,0,0,0, 97427.84));
        Datos.add(new DataSet(55493.95,0,0,0, 96778.92));
        Datos.add(new DataSet(46426.07,0,0,0, 96712.8));
        Datos.add(new DataSet(46014.02,0,0,0, 96479.51));
        Datos.add(new DataSet(28663.76,0,0,0, 90708.19));
        Datos.add(new DataSet(44069.95,0,0,0, 89949.14));
        Datos.add(new DataSet(20229.59,0,0,0, 81229.06));
        Datos.add(new DataSet(38558.51,0,0,0, 81005.76));
        Datos.add(new DataSet(28754.33,0,0,0, 78239.91));
        Datos.add(new DataSet(27892.92,0,0,0, 77798.83));
        Datos.add(new DataSet(23640.93,0,0,0, 71498.49));
        Datos.add(new DataSet(15505.73,0,0,0, 69758.98));
        Datos.add(new DataSet(22177.74,0,0,0, 65200.33));
        Datos.add(new DataSet(1000.23,0,0,0, 64926.08));
        Datos.add(new DataSet(1315.46,0,0,0, 49490.75));
        Datos.add(new DataSet(0,0,0,0, 42559.73));
        Datos.add(new DataSet(542.05,0,0,0, 35673.41));
        Datos.add(new DataSet(0,0,0,0, 14681.4));

        return Datos;
    }

    public static ArrayList<DataSet> LeerDatos3() {
        Datos.clear();
        Datos.add(new DataSet(1,165349.2, 136897.8, 471784.1, 192261.83));
        Datos.add(new DataSet(1,162597.7, 151377.59, 443898.53, 191792.06));
        Datos.add(new DataSet(1,153441.51, 101145.55, 407934.54, 191050.39));
        Datos.add(new DataSet(1,144372.41, 118671.85, 383199.62, 182901.99));
        Datos.add(new DataSet(1,142107.34, 91391.77, 366168.42, 166187.94));
        Datos.add(new DataSet(1,131876.9, 99814.71, 362861.36, 156991.12));
        Datos.add(new DataSet(1,134615.46, 147198.87, 127716.82, 156122.51));
        Datos.add(new DataSet(1,130298.13, 145530.06, 323876.68, 155752.6));
        Datos.add(new DataSet(1,120542.52, 148718.95, 311613.29, 152211.77));
        Datos.add(new DataSet(1,123334.88, 108679.17, 304981.62, 149759.96));
        Datos.add(new DataSet(1,101913.08, 110594.11, 229160.95, 146121.95));
        Datos.add(new DataSet(1,100671.96, 91790.61, 249744.55, 144259.4));
        Datos.add(new DataSet(1,93863.75, 127320.38, 249839.44, 141585.52));
        Datos.add(new DataSet(1,91992.39, 135495.07, 252664.93, 134307.35));
        Datos.add(new DataSet(1,119943.24, 156547.42, 256512.92, 132602.65));
        Datos.add(new DataSet(1,114523.61, 122616.84, 261776.23, 129917.04));
        Datos.add(new DataSet(1,78013.11, 121597.55, 264346.06, 126992.93));
        Datos.add(new DataSet(1,94657.16, 145077.58, 282574.31, 125370.37));
        Datos.add(new DataSet(1,91749.16, 114175.79, 294919.57, 124266.9));
        Datos.add(new DataSet(1,86419.7, 153514.11, 0, 122776.86));
        Datos.add(new DataSet(1,76253.86, 113867.3, 298664.47, 118474.03));
        Datos.add(new DataSet(1,78389.47, 153773.43, 299737.29, 111313.02));
        Datos.add(new DataSet(1,73994.56, 122782.75, 303319.26, 110352.25));
        Datos.add(new DataSet(1,67532.53, 105751.03, 304768.73, 108733.99));
        Datos.add(new DataSet(1,77044.01, 99281.34, 140574.81, 108552.04));
        Datos.add(new DataSet(1,64664.71, 139553.16, 137962.62, 107404.34));
        Datos.add(new DataSet(1,75328.87, 144135.98, 134050.07, 105733.54));
        Datos.add(new DataSet(1,72107.6, 127864.55, 353183.81, 105008.31));
        Datos.add(new DataSet(1,66051.52, 182645.56, 118148.2, 103282.38));
        Datos.add(new DataSet(1,65605.48, 153032.06, 107138.38, 101004.64));
        Datos.add(new DataSet(1,61994.48, 115641.28, 91131.24, 99937.59));
        Datos.add(new DataSet(1,61136.38, 152701.92, 88218.23, 97483.56));
        Datos.add(new DataSet(1,63408.86, 129219.61, 46085.25, 97427.84));
        Datos.add(new DataSet(1,55493.95, 103057.49, 214634.81, 96778.92));
        Datos.add(new DataSet(1,46426.07, 157693.92, 210797.67, 96712.8));
        Datos.add(new DataSet(1,46014.02, 85047.44, 205517.64, 96479.51));
        Datos.add(new DataSet(1,28663.76, 127056.21, 201126.82, 90708.19));
        Datos.add(new DataSet(1,44069.95, 51283.14, 197029.42, 89949.14));
        Datos.add(new DataSet(1,20229.59, 65947.93, 185265.1, 81229.06));
        Datos.add(new DataSet(1,38558.51, 82982.09, 174999.3, 81005.76));
        Datos.add(new DataSet(1,28754.33, 118546.05, 172795.67, 78239.91));
        Datos.add(new DataSet(1,27892.92, 84710.77, 164470.71, 77798.83));
        Datos.add(new DataSet(1,23640.93, 96189.63, 148001.11, 71498.49));
        Datos.add(new DataSet(1,15505.73, 127382.3, 35534.17, 69758.98));
        Datos.add(new DataSet(1,22177.74, 154806.14, 28334.72, 65200.33));
        Datos.add(new DataSet(1,1000.23, 124153.04, 1903.93, 64926.08));
        Datos.add(new DataSet(1,1315.46, 115816.21, 297114.46, 49490.75));
        Datos.add(new DataSet(1,0, 135426.92, 0, 42559.73));
        Datos.add(new DataSet(1,542.05, 51743.15, 0, 35673.41));
        Datos.add(new DataSet(1,0, 116983.8, 45173.06, 14681.4));

        return Datos;
    }

    public static  ArrayList<DataSet> LeerDatos4() {
        Datos.clear();
        Datos.add(new DataSet(1, 41.90, 29.1, 251.30));
        Datos.add(new DataSet(1, 43.40, 29.3, 251.30));
        Datos.add(new DataSet(1, 43.90, 29.5, 248.30));
        Datos.add(new DataSet(1, 44.50, 29.7, 267.50));
        Datos.add(new DataSet(1, 47.30, 29.9, 273.00));
        Datos.add(new DataSet(1, 47.50, 30.3, 276.50));
        Datos.add(new DataSet(1, 47.90, 30.5, 270.30));
        Datos.add(new DataSet(1, 50.20, 30.7, 274.90));
        Datos.add(new DataSet(1, 52.80, 30.8, 285.00));
        Datos.add(new DataSet(1, 53.20, 30.9, 290.00));
        Datos.add(new DataSet(1, 56.70, 31.5, 297.00));
        Datos.add(new DataSet(1, 57.00, 31.7, 302.50));
        Datos.add(new DataSet(1, 63.50, 31.90, 304.50));
        Datos.add(new DataSet(1, 65.30, 32.00, 309.30));
        Datos.add(new DataSet(1, 71.10, 32.10, 321.70));
        Datos.add(new DataSet(1, 77.00, 32.50, 330.70));
        Datos.add(new DataSet(1, 77.80, 32.90, 349.00));

        return Datos;
    }

    public static  ArrayList<DataSet> LeerDatos5() {
        Datos.clear();
        Datos.add(new DataSet(-3, 7.5));
        Datos.add(new DataSet(-2, 3));
        Datos.add(new DataSet(-1, 0.5));
        Datos.add(new DataSet(0, 1));
        Datos.add(new DataSet(1, 3));
        Datos.add(new DataSet(2, 6));
        Datos.add(new DataSet(3, 14));
        return Datos;
    }

    public static ArrayList<DataSet> LeerDatos6(){
        Datos.add(new DataSet(108,95));
        Datos.add(new DataSet(115,96));
        Datos.add(new DataSet(106,95));
        Datos.add(new DataSet(97,97));
        Datos.add(new DataSet(95,93));
        Datos.add(new DataSet(91,94));
        Datos.add(new DataSet(97,95));
        Datos.add(new DataSet(83,93));
        Datos.add(new DataSet(83,92));
        Datos.add(new DataSet(78,86));
        Datos.add(new DataSet(54,73));
        Datos.add(new DataSet(67,80));
        Datos.add(new DataSet(56,65));
        Datos.add(new DataSet(53,69));
        Datos.add(new DataSet(61,77));
        Datos.add(new DataSet(115,96));
        Datos.add(new DataSet(81,87));
        Datos.add(new DataSet(78,89));
        Datos.add(new DataSet(30,60));
        Datos.add(new DataSet(45,63));
        Datos.add(new DataSet(99,95));
        Datos.add(new DataSet(32,61));
        Datos.add(new DataSet(25,55));
        Datos.add(new DataSet(28,56));
        Datos.add(new DataSet(90,94));
        Datos.add(new DataSet(89,93));
        return Datos;
        
    }
    
}

