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
import java.util.Random;
import java.util.Arrays;
import java.text.DecimalFormat;

public class AmelMenesesProyecto {
    // Formato para presentar solo 2 decimales en un double.
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        // Se usa Scanner para poder obtener el input del usuario
        Scanner in = new Scanner(System.in);
        System.out.println(aModoTitulo(" amel  sabine  meneses iMbaquingo "));
        System.out.println("****   Información de un equipo deportivo   ****");
        System.out.println();
        System.out.println("Ingrese el número de integrantes del equipo/grupo deportivo");

        esInt(in);
        int numIntegrantes = in.nextInt();
        
        // Saltar caracter de nueva línea luego del nextInt()
        in.nextLine();
 
        System.out.println("El equipo consta de " + numIntegrantes + " integrantes");
        System.out.println("----------------------------------");
        String[][] informacionEquipo = new String[3][numIntegrantes];
        String inputDate = "";
        String nombreApellidoInput, nombreApellidoTitulo;
        String continuar = "";
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
                        
                        //Almacenamos nombre y apellido ingresados en la matriz
                        informacionEquipo[fila][col] = in.nextLine();
                        // Asignamos el nombre y apellido ingresados a la variable nombreApellidoInput para corregirlo
                        nombreApellidoInput = informacionEquipo[fila][col];
                        //Usamos replace para reemplazar el contenido original de nombreApellidoInput con el nombre y apellido a modo título.
                        nombreApellidoTitulo = nombreApellidoInput.replace(nombreApellidoInput, aModoTitulo(nombreApellidoInput));
                        // Ponemos en la matriz el nombre y apellido corregidos a modo título.
                        informacionEquipo[fila][col] = nombreApellidoTitulo;
                      break;
                    case 1:
                        System.out.println("Ingrese la fecha de nacimiento de " + informacionEquipo[0][col] + " en formato dd/MM/yyyy");
                        while (fechaNoValida) {
                            try {
                                inputDate = in.next();
                                Date fechaCorrecta=formatter1.parse(inputDate);
                                informacionEquipo[fila][col] = inputDate;
                                fechaNoValida = false;
                            }catch(Exception e) {
                                System.out.println("Formato incorrecto en la fecha ingresada, por favor usar el formato dd/MM/yyyy");
                            }
                        }
                        fechaNoValida = true;
                      break;
                    case 2:
                        System.out.println("Ingrese la estatura en metros de " + informacionEquipo[0][col]);
                        esDouble(in);
                        informacionEquipo[fila][col] = in.next();
                      break;
                    default:
                }
                System.out.println();
            }
        }
        
        do {
            continuar = "";
            generarMenuPrincipal(in, informacionEquipo);
            
            while(!"SI".equals(continuar) && !"NO".equals(continuar)) {
                System.out.println("¿ Desea continuar ? (Responda SI/NO)");
                continuar = (in.nextLine()).toUpperCase();
            }
            
            if ("NO".equals(continuar))
                salirDelPrograma();
        } while("SI".equals(continuar));

