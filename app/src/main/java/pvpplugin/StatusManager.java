package pvpplugin;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class StatusManager {
    private final Map<UUID, PlayerStatus> statusById = new ConcurrentHashMap<>();

    public PlayerStatus get(UUID id) {
        return statusById.getOrDefault(id, PlayerStatus.OFFLINE);
    }

    public void set(UUID id, PlayerStatus status) {
        statusById.put(id, status);
    }
}
