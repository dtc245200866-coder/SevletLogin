# jsp-servlet-login

Dự án **Maven Webapp** chuẩn cho Java JSP/Servlet, tương thích **Apache Tomcat 10.1+** (Jakarta Servlet API 6.0).

Chức năng: đăng nhập, đăng ký tài khoản và quên mật khẩu (demo).

## Chức năng

| Chức năng | Endpoint | Mô tả |
|-----------|----------|-------|
| Đăng nhập | `POST /login` | Nhập `admin` / `admin` (hoặc tài khoản đã đăng ký) → **Welcome ... to website**; sai → **Login Error** |
| Đăng ký | `POST /register` | Tạo tài khoản mới, lưu tạm trong bộ nhớ |
| Quên mật khẩu | `POST /forgot-password` | Kiểm tra tài khoản tồn tại, trả thông báo (demo) |

> Lưu ý: user đăng ký được lưu **trong bộ nhớ (in-memory)**, sẽ mất khi khởi động lại Tomcat. `admin/admin` là tài khoản mặc định.

## Phân chia Frontend / Backend (MVC Model 2)

| Phần | Trách nhiệm | Vị trí |
|------|-------------|--------|
| **Backend** (Controller + Model) | Xử lý nghiệp vụ, lưu/kiểm tra user, forward kết quả. KHÔNG tự sinh HTML. | `src/main/java/com/codegym/` |
| **Frontend** (View) | Giao diện: form, trang kết quả, CSS. KHÔNG chứa logic nghiệp vụ. | `src/main/webapp/` |

## Cấu trúc dự án

```
ServletLogin/
├── pom.xml                                  ← group com.codegym, artifact jsp-servlet-login, packaging war
├── mvnw / mvnw.cmd / .mvn/
└── src/main/
    ├── java/com/codegym/                    ← BACKEND
    │   ├── LoginServlet.java                ← xử lý POST /login
    │   ├── RegisterServlet.java             ← xử lý POST /register
    │   ├── ForgotPasswordServlet.java       ← xử lý POST /forgot-password
    │   └── UserStore.java                   ← kho user tạm (in-memory)
    └── webapp/                              ← FRONTEND
        ├── index.jsp                        ← form đăng nhập
        ├── register.jsp                     ← form đăng ký
        ├── forgot-password.jsp              ← form quên mật khẩu
        ├── result.jsp                       ← hiển thị kết quả (EL)
        ├── css/style.css                    ← CSS dùng chung
        └── WEB-INF/web.xml                  ← Jakarta Servlet 6.0
```

## Đóng gói

```bash
mvnw clean package
```

File WAR tạo tại: `target/jsp-servlet-login.war`

## Chạy trên Tomcat 10.1+

1. Copy `target/jsp-servlet-login.war` vào `webapps/` của Tomcat.
2. Khởi động Tomcat.
3. Truy cập: http://localhost:8080/jsp-servlet-login/

## Lưu ý kỹ thuật

- **Tomcat 10.1+ dùng `jakarta.servlet.*`** (KHÔNG phải `javax.servlet.*`).
- Java 17.
- View dùng **EL** (`${message}`, `${status}`, `${backUrl}`, `${backLabel}`) thay vì scriptlet.
