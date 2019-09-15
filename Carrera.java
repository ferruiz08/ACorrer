package aCorrer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Carrera {

	int cantParticipantes;
	int cantCategoriasFemeninas;
	int cantCategoriasMasculinas;
	int cantLlegadas;
	int [][] categoriasFemeninas;
	int [][] categoriasMasculinas;
	Participante participante[];
	int [] llegadas;
	int [][] podioFemenino;
	int [][] podioMasculino;
	
	public Carrera(String path) throws IOException {
		
		try {

            File f = new File(path);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            String[] readLineaSplit;

            //Leo la 1er linea para armar la cantidad de participantes , de categorias y de corredores que llegaron a la meta
            readLine = b.readLine();
            readLineaSplit = readLine.split(" ");
            cantParticipantes = Integer.parseInt(readLineaSplit[0]);
            participante = new Participante[cantParticipantes+1];
            cantCategoriasFemeninas = Integer.parseInt(readLineaSplit[1]);
            cantCategoriasMasculinas = Integer.parseInt(readLineaSplit[2]);
            categoriasFemeninas = new int[cantCategoriasFemeninas+1][3];
            categoriasMasculinas = new int[cantCategoriasMasculinas+1][3];  	
            cantLlegadas = Integer.parseInt(readLineaSplit[3]);
            llegadas = new int[cantLlegadas+1];
            podioFemenino = new int[cantCategoriasFemeninas+1][4];
            podioMasculino = new int[cantCategoriasMasculinas+1][4];
            
            //Leo la cantidad de lineas de categorias femeninas y guardo los rangos de edades
            for (int i = 1 ; i <= cantCategoriasFemeninas ; i++) {
            	readLine = b.readLine();
            	readLineaSplit = readLine.split(" ");
            	categoriasFemeninas[i][1] = Integer.parseInt(readLineaSplit[0]);
            	categoriasFemeninas[i][2] = Integer.parseInt(readLineaSplit[1]);
            	
            }
            
          //Leo la cantidad de lineas de categorias masculinas y guardo los rangos de edades
            for (int i = 1 ; i <= cantCategoriasMasculinas ; i++) {
            	readLine = b.readLine();
            	readLineaSplit = readLine.split(" ");
            	categoriasMasculinas[i][1] = Integer.parseInt(readLineaSplit[0]);
            	categoriasMasculinas[i][2] = Integer.parseInt(readLineaSplit[1]);
            	
            }
            
          //Leo la cantidad de lineas de participantes y guardo id, edades y sexo
            for (int i = 1 ; i <= cantParticipantes ; i++) {
            	readLine = b.readLine();
            	readLineaSplit = readLine.split(" ");
            	participante[i] = new Participante(i,Integer.parseInt(readLineaSplit[0]),readLineaSplit[1].charAt(0));
            	
            }
            
            //Leo la cantidad de lineas de participantes que llegaron a la meta
            for (int i = 1 ; i <= cantLlegadas ; i++) {
            	readLine = b.readLine();
            	readLineaSplit = readLine.split(" ");
            	llegadas[i] = Integer.parseInt(readLineaSplit[0]);
            	
            }

            b.close();      
        } catch (IOException e) {
            e.printStackTrace();
        }

		
		
	}
	
	public void calcularCategoriasParticipantes() {

		for (int i = 1 ; i <= cantParticipantes ; i++) {
			participante[i].calcularCategoria(categoriasFemeninas, categoriasMasculinas);
		}
	}

	public void imprimirParticipantes() {
		
		for (int i = 1 ; i <= cantParticipantes ; i++) {
			System.out.println("Participante Nro: " + participante[i].id);
			System.out.println("Participante sexo: " + participante[i].sexo);
			System.out.println("Participante edad: " + participante[i].edad);
			System.out.println("Participante categoria: " + participante[i].categoria);
			System.out.println("Participante orden llegada: " + participante[i].ordenLlegada);
			System.out.println("------------------------------------------");
		}
	}

	public void calcularLlegadas() {
		
		for (int i = 1 ; i <= cantParticipantes ; i++) {
			participante[i].calcularLlegada(llegadas);
		}
	}
	
	public void calcularPodios() {
		
		for (int i = 0 ; i <= cantParticipantes ; i++) {
			
			
			
		}
	}
}
