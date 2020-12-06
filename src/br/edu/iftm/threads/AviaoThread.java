package br.edu.iftm.threads;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class AviaoThread extends Thread{

	private int idAviao;
	private Semaphore semaforo;
	private int controlArea;
	private String area;
	
	public AviaoThread(int idAviao, Semaphore semaforo, String area) {
		this.idAviao = idAviao;
		this.semaforo = semaforo;
		this.area = area;
	}
	
	// Dura 3 a 7 segundos
	private void manobrar() {
		System.out.println(area + "Avião #" + idAviao + " está manobrando");
		Random generator = new Random();
		int r = generator.nextInt(5) + 3;
		try {
			Thread.sleep(r * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Dura 5 a 10 segundos
	private void taxiar() {
		System.out.println(area + "Avião #" + idAviao + " está taxiando");
		Random generator = new Random();
		int r = generator.nextInt(6) + 5;
		try {
			Thread.sleep(r * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Dura 1 a 4 segundos
	private void decolar() {
		System.out.println(area + "Avião #" + idAviao + " está decolando");
		Random generator = new Random();
		int r = generator.nextInt(4) + 1;
		try {
			Thread.sleep(r * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Dura 3 a 8 segundos
	private void afastarArea() {
		System.out.println(area + "Avião #" + idAviao + " está se afastando da área");
		Random generator = new Random();
		int r = generator.nextInt(5) + 3;
		try {
			Thread.sleep(r * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Run
	public void run() {
		manobrar();
		taxiar();
		
		try {
			semaforo.acquire();
			decolar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			afastarArea();
			semaforo.release();
		}
	}
}
