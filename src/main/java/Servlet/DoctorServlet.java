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

public class DoctorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HospitalService serv = ServiceFactory.getHospitalService();
        Verifier verifier = VerifierFactory.getVerifier();
        UserService userService = ServiceFactory.getUserService();
        if (req.getParameter("timeId") == null) {
            if (req.getParameter("id") != null && verifier.existDoctor(Integer.parseInt(req.getParameter("id")))) {
                int id = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("doctor", serv.getDoctor(id));
                if (req.getSession().getAttribute("current_user") != null && userService.getUser((String) req.getSession().getAttribute("current_user")) != null) {
                    req.setAttribute("userS", userService);
                    req.setAttribute("user", userService.getUser((String) req.getSession().getAttribute("current_user")));
                }
                req.getRequestDispatcher("/doctor.jsp").forward(req, resp);
            } else {
                req.setAttribute("doctors", serv.getAllDotorss());
                req.getRequestDispatcher("/doctors.jsp").forward(req, resp);
            }
        } else {
            if(req.getSession().getAttribute("current_user") != null && userService.getUser((String) req.getSession().getAttribute("current_user")) != null) {
                userService.addTimeToUser(Integer.parseInt(req.getParameter("timeId")), userService.getUser((String) req.getSession().getAttribute("current_user")).getId());
                req.getRequestDispatcher("/myPage").forward(req,resp);
            } else {
                req.getRequestDispatcher("/login").forward(req,resp);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}