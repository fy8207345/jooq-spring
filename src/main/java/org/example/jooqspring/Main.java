package org.example.jooqspring;

import org.example.jooqspring.db.tables.Author;
import org.example.jooqspring.db.tables.records.AuthorRecord;
import org.jooq.DSLContext;
import org.jooq.Record3;
import org.jooq.Result;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("org.example.jooqspring");
        applicationContext.refresh();
        applicationContext.start();
        Author author = Author.AUTHOR;
        DSLContext bean = applicationContext.getBean(DSLContext.class);
        Result<AuthorRecord> fetch1 = bean.selectFrom(author)
                .fetch();
        System.out.println(fetch1);
    }
}
