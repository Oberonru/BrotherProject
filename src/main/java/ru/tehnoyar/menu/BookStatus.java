package main.java.ru.tehnoyar.menu;

public enum BookStatus {
    READ("ПРОЧИТАНА"),
    SCHEDULED("ЗАПЛАНИРОВАНА"),
    DEFFERED("ОТЛОЖЕНА");

    private String fieldDescription;

    BookStatus(String value) {
        this.fieldDescription = value;
    }
    public  String getFieldDescriptiopn() {
        return this.fieldDescription;
    }

    public static BookStatus parseStatus(int numStatus) throws Exception {

        if (numStatus == 1) {

            return BookStatus.READ;
        }
        if (numStatus == 2) {
            return BookStatus.SCHEDULED;
        }
        if (numStatus == 3) {
            return BookStatus.DEFFERED;
        }
        else  {
            throw new Exception("Нет такой позиции");
        }
    }



}
