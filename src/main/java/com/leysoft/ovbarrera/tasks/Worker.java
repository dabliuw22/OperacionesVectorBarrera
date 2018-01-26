package com.leysoft.ovbarrera.tasks;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import com.leysoft.ovbarrera.resources.Resource;

public class Worker implements Runnable {
	
	private CyclicBarrier barrier;
	
	private int inicio;
	
	private int fin;
	
	private Resource recurso;
	
	public Worker(CyclicBarrier barrier, Resource recurso, int inicio, int fin) {
		this.barrier = barrier;
		this.recurso = recurso;
		this.inicio = inicio;
		this.fin = Math.min(fin, this.recurso.size());
	}

	@Override
	public void run() {
		this.recurso.suma(inicio, fin);
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}