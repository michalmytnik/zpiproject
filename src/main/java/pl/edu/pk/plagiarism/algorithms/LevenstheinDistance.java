package pl.edu.pk.plagiarism.algorithms;

public class LevenstheinDistance {

		public static int countLevensteinDistance(String orginalSource,
				String sourceToCompere) {

			// zapisz dlugosc pierwszego slowa powiekszona o jeden
			int firstWordLength = orginalSource.length() + 1;
			// zapisz dlugosc drugiego slowa powiêkszon¹ o jeden
			int secondWordLength = sourceToCompere.length() + 1;

			// utworz tablice kosztow levensteina o liczbie elementow rownej
			// dlugosci pierwszego slowa + 1
			int[] currentCost = new int[firstWordLength];
			int[] newCost = new int[firstWordLength];

			// zainicuj pierwszy wektor wartosciami rownymi pozycji indeksu
			for (int i = 0; i < firstWordLength; i++)
				currentCost[i] = i;

			// obliczanie kosztu dla kazej litery drugiego wyrazu
			for (int j = 1; j < secondWordLength; j++) {

				// zainicuj drugi wektor wartosciami rownymi pozycji indeksu
				newCost[0] = j - 1;

				// Obliczanie odleglosci Levensteina dla kazdej litery
				for (int i = 1; i < firstWordLength; i++) {

					// porównywanie konkretnych liter w obu wyrazach
					// jesli litera na pozycji i w wyrazie pierwszym jest identyczna
					// jak litera
					// na pozycji i w wyrazie drugim zapisz 0 jesli nie zapisz 1
					int sameValue = (orginalSource.charAt(i - 1) == sourceToCompere
							.charAt(j - 1)) ? 0 : 1;

					// Dzialania proste:

					// zmiana znaku na inny
					// jesli litery rowne identyczne to zawsze zero
					int costReplace = currentCost[i - 1] + sameValue;
					// wstawienie znaku,
					int costAdd = currentCost[i] + 1;
				
					// usuniêcie znaku
					int costRemove = newCost[i - 1] + 1;
				
					// obliczanie najmniejszego kosztu i zapisanie w tablicy
					newCost[i] = Math.min(Math.min(costAdd, costRemove),
							costReplace);

				}

			
				// zamienianie tablic z wartosciami obecnego i nowo policzonego
				// kosztu

				int[] temp = currentCost;
				currentCost = newCost;
				newCost = temp;
			}

			// zwroc dystans Levenstein'a czyli koszt transformacji wszystkich
			// znakow w obu wyrazach
			return currentCost[firstWordLength - 1];
		}
}
