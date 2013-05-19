package cujo;

public final class KeywordRegistry extends Registry<Keyword> {

	public void register(String name, String keyword) {
		super.register(name, new Keyword(keyword));
	}

	Keyword forComponent(Token component) {
		return search(component.getKeyword().toString());
	}

}