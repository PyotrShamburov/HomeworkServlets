package storage;

import model.Author;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAuthorStorage {
    private static List<Author> writers = new ArrayList<>();
    private static InMemoryBookStorage inMemoryBookStorage = new InMemoryBookStorage();


    public InMemoryAuthorStorage() {
    }
    static{
        Author authorOne = new Author(1,"George","Orwell","Родился в Мотихари (Индия) в семье британского торгового агента. " +
                "Закончил Итонский колледж в 1921 году. " +
                "До 1927 года служил в колониальной полиции в Бирме, затем долго жил в Великобритании и Европе, " +
                "пробавляясь случайными заработками, тогда же начал писать художественную прозу и публицистику.");
        authorOne.setBooks(inMemoryBookStorage.getById(5));
        authorOne.setBooks(inMemoryBookStorage.getById(6));
        Author authorTwo = new Author(2,"Louisa","May Alcott","Луиза Олкотт (1832 -1888) – американская писательница. " +
                "Самым известным ее произведением стал роман «Маленькие женщины», основанный на ее воспоминаниях о том, как она и ее сестры взрослели. " +
                "Луиза Олкотт родилась в семье Амоса Бронсона Олкотта, известного писателя-трансценденталиста.");
        authorTwo.setBooks(inMemoryBookStorage.getById(3));
        authorTwo.setBooks(inMemoryBookStorage.getById(4));
        Author authorThree = new Author(3,"Erich","Maria Remarque","Родился в Оснабрюке, Германия. " +
                "В его метрике было записано \"Эрих Пауль Ремарк\"; второе имя \"Мария\" он взял себе позднее в память о матери. " +
                "В 1916 году добровольцем ушел на фронт, был серьезно ранен, долго пролежал в госпитале. " +
                "В 1928 году опубликовал знаменитый роман \"На Западном фронте без перемен\", мгновенно принесший ему популярность.");
        authorThree.setBooks(inMemoryBookStorage.getById(1));
        authorThree.setBooks(inMemoryBookStorage.getById(2));
        writers.add(authorOne);
        writers.add(authorTwo);
        writers.add(authorThree);

    }

    public Author getById(int id){
        for (Author author: writers){
            if (author.getId() == id){
                return author;
            }
        }
        return null;
    }
}
