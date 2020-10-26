package com.company;

import java.util.Scanner;

import clases.CapacidadEndeudamiento;
import clases.Constantes;

public class Main {
	 static boolean numero;
	 private static Scanner in;

	//Recuerda que aca empieza todo
	public static void main(String[] args) {
		in = new Scanner(System.in);
	
	    //Esto te dara la primera entrada al proceso de solicitar los datos para instancir nuestro objeto
        // CapacidadEndedudamiento()
		CapacidadEndeudamiento capacidadendeudamiento = new CapacidadEndeudamiento ();
        System.out.println(Constantes.TEXTO_INGRESOS_TOTALES);
        
        String Texto = in.nextLine();
        numero = isNumeric(Texto);
        
        if (numero) {
        	
        	int ingresosTotales = Integer.parseInt(Texto);        	
            capacidadendeudamiento.setIngresosTotales(ingresosTotales);
        
            String entrada = "SI";
            while (entrada.equals("SI")) {
            	System.out.println(Constantes.TEXTO_GASTOS_FIJOS);
            	Texto = in.nextLine();
            	numero = isNumeric(Texto);
            	
            	if (numero) {
            		int gastosfijos = Integer.parseInt(Texto);
            		capacidadendeudamiento.setGastosFijos(gastosfijos);
            		System.out.println(Constantes.TEXTO_GASTOS_VARIABLES);
            		Texto = in.nextLine();
                	numero = isNumeric(Texto);
                	
                	if (numero) {
                		int gastosvariables = Integer.parseInt(Texto);
                		capacidadendeudamiento.setGastoVaribales(gastosvariables);	
                		
                		capacidadendeudamiento.getIngresosTotales();
                		capacidadendeudamiento.getGastosFijos();
                		capacidadendeudamiento.getGastoVaribales();
                		System.out.println(capacidadendeudamiento.getCapacidadEndeudamiento());
                		
                		entrada = "NO";
                	}
                	else {
                    	System.out.println(Constantes.ERROR_GASTOS_VARIABLES);
                    }	
            	}
            	else {
                	System.out.println(Constantes.ERROR_GASTOS_FIJOS);
                }
            }
        }
        else {
        	System.out.println(Constantes.ERROR_INGRESOS_TOTALES);
        }
	}

    //Valida las entradas de los usuarios que no vayas a convertir una "A" numero y el calculo no te funcione
    //Utiliza el metodo is numeric para vada entrada de ser necesarios
	
    public static boolean isNumeric(String value) {
        // implementa un bloque try catch aca
    	
    	try {
    		Double.parseDouble(value);
    		return true;
    	}
        catch(NumberFormatException e) {
        	return false;
        }	
    }
	
}
