package com.codegym;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * BACKEND — kho người dùng tạm (in-memory) dùng cho demo.
 * Không dùng database; dữ liệu sẽ mất khi server khởi động lại.
 */
public class UserStore {

    private static final Map<String, String> USERS = new ConcurrentHashMap<>();

    static {
        // Tài khoản mặc định
        USERS.put("admin", "admin");
    }

    /**
     * Đăng ký tài khoản mới. Trả về false nếu username đã tồn tại.
     */
    public static boolean register(String username, String password) {
        return USERS.putIfAbsent(username, password) == null;
    }

    public static boolean exists(String username) {
        return USERS.containsKey(username);
    }

    public static boolean check(String username, String password) {
        String stored = USERS.get(username);
        return stored != null && stored.equals(password);
    }

    private UserStore() {
    }
}
