package br.com.devmedia.dao;

import br.com.devmedia.domain.PlayList;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PlayListDaoImpl implements PlayListDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(PlayList playList) {
        em.persist(playList);
    }

    @Override
    public List<PlayList> recuperar() {
        return em.createQuery("select p from PlayList p", PlayList.class).getResultList();
    }

    @Override
    public PlayList recuperarPorId(long id) {
        return em.find(PlayList.class, id);
    }

    @Override
    public void atualizar(PlayList playList) {
        em.merge(playList);
    }

    @Override
    public void excluir(long id) {
        em.remove(em.getReference(PlayList.class, id));
    }
}
