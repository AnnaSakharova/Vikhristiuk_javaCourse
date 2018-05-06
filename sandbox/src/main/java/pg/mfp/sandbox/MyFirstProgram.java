package pg.mfp.sandbox;

public class MyFirstProgram {



	public static void main(String[] args){

		Point p1 = new Point(2,2);
		Point p2 = new Point(4,4);
		System.out.println("=========================================================================================");
		System.out.println("Запуск расчета расстояния между точками в функции main. Результат = " + distance(p1, p2));
		System.out.println("=========================================================================================");


		System.out.println("Вычисление расстояния между двумя точками в методе класса Point. Результат = " + Point.distance(p1, p2));
		System.out.println("=========================================================================================");

    Distance d = new Distance(p1, p2);
		System.out.println("Вычисление расстояния между двумя точками в методе класса Distance. Результат = " + d.distance());
		System.out.println("=========================================================================================");

	}



	public static String distance(Point p1, Point p2) {
		double distance = Math.sqrt(Math.pow((p2.x-p1.x),2) + Math.pow((p2.y-p1.y),2));
		return String.format("%.4g%n", distance);
	}
	
}