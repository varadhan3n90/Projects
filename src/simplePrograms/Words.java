package simplePrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Words {
	public static String[] getBigWords(String sentence){
		int i = 0;		
		StringTokenizer st = new StringTokenizer(sentence);
		List<String> output = new ArrayList<String>();		
		while(st.hasMoreTokens()){
			String word = st.nextToken();
			if(word.length()>=5){
				boolean flag = true;
				for(int j=0;j<word.length();j++){
					if(word.charAt(j)>='A'&&word.charAt(j)<='z'){
						;
					}else{
						flag = false;
						break;
					}
				}
				if(flag){
					output.add(word);
				}
			}
		}
		String[] op = new String [output.size()];
		for(String word : output){
			op[i++] = word;
		}
		return op;
	}
	
	public static void main(String[] args){
		System.out.println("Enter a sentence: ");
		Scanner input = new Scanner(System.in);
		String sentence = input.nextLine();
		String output[] = getBigWords(sentence);
		System.out.println("You entered "+sentence);
		System.out.println("Words that have more than 5 characters: ");
		if(output!=null)
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		if(output==null||output.length==0){
			System.out.println("No such word");
		}
	}
	
}
