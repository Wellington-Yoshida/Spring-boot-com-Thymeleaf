package br.com.devmedia.dao;

import br.com.devmedia.domain.Musica;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MusicaDaoImpl implements MusicaDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Musica musica) {
        em.persist(musica);
    }

    @Override
    public List<Musica> recuperarPorPlayList(long playListId) {
        return em.createQuery("select m from Musica m where m.playList.id = :playListId", Musica.class)
                .setParameter("playListId", playListId)
                .getResultList();
    }

    @Override
    public Musica recuparPorPlayListIdEMusicaId(long musidaId, long playListId) {
        return em.createQuery("select m from Musica m where m.playList.id = :playListId and m.id = :id", Musica.class)
                .setParameter("playListId", playListId)
                .setParameter("id", musidaId)
                .getSingleResult();
    }

    @Override
    public void atualizar(Musica musica) {
        em.merge(musica);
    }

    @Override
    public void excluir(long id) { em.remove(em.getReference(Musica.class, id)); }
}
