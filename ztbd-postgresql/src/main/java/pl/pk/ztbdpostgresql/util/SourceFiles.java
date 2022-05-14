package pl.pk.ztbdpostgresql.util;

public enum SourceFiles {
    ADDRESS("./data/relacyjna-5k/adres-5000.csv"),
    ORDER("./data/relacyjna-5k/zlecenie-5000.csv"),
    PARCEL("./data/relacyjna-5k/przesylka-5000.csv"),
    PAYMENT("./data/relacyjna-5k/przesylka-5000.csv"),
    RECEIPT_ACK("./data/relacyjna-5k/potwierdzenie_odbioru-5000.csv"),
    SALES_DOCUMENT("./data/relacyjna-5k/faktura-5000.csv"),
    SUBJECT("./data/relacyjna-5k/podmiot-5000.csv");

    private final String filename;

    SourceFiles(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
