package kat.hamster.dao;

import kat.hamster.domain.Presentation;

public class PresentationDao extends BaseDaoImpl<Presentation, Integer> {

    public PresentationDao() {
        super(Presentation.class);
    }
}