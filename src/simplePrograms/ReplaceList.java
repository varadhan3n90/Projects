package simplePrograms;

import java.util.ArrayList;


public class ReplaceList {
	public void change(ArrayList<String> a,int n){
		int end = a.size();
		for(int i=0;i<end;i++){
			String temp = a.get(0);
			a.remove(0);		
			for(int j=0;j<n;j++){
				a.add(temp);	
			}
		}
	}
	
	public static void main(String args[]){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("octopus");
		temp.add("squid");
		new ReplaceList().change(temp, 3);
		for(String s: temp){
			System.out.println(s);
		}
	}
}
