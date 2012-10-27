package fichier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class FileParser {

	public FileParser() {
		// TODO Auto-generated constructor stub
	}


	public String getbalise(Scanner input) {
		XmlContentHandler handler = new XmlContentHandler();
		String mot = null;
		while (input.hasNext()) {
			mot = input.next();
			if ((mot.startsWith("<") || mot.startsWith("</"))
					&& mot.endsWith(">")) {
				handler.callBack(mot);
				return mot;
			}
		}
		return null;

	}

	public Boolean check_xml(String file) throws FileNotFoundException {
		Scanner ss = new Scanner(new File(file));
		LinkedList<String> Pile = new LinkedList<String>();

		if (file.endsWith(".xml")) {
			if (ss.nextLine().contains(
					"<?xml version=\"1.0\" encoding=\"UTF-8\"?>")) {
				String balise = getbalise(ss);
				if (balise == null)
					return true;
				else {
					Pile.addFirst(balise);

					while (ss.hasNext() && !Pile.isEmpty()) {
						String bb = getbalise(ss);
						if (Pile.getFirst().equals(bb.replace("/", "")))
							Pile.removeFirst();
						else
							Pile.addFirst(bb);

					}

				}

				return Pile.isEmpty();

			}
			return false;

		}
		return false;

	}
}