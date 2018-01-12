
package dao;

import entities.Member;
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


    public void create(Member entity) {
        em.persist(entity);
    }

    public void edit(Member entity) {
        em.merge(entity);
    }

    public void remove(Member entity) {
        em.remove(em.merge(entity));
    }

    public Member find(Object id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Member.class));
        return em.createQuery(cq).getResultList();
    }

    
}
