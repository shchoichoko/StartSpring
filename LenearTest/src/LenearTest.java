import java.util.ArrayList;
import java.util.Collections;

public class LenearTest {
	public static void main(String[] args) {
		/*
		double[] arrayX = { 2, 1.5, 1, 3, 4, 5, 8.5, 12, 18, 2.5 };
		double[] arrayY = { 4000, 3000, 2500, 7500, 9500, 11000, 16000, 30000, 43000, 5000 };

		double gap = 0;
		double min = 10000000;
		double a = 0;
		int lengthArrayX = arrayX.length;
		for (int i = 10; i < 4001; i++) {
			for (int j = 0; j < lengthArrayX; j++) {
				gap = Math.abs(arrayX[j] * i - arrayY[j]);
			}
			System.out.println("y = " + i + "x / " + "값 차이 : " + gap);
			if (gap < min) {
				min = gap;
				a = i;
			}
		}
		System.out.println("최적 그래프 : y = " + a + "x");
		*/
		ArrayList<Double> diffArray = new ArrayList<Double>();

		double[][] taxiArray = { { 2.3, 4000 }, { 3, 3700 }, { 15, 27300 }, { 7, 9000 }, { 11, 18000 }, { 9, 7400 },
				{ 3, 4800 }, { 13, 24000 }, { 4, 5600 }, { 10, 17700 } };

		double[] dist = { 2.2, 3.1, 15.4, 7.6, 11, 9.2, 3.4, 13.7, 4.5, 10 ,2,1.5,1,3,4,5,8.5,12,18,2.5 ,2, 1.5, 10, 5, 20, 30, 7, 12, 15, 18 ,2, 1.5, 5, 10, 8, 8.4, 22, 18, 4.5, 0.8, 15, 2, 1.5, 10, 9, 0.5, 8.2, 5, 2.5, 1, 20};
		double[] fee = { 4000, 5700, 27300, 9000, 18000, 7400, 4800, 24000, 5600, 17700 ,4000,3000,2500,7500,9500,11000,16000,30000,43000,5000, 4000, 3000, 15600, 10000, 34000, 54000, 12300, 18000, 20000, 33000, 4000, 3800, 9600, 21000, 16400, 17200, 49600, 34900, 8200, 3800, 31900,4000, 3000, 18000, 16300, 2000, 15200, 9700, 5200, 2100, 37000};

		double diff = 0;

		int i = 0;

		while (true) {

			double diffSum = 0.0;

			for (int j = 0; j < dist.length; j++) {
				diff = Math.abs((1000 + (i * 10)) * dist[j] - fee[j]);
				diffSum += diff;
			}
			diffArray.add(diffSum);

			if (i > 0 && diffArray.get(i) > diffArray.get(i - 1)) {
				break;
			}
			i++;
		}

		double min = Collections.min(diffArray);

		double optCoefficient = 1000 + (diffArray.indexOf(min) * 10);

		System.out.println("기울기: " + optCoefficient);

	}
}
