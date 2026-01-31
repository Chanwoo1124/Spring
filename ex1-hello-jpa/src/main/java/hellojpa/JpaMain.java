package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Movie movie = new Movie();
            movie.setDirector("aaa");
            movie.setActor("bbbb");
            movie.setName("바람과함께사라지다");
            movie.setPrice(1000);

            em.persist(movie);

            em.flush();
            em.clear();

            Movie movie1 = em.find(Movie.class, movie.getId());
            System.out.println("movie1 = " + movie1);


            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }




        emf.close();
    }
}
