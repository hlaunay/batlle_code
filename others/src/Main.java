import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Main {
	
	public static String bestCalculs;

	public static boolean recurse(int[] best, int[] liste, int obj, String currentCalculs) {
		for (int i : liste) {
			if (i == obj) {
				bestCalculs = currentCalculs;
				best[0] = i;
				return true;
			} else if (Math.abs(obj - i) < Math.abs(obj - best[0])) {
				bestCalculs = currentCalculs;
				best[0] = i;
			}
		}
		for (int i = 0; i < liste.length; i++) {
			for (int j = i + 1; j < liste.length; j++) {
				List<Integer> listOfNew = new ArrayList<Integer>();
				List<String> listOfStrings = new ArrayList<String>();
				listOfNew.add(liste[i] + liste[j]);
				String newString = currentCalculs + liste[i] + " + " + liste[j] + " = " + (liste[i] + liste[j]) + "\n";
				listOfStrings.add(newString);
				
				listOfNew.add(liste[i] * liste[j]);
				newString = currentCalculs + liste[i] + " * " + liste[j] + " = " + (liste[i] * liste[j]) + "\n";
				listOfStrings.add(newString);
				
				listOfNew.add(liste[i] - liste[j]);
				newString = currentCalculs + liste[i] + " - " + liste[j] + " = " + (liste[i] - liste[j]) + "\n";
				listOfStrings.add(newString);
				
				listOfNew.add(liste[j] - liste[i]);
				newString = currentCalculs + liste[j] + " - " + liste[i] + " = " + (liste[j] - liste[i]) + "\n";
				listOfStrings.add(newString);
				
				if (liste[i] != 0 && liste[j] != 0 && Math.max(liste[i], liste[j]) % Math.min(liste[i], liste[j]) == 0) {
					listOfNew.add(Math.max(liste[i], liste[j])/Math.min(liste[i], liste[j]));
					newString = currentCalculs + Math.max(liste[i], liste[j]) + " / " + Math.min(liste[i], liste[j]) + " = " 
									+ (Math.max(liste[i], liste[j]) / Math.min(liste[i], liste[j])) + "\n";
					listOfStrings.add(newString);
				}
				for (int k = 0; k < listOfNew.size(); k++) {
					int[] newList = new int[liste.length-1];
					int currentPos=0;
					for (int l = 0; l < liste.length; l++) {
						if (l != i && l != j) {
							newList[currentPos] = liste[l];
							currentPos++;
						}
					}
					newList[currentPos] = listOfNew.get(k);
					String newCurrentString = listOfStrings.get(k);
					if (recurse(best, newList, obj, newCurrentString)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static void ex7(int[] tab, int obj) {
		int[] best = new int[1];
		best[0] = 0;
		bestCalculs = "";
		if (recurse(best, tab, obj, "")) {
			System.out.println("Résultat trouvé !");
		} else {
			System.out.println("Résultat approchant");
		}
		System.out.println(bestCalculs);
	}
	
	public static void ex4(String date) {
		String[] points = date.split("/");
		int nbAns, nbMois, nbSem, nbJ, nbHeures, nbMinutes;
		Date currentDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		System.out.println(cal.get(Calendar.YEAR));
		nbAns = Integer.parseInt(points[2]) - cal.get(Calendar.YEAR);
		nbMois = Integer.parseInt(points[1]) - cal.get(Calendar.MONTH);
		nbJ = Integer.parseInt(points[0]) - cal.get(Calendar.DAY_OF_MONTH);
		if (cal.get(Calendar.MINUTE) == 0) {
			nbMinutes = 0;
			nbHeures = 24 - cal.get(Calendar.HOUR_OF_DAY);
		} else {
			nbMinutes = 60 - cal.get(Calendar.MINUTE);
			nbHeures = 24 - cal.get(Calendar.HOUR_OF_DAY) - 1;
		}
		if (nbJ < 0) {
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ex4("11/12/2065");
		//int obj = 888;
		//int[] list = {100, 2, 75, 3, 1, 10};
		int obj = 999;
		int[] list = {8, 5, 2, 9, 6, 1};
		ex7(list, obj);
	}

}
