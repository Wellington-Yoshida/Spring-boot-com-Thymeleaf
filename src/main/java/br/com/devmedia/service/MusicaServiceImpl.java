package br.com.devmedia.service;

import br.com.devmedia.dao.MusicaDao;
import br.com.devmedia.domain.Musica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MusicaServiceImpl implements MusicaService{

    @Autowired
    private MusicaDao musicaDao;

    @Autowired
    private PlayListService playListService;

    @Override
    public void salvar(Musica musica, long playListId) {
        musica.setPlayList(playListService.recuperarPorId(playListId));
        musicaDao.salvar(musica);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Musica> recuperarPorPlayList(long playListId) {
        return musicaDao.recuperarPorPlayList(playListId);
    }

    @Override
    @Transactional(readOnly = true)
    public Musica recuparPorPlayListIdEMusicaId(long musidaId, long playListId) {
        return musicaDao.recuparPorPlayListIdEMusicaId(musidaId, playListId);
    }

    @Override
    public void atualizar(Musica musica, long playListId) {
        musica.setPlayList(playListService.recuperarPorId(playListId));
        musicaDao.atualizar(musica);
    }

    @Override
    public void excluir(long id, long playListId) {
        musicaDao.excluir(recuparPorPlayListIdEMusicaId(id, playListId).getId());
    }
}
