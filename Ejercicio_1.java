import java.util.Scanner;

public class Ejercicio_1 {

    public void menu(int joh[]) {
        operation_vector vec = new operation_vector();
        Scanner tec = new Scanner(System.in);
        int op = 0;
        do {
            System.out.println("****************************************************************");
            System.out.println("1.LLENAR");
            System.out.println("2.IMPRIMIR NUMERO PAR");
            System.out.println("3.SALIR");
            System.out.println("****************************************************************");
            op = tec.nextInt();
            switch (op) {
                case 1:
                    vec.fill(joh);
                    break;

                case 2:
                    vec.println(joh);
                    break;

                case 3:
                    System.out.println("SALIENDO....");
                    System.exit(op);
                    break;
            }
        } while (op != 3);
        tec.close();
    }

    public static void main(String[] args) {
        Ejercicio_1 meth = new Ejercicio_1();
        int[] joh = new int[5];
        meth.menu(joh);

    }

}
