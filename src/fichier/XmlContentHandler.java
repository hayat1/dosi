package fichier;

public class XmlContentHandler implements IContentHandler {

	@Override
	public void callBack(String content) {
		System.out.println(content);

	}
}
