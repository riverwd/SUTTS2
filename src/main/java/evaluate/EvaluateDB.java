package evaluate;

import common.DBConnection;

import java.sql.*;
import common.DBConnection;
import java.sql.Date;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
public class EvaluateDB {

    private Connection con = null;




    //    根据评价ID查询
    public EvaluateInfo getevaluateByID(String code) {
        ResultSet rs = null;
        PreparedStatement pStmt = null;
        EvaluateInfo evaluate = new EvaluateInfo();
        try {
            con = DBConnection.getConnection();
            pStmt = con.prepareStatement("SELECT * FROM t_evaluate WHERE VC_FeedbackID = ?");
            pStmt.setString(1, code);
            rs = pStmt.executeQuery();
            while (rs.next()) {
                evaluate.setFeedbackID(rs.getString("VC_FeedbackID"));
                evaluate.setEvaluatorID(rs.getString("VC_EvaluatorID"));
                evaluate.setEvaluatedID(rs.getString("VC_EvaluatedID"));
                evaluate.setFeedbackTime(rs.getDate("D_FeedbackTime"));
                evaluate.setFeedbackType(rs.getString("VC_Type"));
                evaluate.setContent(rs.getString("VC_Content"));
                evaluate.setTextbookID(rs.getString("VC_TextbookID"));
                evaluate.setUserID(rs.getString("VC_UserID"));
                evaluate.setTextbookName(rs.getString("VC_TextbookName"));
                evaluate.setAuthor(rs.getString("VC_Author"));
                evaluate.setPrice(rs.getString("VC_Price"));

            }
            rs.close();
            pStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取评价信息失败！");
        } finally {
            DBConnection.closeConnection();
        }
        return evaluate;
    }

    //新增评价
    public int addevaluate(EvaluateInfo evaluate) {
        PreparedStatement pStmt=null;
        int count=0;
        try {
            con = DBConnection.getConnection();
            pStmt = con.prepareStatement("insert into t_evaluate (VC_FeedbackID,VC_EvaluatorID,VC_EvaluatedID,D_FeedbackTime,VC_Type,VC_Content) values (?, ?, ?, ?, ?, ?)");
            pStmt.setString(1, evaluate.getFeedbackID());
            pStmt.setString(2, evaluate.getEvaluatorID());
            pStmt.setString(3, evaluate.getEvaluatedID());
            pStmt.setDate(4, evaluate.getFeedbackTime());
            pStmt.setString(5, evaluate.getFeedbackType());
            pStmt.setString(6, evaluate.getContent());


            count = pStmt.executeUpdate();
            pStmt.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("提交失败！");
        } finally{
            DBConnection.closeConnection();
        }
        return count;
    }
    /* 修改评价信息 */
    public int updateevaluate(EvaluateInfo evaluate) {
        PreparedStatement pStmt=null;
        int count=0;
        try {
            con = DBConnection.getConnection();
            pStmt = con.prepareStatement("update t_evaluate set VC_FeedbackID = ?, VC_EvaluatorID = ?, VC_EvaluatedID = ?, D_FeedbackTime = ?, VC_Type = ?, VC_Content = ? WHERE VC_FeedbackID = ?");
            pStmt.setString(1, evaluate.getFeedbackID());
            pStmt.setString(2, evaluate.getEvaluatorID());
            pStmt.setString(3, evaluate.getEvaluatedID());
            pStmt.setDate(4, evaluate.getFeedbackTime());
            pStmt.setString(5, evaluate.getFeedbackType());
            pStmt.setString(6, evaluate.getContent());

            System.out.println("sql = " + pStmt);
            count = pStmt.executeUpdate();
            pStmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("修改评价失败！");
        } finally{
            DBConnection.closeConnection();
        }
        return count;
    }

}
