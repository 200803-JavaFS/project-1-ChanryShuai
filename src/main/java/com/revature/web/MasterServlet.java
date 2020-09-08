package com.revature.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.EmployeeController;
import com.revature.controllers.LoginController;
import com.revature.controllers.ManagerController;

public class MasterServlet extends HttpServlet {

	private static LoginController lc = new LoginController();
	private static EmployeeController ec = new EmployeeController();
	private static ManagerController mc = new ManagerController();

	public MasterServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json"); // default all responses are sent in JSON format
		res.setStatus(404);

		// request method that gets the URI string
		final String URI = req.getRequestURI().replace("/project1/", "");
		System.out.println(req);
		String[] portions = URI.split("/"); // splitting different sections of the URI

		System.out.println(Arrays.toString(portions));
		if (portions.length == 0) {
			req.getRequestDispatcher("index.html").forward(req, res);
		}

		try {
			switch (portions[0]) {
			case "reimbursement":
				if (req.getSession(false) != null && (boolean) req.getSession().getAttribute("loggedin")) {

					if ((boolean) req.getSession().getAttribute("ismanager")) {

						if (req.getMethod().equals("GET")) {

							if (portions.length == 1) {
								mc.getAllReimbs(res);
							} else if (portions.length == 3) {
								int id = Integer.parseInt(portions[2]); // parseInt(): parses a string argument and
																		// returns an integer
								ec.getReimbById(res, id);
							} else if (portions.length == 2) {
								switch (portions[1]) {
								case "pending":
									mc.getReimbByStatus(res, "Pending");
									break;
								case "approved":
									mc.getReimbByStatus(res, "Approved");
									break;
								case "denined":
									mc.getReimbByStatus(res, "Denied");
									break;
								}
							}

						} else if (req.getMethod().equals("POST")) {
							mc.setReimbStatus(req, res);
						}
					} else { // employee controller: ismanager false

						if (req.getMethod().equals("GET")) {
							if (portions.length == 1) {
								res.setStatus(403);
								res.getWriter().println("You must be a manager to view all reimbursement!");
							} else if (portions.length == 2) {
								System.out.println(req.getSession().getAttribute("user"));
								System.out.println(req.getSession().getAttribute("loggedin"));
								System.out.println(req.getSession().getAttribute("ismanager"));

								ec.getReimbByAuthor(req, res);
							}
						} else if (req.getMethod().equals("POST")) {
							ec.insertReimb(req, res);
						}
					}
					// Loggedin failed
				} else {
					res.setStatus(403); // 403: (forbidden)
					res.getWriter().println("You must be logged in to do that!");
				}

				break;

			case "login":
				lc.login(req, res);
				break;
			case "logout":
				lc.logout(req, res);
				break;
			}

		} catch (

		NumberFormatException e) {
			e.printStackTrace();
			res.getWriter().print("Invalid Input Type.");
			res.setStatus(400); // 404 (bad / invalid request)
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
