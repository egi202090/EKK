package Helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBseed {
    private static DBseed ourInstance = new DBseed();

    public static DBseed getInstance() {
        return ourInstance;
    }


    private DBseed() {
    }

    public static void DBtables(){
        createTables();
        }

    private static void createTables(){
        String str1 = "Create Table if not exists Kategorie (" +
                "id int not null auto_increment primary key,"+
                "benutzerFK int not null,"+
                "kategorieName varchar(50),"+
                "kategorieFarbe int);";
        String str2 = "Create Table if not exists Benutzer (" +
                "id int not null auto_increment primary key, "+
                "benutzername varchar(50),"+
                "passwort varchar(50),"+
                "nachname varchar(50),"+
                "vorname varchar(50),"+
                "email varchar(50),"+
                "erstellDatum date)";
        String str3 = "Create Table if not exists Karte (" +
                "id int not null auto_increment primary key,"+
                "kategorieFK int not null,"+
                "frage varchar(50),"+
                "antwort varchar(50),"+
                "richtig enum('Ja','Nein'))";
        String str4 = " ALTER TABLE Kategorie" +
                "ADD FOREIGN KEY (benutzerFK) REFERENCES Benutzer(id)";

        String str5 ="ALTER TABLE Karte" +
                "ADD FOREIGN KEY (kategorieFK) REFERENCES Kategorie(id)";
        try{
            Statement stmt = DBconnection.getInstance().createStatement();
            stmt.execute(str1);
            stmt.execute(str2);
            stmt.execute(str3);
            stmt.execute(str4);
            stmt.execute(str5);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void fillTables(){
       // String

    }

}
