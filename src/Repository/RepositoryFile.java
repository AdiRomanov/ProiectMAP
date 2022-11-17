//package Repository;
//
//import Domain.Entity;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.List;
//
//public class RepositoryFile extends RepositoryInMemory{
//    private String fileName;
//
//
//    /**
//     * Constructor pentru Repo file.
//     */
//
//    public RepositoryFile(String fileName)  {
//        this.fileName = fileName;
//        loadData();
//
//    }
//
//    /**
//     * Citeste date din fisier si le incarca in UserRepo.
//     */
//    private void loadData() {
//        Path path = Paths.get(fileName);
//        try {
//            List<String> lines = Files.readAllLines(path);
//            for (String line : lines) {
//                String[] words = line.split(",");
//                Entity entity = new Entity();
//                super.add(entity);
//            }
//        } catch (IOException e) {
//            System.err.println("Eroare la citirea fișierului!");
//            e.printStackTrace();
//        }
//    }
//}
