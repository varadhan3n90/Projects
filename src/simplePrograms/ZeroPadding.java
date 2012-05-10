package simplePrograms;

import java.util.ArrayList;

public class ZeroPadding {
	
	public void padWithZeros(ArrayList<Integer> mylist){
		if(mylist==null)
			return;
		int size = mylist.size();
		if(mylist.isEmpty()){
			mylist.add(0);
		}
		for(int i=1;i<=(2*size);i+=2){
			mylist.add(i, 0);
		}
	}
	
	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		new ZeroPadding().padWithZeros(list);
		for(Integer i : list){
			System.out.println(i.intValue());
		}
	}	
	
	
}
