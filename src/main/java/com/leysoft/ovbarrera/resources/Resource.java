package com.leysoft.ovbarrera.resources;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {
	
	private int[] array;
	
	private int suma;
	
	private double promedio;
	
	private Lock lock;

	public Resource(int[] array) {
		this.array = array;
		this.suma = 0;
		this.promedio = 0.0;
		this.lock = new ReentrantLock();
	}
	
	public int getSuma() {
		return suma;
	}

	public double getPromedio() {
		return promedio;
	}

	public void suma(int inicio, int fin) {
		int suma = 0;
		for(int i = inicio; i < fin; i++) {
			suma += array[i];
		}
		System.out.println("suma("+ inicio +", " + fin + ")... " + suma + " " + Thread.currentThread().getName());
		lock.lock();
		this.suma += suma;
		lock.unlock();
	}
	
	public void promedio() {
		lock.lock();
		this.promedio = getSuma()/size();
		lock.unlock();
		System.out.println("promedio()... " + promedio + " " + Thread.currentThread().getName());
	}
	
	public int size() {
		return array.length;
	}
}