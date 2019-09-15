package aCorrer;

public class Participante {

	int id;
	char sexo;
	int edad;
	int ordenLlegada;
	int categoria;
	
	public Participante(int id, int edad, char sexo) {
		
		this.id = id;
		this.edad = edad;
		this.sexo = sexo;
	}
	
	public void calcularCategoria(int[][] categoriasFemeninas,int[][] categoriasMasculinas) {
		
		if (this.sexo == 'F') {
			for (int i = 1 ; i < categoriasFemeninas.length ; i++)
				if (this.edad > categoriasFemeninas[i][1] && this.edad <= categoriasFemeninas[i][2])
					this.categoria = i;	
		}
		
		if (this.sexo == 'M') {
			for (int i = 1 ; i < categoriasMasculinas.length ; i++)
				if (this.edad > categoriasMasculinas[i][1] && this.edad <= categoriasMasculinas[i][2])
					this.categoria = i;	
		}
	}

	public void calcularLlegada(int[] llegadas) {
		
		for (int i = 1 ; i < llegadas.length ; i++) {
			if (llegadas[i] == this.id)
				ordenLlegada = i;
		}
	}

}
