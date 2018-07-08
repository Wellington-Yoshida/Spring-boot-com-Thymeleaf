package br.com.devmedia.dao;

import br.com.devmedia.domain.PlayList;

import java.util.List;

public interface PlayListDao {

    void salvar(PlayList playList);
    List<PlayList> recuperar();
    PlayList recuperarPorId(long id);
    void atualizar(PlayList playList);
    void excluir(long id);

}
