import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Borrar {
	static String BDPer = "DBPersonas.yap";

	public static void main(String[] args) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPer);
		Persona per = new Persona(null, null);
		//Persona per2 = new Persona("Alvaro","Madrid");
		ObjectSet<Persona> result = db.queryByExample(per);
		
		//result.add(per2);
		if (result.size() == 0) {
			System.out.println("No existe registro de personas...");
		} else {
			System.out.printf("Numero de resitros: %d %n", result.size());
			while (result.hasNext()) {
				Persona p = result.next();
				db.delete(p);
				
			}
		}
		db.close();
	}
}