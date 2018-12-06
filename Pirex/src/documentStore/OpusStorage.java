package documentStore;
import java.util.LinkedList;
import java.util.List;

public class OpusStorage {
	private LinkedList<Opus> opusList;

	public OpusStorage() {
		opusList = new LinkedList<Opus>();	
	}

	public List<Opus> getOpusStorage() {
		return opusList;
	}
//	holder	
	public void getIndex(Opus opus) {
		return; 
	}
	
	public Opus getOpus(int index) {
		return opusList.get(index);

	}
	
	public void removeOpus(Opus opus) {
		if(opusList.contains(opus)) {
			opusList.remove(opus);
		}

		return;
	}
	
	public void addOpus(Opus opus) {
		opusList.add(opus);
		return;
	}

}
