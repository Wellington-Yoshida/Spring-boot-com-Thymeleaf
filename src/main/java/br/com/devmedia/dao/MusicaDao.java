package br.com.devmedia.dao;

import br.com.devmedia.domain.Musica;

import java.util.List;

public interface MusicaDao {

    void salvar(Musica musica);
    List<Musica> recuperarPorPlayList(long playListId);
    Musica recuparPorPlayListIdEMusicaId(long musidaId, long playListId);
    void atualizar(Musica musica);
    void excluir(long id);
}
