package indexing;
import java.util.ArrayList;


public class IndexTerms {

	public static String[] filterOperators(String query) {
		ArrayList<String> text = new ArrayList<String>();
		query = query.replaceAll("!@#$%^&*().?", "");
		query = query.replace("--", " ");
		String[] querySet = query.split(" ");

		for (int i = 0; i < querySet.length; i++) {
			text.add(querySet[i]);
		}

		filterStopWords(text);
		String[] filteredText = new String[text.size()];

		for(int i = 0; i < text.size(); i++) {
			filteredText[i] = text.get(i);
		}

		//using "Porter Stemming" algorithm
		Stemmer stem = new Stemmer();
		for(int i = 0; i < filteredText.length; i++) {
			stem.add(filteredText[i].toCharArray(), filteredText[i].length());
			stem.stem();
			filteredText[i] = stem.toString();
		stem = new Stemmer();
		}
		return filteredText;
	}

	public static ArrayList<String> filterStopWords(ArrayList<String> unfilteredText){
		String[] stopWords = {"a", "an", "and", "are", "but", "did", "do", "does"
							  ,"for", "had", "has", "is", "it", "its", "of", "or",
							 "that", "the", "this", "to", "were", "which", "with"
							 };
		for(int i = 0; i < unfilteredText.size(); i++ ) {

			for(int j = 0; j < stopWords.length; j++) {
				if(unfilteredText.get(i).equalsIgnoreCase(stopWords[j])) {
					unfilteredText.remove(i); 
				}
			}

		}
		return unfilteredText;
	}

	public static void main(String[]args){
		String test = "this Tricia's ditches HELLO HI of WONDERFUL kickers";
		String[] output = filterOperators(test);
		for(String filtered : output){
			System.out.println(filtered);
		}

	}
}
