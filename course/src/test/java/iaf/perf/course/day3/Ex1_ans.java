package iaf.perf.course.day3;

///EX1
import iaf.perf.course.day3.map.Ex1.TimedSizableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * A hash map based implementation of TimedSizable map.
 * 
 * This class is not thread-safe: calling any public operations concurrently
 * will result in program errors. Implementing "GC" for lazy hash hybrid method.
 *
 * @param <K> Key type
 * @param <V> Value type
 */

public class Ex1_ans<K, V> implements TimedSizableMap<K, V> {
	private final ScheduledExecutorService GarbageService = Executors.newSingleThreadScheduledExecutor();
	private final Map<K, V> data;
	private final Map<K, Object[]> time;

	public Ex1_ans() {
		this(new HashMap<>());
	}

	protected Ex1_ans(Map<K, V> map) {
		this.data = map;
		this.time = new HashMap<K,Object[]>();
	}

	public void put(K key, V value, int duration, TimeUnit unit) {
		data.put(key, value);
		Object[] TimeStamp = new Object[2];
		TimeStamp[0] = System.currentTimeMillis();
		TimeStamp[1] = duration;  //in seconds
		time.put(key, TimeStamp);
		GarbageService.schedule(() -> remove(key), duration, unit);  //need to be triggered by size() 
	}

	public Optional<V> get(K key) {
		// checking if time has passed
		if( System.currentTimeMillis() - (long)(time.get(key))[0] <  (long)(time.get(key))[1]*1000)
			return Optional.ofNullable(data.get(key));
		else return Optional.empty();
	}

	public long size() {
		return data.size();
	}

	@Override
	public Optional<V> remove(K key) {
		Optional.ofNullable(time.remove(key)).map(so -> so);
		return Optional.ofNullable(data.remove(key)).map(so -> so);
	}

}
