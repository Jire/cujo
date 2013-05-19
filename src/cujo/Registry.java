package cujo;

import java.util.HashMap;
import java.util.Map;

/**
 * @param <T>
 *            The type of value which is kept in the registry.
 */
public abstract class Registry<T> {

	private final Map<String, T> registry = new HashMap<String, T>();

	public final void register(String name, T value) {
		registry.put(name, value);
	}

	public final void unregister(String name) {
		registry.remove(name);
	}

	public final T search(String name) {
		return registry.get(name);
	}

}