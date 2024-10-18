package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.entidades.Estudiante;
import com.krakedev.persistencia.utils.ConexionBDD;

public class AdminEstudiantes {
private static final Logger LOGGER=LogManager.getLogger(AdminEstudiantes.class);
	
	
	public static void insertar(Estudiante estudiante) throws Exception{
		Connection con=null;
		PreparedStatement ps;
		LOGGER.trace("Estudiante a insertar>>> "+estudiante);
		try {
			con=ConexionBDD.conectar();
			ps=con.prepareStatement("insert into estudiantes(cedula,nombre,apellido,email,fecha_nacimiento,codigo_profesor)"
					+ "values(?,?,?,?,?,?)");
			ps.setString(1, estudiante.getCedula());
			ps.setString(2, estudiante.getNombre());
			ps.setString(3, estudiante.getApellido());
			ps.setString(4, estudiante.getEmail());
			ps.setDate(5, new java.sql.Date(estudiante.getFechaNacimiento().getTime()));
			ps.setInt(6, estudiante.getProfesor().getCodigo());
			ps.executeUpdate();
			
		}catch(Exception e){
			LOGGER.error("Error al insertar",e);
			throw new Exception("Error al insertar");
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos",e);
				throw new Exception("Error con la base de datos");
			}
		}
		
	}
	
	
	public static void actualizar(Estudiante estudiante) throws Exception{
		Connection con=null;
		PreparedStatement ps;
		LOGGER.trace("Estudiante a actualizar>>> "+estudiante);
		try {
			con=ConexionBDD.conectar();
			ps=con.prepareStatement("update estudiantes set nombre=?,apellido=?,email=?,fecha_nacimiento=?,codigo_profesor=? where cedula=?");
			ps.setString(1, estudiante.getNombre());
			ps.setString(2, estudiante.getApellido());
			ps.setString(3, estudiante.getEmail());
			ps.setDate(4, new java.sql.Date(estudiante.getFechaNacimiento().getTime()));
			ps.setDouble(5, estudiante.getProfesor().getCodigo());
			ps.setString(6, estudiante.getCedula());
			ps.executeUpdate();
			
		}catch(Exception e){
			LOGGER.error("Error al actualizar",e);
			throw new Exception("Error al actualizar");
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos",e);
				throw new Exception("Error con la base de datos");
			}
		}
	}
	
	public static void eliminar(String cedula) throws Exception {
		Connection con=null;
		PreparedStatement ps;
		LOGGER.trace("Cedula de estudiante a eliminar>>> "+cedula);
		try {
			con=ConexionBDD.conectar();
			ps=con.prepareStatement("Delete From estudiantes Where cedula=?");
			ps.setString(1, cedula);
			ps.executeUpdate();
		}catch(Exception e){
			LOGGER.error("Error al eliminar",e);
			throw new Exception("Error al eliminar");
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos",e);
				throw new Exception("Error con la base de datos");
			}
		}
	}
}
