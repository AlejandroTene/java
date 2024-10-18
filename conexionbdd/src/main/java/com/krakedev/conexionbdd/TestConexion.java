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

public class TestConexion {

	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement ps=null;
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Fidel2006$");
			System.out.println("conexion exitosa");
			ps=connection.prepareStatement("insert into personas(cedula,nombre,apellido,estado_civil_codigo,numero_hijos,estatura,cantidad_ahorrada,fecha_nacimiento,hora_nacimiento)"
					+ "values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, "1163749520");
			ps.setString(2, "Mauricio");
			ps.setString(3, "Rosero");
			ps.setString(4, "S");
			ps.setInt(5, 2);
			ps.setDouble(6, 1.56);
			ps.setBigDecimal(7, new BigDecimal(1200.45));
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			String fechasStr="2020/03/22 10:05:04";
			try {
				Date fecha=sdf.parse(fechasStr);
				System.out.println(fecha);
				long fechaMilis=fecha.getTime();
				System.out.println(fechaMilis);
				//crea un java.sql.date partiendo de in java.util.date
				java.sql.Date fechaSQL=new java.sql.Date(fechaMilis);
				System.out.println(fechaSQL);
				
				Time timeSQL=new Time(fechaMilis);
				System.out.println(timeSQL);
				
				ps.setDate(8, fechaSQL);
				ps.setTime(9, timeSQL);
				
				ps.executeUpdate();
				System.out.println("ejecuta insert");
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
