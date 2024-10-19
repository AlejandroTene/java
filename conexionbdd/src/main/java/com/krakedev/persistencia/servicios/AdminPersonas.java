package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.utils.ConexionBDD;

public class AdminPersonas {
	private static final Logger LOGGER=LogManager.getLogger(AdminPersonas.class);
	
	
	public static void insertar(Persona persona) throws Exception{
		Connection con=null;
		PreparedStatement ps;
		LOGGER.trace("Persona a insertar>>> "+persona);
		try {
			//abrir la conexion
			con=ConexionBDD.conectar();
			ps=con.prepareStatement("insert into personas(cedula,nombre,apellido,estado_civil_codigo,numero_hijos,estatura,cantidad_ahorrada,fecha_nacimiento,hora_nacimiento)"
					+ "values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, persona.getCedula());
			ps.setString(2, persona.getNombre());
			ps.setString(3, persona.getApellido());
			ps.setString(4, persona.getEstadoCivil().getCodigo());
			ps.setInt(5, persona.getNumeroHijos());
			ps.setDouble(6, persona.getEstatura());
			ps.setBigDecimal(7, persona.getCantidadAhorrada());
			ps.setDate(8, new java.sql.Date(persona.getFechaNacimiento().getTime()));
			ps.setTime(9, new Time(persona.getHoraNacimeinto().getTime()));
			ps.executeUpdate();
			
		}catch(Exception e){
			LOGGER.error("Error al insertar",e);
			throw new Exception("Error al insertar");
		}finally {
			//cerrar la conexion
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos",e);
				throw new Exception("Error con la base de datos");
			}
		}
		
	}
	
	
	public static void actualizar(Persona persona) throws Exception{
		Connection con=null;
		PreparedStatement ps;
		LOGGER.trace("Persona a actualizar>>> "+persona);
		try {
			//abrir la conexion
			con=ConexionBDD.conectar();
			ps=con.prepareStatement("update personas set nombre=?,apellido=?,estado_civil_codigo=?,numero_hijos=?,estatura=?,cantidad_ahorrada=?,fecha_nacimiento=?,hora_nacimiento=? where cedula=?");
			ps.setString(1, persona.getNombre());
			ps.setString(2, persona.getApellido());
			ps.setString(3, persona.getEstadoCivil().getCodigo());
			ps.setInt(4, persona.getNumeroHijos());
			ps.setDouble(5, persona.getEstatura());
			ps.setBigDecimal(6, persona.getCantidadAhorrada());
			ps.setDate(7, new java.sql.Date(persona.getFechaNacimiento().getTime()));
			ps.setTime(8, new Time(persona.getHoraNacimeinto().getTime()));
			ps.setString(9, persona.getCedula());
			ps.executeUpdate();
			
		}catch(Exception e){
			LOGGER.error("Error al actualizar",e);
			throw new Exception("Error al actualizar");
		}finally {
			//cerrar la conexion
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
		LOGGER.trace("Cedula de persona a eliminar>>> "+cedula);
		try {
			//abrir la conexion
			con=ConexionBDD.conectar();
			ps=con.prepareStatement("Delete From personas Where cedula=?");
			ps.setString(1, cedula);

			ps.executeUpdate();
			
		}catch(Exception e){
			LOGGER.error("Error al eliminar",e);
			throw new Exception("Error al eliminar");
		}finally {
			//cerrar la conexion
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos",e);
				throw new Exception("Error con la base de datos");
			}
		}
	}
	
	public static ArrayList<Persona> buscarPorNombre(String nombreBusqueda) throws Exception{
		ArrayList<Persona> personas=new ArrayList<Persona>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=ConexionBDD.conectar();
			ps=con.prepareStatement("select * from personas where nombre like ?");
			ps.setString(1, "%"+nombreBusqueda+"%");
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String nombre=rs.getString("nombre");
				String cedula=rs.getString("cedula");
				Persona p=new Persona();
				p.setNombre(nombre);
				p.setCedula(cedula);
				personas.add(p);
			}
			
			
		} catch (Exception e) {
			LOGGER.error("Error al consultar por nombre",e);
			throw new Exception("Error al consultar por nombre");
		}finally {
			//cerrar la conexion
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos",e);
				throw new Exception("Error con la base de datos");
			}
		}
		
		return personas;
	}
	public static Persona buscarPorCedula(String cedula) throws Exception{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=ConexionBDD.conectar();
			ps=con.prepareStatement("select * from personas where cedula = ?");
			ps.setString(1, cedula);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				String cedulap=rs.getString("cedula");
				String nombre=rs.getString("nombre");
				String apellido=rs.getString("apellido");
				Persona p=new Persona();
				p.setCedula(cedulap);
				p.setNombre(nombre);
				p.setApellido(apellido);
				return p;
			}else {
				return null;
			}
			
		} catch (Exception e) {
			LOGGER.error("Error al consultar por número de cedula",e);
			throw new Exception("Error al consultar por número de cedula");
		}finally {
			//cerrar la conexion
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos",e);
				throw new Exception("Error con la base de datos");
			}
		}
	}
	
	public static ArrayList<Persona> buscarPorNumeroHijos(int numeroHijos) throws Exception{
		ArrayList<Persona> personas=new ArrayList<Persona>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=ConexionBDD.conectar();
			ps=con.prepareStatement("select * from personas where numero_hijos >= ?");
			ps.setInt(1, numeroHijos);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String cedula=rs.getString("cedula");
				String nombre=rs.getString("nombre");
				String apellido=rs.getString("apellido");
				int numero_H=rs.getInt("numero_hijos");
				Persona p=new Persona();
				p.setCedula(cedula);
				p.setNombre(nombre);
				p.setApellido(apellido);
				p.setNumeroHijos(numero_H);
				personas.add(p);
			}
			
			
		} catch (Exception e) {
			LOGGER.error("Error al consultar por número de hijos",e);
			throw new Exception("Error al consultar por número de hijos");
		}finally {
			//cerrar la conexion
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos",e);
				throw new Exception("Error con la base de datos");
			}
		}
		
		return personas;
	}
}
