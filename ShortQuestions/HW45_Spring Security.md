## HW45 - Spring Security / HW13

### 2. Explain TLS, PKI, certificate, public key, private key, and signature.

#### TLS (Transport Layer Security)

a cryptographic protocol designed to ensure privacy and security for communications between applications over the internet.

#### PKI(Public key infrastructure)：

a framework used to create, manage, distribute, use, store and revoke certificates and manage public-key encryption.

tools/framework used to manage digital keys and certificates. It supports the distribution and identification of public encryption keys, enabling secure data exchange and authentication over networks. 

#### Certificate

a digital document that uses a digital signature to **bind a public key with an identity**—information such as the name of a person or an organization, their address, and so forth. （证书的主要作用是确保公钥属于特定的个人、组织或服务器，防止中间人攻击。）

Contains:

- public keys
- Subject: holder information
- Issuer: issuer information
- Serial number: unique identifier of each certificate

Certificates are used in PKI to associate a public key with a trusted entity. When you visit a secure website, your browser checks the site's certificate to ensure that it is legitimate and issued by a trusted Certificate Authority (CA).

#### Public key

- shared openly and can be **used by anyone to encrypt data** intended for a specific recipient. 
- However, only the recipient with the **corresponding private key can decrypt** this data.
- Verify digital signatures created with the corresponding private key.

#### Private key

- secret by the owner and is used to **decrypt data encrypted with the matching public key**. 
- It is also used to **create digital signatures** that can be verified by the corresponding public key.

sender 用自己的private key签名，用receiver的public key加密 -> receiver 用自己的private key解密，用sender的public key 验证signature

#### Signature

to validate data integrity and sender authentity.

- The sender encrypts the message or a digest of the message using its private key to generate a digital signature.
- The receiver uses the sender's public key to decrypt the digital signature and verify the integrity and authenticity of the message.



### 3. list all http status codes that related to authentication and authorization failures.

#### 401 Unauthorized

The client's request is rejected due to lack of valid authentication information. Server requests authentication credentials.

#### 403 forbidden

The server understood the request but refuses to authorize it. The client does not have permission to access the requested resource, even if authenticated.

#### 407 proxy authentication required

The client must first authenticate using the proxy server before the proxy server can forward the request.



### 4. Compare authentication and authorization?

- authentication：the process of verifying the identity of a user or entity. ("Who are you?")
- authorization：the process of determining a authenticated user or entity has permission an d rights to access a specific resource. ("What are you allowed to do?")



### 5. What is HTTP Session?

a mechanism used by web applications to maintain **stateful information** or context about a series of HTTP requests and responses between a client (such as a web browser) and a server.



### 6. What is Cookie?

- a small piece of data that a server sends to the user's web browser. 

- The browser then **stores this data**(info about the user, like the preference, login status, session information) and **sends it back** to the server with every subsequent request to that server.



### 7. What is the difference between Session and Cookie?

| Feature          | Cookies                                                      | Sessions                                                     |
| ---------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Storage Location | user side, within the browser                                | server side, client only stores a session identifier         |
| Data Capacity    | size limits (typically 4KB per cookie) and browsers impose limits on the total number of cookies per domain. | no strict size limit, depends on server configuration        |
| Security         | less scecure, can be accessed and manipulated by the user.   | more secure due to stored on the server, reduce exposure to client-side attacks |
| Communication    | Sent with every HTTP request, allowing the server to read the cookie data without additional server-side processing. | server must be contacted to retrieve or update session data, identified by a seesionID |
| Performance      | Minimal overhead since cookie are small                      | can be heavier on the server side as data grows              |
| Usage            | store user preferences, such as theme choices or language settings.<br />tracking user behavior and maintaining login states across different sessions if they are persistent. | user authentication state and other sensitive information that should not be exposed to the client-side.<br />store temporary shopping cart data for e-commerce applications. |



### 8. How do we use session and cookie to keep user information across the the application?

