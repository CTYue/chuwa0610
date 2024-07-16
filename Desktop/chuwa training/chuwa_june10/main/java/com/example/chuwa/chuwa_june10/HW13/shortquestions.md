
## 2.  Explain TLS, PKI, certificate, public key, private key, and signature.
### TLS
**Description**: Transport Layer Security (TLS) is a cryptographic protocol designed to provide secure communication over a computer network. 
TLS is the successor to Secure Sockets Layer (SSL) and is widely used to secure communications on the internet.
### PKI
**Description**:PKI is a security framework for establishing, managing and distributing public keys,
and providing secure and trusted communication and data transmission. 
It is based on asymmetric encryption algorithms and implements identity authentication and trust through digital certificates and certificate authorities (CA).

### certificate
**Description**: A digital certificate is an electronic document that uses a digital signature to bind a public key with an entity's identity, such as an individual, organization, or device. 
Certificates are issued by trusted Certificate Authorities (CAs).
 
### public key
A public key is a cryptographic key that can be shared publicly, usually used for asymmetric encryption. 
It is paired with a private key to form an asymmetric key pair. he public key is used to encrypt data, while the private key is used to decrypt it. 
In addition, the public key can also be used to verify the validity of a digital signature.
### private key

Private key is a cryptographic key that must be kept secret and is typically used in asymmetric encryption. Paired with a public key, it forms an asymmetric key pair. 
The private key is used to decrypt data encrypted with the public key or to create digital signatures.
### signature
A digital signature is an encrypted value calculated from data and a private key. It ensures the security of digital communication by preventing messages from being altered or forged during transmission and storage.
## 3.  list all http status codes that related to authentication and authorization failures.
## 3.  list all http status codes that related to authentication and authorization failures.

#### 401 Unauthorized

**Description**: This status code indicates that the request has not been applied because it lacks valid authentication credentials for the target resource.

**Common Causes**:
- Missing or invalid authentication token
- Expired authentication token
- Incorrect credentials


#### 403 Forbidden
**Description**: This status code indicates that the server understood the request but refuses to authorize it. This is typically used when the user does not have the necessary permissions to access the resource.

**Common Causes**:

- User lacks necessary permissions
- Access to the resource is restricted
- Request is valid but the server is refusing action

#### 407 Proxy Authentication Required
**Description**: This status code indicates that the client must first authenticate itself with the proxy. The proxy server requires authentication before it can forward the request to the destination server.

**Common Causes**:

- Missing or invalid proxy authentication credentials
- Proxy server requiring user authentication

#### 419 Authentication Timeout (Non-Standard)
**Description**: This non-standard status code indicates that the session has expired or the authentication token is no longer valid. This is often used in web applications to indicate that the user needs to re-authenticate.

**Common Causes**:

- Session expiration
- Inactivity timeout
- Invalidated authentication token

#### 511 Network Authentication Required
**Description**: This status code indicates that the client needs to authenticate to gain network access. This is often used by captive portals to require user authentication before allowing access to the internet.

**Common Causes**:

- Captive portal requiring user login
- Network access restrictions

## 4.  Compare authentication and authorization?
### Authentication

- **Purpose**: Verifies the identity of a user or entity.
- **Process**: User provides credentials (e.g., username and password).
- **Outcome**: Confirms if the user is who they claim to be.

### Authorization

- **Purpose**: Determines the permissions and access rights of an authenticated user.
- **Process**: Checks user's permissions against the requested action/resource.
- **Outcome**: Grants or denies access to resources or actions based on permissions.

### Key Differences

- **Focus**: Authentication is about identity; Authorization is about permissions.
- **Sequence**: Authentication occurs before authorization.

## 5.  What is HTTP Session?
- **Definition**: A sequence of network request-response transactions between a client and server.
- **Purpose**: Maintains stateful interaction in a stateless HTTP protocol.
- **Implementation**: Often managed using session IDs stored in cookies, URL parameters, or hidden form fields.
- **Usage**: Tracks user activity, stores user data (e.g., login status, preferences), and supports secure transactions.
## 6.  What is Cookie?
Cookies are small files sent by a web server to a browser, often containing a unique identifier. The browser stores these files and sends them back to the server 
when the user revisits the website so that the website can recognize the user and retrieve the stored information.
## 7.  What is the difference between Session and Cookie?
- Cookies are stored on the client (browser), and Sessions are stored on the server
- Cookies can be set to be kept for a long time, such as the default login function. Sessions are generally valid for a short time and will become invalid when the client is closed or the Session times out.
- Cookies are stored on the client, and information can be easily stolen; Sessions are stored on the server, which is relatively safer
## 8.  How do we use session and cookie to keep user information across the the application?
1. **User Logs In**: Server creates a session and stores user information (e.g., user ID).
2. **Session ID**: Server generates a unique session ID.
3. **Store Session ID**: Server sends the session ID to the client in a cookie.
4. **Subsequent Requests**: Client sends the session ID cookie with each request.
5. **Retrieve Information**: Server uses the session ID to retrieve user information from server-side storage.
## 9.  What is JWT?
JWT stands for JSON Web Token, and it is a commonly used stateless user authentication standard used to securely transmit information between client and server in a JSON format.
Consists of three parts:
1. **Header**: Specifies the token type (JWT) and the signing algorithm (e.g., HMAC, RSA).
2. **Payload**: Contains claims (e.g., user information, permissions).
3. **Signature**: Verifies the token's integrity using the header and payload.
## 10.  What is the spring security filter?
A component in the Spring Security framework that processes HTTP requests and responses to perform security rules.
These filters are configured in the Spring Security filter chain and are responsible for intercepting and processing incoming requests to ensure the security of the application.
## 11.  Explain how JWT works
Process description:
1. The browser initiates a login request with a username and password;
2. The server verifies the identity and packages the user identifier to generate a token according to the algorithm.
3. The server returns the JWT information to the browser. The JWT does not contain sensitive information;
4. The browser initiates a request to obtain user information and sends the token just obtained to the server;
5. The server finds the token in the data and verifies the identity;
6. The server returns the user information of the user;

