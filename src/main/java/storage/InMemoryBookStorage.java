package storage;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookStorage {
    private static List<Book> books = new ArrayList<>();
    private static InMemoryBookStorage inMemoryBookStorage;
    private static InMemoryAuthorStorage inMemoryAuthorStorage = InMemoryAuthorStorage.getInstance();
    private static int bookId = 9;

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
                9.31,"https://s4-goods.ozstatic.by/2000/666/625/10/10625666_0.jpg"));
        books.add(new Book(2,"Три товарища","Самый красивый в нашем столетии роман о любви..." +
                "Самый обаятельный в нашем столетии роман о дружбе. " +
                "Самый трагический и самый прелестный роман о человеческих отношениях за всю историю ХХ в.", inMemoryAuthorStorage.getById(3),
                2016,14.80,"https://s4-goods.ozstatic.by/2000/837/122/10/10122837_0.jpg"));
        inMemoryAuthorStorage.getById(3).setBooks(inMemoryBookStorage.getById(1));
        inMemoryAuthorStorage.getById(3).setBooks(inMemoryBookStorage.getById(2));
        books.add(new Book(3,"Маленькие женщины","«Маленькие женщины» американской писательницы Луизы Мэй Олкотт - трогательный роман о четырех дружных сестрах, " +
                "подрастающих в семействе Марч: романтичной Мег, озорной Джо, застенчивой Бесс и своенравной Эми.", inMemoryAuthorStorage.getById(2),
                2020,16.39,"https://s2-goods.ozstatic.by/2000/203/646/10/10646203_0.jpg"));
        books.add(new Book(4,"Хорошие жены","\"Хорошие жены\" - продолжение \"Маленьких женщин\", искреннего и трогательного романа о детстве и юности четырех сестер. " +
                "Маргарет, Джо, Бесс и Эми - такие разные, такие неповторимые. ", inMemoryAuthorStorage.getById(2),
                2019,8.61,"https://s3-goods.ozstatic.by/2000/484/872/10/10872484_0.jpg"));
        inMemoryAuthorStorage.getById(2).setBooks(inMemoryBookStorage.getById(3));
        inMemoryAuthorStorage.getById(2).setBooks(inMemoryBookStorage.getById(4));
        books.add(new Book(5,"1984. Скотный Двор","Своеобразный антипод второй великой антиутопии XX века - \"О дивный новый мир\" Олдоса Хаксли. Что, в сущности, страшнее:" +
                " доведенное до абсурда \"общество потребления\" - " +
                "или доведенное до абсолюта \"общество идеи\"?", inMemoryAuthorStorage.getById(1),2017,15.75,"https://s5-goods.ozstatic.by/2000/858/81/1/1081858_0.jpg"));
        books.add(new Book(6,"Памяти Каталонии","Перед вами - иной Оруэлл. Не писатель, а философ, литературный критик и журналист." +
                " Его публицистика стала образцом истинного искусства слова.", inMemoryAuthorStorage.getById(1),2017,
        8.66,"https://s2-goods.ozstatic.by/2000/12/952/10/10952012_0.jpg"));
        inMemoryAuthorStorage.getById(1).setBooks(inMemoryBookStorage.getById(5));
        inMemoryAuthorStorage.getById(1).setBooks(inMemoryBookStorage.getById(6));
        books.add(new Book(7,"Пассажиры","Загадочный хакер взломал системы управления восьми самоуправляемых машин, с недавних пор ставших нормой для всех жителей Великобритании. " +
                "Теперь он угрожает их пассажирам смертью. Среди его заложников - угасающая телезвезда; нелегальный иммигрант; молодая беременная женщина; муж и жена, едущие раздельно; " +
                "ветеран военного конфликта; желающий покончить с собой мужчина; жена, сбегающая от своего тирана-мужа. Встроенные камеры транслируют их панику миллионам зрителей по всему миру. " +
                "И теперь эти миллионы должны принять чью-то сторону. Потому что хакер уже открыл голосование:" +
                " \"Кто из них выживет в конце? И кто умрет первым?\".", inMemoryAuthorStorage.getById(4),2020,17.67,
                "https://s1-goods.ozstatic.by/2000/40/954/10/10954040_0.jpg"));
        inMemoryAuthorStorage.getById(4).setBooks(inMemoryBookStorage.getById(7));
        books.add(new Book(8,"Гарри Поттер и философский камень","Одиннадцатилетний мальчик-сирота Гарри Поттер живет в семье своей тетки и даже не подозревает, " +
                "что он - настоящий волшебник. Но однажды прилетает сова с письмом для него, и жизнь Гарри Поттера изменяется навсегда. Он узнает, что зачислен в Школу " +
                "Чародейства и Волшебства, выясняет правду о загадочной смерти своих родителей, а в " +
                "результате ему удается раскрыть секрет философского камня.", inMemoryAuthorStorage.getById(5),2016,
                26.18,"https://s1-goods.ozstatic.by/2000/490/102/102490_0.jpg"));
        inMemoryAuthorStorage.getById(5).setBooks(inMemoryBookStorage.getById(8));

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
    public void saveBook(Book book){
        book.setId(bookId++);
        books.add(book);
    }
    public void removeBook(int bookId){
        books.removeIf(book -> book.getId() == bookId);
    }
    public Book getByTitle(String title){
        for (Book book : books){
            if (book.getTitle().equals(title)){
                return book;
            }
        }
        return null;
    }
}
