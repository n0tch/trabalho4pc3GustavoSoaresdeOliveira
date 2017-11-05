package br.com.prog3web.trabalho4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Formulario")
public class Formulario extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException{
		doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String nome, sexo, matricula, msg;
		Integer idade;
		
		nome = req.getParameter("nome");
		idade = Integer.parseInt(req.getParameter("idade"));
		matricula = req.getParameter("matricula");
		sexo = req.getParameter("sexo");
		
		if(idade >= 18 && sexo.equals("masculino"))
			msg = "Você precisa servir ao exército.";
		else if(idade < 18 && sexo.equals("masculino"))
			msg = "Você está ok com as obrigações militares.";
		else
			msg = "Você não precisa servir ao exército.";
		
		out.println("<HTML><HEAD><TITLE>Primeiro Servlet");
		out.println("</TITLE></HEAD><BODY>");
		
		out.println("Nome: " + nome + "<br/>");
		out.println("Matricula: " + matricula + "<br/>");
		out.println("Idade: " + idade + "<br/>");
		out.println("Sexo: " + sexo + "<br/>");
		out.println("Mensagem: " + msg + "<br/>");
		
		out.println("<BR></BODY></HTML>");
		out.close();
	}
}
