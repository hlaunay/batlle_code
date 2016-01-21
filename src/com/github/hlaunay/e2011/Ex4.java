package com.github.hlaunay.e2011;

import java.time.Duration;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Ex4 {

	public static void main(String[] args) {
		diff(2016, Calendar.DECEMBER, 21);
		System.out.println("****");
		diff(2068, Calendar.JANUARY, 1);
	}

	private static void diff(int year, int month, int day) {
		Calendar today = Calendar.getInstance();
		Calendar calendarToCompare = Calendar.getInstance();
		calendarToCompare.set(year, month, day, 0, 0, 0);
		boolean after = calendarToCompare.after(today); 
		if(! after){
			System.out.println("Given date is not after today");
			return;
		}

		System.out.println("Aujourd'hui : " + today.getTime());
		System.out.println("Entrée : " + calendarToCompare.getTime());
		
		long rest = calendarToCompare.getTimeInMillis() - today.getTimeInMillis();
		printDiff2(rest);
		rest = rest / (1000 * 60);
		
		long nbYears = rest / (60*24*31*12);
		rest = rest % (60*24*31*12);
		long nbMonths = rest / (60*24*31);
		rest = rest % (60*24*31);
		long nbDays = rest / (60*24);
		rest = rest % (60*24);
		long nbHours = rest / (60);
		long nbMinutes = rest % 60;
		
		printDiff(nbYears, nbMonths, nbDays, nbHours, nbMinutes);
	}
	
	private static void printDiff2(long mili) {
		Duration miliseconds = Duration.ofMillis(mili);
		System.out.println("----");
		System.out.println(miliseconds.toDays());
	}
	
	private static void printDiff(long nbYears, long nbMonths, long nbDays, long nbHours, long nbMinutes) {
		System.out.print("Dans ");
		if (nbYears > 0) {
			System.out.print(nbYears + " années, ");
		}
		if (nbYears > 0 || nbMonths > 0) {
			System.out.print(nbMonths + " mois, ");
		}
		if (nbYears > 0 || nbMonths > 0 || nbDays > 0) {
			System.out.print(nbDays + " jours, ");
		}
		if (nbYears > 0 || nbMonths > 0 || nbDays > 0 || nbHours > 0) {
			System.out.print(nbHours + " heures, ");
		}
		System.out.print(nbMinutes + " minutes.\n");
	}

}
