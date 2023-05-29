package kat.hamster;

import kat.hamster.csvHandler.CsvHandler;
import kat.hamster.util.HibernateUtil;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("You must specify data file name and serialize file name!");
            return;
        }

        final Session session = HibernateUtil.getSession();

        String sourceFile = args[0];
        var csvHandler = new CsvHandler(sourceFile);
        csvHandler.GetFigureFromCsvFile();

        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }

    }
}