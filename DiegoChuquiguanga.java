/*
 *1 Se pedirá por teclado el nivel de dificultad deseado en el juego,
 *el rango de dificultad estará comprendido entre 1.‐ muy fácil, hasta. ‐ 5 imposible
 *
 *2. Se generará un número aleatorio comprendido entre 1 y el valor máximo (incluidos).  
 *El valor máximo dependerá del nivel de dificultad, según la tabla:
 *
 *3. Seguidamente se pedirán números al usuario, hasta que adivine el número 
 *aleatorio, contabilizando el número de veces que ha errado.
 *
 *4. La puntuación se calculará según la siguiente tabla, calculando el tanto por
 *ciento que representa el número de errores cometidos, según el valor máximo del número máximo.
 *
 *5. Se mostrará la puntuación acumulada (si ha jugado más numeritos)
 *6. Se le preguntará si quiere volver a jugar (0 .‐ vuelve a jugar, otra cosa finaliza el programa)
 *7. Si desea volver a jugar, se empezará desde el punto 1.
*/
package diegochuquiguanga;

import javax.swing.JOptionPane;

public class DiegoChuquiguanga {

    //metodo que muestra el menu, recibe un String y devuelve el nivel ingresado en entero
    public static int menu(String opcionNivel) {
        JOptionPane.showMessageDialog(null, "ADIVINA UN NUMERITO\n", "", 1);
        JOptionPane.showMessageDialog(null, "¿ Listo para jugar ?\n", "", 3);
        JOptionPane.showMessageDialog(null, " NIVEL \t          VALOR MÁXIMO\n\n 1_______________10\n 2_______________15"+
                "\n 3_______________20\n 4_______________25\n 5_______________40\n\n", "RECUERDA", 1);
        opcionNivel = JOptionPane.showInputDialog(null,"__________NIVELES__________\n\n1 )  Muy fácil \n2 ) "+
                " Fácil\n3 )   Normal\n4 )   Difícil\n5 )   Imposible\n\nIngresa el nivel de dificulad (1-5)\n\n"," MENU",1);

        return Integer.parseInt(opcionNivel);
    }

    //método para ingresar el numerito a adivinar recibiendo un string  y devuelve el número convertido en entero
    public static int ingresaNumerito(String numAdivinar) {
        
    //el parametro que se pasa se borra porque lo elimina en que ingresa OJO
        
        numAdivinar = JOptionPane.showInputDialog(null, "Adivina el numerito", "", 3);
        return Integer.parseInt(numAdivinar);
    }

    //método que recibe un entero y entra en los condicionales según sea true devuelve el valor de la puntuación en entero 
    public static int puntos(int puntuacion) {

        int valorPuntuacion = 0;
        //condición para todos los números menores de 25%
        if (puntuacion <= 25) {
            valorPuntuacion = 1500000;
            //condición para todos los números menores de 50 y mayores de 26%
        } else if (puntuacion <= 50) {
            valorPuntuacion = 1000000;
            //condición para todos los números menores de 75% y mayores de 51%
        } else if (puntuacion <= 75) {
            valorPuntuacion = 750000;
            //condición para todos los números menores de 100% y mayores de 76%
        } else if (puntuacion < 100) {
            valorPuntuacion = 250000;
        }
        //mensaje con los puntos obtenidos según la condición 
        JOptionPane.showMessageDialog(null, "          " + valorPuntuacion + " PUNTOS", "PUNTOS OBTENIDOS", 1);
        return valorPuntuacion;
    }

