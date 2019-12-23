import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Neural {
    public static void main(String[] args) {
        int flag = Integer.parseInt(args[0]);
        if (flag == 100) {
            double uA, vA, uB, vB, uC, vC = 0;
            double w1 = Double.parseDouble(args[1]);
            double w2 = Double.parseDouble(args[2]);
            double w3 = Double.parseDouble(args[3]);
            double w4 = Double.parseDouble(args[4]);
            double w5 = Double.parseDouble(args[5]);
            double w6 = Double.parseDouble(args[6]);
            double w7 = Double.parseDouble(args[7]);
            double w8 = Double.parseDouble(args[8]);
            double w9 = Double.parseDouble(args[9]);
            double x1 = Double.parseDouble(args[10]);
            double x2 = Double.parseDouble(args[11]);
            uA = 1 * w1 + x1 * w2 + x2 * w3;
            System.out.print(String.format("%.5f", uA) + " ");
            vA = Math.max(0, uA);
            System.out.print(String.format("%.5f", vA) + " ");
            uB = 1 * w4 + x1 * w5 + x2 * w6;
            System.out.print(String.format("%.5f", uB) + " ");
            vB = Math.max(0, uB);
            System.out.print(String.format("%.5f", vB) + " ");
            uC = 1 * w7 + w8 * vA + w9 * vB;
            System.out.print(String.format("%.5f", uC) + " ");
            vC = 1 / (double)(1 + Math.pow(Math.E, -1 * uC));
            System.out.println(String.format("%.5f", vC));
        } else if (flag == 200) {
            double uA, vA, uB, vB, uC, vC = 0;
            double w1 = Double.parseDouble(args[1]);
            double w2 = Double.parseDouble(args[2]);
            double w3 = Double.parseDouble(args[3]);
            double w4 = Double.parseDouble(args[4]);
            double w5 = Double.parseDouble(args[5]);
            double w6 = Double.parseDouble(args[6]);
            double w7 = Double.parseDouble(args[7]);
            double w8 = Double.parseDouble(args[8]);
            double w9 = Double.parseDouble(args[9]);
            double x1 = Double.parseDouble(args[10]);
            double x2 = Double.parseDouble(args[11]);
            double y = Double.parseDouble(args[12]);
            uA = 1 * w1 + x1 * w2 + x2 * w3;
            vA = Math.max(0, uA);
            uB = 1 * w4 + x1 * w5 + x2 * w6;
            vB = Math.max(0, uB);
            uC = 1 * w7 + w8 * vA + w9 * vB;
            vC = 1 / (double)(1 + Math.pow(Math.E, -1 * uC));
            double E = 0.5 * (vC - y) * (vC - y);
            System.out.print(String.format("%.5f", E) + " ");
            double dvC = vC - y;
            System.out.print(String.format("%.5f", dvC) + " ");
            double duC = dvC * vC * (1 - vC);
            System.out.println(String.format("%.5f", duC));
        } else if (flag == 300) {
            double uA, vA, uB, vB, uC, vC, dEvA, dEuA, dEvB, dEuB, dvuA, dvuB = 0;
            double w1 = Double.parseDouble(args[1]);
            double w2 = Double.parseDouble(args[2]);
            double w3 = Double.parseDouble(args[3]);
            double w4 = Double.parseDouble(args[4]);
            double w5 = Double.parseDouble(args[5]);
            double w6 = Double.parseDouble(args[6]);
            double w7 = Double.parseDouble(args[7]);
            double w8 = Double.parseDouble(args[8]);
            double w9 = Double.parseDouble(args[9]);
            double x1 = Double.parseDouble(args[10]);
            double x2 = Double.parseDouble(args[11]);
            double y = Double.parseDouble(args[12]);
            uA = 1 * w1 + x1 * w2 + x2 * w3;
            vA = Math.max(0, uA);
            uB = 1 * w4 + x1 * w5 + x2 * w6;
            vB = Math.max(0, uB);
            uC = 1 * w7 + w8 * vA + w9 * vB;
            vC = 1 / (double)(1 + Math.pow(Math.E, -1 * uC));
            double dvC = vC - y;
            double duC = dvC * vC * (1 - vC);

            dEvA = w8 * duC;
            System.out.print(String.format("%.5f", dEvA) + " ");
            if (uA >= 0) {
                dvuA = 1;
            } else {
                dvuA = 0;
            }
            dEuA = dEvA * dvuA;
            System.out.print(String.format("%.5f", dEuA) + " ");
            dEvB = w9 * duC;
            System.out.print(String.format("%.5f", dEvB) + " ");
            if (uB >= 0) {
                dvuB = 1;
            } else {
                dvuB = 0;
            }
            dEuB = dEvB * dvuB;
            System.out.println(String.format("%.5f", dEuB));
        } else if (flag == 400) {
            double uA, vA, uB, vB, uC, vC, dEvA, dEuA, dEvB, dEuB, dvuA, dvuB = 0;
            double w1 = Double.parseDouble(args[1]);
            double w2 = Double.parseDouble(args[2]);
            double w3 = Double.parseDouble(args[3]);
            double w4 = Double.parseDouble(args[4]);
            double w5 = Double.parseDouble(args[5]);
            double w6 = Double.parseDouble(args[6]);
            double w7 = Double.parseDouble(args[7]);
            double w8 = Double.parseDouble(args[8]);
            double w9 = Double.parseDouble(args[9]);
            double x1 = Double.parseDouble(args[10]);
            double x2 = Double.parseDouble(args[11]);
            double y = Double.parseDouble(args[12]);
            uA = 1 * w1 + x1 * w2 + x2 * w3;
            vA = Math.max(0, uA);
            uB = 1 * w4 + x1 * w5 + x2 * w6;
            vB = Math.max(0, uB);
            uC = 1 * w7 + w8 * vA + w9 * vB;
            vC = 1 / (double)(1 + Math.pow(Math.E, -1 * uC));
            double dvC = vC - y;
            double duC = dvC * vC * (1 - vC);
            dEvA = w8 * duC;
            if (uA >= 0) {
                dvuA = 1;
            } else {
                dvuA = 0;
            }
            dEuA = dEvA * dvuA;
            dEvB = w9 * duC;
            if (uB >= 0) {
                dvuB = 1;
            } else {
                dvuB = 0;
            }
            dEuB = dEvB * dvuB;
            double dEw1 = 1 * dEuA;
            double dEw2 = x1 * dEuA;
            double dEw3 = x2 * dEuA;
            double dEw4 = 1 * dEuB;
            double dEw5 = x1 * dEuB;
            double dEw6 = x2 * dEuB;
            double dEw7 = 1 * duC;
            double dEw8 = vA * duC;
            double dEw9 = vB * duC;
            System.out.print(String.format("%.5f", dEw1) + " ");
            System.out.print(String.format("%.5f", dEw2) + " ");
            System.out.print(String.format("%.5f", dEw3) + " ");
            System.out.print(String.format("%.5f", dEw4) + " ");
            System.out.print(String.format("%.5f", dEw5) + " ");
            System.out.print(String.format("%.5f", dEw6) + " ");
            System.out.print(String.format("%.5f", dEw7) + " ");
            System.out.print(String.format("%.5f", dEw8) + " ");
            System.out.println(String.format("%.5f", dEw9));
        } else if (flag == 500) {
            double uA, vA, uB, vB, uC, vC, dEvA, dEuA, dEvB, dEuB, dvuA, dvuB = 0;
            double w1 = Double.parseDouble(args[1]);
            double w2 = Double.parseDouble(args[2]);
            double w3 = Double.parseDouble(args[3]);
            double w4 = Double.parseDouble(args[4]);
            double w5 = Double.parseDouble(args[5]);
            double w6 = Double.parseDouble(args[6]);
            double w7 = Double.parseDouble(args[7]);
            double w8 = Double.parseDouble(args[8]);
            double w9 = Double.parseDouble(args[9]);
            double x1 = Double.parseDouble(args[10]);
            double x2 = Double.parseDouble(args[11]);
            double y = Double.parseDouble(args[12]);
            double yta = Double.parseDouble(args[13]);
            uA = 1 * w1 + x1 * w2 + x2 * w3;
            vA = Math.max(0, uA);
            uB = 1 * w4 + x1 * w5 + x2 * w6;
            vB = Math.max(0, uB);
            uC = 1 * w7 + w8 * vA + w9 * vB;
            vC = 1 / (double)(1 + Math.pow(Math.E, -1 * uC));
            double dvC = vC - y;
            double duC = dvC * vC * (1 - vC);
            dEvA = w8 * duC;
            if (uA >= 0) {
                dvuA = 1;
            } else {
                dvuA = 0;
            }
            dEuA = dEvA * dvuA;
            dEvB = w9 * duC;
            if (uB >= 0) {
                dvuB = 1;
            } else {
                dvuB = 0;
            }
            dEuB = dEvB * dvuB;
            double dEw1 = 1 * dEuA;
            double dEw2 = x1 * dEuA;
            double dEw3 = x2 * dEuA;
            double dEw4 = 1 * dEuB;
            double dEw5 = x1 * dEuB;
            double dEw6 = x2 * dEuB;
            double dEw7 = 1 * duC;
            double dEw8 = vA * duC;
            double dEw9 = vB * duC;
            for (int i = 0; i < 8; i++) {
                System.out.print(String.format("%.5f", Double.parseDouble(args[i + 1])) + " ");
            }
            System.out.println(String.format("%.5f", w9));
            double E = 0.5 * (vC - y) * (vC - y);
            System.out.println(String.format("%.5f", E));
            w1 = w1 - yta * dEw1;
            w2 = w2 - yta * dEw2;
            w3 = w3 - yta * dEw3;
            w4 = w4 - yta * dEw4;
            w5 = w5 - yta * dEw5;
            w6 = w6 - yta * dEw6;
            w7 = w7 - yta * dEw7;
            w8 = w8 - yta * dEw8;
            w9 = w9 - yta * dEw9;
            System.out.print(String.format("%.5f", w1) + " ");
            System.out.print(String.format("%.5f", w2) + " ");
            System.out.print(String.format("%.5f", w3) + " ");
            System.out.print(String.format("%.5f", w4) + " ");
            System.out.print(String.format("%.5f", w5) + " ");
            System.out.print(String.format("%.5f", w6) + " ");
            System.out.print(String.format("%.5f", w7) + " ");
            System.out.print(String.format("%.5f", w8) + " ");
            System.out.println(String.format("%.5f", w9));
            uA = 1 * w1 + x1 * w2 + x2 * w3;
            vA = Math.max(0, uA);
            uB = 1 * w4 + x1 * w5 + x2 * w6;
            vB = Math.max(0, uB);
            uC = 1 * w7 + w8 * vA + w9 * vB;
            vC = 1 / (double)(1 + Math.pow(Math.E, -1 * uC));
            E = 0.5 * (vC - y) * (vC - y);
            System.out.println(String.format("%.5f", E));
        } else if (flag == 600) {
            double uA, vA, uB, vB, uC, vC, dEvA, dEuA, dEvB, dEuB, dvuA, dvuB = 0;
            double w1 = Double.parseDouble(args[1]);
            double w2 = Double.parseDouble(args[2]);
            double w3 = Double.parseDouble(args[3]);
            double w4 = Double.parseDouble(args[4]);
            double w5 = Double.parseDouble(args[5]);
            double w6 = Double.parseDouble(args[6]);
            double w7 = Double.parseDouble(args[7]);
            double w8 = Double.parseDouble(args[8]);
            double w9 = Double.parseDouble(args[9]);
            double yta = Double.parseDouble(args[10]);
            Scanner scanner;
            ArrayList < String > lines = new ArrayList < String > ();
            ArrayList < Node > datas = new ArrayList < Node > ();
            try {
                scanner = new Scanner(new File("hw2_midterm_A_train.txt"));
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    lines.add(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ArrayList < String > evallines = new ArrayList < String > ();
            try {
                scanner = new Scanner(new File("hw2_midterm_A_eval.txt"));
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    evallines.add(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ArrayList < Node > evals = new ArrayList < Node > ();
            for (String x: evallines) {
                String[] data = x.split(" ");
                Node node = new Node();
                node.x1 = Double.valueOf(data[0]);
                node.x2 = Double.valueOf(data[1]);
                node.y = Double.valueOf(data[2]);
                evals.add(node);
            }
            for (String x: lines) {
                String[] data = x.split(" ");
                Node node = new Node();
                node.x1 = Double.valueOf(data[0]);
                node.x2 = Double.valueOf(data[1]);
                node.y = Double.valueOf(data[2]);
                datas.add(node);
            }
            for (int i = 0; i < datas.size(); i++) {
                System.out.println(String.format("%.5f", datas.get(i).x1) +
                    " " + String.format("%.5f", datas.get(i).x2) +
                    " " + String.format("%.5f", datas.get(i).y));
                double x1 = datas.get(i).x1;
                double x2 = datas.get(i).x2;
                double y = datas.get(i).y;
                uA = 1 * w1 + x1 * w2 + x2 * w3;
                vA = Math.max(0, uA);
                uB = 1 * w4 + x1 * w5 + x2 * w6;
                vB = Math.max(0, uB);
                uC = 1 * w7 + w8 * vA + w9 * vB;
                vC = 1 / (double)(1 + Math.pow(Math.E, -1 * uC));
                double dvC = vC - y;
                double duC = dvC * vC * (1 - vC);
                dEvA = w8 * duC;
                if (uA >= 0) {
                    dvuA = 1;
                } else {
                    dvuA = 0;
                }
                dEuA = dEvA * dvuA;
                dEvB = w9 * duC;
                if (uB >= 0) {
                    dvuB = 1;
                } else {
                    dvuB = 0;
                }
                dEuB = dEvB * dvuB;
                double dEw1 = 1 * dEuA;
                double dEw2 = x1 * dEuA;
                double dEw3 = x2 * dEuA;
                double dEw4 = 1 * dEuB;
                double dEw5 = x1 * dEuB;
                double dEw6 = x2 * dEuB;
                double dEw7 = 1 * duC;
                double dEw8 = vA * duC;
                double dEw9 = vB * duC;
                double E = 0;
                w1 = w1 - yta * dEw1;
                w2 = w2 - yta * dEw2;
                w3 = w3 - yta * dEw3;
                w4 = w4 - yta * dEw4;
                w5 = w5 - yta * dEw5;
                w6 = w6 - yta * dEw6;
                w7 = w7 - yta * dEw7;
                w8 = w8 - yta * dEw8;
                w9 = w9 - yta * dEw9;
                System.out.print(String.format("%.5f", w1) + " ");
                System.out.print(String.format("%.5f", w2) + " ");
                System.out.print(String.format("%.5f", w3) + " ");
                System.out.print(String.format("%.5f", w4) + " ");
                System.out.print(String.format("%.5f", w5) + " ");
                System.out.print(String.format("%.5f", w6) + " ");
                System.out.print(String.format("%.5f", w7) + " ");
                System.out.print(String.format("%.5f", w8) + " ");
                System.out.println(String.format("%.5f", w9));
                for (int j = 0; j < evals.size(); j++) {
                    uA = 1 * w1 + evals.get(j).x1 * w2 + evals.get(j).x2 * w3;
                    vA = Math.max(0, uA);
                    uB = 1 * w4 + evals.get(j).x1 * w5 + evals.get(j).x2 * w6;
                    vB = Math.max(0, uB);
                    uC = 1 * w7 + w8 * vA + w9 * vB;
                    vC = 1 / (double)(1 + Math.pow(Math.E, -1 * uC));
                    E += 0.5 * (vC - evals.get(j).y) * (vC - evals.get(j).y);
                }
                System.out.println(String.format("%.5f", E));
            }
        } else if (flag == 700) {
            double uA, vA, uB, vB, uC, vC, dEvA, dEuA, dEvB, dEuB, dvuA, dvuB = 0;
            double w1 = Double.parseDouble(args[1]);
            double w2 = Double.parseDouble(args[2]);
            double w3 = Double.parseDouble(args[3]);
            double w4 = Double.parseDouble(args[4]);
            double w5 = Double.parseDouble(args[5]);
            double w6 = Double.parseDouble(args[6]);
            double w7 = Double.parseDouble(args[7]);
            double w8 = Double.parseDouble(args[8]);
            double w9 = Double.parseDouble(args[9]);
            double yta = Double.parseDouble(args[10]);
            double T = Double.parseDouble(args[11]);
            Scanner scanner;
            ArrayList < String > lines = new ArrayList < String > ();
            ArrayList < Node > datas = new ArrayList < Node > ();
            try {
                scanner = new Scanner(new File("hw2_midterm_A_train.txt"));
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    lines.add(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ArrayList < String > evallines = new ArrayList < String > ();
            try {
                scanner = new Scanner(new File("hw2_midterm_A_eval.txt"));
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    evallines.add(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ArrayList < Node > evals = new ArrayList < Node > ();
            for (String x: evallines) {
                String[] data = x.split(" ");
                Node node = new Node();
                node.x1 = Double.valueOf(data[0]);
                node.x2 = Double.valueOf(data[1]);
                node.y = Double.valueOf(data[2]);
                evals.add(node);
            }
            double E = 0;
            for (String x: lines) {
                String[] data = x.split(" ");
                Node node = new Node();
                node.x1 = Double.valueOf(data[0]);
                node.x2 = Double.valueOf(data[1]);
                node.y = Double.valueOf(data[2]);
                datas.add(node);
            }
            for (int k = 0; k < T; k++) {
                for (int i = 0; i < datas.size(); i++) {
                    double x1 = datas.get(i).x1;
                    double x2 = datas.get(i).x2;
                    double y = datas.get(i).y;
                    uA = 1 * w1 + x1 * w2 + x2 * w3;
                    vA = Math.max(0, uA);
                    uB = 1 * w4 + x1 * w5 + x2 * w6;
                    vB = Math.max(0, uB);
                    uC = 1 * w7 + w8 * vA + w9 * vB;
                    vC = 1 / (double)(1 + Math.pow(Math.E, -1 * uC));
                    double dvC = vC - y;
                    double duC = dvC * vC * (1 - vC);
                    dEvA = w8 * duC;
                    if (uA >= 0) {
                        dvuA = 1;
                    } else {
                        dvuA = 0;
                    }
                    dEuA = dEvA * dvuA;
                    dEvB = w9 * duC;
                    if (uB >= 0) {
                        dvuB = 1;
                    } else {
                        dvuB = 0;
                    }
                    dEuB = dEvB * dvuB;
                    double dEw1 = 1 * dEuA;
                    double dEw2 = x1 * dEuA;
                    double dEw3 = x2 * dEuA;
                    double dEw4 = 1 * dEuB;
                    double dEw5 = x1 * dEuB;
                    double dEw6 = x2 * dEuB;
                    double dEw7 = 1 * duC;
                    double dEw8 = vA * duC;
                    double dEw9 = vB * duC;
                    E = 0;
                    w1 = w1 - yta * dEw1;
                    w2 = w2 - yta * dEw2;
                    w3 = w3 - yta * dEw3;
                    w4 = w4 - yta * dEw4;
                    w5 = w5 - yta * dEw5;
                    w6 = w6 - yta * dEw6;
                    w7 = w7 - yta * dEw7;
                    w8 = w8 - yta * dEw8;
                    w9 = w9 - yta * dEw9;
                    for (int j = 0; j < evals.size(); j++) {
                        uA = 1 * w1 + evals.get(j).x1 * w2 + evals.get(j).x2 * w3;
                        vA = Math.max(0, uA);
                        uB = 1 * w4 + evals.get(j).x1 * w5 + evals.get(j).x2 * w6;
                        vB = Math.max(0, uB);
                        uC = 1 * w7 + w8 * vA + w9 * vB;
                        vC = 1 / (double)(1 + Math.pow(Math.E, -1 * uC));
                        E += 0.5 * (vC - evals.get(j).y) * (vC - evals.get(j).y);
                    }

                }
                System.out.print(String.format("%.5f", w1) + " ");
                System.out.print(String.format("%.5f", w2) + " ");
                System.out.print(String.format("%.5f", w3) + " ");
                System.out.print(String.format("%.5f", w4) + " ");
                System.out.print(String.format("%.5f", w5) + " ");
                System.out.print(String.format("%.5f", w6) + " ");
                System.out.print(String.format("%.5f", w7) + " ");
                System.out.print(String.format("%.5f", w8) + " ");
                System.out.println(String.format("%.5f", w9));
                System.out.println(String.format("%.5f", E));
            }
        } else if (flag == 800) {
            double uA, vA, uB, vB, uC, vC, dEvA, dEuA, dEvB, dEuB, dvuA, dvuB = 0;
            double w1 = Double.parseDouble(args[1]);
            double w2 = Double.parseDouble(args[2]);
            double w3 = Double.parseDouble(args[3]);
            double w4 = Double.parseDouble(args[4]);
            double w5 = Double.parseDouble(args[5]);
            double w6 = Double.parseDouble(args[6]);
            double w7 = Double.parseDouble(args[7]);
            double w8 = Double.parseDouble(args[8]);
            double w9 = Double.parseDouble(args[9]);
            double yta = Double.parseDouble(args[10]);
            double T = Double.parseDouble(args[11]);
            Scanner scanner;
            ArrayList < String > lines = new ArrayList < String > ();
            ArrayList < Node > datas = new ArrayList < Node > ();
            try {
                scanner = new Scanner(new File("hw2_midterm_A_train.txt"));
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    lines.add(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ArrayList < String > evallines = new ArrayList < String > ();
            try {
                scanner = new Scanner(new File("hw2_midterm_A_eval.txt"));
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    evallines.add(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ArrayList<String> testlines = new ArrayList<String>();
            try {
                scanner = new Scanner(new File("hw2_midterm_A_test.txt"));
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    testlines.add(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ArrayList<Node> test = new  ArrayList<Node>();
            for (String x: testlines) {
                String[] data = x.split(" ");
                Node node = new Node();
                node.x1 = Double.valueOf(data[0]);
                node.x2 = Double.valueOf(data[1]);
                node.y = Double.valueOf(data[2]);
                test.add(node);
            }
            ArrayList < Node > evals = new ArrayList < Node > ();
            for (String x: evallines) {
                String[] data = x.split(" ");
                Node node = new Node();
                node.x1 = Double.valueOf(data[0]);
                node.x2 = Double.valueOf(data[1]);
                node.y = Double.valueOf(data[2]);
                evals.add(node);
            }
            double E = 0;
            for (String x: lines) {
                String[] data = x.split(" ");
                Node node = new Node();
                node.x1 = Double.valueOf(data[0]);
                node.x2 = Double.valueOf(data[1]);
                node.y = Double.valueOf(data[2]);
                datas.add(node);
            }
            double prevE = Integer.MAX_VALUE;
            boolean increasingError = false;
            int count = 0;
            for (int k = 0; k < T; k++) {
                if(!increasingError) {
                count = k + 1;
                for (int i = 0; i < datas.size(); i++) {
                    double x1 = datas.get(i).x1;
                    double x2 = datas.get(i).x2;
                    double y = datas.get(i).y;
                    uA = 1 * w1 + x1 * w2 + x2 * w3;
                    vA = Math.max(0, uA);
                    uB = 1 * w4 + x1 * w5 + x2 * w6;
                    vB = Math.max(0, uB);
                    uC = 1 * w7 + w8 * vA + w9 * vB;
                    vC = 1 / (double)(1 + Math.pow(Math.E, -1 * uC));
                    double dvC = vC - y;
                    double duC = dvC * vC * (1 - vC);
                    dEvA = w8 * duC;
                    if (uA >= 0) {
                        dvuA = 1;
                    } else {
                        dvuA = 0;
                    }
                    dEuA = dEvA * dvuA;
                    dEvB = w9 * duC;
                    if (uB >= 0) {
                        dvuB = 1;
                    } else {
                        dvuB = 0;
                    }
                    dEuB = dEvB * dvuB;
                    double dEw1 = 1 * dEuA;
                    double dEw2 = x1 * dEuA;
                    double dEw3 = x2 * dEuA;
                    double dEw4 = 1 * dEuB;
                    double dEw5 = x1 * dEuB;
                    double dEw6 = x2 * dEuB;
                    double dEw7 = 1 * duC;
                    double dEw8 = vA * duC;
                    double dEw9 = vB * duC;
                    E = 0;
                    w1 = w1 - yta * dEw1;
                    w2 = w2 - yta * dEw2;
                    w3 = w3 - yta * dEw3;
                    w4 = w4 - yta * dEw4;
                    w5 = w5 - yta * dEw5;
                    w6 = w6 - yta * dEw6;
                    w7 = w7 - yta * dEw7;
                    w8 = w8 - yta * dEw8;
                    w9 = w9 - yta * dEw9;
                    for (int j = 0; j < evals.size(); j++) {
                        uA = 1 * w1 + evals.get(j).x1 * w2 + evals.get(j).x2 * w3;
                        vA = Math.max(0, uA);
                        uB = 1 * w4 + evals.get(j).x1 * w5 + evals.get(j).x2 * w6;
                        vB = Math.max(0, uB);
                        uC = 1 * w7 + w8 * vA + w9 * vB;
                        vC = 1 / (double)(1 + Math.pow(Math.E, -1 * uC));
                        E += 0.5 * (vC - evals.get(j).y) * (vC - evals.get(j).y);
                    }
                }
                if(E > prevE) {
                    increasingError = true;
                }
                prevE = E;
                }
            }
            System.out.println(count);
            System.out.print(String.format("%.5f", w1) + " ");
            System.out.print(String.format("%.5f", w2) + " ");
            System.out.print(String.format("%.5f", w3) + " ");
            System.out.print(String.format("%.5f", w4) + " ");
            System.out.print(String.format("%.5f", w5) + " ");
            System.out.print(String.format("%.5f", w6) + " ");
            System.out.print(String.format("%.5f", w7) + " ");
            System.out.print(String.format("%.5f", w8) + " ");
            System.out.println(String.format("%.5f", w9));
            System.out.println(String.format("%.5f", E));
            int correctCount = 0;
            for (int i = 0; i < test.size(); i++) {
                double x1test = test.get(i).x1;
                double x2test = test.get(i).x2;
                double ytest = test.get(i).y;
                uA = 1 * w1 + x1test * w2 + x2test * w3;
                vA = Math.max(0, uA);
                uB = 1 * w4 + x1test * w5 + x2test * w6;
                vB = Math.max(0, uB);
                uC = 1 * w7 + w8 * vA + w9 * vB;
                vC = 1 / (double)(1 + Math.pow(Math.E, -1 * uC));
                if((vC > 0.5 && ytest > 0.5) || (vC < 0.5 && ytest < 0.5)) {
                    correctCount ++;
                }
            }
            System.out.println(String.format("%.5f",correctCount / (double) test.size()));
        }
    }
}
class Node {
    public double x1;
    public double x2;
    public double y;
}