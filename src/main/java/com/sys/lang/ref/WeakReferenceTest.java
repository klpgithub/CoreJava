package com.sys.lang.ref;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {

	static class Car {
		private Double price;
		private String name;

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Car [price=" + price + ", name=" + name + "]";
		}

		public Car(Double price, String name) {
			super();
			this.price = price;
			this.name = name;
		}

	}

	public static void main(String[] args) {
		// 运行一段时间后，输出"bject has been collected.car对象被回收
		{
			Car BMW = new Car(550000.00, "BMW");
			WeakReference<Car> weakCar = new WeakReference<Car>(BMW);
			int i = 0;
			for (;;) {
				if (weakCar.get() != null) {
					i++;
					System.out.println("Object is alive for " + i + " loops - " + weakCar);
				} else {
					System.out.println("Object has been collected.");
//					System.out.println(BMW == null);//有这句GC认为还有BMW的引用？？？
					break;
				}
			}
		}
		
	}
}
