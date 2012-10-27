package fichier;

import java.io.FileNotFoundException;

public class TestContentHandler {

	public static void main(String[] args) throws FileNotFoundException {
		FileParser f = new FileParser();

		System.out.println("Verification du fichier '" + args[0]
				+ "' en argument...");

		if (f.check_xml(args[0]))
			System.out.print("C'est bien ");
		else
			System.out.print("Ce n'est pas ");

		System.out.println("un fichier XML");

	}
}
