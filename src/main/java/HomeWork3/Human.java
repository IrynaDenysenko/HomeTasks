package HomeWork3;

import java.util.Objects;
import java.util.Scanner;

public abstract class Human {
    private boolean sex;
    private String firstname;
    private String lastname;
    private float height;
    private float weight;

    public boolean getSex() {
        return sex;
    }

    public String getName() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    protected void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    Human() {
    }

    Human(
            boolean sex,
            String firstname,
            String lastname,
            float height,
            float weight
    ) {
        this.sex = sex;
        this.firstname = firstname;
        this.lastname = lastname;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Human{" +
                "sex=" + sex +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return sex == human.sex && Float.compare(human.height, height) == 0 && Float.compare(human.weight, weight) == 0 && Objects.equals(firstname, human.firstname) && Objects.equals(lastname, human.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sex, firstname, lastname, height, weight);
    }

    public boolean speak(Human human) {
        boolean speak = true;
        if (this.sex == true && human.sex == true) {
            speak = Math.random() <= 0.5;
        }
        return speak;
    }
    public boolean tolerate(Human human) {
        boolean tolerate = false;
        if (this.sex == false && human.sex == false) {
            if (Math.random() < 0.05) {
                tolerate = true;
            } else {
                tolerate = false;
            }
        } else if (this.sex == true && human.sex == false) {
            if (Math.random() < 0.7) {
                tolerate = true;
            } else {
                tolerate = false;
            }
        } else if (this.sex == false && human.sex == true) {
            if (Math.random() < 0.7) {
                tolerate = true;
            } else {
                tolerate = false;
            }
        } else if (this.sex == true && human.sex == true) {
            if (Math.random() < 0.056) {
                tolerate = true;
            } else {
                tolerate = false;
            }
        }
        return tolerate;
    }

        public boolean timetogather (Human human){
            boolean timetogather = false;
            if (Math.abs(this.height - human.height)>((this.height + human.height)/2) * 0.1) {
                if (Math.random() < 0.85) {
                    timetogather = true;
                }
                else {
                    timetogather = false;
                }

            }
            else {
                if (Math.random() < 0.95) {
                    timetogather = true;
                }
                else {
                    timetogather = false;
                }

            }
            return timetogather;
        }

    public boolean timetogather2 (Human human){
        boolean timetogather = false;
        if (Math.abs(this.height / human.height - 1) > 0.1) {
            if (Math.random() < 0.85) {
                timetogather = true;
            }
            else {
                timetogather = false;
            }

        }
        else {
            if (Math.random() < 0.95) {
                timetogather = true;
            }
            else {
                timetogather = false;
            }

        }
        return timetogather;
    }

        public Human relationships (Human human, Scanner scanner){
            if (this.speak(human)
                    && this.tolerate(human)
                    && this.timetogather(human)
                    && this.getSex() != human.getSex()) {

                if(human.getSex() == false){
                    return ((Woman)human).givebirth((Man)this, scanner);
                }

                if(this.getSex() == false) {
                    return ((Woman)this).givebirth((Man)human, scanner);
                }
            }

            return null;
        }
    }
