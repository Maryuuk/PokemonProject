package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import beans.Pokemon;

public class Registro {

	public void resultadoCombate(Pokemon pokemon1, Pokemon pokemon2, Pokemon ganador) {
		
		try {
			// Crea un nuevo archivo en el directorio especificado
			// Crea un arraylist donde guarda los resultados de los combates que ya estén escritos
			// Escribe los anteriores combates, si los hay, y el que acaba de finalizar
            File resultados = new File("src/exports/combates.md");
            resultados.createNewFile();
            FileWriter escritor;
            Scanner lector = new Scanner(resultados);
            ArrayList<String> lineasOriginales = new ArrayList<String>();
            
            while(lector.hasNextLine()) {
                lineasOriginales.add(lector.nextLine());
            }
            
            escritor = new FileWriter(resultados);
            Date fecha = new Date();
            
            escritor.write(String.join("\n", lineasOriginales) + "\n");
            
            escritor.write("## COMBATE\n");
            escritor.write("*"+fecha.toString()+"*\n");
            escritor.write("- Pokemon aliado: \n\t"+pokemon1.toString());
            escritor.write("- Pokemon enemigo: \n\t"+pokemon2.toString());
            if(ganador != null) {
            	escritor.write("\nEl ganador del combate ha sido: **"+ganador.getNombre()+"**");
            } else {
            	escritor.write("\nHa ocurrido un empate, no hay ganador.");
            }
            escritor.write("\n***");
            escritor.close();
		} catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public void leerResultado() {
		
		// Lee por consola el archivo del directorio especificado
		String linea = "";
        File resultados = new File("src/exports/combates.md");
        try{
            Scanner lector = new Scanner(resultados);
            while(lector.hasNextLine()){
                linea = lector.nextLine();
                System.out.println(linea);
            }
        } catch(FileNotFoundException e) {
            System.out.println("\nNo existe ningun combate registrado.");
        }
		
	}
	
}
