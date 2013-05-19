package cujo;

public class Data {

	private final String identifier;
	private final Type type;
	private final Object value;

	public Data(String identifier, Type type, Object value) {
		this.identifier = identifier;
		this.type = type;
		this.value = value;
	}

	public String getIdentifier() {
		return identifier;
	}

	public Type getType() {
		return type;
	}

	public Object getValue() {
		return type.convert(value);
	}

	@Override
	public String toString() {
		return String.format("[%s =: (%s, %s)]", identifier, type.name()
				.toLowerCase(), value.toString());
	}

	public enum Type {

		TOGGLE(boolean.class), NUM(double.class), TEXT(String.class);

		private final Class<?> clazz;

		Type(Class<?> clazz) {
			this.clazz = clazz;
		}

		Class<?> getClazz() {
			return clazz;
		}

		String keyword() {
			return name().toLowerCase();
		}

		/**
		 * Converts an object value to the data type.
		 * 
		 * @param value
		 *            The object to cast.
		 * @return The object casted as the value.
		 */
		Object convert(Object value) {
			return clazz.cast(value);
		}

	}

}