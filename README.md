# jsp-servlet-login

Dự án **Maven Webapp** chuẩn cho Java JSP/Servlet, tương thích **Apache Tomcat 10.1+** (Jakarta Servlet API 6.0).

Chức năng: form đăng nhập đơn giản — nhập `username = admin` và `password = admin` sẽ in ra **"Welcome admin to website"**, sai thì in **"Login Error"**.

## Phân chia Frontend / Backend

Dự án tách rõ ràng hai phần theo mô hình MVC (Model 2):

| Phần | Trách nhiệm | Vị trí |
|------|-------------|--------|
| **Frontend** (View) | Giao diện hiển thị: form đăng nhập, trang kết quả, CSS. KHÔNG chứa logic nghiệp vụ. | `src/main/webapp/` |
| **Backend** (Controller) | Xử lý nghiệp vụ: nhận request, kiểm tra username/password, forward kết quả. KHÔNG tự sinh HTML. | `src/main/java/` |

Luồng hoạt động:
1. Người dùng mở `index.jsp` (frontend) → điền form.
2. Form POST tới `/login` → `LoginServlet` (backend) xử lý nghiệp vụ.
3. Servlet đặt kết quả vào request scope rồi forward sang `result.jsp` (frontend) hiển thị.

## Cấu trúc dự án (đầy đủ)

```
ServletLogin/
├── pom.xml                                  ← Cấu hình Maven (group com.codegym, artifact jsp-servlet-login, packaging war)
├── mvnw / mvnw.cmd                          ← Maven wrapper
├── .mvn/wrapper/maven-wrapper.properties
└── src/main/
    ├── java/com/codegym/
    │   └── LoginServlet.java                ← BACKEND: @WebServlet("/login"), xử lý POST, forward sang result.jsp
    └── webapp/                              ← FRONTEND
        ├── index.jsp                        ← View: form đăng nhập (POST tới /login)
        ├── result.jsp                       ← View: hiển thị kết quả (dùng EL nhận dữ liệu từ servlet)
        ├── css/
        │   └── style.css                    ← CSS dùng chung cho các view
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
- View dùng **EL** (`${message}`, `${status}`) thay vì scriptlet để giữ frontend sạch, không trộn code Java.
