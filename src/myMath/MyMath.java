package myMath;

public class MyMath {
	public boolean almostEqual(double a, double b){
		double c = Math.abs(a-b);
		if(c <= 0.001)
			return true;
		return false;
	}
	
}