//        long edad = calcularEdadEntera(informacionEquipo[1][1]);
//        System.out.println("La edad es: " + edad);
//        double edadDecimal = calcularEdadDecimal(informacionEquipo[1][1]);
//        System.out.println("La edad es: " + edadDecimal);
//        int posicionDelMayor = posicionMayorDelGrupo(informacionEquipo);
//        System.out.println("La persona mayor es: " + informacionEquipo[0][posicionDelMayor]);
//        int posicionDelMenor = posicionMenorDelGrupo(informacionEquipo);
//        System.out.println("La persona menor es: " + informacionEquipo[0][posicionDelMenor]);
//        int posicionMasAlto = posicionMayorDelGrupo(informacionEquipo, true);
//        System.out.println("La persona mas alta es: " + informacionEquipo[0][posicionMasAlto]);
//        int posicionMenosAlto = posicionMenorDelGrupo(informacionEquipo, true);
//        System.out.println("La persona menos alta es: " + informacionEquipo[0][posicionMenosAlto]);
//        System.out.println("El promedio de edad del grupo es: " + promedio(informacionEquipo));
//        System.out.println("El promedio de estatura del grupo es: " + promedio(informacionEquipo, true));
//        System.out.println("El número de adultos es: " + adultos(informacionEquipo));
//        System.out.println("El número de menores de edad es: " + menores(informacionEquipo));
//        System.out.println("El peso recomendado de Prueba 1.85 30 años es: " + pesoRecomendado(1.75, 32) + "kg");
//        sorteoDopping(informacionEquipo);
//        ordenarAlfabeticamenteNombres(nombres);
//        imprimirArr(nombres);
    }
    
    public static void imprimirArr(String mat[][])
    {
        // Barrer filas
        for (int i = 0; i < mat.length; i++) {
 
            // Barrar columnas de cada fila
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }
    
    public static void imprimirArr(String arr[])
    {
        // Barrer cada elemento del arreglo
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        
        System.out.println();
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
    public static void esDouble(Scanner in) {
        while (!in.hasNextDouble())
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
    
    // Funcion para encontrar la posicion de la persona de menor edad del grupo
    public static int posicionMenorDelGrupo(String[][] matrizDeInfo) {
        int posicionMenor = -1, i = 0;
        double edadMenor = 0, edad;
        
        while(i < matrizDeInfo[1].length) {
            if (i == 0) {
                posicionMenor = i;
                edadMenor = calcularEdadDecimal(matrizDeInfo[1][i]);
            } 
            else {
                edad = calcularEdadDecimal(matrizDeInfo[1][i]);
                if (edad < edadMenor) {
                    edadMenor = edad;
                    posicionMenor = i;
                }
            }
            i++;
        }
        
        return posicionMenor;
    }
    
    // Función para encontrar la posicion de la persona de mayor estatura del grupo usando sobrecarga de funciones
    public static int posicionMayorDelGrupo(String[][] matrizDeInfo, boolean paraEstatura) {
        int posicionMayor = -1, i = 0;
        double estaturaMayor = 0, estatura;
        
        while(i < matrizDeInfo[2].length) {
            if (i == 0) {
                posicionMayor = i;
                estaturaMayor = Double.parseDouble(matrizDeInfo[2][i]);
            } 
            else {
                estatura = Double.parseDouble(matrizDeInfo[2][i]);
                if (estatura > estaturaMayor) {
                    estaturaMayor = estatura;
                    posicionMayor = i;
                }
            }
            i++;
        }
        
        return posicionMayor;
    }
    
    // Funcion para encontrar la posicion de la persona de menor estatura del grupo usando sobrecarga de funciones
    public static int posicionMenorDelGrupo(String[][] matrizDeInfo, boolean paraEstatura) {
        int posicionMenor = -1, i = 0;
        double estaturaMenor = 0, estatura;
        
        while(i < matrizDeInfo[2].length) {
            if (i == 0) {
                posicionMenor = i;
                estaturaMenor = Double.parseDouble(matrizDeInfo[2][i]);
            } 
            else {
                estatura = Double.parseDouble(matrizDeInfo[2][i]);
                if (estatura < estaturaMenor) {
                    estaturaMenor = estatura;
                    posicionMenor = i;
                }
            }
            i++;
        }
        
        return posicionMenor;
    }
    
    //Función para sacar el promedio de Edad.
    public static double promedio(String[][] matrizDeInfo) {
        double promedio = 0;
        int i = 0;
        
        while(i < matrizDeInfo[1].length) {
            promedio += calcularEdadDecimal(matrizDeInfo[1][i]);
            i++;
        }
        
        promedio /= matrizDeInfo[1].length;
        
        return promedio;
    }
    
    //Función para sacar el promedio de estatura usando sobrecarga de funciones.
    public static double promedio(String[][] matrizDeInfo, boolean paraEstatura) {
        double promedio = 0;
        int i = 0;
        while(i < matrizDeInfo[2].length) {
            promedio += Double.parseDouble(matrizDeInfo[2][i]);
            i++;
        }
        
        promedio /= matrizDeInfo[2].length;
        
        return promedio;
    }
    
    //Función para calcular el total de adultos del grupo
    public static int adultos(String[][] matrizDeInfo) {
        int adultos = 0, i = 0;
        
        while(i < matrizDeInfo[1].length) {
            if (calcularEdadEntera(matrizDeInfo[1][i]) >= 18)
                adultos++;
            i++;
        }
        
        return adultos;
    }
    
    //Función para calcular el total de menores de edad del grupo
    public static int menores(String[][] matrizDeInfo) {
        int menores = 0, i = 0;
        
        while(i < matrizDeInfo[1].length) {
            if (calcularEdadEntera(matrizDeInfo[1][i]) < 18)
                menores++;
            i++;
        }
        
        return menores;
    }
    
    //Elige una persona al azar para el test antidopping
    public static void sorteoDopping(String[][] matrizDeInfo) {
        Random rand = new Random(); //instance of random class
        int limiteSuperior = matrizDeInfo[0].length - 1;
        
        //Generar num random entre 0 y última posición
        int intRandom = rand.nextInt(limiteSuperior);
        
        System.out.println("La persona elegida para el control antidopping es: " + matrizDeInfo[0][intRandom]);
    }
    
    //Ordenar arreglo que viene como parámetro por referencia
    public static void ordenarAlfabeticamenteNombres(String[] nombresDesordenados) {
        Arrays.sort(nombresDesordenados);
    }
    
    public static double pesoRecomendado(double estatura, int edad) {
        double  pesoRecomendado;
        
        pesoRecomendado = (((estatura * 100) - 100) + edad / 10) * 0.9;
        
        return pesoRecomendado;
    }
    
    // Función que recibe una cadena y la transforma a modo título, esto es cada palabra tiene su primera letra en mayúscula y el resto en minúscula.
    public static String aModoTitulo(String cadena) {
        String aModoTitulo, caracterInicial, restoDePalabra, palabraAModoTitulo;
        int i =0;
        // Primero removemos espacios al inicio y al final de la cadena
        aModoTitulo = cadena.trim();
        
        // Separa la cadena en un arreglo de palabras por espacios en blanco, ignora múltiples espacios seguidos.
        String[] palabras = aModoTitulo.split("\\s+");

        while(i < palabras.length) {
            // Sacamos el caracter inicial de cada palabra en la variable caracterInicial
            caracterInicial = palabras[i].substring(0, 1);
            // Sacamos el resto de cada palabra en la variabla restoDePalabra, 
            //no se envía el segundo parámetro para que llegue hasta el final de la cadena.
            restoDePalabra = palabras[i].substring(1);
            // Pasamos el caracterInicial a mayúscula.
            caracterInicial = caracterInicial.toUpperCase();
            // Pasamos el restoDePalabra a minúscula.
            restoDePalabra = restoDePalabra.toLowerCase();
            
            // Unimos el caracterInicial al restoDePalabra
            palabraAModoTitulo = caracterInicial + restoDePalabra;
            
            // Sobreesribimos esa palabra en el arreglo de palabras
            palabras[i] = palabraAModoTitulo;
            i++;
        }
        
        // Volvemos a unir el arreglo de palabras en un solo String separado por espacios.
        aModoTitulo = String.join(" ", palabras);
        return aModoTitulo;
    }
    
    public static void generarMenuPrincipal(Scanner in, String[][] informacionEquipo) {
        boolean opcionValida = false;
        int opcion = 0;
        
        do {
            limpiarConsola();
            imprimirArr(informacionEquipo);
            System.out.println();
            System.out.println("--------- Menú de opciones ---------");
            System.out.println("Elija una opción del menú");
            System.out.println();
            System.out.println("1. Persona de mayor edad del equipo");
            System.out.println("2. Persona menor de edad del equipo");
            System.out.println("3. Persona más alta del equipo");
            System.out.println("4. Persona más baja del equipo");
            System.out.println("5. Promedio de edad del equipo");
            System.out.println("6. Promedio de estatura del equipo");
            System.out.println("7. Número de personas adultas del equipo");
            System.out.println("8. Número de personas menores de edad del equipo");
            System.out.println("9. Peso ideal para una persona del equipo");
            System.out.println("10. Elegir al azar una persona para prueba antidoping");
            System.out.println("11. Mostrar los nombres de los integrantes ordenados alfabéticamente");
            System.out.println("12. Salir del programa.");
            
            // Verificamos si la opción es un número
            if (in.hasNextInt()) {
                opcion = in.nextInt();
                
                // Si la opción es un número verificamos que se encuentre entre las opciones disponibles
                if (opcion > 0 && opcion <= 12) {
                    opcionValida = true;
                    
                    switch(opcion) {
                        case 1:
                            int posicionDelMayor = posicionMayorDelGrupo(informacionEquipo);
                            System.out.println("La persona mayor es: " + informacionEquipo[0][posicionDelMayor] + ".");
                          break;
                        case 2: 
                            int posicionDelMenor = posicionMenorDelGrupo(informacionEquipo);
                            System.out.println("La persona menor es: " + informacionEquipo[0][posicionDelMenor] + ".");
                          break;
                        case 3: 
                            int posicionMasAlto = posicionMayorDelGrupo(informacionEquipo, true);
                            System.out.println("La persona más alta es: " + informacionEquipo[0][posicionMasAlto] + ".");
                          break;
                        case 4: 
                            int posicionMenosAlto = posicionMenorDelGrupo(informacionEquipo, true);
                            System.out.println("La persona más baja es: " + informacionEquipo[0][posicionMenosAlto] + ".");
                          break;
                        case 5: 
                            System.out.println("El promedio de edad del equipo es: " + df.format(promedio(informacionEquipo)) + " años.");
                          break;
                        case 6: 
                            System.out.println("El promedio de estatura del grupo es: " + df.format(promedio(informacionEquipo, true)) + " metros.");
                          break;
                        case 7: 
                            System.out.println("El número de adultos es: " + adultos(informacionEquipo) + ".");
                          break;
                        case 8:  
                            System.out.println("El número de menores de edad es: " + menores(informacionEquipo) + ".");
                          break;
                        case 9: 
                            System.out.println("Peso ideal");
                          break;
                        case 10: 
                            sorteoDopping(informacionEquipo);
                          break;
                        case 11:
                            String[] nombres = new String[informacionEquipo[0].length];
                            int i = 0;
                            // Copiamos cada nombre y apellido en el arreglo que será ordenado para no alterar la matriz original.
                            while(i < nombres.length) {
                                nombres[i] = informacionEquipo[0][i];
                                i++;
                            }
                            ordenarAlfabeticamenteNombres(nombres);
                            System.out.println("Lista de integrantes en orden alfabético");
                            imprimirArr(nombres);
                          break;
                        case 12: 
                            salirDelPrograma();
                          break;
                        default:
                          // code block
                    }
                } else {
                    // La opcion no es correcta
                    System.out.println("Opción incorrecta.");
                }
            } else {
                // La opcion no es correcta, no es un número
                System.out.println("Opción incorrecta.");
            }
            // Saltar caracter de nueva línea luego del nextInt()
            in.nextLine();
        }
        while (opcionValida == false);
    }
    
    public static void salirDelPrograma() {
        System.out.println();
        System.out.println();
        System.out.println("************************************************************************");
        System.out.println("Gracias por utilizar el programa de información de un equipo deportivo");
        System.exit(0);
    }
    
    public static void limpiarConsola() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
