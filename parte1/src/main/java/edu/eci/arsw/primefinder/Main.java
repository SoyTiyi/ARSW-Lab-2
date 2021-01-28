package edu.eci.arsw.primefinder;

import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) throws InterruptedException {
		LinkedList<PrimeFinderThread> threads = new LinkedList<>();
		
		int numberThreads = 3;
		for(int i=0; i<numberThreads; i++){
			int first = (30000000/numberThreads)*i;
			int second = (30000000/numberThreads)*(i+1);
			threads.add(new PrimeFinderThread(first, second));
		}

		for(PrimeFinderThread thread: threads){
			thread.start();
		}

		Date startDate = new Date();
		int numberSeconds = 0;
		while(numberSeconds != 5){
			Date endDate = new Date();
			numberSeconds = (int)((endDate.getTime() - startDate.getTime()) / 1000);
			/* System.out.println(numberSeconds+" Number seconds"); */
		}
		for(PrimeFinderThread thread: threads){
			thread.setSuspend(true);
		}	
		System.out.println("Enter para continuar");
		Scanner sc = new Scanner(System.in);
		String entrada = sc.nextLine();
		System.out.println(entrada+ " entrada");
		if(entrada.equals("")){
			for(PrimeFinderThread thread: threads){
				thread.renaudarhilo();
			}
		}
		/* PrimeFinderThread pft=new PrimeFinderThread(0, 30000000); */		
	}
	
}