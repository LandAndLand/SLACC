package IntroClassJava.median.median_317aa705_000;

class IntObj {

    public int value;

    public IntObj() {
    }

    public IntObj(int i) {
        value = i;
    }
}

class FloatObj {

    public float value;

    public FloatObj() {
    }

    public FloatObj(float i) {
        value = i;
    }
}

class LongObj {

    public long value;

    public LongObj() {
    }

    public LongObj(long i) {
        value = i;
    }
}

class DoubleObj {

    public double value;

    public DoubleObj() {
    }

    public DoubleObj(double i) {
        value = i;
    }
}

class CharObj {

    public char value;

    public CharObj() {
    }

    public CharObj(char i) {
        value = i;
    }
}

public class median_317aa705_000 {

    public java.util.Scanner scanner;

    public String output = "";

    public static void main(String[] args) throws Exception {
        median_317aa705_000 mainClass = new median_317aa705_000();
        String output;
        if (args.length > 0) {
            mainClass.scanner = new java.util.Scanner(args[0]);
        } else {
            mainClass.scanner = new java.util.Scanner(System.in);
        }
        mainClass.exec();
        System.out.println(mainClass.output);
    }

    public void exec() throws Exception {
        IntObj a = new IntObj(), b = new IntObj(), c = new IntObj(), temp1 = new IntObj(), temp2 = new IntObj();
        output += (String.format("Please enter 3 numbers separated by spaces > "));
        a.value = scanner.nextInt();
        b.value = scanner.nextInt();
        c.value = scanner.nextInt();
        temp1.value = a.value;
        temp2.value = b.value;
        if (a.value > b.value) {
            a.value = b.value;
            b.value = temp1.value;
        }
        if (b.value > c.value) {
            b.value = c.value;
            c.value = temp2.value;
        }
        if (a.value > b.value) {
            a.value = b.value;
            b.value = temp1.value;
        }
        output += (String.format("%d is the median", b.value));
        if (true)
            return;
        ;
    }
}