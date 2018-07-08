package br.com.devmedia.service;

import br.com.devmedia.domain.Musica;

import java.util.List;

public interface MusicaService {

    void salvar(Musica musica, long playListId);
    List<Musica> recuperarPorPlayList(long playListId);
    Musica recuparPorPlayListIdEMusicaId(long musidaId, long playListId);
    void atualizar(Musica musica, long playListId);
    void excluir(long id, long playListId);

}
