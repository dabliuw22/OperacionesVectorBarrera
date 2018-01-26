package com.leysoft.ovbarrera.logics;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.leysoft.ovbarrera.resources.Resource;
import com.leysoft.ovbarrera.tasks.Worker;

public class Operations {
	
	private int NUM_HILOS;
	private CyclicBarrier barrier;
	private ExecutorService service;
	private Resource recurso;
	
	public Operations(int NUM_HILOS, Resource recurso) {
		this.NUM_HILOS = NUM_HILOS;
		this.service = Executors.newFixedThreadPool(this.NUM_HILOS);
		this.recurso = recurso;
		this.barrier = new CyclicBarrier(this.NUM_HILOS, new Runnable() {
			@Override
			public void run() {
				recurso.promedio();
			}
		});
	}

	public void run() {
		int size = (int) Math.ceil(1.0*recurso.size()/this.NUM_HILOS);
		for(int i = 0; i < NUM_HILOS; i++) {
			this.service.execute(new Worker(barrier, recurso, i*size, size*(i + 1)));
		}
		this.service.shutdown();
	}
}
