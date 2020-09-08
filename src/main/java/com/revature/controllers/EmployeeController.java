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
import com.revature.services.EmployeeService;
import com.revature.services.ReimbService;

public class EmployeeController {

	private static EmployeeService es = new EmployeeService();
	private static ReimbService rs = new ReimbService();
	private static ObjectMapper om = new ObjectMapper();

	public void getReimbByAuthor(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();
		String line = reader.readLine();
		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}
		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}
		String body = new String(s);
		
		List<Reimb> list = es.getReimbByAuthor(es.getUserByName(body));

		if (list == null) {
			res.setStatus(204);
		} else {
			res.setStatus(200);
			res.getWriter().println(om.writeValueAsString(list));
		}
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

	public void insertReimb(HttpServletRequest req, HttpServletResponse res) throws IOException {
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
		if (rs.insertReimb(r)) {
			res.setStatus(201);
			res.getWriter().println("New Reimbursement Submitted.");
		} else {
			res.setStatus(403);
		}
	}
}
