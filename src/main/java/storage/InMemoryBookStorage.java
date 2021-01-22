package storage;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookStorage {
    private static List<Book> books = new ArrayList<>();
    private static InMemoryBookStorage inMemoryBookStorage;
    private static InMemoryAuthorStorage inMemoryAuthorStorage = new InMemoryAuthorStorage();

    public InMemoryBookStorage() {
    }

    public static InMemoryBookStorage getInstance() {
        if (inMemoryBookStorage == null) {
            inMemoryBookStorage = new InMemoryBookStorage();
            return inMemoryBookStorage;
        }
        return inMemoryBookStorage;
    }

    static {
        books.add(new Book(1,"Триумфальная арка","\"Триумфальная арка\" - пронзительная история любви всему наперекор, " +
                "любви, приносящей боль, но и дарующей бесконечную радость.", inMemoryAuthorStorage.getById(3),2017,
                9.31));
        books.add(new Book(2,"Три товарища","Самый красивый в нашем столетии роман о любви..." +
                "Самый обаятельный в нашем столетии роман о дружбе. " +
                "Самый трагический и самый прелестный роман о человеческих отношениях за всю историю ХХ в.", inMemoryAuthorStorage.getById(3),
                2016,14.80));
        books.add(new Book(3,"Маленькие женщины","«Маленькие женщины» американской писательницы Луизы Мэй Олкотт - трогательный роман о четырех дружных сестрах, " +
                "подрастающих в семействе Марч: романтичной Мег, озорной Джо, застенчивой Бесс и своенравной Эми.", inMemoryAuthorStorage.getById(2),
                2020,16.39));
        books.add(new Book(4,"Хорошие жены","\"Хорошие жены\" - продолжение \"Маленьких женщин\", искреннего и трогательного романа о детстве и юности четырех сестер. " +
                "Маргарет, Джо, Бесс и Эми - такие разные, такие неповторимые. ", inMemoryAuthorStorage.getById(2),
                2019,8.61));
        books.add(new Book(5,"1984. Скотный Двор","Своеобразный антипод второй великой антиутопии XX века - \"О дивный новый мир\" Олдоса Хаксли. Что, в сущности, страшнее:" +
                " доведенное до абсурда \"общество потребления\" - " +
                "или доведенное до абсолюта \"общество идеи\"?", inMemoryAuthorStorage.getById(1),2017,15.75));
        books.add(new Book(6,"Памяти Каталонии","Перед вами - иной Оруэлл. Не писатель, а философ, литературный критик и журналист." +
                " Его публицистика стала образцом истинного искусства слова.", inMemoryAuthorStorage.getById(1),2017,
        8.66));

    }

    public List<Book> getAll() {
        return new ArrayList<>(books);
    }

    public Book getById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
