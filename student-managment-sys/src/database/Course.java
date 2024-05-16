package database;


public class Course {

    int id,creditHour, ects, score, year, semister;
    String courseName, grade;

    public Course(int id, String courseName, int creditHour, int ects, int score, String grade, int year, int semister) {

                this.id = id;
                this.courseName = courseName;
                this.creditHour = creditHour;
                this.ects = ects;
                this.score = score;
                this.grade = grade;
                this.year = year;
                this.semister = semister;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCreditHour(int creditHour) {
        this.creditHour = creditHour;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSemister(int semister) {
        this.semister = semister;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCreditHour() {
        return creditHour;
    }

    public int getEcts() {
        return ects;
    }

    public int getScore() {
        return score;
    }

    public String getGrade() {
        return grade;
    }

    public int getYear() {
        return year;
    }

    public int getSemester() {
        return semister;
    }


}
