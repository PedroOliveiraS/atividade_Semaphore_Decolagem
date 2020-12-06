package br.edu.iftm.tests;

import java.util.Random;
import java.util.concurrent.Semaphore;

import br.edu.iftm.threads.AviaoThread;

public class AviaoTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeroAvioes = 12;
		int numDecolagens = 1;
		
		Semaphore semaforoNorte = new Semaphore(numDecolagens);
		Semaphore semaforoSul = new Semaphore(numDecolagens);
		
		AviaoThread[] processos = new AviaoThread[numeroAvioes];
		
		for(int i = 0; i < numeroAvioes; i++) {
			Random generator = new Random();
			int r = generator.nextInt(2);
			if(r == 0) { // NORTE
				processos[i] = new AviaoThread(i, semaforoNorte, "Pista Norte: ");
				processos[i].start();
			}
			if(r == 1) { // SUL
				processos[i] = new AviaoThread(i, semaforoSul, "Pista Sul: ");
				processos[i].start();
			}
		}
	}

}
