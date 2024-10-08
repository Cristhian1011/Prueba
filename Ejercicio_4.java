import java.util.Scanner;

public class Ejercicio_4 {

    public void Registro(int[] Cedula, String[] sexo, int[] Votos) {
        Scanner sc = new Scanner(System.in);
        Ejercicio_4 Ej = new Ejercicio_4();

        int cont = 0;
        for (int i = 0; i < Cedula.length; i++) {
            System.out.println("******************************************************");
            System.out.println("*           INGRESE SU CEDULA VOTANTE N" + (cont + 1) + ":           *");
            System.out.println("******************************************************");
            Cedula[cont] = sc.nextInt();

            System.out.println("******************************************************");
            System.out.println("*           INGRESE SU SEXO: M O F                  *");
            System.out.println("******************************************************");
            sexo[cont] = sc.next();

            System.out.println("******************************************************");
            System.out.println("*            INGRESE SU VOTO:                       *");
            System.out.println("******************************************************");
            System.out.println("************************************************************************************");
            System.out.println("*  BLANCO (0) | Fernando Perez (1) | Gustavo Petro (2) | Cristhian Mantilla (3)   *");
            System.out.println("************************************************************************************");
            Votos[cont] = sc.nextInt();
            cont++;
        }

        System.out.println("******************************************************");
        System.out.println("*               EL GANADOR ES: " + Ej.Ganador(Votos) + "            *");
        System.out.println("******************************************************");
        System.out
                .println("*  VOTOS EN BLANCO: " + Ej.CantVotos(Votos)[0] + "                                        *");
        System.out
                .println("*  VOTOS DE Fernando Perez: " + Ej.CantVotos(Votos)[1] + "                                *");
        System.out
                .println("*  VOTOS DE Gustavo Petro: " + Ej.CantVotos(Votos)[2] + "                                 *");
        System.out
                .println("*  VOTOS DE Cristhian Mantilla: " + Ej.CantVotos(Votos)[3] + "                            *");
        System.out.println("******************************************************");
        System.out.println("*  LAS MUJERES QUE VOTARON: " + Ej.NSexo(sexo)[1] + "                                  *");
        System.out.println("*  LOS HOMBRES QUE VOTARON: " + Ej.NSexo(sexo)[0] + "                                   *");
        System.out.println("******************************************************");

        Ej.Revisar(Votos);
        sc.close();
    }

    public int[] NSexo(String[] sexos) {
        int mujeres = 0;
        int hombres = 0;
        for (int i = 0; i < sexos.length; i++) {
            if (sexos[i].equals("M")) {
                hombres++;
            } else if (sexos[i].equals("F")) {
                mujeres++;
            }
        }
        return new int[] { hombres, mujeres };
    }

    public String Ganador(int[] Votos) {
        String Ganador = " ";
        int Fernando = 0;
        int Petro = 0;
        int Cristhian = 0;
        for (int i = 0; i < Votos.length; i++) {
            switch (Votos[i]) {
                case 1:
                    Fernando++;
                    break;
                case 2:
                    Petro++;
                    break;
                case 3:
                    Cristhian++;
                    break;
            }
        }
        if (Fernando > Petro && Fernando > Cristhian) {
            Ganador = "Fernando Perez";
        } else if (Petro > Fernando && Petro > Cristhian) {
            Ganador = "Gustavo Petro";
        } else if (Cristhian > Fernando && Cristhian > Petro) {
            Ganador = "Cristhian Mantilla";
        } else {
            Ganador = "EMPATE TECNICO";
        }
        return Ganador;
    }

    public int[] CantVotos(int[] Votos) {
        int BLANCO = 0;
        int Fernando = 0;
        int Petro = 0;
        int Cristhian = 0;
        for (int i = 0; i < Votos.length; i++) {
            switch (Votos[i]) {
                case 0:
                    BLANCO++;
                    break;
                case 1:
                    Fernando++;
                    break;
                case 2:
                    Petro++;
                    break;
                case 3:
                    Cristhian++;
                    break;
            }
        }
        return new int[] { BLANCO, Fernando, Petro, Cristhian };
    }

    public void Revisar(int[] votos) {
        int TotalVts = 0;
        int Fernando = 0;
        int Petro = 0;
        int Cristhian = 0;
        for (int i = 0; i < votos.length; i++) {
            switch (votos[i]) {
                case 1:
                    Fernando++;
                    TotalVts++;
                    break;
                case 2:
                    Petro++;
                    TotalVts++;
                    break;
                case 3:
                    Cristhian++;
                    TotalVts++;
                    break;
            }
        }
        double porcentajeFernando = (Fernando / (double) TotalVts) * 100;
        double porcentajePetro = (Petro / (double) TotalVts) * 100;
        double porcentajeCristhian = (Cristhian / (double) TotalVts) * 100;

        System.out.println("******************************************************");
        System.out.println("*          PORCENTAJES DE VOTOS POR CANDIDATO         *");
        System.out.println("******************************************************");
        System.out.printf("*  VOTOS DE Fernando Perez: %.1f%%                      *\n", porcentajeFernando);
        System.out.printf("*  VOTOS DE Gustavo Petro: %.1f%%                       *\n", porcentajePetro);
        System.out.printf("*  VOTOS DE Cristhian Mantilla: %.1f%%                  *\n", porcentajeCristhian);
        System.out.println("******************************************************");

        String candidato1 = "";
        String candidato2 = "";

        if (porcentajeCristhian == porcentajeFernando || porcentajeCristhian == porcentajePetro
                || porcentajePetro == porcentajeFernando) {

            if (porcentajeCristhian == porcentajeFernando) {
                candidato1 = "Cristhian";
                candidato2 = "Fernando";
            } else if (porcentajeCristhian == porcentajePetro) {
                candidato1 = "Cristhian";
                candidato2 = "Petro";
            } else if (porcentajePetro == porcentajeFernando) {
                candidato1 = "Petro";
                candidato2 = "Fernando";
            }

            System.out.println("******************************************************");
            System.out.println("*  HAY EMPATE TÉCNICO, SE DEBE REALIZAR UNA SEGUNDA   *");
            System.out.println("*  RONDA CON LOS DOS CANDIDATOS: " + candidato1 + " y " + candidato2 + "  *");
            System.out.println("******************************************************");
        }

    }

    public static void main(String args[]) {
        Ejercicio_4 Ej = new Ejercicio_4();
        Scanner sc = new Scanner(System.in);
        System.out.println("******************************************************");
        System.out.println("*           INGRESE LA CANTIDAD DE VOTANTES           *");
        System.out.println("******************************************************");
        int i = sc.nextInt();

        int[] Cedula = new int[i];
        String[] sexo = new String[i];
        int[] Votos = new int[i];
        Ej.Registro(Cedula, sexo, Votos);

        sc.close();
    }
}