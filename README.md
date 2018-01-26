# Operaciones Vector con Threads y uso de Barreras

Se calculara la suma y promedio de un array de números enteros usando **Threads**, dividiendo el trabajo de la suma de forma paralela, teniendo en cuenta la sección crítica del recurso a procesar y una barrera para poder procesar la operación de promedio al liberar la barrera, los aspectos más importantes a seguir son los siguientes:

1. Instanciar la barrera y especificar la acción a realizar cuando se libere la barrera, para lo cual utilizamos un **Runnable**:
	```[java]
	barrier = new CyclicBarrier(this.NUM_HILOS, new Runnable() {
			@Override
			public void run() {
				recurso.promedio();
			}
	});
	```
2. Pasar *barrier* a cada tarea y despúes de realizar el proceso de suma, agregamos:
	```[java]
	barrier.await();
	```