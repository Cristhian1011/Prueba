#include <stdio.h>
#include <string.h>
#include <fstream>
#include <conio.h>

using namespace std;

void printMenu() {
    printf("\n****************************************\n");
    printf("*              MENU PRINCIPAL          *\n");
    printf("****************************************\n");
    printf("* 1. INICIAR SESION                    *\n");
    printf("* 2. REGISTRAR NUEVO USUARIO           *\n");
    printf("* 3. SALIR                             *\n");
    printf("****************************************\n");
    printf("ELIJA UNA OPCION (1/2/3): ");
}

int main() {
    char option[2], username[11], password[11], fileUser[11], filePassword[11];
    bool sessionStarted = false;

    while (!sessionStarted) {
        printMenu();
        scanf("%s", option);

        if (strcmp(option, "1") == 0) {
            // Código para iniciar sesión
            printf("\n--- INICIAR SESION ---\n");
            printf("INGRESE SU NOMBRE DE USUARIO: ");
            scanf("%s", username);

            if (strcmp(username, "ATRAS") == 0) {
                continue; // Regresa al menú
            }

            printf("INGRESE SU CONTRASEÑA: ");
            scanf("%s", password);

            if (strcmp(password, "ATRAS") == 0) {
                continue; // Regresa al menú
            }

            ifstream usersFile("u.txt");
            while (usersFile >> fileUser >> filePassword) {
                if (strcmp(fileUser, username) == 0 && strcmp(filePassword, password) == 0) {
                    printf("HOLA DE NUEVO %s! HAS INICIADO SESION CORRECTAMENTE :3\n", username);
                    sessionStarted = true;
                    usersFile.close();
                    break;
                }
            }
            usersFile.close();

            if (!sessionStarted) {
                printf("USUARIO NO ENCONTRADO. INTENTE NUEVAMENTE.\n");
            }
        } else if (strcmp(option, "2") == 0) {
            // Código para registrar nuevo usuario
            printf("\n--- REGISTRAR NUEVO USUARIO ---\n");
            printf("INGRESE SU NOMBRE DE USUARIO: ");
            scanf("%s", username);

            if (strcmp(username, "ATRAS") == 0) {
                continue; // Regresa al menú
            }

            printf("INGRESE UNA CONTRASEÑA: ");
            scanf("%s", password);

            if (strcmp(password, "ATRAS") == 0) {
                continue; // Regresa al menú
            }

            ofstream usersFile("u.txt", ios::app);
            usersFile << username << " " << password << endl;
            usersFile.close();
            printf("\nUSUARIO REGISTRADO EXITOSAMENTE.\n");
        } else if (strcmp(option, "3") == 0) {
            // Salir del programa
            printf("SALIENDO DEL PROGRAMA...\n");
            break;
        } else {
            printf("OPCIÓN NO VALIDA. POR FAVOR, INTENTE NUEVAMENTE.\n");
        }
    }

    getch();
    return 0;
}