## 12.  Explain how do we store sensitive user information such as password and credit card number in DB?
- Password Storage:

Use strong hashing algorithms like bcrypt, scrypt, or Argon2.
Generate a unique salt for each password.
Store only the salt and hash, not the plain-text password.

- Credit Card Storage:

Encrypt credit card numbers using strong encryption algorithms like AES-256.
Securely manage and store encryption keys.
Follow industry standards such as PCI-DSS for compliance

## 13.  Compare UserDetailService, AuthenticationProvider, AuthenticationManager, AuthenticationFilter?(把这几个名字看熟悉也行)
- UserDetailsService:
    - Purpose: Fetches user details from a data source.
    - Role: Provides `UserDetails` for a given username.
    - Position in Workflow: Invoked by `AuthenticationProvider`.
    - AuthenticationProvider:
        - Purpose: Validates user credentials.
        - Role: Authenticates the user and returns an `Authentication` object.
        - Position in Workflow: Invoked by `AuthenticationManager`.
    - AuthenticationManager:
        - Purpose: Manages the authentication process.
        - Role: Delegates authentication to configured `AuthenticationProvider` instances.
        - Position in Workflow: Central component in the authentication process.
    - AuthenticationFilter:
        - Purpose: Intercepts HTTP requests to extract authentication data.
        - Role: Extracts credentials and initiates authentication.
        - Position in Workflow: Entry point in the HTTP request processing pipeline.

  These components work together to implement a robust authentication system in Spring Security, each with a specific responsibility in the process.
## 14.  What is the disadvantage of Session? how to overcome the disadvantage?
    - disadvantage
        - server side storage, storage pressure
        - scalability concerns (it is stateful)，If the session is not shared, it will not work in a server cluster environment.
        - session management overhead：server need to manage the session data, increase pressure
    - improve
        - stateless authentication (JWT), server do not need storage session data, high scalability
        - add cache, improve the read and write speed.
        - implement session expiry and clean up mechanism, reducing storage space usage

## 15.  how to get value from application.properties in Spring security?
     application.properties
     security.jwt.secret=my_secret_key
     security.jwt.expiration=3600
     
    1.using @Value annotation
     @Value("${security.jwt.secret}")
     private String jwtSecret;
     @Value("${security.jwt.expiration}")
     private int jwtExpiration;

    2.@ConfigurationProperties(prefix = "security.jwt")    
    public class  ManyEnvProperties{  
        private String my_secret_key;  
        private int expiration;
        // getter setter 方法  
    }
  
## 16.  What is the role of configure(HttpSecurity http) and configure(AuthenticationManagerBuilder auth)?
**configure(HttpSecurity http)**:
Used to configure the security of HTTP requests, 
such as which requests need authentication, 
how to configure login and logout .

**configure(AuthenticationManagerBuilder auth)**:
Used to configure the authentication mechanism, 
such as where users are stored (memory, database, LDAP, etc.), 
how to load user information, etc.
Specify password encoders for hashing and verifying passwords.
## 17.  What is Spring security authentication and authorization?
**Authentication**:
- Purpose: Verify the identity of a user.
- Key Components: AuthenticationManager, AuthenticationProvider, UserDetailsService, UserDetails.
- Process: Involves verifying user credentials and returning an Authentication object upon successful authentication.

**Authorization**:
- Purpose: Determine whether an authenticated user has permission to access a specific resource.
- Key Components: AccessDecisionManager, AccessDecisionVoter, SecurityMetadataSource.
- Process: Involves evaluating user authorities against required permissions and granting or denying access based on the evaluation.
## 18.  Reading, 泛读一下即可，自己觉得是重点的，可以多看两眼。https://www.interviewbit.com/spring-security-interview-questions/#is-security-a-cross-cutting-concern
### 1.  1-12
### 2.  17 - 30