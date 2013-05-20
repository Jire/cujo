package cujo;

public final class KeywordRegistry extends Registry<Keyword> {

	public void register(String name, String keyword) {
		super.register(name, Keyword.get(keyword));
	}

	Keyword forComponent(Token component) {
		return search(component.getKeyword().toString());
	}

}