1. User side: User send **login HTTP request** with username and password(credentials).
2. Server side: 
   - Server **verifies credentials**, if valid, creates a session(generates session ID) for the user on the server-side, 
   - the server stores user-specific data (e.g., user ID, role) in the session storage, associated with the session ID.
   - the server sends an HTTP response setting a cookie containing the session ID (e.g., `Set-Cookie: JSESSIONID=666ABC`).
3. User side: user send requests with **session id and cookie**
4. Server side: server get session id from the cookie, retrieves the session data from the session storage, and processes the request accordingly.

![image-20240717084449563](/Users/xiao/Library/Application Support/typora-user-images/image-20240717084449563.png)



### 9. What is JWT?

**JSON Web Token**, is an open standard  that defines a compact and self-contained way for transferring information securely between two parties — a client and a server **as a JSON object**..

A JWT is typically composed of three parts separated by dots:

- header: 

  - the type of the token, 
  - signing algorithm being used, such as HMAC SHA256 or RSA.

  ```json
  {
    "alg": "HS256",
    "typ": "JWT"
  }
  
  ```

- payload: contains the claims

  - Claims are statements about an entity (typically, the user) and additional data. There are three types of claims: registered, public, and private claims.

  ```json
  {
    "sub": "1234567890",
    "name": "John Doe",
    "admin": true
  }	
  ```

- signature: have to take the encoded header, the encoded payload, a secret, the algorithm specified in the header, and sign that.

  ```scss
  HMACSHA256(
    base64UrlEncode(header) + "." +
    base64UrlEncode(payload),
    secret)
  
  ```

Example of JWT:

```json
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9
.
eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ
.
SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c

```



### 10. What is the spring security filter?

Used to **intercept and filter incoming requests** for authentication and authorization purposes. 
Contains filter chain that composed of multiple filters that handle various security concerns.
Some a specific security task such as:

- **Authentication**: Validates user credentials.
- **Authorization**: Checks user permissions.
- **CSRF Protection**: Prevents cross-site request forgery attacks.
- **Session Management**: Manages user sessions.



### 11. Explain how JWT works 

JWT (JSON Web Token) is a compact, URL-safe means of representing claims to be transferred between two parties. It works as follows:

1. **Header**: Contains metadata about the token, including the type of token (JWT) and the hashing algorithm used (e.g., HMAC SHA256).
2. **Payload**: Contains the claims, which are statements about an entity (usually the user) and additional data.
3. **Signature**: Created by encoding the header and payload using a secret key with the specified algorithm. This ensures the token's integrity.

The process typically involves:

- **Client Authentication**: The client sends a login request with their credentials (e.g., username and password) to the authentication server.

  ```json
  POST /login
  {
    "username": "user",
    "password": "password"
  }
  ```

- **Token Creation**: Server validates credentials, if valid, it creates a JWT containing the user information and any additional claims needed for the application. **the server generates a JWT and sends it to the client.**

  ```json
  // header
  {
    "alg": "HS256",
    "typ": "JWT"
  }
  // Payload
  {
    "sub": "1234567890",
    "name": "John Doe",
    "iat": 1516239022,
    "exp": 1516249022
  }
  // Signature
  HMACSHA256(
    base64UrlEncode(header) + "." +
    base64UrlEncode(payload),
    secret)
  // return 
  HTTP/1.1 200 OK
  {
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
  }
  ```

  

- **Token Storage**: The client **stores** the token (e.g., in local storage or a cookie).

- **Token Usage**: The client sends subsequent HTTP requests with the token in the Authorization header.

  ```http
  GET /protected
  Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
  ```

  

- **Token Validation**: The server **validates** the token's signature, extracts and check the claims(expiration time, issuer, subject) to authorize the request. 
  If the token is valid, the server processes the request. If not, it rejects the request (e.g., with a 401 Unauthorized status).



### 12. Explain how do we store sensitive user information such as password and credit card number in DB? 

Sensitive information, such as passwords and credit card numbers, should be stored securely in a database using the following methods:

#### Password 

**Hashing**: Use strong, one-way hashing algorithms like bcrypt, Argon2, or PBKDF2. Hashing ensures passwords are stored in an irreversible format.

