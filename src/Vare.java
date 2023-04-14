import java.util.Objects;

public class Vare {
    private int varenr;
    private String varenavn;
    private int antal;

    // Bemærk at antal ikke er med i equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vare vare = (Vare) o;
        return getVarenr() == vare.getVarenr() && getVarenavn().equals(vare.getVarenavn());
    }

    // Bemlærk at antal ikke er med i udregningen af hashkoden.
    @Override
    public int hashCode() {
        return Objects.hash(getVarenr(), getVarenavn());
    }

    public Vare(int nr, String navn, int r) {
        varenr = nr;
        varenavn = navn;
        antal = r;
    }

    public String getVarenavn() {
        return varenavn;
    }

    public int getVarenr() {
        return varenr;
    }

    public void setNavn(String n) {
        varenavn = n;
    }

    public void setAntal(int n) {
        antal = n;
    }

}
