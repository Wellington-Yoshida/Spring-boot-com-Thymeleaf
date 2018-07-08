package br.com.devmedia.service;

import br.com.devmedia.dao.PlayListDao;
import br.com.devmedia.domain.PlayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class PlayListServiceImpl implements PlayListService{

    @Autowired
    private PlayListDao playListDao;

    @Override
    public void salvar(PlayList playList) {
        playListDao.salvar(playList);
    }

    @Override
    @Transactional(readOnly = true) //Transações apenas para leitura
    public List<PlayList> recuperar() {
        return playListDao.recuperar();
    }

    @Override
    @Transactional(readOnly = true) //Transações apenas para leitura
    public PlayList recuperarPorId(long id) {
        return playListDao.recuperarPorId(id);
    }

    @Override
    public void atualizar(PlayList playList) {
        playListDao.atualizar(playList);
    }

    @Override
    public void excluir(long id) {
        playListDao.excluir(id);
    }
}
