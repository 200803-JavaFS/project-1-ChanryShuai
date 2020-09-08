package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimb;
import com.revature.models.ReimbDTO;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.services.EmployeeService;
import com.revature.services.ReimbService;

public class ManagerController {

	private static EmployeeService es = new EmployeeService();
	private static ReimbService rs = new ReimbService();
	private static ObjectMapper om = new ObjectMapper();

	public void getAllReimbs(HttpServletResponse res) throws IOException {

		List<Reimb> all = es.getAllReimbs();
		res.getWriter().println(om.writeValueAsString(all));
		res.setStatus(200);
	}

	public void getReimbById(HttpServletResponse res, int id) throws IOException {
		Reimb r = es.getReimbById(id);

		if (r == null) {
			res.setStatus(204);
		} else {
			res.setStatus(200);
			String json = om.writeValueAsString(r);
			res.getWriter().println(json);
		}
	}

	public List<Reimb> getReimbByStatus(HttpServletResponse res, String rStatus) throws IOException {

		ReimbStatus rs = new ReimbStatus(rStatus);
		List<Reimb> list = es.getReimbByStatus(rs);

		if (list == null) {
			res.setStatus(204);
			return Collections.emptyList();
		} else {
			res.setStatus(200);
			res.getWriter().println(om.writeValueAsString(list));
			return es.getReimbByStatus(rs);
		}
	}

	public List<Reimb> getReimbByType(HttpServletResponse res, String rType) throws IOException {

		ReimbType rt = new ReimbType(rType);
		List<Reimb> list = es.getReimbByType(rt);
		if (list == null) {
			res.setStatus(204);
			return Collections.emptyList();
		} else {
			res.setStatus(200);
			res.getWriter().println(om.writeValueAsString(list));
			return es.getReimbByType(rt);
		}

	}

	public void setReimbStatus(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();
		String line = reader.readLine();
		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}
		String body = new String(s);

		System.out.println(body);
		ReimbDTO r = om.readValue(body, ReimbDTO.class);
		if (rs.updateReimbStatus(r)) {
			res.setStatus(202);
			res.getWriter().println("Reimbursement Status Updated.");
		} else {
			res.setStatus(400);
		}
		
		
	}
}
