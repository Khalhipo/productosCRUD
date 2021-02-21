/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Bueno
 */
public class ProductosCRUD {

    public static List<Productos> getProductos() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_productosCRUD_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM productos";

        Query q = manager.createNativeQuery(sql, Productos.class);
        List<Productos> productosBD = q.getResultList();

        return productosBD;

    }

    public static Productos getProducto(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_productosCRUD_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM productos p WHERE p.id=" + id;

        Query q = manager.createQuery(sql, Productos.class);
        Productos producto = (Productos) q.getSingleResult();

        return producto;
    }

    public static void insertaProducto(Productos prod) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_productosCRUD_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "INSERT INTO productos p (id, nombre, imagen, categoria, precio) VALUES (NULL, 'Tortas de Alcázar','','Complementos',6.00)";

        manager.getTransaction().begin();
        Query q = manager.createQuery(sql, Productos.class);
        int lineasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
    }
    
        public static void borrarProducto(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_productosCRUD_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "DELETE from productos WHERE id = " + id;
        Query q = manager.createNativeQuery(sql, Productos.class);
        manager.getTransaction().begin();
        q.executeUpdate();
        manager.getTransaction().commit();
    }

}
