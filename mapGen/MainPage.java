package aicw;

public class MainPage {
	public static void main(String args[]){

	// if you want z=1 then you have to commit out checkverticalup and checkverticaldown
	//in the mapGen class
	mapGen testMap = new mapGen(5, 5, 2);
	
	//add obstical
	//1 starts from 0 to length-1
	testMap.addObstical(1, 3, 1, 3,0 , 0);
	
	String testString = testMap.getPaths();
	System.out.print(testString);
	
}
}