- Example: `hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt())`

**Salting**: Add a unique salt to each password before hashing to protect against rainbow table attacks. Salting ensures that even identical passwords have different hashes.

- Example: `hashedPassword = BCrypt.hashpw(password + salt, BCrypt.gensalt())`

**Peppering**: Add a secret key (pepper) to passwords before hashing to provide an additional layer of security.

#### Credit card numbers

**Encryption**: Use strong encryption algorithms like AES-256 to encrypt credit card numbers before storing them. Encryption keys must be securely managed.

```java
Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
byte[] encryptedData = cipher.doFinal(creditCardNumber.getBytes());

```

**Tokenization**: Replace credit card numbers with randomly generated tokens that have no meaningful value outside of the tokenization system. Tokens are stored in the database, and the actual credit card numbers are stored in a secure vault.

- Example: Use a third-party service or library for tokenization.



### 13. Compare UserDetailService, AuthenticationProvider, AuthenticationManager, AuthenticationFilter? (把这⼏个名字看熟悉也⾏)
#### UserDetailsService

- **Purpose**: Provides a way to load user-specific data.
- **Functionality**: Implements `loadUserByUsername(String username)` method to retrieve user details from a database or other source.
- **Use Case**: Primarily used for custom user authentication logic.

#### AuthenticationProvider

- **Purpose**: Performs authentication by validating user credentials.
- **Functionality**: Implements `authenticate(Authentication authentication)` method.
- **Use Case**: Used to encapsulate the logic for different authentication mechanisms, such as username/password, OAuth, etc.

#### AuthenticationManager

- **Purpose**: Manages authentication by delegating to one or more `AuthenticationProvider`s.
- **Functionality**: Calls the `authenticate` method of the configured `AuthenticationProvider`s.
- **Use Case**: Serves as the entry point for authentication requests, ensuring they are handled by the appropriate provider.

#### AuthenticationFilter

- **Purpose**: Intercepts and processes authentication requests.
- **Functionality**: Extracts credentials from the request, creates an `Authentication` object, and passes it to the `AuthenticationManager`.
- **Use Case**: Used to handle authentication logic within the request processing pipeline, often configured in the security filter chain.



### 14. What is the disadvantage of Session? how to overcome the disadvantage? 

#### Impact performace(Resource Consumption)

**Problem**: Storing session data on the server can consume significant resources, impacting performance.

**Solution**: Optimize session data to store only essential information and set appropriate expiration times to clean up old sessions.

```java
// Session Timeout Configuration, and clean up
@Bean
public ServletContextInitializer initializer() {
    return new ServletContextInitializer() {
        @Override
        public void onStartup(ServletContext servletContext) throws ServletException {
            servletContext.getSessionCookieConfig().setMaxAge(1800); // Session timeout in seconds
        }
    };
}

```

#### Scalability Issues(it is stateful)

**Problem**: Storing sessions in memory on the server can lead to scalability problems, particularly in high-traffic applications. As the number of users increases, the server may run out of memory, leading to performance degradation or crashes.

**Solution**: Use a **distributed session management system to store session data, like Redis, Memcached, or a relational database.**.  These systems can handle large amounts of data and distribute the load across multiple nodes, ensuring that no single server becomes a bottleneck.

```java
// Redis: Configure your application to store session data in Redis, which supports data persistence and provides fast read/write operations.
@Bean
public RedisOperationsSessionRepository sessionRepository(RedisConnectionFactory redisConnectionFactory) {
    RedisOperationsSessionRepository sessionRepository = new RedisOperationsSessionRepository(redisConnectionFactory);
    sessionRepository.setDefaultMaxInactiveInterval(1800); // Session timeout in seconds
    return sessionRepository;
}
// MySQL: Store session data in a relational database like MySQL or PostgreSQL.
@Bean
public JdbcOperationsSessionRepository sessionRepository(DataSource dataSource) {
    JdbcOperationsSessionRepository sessionRepository = new JdbcOperationsSessionRepository(dataSource);
    sessionRepository.setDefaultMaxInactiveInterval(1800); // Session timeout in seconds
    return sessionRepository;
}


```

