package com.codess.chatapp.dao;

import com.codess.chatapp.dto.UserDTO;
import com.codess.chatapp.utils.Encryption;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // for login
    public boolean isLogin(UserDTO userDTO) throws Exception {
        final String sql = "SELECT userid FROM users WHERE userid = ? AND password = ?";
        try (
            Connection con = CommonDAO.createConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)
        ) {
            String encryptedPwd = Encryption.passwordEncrypt(new String(userDTO.getPassword()));
            pstmt.setString(1, userDTO.getUserid());
            pstmt.setString(2, encryptedPwd);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    // for register
    public int add(UserDTO userDTO) throws Exception {
        final String sql = "INSERT INTO users(userid, password) VALUES (?, ?)";
        try (
            Connection con = CommonDAO.createConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)
        ) {
            String encryptedPwd = Encryption.passwordEncrypt(new String(userDTO.getPassword()));
            pstmt.setString(1, userDTO.getUserid());
            pstmt.setString(2, encryptedPwd);
            return pstmt.executeUpdate();
        }
    }
}
