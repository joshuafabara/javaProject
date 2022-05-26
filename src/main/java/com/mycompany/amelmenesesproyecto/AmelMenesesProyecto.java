/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.amelmenesesproyecto;

/**
 *
 * @author amelmeneses
 * 
 * Proyecto Final Amel Meneses
 * 
 * Programa de Información Equipo/Grupo deportivo
 * 
 * El siguiente programa permite al usuario ingresar los datos principales de un grupo/equipo deportivo tales como:
 * Número de integrantes, nombre y apellido, fecha de nacimiento y estatura de cada integrante.
 * 
 * A partir de los datos ingresados el usuario puede por medio de un menú elegir entre las siguientes opciones: 
 * 
 * - Persona de mayor edad del grupo.
 * - Persona de menor edad del grupo.
 * - Persona de mayor estatura del grupo.
 * - Persona de menor estatura del grupo.
 * - Promedio de edad en años del grupo.
 * - Promedio de estatura del grupo.
 * - Número de personas adultas en el grupo.
 * - Número de personas menores de edad en el grupo.
 * - Peso ideal para la persona del grupo que elija el usuario usando un menú con todos los integrantes.
 * - Elegir integrante al azar para prueba antidoping.
 */

import java.util.Scanner;
import java.text.SimpleDateFormat;  
import java.util.concurrent.TimeUnit;
import java.util.Date;  
public class AmelMenesesProyecto {

