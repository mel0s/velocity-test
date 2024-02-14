package com.okta.developer.servlet;

import com.okta.developer.entity.Employee;
import org.apache.velocity.Template;
import com.okta.developer.services.EmployeeServices;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserServlet extends VelocityViewServlet {

    private static final long serialVersionUID = 1L;

    EmployeeServices service;


    public Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context context) {

        List<Employee> employee = service.getAllEmployee();

        context.put("employee", employee);

        Template template = null;

        try {
            template = getTemplate("templates/index.vm");
            response.setHeader("Template Returned", "Success");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return template;
    }

}
