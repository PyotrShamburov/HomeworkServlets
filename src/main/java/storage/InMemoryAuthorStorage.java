package storage;

import model.Author;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InMemoryAuthorStorage {
    private static List<Author> writers = new ArrayList<>();
    private static InMemoryBookStorage inMemoryBookStorage = InMemoryBookStorage.getInstance();
    private static InMemoryAuthorStorage inMemoryAuthorStorage;
    private static int authorId = 6;


    public InMemoryAuthorStorage() {
    }

    static {
        Author authorOne = new Author(1, "George", "Orwell", "Родился в Мотихари (Индия) в семье британского торгового агента. " +
                "Закончил Итонский колледж в 1921 году. " +
                "До 1927 года служил в колониальной полиции в Бирме, затем долго жил в Великобритании и Европе, " +
                "пробавляясь случайными заработками, тогда же начал писать художественную прозу и публицистику.", "https://s4-people.ozstatic.by/200/677/902/902677_0.jpg");
        Author authorTwo = new Author(2, "Louisa", "May Alcott", "Луиза Олкотт (1832 -1888) – американская писательница. " +
                "Самым известным ее произведением стал роман «Маленькие женщины», основанный на ее воспоминаниях о том, как она и ее сестры взрослели. " +
                "Луиза Олкотт родилась в семье Амоса Бронсона Олкотта, известного писателя-трансценденталиста.", "https://s3-people.ozstatic.by/200/784/43/9/9043784_0.jpg");
        Author authorThree = new Author(3, "Erich", "Maria Remarque", "Родился в Оснабрюке, Германия. " +
                "В его метрике было записано \"Эрих Пауль Ремарк\"; второе имя \"Мария\" он взял себе позднее в память о матери. " +
                "В 1916 году добровольцем ушел на фронт, был серьезно ранен, долго пролежал в госпитале. " +
                "В 1928 году опубликовал знаменитый роман \"На Западном фронте без перемен\", мгновенно принесший ему популярность.", "https://s1-people.ozstatic.by/200/640/901/901640_0.jpg");
        Author authorFour = new Author(4,"John","Mars","Джон Маррс — британский писатель, в прошлом журналист. " +
                "В его биографии — сотрудничество с популярными изданиями " +
                "The Guardian’s Guide, Guardian Online, The Independent и 25 лет работы интервьюером со " +
                "знаменитостями кино, телевидения и музыки.","https://s2-people.ozstatic.by/200/452/139/90/90139452_0.jpg");
        Author authorFive = new Author(5,"Joanne","Kathleen Rowling","Известна также под псевдонимами Роберт Гэлбрейт, Ньют Скамандер, Кеннилуорти Уисп.\n" +
                "\n" +
                "Британская писательница, автор серии романов о Гарри Поттере. " +
                "Книги о Поттере получили несколько наград и были проданы в количестве более 400 " +
                "миллионов экземпляров. Они стали самой продаваемой серией книг в истории и основой для серии фильмов, " +
                "ставшей самой кассовой серией фильмов в истории.","https://s4-people.ozstatic.by/200/56/9/9056_0.jpg");
        writers.add(authorOne);
        writers.add(authorTwo);
        writers.add(authorThree);
        writers.add(authorFour);
        writers.add(authorFive);

    }

    public static InMemoryAuthorStorage getInstance() {
        if (inMemoryAuthorStorage == null) {
            inMemoryAuthorStorage = new InMemoryAuthorStorage();
            return inMemoryAuthorStorage;
        }
        return inMemoryAuthorStorage;
    }

    public Author getById(int id) {
        for (Author author : writers) {
            if (author.getId() == id) {
                return author;
            }
        }
        return null;
    }

    public void saveAuthor(Author author) {
        author.setId(authorId++);
        writers.add(author);
    }

    public void removeAuthor(int authorId) {
        writers.removeIf(author -> author.getId()==authorId);
    }
    public Author getByName(String firstName, String secondName){
        for (Author author: writers){
            if (author.getFirstName().equals(firstName) && author.getLastName().equals(secondName)){
                return author;
            }
        }
        return null;
    }

    public List<Author> getWriters() {
        return new ArrayList<>(writers);
    }
}

