package Servlet;

import Services.HospitalService;
import Services.ServiceFactory;
import Services.UserService;
import Utils.Verifier;
import Utils.VerifierFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HospitalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HospitalService serv = ServiceFactory.getHospitalService();
        Verifier verifier = VerifierFactory.getVerifier();
        if(req.getParameter("id") != null && verifier.existHospital(Integer.parseInt(req.getParameter("id")))) {
            int id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("hospital", serv.getHospital(id));
            req.getRequestDispatcher("/hospital.jsp").forward(req, resp);
        } else {
            req.setAttribute("hospitals", serv.getAllHospitals());
            req.getRequestDispatcher("/hospitals.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}