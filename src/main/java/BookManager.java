import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class BookManager {
    private List<Book> books = new ArrayList<>();

    public BookManager(){

    }

    public BookManager(List<Book> books) {
        this.books = books;
    }


    public List<Book> getBooks() {
        return books;
    }

    public List<Book> getBooks(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }
    public void addBook(Book book) {
        books.add(book);
    }

    public void printReportFromAuthor(String author) throws IOException {
        List<Book> booksByAuthor = getBooks(author);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(author + "_report.txt"))) {

            for (Book book : booksByAuthor) {
                writer.write(book.toString());
                writer.newLine();
            }
        }
    }

    public void saveBooksToJsonFile(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(filePath), books);
    }

    public void loadBooksFromJsonFile(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        books = mapper.readValue(new File(filePath), new TypeReference<List<Book>>() {});
    }

    public void saveBooksToBinaryFile(String filePath) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(books);
        }
    }

    public void loadBooksFromBinaryFile(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            books = (List<Book>) in.readObject();
        }
    }
}
