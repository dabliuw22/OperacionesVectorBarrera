package com.leysoft.ovbarrera;

import java.util.Random;

import com.leysoft.ovbarrera.logics.Operations;
import com.leysoft.ovbarrera.resources.Resource;

public class App {
    public static void main( String[] args ) {	
    	Resource recurso = new Resource(llenarArray(10000000));
    	Operations operations = new Operations(Runtime.getRuntime().availableProcessors(), recurso);
    	operations.run();
    }
    
    public static int[] llenarArray(int SIZE) {
    	int[] array = new int[SIZE];
    	Random random = new Random();
    	for(int i = 0; i < SIZE; i++) {
    		array[i] = random.nextInt(100) + 1;
    	}
    	return array;
    }
}
