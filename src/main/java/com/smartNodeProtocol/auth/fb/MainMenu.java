package com.smartNodeProtocol.auth.fb;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by Samarth on 18-08-2017.
 */

public class MainMenu extends HttpServlet {
    //App ID: 1273913146053200
    //App Secret: dc9117c38bd69a871adb38ae12d5fc76
    //Account Kit Client Token: e15b9369aaac3ffa999d3ce87674b2c3
    private static final long serialVersionUID = 1L;
    private String code = "";

    public void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        code = req.getParameter("code");
        if (code == null || code.equals("")) {
            throw new RuntimeException(
                    "ERROR: Didn't get code parameter in callback.");
        }
        FBConnection fbConnection = new FBConnection();
        String resultMapJson = fbConnection.getAccessToken(code);
        String accessCode = resultMapJson.split(",")[0].split(":")[1];
        accessCode = accessCode.substring(1).substring(0,accessCode.length()-2);
        FBGraph fbGraph = new FBGraph(accessCode);
        String graph = fbGraph.getFBGraph();
        Map<String, String> fbProfileData =  fbGraph.getGraphData(graph);
        ServletOutputStream out = res.getOutputStream();
        out.println("<h1>Facebook Login using Java</h1>");
        out.println("<h2>Application Main Menu</h2>");
        out.println("<div>Welcome " + fbProfileData.get("first_name"));
        out.println("<div>Your Email: " + fbProfileData.get("email"));
        out.println("<div>You are " + fbProfileData.get("gender"));
    }

}