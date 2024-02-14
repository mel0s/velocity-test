package com.okta.developer.servlet;

import com.okta.developer.entity.Employee;
import com.okta.developer.services.EmployeeServices;
import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityLayoutServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class LayoutServlet extends VelocityLayoutServlet {
    private static final long serialVersionUID = 1L;
    EmployeeServices service;

    @Override
    public Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context context) {

        List<Employee> users = service.getAllEmployee();

        context.put("users", users);

        Template template = null;

        try {
            template = getTemplate("templates/layoutdemo.vm");

            response.setHeader("Template Returned", "Success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return template;
    }
}