#### Server Dependency

**Problem**: Sessions are tied to the server, making it challenging to maintain state across server restarts or crashes. 

**Solution**: Use stateless authentication methods like **JWTs** (JSON Web Tokens) or employ a persistent session store.

```java
String token = Jwts.builder()
    .setSubject(username)
    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
    .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
    .compact();
response.addHeader("Authorization", "Bearer " + token);
```

### Security Risks

**Problem**: Sessions can be vulnerable to attacks like session hijacking or fixation. 

**Solution**: Implement secure cookies (HttpOnly and Secure flags), regenerate session IDs after login, and use HTTPS to encrypt session data.

```java
//Secure Cookies
Cookie sessionCookie = new Cookie("JSESSIONID", sessionId);
sessionCookie.setHttpOnly(true); // Prevent access via JavaScript
sessionCookie.setSecure(true);   // Ensure cookie is sent over HTTPS
response.addCookie(sessionCookie);

// Session ID Regeneration
HttpSession oldSession = request.getSession(false);
if (oldSession != null) {
    oldSession.invalidate();
}
HttpSession newSession = request.getSession(true);

```



### 15. how to get value from application.properties in Spring security?

#### Using @Value Annotation

1. **Add a property in `application.properties`**:

   ```
   security.jwt.secret=mySecretKey
   ```

2. **Inject the property in your configuration class**:

   ```java
   @Configuration
   public class SecurityConfig extends WebSecurityConfigurerAdapter {
   
       @Value("${security.jwt.secret}")
       private String jwtSecret;
   
       @Override
       protected void configure(HttpSecurity http) throws Exception {
           // Use the jwtSecret variable
       }
   }
   ```

#### Using Environment Class

1. **Add a property in `application.properties`**:

   ```
   security.jwt.secret=mySecretKey
   ```

2. **Inject the `Environment` and get the property value**:

   ```java
   @Configuration
   public class SecurityConfig extends WebSecurityConfigurerAdapter {
   
       @Autowired
       private Environment env;
   
       @Override
       protected void configure(HttpSecurity http) throws Exception {
           String jwtSecret = env.getProperty("security.jwt.secret");
           // Use the jwtSecret variable
       }
   }
   ```

   

### 16. What is the role of configure(HttpSecurity http) and configure(AuthenticationManagerBuilder auth)?

#### Configure(HttpSecurity http)

Used to configure the security settings for **HTTP requests**. It allows you to define which endpoints should be secured, specify the type of authentication and authorization required, and configure various security features such as form login, logout, CSRF protection, and more. 

Configures HTTP security, specifying **which URLs** need authentication, **how to handle** login/logout, and enabling/disabling security features.

```java
@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            .antMatchers("/public/**").permitAll() // Public URLs
            .anyRequest().authenticated() // All other URLs require authentication
        .and()
        .formLogin()
            .loginPage("/login")
            .permitAll()
        .and()
        .logout()
            .permitAll();
}

```

#### Configure(AuthenticationManagerBuilder auth)

Used to set up **authentication**. It defines how users are authenticated, whether it's through in-memory storage, a database, LDAP, or an external authentication provider. This method sets up the authentication manager with user details and authentication providers.

Configures authentication mechanisms, defining **how** users are authenticated and **where** user details are stored.

```java
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .inMemoryAuthentication()
            .withUser("user").password("{noop}password").roles("USER")
        .and()
            .withUser("admin").password("{noop}admin").roles("ADMIN");
}

```



### 17. What is Spring security authentication and authorization?

https://github.com/Liam-Zhou/chuwa0610/pull/235/files#diff-112dff7cd68c3067d423b8149f3f1da06edf08813b93c837aa2e26447ac17a5c



### 18. Reading, 泛读⼀下即可，⾃⼰觉得是重点的，可以多看两眼。 

https://www.interviewbit.com/spring-security-interview-questions/#is-security-a-cross-cutting-concern

1. 1-12
2. 17 - 30