    public static void main(String[] args) {

        //Declaración de variables
        String niveles = "";
        int vuelta;
        float puntuacion = 0;
        int numAleatorio = 0,numAdivina = 0;
        int cuentaErrores = -1;       
        long sumaPuntos = 0;
            
        //do ..while Genera partidas mientras sea cero 
        do {

            //switch para cada caso del menu y llamada al metodo menu()
            switch (menu(niveles)) {

                case 1:
                    JOptionPane.showMessageDialog(null, "¿ LISTO ?", "NIVEL 1", 3);
                    //generador de número aleatorio entre (1-10) y asignación de valores convertidos a enteros
                    numAleatorio = (int) (Math.random() * 10 + 1);
                    System.out.println(numAleatorio);

                    //búcle para generar el ingreso de números mientras sea distinto al numero aleatorio
                    while (numAleatorio != numAdivina) {
                        
                        numAdivina = ingresaNumerito(niveles); //llamda al método para ingresar un número
                        
                        //condición para números fuera del rango, emite un mesaje con el error y recuerda el rango
                        if (numAdivina < 1 || numAdivina > 10) {

                            JOptionPane.showMessageDialog(null, "ES IMPOSIBLE QUE SEA " + numAdivina + " ESTA FUERA DEL RANGO\n\n 1 AL 10\n", "ERROR", 2);
                            cuentaErrores--;//resta uno para que no cuente en el porcentaje de errores cometidos
                        }//fin if
                        cuentaErrores++;//cuenta los errores cometidos
                        
                        //condición que tras haber superado la cantidad de errores, emite un mensaje junto al número y sale del bucle sin dar puntos
                        if (cuentaErrores == 10) {
                            JOptionPane.showMessageDialog(null, "EL NUMERO ERA " + numAleatorio, "PERDISTE", 2);
                            break;//salida del case 1 sin contar porcentaje de errores
                        }//fin del if
                    }//fin del while
                    //calculo de porcentaje de errores cometidos
                    puntuacion = ((cuentaErrores * 100) / 10);
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "¿ LISTO ?", "NIVEL 2", 3);
                    //generador de número aleatorio
                    numAleatorio = (int) (Math.random() * 15 + 1);
                    System.out.println(numAleatorio);
                    
                    while (numAleatorio != numAdivina) {

                        numAdivina = ingresaNumerito(niveles);

                        if (numAdivina < 1 || numAdivina > 15) {

                            JOptionPane.showMessageDialog(null, "ES IMPOSIBLE QUE SEA " + numAdivina + " ESTA FUERA DEL RANGO\n\n 1 AL 15 ", "ERROR", 2);
                            cuentaErrores--;
                        }
                        cuentaErrores++;

                        if (cuentaErrores == 15) {
                            JOptionPane.showMessageDialog(null, "EL NUMERO ERA " + numAleatorio, "PERDISTE", 2);
                            break;
                        }
                    }
                    puntuacion = ((cuentaErrores * 100) / 15);
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "¿ LISTO ?", "NIVEL 3", 3);
                    //generador de número aleatorio
                    numAleatorio = (int) (Math.random() * 20 + 1);
                    System.out.println(numAleatorio);
                    
                    while (numAleatorio != numAdivina) {

                        numAdivina = ingresaNumerito(niveles);

                        if (numAdivina < 1 || numAdivina > 20) {

                            JOptionPane.showMessageDialog(null, "ES IMPOSIBLE QUE SEA " + numAdivina + " ESTA FUERA DEL RANGO\n\n 1 AL 20", "ERROR", 2);
                            cuentaErrores--;
                        }
                        cuentaErrores++;
                        if (cuentaErrores == 20) {
                            JOptionPane.showMessageDialog(null, "EL NUMERO ERA " + numAleatorio, "PERDISTE", 2);
                            break;
                        }
                    }
                    puntuacion = ((cuentaErrores * 100) / 20);
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "¿ LISTO ?", "NIVEL 4", 3);
                    //generador de número aleatorio
                    numAleatorio = (int) (Math.random() * 25 + 1);
                    System.out.println(numAleatorio);
                    
                    while (numAleatorio != numAdivina) {

                        numAdivina = ingresaNumerito(niveles);

                        if (numAdivina < 1 || numAdivina > 25) {

                            JOptionPane.showMessageDialog(null, "ES IMPOSIBLE QUE SEA " + numAdivina + " ESTA FUERA DEL RANGO\n\n 1 AL 25", "ERROR", 2);
                            cuentaErrores--;
                        }
                        cuentaErrores++;
                        if (cuentaErrores == 25) {
                            JOptionPane.showMessageDialog(null, "EL NUMERO ERA " + numAleatorio, "PERDISTE", 2);
                            break;
                        }
                    }
                    puntuacion = ((cuentaErrores * 100) / 25);
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "¿ LISTO ?", "NIVEL 5", 3);
                    //generador de número aleatorio
                    numAleatorio = (int) (Math.random() * 40 + 1);
                    System.out.println(numAleatorio);
                    
                    while (numAleatorio != numAdivina) {

                        numAdivina = ingresaNumerito(niveles);

                        if (numAdivina < 1 || numAdivina > 40) {

                            JOptionPane.showMessageDialog(null, "ES IMPOSIBLE QUE SEA " + numAdivina + " ESTA FUERA DEL RANGO\n\n 1 AL 40", "ERROR", 2);
                            cuentaErrores--;
                        }
                        cuentaErrores++;
                        if (cuentaErrores == 40) {
                            JOptionPane.showMessageDialog(null, "EL NUMERO ERA " + numAleatorio, "PERDISTE", 2);
                            break;
                        }
                    }
                    puntuacion = ((cuentaErrores * 100) / 40);
                    break;
                    
                    //Default en caso de haber ingresado mal la opción
                default:
                    JOptionPane.showMessageDialog(null, "LA OPCIÓN NO EXISTE", "TE EQUIVOCASTE", 1);
                    break;
            }//fin de Switch
            
            //muestra la respuesta del número aleatorio y errores cometidos tras haber jugado 
            JOptionPane.showMessageDialog(null, "¡ FELICIDADES !\n\n EL NÚMERO ES " + numAleatorio + "\n\n COMETISTE " + cuentaErrores + " ERRORES\n", "¡ ADIVINASTE !", 1);

            //acumulador de puntos y llamada al método para mostrar los puntos obtnidos
            sumaPuntos += (puntos((int) puntuacion));
            
            //ingreso de opción para volver a jugar o salir
            niveles = JOptionPane.showInputDialog(null, " ( 0 ) JUGAR / ( OTRO Nº ) SALIR  ", " ¿ QUIERES JUGAR OTRA VEZ ?", 3);
            vuelta = Integer.parseInt(niveles);

            cuentaErrores = -1;//vuelve a inicializar el contador de errores

        } while (vuelta == 0);//while de vuelta al juego  
        
        //Mensaje con los puntos acumulados de las partidas realizadas y despedida del juego
        JOptionPane.showMessageDialog(null, "           " + sumaPuntos + " PUNTOS ", "PUNTOS ACUMULADOS", 1);
        JOptionPane.showMessageDialog(null, "    HASTA LA PROXIMA GAMER ", "¡ HO !", 1);
        
    }//fin del main

}//fin de la clase
