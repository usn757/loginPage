package org.example.why_pstmt.model.dao;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Repository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Base64;

@Repository
public class TestUserRepository {
    private final Connection connection;
    private final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

    // 해싱
    private final MessageDigest digest;

    public TestUserRepository() throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://%s:%s/%s".formatted(
                dotenv.get("DB_HOST"),
                dotenv.get("DB_PORT"),
                dotenv.get("DB_DATABASE")
        );
        String username = dotenv.get("DB_USERNAME");
        String password = dotenv.get("DB_PASSWORD");
        connection = DriverManager.getConnection(url, username, password);

        digest = MessageDigest.getInstance("SHA-256");
    }

    public void createTestUser(String username, String password) throws SQLException {

/*      //v1
        Statement stmt = connection.createStatement();
        String sql = "INSERT INTO test_user (username, password) VALUES ('%s', '%s')".formatted(username,password);
        stmt.executeUpdate(sql); // executeUpdate VS executeQuery
 */
        PreparedStatement pstmt = connection.prepareStatement("insert into test_user (username, password) values (?, ?)");
        pstmt.setString(1,username);
        pstmt.setString(2,hashPassword(password));
        pstmt.executeUpdate();

    }

    public boolean login(String username, String password) throws SQLException {

/*      //v1
        Statement stmt = connection.createStatement();
        String sql = "SELECT * FROM test_user WHERE username = '%s' and password = '%s'".formatted(username, password);
        ResultSet rs = stmt.executeQuery(sql);
*/
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM test_user WHERE username = ? AND password = ?");
        pstmt.setString(1,username);
        pstmt.setString(2, hashPassword(password));
        ResultSet rs = pstmt.executeQuery();


        return rs.next();
    }

    private String hashPassword(String password) {
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
//        String hashedPassword = Base64.getEncoder().encodeToString(hash);
//        return hashedPassword;
        return Base64.getEncoder().encodeToString(hash);
    }

}