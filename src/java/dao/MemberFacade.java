
package dao;

import entities.Members;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class MemberFacade {
    
@PersistenceContext(unitName ="PU")
    EntityManager em;

    public MemberFacade(EntityManager em) {
        this.em = em;
    }


    public MemberFacade() {
    }


    public void create(Members entity) {
        em.persist(entity);
    }

    public void edit(Members entity) {
        em.merge(entity);
    }

    public void remove(Members entity) {
        em.remove(em.merge(entity));
    }

    public Members find(Object id) {
        return em.find(Members.class, id);
    }

    public List<Members> findAll() {
        
        return em.createQuery("SELECT m FROM Members AS m").getResultList();
    }

    
    
}
