package pl.edu.pk.plagiarism.algorithms;

public class LevenstheinDistance {

		public static int countLevensteinDistance(String orginalSource,
				String sourceToCompere) {

		
			int firstWordLength = orginalSource.length() + 1;
			
			
			int secondWordLength = sourceToCompere.length() + 1;

			
			int[] currentCost = new int[firstWordLength];
			int[] newCost = new int[firstWordLength];

			
			for (int i = 0; i < firstWordLength; i++)
				currentCost[i] = i;

			
			for (int j = 1; j < secondWordLength; j++) {

				
				newCost[0] = j - 1;

				for (int i = 1; i < firstWordLength; i++) {

					
					int sameValue = (orginalSource.charAt(i - 1) == sourceToCompere
							.charAt(j - 1)) ? 0 : 1;

				
					int costReplace = currentCost[i - 1] + sameValue;
					// wstawienie znaku,
					int costAdd = currentCost[i] + 1;
				
					// usuniêcie znaku
					int costRemove = newCost[i - 1] + 1;
				
					// obliczanie najmniejszego kosztu i zapisanie w tablicy
					newCost[i] = Math.min(Math.min(costAdd, costRemove),
							costReplace);

				}


				int[] temp = currentCost;
				currentCost = newCost;
				newCost = temp;
			}

			
			return currentCost[firstWordLength - 1];
		}
}
