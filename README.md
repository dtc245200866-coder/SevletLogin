# jsp-servlet-login

Dự án **Maven Webapp** chuẩn cho Java JSP/Servlet, tương thích **Apache Tomcat 10.1+** (Jakarta Servlet API 6.0).

Chức năng: form đăng nhập đơn giản — nhập `username = admin` và `password = admin` sẽ in ra **"Welcome admin to website"**, sai thì in **"Login Error"**.

## Cấu trúc dự án (đầy đủ)

```
ServletLogin/
├── pom.xml                                  ← Cấu hình Maven (group com.codegym, artifact jsp-servlet-login, packaging war)
├── mvnw / mvnw.cmd                          ← Maven wrapper
├── .mvn/wrapper/maven-wrapper.properties
└── src/main/
    ├── java/com/codegym/
    │   └── LoginServlet.java                ← @WebServlet("/login"), xử lý POST đăng nhập
    └── webapp/
        ├── index.jsp                        ← Form đăng nhập (POST tới /login)
        └── WEB-INF/
            └── web.xml                      ← Jakarta Servlet 6.0 (welcome-file index.jsp)
```

## Đóng gói

```bash
mvnw clean package
```

File WAR tạo tại: `target/jsp-servlet-login.war`

## Chạy trên Tomcat 10.1+

1. Copy `target/jsp-servlet-login.war` vào thư mục `webapps/` của Tomcat.
2. Khởi động Tomcat.
3. Truy cập:
   - Form đăng nhập: http://localhost:8080/jsp-servlet-login/
4. Nhập `admin` / `admin` → hiện **Welcome admin to website**; nhập sai → **Login Error**.

## Lưu ý kỹ thuật

- **Tomcat 10.1+ dùng `jakarta.servlet.*`** (KHÔNG phải `javax.servlet.*`).
- Java 17.
