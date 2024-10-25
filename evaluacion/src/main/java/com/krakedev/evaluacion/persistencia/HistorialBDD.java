package com.krakedev.evaluacion.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.utils.ConexionBDD;

public class HistorialBDD {

		public void insertar(Categoria categoria) throws KrakeException{
			Connection con=null;
			
			try {
				con=ConexionBDD.obtenerConexion();
				PreparedStatement ps=con.prepareStatement("insert into categorias(id,nombre) values(?,?)");
				ps.setString(1, categoria.getId());
				ps.setString(2, categoria.getNombre());
				
				ps.executeUpdate();
				System.out.println("insertado");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new KrakeException("Error al insertar la categoria. Detalle: "+e.getMessage());
			} catch (KrakeException e) {
				throw e;
			}finally {
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		
		public void actualizar(Categoria categoria) throws KrakeException{
			Connection con=null;
			try {
				con=ConexionBDD.obtenerConexion();
				PreparedStatement ps=con.prepareStatement("update categorias set nombre=? where id=?");
				ps.setString(1, categoria.getNombre());
				ps.setString(2, categoria.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new KrakeException("Error al actualizar la categoria. Detalle: "+e.getMessage());
			} catch (KrakeException e) {
				throw e;
			}finally {
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		public Categoria buscarPorId(String idB) throws KrakeException{
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			Categoria c=null;
			try {
				con=ConexionBDD.obtenerConexion();
				ps=con.prepareStatement("select nombre from categorias where id=?");
				ps.setString(1, idB);
				System.out.println(idB);
				rs=ps.executeQuery();
				
				if(rs.next()) {
					String idR=rs.getString("id");
					String nombre=rs.getString("nombre");
					c=new Categoria(idR,nombre);	
					System.out.println("r   "+c);
				}
			} catch (KrakeException e) {
				e.printStackTrace();
				throw e;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new KrakeException("Error al consultar. Detalle: "+e.getMessage());
			}
			return c;
        }
		
		public ArrayList<Categoria> recuperarTodos() throws KrakeException{
			ArrayList<Categoria> categorias=new ArrayList<Categoria>();
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			Categoria c=null;
			try {
				con=ConexionBDD.obtenerConexion();
				ps=con.prepareStatement("select id,nombre from categorias");
				rs=ps.executeQuery();
				
				while(rs.next()) {
					String id=rs.getString("id");
					String nombre=rs.getString("nombre");
					c=new Categoria(id,nombre);
					categorias.add(c);	
				}
			} catch (KrakeException e) {
				e.printStackTrace();
				throw e;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new KrakeException("Error al consultar. Detalle: "+e.getMessage());
			}
			
			return categorias;
		}
		
}
