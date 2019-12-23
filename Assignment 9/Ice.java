import java.util.Random;

public class Ice {
    
    public static void main(String[] args) {
        Node[] record = new Node[163];
        for(int i = 0; i < 45; i++) {
            record[i] = new Node();
            record[i].x = 1855 + i;
        }
        for(int i = 45; i < 95; i++) {
            record[i] = new Node();
            record[i].x = 1900 + i - 45;
        }
        for(int i = 95; i < 145; i++) {
            record[i] = new Node();
            record[i].x = 1950 + i - 95;
        }
        for(int i = 145; i < 163; i++) {
            record[i] = new Node();
            record[i].x = 2000 + i - 145;
        }
        String days = "118,151,121,96,110,117,132,104,125,118,125,123,"
                        + "110,127,131,99,126,144,136,126,91,130,62,112,"
                        + "99,161,78,124,119,124,128,131,113,88,75,111,97,"
                        + "112,101,101,91,110,100,130,111,107,105,89,126,"
                        + "108,97,94,83,106,98,101,108,99,88,115,102,116,"
                        + "115,82,110,81,96,125,104,105,124,103,106,96,107,"
                        + "98,65,115,91,94,101,121,105,97,105,96,82,116,114,"
                        + "92,98,101,104,96,109,122,114,81,85,92,114,111,95,"
                        + "126,105,108,117,112,113,120,65,98,91,108,113,110,105,"
                        + "97,105,107,88,115,123,118,99,93,96,54,111,85,107,89,"
                        + "87,97,93,88,99,108,94,74,119,102,47,82,53,115,21,89,"
                        + "80,101,95,66,106,97,87,109,57,87,117,91,62,65,94";
        String[] splitDays = days.split(",");
        for(int i = 0; i < 163; i++) {
            record[i].y = Integer.valueOf(splitDays[i]);
        }
        int flag = Integer.parseInt(args[0]);
        if(flag == 100) {
            for(Node x: record) {
                System.out.println((int)x.x +  " " + (int)x.y);
            }
        }
        else if(flag == 200) {
            int count = record.length;
            double mean = 0;
            for(Node x: record) {
                mean += x.y;
            }
            mean = mean/(double)count;
            double stddev = 0;
            for(Node x: record) {
                stddev += Math.pow(x.y - mean, 2);
            }
            stddev = Math.sqrt(stddev/(count - 1));
            System.out.println(count);
            System.out.println(String.format("%.2f", mean));
            System.out.println(String.format("%.2f", stddev));
        }
        else if(flag == 300) {
            double beta0 = Double.parseDouble(args[1]);
            double beta1 = Double.parseDouble(args[2]);
            
            double mse = 0;
            for(Node x: record) {
                //System.out.println(beta0 + beta1 * x.x - x.y + " " + x.x * beta1);
                mse += (beta0 + beta1 * x.x - x.y) * (beta0 + beta1 * x.x - x.y);
            }
            mse = mse / (double)record.length;
            System.out.println(String.format("%.2f", mse));
        }
        else if(flag == 400) {
            double beta0 = Double.parseDouble(args[1]);
            double beta1 = Double.parseDouble(args[2]);
            double mse = 0;
            for(Node x: record) {
                mse += beta0 + beta1 * x.x - x.y;
            }
            mse = mse * 2/(double)record.length;
            System.out.println(String.format("%.2f", mse));
            mse = 0;
            for(Node x: record) {
                mse += (beta0 + beta1 * x.x - x.y) * x.x;
            }
            mse = mse * 2/(double)record.length;
            System.out.println(String.format("%.2f", mse));
        }
        else if(flag == 500) {
            double yta = Double.parseDouble(args[1]);
            double t = Double.parseDouble(args[2]);
            int count = 1;
            double oldbeta0 = 0;
            double oldbeta1 = 0;
            double newbeta0 = 0;
            double newbeta1 = 0;
            for(int i = 0; i < t; i++) {               
                double mse = 0;
                for(Node x: record) {
                    mse += oldbeta0 + oldbeta1 * x.x - x.y;
                }
                mse = mse * 2/(double)record.length;
                newbeta0 = oldbeta0 - yta * mse;    
                mse = 0;
                for(Node x: record) {
                    mse += (oldbeta0 + oldbeta1 * x.x - x.y) * x.x;
                }
                mse = mse * 2/(double)record.length;
                newbeta1 = oldbeta1 - yta * mse;               
                mse = 0;
                for(Node x: record) {
                    mse += Math.pow(newbeta0 + newbeta1 * x.x - x.y, 2);
                }
                mse = mse/(double)record.length;
                oldbeta0 = newbeta0;
                oldbeta1 = newbeta1;
                System.out.print(count + " ");
                System.out.print(String.format("%.2f", newbeta0) + " ");
                System.out.print(String.format("%.2f", newbeta1) + " ");
                System.out.print(String.format("%.2f", mse));
                System.out.println();
                count++;
            }
        }
        else if(flag == 600) {
            double beta0 = 0;
            double beta1 = 0;
            double meanx = 0;
            double meany = 0;
            for(Node x: record) {
                meanx += x.x;
                meany += x.y;
            }
            meanx = meanx / (double)record.length;
            meany = meany / (double)record.length;
            double temp1 = 0;
            double temp2 = 0;
            for(Node x: record) {
                temp1 += (x.x - meanx) * (x.y - meany);
                temp2 += (x.x - meanx) * (x.x - meanx);
            }
            beta1 = temp1 / temp2;
            beta0 = meany - beta1 * meanx;
            double mse = 0;
            for(Node x: record) {
                mse += Math.pow(beta0 + beta1 * x.x - x.y, 2);
            }
            mse = mse/(double)record.length;
            System.out.print(String.format("%.2f", beta0) + " ");
            System.out.print(String.format("%.2f", beta1) + " ");
            System.out.print(String.format("%.2f", mse));
			System.out.println();
        }
        else if(flag == 700) {
            int year = Integer.parseInt(args[1]);
            double beta0 = 0;
            double beta1 = 0;
            double meanx = 0;
            double meany = 0;
            for(Node x: record) {
                meanx += x.x;
                meany += x.y;
            }
            meanx = meanx / (double)record.length;
            meany = meany / (double)record.length;
            double temp1 = 0;
            double temp2 = 0;
            for(Node x: record) {
                temp1 += (x.x - meanx) * (x.y - meany);
                temp2 += (x.x - meanx) * (x.x - meanx);
            }
            beta1 = temp1 / temp2;
            beta0 = meany - beta1 * meanx;
            System.out.println(String.format("%.2f", beta0 + year * beta1));
        }
        else if(flag == 800) {
            double yta = Double.parseDouble(args[1]);
            double t = Double.parseDouble(args[2]);
            int count = 1;
            double oldbeta0 = 0;
            double oldbeta1 = 0;
            double newbeta0 = 0;
            double newbeta1 = 0;
            double meanx = 0;
            for(Node x: record) {
                meanx += x.x;
            }
            meanx = meanx / record.length;
            double stddev = 0;
            for(Node x: record) {
                stddev += Math.pow(x.x - meanx, 2);
            }
            stddev = Math.sqrt(stddev/(record.length - 1));
            for(Node x: record) {
                x.x = (x.x - meanx) / (double)stddev;
            }
            for(int i = 0; i < t; i++) {               
                double mse = 0;
                for(Node x: record) {
                    mse += oldbeta0 + oldbeta1 * x.x - x.y;
                }
                mse = mse * 2/(double)record.length;
                newbeta0 = oldbeta0 - yta * mse;    
                mse = 0;
                for(Node x: record) {
                    mse += (oldbeta0 + oldbeta1 * x.x - x.y) * x.x;
                }
                mse = mse * 2/(double)record.length;
                newbeta1 = oldbeta1 - yta * mse;               
                mse = 0;
                for(Node x: record) {
                    mse += Math.pow(newbeta0 + newbeta1 * x.x - x.y, 2);
                }
                mse = mse/(double)record.length;
                oldbeta0 = newbeta0;
                oldbeta1 = newbeta1;
                System.out.print(count + " ");
                System.out.print(String.format("%.2f", newbeta0) + " ");
                System.out.print(String.format("%.2f", newbeta1) + " ");
                System.out.print(String.format("%.2f", mse));
                System.out.println();
                count++;
            }
        }
        else if(flag == 900) {
            double yta = Double.parseDouble(args[1]);
            double t = Double.parseDouble(args[2]);
            int count = 1;
            double oldbeta0 = 0;
            double oldbeta1 = 0;
            double newbeta0 = 0;
            double newbeta1 = 0;
            double meanx = 0;
            for(Node x: record) {
                meanx += x.x;
            }
            meanx = meanx / record.length;
            double stddev = 0;
            for(Node x: record) {
                stddev += Math.pow(x.x - meanx, 2);
            }
            stddev = Math.sqrt(stddev/(record.length - 1));
            for(Node x: record) {
                x.x = (x.x - meanx) / (double)stddev;
            }
            for(int i = 0; i < t; i++) {               
                double mse = 0;
                Random rand = new Random();
                Node chosen = record[rand.nextInt(record.length)];
                mse = 2 * (oldbeta0 + oldbeta1 * chosen.x - chosen.y);
                newbeta0 = oldbeta0 - yta * mse;    
                mse = 0;
                mse = 2 * (oldbeta0 + oldbeta1 * chosen.x - chosen.y) * chosen.x;
                newbeta1 = oldbeta1 - yta * mse;               
                mse = 0;
                for(Node x: record) {
                    mse += Math.pow(newbeta0 + newbeta1 * x.x - x.y, 2);
                }
                mse = mse/(double)record.length;
                oldbeta0 = newbeta0;
                oldbeta1 = newbeta1;
                System.out.print(count + " ");
                System.out.print(String.format("%.2f", newbeta0) + " ");
                System.out.print(String.format("%.2f", newbeta1) + " ");
                System.out.print(String.format("%.2f", mse));
                System.out.println();
                count++;
            }
        }
    }

}
class Node {
    public double x;
    public double y;
}