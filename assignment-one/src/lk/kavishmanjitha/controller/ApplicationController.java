package lk.kavishmanjitha.controller;

import lk.kavishmanjitha.config.DBConnection;
import lk.kavishmanjitha.entity.Score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApplicationController {

    public static int saveScore(Score score) throws ClassNotFoundException, SQLException {
        String sql = "Insert into Category values(?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, score.getId());
        stm.setObject(2, score.getUserId());
        stm.setObject(2, score.getScore());
        return stm.executeUpdate();
    }

}
