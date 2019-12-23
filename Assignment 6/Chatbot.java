import java.util.*;
import java.io.*;

public class Chatbot{
    private static String filename = "./WARC201709_wid.txt";
    private static ArrayList<Integer> readCorpus(){
        ArrayList<Integer> corpus = new ArrayList<Integer>();
        try{
            File f = new File(filename);
            Scanner sc = new Scanner(f);
            while(sc.hasNext()){
                if(sc.hasNextInt()){
                    int i = sc.nextInt();
                    corpus.add(i);
                }
                else{
                    sc.next();
                }
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("File Not Found.");
        }
        return corpus;
    }

    static public void main(String[] args){
        ArrayList<Integer> corpus = readCorpus();
        
		int flag = Integer.valueOf(args[0]);
        
        if(flag == 100){
			int w = Integer.valueOf(args[1]);
            int count = 0;
            for(int i = 0; i < corpus.size(); i++) {
                if(corpus.get(i) == w) {
                    count++;
                }
            }
            System.out.println(count);
            System.out.println(String.format("%.7f",count/(double)corpus.size()));
        }
        else if(flag == 200){
            int n1 = Integer.valueOf(args[1]);
            int n2 = Integer.valueOf(args[2]);
            double r = n1/(double)n2;
            Unigram(r, corpus, true);
        }
        else if(flag == 300){
            int h = Integer.valueOf(args[1]);
            int w = Integer.valueOf(args[2]);
            int count = 0;
            int hCount = 0;
            for(int i = 0; i < corpus.size() - 1; i++) {
                if(corpus.get(i) == h) {
                    hCount++;
                    if(corpus.get(i + 1) == w) {
                        count++;
                    }
                }
            }
            //output 
            System.out.println(count);
            System.out.println(hCount);
            System.out.println(String.format("%.7f",count/(double)hCount));
            return;
        }
        else if(flag == 400){
            int n1 = Integer.valueOf(args[1]);
            int n2 = Integer.valueOf(args[2]);
            int h = Integer.valueOf(args[3]);
            double r = n1/(double)n2 ;
            Bigram(h, r, corpus, true);
        }
        else if(flag == 500){
            int h1 = Integer.valueOf(args[1]);
            int h2 = Integer.valueOf(args[2]);
            int w = Integer.valueOf(args[3]);
            int count = 0;
            int hCount = 0;
            for(int i = 0; i < corpus.size() - 2; i++) {
                if(corpus.get(i) == h1 && corpus.get(i + 1) == h2) {
                    hCount++;
                    if(corpus.get(i + 2) == w) {
                        count++;
                    }
                }
            }
            System.out.println(count);
            System.out.println(hCount);
            if(hCount == 0) {
                System.out.println("undefined");
            }
            else {
                 System.out.println(String.format("%.7f",count/(double)hCount));
            }      
        }
        else if(flag == 600){
            int n1 = Integer.valueOf(args[1]);
            int n2 = Integer.valueOf(args[2]);
            int h1 = Integer.valueOf(args[3]);
            int h2 = Integer.valueOf(args[4]);
            double r = n1/(double)n2 ;
            Trigram(h1, h2, r, corpus, true);
        }
        else if(flag == 700){
            int seed = Integer.valueOf(args[1]);
            int t = Integer.valueOf(args[2]);
            int h1=0,h2=0;       
            Random rng = new Random();
            if (seed != -1) rng.setSeed(seed);
            if(t == 0){
                double r = rng.nextDouble();
                if(h1 == 9 || h1 == 10 || h1 == 12){
                    return;
                }
                h1 = Unigram(r, corpus,false);
                System.out.println(h1);
                r = rng.nextDouble();
                h2 = Bigram(h1, r, readCorpus(), false);
                if(h2 == -1) {
                    return;
                }
                System.out.println(h2);
            }
            else if(t == 1){
                h1 = Integer.valueOf(args[3]);
                // TODO Generate second word using r
                double r = rng.nextDouble();
                h2 = Bigram(h1, r, corpus, false);
                if(h2 == -1) {
                    return;
                }
                System.out.println(h2);
            }
            else if(t == 2){
                h1 = Integer.valueOf(args[3]);
                h2 = Integer.valueOf(args[4]);
                double r = rng.nextDouble();
                int[] result = new int[2];
                result = Trigram(h1, h2, r, corpus,false);
                if(result[0] == -1 || result[1] == -1) {
                    return;
                }
                System.out.println(result[1]);
                h1 = result[0];
                h2 = result[1];
            }
            while(h2 != 9 && h2 != 10 && h2 != 12){
                double r = rng.nextDouble();
                int w  = 0;
                int[] result = Trigram(h1, h2, r, readCorpus(), false);
                if(result[0] == -1 || result[1] == -1) {
                    return;
                }
                w = result[1];
                System.out.println(w);
                h1 = h2;
                h2 = w;
            }
        }
        return;
    }
    private static int Unigram(double r, ArrayList<Integer> corpus, boolean flag) {
        int result = 0;
        ArrayList<Tuple> intervals = new ArrayList<Tuple>();
        int size = corpus.size();
        int tempCount = 0;   
        for(int i = 0; i < size; i++) {
            int temp = corpus.get(i);
            tempCount = 0;
            if(temp != -1) {
                for(int j = 0; j < size; j++) {
                    if(corpus.get(j) == temp) {
                        tempCount++;
                        corpus.set(j, -1);
                    }
                }
                if(tempCount/(double)size == 0) {
                    continue;
                }
                Tuple interval = new Tuple(temp, 0.0, tempCount/(double)size, 0.0);
                intervals.add(interval);
            }
        }
        intervals.sort(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple a, Tuple b) {
                return (new Integer(a.index).compareTo(new Integer(b.index)));
            }
        });
        intervals.get(0).left = 0;
        intervals.get(0).right = intervals.get(0).current;
        for(int i = 1; i < intervals.size(); i++) {
            intervals.get(i).left = intervals.get(i - 1).right;
            intervals.get(i).right = intervals.get(i).current + intervals.get(i).left;
        }
        if(r == 0) {
            result = intervals.get(0).index;
            if(flag) {
                System.out.println(intervals.get(0).index);
                System.out.println(String.format("%.7f",intervals.get(0).left));
                System.out.println(String.format("%.7f",intervals.get(0).right));
            }
            return result;
        }
        for(int i = 0; i < intervals.size(); i++) {
            if(intervals.get(i).left < r && intervals.get(i).right >= r) {
                result = intervals.get(i).index;
                if(flag) {
                    System.out.println(result);
                    System.out.println(String.format("%.7f",intervals.get(i).left));
                    System.out.println(String.format("%.7f",intervals.get(i).right));
                    return -1;
                }
                break;
            }
        }
        return result;
    }
    private static int Bigram(int h1, double r, ArrayList<Integer> corpus, boolean flag) {
        ArrayList<Integer> indices = new ArrayList<Integer>();
        int result = 0;
        int count = 0;
        int hCount = 0;
        ArrayList<Tuple> intervals = new ArrayList<Tuple>();      
        for(int i = 0; i < corpus.size() - 1; i++) {
            if(corpus.get(i) == h1) {
                hCount++;
                indices.add(i);
            }
        }
        for(int i = 0; i < corpus.size(); i++) {
            int temp = corpus.get(i);
            if(temp != -1) {
                count = 0;
                for(int j = 0; j < indices.size(); j++) {
                    if(corpus.get(indices.get(j) + 1) == temp) {
                        count++;
                        corpus.set(indices.get(j) + 1, -1);
                    }
                } 
                if(count/(double)hCount == 0) {
                    continue;
                }
                Tuple interval = new Tuple(temp, 0.0, count/(double)hCount, 0.0);
                intervals.add(interval);
            }
        }
        intervals.sort(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple a, Tuple b) {
                return (new Integer(a.index).compareTo(new Integer(b.index)));
            }
        });
        intervals.get(0).left = 0;
        intervals.get(0).right = intervals.get(0).current;
        for(int i = 1; i < intervals.size(); i++) {
            intervals.get(i).left = intervals.get(i - 1).right;
            intervals.get(i).right = intervals.get(i).current + intervals.get(i).left;
        }
        if(r == 0) {
            result = intervals.get(0).index;
            if(flag) {
                System.out.println(intervals.get(0).index);
                System.out.println(String.format("%.7f",intervals.get(0).left));
                System.out.println(String.format("%.7f",intervals.get(0).right));
            }
            return result;
        }
        for(int i = 0; i < intervals.size(); i++) {
            if(intervals.get(i).left < r && intervals.get(i).right >= r) {
                result = intervals.get(i).index;
                if(flag) {
                    System.out.println(result);
                    System.out.println(String.format("%.7f",intervals.get(i).left));
                    System.out.println(String.format("%.7f",intervals.get(i).right));
                    return -1;
                }
                break;
            }
        }
        return result;
    }
    
    private static int[] Trigram(int h1, int h2, double r, ArrayList<Integer> corpus, boolean flag) {
        int[] result = new int[2];
        ArrayList<Integer> indices = new ArrayList<Integer>();
        int count = 0;
        int hCount = 0;
        ArrayList<Tuple> intervals = new ArrayList<Tuple>();      
        for(int i = 0; i < corpus.size() - 2; i++) {
            if(corpus.get(i) == h1 && corpus.get(i + 1) == h2) {
                hCount++;
                indices.add(i);
            }
        }
        if(hCount == 0) {
            result[0] = -1;
            result[1] = -1;
            System.out.println("undefined");
            return result;
        }
        for(int i = 0; i < corpus.size(); i++) {
            int temp = corpus.get(i);
            if(temp != -1) {
                count = 0;
                for(int j = 0; j < indices.size(); j++) {
                    if(corpus.get(indices.get(j) + 2) == temp) {
                        count++;
                        corpus.set(indices.get(j) + 2, -1);
                    }
                } 
                if(count/(double)hCount == 0) {
                    continue;
                }
                Tuple interval = new Tuple(temp, 0.0, count/(double)hCount, 0.0);
                intervals.add(interval); 
            }
        }
        intervals.sort(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple a, Tuple b) {
                return (new Integer(a.index).compareTo(new Integer(b.index)));
            }
        });
        intervals.get(0).left = 0;
        intervals.get(0).right = intervals.get(0).current;
        for(int i = 1; i < intervals.size(); i++) {
            intervals.get(i).left = intervals.get(i - 1).right;
            intervals.get(i).right = intervals.get(i).current + intervals.get(i).left;
        }
        if(r == 0) {
            result[0] = h2;
            result[1] = intervals.get(0).index;
            if(flag) {
                System.out.println(intervals.get(0).index);
                System.out.println(String.format("%.7f",intervals.get(0).left));
                System.out.println(String.format("%.7f",intervals.get(0).right));
            }
            return result;
        }
        for(int i = 0; i < intervals.size(); i++) {
            if(intervals.get(i).left < r && intervals.get(i).right >= r) {
                result[0] = h2;
                result[1] = intervals.get(i).index;
                if(flag) {
                    System.out.println(result[1]);
                    System.out.println(String.format("%.7f",intervals.get(i).left));
                    System.out.println(String.format("%.7f",intervals.get(i).right));
                }
                break;
            }
        }
        return result;
    }
}
class Tuple {
    protected int index;
    protected double left;
    protected double current;
    protected double right;
    protected Tuple(int index, double left, double current, double right) {
        this.index = index;
        this.left = left;
        this.current = current;
        this.right = right;
    }
}