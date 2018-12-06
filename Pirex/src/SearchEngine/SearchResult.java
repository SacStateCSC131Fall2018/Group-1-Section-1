package SearchEngine;
import documentStore.Document;
import documentStore.Opus;

public class SearchResult {
	private Document doc;
	private Opus opus;
	private int docNum, opusNum;
	
	public SearchResult(int opusNum, int docNum, Document doc, Opus opus) {
		this.opusNum = opusNum;
		this.docNum = docNum;
		this.doc = doc;
		this. opus = opus;
	}
	
	//getters
	public int getOpusNum() {
		return opusNum;
	}
	public int getdocNum() {
		return docNum;
	}
	public Opus getOpus() {
		return opus;
	}
	public Document getDoc() {
		return doc;
	}
}
