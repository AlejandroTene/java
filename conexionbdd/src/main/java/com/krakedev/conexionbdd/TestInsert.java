package com.krakedev.conexionbdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestInsert {

	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Fidel2006$");
			System.out.println("conexion exitosa");
			ps1=connection.prepareStatement("insert into profesores(codigo,nombre)"
					+ "values(?,?)");
			ps1.setInt(1, 5);
			ps1.setString(2, "Stev");
			ps1.executeUpdate();
			System.out.println("ejecuta insert1");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	
		try {
			ps=connection.prepareStatement("insert into estudiantes(cedula,nombre,apellido,email,fecha_nacimiento,codigo_profesor)"
					+ "values(?,?,?,?,?,?)");
			
			ps.setString(1, "1163987462");
			ps.setString(2, "Ana");
			ps.setString(3, "Ordoñes");
			ps.setString(4, "anita56@gmail.com");
			ps.setInt(6, 2);
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
			String fechasStr="2006/08/25";
			try {
				Date fecha=sdf.parse(fechasStr);
				long fechaMilis=fecha.getTime();
				java.sql.Date fechaSQL=new java.sql.Date(fechaMilis);

				ps.setDate(5, fechaSQL);
				
				ps.executeUpdate();
				System.out.println("ejecuta insert2");
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