    public static void main(String[] args) {
        // Se usa Scanner para poder obtener el input del usuario
        Scanner in = new Scanner(System.in);
        System.out.println("****   Información de un equipo deportivo   ****");
        System.out.println();
        System.out.println("Ingrese el número de integrantes del equipo/grupo deportivo");
        //String s = in.nextLine();
        //System.out.println("You entered string " + s);
        
        // A prueba de usuarios, validar que sea un entero
//        while (!in.hasNextInt())
//        {
//            System.out.println("Ingrese un número por favor");
//            in.next();
//        }
        esInt(in);
        int numIntegrantes = in.nextInt();
        
        // Saltar caracter de nueva línea luego del nextInt()
        in.nextLine();
   
        //System.out.println("You entered integer " + a);
 
        //float b = in.nextFloat();
        System.out.println("El equipo consta de " + numIntegrantes + " integrantes");
        System.out.println("----------------------------------");
        String[][] informacionEquipo = new String[3][numIntegrantes];
        String inputDate = "";
        boolean fechaNoValida = true;
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
   
 
        // LLenado de matriz de información del equipo
        // Primera fila para nombres y apellidos
        // segunda fila para fecha de nacimiento
        // tercera fila para estatura
        for (int fila = 0; fila < informacionEquipo.length; fila++)
        {
            for (int col = 0; col < informacionEquipo[fila].length; col++)
            {
                switch(fila) {
                    case 0:
                        System.out.println("Ingrese el nombre y apellido del integrante Nro " + (col + 1));
                        informacionEquipo[fila][col] = in.nextLine();
                      break;
                    case 1:
                        System.out.println("Ingrese la fecha de nacimiento de " + informacionEquipo[0][col] + " en formato dd/MM/yyyy");
                        while (fechaNoValida) {
                            try {
                                inputDate = in.next();
                                Date fechaCorrecta=formatter1.parse(inputDate);
//                                System.out.println(inputDate+"\t"+fechaCorrecta);
                                informacionEquipo[fila][col] = inputDate;
                                fechaNoValida = false;
                            }catch(Exception e) {
                                System.out.println("Formato incorrecto en la fecha ingresada, por favor usar el formato dd/MM/yyyy");
                            }
                        }
                        fechaNoValida = true;
                      break;
                    case 2:
                        System.out.println("Ingrese la estatura en centímetros de " + informacionEquipo[0][col]);
                        esFloat(in);
                        informacionEquipo[fila][col] = in.next();
                      break;
                    default:
                }
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("--------- Menú de opciones ---------");
        System.out.println("Elija una opción del menú");
        System.out.println();
        System.out.println("1. Persona mayor de edad del equipo");
        System.out.println("2. Persona menor de edad del equipo");
        System.out.println("3. Persona más alta del equipo");
        System.out.println("4. Persona más baja del equipo");
        System.out.println("5. Promedio de edad del equipo");
        System.out.println("6. Promedio de estatura del equipo");
        System.out.println("7. Número de personas adultas del equipo");
        System.out.println("8. Número de personas menores de edad del equipo");
        System.out.println("9. Número de personas menores de edad del equipo");
        System.out.println("10. Peso ideal para una persona del equipo");
        System.out.println("11. Elegir al azar una persona para prueba antidoping");

        imprimirMatriz(informacionEquipo);
        long edad = calcularEdadEntera(informacionEquipo[1][1]);
        System.out.println("La edad es: " + edad);
        double edadDecimal = calcularEdadDecimal(informacionEquipo[1][1]);
        System.out.println("La edad es: " + edadDecimal);
        int posicionDelMayor = posicionMayorDelGrupo(informacionEquipo);
        System.out.println("La persona mayor es: " + informacionEquipo[0][posicionDelMayor]);
        int posicionMasAlto = posicionMayorDelGrupo(informacionEquipo);
        System.out.println("La persona mas alta es: " + informacionEquipo[0][posicionMasAlto]);
    }
    
    public static void imprimirMatriz(String mat[][])
    {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++) {
 
            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }
    
    // Función para validar enteros
    public static void esInt(Scanner in) {
        while (!in.hasNextInt())
        {
            System.out.println("Ingrese un número por favor");
            in.next();
        }
    }
    
    // Función para validar floats
    public static void esFloat(Scanner in) {
        while (!in.hasNextFloat())
        {
            System.out.println("Ingrese un número válido por favor");
            in.next();
        }
    }
    
    // Funcion para calcular la edad de una persona a partir de una cadena con formato correcto de fecha
    public static long calcularEdadEntera(String fechaNacimiento) {
        Date fechaActual = new Date();
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        long diferenciaDeTiempo = 0;
        
        try {
            Date fecha = formatter1.parse(fechaNacimiento);
            diferenciaDeTiempo = fechaActual.getTime() - fecha.getTime();
            diferenciaDeTiempo = TimeUnit
                      .MILLISECONDS
                      .toDays(diferenciaDeTiempo)
                  / 365l;
        }catch(Exception e) {
            // No puede haber error porque ya validamos al momento de que el usuario ingresa los datos, el try catch es obligatorio.
        }
        
        return diferenciaDeTiempo;
    }
    
    // Funcion para calcular la edad de una persona a partir de una cadena con formato correcto de fecha con decimales
    public static double calcularEdadDecimal(String fechaNacimiento) {
        Date fechaActual = new Date();
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        long diferenciaDeTiempo = 0;
        double anios = 0;
        
        try {
            Date fecha = formatter1.parse(fechaNacimiento);
            diferenciaDeTiempo = fechaActual.getTime() - fecha.getTime();
            anios = TimeUnit.DAYS.convert(diferenciaDeTiempo, TimeUnit.MILLISECONDS);
            anios = anios/365;
        }catch(Exception e) {
            // No puede haber error porque ya validamos al momento de que el usuario ingresa los datos, el try catch es obligatorio.
        }
        
        return anios;
    }
    
    // Funcion para encontrar la posicion de la persona de mayor edad del grupo
    public static int posicionMayorDelGrupo(String[][] matrizDeInfo) {
        int posicionMayor = -1, i = 0;
        double edadMayor = 0, edad;
        
        while(i < matrizDeInfo[1].length) {
            if (i == 0) {
                posicionMayor = i;
                edadMayor = calcularEdadDecimal(matrizDeInfo[1][i]);
            } 
            else {
                edad = calcularEdadDecimal(matrizDeInfo[1][i]);
                if (edad > edadMayor) {
                    edadMayor = edad;
                    posicionMayor = i;
                }
            }
            i++;
        }
        
        return posicionMayor;
    }
    
    // Funcion para encontrar la posicion de la persona de mayor estatura del grupo usando sobrecarga de funciones
    public static int posicionMayorDelGrupo(String[][] matrizDeInfo, boolean paraEstatura) {
        int posicionMayor = -1, i = 0;
        double estaturaMayor = 0, estatura;
        
        while(i < matrizDeInfo[2].length) {
            if (i == 0) {
                posicionMayor = i;
                estaturaMayor = Integer.parseInt(matrizDeInfo[2][i]);
            } 
            else {
                estatura = Integer.parseInt(matrizDeInfo[2][i]);
                if (estatura > estaturaMayor) {
                    estaturaMayor = estatura;
                    posicionMayor = i;
                }
            }
            i++;
        }
        
        return posicionMayor;
    }
}