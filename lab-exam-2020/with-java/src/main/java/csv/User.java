package csv;

import com.opencsv.bean.CsvBindByName;

public class User {
    @CsvBindByName
    private String name;
    @CsvBindByName
    private String code;
    @CsvBindByName
    private String grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
