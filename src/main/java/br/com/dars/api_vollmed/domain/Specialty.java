package br.com.dars.api_vollmed.domain;

public enum Specialty {
    CARDIOLOGIA(1, "cardiologia"),
    DERMATOLOGIA(2, "dermatologia"),
    GINECOLOGIA(3, "ginecologia"),
    ORTOPEDIA(4, "ortopedia");

    private int code;
    private String description;

    Specialty(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static Specialty find(String specialtyString) {
        for (Specialty specialty : Specialty.values()) {
            if (specialty.description.equalsIgnoreCase(specialtyString)) {
                return specialty;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
