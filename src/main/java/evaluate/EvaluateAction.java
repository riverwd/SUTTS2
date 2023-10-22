package evaluate;

import common.MyTools;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@WebServlet(name = "EvaluateAction", value = "/EvaluateAction")
public class EvaluateAction extends HttpServlet {
    public EvaluateAction() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("已链接到数据库");
        String actionType = request.getParameter("action");
        switch (actionType) {


            case "update":
                UpdateEvaluate(request, response);
                break;
            case "getEvaluateByCode":
                GetEvaluateByID(request, response);
                break;
            case "add":
                AddEvaluate(request, response);
                break;
        }
    }
    //新增评价
    protected void AddEvaluate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("already in AddEvaluate..");
        EvaluateDB beanDB=new EvaluateDB();
        //1、获取客户端请求
        EvaluateInfo Evaluate=new EvaluateInfo();
        Evaluate.setFeedbackID(request.getParameter("feedbackID"));
        Evaluate.setEvaluatorID(request.getParameter("evaluatorID"));
        Evaluate.setEvaluatedID(request.getParameter("evaluatedID"));
        Evaluate.setFeedbackTime(Date.valueOf(request.getParameter("feedbackTime")));
        Evaluate.setContent(request.getParameter("content"));

        Evaluate.setTextbookID(request.getParameter("textbookID"));
        Evaluate.setUserID(request.getParameter("userID"));
        Evaluate.setTextbookName(request.getParameter("textbookName"));
        Evaluate.setAuthor(request.getParameter("author"));
        Evaluate.setPrice(request.getParameter("price"));


        int count=beanDB.addevaluate(Evaluate);			//调用业务处理Bean的方法处理数据
        //3、向客户端做出响应
        response.setContentType("text/html;charset=UTF-8");	//返回text
        PrintWriter out = response.getWriter();
        if(count!=0){
            out.print("1");//out.println("1");
            //用于直接比较的简单数据不能用out.println，包含隐藏的换行符
        }else{
            out.print("0");
        }
    }
    //修改评价信息
    protected void UpdateEvaluate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("already in UpdateEvaluate..");
        EvaluateDB beanDB=new EvaluateDB();
        //1、获取客户端请求
        EvaluateInfo Evaluate=new EvaluateInfo();

        Evaluate.setFeedbackID(request.getParameter("feedbackID"));
        Evaluate.setEvaluatorID(request.getParameter("evaluatorID"));
        Evaluate.setEvaluatedID(request.getParameter("evaluatedID"));
        Evaluate.setFeedbackTime(Date.valueOf(request.getParameter("feedbackTime")));
        Evaluate.setFeedbackType(request.getParameter("feedbackType"));
        Evaluate.setContent(request.getParameter("content"));


        int count=beanDB.updateevaluate(Evaluate);			//调用业务处理Bean的方法处理数据
        //3、向客户端做出响应
        response.setContentType("text/html;charset=UTF-8");	//返回text
        PrintWriter out = response.getWriter();
        if(count!=0){
            out.print("1");//out.println("1");
            //用于直接比较的简单数据不能用out.println，包含隐藏的换行符
        }else{
            out.print("0");
        }
    }
    protected void GetEvaluateByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EvaluateDB beanDB = new EvaluateDB();
        String value = request.getParameter("value");
        EvaluateInfo Evaluate = beanDB.getevaluateByID(value);
        //设置响应的内容类型及编码方式
        response.setContentType("application/json;charset=UTF-8");
        //获取输出流对象
        PrintWriter out = response.getWriter();
        out.println("[");
        String jsonData = "";
        jsonData += "{\"empId\":" + Evaluate.getFeedbackID() + ",";
        jsonData += "\"deptName\":\"" + Evaluate.getEvaluatorID() + "\",";
        jsonData += "\"titleName\":\"" + Evaluate.getEvaluatedID() + "\",";
        jsonData += "\"postName\":\"" + Evaluate.getFeedbackTime() + "\",";
        jsonData += "\"name\":\"" + Evaluate.getFeedbackType() + "\",";
        jsonData += "\"number\":\"" + Evaluate.getContent() + "\",";
        jsonData += "\"gender\":\"" + Evaluate.getTextbookID() + "\",";
        jsonData += "\"idcardNumber\":\"" + Evaluate.getUserID() + "\",";
        jsonData += "\"birthday\":\"" + Evaluate.getTextbookName() + "\",";
        jsonData += "\"nativePlace\":\"" + Evaluate.getAuthor() + "\",";
        jsonData += "\"eduLevel\":\"" + Evaluate.getPrice() + "\",";

        if (!jsonData.equals("")) {
            out.println(jsonData.substring(0, jsonData.length() - 1));
        }
//        System.out.println("jsondata: " + jsonData);
        out.println("]");
        // 测试语句
        System.out.println(jsonData);
        out.flush();
        out.close();
    }

}